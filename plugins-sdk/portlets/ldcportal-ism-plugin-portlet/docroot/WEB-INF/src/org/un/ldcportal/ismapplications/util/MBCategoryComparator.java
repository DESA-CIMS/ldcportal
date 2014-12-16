package org.un.ldcportal.ismapplications.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portlet.messageboards.model.MBCategory;

/**
 * 
 * ISM Plugin Package
 * United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal 
 * 
 * MBCategory Comparator by Category Name
 * 
 * @author Thibault Boyeux (thibault.boyeux@gmail.com), 2012
 *
 */

public class MBCategoryComparator extends OrderByComparator {

	public static final String ORDER_BY_ASC = "MBCategory.name ASC";

	public static final String ORDER_BY_DESC = "MBCategory.name DESC";

	public static final String[] ORDER_BY_FIELDS = {
		"name"
	};

	public MBCategoryComparator() {
		this(true);
	}

	public MBCategoryComparator(boolean ascending) {

		_ascending = ascending;
	}

	@Override
	public int compare(Object obj1, Object obj2) {

		MBCategory entry1 = (MBCategory) obj1;
		MBCategory entry2 = (MBCategory) obj2;

		int value = entry1.getName().compareToIgnoreCase(entry2.getName());

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
