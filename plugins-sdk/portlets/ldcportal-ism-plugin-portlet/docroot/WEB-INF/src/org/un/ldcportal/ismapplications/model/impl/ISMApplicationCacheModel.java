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

package org.un.ldcportal.ismapplications.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.un.ldcportal.ismapplications.model.ISMApplication;

import java.io.Serializable;

import java.util.Date;

/**
 * The cache model class for representing ISMApplication in entity cache.
 *
 * @author Thibault Boyeux
 * @see ISMApplication
 * @generated
 */
public class ISMApplicationCacheModel implements CacheModel<ISMApplication>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", ismApplicationId=");
		sb.append(ismApplicationId);
		sb.append(", country=");
		sb.append(country);
		sb.append(", ismId=");
		sb.append(ismId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserId=");
		sb.append(statusByUserId);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", statusDate=");
		sb.append(statusDate);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", applicationReason=");
		sb.append(applicationReason);
		sb.append(", applicationAdditional=");
		sb.append(applicationAdditional);
		sb.append("}");

		return sb.toString();
	}

	public ISMApplication toEntityModel() {
		ISMApplicationImpl ismApplicationImpl = new ISMApplicationImpl();

		if (uuid == null) {
			ismApplicationImpl.setUuid(StringPool.BLANK);
		}
		else {
			ismApplicationImpl.setUuid(uuid);
		}

		ismApplicationImpl.setIsmApplicationId(ismApplicationId);

		if (country == null) {
			ismApplicationImpl.setCountry(StringPool.BLANK);
		}
		else {
			ismApplicationImpl.setCountry(country);
		}

		ismApplicationImpl.setIsmId(ismId);
		ismApplicationImpl.setStatus(status);
		ismApplicationImpl.setStatusByUserId(statusByUserId);

		if (statusByUserName == null) {
			ismApplicationImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			ismApplicationImpl.setStatusByUserName(statusByUserName);
		}

		if (statusDate == Long.MIN_VALUE) {
			ismApplicationImpl.setStatusDate(null);
		}
		else {
			ismApplicationImpl.setStatusDate(new Date(statusDate));
		}

		ismApplicationImpl.setCompanyId(companyId);
		ismApplicationImpl.setGroupId(groupId);
		ismApplicationImpl.setUserId(userId);

		if (applicationReason == null) {
			ismApplicationImpl.setApplicationReason(StringPool.BLANK);
		}
		else {
			ismApplicationImpl.setApplicationReason(applicationReason);
		}

		if (applicationAdditional == null) {
			ismApplicationImpl.setApplicationAdditional(StringPool.BLANK);
		}
		else {
			ismApplicationImpl.setApplicationAdditional(applicationAdditional);
		}

		ismApplicationImpl.resetOriginalValues();

		return ismApplicationImpl;
	}

	public String uuid;
	public long ismApplicationId;
	public String country;
	public long ismId;
	public int status;
	public long statusByUserId;
	public String statusByUserName;
	public long statusDate;
	public long companyId;
	public long groupId;
	public long userId;
	public String applicationReason;
	public String applicationAdditional;
}