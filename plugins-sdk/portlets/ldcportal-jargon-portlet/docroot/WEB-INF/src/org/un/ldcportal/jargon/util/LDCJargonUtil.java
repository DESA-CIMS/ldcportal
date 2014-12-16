
package org.un.ldcportal.jargon.util;

import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;

import org.un.ldcportal.jargon.model.LDCJargon;
import org.un.ldcportal.jargon.model.impl.LDCJargonImpl;

import com.liferay.portal.kernel.util.LocalizationUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

/**
 * 
 * LDC Jargon Portlet
 * United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal 
 * 
 * @author Thibault Boyeux (thibault.boyeux@gmail.com), 2012
 *
 */

public class LDCJargonUtil {
	
	/**
	 * Creates a LDC Jargon object from the Action Request
	 * 
	 * @param actionRequest
	 * @return
	 */
	public static LDCJargon ldcJargonFromRequest(ActionRequest actionRequest) {

		LDCJargon ldcJargon = new LDCJargonImpl();

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		Map<Locale, String> nameMap = LocalizationUtil.getLocalizationMap(actionRequest, "name");

		Map<Locale, String> definitionMap = LocalizationUtil.getLocalizationMap(actionRequest, "definition");

		ldcJargon.setLdcJargonId(ParamUtil.getLong(actionRequest, "ldcJargonId"));
		ldcJargon.setCompanyId(themeDisplay.getCompanyId());
		ldcJargon.setGroupId(themeDisplay.getScopeGroupId());
		ldcJargon.setNameMap(nameMap);
		ldcJargon.setDefinitionMap(definitionMap);

		return ldcJargon;
	}

	
}
