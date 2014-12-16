<%--
/**
 *
 * LDC Jargon Portlet
 * United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal 
 * 
 * @author Thibault Boyeux (thibault.boyeux@gmail.com), 2012
 *
 * Used to display possible actions (edit, delete) for each LDC Jargon
 * in the Jargon list of the Control Panel
 *
 */
--%>


<%@include file="/init.jsp" %>

<%
ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
LDCJargon ldcJargon = (LDCJargon) row.getObject();
String primKey = String.valueOf(ldcJargon.getPrimaryKey());
%>

<liferay-ui:icon-menu>
	<portlet:actionURL name="editLDCJargon" var="editURL">
		<portlet:param name="resourcePrimKey" value="<%= primKey %>" />
	</portlet:actionURL>	
	<liferay-ui:icon image="edit" message="Edit" url="<%= editURL.toString() %>" />
	
	<portlet:actionURL name="deleteLDCJargon" var="deleteURL">
		<portlet:param name="resourcePrimKey" value="<%= primKey %>" />
	</portlet:actionURL>	
	<liferay-ui:icon-delete url="<%= deleteURL.toString() %>" />
</liferay-ui:icon-menu>