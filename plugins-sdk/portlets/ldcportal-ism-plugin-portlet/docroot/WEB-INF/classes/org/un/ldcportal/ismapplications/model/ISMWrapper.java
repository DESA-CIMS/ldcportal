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
 * This class is a wrapper for {@link ISM}.
 * </p>
 *
 * @author    Thibault Boyeux
 * @see       ISM
 * @generated
 */
public class ISMWrapper implements ISM, ModelWrapper<ISM> {
	public ISMWrapper(ISM ism) {
		_ism = ism;
	}

	public Class<?> getModelClass() {
		return ISM.class;
	}

	public String getModelClassName() {
		return ISM.class.getName();
	}

	/**
	* Returns the primary key of this i s m.
	*
	* @return the primary key of this i s m
	*/
	public long getPrimaryKey() {
		return _ism.getPrimaryKey();
	}

	/**
	* Sets the primary key of this i s m.
	*
	* @param primaryKey the primary key of this i s m
	*/
	public void setPrimaryKey(long primaryKey) {
		_ism.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ism ID of this i s m.
	*
	* @return the ism ID of this i s m
	*/
	public long getIsmId() {
		return _ism.getIsmId();
	}

	/**
	* Sets the ism ID of this i s m.
	*
	* @param ismId the ism ID of this i s m
	*/
	public void setIsmId(long ismId) {
		_ism.setIsmId(ismId);
	}

	/**
	* Returns the web content ID of this i s m.
	*
	* @return the web content ID of this i s m
	*/
	public long getWebContentId() {
		return _ism.getWebContentId();
	}

	/**
	* Sets the web content ID of this i s m.
	*
	* @param webContentId the web content ID of this i s m
	*/
	public void setWebContentId(long webContentId) {
		_ism.setWebContentId(webContentId);
	}

	/**
	* Returns the moderator ID of this i s m.
	*
	* @return the moderator ID of this i s m
	*/
	public long getModeratorId() {
		return _ism.getModeratorId();
	}

	/**
	* Sets the moderator ID of this i s m.
	*
	* @param moderatorId the moderator ID of this i s m
	*/
	public void setModeratorId(long moderatorId) {
		_ism.setModeratorId(moderatorId);
	}

	/**
	* Returns the company ID of this i s m.
	*
	* @return the company ID of this i s m
	*/
	public long getCompanyId() {
		return _ism.getCompanyId();
	}

	/**
	* Sets the company ID of this i s m.
	*
	* @param companyId the company ID of this i s m
	*/
	public void setCompanyId(long companyId) {
		_ism.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this i s m.
	*
	* @return the group ID of this i s m
	*/
	public long getGroupId() {
		return _ism.getGroupId();
	}

	/**
	* Sets the group ID of this i s m.
	*
	* @param groupId the group ID of this i s m
	*/
	public void setGroupId(long groupId) {
		_ism.setGroupId(groupId);
	}

	/**
	* Returns the mb category ID of this i s m.
	*
	* @return the mb category ID of this i s m
	*/
	public long getMbCategoryId() {
		return _ism.getMbCategoryId();
	}

	/**
	* Sets the mb category ID of this i s m.
	*
	* @param mbCategoryId the mb category ID of this i s m
	*/
	public void setMbCategoryId(long mbCategoryId) {
		_ism.setMbCategoryId(mbCategoryId);
	}

	/**
	* Returns the asset category ID of this i s m.
	*
	* @return the asset category ID of this i s m
	*/
	public long getAssetCategoryId() {
		return _ism.getAssetCategoryId();
	}

	/**
	* Sets the asset category ID of this i s m.
	*
	* @param assetCategoryId the asset category ID of this i s m
	*/
	public void setAssetCategoryId(long assetCategoryId) {
		_ism.setAssetCategoryId(assetCategoryId);
	}

	public boolean isNew() {
		return _ism.isNew();
	}

	public void setNew(boolean n) {
		_ism.setNew(n);
	}

	public boolean isCachedModel() {
		return _ism.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_ism.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _ism.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _ism.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_ism.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _ism.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_ism.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ISMWrapper((ISM)_ism.clone());
	}

	public int compareTo(org.un.ldcportal.ismapplications.model.ISM ism) {
		return _ism.compareTo(ism);
	}

	@Override
	public int hashCode() {
		return _ism.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.un.ldcportal.ismapplications.model.ISM> toCacheModel() {
		return _ism.toCacheModel();
	}

	public org.un.ldcportal.ismapplications.model.ISM toEscapedModel() {
		return new ISMWrapper(_ism.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _ism.toString();
	}

	public java.lang.String toXmlString() {
		return _ism.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_ism.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public ISM getWrappedISM() {
		return _ism;
	}

	public ISM getWrappedModel() {
		return _ism;
	}

	public void resetOriginalValues() {
		_ism.resetOriginalValues();
	}

	private ISM _ism;
}