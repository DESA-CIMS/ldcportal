
<%
	/**
	 * 
	 */
%>

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
<%@page import="javax.portlet.PortletRequest"%>

<%@page import="java.io.Serializable" %>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.HashSet"%>

<%@page import="com.liferay.portal.NoSuchUserException"%>

<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page
	import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.OrderFactoryUtil"%>

<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.KeyValuePair"%>
<%@page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil"%>
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
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletURL" %>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
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
<%@page import="com.liferay.portal.kernel.util.PrefsPropsUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil" %>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowInstance" %>
<%@page import="com.liferay.portal.model.Layout"%>
<%@page import="com.liferay.portal.model.UserGroup"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.util.PortletKeys"%>
<%@page import="com.liferay.portal.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.service.ServiceContext" %>
<%@page import="com.liferay.portal.service.UserGroupLocalServiceUtil"%>
<%@page	import="com.liferay.portal.service.PortletPreferencesLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.GroupLocalServiceUtil"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>

<%@page import="com.liferay.portlet.PortletPreferencesFactoryUtil"%>
<%@page	import="com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil"%>
<%@page	import="com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.model.AssetVocabulary"%>
<%@page import="com.liferay.portlet.asset.model.AssetCategory"%>
<%@page import="com.liferay.portlet.asset.model.AssetRendererFactory"%>
<%@page import="com.liferay.portlet.asset.model.AssetRenderer"%>
<%@page import="com.liferay.portlet.asset.model.AssetEntry"%>
<%@page	import="com.liferay.portlet.asset.AssetRendererFactoryRegistryUtil"%>
<%@page import="com.liferay.portlet.PortletURLUtil"%>
<%@page	import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.NoSuchEntryException"%>
<%@page	import="com.liferay.portlet.messageboards.service.MBCategoryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.messageboards.model.MBCategory"%>
<%@page import="com.liferay.portlet.PortletURLFactoryUtil"%>
<%@page
	import="com.liferay.portlet.messageboards.service.permission.MBCategoryPermissionClp"%>

<%@page	import="org.un.ldcportal.ismapplications.util.ISMConstants"%>
<%@page	import="org.un.ldcportal.ismapplications.service.ISMLocalServiceUtil"%>
<%@page import="org.un.ldcportal.ismapplications.model.ISM"%>
<%@page import="org.un.ldcportal.ismapplications.model.ISMApplication"%>
<%@page	import="org.un.ldcportal.ismapplications.util.ISMPluginUtil"%>
<%@page	import="org.un.ldcportal.ismapplications.util.MBCategoryComparator"%>






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

	// Get ISM and ISm-related objects

	AssetEntry layoutAssetEntry = (AssetEntry) request.getAttribute("LAYOUT_ASSET_ENTRY");	
	
	ISM ism =  null;	
	
	long ismKey = GetterUtil.DEFAULT_LONG;
	
	if (layoutAssetEntry != null) {
		ism = ISMLocalServiceUtil.getISMByWebContentId(layoutAssetEntry.getEntryId());
		ismKey = ism.getIsmId();		

	}
	else {
		ismKey = ParamUtil.getLong(request, "ismKey");
		ism = ISMLocalServiceUtil.getISM(ismKey);
	}
	
	if (ism == null) {
		return;
	}	

	AssetEntry assetEntry =
			AssetEntryLocalServiceUtil.getAssetEntry(ism.getWebContentId());
	long ismWebContentGroupId = assetEntry.getGroupId();

	long mbCategoryId = ism.getMbCategoryId();

	// Get admin portlet preferencses
	PortletPreferences adminPreferences =
		ISMPluginUtil.getAdminPreferences(company.getCompanyId());
	
	// Get usergroup of users allowed to apply to an ISM
	long userGroupId = GetterUtil.getLong(adminPreferences.getValue("userGroupId", null));

	// Get attributes
	String applicationReason = GetterUtil.getString(request.getAttribute("applicationReason"));
	String applicationAdditional = GetterUtil.getString(request.getAttribute("applicationAdditional"));
	boolean success = GetterUtil.getBoolean(request.getAttribute("success"));

	// Get all scopes

	Set<Object> groupIds = new HashSet<Object>();

	groupIds.add(company.getGroup().getGroupId());
	groupIds.add(scopeGroupId);

	for (Layout curLayout : LayoutLocalServiceUtil.getLayouts(layout.getGroupId(), layout.isPrivateLayout())) {
		if (curLayout.hasScopeGroup()) {
	groupIds.add(curLayout.getScopeGroup().getGroupId());
		}
	}
%>