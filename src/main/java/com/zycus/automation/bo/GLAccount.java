package com.zycus.automation.bo;

public class GLAccount
{
	String	glAccountName;
	String	company;
	String	glAccountType;
	int		glAccountCode;
	String	changeStatus;

	public String getGlAccountName()
	{
		return glAccountName;
	}

	public void setGlAccountName(String glAccountName)
	{
		this.glAccountName = glAccountName;
	}

	public String getCompany()
	{
		return company;
	}

	public void setCompany(String company)
	{
		this.company = company;
	}

	public String getGlAccountType()
	{
		return glAccountType;
	}

	public void setGlAccountType(String glAccountType)
	{
		this.glAccountType = glAccountType;
	}

	public int getGlAccountCode()
	{
		return glAccountCode;
	}

	public void setGlAccountCode(int glAccountCode)
	{
		this.glAccountCode = glAccountCode;
	}

	public String getChangeStatus()
	{
		return changeStatus;
	}

	public void setChangeStatus(String changeStatus)
	{
		this.changeStatus = changeStatus;
	}

	@Override
	public String toString()
	{
		return "GLAccount [changeStatus=" + changeStatus + "]";
	}

}
