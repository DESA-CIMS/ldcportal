package org.un.ldcportal.mbdisplay.util;

import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portlet.messageboards.model.MBCategory;

/**
 * Class used to order MBCategory objects by name, ignoring case
 * 
 * Message Boards Publisher portlet
 * United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal 
 * 
 * @author Thibault Boyeux
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
