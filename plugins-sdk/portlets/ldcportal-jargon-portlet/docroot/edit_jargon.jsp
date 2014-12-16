<%--
/**
 *
 * LDC Jargon Portlet
 * United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal 
 * 
 * @author Thibault Boyeux (thibault.boyeux@gmail.com), 2012
 *
 */
--%>


<%@include file="/init.jsp"%>

<%
	LDCJargon ldcJargon = (LDCJargon) request.getAttribute(JargonWebKeys.LDC_JARGON);	

	String redirect = ParamUtil.getString(request, "redirect");
	String backURL = ParamUtil.getString(request, "backURL", redirect);

	String cmdValue = (ldcJargon == null) ? Constants.ADD : Constants.UPDATE;
	
	request.setAttribute("toolbarItem", "add");
%>

<portlet:actionURL name="updateLDCJargon" var="updateURL" />

<liferay-ui:error key="name-and-definition-required" message="name-and-definition-required-error" />
<liferay-ui:error key="failed-to-add-ldc-jargon" message="failed-to-add-ldc-jargon-error" />
<liferay-ui:error key="failed-to-update-ldc-jargon"
	message="failed-to-update-ldc-jargon-error" />
	

<jsp:include page="/toolbar.jsp" />

<liferay-ui:header backURL="<%= backURL %>" localizeTitle="<%= (ldcJargon == null) %>"
	title='<%= (ldcJargon == null) ? "new-jargon" : ldcJargon.getName(locale) %>' />


<aui:form method="post" name="fm" action="<%= updateURL.toString() %>">
	<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= cmdValue %>" />

	<aui:model-context bean="<%= ldcJargon %>" model="<%= LDCJargon.class %>" />
	
	<aui:input name="ldcJargonId" type="hidden" />

	<aui:input name="name" />

	<aui:input name="definition" />

	<aui:button-row>
		<aui:button type="submit" />

		<aui:button href="<%= redirect %>" type="cancel" />
	</aui:button-row>

</aui:form>
