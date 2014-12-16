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
 * The utility for the i s m local service. This utility wraps {@link org.un.ldcportal.ismapplications.service.impl.ISMLocalServiceImpl} and is the primary access point for service operations in application layer code running on the local server.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Thibault Boyeux
 * @see ISMLocalService
 * @see org.un.ldcportal.ismapplications.service.base.ISMLocalServiceBaseImpl
 * @see org.un.ldcportal.ismapplications.service.impl.ISMLocalServiceImpl
 * @generated
 */
public class ISMLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link org.un.ldcportal.ismapplications.service.impl.ISMLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Adds the i s m to the database. Also notifies the appropriate model listeners.
	*
	* @param ism the i s m
	* @return the i s m that was added
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISM addISM(
		org.un.ldcportal.ismapplications.model.ISM ism)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().addISM(ism);
	}

	/**
	* Creates a new i s m with the primary key. Does not add the i s m to the database.
	*
	* @param ismId the primary key for the new i s m
	* @return the new i s m
	*/
	public static org.un.ldcportal.ismapplications.model.ISM createISM(
		long ismId) {
		return getService().createISM(ismId);
	}

	/**
	* Deletes the i s m with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ismId the primary key of the i s m
	* @throws PortalException if a i s m with the primary key could not be found
	* @throws SystemException if a system exception occurred
	* @throws org.un.ldcportal.ismapplications.NoSuchISMException
	*/
	public static void deleteISM(long ismId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException {
		getService().deleteISM(ismId);
	}

	/**
	* Deletes the i s m from the database. Also notifies the appropriate model listeners.
	*
	* @param ism the i s m
	* @throws PortalException
	* @throws SystemException if a system exception occurred
	*/
	public static void deleteISM(org.un.ldcportal.ismapplications.model.ISM ism)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteISM(ism);
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

	public static org.un.ldcportal.ismapplications.model.ISM fetchISM(
		long ismId) throws com.liferay.portal.kernel.exception.SystemException {
		return getService().fetchISM(ismId);
	}

	/**
	* Returns the i s m with the primary key.
	*
	* @param ismId the primary key of the i s m
	* @return the i s m
	* @throws PortalException if a i s m with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISM getISM(long ismId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getISM(ismId);
	}

	public static com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the i s ms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of i s ms
	* @param end the upper bound of the range of i s ms (not inclusive)
	* @return the range of i s ms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISM> getISMs(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getISMs(start, end);
	}

	/**
	* Returns the number of i s ms.
	*
	* @return the number of i s ms
	* @throws SystemException if a system exception occurred
	*/
	public static int getISMsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getISMsCount();
	}

	/**
	* Updates the i s m in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ism the i s m
	* @return the i s m that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISM updateISM(
		org.un.ldcportal.ismapplications.model.ISM ism)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateISM(ism);
	}

	/**
	* Updates the i s m in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ism the i s m
	* @param merge whether to merge the i s m with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the i s m that was updated
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISM updateISM(
		org.un.ldcportal.ismapplications.model.ISM ism, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().updateISM(ism, merge);
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

	public static org.un.ldcportal.ismapplications.model.ISM addNewISM(
		org.un.ldcportal.ismapplications.model.ISM newISM)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addNewISM(newISM);
	}

	public static java.util.List<org.un.ldcportal.ismapplications.model.ISM> getAllISMs(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getAllISMs(groupId);
	}

	public static org.un.ldcportal.ismapplications.model.ISM getISMByWebContentId(
		long webContentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getISMByWebContentId(webContentId);
	}

	public static org.un.ldcportal.ismapplications.model.ISM getISM(
		long groupId, long ismId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getISM(groupId, ismId);
	}

	public static java.util.List<org.un.ldcportal.ismapplications.model.ISM> getISMByMBCategoryId(
		long mbCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().getISMByMBCategoryId(mbCategoryId);
	}

	public static boolean ismExistsByWebContendId(long webContentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().ismExistsByWebContendId(webContentId);
	}

	public static boolean ismExistsByMBCategoryId(long mbCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService().ismExistsByMBCategoryId(mbCategoryId);
	}

	public static void clearService() {
		_service = null;
	}

	public static ISMLocalService getService() {
		if (_service == null) {
			Object object = PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					ISMLocalService.class.getName());
			ClassLoader portletClassLoader = (ClassLoader)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					"portletClassLoader");

			ClassLoaderProxy classLoaderProxy = new ClassLoaderProxy(object,
					ISMLocalService.class.getName(), portletClassLoader);

			_service = new ISMLocalServiceClp(classLoaderProxy);

			ClpSerializer.setClassLoader(portletClassLoader);

			ReferenceRegistry.registerReference(ISMLocalServiceUtil.class,
				"_service");
			MethodCache.remove(ISMLocalService.class);
		}

		return _service;
	}

	public void setService(ISMLocalService service) {
		MethodCache.remove(ISMLocalService.class);

		_service = service;

		ReferenceRegistry.registerReference(ISMLocalServiceUtil.class,
			"_service");
		MethodCache.remove(ISMLocalService.class);
	}

	private static ISMLocalService _service;
}