package com.zycus.automation.tenanatCreation.utilities.objectCreation;

import java.util.List;
import java.util.Map;

import com.zycus.automation.eproc.excelDatabaseReader.ExcelReader;
import com.zycus.automation.tenanatCreation.bo.ClientDetail;
import com.zycus.automation.tenanatCreation.bo.Field;
import com.zycus.automation.tenanatCreation.bo.MasterDataCmd;
import com.zycus.automation.tenanatCreation.bo.SimConfiguration;
import com.zycus.automation.tenanatCreation.bo.SystemLevelConfiguration;
import com.zycus.automation.tenanatCreation.bo.Tenant;
import com.zycus.automation.tenanatCreation.utilities.IConstants.IConstantData;

public class DefaultObjectCreation
{
	static Map<String, String>		testDataMap					= null;
	static Map<String, String>		testDataSystemTenantConfig	= null;
	static SystemLevelConfiguration	systemTenentConfig			= null;
	static Tenant					tenant						= null;
	static Map<String, String>		simDataMap					= null;
	static Map<String, String>		masterDataCmdMap			= null;

	public static Tenant getNewTenantObject() throws Exception
	{

		testDataMap = ExcelReader.getTestDataCombo();
		tenant = new Tenant();

		//For client Details
		ClientDetail clientDetail = new ClientDetail();
		if (testDataMap.get(IConstantData.companyName) != null && !(testDataMap.get(IConstantData.companyName).equals("null")))
		{
			tenant.setCompanyName(testDataMap.get(IConstantData.companyName));
			clientDetail.setClientName(testDataMap.get(IConstantData.companyName));
		}
		if (testDataMap.get(IConstantData.saasCompany) != null && !(testDataMap.get(IConstantData.saasCompany).equals("null")))
		{
			tenant.setSaasCompany(Boolean.valueOf(testDataMap.get(IConstantData.saasCompany).toLowerCase()));
		}
		if (testDataMap.get(IConstantData.delegateCompany) != null && !(testDataMap.get(IConstantData.delegateCompany).equals("null")))
		{
			tenant.setDelegateCompany(Boolean.valueOf(testDataMap.get(IConstantData.delegateCompany).toLowerCase()));
		}
		if (testDataMap.get(IConstantData.bridgeUrl) != null && !(testDataMap.get(IConstantData.bridgeUrl).equals("null")))
		{
			tenant.setBridgeUrl(testDataMap.get(IConstantData.bridgeUrl));
		}
		if (testDataMap.get(IConstantData.domailUrl) != null && !(testDataMap.get(IConstantData.domailUrl).equals("null")))
		{
			tenant.setDomailUrl(testDataMap.get(IConstantData.domailUrl));
		}
		if (testDataMap.get(IConstantData.loginThroughUniqueId) != null && !(testDataMap.get(IConstantData.loginThroughUniqueId).equals("null")))
		{
			tenant.setLoginThroughUniqueId(Boolean.valueOf(testDataMap.get(IConstantData.loginThroughUniqueId).toLowerCase()));
		}
		if (testDataMap.get(IConstantData.enableScope) != null && !(testDataMap.get(IConstantData.enableScope).equals("null")))
		{
			tenant.setEnableScope(Boolean.valueOf(testDataMap.get(IConstantData.enableScope).toLowerCase()));
		}
		if (testDataMap.get(IConstantData.locationName) != null && !(testDataMap.get(IConstantData.locationName).equals("null")))
		{
			tenant.setLocationName(testDataMap.get(IConstantData.locationName));
		}
		if (testDataMap.get(IConstantData.address1) != null && !(testDataMap.get(IConstantData.address1).equals("null")))
		{
			tenant.setAddress1(testDataMap.get(IConstantData.address1));
		}
		if (testDataMap.get(IConstantData.address2) != null && !(testDataMap.get(IConstantData.address2).equals("null")))
		{
			tenant.setAddress2(testDataMap.get(IConstantData.address2));
		}
		if (testDataMap.get(IConstantData.city) != null && !(testDataMap.get(IConstantData.city).equals("null")))
		{
			tenant.setCity(testDataMap.get(IConstantData.city));
		}
		if (testDataMap.get(IConstantData.state) != null && !(testDataMap.get(IConstantData.state).equals("null")))
		{
			tenant.setState(testDataMap.get(IConstantData.state));
		}
		if (testDataMap.get(IConstantData.zipCode) != null && !(testDataMap.get(IConstantData.zipCode).equals("null")))
		{
			tenant.setZipCode(Integer.parseInt(testDataMap.get(IConstantData.zipCode)));
		}
		if (testDataMap.get(IConstantData.country) != null && !(testDataMap.get(IConstantData.country).equals("null")))
		{
			tenant.setCountry(testDataMap.get(IConstantData.country));
		}
		if (testDataMap.get(IConstantData.componentRainbow) != null && !(testDataMap.get(IConstantData.componentRainbow).equals("null")))
		{
			tenant.setComponentRainbow(Boolean.valueOf(testDataMap.get(IConstantData.componentRainbow).toLowerCase()));
		}
		if (testDataMap.get(IConstantData.componentCrms) != null && !(testDataMap.get(IConstantData.componentCrms).equals("null")))
		{
			tenant.setComponentCrms(Boolean.valueOf(testDataMap.get(IConstantData.componentCrms).toLowerCase()));
		}
		if (testDataMap.get(IConstantData.ComponentOneView) != null && !(testDataMap.get(IConstantData.ComponentOneView).equals("null")))
		{
			tenant.setComponentOneView(Boolean.valueOf(testDataMap.get(IConstantData.ComponentOneView).toLowerCase()));
		}
		if (testDataMap.get(IConstantData.civilProductUrl) != null && !(testDataMap.get(IConstantData.civilProductUrl).equals("null")))
		{
			tenant.setCivilProductUrl(testDataMap.get(IConstantData.civilProductUrl));
		}
		if (testDataMap.get(IConstantData.crmsProductUrl) != null && !(testDataMap.get(IConstantData.crmsProductUrl).equals("null")))
		{
			tenant.setCrmsProductUrl(testDataMap.get(IConstantData.crmsProductUrl));
		}
		if (testDataMap.get(IConstantData.centralRmsUrlProductUrl) != null && !(testDataMap.get(IConstantData.centralRmsUrlProductUrl).equals("null")))
		{
			tenant.setCentralRmsUrlProductUrl(testDataMap.get(IConstantData.centralRmsUrlProductUrl));
		}
		if (testDataMap.get(IConstantData.dahsboardProductUrl) != null && !(testDataMap.get(IConstantData.dahsboardProductUrl).equals("null")))
		{
			tenant.setDahsboardProductUrl(testDataMap.get(IConstantData.dahsboardProductUrl));
		}
		if (testDataMap.get(IConstantData.fieldLibraryProductUrl) != null && !(testDataMap.get(IConstantData.fieldLibraryProductUrl).equals("null")))
		{
			tenant.setFieldLibraryProductUrl(testDataMap.get(IConstantData.fieldLibraryProductUrl));
		}
		if (testDataMap.get(IConstantData.flexiFormProductUrl) != null && !(testDataMap.get(IConstantData.flexiFormProductUrl).equals("null")))
		{
			tenant.setFlexiFormProductUrl(testDataMap.get(IConstantData.flexiFormProductUrl));
		}
		if (testDataMap.get(IConstantData.masProductUrl) != null && !(testDataMap.get(IConstantData.masProductUrl).equals("null")))
		{
			tenant.setMasProductUrl(testDataMap.get(IConstantData.masProductUrl));
		}
		if (testDataMap.get(IConstantData.notificationProductUrl) != null && !(testDataMap.get(IConstantData.notificationProductUrl).equals("null")))
		{
			tenant.setNotificationProductUrl(testDataMap.get(IConstantData.notificationProductUrl));
		}
		if (testDataMap.get(IConstantData.oneViewProductUrl) != null && !(testDataMap.get(IConstantData.oneViewProductUrl).equals("null")))
		{
			tenant.setOneViewProductUrl(testDataMap.get(IConstantData.oneViewProductUrl));
		}
		if (testDataMap.get(IConstantData.simProductUrl) != null && !(testDataMap.get(IConstantData.simProductUrl).equals("null")))
		{
			tenant.setSimProductUrl(testDataMap.get(IConstantData.simProductUrl));
		}
		if (testDataMap.get(IConstantData.spmProductUrl) != null && !(testDataMap.get(IConstantData.spmProductUrl).equals("null")))
		{
			tenant.setSpmProductUrl(testDataMap.get(IConstantData.spmProductUrl));
		}
		if (testDataMap.get(IConstantData.supplierPortalProductUrl) != null && !(testDataMap.get(IConstantData.supplierPortalProductUrl).equals("null")))
		{
			tenant.setSupplierPortalProductUrl(testDataMap.get(IConstantData.supplierPortalProductUrl));
		}
		if (testDataMap.get(IConstantData.tmsProductUrl) != null && !(testDataMap.get(IConstantData.tmsProductUrl).equals("null")))
		{
			tenant.setTmsProductUrl(testDataMap.get(IConstantData.tmsProductUrl));
		}
		if (testDataMap.get(IConstantData.workflowProductUrl) != null && !(testDataMap.get(IConstantData.workflowProductUrl).equals("null")))
		{
			tenant.setWorkflowProductUrl(testDataMap.get(IConstantData.workflowProductUrl));
		}
		if (testDataMap.get(IConstantData.einvoiceProductUrl) != null && !(testDataMap.get(IConstantData.einvoiceProductUrl).equals("null")))
		{
			tenant.setEinvoiceProductUrl(testDataMap.get(IConstantData.einvoiceProductUrl));
		}
		if (testDataMap.get(IConstantData.eprocProductUrl) != null && !(testDataMap.get(IConstantData.eprocProductUrl).equals("null")))
		{
			tenant.setEprocProductUrl(testDataMap.get(IConstantData.eprocProductUrl));
		}
		if (testDataMap.get(IConstantData.ianalyzeProductUrl) != null && !(testDataMap.get(IConstantData.ianalyzeProductUrl).equals("null")))
		{
			tenant.setIanalyzeProductUrl(testDataMap.get(IConstantData.ianalyzeProductUrl));
		}
		if (testDataMap.get(IConstantData.icontractProductUrl) != null && !(testDataMap.get(IConstantData.icontractProductUrl).equals("null")))
		{
			tenant.setIcontractProductUrl(testDataMap.get(IConstantData.icontractProductUrl));
		}
		if (testDataMap.get(IConstantData.icostProductUrl) != null && !(testDataMap.get(IConstantData.icostProductUrl).equals("null")))
		{
			tenant.setIcostProductUrl(testDataMap.get(IConstantData.icostProductUrl));
		}
		if (testDataMap.get(IConstantData.imanageProductUrl) != null && !(testDataMap.get(IConstantData.imanageProductUrl).equals("null")))
		{
			tenant.setImanageProductUrl(testDataMap.get(IConstantData.imanageProductUrl));
		}
		if (testDataMap.get(IConstantData.isaveProductUrl) != null && !(testDataMap.get(IConstantData.isaveProductUrl).equals("null")))
		{
			tenant.setIsaveProductUrl(testDataMap.get(IConstantData.isaveProductUrl));
		}
		if (testDataMap.get(IConstantData.irequestProductUrl) != null && !(testDataMap.get(IConstantData.irequestProductUrl).equals("null")))
		{
			tenant.setIrequestProductUrl(testDataMap.get(IConstantData.irequestProductUrl));
		}
		if (testDataMap.get(IConstantData.isourceProductUrl) != null && !(testDataMap.get(IConstantData.isourceProductUrl).equals("null")))
		{
			tenant.setIsourceProductUrl(testDataMap.get(IConstantData.isourceProductUrl));
		}
		if (testDataMap.get(IConstantData.firstnameAdmin) != null && !(testDataMap.get(IConstantData.firstnameAdmin).equals("null")))
		{
			tenant.setFirstnameAdmin(testDataMap.get(IConstantData.firstnameAdmin));
		}
		if (testDataMap.get(IConstantData.LastNameAdmin) != null && !(testDataMap.get(IConstantData.LastNameAdmin).equals("null")))
		{
			tenant.setLastNameAdmin(testDataMap.get(IConstantData.LastNameAdmin));
		}
		if (testDataMap.get(IConstantData.displayNameAdmin) != null && !(testDataMap.get(IConstantData.displayNameAdmin).equals("null")))
		{
			tenant.setDisplayNameAdmin(testDataMap.get(IConstantData.displayNameAdmin));
		}
		if (testDataMap.get(IConstantData.emailIdAdmin) != null && !(testDataMap.get(IConstantData.emailIdAdmin).equals("null")))
		{
			tenant.setEmailIdAdmin(testDataMap.get(IConstantData.emailIdAdmin));
		}
		if (testDataMap.get(IConstantData.passwordToSetForAdminUser) != null && !(testDataMap.get(IConstantData.passwordToSetForAdminUser).equals("null")))
		{
			tenant.setPasswordToSetForAdminUser(testDataMap.get(IConstantData.passwordToSetForAdminUser));
		}
		if (testDataMap.get(IConstantData.uniqueKeyType) != null && !(testDataMap.get(IConstantData.uniqueKeyType).equals("null")))
		{
			tenant.setUniqueKeyType(testDataMap.get(IConstantData.uniqueKeyType));
		}
		if (testDataMap.get(IConstantData.uniqueKeyValue) != null && !(testDataMap.get(IConstantData.uniqueKeyValue).equals("null")))
		{
			tenant.setUniqueKeyValue(testDataMap.get(IConstantData.uniqueKeyValue));
		}
		if (testDataMap.get(IConstantData.timezone) != null && !(testDataMap.get(IConstantData.timezone).equals("null")))
		{
			tenant.setTimezone(testDataMap.get(IConstantData.timezone));
		}
		if (testDataMap.get(IConstantData.numberformat) != null && !(testDataMap.get(IConstantData.numberformat).equals("null")))
		{
			tenant.setNumberformat(testDataMap.get(IConstantData.numberformat));
		}
		if (testDataMap.get(IConstantData.dateFormat) != null && !(testDataMap.get(IConstantData.dateFormat).equals("null")))
		{
			tenant.setDateFormat(testDataMap.get(IConstantData.dateFormat));
		}
		if (testDataMap.get(IConstantData.timeFormat) != null && !(testDataMap.get(IConstantData.timeFormat).equals("null")))
		{
			tenant.setTimeFormat(testDataMap.get(IConstantData.timeFormat));
		}
		if (testDataMap.get(IConstantData.currency) != null && !(testDataMap.get(IConstantData.currency).equals("null")))
		{
			tenant.setCurrency(testDataMap.get(IConstantData.currency));
		}
		if (testDataMap.get(IConstantData.locale) != null && !(testDataMap.get(IConstantData.locale).equals("null")))
		{
			tenant.setLocale(testDataMap.get(IConstantData.locale));
		}
		if (testDataMap.get(IConstantData.smtpServerId) != null && !(testDataMap.get(IConstantData.smtpServerId).equals("null")))
		{
			tenant.setSmtpServerId(testDataMap.get(IConstantData.smtpServerId));
		}
		if (testDataMap.get(IConstantData.portNumber) != null && !(testDataMap.get(IConstantData.portNumber).equals("null")))
		{
			tenant.setPortNumber(testDataMap.get(IConstantData.portNumber));
		}
		if (testDataMap.get(IConstantData.decimalPrecision) != null && !(testDataMap.get(IConstantData.decimalPrecision).equals("null")))
		{
			tenant.setDecimalPrecision(testDataMap.get(IConstantData.decimalPrecision));
		}
		//client details for sim
		if (testDataMap.get(IConstantData.ClientIdentifierForSim) != null && !(testDataMap.get(IConstantData.ClientIdentifierForSim).equals("null")))
		{
			clientDetail.setClientIdentifier(testDataMap.get(IConstantData.ClientIdentifierForSim));
		}
		if (testDataMap.get(IConstantData.ClientDescriptionForSim) != null && !(testDataMap.get(IConstantData.ClientDescriptionForSim).equals("null")))
		{
			clientDetail.setClientDescription(testDataMap.get(IConstantData.ClientDescriptionForSim));
		}
		tenant.setClientDetails(clientDetail);

		return tenant;
	}

	public static ClientDetail getClientDetailObject() throws Exception
	{

		testDataMap = ExcelReader.getTestDataCombo();
		tenant = new Tenant();

		if (testDataMap.get(IConstantData.companyName) != null && !(testDataMap.get(IConstantData.companyName).equals("null")))
		{
			tenant.setCompanyName(testDataMap.get(IConstantData.companyName));
		}
		return null;
	}

	@SuppressWarnings("null")
	public static SystemLevelConfiguration getSystemTenantConfigurationObject(String sheetName) throws Exception
	{

		testDataSystemTenantConfig = ExcelReader.getTestDataComboFromFileXlsx("systemTenantConfigurationFile", sheetName);
		systemTenentConfig = new SystemLevelConfiguration();

		if (testDataSystemTenantConfig.get(IConstantData.adminUser) != null && !(testDataSystemTenantConfig.get(IConstantData.adminUser).equals("null")))
		{
			systemTenentConfig.setAdminUser(testDataSystemTenantConfig.get(IConstantData.adminUser));
		}

		if (testDataSystemTenantConfig.get(IConstantData.adminEmailId) != null && !(testDataSystemTenantConfig.get(IConstantData.adminEmailId).equals("null")))
		{
			systemTenentConfig.setAdminEmailId(testDataSystemTenantConfig.get(IConstantData.adminEmailId));
		}

		if (testDataSystemTenantConfig.get(IConstantData.invoiceAdminEmailId) != null && !(testDataSystemTenantConfig.get(IConstantData.invoiceAdminEmailId).equals("null")))
		{
			systemTenentConfig.setInvoiceAdminEmailId(testDataSystemTenantConfig.get(IConstantData.invoiceAdminEmailId));
		}

		if (testDataSystemTenantConfig.get(IConstantData.invoiceAdminUser) != null && !(testDataSystemTenantConfig.get(IConstantData.invoiceAdminUser).equals("null")))
		{
			systemTenentConfig.setInvoiceAdminUser(testDataSystemTenantConfig.get(IConstantData.invoiceAdminUser));
		}

		if (testDataSystemTenantConfig.get(IConstantData.apiEmail) != null && !(testDataSystemTenantConfig.get(IConstantData.apiEmail).equals("null")))
		{
			systemTenentConfig.setApiEmail(testDataSystemTenantConfig.get(IConstantData.apiEmail));
		}

		if (testDataSystemTenantConfig.get(IConstantData.eInvoiceEventUrl) != null && !(testDataSystemTenantConfig.get(IConstantData.eInvoiceEventUrl).equals("null")))
		{
			systemTenentConfig.seteInvoiceEventUrl(testDataSystemTenantConfig.get(IConstantData.eInvoiceEventUrl));
		}

		if (testDataSystemTenantConfig.get(IConstantData.iSourceEventUrl) != null && !(testDataSystemTenantConfig.get(IConstantData.iSourceEventUrl).equals("null")))
		{
			systemTenentConfig.setiSourceEventUrl(testDataSystemTenantConfig.get(IConstantData.iSourceEventUrl));
		}

		if (testDataSystemTenantConfig.get(IConstantData.baseUrl) != null && !(testDataSystemTenantConfig.get(IConstantData.baseUrl).equals("null")))
		{
			systemTenentConfig.setBaseUrl(testDataSystemTenantConfig.get(IConstantData.baseUrl));
		}

		if (testDataSystemTenantConfig.get(IConstantData.autoClassUrl) != null && !(testDataSystemTenantConfig.get(IConstantData.autoClassUrl).equals("null")))
		{
			systemTenentConfig.setAutoClassUrl(testDataSystemTenantConfig.get(IConstantData.autoClassUrl));
		}

		if (testDataSystemTenantConfig.get(IConstantData.autoClassSchema) != null && !(testDataSystemTenantConfig.get(IConstantData.autoClassSchema).equals("null")))
		{
			systemTenentConfig.setAutoClassSchema(testDataSystemTenantConfig.get(IConstantData.autoClassSchema));
		}

		if (testDataSystemTenantConfig.get(IConstantData.autoClassProject) != null && !(testDataSystemTenantConfig.get(IConstantData.autoClassProject).equals("null")))
		{
			systemTenentConfig.setAutoClassProject(testDataSystemTenantConfig.get(IConstantData.autoClassProject));
		}

		if (testDataSystemTenantConfig.get(IConstantData.autoClassModel) != null && !(testDataSystemTenantConfig.get(IConstantData.autoClassModel).equals("null")))
		{
			systemTenentConfig.setAutoClassModel(testDataSystemTenantConfig.get(IConstantData.autoClassModel));
		}

		if (testDataSystemTenantConfig.get(IConstantData.autoClassModelVersion) != null && !(testDataSystemTenantConfig.get(IConstantData.autoClassModelVersion).equals("null")))
		{
			systemTenentConfig.setAutoClassModelVersion(testDataSystemTenantConfig.get(IConstantData.autoClassModelVersion));
		}

		if (testDataSystemTenantConfig.get(IConstantData.useMasterDataCMD) != null && !(testDataSystemTenantConfig.get(IConstantData.useMasterDataCMD).equals("null")))
		{
			systemTenentConfig.setUseMasterDataCMD(testDataSystemTenantConfig.get(IConstantData.useMasterDataCMD).toLowerCase());
		}

		if (testDataSystemTenantConfig.get(IConstantData.enableAnalyticsCRMSIntegration) != null
			&& !(testDataSystemTenantConfig.get(IConstantData.enableAnalyticsCRMSIntegration).equals("null")))
		{
			systemTenentConfig.setEnableAnalyticsCRMSIntegration(testDataSystemTenantConfig.get(IConstantData.enableAnalyticsCRMSIntegration).toLowerCase());
		}

		if (testDataSystemTenantConfig.get(IConstantData.allowSupplierAdditionForStockItem) != null
			&& !(testDataSystemTenantConfig.get(IConstantData.allowSupplierAdditionForStockItem).equals("null")))
		{
			systemTenentConfig.setAllowSupplierAdditionForStockItem(testDataSystemTenantConfig.get(IConstantData.allowSupplierAdditionForStockItem).toLowerCase());
		}

		if (testDataSystemTenantConfig.get(IConstantData.useRegionsForScoping) != null && !(testDataSystemTenantConfig.get(IConstantData.useRegionsForScoping).equals("null")))
		{
			systemTenentConfig.setUseRegionsForScoping(testDataSystemTenantConfig.get(IConstantData.useRegionsForScoping).toLowerCase());
		}

		if (testDataSystemTenantConfig.get(IConstantData.iseInvoiceIntegrated) != null && !(testDataSystemTenantConfig.get(IConstantData.iseInvoiceIntegrated).equals("null")))
		{
			systemTenentConfig.setIseInvoiceIntegrated(testDataSystemTenantConfig.get(IConstantData.iseInvoiceIntegrated).toLowerCase());
		}

		if (testDataSystemTenantConfig.get(IConstantData.isAutoRetriggerDocuments) != null
			&& !(testDataSystemTenantConfig.get(IConstantData.isAutoRetriggerDocuments).equals("null")))
		{
			systemTenentConfig.setIsAutoRetriggerDocuments(testDataSystemTenantConfig.get(IConstantData.isAutoRetriggerDocuments).toLowerCase());
		}

		if (testDataSystemTenantConfig.get(IConstantData.attemptRetriggerInMins) != null && !(testDataSystemTenantConfig.get(IConstantData.attemptRetriggerInMins).equals("null")))
		{
			systemTenentConfig.setAttemptRetriggerInMins(testDataSystemTenantConfig.get(IConstantData.attemptRetriggerInMins));
		}

		if (testDataSystemTenantConfig.get(IConstantData.maximumNoOfAttempts) != null && !(testDataSystemTenantConfig.get(IConstantData.maximumNoOfAttempts).equals("null")))
		{
			systemTenentConfig.setMaximumNoOfAttempts(testDataSystemTenantConfig.get(IConstantData.maximumNoOfAttempts));
		}

		if (testDataSystemTenantConfig.get(IConstantData.analyticsCRMSIntegrationUrl) != null
			&& !(testDataSystemTenantConfig.get(IConstantData.analyticsCRMSIntegrationUrl).equals("null")))
		{
			systemTenentConfig.setAnalyticsCRMSIntegrationUrl(testDataSystemTenantConfig.get(IConstantData.analyticsCRMSIntegrationUrl));
		}

		if (testDataSystemTenantConfig.get(IConstantData.predefinedFields) != null && !(testDataSystemTenantConfig.get(IConstantData.predefinedFields).equals("null")))
		{
			systemTenentConfig.setPredefinedFields(testDataSystemTenantConfig.get(IConstantData.predefinedFields));
		}
		if (testDataSystemTenantConfig.get(IConstantData.noOfIntegrationEntityToAdd) != null
			&& !(testDataSystemTenantConfig.get(IConstantData.noOfIntegrationEntityToAdd).equals("null")))
		{
			systemTenentConfig.setNoOfIntegrationEntityToAdd(testDataSystemTenantConfig.get(IConstantData.noOfIntegrationEntityToAdd));
		}
		if (testDataSystemTenantConfig.get(IConstantData.tmsProductName) != null && !(testDataSystemTenantConfig.get(IConstantData.tmsProductName).equals("null")))
		{
			systemTenentConfig.setTmsProductName(testDataSystemTenantConfig.get(IConstantData.tmsProductName));
		}
		if (testDataSystemTenantConfig.get(IConstantData.smtpHost) != null && !(testDataSystemTenantConfig.get(IConstantData.smtpHost).equals("null")))
		{
			systemTenentConfig.setSmtpHost(testDataSystemTenantConfig.get(IConstantData.smtpHost));
		}
		if (testDataSystemTenantConfig.get(IConstantData.defaultEmailSender) != null && !(testDataSystemTenantConfig.get(IConstantData.defaultEmailSender).equals("null")))
		{
			systemTenentConfig.setDefaultEmailSender(testDataSystemTenantConfig.get(IConstantData.defaultEmailSender));
		}
		if (testDataSystemTenantConfig.get(IConstantData.apiEmailId) != null && !(testDataSystemTenantConfig.get(IConstantData.apiEmailId).equals("null")))
		{
			systemTenentConfig.setApiEmailId(testDataSystemTenantConfig.get(IConstantData.apiEmailId));
		}
		if (testDataSystemTenantConfig.get(IConstantData.fileServerUrl) != null && !(testDataSystemTenantConfig.get(IConstantData.fileServerUrl).equals("null")))
		{
			systemTenentConfig.setFileServerUrl(testDataSystemTenantConfig.get(IConstantData.fileServerUrl));
		}
		if (testDataSystemTenantConfig.get(IConstantData.zsnIntegrationUrl) != null && !(testDataSystemTenantConfig.get(IConstantData.zsnIntegrationUrl).equals("null")))
		{
			systemTenentConfig.setZsnIntegrationUrl(testDataSystemTenantConfig.get(IConstantData.zsnIntegrationUrl));
		}
		if (testDataSystemTenantConfig.get(IConstantData.isCatalogEnableSearchItem) != null
			&& !(testDataSystemTenantConfig.get(IConstantData.isCatalogEnableSearchItem).equals("null")))
		{
			systemTenentConfig.setIsCatalogEnableSearchItem(testDataSystemTenantConfig.get(IConstantData.isCatalogEnableSearchItem));
		}
		if (testDataSystemTenantConfig.get(IConstantData.usageTracking) != null && !(testDataSystemTenantConfig.get(IConstantData.usageTracking).equals("null")))
		{
			systemTenentConfig.setUsageTracking(testDataSystemTenantConfig.get(IConstantData.usageTracking));
		}
		if (testDataSystemTenantConfig.get(IConstantData.CMDeventUrl) != null && !(testDataSystemTenantConfig.get(IConstantData.CMDeventUrl).equals("null")))
		{
			systemTenentConfig.setCMDeventUrl(testDataSystemTenantConfig.get(IConstantData.CMDeventUrl));
		}
		if (testDataSystemTenantConfig.get(IConstantData.uploadExchangeRateFilePath) != null
			&& !(testDataSystemTenantConfig.get(IConstantData.uploadExchangeRateFilePath).equals("null")))
		{
			systemTenentConfig.setUploadExchangeRateFilePath(testDataSystemTenantConfig.get(IConstantData.uploadExchangeRateFilePath));
		}

		if (testDataSystemTenantConfig.get(IConstantData.CMDeventUrl) != null && !(testDataSystemTenantConfig.get(IConstantData.CMDeventUrl).equals("null")))
		{
			systemTenentConfig.setCMDeventUrl(testDataSystemTenantConfig.get(IConstantData.CMDeventUrl));
		}

		//---------------
		if (testDataSystemTenantConfig.get(IConstantData.cmdAutoClassUrl) != null && !(testDataSystemTenantConfig.get(IConstantData.cmdAutoClassUrl).equals("null")))
		{
			systemTenentConfig.setCmdAutoClassUrl(testDataSystemTenantConfig.get(IConstantData.cmdAutoClassUrl));
		}
		if (testDataSystemTenantConfig.get(IConstantData.cmdAutoClassSchema) != null && !(testDataSystemTenantConfig.get(IConstantData.cmdAutoClassSchema).equals("null")))
		{
			systemTenentConfig.setCmdAutoClassSchema(testDataSystemTenantConfig.get(IConstantData.cmdAutoClassSchema));
		}
		if (testDataSystemTenantConfig.get(IConstantData.cmdAutoClassProject) != null && !(testDataSystemTenantConfig.get(IConstantData.cmdAutoClassProject).equals("null")))
		{
			systemTenentConfig.setCmdAutoClassProject(testDataSystemTenantConfig.get(IConstantData.cmdAutoClassProject));
		}
		if (testDataSystemTenantConfig.get(IConstantData.cmdAutoClassModel) != null && !(testDataSystemTenantConfig.get(IConstantData.cmdAutoClassModel).equals("null")))
		{
			systemTenentConfig.setCmdAutoClassModel(testDataSystemTenantConfig.get(IConstantData.cmdAutoClassModel));
		}
		if (testDataSystemTenantConfig.get(IConstantData.cmdAutoClassModelVersion) != null
			&& !(testDataSystemTenantConfig.get(IConstantData.cmdAutoClassModelVersion).equals("null")))
		{
			systemTenentConfig.setCmdAutoClassModelVersion(testDataSystemTenantConfig.get(IConstantData.cmdAutoClassModelVersion));
		}
		if (testDataSystemTenantConfig.get(IConstantData.cmdSimUrl) != null && !(testDataSystemTenantConfig.get(IConstantData.cmdSimUrl).equals("null")))
		{
			systemTenentConfig.setCmdSimUrl(testDataSystemTenantConfig.get(IConstantData.cmdSimUrl));
		}
		if (testDataSystemTenantConfig.get(IConstantData.simSupplierAddUrl) != null && !(testDataSystemTenantConfig.get(IConstantData.simSupplierAddUrl).equals("null")))
		{
			systemTenentConfig.setSimSupplierAddUrl(testDataSystemTenantConfig.get(IConstantData.simSupplierAddUrl));
		}
		if (testDataSystemTenantConfig.get(IConstantData.languagesForTranslation) != null
			&& !(testDataSystemTenantConfig.get(IConstantData.languagesForTranslation).equals("null")))
		{
			String languages = testDataSystemTenantConfig.get(IConstantData.languagesForTranslation);
			String[] languagesArray = languages.split("||");
			List<String> allLanguages = null;
			for (int i = 0; i < languagesArray.length; i++)
			{
				allLanguages.add(languagesArray[i].trim());
			}
			systemTenentConfig.setLanguagesForTranslation(allLanguages);
		}
		if (testDataSystemTenantConfig.get(IConstantData.useBUinGL) != null && !(testDataSystemTenantConfig.get(IConstantData.useBUinGL).equals("null")))
		{
			systemTenentConfig.setUseBUinGL(testDataSystemTenantConfig.get(IConstantData.useBUinGL));
		}
		if (testDataSystemTenantConfig.get(IConstantData.linkDeptToOUlevels) != null && !(testDataSystemTenantConfig.get(IConstantData.linkDeptToOUlevels).equals("null")))
		{
			systemTenentConfig.setLinkDeptToOUlevels(testDataSystemTenantConfig.get(IConstantData.linkDeptToOUlevels));
		}
		if (testDataSystemTenantConfig.get(IConstantData.matchPaymentTermWithUniqueCode) != null
			&& !(testDataSystemTenantConfig.get(IConstantData.matchPaymentTermWithUniqueCode).equals("null")))
		{
			systemTenentConfig.setMatchPaymentTermWithUniqueCode(testDataSystemTenantConfig.get(IConstantData.matchPaymentTermWithUniqueCode));
		}

		return systemTenentConfig;
	}

	public static SimConfiguration getSIMObject() throws Exception
	{
		simDataMap = ExcelReader.getTestDataComboFromFile("simDataFile");
		SimConfiguration simConfig = new SimConfiguration();

		if (simDataMap.get(IConstantData.viewAccessesCompany) != null && !simDataMap.get(IConstantData.viewAccessesCompany).equals("null"))
		{
			simConfig.setViewAccessesCompany(Boolean.parseBoolean(simDataMap.get(IConstantData.viewAccessesCompany).toLowerCase()));
		}
		if (simDataMap.get(IConstantData.viewAccessesAddress) != null && !simDataMap.get(IConstantData.viewAccessesAddress).equals("null"))
		{
			simConfig.setViewAccessesAddress(Boolean.parseBoolean(simDataMap.get(IConstantData.viewAccessesAddress).toLowerCase()));
		}
		if (simDataMap.get(IConstantData.viewAccessesProductAndServices) != null && !simDataMap.get(IConstantData.viewAccessesProductAndServices).equals("null"))
		{
			simConfig.setViewAccessesProductAndServices(Boolean.parseBoolean(simDataMap.get(IConstantData.viewAccessesProductAndServices).toLowerCase()));
		}
		if (simDataMap.get(IConstantData.viewAccessesSpendInformation) != null && !simDataMap.get(IConstantData.viewAccessesSpendInformation).equals("null"))
		{
			simConfig.setViewAccessesSpendInformation(Boolean.parseBoolean(simDataMap.get(IConstantData.viewAccessesSpendInformation).toLowerCase()));
		}
		if (simDataMap.get(IConstantData.viewAccessesDiversity) != null && !simDataMap.get(IConstantData.viewAccessesDiversity).equals("null"))
		{
			simConfig.setViewAccessesDiversity(Boolean.parseBoolean(simDataMap.get(IConstantData.viewAccessesDiversity).toLowerCase()));
		}
		if (simDataMap.get(IConstantData.viewAccessesFinancial) != null && !simDataMap.get(IConstantData.viewAccessesFinancial).equals("null"))
		{
			simConfig.setViewAccessesFinancial(Boolean.parseBoolean(simDataMap.get(IConstantData.viewAccessesFinancial).toLowerCase()));
		}
		if (simDataMap.get(IConstantData.viewAccessesInsurance) != null && !simDataMap.get(IConstantData.viewAccessesInsurance).equals("null"))
		{
			simConfig.setViewAccessesInsurance(Boolean.parseBoolean(simDataMap.get(IConstantData.viewAccessesInsurance).toLowerCase()));
		}
		if (simDataMap.get(IConstantData.viewAccessesPurchasing) != null && !simDataMap.get(IConstantData.viewAccessesPurchasing).equals("null"))
		{
			simConfig.setViewAccessesPurchasing(Boolean.parseBoolean(simDataMap.get(IConstantData.viewAccessesPurchasing).toLowerCase()));
		}
		if (simDataMap.get(IConstantData.simMasterDataFilesLocation) != null && !simDataMap.get(IConstantData.simMasterDataFilesLocation).equals("null"))
		{
			simConfig.setSimMasterDataFilesLocation(simDataMap.get(IConstantData.simMasterDataFilesLocation));
		}
		return simConfig;

	}

	public static Field getContractedSupplierObject() throws Exception
	{
		Field field = new Field();
		field.setFieldName(IConstantData.fieldName_ContractedSupplier);
		field.setDisplayName(IConstantData.displayName_ContractedSupplier);
		field.setMandatory(IConstantData.yes);
		field.setFieldType(IConstantData.fieldTypeRadioButton);
		field.setCharacterType(IConstantData.characterType_Text);
		field.setMaximumCharactersAllowed(IConstantData.maximumNoOfCharacterAllowed_ContractedSupplier);
		field.setValueStatic(true);
		field.setValueType(IConstantData.valueFormat);
		field.setNextAction(IConstantData.save);
		return field;

	}

	public static Field getPreferredSupplierObject() throws Exception
	{
		Field field = new Field();
		field.setFieldName(IConstantData.fieldName_IsPreferredSupplier);
		field.setDisplayName(IConstantData.displayName_IsPreferredSupplier);
		field.setMandatory(IConstantData.yes);
		field.setFieldType(IConstantData.fieldTypeRadioButton);
		field.setCharacterType(IConstantData.characterType_Text);
		field.setMaximumCharactersAllowed(IConstantData.maximumNoOfCharacterAllowed_IsPreferredSupplier);
		field.setValueStatic(true);
		field.setValueType(IConstantData.valueFormat);
		field.setNextAction(IConstantData.save);
		return field;

	}

	public static Field getCustomerIDObject() throws Exception
	{
		Field field = new Field();
		field.setFieldName(IConstantData.fieldName_CustomerId);
		field.setDisplayName(IConstantData.displayName_CustomerId);
		field.setMandatory(IConstantData.no);
		field.setFieldType(IConstantData.fieldTypeTextBox);
		field.setCharacterType(IConstantData.characterType_Text);
		field.setMaximumCharactersAllowed(IConstantData.maximumNoOfCharacterAllowed_ContractedSupplier);
		field.setNextAction(IConstantData.save);
		return field;

	}

	public static Field getCustomerIDGlobalPaymentTersObject() throws Exception
	{
		Field field = new Field();
		field.setFieldName(IConstantData.fieldName_CustomerId + "_G");
		field.setDisplayName(IConstantData.displayName_CustomerId);
		field.setMandatory(IConstantData.no);
		field.setFieldType(IConstantData.fieldTypeTextBox);
		field.setCharacterType(IConstantData.characterType_Text);
		field.setMaximumCharactersAllowed(IConstantData.maximumNoOfCharacterAllowed_ContractedSupplier);
		field.setNextAction(IConstantData.save);
		return field;

	}

	public static Field getSectionHeaderGlobalPaymentTermObject() throws Exception
	{
		Field field = new Field();
		field.setDisplayName(IConstantData.viewName_GPT + "_G");
		field.setMandatory(IConstantData.no);
		field.setFieldType(IConstantData.fieldType_SectionHeader);
		field.setNextAction(IConstantData.save);
		return field;
	}

	public static Field getPaymentTermObject(String clientId) throws Exception
	{

		Field field = new Field();
		field.setFieldName(IConstantData.fieldName_PaymentTerms);
		field.setDisplayName(IConstantData.displayName_PaymentTerms);
		field.setMandatory(IConstantData.yes);
		field.setFieldType(IConstantData.fieldTypeDropDownBox);
		field.setMaximumCharactersAllowed(IConstantData.maximumNoOfCharacterAllowed_ContractedSupplier);
		field.setReferrenceMasterTable(true);
		field.setReferenceMasterValue(((IConstantData.paymentTermsFile).toUpperCase() + "_" + clientId).toUpperCase());
		field.setRefrenceMasterDisplayCode(IConstantData.paymentTerms);
		field.setRefrenceMasterDisplayValue(IConstantData.displayCode);
		field.setNextAction(IConstantData.save);
		return field;
	}

	public static Field getPoSubmissionObject(String clientId) throws Exception
	{
		Field field = new Field();
		field.setFieldName(IConstantData.fieldName_PoSubmission);
		field.setDisplayName(IConstantData.displayName_PoSubmission);
		field.setMandatory(IConstantData.no);
		field.setFieldType(IConstantData.fieldTypeDropDownBox);
		field.setMaximumCharactersAllowed(IConstantData.maximumNoOfCharacterAllowed_ContractedSupplier);
		field.setReferrenceMasterTable(true);
		field.setReferenceMasterValue((IConstantData.poSubmission + "_" + clientId).toUpperCase());
		field.setRefrenceMasterDisplayCode(IConstantData.poSubmission);
		field.setRefrenceMasterDisplayValue(IConstantData.displayCode);
		field.setNextAction(IConstantData.save);
		return field;

	}

	public static Field getPaymentTypeObject(String clientId) throws Exception
	{
		Field field = new Field();
		field.setFieldName(IConstantData.fieldName_PaymentType);
		field.setDisplayName(IConstantData.displayName_PaymentType);
		field.setMandatory(IConstantData.no);
		field.setFieldType(IConstantData.fieldTypeDropDownBox);
		field.setMaximumCharactersAllowed(IConstantData.maximumNoOfCharacterAllowed_ContractedSupplier);
		field.setReferrenceMasterTable(true);
		field.setReferenceMasterValue((IConstantData.paymentType + "_" + clientId).toUpperCase());
		field.setRefrenceMasterDisplayCode(IConstantData.paymentType);
		field.setRefrenceMasterDisplayValue(IConstantData.displayCode);
		field.setNextAction(IConstantData.save);
		return field;

	}

	public static Field getCurrencyObject() throws Exception
	{
		Field field = new Field();
		field.setFieldName(IConstantData.fieldName_CurrencyType);
		field.setDisplayName(IConstantData.displayName_CurrencyType);
		field.setMandatory(IConstantData.yes);
		field.setFieldType(IConstantData.fieldTypeDropDownBox);
		field.setMaximumCharactersAllowed(IConstantData.maximumNoOfCharacterAllowed_ContractedSupplier);
		field.setReferrenceMasterTable(true);
		field.setCharacterType(IConstantData.characterType_Text);
		field.setReferenceMasterValue(IConstantData.currencyType_ReferenceMasterTable);
		field.setRefrenceMasterDisplayCode(IConstantData.currencyType_ReferenceKey);
		field.setRefrenceMasterDisplayValue(IConstantData.currencyType_ReferenceValue);
		field.setNextAction(IConstantData.save);
		return field;

	}

	public static MasterDataCmd getMasterdataForCMD() throws Exception
	{
		masterDataCmdMap = ExcelReader.getTestDataComboFromFileXlsx("masterDataCmdFile", "Main");
		MasterDataCmd masterData = new MasterDataCmd();

		if (masterDataCmdMap.get(IConstantData.Currency) != null && !(masterDataCmdMap.get(IConstantData.Currency).equals("null")))
		{
			masterData.setCurrency(masterDataCmdMap.get(IConstantData.Currency));
		}
		if (masterDataCmdMap.get(IConstantData.ExchangeRates) != null && !(masterDataCmdMap.get(IConstantData.ExchangeRates).equals("null")))
		{
			masterData.setExchangeRates(masterDataCmdMap.get(IConstantData.ExchangeRates));

		}
		if (masterDataCmdMap.get(IConstantData.UOM) != null && !(masterDataCmdMap.get(IConstantData.UOM).equals("null")))
		{
			masterData.setUOM(masterDataCmdMap.get(IConstantData.UOM));

		}
		if (masterDataCmdMap.get(IConstantData.Countries) != null && !(masterDataCmdMap.get(IConstantData.Countries).equals("null")))
		{
			masterData.setCountries(masterDataCmdMap.get(IConstantData.Countries));

		}
		if (masterDataCmdMap.get(IConstantData.State) != null && !(masterDataCmdMap.get(IConstantData.State).equals("null")))
		{
			masterData.setState(masterDataCmdMap.get(IConstantData.State));

		}
		if (masterDataCmdMap.get(IConstantData.Catagories) != null && !(masterDataCmdMap.get(IConstantData.Catagories).equals("null")))
		{
			masterData.setCatagories(masterDataCmdMap.get(IConstantData.Catagories));

		}
		if (masterDataCmdMap.get(IConstantData.DeliveryTerms) != null && !(masterDataCmdMap.get(IConstantData.DeliveryTerms).equals("null")))
		{
			masterData.setDeliveryTerms(masterDataCmdMap.get(IConstantData.DeliveryTerms));

		}
		if (masterDataCmdMap.get(IConstantData.PaymentTerms) != null && !(masterDataCmdMap.get(IConstantData.PaymentTerms).equals("null")))
		{
			masterData.setPaymentTerms(masterDataCmdMap.get(IConstantData.PaymentTerms));

		}
		if (masterDataCmdMap.get(IConstantData.PurchaseTypes) != null && !(masterDataCmdMap.get(IConstantData.PurchaseTypes).equals("null")))
		{
			masterData.setPurchaseTypes(masterDataCmdMap.get(IConstantData.PurchaseTypes));

		}
		if (masterDataCmdMap.get(IConstantData.Regions) != null && !(masterDataCmdMap.get(IConstantData.Regions).equals("null")))
		{
			masterData.setRegions(masterDataCmdMap.get(IConstantData.Regions));

		}
		if (masterDataCmdMap.get(IConstantData.Address) != null && !(masterDataCmdMap.get(IConstantData.Address).equals("null")))
		{
			masterData.setAddress(masterDataCmdMap.get(IConstantData.Address));

		}
		if (masterDataCmdMap.get(IConstantData.Locations) != null && !(masterDataCmdMap.get(IConstantData.Locations).equals("null")))
		{
			masterData.setLocations(masterDataCmdMap.get(IConstantData.Locations));

		}
		if (masterDataCmdMap.get(IConstantData.OrganizationUnits) != null && !(masterDataCmdMap.get(IConstantData.OrganizationUnits).equals("null")))
		{
			masterData.setOrganizationUnits(masterDataCmdMap.get(IConstantData.OrganizationUnits));

		}
		if (masterDataCmdMap.get(IConstantData.Departments) != null && !(masterDataCmdMap.get(IConstantData.Departments).equals("null")))
		{
			masterData.setDepartments(masterDataCmdMap.get(IConstantData.Departments));

		}
		if (masterDataCmdMap.get(IConstantData.CostCenters) != null && !(masterDataCmdMap.get(IConstantData.CostCenters).equals("null")))
		{
			masterData.setCostCenters(masterDataCmdMap.get(IConstantData.CostCenters));

		}
		if (masterDataCmdMap.get(IConstantData.Projects) != null && !(masterDataCmdMap.get(IConstantData.Projects).equals("null")))
		{
			masterData.setCurrency(masterDataCmdMap.get(IConstantData.Projects));

		}
		if (masterDataCmdMap.get(IConstantData.ProcurementScopeConfig) != null && !(masterDataCmdMap.get(IConstantData.ProcurementScopeConfig).equals("null")))
		{
			masterData.setProcurementScopeConfig(masterDataCmdMap.get(IConstantData.ProcurementScopeConfig));

		}
		if (masterDataCmdMap.get(IConstantData.Designation) != null && !(masterDataCmdMap.get(IConstantData.Designation).equals("null")))
		{
			masterData.setDesignation(masterDataCmdMap.get(IConstantData.Designation));

		}
		if (masterDataCmdMap.get(IConstantData.ClientSystems) != null && !(masterDataCmdMap.get(IConstantData.ClientSystems).equals("null")))
		{
			masterData.setCurrency(masterDataCmdMap.get(IConstantData.ClientSystems));
		}
		return masterData;
	}

}
