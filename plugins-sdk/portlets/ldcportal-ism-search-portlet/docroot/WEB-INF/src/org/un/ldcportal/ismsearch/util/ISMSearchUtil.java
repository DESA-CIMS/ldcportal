
package org.un.ldcportal.ismsearch.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.persistence.AssetEntryQuery;

/**
 * ISM Search Portlet United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal
 * 
 * @author Thibault Boyeux (thibault.boyeux@gmail.com), 2012
 */

public class ISMSearchUtil {

	/**
	 * Converts a String List to a long array
	 * 
	 * @param strings
	 * @return
	 */
	public static long[] convertStringsToLongs(List<String> strings) {

		long[] ret = new long[strings.size()];
		Iterator<String> iterator = strings.iterator();
		for (int i = 0; i < ret.length; i++) {
			ret[i] = Long.valueOf(iterator.next().toString());
		}

		return ret;
	}

	/**
	 * Converts a String array to a long array
	 * 
	 * @param strings
	 * @return
	 */
	public static long[] convertStringsToLongs(String[] strings) {

		long[] ret = new long[strings.length];
		for (int i = 0; i < ret.length; i++) {
			ret[i] = Long.valueOf(strings[i]);
		}

		return ret;
	}

	/**
	 * @param groupId
	 * @param categoryId
	 * @param masterCategoryId
	 * @return
	 * @throws Exception
	 */
	public static long[] getNonEmptyCategories(int ismCategoryId, List<AssetCategory> criterias)
		throws Exception {
		
		ArrayList<Long> nonEmptyCategories = new ArrayList<Long>();

		for (AssetCategory criteria : criterias) {
			long criteriaId = criteria.getCategoryId();
			
			AssetEntryQuery assetEntryQuery = new AssetEntryQuery();
			assetEntryQuery.setClassNameIds(new long[] {
				ClassNameLocalServiceUtil.getClassNameId("com.liferay.portlet.journal.model.JournalArticle")
			});
			assetEntryQuery.setAllCategoryIds(new long[] {
				Long.valueOf(criteriaId), ismCategoryId
			});
			assetEntryQuery.setExcludeZeroViewCount(false);
			
			if (AssetEntryLocalServiceUtil.getEntriesCount(assetEntryQuery) > 0) {
				nonEmptyCategories.add(Long.valueOf(criteriaId));
			}
		}		
		
		long[] nonEmptyCategoriesArray = new long[nonEmptyCategories.size()];
		
		for (int i = 0; i < nonEmptyCategories.size(); i++) {
			nonEmptyCategoriesArray[i] = nonEmptyCategories.get(i);
		}

		return nonEmptyCategoriesArray;
		
		//

		// // Get child categories of the master category
		// List<AssetCategory> childMasterCategories =
		// AssetCategoryLocalServiceUtil.getChildCategories(masterCategoryId);
		//
		// // Get all the assets associated with the child categories and put
		// all
		// // their categories (as a long[]) in the result List
		// for (AssetCategory childMasterCategory : childMasterCategories) {
		// HashSet<Long> nonEmptyCategories = new HashSet<Long>();
		//
		// // Get all assets associated with the childMasterCategory
		// AssetEntryQuery assetEntryQuery = new AssetEntryQuery();
		// assetEntryQuery.setClassNameIds(new long[] {
		// ClassNameLocalServiceUtil.getClassNameId("com.liferay.portlet.journal.model.JournalArticle")
		// });
		// assetEntryQuery.setAllCategoryIds(new long[] {
		// childMasterCategory.getCategoryId()
		// });
		// assetEntryQuery.setExcludeZeroViewCount(false);
		// assetEntryQuery.setGroupIds(new long[] {
		// groupId
		// });
		//
		// List<AssetEntry> assets =
		// AssetEntryLocalServiceUtil.getEntries(assetEntryQuery);
		//
		// // Go through all assets, fetch their respective categories, and add
		// // them to the HashSet (if they do not already exist) if their
		// // parent is the current categoryId
		// for (AssetEntry asset : assets) {
		// List<AssetCategory> assetCategories = asset.getCategories();
		// for (AssetCategory assetCategory : assetCategories) {
		// if (assetCategory.getParentCategoryId() == categoryId) {
		// nonEmptyCategories.add(new Long(assetCategory.getCategoryId()));
		//
		// }
		// }
		// }
		//
		// // Add to the result object
		// result.put(childMasterCategory.getCategoryId(), nonEmptyCategories);
		// }
        //
		// return result;
	}

	/**
	 * Checks if a category (criteriaId) is among the list of nonEmptyCategories
	 * If so, returns a specific CSS class
	 * 
	 * @param nonEmptyCategories
	 * @param criteriaId
	 * @return
	 */
	public static String getCriteriaCssClass(HashMap<Long, Set<Long>> nonEmptyCategories, long criteriaId) {

		// "non-empty" class: all subcategories of the category displayed as
		// "Only non Empty"
		// "nonEmptyCategoryxx class" : subcategories that indeed are non empty

		String result = "non-empty ";

		for (Map.Entry<Long, Set<Long>> entry : (Set<Map.Entry<Long, Set<Long>>>) nonEmptyCategories.entrySet()) {
			if (entry.getValue().contains(new Long(criteriaId))) {
				result += " nonEmptyCategory" + entry.getKey().toString();
			}
		}

		return result;
	}

	/**
	 * Returns true if every element of the contained array is present in the
	 * container array
	 * 
	 * @param contained
	 * @param container
	 * @return
	 */
	public static boolean arrayContainsAll(long[] contained, long[] container) {

		Arrays.sort(container);

		if (contained.length == 0) {
			return false;
		}

		boolean result = true;

		for (int i = 0; i < contained.length; i++) {
			if (Arrays.binarySearch(container, contained[i]) < 0) {
				result = false;
				break;
			}
		}
		return result;

	}
}
