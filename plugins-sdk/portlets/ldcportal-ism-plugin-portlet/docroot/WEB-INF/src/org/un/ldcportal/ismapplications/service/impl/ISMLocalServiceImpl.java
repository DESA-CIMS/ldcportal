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

package org.un.ldcportal.ismapplications.service.impl;

import java.util.List;

import org.un.ldcportal.ismapplications.NoSuchISMException;
import org.un.ldcportal.ismapplications.model.ISM;
import org.un.ldcportal.ismapplications.service.base.ISMLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.ResourceConstants;

/**
 * The implementation of the i s m local service. <p> All custom service methods
 * should be put in this class. Whenever methods are added, rerun ServiceBuilder
 * to copy their definitions into the
 * {@link org.un.ldcportal.ismapplications.service.ISMLocalService} interface.
 * <p> This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM. </p>
 * 
 * @author Thibault Boyeux
 * @see org.un.ldcportal.ismapplications.service.base.ISMLocalServiceBaseImpl
 * @see org.un.ldcportal.ismapplications.service.ISMLocalServiceUtil
 */
public class ISMLocalServiceImpl extends ISMLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS: Never reference this interface directly. Always use
	 * {@link org.un.ldcportal.ismapplications.service.ISMLocalServiceUtil} to
	 * access the i s m local service.
	 */

	public ISM addNewISM(ISM newISM)
		throws SystemException, PortalException {

		ISM ism = ismPersistence.create(counterLocalService.increment(ISM.class.getName()));

		resourceLocalService.addResources(newISM.getCompanyId(), newISM.getGroupId(), ISM.class.getName(), false);

		ism.setWebContentId(newISM.getWebContentId());
		ism.setCompanyId(newISM.getCompanyId());
		ism.setGroupId(newISM.getGroupId());

		return ismPersistence.update(ism, false);
	}

	public void deleteISM(long ismId)
		throws NoSuchISMException, SystemException, PortalException {

		ISM ism = ismPersistence.findByPrimaryKey(ismId);
		deleteISM(ism);
	}

	public void deleteISM(ISM ism)
		throws PortalException, SystemException {

		resourceLocalService.deleteResource(
			ism.getCompanyId(), ISM.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, ism.getPrimaryKey());

		ismPersistence.remove(ism);
	}
	
	public List<ISM> getAllISMs(long groupId)
		throws SystemException {

		List<ISM> isms = ismPersistence.findByGroupId(groupId);
		return isms;
	}

	public ISM getISMByWebContentId(long webContentId)
		throws SystemException {

		ISM ism;
		try {
			ism = ismPersistence.findByWebContendId(webContentId);
			return ism;
		}
		catch (NoSuchISMException e) {
			return null;
		}
	}

	public ISM getISM(long ismId)
		throws SystemException {

		ISM ism;

		try {
			ism = ismPersistence.findByismId(ismId);
			return ism;
		}
		catch (NoSuchISMException e) {
			return null;
		}
	}

	public ISM getISM(long groupId, long ismId)
		throws SystemException {

		ISM ism;

		try {
			ism = ismPersistence.findByG_I(ismId, groupId);
			return ism;
		}
		catch (NoSuchISMException e) {
			return null;
		}
	}

	public List<ISM> getISMByMBCategoryId(long mbCategoryId)
		throws SystemException {

		List<ISM> isms = ismPersistence.findBymbCategoryId(mbCategoryId);
		return isms;
	}
	
	public boolean ismExistsByWebContendId(long webContentId) throws SystemException {
		if (ismPersistence.countByWebContendId(webContentId) > 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public boolean ismExistsByMBCategoryId(long mbCategoryId) throws SystemException {
		if (ismPersistence.countBymbCategoryId(mbCategoryId) > 0) {
			return true;
		}
		else {
			return false;
		}
	}
}
