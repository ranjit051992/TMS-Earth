/**
 * 
 */
package com.zycus.automation.bo;

/**
 * @author ankita.sawant
 *
 */
public class UserSettings
{
	private String	emailId;
	private String	firstName;
	private String	displayName;
	private String	departmentName;
	private String	companyName;
	private String	locationName;
	private String	purchasingScopeName;
	private String	deliveryScopeName;
	private Float	purchasingLimit	= 0f;
	private String	locale;
	private String	timezone;
	private String	numberFormat;
	private String	controlCurrency;
	private String	salutation;
	private String	lastName;
	private String	reportingManager;
	private String	designation;
	private String	businessUnit;
	private String	costCenter;
	private String	behalfScope;
	private int		approvalLimit	= 0;
	private String	userCurrency;
	private String	dateFormat;
	private String	decimalPlace;
	private boolean	result			= false;
	private String	requestingScope	= null;
	private String	adminScope		= null;
	private String	nextAction		= null;

	public String getRequestingScope()
	{
		return requestingScope;
	}

	public void setRequestingScope(String requestingScope)
	{
		this.requestingScope = requestingScope;
	}

	public String getAdminScope()
	{
		return adminScope;
	}

	public void setAdminScope(String adminScope)
	{
		this.adminScope = adminScope;
	}

	public String getNextAction()
	{
		return nextAction;
	}

	public void setNextAction(String nextAction)
	{
		this.nextAction = nextAction;
	}

	public String getEmailId()
	{
		return emailId;
	}

	public void setEmailId(String emailId)
	{
		this.emailId = emailId;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getDisplayName()
	{
		return displayName;
	}

	public void setDisplayName(String displayName)
	{
		this.displayName = displayName;
	}

	public String getDepartmentName()
	{
		return departmentName;
	}

	public void setDepartmentName(String departmentName)
	{
		this.departmentName = departmentName;
	}

	public String getCompanyName()
	{
		return companyName;
	}

	public void setCompanyName(String companyName)
	{
		this.companyName = companyName;
	}

	public String getLocationName()
	{
		return locationName;
	}

	public void setLocationName(String locationName)
	{
		this.locationName = locationName;
	}

	public String getPurchasingScopeName()
	{
		return purchasingScopeName;
	}

	public void setPurchasingScopeName(String purchasingScopeName)
	{
		this.purchasingScopeName = purchasingScopeName;
	}

	public String getDeliveryScopeName()
	{
		return deliveryScopeName;
	}

	public void setDeliveryScopeName(String deliveryScopeName)
	{
		this.deliveryScopeName = deliveryScopeName;
	}

	public Float getPurchasingLimit()
	{
		return purchasingLimit;
	}

	public void setPurchasingLimit(Float purchasingLimit)
	{
		this.purchasingLimit = purchasingLimit;
	}

	public String getLocale()
	{
		return locale;
	}

	public void setLocale(String locale)
	{
		this.locale = locale;
	}

	public String getTimezone()
	{
		return timezone;
	}

	public void setTimezone(String timezone)
	{
		this.timezone = timezone;
	}

	public String getNumberFormat()
	{
		return numberFormat;
	}

	public void setNumberFormat(String numberFormat)
	{
		this.numberFormat = numberFormat;
	}

	public String getControlCurrency()
	{
		return controlCurrency;
	}

	public void setControlCurrency(String controlCurrency)
	{
		this.controlCurrency = controlCurrency;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getReportingManager()
	{
		return reportingManager;
	}

	public void setReportingManager(String reportingManager)
	{
		this.reportingManager = reportingManager;
	}

	public String getDesignation()
	{
		return designation;
	}

	public void setDesignation(String designation)
	{
		this.designation = designation;
	}

	public String getBusinessUnit()
	{
		return businessUnit;
	}

	public void setBusinessUnit(String businessUnit)
	{
		this.businessUnit = businessUnit;
	}

	public String getCostCenter()
	{
		return costCenter;
	}

	public void setCostCenter(String costCenter)
	{
		this.costCenter = costCenter;
	}

	public String getBehalfScope()
	{
		return behalfScope;
	}

	public void setBehalfScope(String behalfScope)
	{
		this.behalfScope = behalfScope;
	}

	public int getApprovalLimit()
	{
		return approvalLimit;
	}

	public void setApprovalLimit(int approvalLimit)
	{
		this.approvalLimit = approvalLimit;
	}

	public String getUserCurrency()
	{
		return userCurrency;
	}

	public void setUserCurrency(String userCurrency)
	{
		this.userCurrency = userCurrency;
	}

	public String getDateFormat()
	{
		return dateFormat;
	}

	public void setDateFormat(String dateFormat)
	{
		this.dateFormat = dateFormat;
	}

	public String getDecimalPlace()
	{
		return decimalPlace;
	}

	public void setDecimalPlace(String decimalPlace)
	{
		this.decimalPlace = decimalPlace;
	}

	public boolean isResult()
	{
		return result;
	}

	public void setResult(boolean result)
	{
		this.result = result;
	}

	public String getSalutation()
	{
		return salutation;
	}

	public void setSalutation(String salutation)
	{
		this.salutation = salutation;
	}

}
