
<%--
/**
 *
 * ISM Plugin Applications Portlet
 * United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal 
 *
 * Main View page for the ISM Plugin Application Portlet
 * Displayed on ISM pages and shows the "Add conversation" & "Apply to ISM" messages
 *
 * @author Thibault Boyeux (thibault.boyeux@gmail.com), 2012
 *
 */
--%>

<%@include file="/applications/init.jsp"%>


<%
	String ismTitle = StringPool.BLANK;
	boolean ismHasModerator = false;

	if (ism != null) {
		ismTitle = AssetEntryLocalServiceUtil.getAssetEntry(ism.getWebContentId()).getTitle(locale);

		try {
			// Check whether the ISM has an assigned moderator (ISM Plugin)
			UserLocalServiceUtil.getUser(ism.getModeratorId());
			ismHasModerator = true;
		}
		catch (NoSuchUserException e) {
			//e.printStackTrace();
		}
	}
	
	// Build Add Conversation URL
	LiferayPortletURL newConversationURL =
		PortletURLFactoryUtil.create(request, PortletKeys.MESSAGE_BOARDS, layout.getPlid(), PortletRequest.ACTION_PHASE);
	newConversationURL.setWindowState(WindowState.MAXIMIZED);
	newConversationURL.setPortletMode(PortletMode.VIEW);
	newConversationURL.setParameter("mbCategoryId", String.valueOf(mbCategoryId));
	newConversationURL.setParameter("struts_action", "/message_boards/edit_message");
	newConversationURL.setParameter("redirect", currentURL);
	
	// Build Sign In URL
	PortletURL newSignInURL =
		PortletURLFactoryUtil.create(request, PortletKeys.LOGIN, layout.getPlid(), PortletRequest.ACTION_PHASE);
	newSignInURL.setWindowState(WindowState.MAXIMIZED);
	newSignInURL.setPortletMode(PortletMode.VIEW);
	newSignInURL.setParameter("redirect", currentURL);

	// Checks whether the user can or cannot add a message	
	boolean canAddMessage = MBCategoryPermissionClp.contains(permissionChecker, mbCategoryId, ActionKeys.ADD_MESSAGE);
	boolean ismHasCategory = mbCategoryId != GetterUtil.DEFAULT_LONG;

	// Checks whether the user can or cannot apply for this ISM
	boolean belongsToLDCManagerGroup = UserLocalServiceUtil.hasUserGroupUser(userGroupId, user.getUserId());
	boolean canApply = belongsToLDCManagerGroup && ismHasModerator;

	// Checks whether the user has already applied for this ISM (open application, not completed)
	boolean hasAlreadyApplied = ISMPluginUtil.userHasAlreadyAppliedToISM(company.getCompanyId(), user.getUserId(), ismKey);

%>


<div class="portlet-content">
	<aui:form name="fm" action="<%= newConversationURL.toString() %>"
		method="post">
		<c:choose>
			<%-- If user does not have permission to add message and the ISM has an MBCategory assigned to it, 
			display the "You must be signed-in to start a new discussion" message --%>
			<c:when test="<%= !canAddMessage && ismHasCategory %>">
				<div class="portlet-msg-info">
					<%=LanguageUtil.get(pageContext, "you-must-be")%>
					<a href="<%=newSignInURL.toString()%>"><%=LanguageUtil.get(pageContext, "signed-in")%></a>
					<%=LanguageUtil.get(pageContext, "to-start-a-new-discussion-on-this-ism")%>
				</div>
			</c:when>
			<c:when test="<%= canAddMessage && ismHasCategory %>">
				<aui:button type="submit" value="start-conversation" />
			</c:when>
		</c:choose>
		<%-- Display the Apply to ISM button only if the user can apply --%>
		<c:if test="<%= canApply %>">
			<c:choose>
				<c:when test="<%= !hasAlreadyApplied %>">
					<aui:button
						onClick='<%= renderResponse.getNamespace() + "callPopup()" %>'
						value="apply-for-this-ism" />
				</c:when>
				<c:otherwise>
					<aui:button disabled="true" value="ism-already-applied-for" />
				</c:otherwise>
			</c:choose>
		</c:if>
	</aui:form>
</div>

<%--- Build Apply for ISM render URL --%>
<portlet:renderURL var="applyForISMRenderURL"
	windowState="<%= LiferayWindowState.POP_UP.toString() %>">
	<portlet:param name="jspPage" value="/applications/apply_ism.jsp" />
	<portlet:param name="redirect" value="<%= currentURL %>" />
	<portlet:param name="ismKey" value="<%= String.valueOf(ismKey) %>" />
</portlet:renderURL>

<portlet:actionURL name="addApplication" var="applyForISMURL" />

<aui:script>    
// Script to open the ISM Application Pop-up after clicking on "Apply to this ISM" 

function <portlet:namespace />callPopup() {
AUI().ready('aui-dialog','aui-dialog-iframe', function(A) {      
	 var dialog = new A.Dialog(             
			 {               
				 align: Liferay.Util.Window.ALIGN_CENTER,  
				 after: {
						render: function(event) {
							this.set('y', this.get('y') + 50);
						}
					},
			     destroyOnClose: true,
				 title: '<%=ismTitle%>',                 
				 width: 600,                      
			 }         
	 	);
	 dialog.plug(             
			 A.Plugin.DialogIframe,             
			 {                 
				 uri: '<%=applyForISMRenderURL.toString()%>',
				 iframeCssClass: 'dialog-iframe'                           
			}         
	 ).render();

	  });
}
</aui:script>