package org.un.ldcportal.jargon.util;

import java.util.Comparator;

import org.un.ldcportal.jargon.model.LDCJargon;

/**
 * 
 * LDC Jargon Portlet
 * United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal 
 * 
 * Comparator used to order LDC Jargon by name, ignoring case
 * 
 * @author Thibault Boyeux (thibault.boyeux@gmail.com), 2012
 *
 */

public class LDCJargonComparator implements Comparator<LDCJargon> {
	@Override
	public int compare(LDCJargon jarg1, LDCJargon jarg2) {

		if (jarg1.getName().compareToIgnoreCase(jarg2.getName()) > 0) {
			return 1;
		}
		else if (jarg1.getName().compareToIgnoreCase(jarg2.getName()) < 0) {
			return -1;
		}
		else {
			return 0;
		}
		

	}
}
