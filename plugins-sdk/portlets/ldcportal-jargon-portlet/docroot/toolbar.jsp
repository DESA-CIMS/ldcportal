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

<%@ include file="/init.jsp" %>


<%
String toolbarItem = GetterUtil.getString(request.getAttribute("toolbarItem"));
%>



<div class="lfr-portlet-toolbar">
	<portlet:renderURL var="viewJargonsURL">
		<portlet:param name="jspPage" value="/view.jsp" />
		<portlet:param name="redirect" value="<%= currentURL %>" />
	</portlet:renderURL>
	
	<portlet:renderURL var="editJargonURL">
		<portlet:param name="jspPage" value="/edit_jargon.jsp" />
		<portlet:param name="redirect" value="<%= currentURL %>" />
	</portlet:renderURL>

	<span class="lfr-toolbar-button view-button <%= toolbarItem.equals("view-all") ? "current" : StringPool.BLANK %>">
		<a href="<%= viewJargonsURL %>"><liferay-ui:message key="view-all" /></a>
	</span>
	
	<span class="lfr-toolbar-button add-button <%= toolbarItem.equals("add") ? "current" : StringPool.BLANK %>">
		<a href="<%= editJargonURL %>"><liferay-ui:message key="add" /></a>
	</span>

</div>