<%--
/**
 *
 * ISM Plugin Admin Portlet
 * United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal 
 *
 * View page : displays the list of ISMs with indicators regarding moderators
 * and message boards
 *
 * Configuration page : displays basic configuration for the ISM Admin Plugin portlet
 *
 * @author Thibault Boyeux (thibault.boyeux@gmail.com), 2012
 *
 */
--%>

<%@include file="/admin/init.jsp"%>

<liferay-ui:success key="configuration-saved"
	message="ism-plugin-configuration-was-successfully-saved" />
<liferay-ui:success key="ism-list-updated"
	message="the-list-of-isms-was-successfully-updated" />

<%@include file="/admin/tabs1.jspf"%>

<%
	List<UserGroup> userGroupList = UserGroupLocalServiceUtil.getUserGroups(company.getCompanyId());
%>

<c:choose>
	
	<%--- List-view page --%>
	<c:when
		test='<%=tabs1.equals("ism-home") && selectedIsmCategoryId != GetterUtil.DEFAULT_LONG%>'>

		<div class="lfr-portlet-toolbar">
			<portlet:actionURL name="refreshISMs" var="refreshISMsURL" />

			<span class="lfr-toolbar-button refresh-button"> <a
				href="<%=refreshISMsURL%>"><liferay-ui:message key="refresh" /></a>
			</span>

		</div>


		<liferay-ui:search-container emptyResultsMessage="there-are-no-ism"
			delta="20">
			<liferay-ui:search-container-results>
				<%
					// Get all ISMs
									List<ISM> tempResults = ISMLocalServiceUtil.getAllISMs(scopeGroupId);
									for (ISM ism : tempResults) {
										results.add(ism);
									}

									Collections.sort(results, new ISMTitleComparator());

									total = results.size();

									results = ListUtil.subList(results, searchContainer.getStart(), searchContainer.getEnd());

									pageContext.setAttribute("results", results);
									pageContext.setAttribute("total", total);
				%>
			</liferay-ui:search-container-results>

			<liferay-ui:search-container-row
				className="org.un.ldcportal.ismapplications.model.ISM"
				keyProperty="ismId" modelVar="ism">

				<portlet:renderURL var="viewURL">
					<portlet:param name="jspPage" value="/admin/view.jsp" />
				</portlet:renderURL>

				<portlet:renderURL var="editISMURL">
					<portlet:param name="resourcePrimKey"
						value="<%= String.valueOf(ism.getPrimaryKey()) %>" />
					<portlet:param name="jspPage" value="/admin/edit_ism.jsp" />
					<portlet:param name="backURL" value="<%= viewURL %>" />
				</portlet:renderURL>


				<%-- Display ISM Title --%>
				<liferay-ui:search-container-column-text name="ism-title"
					href="<%= editISMURL %>">
					<%
						String title = StringPool.BLANK;
											try {
												title = AssetEntryLocalServiceUtil.getAssetEntry(ism.getWebContentId()).getTitle(locale);
											}
											catch (NoSuchEntryException e) {
											}
					%>
					<b><%=title%></b>
				</liferay-ui:search-container-column-text>
				
				<%-- Display ISM scope --%>
				<liferay-ui:search-container-column-text name="scope">
					<%
						String scope = StringPool.BLANK;
											try {
												long ismWebContentGroupId =
													AssetEntryLocalServiceUtil.getAssetEntry(ism.getWebContentId()).getGroupId();
												if (ismWebContentGroupId == scopeGroupId) {
													scope = LanguageUtil.get(locale, "default");
												}
												else {
													scope = HtmlUtil.escape(GroupLocalServiceUtil.getGroup(ismWebContentGroupId).getDescriptiveName());
												}
											}
											catch (NoSuchEntryException e) {
											}
					%>
					<%=scope%>

				</liferay-ui:search-container-column-text>
				
				<%-- Display ISM additional info : moderator and message board --%>
				<liferay-ui:search-container-column-text name="more-info">
					<%
						//
											String defaultMessage = "<span class=\"none\">" + LanguageUtil.get(pageContext, "none") + "</span>";
											String okMessage = "<span class=\"ok\">" + LanguageUtil.get(pageContext, "ok") + "</span>";

											String moderatorMsg = defaultMessage;
											String categoryMsg = defaultMessage;
											String messageBoardMsg = defaultMessage;

											String moderatorHelperMsg = null;
											String categoryHelperMsg = null;
											String messageBoardHelperMsg = null;

											try {
												User moderator = UserLocalServiceUtil.getUser(ism.getModeratorId());
												moderatorMsg = okMessage;
												moderatorHelperMsg = moderator.getFirstName() + StringPool.SPACE + moderator.getLastName();

											}
											catch (NoSuchUserException e) {

											}
											try {
												AssetCategory assetCategory = AssetCategoryLocalServiceUtil.getAssetCategory(ism.getAssetCategoryId());
												categoryMsg = okMessage;
												categoryHelperMsg = assetCategory.getName();
											}
											catch (com.liferay.portlet.asset.NoSuchCategoryException e) {

											}
											try {
												if (ism.getMbCategoryId() != 0) {
													MBCategory mbCategory = MBCategoryLocalServiceUtil.getCategory(ism.getMbCategoryId());
													messageBoardMsg = okMessage;
													messageBoardHelperMsg = mbCategory.getName();
												}
											}
											catch (com.liferay.portlet.messageboards.NoSuchCategoryException e) {

											}
					%>
					<table class="more-info-table">
						<tr>
							<td><%=LanguageUtil.get(pageContext, "boards") + StringPool.COLON%></td>
							<td class="right-cell"><%=messageBoardMsg%> <c:if
									test="<%= messageBoardHelperMsg != null %>">
									<liferay-ui:icon-help message="<%=messageBoardHelperMsg %>"></liferay-ui:icon-help>
								</c:if></td>
						</tr>
						<tr>
							<td><%=LanguageUtil.get(pageContext, "moderator") + StringPool.COLON%></td>
							<td class="right-cell">
								<div><%=moderatorMsg%>
									<c:if test="<%= moderatorHelperMsg != null %>">
										<liferay-ui:icon-help message="<%=moderatorHelperMsg %>"></liferay-ui:icon-help>
									</c:if>
								</div>
							</td>
						</tr>
					</table>
				</liferay-ui:search-container-column-text>


			</liferay-ui:search-container-row>

			<liferay-ui:search-iterator />
		</liferay-ui:search-container>
	</c:when>

	<%-- Configuration tab --%>
	<c:when
		test='<%=tabs1.equals("configuration") || selectedIsmCategoryId == GetterUtil.DEFAULT_LONG%>'>
		<portlet:actionURL name="editUserGroup" var="editUserGroupURL" />

		<aui:form name="fm" action="<%=editUserGroupURL.toString()%>"
			method="post">
			<aui:fieldset>
				<aui:input name="<%=Constants.CMD%>" value="<%=Constants.UPDATE%>"
					type="hidden" />
				
				<%-- Display all User Groups to select the LDC Manager User Group --%>
				<aui:select name="preferences--userGroupId--" label="user-group"
					helpMessage="user-group-help-message" showEmptyOption="true">
					<%
						for (UserGroup userGroup : userGroupList) {
					%>
					<aui:option value="<%=userGroup.getUserGroupId()%>"
						selected="<%=selectedUserGroupId == userGroup.getUserGroupId()%>"><%=userGroup.getName()%></aui:option>
					<%
						}
					%>
				</aui:select>
				
				<%-- Display all User Groups to select the ISM Moderator User Group --%>
				<aui:select name="preferences--moderatorGroupId--"
					label="moderator-group" helpMessage="moderator-group-help-message"
					showEmptyOption="true">
					<%
						for (UserGroup moderatorGroup : userGroupList) {
					%>
					<aui:option value="<%=moderatorGroup.getUserGroupId()%>"
						selected="<%=selectedModeratorGroupId == moderatorGroup.getUserGroupId()%>"><%=moderatorGroup.getName()%></aui:option>
					<%
						}
					%>
				</aui:select>
				
				<%-- Display all Categories to select the ISM Category --%>
				<aui:select name="preferences--ismCategoryId--"
					label="select-ism-category" showEmptyOption="true">
					<%
						List<AssetCategory> assetCategoryList = AssetCategoryLocalServiceUtil.getCategories();
											for (AssetCategory currentCategory : assetCategoryList) {
					%>
					<aui:option value="<%=currentCategory.getCategoryId()%>"
						selected="<%=currentCategory.getCategoryId() == selectedIsmCategoryId%>">
						<%=currentCategory.getTitle(locale)%>
					</aui:option>
					<%
						}
					%>
				</aui:select>
				
				<%-- Display all Vocabularies to select the ISM Vocabulary --%>
				<aui:select name="preferences--ismVocabularyId--"
					label="select-ism-vocabulary" showEmptyOption="true">
					<%
						List<AssetVocabulary> assetVocabularyList =
												AssetVocabularyLocalServiceUtil.getGroupVocabularies(scopeGroupId);
											for (AssetVocabulary currentVocabulary : assetVocabularyList) {
					%>
					<aui:option value="<%=currentVocabulary.getVocabularyId()%>"
						selected="<%=currentVocabulary.getVocabularyId() == selectedISMVocabularyId%>">
						<%=currentVocabulary.getTitle(locale)%>
					</aui:option>
					<%
						}
					%>
				</aui:select>


			</aui:fieldset>
			<aui:button type="submit" />
		</aui:form>
	</c:when>
</c:choose>