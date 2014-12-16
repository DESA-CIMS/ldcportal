
package org.un.ldcportal.jargon.util;

import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.un.ldcportal.jargon.model.LDCJargon;

import com.liferay.portal.kernel.util.Validator;

/**
 * LDC Jargon Portlet United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal
 * 
 * @author Thibault Boyeux (thibault.boyeux@gmail.com), 2012
 */

public class LDCJargonValidator {

	/**
	 * Checks if a LDC Jargon is valid or not (basically that it is not empty in
	 * any of the languages)
	 * 
	 * @param ldcJargon
	 * @param errors
	 * @return
	 */

	public static boolean validateLDCJargon(LDCJargon ldcJargon, List<String> errors) {

		boolean valid = false;

		Map<Locale, String> nameMap = ldcJargon.getNameMap();
		Map<Locale, String> definitionMap = ldcJargon.getDefinitionMap();

		for (Map.Entry<Locale, String> name : nameMap.entrySet()) {
			if (!name.getValue().isEmpty() && !definitionMap.get(name.getKey()).isEmpty()) {
				valid = true;
			}
		}

		if (!valid) {
			errors.add("name-and-definition-required");
		}

		return valid;
	}
}
