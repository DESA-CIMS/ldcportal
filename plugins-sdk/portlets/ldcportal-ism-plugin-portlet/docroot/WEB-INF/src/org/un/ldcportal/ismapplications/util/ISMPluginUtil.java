
package org.un.ldcportal.ismapplications.util;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.PortletPreferences;

import org.un.ldcportal.ismapplications.model.ISM;
import org.un.ldcportal.ismapplications.model.ISMApplication;
import org.un.ldcportal.ismapplications.service.ISMApplicationLocalServiceUtil;
import org.un.ldcportal.ismapplications.service.ISMLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowException;
import com.liferay.portal.kernel.workflow.WorkflowInstance;
import com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil;
import com.liferay.portal.model.Layout;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.GroupLocalServiceUtil;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.service.PortletPreferencesLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.asset.NoSuchEntryException;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.persistence.AssetEntryQuery;

/**
 * 
 * ISM Plugin Package
 * United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal 
 * 
 * @author Thibault Boyeux (thibault.boyeux@gmail.com), 2012
 *
 */

public class ISMPluginUtil {
	
	/**
	 * Builds ISM Application object from PortletRequset
	 * 
	 * @param request
	 * @return Built ISMApplication object
	 * @throws SystemException
	 */
	public static ISMApplication ismApplicationFromRequest(ActionRequest request)
		throws SystemException {

		long newISMApplicationId = CounterLocalServiceUtil.increment(ISMApplication.class.getName());

		ISMApplication ismApplication = ISMApplicationLocalServiceUtil.createISMApplication(newISMApplicationId);

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		ismApplication.setCompanyId(themeDisplay.getCompanyId());
		ismApplication.setGroupId(themeDisplay.getScopeGroupId());
		ismApplication.setUserId(themeDisplay.getUserId());
		ismApplication.setApplicationReason(ParamUtil.getString(request, "applicationReason"));
		ismApplication.setApplicationAdditional(ParamUtil.getString(request, "applicationAdditional"));
		ismApplication.setIsmId(ParamUtil.getLong(request, "ismKey"));

		return ismApplication;
	}
	
	/**
	 * Get preferences from ISM Plugin Admin Portlet
	 * 
	 * @param companyId
	 * @return ISM Plugin Admin Portlet's PortletPreferences
	 * @throws PortalException
	 * @throws SystemException
	 */
	public static PortletPreferences getAdminPreferences(long companyId)
		throws PortalException, SystemException {

		String adminPortletId = WebKeys.ISM_ADMIN_PORTLET_ID;

		long ownerId = PortletKeys.PREFS_OWNER_ID_DEFAULT;
		int ownerType = PortletKeys.PREFS_OWNER_TYPE_LAYOUT;

		long cpGroupId = GroupLocalServiceUtil.getGroup(companyId, "Control Panel").getGroupId();
		long cpPlid = LayoutLocalServiceUtil.getDefaultPlid(cpGroupId);

		return PortletPreferencesLocalServiceUtil.getPreferences(companyId, ownerId, ownerType, cpPlid, adminPortletId);
	}
	
	/**
	 * Updates ISMs in the database by going through all Web Content and checking whether or not
	 * they are categorized under the ISM-specific category.
	 * 
	 * Deletes ISM Web Content no longer existing and adds new ISM Web Content.
	 * 
	 * @param ismCategoryId
	 * @param groupId
	 * @param companyId
	 * @throws SystemException
	 * @throws PortalException
	 */
	public static void updateISMs(long ismCategoryId, long groupId, long companyId)
		throws SystemException, PortalException {

		// Get all scopes groupIds
		List<Layout> layoutList = LayoutLocalServiceUtil.getLayouts(groupId, false);
		long[] groupIds = new long[layoutList.size()];
		for (int i = 0; i < layoutList.size(); i++) {
			Layout curLayout = layoutList.get(i);
			if (curLayout.hasScopeGroup()) {
				groupIds[i] = curLayout.getScopeGroup().getGroupId();
			}
		}

		// Fetch web content as Assets
		AssetEntryQuery assetEntryQuery = new AssetEntryQuery();
		assetEntryQuery.setClassNameIds(new long[] {
			ClassNameLocalServiceUtil.getClassNameId("com.liferay.portlet.journal.model.JournalArticle")
		});
		assetEntryQuery.setAllCategoryIds(new long[] {
			ismCategoryId
		});
		assetEntryQuery.setExcludeZeroViewCount(false);
		assetEntryQuery.setGroupIds(groupIds);

		List<AssetEntry> results = AssetEntryLocalServiceUtil.getEntries(assetEntryQuery);

		// Add non-existing assets in the ISM database
		for (AssetEntry currentEntry : results) {
			if (Validator.isNull(ISMLocalServiceUtil.getISMByWebContentId(currentEntry.getEntryId())) && currentEntry.isVisible()) {

				long newIsmId = CounterLocalServiceUtil.increment(ISM.class.getName());

				// Define ism
				ISM ism = ISMLocalServiceUtil.createISM(newIsmId);
				ism.setGroupId(groupId);
				ism.setWebContentId(currentEntry.getEntryId());
				ism.setCompanyId(companyId);
				ISMLocalServiceUtil.addNewISM(ism);
			}
		}

		// Delete no-longer existing assets from the database
		List<ISM> allISMs = ISMLocalServiceUtil.getAllISMs(groupId);
		for (ISM currentISM : allISMs) {
			try {
				AssetEntry assetEntry = AssetEntryLocalServiceUtil.getAssetEntry(currentISM.getWebContentId());
				long[] assetCategoryIds = assetEntry.getCategoryIds();
				Arrays.sort(assetCategoryIds);
				if (Arrays.binarySearch(assetCategoryIds, ismCategoryId) < 0 || !assetEntry.isVisible()) {
					ISMLocalServiceUtil.deleteISM(currentISM.getPrimaryKey());
				}
			}
			catch (NoSuchEntryException e) {
				ISMLocalServiceUtil.deleteISM(currentISM.getPrimaryKey());
			}
		}
	}
	
	/**
	 * Checks whether a user has already applied to a specific ISM or not
	 * 
	 * @param companyId
	 * @param userId
	 * @param ismKey
	 * @return true if the user has already applied, else false
	 * @throws WorkflowException
	 */
	public static boolean userHasAlreadyAppliedToISM(long companyId, long userId, long ismKey)
		throws WorkflowException {

		boolean hasAlreadyApplied = false;

		// Checks whether the user has already applied for this ISM (open
		// workflow application, not completed)
		String[] assetTypes = {
			ISMApplication.class.getName()
		};
		int nbInstances = WorkflowInstanceManagerUtil.getWorkflowInstanceCount(companyId, userId, assetTypes, false);
		
		// Get all ISM Application workflow related to this user
		List<WorkflowInstance> instances =
			WorkflowInstanceManagerUtil.getWorkflowInstances(companyId, userId, assetTypes, false, 0, nbInstances, null);

		// Go through all workflow instances and check if any is related to the ISM we are looking for
		for (WorkflowInstance instance : instances) {
			Map<String, Serializable> workflowContext = instance.getWorkflowContext();
			ServiceContext serviceContext = (ServiceContext) workflowContext.get("serviceContext");
			Map<String, Serializable> instanceAttributes = serviceContext.getAttributes();
			long instanceISMKey = Long.valueOf((String) instanceAttributes.get("ismKey")).longValue();
			if (ismKey == instanceISMKey) {
				hasAlreadyApplied = true;
				break;
			}
		}

		return hasAlreadyApplied;
	}
}
