package org.un.ldcportal.ismapplications.asset;

import org.un.ldcportal.ismapplications.model.ISMApplication;
import org.un.ldcportal.ismapplications.service.ISMApplicationLocalServiceUtil;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portlet.asset.model.AssetRenderer;
import com.liferay.portlet.asset.model.BaseAssetRendererFactory;

/**
 * 
 * ISM Plugin Package
 * United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal 
 * 
 * ISM Application AssetRendererFactory class
 * 
 * @author Thibault Boyeux (thibault.boyeux@gmail.com), 2012
 *
 */

public class ISMApplicationAssetRendererFactory extends BaseAssetRendererFactory {
	public static final String CLASS_NAME = ISMApplication.class.getName();

    public static final String TYPE = "ismApplication";

    public AssetRenderer getAssetRenderer(long classPK, int type)
        throws PortalException, SystemException {

        ISMApplication ismApplication = ISMApplicationLocalServiceUtil.getISMApplication(classPK);

        return new ISMApplicationAssetRenderer(ismApplication);
    }

    public String getClassName() {
        return CLASS_NAME;
    }

    public String getType() {
        return TYPE;
    }
}