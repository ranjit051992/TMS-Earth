/**
 * 
 */
package com.zycus.automation.bo;

/**
 * @author ankita.sawant
 *
 */
public class BudgetDimension
{
	private boolean	businessUnit	= false;
	private boolean	location		= false;
	private boolean	costCenter		= false;
	private boolean	department		= false;
	private boolean	designation		= false;
	private boolean	project			= false;
	private boolean	glAccount		= false;
	private boolean	category		= false;

	public boolean isProject()
	{
		return project;
	}

	public void setProject(boolean project)
	{
		this.project = project;
	}

	public boolean isGlAccount()
	{
		return glAccount;
	}

	public void setGlAccount(boolean glAccount)
	{
		this.glAccount = glAccount;
	}

	public boolean isBusinessUnit()
	{
		return businessUnit;
	}

	public void setBusinessUnit(boolean businessUnit)
	{
		this.businessUnit = businessUnit;
	}

	public boolean isLocation()
	{
		return location;
	}

	public void setLocation(boolean location)
	{
		this.location = location;
	}

	public boolean isCostCenter()
	{
		return costCenter;
	}

	public void setCostCenter(boolean costCenter)
	{
		this.costCenter = costCenter;
	}

	public boolean isDepartment()
	{
		return department;
	}

	public void setDepartment(boolean department)
	{
		this.department = department;
	}

	public boolean isDesignation()
	{
		return designation;
	}

	public void setDesignation(boolean designation)
	{
		this.designation = designation;
	}

	public boolean isCategory()
	{
		return category;
	}

	public void setCategory(boolean category)
	{
		this.category = category;
	}

}
