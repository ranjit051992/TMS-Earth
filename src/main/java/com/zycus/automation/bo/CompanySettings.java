package com.zycus.automation.bo;

public class CompanySettings
{
	String	companyName;
	String	changStatus;

	public String getCompanyName()
	{
		return companyName;
	}

	public void setCompanyName(String companyName)
	{
		this.companyName = companyName;
	}

	public String getChangStatus()
	{
		return changStatus;
	}

	public void setChangStatus(String changStatus)
	{
		this.changStatus = changStatus;
	}

	@Override
	public String toString()
	{
		return "CompanySettings [companyName=" + companyName + ", changStatus=" + changStatus + "]";
	}

}
