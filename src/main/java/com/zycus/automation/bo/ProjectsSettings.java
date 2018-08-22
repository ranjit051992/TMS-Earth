package com.zycus.automation.bo;

public class ProjectsSettings
{
	private String assignProjecttoPurchaseCost;

	public String getAssignProjecttoPurchaseCost()
	{
		return assignProjecttoPurchaseCost;
	}

	public void setAssignProjecttoPurchaseCost(String assignProjecttoPurchaseCost)
	{
		this.assignProjecttoPurchaseCost = assignProjecttoPurchaseCost;
	}

	@Override
	public String toString()
	{
		return "ProjectsSettings [assignProjecttoPurchaseCost=" + assignProjecttoPurchaseCost + ", getAssignProjecttoPurchaseCost()=" + getAssignProjecttoPurchaseCost()
			+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
