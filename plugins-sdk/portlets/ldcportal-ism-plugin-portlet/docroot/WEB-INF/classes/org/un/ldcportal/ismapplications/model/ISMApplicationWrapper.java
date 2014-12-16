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

package org.un.ldcportal.ismapplications.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link ISMApplication}.
 * </p>
 *
 * @author    Thibault Boyeux
 * @see       ISMApplication
 * @generated
 */
public class ISMApplicationWrapper implements ISMApplication,
	ModelWrapper<ISMApplication> {
	public ISMApplicationWrapper(ISMApplication ismApplication) {
		_ismApplication = ismApplication;
	}

	public Class<?> getModelClass() {
		return ISMApplication.class;
	}

	public String getModelClassName() {
		return ISMApplication.class.getName();
	}

	/**
	* Returns the primary key of this i s m application.
	*
	* @return the primary key of this i s m application
	*/
	public long getPrimaryKey() {
		return _ismApplication.getPrimaryKey();
	}

	/**
	* Sets the primary key of this i s m application.
	*
	* @param primaryKey the primary key of this i s m application
	*/
	public void setPrimaryKey(long primaryKey) {
		_ismApplication.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this i s m application.
	*
	* @return the uuid of this i s m application
	*/
	public java.lang.String getUuid() {
		return _ismApplication.getUuid();
	}

	/**
	* Sets the uuid of this i s m application.
	*
	* @param uuid the uuid of this i s m application
	*/
	public void setUuid(java.lang.String uuid) {
		_ismApplication.setUuid(uuid);
	}

	/**
	* Returns the ism application ID of this i s m application.
	*
	* @return the ism application ID of this i s m application
	*/
	public long getIsmApplicationId() {
		return _ismApplication.getIsmApplicationId();
	}

	/**
	* Sets the ism application ID of this i s m application.
	*
	* @param ismApplicationId the ism application ID of this i s m application
	*/
	public void setIsmApplicationId(long ismApplicationId) {
		_ismApplication.setIsmApplicationId(ismApplicationId);
	}

	/**
	* Returns the country of this i s m application.
	*
	* @return the country of this i s m application
	*/
	public java.lang.String getCountry() {
		return _ismApplication.getCountry();
	}

	/**
	* Sets the country of this i s m application.
	*
	* @param country the country of this i s m application
	*/
	public void setCountry(java.lang.String country) {
		_ismApplication.setCountry(country);
	}

	/**
	* Returns the ism ID of this i s m application.
	*
	* @return the ism ID of this i s m application
	*/
	public long getIsmId() {
		return _ismApplication.getIsmId();
	}

	/**
	* Sets the ism ID of this i s m application.
	*
	* @param ismId the ism ID of this i s m application
	*/
	public void setIsmId(long ismId) {
		_ismApplication.setIsmId(ismId);
	}

	/**
	* Returns the status of this i s m application.
	*
	* @return the status of this i s m application
	*/
	public int getStatus() {
		return _ismApplication.getStatus();
	}

	/**
	* Sets the status of this i s m application.
	*
	* @param status the status of this i s m application
	*/
	public void setStatus(int status) {
		_ismApplication.setStatus(status);
	}

	/**
	* Returns the status by user ID of this i s m application.
	*
	* @return the status by user ID of this i s m application
	*/
	public long getStatusByUserId() {
		return _ismApplication.getStatusByUserId();
	}

	/**
	* Sets the status by user ID of this i s m application.
	*
	* @param statusByUserId the status by user ID of this i s m application
	*/
	public void setStatusByUserId(long statusByUserId) {
		_ismApplication.setStatusByUserId(statusByUserId);
	}

	/**
	* Returns the status by user uuid of this i s m application.
	*
	* @return the status by user uuid of this i s m application
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getStatusByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ismApplication.getStatusByUserUuid();
	}

	/**
	* Sets the status by user uuid of this i s m application.
	*
	* @param statusByUserUuid the status by user uuid of this i s m application
	*/
	public void setStatusByUserUuid(java.lang.String statusByUserUuid) {
		_ismApplication.setStatusByUserUuid(statusByUserUuid);
	}

	/**
	* Returns the status by user name of this i s m application.
	*
	* @return the status by user name of this i s m application
	*/
	public java.lang.String getStatusByUserName() {
		return _ismApplication.getStatusByUserName();
	}

	/**
	* Sets the status by user name of this i s m application.
	*
	* @param statusByUserName the status by user name of this i s m application
	*/
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_ismApplication.setStatusByUserName(statusByUserName);
	}

	/**
	* Returns the status date of this i s m application.
	*
	* @return the status date of this i s m application
	*/
	public java.util.Date getStatusDate() {
		return _ismApplication.getStatusDate();
	}

	/**
	* Sets the status date of this i s m application.
	*
	* @param statusDate the status date of this i s m application
	*/
	public void setStatusDate(java.util.Date statusDate) {
		_ismApplication.setStatusDate(statusDate);
	}

	/**
	* Returns the company ID of this i s m application.
	*
	* @return the company ID of this i s m application
	*/
	public long getCompanyId() {
		return _ismApplication.getCompanyId();
	}

	/**
	* Sets the company ID of this i s m application.
	*
	* @param companyId the company ID of this i s m application
	*/
	public void setCompanyId(long companyId) {
		_ismApplication.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this i s m application.
	*
	* @return the group ID of this i s m application
	*/
	public long getGroupId() {
		return _ismApplication.getGroupId();
	}

	/**
	* Sets the group ID of this i s m application.
	*
	* @param groupId the group ID of this i s m application
	*/
	public void setGroupId(long groupId) {
		_ismApplication.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this i s m application.
	*
	* @return the user ID of this i s m application
	*/
	public long getUserId() {
		return _ismApplication.getUserId();
	}

	/**
	* Sets the user ID of this i s m application.
	*
	* @param userId the user ID of this i s m application
	*/
	public void setUserId(long userId) {
		_ismApplication.setUserId(userId);
	}

	/**
	* Returns the user uuid of this i s m application.
	*
	* @return the user uuid of this i s m application
	* @throws SystemException if a system exception occurred
	*/
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ismApplication.getUserUuid();
	}

	/**
	* Sets the user uuid of this i s m application.
	*
	* @param userUuid the user uuid of this i s m application
	*/
	public void setUserUuid(java.lang.String userUuid) {
		_ismApplication.setUserUuid(userUuid);
	}

	/**
	* Returns the application reason of this i s m application.
	*
	* @return the application reason of this i s m application
	*/
	public java.lang.String getApplicationReason() {
		return _ismApplication.getApplicationReason();
	}

	/**
	* Sets the application reason of this i s m application.
	*
	* @param applicationReason the application reason of this i s m application
	*/
	public void setApplicationReason(java.lang.String applicationReason) {
		_ismApplication.setApplicationReason(applicationReason);
	}

	/**
	* Returns the application additional of this i s m application.
	*
	* @return the application additional of this i s m application
	*/
	public java.lang.String getApplicationAdditional() {
		return _ismApplication.getApplicationAdditional();
	}

	/**
	* Sets the application additional of this i s m application.
	*
	* @param applicationAdditional the application additional of this i s m application
	*/
	public void setApplicationAdditional(java.lang.String applicationAdditional) {
		_ismApplication.setApplicationAdditional(applicationAdditional);
	}

	/**
	* @deprecated Renamed to {@link #isApproved()}
	*/
	public boolean getApproved() {
		return _ismApplication.getApproved();
	}

	/**
	* Returns <code>true</code> if this i s m application is approved.
	*
	* @return <code>true</code> if this i s m application is approved; <code>false</code> otherwise
	*/
	public boolean isApproved() {
		return _ismApplication.isApproved();
	}

	/**
	* Returns <code>true</code> if this i s m application is a draft.
	*
	* @return <code>true</code> if this i s m application is a draft; <code>false</code> otherwise
	*/
	public boolean isDraft() {
		return _ismApplication.isDraft();
	}

	/**
	* Returns <code>true</code> if this i s m application is expired.
	*
	* @return <code>true</code> if this i s m application is expired; <code>false</code> otherwise
	*/
	public boolean isExpired() {
		return _ismApplication.isExpired();
	}

	/**
	* Returns <code>true</code> if this i s m application is pending.
	*
	* @return <code>true</code> if this i s m application is pending; <code>false</code> otherwise
	*/
	public boolean isPending() {
		return _ismApplication.isPending();
	}

	public boolean isNew() {
		return _ismApplication.isNew();
	}

	public void setNew(boolean n) {
		_ismApplication.setNew(n);
	}

	public boolean isCachedModel() {
		return _ismApplication.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_ismApplication.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _ismApplication.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _ismApplication.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_ismApplication.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _ismApplication.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_ismApplication.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ISMApplicationWrapper((ISMApplication)_ismApplication.clone());
	}

	public int compareTo(
		org.un.ldcportal.ismapplications.model.ISMApplication ismApplication) {
		return _ismApplication.compareTo(ismApplication);
	}

	@Override
	public int hashCode() {
		return _ismApplication.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.un.ldcportal.ismapplications.model.ISMApplication> toCacheModel() {
		return _ismApplication.toCacheModel();
	}

	public org.un.ldcportal.ismapplications.model.ISMApplication toEscapedModel() {
		return new ISMApplicationWrapper(_ismApplication.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _ismApplication.toString();
	}

	public java.lang.String toXmlString() {
		return _ismApplication.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_ismApplication.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ISMApplication getWrappedISMApplication() {
		return _ismApplication;
	}

	public ISMApplication getWrappedModel() {
		return _ismApplication;
	}

	public void resetOriginalValues() {
		_ismApplication.resetOriginalValues();
	}

	private ISMApplication _ismApplication;
}