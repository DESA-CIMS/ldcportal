package org.un.ldcportal.hook.service.impl;

import java.util.Date;

import com.liferay.portal.UserEmailAddressException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.util.Portal;
import com.liferay.portal.util.SubscriptionSender;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.CompanyLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.TicketLocalServiceUtil;
import com.liferay.portal.service.UserLocalService;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceWrapper;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.PasswordPolicy;
import com.liferay.portal.model.Ticket;
import com.liferay.portal.model.TicketConstants;
import com.liferay.portal.model.User;


public class HookUserLocalServiceImpl extends UserLocalServiceWrapper {

	public HookUserLocalServiceImpl(UserLocalService userLocalService) {

		super(userLocalService);
	}
	
	/**
	 * Sends the password email to the user with the email address. The content
	 * of this email can be specified in <code>portal.properties</code> with the
	 * <code>admin.email.password</code> keys.
	 *
	 * @param  companyId the primary key of the user's company
	 * @param  emailAddress the user's email address
	 * @param  fromName the name of the individual that the email should be from
	 * @param  fromAddress the address of the individual that the email should
	 *         be from
	 * @param  subject the email subject. If <code>null</code>, the subject
	 *         specified in <code>portal.properties</code> will be used.
	 * @param  body the email body. If <code>null</code>, the body specified in
	 *         <code>portal.properties</code> will be used.
	 * @param  serviceContext the user's service context
	 * @throws PortalException if a user with the email address could not be
	 *         found
	 * @throws SystemException if a system exception occurred
	 */
	
	public void sendPassword(
			long companyId, String emailAddress, String fromName,
			String fromAddress, String subject, String body,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		Company company = CompanyLocalServiceUtil.getCompany(companyId);

		if (!company.isSendPassword() && !company.isSendPasswordResetLink()) {
			return;
		}

		emailAddress = emailAddress.trim().toLowerCase();

		if (Validator.isNull(emailAddress)) {
			throw new UserEmailAddressException();
		}

		User user = UserLocalServiceUtil.getUserByEmailAddress(companyId, emailAddress);

		PasswordPolicy passwordPolicy = user.getPasswordPolicy();

		String newPassword = StringPool.BLANK;
		String passwordResetURL = StringPool.BLANK;

		if (company.isSendPasswordResetLink()) {
			Date expirationDate = new Date(
				System.currentTimeMillis() +
					(passwordPolicy.getResetTicketMaxAge() * 1000));

			Ticket ticket = TicketLocalServiceUtil.addTicket(
				companyId, User.class.getName(), user.getUserId(),
				TicketConstants.TYPE_PASSWORD, null, expirationDate,
				serviceContext);
			
			passwordResetURL =
				serviceContext.getPortalURL() + Portal.PATH_MAIN +
					"/portal/update_password?p_l_id="+
						serviceContext.getPlid() +
							"&ticketKey=" + ticket.getKey();
		}
		else {
			super.sendPassword(companyId, emailAddress, fromName, fromAddress, subject, body, serviceContext);
		}

		if (Validator.isNull(fromName)) {
			try {
				fromName = PrefsPropsUtil.getString(
					companyId, PropsKeys.ADMIN_EMAIL_FROM_NAME);
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		if (Validator.isNull(fromAddress)) {
			try {
				fromAddress = PrefsPropsUtil.getString(
					companyId, PropsKeys.ADMIN_EMAIL_FROM_ADDRESS);
			}
			catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		String toName = user.getFullName();
		String toAddress = user.getEmailAddress();

		if (Validator.isNull(subject)) {
			if (company.isSendPasswordResetLink()) {
				try {
					subject = PrefsPropsUtil.getString(
						companyId, PropsKeys.ADMIN_EMAIL_PASSWORD_RESET_SUBJECT);
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				try {
					subject = PrefsPropsUtil.getString(
						companyId, PropsKeys.ADMIN_EMAIL_PASSWORD_SENT_SUBJECT);
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		if (Validator.isNull(body)) {
			if (company.isSendPasswordResetLink()) {
				try {
					body = PrefsPropsUtil.getString(
						companyId, PropsKeys.ADMIN_EMAIL_PASSWORD_RESET_BODY);
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else {
				try {
					body = PrefsPropsUtil.getString(
						companyId, PropsKeys.ADMIN_EMAIL_PASSWORD_SENT_BODY);
				}
				catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		SubscriptionSender subscriptionSender = new SubscriptionSender();

		subscriptionSender.setBody(body);
		subscriptionSender.setCompanyId(companyId);
		subscriptionSender.setContextAttributes(
			"[$PASSWORD_RESET_URL$]", passwordResetURL, "[$REMOTE_ADDRESS$]",
			serviceContext.getRemoteAddr(), "[$REMOTE_HOST$]",
			serviceContext.getRemoteHost(), "[$USER_AGENT$]",
			serviceContext.getUserAgent(), "[$USER_ID$]", user.getUserId(),
			"[$USER_PASSWORD$]", newPassword, "[$USER_SCREENNAME$]",
			user.getScreenName());
		subscriptionSender.setFrom(fromAddress, fromName);
		subscriptionSender.setHtmlFormat(true);
		subscriptionSender.setMailId("user", user.getUserId());
		subscriptionSender.setServiceContext(serviceContext);
		subscriptionSender.setSubject(subject);
		subscriptionSender.setUserId(user.getUserId());

		subscriptionSender.addRuntimeSubscribers(toAddress, toName);

		subscriptionSender.flushNotificationsAsync();
	}
	
}
