/**
 * 
 */
package com.zycus.automation.bo;

/**
 * @author ankita.sawant
 *
 */
public class BudgetLine
{
	private String				businessUnit		= null;
	private String				location			= null;
	private String				costCenter			= null;
	private String				department			= null;
	private String				designation			= null;
	private String				project				= null;
	private String				budgetLineCode		= null;
	private String				budgetLineName		= null;
	private String				owner				= null;
	private String				plannedAmount		= null;
	private String				nextAction			= null;
	private boolean				isAutoGenerate		= false;
	private boolean				isUploadViaFile		= false;
	private String				fileName			= null;
	private boolean				result				= false;
	private boolean				isbudgetLineSetting	= false;
	private BudgetLineSetting	budgetLineSetting	= null;

	public BudgetLineSetting getBudgetLineSetting()
	{
		return budgetLineSetting;
	}

	public void setBudgetLineSetting(BudgetLineSetting budgetLineSetting)
	{
		this.budgetLineSetting = budgetLineSetting;
	}

	public boolean isIsbudgetLineSetting()
	{
		return isbudgetLineSetting;
	}

	public void setIsbudgetLineSetting(boolean isbudgetLineSetting)
	{
		this.isbudgetLineSetting = isbudgetLineSetting;
	}

	public String getProject()
	{
		return project;
	}

	public void setProject(String project)
	{
		this.project = project;
	}

	public boolean isResult()
	{
		return result;
	}

	public void setResult(boolean result)
	{
		this.result = result;
	}

	public String getLocation()
	{
		return location;
	}

	public void setLocation(String location)
	{
		this.location = location;
	}

	public String getCostCenter()
	{
		return costCenter;
	}

	public void setCostCenter(String costCenter)
	{
		this.costCenter = costCenter;
	}

	public String getDepartment()
	{
		return department;
	}

	public void setDepartment(String department)
	{
		this.department = department;
	}

	public String getDesignation()
	{
		return designation;
	}

	public void setDesignation(String designation)
	{
		this.designation = designation;
	}

	public boolean isAutoGenerate()
	{
		return isAutoGenerate;
	}

	public void setAutoGenerate(boolean isAutoGenerate)
	{
		this.isAutoGenerate = isAutoGenerate;
	}

	public boolean isUploadViaFile()
	{
		return isUploadViaFile;
	}

	public void setUploadViaFile(boolean isUploadViaFile)
	{
		this.isUploadViaFile = isUploadViaFile;
	}

	public String getFileName()
	{
		return fileName;
	}

	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	public String getBusinessUnit()
	{
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit)
	{
		this.businessUnit = businessUnit;
	}

	public String getBudgetLineCode()
	{
		return budgetLineCode;
	}

	public void setBudgetLineCode(String budgetLineCode)
	{
		this.budgetLineCode = budgetLineCode;
	}

	public String getBudgetLineName()
	{
		return budgetLineName;
	}

	public void setBudgetLineName(String budgetLineName)
	{
		this.budgetLineName = budgetLineName;
	}

	public String getOwner()
	{
		return owner;
	}

	public void setOwner(String owner)
	{
		this.owner = owner;
	}

	public String getPlannedAmount()
	{
		return plannedAmount;
	}

	public void setPlannedAmount(String plannedAmount)
	{
		this.plannedAmount = plannedAmount;
	}

	public String getNextAction()
	{
		return nextAction;
	}

	public void setNextAction(String nextAction)
	{
		this.nextAction = nextAction;
	}

}
