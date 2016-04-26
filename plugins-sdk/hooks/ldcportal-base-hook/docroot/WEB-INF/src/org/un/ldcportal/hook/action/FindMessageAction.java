
package org.un.ldcportal.hook.action;

import javax.portlet.PortletMode;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowState;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.un.ldcportal.ismapplications.model.ISM;
import org.un.ldcportal.ismapplications.service.ISMLocalServiceUtil;

import com.liferay.portal.NoSuchLayoutException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.struts.BaseStrutsAction;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutConstants;
import com.liferay.portal.model.LayoutTypePortlet;
import com.liferay.portal.service.LayoutLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.messageboards.model.MBMessage;
import com.liferay.portlet.messageboards.service.MBMessageLocalServiceUtil;

public class FindMessageAction extends BaseStrutsAction {

	public FindMessageAction() {

		_portletIds = initPortletIds();

		if ((_portletIds == null) || (_portletIds.length == 0)) {
			throw new RuntimeException("Portlet IDs cannot be null or empty");
		}
	}

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		try {
			long plid = ParamUtil.getLong(request, "p_l_id");
			long primaryKey = ParamUtil.getLong(request, getPrimaryKeyParameterName());

			MBMessage message = MBMessageLocalServiceUtil.getMessage(primaryKey);

			Object[] plidAndPortletId = getPlidAndPortletId(request, plid, primaryKey);

			plid = (Long) plidAndPortletId[0];

			String portletId = (String) plidAndPortletId[1];

			PortletURL portletURL = PortletURLFactoryUtil.create(request, portletId, plid, PortletRequest.RENDER_PHASE);

			portletURL.setParameter("struts_action", getStrutsAction(request, portletId));

			String redirect = ParamUtil.getString(request, "redirect");

			if (Validator.isNotNull(redirect)) {
				portletURL.setParameter("redirect", redirect);
			}

			setPrimaryKeyParameter(portletURL, primaryKey);

			portletURL.setPortletMode(PortletMode.VIEW);
			portletURL.setWindowState(WindowState.NORMAL);

			portletURL = processPortletURL(request, portletURL);

			String portletURLString = portletURL.toString();

			ISM ism = null;

			try {
				ism = ISMLocalServiceUtil.getISMByMBCategoryId(message.getCategoryId()).get(0);
			}
			catch (IndexOutOfBoundsException e) {

			}

			if (ism != null) {
				portletURLString = HttpUtil.setParameter(portletURLString, "ismKey", ism.getIsmId());
				portletURLString = HttpUtil.setParameter(portletURLString, "messageId", message.getMessageId());
			}

			response.sendRedirect(portletURLString);

			return null;
		}
		catch (Exception e) {
			String noSuchEntryRedirect = ParamUtil.getString(request, "noSuchEntryRedirect");

			if (Validator.isNotNull(noSuchEntryRedirect) && (e instanceof NoSuchLayoutException)) {

				response.sendRedirect(noSuchEntryRedirect);
			}
			else {
				PortalUtil.sendError(e, request, response);
			}

			return null;
		}
	}

	protected Object[] getPlidAndPortletId(HttpServletRequest request, long plid, long primaryKey)
		throws Exception {

		if (plid != LayoutConstants.DEFAULT_PLID) {
			try {
				Layout layout = LayoutLocalServiceUtil.getLayout(plid);

				LayoutTypePortlet layoutTypePortlet = (LayoutTypePortlet) layout.getLayoutType();

				for (String portletId : _portletIds) {
					if (layoutTypePortlet.hasPortletId(portletId)) {
						return new Object[] {
							plid, portletId
						};
					}
				}
			}
			catch (NoSuchLayoutException nsle) {
			}
		}

		long groupId = 0;

		if (primaryKey > 0) {
			try {
				groupId = getGroupId(primaryKey);
			}
			catch (Exception e) {
				if (_log.isDebugEnabled()) {
					_log.debug(e, e);
				}
			}
		}

		if (groupId <= 0) {
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

			groupId = themeDisplay.getScopeGroupId();
		}

		for (String portletId : _portletIds) {
			plid = PortalUtil.getPlidFromPortletId(groupId, portletId);

			if (plid != LayoutConstants.DEFAULT_PLID) {
				return new Object[] {
					plid, portletId
				};
			}
		}

		throw new NoSuchLayoutException();
	}

	protected PortletURL processPortletURL(HttpServletRequest request, PortletURL portletURL)
		throws Exception {

		return portletURL;
	}

	protected void setPrimaryKeyParameter(PortletURL portletURL, long primaryKey)
		throws Exception {

		portletURL.setParameter(getPrimaryKeyParameterName(), String.valueOf(primaryKey));
	}

	protected long getGroupId(long primaryKey)
		throws Exception {

		MBMessage message = MBMessageLocalServiceUtil.getMessage(primaryKey);

		return message.getGroupId();
	}

	protected String getPrimaryKeyParameterName() {

		return "messageId";
	}

	protected String getStrutsAction(HttpServletRequest request, String portletId) {

		if (portletId.equals(PortletKeys.MESSAGE_BOARDS_ADMIN)) {
			return "/message_boards_admin/view_message";
		}
		else {
			return "/message_boards/view_message";
		}
	}

	protected String[] initPortletIds() {

		// Order is important. See LPS-23770.

		return new String[] {
			PortletKeys.MESSAGE_BOARDS_ADMIN, PortletKeys.MESSAGE_BOARDS
		};
	}

	private static Log _log = LogFactoryUtil.getLog(FindMessageAction.class);

	private String[] _portletIds;

}
