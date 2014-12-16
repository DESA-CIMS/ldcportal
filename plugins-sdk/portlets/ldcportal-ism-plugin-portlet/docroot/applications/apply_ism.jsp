
<%--
/**
 *
 * ISM Plugin Applications Portlet
 * United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal 
 *
 * Pop-up used when an LDC Manager wants to submit an ISM Application on the ISM Page
 *
 * @author Thibault Boyeux (thibault.boyeux@gmail.com), 2012
 *
 */
--%>

<%@include file="/applications/init.jsp"%>


<liferay-ui:error key="reason-required" message="reason-required-error" />
<liferay-ui:error key="failed-to-register-application"
	message="failed-to-register-application-message" />
<liferay-ui:success key="application-added"
	message="application-added-message" />

<portlet:actionURL name="addApplication" var="applyForISMURL" />

<%	
	// Get whether the user applying belongs to the LDC Manager Group and whether or not 
	// he/she has already applied to the ISM
	boolean userBelongsToGroup = UserLocalServiceUtil.hasUserGroupUser(userGroupId, user.getUserId());
	boolean hasAlreadyApplied = ISMPluginUtil.userHasAlreadyAppliedToISM(company.getCompanyId(), user.getUserId(), ismKey);
%>

<c:choose>
	<c:when
		test="<%=!success && userBelongsToGroup && !hasAlreadyApplied%>">
		<aui:form name="fm_nw" action="<%= applyForISMURL.toString() %>"
			cssClass="portlet-ism-plugin popup">

			<liferay-ui:panel collapsible="<%= false %>" extended="<%= false %>"
				id='newISMApplication' persistState="<%= true %>"
				title='<%= LanguageUtil.get(pageContext, "apply-for-ism") %>'>
				<span><%=LanguageUtil.get(pageContext, "thank-you-for-your-interest")%></span>

				<aui:input type="hidden" name="ismKey" value="<%= ismKey %>" />
				<aui:input type="textarea" name="applicationReason"
					value="<%= applicationReason %>" />
				<aui:input type="textarea" name="applicationAdditional"
					value="<%= applicationAdditional %>" />
			</liferay-ui:panel>

			<aui:button-row>
				<aui:button type="submit" value="submit" />
			</aui:button-row>


		</aui:form>
	</c:when>
	<c:when test="<%= hasAlreadyApplied && !success %>">
		<div class="portlet-msg-info">
			<%=LanguageUtil.get(pageContext, "you-have-already-submitted-an-application-for-this-ism")%>
		</div>
	</c:when>
</c:choose>