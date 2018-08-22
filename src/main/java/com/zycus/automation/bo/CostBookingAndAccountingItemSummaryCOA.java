package com.zycus.automation.bo;

public class CostBookingAndAccountingItemSummaryCOA
{
	// generic form fields
	private String	splitBy				= null;	// to split on
									// Percentage/quantity/amount
	private String	percentage			= null;
	private String	quantity			= null;
	private String	amount				= null;
	private String	glAccount			= null;
	private String	costCenter			= null;
	private String	errorMessage		= null;

	// AmFam form fields
	private String	businessUnit		= null;
	private String	project				= null;
	private String	subAccount			= null;
	private String	product				= null;
	private String	geoAccount			= null;
	private String	operationalUnit		= null;

	// MayorBrown form fields
	private String	bookCostTo			= null;
	private String	matter				= null;
	private String	client				= null;
	private String	employee_Timekeeper	= null;
	private String	office				= null;
	private String	disbursementCode	= null;
	private String	department			= null;
	private String	description			= null;

	// Data from Excel
	private int		totalRows			= 0;

	// actions
	private int		split				= 1;	// split count
	private String	initialAction		= null;
	private String	nextAction			= null;
	private boolean	isCoaEdit			= false;

	// get UI Values
	private double	finalUIAmount		= 0;

	public String getBusinessUnit()
	{
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit)
	{
		this.businessUnit = businessUnit;
	}

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

	public String getProject()
	{
		return project;
	}

	public void setProject(String project)
	{
		this.project = project;
	}

	public String getSubAccount()
	{
		return subAccount;
	}

	public void setSubAccount(String subAccount)
	{
		this.subAccount = subAccount;
	}

	public String getProduct()
	{
		return product;
	}

	public void setProduct(String product)
	{
		this.product = product;
	}

	public String getGeoAccount()
	{
		return geoAccount;
	}

	public void setGeoAccount(String geoAccount)
	{
		this.geoAccount = geoAccount;
	}

	public String getOperationalUnit()
	{
		return operationalUnit;
	}

	public void setOperationalUnit(String operationalUnit)
	{
		this.operationalUnit = operationalUnit;
	}

	public String getPercentage()
	{
		return percentage;
	}

	public void setPercentage(String percentage)
	{
		this.percentage = percentage;
	}

	public String getQuantity()
	{
		return quantity;
	}

	public void setQuantity(String quantity)
	{
		this.quantity = quantity;
	}

	public String getAmount()
	{
		return amount;
	}

	public void setAmount(String amount)
	{
		this.amount = amount;
	}

	public String getSplitBy()
	{
		return splitBy;
	}

	public void setSplitBy(String splitBy)
	{
		this.splitBy = splitBy;
	}

	public String getBookCostTo()
	{
		return bookCostTo;
	}

	public void setBookCostTo(String bookCostTo)
	{
		this.bookCostTo = bookCostTo;
	}

	public String getMatter()
	{
		return matter;
	}

	public void setMatter(String matter)
	{
		this.matter = matter;
	}

	public String getClient()
	{
		return client;
	}

	public void setClient(String client)
	{
		this.client = client;
	}

	public String getEmployee_Timekeeper()
	{
		return employee_Timekeeper;
	}

	public void setEmployee_Timekeeper(String employee_Timekeeper)
	{
		this.employee_Timekeeper = employee_Timekeeper;
	}

	public String getOffice()
	{
		return office;
	}

	public void setOffice(String office)
	{
		this.office = office;
	}

	public String getDisbursementCode()
	{
		return disbursementCode;
	}

	public void setDisbursementCode(String disbursementCode)
	{
		this.disbursementCode = disbursementCode;
	}

	public String getDepartment()
	{
		return department;
	}

	public void setDepartment(String department)
	{
		this.department = department;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public int getTotalRows()
	{
		return totalRows;
	}

	public void setTotalRows(int totalRows)
	{
		this.totalRows = totalRows;
	}

	public int getSplit()
	{
		return split;
	}

	public void setSplit(int split)
	{
		this.split = split;
	}

	public String getInitialAction()
	{
		return initialAction;
	}

	public void setInitialAction(String initialAction)
	{
		this.initialAction = initialAction;
	}

	public String getNextAction()
	{
		return nextAction;
	}

	public void setNextAction(String nextAction)
	{
		this.nextAction = nextAction;
	}

	public String getErrorMessage()
	{
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage)
	{
		this.errorMessage = errorMessage;
	}

	public double getFinalUIAmount()
	{
		return finalUIAmount;
	}

	public void setFinalUIAmount(double finalUIAmount)
	{
		this.finalUIAmount = finalUIAmount;
	}

	public boolean isCoaEdit()
	{
		return isCoaEdit;
	}

	public void setCoaEdit(boolean isCoaEdit)
	{
		this.isCoaEdit = isCoaEdit;
	}

}
