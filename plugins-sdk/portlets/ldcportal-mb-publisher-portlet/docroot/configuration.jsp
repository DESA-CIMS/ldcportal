<%--
/**
 *
 * Message Boards Publisher portlet
 * United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal 
 * 
 * @author Thibault Boyeux (thibault.boyeux@gmail.com), 2012
 *
 * Used for configuration of the portlet.
 *
 */
--%>


<%@include file="/init.jsp"%>

<%
	String redirect = ParamUtil.getString(request, "redirect");

	boolean displayAllMessages = false;

	// Display all messages only if the portlet is set to display all messages or to listen
	// for an ISM
	if (displayMessages.equals("all-boards-messages") || displayMessages.equals("listen-for-ism")) {
		displayAllMessages = true;
	}

	Group scopeGroup = themeDisplay.getScopeGroup();
%>

<liferay-portlet:actionURL portletConfiguration="true"
	var="configurationActionURL" />
<liferay-portlet:renderURL portletConfiguration="true"
	varImpl="configurationRenderURL" />

<aui:form action="<%= configurationActionURL.toString()%>" method="post"
	name="fm">
	<aui:input name="redirect" type="hidden"
		value="<%= configurationRenderURL.toString() %>" />
	<aui:input name="<%=Constants.CMD%>" value="<%=Constants.UPDATE%>"
		type="hidden" />

	<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>"
		id="messageBoardsDisplaySelectionMessageSettingsPanel"
		persistState="<%= true %>" title="message-settings">


		<aui:fieldset label="scope">

			<%
				// Get Liferay Scopes
							Set<Group> groups = new HashSet<Group>();

							groups.add(company.getGroup());
							groups.add(scopeGroup);

							for (Layout curLayout : LayoutLocalServiceUtil.getLayouts(layout.getGroupId(), layout.isPrivateLayout())) {
								if (curLayout.hasScopeGroup()) {
									groups.add(curLayout.getScopeGroup());
								}
							}

							// Scopes Left list

							List<KeyValuePair> scopesLeftList = new ArrayList<KeyValuePair>();

							for (long groupId : groupIds) {

								Group group = GroupLocalServiceUtil.getGroup(groupId);

								scopesLeftList.add(new KeyValuePair(_getKey(group), _getName(group, locale)));
							}

							// Scopes Right list

							List<KeyValuePair> scopesRightList = new ArrayList<KeyValuePair>();

							Arrays.sort(groupIds);
			%>

			<aui:select label="" name="preferences--defaultScope--">
				<aui:option
					label='<%= LanguageUtil.get(pageContext,"select-more-than-one") + "..." %>'
					selected="<%= groupIds.length > 1 %>" value="<%= false %>" />

				<optgroup label="<liferay-ui:message key="scopes" />">

					<%
						for (Group group : groups) {
											if (Arrays.binarySearch(groupIds, group.getGroupId()) < 0) {
												scopesRightList.add(new KeyValuePair(_getKey(group), _getName(group, locale)));
											}
					%>

					<aui:option label="<%= _getName(group, locale) %>"
						selected="<%= (groupIds.length == 1) && (group.getGroupId() == groupIds[0]) %>"
						value="<%= group.getGroupId() %>" />

					<%
						}
					%>

				</optgroup>
			</aui:select>

			<aui:input name="preferences--scopeIds--" type="hidden" />

			<%
				scopesRightList = ListUtil.sort(scopesRightList, new KeyValuePairComparator(false, true));
			%>

			<div class="<%=defaultScope ? "aui-helper-hidden" : ""%>"
				id="<portlet:namespace />scopesBoxes">
				<liferay-ui:input-move-boxes leftTitle="selected"
					rightTitle="available" leftBoxName="currentScopeIds"
					rightBoxName="availableScopeIds" leftReorder="true"
					leftList="<%= scopesLeftList %>" rightList="<%= scopesRightList %>" />
			</div>
		</aui:fieldset>

		<aui:fieldset>
			<aui:select name="preferences--displayMessages--"
				onChange='<%= renderResponse.getNamespace() + "disableCategory(this.value);" %>'>
				<aui:option label="all-boards-messages"
					selected='<%= displayMessages.equals("all-boards-messages") %>' />
				<aui:option label="category-messages-only"
					selected='<%= displayMessages.equals("category-messages-only") %>' />
				<aui:option label="categories-and-subcategories-messages"
					selected='<%= displayMessages.equals("categories-and-subcategories-messages") %>' />
				<aui:option label="listen-for-ism"
					selected='<%= displayMessages.equals("listen-for-ism") %>' />
			</aui:select>

			<%-- Select categories --%>
			<aui:select label="category-displayed" name="preferences--category--"
				cssClass='<%= displayAllMessages ? "no-display" : "" %>'>
				<%
					//
									DynamicQuery dynamicQuery =
										DynamicQueryFactoryUtil.forClass(MBCategory.class, classLoader).add(
											PropertyFactoryUtil.forName("groupId").in(groupIdsList)).add(
											PropertyFactoryUtil.forName("companyId").eq(new Long(company.getCompanyId()))).addOrder(
											OrderFactoryUtil.asc("name"));

									List<MBCategory> categoryList =
										new ArrayList<MBCategory>((List<MBCategory>) MBCategoryLocalServiceUtil.dynamicQuery(dynamicQuery));

									Collections.sort(categoryList, new MBCategoryComparator());

									for (MBCategory currentCategory : categoryList) {
				%>
				<aui:option value="<%= currentCategory.getCategoryId() %>"
					selected="<%= currentCategory.getCategoryId() == categoryId  %>">
					<%=currentCategory.getName()%>
				</aui:option>
				<%
					}
				%>
			</aui:select>
		</aui:fieldset>
	</liferay-ui:panel>

	<liferay-ui:panel collapsible="<%= true %>" extended="<%= true %>"
		id="messageBoardsDisplaySelectionDisplaySettingsPanel"
		persistState="<%= true %>" title="display-settings">

		<aui:fieldset cssClass="general-display-settings">
			<aui:select name="preferences--displayStyle--">
				<%
					for (String curDisplayStyle : MBDisplayKeys.MB_PUBLISHER_DISPLAY_STYLES) {
				%>

				<aui:option label="<%= curDisplayStyle %>"
					selected="<%= displayStyle.equals(curDisplayStyle) %>" />

				<%
					}
				%>
			</aui:select>

			<%-- Select abstract length --%>
			<aui:select cssClass="hidden-field abstract-length"
				helpMessage="abstract-length-key-help"
				name="preferences--abstractLength--">
				<aui:option label="100" selected="<%= abstractLength == 100%>" />
				<aui:option label="200" selected="<%= abstractLength == 200%>" />
				<aui:option label="300" selected="<%= abstractLength == 300%>" />
				<aui:option label="400" selected="<%= abstractLength == 400%>" />
				<aui:option label="500" selected="<%= abstractLength == 500%>" />
			</aui:select>

			<%-- Select number of items to display --%>
			<aui:select label="maximum-items-to-display"
				name="preferences--delta--">
				<%
					int[] deltas = {
										1, 2, 3, 4, 5, 10, 15, 20, 25, 30, 40, 50, 60, 70, 80, 90, 100
									};

									for (int currentDelta : deltas) {
				%>

				<aui:option label="<%= currentDelta%>"
					selected="<%= (delta == currentDelta)%>" />

				<%
					}
				%>
			</aui:select>

			<aui:input name="preferences--readMoreLink--" type="checkbox"
				value="<%= readMoreLink %>" />

			<aui:select name="preferences--readMoreLinkType--">
				<aui:option label="maximize"
					selected='<%= readMoreLinkType.equals("maximize") %>' />
				<aui:option label="custom"
					selected='<%= readMoreLinkType.equals("custom") %>' />
			</aui:select>

			<aui:select label="maximum-items-to-display-when-maximized"
				name="preferences--deltaMaximized--">

				<%
					int[] deltas = {
										1, 2, 3, 4, 5, 10, 15, 20, 25, 30, 40, 50, 60, 70, 80, 90, 100
									};

									for (int currentDelta : deltas) {
				%>

				<aui:option label="<%= currentDelta %>"
					selected="<%= (deltaMaximized == currentDelta) %>" />

				<%
					}
				%>
			</aui:select>

			<aui:input name="preferences--readMoreCustomURL--" type="text"
				value="<%= readMoreCustomURL %>" />

			<aui:select name="preferences--paginationType--">
				<aui:option label="none"
					selected='<%= paginationType.equals("none") %>' />
				<aui:option label="simple"
					selected='<%= paginationType.equals("simple") %>' />
				<aui:option label="regular"
					selected='<%= paginationType.equals("regular") %>' />
			</aui:select>

		</aui:fieldset>

	</liferay-ui:panel>

	<aui:button-row>
		<aui:button type="submit"
			onClick='<%= renderResponse.getNamespace() + "onSubmit();" %>' />
	</aui:button-row>
</aui:form>


<aui:script>
Liferay.provide(
       window,
       '<portlet:namespace />onSubmit',
       function()  {	        		
       				    	
		   	if (document.<portlet:namespace />fm.<portlet:namespace />scopeIds) {		   	
				document.<portlet:namespace />fm.<portlet:namespace />scopeIds.value = Liferay.Util.listSelect(document.<portlet:namespace />fm.<portlet:namespace />currentScopeIds);
			}				   	    	
			
			submitForm(document.<portlet:namespace />fm);
	},
	['liferay-util-list-fields']
);


function <portlet:namespace />disableCategory(curValue) {
	if (curValue == "all-boards-messages" || curValue == "listen-for-ism") {
		document.<portlet:namespace />fm.<portlet:namespace />category.disabled=true;
		document.<portlet:namespace />fm.<portlet:namespace />category.parentNode.parentNode.parentNode.style.display='none';
		}
	else {
		document.<portlet:namespace />fm.<portlet:namespace />category.disabled=false;
		document.<portlet:namespace />fm.<portlet:namespace />category.parentNode.parentNode.parentNode.style.display='block';
	}
}

Liferay.Util.toggleSelectBox('<portlet:namespace />defaultScope','false','<portlet:namespace />scopesBoxes');

</aui:script>

<%!private String _getKey(Group group)
		throws Exception {

		String key = null;

		if (group.isLayout()) {
			Layout layout = LayoutLocalServiceUtil.getLayout(group.getClassPK());

			key = "Layout" + StringPool.UNDERLINE + layout.getLayoutId();
		}
		else if (group.isLayoutPrototype()) {
			key = "Group" + StringPool.UNDERLINE + GroupConstants.DEFAULT;
		}
		else {
			key = "Group" + StringPool.UNDERLINE + group.getGroupId();
		}

		return key;
	}

	private String _getName(Group group, Locale locale)
		throws Exception {

		String name = null;

		if (group.isLayoutPrototype()) {
			name = LanguageUtil.get(locale, "default");
		}
		else {
			name = HtmlUtil.escape(group.getDescriptiveName(locale));
		}

		return name;
	}%>

