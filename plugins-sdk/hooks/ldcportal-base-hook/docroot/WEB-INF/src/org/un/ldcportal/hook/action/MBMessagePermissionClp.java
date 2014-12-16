package org.un.ldcportal.hook.action;

import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.kernel.util.PortalClassInvoker;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.portlet.messageboards.model.MBMessage;

/**
 * Delegates to com.liferay.portlet.messageboards.service.permission.MBCategoryPermission This class is
 * located in the ROOT (portal) service context and as such we cannot access it directly. This class uses classloader
 * trickery to still call methods on this class so we do not have to duplicate the logic here.
 *
 * @author Jelmer Kuperus
 * @author Thibault Boyeux
 */

public class MBMessagePermissionClp {

    private static final String DELEGATE_CLASS_NAME =
            "com.liferay.portlet.messageboards.service.permission.MBMessagePermission";

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
    public static boolean contains(PermissionChecker permissionChecker, MBMessage message, String actionId) {

        MethodKey key = new MethodKey(DELEGATE_CLASS_NAME, "contains", PermissionChecker.class, MBMessage.class,
                                      String.class);
        try {
            return (Boolean) PortalClassInvoker.invoke(false, key, permissionChecker, message, actionId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}