package org.un.ldcportal.ismapplications.workflow;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;

import org.un.ldcportal.ismapplications.model.ISMApplication;
import org.un.ldcportal.ismapplications.service.ISMApplicationLocalServiceUtil;
import org.un.ldcportal.ismapplications.util.WorkflowConstants;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.workflow.BaseWorkflowHandler;
import com.liferay.portal.security.permission.ResourceActionsUtil;
import com.liferay.portal.service.ServiceContext;


public class ISMApplicationWorkflowHandler extends BaseWorkflowHandler {

	@Override
	public String getClassName() {

		return CLASS_NAME;
	}

	@Override
	public String getType(Locale locale) {

		return ResourceActionsUtil.getModelResource(locale, CLASS_NAME);
	}

	@Override
	public Object updateStatus(int status, Map<String, Serializable> workflowContext)
		throws PortalException, SystemException {

		long userId = GetterUtil.getLong(workflowContext.get(WorkflowConstants.CONTEXT_USER_ID));
		
		long resourcePrimKey = GetterUtil.getLong(workflowContext.get(WorkflowConstants.CONTEXT_ENTRY_CLASS_PK));		
		
		ServiceContext serviceContext = (ServiceContext) workflowContext.get("serviceContext");
		
		return ISMApplicationLocalServiceUtil.updateStatus(userId, resourcePrimKey, status, serviceContext);
	}
	
	public static final String CLASS_NAME = ISMApplication.class.getName();

}