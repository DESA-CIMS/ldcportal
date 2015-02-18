<%--
/**
 *
 * ISM Search Portlet
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

<%@page import="javax.portlet.PortletPreferences"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.PortletMode"%>
<%@page import="javax.portlet.WindowState"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Collections"%>

<%@page import="com.liferay.portal.kernel.util.KeyValuePair"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.KeyValuePairComparator"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.search.Hits"%>
<%@page import="com.liferay.portal.kernel.search.Document"%>
<%@page import="com.liferay.portal.kernel.search.Indexer"%>
<%@page import="com.liferay.portal.kernel.search.IndexerRegistryUtil"%>
<%@page import="com.liferay.portal.kernel.search.SearchContext"%>
<%@page import="com.liferay.portal.kernel.search.SearchContextFactory"%>
<%@page import="com.liferay.portal.kernel.search.Summary"%>
<%@page import="com.liferay.portal.kernel.dao.search.ResultRow"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.search.Field"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil" %>
<%@page import="com.liferay.portal.util.PortalUtil"%>

<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetVocabulary"%>
<%@page import="com.liferay.portlet.asset.model.AssetCategory"%>
<%@page import="com.liferay.portlet.asset.model.AssetRendererFactory"%>
<%@page import="com.liferay.portlet.asset.model.AssetRenderer"%>
<%@page import="com.liferay.portlet.asset.model.AssetEntry"%>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil"%>
<%@page import="com.liferay.portlet.asset.NoSuchEntryException" %>
<%@page import="com.liferay.portlet.PortletURLUtil"%>
<%@page import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticleDisplay " %>

<%@page import="org.apache.commons.lang3.ArrayUtils"%>

<%@page import="org.un.ldcportal.ismsearch.util.ISMSearchUtil"%>
<%@page import="org.un.ldcportal.ismsearch.util.DocumentTitleComparator"%>

<portlet:defineObjects />
<liferay-theme:defineObjects />



<%
	WindowState windowState = null;
	PortletMode portletMode = null;

	PortletURL currentURLObj = null;
	String emptyStringArray []=new String [0]; 

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

	String redirect = ParamUtil.getString(request, "redirect");
	String cmd = (String) portletSession.getAttribute(Constants.CMD);
	
	// Preferences
	PortletPreferences preferences = renderRequest.getPreferences();
	String portletResource = ParamUtil.getString(request, "portletResource");
	if (Validator.isNotNull(portletResource)) {
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}
	List<AssetCategory> masterChildCategories = null;
	// Get preferences
	int vocabularyId = GetterUtil.getInteger((preferences.getValue("vocabularyId", "0")));
	int masterCategoryId = GetterUtil.getInteger((preferences.getValue("masterCategoryId", "0")));
	if (masterCategoryId != 0) {
		masterChildCategories = AssetCategoryLocalServiceUtil.getChildCategories(masterCategoryId);
	}
	int ismCategoryId = GetterUtil.getInteger((preferences.getValue("ismCategoryId", null)));
	String[] categoriesId = preferences.getValues("categoriesId", emptyStringArray);
	long[] selectedCategories = (long[]) portletSession.getAttribute("selectedCategories");
	long[] allSelectedCategories;
	if (selectedCategories == null) {
		allSelectedCategories = new long[1];
		allSelectedCategories[0] = ismCategoryId;
	}
	else {
		allSelectedCategories = new long[selectedCategories.length + 1];
		System.arraycopy(selectedCategories, 0, allSelectedCategories, 0, selectedCategories.length);
		allSelectedCategories[selectedCategories.length] = ismCategoryId;
	}
	
	if (Validator.isNotNull(selectedCategories)) {
	Arrays.sort(selectedCategories);
	}

	// Init
	String allNWCategoryIds = "";
%>