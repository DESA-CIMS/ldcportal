
package org.un.ldcportal.ismsearch.config;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portlet.PortletPreferencesFactoryUtil;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;

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
			//Store preferences
			String selectedCategoriesIds[] = ParamUtil.getParameterValues(actionRequest, "currentCategoriesId");
			String portletResource = ParamUtil.getString(actionRequest, "portletResource");
			PortletPreferences preferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest, portletResource);
			preferences.setValues("categoriesId", selectedCategoriesIds);
			for(int i=0;i<selectedCategoriesIds.length;i++)
			{
				String selectedCriteriasIds[] = ParamUtil.getParameterValues(actionRequest, "currentCriteriasId"+selectedCategoriesIds[i]);
				preferences.setValues("criteriasId"+selectedCategoriesIds[i],selectedCriteriasIds );
			}
			preferences.store();
			super.processAction(portletConfig, actionRequest, actionResponse);	
		}
	}
}
