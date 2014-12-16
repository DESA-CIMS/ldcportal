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
import com.liferay.portal.model.CacheModel;

import org.un.ldcportal.ismapplications.model.ISM;

import java.io.Serializable;

/**
 * The cache model class for representing ISM in entity cache.
 *
 * @author Thibault Boyeux
 * @see ISM
 * @generated
 */
public class ISMCacheModel implements CacheModel<ISM>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(15);

		sb.append("{ismId=");
		sb.append(ismId);
		sb.append(", webContentId=");
		sb.append(webContentId);
		sb.append(", moderatorId=");
		sb.append(moderatorId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", mbCategoryId=");
		sb.append(mbCategoryId);
		sb.append(", assetCategoryId=");
		sb.append(assetCategoryId);
		sb.append("}");

		return sb.toString();
	}

	public ISM toEntityModel() {
		ISMImpl ismImpl = new ISMImpl();

		ismImpl.setIsmId(ismId);
		ismImpl.setWebContentId(webContentId);
		ismImpl.setModeratorId(moderatorId);
		ismImpl.setCompanyId(companyId);
		ismImpl.setGroupId(groupId);
		ismImpl.setMbCategoryId(mbCategoryId);
		ismImpl.setAssetCategoryId(assetCategoryId);

		ismImpl.resetOriginalValues();

		return ismImpl;
	}

	public long ismId;
	public long webContentId;
	public long moderatorId;
	public long companyId;
	public long groupId;
	public long mbCategoryId;
	public long assetCategoryId;
}