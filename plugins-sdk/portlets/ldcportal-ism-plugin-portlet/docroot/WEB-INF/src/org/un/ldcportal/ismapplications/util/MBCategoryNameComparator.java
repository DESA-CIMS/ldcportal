package org.un.ldcportal.ismapplications.util;

import java.util.Comparator;

import com.liferay.portlet.messageboards.model.MBCategory;


public class MBCategoryNameComparator implements Comparator<MBCategory> {

	@Override
	public int compare(MBCategory mbCategory1, MBCategory mbCategory2) {

		return mbCategory1.getName().compareToIgnoreCase(mbCategory2.getName());
	}

}
