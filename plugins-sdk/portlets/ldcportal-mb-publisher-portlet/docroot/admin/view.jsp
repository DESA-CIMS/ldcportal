<%--
/**
 *
 * Message Boards Publisher portlet
 * United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal 
 * 
 * @author Thibault Boyeux (thibault.boyeux@gmail.com), 2012
 *
 * This is the view page for the admin portlet of the Message Boards Publisher
 * which is displayed in "My Dashboard" / Control Panel.
 * 
 * It simply shows all the messages posted by the user.
 *
 */
--%>

<%@include file="/admin/init.jsp"%>

<liferay-ui:header title="my-posts" />

<liferay-ui:search-container
	emptyResultsMessage="you-do-not-have-any-posts" delta="20">
	<liferay-ui:search-container-results>
		<%
			//
					DynamicQuery dynamicQuery =
						DynamicQueryFactoryUtil.forClass(MBMessage.class, classLoader).add(
							PropertyFactoryUtil.forName("status").eq(new Integer(WorkflowConstants.STATUS_APPROVED))).add(
							PropertyFactoryUtil.forName("userId").eq(user.getUserId()));
				
					Criterion criterion = RestrictionsFactoryUtil.ne("categoryId", new Long(-1));
					criterion = RestrictionsFactoryUtil.or(criterion, RestrictionsFactoryUtil.ne("parentMessageId", new Long(0)));
					
					dynamicQuery.add(criterion);

					// 							PropertyFactoryUtil.forName("parentMessageId").ne(new Long(0))).add(
					// 							PropertyFactoryUtil.forName("categoryId").ne(new Long(-1)));

					// Get all the users' message for the Search Container
					results =
						MBMessageLocalServiceUtil.dynamicQuery(
							dynamicQuery, searchContainer.getStart(), searchContainer.getEnd(), new MessageCreateDateComparator(false));

					total = (int) MBMessageLocalServiceUtil.dynamicQueryCount(dynamicQuery);

					pageContext.setAttribute("results", results);
					pageContext.setAttribute("total", total);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.liferay.portlet.messageboards.model.MBMessage"
		keyProperty="messageId" modelVar="message">

		<%
			message = message.toEscapedModel();

					row.setRestricted(!MBMessagePermissionClp.contains(permissionChecker, message, ActionKeys.VIEW));
		%>

		<%
			// Generate URL to view message
					LiferayPortletURL rowURL = PortletURLFactoryUtil.create(request, "19", plid, PortletRequest.RENDER_PHASE);
					rowURL.setPortletMode(PortletMode.VIEW);
					rowURL.setParameter("struts_action", "/message_boards/view_message");
					rowURL.setParameter("messageId", String.valueOf(message.getMessageId()));
		%>

		<liferay-ui:search-container-column-text href="<%= rowURL %>"
			name="subject" value="<%= String.valueOf(message.getSubject()) %>" />

		<liferay-ui:search-container-column-text href="<%= rowURL %>"
			name="thread"
			value="<%= MBMessageLocalServiceUtil.getMBMessage(message.getRootMessageId()).getSubject() %>" />

		<liferay-ui:search-container-column-text href="<%= rowURL %>"
			buffer="buffer" name="create-date">

			<%
				//
												buffer.append(LanguageUtil.get(pageContext, "date"));
												buffer.append(": ");
												buffer.append(dateFormatDateTime.format(message.getCreateDate()));
			%>

		</liferay-ui:search-container-column-text>

	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator />
</liferay-ui:search-container>

<%!private static Log _log = LogFactoryUtil.getLog("mb_publisher.docroot.admin.view_jsp");%>
