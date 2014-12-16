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

package org.un.ldcportal.jargon.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import org.un.ldcportal.jargon.model.LDCJargon;

import java.util.List;

/**
 * The persistence utility for the l d c jargon service. This utility wraps {@link LDCJargonPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Thibault Boyeux
 * @see LDCJargonPersistence
 * @see LDCJargonPersistenceImpl
 * @generated
 */
public class LDCJargonUtil {
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
	public static void clearCache(LDCJargon ldcJargon) {
		getPersistence().clearCache(ldcJargon);
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
	public static List<LDCJargon> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<LDCJargon> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<LDCJargon> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean)
	 */
	public static LDCJargon update(LDCJargon ldcJargon, boolean merge)
		throws SystemException {
		return getPersistence().update(ldcJargon, merge);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, boolean, ServiceContext)
	 */
	public static LDCJargon update(LDCJargon ldcJargon, boolean merge,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(ldcJargon, merge, serviceContext);
	}

	/**
	* Caches the l d c jargon in the entity cache if it is enabled.
	*
	* @param ldcJargon the l d c jargon
	*/
	public static void cacheResult(
		org.un.ldcportal.jargon.model.LDCJargon ldcJargon) {
		getPersistence().cacheResult(ldcJargon);
	}

	/**
	* Caches the l d c jargons in the entity cache if it is enabled.
	*
	* @param ldcJargons the l d c jargons
	*/
	public static void cacheResult(
		java.util.List<org.un.ldcportal.jargon.model.LDCJargon> ldcJargons) {
		getPersistence().cacheResult(ldcJargons);
	}

	/**
	* Creates a new l d c jargon with the primary key. Does not add the l d c jargon to the database.
	*
	* @param ldcJargonId the primary key for the new l d c jargon
	* @return the new l d c jargon
	*/
	public static org.un.ldcportal.jargon.model.LDCJargon create(
		long ldcJargonId) {
		return getPersistence().create(ldcJargonId);
	}

	/**
	* Removes the l d c jargon with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ldcJargonId the primary key of the l d c jargon
	* @return the l d c jargon that was removed
	* @throws org.un.ldcportal.jargon.NoSuchLDCJargonException if a l d c jargon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.jargon.model.LDCJargon remove(
		long ldcJargonId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.jargon.NoSuchLDCJargonException {
		return getPersistence().remove(ldcJargonId);
	}

	public static org.un.ldcportal.jargon.model.LDCJargon updateImpl(
		org.un.ldcportal.jargon.model.LDCJargon ldcJargon, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(ldcJargon, merge);
	}

	/**
	* Returns the l d c jargon with the primary key or throws a {@link org.un.ldcportal.jargon.NoSuchLDCJargonException} if it could not be found.
	*
	* @param ldcJargonId the primary key of the l d c jargon
	* @return the l d c jargon
	* @throws org.un.ldcportal.jargon.NoSuchLDCJargonException if a l d c jargon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.jargon.model.LDCJargon findByPrimaryKey(
		long ldcJargonId)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.jargon.NoSuchLDCJargonException {
		return getPersistence().findByPrimaryKey(ldcJargonId);
	}

	/**
	* Returns the l d c jargon with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ldcJargonId the primary key of the l d c jargon
	* @return the l d c jargon, or <code>null</code> if a l d c jargon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.jargon.model.LDCJargon fetchByPrimaryKey(
		long ldcJargonId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(ldcJargonId);
	}

	/**
	* Returns all the l d c jargons where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching l d c jargons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.jargon.model.LDCJargon> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the l d c jargons where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of l d c jargons
	* @param end the upper bound of the range of l d c jargons (not inclusive)
	* @return the range of matching l d c jargons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.jargon.model.LDCJargon> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the l d c jargons where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of l d c jargons
	* @param end the upper bound of the range of l d c jargons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching l d c jargons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.jargon.model.LDCJargon> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first l d c jargon in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching l d c jargon
	* @throws org.un.ldcportal.jargon.NoSuchLDCJargonException if a matching l d c jargon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.jargon.model.LDCJargon findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.jargon.NoSuchLDCJargonException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last l d c jargon in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching l d c jargon
	* @throws org.un.ldcportal.jargon.NoSuchLDCJargonException if a matching l d c jargon could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.jargon.model.LDCJargon findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.jargon.NoSuchLDCJargonException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the l d c jargons before and after the current l d c jargon in the ordered set where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param ldcJargonId the primary key of the current l d c jargon
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next l d c jargon
	* @throws org.un.ldcportal.jargon.NoSuchLDCJargonException if a l d c jargon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.jargon.model.LDCJargon[] findByGroupId_PrevAndNext(
		long ldcJargonId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.jargon.NoSuchLDCJargonException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(ldcJargonId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the l d c jargons that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching l d c jargons that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.jargon.model.LDCJargon> filterFindByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId);
	}

	/**
	* Returns a range of all the l d c jargons that the user has permission to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of l d c jargons
	* @param end the upper bound of the range of l d c jargons (not inclusive)
	* @return the range of matching l d c jargons that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.jargon.model.LDCJargon> filterFindByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the l d c jargons that the user has permissions to view where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of l d c jargons
	* @param end the upper bound of the range of l d c jargons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching l d c jargons that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.jargon.model.LDCJargon> filterFindByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the l d c jargons before and after the current l d c jargon in the ordered set of l d c jargons that the user has permission to view where groupId = &#63;.
	*
	* @param ldcJargonId the primary key of the current l d c jargon
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next l d c jargon
	* @throws org.un.ldcportal.jargon.NoSuchLDCJargonException if a l d c jargon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static org.un.ldcportal.jargon.model.LDCJargon[] filterFindByGroupId_PrevAndNext(
		long ldcJargonId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			org.un.ldcportal.jargon.NoSuchLDCJargonException {
		return getPersistence()
				   .filterFindByGroupId_PrevAndNext(ldcJargonId, groupId,
			orderByComparator);
	}

	/**
	* Returns all the l d c jargons.
	*
	* @return the l d c jargons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.jargon.model.LDCJargon> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the l d c jargons.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of l d c jargons
	* @param end the upper bound of the range of l d c jargons (not inclusive)
	* @return the range of l d c jargons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.jargon.model.LDCJargon> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the l d c jargons.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of l d c jargons
	* @param end the upper bound of the range of l d c jargons (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of l d c jargons
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<org.un.ldcportal.jargon.model.LDCJargon> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the l d c jargons where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Removes all the l d c jargons from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of l d c jargons where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching l d c jargons
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns the number of l d c jargons that the user has permission to view where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching l d c jargons that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByGroupId(groupId);
	}

	/**
	* Returns the number of l d c jargons.
	*
	* @return the number of l d c jargons
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static LDCJargonPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (LDCJargonPersistence)PortletBeanLocatorUtil.locate(org.un.ldcportal.jargon.service.ClpSerializer.getServletContextName(),
					LDCJargonPersistence.class.getName());

			ReferenceRegistry.registerReference(LDCJargonUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	public void setPersistence(LDCJargonPersistence persistence) {
		_persistence = persistence;

		ReferenceRegistry.registerReference(LDCJargonUtil.class, "_persistence");
	}

	private static LDCJargonPersistence _persistence;
}