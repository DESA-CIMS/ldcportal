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


<%
	request.setAttribute("toolbarItem", "view-all");
%>

<%@include file="/init.jsp"%>


<portlet:renderURL var="addNewJargonURL">
	<portlet:param name="jspPage" value="/edit_jargon.jsp" />
	<portlet:param name="redirect" value="<%= currentURL %>" />
</portlet:renderURL>


<liferay-ui:success key="jargon-added" message="jargon-added-success" />
<liferay-ui:success key="jargon-modified" message="jargon-modified-success" />
<liferay-ui:success key="jargon-deleted" message="jargon-deleted-success" />

<liferay-ui:error key="error-deleting-jargon" message="error-deleting-jargon-error" />


<jsp:include page="/toolbar.jsp" />


<liferay-ui:search-container emptyResultsMessage="there-are-no-jargon" delta="20"
	orderByCol="name">
	<liferay-ui:search-container-results>
		<%
			// Get all LDC Jargons for the Search Container
					List<LDCJargon> tempResults = LDCJargonLocalServiceUtil.getAllLDCJargons(scopeGroupId);
					for (LDCJargon ldcJargon : tempResults) {
						ldcJargon.setName(ldcJargon.getName(locale));
						results.add(ldcJargon);
					}
					Collections.sort(results, new LDCJargonComparator());
					
					total = results.size();

					results = ListUtil.subList(results, searchContainer.getStart(), searchContainer.getEnd());

					pageContext.setAttribute("results", results);
					pageContext.setAttribute("total", total);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row className="org.un.ldcportal.jargon.model.LDCJargon"
		keyProperty="ldcJargonId" modelVar="ldcJargon">


		<portlet:actionURL name="editLDCJargon" var="editURL">
			<portlet:param name="resourcePrimKey"
				value="<%= String.valueOf(ldcJargon.getLdcJargonId()) %>" />
		</portlet:actionURL>


		<liferay-ui:search-container-column-text name="name" href="<%= editURL.toString() %>"
			property="name">
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text name="definition"
			href="<%= editURL.toString() %>">
			<%=ldcJargon.getDefinition(locale)%>
		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-jsp path="/actions.jsp" align="right" />
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

