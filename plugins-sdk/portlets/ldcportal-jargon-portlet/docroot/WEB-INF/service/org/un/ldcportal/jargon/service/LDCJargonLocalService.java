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

package org.un.ldcportal.jargon.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.PersistedModelLocalService;

/**
 * The interface for the l d c jargon local service.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Thibault Boyeux
 * @see LDCJargonLocalServiceUtil
 * @see org.un.ldcportal.jargon.service.base.LDCJargonLocalServiceBaseImpl
 * @see org.un.ldcportal.jargon.service.impl.LDCJargonLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface LDCJargonLocalService extends PersistedModelLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link LDCJargonLocalServiceUtil} to access the l d c jargon local service. Add custom service methods to {@link org.un.ldcportal.jargon.service.impl.LDCJargonLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Adds the l d c jargon to the database. Also notifies the appropriate model listeners.
	*
	* @param ldcJargon the l d c jargon
	* @return the l d c jargon that was added
	* @throws SystemException if a system exception occurred
	*/
	public org.un.ldcportal.jargon.model.LDCJargon addLDCJargon(
		org.un.ldcportal.jargon.model.LDCJargon ldcJargon)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Creates a new l d c jargon with the primary key. Does not add the l d c jargon to the database.
	*
	* @param ldcJargonId the primary key for the new l d c jargon
	* @return the new l d c jargon
	*/
	public org.un.ldcportal.jargon.model.LDCJargon createLDCJargon(
		long ldcJargonId);

	/**
	* Deletes the l d c jargon with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ldcJargonId the primary key of the l d c jargon
	* @throws PortalException if a l d c jargon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public void deleteLDCJargon(long ldcJargonId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	/**
	* Deletes the l d c jargon from the database. Also notifies the appropriate model listeners.
	*
	* @param ldcJargon the l d c jargon
	* @throws SystemException if a system exception occurred
	*/
	public void deleteLDCJargon(
		org.un.ldcportal.jargon.model.LDCJargon ldcJargon)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.un.ldcportal.jargon.model.LDCJargon fetchLDCJargon(
		long ldcJargonId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the l d c jargon with the primary key.
	*
	* @param ldcJargonId the primary key of the l d c jargon
	* @return the l d c jargon
	* @throws PortalException if a l d c jargon with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public org.un.ldcportal.jargon.model.LDCJargon getLDCJargon(
		long ldcJargonId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

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
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.un.ldcportal.jargon.model.LDCJargon> getLDCJargons(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of l d c jargons.
	*
	* @return the number of l d c jargons
	* @throws SystemException if a system exception occurred
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getLDCJargonsCount()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the l d c jargon in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ldcJargon the l d c jargon
	* @return the l d c jargon that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.un.ldcportal.jargon.model.LDCJargon updateLDCJargon(
		org.un.ldcportal.jargon.model.LDCJargon ldcJargon)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Updates the l d c jargon in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param ldcJargon the l d c jargon
	* @param merge whether to merge the l d c jargon with the current session. See {@link com.liferay.portal.service.persistence.BatchSession#update(com.liferay.portal.kernel.dao.orm.Session, com.liferay.portal.model.BaseModel, boolean)} for an explanation.
	* @return the l d c jargon that was updated
	* @throws SystemException if a system exception occurred
	*/
	public org.un.ldcportal.jargon.model.LDCJargon updateLDCJargon(
		org.un.ldcportal.jargon.model.LDCJargon ldcJargon, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<org.un.ldcportal.jargon.model.LDCJargon> getAllLDCJargons(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns LDC Jargon in a specified locale as HashMap where the key is the
	* name of the jargon and the value is the definition
	*
	* @param groupdId
	* @param locale
	* @return HashMap<name, value>
	* @throws SystemException
	*/
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.HashMap<java.lang.String, java.lang.String> getAllLDCJargonMapByLocale(
		long groupdId, java.util.Locale locale)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.lang.String tooltipJargon(java.lang.String s,
		java.util.Map<java.lang.String, java.lang.String> jargonMap,
		java.lang.String start1, java.lang.String start2, java.lang.String end);
}