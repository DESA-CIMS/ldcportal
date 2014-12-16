<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme"%>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui"%>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui"%>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet"%>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util"%>
<%@ taglib uri="http://liferay.com/tld/security"
	prefix="liferay-security"%>

<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Collections" %>
<%@page import="java.util.List" %>

<%@page import="javax.portlet.PortletPreferences"%>

<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.HttpUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>

<%@page import="com.liferay.portal.util.PortalUtil"%>

<%@page import="com.liferay.portlet.PortletURLUtil"%>

<%@page import="com.liferay.portlet.asset.model.AssetCategory"%>
<%@page import="com.liferay.portlet.asset.model.AssetEntry"%>
<%@page import="com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil"%>
<%@page import="com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil"%>

<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>

<%@page import="org.un.ldcportal.ismapplications.model.ISM"%>
<%@page	import="org.un.ldcportal.ismapplications.service.ISMLocalServiceUtil"%>
<%@page	import="org.un.ldcportal.ismapplications.util.ISMPluginUtil"%>


<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
	// ISM Primary Key

	AssetEntry layoutAssetEntry = (AssetEntry) request.getAttribute("LAYOUT_ASSET_ENTRY");	

	ISM ism = ISMLocalServiceUtil.getISMByWebContentId(layoutAssetEntry.getEntryId());
	
	if (ism == null) {
		return;
	}

	AssetEntry assetEntry = AssetEntryLocalServiceUtil.getAssetEntry(ism.getWebContentId());

	// Get admin portlet preferencses
	PortletPreferences adminPreferences = ISMPluginUtil.getAdminPreferences(company.getCompanyId());
	
	long ismVocabularyId = GetterUtil.getLong(adminPreferences.getValue("ismVocabularyId", null));
	
	String delimiter = ">";
%>