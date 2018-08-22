package com.zycus.automation.bo;

public class ChangeMultiple
{

	private String		glAccount		= null;
	private String		costCenter		= null;
	private String		budget			= null;
	private String		project			= null;
	private CustomDate	requiredByDate	= new CustomDate();

	public String getGlAccount()
	{
		return glAccount;
	}

	public void setGlAccount(String glAccount)
	{
		this.glAccount = glAccount;
	}

	public String getCostCenter()
	{
		return costCenter;
	}

	public void setCostCenter(String costCenter)
	{
		this.costCenter = costCenter;
	}

	public String getBudget()
	{
		return budget;
	}

	public void setBudget(String budget)
	{
		this.budget = budget;
	}

	public String getProject()
	{
		return project;
	}

	public void setProject(String project)
	{
		this.project = project;
	}

	public CustomDate getRequiredByDate()
	{
		return requiredByDate;
	}

	public void setRequiredByDate(CustomDate requiredByDate)
	{
		this.requiredByDate = requiredByDate;
	}

	@Override
	public String toString()
	{
		return "ChangeMultiple [glAccount=" + glAccount + ", costCenter=" + costCenter + ", budget=" + budget + ", project=" + project + ", requiredByDate=" + requiredByDate + "]";
	}

}
