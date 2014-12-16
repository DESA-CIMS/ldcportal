package org.un.ldcportal.mbdisplay.config;

import java.util.Arrays;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import javax.portlet.PortletConfig;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;

/**
 * This class is used as the action for the configuration page of the ISM
 * Message Boards Publisher Portlet. It simply calls the method of Liferay's
 * default configuration class
 * 
 * Message Boards Publisher portlet
 * United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal 
 * 
 * @author Thibault Boyeux
 */

public class ConfigurationActionImpl extends DefaultConfigurationAction {

	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);

		if (cmd.equals(Constants.UPDATE)) {
			updateDisplaySettings(actionRequest);
			// Store preferences
			super.processAction(portletConfig, actionRequest, actionResponse);
		}
		else {
			return;
		}

	}

	/**
	 * Incorporates Liferay's scope (Trade, Development Assistance and General
	 * Support in our case of the LDC Portal) data into the Action Request
	 * 
	 * @param actionRequest
	 * @throws Exception
	 */
	protected void updateDisplaySettings(ActionRequest actionRequest)
		throws Exception {

		String[] scopeIds = StringUtil.split(getParameter(actionRequest, "scopeIds"));
		setPreference(actionRequest, "scopeIds", scopeIds);
	}

}
