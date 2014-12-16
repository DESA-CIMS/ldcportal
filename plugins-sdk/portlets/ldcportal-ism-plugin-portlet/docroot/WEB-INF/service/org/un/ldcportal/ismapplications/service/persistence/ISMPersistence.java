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

import org.un.ldcportal.ismapplications.model.ISM;

/**
 * The persistence interface for the i s m service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Thibault Boyeux
 * @see ISMPersistenceImpl
 * @see ISMUtil
 * @generated
 */
public interface ISMPersistence extends BasePersistence<ISM> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ISMUtil} to access the i s m persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the i s m in the entity cache if it is enabled.
	*
	* @param ism the i s m
	*/
	public void cacheResult(org.un.ldcportal.ismapplications.model.ISM ism);

	/**
	* Caches the i s ms in the entity cache if it is enabled.
	*
	* @param isms the i s ms
	*/
	public void cacheResult(
		java.util.List<org.un.ldcportal.ismapplications.model.ISM> isms);

	/**
	* Creates a new i s m with the primary key. Does not add the i s m to the database.
	*
	* @param ismId the primary key for the new i s m
	* @return the new i s m
	*/
	public org.un.ldcportal.ismapplications.model.ISM create(long ismId);

	/**
	* Removes the i s m with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ismId the primary key of the i s m
	* @return the i s m that was removed
	* @throws org.un.ldcportal.ismapplications.NoSuchISMException if a i s m with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.un.ldcportal.ismapplications.model.ISM remove(long ismId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException;

	public org.un.ldcportal.ismapplications.model.ISM updateImpl(
		org.un.ldcportal.ismapplications.model.ISM ism, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i s m with the primary key or throws a {@link org.un.ldcportal.ismapplications.NoSuchISMException} if it could not be found.
	*
	* @param ismId the primary key of the i s m
	* @return the i s m
	* @throws org.un.ldcportal.ismapplications.NoSuchISMException if a i s m with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.un.ldcportal.ismapplications.model.ISM findByPrimaryKey(
		long ismId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException;

	/**
	* Returns the i s m with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ismId the primary key of the i s m
	* @return the i s m, or <code>null</code> if a i s m with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.un.ldcportal.ismapplications.model.ISM fetchByPrimaryKey(
		long ismId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the i s ms where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching i s ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.un.ldcportal.ismapplications.model.ISM> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the i s ms where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of i s ms
	* @param end the upper bound of the range of i s ms (not inclusive)
	* @return the range of matching i s ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.un.ldcportal.ismapplications.model.ISM> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the i s ms where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of i s ms
	* @param end the upper bound of the range of i s ms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i s ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.un.ldcportal.ismapplications.model.ISM> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first i s m in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i s m
	* @throws org.un.ldcportal.ismapplications.NoSuchISMException if a matching i s m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.un.ldcportal.ismapplications.model.ISM findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException;

	/**
	* Returns the last i s m in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i s m
	* @throws org.un.ldcportal.ismapplications.NoSuchISMException if a matching i s m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.un.ldcportal.ismapplications.model.ISM findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException;

	/**
	* Returns the i s ms before and after the current i s m in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ismId the primary key of the current i s m
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i s m
	* @throws org.un.ldcportal.ismapplications.NoSuchISMException if a i s m with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.un.ldcportal.ismapplications.model.ISM[] findByGroupId_PrevAndNext(
		long ismId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException;

	/**
	* Returns all the i s ms that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching i s ms that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.un.ldcportal.ismapplications.model.ISM> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the i s ms that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of i s ms
	* @param end the upper bound of the range of i s ms (not inclusive)
	* @return the range of matching i s ms that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.un.ldcportal.ismapplications.model.ISM> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the i s ms that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of i s ms
	* @param end the upper bound of the range of i s ms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i s ms that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.un.ldcportal.ismapplications.model.ISM> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i s ms before and after the current i s m in the ordered set of i s ms that the user has permission to view where groupId = &#63;.
	*
	* @param ismId the primary key of the current i s m
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i s m
	* @throws org.un.ldcportal.ismapplications.NoSuchISMException if a i s m with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.un.ldcportal.ismapplications.model.ISM[] filterFindByGroupId_PrevAndNext(
		long ismId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException;

	/**
	* Returns all the i s ms where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the matching i s ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.un.ldcportal.ismapplications.model.ISM> findByG_C(
		long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the i s ms where groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param start the lower bound of the range of i s ms
	* @param end the upper bound of the range of i s ms (not inclusive)
	* @return the range of matching i s ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.un.ldcportal.ismapplications.model.ISM> findByG_C(
		long groupId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the i s ms where groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param start the lower bound of the range of i s ms
	* @param end the upper bound of the range of i s ms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i s ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.un.ldcportal.ismapplications.model.ISM> findByG_C(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first i s m in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i s m
	* @throws org.un.ldcportal.ismapplications.NoSuchISMException if a matching i s m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.un.ldcportal.ismapplications.model.ISM findByG_C_First(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException;

	/**
	* Returns the last i s m in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i s m
	* @throws org.un.ldcportal.ismapplications.NoSuchISMException if a matching i s m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.un.ldcportal.ismapplications.model.ISM findByG_C_Last(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException;

	/**
	* Returns the i s ms before and after the current i s m in the ordered set where groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ismId the primary key of the current i s m
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i s m
	* @throws org.un.ldcportal.ismapplications.NoSuchISMException if a i s m with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.un.ldcportal.ismapplications.model.ISM[] findByG_C_PrevAndNext(
		long ismId, long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException;

	/**
	* Returns all the i s ms that the user has permission to view where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the matching i s ms that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.un.ldcportal.ismapplications.model.ISM> filterFindByG_C(
		long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the i s ms that the user has permission to view where groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param start the lower bound of the range of i s ms
	* @param end the upper bound of the range of i s ms (not inclusive)
	* @return the range of matching i s ms that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.un.ldcportal.ismapplications.model.ISM> filterFindByG_C(
		long groupId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the i s ms that the user has permissions to view where groupId = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @param start the lower bound of the range of i s ms
	* @param end the upper bound of the range of i s ms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i s ms that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.un.ldcportal.ismapplications.model.ISM> filterFindByG_C(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i s ms before and after the current i s m in the ordered set of i s ms that the user has permission to view where groupId = &#63; and companyId = &#63;.
	*
	* @param ismId the primary key of the current i s m
	* @param groupId the group ID
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i s m
	* @throws org.un.ldcportal.ismapplications.NoSuchISMException if a i s m with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.un.ldcportal.ismapplications.model.ISM[] filterFindByG_C_PrevAndNext(
		long ismId, long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException;

	/**
	* Returns the i s m where webContentId = &#63; or throws a {@link org.un.ldcportal.ismapplications.NoSuchISMException} if it could not be found.
	*
	* @param webContentId the web content ID
	* @return the matching i s m
	* @throws org.un.ldcportal.ismapplications.NoSuchISMException if a matching i s m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.un.ldcportal.ismapplications.model.ISM findByWebContendId(
		long webContentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException;

	/**
	* Returns the i s m where webContentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param webContentId the web content ID
	* @return the matching i s m, or <code>null</code> if a matching i s m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.un.ldcportal.ismapplications.model.ISM fetchByWebContendId(
		long webContentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i s m where webContentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param webContentId the web content ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching i s m, or <code>null</code> if a matching i s m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.un.ldcportal.ismapplications.model.ISM fetchByWebContendId(
		long webContentId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i s m where ismId = &#63; and groupId = &#63; or throws a {@link org.un.ldcportal.ismapplications.NoSuchISMException} if it could not be found.
	*
	* @param ismId the ism ID
	* @param groupId the group ID
	* @return the matching i s m
	* @throws org.un.ldcportal.ismapplications.NoSuchISMException if a matching i s m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.un.ldcportal.ismapplications.model.ISM findByG_I(long ismId,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException;

	/**
	* Returns the i s m where ismId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ismId the ism ID
	* @param groupId the group ID
	* @return the matching i s m, or <code>null</code> if a matching i s m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.un.ldcportal.ismapplications.model.ISM fetchByG_I(long ismId,
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i s m where ismId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ismId the ism ID
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching i s m, or <code>null</code> if a matching i s m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.un.ldcportal.ismapplications.model.ISM fetchByG_I(long ismId,
		long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i s m where ismId = &#63; or throws a {@link org.un.ldcportal.ismapplications.NoSuchISMException} if it could not be found.
	*
	* @param ismId the ism ID
	* @return the matching i s m
	* @throws org.un.ldcportal.ismapplications.NoSuchISMException if a matching i s m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.un.ldcportal.ismapplications.model.ISM findByismId(long ismId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException;

	/**
	* Returns the i s m where ismId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ismId the ism ID
	* @return the matching i s m, or <code>null</code> if a matching i s m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.un.ldcportal.ismapplications.model.ISM fetchByismId(long ismId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the i s m where ismId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ismId the ism ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching i s m, or <code>null</code> if a matching i s m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.un.ldcportal.ismapplications.model.ISM fetchByismId(long ismId,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the i s ms where mbCategoryId = &#63;.
	*
	* @param mbCategoryId the mb category ID
	* @return the matching i s ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.un.ldcportal.ismapplications.model.ISM> findBymbCategoryId(
		long mbCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the i s ms where mbCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param mbCategoryId the mb category ID
	* @param start the lower bound of the range of i s ms
	* @param end the upper bound of the range of i s ms (not inclusive)
	* @return the range of matching i s ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.un.ldcportal.ismapplications.model.ISM> findBymbCategoryId(
		long mbCategoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the i s ms where mbCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param mbCategoryId the mb category ID
	* @param start the lower bound of the range of i s ms
	* @param end the upper bound of the range of i s ms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching i s ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.un.ldcportal.ismapplications.model.ISM> findBymbCategoryId(
		long mbCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first i s m in the ordered set where mbCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param mbCategoryId the mb category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching i s m
	* @throws org.un.ldcportal.ismapplications.NoSuchISMException if a matching i s m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.un.ldcportal.ismapplications.model.ISM findBymbCategoryId_First(
		long mbCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException;

	/**
	* Returns the last i s m in the ordered set where mbCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param mbCategoryId the mb category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching i s m
	* @throws org.un.ldcportal.ismapplications.NoSuchISMException if a matching i s m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.un.ldcportal.ismapplications.model.ISM findBymbCategoryId_Last(
		long mbCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException;

	/**
	* Returns the i s ms before and after the current i s m in the ordered set where mbCategoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ismId the primary key of the current i s m
	* @param mbCategoryId the mb category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next i s m
	* @throws org.un.ldcportal.ismapplications.NoSuchISMException if a i s m with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public org.un.ldcportal.ismapplications.model.ISM[] findBymbCategoryId_PrevAndNext(
		long ismId, long mbCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException;

	/**
	* Returns all the i s ms.
	*
	* @return the i s ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.un.ldcportal.ismapplications.model.ISM> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<org.un.ldcportal.ismapplications.model.ISM> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the i s ms.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of i s ms
	* @param end the upper bound of the range of i s ms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of i s ms
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.un.ldcportal.ismapplications.model.ISM> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the i s ms where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the i s ms where groupId = &#63; and companyId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_C(long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the i s m where webContentId = &#63; from the database.
	*
	* @param webContentId the web content ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByWebContendId(long webContentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException;

	/**
	* Removes the i s m where ismId = &#63; and groupId = &#63; from the database.
	*
	* @param ismId the ism ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByG_I(long ismId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException;

	/**
	* Removes the i s m where ismId = &#63; from the database.
	*
	* @param ismId the ism ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByismId(long ismId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException;

	/**
	* Removes all the i s ms where mbCategoryId = &#63; from the database.
	*
	* @param mbCategoryId the mb category ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBymbCategoryId(long mbCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the i s ms from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i s ms where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching i s ms
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i s ms that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching i s ms that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i s ms where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the number of matching i s ms
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_C(long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i s ms that the user has permission to view where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the number of matching i s ms that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByG_C(long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i s ms where webContentId = &#63;.
	*
	* @param webContentId the web content ID
	* @return the number of matching i s ms
	* @throws SystemException if a system exception occurred
	*/
	public int countByWebContendId(long webContentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i s ms where ismId = &#63; and groupId = &#63;.
	*
	* @param ismId the ism ID
	* @param groupId the group ID
	* @return the number of matching i s ms
	* @throws SystemException if a system exception occurred
	*/
	public int countByG_I(long ismId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i s ms where ismId = &#63;.
	*
	* @param ismId the ism ID
	* @return the number of matching i s ms
	* @throws SystemException if a system exception occurred
	*/
	public int countByismId(long ismId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i s ms where mbCategoryId = &#63;.
	*
	* @param mbCategoryId the mb category ID
	* @return the number of matching i s ms
	* @throws SystemException if a system exception occurred
	*/
	public int countBymbCategoryId(long mbCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i s ms.
	*
	* @return the number of i s ms
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the i s m applications associated with the i s m.
	*
	* @param pk the primary key of the i s m
	* @return the i s m applications associated with the i s m
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> getISMApplications(
		long pk) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the i s m applications associated with the i s m.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the i s m
	* @param start the lower bound of the range of i s ms
	* @param end the upper bound of the range of i s ms (not inclusive)
	* @return the range of i s m applications associated with the i s m
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> getISMApplications(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the i s m applications associated with the i s m.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param pk the primary key of the i s m
	* @param start the lower bound of the range of i s ms
	* @param end the upper bound of the range of i s ms (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of i s m applications associated with the i s m
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> getISMApplications(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of i s m applications associated with the i s m.
	*
	* @param pk the primary key of the i s m
	* @return the number of i s m applications associated with the i s m
	* @throws SystemException if a system exception occurred
	*/
	public int getISMApplicationsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the i s m application is associated with the i s m.
	*
	* @param pk the primary key of the i s m
	* @param ismApplicationPK the primary key of the i s m application
	* @return <code>true</code> if the i s m application is associated with the i s m; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsISMApplication(long pk, long ismApplicationPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns <code>true</code> if the i s m has any i s m applications associated with it.
	*
	* @param pk the primary key of the i s m to check for associations with i s m applications
	* @return <code>true</code> if the i s m has any i s m applications associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public boolean containsISMApplications(long pk)
		throws com.liferay.portal.kernel.exception.SystemException;
}