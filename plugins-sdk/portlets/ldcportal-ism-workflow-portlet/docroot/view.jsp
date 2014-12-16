<%--
/**
 *
 * ISM Workflow Portlet
 * United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal 
 *
 * View page for the ISM Workflow Portlet
 * Displays a list of all Workflow instances of class ISMApplication
 * 
 * @author Thibault Boyeux (thibault.boyeux@gmail.com), 2012
 *
 */
--%>

<%@include file="/init.jsp"%>

<%
	String tabs2 = ParamUtil.getString(request, "tabs2", "pending");

	PortletURL portletURL = renderResponse.createRenderURL();

	portletURL.setParameter("tabs1", "submissions");
	portletURL.setParameter("tabs2", tabs2);
%>

<liferay-ui:tabs names="pending,completed" param="tabs2"
	portletURL="<%= portletURL %>" />

<%
	try {
		boolean completedInstances = true;

		if (tabs2.equals("pending")) {
	completedInstances = false;
		}
%>


<liferay-ui:search-container iteratorURL="<%= portletURL %>">
	<%
		//
		boolean allInstances = true;

		String[] assetTypes = {
			ISMApplication.class.getName()
		};

		List<WorkflowInstance> resultsInstances = null;

		int totalInstances = 0;

		if (completedInstances) {
			searchContainer.setEmptyResultsMessage("there-are-no-completed-instances");
		}
		else {
			searchContainer.setEmptyResultsMessage("there-are-no-pending-instances");
		}

		resultsInstances =
			WorkflowInstanceManagerUtil.getWorkflowInstances(
		company.getCompanyId(), null, assetTypes, completedInstances, searchContainer.getStart(),
		searchContainer.getEnd(), null);
		totalInstances =
			WorkflowInstanceManagerUtil.getWorkflowInstanceCount(company.getCompanyId(), null, assetTypes, completedInstances);

	%>

	<liferay-ui:search-container-results results="<%= resultsInstances %>"
		total="<%= totalInstances %>" />

	<liferay-ui:search-container-row
		className="com.liferay.portal.kernel.workflow.WorkflowInstance"
		modelVar="workflowInstance" stringKey="<%= true %>">
		<liferay-ui:search-container-row-parameter name="workflowInstance"
			value="<%= workflowInstance %>" />

		<%
			//
						Map<String, Serializable> workflowContext = workflowInstance.getWorkflowContext();

						long companyId = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_COMPANY_ID));
						long groupId = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_GROUP_ID));
						String className = (String) workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_NAME);
						long classPK = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));
						long userId = GetterUtil.getLong((String) workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));

						WorkflowHandler workflowHandler = WorkflowHandlerRegistryUtil.getWorkflowHandler(className);
						
						LiferayPortletURL rowURL =
										PortletURLFactoryUtil.create(request, PortletKeys.WORKFLOW_DEFINITIONS, plid, PortletRequest.RENDER_PHASE);
						rowURL.setPortletMode(PortletMode.VIEW);
						rowURL.setParameter("struts_action", "/workflow_definitions/edit_workflow_instance");
						rowURL.setParameter("redirect", currentURL);
						rowURL.setParameter("workflowInstanceId", String.valueOf(workflowInstance.getWorkflowInstanceId()));

		%>

		<liferay-ui:search-container-column-text buffer="buffer"
			name="ism-title" href="<%= rowURL %>">

			<%
				buffer.append(HtmlUtil.escape(workflowHandler.getTitle(classPK, locale)));
			%>

		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text buffer="buffer"
			href="<%= rowURL %>" name="status">

			<%
				buffer.append(LanguageUtil.get(pageContext, workflowInstance.getState()));
			%>

		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text buffer="buffer"
			href="<%= rowURL %>" name="applicant">

			<%
				User instanceUser = UserLocalServiceUtil.getUser(userId);
																																		buffer.append(instanceUser.getFullName());
			%>

		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text buffer="buffer"
			href="<%= rowURL %>" name="moderator">

		</liferay-ui:search-container-column-text>

		<liferay-ui:search-container-column-text buffer="buffer"
			name="last-activity-date" href="<%= rowURL %>">

		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<%
	}
	catch (Exception e) {
		if (_log.isWarnEnabled()) {
	_log.warn("Error retrieving workflow instances", e);
		}
%>

<div class="portlet-msg-error">
	<liferay-ui:message
		key="an-error-occurred-while-retrieving-the-list-of-instances" />
</div>

<%
	}
%>

<%!private static Log _log = LogFactoryUtil.getLog("portal-web.docroot.html.portlet.workflow_instances.view_workflow_instances_jspf");%>