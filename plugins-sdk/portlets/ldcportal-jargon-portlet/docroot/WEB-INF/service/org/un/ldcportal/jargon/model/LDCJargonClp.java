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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.un.ldcportal.jargon.service.LDCJargonLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author Thibault Boyeux
 */
public class LDCJargonClp extends BaseModelImpl<LDCJargon> implements LDCJargon {
	public LDCJargonClp() {
	}

	public Class<?> getModelClass() {
		return LDCJargon.class;
	}

	public String getModelClassName() {
		return LDCJargon.class.getName();
	}

	public long getPrimaryKey() {
		return _ldcJargonId;
	}

	public void setPrimaryKey(long primaryKey) {
		setLdcJargonId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_ldcJargonId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getLdcJargonId() {
		return _ldcJargonId;
	}

	public void setLdcJargonId(long ldcJargonId) {
		_ldcJargonId = ldcJargonId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getDefinition() {
		return _definition;
	}

	public void setDefinition(String definition) {
		_definition = definition;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public void setName(java.lang.String name, java.util.Locale locale) {
		throw new UnsupportedOperationException();
	}

	public void setName(java.lang.String name, java.util.Locale locale,
		java.util.Locale defaultLocale) {
		throw new UnsupportedOperationException();
	}

	public void setNameMap(
		java.util.Map<java.util.Locale, java.lang.String> nameMap) {
		throw new UnsupportedOperationException();
	}

	public void setNameMap(
		java.util.Map<java.util.Locale, java.lang.String> nameMap,
		java.util.Locale defaultLocale) {
		throw new UnsupportedOperationException();
	}

	public void setDefinition(java.lang.String definition,
		java.util.Locale locale) {
		throw new UnsupportedOperationException();
	}

	public void setDefinition(java.lang.String definition,
		java.util.Locale locale, java.util.Locale defaultLocale) {
		throw new UnsupportedOperationException();
	}

	public void setDefinitionMap(
		java.util.Map<java.util.Locale, java.lang.String> definitionMap) {
		throw new UnsupportedOperationException();
	}

	public void setDefinitionMap(
		java.util.Map<java.util.Locale, java.lang.String> definitionMap,
		java.util.Locale defaultLocale) {
		throw new UnsupportedOperationException();
	}

	public java.lang.String getName(java.util.Locale locale) {
		throw new UnsupportedOperationException();
	}

	public java.lang.String getName(java.lang.String languageId) {
		throw new UnsupportedOperationException();
	}

	public java.util.Map<java.util.Locale, java.lang.String> getNameMap() {
		throw new UnsupportedOperationException();
	}

	public java.lang.String getDefinition(java.util.Locale locale) {
		throw new UnsupportedOperationException();
	}

	public java.lang.String getDefinition(java.lang.String languageId) {
		throw new UnsupportedOperationException();
	}

	public java.util.Map<java.util.Locale, java.lang.String> getDefinitionMap() {
		throw new UnsupportedOperationException();
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			LDCJargonLocalServiceUtil.addLDCJargon(this);
		}
		else {
			LDCJargonLocalServiceUtil.updateLDCJargon(this);
		}
	}

	@Override
	public LDCJargon toEscapedModel() {
		return (LDCJargon)Proxy.newProxyInstance(LDCJargon.class.getClassLoader(),
			new Class[] { LDCJargon.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LDCJargonClp clone = new LDCJargonClp();

		clone.setLdcJargonId(getLdcJargonId());
		clone.setName(getName());
		clone.setDefinition(getDefinition());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());

		return clone;
	}

	public int compareTo(LDCJargon ldcJargon) {
		long primaryKey = ldcJargon.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		LDCJargonClp ldcJargon = null;

		try {
			ldcJargon = (LDCJargonClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = ldcJargon.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{ldcJargonId=");
		sb.append(getLdcJargonId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", definition=");
		sb.append(getDefinition());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(19);

		sb.append("<model><model-name>");
		sb.append("org.un.ldcportal.jargon.model.LDCJargon");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ldcJargonId</column-name><column-value><![CDATA[");
		sb.append(getLdcJargonId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>definition</column-name><column-value><![CDATA[");
		sb.append(getDefinition());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _ldcJargonId;
	private String _name;
	private String _definition;
	private long _companyId;
	private long _groupId;
}