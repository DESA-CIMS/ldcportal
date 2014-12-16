<%--
/**
 *
 * ISM Plugin Admin Portlet
 * United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal 
 *
 * View page for editing each ISM individually
 *
 * @author Thibault Boyeux (thibault.boyeux@gmail.com), 2012
 *
 */
--%>


<%@include file="/admin/init.jsp"%>

<liferay-ui:success key="category-added"
	message="the-category-was-succcessfully-added" />

<%@include file="/admin/tabs1.jspf"%>

<%
	long ismKey = ParamUtil.getLong(renderRequest, "resourcePrimKey");
	String backURL = ParamUtil.getString(request, "backURL");

	// Get ISM
	ISM ism = ISMLocalServiceUtil.getISM(ismKey);

	AssetEntry ismAssetEntry = AssetEntryLocalServiceUtil.getAssetEntry(ism.getWebContentId());
	String ismTitle = ismAssetEntry.getTitle(locale);;
	long moderatorId = ism.getModeratorId();
	long mbCategoryId = ism.getMbCategoryId();
	long ismWebContentId = ism.getWebContentId();;

	long ismWebContentGroupId = ismAssetEntry.getGroupId();

	AssetRendererFactory assetRendererFactory =
		AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(JournalArticle.class.getName());
	AssetRenderer assetRenderer =
		assetRendererFactory.getAssetRenderer(ismAssetEntry.getClassPK(), AssetRendererFactory.TYPE_LATEST_APPROVED);	
	
	// Get scope
	String scopeName;
	if (ismWebContentGroupId == scopeGroupId) {
		scopeName = LanguageUtil.get(locale, "default");
	}
	else {
		scopeName = HtmlUtil.escape(GroupLocalServiceUtil.getGroup(ismWebContentGroupId).getDescriptiveName());
	}
%>

<div class="lfr-portlet-toolbar">
	<%
		LiferayPortletURL editMBCategoryURL =
			PortletURLFactoryUtil.create(request, PortletKeys.MESSAGE_BOARDS, plid, PortletRequest.RENDER_PHASE);
		editMBCategoryURL.setPortletMode(PortletMode.VIEW);
		editMBCategoryURL.setParameter("struts_action", "/message_boards/edit_category");
		editMBCategoryURL.setParameter("redirect", currentURL);
		editMBCategoryURL.setParameter("parentCategoryId", String.valueOf(MBCategoryConstants.DEFAULT_PARENT_CATEGORY_ID));
		editMBCategoryURL.setDoAsGroupId(ismWebContentGroupId);

		PortletURL editWebContentURL = assetRenderer.getURLEdit(liferayPortletRequest, liferayPortletResponse);
		editWebContentURL.setParameter("redirect", currentURL);
		editWebContentURL.setParameter("backURL", currentURL);
	%>
	<span class="lfr-toolbar-button add-button"> <a
		href="<%=editMBCategoryURL%>"><liferay-ui:message
				key="add-new-message-board" /></a>
	</span>

	<span class="lfr-toolbar-button edit-button"> <a
		href="<%=editWebContentURL%>"><liferay-ui:message
				key="edit-web-content" /></a>
	</span>

</div>

<liferay-ui:header backURL="<%= backURL %>" title="<%= ismTitle %>" />

<portlet:actionURL name="updateISM" var="updateISMURL" />

<aui:form name="fm" action="<%= updateISMURL %>" method="post">
	<aui:input name="<%=Constants.CMD%>" value="<%=Constants.UPDATE%>"
		type="hidden" />
	<aui:input name="ismId" value="<%= ismKey %>" type="hidden" />
	<aui:fieldset>
		<div>
			<b><%=LanguageUtil.get(locale, "scope") + StringPool.COLON%></b>
			<%=scopeName%></div>

		<aui:select name="mbCategoryId" label="select-ism-message-boards"
			showEmptyOption="true"
			helpMessage="please-select-the-message-boards-used-for-discussions-related-to-the-ism">

			<%
				//
							List<MBCategory> mbCategoryList = new ArrayList<MBCategory>();
							mbCategoryList.addAll(MBCategoryLocalServiceUtil.getCategories(ismWebContentGroupId));
							Collections.sort(mbCategoryList, new MBCategoryNameComparator());
							for (MBCategory mbCategory : mbCategoryList) {
			%>
			<aui:option value="<%= mbCategory.getCategoryId() %>"
				selected="<%= mbCategoryId == mbCategory.getCategoryId() %>">
				<%=mbCategory.getName()%>
			</aui:option>

			<%
				}
			%>
		</aui:select>

	</aui:fieldset>
	
	<aui:fieldset>
		<aui:select name="moderatorId" label="select-moderator"
			showEmptyOption="true"
			helpMessage="please-select-a-moderator-for-this-ism">
			<%
				//
							List<User> userList = new ArrayList<User>();
							userList.addAll(UserLocalServiceUtil.getUserGroupUsers(selectedModeratorGroupId));
							Collections.sort(userList, new UserFullNameComparator());
							for (User mUser : userList) {
			%>
			<aui:option value="<%= mUser.getUserId() %>"
				selected="<%= moderatorId == mUser.getUserId() %>">
				<%=mUser.getFirstName() + StringPool.SPACE + mUser.getLastName()%>
			</aui:option>
			<%
				}
			%>
		</aui:select>
	</aui:fieldset>

	<aui:button-row>
		<aui:button type="submit" />
	</aui:button-row>
</aui:form>