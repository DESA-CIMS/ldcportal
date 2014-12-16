
package org.un.ldcportal.ismsearch.util;

import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.util.OrderByComparator;

/**
 * 
 * ISM Search Portlet
 * United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal 
 * 
 * Comparator used to compare Document by Titles
 * 
 * @author Thibault Boyeux (thibault.boyeux@gmail.com), 2012
 *
 */

public class DocumentTitleComparator extends OrderByComparator {

	public static final String ORDER_BY_ASC = "AssetEntry.title ASC";

	public static final String ORDER_BY_DESC = "AssetEntry.title DESC";

	public static final String[] ORDER_BY_FIELDS = {
		"title"
	};

	public DocumentTitleComparator() {
		this(true);
	}

	public DocumentTitleComparator(boolean ascending) {

		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {

		Document entry1 = (Document) obj1;
		Document entry2 = (Document) obj2;

		int value = entry1.get(Field.TITLE).toLowerCase().compareTo(entry2.get(Field.TITLE).toLowerCase());

		if (_ascending) {
			return value;
		}
		else {
			return -value;
		}
	}

	@Override
	public String getOrderBy() {

		if (_ascending) {
			return ORDER_BY_ASC;
		}
		else {
			return ORDER_BY_DESC;
		}
	}

	@Override
	public String[] getOrderByFields() {

		return ORDER_BY_FIELDS;
	}

	@Override
	public boolean isAscending() {

		return _ascending;
	}

	private boolean _ascending;

}
