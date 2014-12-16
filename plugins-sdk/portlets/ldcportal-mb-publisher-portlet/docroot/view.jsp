<%--
/**
 *
 * Message Boards Publisher portlet
 * United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal 
 * 
 * @author Thibault Boyeux (thibault.boyeux@gmail.com), 2012
 * 
 * Used to display the "abstracts" display style for messages
 * (much inspired from Liferay's Asset Publisher abstracts display style)
 *
 */
--%>

<%@include file="/init.jsp"%>

<%
	if (readMoreLink) {
		if (isMaximized) {
			delta = deltaMaximized;
		}
		else {
			paginationType = "none";
		}
	}

	PortletURL portletURL = renderResponse.createRenderURL();

	SearchContainer searchContainer =
		new SearchContainer(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, delta, portletURL, null, null);

	if (!paginationType.equals("none")) {
		searchContainer.setDelta(delta);
		searchContainer.setDeltaConfigurable(false);
	}

	List<MBThread> results = new ArrayList<MBThread>();
	int total = 0;

	// Display messages from a specific category only
	if (displayMessages.equals("category-messages-only")) {
		DynamicQuery dynamicQuery =
			DynamicQueryFactoryUtil.forClass(MBThread.class, classLoader).add(
				PropertyFactoryUtil.forName("groupId").in(groupIdsList)).add(
				PropertyFactoryUtil.forName("companyId").eq(new Long(company.getCompanyId()))).add(
				PropertyFactoryUtil.forName("categoryId").eq(new Long(categoryId))).add(
				PropertyFactoryUtil.forName("categoryId").ne(new Long(-1))).add(
				PropertyFactoryUtil.forName("status").eq(new Integer(WorkflowConstants.STATUS_APPROVED)));

		results =
			MBThreadLocalServiceUtil.dynamicQuery(
				dynamicQuery, searchContainer.getStart(), searchContainer.getEnd(), new ThreadLastPostDateComparator());

		total = (int) MBThreadLocalServiceUtil.dynamicQueryCount(dynamicQuery);
	}
	// Display all messages within a scope
	else if (displayMessages.equals("all-boards-messages")) {
		DynamicQuery dynamicQuery =
			DynamicQueryFactoryUtil.forClass(MBThread.class, classLoader).add(
				PropertyFactoryUtil.forName("groupId").in(groupIdsList)).add(
				PropertyFactoryUtil.forName("companyId").eq(new Long(company.getCompanyId()))).add(
				PropertyFactoryUtil.forName("categoryId").ne(new Long(-1))).add(
				PropertyFactoryUtil.forName("status").eq(new Integer(WorkflowConstants.STATUS_APPROVED)));

		results =
			MBThreadLocalServiceUtil.dynamicQuery(
				dynamicQuery, searchContainer.getStart(), searchContainer.getEnd(), new ThreadLastPostDateComparator());

		total = (int) MBThreadLocalServiceUtil.dynamicQueryCount(dynamicQuery);
	}
	// Display all messages from a category and its subcategories
	else if (displayMessages.equals("categories-and-subcategories-messages")) {
		List<Object> categoryList = new ArrayList<Object>();
		categoryList.add(new Long(categoryId));
		categoryList.addAll(MBCategoryLocalServiceUtil.getSubcategoryIds(
			new ArrayList<Long>(Arrays.asList(new Long(categoryId))), scopeGroupId, categoryId));

		DynamicQuery dynamicQuery =
			DynamicQueryFactoryUtil.forClass(MBThread.class, classLoader).add(
				PropertyFactoryUtil.forName("groupId").in(groupIdsList)).add(
				PropertyFactoryUtil.forName("companyId").eq(new Long(company.getCompanyId()))).add(
				PropertyFactoryUtil.forName("categoryId").ne(new Long(-1))).add(
				PropertyFactoryUtil.forName("categoryId").in(categoryList)).add(
				PropertyFactoryUtil.forName("status").eq(new Integer(WorkflowConstants.STATUS_APPROVED)));

		results =
			MBThreadLocalServiceUtil.dynamicQuery(
				dynamicQuery, searchContainer.getStart(), searchContainer.getEnd(), new ThreadLastPostDateComparator());

		total = (int) MBThreadLocalServiceUtil.dynamicQueryCount(dynamicQuery);
	}
	// Listen for an ISM, i.e get all messages from the  category related to the ISM in the "ISM Plugin Admin" portlet
	else if (displayMessages.equals("listen-for-ism")) {

		// Get ISM and ISm-related objects

		AssetEntry layoutAssetEntry = (AssetEntry) request.getAttribute("LAYOUT_ASSET_ENTRY");

		ISM ism = null;

		long messageId = GetterUtil.DEFAULT_LONG;

		if (layoutAssetEntry != null) {
			ism = ISMLocalServiceUtil.getISMByWebContentId(layoutAssetEntry.getEntryId());
			ismKey = ism.getIsmId();
		}
		else {
			// Get Servlet request
			HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
			// Get ismKey from the URL (x in ?ismKey=x)
			if (ismKey == GetterUtil.DEFAULT_LONG) {
				ismKey = GetterUtil.getLong(httpRequest.getParameter("ismKey"));
			}
			// Get the messageId from the URL. This is used to prevent the same message being displayed twice 
			// when the user is seeing a specific message in the Message Boards Portlet.
			messageId = GetterUtil.getLong(httpRequest.getParameter("messageId"));

			ism = ISMLocalServiceUtil.getISM(ismKey);
		}

		if (ism == null) {
			return;
		}

		AssetEntry assetEntry = AssetEntryLocalServiceUtil.getAssetEntry(ism.getWebContentId());
		long ismWebContentGroupId = assetEntry.getGroupId();

		if (ism != null) {
			// Generate the query to get the messages
			DynamicQuery dynamicQuery =
				DynamicQueryFactoryUtil.forClass(MBThread.class, classLoader).add(
					PropertyFactoryUtil.forName("groupId").eq(ismWebContentGroupId)).add(
					PropertyFactoryUtil.forName("companyId").eq(new Long(company.getCompanyId()))).add(
					PropertyFactoryUtil.forName("categoryId").eq(new Long(ism.getMbCategoryId()))).add(
					PropertyFactoryUtil.forName("categoryId").ne(new Long(-1))).add(
					PropertyFactoryUtil.forName("rootMessageId").ne(new Long(messageId))).add(
					PropertyFactoryUtil.forName("status").eq(new Integer(WorkflowConstants.STATUS_APPROVED)));

			// Get all messages
			results =
				MBThreadLocalServiceUtil.dynamicQuery(
					dynamicQuery, searchContainer.getStart(), searchContainer.getEnd(), new ThreadLastPostDateComparator());

			total = (int) MBThreadLocalServiceUtil.dynamicQueryCount(dynamicQuery);

		}
	}

	searchContainer.setTotal(total);

	if (!results.isEmpty()) {
		searchContainer.setResults(results);

		for (int mbThreadIndex = 0; mbThreadIndex < results.size(); mbThreadIndex++) {
			MBThread mbThread = (MBThread) results.get(mbThreadIndex);

			MBMessage mbMessage = null;

			try {
				mbMessage = MBMessageLocalServiceUtil.getMessage(mbThread.getRootMessageId());
			}
			catch (NoSuchMessageException nsme) {
				_log.error("Thread requires missing root message id " + mbThread.getRootMessageId());
			}

			mbMessage = mbMessage.toEscapedModel();

			AssetEntry assetEntry = null;

			try {
				assetEntry = AssetEntryLocalServiceUtil.getEntry(MBMessage.class.getName(), mbMessage.getMessageId());
			}
			catch (NoSuchEntryException nsee) {
				_log.error("Cannot acquire assetEntry from thread " + mbThread.getThreadId());
			}

			// Define the assetRenderer
			AssetRendererFactory assetRendererFactory =
				AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(MBMessage.class.getName());
			AssetRenderer assetRenderer = assetRendererFactory.getAssetRenderer(mbMessage.getMessageId());

			// Define the title
			String title = assetRenderer.getTitle(locale);

			request.setAttribute("view.jsp-results", results);
			request.setAttribute("view.jsp-title", title);
			request.setAttribute("view.jsp-mbMessage", mbMessage);
			request.setAttribute("view.jsp-mbThreadIndex", mbThreadIndex);
			request.setAttribute("view.jsp-assetEntry", assetEntry);
			request.setAttribute("view.jsp-assetRendererFactory", assetRendererFactory);
			request.setAttribute("view.jsp-assetRenderer", assetRenderer);

			if (!ArrayUtil.contains(MBDisplayKeys.MB_PUBLISHER_DISPLAY_STYLES, displayStyle)) {
%>

<%=LanguageUtil.format(pageContext, "x-is-not-a-display-type", displayStyle)%>

<%
	//
			}
			else {
				for (String curDisplayStyle : MBDisplayKeys.MB_PUBLISHER_DISPLAY_STYLES) {

					if (displayStyle.equals(curDisplayStyle)) {
						String displayStyleJsp = "/" + TextFormatter.format(curDisplayStyle, TextFormatter.N) + ".jsp";
%>

<jsp:include page="<%= displayStyleJsp %>" />

<%
	break;
					}
				}
			}
		}

	}
%>

<%-- Generate "Read more" link, either maximizing the portlet or linking to a 
specific URL specified in the configuration page --%>
<c:if
	test="<%= readMoreLink && !isMaximized && searchContainer.getTotal() > delta %>">
	<liferay-portlet:renderURL windowState="maximized"
		varImpl="portletMaximizedURL">
		<liferay-portlet:param name="ismKey"
			value="<%= String.valueOf(ismKey) %>" />
	</liferay-portlet:renderURL>
	<div class="maximize-portlet">

		<%
			String readMoreURL = StringPool.BLANK;

				if (readMoreLinkType.equals("maximize")) {
					readMoreURL = portletMaximizedURL.toString();
				}
				else if (readMoreLinkType.equals("custom")) {
					readMoreURL = readMoreCustomURL;
				}
		%>

		<a href="<%=readMoreURL%>"> <%=LanguageUtil.get(pageContext, "more").toLowerCase()%>
			&raquo;
		</a>
	</div>
</c:if>

<c:if
	test='<%= !paginationType.equals("none") && (searchContainer.getTotal() > searchContainer.getResults().size()) %>'>
	<liferay-ui:search-paginator searchContainer="<%= searchContainer %>"
		type="<%= paginationType %>" />
</c:if>


<c:if test="<%=total == 0%>">
	<div class="portlet-msg-info">
		<liferay-ui:message
			key="there-is-currently-no-additional-information-available" />
	</div>
</c:if>




<%!private static Log _log = LogFactoryUtil.getLog("mb_publisher.docroot.view_jsp");%>



