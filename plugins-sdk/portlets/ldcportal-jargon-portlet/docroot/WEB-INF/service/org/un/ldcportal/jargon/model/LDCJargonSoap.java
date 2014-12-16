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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    Thibault Boyeux
 * @generated
 */
public class LDCJargonSoap implements Serializable {
	public static LDCJargonSoap toSoapModel(LDCJargon model) {
		LDCJargonSoap soapModel = new LDCJargonSoap();

		soapModel.setLdcJargonId(model.getLdcJargonId());
		soapModel.setName(model.getName());
		soapModel.setDefinition(model.getDefinition());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setGroupId(model.getGroupId());

		return soapModel;
	}

	public static LDCJargonSoap[] toSoapModels(LDCJargon[] models) {
		LDCJargonSoap[] soapModels = new LDCJargonSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LDCJargonSoap[][] toSoapModels(LDCJargon[][] models) {
		LDCJargonSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LDCJargonSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LDCJargonSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LDCJargonSoap[] toSoapModels(List<LDCJargon> models) {
		List<LDCJargonSoap> soapModels = new ArrayList<LDCJargonSoap>(models.size());

		for (LDCJargon model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LDCJargonSoap[soapModels.size()]);
	}

	public LDCJargonSoap() {
	}

	public long getPrimaryKey() {
		return _ldcJargonId;
	}

	public void setPrimaryKey(long pk) {
		setLdcJargonId(pk);
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

	private long _ldcJargonId;
	private String _name;
	private String _definition;
	private long _companyId;
	private long _groupId;
}