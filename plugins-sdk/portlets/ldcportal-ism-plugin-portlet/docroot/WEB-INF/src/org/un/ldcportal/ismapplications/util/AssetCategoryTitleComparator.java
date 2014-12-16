package org.un.ldcportal.ismapplications.util;

import java.util.Comparator;

import com.liferay.portlet.asset.model.AssetCategory;

/**
 * 
 * ISM Plugin Package
 * United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal 
 * 
 * Comparator for AssetCategory class based on Title
 * 
 * @author Thibault Boyeux (thibault.boyeux@gmail.com), 2012
 *
 */

public class AssetCategoryTitleComparator implements Comparator<AssetCategory> {

	@Override
	public int compare(AssetCategory category1, AssetCategory category2) {

		return category1.getTitle().compareToIgnoreCase(category2.getTitle());
	}

}
