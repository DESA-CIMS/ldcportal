<%--
/**
 *
 * ISM Plugin Admin Portlet
 * United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal 
 *
 * @author Thibault Boyeux (thibault.boyeux@gmail.com), 2012
 *
 */
--%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security"%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List" %>

<%@page import="javax.portlet.PortletMode"%>
<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="javax.portlet.PortletRequest" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>

<%@page import="com.liferay.portal.NoSuchUserException"%>

<%@page import="com.liferay.portal.kernel.bean.BeanParamUtil" %>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletURL" %>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@page import="com.liferay.portal.kernel.util.ListUtil" %>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>

<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.model.UserGroup"%>

<%@page import="com.liferay.portal.security.permission.ActionKeys" %>

<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.UserGroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>

<%@page import="com.liferay.portal.util.PortalUtil" %>
<%@page import="com.liferay.portal.util.PortletKeys" %>

<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil" %>
<%@page import="com.liferay.portlet.PortletURLUtil"%>

<%@page import="com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil"%>
<%@page import="com.liferay.portlet.asset.NoSuchEntryException"%>
<%@page import="com.liferay.portlet.asset.model.AssetCategory"%>
<%@page import="com.liferay.portlet.asset.model.AssetCategoryProperty"%>
<%@page import="com.liferay.portlet.asset.model.AssetEntry"%>
<%@page import="com.liferay.portlet.asset.model.AssetRenderer"%>
<%@page import="com.liferay.portlet.asset.model.AssetRendererFactory"%>
<%@page import="com.liferay.portlet.asset.model.AssetVocabulary"%>
<%@page import="com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.service.AssetCategoryPropertyLocalServiceUtil" %>
<%@page import="com.liferay.portlet.asset.service.AssetCategoryPropertyServiceUtil"%>
<%@page import="com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil"%>


<%@page import="com.liferay.portlet.journal.model.JournalArticle" %>
<%@page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil" %>

<%@page import="com.liferay.portlet.messageboards.model.MBCategory" %>
<%@page import="com.liferay.portlet.messageboards.model.MBCategoryConstants" %>
<%@page import="com.liferay.portlet.messageboards.service.MBCategoryLocalServiceUtil" %>

<%@page import="org.un.ldcportal.ismapplications.NoSuchISMException"%>
<%@page import="org.un.ldcportal.ismapplications.model.ISM"%>
<%@page import="org.un.ldcportal.ismapplications.service.ISMLocalServiceUtil"%>
<%@page import="org.un.ldcportal.ismapplications.util.AssetCategoryTitleComparator" %>
<%@page import="org.un.ldcportal.ismapplications.util.ISMTitleComparator"%>
<%@page import="org.un.ldcportal.ismapplications.util.MBCategoryNameComparator" %>
<%@page import="org.un.ldcportal.ismapplications.util.UserFullNameComparator"%>
<%@page import="org.un.ldcportal.ismapplications.util.WebKeys" %>


<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
	// Current URL	
	WindowState windowState = null;
	PortletMode portletMode = null;

	PortletURL currentURLObj = null;

	if (renderRequest != null) {
		windowState = renderRequest.getWindowState();
		portletMode = renderRequest.getPortletMode();

		currentURLObj = PortletURLUtil.getCurrent(renderRequest, renderResponse);
	}
	else if (resourceRequest != null) {
		windowState = resourceRequest.getWindowState();
		portletMode = resourceRequest.getPortletMode();

		currentURLObj = PortletURLUtil.getCurrent(resourceRequest, resourceResponse);
	}

	String currentURL = currentURLObj.toString();
	
	//Preferences
	PortletPreferences preferences = renderRequest.getPreferences();
	String portletResource = ParamUtil.getString(request, "portletResource");
	if (Validator.isNotNull(portletResource)) {
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
	
	long selectedUserGroupId = GetterUtil.getLong(preferences.getValue("userGroupId", null));
	long selectedIsmCategoryId = GetterUtil.getLong(preferences.getValue("ismCategoryId", null));
	//long selectedRelatedAssetCategoryId = GetterUtil.getLong(preferences.getValue("relatedAssetCategoryId", null));
	long selectedModeratorGroupId = GetterUtil.getLong(preferences.getValue("moderatorGroupId", null));
	long selectedISMVocabularyId = GetterUtil.getLong(preferences.getValue("ismVocabularyId", null));
%>