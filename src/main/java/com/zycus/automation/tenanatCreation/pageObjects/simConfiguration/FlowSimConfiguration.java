package com.zycus.automation.tenanatCreation.pageObjects.simConfiguration;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

public class FlowSimConfiguration
{
	static Logger logger = Logger.getLogger(FlowSimConfiguration.class);

	public static void goToSettingTabInSim(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.goToSettingTabInSim(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method fillSystemTenantAdminUser " + e, e);
		}

	}

	public static void clickonManageRoles(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.clickonManageRoles(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method fillSystemTenantAdminUser " + e, e);
		}

	}

	public static void clickOnEditMDM(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.clickOnEditMDM(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method fillSystemTenantAdminUser " + e, e);
		}

	}

	public static void clickOnViewAccesses(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.clickOnViewAccesses(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method fillSystemTenantAdminUser " + e, e);
		}

	}

	public static void selectCheckboxesForView_Company(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectCheckboxesForView_Company(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method fillSystemTenantAdminUser " + e, e);
		}

	}

	public static void selectCheckboxesForView_Address(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectCheckboxesForView_Address(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method fillSystemTenantAdminUser " + e, e);
		}

	}

	public static void selectCheckboxesForView_ProductAndServices(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectCheckboxesForView_ProductAndServices(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method fillSystemTenantAdminUser " + e, e);
		}

	}

	public static void selectCheckboxesForView_SpendInformation(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectCheckboxesForView_SpendInformation(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method fillSystemTenantAdminUser " + e, e);
		}

	}

	public static void selectCheckboxesForView_Diversity(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectCheckboxesForView_Diversity(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method fillSystemTenantAdminUser " + e, e);
		}

	}

	public static void selectCheckboxesForView_Financial(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectCheckboxesForView_Financial(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method fillSystemTenantAdminUser " + e, e);
		}

	}

	public static void selectCheckboxesForView_Insurance(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectCheckboxesForView_Insurance(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method fillSystemTenantAdminUser " + e, e);
		}

	}

	public static void selectCheckboxesForView_Purchasing(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectCheckboxesForView_Purchasing(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method fillSystemTenantAdminUser " + e, e);
		}

	}

	public static void clickOnSave_ViewAccesses(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.clickOnSave_ViewAccesses(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method fillSystemTenantAdminUser " + e, e);
		}

	}

	public static void clickOnMasterDataConfigHeaderTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.clickOnMasterDataConfigHeaderTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method fillSystemTenantAdminUser " + e, e);
		}

	}

	public static void clickOnManageClientHeaderTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.clickOnManageClientHeaderTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method fillSystemTenantAdminUser " + e, e);
		}

	}

	public static void clickOnCreateNewMaster(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.clickOnCreateNewMaster(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method fillSystemTenantAdminUser " + e, e);
		}

	}

	public static void enterTableName(WebDriver driver, String testCaseName, String tableName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.enterTableName(driver, testCaseName, tableName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method fillSystemTenantAdminUser " + e, e);
		}

	}

	public static void enterDisplayName(WebDriver driver, String testCaseName, String displayName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.enterDisplayName(driver, testCaseName, displayName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method fillSystemTenantAdminUser " + e, e);
		}

	}

	public static void enterColumnName(WebDriver driver, String testCaseName, String columnName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.enterColumnName(driver, testCaseName, columnName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method fillSystemTenantAdminUser " + e, e);
		}

	}

	public static void enterDisplayField(WebDriver driver, String testCaseName, String displayField) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.enterDisplayField(driver, testCaseName, displayField);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method fillSystemTenantAdminUser " + e, e);
		}

	}

	public static void selectFieldType(WebDriver driver, String testCaseName, String fieldType) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectFieldType(driver, testCaseName, fieldType);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method fillSystemTenantAdminUser " + e, e);
		}

	}

	public static void enterFieldLength(WebDriver driver, String testCaseName, String fieldLength) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.enterFieldLength(driver, testCaseName, fieldLength);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method fillSystemTenantAdminUser " + e, e);
		}

	}

	public static void selectContraint(WebDriver driver, String testCaseName, String constraint) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectContraint(driver, testCaseName, constraint);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method fillSystemTenantAdminUser " + e, e);
		}

	}

	public static void selectIsRequired(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectIsRequired(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method fillSystemTenantAdminUser " + e, e);
		}

	}

	public static void clickOnAddNewField(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.clickOnAddNewField(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method fillSystemTenantAdminUser " + e, e);
		}

	}

	public static void clickOnDone(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.clickOnDone(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method fillSystemTenantAdminUser " + e, e);
		}

	}

	public static void clickOnConfigureNewClient(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.clickOnConfigureNewClient(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method fillSystemTenantAdminUser " + e, e);
		}

	}

	public static void selectClient(WebDriver driver, String testCaseName, String clientName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectClient(driver, testCaseName, clientName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method fillSystemTenantAdminUser " + e, e);
		}

	}

	public static void enterClientIdentifier(WebDriver driver, String testCaseName, String clientIdentifier) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.enterClientIdentifier(driver, testCaseName, clientIdentifier);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method fillSystemTenantAdminUser " + e, e);
		}

	}

	public static void enterClientDescription(WebDriver driver, String testCaseName, String clientDescription) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.enterClientDescription(driver, testCaseName, clientDescription);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method enterClientDescription " + e, e);
		}

	}

	public static void clickOnSubmit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.clickOnSubmit(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method clickOnSubmit " + e, e);
		}

	}

	public static void selectFieldsForFacilityMaster(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectFieldsForFacilityMaster(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method selectFieldsForFacilityMaster " + e, e);
		}

	}

	public static void selectFieldsForSystemFacilityRelation(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectFieldsForSystemFacilityRelation(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method selectFieldsForSystemFacilityRelation " + e, e);
		}

	}

	public static void selectFieldsForINCOTerms(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectFieldsForINCOTerms(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method selectFieldsForINCOTerms " + e, e);
		}

	}

	public static void selectFieldsForLegalStructure(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectFieldsForLegalStructure(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method selectFieldsForLegalStructure " + e, e);
		}

	}

	public static void selectFieldsForPaymentTerms(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectFieldsForPaymentTerms(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method selectFieldsForPaymentTerms " + e, e);
		}

	}

	public static void selectFieldsForPaymentType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectFieldsForPaymentType(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method selectFieldsForPaymentType " + e, e);
		}

	}

	public static void selectFieldsForPoSubmission(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectFieldsForPoSubmission(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method selectFieldsForPoSubmission " + e, e);
		}

	}

	public static void selectFieldsForSupplierType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectFieldsForSupplierType(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method selectFieldsForSupplierType " + e, e);
		}

	}

	public static void selectFieldsForTransactionCount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectFieldsForTransactionCount(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method selectFieldsForTransactionCount " + e, e);
		}

	}

	public static void selectFieldsForSystemMaster(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectFieldsForSystemMaster(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method selectFieldsForSystemMaster " + e, e);
		}

	}

	public static void clickOnUpload(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.clickOnUpload(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method clickOnUpload " + e, e);
		}

	}

	public static void enterFileForUpload(WebDriver driver, String testCaseName, String fileName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.enterFileForUpload(driver, testCaseName, fileName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method enterFileForUpload " + e, e);
		}

	}

	public static void clickOnFinish(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.clickOnFinish(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method clickOnFinish " + e, e);
		}

	}

	public static void clickOnExpandViewPurchasing(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.clickOnExpandViewPurchasing(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method clickOnExpandViewPurchasing " + e, e);
		}

	}

	public static void clickManageFieldsPurchasingDetails(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.clickManageFieldsPurchasingDetails(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method clickManageFieldsPurchasingDetails " + e, e);
		}

	}

	public static void clickManageFieldsPaymentTerms(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.clickManageFieldsPaymentTerms(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method clickManageFieldsPaymentTerms " + e, e);
		}

	}

	public static void clickManageFieldsGlobalPaymentTerms(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.clickManageFieldsGlobalPaymentTerms(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method clickManageFieldsGlobalPaymentTerms " + e, e);
		}

	}

	public static void clickOnEditContractedSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.clickOnEditContractedSupplier(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method clickOnEditContractedSupplier " + e, e);
		}

	}

	public static void fillDisplayName(WebDriver driver, String testCaseName, String displayName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.fillDisplayName(driver, testCaseName, displayName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method fillDisplayName " + e, e);
		}

	}

	public static void fillFieldName(WebDriver driver, String testCaseName, String fieldName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.fillFieldName(driver, testCaseName, fieldName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method fillFieldName " + e, e);
		}

	}

	public static void selectMandatoryField_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectMandatoryField_Yes(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method selectMandatoryField_Yes " + e, e);
		}

	}

	public static void selectMandatoryField_No(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectMandatoryField_No(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method selectMandatoryField_Yes " + e, e);
		}

	}

	public static void selectValueFormat_Static(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectValueFormat_Static(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method selectValueFormat_Static " + e, e);
		}

	}

	public static void fillValueFormat(WebDriver driver, String testCaseName, String valueFormat) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.fillValueFormat(driver, testCaseName, valueFormat);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method fillValueFormat " + e, e);
		}

	}

	public static void clickOnSaveField(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.clickOnSaveField(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method clickOnSaveField " + e, e);
		}

	}
	

	public static void clickOnEditPaymentTerms(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.clickOnEditPaymentTerms(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method clickOnEditPurchasingDetails " + e, e);
		}

	}

	public static void clickOnEditPurchasingDetails(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.clickOnEditPurchasingDetails(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method clickOnEditPurchasingDetails " + e, e);
		}

	}

	public static void selectFieldType_manageView(WebDriver driver, String testCaseName, String fieldType) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectFieldType_manageView(driver, testCaseName, fieldType);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method selectFieldType_manageView " + e, e);
		}

	}

	public static void clickOnCreateNewField(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.clickOnCreateNewField(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method clickOnCreateNewField " + e, e);
		}

	}

	public static void fillMaximunColumnLength(WebDriver driver, String testCaseName, String columnLength) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.fillMaximunColumnLength(driver, testCaseName, columnLength);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method fillMaximunColumnLength " + e, e);
		}

	}

	public static void selectCharacterType_Text(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectCharacterType_Text(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method selectCharacterType_Text " + e, e);
		}

	}

	public static void clickOnManageViewsHeaderTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.clickOnManageViewsHeaderTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method clickOnManageViewsHeaderTab " + e, e);
		}

	}

	public static void clickOnLinkBackToManageViews(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.clickOnLinkBackToManageViews(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{
			logger.error("Factory Method Exception in method clickOnLinkBackToManageViews " + e, e);
		}

	}

	public static void clickOnCreateViews(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.clickOnCreateViews(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method clickOnCreateViews " + e, e);
		}

	}

	public static void fillViewName(WebDriver driver, String testCaseName, String viewName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.fillViewName(driver, testCaseName, viewName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method fillViewName " + e, e);
		}

	}

	public static void selectView_SubView(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectView_SubView(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method selectView_SubView " + e, e);
		}

	}

	public static void selectParentView(WebDriver driver, String testCaseName, String parentView) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectParentView(driver, testCaseName, parentView);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method selectParentView " + e, e);
		}

	}

	public static void selectAddToViewList_No(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectAddToViewList_No(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method selectAddToViewList_No " + e, e);
		}

	}

	public static void selectViewScope(WebDriver driver, String testCaseName, String scope) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectViewScope(driver, testCaseName, scope);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method selectViewScope " + e, e);
		}

	}

	public static void fillDisplayName_View(WebDriver driver, String testCaseName, String displayName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.fillDisplayName_View(driver, testCaseName, displayName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method fillDisplayName_View " + e, e);
		}

	}

	public static void fillDisplayRank(WebDriver driver, String testCaseName, String rank) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.fillDisplayRank(driver, testCaseName, rank);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method fillDisplayRank " + e, e);
		}

	}

	public static void selectViewLayout_2Columns(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectViewLayout_2Columns(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method selectViewLayout_2Columns " + e, e);
		}

	}

	public static void clickOnSaveView(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.clickOnSaveView(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method clickOnSaveView " + e, e);
		}

	}

	public static void selectValue_ReferenceMaster(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectValue_ReferenceMaster(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method selectValue_ReferenceMaster " + e, e);
		}

	}

	public static void selectReferenceMaster(WebDriver driver, String testCaseName, String referenceMaster) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectReferenceMaster(driver, testCaseName, referenceMaster);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method selectReferenceMaster " + e, e);
		}

	}

	public static void selectReferenceDisplayCode(WebDriver driver, String testCaseName, String displayCode) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectReferenceDisplayCode(driver, testCaseName, displayCode);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method selectRefrenceDisplayCode " + e, e);
		}

	}

	public static void selectReferenceDisplayValue(WebDriver driver, String testCaseName, String displayValue) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectReferenceDisplayValue(driver, testCaseName, displayValue);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method selectRefrenceDisplayValue " + e, e);
		}

	}

	public static void deactivateEdiDeliveryMethod(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.deactivateEdiDeliveryMethod(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method deactivateEdiDeliveryMethod " + e, e);
		}

	}

	public static void deactivateSupplierIndicator(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.deactivateSupplierIndicator(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method deactivateSupplierIndicator " + e, e);
		}

	}

	public static void deactivateEdiComment(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.deactivateEdiComment(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method deactivateEdiComment " + e, e);
		}

	}

	public static void deactivateEdiObjectMode(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.deactivateEdiObjectMode(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method deactivateEdiObjectMode " + e, e);
		}

	}

	public static void deactivateEdiPartnerId(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.deactivateEdiPartnerId(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method deactivateEdiPartnerId " + e, e);
		}

	}

	public static void deactivateEdiGsQualifier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.deactivateEdiGsQualifier(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method deactivateEdiGsQualifier " + e, e);
		}

	}

	public static void deactivateJustificationStatement(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.deactivateJustificationStatement(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method deactivateJustificationStatement " + e, e);
		}

	}

	public static void deactivateEdiGsAddress(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.deactivateEdiGsAddress(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method deactivateEdiGsAddress " + e, e);
		}

	}

	public static void deactivateEdiGoodsReceiptBasesInvoice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.deactivateEdiGoodsReceiptBasesInvoice(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method deactivateEdiGoodsReceiptBasesInvoice " + e, e);
		}

	}

	public static void deactivateCompetitorFlag(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.deactivateCompetitorFlag(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method deactivateCompetitorFlag " + e, e);
		}

	}

	public static void deactivateUsedAt(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.deactivateUsedAt(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method deactivateUsedAt " + e, e);
		}

	}

	public static void deactivateViewDiversity(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.deactivateViewDiversity(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method deactivateViewDiversity " + e, e);
		}

	}

	public static void deactivateViewFinancial(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.deactivateViewFinancial(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method deactivateViewFinancial " + e, e);
		}

	}

	public static void deactivateViewInsurance(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.deactivateViewInsurance(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method deactivateViewInsurance " + e, e);
		}

	}

	public static void clickOnActivateAndDeploy(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.clickOnActivateAndDeploy(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method clickOnActivateAndDeploy " + e, e);
		}

	}

	public static void goToHeaderManageUserTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.goToHeaderManageUserTab(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method goToHeaderManageUserTab " + e, e);
		}

	}

	public static void clickOnManageUserSidePanel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.clickOnManageUserSidePanel(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method clickOnManageUserSidePanel " + e, e);
		}

	}

	public static void clickOnEditUserDetails_ManageUser(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.clickOnEditUserDetails_ManageUser(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method clickOnEditUserDetails_ManageUser " + e, e);
		}

	}

	public static void clickOnSaveChangeToProfile(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.clickOnSaveChangeToProfile(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method clickOnSaveChangeToProfile " + e, e);
		}

	}

	public static void selectAllFacilities(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectAllFacilities(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method selectAllFacilities " + e, e);
		}

	}
	
	public static void selectMainRole(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			SimConfigurationsImpl simConfig = FactoryPage.getInstanceOf(SimConfigurationsImpl.class);
			simConfig.selectMainRole(driver, testCaseName);
		}
		catch (FactoryMethodException e)
		{

			logger.error("Factory Method Exception in method selectMainRole " + e, e);
		}

	}
}
