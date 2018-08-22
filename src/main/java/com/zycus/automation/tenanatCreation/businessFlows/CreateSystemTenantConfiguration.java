package com.zycus.automation.tenanatCreation.businessFlows;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.tenanatCreation.bo.IntegrationEntity;
import com.zycus.automation.tenanatCreation.bo.SystemLevelConfiguration;
import com.zycus.automation.tenanatCreation.bo.Tenant;
import com.zycus.automation.tenanatCreation.pageObjects.adminConfiguration.FlowAdminConfiguration;
import com.zycus.automation.tenanatCreation.utilities.IConstants.IConstantData;
import com.zycus.automation.tenanatCreation.utilities.excelReader.ExcelReader;
import com.zycus.automation.utilities.actionbot.ActionBot;

public class CreateSystemTenantConfiguration
{
	public static void fillSystemTenantConfiguration(WebDriver driver, String testCaseName, SystemLevelConfiguration systemLevelConfiguration, Tenant tenant, String product)
		throws ActionBotException
	{

		FlowAdminConfiguration.goToSystemLevelTenantConfigurationPage(driver, testCaseName);

		//		FlowAdminConfiguration.selectCompany(driver, testCaseName, companyName);

		ActionBot.defaultSleep();
		if (systemLevelConfiguration.getAdminUser() != null)
			FlowAdminConfiguration.fillSystemTenantAdminUser(driver, testCaseName, systemLevelConfiguration.getAdminUser());

		if (systemLevelConfiguration.getAdminEmailId() != null)
			FlowAdminConfiguration.fillSystemTenantAdminUserEmailId(driver, testCaseName, systemLevelConfiguration.getAdminEmailId());

		if (systemLevelConfiguration.getInvoiceAdminUser() != null)
			FlowAdminConfiguration.fillSystemTenantInvoiceAdminUser(driver, testCaseName, systemLevelConfiguration.getInvoiceAdminUser());

		if (systemLevelConfiguration.getApiEmail() != null)
			FlowAdminConfiguration.fillSystemTenantAPIEmail(driver, testCaseName, systemLevelConfiguration.getApiEmail());

		if (systemLevelConfiguration.geteInvoiceEventUrl() != null)
			FlowAdminConfiguration.fillSystemTenantInvoiceEventUrl(driver, testCaseName, systemLevelConfiguration.geteInvoiceEventUrl());

		if (systemLevelConfiguration.getiSourceEventUrl() != null)
			FlowAdminConfiguration.fillSystemTenantISourceEventUrl(driver, testCaseName, systemLevelConfiguration.getiSourceEventUrl());

		if (systemLevelConfiguration.getBaseUrl() != null)
			FlowAdminConfiguration.fillSystemTenantBaseUrl(driver, testCaseName, systemLevelConfiguration.getBaseUrl());

		if (systemLevelConfiguration.getUseRegionsForScoping() != null)
		{
			if (systemLevelConfiguration.getUseRegionsForScoping().equals("yes"))
				FlowAdminConfiguration.selectRegionForScoping_Yes(driver, testCaseName);
			if (systemLevelConfiguration.getUseRegionsForScoping().equals("no"))
				FlowAdminConfiguration.selectRegionForScoping_No(driver, testCaseName);
		}

		if (systemLevelConfiguration.getIseInvoiceIntegrated() != null)
		{
			if (systemLevelConfiguration.getIseInvoiceIntegrated().equals("yes"))
				FlowAdminConfiguration.selectInvoiceIntegrated_Yes(driver, testCaseName);
			if (systemLevelConfiguration.getIseInvoiceIntegrated().equals("no"))
				FlowAdminConfiguration.selectInvoiceIntegrated_No(driver, testCaseName);
		}

		if (systemLevelConfiguration.getEnableAnalyticsCRMSIntegration() != null)
		{
			if (systemLevelConfiguration.getEnableAnalyticsCRMSIntegration().equals("yes"))
				FlowAdminConfiguration.selectAnalyticsCRMSIntegration_Yes(driver, testCaseName);
			if (systemLevelConfiguration.getEnableAnalyticsCRMSIntegration().equals("no"))
				FlowAdminConfiguration.selectAnalyticsCRMSIntegration_No(driver, testCaseName);
		}

		if (systemLevelConfiguration.getAllowSupplierAdditionForStockItem() != null)
		{
			if (systemLevelConfiguration.getAllowSupplierAdditionForStockItem().equals("yes"))
				FlowAdminConfiguration.selectAllowSupplierForAdditionOfStockItem_YES(driver, testCaseName);
			if (systemLevelConfiguration.getAllowSupplierAdditionForStockItem().equals("no"))
				FlowAdminConfiguration.selectAllowSupplierForAdditionOfStockItem_NO(driver, testCaseName);
		}

		if (systemLevelConfiguration.getAutoClassUrl() != null)
			FlowAdminConfiguration.fillSystemTenantAutoClassUrl(driver, testCaseName, systemLevelConfiguration.getAutoClassUrl());

		if (systemLevelConfiguration.getAutoClassSchema() != null)
			FlowAdminConfiguration.fillSystemTenantAutoClassSchema(driver, testCaseName, systemLevelConfiguration.getAutoClassSchema());

		if (systemLevelConfiguration.getAutoClassProject() != null)
			FlowAdminConfiguration.fillSystemTenantProject(driver, testCaseName, systemLevelConfiguration.getAutoClassProject());

		if (systemLevelConfiguration.getAutoClassModel() != null)
			FlowAdminConfiguration.fillSystemTenantAutoClassModel(driver, testCaseName, systemLevelConfiguration.getAutoClassModel());

		if (systemLevelConfiguration.getAutoClassModelVersion() != null)
			FlowAdminConfiguration.fillSystemTenantAutoclassModelVersion(driver, testCaseName, systemLevelConfiguration.getAutoClassModelVersion());

		if (systemLevelConfiguration.getIsAutoRetriggerDocuments() != null)
		{
			if (systemLevelConfiguration.getIsAutoRetriggerDocuments().equals("yes"))
				FlowAdminConfiguration.selectRetriggerFailedDocument_Yes(driver, testCaseName);
			if (systemLevelConfiguration.getIsAutoRetriggerDocuments().equals("no"))
				FlowAdminConfiguration.selectRetriggerFailedDocument_No(driver, testCaseName);
		}

		if (systemLevelConfiguration.getAnalyticsCRMSIntegrationUrl() != null)
			FlowAdminConfiguration.fillAnalyticsCRMSIntegrationUrl(driver, testCaseName, systemLevelConfiguration.getAnalyticsCRMSIntegrationUrl());

		if (systemLevelConfiguration.getAttemptRetriggerInMins() != null)
			FlowAdminConfiguration.fillAttempRetriggerUrlInMins(driver, testCaseName, Integer.parseInt(systemLevelConfiguration.getAttemptRetriggerInMins()));

		if (systemLevelConfiguration.getMaximumNoOfAttempts() != null)
			FlowAdminConfiguration.fillMaximumNoOfAttempts(driver, testCaseName, Integer.parseInt(systemLevelConfiguration.getMaximumNoOfAttempts()));

		if (systemLevelConfiguration.getPredefinedFields() != null)
			FlowAdminConfiguration.selectPreDefinedFields(driver, testCaseName, systemLevelConfiguration.getPredefinedFields());

		if (systemLevelConfiguration.getTmsProductName() != null)
			FlowAdminConfiguration.fillTmsProductName(driver, testCaseName, systemLevelConfiguration.getTmsProductName());
		if (systemLevelConfiguration.getSmtpHost() != null)
			FlowAdminConfiguration.fillSmtpHost(driver, testCaseName, systemLevelConfiguration.getSmtpHost());
		if (systemLevelConfiguration.getDefaultEmailSender() != null)
			FlowAdminConfiguration.fillDefaultEmailSender(driver, testCaseName, systemLevelConfiguration.getDefaultEmailSender());
		if (systemLevelConfiguration.getApiEmailId() != null)
			FlowAdminConfiguration.fillApiEmailId(driver, testCaseName, systemLevelConfiguration.getApiEmailId());
		if (systemLevelConfiguration.getFileServerUrl() != null)
			FlowAdminConfiguration.fillFileServerUrl(driver, testCaseName, systemLevelConfiguration.getFileServerUrl());
		if (systemLevelConfiguration.getZsnIntegrationUrl() != null)
			FlowAdminConfiguration.fillZsnIntegrationUrl(driver, testCaseName, systemLevelConfiguration.getZsnIntegrationUrl());
		if (systemLevelConfiguration.getIsCatalogEnableSearchItem() != null)
		{
			if (systemLevelConfiguration.getIsCatalogEnableSearchItem().equalsIgnoreCase(IConstantData.yes))
				FlowAdminConfiguration.selectCatalogEnableSearch_Yes(driver, testCaseName);
			if (systemLevelConfiguration.getIsCatalogEnableSearchItem().equalsIgnoreCase(IConstantData.no))
				FlowAdminConfiguration.selectCatalogEnableSearch_No(driver, testCaseName);
		}

		if (systemLevelConfiguration.getUsageTracking() != null)
		{
			if (systemLevelConfiguration.getUsageTracking().equalsIgnoreCase(IConstantData.yes))
				FlowAdminConfiguration.selectUsageTracking_Yes(driver, testCaseName);
			if (systemLevelConfiguration.getUsageTracking().equalsIgnoreCase(IConstantData.no))
				FlowAdminConfiguration.selectUsageTracking_No(driver, testCaseName);
		}

		if (systemLevelConfiguration.getCMDeventUrl() != null)
			FlowAdminConfiguration.fillCmdProductUrl(driver, testCaseName, systemLevelConfiguration.getCMDeventUrl());
		if (systemLevelConfiguration.getUploadExchangeRateFilePath() != null)
		{
			FlowAdminConfiguration.UploadFileForExchangeRates(driver, testCaseName, systemLevelConfiguration.getUploadExchangeRateFilePath());
			FlowAdminConfiguration.clickOnUpdateEinvoice(driver, testCaseName);
		}
		//noOfIntegrationEntityToAdd
		if (systemLevelConfiguration.getNoOfIntegrationEntityToAdd() != null
			&& (product.equalsIgnoreCase(IConstantData.sheetName_eproc) || product.equalsIgnoreCase(IConstantData.sheetName_ecatalog)))
		{
			if (Integer.parseInt(systemLevelConfiguration.getNoOfIntegrationEntityToAdd()) > 0)
			{
				List<IntegrationEntity> entities = ExcelReader.getintegrationEntities(driver, testCaseName,
					Integer.parseInt(systemLevelConfiguration.getNoOfIntegrationEntityToAdd()), product);
				int noOfEntities = entities.size();
				for (int i = 0; i < noOfEntities; i++)
				{
					String entity = entities.get(i).getEntity();
					String toSystem = entities.get(i).getToSystem();
					String toUrl = entities.get(i).getToUrl();

					FlowAdminConfiguration.addIntegation(driver, testCaseName);
					FlowAdminConfiguration.selectEntity(driver, testCaseName, entity, i);
					FlowAdminConfiguration.fillToSystem(driver, testCaseName, toSystem, i);
					FlowAdminConfiguration.fillToUrl(driver, testCaseName, toUrl, i);
				}
			}
		}

		//CMD config

		if (systemLevelConfiguration.getCmdAutoClassUrl() != null)
			FlowAdminConfiguration.fillSystemTenantAutoClassUrl(driver, testCaseName, systemLevelConfiguration.getCmdAutoClassUrl());

		if (systemLevelConfiguration.getCmdAutoClassSchema() != null)
			FlowAdminConfiguration.fillSystemTenantAutoClassSchema(driver, testCaseName, systemLevelConfiguration.getCmdAutoClassSchema());

		if (systemLevelConfiguration.getCmdAutoClassProject() != null)
			FlowAdminConfiguration.fillSystemTenantProject(driver, testCaseName, systemLevelConfiguration.getCmdAutoClassProject());

		if (systemLevelConfiguration.getCmdAutoClassModel() != null)
			FlowAdminConfiguration.fillSystemTenantAutoClassModel(driver, testCaseName, systemLevelConfiguration.getCmdAutoClassModel());

		if (systemLevelConfiguration.getCmdAutoClassModelVersion() != null)
			FlowAdminConfiguration.fillSystemTenantAutoclassModelVersion(driver, testCaseName, systemLevelConfiguration.getCmdAutoClassModelVersion());

		FlowAdminConfiguration.enterSimClientId(driver, testCaseName);

		if (systemLevelConfiguration.getCmdSimUrl() != null)
			FlowAdminConfiguration.enterSimUrl(driver, testCaseName, systemLevelConfiguration.getCmdSimUrl());

		if (systemLevelConfiguration.getSimSupplierAddUrl() != null)
			FlowAdminConfiguration.enterSimSupplierAddUrl(driver, testCaseName, systemLevelConfiguration.getSimSupplierAddUrl());

		if (systemLevelConfiguration.getLanguagesForTranslation() != null)
		{
			if (systemLevelConfiguration.getLanguagesForTranslation().size() > 0)
			{
				FlowAdminConfiguration.clickOnLinkSelectLanguageForTranslation(driver, testCaseName);
				ActionBot.defaultLowSleep();
				for (String language : systemLevelConfiguration.getLanguagesForTranslation())
				{
					FlowAdminConfiguration.selectLanguageForTranslation(driver, testCaseName, language);
				}
				FlowAdminConfiguration.clickOnSaveLanguagesForTransaltion(driver, testCaseName);
				ActionBot.defaultLowSleep();
			}
		}

		if (systemLevelConfiguration.getUseBUinGL() != null)
		{
			if (systemLevelConfiguration.getUseBUinGL().equalsIgnoreCase(IConstantData.yes))
				FlowAdminConfiguration.selectBUInGL_YES(driver, testCaseName);
			if (systemLevelConfiguration.getUseBUinGL().equalsIgnoreCase(IConstantData.no))
				FlowAdminConfiguration.selectBUInGL_NO(driver, testCaseName);
			FlowAdminConfiguration.clickOnConfirmation_Yes(driver, testCaseName);
		}
		if (systemLevelConfiguration.getLinkDeptToOUlevels() != null)
		{
			if (systemLevelConfiguration.getLinkDeptToOUlevels().equalsIgnoreCase(IConstantData.yes))
				FlowAdminConfiguration.selectDeptToOU_YES(driver, testCaseName);
			if (systemLevelConfiguration.getLinkDeptToOUlevels().equalsIgnoreCase(IConstantData.no))
				FlowAdminConfiguration.selectDeptToOU_NO(driver, testCaseName);
			FlowAdminConfiguration.clickOnConfirmation_Yes(driver, testCaseName);
		}
		if (systemLevelConfiguration.getMatchPaymentTermWithUniqueCode() != null)
		{
			if (systemLevelConfiguration.getMatchPaymentTermWithUniqueCode().equalsIgnoreCase(IConstantData.yes))
				FlowAdminConfiguration.matchPTWithUnicode_YES(driver, testCaseName);
			if (systemLevelConfiguration.getMatchPaymentTermWithUniqueCode().equalsIgnoreCase(IConstantData.no))
				FlowAdminConfiguration.matchPTWithUnicode_NO(driver, testCaseName);
			FlowAdminConfiguration.clickOnConfirmation_Yes(driver, testCaseName);
		}

		//pending-> predefined fields
		FlowAdminConfiguration.clickButtonUpdate(driver, testCaseName);

		FlowAdminConfiguration.clickOnUpdateEinvoice(driver, testCaseName);

	}
}
