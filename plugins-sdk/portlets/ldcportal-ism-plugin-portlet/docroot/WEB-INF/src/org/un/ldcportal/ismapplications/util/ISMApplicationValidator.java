package org.un.ldcportal.ismapplications.util;

import java.util.List;

import org.un.ldcportal.ismapplications.model.ISMApplication;

import com.liferay.portal.kernel.util.Validator;

/**
 * 
 * ISM Plugin Package
 * United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal 
 * 
 * Used to validate an application : check whether the "reason" field has been filled
 * 
 * @author Thibault Boyeux (thibault.boyeux@gmail.com), 2012
 *
 */

public class ISMApplicationValidator {

    public static boolean validateISMApplication (ISMApplication ismApplication, List<String> errors) {

        boolean valid = true;

        if (Validator.isNull(ismApplication.getApplicationReason())) {
            valid = false;
            errors.add("reason-required");
        }

        return valid;
    }

}