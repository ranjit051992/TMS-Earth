package com.zycus.automation.bo;

public class Project
{
	String			projectName;
	Integer			projectNumber;
	String			company;
	String			changStatus;
	CustomDate		customDate;
	private String	BUName	= null;

	public String getBUName()
	{
		return BUName;
	}

	public void setBUName(String bUName)
	{
		BUName = bUName;
	}

	public String getProjectName()
	{
		return projectName;
	}

	public void setProjectName(String projectName)
	{
		this.projectName = projectName;
	}

	public Integer getProjectNumber()
	{
		return projectNumber;
	}

	public void setProjectNumber(Integer projectNumber)
	{
		this.projectNumber = projectNumber;
	}

	public String getCompany()
	{
		return company;
	}

	public void setCompany(String company)
	{
		this.company = company;
	}

	public String getChangStatus()
	{
		return changStatus;
	}

	public void setChangStatus(String changStatus)
	{
		this.changStatus = changStatus;
	}

	public CustomDate getCustomDate()
	{
		return customDate;
	}

	public void setCustomDate(CustomDate customDate)
	{
		this.customDate = customDate;
	}

}
