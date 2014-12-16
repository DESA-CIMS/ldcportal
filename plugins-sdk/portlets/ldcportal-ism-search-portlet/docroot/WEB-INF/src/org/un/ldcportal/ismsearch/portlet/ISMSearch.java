
package org.un.ldcportal.ismsearch.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.un.ldcportal.ismsearch.util.ISMSearchUtil;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * ISM Search Portlet United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal This is the main action class of the ISM Search
 * Portlet.
 * 
 * @author Thibault Boyeux (thibault.boyeux@gmail.com), 2012
 */

public class ISMSearch extends MVCPortlet {

	/**
	 * Used to search relevant ISM according to categories and keywords selected
	 * by the user Sends back to View keywords that were used as well as
	 * selected categories
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws Exception
	 */
	public void filterISM(ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		if (!cmd.equals(Constants.UPDATE)) {
			return;
		}

		// Get portlet preferences
		PortletPreferences preferences = actionRequest.getPreferences();

		String[] categoriesId = StringUtil.split(preferences.getValue("categoriesId", ""));

		ArrayList<String> strSelectedCategories = new ArrayList<String>();

		// Get all selected categories
		for (int i = 0; i < categoriesId.length; i++) {

			int categoryId = Integer.valueOf(categoriesId[i]);
			// Get preferences
			String displayType = preferences.getValue("displayType" + categoryId, ""); // Get
																					   // display
																					   // type

			boolean onlyNonEmpty = GetterUtil.getBoolean(preferences.getValue("onlyNonEmpty" + categoryId, null), false);
			int ismCategoryId = GetterUtil.getInteger((preferences.getValue("ismCategoryId", null)));

			String[] criteriasId;

			if (onlyNonEmpty) {
				List<AssetCategory> criterias = AssetCategoryLocalServiceUtil.getChildCategories(categoryId);
				
				long[] nonEmptyCriteriasId = ISMSearchUtil.getNonEmptyCategories(ismCategoryId, criterias);
				
				criteriasId = new String[nonEmptyCriteriasId.length];
				for (int j = 0; j < nonEmptyCriteriasId.length; j++) {
					criteriasId[j] = String.valueOf(nonEmptyCriteriasId[j]);
				}
			}
			else {
				criteriasId = StringUtil.split(preferences.getValue("criteriasId" + categoryId, "")); // Get
																									  // selected
																									  // criterias
			}

			// According to the display type, get the ID of the categories to
			// display
			if (displayType.equals("dropdown-list")) {
				// Check that the selection is not empty
				if (GetterUtil.getLong(actionRequest.getParameter("select" + categoryId)) != GetterUtil.DEFAULT_LONG) {
					// Add selected category
					strSelectedCategories.add(actionRequest.getParameter("select" + categoryId));
				}
			}
			else if (displayType.equals("new-window")) {
				List<String> strSelectedCategoriesNW = Arrays.asList(StringUtil.split(actionRequest.getParameter("nw" + categoryId)));

				actionRequest.setAttribute(
					"selectedCategoriesNW" + String.valueOf(categoryId), actionRequest.getParameter("nw" + categoryId));

				// Add selected categories
				strSelectedCategories.addAll(strSelectedCategoriesNW);
			}
			else if (displayType.equals("checkbox")) {
				for (int j = 0; j < criteriasId.length; j++) {
					if (actionRequest.getParameter("checkbox" + criteriasId[j]).equals("true")) {
						// Add selected category
						strSelectedCategories.add(criteriasId[j]);
					}
				}
			}
		}

		// Convert String ID list to long ID array
		long[] selectedCategories = ISMSearchUtil.convertStringsToLongs(strSelectedCategories);

		actionRequest.setAttribute("selectedCategories", selectedCategories);
		actionRequest.setAttribute("keywords", actionRequest.getParameter("keywords"));
		actionRequest.setAttribute(Constants.CMD, cmd);

	}

	/**
	 * Used to manage selection list in pop-up "New Window" mode (AJAX) Sends
	 * the ID of selected categories (in the pop-up) back to the main page
	 */
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws PortletException, IOException {

		resourceResponse.setContentType("text/javascript");

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		// Get categoryList
		String[] categoryList = StringUtil.split(resourceRequest.getParameter("strCategoryList"));

		ArrayList<String> selectedCategoryList = new ArrayList<String>();

		// Get checked categories only
		for (int i = 0; i < categoryList.length; i++) {
			if (resourceRequest.getParameter("category" + categoryList[i]).equals("true")) {
				selectedCategoryList.add(categoryList[i]);
			}
		}

		// Put selected categories and number of selected categories in the JSON
		// Object
		jsonObject.put("selectedCategories", StringUtil.merge(selectedCategoryList));
		jsonObject.put("nbCategories", selectedCategoryList.size());

		PrintWriter writer = resourceResponse.getWriter();
		writer.write(jsonObject.toString());

	}
}
