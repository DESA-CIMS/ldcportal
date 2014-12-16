<%--
/**
 *
 * Message Boards Publisher portlet
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

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Collections"%>
<%@page import="java.text.Format"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.HashSet"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.TreeMap" %>

<%@page import="com.liferay.portlet.messageboards.service.MBThreadLocalServiceUtil"%>
<%@page import="com.liferay.portlet.messageboards.model.MBThread"%>
<%@page import="com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil"%>
<%@page import="com.liferay.portlet.messageboards.model.MBMessage"%>
<%@page import="com.liferay.portlet.messageboards.NoSuchMessageException"%>

<%@page import="com.liferay.portlet.asset.model.AssetEntry"%>
<%@page import="com.liferay.portlet.asset.model.AssetRenderer"%>
<%@page import="com.liferay.portlet.asset.model.AssetRendererFactory"%>
<%@page import="com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil"%>
<%@page import="com.liferay.portlet.asset.NoSuchEntryException"%>

<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.OrderFactoryUtil" %>

<%@page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.util.ArrayUtil"%>
<%@page import="com.liferay.portal.kernel.util.TextFormatter"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil"%>
<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.servlet.SessionMessages"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.util.KeyValuePairComparator"%>
<%@page import="com.liferay.portal.kernel.util.SetUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.KeyValuePair"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.MethodKey"%>
<%@page import="com.liferay.portal.kernel.util.PortalClassInvoker"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>

<%@page import="com.liferay.portal.model.Group"%>
<%@page import="com.liferay.portal.model.GroupConstants"%>
<%@page import="com.liferay.portal.model.Layout"%>

<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>

<%@page import="com.liferay.portal.util.PortalUtil" %>

<%@page import="com.liferay.portlet.PortletURLUtil"%>

<%@page import="com.liferay.portlet.messageboards.service.MBCategoryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.messageboards.model.MBCategory"%>
<%@page
	import="com.liferay.portlet.messageboards.util.comparator.ThreadLastPostDateComparator"%>

<%@page import="org.un.ldcportal.mbdisplay.util.MBDisplayKeys"%>
<%@page import="org.un.ldcportal.mbdisplay.util.MBCategoryComparator" %>

<%@page import="org.un.ldcportal.ismapplications.model.ISM" %>
<%@page import="org.un.ldcportal.ismapplications.service.ISMLocalServiceUtil" %>

<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>




<portlet:defineObjects />
<liferay-theme:defineObjects />


<%
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

	// Preferences
	PortletPreferences preferences = renderRequest.getPreferences();
	String portletResource = ParamUtil.getString(request, "portletResource");
	if (Validator.isNotNull(portletResource)) {
		preferences = PortletPreferencesFactoryUtil.getPortletSetup(request, portletResource);
	}

	Format dateFormatDate = FastDateFormatFactoryUtil.getDate(locale, timeZone);

	ClassLoader classLoader = PortalClassLoaderUtil.getClassLoader();
	
	
	// Get values from preferences
	long categoryId = GetterUtil.getLong(preferences.getValue("category", null));
	int abstractLength = GetterUtil.getInteger(preferences.getValue("abstractLength", null), 200);
	int delta = GetterUtil.getInteger(preferences.getValue("delta", null));
	String dataType = GetterUtil.getString(preferences.getValue("dataType", null));
	String displayStyle = GetterUtil.getString(preferences.getValue("displayStyle", "abstracts"));
	String displayMessages = GetterUtil.getString(preferences.getValue("displayMessages", "all-boards-messages"));
	String paginationType = GetterUtil.getString(preferences.getValue("paginationType", "none"));

	boolean readMoreLink = GetterUtil.getBoolean(preferences.getValue("readMoreLink", null));
	String readMoreLinkType = preferences.getValue("readMoreLinkType", "maximize");
	String readMoreCustomURL = preferences.getValue("readMoreCustomURL", StringPool.BLANK);
	int deltaMaximized =
		GetterUtil.getInteger(preferences.getValue("deltaMaximized", StringPool.BLANK), SearchContainer.DEFAULT_DELTA);
	boolean isMaximized = windowState.toString().equals(WindowState.MAXIMIZED.toString());

	boolean defaultScope = GetterUtil.getBoolean(preferences.getValue("defaultScope", null), true);
	
	// Get ISM Key
	long ismKey = ParamUtil.getLong(request, "ismKey");
	
	// Prepare AssetPublisherUtil method
	MethodKey methodKey =
		new MethodKey(
			"com.liferay.portlet.assetpublisher.util.AssetPublisherUtil", "getGroupIds",
			javax.portlet.PortletPreferences.class, long.class, com.liferay.portal.model.Layout.class);
	long[] groupIds = (long[]) PortalClassInvoker.invoke(false, methodKey, new Object[] {
		preferences, scopeGroupId, layout
	});

	List<Object> groupIdsList = new ArrayList<Object>(groupIds.length);
	for (long n : groupIds)
		groupIdsList.add(new Long(n));
%>
