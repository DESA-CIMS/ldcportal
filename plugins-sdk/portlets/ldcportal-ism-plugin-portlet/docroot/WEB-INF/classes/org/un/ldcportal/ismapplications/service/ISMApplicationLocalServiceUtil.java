/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package org.un.ldcportal.ismapplications.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ClassLoaderProxy;
import com.liferay.portal.kernel.util.MethodCache;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * The utility for the i s m application local service. This utility wraps {@link org.un.ldcportal.ismapplications.service.impl.ISMApplicationLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Thibault Boyeux
 * @see ISMApplicationLocalService
 * @see org.un.ldcportal.ismapplications.service.base.ISMApplicationLocalServiceBaseImpl
 * @see org.un.ldcportal.ismapplications.service.impl.ISMApplicationLocalServiceImpl
 * @generated
 */
public class ISMApplicationLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.un.ldcportal.ismapplications.service.impl.ISMApplicationLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the i s m application to the database. Also notifies the appropriate model listeners.
	*
	* @param ismApplication the i s m application
	* @return the i s m application that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISMApplication addISMApplication(
		org.un.ldcportal.ismapplications.model.ISMApplication ismApplication)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addISMApplication(ismApplication);
	}

	/**
	* Creates a new i s m application with the primary key. Does not add the i s m application to the database.
	*
	* @param ismApplicationId the primary key for the new i s m application
	* @return the new i s m application
	*/
	public static org.un.ldcportal.ismapplications.model.ISMApplication createISMApplication(
		long ismApplicationId) {
		return getService().createISMApplication(ismApplicationId);
	}

	/**
	* Deletes the i s m application with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ismApplicationId the primary key of the i s m application
	* @throws PortalException if a i s m application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteISMApplication(long ismApplicationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteISMApplication(ismApplicationId);
	}

	/**
	* Deletes the i s m application from the database. Also notifies the appropriate model listeners.
	*
	* @param ismApplication the i s m application
	* @throws PortalException
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteISMApplication(
		org.un.ldcportal.ismapplications.model.ISMApplication ismApplication)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteISMApplication(ismApplication);
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public static java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	public static org.un.ldcportal.ismapplications.model.ISMApplication fetchISMApplication(
		long ismApplicationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchISMApplication(ismApplicationId);
	}

	/**
	* Returns the i s m application with the primary key.
	*
	* @param ismApplicationId the primary key of the i s m application
	* @return the i s m application
	* @throws PortalException if a i s m application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISMApplication getISMApplication(
		long ismApplicationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getISMApplication(ismApplicationId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the i s m application with the UUID in the group.
	*
	* @param uuid the UUID of i s m application
	* @param groupId the group id of the i s m application
	* @return the i s m application
	* @throws PortalException if a i s m application with the UUID in the group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISMApplication getISMApplicationByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getISMApplicationByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns a range of all the i s m applications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of i s m applications
	* @param end the upper bound of the range of i s m applications (not inclusive)
	* @return the range of i s m applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> getISMApplications(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getISMApplications(start, end);
	}

	/**
	* Returns the number of i s m applications.
	*
	* @return the number of i s m applications
	* @throws SystemException if a system exception occurred
	*/
	public static int getISMApplicationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getISMApplicationsCount();
	}

	/**
	* Updates the i s m application in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ismApplication the i s m application
	* @return the i s m application that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISMApplication updateISMApplication(
		org.un.ldcportal.ismapplications.model.ISMApplication ismApplication)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateISMApplication(ismApplication);
	}

	/**
	* Updates the i s m application in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ismApplication the i s m application
	* @param merge whether to merge the i s m application with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the i s m application that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISMApplication updateISMApplication(
		org.un.ldcportal.ismapplications.model.ISMApplication ismApplication,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateISMApplication(ismApplication, merge);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static org.un.ldcportal.ismapplications.model.ISMApplication addISMApplication(
		org.un.ldcportal.ismapplications.model.ISMApplication newISMApplication,
		long userId, com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addISMApplication(newISMApplication, userId, serviceContext);
	}

	public static org.un.ldcportal.ismapplications.model.ISMApplication updateStatus(
		long userId, long resourcePrimKey, int status,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateStatus(userId, resourcePrimKey, status, serviceContext);
	}

	public static java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> getAllISMApplications(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllISMApplications(groupId);
	}

	public static java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> getByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByCompanyId(companyId);
	}

	public static java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> getByStatus(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getByStatus(groupId, status);
	}

	public static void clearService() {
		_service = null;
	}

	public static ISMApplicationLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ISMApplicationLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					ISMApplicationLocalService.class.getName(),
					portletClassLoader);

			_service = new ISMApplicationLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(ISMApplicationLocalServiceUtil.class,
				"_service");
			MethodCache.remove(ISMApplicationLocalService.class);
		}

		return _service;
	}

	public void setService(ISMApplicationLocalService service) {
		MethodCache.remove(ISMApplicationLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(ISMApplicationLocalServiceUtil.class,
			"_service");
		MethodCache.remove(ISMApplicationLocalService.class);
	}

	private static ISMApplicationLocalService _service;
}