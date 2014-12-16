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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Thibault Boyeux
 * @generated
 */
public class ISMSoap implements Serializable {
	public static ISMSoap toSoapModel(ISM model) {
		ISMSoap soapModel = new ISMSoap();

		soapModel.setIsmId(model.getIsmId());
		soapModel.setWebContentId(model.getWebContentId());
		soapModel.setModeratorId(model.getModeratorId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setMbCategoryId(model.getMbCategoryId());
		soapModel.setAssetCategoryId(model.getAssetCategoryId());

		return soapModel;
	}

	public static ISMSoap[] toSoapModels(ISM[] models) {
		ISMSoap[] soapModels = new ISMSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ISMSoap[][] toSoapModels(ISM[][] models) {
		ISMSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ISMSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ISMSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ISMSoap[] toSoapModels(List<ISM> models) {
		List<ISMSoap> soapModels = new ArrayList<ISMSoap>(models.size());

		for (ISM model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ISMSoap[soapModels.size()]);
	}

	public ISMSoap() {
	}

	public long getPrimaryKey() {
		return _ismId;
	}

	public void setPrimaryKey(long pk) {
		setIsmId(pk);
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

	private long _ismId;
	private long _webContentId;
	private long _moderatorId;
	private long _companyId;
	private long _groupId;
	private long _mbCategoryId;
	private long _assetCategoryId;
}