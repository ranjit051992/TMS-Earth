package eProc.productUtilities.userListing;

public class UserBO
{

	private String	username;
	private String	password;
	private String	role	= "Global_Role";
	private String	tenant;
	private String	setup;
	private String	displayName;
	private boolean	isActive;

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

	public String getSetUpName()
	{
		return setup;
	}

	public void setSetUpName(String setupName)
	{
		this.setup = setupName;
	}

	public String toString()
	{
		return "User [username=" + username + ", password=" + password + ", role=" + role + ", tenant=" + tenant + ", displayName=" + displayName + ", setup=" + setup + ", isActive=" + isActive + "]";
	}
}
