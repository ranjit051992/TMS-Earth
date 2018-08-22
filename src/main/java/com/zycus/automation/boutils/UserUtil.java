package com.zycus.automation.boutils;

import com.zycus.automation.bo.User;
import com.zycus.automation.boutilshelper.UserUtilHelper;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;

public class UserUtil extends UserUtilHelper
{

	public static User getDefaultUsernameAndPassword()
	{
		getAvailableUser();
		User usernameAndPassword = new User();
		// Properties properties = PropertyReader.configProperty;
		usernameAndPassword.setUsername(ConfigProperty.getConfig("Username"));
		usernameAndPassword.setPassword(ConfigProperty.getConfig("Password"));
		usernameAndPassword.setTenant(ConfigProperty.getConfig("Tenant"));
		usernameAndPassword.setRole(ConfigProperty.getConfig("Role"));

		/*
		 * if (!isUserAvaliable(usernameAndPassword)) { //for (User user :
		 * users) Iterator<User> userList = users.iterator(); while
		 * (userList.hasNext()) { User user = userList.next();
		 * System.out.println("User :->" + user); if
		 * (user.getUsername().equalsIgnoreCase(usernameAndPassword.getUsername(
		 * )) && user.getId() != usernameAndPassword.getId()) {
		 * removeUserFromList(user); addUserToList(usernameAndPassword); break;
		 * }
		 * 
		 * } }
		 */
		return usernameAndPassword;
	}
}
