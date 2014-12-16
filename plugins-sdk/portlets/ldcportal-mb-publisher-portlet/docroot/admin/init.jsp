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


<%@page import="java.text.Format" %>

<%@page import="javax.portlet.PortletRequest" %>
<%@page import="javax.portlet.PortletMode" %>

<%@page import="com.liferay.portlet.PortletURLFactoryUtil" %>

<%@page import="com.liferay.portlet.messageboards.NoSuchMessageException"%>
<%@page import="com.liferay.portlet.messageboards.model.MBMessage"%>
<%@page import="com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil"%>
<%@page import="com.liferay.portlet.messageboards.service.MBThreadFlagLocalServiceUtil" %>
<%@page import="com.liferay.portlet.messageboards.service.MBThreadLocalServiceUtil"%>
<%@page import="com.liferay.portlet.messageboards.service.permission.MBMessagePermissionClp" %>

<%@page import="com.liferay.portal.kernel.dao.orm.Criterion" %>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQuery"%>
<%@page import="com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.OrderFactoryUtil" %>
<%@page import="com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil" %>

<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log" %>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil" %>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletURL" %>
<%@page import="com.liferay.portal.kernel.util.FastDateFormatFactoryUtil" %>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil" %>
<%@page import="com.liferay.portal.kernel.util.PortalClassLoaderUtil"%>
<%@page import="com.liferay.portal.kernel.util.StringPool" %>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.workflow.WorkflowConstants"%>

<%@page
	import="com.liferay.portlet.messageboards.util.comparator.MessageCreateDateComparator"%>

<%@page import="com.liferay.portal.security.permission.ActionKeys" %>

<%@page import="com.liferay.portal.util.PortalUtil" %>


<portlet:defineObjects />
<liferay-theme:defineObjects />

<%
Format dateFormatDateTime = FastDateFormatFactoryUtil.getDateTime(locale, timeZone);

ClassLoader classLoader = PortalClassLoaderUtil.getClassLoader();
%>
