
package org.un.ldcportal.ismapplications.portlet;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletPreferences;

import org.un.ldcportal.ismapplications.model.ISM;
import org.un.ldcportal.ismapplications.service.ISMLocalServiceUtil;
import org.un.ldcportal.ismapplications.util.ISMPluginUtil;
import org.un.ldcportal.ismapplications.util.WebKeys;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetCategoryServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * 
 * ISM Plugin Package - ISM Admin Portlet
 * United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal 
 * 
 * Main class for the ISM Admin Portlet
 * 
 * @author Thibault Boyeux (thibault.boyeux@gmail.com), 2012
 *
 */

public class ISMAdminPortlet extends MVCPortlet {
	
	/**
	 * Portlet Action used to edit configuration of the ISM Admin Portlet
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	public void editUserGroup(ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		if (!cmd.equals(Constants.UPDATE)) {
			return;
		}
		
		// Get param preferences
		String selectedUserGroup = ParamUtil.getString(actionRequest, "preferences--userGroupId--");
		String ismCategoryId = ParamUtil.getString(actionRequest, "preferences--ismCategoryId--");
		String moderatorGroupId =
			ParamUtil.getString(actionRequest, "preferences--moderatorGroupId--");
		String relatedAssetCategoryId =
			ParamUtil.getString(actionRequest, "preferences--relatedAssetCategoryId--");
		String ismVocabularyId =
						ParamUtil.getString(actionRequest, "preferences--ismVocabularyId--");

		// Get portlet preferences
		PortletPreferences preferences = actionRequest.getPreferences();

		preferences.setValue("userGroupId", selectedUserGroup);
		preferences.setValue("moderatorGroupId", moderatorGroupId);
		preferences.setValue("ismCategoryId", ismCategoryId);
		preferences.setValue("relatedAssetCategoryId", relatedAssetCategoryId);
		preferences.setValue("ismVocabularyId", ismVocabularyId);

		preferences.store();

		actionResponse.setRenderParameter("tabs1", "configuration");
		
		SessionMessages.add(actionRequest, "configuration-saved");
	}
	
	/**
	 * Portlet Action used to udpate ISM settngs : message board category and moderator ID
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void updateISM(ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		if (!cmd.equals(Constants.UPDATE)) {
			return;
		}

		long ismId = ParamUtil.getLong(actionRequest, "ismId");
		long mbCategoryId = ParamUtil.getLong(actionRequest, "mbCategoryId");
		long moderatorId = ParamUtil.getLong(actionRequest, "moderatorId");

		ISM ism = ISMLocalServiceUtil.getISM(ismId);
		ism.setMbCategoryId(mbCategoryId);
		ism.setModeratorId(moderatorId);
		ISMLocalServiceUtil.updateISM(ism);

		actionResponse.setRenderParameter("jspPage", "/admin/view.jsp");
	}
	
	/**
	 * Portlet Action used to refresh the displayed list of ISMs
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void refreshISMs(ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException {
				
		// Preferences
		PortletPreferences preferences = actionRequest.getPreferences();

		ThemeDisplay themeDisplay =
			(ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long ismCategoryId = GetterUtil.getLong(preferences.getValue("ismCategoryId", null));
		long groupId = themeDisplay.getScopeGroupId();
		long companyId = themeDisplay.getCompanyId();

		ISMPluginUtil.updateISMs(ismCategoryId, groupId, companyId);
		
		SessionMessages.add(actionRequest, "ism-list-updated");	
		
	}
	
}
