
package org.un.ldcportal.ismapplications.portlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.un.ldcportal.ismapplications.model.ISMApplication;
import org.un.ldcportal.ismapplications.service.ISMApplicationLocalServiceUtil;
import org.un.ldcportal.ismapplications.util.ISMPluginUtil;
import org.un.ldcportal.ismapplications.util.ISMApplicationValidator;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * 
 * ISM Plugin Package - ISM Plugin Applications Portlet
 * United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal 
 * 
 * Main class for the ISM Applications Portlet
 * 
 * @author Thibault Boyeux (thibault.boyeux@gmail.com), 2012
 *
 */

public class ISMApplicationsPortlet extends MVCPortlet {
	
	/**
	 * Adds an ISM Application to the database and workflow engine
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void addApplication(ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException {

		PortletConfig portletConfig = this.getPortletConfig();
		String portletResource = ParamUtil.getString(actionRequest, "portletResource");
		long ismKey = ParamUtil.getLong(actionRequest, "ismKey");
		
		// Get application from the request
		ISMApplication ismApplication = ISMPluginUtil.ismApplicationFromRequest(actionRequest);

		ArrayList<String> errors = new ArrayList<String>();

		ServiceContext serviceContext = ServiceContextFactory.getInstance(ISMApplication.class.getName(), actionRequest);
		
		// Get application data : reason and additional info
		String applicationReason = ParamUtil.getString(actionRequest, "applicationReason");
		String applicationAdditional = ParamUtil.getString(actionRequest, "applicationAdditional");

		if (ISMApplicationValidator.validateISMApplication(ismApplication, errors)) {
			try {
				ISMApplicationLocalServiceUtil.addISMApplication(ismApplication, ismApplication.getUserId(), serviceContext);
				SessionMessages.add(actionRequest, "application-added");
				SUCCESS = true;
			}
			catch (SystemException e) {
				e.printStackTrace();
				errors.add("failed-to-register-application");
			}
			catch (PortalException e) {
				e.printStackTrace();
				errors.add("failed-to-register-application");
			}
		}

		for (String error : errors) {
			SessionErrors.add(actionRequest, error);
		}

		if (!errors.isEmpty()) {
			actionRequest.setAttribute("applicationReason", applicationReason);
			actionRequest.setAttribute("applicationAdditional", applicationAdditional);
		}
		
		actionRequest.setAttribute("success", SUCCESS);

		SessionMessages.add(
			actionRequest, portletConfig.getPortletName() + SessionMessages.KEY_SUFFIX_REFRESH_PORTLET, portletResource);

		actionResponse.setRenderParameter("jspPage", applyISMPage);
		actionResponse.setRenderParameter("ismKey", String.valueOf(ismKey));
	}
	

	public static final String applyISMPage = "/applications/apply_ism.jsp";

	public static boolean SUCCESS = false;
}
