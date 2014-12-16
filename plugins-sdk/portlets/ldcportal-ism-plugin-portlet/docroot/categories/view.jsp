<%--
/**
 *
 * ISM Plugin Categories Portlet
 * United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal 
 *
 * Main View page for the ISM Plugin Categories Portlet
 *
 * Displays ISM Categories associated to an ISM in a table
 *
 * @author Thibault Boyeux (thibault.boyeux@gmail.com), 2012
 *
 */
--%>

<%@include file="/categories/init.jsp"%>

<%	
	// Get ISM categories
	List<AssetCategory> assetCategories = assetEntry.getCategories();

	ArrayList<String> categoryDescriptionList = new ArrayList<String>();	
	
	for (AssetCategory assetCategory : assetCategories) {
		// Check that the category belongs to the ISM Vocabulary, that it does not have any Child Category
		// and that it is not a Root Category. As such, if "parent" categories were wrongly selected, they
		// are not displayed
		if (assetCategory.getVocabularyId() == ismVocabularyId &&
			AssetCategoryLocalServiceUtil.getChildCategories(assetCategory.getCategoryId()).isEmpty() &&
			!assetCategory.isRootCategory()) {
			
			// Get the category's Parent Category
			AssetCategory parentCategory =
				AssetCategoryLocalServiceUtil.getCategory(assetCategory.getParentCategoryId());
			String parentCategoryTitle = parentCategory.getTitle(locale);
			
			// Remove the delimiter (usually ">") and what's before from the Category name
			if (parentCategoryTitle.contains(delimiter)) {
				String[] splitTitle = StringUtil.split(parentCategoryTitle, delimiter);
				parentCategoryTitle = splitTitle[splitTitle.length - 1];
			}
			
			parentCategoryTitle = StringUtil.trim(parentCategoryTitle);
			
			// Build the HTML displayed for each category
			String categoryDescription = new String();
			categoryDescription += "<td class=\"description-parent-category\">";
			categoryDescription += parentCategoryTitle;
			categoryDescription += "</td>";
			categoryDescription += "<td class=\"description-category\">";
			categoryDescription += assetCategory.getTitle(locale);
			categoryDescription += "</td>";
			
			categoryDescriptionList.add(categoryDescription);
		}
	}
	
	Collections.sort(categoryDescriptionList);
%>

<table class="ism-category-description">
<% for (String categoryDescription : categoryDescriptionList) { %>
	<tr class="category-description"><%=categoryDescription %></tr>
<% } %>
</table>
