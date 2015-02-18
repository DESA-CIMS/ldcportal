<%--
/**
 *
 * ISM Search Portlet
 * United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal 
 *
 * Used for display the selection list pop-up in "New Window" mode
 * 
 * @author Thibault Boyeux (thibault.boyeux@gmail.com), 2012
 *
 */
--%>

<%@include file="/init.jsp"%>

<%
	// Depth represents the category "depth" to dislay: 1 is only the first level of categories,
	// 2 is the first level and their children categories
	int depth = Integer.valueOf(request.getParameter("depth"));
	int categoryId = Integer.valueOf(request.getParameter("categoryId"));	
	
	// Retrieve criteria list
	String[] criteriasId = preferences.getValues("criteriasId" + categoryId, emptyStringArray);

	ArrayList<String> categoryList = new ArrayList<String>();
	String strCategoryList = StringPool.BLANK;

	// Get categories the user has already selected, if any
	String[] strSelectedCategoriesNW = StringUtil.split(request.getParameter("selectedCategoriesNW"));
	long[] selectedCategoriesNW = ISMSearchUtil.convertStringsToLongs(strSelectedCategoriesNW);
%>


<aui:form name="fm_nw">
	<aui:fieldset id='fieldsetNWMain'>
	<%-- DEPTH == 1 --%>
		<%
			if (depth == 1) {
						// Select All / Unselect All boxes
						String selectAllString =
							renderResponse.getNamespace() + "checkAll('" + renderResponse.getNamespace() + "fieldsetNWMain')";
						String unselectAllString =
							renderResponse.getNamespace() + "uncheckAll('" + renderResponse.getNamespace() + "fieldsetNWMain')";
		%>

		<span class="selectAll"><a href="javascript:void(0)"
			onclick="<%=selectAllString%>"> <%=LanguageUtil.get(pageContext, "select-all")%>
		</a></span>
		<%=StringPool.DASH%>
		<span class="unselectAll"><a href="javascript:void(0)"
			onclick="<%=unselectAllString%>"> <%=LanguageUtil.get(pageContext, "unselect-all")%>
		</a></span>

		<%
			}
					//

					for (int i = 0; i < criteriasId.length; i++) {

						int criteriaId = Integer.valueOf(criteriasId[i]);
						// Retrieve category object
						AssetCategory category = AssetCategoryLocalServiceUtil.getCategory(criteriaId);

						if (depth == 1) {
							categoryList.add(String.valueOf(category.getCategoryId()));
							boolean checkboxValue = false;
							// Check if the category has already been selected
							if (Arrays.binarySearch(selectedCategoriesNW, category.getCategoryId()) >= 0) {
								checkboxValue = true;
							}
		%>

		<%-- Display category checkbox --%>
		<aui:input type="checkbox"
			name='<%= "category" + String.valueOf(category.getCategoryId()) %>'
			value="<%= checkboxValue %>" label="<%= category.getTitle(locale) %>" />
			
		<%-- DEPTH == 2 --%>	
		<%
			}
						else if (depth == 2) {
		%>

		<liferay-ui:panel collapsible="<%= true %>" extended="<%= false %>"
			id='ISMNewWindowSelect<%= category.getCategoryId() %>' persistState="<%= true %>"
			title='<%= category.getTitle(locale) %>'>

			<%
				// Select all, unselect all checkboxes
				String selectAllString =
										renderResponse.getNamespace() + "checkAll('" + renderResponse.getNamespace() + "fieldsetNW" +
											String.valueOf(category.getCategoryId()) + "')";
									String unselectAllString =
										renderResponse.getNamespace() + "uncheckAll('" + renderResponse.getNamespace() +
											"fieldsetNW" + String.valueOf(category.getCategoryId()) + "')";
			%>

			<span class="selectAll"><a href="javascript:void(0)"
				onclick="<%=selectAllString%>"> <%=LanguageUtil.get(pageContext, "select-all")%>
			</a></span>
			<%=StringPool.DASH%>
			<span class="unselectAll"><a href="javascript:void(0)"
				onclick="<%=unselectAllString%>"> <%=LanguageUtil.get(pageContext, "unselect-all")%>
			</a></span>

			<aui:fieldset id='<%= "fieldsetNW" + String.valueOf(category.getCategoryId()) %>'>

				<%
					List<AssetCategory> subChildCategories =
												AssetCategoryLocalServiceUtil.getChildCategories(category.getCategoryId());

											for (AssetCategory subCategory : subChildCategories) {
												categoryList.add(String.valueOf(subCategory.getCategoryId()));
												boolean checkboxValue = false;

												// Check if the category has already been selected
												if (Arrays.binarySearch(selectedCategoriesNW, subCategory.getCategoryId()) >= 0) {
													checkboxValue = true;
												}
				%>
				<aui:input type="checkbox"
					name='<%= "category" + String.valueOf(subCategory.getCategoryId()) %>'
					value="<%= checkboxValue %>" label="<%= subCategory.getTitle(locale) %>" />
				<%
					//
											}
				%>
			</aui:fieldset>
		</liferay-ui:panel>

		<%
			//
						}
		%>

		<%
			}
					strCategoryList = StringUtil.merge(categoryList);
		%>

		<aui:input type="hidden" name="strCategoryList" value="<%= strCategoryList %>" />
	</aui:fieldset>
</aui:form>
