
package org.un.ldcportal.ismsearch.config;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;

/**
 * 
 * ISM Search Portlet
 * United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal 
 * 
 * This is the main configuraton class for the ISM Search Portlet
 * 
 * @author Thibault Boyeux (thibault.boyeux@gmail.com), 2012
 *
 */

public class ConfigurationActionImpl extends DefaultConfigurationAction {

	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		
		if (cmd.equals(Constants.UPDATE)) {
			// Store preferences
			super.processAction(portletConfig, actionRequest, actionResponse);	
		}
	}
}
