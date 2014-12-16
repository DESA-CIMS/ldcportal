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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.impl.BaseModelImpl;

import org.un.ldcportal.ismapplications.service.ISMLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Proxy;

/**
 * @author Thibault Boyeux
 */
public class ISMClp extends BaseModelImpl<ISM> implements ISM {
	public ISMClp() {
	}

	public Class<?> getModelClass() {
		return ISM.class;
	}

	public String getModelClassName() {
		return ISM.class.getName();
	}

	public long getPrimaryKey() {
		return _ismId;
	}

	public void setPrimaryKey(long primaryKey) {
		setIsmId(primaryKey);
	}

	public Serializable getPrimaryKeyObj() {
		return new Long(_ismId);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	public long getIsmId() {
		return _ismId;
	}

	public void setIsmId(long ismId) {
		_ismId = ismId;
	}

	public long getWebContentId() {
		return _webContentId;
	}

	public void setWebContentId(long webContentId) {
		_webContentId = webContentId;
	}

	public long getModeratorId() {
		return _moderatorId;
	}

	public void setModeratorId(long moderatorId) {
		_moderatorId = moderatorId;
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

	public long getMbCategoryId() {
		return _mbCategoryId;
	}

	public void setMbCategoryId(long mbCategoryId) {
		_mbCategoryId = mbCategoryId;
	}

	public long getAssetCategoryId() {
		return _assetCategoryId;
	}

	public void setAssetCategoryId(long assetCategoryId) {
		_assetCategoryId = assetCategoryId;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			ISMLocalServiceUtil.addISM(this);
		}
		else {
			ISMLocalServiceUtil.updateISM(this);
		}
	}

	@Override
	public ISM toEscapedModel() {
		return (ISM)Proxy.newProxyInstance(ISM.class.getClassLoader(),
			new Class[] { ISM.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ISMClp clone = new ISMClp();

		clone.setIsmId(getIsmId());
		clone.setWebContentId(getWebContentId());
		clone.setModeratorId(getModeratorId());
		clone.setCompanyId(getCompanyId());
		clone.setGroupId(getGroupId());
		clone.setMbCategoryId(getMbCategoryId());
		clone.setAssetCategoryId(getAssetCategoryId());

		return clone;
	}

	public int compareTo(ISM ism) {
		long primaryKey = ism.getPrimaryKey();

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

		ISMClp ism = null;

		try {
			ism = (ISMClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		long primaryKey = ism.getPrimaryKey();

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
		StringBundler sb = new StringBundler(15);

		sb.append("{ismId=");
		sb.append(getIsmId());
		sb.append(", webContentId=");
		sb.append(getWebContentId());
		sb.append(", moderatorId=");
		sb.append(getModeratorId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", mbCategoryId=");
		sb.append(getMbCategoryId());
		sb.append(", assetCategoryId=");
		sb.append(getAssetCategoryId());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(25);

		sb.append("<model><model-name>");
		sb.append("org.un.ldcportal.ismapplications.model.ISM");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>ismId</column-name><column-value><![CDATA[");
		sb.append(getIsmId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>webContentId</column-name><column-value><![CDATA[");
		sb.append(getWebContentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>moderatorId</column-name><column-value><![CDATA[");
		sb.append(getModeratorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mbCategoryId</column-name><column-value><![CDATA[");
		sb.append(getMbCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>assetCategoryId</column-name><column-value><![CDATA[");
		sb.append(getAssetCategoryId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _ismId;
	private long _webContentId;
	private long _moderatorId;
	private long _companyId;
	private long _groupId;
	private long _mbCategoryId;
	private long _assetCategoryId;
}