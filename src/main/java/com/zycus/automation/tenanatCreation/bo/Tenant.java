package com.zycus.automation.tenanatCreation.bo;

public class Tenant
{

	private String			companyName;
	private boolean			saasCompany					= false;
	private boolean			delegateCompany				= false;
	private String			bridgeUrl					= null;
	private String			domailUrl					= null;
	private boolean			loginThroughUniqueId		= false;
	private boolean			enableScope					= false;
	private String			locationName				= null;
	private String			address1					= null;
	private String			address2					= null;
	private String			city						= null;
	private String			state						= null;
	private int				zipCode						= -1;
	private String			country						= null;
	private boolean			componentRainbow			= false;
	private boolean			componentCrms				= false;
	private boolean			ComponentOneView			= false;
	private String			civilProductUrl				= null;
	private String			crmsProductUrl				= null;
	private String			centralRmsUrlProductUrl		= null;
	private String			dahsboardProductUrl			= null;
	private String			fieldLibraryProductUrl		= null;
	private String			flexiFormProductUrl			= null;
	private String			masProductUrl				= null;
	private String			notificationProductUrl		= null;
	private String			oneViewProductUrl			= null;
	private String			simProductUrl				= null;
	private String			spmProductUrl				= null;
	private String			supplierPortalProductUrl	= null;
	private String			tmsProductUrl				= null;
	private String			workflowProductUrl			= null;
	private String			einvoiceProductUrl			= null;
	private String			eprocProductUrl				= null;
	private String			ianalyzeProductUrl			= null;
	private String			icontractProductUrl			= null;
	private String			icostProductUrl				= null;
	private String			imanageProductUrl			= null;
	private String			isaveProductUrl				= null;
	private String			irequestProductUrl			= null;
	private String			isourceProductUrl			= null;
	private String			firstnameAdmin				= null;
	private String			LastNameAdmin				= null;
	private String			displayNameAdmin			= null;
	private String			emailIdAdmin				= null;
	private String			passwordToSetForAdminUser	= null;
	private String			uniqueKeyType				= null;
	private String			uniqueKeyValue				= null;
	private String			timezone					= null;
	private String			numberformat				= null;
	private String			dateFormat					= null;
	private String			timeFormat					= null;

	private String			currency					= null;
	private String			locale						= null;
	private String			smtpServerId				= null;
	private String			portNumber					= null;
	private String			decimalPrecision			= null;
	private ClientDetail	clientDetails				= null;
	

	public ClientDetail getClientDetails()
	{
		return clientDetails;
	}

	public void setClientDetails(ClientDetail clientDetails)
	{
		this.clientDetails = clientDetails;
	}

	public String getCompanyName()
	{
		return companyName;
	}

	public void setCompanyName(String companyName)
	{
		this.companyName = companyName;
	}

	public boolean isSaasCompany()
	{
		return saasCompany;
	}

	public void setSaasCompany(boolean saasCompany)
	{
		this.saasCompany = saasCompany;
	}

	public boolean isDelegateCompany()
	{
		return delegateCompany;
	}

	public void setDelegateCompany(boolean delegateCompany)
	{
		this.delegateCompany = delegateCompany;
	}

	public String getBridgeUrl()
	{
		return bridgeUrl;
	}

	public void setBridgeUrl(String bridgeUrl)
	{
		this.bridgeUrl = bridgeUrl;
	}

	public String getDomailUrl()
	{
		return domailUrl;
	}

	public void setDomailUrl(String domailUrl)
	{
		this.domailUrl = domailUrl;
	}

	public boolean isLoginThroughUniqueId()
	{
		return loginThroughUniqueId;
	}

	public void setLoginThroughUniqueId(boolean loginThroughUniqueId)
	{
		this.loginThroughUniqueId = loginThroughUniqueId;
	}

	public boolean isEnableScope()
	{
		return enableScope;
	}

	public void setEnableScope(boolean enableScope)
	{
		this.enableScope = enableScope;
	}

	public String getLocationName()
	{
		return locationName;
	}

	public void setLocationName(String locationName)
	{
		this.locationName = locationName;
	}

	public String getAddress1()
	{
		return address1;
	}

	public void setAddress1(String address1)
	{
		this.address1 = address1;
	}

	public String getAddress2()
	{
		return address2;
	}

	public void setAddress2(String address2)
	{
		this.address2 = address2;
	}

	public String getCity()
	{
		return city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	public String getState()
	{
		return state;
	}

	public void setState(String state)
	{
		this.state = state;
	}

	public int getZipCode()
	{
		return zipCode;
	}

	public void setZipCode(int zipCode)
	{
		this.zipCode = zipCode;
	}

	public String getCountry()
	{
		return country;
	}

	public void setCountry(String country)
	{
		this.country = country;
	}

	public boolean isComponentRainbow()
	{
		return componentRainbow;
	}

	public void setComponentRainbow(boolean componentRainbow)
	{
		this.componentRainbow = componentRainbow;
	}

	public boolean isComponentCrms()
	{
		return componentCrms;
	}

	public void setComponentCrms(boolean componentCrms)
	{
		this.componentCrms = componentCrms;
	}

	public boolean isComponentOneView()
	{
		return ComponentOneView;
	}

	public void setComponentOneView(boolean componentOneView)
	{
		ComponentOneView = componentOneView;
	}

	public String getCivilProductUrl()
	{
		return civilProductUrl;
	}

	public void setCivilProductUrl(String civilProductUrl)
	{
		this.civilProductUrl = civilProductUrl;
	}

	public String getCrmsProductUrl()
	{
		return crmsProductUrl;
	}

	public void setCrmsProductUrl(String crmsProductUrl)
	{
		this.crmsProductUrl = crmsProductUrl;
	}

	public String getCentralRmsUrlProductUrl()
	{
		return centralRmsUrlProductUrl;
	}

	public void setCentralRmsUrlProductUrl(String centralRmsUrlProductUrl)
	{
		this.centralRmsUrlProductUrl = centralRmsUrlProductUrl;
	}

	public String getDahsboardProductUrl()
	{
		return dahsboardProductUrl;
	}

	public void setDahsboardProductUrl(String dahsboardProductUrl)
	{
		this.dahsboardProductUrl = dahsboardProductUrl;
	}

	public String getFieldLibraryProductUrl()
	{
		return fieldLibraryProductUrl;
	}

	public void setFieldLibraryProductUrl(String fieldLibraryProductUrl)
	{
		this.fieldLibraryProductUrl = fieldLibraryProductUrl;
	}

	public String getFlexiFormProductUrl()
	{
		return flexiFormProductUrl;
	}

	public void setFlexiFormProductUrl(String flexiFormProductUrl)
	{
		this.flexiFormProductUrl = flexiFormProductUrl;
	}

	public String getMasProductUrl()
	{
		return masProductUrl;
	}

	public void setMasProductUrl(String masProductUrl)
	{
		this.masProductUrl = masProductUrl;
	}

	public String getNotificationProductUrl()
	{
		return notificationProductUrl;
	}

	public void setNotificationProductUrl(String notificationProductUrl)
	{
		this.notificationProductUrl = notificationProductUrl;
	}

	public String getOneViewProductUrl()
	{
		return oneViewProductUrl;
	}

	public void setOneViewProductUrl(String oneViewProductUrl)
	{
		this.oneViewProductUrl = oneViewProductUrl;
	}

	public String getSimProductUrl()
	{
		return simProductUrl;
	}

	public void setSimProductUrl(String simProductUrl)
	{
		this.simProductUrl = simProductUrl;
	}

	public String getSpmProductUrl()
	{
		return spmProductUrl;
	}

	public void setSpmProductUrl(String spmProductUrl)
	{
		this.spmProductUrl = spmProductUrl;
	}

	public String getSupplierPortalProductUrl()
	{
		return supplierPortalProductUrl;
	}

	public void setSupplierPortalProductUrl(String supplierPortalProductUrl)
	{
		this.supplierPortalProductUrl = supplierPortalProductUrl;
	}

	public String getTmsProductUrl()
	{
		return tmsProductUrl;
	}

	public void setTmsProductUrl(String tmsProductUrl)
	{
		this.tmsProductUrl = tmsProductUrl;
	}

	public String getWorkflowProductUrl()
	{
		return workflowProductUrl;
	}

	public void setWorkflowProductUrl(String workflowProductUrl)
	{
		this.workflowProductUrl = workflowProductUrl;
	}

	public String getEinvoiceProductUrl()
	{
		return einvoiceProductUrl;
	}

	public void setEinvoiceProductUrl(String einvoiceProductUrl)
	{
		this.einvoiceProductUrl = einvoiceProductUrl;
	}

	public String getEprocProductUrl()
	{
		return eprocProductUrl;
	}

	public void setEprocProductUrl(String eprocProductUrl)
	{
		this.eprocProductUrl = eprocProductUrl;
	}

	public String getIanalyzeProductUrl()
	{
		return ianalyzeProductUrl;
	}

	public void setIanalyzeProductUrl(String ianalyzeProductUrl)
	{
		this.ianalyzeProductUrl = ianalyzeProductUrl;
	}

	public String getIcontractProductUrl()
	{
		return icontractProductUrl;
	}

	public void setIcontractProductUrl(String icontractProductUrl)
	{
		this.icontractProductUrl = icontractProductUrl;
	}

	public String getIcostProductUrl()
	{
		return icostProductUrl;
	}

	public void setIcostProductUrl(String icostProductUrl)
	{
		this.icostProductUrl = icostProductUrl;
	}

	public String getImanageProductUrl()
	{
		return imanageProductUrl;
	}

	public void setImanageProductUrl(String imanageProductUrl)
	{
		this.imanageProductUrl = imanageProductUrl;
	}

	public String getIsaveProductUrl()
	{
		return isaveProductUrl;
	}

	public void setIsaveProductUrl(String isaveProductUrl)
	{
		this.isaveProductUrl = isaveProductUrl;
	}

	public String getIrequestProductUrl()
	{
		return irequestProductUrl;
	}

	public void setIrequestProductUrl(String irequestProductUrl)
	{
		this.irequestProductUrl = irequestProductUrl;
	}

	public String getIsourceProductUrl()
	{
		return isourceProductUrl;
	}

	public void setIsourceProductUrl(String isourceProductUrl)
	{
		this.isourceProductUrl = isourceProductUrl;
	}

	public String getFirstnameAdmin()
	{
		return firstnameAdmin;
	}

	public void setFirstnameAdmin(String firstnameAdmin)
	{
		this.firstnameAdmin = firstnameAdmin;
	}

	public String getLastNameAdmin()
	{
		return LastNameAdmin;
	}

	public void setLastNameAdmin(String lastNameAdmin)
	{
		LastNameAdmin = lastNameAdmin;
	}

	public String getDisplayNameAdmin()
	{
		return displayNameAdmin;
	}

	public void setDisplayNameAdmin(String displayNameAdmin)
	{
		this.displayNameAdmin = displayNameAdmin;
	}

	public String getEmailIdAdmin()
	{
		return emailIdAdmin;
	}

	public void setEmailIdAdmin(String emailIdAdmin)
	{
		this.emailIdAdmin = emailIdAdmin;
	}

	public String getUniqueKeyType()
	{
		return uniqueKeyType;
	}

	public void setUniqueKeyType(String uniqueKeyType)
	{
		this.uniqueKeyType = uniqueKeyType;
	}

	public String getUniqueKeyValue()
	{
		return uniqueKeyValue;
	}

	public void setUniqueKeyValue(String uniqueKeyValue)
	{
		this.uniqueKeyValue = uniqueKeyValue;
	}

	public String getTimezone()
	{
		return timezone;
	}

	public void setTimezone(String timezone)
	{
		this.timezone = timezone;
	}

	public String getNumberformat()
	{
		return numberformat;
	}

	public void setNumberformat(String numberformat)
	{
		this.numberformat = numberformat;
	}

	public String getDateFormat()
	{
		return dateFormat;
	}

	public void setDateFormat(String dateFormat)
	{
		this.dateFormat = dateFormat;
	}

	public String getTimeFormat()
	{
		return timeFormat;
	}

	public void setTimeFormat(String timeFormat)
	{
		this.timeFormat = timeFormat;
	}

	public String getCurrency()
	{
		return currency;
	}

	public void setCurrency(String currency)
	{
		this.currency = currency;
	}

	public String getLocale()
	{
		return locale;
	}

	public void setLocale(String locale)
	{
		this.locale = locale;
	}

	public String getSmtpServerId()
	{
		return smtpServerId;
	}

	public void setSmtpServerId(String smtpServerId)
	{
		this.smtpServerId = smtpServerId;
	}

	public String getPortNumber()
	{
		return portNumber;
	}

	public void setPortNumber(String portNumber)
	{
		this.portNumber = portNumber;
	}

	public String getDecimalPrecision()
	{
		return decimalPrecision;
	}

	public void setDecimalPrecision(String decimalPrecision)
	{
		this.decimalPrecision = decimalPrecision;
	}

	public String getPasswordToSetForAdminUser()
	{
		return passwordToSetForAdminUser;
	}

	public void setPasswordToSetForAdminUser(String passwordToSetForAdminUser)
	{
		this.passwordToSetForAdminUser = passwordToSetForAdminUser;
	}

}
