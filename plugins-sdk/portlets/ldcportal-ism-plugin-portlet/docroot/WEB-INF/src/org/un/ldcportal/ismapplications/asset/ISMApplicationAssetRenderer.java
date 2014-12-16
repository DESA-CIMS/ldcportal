/**
 * 
 * ISM Plugin Package
 * United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal 
 * 
 * ISM Application AssetRenderer class
 * 
 * @author Thibault Boyeux (thibault.boyeux@gmail.com), 2012
 *
 */


package org.un.ldcportal.ismapplications.asset;

import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.un.ldcportal.ismapplications.model.ISM;
import org.un.ldcportal.ismapplications.model.ISMApplication;
import org.un.ldcportal.ismapplications.service.ISMLocalServiceUtil;
import org.un.ldcportal.ismapplications.util.WebKeys;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portlet.asset.model.BaseAssetRenderer;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;

public class ISMApplicationAssetRenderer extends BaseAssetRenderer {

	public ISMApplicationAssetRenderer(ISMApplication ismApplication) {

		_ismApplication = ismApplication;
	}

	public long getClassPK() {

		return _ismApplication.getIsmApplicationId();
	}

	public long getGroupId() {

		return _ismApplication.getGroupId();
	}
	
	public String getSummary(Locale locale) {

		StringBuilder sb = new StringBuilder();
		
		sb.append("<b>");
		sb.append(LanguageUtil.get(locale, "application-reason"));
		sb.append(": </b>");		
		sb.append("<br />");
		sb.append(_ismApplication.getApplicationReason());
		
		sb.append("<br /><br />");
		
		sb.append("<b>");
		sb.append(LanguageUtil.get(locale, "application-additional"));
		sb.append("</b>");
		sb.append(": <br />");
		sb.append(_ismApplication.getApplicationAdditional());

		return sb.toString();
	}

	public String getTitle(Locale locale) {		
		ISM ism;
		String title="" ;
		try {
			ism = ISMLocalServiceUtil.getISM(_ismApplication.getIsmId());
			title = AssetEntryLocalServiceUtil.getAssetEntry(ism.getWebContentId()).getTitle(locale);
		}
		catch (PortalException e) {
			// TODO Auto-generated catch block
		}
		catch (SystemException e) {
			// TODO Auto-generated catch block
		}
		
		return title;

	}

	public long getUserId() {

		return _ismApplication.getUserId();
	}

	public String getUuid() {

		return _ismApplication.getUuid();
	}

	public String render(RenderRequest request, RenderResponse response, String template)
		throws Exception {

		if (template.equals(TEMPLATE_FULL_CONTENT)) {
			request.setAttribute(WebKeys.ISMAPPLICATION_ENTRY, _ismApplication);
			
			return "/html" + template + ".jsp";
		}
		else {
			return null;
		}
	}

	private ISMApplication _ismApplication;


}