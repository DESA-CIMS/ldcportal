
package org.un.ldcportal.hook.action;

import com.liferay.portal.kernel.captcha.CaptchaMaxChallengesException;
import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.servlet.BrowserSnifferUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.struts.BaseStrutsPortletAction;
import com.liferay.portal.kernel.struts.StrutsPortletAction;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Constants;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.JavaConstants;
import com.liferay.portal.kernel.util.ObjectValuePair;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StreamUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutTypePortlet;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.asset.AssetCategoryException;
import com.liferay.portlet.asset.AssetTagException;
import com.liferay.portlet.asset.model.BaseAssetRenderer;
import com.liferay.portlet.documentlibrary.FileExtensionException;
import com.liferay.portlet.documentlibrary.FileNameException;
import com.liferay.portlet.documentlibrary.FileSizeException;
import com.liferay.portlet.messageboards.LockedThreadException;
import com.liferay.portlet.messageboards.MessageBodyException;
import com.liferay.portlet.messageboards.MessageSubjectException;
import com.liferay.portlet.messageboards.NoSuchMessageException;
import com.liferay.portlet.messageboards.RequiredMessageException;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.model.MBMessageConstants;
import com.liferay.portlet.messageboards.service.MBMessageServiceUtil;
import com.liferay.portlet.messageboards.service.MBThreadLocalServiceUtil;
import com.liferay.portlet.messageboards.service.MBThreadServiceUtil;

import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 * @author Brian Wing Shun Chan
 * @author Daniel Sanz
 * @author Shuyang Zhou
 */
public class EditMessageAction extends BaseStrutsPortletAction {

	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		String cmd = ParamUtil.getString(actionRequest, Constants.CMD);
		try {
			MBMessage message = null;

			if (cmd.equals(Constants.ADD) || cmd.equals(Constants.UPDATE)) {
				message = updateMessage(actionRequest, actionResponse);
			}
			else if (cmd.equals(Constants.DELETE)) {
				deleteMessage(actionRequest);
			}
			else if (cmd.equals(Constants.LOCK)) {
				lockThreads(actionRequest);
			}
			else if (cmd.equals(Constants.SUBSCRIBE)) {
				subscribeMessage(actionRequest);
			}
			else if (cmd.equals(Constants.UNLOCK)) {
				unlockThreads(actionRequest);
			}
			else if (cmd.equals(Constants.UNSUBSCRIBE)) {
				unsubscribeMessage(actionRequest);
			}

			if (Validator.isNotNull(cmd)) {
				String redirect = getRedirect(actionRequest, actionResponse, message);

				sendRedirect(actionRequest, actionResponse, redirect);
			}
		}
		catch (Exception e) {
			if (e instanceof NoSuchMessageException || e instanceof PrincipalException || e instanceof RequiredMessageException) {

				SessionErrors.add(actionRequest, e.getClass().getName());

				setForward(actionRequest, "portlet.message_boards.error");
			}
			else if (e instanceof CaptchaMaxChallengesException || e instanceof CaptchaTextException ||
				e instanceof FileExtensionException || e instanceof FileNameException || e instanceof FileSizeException ||
				e instanceof LockedThreadException || e instanceof MessageBodyException || e instanceof MessageSubjectException) {

				SessionErrors.add(actionRequest, e.getClass().getName());
			}
			else if (e instanceof AssetCategoryException || e instanceof AssetTagException) {

				SessionErrors.add(actionRequest, e.getClass().getName(), e);
			}
			else {
				throw e;
			}
		}
	}

	@Override
	public String render(
		StrutsPortletAction originalStrutsPortletAction, PortletConfig portletConfig, RenderRequest renderRequest,
		RenderResponse renderResponse)
		throws Exception {

		return originalStrutsPortletAction.render(portletConfig, renderRequest, renderResponse);
	};

	protected void deleteMessage(ActionRequest actionRequest)
		throws Exception {

		long messageId = ParamUtil.getLong(actionRequest, "messageId");

		MBMessageServiceUtil.deleteMessage(messageId);
	}

	protected String getRedirect(ActionRequest actionRequest, ActionResponse actionResponse, MBMessage message)
		throws WindowStateException {

		if (message == null) {
			String redirect = ParamUtil.getString(actionRequest, "redirect");

			return redirect;
		}

		int workflowAction = ParamUtil.getInteger(actionRequest, "workflowAction", WorkflowConstants.ACTION_PUBLISH);

		if (workflowAction == WorkflowConstants.ACTION_SAVE_DRAFT) {
			return getSaveAndContinueRedirect(actionRequest, actionResponse, message);
		}
		else if (message == null) {
			return ParamUtil.getString(actionRequest, "redirect");
		}

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		StringBundler sb = new StringBundler(11);

		sb.append(themeDisplay.getPortalURL());
		sb.append(themeDisplay.getPathMain());
		sb.append("/message_boards/find_message");
		sb.append("?p_l_id=");
		sb.append(themeDisplay.getPlid());
		sb.append(StringPool.AMPERSAND);
		sb.append("messageId");
		sb.append(StringPool.EQUAL);
		sb.append(message.getMessageId());

		return sb.toString();
	}

	protected String getSaveAndContinueRedirect(ActionRequest actionRequest, ActionResponse actionResponse, MBMessage message)
		throws WindowStateException {

		String redirect = ParamUtil.getString(actionRequest, "redirect");

		boolean preview = ParamUtil.getBoolean(actionRequest, "preview");

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		Layout layout = themeDisplay.getLayout();

		PortletURL portletURL =
			PortletURLFactoryUtil.create(actionRequest, PortletKeys.MESSAGE_BOARDS, layout.getPlid(), PortletRequest.RENDER_PHASE);

		portletURL.setWindowState(WindowState.MAXIMIZED);
		portletURL.setParameter("struts_action", "/message_boards/edit_message");
		portletURL.setParameter("redirect", redirect);
		portletURL.setParameter("messageId", String.valueOf(message.getMessageId()));
		portletURL.setParameter("preview", String.valueOf(preview));
		
		return portletURL.toString();
	}

	protected void lockThreads(ActionRequest actionRequest)
		throws Exception {

		long threadId = ParamUtil.getLong(actionRequest, "threadId");

		if (threadId > 0) {
			MBThreadServiceUtil.lockThread(threadId);
		}
		else {
			long[] threadIds = StringUtil.split(ParamUtil.getString(actionRequest, "threadIds"), 0L);

			for (int i = 0; i < threadIds.length; i++) {
				MBThreadServiceUtil.lockThread(threadIds[i]);
			}
		}
	}

	protected void subscribeMessage(ActionRequest actionRequest)
		throws Exception {

		long messageId = ParamUtil.getLong(actionRequest, "messageId");

		MBMessageServiceUtil.subscribeMessage(messageId);
	}

	protected void unlockThreads(ActionRequest actionRequest)
		throws Exception {

		long threadId = ParamUtil.getLong(actionRequest, "threadId");

		if (threadId > 0) {
			MBThreadServiceUtil.unlockThread(threadId);
		}
		else {
			long[] threadIds = StringUtil.split(ParamUtil.getString(actionRequest, "threadIds"), 0L);

			for (int i = 0; i < threadIds.length; i++) {
				MBThreadServiceUtil.unlockThread(threadIds[i]);
			}
		}
	}

	protected void unsubscribeMessage(ActionRequest actionRequest)
		throws Exception {

		long messageId = ParamUtil.getLong(actionRequest, "messageId");

		MBMessageServiceUtil.unsubscribeMessage(messageId);
	}

	protected MBMessage updateMessage(ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {

		PortletPreferences preferences = actionRequest.getPreferences();

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

		long messageId = ParamUtil.getLong(actionRequest, "messageId");

		long groupId = themeDisplay.getScopeGroupId();
		long categoryId = ParamUtil.getLong(actionRequest, "mbCategoryId");
		long threadId = ParamUtil.getLong(actionRequest, "threadId");
		long parentMessageId = ParamUtil.getLong(actionRequest, "parentMessageId");
		String subject = ParamUtil.getString(actionRequest, "subject");
		String body = ParamUtil.getString(actionRequest, "body");

		String format = GetterUtil.getString(preferences.getValue("messageFormat", null), MBMessageConstants.DEFAULT_FORMAT);

		boolean attachments = ParamUtil.getBoolean(actionRequest, "attachments");

		List<ObjectValuePair<String, InputStream>> inputStreamOVPs = new ArrayList<ObjectValuePair<String, InputStream>>(5);

		try {
			if (attachments) {
				UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);

				for (int i = 1; i <= 5; i++) {
					String fileName = uploadPortletRequest.getFileName("msgFile" + i);
					InputStream inputStream = uploadPortletRequest.getFileAsStream("msgFile" + i);

					if (inputStream == null) {
						continue;
					}

					ObjectValuePair<String, InputStream> inputStreamOVP = new ObjectValuePair<String, InputStream>(fileName, inputStream);

					inputStreamOVPs.add(inputStreamOVP);
				}
			}

			boolean question = ParamUtil.getBoolean(actionRequest, "question");
			boolean anonymous = ParamUtil.getBoolean(actionRequest, "anonymous");
			double priority = ParamUtil.getDouble(actionRequest, "priority");
			boolean allowPingbacks = ParamUtil.getBoolean(actionRequest, "allowPingbacks");

			ServiceContext serviceContext = ServiceContextFactory.getInstance(MBMessage.class.getName(), actionRequest);

			boolean preview = ParamUtil.getBoolean(actionRequest, "preview");

			serviceContext.setAttribute("preview", preview);

			MBMessage message = null;

			if (messageId <= 0) {
				boolean propsValue = GetterUtil.getBoolean(PropsUtil.get(PropsKeys.CAPTCHA_CHECK_PORTLET_MESSAGE_BOARDS_EDIT_MESSAGE));

				if (propsValue) {

					CaptchaUtil.check(actionRequest);
				}

				if (threadId <= 0) {

					// Post new thread

					message =
						MBMessageServiceUtil.addMessage(
							groupId, categoryId, subject, body, format, inputStreamOVPs, anonymous, priority, allowPingbacks,
							serviceContext);

					if (question) {
						MBThreadLocalServiceUtil.updateQuestion(message.getThreadId(), true);
					}
				}
				else {

					// Post reply

					message =
						MBMessageServiceUtil.addMessage(
							groupId, categoryId, threadId, parentMessageId, subject, body, format, inputStreamOVPs, anonymous, priority,
							allowPingbacks, serviceContext);
				}
			}
			else {
				List<String> existingFiles = new ArrayList<String>();

				for (int i = 1; i <= 5; i++) {
					String path = ParamUtil.getString(actionRequest, "existingPath" + i);

					if (Validator.isNotNull(path)) {
						existingFiles.add(path);
					}
				}

				// Update message

				message =
					MBMessageServiceUtil.updateMessage(
						messageId, subject, body, inputStreamOVPs, existingFiles, priority, allowPingbacks, serviceContext);

				if (message.isRoot()) {
					MBThreadLocalServiceUtil.updateQuestion(message.getThreadId(), question);
				}
			}

			PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();

			boolean subscribe = ParamUtil.getBoolean(actionRequest, "subscribe");

			if (subscribe && MBMessagePermissionClp.contains(permissionChecker, message, ActionKeys.SUBSCRIBE)) {

				MBMessageServiceUtil.subscribeMessage(message.getMessageId());
			}

			return message;
		}
		finally {
			if (attachments) {
				for (ObjectValuePair<String, InputStream> inputStreamOVP : inputStreamOVPs) {

					InputStream inputStream = inputStreamOVP.getValue();

					StreamUtil.cleanUp(inputStream);
				}
			}
		}
	}

	protected void setForward(PortletRequest portletRequest, String forward) {

		portletRequest.setAttribute(getForwardKey(portletRequest), forward);
	}

	public static String getForwardKey(PortletRequest portletRequest) {

		String portletId = (String) portletRequest.getAttribute(WebKeys.PORTLET_ID);

		String portletNamespace = PortalUtil.getPortletNamespace(portletId);

		return portletNamespace.concat(WebKeys.PORTLET_STRUTS_FORWARD);
	}

	protected void sendRedirect(ActionRequest actionRequest, ActionResponse actionResponse, String redirect)
		throws IOException {

		if (SessionErrors.isEmpty(actionRequest)) {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

			LayoutTypePortlet layoutTypePortlet = themeDisplay.getLayoutTypePortlet();

			boolean hasPortletId = false;

			String portletId = (String) actionRequest.getAttribute(WebKeys.PORTLET_ID);

			try {
				hasPortletId = layoutTypePortlet.hasPortletId(portletId);
			}
			catch (Exception e) {
			}

			Portlet portlet = PortletLocalServiceUtil.getPortletById(portletId);

			if (hasPortletId || portlet.isAddDefaultResource()) {
				addSuccessMessage(actionRequest, actionResponse);
			}
		}

		if (Validator.isNull(redirect)) {
			redirect = (String) actionRequest.getAttribute(WebKeys.REDIRECT);
		}

		if (Validator.isNull(redirect)) {
			redirect = ParamUtil.getString(actionRequest, "redirect");
		}

		if (Validator.isNotNull(redirect)) {

			// LPS-1928

			HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);

			if ((BrowserSnifferUtil.isIe(request)) && (BrowserSnifferUtil.getMajorVersion(request) == 6.0) &&
				(redirect.contains(StringPool.POUND))) {

				String redirectToken = "&#";

				if (!redirect.contains(StringPool.QUESTION)) {
					redirectToken = StringPool.QUESTION + redirectToken;
				}

				redirect = StringUtil.replace(redirect, StringPool.POUND, redirectToken);
			}

			redirect = PortalUtil.escapeRedirect(redirect);

			if (Validator.isNotNull(redirect)) {
				actionResponse.sendRedirect(redirect);
			}
		}
	}

	protected void addSuccessMessage(ActionRequest actionRequest, ActionResponse actionResponse) {

		PortletConfig portletConfig = (PortletConfig) actionRequest.getAttribute(JavaConstants.JAVAX_PORTLET_CONFIG);

		boolean addProcessActionSuccessMessage =
			GetterUtil.getBoolean(portletConfig.getInitParameter("add-process-action-success-action"), true);

		if (!addProcessActionSuccessMessage) {
			return;
		}

		String successMessage = ParamUtil.getString(actionRequest, "successMessage");

		SessionMessages.add(actionRequest, "request_processed", successMessage);
	}

}
