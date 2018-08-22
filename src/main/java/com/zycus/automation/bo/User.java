package com.zycus.automation.bo;

import com.zycus.automation.constants.IConstants;

public class User implements Comparable<User>
{
	private static int		counter	= 0;

	private int				id;
	private String			username;
	private String			password;
	private String			role;
	private String			tenant;
	private String			displayName;
	private String			searchUserByOption;
	private boolean			isActive;
	private boolean			result;
	private UserSettings	userSettings;

	public UserSettings getUserSettings()
	{
		return userSettings;
	}

	public void setUserSettings(UserSettings userSettings)
	{
		this.userSettings = userSettings;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public User()
	{
		setId(++counter);
		setActive(IConstants.ACTIVE);
	}

	public boolean isActive()
	{
		return isActive;
	}

	public void setActive(boolean isActive)
	{
		this.isActive = isActive;
	}

	public String getDisplayName()
	{
		return displayName;
	}

	public void setDisplayName(String displayName)
	{
		this.displayName = displayName;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getRole()
	{
		return role;
	}

	public void setRole(String role)
	{
		this.role = role;
	}

	public String getTenant()
	{
		return tenant;
	}

	public void setTenant(String tenant)
	{
		this.tenant = tenant;
	}

	public String getSearchUserByOption()
	{
		return searchUserByOption;
	}

	public void setSearchUserByOption(String searchUserByOption)
	{
		this.searchUserByOption = searchUserByOption;
	}

	@Override
	public int hashCode()
	{
		return id;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj == null)
		{
			return false;
		}
		if (this.id == obj.hashCode())
		{
			return true;
		}
		if (getClass() != obj.getClass())
		{
			return false;
		}
		return false;
	}


	public int compareTo(User user)
	{
		Integer key1 = this.getId();
		Integer key2 = user.getId();
		return key1.compareTo(key2);
	}

	public boolean isResult()
	{
		return result;
	}

	public void setResult(boolean result)
	{
		this.result = result;
	}

	@Override
	public String toString()
	{
		return "User [id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + ", tenant=" + tenant + ", displayName=" + displayName + ", isActive="
			+ isActive + "]";
	}

}
