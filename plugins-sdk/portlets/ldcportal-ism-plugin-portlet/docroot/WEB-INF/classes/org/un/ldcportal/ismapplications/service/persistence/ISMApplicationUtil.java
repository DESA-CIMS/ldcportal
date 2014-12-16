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

package org.un.ldcportal.ismapplications.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.un.ldcportal.ismapplications.model.ISMApplication;

import java.util.List;

/**
 * The persistence utility for the i s m application service. This utility wraps {@link ISMApplicationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Thibault Boyeux
 * @see ISMApplicationPersistence
 * @see ISMApplicationPersistenceImpl
 * @generated
 */
public class ISMApplicationUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(ISMApplication ismApplication) {
		getPersistence().clearCache(ismApplication);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ISMApplication> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ISMApplication> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ISMApplication> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ISMApplication update(ISMApplication ismApplication,
		boolean merge) throws SystemException {
		return getPersistence().update(ismApplication, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ISMApplication update(ISMApplication ismApplication,
		boolean merge, ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(ismApplication, merge, serviceContext);
	}

	/**
	* Caches the i s m application in the entity cache if it is enabled.
	*
	* @param ismApplication the i s m application
	*/
	public static void cacheResult(
		org.un.ldcportal.ismapplications.model.ISMApplication ismApplication) {
		getPersistence().cacheResult(ismApplication);
	}

	/**
	* Caches the i s m applications in the entity cache if it is enabled.
	*
	* @param ismApplications the i s m applications
	*/
	public static void cacheResult(
		java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> ismApplications) {
		getPersistence().cacheResult(ismApplications);
	}

	/**
	* Creates a new i s m application with the primary key. Does not add the i s m application to the database.
	*
	* @param ismApplicationId the primary key for the new i s m application
	* @return the new i s m application
	*/
	public static org.un.ldcportal.ismapplications.model.ISMApplication create(
		long ismApplicationId) {
		return getPersistence().create(ismApplicationId);
	}

	/**
	* Removes the i s m application with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ismApplicationId the primary key of the i s m application
	* @return the i s m application that was removed
	* @throws org.un.ldcportal.ismapplications.NoSuchApplicationException if a i s m application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISMApplication remove(
		long ismApplicationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchApplicationException {
		return getPersistence().remove(ismApplicationId);
	}

	public static org.un.ldcportal.ismapplications.model.ISMApplication updateImpl(
		org.un.ldcportal.ismapplications.model.ISMApplication ismApplication,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(ismApplication, merge);
	}

	/**
	* Returns the i s m application with the primary key or throws a {@link org.un.ldcportal.ismapplications.NoSuchApplicationException} if it could not be found.
	*
	* @param ismApplicationId the primary key of the i s m application
	* @return the i s m application
	* @throws org.un.ldcportal.ismapplications.NoSuchApplicationException if a i s m application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISMApplication findByPrimaryKey(
		long ismApplicationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchApplicationException {
		return getPersistence().findByPrimaryKey(ismApplicationId);
	}

	/**
	* Returns the i s m application with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ismApplicationId the primary key of the i s m application
	* @return the i s m application, or <code>null</code> if a i s m application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISMApplication fetchByPrimaryKey(
		long ismApplicationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(ismApplicationId);
	}

	/**
	* Returns all the i s m applications where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching i s m applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the i s m applications where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of i s m applications
	* @param end the upper bound of the range of i s m applications (not inclusive)
	* @return the range of matching i s m applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the i s m applications where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of i s m applications
	* @param end the upper bound of the range of i s m applications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i s m applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first i s m application in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i s m application
	* @throws org.un.ldcportal.ismapplications.NoSuchApplicationException if a matching i s m application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISMApplication findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchApplicationException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last i s m application in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i s m application
	* @throws org.un.ldcportal.ismapplications.NoSuchApplicationException if a matching i s m application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISMApplication findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchApplicationException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the i s m applications before and after the current i s m application in the ordered set where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ismApplicationId the primary key of the current i s m application
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i s m application
	* @throws org.un.ldcportal.ismapplications.NoSuchApplicationException if a i s m application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISMApplication[] findByUuid_PrevAndNext(
		long ismApplicationId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchApplicationException {
		return getPersistence()
				   .findByUuid_PrevAndNext(ismApplicationId, uuid,
			orderByComparator);
	}

	/**
	* Returns the i s m application where uuid = &#63; and groupId = &#63; or throws a {@link org.un.ldcportal.ismapplications.NoSuchApplicationException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching i s m application
	* @throws org.un.ldcportal.ismapplications.NoSuchApplicationException if a matching i s m application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISMApplication findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchApplicationException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the i s m application where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching i s m application, or <code>null</code> if a matching i s m application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISMApplication fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the i s m application where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching i s m application, or <code>null</code> if a matching i s m application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISMApplication fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Returns all the i s m applications where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching i s m applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the i s m applications where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of i s m applications
	* @param end the upper bound of the range of i s m applications (not inclusive)
	* @return the range of matching i s m applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the i s m applications where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of i s m applications
	* @param end the upper bound of the range of i s m applications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i s m applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first i s m application in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i s m application
	* @throws org.un.ldcportal.ismapplications.NoSuchApplicationException if a matching i s m application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISMApplication findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchApplicationException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last i s m application in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i s m application
	* @throws org.un.ldcportal.ismapplications.NoSuchApplicationException if a matching i s m application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISMApplication findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchApplicationException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the i s m applications before and after the current i s m application in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ismApplicationId the primary key of the current i s m application
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i s m application
	* @throws org.un.ldcportal.ismapplications.NoSuchApplicationException if a i s m application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISMApplication[] findByGroupId_PrevAndNext(
		long ismApplicationId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchApplicationException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(ismApplicationId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the i s m applications that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching i s m applications that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	* Returns a range of all the i s m applications that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of i s m applications
	* @param end the upper bound of the range of i s m applications (not inclusive)
	* @return the range of matching i s m applications that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the i s m applications that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of i s m applications
	* @param end the upper bound of the range of i s m applications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i s m applications that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the i s m applications before and after the current i s m application in the ordered set of i s m applications that the user has permission to view where groupId = &#63;.
	*
	* @param ismApplicationId the primary key of the current i s m application
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i s m application
	* @throws org.un.ldcportal.ismapplications.NoSuchApplicationException if a i s m application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISMApplication[] filterFindByGroupId_PrevAndNext(
		long ismApplicationId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchApplicationException {
		return getPersistence()
				   .filterFindByGroupId_PrevAndNext(ismApplicationId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the i s m applications where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching i s m applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
	}

	/**
	* Returns a range of all the i s m applications where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of i s m applications
	* @param end the upper bound of the range of i s m applications (not inclusive)
	* @return the range of matching i s m applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

	/**
	* Returns an ordered range of all the i s m applications where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of i s m applications
	* @param end the upper bound of the range of i s m applications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i s m applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first i s m application in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i s m application
	* @throws org.un.ldcportal.ismapplications.NoSuchApplicationException if a matching i s m application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISMApplication findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchApplicationException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last i s m application in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i s m application
	* @throws org.un.ldcportal.ismapplications.NoSuchApplicationException if a matching i s m application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISMApplication findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchApplicationException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the i s m applications before and after the current i s m application in the ordered set where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ismApplicationId the primary key of the current i s m application
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i s m application
	* @throws org.un.ldcportal.ismapplications.NoSuchApplicationException if a i s m application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISMApplication[] findByCompanyId_PrevAndNext(
		long ismApplicationId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchApplicationException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(ismApplicationId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the i s m applications where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching i s m applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> findByG_S(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_S(groupId, status);
	}

	/**
	* Returns a range of all the i s m applications where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of i s m applications
	* @param end the upper bound of the range of i s m applications (not inclusive)
	* @return the range of matching i s m applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> findByG_S(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_S(groupId, status, start, end);
	}

	/**
	* Returns an ordered range of all the i s m applications where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of i s m applications
	* @param end the upper bound of the range of i s m applications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i s m applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_S(groupId, status, start, end, orderByComparator);
	}

	/**
	* Returns the first i s m application in the ordered set where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i s m application
	* @throws org.un.ldcportal.ismapplications.NoSuchApplicationException if a matching i s m application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISMApplication findByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchApplicationException {
		return getPersistence()
				   .findByG_S_First(groupId, status, orderByComparator);
	}

	/**
	* Returns the last i s m application in the ordered set where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i s m application
	* @throws org.un.ldcportal.ismapplications.NoSuchApplicationException if a matching i s m application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISMApplication findByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchApplicationException {
		return getPersistence()
				   .findByG_S_Last(groupId, status, orderByComparator);
	}

	/**
	* Returns the i s m applications before and after the current i s m application in the ordered set where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ismApplicationId the primary key of the current i s m application
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i s m application
	* @throws org.un.ldcportal.ismapplications.NoSuchApplicationException if a i s m application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISMApplication[] findByG_S_PrevAndNext(
		long ismApplicationId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchApplicationException {
		return getPersistence()
				   .findByG_S_PrevAndNext(ismApplicationId, groupId, status,
			orderByComparator);
	}

	/**
	* Returns all the i s m applications that the user has permission to view where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching i s m applications that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> filterFindByG_S(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_S(groupId, status);
	}

	/**
	* Returns a range of all the i s m applications that the user has permission to view where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of i s m applications
	* @param end the upper bound of the range of i s m applications (not inclusive)
	* @return the range of matching i s m applications that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> filterFindByG_S(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_S(groupId, status, start, end);
	}

	/**
	* Returns an ordered range of all the i s m applications that the user has permissions to view where groupId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param status the status
	* @param start the lower bound of the range of i s m applications
	* @param end the upper bound of the range of i s m applications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i s m applications that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> filterFindByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_S(groupId, status, start, end,
			orderByComparator);
	}

	/**
	* Returns the i s m applications before and after the current i s m application in the ordered set of i s m applications that the user has permission to view where groupId = &#63; and status = &#63;.
	*
	* @param ismApplicationId the primary key of the current i s m application
	* @param groupId the group ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i s m application
	* @throws org.un.ldcportal.ismapplications.NoSuchApplicationException if a i s m application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISMApplication[] filterFindByG_S_PrevAndNext(
		long ismApplicationId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchApplicationException {
		return getPersistence()
				   .filterFindByG_S_PrevAndNext(ismApplicationId, groupId,
			status, orderByComparator);
	}

	/**
	* Returns all the i s m applications.
	*
	* @return the i s m applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the i s m applications.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of i s m applications
	* @param end the upper bound of the range of i s m applications (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of i s m applications
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the i s m applications where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Removes the i s m application where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchApplicationException {
		getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Removes all the i s m applications where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Removes all the i s m applications where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Removes all the i s m applications where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_S(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_S(groupId, status);
	}

	/**
	* Removes all the i s m applications from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of i s m applications where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching i s m applications
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the number of i s m applications where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching i s m applications
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of i s m applications where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching i s m applications
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of i s m applications that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching i s m applications that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Returns the number of i s m applications where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching i s m applications
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns the number of i s m applications where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching i s m applications
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_S(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_S(groupId, status);
	}

	/**
	* Returns the number of i s m applications that the user has permission to view where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching i s m applications that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_S(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_S(groupId, status);
	}

	/**
	* Returns the number of i s m applications.
	*
	* @return the number of i s m applications
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ISMApplicationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ISMApplicationPersistence)PortletBeanLocatorUtil.locate(org.un.ldcportal.ismapplications.service.ClpSerializer.getServletContextName(),
					ISMApplicationPersistence.class.getName());

			ReferenceRegistry.registerReference(ISMApplicationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(ISMApplicationPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(ISMApplicationUtil.class,
			"_persistence");
	}

	private static ISMApplicationPersistence _persistence;
}