<%--
/**
 *
 * ISM Search Portlet
 * United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal 
 * 
 * @author Thibault Boyeux (thibault.boyeux@gmail.com), 2012
 *
 */
--%>


<%@include file="/init.jsp"%>


<portlet:actionURL name="filterISM" var="searchURL" />

<aui:form name="fm" action="<%= searchURL.toString() %>" method="post">

	<aui:input name="<%=Constants.CMD%>" value="<%=Constants.UPDATE%>" type="hidden" />

	<%
		// Get keywords input by users
			String keywords = (String) portletSession.getAttribute("keywords");
			if (keywords == null || keywords.isEmpty()) {
				keywords = StringPool.BLANK;
				// keywords = LanguageUtil.get(pageContext, "search-term");
			}

			String resetScript = renderResponse.getNamespace() + "resetAllNWText()";
	%>

	<div class="filter">
		<div class="filter-header">
			<span><liferay-ui:message key="filter" /></span>
		</div>
		<div class="filter-content">
			<aui:button-row>
				<aui:button type="submit" value="filter" />
				<aui:button type="reset" value="reset" onclick="<%= resetScript %>" />
			</aui:button-row>
			<aui:fieldset>
				<%
					//	For each main category, display it through dispaly_category_filter.jspf
					
							for (int i = 0; i < categoriesId.length; i++) {
								int categoryId = Integer.valueOf(categoriesId[i]);
								AssetCategory category = AssetCategoryLocalServiceUtil.getCategory(categoryId);

								// Get & set preferences
								String displayType = GetterUtil.getString(preferences.getValue("displayType" + categoryId, ""));

								int depth = GetterUtil.getInteger(preferences.getValue("depth" + categoryId, null), 1);

								boolean onlyNonEmpty =
									GetterUtil.getBoolean(preferences.getValue("onlyNonEmpty" + categoryId, null), false);

								int displayFor = GetterUtil.getInteger(preferences.getValue("displayFor" + categoryId, null));

								String[] criteriasId =preferences.getValues("criteriasId" + category.getCategoryId(), emptyStringArray);
								Arrays.sort(criteriasId);
				%>
				<%@include file="/display_category_filter.jspf"%>

				<%
					}
				%>
			</aui:fieldset>
		</div>
	</div>

	<div class="search-content">
		<div class="results-topper">
			<h1><%=LanguageUtil.get(pageContext, "find-support-measure")%></h1>
		</div>

		<div class="searchbox">
			<aui:fieldset>
				<aui:input name="keywords" value='<%= keywords %>' label="" />
			</aui:fieldset>
			<aui:button-row>
				<aui:button type="submit" value="search" />
			</aui:button-row>
		</div>



		<div class="results-content">
			<%
				String noResultsMessage =
						LanguageUtil.format(
							pageContext, "no-entries-were-found-that-matched-the-keywords-x", "<strong>" + HtmlUtil.escape(keywords) +
								"</strong>");
			%>
			<liferay-ui:search-container emptyResultsMessage="<%= noResultsMessage %>" delta="10">
				<liferay-ui:search-container-results>
					<%	
									// Fetch all the results
									//
									// Basically what we will do is first fetchc all Web Content with the selected keywords
									// and then logically check if its categories match the ones selected by the user in the right menu
									//
									// This is because Liferay does not allow searching for keywords AND categories in Web Content at
									// the same time
									
									Indexer indexer = IndexerRegistryUtil.getIndexer(JournalArticle.class);

									SearchContext searchContext = SearchContextFactory.getInstance(request);

									searchContext.setAssetCategoryIds(selectedCategories); // Somehow this does not work, must be a Liferay bug
									searchContext.setKeywords(keywords);

									// Get all subgroup ids for search								

									List<Layout> childLayouts = LayoutLocalServiceUtil.getLayouts(layout.getGroupId(), false);

									long groupIds[] = new long[childLayouts.size() + 1];
									groupIds[0] = scopeGroupId; // Add default group id

									// Search all subgroups
									for (int i = 0; i < childLayouts.size(); i++) {
										Layout curLayout = childLayouts.get(i);
										if (curLayout.hasScopeGroup()) {
											groupIds[i + 1] = curLayout.getScopeGroup().getGroupId();
										}
									}

									searchContext.setGroupIds(groupIds);
									// searchContext.setAndSearch(true);  //This bugs too

									// Get results
									ArrayList<Document> keywordsDocuments = (ArrayList<Document>) indexer.search(searchContext).toList();
									Collections.sort(keywordsDocuments, new DocumentTitleComparator());

									// St queryTerms
									pageContext.setAttribute("queryTerms", indexer.search(searchContext).getQueryTerms());

									for (int i = 0; i < keywordsDocuments.size(); i++) {
										Document document = keywordsDocuments.get(i);
										String className = document.get(Field.ENTRY_CLASS_NAME);
										long classPK = GetterUtil.getLong(document.get(Field.ENTRY_CLASS_PK));

										AssetEntry assetEntry;

										try {
											assetEntry = AssetEntryLocalServiceUtil.getEntry(className, classPK);

											if (ISMSearchUtil.arrayContainsAll(allSelectedCategories, assetEntry.getCategoryIds())) {
												if (total >= searchContainer.getStart() && total < searchContainer.getEnd()) {
													results.add(assetEntry);
												}
												total++;
											}
										}
										catch (NoSuchEntryException e) {

										}

									}

									//Collections.sort(results, new AssetEntryTitleComparator());

									pageContext.setAttribute("results", results);
									pageContext.setAttribute("total", total);
					%>
				</liferay-ui:search-container-results>

				<liferay-ui:search-container-row
					className="com.liferay.portlet.asset.model.AssetEntry" keyProperty="entryId"
					modelVar="assetEntry">

					<liferay-ui:search-container-column-text>
						<%
											// Get information to be displayed from the Web Content
											
											int abstractLength = 200;

											JournalArticle journalArticle =
												JournalArticleLocalServiceUtil.getLatestArticle(assetEntry.getClassPK());											

											JournalArticleDisplay articleDisplay =
												JournalArticleLocalServiceUtil.getArticleDisplay(
													journalArticle, null, null, locale.getLanguage(), 1, null, themeDisplay);

											AssetRendererFactory assetRendererFactory =
												AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(assetEntry.getClassName());

											AssetRenderer assetRenderer = assetRendererFactory.getAssetRenderer(assetEntry.getClassPK());

											// Define the title
											String entryTitle = assetRenderer.getTitle(locale);

											// Define the View URL
											String viewURL = null;
											viewURL = assetRenderer.getURLViewInContext(liferayPortletRequest, liferayPortletResponse, null);
											
											viewURL = HttpUtil.setParameter(viewURL, "redirect", currentURL);				
											
											if (assetRenderer.getGroupId() != scopeGroupId) {
												viewURL = HttpUtil.setParameter(viewURL, "groupId", String.valueOf(assetRenderer.getGroupId()));
											}

											// Define summary
											String entrySummary =
												StringUtil.shorten(HtmlUtil.stripHtml(articleDisplay.getContent()), abstractLength);

											// Get queryTerms
											String[] queryTerms = (String[]) pageContext.getAttribute("queryTerms");

											String rowText =
												"<div class=\"asset-title\">" + "<a href=\"" + viewURL + "\">" +
													StringUtil.highlight(HtmlUtil.escape(entryTitle), queryTerms) + "</div>" + "</a>";
											rowText +=
												"<div class=\"asset-summary\">" +
													StringUtil.highlight(HtmlUtil.escape(entrySummary), queryTerms) + "</div>";
						%>

						<%=rowText%>
					</liferay-ui:search-container-column-text>

				</liferay-ui:search-container-row>

				<liferay-ui:search-iterator />

			</liferay-ui:search-container>
		</div>
	</div>
</aui:form>

<aui:script>

	// Focus mouse on search field
	Liferay.Util.focusFormField(document.<portlet:namespace />fm.<portlet:namespace />keywords);
	
	// New Window mode pop-up script
	Liferay.provide(
		window,
		'<portlet:namespace />callPopup',
		function(renderURL, resourceURL, titleKey, categoryId) {
			var A = AUI();

			var	data = {
					<portlet:namespace />selectedCategoriesNW: document.getElementById("<portlet:namespace />nw" + categoryId).value
			};		

			var selectedCategories = document.getElementById("<portlet:namespace />nw" + categoryId).value;		
									
			var dialog = new A.Dialog(
				{
					align: Liferay.Util.Window.ALIGN_CENTER,  
				 	after: {
						render: function(event) {
							this.set('y', this.get('y') + 50);
						}
					},
					destroyOnClose: true,
					modal: true,
					title: titleKey,
					width: 600,
					buttons:[                    
			            {
			            	label: Liferay.Language.get('ok'),
			            	handler:function() {
			                	var cfg = {
                 					method: 'POST',
                     				dataType: 'json',
			                        form: {
			                            id: '<portlet:namespace />fm_nw'
			                        },
			                        on: {
			                            success: function(id, resp, args) {
			                                var instance = this;

											//JSON Data coming back from Server
											var message = instance.get('responseData');
			
											if (message) {
												document.getElementById("<portlet:namespace />nw" + categoryId).value
													=message.selectedCategories;
												document.getElementById("<portlet:namespace />numberSelectedNW" + categoryId).innerHTML
													=message.nbCategories + " <%=LanguageUtil.get(pageContext, "selected").toLowerCase()%>";
											}												
											
			                                dialog.close();
			                            },
			                        }
			                    };                   
                   				var	request=A.io.request(resourceURL, cfg);
			               	}
			            },
			            {
							handler:
								function() {
									this.close();
								},
								label:
									Liferay.Language.get('cancel')
								}
      					]
				}
			).render();
			dialog.plug(
				A.Plugin.IO,
				{
					data: data,
					uri:renderURL
				}
			);			
		},
		['aui-dialog', 'aui-io']
	);
	
	// Reset selected categories in New Window popups
	function <portlet:namespace />resetAllNWText() {
		var allNWCategoryIds = "<%=allNWCategoryIds%>".split(",")	
		
		for (var i = 0; i < allNWCategoryIds.length - 1; i++) {				
			document.getElementById("<portlet:namespace />nw" + allNWCategoryIds[i]).value
				="";
			document.getElementById("<portlet:namespace />numberSelectedNW" + allNWCategoryIds[i]).innerHTML
				="0 <%=LanguageUtil.get(pageContext, "selected").toLowerCase()%>";
		}
	
	}

	// Check all checkboxes from a container
	function <portlet:namespace />checkAll (containerId) {
		var inputs= document.getElementById(containerId).getElementsByTagName("input");	

		for (var i =0; i < inputs.length; i++) 
		{
			if (inputs[i].type == "checkbox") {
				inputs[i].checked = true;
			}
			else if (inputs[i].type == "hidden") {
				inputs[i].value= "true";
			}
		}
	}
	
	// Uncheck all checkboxes from a container
	function <portlet:namespace />uncheckAll (containerId) {
		var inputs= document.getElementById(containerId).getElementsByTagName("input");	

		for (var i =0; i < inputs.length; i++) 
		{
			if (inputs[i].type == "checkbox") {
				inputs[i].checked = false;
			}
			else if (inputs[i].type == "hidden") {
				inputs[i].value= "false";
			}
		}
	}
	
	// Get DOM elements by Class name
	function <portlet:namespace />getElementsByClassName(node, classname) {
	    var a = [];
	    var re = new RegExp('(^| )'+classname+'( |$)');
	    var els = node.getElementsByTagName("*");
	   	for(var i=0,j=els.length; i < j; i++)
       	 	if(re.test(els[i].className))a.push(els[i]);
	    return a;
	}
	
	// Used to display and hide categories according to the masterCategory subcategories
	function <portlet:namespace />displayPanels ()  {
	
		<portlet:namespace />resetAllNWText();
		
		var categoryId = $('select#<portlet:namespace />select<%=masterCategoryId%>').val();		
		
		var hidePanels = $('div.no-display:not(div.masterCategory' + categoryId + ')')
		
		// Hide and show panels
		$('div.no-display:not(div.masterCategory' + categoryId + ') input:checkbox').removeAttr("checked");
		$('div.no-display:not(div.masterCategory' + categoryId + ') option:selected').removeAttr("selected");
		$(hidePanels).slideUp();
		
		$('div.masterCategory' + categoryId).slideDown();	
		
		// Hide and show checkboxes and options for nonEmptyCategories display
		if (categoryId != 0) {
			$('span.non-empty:not(span.nonEmptyCategory' + categoryId + ')').hide();
			$('span.nonEmptyCategory' + categoryId).show();
		}
		else {
			$('span.non-empty').show();
		}		
		

	}
	
	// On load : display master category and, for categories selected as "Only Non Empty", display only the non-empty ones
	$(window).load(function() {
		var categoryId = $('select#<portlet:namespace />select<%=masterCategoryId%>').val();
		
		if (categoryId != 0) {
			$('div.masterCategory' + categoryId).show();
			$('span.non-empty:not(span.nonEmptyCategory' + categoryId + ')').hide();
		}
	});
	
	
		
</aui:script>