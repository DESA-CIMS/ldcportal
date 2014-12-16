package org.un.ldcportal.jargon.portlet;

import java.util.ArrayList;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.un.ldcportal.jargon.model.LDCJargon;
import org.un.ldcportal.jargon.service.LDCJargonLocalServiceUtil;
import org.un.ldcportal.jargon.util.JargonWebKeys;
import org.un.ldcportal.jargon.util.LDCJargonUtil;
import org.un.ldcportal.jargon.util.LDCJargonValidator;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * 
 * LDC Jargon Portlet
 * United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal 
 * 
 * This is the main action class of the LDC Jargon Portlet.
 * 
 * @author Thibault Boyeux (thibault.boyeux@gmail.com), 2012
 *
 */

public class LDCJargonPortlet extends MVCPortlet {
	
	/**
	 * Action method called when reaching the edit/add LDC Jargon page
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void editLDCJargon(ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException {

		long ldcJargonKey = ParamUtil.getLong(actionRequest, "resourcePrimKey");

		if (Validator.isNotNull(ldcJargonKey)) {
			LDCJargon ldcJargon = LDCJargonLocalServiceUtil.getLDCJargon(ldcJargonKey);
			actionRequest.setAttribute(JargonWebKeys.LDC_JARGON, ldcJargon);
			actionResponse.setRenderParameter("jspPage", editJargonJSP);
		}
	}
	
	/**
	 * Action method called when adding/editing a new LDC Jargon
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws SystemException
	 */
	public void updateLDCJargon(ActionRequest actionRequest, ActionResponse actionResponse)
		throws SystemException {
		
		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		if (!cmd.equals(Constants.ADD) && !cmd.equals(Constants.UPDATE)) {
			return;
		}

		ArrayList<String> errors = new ArrayList<String>();

		LDCJargon ldcJargon = LDCJargonUtil.ldcJargonFromRequest(actionRequest);

		actionResponse.setRenderParameter("jspPage", editJargonJSP);

		if (LDCJargonValidator.validateLDCJargon(ldcJargon, errors)) {
			if (cmd.equals(Constants.ADD)) {
				try {
					LDCJargonLocalServiceUtil.addLDCJargon(ldcJargon);
					SessionMessages.add(actionRequest, "jargon-added");
					actionResponse.setRenderParameter("jspPage", "/view.jsp");
				}
				catch (SystemException e) {
					errors.add("failed-to-add-ldc-jargon");
				}
			}
			else if (cmd.equals(Constants.UPDATE)) {
				try {
					LDCJargonLocalServiceUtil.updateLDCJargon(ldcJargon);
					SessionMessages.add(actionRequest, "jargon-modified");
					actionResponse.setRenderParameter("jspPage", "/view.jsp");
				}
				catch (SystemException e) {
					errors.add("failed-to-update-ldc-jargon");
				}
			}
		}

		for (String error : errors) {
			SessionErrors.add(actionRequest, error);
		}
	}
	
	/**
	 * Action called when deleting an existing LDC Jargon
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws PortalException
	 * @throws SystemException
	 */
	public void deleteLDCJargon(ActionRequest actionRequest, ActionResponse actionResponse)
		throws PortalException, SystemException {

		long ldcJargonKey = ParamUtil.getLong(actionRequest, "resourcePrimKey");

		if (Validator.isNotNull(ldcJargonKey)) {
			LDCJargonLocalServiceUtil.deleteLDCJargon(ldcJargonKey);
			SessionMessages.add(actionRequest, "jargon-deleted");
		}
		else {
			SessionErrors.add(actionRequest, "error-deleting-jargon");
		}
	}

	protected String editJargonJSP = "/edit_jargon.jsp";

}
