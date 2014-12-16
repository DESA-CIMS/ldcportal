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

import org.un.ldcportal.ismapplications.model.ISM;

import java.util.List;

/**
 * The persistence utility for the i s m service. This utility wraps {@link ISMPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Thibault Boyeux
 * @see ISMPersistence
 * @see ISMPersistenceImpl
 * @generated
 */
public class ISMUtil {
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
	public static void clearCache(ISM ism) {
		getPersistence().clearCache(ism);
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
	public static List<ISM> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ISM> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ISM> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static ISM update(ISM ism, boolean merge) throws SystemException {
		return getPersistence().update(ism, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static ISM update(ISM ism, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(ism, merge, serviceContext);
	}

	/**
	* Caches the i s m in the entity cache if it is enabled.
	*
	* @param ism the i s m
	*/
	public static void cacheResult(
		org.un.ldcportal.ismapplications.model.ISM ism) {
		getPersistence().cacheResult(ism);
	}

	/**
	* Caches the i s ms in the entity cache if it is enabled.
	*
	* @param isms the i s ms
	*/
	public static void cacheResult(
		java.util.List<org.un.ldcportal.ismapplications.model.ISM> isms) {
		getPersistence().cacheResult(isms);
	}

	/**
	* Creates a new i s m with the primary key. Does not add the i s m to the database.
	*
	* @param ismId the primary key for the new i s m
	* @return the new i s m
	*/
	public static org.un.ldcportal.ismapplications.model.ISM create(long ismId) {
		return getPersistence().create(ismId);
	}

	/**
	* Removes the i s m with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ismId the primary key of the i s m
	* @return the i s m that was removed
	* @throws org.un.ldcportal.ismapplications.NoSuchISMException if a i s m with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISM remove(long ismId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException {
		return getPersistence().remove(ismId);
	}

	public static org.un.ldcportal.ismapplications.model.ISM updateImpl(
		org.un.ldcportal.ismapplications.model.ISM ism, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(ism, merge);
	}

	/**
	* Returns the i s m with the primary key or throws a {@link org.un.ldcportal.ismapplications.NoSuchISMException} if it could not be found.
	*
	* @param ismId the primary key of the i s m
	* @return the i s m
	* @throws org.un.ldcportal.ismapplications.NoSuchISMException if a i s m with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISM findByPrimaryKey(
		long ismId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException {
		return getPersistence().findByPrimaryKey(ismId);
	}

	/**
	* Returns the i s m with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ismId the primary key of the i s m
	* @return the i s m, or <code>null</code> if a i s m with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISM fetchByPrimaryKey(
		long ismId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(ismId);
	}

	/**
	* Returns all the i s ms where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching i s ms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISM> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

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
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISM> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

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
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISM> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

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
	public static org.un.ldcportal.ismapplications.model.ISM findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

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
	public static org.un.ldcportal.ismapplications.model.ISM findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

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
	public static org.un.ldcportal.ismapplications.model.ISM[] findByGroupId_PrevAndNext(
		long ismId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(ismId, groupId, orderByComparator);
	}

	/**
	* Returns all the i s ms that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching i s ms that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISM> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId);
	}

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
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISM> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

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
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISM> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

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
	public static org.un.ldcportal.ismapplications.model.ISM[] filterFindByGroupId_PrevAndNext(
		long ismId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException {
		return getPersistence()
				   .filterFindByGroupId_PrevAndNext(ismId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the i s ms where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the matching i s ms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISM> findByG_C(
		long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_C(groupId, companyId);
	}

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
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISM> findByG_C(
		long groupId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByG_C(groupId, companyId, start, end);
	}

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
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISM> findByG_C(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByG_C(groupId, companyId, start, end, orderByComparator);
	}

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
	public static org.un.ldcportal.ismapplications.model.ISM findByG_C_First(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException {
		return getPersistence()
				   .findByG_C_First(groupId, companyId, orderByComparator);
	}

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
	public static org.un.ldcportal.ismapplications.model.ISM findByG_C_Last(
		long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException {
		return getPersistence()
				   .findByG_C_Last(groupId, companyId, orderByComparator);
	}

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
	public static org.un.ldcportal.ismapplications.model.ISM[] findByG_C_PrevAndNext(
		long ismId, long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException {
		return getPersistence()
				   .findByG_C_PrevAndNext(ismId, groupId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the i s ms that the user has permission to view where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the matching i s ms that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISM> filterFindByG_C(
		long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_C(groupId, companyId);
	}

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
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISM> filterFindByG_C(
		long groupId, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByG_C(groupId, companyId, start, end);
	}

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
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISM> filterFindByG_C(
		long groupId, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByG_C(groupId, companyId, start, end,
			orderByComparator);
	}

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
	public static org.un.ldcportal.ismapplications.model.ISM[] filterFindByG_C_PrevAndNext(
		long ismId, long groupId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException {
		return getPersistence()
				   .filterFindByG_C_PrevAndNext(ismId, groupId, companyId,
			orderByComparator);
	}

	/**
	* Returns the i s m where webContentId = &#63; or throws a {@link org.un.ldcportal.ismapplications.NoSuchISMException} if it could not be found.
	*
	* @param webContentId the web content ID
	* @return the matching i s m
	* @throws org.un.ldcportal.ismapplications.NoSuchISMException if a matching i s m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISM findByWebContendId(
		long webContentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException {
		return getPersistence().findByWebContendId(webContentId);
	}

	/**
	* Returns the i s m where webContentId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param webContentId the web content ID
	* @return the matching i s m, or <code>null</code> if a matching i s m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISM fetchByWebContendId(
		long webContentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByWebContendId(webContentId);
	}

	/**
	* Returns the i s m where webContentId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param webContentId the web content ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching i s m, or <code>null</code> if a matching i s m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISM fetchByWebContendId(
		long webContentId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByWebContendId(webContentId, retrieveFromCache);
	}

	/**
	* Returns the i s m where ismId = &#63; and groupId = &#63; or throws a {@link org.un.ldcportal.ismapplications.NoSuchISMException} if it could not be found.
	*
	* @param ismId the ism ID
	* @param groupId the group ID
	* @return the matching i s m
	* @throws org.un.ldcportal.ismapplications.NoSuchISMException if a matching i s m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISM findByG_I(
		long ismId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException {
		return getPersistence().findByG_I(ismId, groupId);
	}

	/**
	* Returns the i s m where ismId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ismId the ism ID
	* @param groupId the group ID
	* @return the matching i s m, or <code>null</code> if a matching i s m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISM fetchByG_I(
		long ismId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByG_I(ismId, groupId);
	}

	/**
	* Returns the i s m where ismId = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ismId the ism ID
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching i s m, or <code>null</code> if a matching i s m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISM fetchByG_I(
		long ismId, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByG_I(ismId, groupId, retrieveFromCache);
	}

	/**
	* Returns the i s m where ismId = &#63; or throws a {@link org.un.ldcportal.ismapplications.NoSuchISMException} if it could not be found.
	*
	* @param ismId the ism ID
	* @return the matching i s m
	* @throws org.un.ldcportal.ismapplications.NoSuchISMException if a matching i s m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISM findByismId(
		long ismId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException {
		return getPersistence().findByismId(ismId);
	}

	/**
	* Returns the i s m where ismId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ismId the ism ID
	* @return the matching i s m, or <code>null</code> if a matching i s m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISM fetchByismId(
		long ismId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByismId(ismId);
	}

	/**
	* Returns the i s m where ismId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ismId the ism ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching i s m, or <code>null</code> if a matching i s m could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.ismapplications.model.ISM fetchByismId(
		long ismId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByismId(ismId, retrieveFromCache);
	}

	/**
	* Returns all the i s ms where mbCategoryId = &#63;.
	*
	* @param mbCategoryId the mb category ID
	* @return the matching i s ms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISM> findBymbCategoryId(
		long mbCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBymbCategoryId(mbCategoryId);
	}

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
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISM> findBymbCategoryId(
		long mbCategoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findBymbCategoryId(mbCategoryId, start, end);
	}

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
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISM> findBymbCategoryId(
		long mbCategoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findBymbCategoryId(mbCategoryId, start, end,
			orderByComparator);
	}

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
	public static org.un.ldcportal.ismapplications.model.ISM findBymbCategoryId_First(
		long mbCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException {
		return getPersistence()
				   .findBymbCategoryId_First(mbCategoryId, orderByComparator);
	}

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
	public static org.un.ldcportal.ismapplications.model.ISM findBymbCategoryId_Last(
		long mbCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException {
		return getPersistence()
				   .findBymbCategoryId_Last(mbCategoryId, orderByComparator);
	}

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
	public static org.un.ldcportal.ismapplications.model.ISM[] findBymbCategoryId_PrevAndNext(
		long ismId, long mbCategoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException {
		return getPersistence()
				   .findBymbCategoryId_PrevAndNext(ismId, mbCategoryId,
			orderByComparator);
	}

	/**
	* Returns all the i s ms.
	*
	* @return the i s ms
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISM> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISM> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISM> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the i s ms where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Removes all the i s ms where groupId = &#63; and companyId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_C(long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByG_C(groupId, companyId);
	}

	/**
	* Removes the i s m where webContentId = &#63; from the database.
	*
	* @param webContentId the web content ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByWebContendId(long webContentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException {
		getPersistence().removeByWebContendId(webContentId);
	}

	/**
	* Removes the i s m where ismId = &#63; and groupId = &#63; from the database.
	*
	* @param ismId the ism ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByG_I(long ismId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException {
		getPersistence().removeByG_I(ismId, groupId);
	}

	/**
	* Removes the i s m where ismId = &#63; from the database.
	*
	* @param ismId the ism ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByismId(long ismId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.ismapplications.NoSuchISMException {
		getPersistence().removeByismId(ismId);
	}

	/**
	* Removes all the i s ms where mbCategoryId = &#63; from the database.
	*
	* @param mbCategoryId the mb category ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeBymbCategoryId(long mbCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeBymbCategoryId(mbCategoryId);
	}

	/**
	* Removes all the i s ms from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of i s ms where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching i s ms
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of i s ms that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching i s ms that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Returns the number of i s ms where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the number of matching i s ms
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_C(long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_C(groupId, companyId);
	}

	/**
	* Returns the number of i s ms that the user has permission to view where groupId = &#63; and companyId = &#63;.
	*
	* @param groupId the group ID
	* @param companyId the company ID
	* @return the number of matching i s ms that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByG_C(long groupId, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByG_C(groupId, companyId);
	}

	/**
	* Returns the number of i s ms where webContentId = &#63;.
	*
	* @param webContentId the web content ID
	* @return the number of matching i s ms
	* @throws SystemException if a system exception occurred
	*/
	public static int countByWebContendId(long webContentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByWebContendId(webContentId);
	}

	/**
	* Returns the number of i s ms where ismId = &#63; and groupId = &#63;.
	*
	* @param ismId the ism ID
	* @param groupId the group ID
	* @return the number of matching i s ms
	* @throws SystemException if a system exception occurred
	*/
	public static int countByG_I(long ismId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByG_I(ismId, groupId);
	}

	/**
	* Returns the number of i s ms where ismId = &#63;.
	*
	* @param ismId the ism ID
	* @return the number of matching i s ms
	* @throws SystemException if a system exception occurred
	*/
	public static int countByismId(long ismId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByismId(ismId);
	}

	/**
	* Returns the number of i s ms where mbCategoryId = &#63;.
	*
	* @param mbCategoryId the mb category ID
	* @return the number of matching i s ms
	* @throws SystemException if a system exception occurred
	*/
	public static int countBymbCategoryId(long mbCategoryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countBymbCategoryId(mbCategoryId);
	}

	/**
	* Returns the number of i s ms.
	*
	* @return the number of i s ms
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	/**
	* Returns all the i s m applications associated with the i s m.
	*
	* @param pk the primary key of the i s m
	* @return the i s m applications associated with the i s m
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> getISMApplications(
		long pk) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getISMApplications(pk);
	}

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
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> getISMApplications(
		long pk, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getISMApplications(pk, start, end);
	}

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
	public static java.util.List<org.un.ldcportal.ismapplications.model.ISMApplication> getISMApplications(
		long pk, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .getISMApplications(pk, start, end, orderByComparator);
	}

	/**
	* Returns the number of i s m applications associated with the i s m.
	*
	* @param pk the primary key of the i s m
	* @return the number of i s m applications associated with the i s m
	* @throws SystemException if a system exception occurred
	*/
	public static int getISMApplicationsSize(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().getISMApplicationsSize(pk);
	}

	/**
	* Returns <code>true</code> if the i s m application is associated with the i s m.
	*
	* @param pk the primary key of the i s m
	* @param ismApplicationPK the primary key of the i s m application
	* @return <code>true</code> if the i s m application is associated with the i s m; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsISMApplication(long pk, long ismApplicationPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsISMApplication(pk, ismApplicationPK);
	}

	/**
	* Returns <code>true</code> if the i s m has any i s m applications associated with it.
	*
	* @param pk the primary key of the i s m to check for associations with i s m applications
	* @return <code>true</code> if the i s m has any i s m applications associated with it; <code>false</code> otherwise
	* @throws SystemException if a system exception occurred
	*/
	public static boolean containsISMApplications(long pk)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().containsISMApplications(pk);
	}

	public static ISMPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ISMPersistence)PortletBeanLocatorUtil.locate(org.un.ldcportal.ismapplications.service.ClpSerializer.getServletContextName(),
					ISMPersistence.class.getName());

			ReferenceRegistry.registerReference(ISMUtil.class, "_persistence");
		}

		return _persistence;
	}

	public void setPersistence(ISMPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(ISMUtil.class, "_persistence");
	}

	private static ISMPersistence _persistence;
}