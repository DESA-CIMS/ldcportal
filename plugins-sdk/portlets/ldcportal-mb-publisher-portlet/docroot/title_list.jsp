<%--
/**
 *
 * Message Boards Publisher portlet
 * United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal 
 * 
 * @author Thibault Boyeux (thibault.boyeux@gmail.com), 2012
 * 
 * Used to display the "title_list" display style for messages
 * (much inspired from Liferay's Asset Publisher title_list display style)
 *
 */
--%>

<%@include file="/init.jsp"%>

<%
	List results = (List) request.getAttribute("view.jsp-results");

	MBMessage mbMessage = (MBMessage) request.getAttribute("view.jsp-mbMessage");
	
	int mbThreadIndex = ((Integer)request.getAttribute("view.jsp-mbThreadIndex")).intValue();
	
	AssetEntry assetEntry = (AssetEntry)request.getAttribute("view.jsp-assetEntry");
	AssetRendererFactory assetRendererFactory = (AssetRendererFactory)request.getAttribute("view.jsp-assetRendererFactory");
	AssetRenderer assetRenderer = (AssetRenderer)request.getAttribute("view.jsp-assetRenderer");
	
	String title = (String)request.getAttribute("view.jsp-title");

	if (Validator.isNull(title)) {
		title = assetRenderer.getTitle(locale);
	}

	// Define the View Full Content URL (needed for view URL)
	PortletURL viewFullContentURL = renderResponse.createRenderURL();
	viewFullContentURL.setParameter("struts_action", "/asset_publisher/view_content");
	viewFullContentURL.setParameter("assetEntryId", String.valueOf(assetEntry.getEntryId()));
	viewFullContentURL.setParameter("type", assetRendererFactory.getType());
	if (Validator.isNotNull(assetRenderer.getUrlTitle())) {
		if (assetRenderer.getGroupId() != scopeGroupId) {
			viewFullContentURL.setParameter("groupId", String.valueOf(assetRenderer.getGroupId()));
		}

		viewFullContentURL.setParameter("urlTitle", assetRenderer.getUrlTitle());
	}
	String viewFullContentURLString = viewFullContentURL.toString();

	// Define the View URL
	String viewURL = null;
	viewURL =
		assetRenderer.getURLViewInContext(liferayPortletRequest, liferayPortletResponse, viewFullContentURLString);
	
%>



<c:if test="<%= mbThreadIndex == 0 %>">
		<ul class="title-list">
	</c:if>

	<li class="title-list <%= assetRendererFactory.getType() %>">
			<liferay-ui:icon
				label="<%= true %>"
				message="<%= HtmlUtil.escape(title) %>"
				src="<%= assetRenderer.getIconPath(renderRequest) %>"
				url="<%= viewURL %>"
			/>

		<div class="asset-metadata">
			 
		</div>
	</li>

	<c:if test="<%= (mbThreadIndex + 1) == results.size() %>">
		</ul>
	</c:if>
