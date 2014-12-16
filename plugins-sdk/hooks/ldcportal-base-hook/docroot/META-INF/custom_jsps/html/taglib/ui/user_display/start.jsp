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

<%@ include file="/html/taglib/ui/user_display/init.jsp"%>
<%@page import="java.io.File"%>

<%
	if (Validator.isNull(url) && (userDisplay != null)) {
	url = userDisplay.getDisplayURL(themeDisplay);
}
%>

<div class="taglib-user-display display-style-<%=displayStyle%>">

	<%
		String taglibAlt = (userDisplay != null) ? HtmlUtil.escapeAttribute(userDisplay.getFullName()) : LanguageUtil.get(pageContext, "generic-portrait");

		String taglibSrc = null;
		
		String themeDefaultPortraitSrc = themeDisplay.getPathThemeImages() +
						"/custom/user_default_portrait_" + themeDisplay.getColorScheme().getCssClass() + ".png";
		boolean isCustomTheme = themeDisplay.getThemeId().equals("unldcportalv2_WAR_unldcportalv2theme");

		if (userDisplay != null) {	
			boolean isDefaultPortrait = userDisplay.getPortraitURL(themeDisplay).equals(
				UserConstants.getPortraitURL(themeDisplay.getPathImage(), true, 0));
			
			if (isCustomTheme && isDefaultPortrait) {
				taglibSrc = themeDefaultPortraitSrc;
			}
			else {
				taglibSrc = userDisplay.getPortraitURL(themeDisplay);	
			}
		}
		else {					
			if (isCustomTheme) {
				taglibSrc = themeDefaultPortraitSrc;
			}
			else {
				taglibSrc = UserConstants.getPortraitURL(themeDisplay.getPathImage(), true, 0);		
			}
		}
	%>

	<aui:a href="<%= url %>">
		<span class="user-profile-image"> <img alt="<%=taglibAlt%>" class="avatar"
			src="<%=HtmlUtil.escape(taglibSrc)%>" width="65" />
		</span>

		<span class="user-name"> <%=(userDisplay != null) ? HtmlUtil.escape(userDisplay.getFullName()) : HtmlUtil.escape(userName)%>
		</span>
	</aui:a>

	<div class="user-details">