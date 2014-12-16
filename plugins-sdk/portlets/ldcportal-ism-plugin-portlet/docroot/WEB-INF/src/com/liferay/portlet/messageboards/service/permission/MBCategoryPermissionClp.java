package com.liferay.portlet.messageboards.service.permission;

import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.kernel.util.PortalClassInvoker;
import com.liferay.portal.security.permission.PermissionChecker;

/**
 * ISM Plugin Package
 * United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal 
 * 
 * Delegates to com.liferay.portlet.messageboards.service.permission.MBCategoryPermission This class is
 * located in the ROOT (portal) service context and as such we cannot access it directly. This class uses classloader
 * trickery to still call methods on this class so we do not have to duplicate the logic here.
 *
 * @author Jelmer Kuperus
 * @author Thibault Boyeux
 */

public class MBCategoryPermissionClp {

    private static final String DELEGATE_CLASS_NAME =
            "com.liferay.portlet.messageboards.service.permission.MBCategoryPermission";

    /**
     * Returns true if the logged in user has permission to execute the action identified by the passed in actionId
     * on the MBMessage uniquely identified by the passed in messageId
     *
     * @param permissionChecker the permission checker used to check the permissions
     * @param categoryId uniquely identifies the the category you want to check the permissions of
     * @param actionId the identifier of the action you want to check if the logged in user has
     * @return true if the logged in user has permission to execute the action identified by the passed in actionId
     * on the MBMessage uniquely identified by the passed in messageId
     */
    public static boolean contains(PermissionChecker permissionChecker, long categoryId, String actionId) {

        MethodKey key = new MethodKey(DELEGATE_CLASS_NAME, "contains", PermissionChecker.class, long.class,
                                      String.class);
        try {
            return (Boolean) PortalClassInvoker.invoke(false, key, permissionChecker, categoryId, actionId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}