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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.io.Serializable;

import org.un.ldcportal.ismapplications.model.ISMApplication;
import org.un.ldcportal.ismapplications.service.base.ISMApplicationLocalServiceBaseImpl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

/**
 * The implementation of the i s m application local service. <p> All custom
 * service methods should be put in this class. Whenever methods are added,
 * rerun ServiceBuilder to copy their definitions into the
 * {@link org.un.ldcportal.ismapplications.service.ISMApplicationLocalService}
 * interface. <p> This is a local service. Methods of this service will not have
 * security checks based on the propagated JAAS credentials because this service
 * can only be accessed from within the same VM. </p>
 * 
 * @author Thibault Boyeux
 * @see org.un.ldcportal.ismapplications.service.base.ISMApplicationLocalServiceBaseImpl
 * @see org.un.ldcportal.ismapplications.service.ISMApplicationLocalServiceUtil
 */
public class ISMApplicationLocalServiceImpl extends ISMApplicationLocalServiceBaseImpl {

	public ISMApplication addISMApplication(ISMApplication newISMApplication, long userId, ServiceContext serviceContext)
		throws SystemException, PortalException {
		
		
		ISMApplication ismApplication =
			ismApplicationPersistence.create(counterLocalService.increment(ISMApplication.class.getName()));

		ismApplication.setCompanyId(newISMApplication.getCompanyId());
		ismApplication.setGroupId(newISMApplication.getGroupId());
		ismApplication.setUserId(serviceContext.getUserId());
		ismApplication.setApplicationReason(newISMApplication.getApplicationReason());
		ismApplication.setApplicationAdditional(newISMApplication.getApplicationAdditional());
		ismApplication.setIsmId(newISMApplication.getIsmId());
		ismApplication.setStatus(WorkflowConstants.STATUS_DRAFT);
		
		ismApplicationPersistence.update(ismApplication, false);	

		resourceLocalService.addResources(
			newISMApplication.getCompanyId(), newISMApplication.getGroupId(), userId, ISMApplication.class.getName(),
			ismApplication.getPrimaryKey(), false, true, true);

		
		assetEntryLocalService.updateEntry(
			userId, ismApplication.getGroupId(), ISMApplication.class.getName(), ismApplication.getIsmApplicationId(),
			serviceContext.getAssetCategoryIds(), serviceContext.getAssetTagNames());

	
		// Workflow
		long moderatorId = ismLocalService.getISM(newISMApplication.getIsmId()).getModeratorId();	
		
		Map<String, Serializable> workflowContext = new HashMap<String, Serializable>();
		workflowContext.put(ISM_MODERATOR_ID, moderatorId);
		
		WorkflowHandlerRegistryUtil.startWorkflowInstance(
			ismApplication.getCompanyId(), ismApplication.getGroupId(), userId, ISMApplication.class.getName(),
			ismApplication.getPrimaryKey(), ismApplication, serviceContext, workflowContext);	

		return ismApplication;
	}

	public void deleteISMApplication(ISMApplication ismApplication)
		throws SystemException, PortalException {

		long companyId = ismApplication.getCompanyId();

		resourceLocalService.deleteResource(
			companyId, ISMApplication.class.getName(), ResourceConstants.SCOPE_INDIVIDUAL, ismApplication.getPrimaryKey());

//		assetEntryLocalService.deleteEntry(ISMApplication.class.getName(), ismApplication.getIsmApplicationId());

		ismApplicationPersistence.remove(ismApplication);
	}

	public ISMApplication updateStatus(long userId, long resourcePrimKey, int status, ServiceContext serviceContext)
		throws PortalException, SystemException {
		User user = userLocalService.getUser(userId);
		ISMApplication ismApplication = getISMApplication(resourcePrimKey);
		ismApplication.setStatus(status);
		ismApplication.setStatusByUserId(userId);
		ismApplication.setStatusByUserName(user.getFullName());
		ismApplication.setStatusDate(serviceContext.getModifiedDate());
		
		ismApplicationPersistence.update(ismApplication, false);
		
		return ismApplication;
	}	

	public List<ISMApplication> getAllISMApplications(long groupId)
		throws SystemException {

		List<ISMApplication> ismApplications = ismApplicationPersistence.findByGroupId(groupId);

		return ismApplications;
	}

	public List<ISMApplication> getByCompanyId(long companyId)
		throws SystemException {

		List<ISMApplication> ismApplications = ismApplicationPersistence.findByCompanyId(companyId);

		return ismApplications;
	}

	public List<ISMApplication> getByStatus(long groupId, int status)
		throws SystemException {

		List<ISMApplication> ismApplications = ismApplicationPersistence.findByG_S(groupId, status);

		return ismApplications;
	}
	
	public static final String ISM_MODERATOR_ID = "ismModeratorId";
}