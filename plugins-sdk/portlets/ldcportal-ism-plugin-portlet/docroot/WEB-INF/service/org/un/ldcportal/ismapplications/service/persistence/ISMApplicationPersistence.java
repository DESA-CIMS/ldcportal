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

import com.liferay.portal.service.persistence.BasePersistence;

import org.un.ldcportal.ismapplications.model.ISMApplication;

/**
 * The persistence interface for the i s m application service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Thibault Boyeux
 * @see ISMApplicationPersistenceImpl
 * @see ISMApplicationUtil
 * @generated
 */
public interface ISMApplicationPersistence extends BasePersistence<ISMApplication> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ISMApplicationUtil} to access the i s m application persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the i s m application in the entity cache if it is enabled.
	*
	* @param ismApplication the i s m application
	*/
	public void cacheResult(
		org.un.ldcportal.ismapplications.model.ISMApplication ismApplication);

	/**
	* Caches the i s m applications in the entity cache if it is enabled.
	*
	* @param ismApplications the i s m applications
	*/
	public void cacheResult(
		java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> ismApplications);

	/**
	* Creates a new i s m application with the primary key. Does not add the i s m application to the database.
	*
	* @param ismApplicationId the primary key for the new i s m application
	* @return the new i s m application
	*/
	public org.un.ldcportal.ismapplications.model.ISMApplication create(
		long ismApplicationId);

	/**
	* Removes the i s m application with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ismApplicationId the primary key of the i s m application
	* @return the i s m application that was removed
	* @throws org.un.ldcportal.ismapplications.NoSuchApplicationException if a i s m application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.un.ldcportal.ismapplications.model.ISMApplication remove(
		long ismApplicationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchApplicationException;

	public org.un.ldcportal.ismapplications.model.ISMApplication updateImpl(
		org.un.ldcportal.ismapplications.model.ISMApplication ismApplication,
		boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i s m application with the primary key or throws a {@link org.un.ldcportal.ismapplications.NoSuchApplicationException} if it could not be found.
	*
	* @param ismApplicationId the primary key of the i s m application
	* @return the i s m application
	* @throws org.un.ldcportal.ismapplications.NoSuchApplicationException if a i s m application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.un.ldcportal.ismapplications.model.ISMApplication findByPrimaryKey(
		long ismApplicationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchApplicationException;

	/**
	* Returns the i s m application with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ismApplicationId the primary key of the i s m application
	* @return the i s m application, or <code>null</code> if a i s m application with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.un.ldcportal.ismapplications.model.ISMApplication fetchByPrimaryKey(
		long ismApplicationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the i s m applications where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching i s m applications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.un.ldcportal.ismapplications.model.ISMApplication findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchApplicationException;

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
	public org.un.ldcportal.ismapplications.model.ISMApplication findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchApplicationException;

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
	public org.un.ldcportal.ismapplications.model.ISMApplication[] findByUuid_PrevAndNext(
		long ismApplicationId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchApplicationException;

	/**
	* Returns the i s m application where uuid = &#63; and groupId = &#63; or throws a {@link org.un.ldcportal.ismapplications.NoSuchApplicationException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching i s m application
	* @throws org.un.ldcportal.ismapplications.NoSuchApplicationException if a matching i s m application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.un.ldcportal.ismapplications.model.ISMApplication findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchApplicationException;

	/**
	* Returns the i s m application where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching i s m application, or <code>null</code> if a matching i s m application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.un.ldcportal.ismapplications.model.ISMApplication fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i s m application where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching i s m application, or <code>null</code> if a matching i s m application could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.un.ldcportal.ismapplications.model.ISMApplication fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the i s m applications where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching i s m applications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.un.ldcportal.ismapplications.model.ISMApplication findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchApplicationException;

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
	public org.un.ldcportal.ismapplications.model.ISMApplication findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchApplicationException;

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
	public org.un.ldcportal.ismapplications.model.ISMApplication[] findByGroupId_PrevAndNext(
		long ismApplicationId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchApplicationException;

	/**
	* Returns all the i s m applications that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching i s m applications that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.un.ldcportal.ismapplications.model.ISMApplication[] filterFindByGroupId_PrevAndNext(
		long ismApplicationId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchApplicationException;

	/**
	* Returns all the i s m applications where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching i s m applications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.un.ldcportal.ismapplications.model.ISMApplication findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchApplicationException;

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
	public org.un.ldcportal.ismapplications.model.ISMApplication findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchApplicationException;

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
	public org.un.ldcportal.ismapplications.model.ISMApplication[] findByCompanyId_PrevAndNext(
		long ismApplicationId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchApplicationException;

	/**
	* Returns all the i s m applications where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching i s m applications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> findByG_S(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> findByG_S(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> findByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.un.ldcportal.ismapplications.model.ISMApplication findByG_S_First(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchApplicationException;

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
	public org.un.ldcportal.ismapplications.model.ISMApplication findByG_S_Last(
		long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchApplicationException;

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
	public org.un.ldcportal.ismapplications.model.ISMApplication[] findByG_S_PrevAndNext(
		long ismApplicationId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchApplicationException;

	/**
	* Returns all the i s m applications that the user has permission to view where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the matching i s m applications that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> filterFindByG_S(
		long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> filterFindByG_S(
		long groupId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> filterFindByG_S(
		long groupId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public org.un.ldcportal.ismapplications.model.ISMApplication[] filterFindByG_S_PrevAndNext(
		long ismApplicationId, long groupId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchApplicationException;

	/**
	* Returns all the i s m applications.
	*
	* @return the i s m applications
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the i s m applications where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the i s m application where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchApplicationException;

	/**
	* Removes all the i s m applications where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the i s m applications where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the i s m applications where groupId = &#63; and status = &#63; from the database.
	*
	* @param groupId the group ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_S(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the i s m applications from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i s m applications where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching i s m applications
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i s m applications where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching i s m applications
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i s m applications where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching i s m applications
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i s m applications that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching i s m applications that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i s m applications where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching i s m applications
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i s m applications where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching i s m applications
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_S(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i s m applications that the user has permission to view where groupId = &#63; and status = &#63;.
	*
	* @param groupId the group ID
	* @param status the status
	* @return the number of matching i s m applications that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_S(long groupId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i s m applications.
	*
	* @return the number of i s m applications
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}