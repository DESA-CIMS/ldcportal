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
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Thibault Boyeux
 * @generated
 */
public class ISMApplicationSoap implements Serializable {
	public static ISMApplicationSoap toSoapModel(ISMApplication model) {
		ISMApplicationSoap soapModel = new ISMApplicationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setIsmApplicationId(model.getIsmApplicationId());
		soapModel.setCountry(model.getCountry());
		soapModel.setIsmId(model.getIsmId());
		soapModel.setStatus(model.getStatus());
		soapModel.setStatusByUserId(model.getStatusByUserId());
		soapModel.setStatusByUserName(model.getStatusByUserName());
		soapModel.setStatusDate(model.getStatusDate());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setApplicationReason(model.getApplicationReason());
		soapModel.setApplicationAdditional(model.getApplicationAdditional());

		return soapModel;
	}

	public static ISMApplicationSoap[] toSoapModels(ISMApplication[] models) {
		ISMApplicationSoap[] soapModels = new ISMApplicationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ISMApplicationSoap[][] toSoapModels(ISMApplication[][] models) {
		ISMApplicationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ISMApplicationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ISMApplicationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ISMApplicationSoap[] toSoapModels(List<ISMApplication> models) {
		List<ISMApplicationSoap> soapModels = new ArrayList<ISMApplicationSoap>(models.size());

		for (ISMApplication model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ISMApplicationSoap[soapModels.size()]);
	}

	public ISMApplicationSoap() {
	}

	public long getPrimaryKey() {
		return _ismApplicationId;
	}

	public void setPrimaryKey(long pk) {
		setIsmApplicationId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getIsmApplicationId() {
		return _ismApplicationId;
	}

	public void setIsmApplicationId(long ismApplicationId) {
		_ismApplicationId = ismApplicationId;
	}

	public String getCountry() {
		return _country;
	}

	public void setCountry(String country) {
		_country = country;
	}

	public long getIsmId() {
		return _ismId;
	}

	public void setIsmId(long ismId) {
		_ismId = ismId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getStatusByUserId() {
		return _statusByUserId;
	}

	public void setStatusByUserId(long statusByUserId) {
		_statusByUserId = statusByUserId;
	}

	public String getStatusByUserName() {
		return _statusByUserName;
	}

	public void setStatusByUserName(String statusByUserName) {
		_statusByUserName = statusByUserName;
	}

	public Date getStatusDate() {
		return _statusDate;
	}

	public void setStatusDate(Date statusDate) {
		_statusDate = statusDate;
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

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getApplicationReason() {
		return _applicationReason;
	}

	public void setApplicationReason(String applicationReason) {
		_applicationReason = applicationReason;
	}

	public String getApplicationAdditional() {
		return _applicationAdditional;
	}

	public void setApplicationAdditional(String applicationAdditional) {
		_applicationAdditional = applicationAdditional;
	}

	private String _uuid;
	private long _ismApplicationId;
	private String _country;
	private long _ismId;
	private int _status;
	private long _statusByUserId;
	private String _statusByUserName;
	private Date _statusDate;
	private long _companyId;
	private long _groupId;
	private long _userId;
	private String _applicationReason;
	private String _applicationAdditional;
}