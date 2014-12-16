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

package org.un.ldcportal.jargon.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import org.un.ldcportal.jargon.model.LDCJargon;

import java.io.Serializable;

/**
 * The cache model class for representing LDCJargon in entity cache.
 *
 * @author Thibault Boyeux
 * @see LDCJargon
 * @generated
 */
public class LDCJargonCacheModel implements CacheModel<LDCJargon>, Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{ldcJargonId=");
		sb.append(ldcJargonId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", definition=");
		sb.append(definition);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append("}");

		return sb.toString();
	}

	public LDCJargon toEntityModel() {
		LDCJargonImpl ldcJargonImpl = new LDCJargonImpl();

		ldcJargonImpl.setLdcJargonId(ldcJargonId);

		if (name == null) {
			ldcJargonImpl.setName(StringPool.BLANK);
		}
		else {
			ldcJargonImpl.setName(name);
		}

		if (definition == null) {
			ldcJargonImpl.setDefinition(StringPool.BLANK);
		}
		else {
			ldcJargonImpl.setDefinition(definition);
		}

		ldcJargonImpl.setCompanyId(companyId);
		ldcJargonImpl.setGroupId(groupId);

		ldcJargonImpl.resetOriginalValues();

		return ldcJargonImpl;
	}

	public long ldcJargonId;
	public String name;
	public String definition;
	public long companyId;
	public long groupId;
}