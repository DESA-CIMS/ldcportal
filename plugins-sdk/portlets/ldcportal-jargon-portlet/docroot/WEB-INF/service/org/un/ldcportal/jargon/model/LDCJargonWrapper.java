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

package org.un.ldcportal.jargon.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link LDCJargon}.
 * </p>
 *
 * @author    Thibault Boyeux
 * @see       LDCJargon
 * @generated
 */
public class LDCJargonWrapper implements LDCJargon, ModelWrapper<LDCJargon> {
	public LDCJargonWrapper(LDCJargon ldcJargon) {
		_ldcJargon = ldcJargon;
	}

	public Class<?> getModelClass() {
		return LDCJargon.class;
	}

	public String getModelClassName() {
		return LDCJargon.class.getName();
	}

	/**
	* Returns the primary key of this l d c jargon.
	*
	* @return the primary key of this l d c jargon
	*/
	public long getPrimaryKey() {
		return _ldcJargon.getPrimaryKey();
	}

	/**
	* Sets the primary key of this l d c jargon.
	*
	* @param primaryKey the primary key of this l d c jargon
	*/
	public void setPrimaryKey(long primaryKey) {
		_ldcJargon.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the ldc jargon ID of this l d c jargon.
	*
	* @return the ldc jargon ID of this l d c jargon
	*/
	public long getLdcJargonId() {
		return _ldcJargon.getLdcJargonId();
	}

	/**
	* Sets the ldc jargon ID of this l d c jargon.
	*
	* @param ldcJargonId the ldc jargon ID of this l d c jargon
	*/
	public void setLdcJargonId(long ldcJargonId) {
		_ldcJargon.setLdcJargonId(ldcJargonId);
	}

	/**
	* Returns the name of this l d c jargon.
	*
	* @return the name of this l d c jargon
	*/
	public java.lang.String getName() {
		return _ldcJargon.getName();
	}

	/**
	* Sets the name of this l d c jargon.
	*
	* @param name the name of this l d c jargon
	*/
	public void setName(java.lang.String name) {
		_ldcJargon.setName(name);
	}

	/**
	* Returns the definition of this l d c jargon.
	*
	* @return the definition of this l d c jargon
	*/
	public java.lang.String getDefinition() {
		return _ldcJargon.getDefinition();
	}

	/**
	* Sets the definition of this l d c jargon.
	*
	* @param definition the definition of this l d c jargon
	*/
	public void setDefinition(java.lang.String definition) {
		_ldcJargon.setDefinition(definition);
	}

	/**
	* Returns the company ID of this l d c jargon.
	*
	* @return the company ID of this l d c jargon
	*/
	public long getCompanyId() {
		return _ldcJargon.getCompanyId();
	}

	/**
	* Sets the company ID of this l d c jargon.
	*
	* @param companyId the company ID of this l d c jargon
	*/
	public void setCompanyId(long companyId) {
		_ldcJargon.setCompanyId(companyId);
	}

	/**
	* Returns the group ID of this l d c jargon.
	*
	* @return the group ID of this l d c jargon
	*/
	public long getGroupId() {
		return _ldcJargon.getGroupId();
	}

	/**
	* Sets the group ID of this l d c jargon.
	*
	* @param groupId the group ID of this l d c jargon
	*/
	public void setGroupId(long groupId) {
		_ldcJargon.setGroupId(groupId);
	}

	public boolean isNew() {
		return _ldcJargon.isNew();
	}

	public void setNew(boolean n) {
		_ldcJargon.setNew(n);
	}

	public boolean isCachedModel() {
		return _ldcJargon.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_ldcJargon.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _ldcJargon.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _ldcJargon.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_ldcJargon.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _ldcJargon.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_ldcJargon.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LDCJargonWrapper((LDCJargon)_ldcJargon.clone());
	}

	public int compareTo(org.un.ldcportal.jargon.model.LDCJargon ldcJargon) {
		return _ldcJargon.compareTo(ldcJargon);
	}

	@Override
	public int hashCode() {
		return _ldcJargon.hashCode();
	}

	public com.liferay.portal.model.CacheModel<org.un.ldcportal.jargon.model.LDCJargon> toCacheModel() {
		return _ldcJargon.toCacheModel();
	}

	public org.un.ldcportal.jargon.model.LDCJargon toEscapedModel() {
		return new LDCJargonWrapper(_ldcJargon.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _ldcJargon.toString();
	}

	public java.lang.String toXmlString() {
		return _ldcJargon.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_ldcJargon.persist();
	}

	public void setName(java.lang.String name, java.util.Locale locale) {
		_ldcJargon.setName(name, locale);
	}

	public void setName(java.lang.String name, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		_ldcJargon.setName(name, locale, defaultLocale);
	}

	public void setNameMap(
		java.util.Map<java.util.Locale, java.lang.String> nameMap) {
		_ldcJargon.setNameMap(nameMap);
	}

	public void setNameMap(
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Locale defaultLocale) {
		_ldcJargon.setNameMap(nameMap, defaultLocale);
	}

	public void setDefinition(java.lang.String definition,
		java.util.Locale locale) {
		_ldcJargon.setDefinition(definition, locale);
	}

	public void setDefinition(java.lang.String definition,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		_ldcJargon.setDefinition(definition, locale, defaultLocale);
	}

	public void setDefinitionMap(
		java.util.Map<java.util.Locale, java.lang.String> definitionMap) {
		_ldcJargon.setDefinitionMap(definitionMap);
	}

	public void setDefinitionMap(
		java.util.Map<java.util.Locale, java.lang.String> definitionMap,
		java.util.Locale defaultLocale) {
		_ldcJargon.setDefinitionMap(definitionMap, defaultLocale);
	}

	public java.lang.String getName(java.util.Locale locale) {
		return _ldcJargon.getName(locale);
	}

	public java.lang.String getName(java.lang.String languageId) {
		return _ldcJargon.getName(languageId);
	}

	public java.util.Map<java.util.Locale, java.lang.String> getNameMap() {
		return _ldcJargon.getNameMap();
	}

	public java.lang.String getDefinition(java.util.Locale locale) {
		return _ldcJargon.getDefinition(locale);
	}

	public java.lang.String getDefinition(java.lang.String languageId) {
		return _ldcJargon.getDefinition(languageId);
	}

	public java.util.Map<java.util.Locale, java.lang.String> getDefinitionMap() {
		return _ldcJargon.getDefinitionMap();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public LDCJargon getWrappedLDCJargon() {
		return _ldcJargon;
	}

	public LDCJargon getWrappedModel() {
		return _ldcJargon;
	}

	public void resetOriginalValues() {
		_ldcJargon.resetOriginalValues();
	}

	private LDCJargon _ldcJargon;
}