package com.zycus.automation.bo;

/**
 * @author kunal.ashar
 *
 */
public class AdminMonitoring
{

	private String	admin_Url			= null;
	private String	username			= null;
	private String	password			= null;
	private String	userAccount			= null;
	private String	activity			= null;
	private String	tenant				= null;
	private String	entity_Type			= null;
	private String	destination_system	= null;
	private String	status				= null;
	private String	nextAction			= null;

	// to set run-time values
	private String	entityId			= null;

	public String getAdminUrl()
	{
		return admin_Url;
	}

	public void setAdminUrl(String admin_Url)
	{
		this.admin_Url = admin_Url;
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

	public String getUserAccount()
	{
		return userAccount;
	}

	public void setUserAccount(String userAccount)
	{
		this.userAccount = userAccount;
	}

	public String getActivity()
	{
		return activity;
	}

	public void setActivity(String activity)
	{
		this.activity = activity;
	}

	public String getTenant()
	{
		return tenant;
	}

	public void setTenant(String tenant)
	{
		this.tenant = tenant;
	}

	public String getEntityType()
	{
		return entity_Type;
	}

	public void setEntityType(String entity_Type)
	{
		this.entity_Type = entity_Type;
	}

	public String getDestinationSystem()
	{
		return destination_system;
	}

	public void setDestinationSystem(String destination_system)
	{
		this.destination_system = destination_system;
	}

	public String getStatus()
	{
		return status;
	}

	public void setStatus(String status)
	{
		this.status = status;
	}

	public String getNextAction()
	{
		return nextAction;
	}

	public void setNextAction(String nextAction)
	{
		this.nextAction = nextAction;
	}

	public String getEntityID()
	{
		return entityId;
	}

	public void setEntityID(String entityId)
	{
		this.entityId = entityId;
	}
}
