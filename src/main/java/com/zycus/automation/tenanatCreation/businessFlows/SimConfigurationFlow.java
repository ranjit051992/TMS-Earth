package com.zycus.automation.tenanatCreation.businessFlows;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.regexp.RE;
import org.openqa.selenium.WebDriver;

import com.gargoylesoftware.htmlunit.activex.javascript.msxml.MSXMLActiveXObjectFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.tenanatCreation.bo.ClientDetail;
import com.zycus.automation.tenanatCreation.bo.Field;
import com.zycus.automation.tenanatCreation.bo.Master;
import com.zycus.automation.tenanatCreation.bo.MasterStructure;
import com.zycus.automation.tenanatCreation.bo.SimConfiguration;
import com.zycus.automation.tenanatCreation.bo.Tenant;
import com.zycus.automation.tenanatCreation.pageObjects.simConfiguration.FlowSimConfiguration;
import com.zycus.automation.tenanatCreation.pageObjects.simConfiguration.SimConfigurations;
import com.zycus.automation.tenanatCreation.pageObjects.simConfiguration.SimConfigurationsImpl;
import com.zycus.automation.tenanatCreation.scripts.TenantCreation;
import com.zycus.automation.tenanatCreation.utilities.IConstants.IConstantData;
import com.zycus.automation.tenanatCreation.utilities.objectCreation.DefaultObjectCreation;
import com.zycus.automation.utilities.actionbot.ActionBot;

public class SimConfigurationFlow
{

	static Logger logger = Logger.getLogger(SimConfigurationFlow.class);

	public static void fillViewAccessForPurchasing(WebDriver driver, String testCaseName) throws ActionBotException
	{
		FlowSimConfiguration.goToHeaderManageUserTab(driver, testCaseName);

		if (!ActionBot.isElementDisplayed(driver, SimConfigurations.TAB_MANAGE_ROLES))
		{
			FlowSimConfiguration.goToSettingTabInSim(driver, testCaseName);
		}
		FlowSimConfiguration.clickonManageRoles(driver, testCaseName);

		FlowSimConfiguration.clickOnEditMDM(driver, testCaseName);

		FlowSimConfiguration.clickOnViewAccesses(driver, testCaseName);

		FlowSimConfiguration.selectCheckboxesForView_Purchasing(driver, testCaseName);

		FlowSimConfiguration.clickOnSave_ViewAccesses(driver, testCaseName);
	}

	public static void fillMasterValues(WebDriver driver, String testCaseName, SimConfiguration simConfg, List<Master> masterList, String companyName, String clientIdentifier)
		throws ActionBotException
	{

		if (!ActionBot.isElementDisplayed(driver, SimConfigurations.TAB_MANAGE_ROLES))
		{
			FlowSimConfiguration.goToSettingTabInSim(driver, testCaseName);
		}

		FlowSimConfiguration.clickonManageRoles(driver, testCaseName);

		FlowSimConfiguration.clickOnEditMDM(driver, testCaseName);

		FlowSimConfiguration.clickOnViewAccesses(driver, testCaseName);

		if (simConfg.isViewAccessesCompany())
		{
			FlowSimConfiguration.selectCheckboxesForView_Company(driver, testCaseName);
		}
		if (simConfg.isViewAccessesAddress())
		{
			FlowSimConfiguration.selectCheckboxesForView_Address(driver, testCaseName);
		}
		if (simConfg.isViewAccessesProductAndServices())
		{
			FlowSimConfiguration.selectCheckboxesForView_ProductAndServices(driver, testCaseName);
		}
		if (simConfg.isViewAccessesSpendInformation())
		{
			FlowSimConfiguration.selectCheckboxesForView_SpendInformation(driver, testCaseName);
		}
		if (simConfg.isViewAccessesDiversity())
		{
			FlowSimConfiguration.selectCheckboxesForView_Diversity(driver, testCaseName);
		}
		if (simConfg.isViewAccessesFinancial())
		{
			FlowSimConfiguration.selectCheckboxesForView_Financial(driver, testCaseName);
		}
		if (simConfg.isViewAccessesInsurance())
		{
			FlowSimConfiguration.selectCheckboxesForView_Insurance(driver, testCaseName);
		}
		if (simConfg.isViewAccessesPurchasing())
		{
			FlowSimConfiguration.selectCheckboxesForView_Purchasing(driver, testCaseName);
		}

		FlowSimConfiguration.clickOnSave_ViewAccesses(driver, testCaseName);

		FlowSimConfiguration.clickOnMasterDataConfigHeaderTab(driver, testCaseName);

		int size = masterList.size();
		Master currentMaster = new Master();
		MasterStructure masterStructure = new MasterStructure();
		for (int i = 0; i < size; i++)
		{
			FlowSimConfiguration.clickOnCreateNewMaster(driver, testCaseName);
			currentMaster = masterList.get(i);

			FlowSimConfiguration.enterTableName(driver, testCaseName, currentMaster.getTableName() + "_" + clientIdentifier);
			FlowSimConfiguration.enterDisplayName(driver, testCaseName, currentMaster.getDisplayName() + "_" + clientIdentifier);

			int noOfColumns = currentMaster.getMasterStructure().size();

			for (int j = 0; j < noOfColumns; j++)
			{
				masterStructure = currentMaster.getMasterStructure().get(j);
				FlowSimConfiguration.enterColumnName(driver, testCaseName, masterStructure.getColumnName());
				FlowSimConfiguration.enterDisplayField(driver, testCaseName, masterStructure.getDisplayField());
				FlowSimConfiguration.selectFieldType(driver, testCaseName, masterStructure.getFieldType());
				FlowSimConfiguration.enterFieldLength(driver, testCaseName, masterStructure.getFieldLength());
				if (masterStructure.isRequired() == true)
				{
					FlowSimConfiguration.selectIsRequired(driver, testCaseName);
				}
				FlowSimConfiguration.selectContraint(driver, testCaseName, masterStructure.getConstraint());
				FlowSimConfiguration.clickOnAddNewField(driver, testCaseName);
			}
			FlowSimConfiguration.clickOnDone(driver, testCaseName);

		}

	}

	public static void uploadMasterDataFiles(WebDriver driver, String testCaseName, String clientIdentifier, String location) throws ActionBotException
	{
		uploadFiles(driver, testCaseName, clientIdentifier, location, IConstantData.facilityMasterFile);
		uploadFiles(driver, testCaseName, clientIdentifier, location, IConstantData.systemPlantRelationFile);
		uploadFiles(driver, testCaseName, clientIdentifier, location, IConstantData.systemMasterFile);
		uploadFiles(driver, testCaseName, clientIdentifier, location, IConstantData.incoTermsFile);
		uploadFiles(driver, testCaseName, clientIdentifier, location, IConstantData.paymentTermsFile);
		uploadFiles(driver, testCaseName, clientIdentifier, location, IConstantData.paymentTypeFile);
		uploadFiles(driver, testCaseName, clientIdentifier, location, IConstantData.legalStructureFile);
		uploadFiles(driver, testCaseName, clientIdentifier, location, IConstantData.poSubmissionFile);
		uploadFiles(driver, testCaseName, clientIdentifier, location, IConstantData.transactionCountFile);
		uploadFiles(driver, testCaseName, clientIdentifier, location, IConstantData.supplierTypeFile);

	}

	public static void uploadFiles(WebDriver driver, String testCaseName, String clientIdentifier, String location, String masterType) throws ActionBotException
	{
		ActionBot.waitForElementToBeDisplayed(driver, SimConfigurationsImpl.BUTTON_CREATE_NEW_MASTER, ActionBot.timeOut);
		if (masterType.equalsIgnoreCase(IConstantData.facilityMasterFile))
		{
			//facility master
			ActionBot.click(driver, SimConfigurationsImpl.ACTION_FACILITY_MASTER);
			ActionBot.defaultLowSleep();
			ActionBot.click(driver, SimConfigurationsImpl.UPLOAD_ACTION_FACILITY_MASTER);
			ActionBot.waitForElementToBeDisplayed(driver, SimConfigurationsImpl.BUTTON_BROWSE, ActionBot.timeOut);
			FlowSimConfiguration.enterFileForUpload(driver, testCaseName, location + IConstantData.facilityMasterFile + "_" + clientIdentifier + ".txt");
			FlowSimConfiguration.clickOnUpload(driver, testCaseName);
			FlowSimConfiguration.selectFieldsForFacilityMaster(driver, testCaseName);
			FlowSimConfiguration.clickOnFinish(driver, testCaseName);

		}
		if (masterType.equalsIgnoreCase(IConstantData.systemPlantRelationFile))
		{
			//facility master
			ActionBot.click(driver, SimConfigurationsImpl.ACTION_SYSTEM_FACILITY_RELATION);
			ActionBot.defaultLowSleep();
			ActionBot.click(driver, SimConfigurationsImpl.UPLOAD_ACTION_SYSTEM_FACILITY_MASTER);
			ActionBot.waitForElementToBeDisplayed(driver, SimConfigurationsImpl.BUTTON_BROWSE, ActionBot.timeOut);
			FlowSimConfiguration.enterFileForUpload(driver, testCaseName, location + IConstantData.systemPlantRelationFile + "_" + clientIdentifier + ".txt");
			FlowSimConfiguration.clickOnUpload(driver, testCaseName);
			FlowSimConfiguration.selectFieldsForSystemFacilityRelation(driver, testCaseName);
			FlowSimConfiguration.clickOnFinish(driver, testCaseName);
		}

		if (masterType.equalsIgnoreCase(IConstantData.systemMasterFile))
		{
			//facility master
			ActionBot.click(driver, SimConfigurationsImpl.ACTION_SYSTEM_MASTER);
			ActionBot.defaultLowSleep();
			ActionBot.click(driver, SimConfigurationsImpl.UPLOAD_ACTION_SYSTEM_MASTER);
			ActionBot.waitForElementToBeDisplayed(driver, SimConfigurationsImpl.BUTTON_BROWSE, ActionBot.timeOut);
			FlowSimConfiguration.enterFileForUpload(driver, testCaseName, location + IConstantData.systemMasterFile + "_" + clientIdentifier + ".txt");
			FlowSimConfiguration.clickOnUpload(driver, testCaseName);
			FlowSimConfiguration.selectFieldsForSystemMaster(driver, testCaseName);
			FlowSimConfiguration.clickOnFinish(driver, testCaseName);

		}

		if (masterType.equalsIgnoreCase(IConstantData.incoTermsFile))
		{
			//facility master
			ActionBot.click(driver, SimConfigurationsImpl.ACTION_INCO_TERMS);
			ActionBot.defaultLowSleep();
			ActionBot.click(driver, SimConfigurationsImpl.UPLOAD_ACTION_INCO_TERMS);
			//			ActionBot.defaultLowSleep();
			ActionBot.waitForElementToBeDisplayed(driver, SimConfigurationsImpl.BUTTON_BROWSE, ActionBot.timeOut);
			FlowSimConfiguration.enterFileForUpload(driver, testCaseName, location + IConstantData.incoTermsFile + "_" + clientIdentifier + ".txt");
			FlowSimConfiguration.clickOnUpload(driver, testCaseName);
			FlowSimConfiguration.selectFieldsForINCOTerms(driver, testCaseName);
			FlowSimConfiguration.clickOnFinish(driver, testCaseName);

		}

		if (masterType.equalsIgnoreCase(IConstantData.paymentTermsFile))
		{
			//facility master
			ActionBot.click(driver, SimConfigurationsImpl.ACTION_PAYMENT_TERMS);
			ActionBot.defaultLowSleep();
			ActionBot.click(driver, SimConfigurationsImpl.UPLOAD_ACTION_PAYMENT_TERMS);
			ActionBot.waitForElementToBeDisplayed(driver, SimConfigurationsImpl.BUTTON_BROWSE, ActionBot.timeOut);
			FlowSimConfiguration.enterFileForUpload(driver, testCaseName, location + IConstantData.paymentTermsFile + "_" + clientIdentifier + ".txt");
			FlowSimConfiguration.clickOnUpload(driver, testCaseName);
			FlowSimConfiguration.selectFieldsForPaymentTerms(driver, testCaseName);
			FlowSimConfiguration.clickOnFinish(driver, testCaseName);

		}

		if (masterType.equalsIgnoreCase(IConstantData.paymentTypeFile))
		{
			//facility master
			ActionBot.click(driver, SimConfigurationsImpl.ACTION_PAYMENT_TYPE);
			ActionBot.defaultLowSleep();
			ActionBot.click(driver, SimConfigurationsImpl.UPLOAD_ACTION_PAYMENT_TYPE);
			ActionBot.waitForElementToBeDisplayed(driver, SimConfigurationsImpl.BUTTON_BROWSE, ActionBot.timeOut);
			FlowSimConfiguration.enterFileForUpload(driver, testCaseName, location + IConstantData.paymentTypeFile + "_" + clientIdentifier + ".txt");
			FlowSimConfiguration.clickOnUpload(driver, testCaseName);
			FlowSimConfiguration.selectFieldsForPaymentType(driver, testCaseName);
			FlowSimConfiguration.clickOnFinish(driver, testCaseName);

		}

		if (masterType.equalsIgnoreCase(IConstantData.legalStructureFile))
		{
			//facility master
			ActionBot.click(driver, SimConfigurationsImpl.ACTION_LEGAL_STRUCTURE);
			ActionBot.defaultLowSleep();
			ActionBot.click(driver, SimConfigurationsImpl.UPLOAD_ACTION_LEGAL_STRUCTURE);
			ActionBot.waitForElementToBeDisplayed(driver, SimConfigurationsImpl.BUTTON_BROWSE, ActionBot.timeOut);
			FlowSimConfiguration.enterFileForUpload(driver, testCaseName, location + IConstantData.legalStructureFile + "_" + clientIdentifier + ".txt");
			FlowSimConfiguration.clickOnUpload(driver, testCaseName);
			FlowSimConfiguration.selectFieldsForLegalStructure(driver, testCaseName);
			FlowSimConfiguration.clickOnFinish(driver, testCaseName);

		}

		if (masterType.equalsIgnoreCase(IConstantData.poSubmissionFile))
		{
			//facility master
			ActionBot.click(driver, SimConfigurationsImpl.ACTION_PO_SUBMISSION);
			ActionBot.defaultLowSleep();
			ActionBot.click(driver, SimConfigurationsImpl.UPLOAD_ACTION_PO_SUBMISSION);
			ActionBot.waitForElementToBeDisplayed(driver, SimConfigurationsImpl.BUTTON_BROWSE, ActionBot.timeOut);
			FlowSimConfiguration.enterFileForUpload(driver, testCaseName, location + IConstantData.poSubmissionFile + "_" + clientIdentifier + ".txt");
			FlowSimConfiguration.clickOnUpload(driver, testCaseName);
			FlowSimConfiguration.selectFieldsForPoSubmission(driver, testCaseName);
			FlowSimConfiguration.clickOnFinish(driver, testCaseName);

		}

		if (masterType.equalsIgnoreCase(IConstantData.supplierTypeFile))
		{
			//facility master
			ActionBot.click(driver, SimConfigurationsImpl.ACTION_SUPPLIER_TYPE);
			ActionBot.defaultLowSleep();
			ActionBot.click(driver, SimConfigurationsImpl.UPLOAD_ACTION_SUPPLIER_TYPE);
			ActionBot.waitForElementToBeDisplayed(driver, SimConfigurationsImpl.BUTTON_BROWSE, ActionBot.timeOut);
			FlowSimConfiguration.enterFileForUpload(driver, testCaseName, location + IConstantData.supplierTypeFile + "_" + clientIdentifier + ".txt");
			FlowSimConfiguration.clickOnUpload(driver, testCaseName);
			FlowSimConfiguration.selectFieldsForSupplierType(driver, testCaseName);
			FlowSimConfiguration.clickOnFinish(driver, testCaseName);

		}

		if (masterType.equalsIgnoreCase(IConstantData.transactionCountFile))
		{
			//facility master
			ActionBot.click(driver, SimConfigurationsImpl.ACTION_TRANSACTION_COUNT);
			ActionBot.defaultLowSleep();
			ActionBot.click(driver, SimConfigurationsImpl.UPLOAD_ACTION_TRANSACTION_COUNT);
			ActionBot.waitForElementToBeDisplayed(driver, SimConfigurationsImpl.BUTTON_BROWSE, ActionBot.timeOut);
			FlowSimConfiguration.enterFileForUpload(driver, testCaseName, location + IConstantData.transactionCountFile + "_" + clientIdentifier + ".txt");
			FlowSimConfiguration.clickOnUpload(driver, testCaseName);
			FlowSimConfiguration.selectFieldsForTransactionCount(driver, testCaseName);
			FlowSimConfiguration.clickOnFinish(driver, testCaseName);

		}
		ActionBot.defaultSleep();
		//if cancel button is present
		if (ActionBot.isElementDisplayed(driver, SimConfigurationsImpl.BUTTON_CANCEL_UPLOAD))
		{
			System.out.println("Please verify the file provided by you !!! It failed to upload data!!!   ->" + masterType + "\n");
			ActionBot.click(driver, SimConfigurationsImpl.BUTTON_CANCEL_UPLOAD);
			ActionBot.defaultSleep();
		}
		ActionBot.defaultSleep();
	}

	public static void remaneFilesForSIMMasterData(WebDriver driver, String testCaseName, String location, String clientIdentifier, List<String> files) throws ActionBotException
	{
		int noOfFiles = files.size();
		String filePath = "";
		String filePathToBeModified = "";
		for (int i = 0; i < noOfFiles; i++)
		{
			filePath = location + files.get(i);
			String filePathTemp = filePath.split(".txt")[0];
			File oldFile = new File(filePath);
			filePathToBeModified = filePathTemp + "_" + clientIdentifier + ".txt";
			File newFile = new File(filePathToBeModified);

			if (oldFile.renameTo(newFile))
			{
				logger.info("Rename for file " + filePath + " done to file " + filePathToBeModified);
			}
			else
			{
				logger.info("Rename for file " + filePath + " FAILED to rename " + filePathToBeModified);
			}

		}
	}

	public static void configureClientInSIM(WebDriver driver, String testCaseName, ClientDetail clientDetail) throws ActionBotException
	{
		FlowSimConfiguration.clickOnManageClientHeaderTab(driver, testCaseName);
		ActionBot.waitForElementToBeEnable(driver, SimConfigurations.BUTTON_CONFIGURE_NEW_CLIENT, ActionBot.timeOut);
		FlowSimConfiguration.clickOnConfigureNewClient(driver, testCaseName);
		ActionBot.waitForElementToBeDisplayed(driver, SimConfigurations.TEXTBOX_CLIENT_IDENTIFIER, ActionBot.timeOut);
		FlowSimConfiguration.selectClient(driver, testCaseName, clientDetail.getClientName());
		FlowSimConfiguration.enterClientIdentifier(driver, testCaseName, clientDetail.getClientIdentifier());
		if (clientDetail.getClientDescription() != null && !clientDetail.getClientDescription().equals(""))
		{
			FlowSimConfiguration.enterClientDescription(driver, testCaseName, clientDetail.getClientDescription());
		}
		FlowSimConfiguration.clickOnSubmit(driver, testCaseName);
		ActionBot.waitForElementToBeEnable(driver, SimConfigurations.BUTTON_CONFIGURE_NEW_CLIENT, ActionBot.timeOut);
	}

	public static void deactivateFields(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			FlowSimConfiguration.deactivateEdiDeliveryMethod(driver, testCaseName);

			FlowSimConfiguration.deactivateEdiComment(driver, testCaseName);

			FlowSimConfiguration.deactivateSupplierIndicator(driver, testCaseName);

			FlowSimConfiguration.deactivateEdiObjectMode(driver, testCaseName);

			FlowSimConfiguration.deactivateEdiPartnerId(driver, testCaseName);

			FlowSimConfiguration.deactivateEdiGsQualifier(driver, testCaseName);

			FlowSimConfiguration.deactivateJustificationStatement(driver, testCaseName);

			FlowSimConfiguration.deactivateEdiGsAddress(driver, testCaseName);

			FlowSimConfiguration.deactivateEdiGoodsReceiptBasesInvoice(driver, testCaseName);

			FlowSimConfiguration.deactivateCompetitorFlag(driver, testCaseName);

			FlowSimConfiguration.deactivateUsedAt(driver, testCaseName);

			FlowSimConfiguration.clickOnLinkBackToManageViews(driver, testCaseName);

			FlowSimConfiguration.deactivateViewDiversity(driver, testCaseName);

			FlowSimConfiguration.deactivateViewFinancial(driver, testCaseName);

			FlowSimConfiguration.deactivateViewInsurance(driver, testCaseName);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	public static void addFacilities(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{

			FlowSimConfiguration.goToHeaderManageUserTab(driver, testCaseName);
			ActionBot.waitForElementToBeDisplayed(driver, SimConfigurations.SIDE_PANNEL_MANAGE_USERS, ActionBot.timeOut);
			FlowSimConfiguration.clickOnManageUserSidePanel(driver, testCaseName);
			ActionBot.waitForElementToBeDisplayed(driver, SimConfigurations.LINK_EDIT_USER_DETAIL_MANAGE_USERS, ActionBot.timeOut);
			ActionBot.click(driver, SimConfigurations.BUTTON_SYNC_USERS);
			ActionBot.defaultMediumSleep();
			FlowSimConfiguration.clickonManageRoles(driver, testCaseName);
			ActionBot.defaultLowSleep();
			FlowSimConfiguration.clickOnManageUserSidePanel(driver, testCaseName);
			ActionBot.waitForElementToBeDisplayed(driver, SimConfigurations.LINK_EDIT_USER_DETAIL_MANAGE_USERS, ActionBot.timeOut);
			FlowSimConfiguration.clickOnEditUserDetails_ManageUser(driver, testCaseName);
			ActionBot.waitForElementToBeDisplayed(driver, SimConfigurations.BUTTON_SAVE_CHANGES_TO_PROFILE, ActionBot.timeOut);
			FlowSimConfiguration.selectMainRole(driver, testCaseName);
			FlowSimConfiguration.selectAllFacilities(driver, testCaseName);
			FlowSimConfiguration.clickOnSaveChangeToProfile(driver, testCaseName);
			ActionBot.waitForElementToBeDisplayed(driver, SimConfigurations.LINK_EDIT_USER_DETAIL_MANAGE_USERS, ActionBot.timeOut);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	public static void configureManageViewsForPurchaseDetails(WebDriver driver, String testCaseName, ClientDetail clientDetail) throws ActionBotException
	{
		FlowSimConfiguration.clickOnManageViewsHeaderTab(driver, testCaseName);
		ActionBot.waitForElementToBeEnable(driver, SimConfigurations.BUTTON_CREATE_VIEW, ActionBot.timeOut);

		try
		{
			Field contractedSupplier = DefaultObjectCreation.getContractedSupplierObject();

			//For Purchasing details_ contracted supplier
			FlowSimConfiguration.clickOnExpandViewPurchasing(driver, testCaseName);
			FlowSimConfiguration.clickManageFieldsPurchasingDetails(driver, testCaseName);
			FlowSimConfiguration.clickOnEditContractedSupplier(driver, testCaseName);

			fillFieldData(driver, testCaseName, contractedSupplier);

			//for is prefered supplier
			Field preferredSupplier = DefaultObjectCreation.getPreferredSupplierObject();
			FlowSimConfiguration.clickOnCreateNewField(driver, testCaseName);
			fillFieldData(driver, testCaseName, preferredSupplier);

			FlowSimConfiguration.clickOnLinkBackToManageViews(driver, testCaseName);
			ActionBot.waitForElementToBeEnable(driver, SimConfigurations.BUTTON_CREATE_VIEW, ActionBot.timeOut);

			//for Customer Id
			FlowSimConfiguration.clickOnExpandViewPurchasing(driver, testCaseName);
			FlowSimConfiguration.clickManageFieldsPaymentTerms(driver, testCaseName);
			ActionBot.waitForElementToBeEnable(driver, SimConfigurations.BUTTON_CREATE_NEW_FIELD, ActionBot.timeOut);

			FlowSimConfiguration.clickOnCreateNewField(driver, testCaseName);
			Field customerId = DefaultObjectCreation.getCustomerIDObject();
			fillFieldData(driver, testCaseName, customerId);

			//for GlobalPayment term
			FlowSimConfiguration.clickOnLinkBackToManageViews(driver, testCaseName);
			ActionBot.waitForElementToBeEnable(driver, SimConfigurations.BUTTON_CREATE_VIEW, ActionBot.timeOut);

			FlowSimConfiguration.clickOnCreateViews(driver, testCaseName);
			addViewGlobalPaymentTerm(driver, testCaseName, clientDetail.getClientIdentifier());

			goToManageFieldsForGlobalPaymentTerms(driver, testCaseName);
			//For section header global payment term 
			FlowSimConfiguration.clickOnCreateNewField(driver, testCaseName);
			Field globalPaymentTerm = DefaultObjectCreation.getSectionHeaderGlobalPaymentTermObject();
			fillFieldData(driver, testCaseName, globalPaymentTerm);

			//payment terms
			FlowSimConfiguration.clickOnCreateNewField(driver, testCaseName);
			Field paymentTerm = DefaultObjectCreation.getPaymentTermObject(clientDetail.getClientIdentifier());
			fillFieldData(driver, testCaseName, paymentTerm);

			//Currency
			FlowSimConfiguration.clickOnCreateNewField(driver, testCaseName);
			Field currencyType = DefaultObjectCreation.getCurrencyObject();
			fillFieldData(driver, testCaseName, currencyType);

			//Customer Id
			FlowSimConfiguration.clickOnCreateNewField(driver, testCaseName);
			Field customerIdGlobalPaymentTerm = DefaultObjectCreation.getCustomerIDGlobalPaymentTersObject();
			fillFieldData(driver, testCaseName, customerIdGlobalPaymentTerm);

			//poSubmission
			FlowSimConfiguration.clickOnCreateNewField(driver, testCaseName);
			Field poSubmissionGPT = DefaultObjectCreation.getPoSubmissionObject(clientDetail.getClientIdentifier());
			fillFieldData(driver, testCaseName, poSubmissionGPT);

			//payment Type
			FlowSimConfiguration.clickOnCreateNewField(driver, testCaseName);
			Field paymentTypeGPT = DefaultObjectCreation.getPaymentTypeObject(clientDetail.getClientIdentifier());
			fillFieldData(driver, testCaseName, paymentTypeGPT);

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	public static void addViewGlobalPaymentTerm(WebDriver driver, String testCaseName, String clientId) throws ActionBotException
	{
		FlowSimConfiguration.fillViewName(driver, testCaseName, IConstantData.viewName_GPT + "_" + clientId);
		FlowSimConfiguration.selectView_SubView(driver, testCaseName);
		FlowSimConfiguration.selectParentView(driver, testCaseName, IConstantData.parentView_GPT);
		FlowSimConfiguration.selectAddToViewList_No(driver, testCaseName);
		FlowSimConfiguration.selectViewScope(driver, testCaseName, IConstantData.viewScope_GPT);
		FlowSimConfiguration.fillDisplayName_View(driver, testCaseName, IConstantData.displayName_GPT);
		FlowSimConfiguration.fillDisplayRank(driver, testCaseName, IConstantData.displayRank_GPT);
		FlowSimConfiguration.selectMandatoryField_Yes(driver, testCaseName);
		FlowSimConfiguration.selectViewLayout_2Columns(driver, testCaseName);
		FlowSimConfiguration.clickOnSaveView(driver, testCaseName);
		ActionBot.waitForElementToBeDisplayed(driver, SimConfigurations.BUTTON_CREATE_VIEW, ActionBot.timeOut);

	}

	public static void goToManageFieldsForGlobalPaymentTerms(WebDriver driver, String testCaseName) throws ActionBotException
	{
		FlowSimConfiguration.clickOnManageViewsHeaderTab(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
		ActionBot.waitForElementToBeDisplayed(driver, SimConfigurations.BUTTON_CREATE_VIEW, ActionBot.timeOut);

		//		if (!ActionBot.isElementDisplayed(driver, SimConfigurations.MANAGE_FIELDS_GLOBAL_PAYMENT_TERMS))
		//		{
		ActionBot.click(driver, SimConfigurations.LINK_EXPAND_VIEW_PURCHASING);
		//		}
		ActionBot.click(driver, SimConfigurations.MANAGE_FIELDS_GLOBAL_PAYMENT_TERMS);

	}

	public static void fillFieldData(WebDriver driver, String testCaseName, Field field) throws ActionBotException
	{
		System.out.println();
		if (field.getFieldType() != null)
			FlowSimConfiguration.selectFieldType_manageView(driver, testCaseName, field.getFieldType());
		if (field.getDisplayName() != null)
			FlowSimConfiguration.fillDisplayName(driver, testCaseName, field.getDisplayName());
		if (field.getMandatory() != null)
		{
			if (field.getMandatory().equalsIgnoreCase(IConstantData.yes))
				FlowSimConfiguration.selectMandatoryField_Yes(driver, testCaseName);
			if (field.getMandatory().equalsIgnoreCase(IConstantData.no))
				FlowSimConfiguration.selectMandatoryField_No(driver, testCaseName);
		}
		if (field.getFieldName() != null)
			FlowSimConfiguration.fillFieldName(driver, testCaseName, field.getFieldName());
		//		if (field.getFieldType() != null)
		//		{
		//			FlowSimConfiguration.selectFieldType_manageView(driver, testCaseName, field.getFieldType());
		//		}
		if (field.getCharacterType() != null)
		{
			if (field.getCharacterType().equalsIgnoreCase(IConstantData.characterType_Text))
				FlowSimConfiguration.selectCharacterType_Text(driver, testCaseName);
			//else to be writen
		}
		if (field.getMaximumCharactersAllowed() != null)
			FlowSimConfiguration.fillMaximunColumnLength(driver, testCaseName, field.getMaximumCharactersAllowed());

		if (field.isValueStatic())
		{
			FlowSimConfiguration.selectValueFormat_Static(driver, testCaseName);

			if (field.getValueType() != null)
				FlowSimConfiguration.fillValueFormat(driver, testCaseName, field.getValueType());
		}
		if (field.isReferrenceMasterTable())
		{
			FlowSimConfiguration.selectValue_ReferenceMaster(driver, testCaseName);
			FlowSimConfiguration.selectReferenceMaster(driver, null, field.getReferenceMasterValue());
			FlowSimConfiguration.selectReferenceDisplayCode(driver, testCaseName, field.getRefrenceMasterDisplayCode());
			FlowSimConfiguration.selectReferenceDisplayValue(driver, testCaseName, field.getRefrenceMasterDisplayValue());

		}
		if (field.getNextAction() != null)
		{
			if (field.getNextAction().equalsIgnoreCase(IConstantData.save))
				FlowSimConfiguration.clickOnSaveField(driver, testCaseName);
			//else to be writen
		}
		ActionBot.waitForElementToBeEnable(driver, SimConfigurations.BUTTON_CREATE_NEW_FIELD, ActionBot.timeOut);
	}

}
