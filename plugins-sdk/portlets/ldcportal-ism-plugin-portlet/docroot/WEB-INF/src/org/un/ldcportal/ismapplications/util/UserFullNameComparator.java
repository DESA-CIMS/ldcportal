package org.un.ldcportal.ismapplications.util;

import java.util.Comparator;

import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;

/**
 * 
 * ISM Plugin Package
 * United Nations Support Measures Portal v2
 * http://www.un.org/ldcportal 
 * 
 * User Comparator by Full Name (First Name + Last Name, no Middle Name)
 * 
 * @author Thibault Boyeux (thibault.boyeux@gmail.com), 2012
 *
 */

public class UserFullNameComparator implements Comparator<User> {

	@Override
	public int compare(User user1, User user2) {
		String user1FullName = user1.getFirstName() + StringPool.BLANK + user1.getLastName();
		String user2FullName = user2.getFirstName() + StringPool.BLANK + user2.getLastName();
		
		if (user1FullName.compareToIgnoreCase(user2FullName) > 0) {
			return 1;
		}
		else if (user1FullName.compareToIgnoreCase(user2FullName) < 0) {
			return -1;
		}
		else {
			return 0;
		}
		
	}
	
}
