<%--
/**
 *
 * ISM Search Portlet
 * United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal 
 *
 * Used for the configuration page of the ISM Search Portlet
 * 
 * @author Thibault Boyeux (thibault.boyeux@gmail.com), 2012
 *
 */
--%>

<%@include file="/init.jsp"%>




<%
	int nbAssetVocabularies = AssetVocabularyLocalServiceUtil.getAssetVocabulariesCount();
	List<AssetVocabulary> assetVocabularyList =
		AssetVocabularyLocalServiceUtil.getAssetVocabularies(0, nbAssetVocabularies);
%>

<liferay-portlet:actionURL portletConfiguration="true" var="configurationActionURL" />
<liferay-portlet:renderURL portletConfiguration="true" varImpl="configurationRenderURL" />

<aui:form action="<%= configurationActionURL.toString()%>" method="post" name="fm">
	<aui:input name="redirect" type="hidden" value="<%= configurationRenderURL.toString() %>" />
	<aui:input name="<%=Constants.CMD%>" value="<%=Constants.UPDATE%>" type="hidden" />

	<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>"
		id="ISMSearchCategorySettingsPanel" persistState="<%= true %>"
		title="vocabulary-and-category-selection">
		<aui:fieldset>

			<aui:select helpMessage="ism-category-id-help-message"
				name="preferences--ismCategoryId--" label="select-ism-category">
				<%
					List<AssetCategory> allCategories = AssetCategoryLocalServiceUtil.getCategories();
									for (AssetCategory currentCategory : allCategories) {
				%>
				<aui:option value="<%= currentCategory.getCategoryId() %>"
					selected="<%= currentCategory.getCategoryId() == ismCategoryId %>">
					<%=currentCategory.getTitle(locale)%>
				</aui:option>
				<%
					}
				%>
			</aui:select>


			<aui:select name="preferences--vocabularyId--" label="select-vocabulary-ism-criterias">
				<%
					for (AssetVocabulary currentVocabulary : assetVocabularyList) {
				%>
				<aui:option value="<%= currentVocabulary.getVocabularyId() %>"
					selected="<%= currentVocabulary.getVocabularyId() == vocabularyId %>">
					<%=currentVocabulary.getTitle(locale)%>
				</aui:option>
				<%
					}
				%>
			</aui:select>

			<%
				// If vocabulary has already been selected
							List<AssetCategory> availableCategories;
							if (vocabularyId != 0) {
								int nbCategories = AssetCategoryLocalServiceUtil.getVocabularyCategoriesCount(vocabularyId);
								availableCategories =
									AssetCategoryLocalServiceUtil.getVocabularyRootCategories(vocabularyId, 0, nbCategories, null);
			%>

			<aui:select name="preferences--masterCategoryId--" label="master-category">
				<%
					for (AssetCategory currentCategory : availableCategories) {
				%>
				<aui:option value="<%= currentCategory.getCategoryId() %>"
					selected="<%= currentCategory.getCategoryId() == masterCategoryId %>">
					<%=currentCategory.getTitle(locale)%>
				</aui:option>
				<%
					}
				%>
			</aui:select>



			<aui:input name="preferences--categoriesId--" type="hidden" />

			<%
				// Left list
								List<KeyValuePair> leftList = new ArrayList<KeyValuePair>();

								for (int i = 0; i < categoriesId.length; i++) {
									String categoryId = categoriesId[i];

									leftList.add(new KeyValuePair(categoryId, AssetCategoryLocalServiceUtil.getCategory(
										Integer.valueOf(categoryId)).getTitle(locale)));
								}

								// Right list
								List<KeyValuePair> rightList = new ArrayList<KeyValuePair>();
								String[] sortedCategoriesId = Arrays.copyOf(categoriesId, categoriesId.length);
								Arrays.sort(sortedCategoriesId);
								Iterator<AssetCategory> itr = availableCategories.iterator();

								while (itr.hasNext()) {
									AssetCategory category = itr.next();
									String categoryId = String.valueOf(category.getCategoryId());

									if (Arrays.binarySearch(sortedCategoriesId, categoryId) < 0) {
										rightList.add(new KeyValuePair(categoryId, category.getTitle(locale)));
									}
								}

								rightList = ListUtil.sort(rightList, new KeyValuePairComparator(false, true));
			%>

			<liferay-ui:input-move-boxes leftTitle="current" rightTitle="available"
				leftBoxName="currentCategoriesId" rightBoxName="availableCategoriesId"
				leftReorder="true" leftList="<%= leftList %>" rightList="<%= rightList %>" />
			<%
				}
			%>
		</aui:fieldset>

	</liferay-ui:panel>


	<aui:fieldset>
		<%
			for (int i = 0; i < categoriesId.length; i++) {
						long categoryId = Long.valueOf(categoriesId[i]);
						AssetCategory category = AssetCategoryLocalServiceUtil.getCategory(categoryId);

						// Get preferences
						String displayType = GetterUtil.getString(preferences.getValue("displayType" + categoryId, ""));

						int depth = GetterUtil.getInteger(preferences.getValue("depth" + categoryId, null), 1);

						boolean onlyNonEmpty =
							GetterUtil.getBoolean(preferences.getValue("onlyNonEmpty" + categoryId, null), false);

						int displayFor = GetterUtil.getInteger(preferences.getValue("displayFor" + categoryId, null));

						String[] criteriasId =
							StringUtil.split(preferences.getValue("criteriasId" + category.getCategoryId(), ""));

						// Define panel title
						String panelTitle =
							LanguageUtil.get(pageContext, "category") + " " + (i + 1) + ": " + category.getTitle(locale);
						if (masterCategoryId == categoryId) {
							panelTitle += " (" + LanguageUtil.get(pageContext, "master-category") + ")";
						}

						List<AssetCategory> availableCriterias = AssetCategoryLocalServiceUtil.getChildCategories(categoryId);

						// Left list
						List<KeyValuePair> leftList = new ArrayList<KeyValuePair>();

						for (int j = 0; j < criteriasId.length; j++) {
							String criteriaId = criteriasId[j];

							leftList.add(new KeyValuePair(criteriaId, AssetCategoryLocalServiceUtil.getCategory(
								Integer.valueOf(criteriaId)).getTitle(locale)));
						}

						// Right list
						List<KeyValuePair> rightList = new ArrayList<KeyValuePair>();
						Arrays.sort(criteriasId);
						Iterator<AssetCategory> itr = availableCriterias.iterator();

						while (itr.hasNext()) {
							AssetCategory criteria = itr.next();
							String criteriaId = String.valueOf(criteria.getCategoryId());

							if (Arrays.binarySearch(criteriasId, criteriaId) < 0) {
								rightList.add(new KeyValuePair(criteriaId, criteria.getTitle(locale)));
							}
						}

						rightList = ListUtil.sort(rightList, new KeyValuePairComparator(false, true));
		%>

		<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>"
			id='<%= "ISMSearchCategoryPreferencePanel" + String.valueOf(category.getCategoryId()) %>'
			persistState="<%= true %>" defaultState="closed" title='<%= panelTitle %>'>



			<aui:select name='<%= "preferences--displayType" + category.getCategoryId() + "--" %>'
				label="display-type">
				<aui:option label="checkbox" selected='<%= displayType.equals("checkbox") %>' />
				<aui:option label="dropdown-list"
					selected='<%= displayType.equals("dropdown-list") %>' />
				<aui:option label="new-window" selected='<%= displayType.equals("new-window") %>' />
			</aui:select>

			<c:if test="<%= categoryId != masterCategoryId %>">
				<aui:select name='<%= "preferences--displayFor" + category.getCategoryId() + "--" %>'
					label="display-for">
					<aui:option label="" selected='<%= displayFor == GetterUtil.DEFAULT_INTEGER %>' />
					<%
						for (AssetCategory currentCategory : masterChildCategories) {
					%>
					<aui:option value="<%= currentCategory.getCategoryId() %>"
						selected="<%= displayFor == currentCategory.getCategoryId() %>">
						<%=currentCategory.getTitle(locale)%>
					</aui:option>
					<%
						}
					%>
				</aui:select>
			</c:if>

			<aui:select name='<%= "preferences--depth" + category.getCategoryId() + "--" %>'
				label="depth">
				<aui:option label="1" selected="<%= depth == 1 %>" />
				<aui:option label="2" selected="<%= depth == 2 %>" />
			</aui:select>

			<aui:input helpMessage="non-empty-help-message"
				name='<%= "preferences--onlyNonEmpty" + category.getCategoryId() + "--" %>'
				type="checkbox" label="only-display-non-empty" checked="<%= onlyNonEmpty %>" />

			<aui:input name='<%= "preferences--criteriasId" + category.getCategoryId() + "--" %>'
				type="hidden" />

			<c:if test="<%= depth != 0 && onlyNonEmpty == false %>">
				<liferay-ui:input-move-boxes leftTitle="current" rightTitle="available"
					leftBoxName='<%= "currentCriteriasId" + categoriesId[i] %>'
					rightBoxName='<%= "availableCriteriasId" + categoriesId[i] %>' leftReorder="true"
					leftList="<%= leftList %>" rightList="<%= rightList %>" />
			</c:if>

		</liferay-ui:panel>

		<%
			}
		%>
	</aui:fieldset>




	<aui:button-row>
		<aui:button onClick='<%= renderResponse.getNamespace() + "onSubmit();" %>' type="submit" />
	</aui:button-row>
</aui:form>


<%-- Necessary sripts for the input-move-boxes liferay-ui taglib --%>
<aui:script>
Liferay.provide(
       window,
       '<portlet:namespace />onSubmit',
       function()  {	  
		    document.<portlet:namespace />fm.<portlet:namespace />categoriesId.value = 
		    	Liferay.Util.listSelect(document.<portlet:namespace />fm.<portlet:namespace />currentCategoriesId);	
		    	
		    	alert(document.<portlet:namespace />fm.<portlet:namespace />categoriesId.value);	    
		    <%
	for (String categoryId : categoriesId) {
%>	
		    document.<portlet:namespace />fm.<portlet:namespace />criteriasId<%=categoryId%>.value = 
		    	Liferay.Util.listSelect(document.<portlet:namespace />fm.<portlet:namespace />currentCriteriasId<%=categoryId%>);
		    	
		    	
	    	<%
	}
%>
			submitForm(document.<portlet:namespace />fm);
	},
	['liferay-util-list-fields']
);


</aui:script>
<%
//http://esango.un.org/ldcportal/combo/?browserId=other&minifierType=&languageId=en_US&b=6100&t=1353354803800&p=/ldcportal/html/js&m=/liferay/util_list_fields.js
%>