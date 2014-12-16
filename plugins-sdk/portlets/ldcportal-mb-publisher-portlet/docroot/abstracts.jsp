<%--
/**
 *
 * Message Boards Publisher portlet
 * United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal 
 * 
 * @author Thibault Boyeux (thibault.boyeux@gmail.com), 2012
 * 
 * Used to display the "abstracts" display style for messages
 * (much inspired from Liferay's Asset Publisher abstracts display style)
 *
 */
--%>

<%@include file="/init.jsp"%>

<%
	List results = (List) request.getAttribute("view.jsp-results");

	MBMessage mbMessage = (MBMessage) request.getAttribute("view.jsp-mbMessage");

	String categoryName = mbMessage.getCategory().getName();

	int mbThreadIndex = ((Integer) request.getAttribute("view.jsp-mbThreadIndex")).intValue();
	AssetEntry assetEntry = (AssetEntry) request.getAttribute("view.jsp-assetEntry");
	AssetRendererFactory assetRendererFactory = (AssetRendererFactory) request.getAttribute("view.jsp-assetRendererFactory");
	AssetRenderer assetRenderer = (AssetRenderer) request.getAttribute("view.jsp-assetRenderer");

	String title = (String) request.getAttribute("view.jsp-title");

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
	viewURL = assetRenderer.getURLViewInContext(liferayPortletRequest, liferayPortletResponse, viewFullContentURLString);

	ISM ism = null;

	try {
		ism = ISMLocalServiceUtil.getISMByMBCategoryId(mbMessage.getCategoryId()).get(0);
	}
	catch (IndexOutOfBoundsException e) {

	}

	if (ism != null) {
		viewURL = HttpUtil.setParameter(viewURL, "ismKey", ism.getIsmId());
	}

	String summary = StringUtil.shorten(assetRenderer.getSummary(locale), abstractLength);
%>



<div class="asset-abstract">
	<h3 class="asset-title">
		<c:choose>
			<c:when test="<%= Validator.isNotNull(viewURL) %>">
				<a href="<%=viewURL%>"><img alt=""
					src="<%=assetRenderer.getIconPath(renderRequest)%>" /> <%=HtmlUtil.escape(title)%></a>
			</c:when>
			<c:otherwise>
				<img src="<%=assetRenderer.getIconPath(renderRequest)%>" alt="" />
				<%=HtmlUtil.escape(title)%>
			</c:otherwise>
		</c:choose>
	</h3>

	<div class="asset-content">
		<div class="asset-summary">
			<%
				String path = assetRenderer.render(renderRequest, renderResponse, AssetRenderer.TEMPLATE_ABSTRACT);

				request.setAttribute(WebKeys.ASSET_RENDERER, assetRenderer);
				request.setAttribute("ASSET_PUBLISHER_ABSTRACT_LENGTH", abstractLength);
			%>

			<c:choose>
				<c:when test="<%= path == null %>">
					<%=summary%>
				</c:when>
				<c:otherwise>
					<liferay-util:include page="<%= path %>"
						portletId="<%= assetRendererFactory.getPortletId() %>">
						<liferay-util:param name="isMaximized"
							value="<%= String.valueOf(isMaximized) %>" />
						<liferay-util:param name="readMoreLink"
							value="<%= String.valueOf(readMoreLink) %>" />
					</liferay-util:include>
				</c:otherwise>
			</c:choose>
		</div>

		<div class="asset-category">
			<%=categoryName%>
		</div>
	</div>
</div>

<c:if test="<%= (mbThreadIndex + 1) == results.size() %>">
	<div class="final-separator">
		<!-- -->
	</div>
</c:if>


