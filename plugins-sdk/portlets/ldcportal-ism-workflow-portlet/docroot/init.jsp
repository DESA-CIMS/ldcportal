<%--
/**
 *
 * ISM Workflow Portlet
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
<%@ taglib uri="http://liferay.com/tld/security"
	prefix="liferay-security"%>

<%@page import="javax.portlet.PortletMode"%>
<%@page import="javax.portlet.PortletRequest" %>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.WindowState"%>

<%@page import="java.io.Serializable"%>
<%@page import="java.text.Format"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>

<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.liferay.portal.util.PortletKeys"%>

<%@page import="com.liferay.portal.kernel.dao.search.ResultRow" %>

<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>

<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletURL" %>

<%@page import="com.liferay.portal.kernel.util.Constants" %>
<%@page	import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.util.GetterUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringUtil"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys" %>

<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>

<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>
<%@page	import="com.liferay.portal.kernel.workflow.WorkflowEngineManagerUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowException"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowHandler"%>
<%@page	import="com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowHandlerUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowInstance"%>
<%@page	import="com.liferay.portal.kernel.workflow.WorkflowInstanceManagerUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowLog"%>
<%@page	import="com.liferay.portal.kernel.workflow.WorkflowLogManagerUtil"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowTask"%>
<%@page	import="com.liferay.portal.kernel.workflow.WorkflowTaskManagerUtil"%>
<%@page	import="com.liferay.portal.kernel.workflow.comparator.WorkflowComparatorFactoryUtil"%>

<%@page import="com.liferay.portal.model.User" %>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil" %>

<%@page import="com.liferay.portlet.PortletURLFactoryUtil" %>
<%@page import="com.liferay.portlet.PortletURLUtil" %>

<%@page import="com.liferay.util.PwdGenerator" %>

<%@page import="org.un.ldcportal.ismapplications.model.ISMApplication" %>

<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
	//Current URL	
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

	Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(locale, timeZone);
%>