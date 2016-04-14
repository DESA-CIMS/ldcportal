<%--
/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/html/portlet/asset_publisher/init.jsp" %>

<%
List results = (List)request.getAttribute("view.jsp-results");
int assetEntryIndex = ((Integer)request.getAttribute("view.jsp-assetEntryIndex")).intValue();
AssetRendererFactory assetRendererFactory = (AssetRendererFactory)request.getAttribute("view.jsp-assetRendererFactory");
AssetRenderer assetRenderer = (AssetRenderer)request.getAttribute("view.jsp-assetRenderer");
AssetEntry assetEntry = (AssetEntry)request.getAttribute("view.jsp-assetEntry");
boolean show = ((Boolean)request.getAttribute("view.jsp-show")).booleanValue();
request.setAttribute("view.jsp-showIconLabel", true);

String title = (String)request.getAttribute("view.jsp-title");
String displayPageURL = "";
Long assetLayoutId = GetterUtil.getLong(preferences.getValue("assetLayoutId",""),0l);
Layout assetLayout = null;
try	{
	assetLayout = LayoutLocalServiceUtil.getLayout(assetLayoutId);
	String assetLayoutUuid = null;
	String assetViewId = "";
	if(assetLayout != null){
		assetLayoutUuid = assetLayout.getUuid();
		LayoutTypePortlet ltportlet = (LayoutTypePortlet) assetLayout.getLayoutType();
		List<Portlet> portlets = ltportlet.getAllPortlets();
		for (Portlet portlet : portlets) {
			String pId = portlet.getPortletId();
			if(pId.contains("101_INSTANCE_")) {
				String[] aURLSplit = pId.split("_"); 
				if(aURLSplit.length > 2) {
					assetViewId = assetViewId + aURLSplit[2];
					break;
				}
			}

		}
		String fullPath = renderResponse.encodeURL(renderRequest.getContextPath());
		String curLayoutTitle = "";
		String[] fullPathSplit = fullPath.split("\\?");
		String assetLayoutFriendlyURL = assetLayout.getFriendlyURL();
		String[] curLayoutTitleSplit = fullPathSplit[0].split("/");
		curLayoutTitle = curLayoutTitleSplit[curLayoutTitleSplit.length - 1];
		String displayPage = fullPath.split(curLayoutTitle)[0];
		displayPageURL = displayPageURL + "?" + fullPathSplit[1];
		String assetTitle = assetRenderer.getUrlTitle();
		displayPageURL = displayPage + assetLayoutFriendlyURL.substring(1) + "/-/asset_publisher/" + assetViewId + "/content/" + assetTitle;
		displayPageURL = displayPageURL + "?" + fullPathSplit[1];
		displayPageURL += "&groupId=" + assetRenderer.getGroupId(); 
	}
}catch(Exception ex) {
	//No display page selected. Will take the default behaviour
}

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

String summary = StringUtil.shorten(assetRenderer.getSummary(locale), abstractLength);



String viewURL = null;

if (viewInContext) {
	String viewFullContentURLString = viewFullContentURL.toString();

	viewFullContentURLString = HttpUtil.setParameter(viewFullContentURLString, "redirect", currentURL);

	viewURL = assetRenderer.getURLViewInContext(liferayPortletRequest, liferayPortletResponse, viewFullContentURLString);

	viewURL = HttpUtil.setParameter(viewURL, "redirect", currentURL);	
	
// 	if (ISMLocalServiceUtil.ismExistsByWebContendId(assetEntry.getPrimaryKey())) {
// 		ISM ism = ISMLocalServiceUtil.getISMByWebContentId(assetEntry.getPrimaryKey());
		
// 		viewURL = HttpUtil.setParameter(viewURL, "ismKey", ism.getIsmId());		
}	
		
	if (assetRenderer.getGroupId() != scopeGroupId) {
		viewURL = HttpUtil.setParameter(viewURL, "groupId", String.valueOf(assetRenderer.getGroupId()));
	}
//}
else {
	viewURL = viewFullContentURL.toString();
}

if (Validator.isNull(viewURL)) {
	viewURL = viewFullContentURL.toString();
}

String viewURLMessage = viewInContext ? assetRenderer.getViewInContextMessage() : "read-more-x-about-x";

viewURL = _checkViewURL(viewURL, currentURL, themeDisplay);
if(displayPageURL != null && (!displayPageURL.trim().equals("")) && assetEntry.getClassName().equals("com.liferay.portlet.journal.model.JournalArticle")) {
 viewURL = displayPageURL;
}
%>

<c:if test="<%= show %>">
	<div class="asset-abstract <%= defaultAssetPublisher ? "default-asset-publisher" : StringPool.BLANK %>">
		<liferay-util:include page="/html/portlet/asset_publisher/asset_actions.jsp" />

		<h3 class="asset-title">
			<c:choose>
				<c:when test="<%= Validator.isNotNull(viewURL) %>">
					<a href="<%= viewURL %>"><img alt="" src="<%= assetRenderer.getIconPath(renderRequest) %>" /> <%= HtmlUtil.escape(title) %></a>
				</c:when>
				<c:otherwise>
					<img src="<%= assetRenderer.getIconPath(renderRequest) %>" alt="" /> <%= HtmlUtil.escape(title) %>
				</c:otherwise>
			</c:choose>
		</h3>

		<div class="asset-content">
			<div class="asset-summary">

				<%
				String path = assetRenderer.render(renderRequest, renderResponse, AssetRenderer.TEMPLATE_ABSTRACT);

				request.setAttribute(WebKeys.ASSET_RENDERER, assetRenderer);
				request.setAttribute(WebKeys.ASSET_PUBLISHER_ABSTRACT_LENGTH, abstractLength);
				%>

				<c:choose>
					<c:when test="<%= path == null %>">
						<%= summary %>
						
						
					</c:when>
					<c:otherwise>
						<liferay-util:include page="<%= path %>" portletId="<%= assetRendererFactory.getPortletId() %>">
							<liferay-util:param name="isMaximized" value="<%= String.valueOf(isMaximized) %>" />
							<liferay-util:param name="isStories" value="<%= String.valueOf(isStories) %>" />
							<liferay-util:param name="readMoreLink" value="<%= String.valueOf(readMoreLink) %>" />
						</liferay-util:include>
					</c:otherwise>
				</c:choose>
			</div>

			<c:if test="<%= Validator.isNotNull(viewURL) %>">
				<div class="asset-more">
					<a href="<%= viewURL %>"><liferay-ui:message arguments='<%= new Object[] {"aui-helper-hidden-accessible", HtmlUtil.escape(assetRenderer.getTitle(locale))} %>' key="<%= viewURLMessage %>" /> &raquo; </a>
				</div>
			</c:if>
		</div>

		<div class="asset-metadata">
			<%@ include file="/html/portlet/asset_publisher/asset_metadata.jspf" %>
		</div>
	</div>

	<c:if test="<%= (assetEntryIndex + 1) == results.size() %>">
		<div class="final-separator"><!-- --></div>
	</c:if>
</c:if>