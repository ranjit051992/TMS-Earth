package com.zycus.automation.eproc.businessflow.settingMapFlow;

import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.sun.jna.platform.win32.OaIdl._VARIANT_BOOLByReference;
import com.zycus.automation.constants.SettingMapConstants;
import com.zycus.automation.eproc.pageobjects.pages.settings.budgetsettings.PageBudgetSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.buyersdesksettings.PageBuyersDeskSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.cusomizesettings.PageCustomizeSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.masterdatatenantlevelconfig.PageMasterDataTenantLevelConfigSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.projectssettings.PageProjectsSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.purchaseordersettings.PagePurchaseOrderSetting;
import com.zycus.automation.eproc.pageobjects.pages.settings.requisitionsettings.PageRequisitionSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.workflowsettings.PageWorkflowSettings;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;

/**
 * @author kunal.ashar
 */

public class FlowSettingMap
{
	static Logger logger = Logger.getLogger(FlowSettingMap.class);

	public static void changeAllSettings(String groupName, Map<String, Map<String, String>> settingMap, WebDriver driver)
	{
		Map<String, String> localMap = settingMap.get(groupName);
		logger.info("Changing Setting for Key: " + groupName + "\n SettingMap: " + localMap);

		try
		{
			//Changing Requisition setting
			changeRequisitonSettings(localMap, driver, groupName);

			//Changing Buyers Desk setting
			changeBuyersDeskSettings(localMap, driver, groupName);

			//Changing PO setting
			changePurchaseOrderSettings(localMap, driver, groupName);

			//Changing Cost Booking setting
			changeCostBookingSettings(localMap, driver, groupName);

			//Changing Master Data - Control setting
			changeMasterDataControlSettings(localMap, driver, groupName);

			//Changing Master Data - Cost Booking setting
			changeMasterDataCostBookingSettings(localMap, driver, groupName);

			//Changing Workflow setting
			changeWorkflowSettings(localMap, driver, groupName);
		}
		catch (Exception e)
		{
			logger.info("Exception ocured while changing settings for Key: " + groupName);
		}

	}

	public static void changeRequisitonSettings(Map<String, String> requisitionMap, WebDriver driver, String groupName) throws ActionBotException
	{

		// navigates to EPROC
		driver.get(ConfigProperty.getConfig("Product_URL"));
		ActionBot.waitForPageLoad(driver);
		MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
		ActionBot.waitForPageLoad(driver);

		//Navigating to Requisition Setting Page

		// to click on customize tab
		MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
		ActionBot.waitForPageLoad(driver);

		// to click on requisition setting link
		PageCustomizeSettings.clickOnRequisitionLink(driver, groupName);
		ActionBot.waitForPageLoad(driver);

		//Requisition 1: Allow requesters to order free text items
		if (requisitionMap.get(SettingMapConstants.Requisition1) != null)
		{
			if (requisitionMap.get(SettingMapConstants.Requisition1).equalsIgnoreCase(IConstantsData.Requisition_Always))
			{

				if (PageRequisitionSettings.clickOnOrderFreeTextItemsAlways(driver, groupName))
				{
					logger.info("After Clicking on Radio Always for Allow requesters to order free text items setting. Setting Key: " + groupName);
				}
				else
				{
					logger.error("Error Clicking on Radio Always for Allow requesters to order free text items setting. Setting Key: " + groupName);
				}
			}
			else if (requisitionMap.get(SettingMapConstants.Requisition1).equalsIgnoreCase(IConstantsData.Requisition_Never))
			{
				if (PageRequisitionSettings.clickOnOrderFreeTextItemsNever(driver, groupName))
				{
					logger.info("After Clicking on Radio Never for Allow requesters to order free text items setting. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Never for Allow requesters to order free text items setting. Setting Key: " + groupName);
				}
			}
			else if (requisitionMap.get(SettingMapConstants.Requisition1).equalsIgnoreCase(IConstantsData.Requisition_Permission_Based))
			{
				if (PageRequisitionSettings.clickOnOrderFreeTextItemsPermissionBased(driver, groupName))
				{

					logger.info("After Clicking on Radio Permission Based for Allow requesters to order free text items setting. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Permission Based for Allow requesters to order free text items setting. Setting Key: " + groupName);

				}
			}
			else
			{
				logger.info("Incorrect Option provided for Setting: Allow requesters to order free text items. Option: " + requisitionMap.get(SettingMapConstants.Requisition1));
			}
		}

		//Requisition 2: Allow free text items to be requested without selecting a category
		if (requisitionMap.get(SettingMapConstants.Requisition2) != null)
		{
			if (requisitionMap.get(SettingMapConstants.Requisition2).equalsIgnoreCase(IConstantsData.Requisition_Yes))
			{
				if (PageRequisitionSettings.clickOnFreeTextItemsRequestedWithoutSelectingCategory_yes(driver, groupName))
				{
					logger.info("After Clicking on Radio Yes for Allow free text items to be requested without selecting a category. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Yes for Allow free text items to be requested without selecting a category. Setting Key: " + groupName);
				}
			}
			else if (requisitionMap.get(SettingMapConstants.Requisition2).equalsIgnoreCase(IConstantsData.Requisition_No))
			{
				if (PageRequisitionSettings.clickOnFreeTextItemsRequestedWithoutSelectingCategory_no(driver, groupName))
				{
					logger.info("After Clicking on Radio No for Allow free text items to be requested without selecting a category. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio No for Allow free text items to be requested without selecting a category. Setting Key: " + groupName);

				}
			}
			else
			{
				logger.info("Incorrect Option provided for Setting: Allow free text items to be requested without selecting a category. Option: "
					+ requisitionMap.get(SettingMapConstants.Requisition2));
			}
		}

		//Requisition 3: Allow requisitions to be submitted without required-by date
		if (requisitionMap.get(SettingMapConstants.Requisition3) != null)
		{
			if (requisitionMap.get(SettingMapConstants.Requisition3).equalsIgnoreCase(IConstantsData.Requisition_Yes))
			{
				if (PageRequisitionSettings.clickOnReqToBeSubmittedWithoutRequiredByDate_yes(driver, groupName))
				{
					logger.info("After Clicking on Radio Yes for Allow requisitions to be submitted without required-by date. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Yes for Allow requisitions to be submitted without required-by date. Setting Key: " + groupName);
				}
			}
			else if (requisitionMap.get(SettingMapConstants.Requisition3).equalsIgnoreCase(IConstantsData.Requisition_No))
			{
				if (PageRequisitionSettings.clickOnReqToBeSubmittedWithoutRequiredByDate_no(driver, groupName))
				{
					logger.info("After Clicking on Radio No for Allow requisitions to be submitted without required-by date. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio No for Allow requisitions to be submitted without required-by date. Setting Key: " + groupName);
				}
			}
			else
			{
				logger.info("Incorrect Option provided for Setting: Allow requisitions to be submitted without required-by date. Option: "
					+ requisitionMap.get(SettingMapConstants.Requisition3));
			}
		}

		//Requisition 4: Display the GL account information to the requester
		if (requisitionMap.get(SettingMapConstants.Requisition4) != null)
		{
			if (requisitionMap.get(SettingMapConstants.Requisition4).equalsIgnoreCase(IConstantsData.Requisition_Yes))
			{
				if (PageRequisitionSettings.clickOnAllowRequesterToOverrideDefaultGLAccount_yes(driver, groupName))
				{
					logger.info("After Clicking on Radio Yes for Display the GL account information to the requester. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Yes for Display the GL account information to the requester. Setting Key: " + groupName);
				}
			}
			else if (requisitionMap.get(SettingMapConstants.Requisition4).equalsIgnoreCase(IConstantsData.Requisition_No))
			{
				if (PageRequisitionSettings.clickOnAllowRequesterToOverrideDefaultGLAccount_no(driver, groupName))
				{
					logger.info("After Clicking on Radio No for Display the GL account information to the requester. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio No for Display the GL account information to the requester. Setting Key: " + groupName);
				}
			}
			else
			{
				logger.info(
					"Incorrect Option provided for Setting: Display the GL account information to the requester. Option: " + requisitionMap.get(SettingMapConstants.Requisition4));
			}
		}

		//Requisition 5: Requester is required to provide GL account information
		if (requisitionMap.get(SettingMapConstants.Requisition5) != null)
		{
			if (requisitionMap.get(SettingMapConstants.Requisition5).equalsIgnoreCase(IConstantsData.Requisition_Yes))
			{
				if (PageRequisitionSettings.clickOnRequesterIsRequiredToProvideAccountingInfo_yes(driver, groupName))
				{

					logger.info("After Clicking on Radio Yes for Requester is required to provide GL account information. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Yes for Requester is required to provide GL account information. Setting Key: " + groupName);
				}

			}
			else if (requisitionMap.get(SettingMapConstants.Requisition5).equalsIgnoreCase(IConstantsData.Requisition_Yes))
			{
				if (PageRequisitionSettings.clickOnRequesterIsRequiredToProvideAccountingInfo_no(driver, groupName))
				{

					logger.info("After Clicking on Radio No for Requester is required to provide GL account information. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio No for Requester is required to provide GL account information. Setting Key: " + groupName);

				}
			}
			else
			{
				logger.info("Incorrect Option provided for Setting: Requester is required to provide GL account information. Option: "
					+ requisitionMap.get(SettingMapConstants.Requisition5));
			}
		}

		//Requisition 6: Allow requesters to override default GL account
		if (requisitionMap.get(SettingMapConstants.Requisition6) != null)
		{
			if (requisitionMap.get(SettingMapConstants.Requisition6).equalsIgnoreCase(IConstantsData.Requisition_Yes))
			{
				if (PageRequisitionSettings.clickOnAllowRequesterToOverrideDefaultGLAccount_yes(driver, groupName))
				{
					logger.info("After Clicking on Radio Yes for Allow requesters to override default GL account. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Yes for Allow requesters to override default GL account");
				}
			}
			else if (requisitionMap.get(SettingMapConstants.Requisition6).equalsIgnoreCase(IConstantsData.Requisition_Yes))
			{
				if (PageRequisitionSettings.clickOnAllowRequesterToOverrideDefaultGLAccount_no(driver, groupName))
				{
					logger.info("After Clicking on Radio No for Allow requesters to override default GL account. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio No for Allow requesters to override default GL account. Setting Key: " + groupName);
				}
			}
			else
			{
				logger.info(
					"Incorrect Option provided for Setting: Allow requesters to override default GL account. Option: " + requisitionMap.get(SettingMapConstants.Requisition6));
			}
		}

		//Requisition 7: Buyer assignment during requisition submission
		if (requisitionMap.get(SettingMapConstants.Requisition7) != null)
		{
			if (requisitionMap.get(SettingMapConstants.Requisition7).equalsIgnoreCase(IConstantsData.Requisition_Required))
			{
				if (PageRequisitionSettings.clickOnRequesterRequiredToAssignBuyer_Required(driver, groupName))
				{
					logger.info("After Clicking on Radio Required for Buyer assignment during requisition submission. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Required for Buyer assignment during requisition submission. Setting Key: " + groupName);
				}
			}
			else if (requisitionMap.get(SettingMapConstants.Requisition7).equalsIgnoreCase(IConstantsData.Requisition_Optional))
			{
				if (PageRequisitionSettings.clickOnRequesterRequiredToAssignBuyer_Optional(driver, groupName))
				{
					logger.info("After Clicking on Radio Optional for Buyer assignment during requisition submission. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Optional for Buyer assignment during requisition submission. Setting Key: " + groupName);
				}
			}
			else if (requisitionMap.get(SettingMapConstants.Requisition7).equalsIgnoreCase(IConstantsData.Requisition_Hidden))
			{
				if (PageRequisitionSettings.clickOnRequesterRequiredToAssignBuyer_Hidden(driver, groupName))
				{
					logger.info("After Clicking on Radio Hidden for Buyer assignment during requisition submission. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Hidden for Buyer assignment during requisition submission. Setting Key: " + groupName);
				}
			}
			else
			{
				logger
					.info("Incorrect Option provided for Setting: Buyer assignment during requisition submission. Option: " + requisitionMap.get(SettingMapConstants.Requisition7));

			}
		}

		//Requisition 8: Buyer Assignment Default Option
		if (requisitionMap.get(SettingMapConstants.Requisition8) != null)
		{
			if (requisitionMap.get(SettingMapConstants.Requisition8).equalsIgnoreCase(IConstantsData.Requisition_Buyer))
			{
				if (PageRequisitionSettings.clickOnBuyerDefaultOption_Buyer(driver, groupName))
				{
					logger.info("After Clicking on Radio Buyer for Buyer Assignment Default Option. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Buyer for Buyer Assignment Default Option. Setting Key: " + groupName);
				}
			}
			else if (requisitionMap.get(SettingMapConstants.Requisition8).equalsIgnoreCase(IConstantsData.Requisition_BuyerGroup))
			{
				if (PageRequisitionSettings.clickOnBuyerDefaultOption_BuyerGroup(driver, groupName))
				{
					logger.info("After Clicking on Radio BuyerGroup for Buyer Assignment Default Option. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio BuyerGroup for Buyer Assignment Default Option. Setting Key: " + groupName);
				}
			}
			else
			{
				logger.info("Incorrect Option provided for Setting: Buyer Assignment Default Option. Option: " + requisitionMap.get(SettingMapConstants.Requisition8));
			}

		}

		//Requisition 9: Allow tagging existing PO to a requisition
		if (requisitionMap.get(SettingMapConstants.Requisition9) != null)
		{
			if (requisitionMap.get(SettingMapConstants.Requisition9).equalsIgnoreCase(IConstantsData.Requisition_Yes))
			{
				if (PageRequisitionSettings.clickOnPoToReqTagging_Yes(driver, groupName))
				{
					logger.info("After Clicking on Radio Yes for Allow tagging existing PO to a requisition. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Yes for Allow tagging existing PO to a requisition. Setting Key: " + groupName);
				}
			}
			else if (requisitionMap.get(SettingMapConstants.Requisition9).equalsIgnoreCase(IConstantsData.Requisition_No))
			{
				if (PageRequisitionSettings.clickOnPoToReqTagging_No(driver, groupName))
				{
					logger.info("After Clicking on Radio No for Allow tagging existing PO to a requisition. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio No for Allow tagging existing PO to a requisition. Setting Key: " + groupName);
				}
			}
			else
			{
				logger.info("Incorrect Option provided for Setting: Allow tagging existing PO to a requisition. Option: " + requisitionMap.get(SettingMapConstants.Requisition9));
			}
		}

		//Requisition 10: Allow requesters to suggest supplier(s) for buyer review
		if (requisitionMap.get(SettingMapConstants.Requisition10) != null)
		{
			if (requisitionMap.get(SettingMapConstants.Requisition10).equalsIgnoreCase(IConstantsData.Requisition_Yes))
			{
				if (PageRequisitionSettings.clickOnAllowRequesterToSuggestSupplierForBuyersReview_Yes(driver, groupName))
				{

					logger.info("After Clicking on Radio Yes for Allow Requester To Suggest Supplier For Buyers Review. Setting Key: " + groupName);
				}
				else
				{
					logger.info("After Clicking on Radio Yes for Allow Requester To Suggest Supplier For Buyers Review. Setting Key: " + groupName);
				}
			}
			else if (requisitionMap.get(SettingMapConstants.Requisition10).equalsIgnoreCase(IConstantsData.Requisition_No))
			{
				if (PageRequisitionSettings.clickOnAllowRequesterToSuggestSupplierForBuyersReview_No(driver, groupName))
				{

					logger.info("After Clicking on Radio No for Allow Requester To Suggest Supplier For Buyers Review. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio No for Allow Requester To Suggest Supplier For Buyers Review. Setting Key: " + groupName);

				}
			}
			else
			{
				logger.info("Incorrect Option provided for Setting:  Allow requesters to suggest supplier(s) for buyer review. Option: "
					+ requisitionMap.get(SettingMapConstants.Requisition10));
			}
		}

		//Requisition 11: Required by date should be auto calculated as per lead time defined in the catalog
		if (requisitionMap.get(SettingMapConstants.Requisition11) != null)
		{
			if (requisitionMap.get(SettingMapConstants.Requisition11).equalsIgnoreCase(IConstantsData.Requisition_Yes))
			{
				if (PageRequisitionSettings.clickOnRequiredByDateAutoCalculatedAsPerLeadTimeInCatalog_Yes(driver, groupName))
				{
					logger.info("After Clicking on Radio Yes for Required by date should be auto calculated as per lead time defined in the catalog. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Yes for Required by date should be auto calculated as per lead time defined in the catalog. Setting Key: " + groupName);
				}
			}
			else if (requisitionMap.get(SettingMapConstants.Requisition11).equalsIgnoreCase(IConstantsData.Requisition_No))
			{
				if (PageRequisitionSettings.clickOnRequiredByDateAutoCalculatedAsPerLeadTimeInCatalog_No(driver, groupName))
				{

					logger.info("After Clicking on Radio No for Required by date should be auto calculated as per lead time defined in the catalog. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio No for Required by date should be auto calculated as per lead time defined in the catalog. Setting Key: " + groupName);
				}
			}
			else
			{
				logger.info("Incorrect Option provided for Setting:  Required by date should be auto calculated as per lead time defined in the catalog. Option: "
					+ requisitionMap.get(SettingMapConstants.Requisition11));
			}

		}

		//Requisition 12: Add Disbursement as a settlement option
		if (requisitionMap.get(SettingMapConstants.Requisition12) != null)
		{
			if (requisitionMap.get(SettingMapConstants.Requisition12).equalsIgnoreCase(IConstantsData.Requisition_Yes))
			{
				if (PageRequisitionSettings.clickOnAddDisbursementAsSettlementViaOptionYes(driver, groupName))
				{

					logger.info("After Clicking on Radio Yes for Add Disbursement as a settlement option. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Yes for Add Disbursement as a settlement option. Setting Key: " + groupName);
				}
			}
			else if (requisitionMap.get(SettingMapConstants.Requisition12).equalsIgnoreCase(IConstantsData.Requisition_No))
			{
				if (PageRequisitionSettings.clickOnAddDisbursementAsSettlementViaOptionNo(driver, groupName))
				{

					logger.info("After Clicking on Radio No for Add Disbursement as a settlement option. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio No for Add Disbursement as a settlement option. Setting Key: " + groupName);

				}
			}
			else
			{
				logger.info("Incorrect Option provided for Setting:  Add Disbursement as a settlement option. Option: " + requisitionMap.get(SettingMapConstants.Requisition12));
			}
		}

		//Requisition 13 : Allow split delivery locations at item level
		if (requisitionMap.get(SettingMapConstants.Requisition13) != null)
		{
			if (requisitionMap.get(SettingMapConstants.Requisition13).equalsIgnoreCase(IConstantsData.Requisition_Yes))
			{
				if (PageRequisitionSettings.allowSplitDeliveryLocationAtItemLevel_Yes(driver, groupName))
				{
					logger.info("After Clicking on Radio Yes for  Allow split delivery locations at item level. Setting Key: " + groupName);

				}
				else
				{
					logger.info("Error Clicking on Radio Yes for  Allow split delivery locations at item level. Setting Key: " + groupName);

				}
			}
			else if (requisitionMap.get(SettingMapConstants.Requisition13).equalsIgnoreCase(IConstantsData.Requisition_No))
			{
				if (PageRequisitionSettings.allowSplitDeliveryLocationAtItemLevel_Yes(driver, groupName))
				{

					logger.info("After Clicking on Radio No for  Allow split delivery locations at item level. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio No for  Allow split delivery locations at item level. Setting Key: " + groupName);

				}
			}
			else
			{
				logger
					.info("Incorrect Option provided for Setting:  Allow split delivery locations at item level. Option: " + requisitionMap.get(SettingMapConstants.Requisition13));
			}

		}
		//Requisition 14 : Alert users when shopping quantity beyond(Percent)
		if (requisitionMap.get(SettingMapConstants.Requisition14) != null)
		{
			Integer quantity = Integer.parseInt(requisitionMap.get(SettingMapConstants.Requisition14));
			if (requisitionMap.get(SettingMapConstants.Requisition13).equalsIgnoreCase(IConstantsData.Requisition_Yes))
			{
				if (PageRequisitionSettings.enterQuantityToAlertUserWhenShoppingCartIsBeyondQuantity(driver, quantity) == quantity)
				{
					logger.info("After filling quantity for Alert users when shopping quantity beyond. Setting Key: " + groupName);

				}
				else
				{
					logger.info("After filling quantity for Alert users when shopping quantity beyond. Setting Key: " + groupName);

				}
			}

		}

		//Requisition 15 : Send PO to supplier
		if (requisitionMap.get(SettingMapConstants.Requisition15) != null)
		{
			if (requisitionMap.get(SettingMapConstants.Requisition15).equalsIgnoreCase(IConstantsData.Requisition_Yes))
			{
				if (PageRequisitionSettings.clickOnSendPOToSupplierOptionYes(driver, groupName))
				{
					logger.info("After Clicking on Radio Yes for Send PO to supplier. Setting Key: " + groupName);

				}
				else
				{
					logger.info("Error Clicking on Radio Yes for Send PO to supplier. Setting Key: " + groupName);

				}
			}
			else if (requisitionMap.get(SettingMapConstants.Requisition15).equalsIgnoreCase(IConstantsData.Requisition_No))
			{
				if (PageRequisitionSettings.clickOnSendPOToSupplierOptionNo(driver, groupName))
				{

					logger.info("After Clicking on Radio No for Send PO to supplier. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio No for Send PO to supplier. Setting Key: " + groupName);

				}
			}
			else
			{
				logger
					.info("Incorrect Option provided for Setting:  Allow split delivery locations at item level. Option: " + requisitionMap.get(SettingMapConstants.Requisition15));
			}

		}

		ScreenShot.screenshot(driver, groupName, "After filling all required Requisition settings");
		//Code to save

		if (PageRequisitionSettings.clickOnSaveButton(driver, groupName))
		{
			logger.info("Requisition setting saved !  Setting Key: " + groupName);
		}
		else
		{
			logger.info("Requisition setting was not able to save !   Setting Key: " + groupName);
		}

	}

	//Buyers Desk 1: start of buyers desk cases
	public static void changeBuyersDeskSettings(Map<String, String> buyersDeskMap, WebDriver driver, String groupName) throws ActionBotException, FactoryMethodException
	{

		// to click on customize tab
		MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
		ActionBot.waitForPageLoad(driver);

		// to click on requisition setting link
		PageCustomizeSettings.clickOnBuyersDeskLink(driver, groupName);
		ActionBot.waitForPageLoad(driver);

		//Allow buyer to add new item(s) to a requisition
		if (buyersDeskMap.get(SettingMapConstants.BuyersDesk1) != null)
		{
			if (buyersDeskMap.get(SettingMapConstants.BuyersDesk1).equalsIgnoreCase(IConstantsData.BuyersDesk_Yes))
			{
				if (PageBuyersDeskSettings.clickOnAllowBuyerToAddItemsInReq_Yes(driver, groupName))
				{

					logger.info("After Clicking on Radio Yes for Allow buyer to add new item(s) to a requisition. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Yes for Allow buyer to add new item(s) to a requisition. Setting Key: " + groupName);

				}
			}
			else if (buyersDeskMap.get(SettingMapConstants.BuyersDesk1).equalsIgnoreCase(IConstantsData.BuyersDesk_No))
			{
				if (PageBuyersDeskSettings.clickOnAllowBuyerToAddItemsInReq_No(driver, groupName))
				{

					logger.info("After Clicking on Radio No for Allow buyer to add new item(s) to a requisition. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio No for Allow buyer to add new item(s) to a requisition. Setting Key: " + groupName);

				}
			}
			else
			{
				logger
					.info("Incorrect Option provided for Setting: Allow buyer to add new item(s) to a requisition. Option: " + buyersDeskMap.get(SettingMapConstants.BuyersDesk1));
			}
		}

		//Buyers Desk 2: Allow PR's (containing newly added items) total amount to exceed the approved PR's amount by
		if (buyersDeskMap.get(SettingMapConstants.BuyersDesk2) != null)
		{

			String valueLimit = buyersDeskMap.get(SettingMapConstants.BuyersDesk2).split("|")[0];
			String percentage = buyersDeskMap.get(SettingMapConstants.BuyersDesk2).split("|")[1];
			String currencyUnit = buyersDeskMap.get(SettingMapConstants.BuyersDesk2).split("|")[2];

			if (buyersDeskMap.get(SettingMapConstants.BuyersDesk2).equalsIgnoreCase(IConstantsData.BuyersDesk_ExceedLimit_Smaller))
			{
				if (PageBuyersDeskSettings.clickOnAllowPR_Smaller(driver, groupName))
				{

					logger.info("After Clicking on Radio Allow PR's (containing newly added items) total amount to exceed the approved PR's amount by: " + valueLimit
						+ " Setting Key: " + groupName);

					PageBuyersDeskSettings.clearAllowPr_TotalAmount(driver, groupName);
					if (PageBuyersDeskSettings.enterAllowPr_TotalAmount(driver, groupName, percentage).equals(percentage))
					{
						logger.info("After entering total amount percentage " + percentage + " Setting Key: " + groupName);

					}
					else
					{
						logger.info("Error entering total amount percentage " + percentage + " Setting Key: " + groupName);
					}
					PageBuyersDeskSettings.clearAllowPr_CurrencyUnits(driver, groupName);
					if (PageBuyersDeskSettings.enterAllowPr_CurrencyUnits(driver, groupName, currencyUnit).equals(currencyUnit))
					{

						logger.info("After entering currency units " + currencyUnit + " Setting Key: " + groupName);
					}
					else
					{
						logger.info("Error entering currency units " + currencyUnit + " Setting Key: " + groupName);
					}
				}
				else
				{
					logger.info("After Clicking on Radio Allow PR's (containing newly added items) total amount to exceed the approved PR's amount by: " + valueLimit);
				}
			}
			else if (buyersDeskMap.get(SettingMapConstants.BuyersDesk2).equalsIgnoreCase(IConstantsData.BuyersDesk_ExceedLimit_Larger))
			{
				if (PageBuyersDeskSettings.clickOnAllowPR_Larger(driver, groupName))
				{
					logger.info("After Clicking on Radio Allow PR's (containing newly added items) total amount to exceed the approved PR's amount by: " + valueLimit
						+ " Setting Key: " + groupName);
					PageBuyersDeskSettings.clearAllowPr_TotalAmount(driver, groupName);
					if (PageBuyersDeskSettings.enterAllowPr_TotalAmount(driver, groupName, percentage).equals(percentage))
					{

						logger.info("After entering total amount percentage " + percentage + "  Setting Key: " + groupName);
					}
					else
					{
						logger.info("Error entering total amount percentage " + percentage + "  Setting Key: " + groupName);
					}
					PageBuyersDeskSettings.clearAllowPr_CurrencyUnits(driver, groupName);
					if (PageBuyersDeskSettings.enterAllowPr_CurrencyUnits(driver, groupName, currencyUnit).equals(currencyUnit))
					{

						logger.info("After entering currency units " + currencyUnit + " Setting Key: " + groupName);
					}
					else
					{
						logger.info("Error entering currency units " + currencyUnit + " Setting Key: " + groupName);

					}

				}
				else
				{
					logger.info("Error Clicking on Radio Allow PR's (containing newly added items) total amount to exceed the approved PR's amount by: " + valueLimit
						+ " Setting Key: " + groupName);

				}
			}
			else
			{
				logger.info(
					"Allow PR's (containing newly added items) total amount to exceed the approved PR's amount by. Option: " + buyersDeskMap.get(SettingMapConstants.BuyersDesk2));
			}
		}

		//Buyers Desk 3: Allow buyer to replace existing items on a requisition
		if (buyersDeskMap.get(SettingMapConstants.BuyersDesk3) != null)
		{
			if (buyersDeskMap.get(SettingMapConstants.BuyersDesk3).equalsIgnoreCase(IConstantsData.BuyersDesk_Yes))
			{
				if (PageBuyersDeskSettings.clickOnAllowBuyerToReplaceItemsInReq_Yes(driver, groupName))
				{

					logger.info("After Clicking on Radio Yes for Allow buyer to replace existing items on a requisition . Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Yes for Allow buyer to replace existing items on a requisition. Setting Key: " + groupName);

				}
			}
			else if (buyersDeskMap.get(SettingMapConstants.BuyersDesk3).equalsIgnoreCase(IConstantsData.BuyersDesk_No))
			{
				if (PageBuyersDeskSettings.clickOnAllowBuyerToReplaceItemsInReq_No(driver, groupName))
				{

					logger.info("After Clicking on Radio No for Allow buyer to replace existing items on a requisition. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio No for Allow buyer to replace existing items on a requisition. Setting Key: " + groupName);

				}
			}
			else
			{
				logger.info(
					"Incorrect Option provided for Setting: Allow buyer to replace existing items on a requisition. Option: " + buyersDeskMap.get(SettingMapConstants.BuyersDesk3));
			}
		}

		//Buyers Desk 4: Allow buyer to submit requisition without saving it as draft
		if (buyersDeskMap.get(SettingMapConstants.BuyersDesk4) != null)
		{
			if (buyersDeskMap.get(SettingMapConstants.BuyersDesk4).equalsIgnoreCase(IConstantsData.BuyersDesk_Yes))
			{
				if (PageBuyersDeskSettings.clickAllowBuyerToSubmitRequisitionWithoutSavingAsDraft_Yes(driver, groupName))
				{
					logger.info("After Clicking on Radio Yes for Allow buyer to replace existing items on a requisition. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Yes for Allow buyer to replace existing items on a requisition. Setting Key: " + groupName);
				}
			}
			else if (buyersDeskMap.get(SettingMapConstants.BuyersDesk4).equalsIgnoreCase(IConstantsData.BuyersDesk_No))
			{
				if (PageBuyersDeskSettings.clickAllowBuyerToSubmitRequisitionWithoutSavingAsDraft_No(driver, groupName))
				{

					logger.info("After Clicking on Radio No for Allow buyer to replace existing items on a requisition. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio No for Allow buyer to replace existing items on a requisition. Setting Key: " + groupName);

				}
			}
			else
			{
				logger.info(
					"Incorrect Option provided for Setting: Allow buyer to replace existing items on a requisition. Option: " + buyersDeskMap.get(SettingMapConstants.BuyersDesk4));
			}
		}

		ScreenShot.screenshot(driver, groupName, "After filling all required buyers desk setting");
		//save buyers desk setting

		if (PageBuyersDeskSettings.clickSaveButton(driver, groupName))
		{
			logger.info("Buyers Desk setting saved ! . Setting Key: " + groupName);
		}
		else
		{
			logger.info("Buyers Desk setting was not able to save ! . Setting Key: " + groupName);
		}

	}

	public static void changePurchaseOrderSettings(Map<String, String> purchaseOrderMap, WebDriver driver, String groupName) throws ActionBotException, FactoryMethodException
	{

		// to click on customize tab
		MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
		ActionBot.waitForPageLoad(driver);

		// to click on requisition setting link
		PageCustomizeSettings.clickOnPurchaseOrderLink(driver, groupName);
		ActionBot.waitForPageLoad(driver);

		//Purchase Order 1: Automatically generate orders
		if (purchaseOrderMap.get(SettingMapConstants.PurchaseOrder1) != null)
		{
			if (purchaseOrderMap.get(SettingMapConstants.PurchaseOrder1).equalsIgnoreCase(IConstantsData.PurchaseOrder_Yes))
			{
				if (PagePurchaseOrderSetting.clickOnAutomaticallyGeneratePO_Yes(driver, groupName))
				{

					logger.info("After Clicking on Radio Yes for Automatically generate orders. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Yes for Automatically generate orders. Setting Key: " + groupName);

				}
			}
			else if (purchaseOrderMap.get(SettingMapConstants.PurchaseOrder1).equalsIgnoreCase(IConstantsData.PurchaseOrder_No))
			{
				if (PagePurchaseOrderSetting.clickOnAutomaticallyGeneratePO_No(driver, groupName))
				{

					logger.info("After Clicking on Radio No for Automatically generate orders. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio No for Automatically generate orders. Setting Key: " + groupName);

				}
			}
			else
			{
				logger.info("Incorrect Option provided for Setting: Automatically generate orders. Option: " + purchaseOrderMap.get(SettingMapConstants.PurchaseOrder1));
			}
		}

		//Purchase Order 2: Release orders immediately
		if (purchaseOrderMap.get(SettingMapConstants.PurchaseOrder2) != null)
		{
			if (purchaseOrderMap.get(SettingMapConstants.PurchaseOrder2).equalsIgnoreCase(IConstantsData.PurchaseOrder_Yes))
			{
				if (PagePurchaseOrderSetting.clickOnReleaseOrdersImmediately_Yes(driver, groupName))
				{

					logger.info("After Clicking on Radio Yes Release orders immediately. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Yes Release orders immediately. Setting Key: " + groupName);

				}
			}
			else if (purchaseOrderMap.get(SettingMapConstants.PurchaseOrder2).equalsIgnoreCase(IConstantsData.PurchaseOrder_No))
			{
				if (PagePurchaseOrderSetting.clickOnReleaseOrdersImmediately_No(driver, groupName))
				{
					logger.info("After Clicking on Radio No for Release orders immediately. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio No for Release orders immediately. Setting Key: " + groupName);
				}
			}
			else
			{
				logger.info("Incorrect Option provided for Setting: Release orders immediately. Option: " + purchaseOrderMap.get(SettingMapConstants.PurchaseOrder2));
			}
		}
		//Purchase Order 3 : Allow users to change default supplier currency on the PO
		if (purchaseOrderMap.get(SettingMapConstants.PurchaseOrder3) != null)
		{
			if (purchaseOrderMap.get(SettingMapConstants.PurchaseOrder3).equalsIgnoreCase(IConstantsData.PurchaseOrder_Yes))
			{
				if (PagePurchaseOrderSetting.clickOnAllowToChangeDefaultSupplierCurrencyOnPO_Yes(driver, groupName))
				{

					logger.info("After Clicking on Radio Yes Allow users to change default supplier currency on the PO. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Yes Allow users to change default supplier currency on the PO. Setting Key: " + groupName);

				}
			}
			else if (purchaseOrderMap.get(SettingMapConstants.PurchaseOrder3).equalsIgnoreCase(IConstantsData.PurchaseOrder_No))
			{
				if (PagePurchaseOrderSetting.clickOnAllowToChangeDefaultSupplierCurrencyOnPO_No(driver, groupName))
				{

					logger.info("After Clicking on Radio No for Allow users to change default supplier currency on the PO. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio No for Allow users to change default supplier currency on the PO. Setting Key: " + groupName);
				}
			}
			else
			{
				logger.info("Incorrect Option provided for Setting:Allow users to change default supplier currency on the PO. Option: "
					+ purchaseOrderMap.get(SettingMapConstants.PurchaseOrder3));
			}
		}

		//Purchase Order 4: Allow users to change default supplier payment terms on the PO
		if (purchaseOrderMap.get(SettingMapConstants.PurchaseOrder4) != null)
		{
			if (purchaseOrderMap.get(SettingMapConstants.PurchaseOrder4).equalsIgnoreCase(IConstantsData.PurchaseOrder_Yes))
			{
				if (PagePurchaseOrderSetting.clickOnAllowToChangeDefaultSupplierPaymentTermsOnPO_Yes(driver, groupName))
				{

					logger.info("After Clicking on Radio Yes Allow users to change default supplier payment terms on the PO. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Yes Allow users to change default supplier payment terms on the PO. Setting Key: " + groupName);

				}
			}
			else if (purchaseOrderMap.get(SettingMapConstants.PurchaseOrder4).equalsIgnoreCase(IConstantsData.PurchaseOrder_No))
			{
				if (PagePurchaseOrderSetting.clickOnAllowToChangeDefaultSupplierPaymentTermsOnPO_No(driver, groupName))
				{

					logger.info("After Clicking on Radio No for Allow users to change default supplier payment terms on the PO. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio No for Allow users to change default supplier payment terms on the PO. Setting Key: " + groupName);

				}
			}
			else
			{
				logger.info("Incorrect Option provided for Setting:Allow users to change default supplier payment terms on the PO. Option: "
					+ purchaseOrderMap.get(SettingMapConstants.PurchaseOrder4));
			}
		}

		//Purchase Order 5: Allow users to change default supplier delivery terms on the PO
		if (purchaseOrderMap.get(SettingMapConstants.PurchaseOrder5) != null)
		{
			if (purchaseOrderMap.get(SettingMapConstants.PurchaseOrder5).equalsIgnoreCase(IConstantsData.PurchaseOrder_Yes))
			{
				if (PagePurchaseOrderSetting.clickOnAllowToChangeDefaultSupplierDeliveryTermsOnPO_Yes(driver, groupName))
				{

					logger.info("After Clicking on Radio Yes Allow users to change default supplier delivery terms on the PO. Setting Key: " + groupName);
				}
				else
				{
					logger.info("After Clicking on Radio Yes Allow users to change default supplier delivery terms on the PO. Setting Key: " + groupName);

				}
			}
			else if (purchaseOrderMap.get(SettingMapConstants.PurchaseOrder5).equalsIgnoreCase(IConstantsData.PurchaseOrder_No))
			{
				if (PagePurchaseOrderSetting.clickOnAllowToChangeDefaultSupplierDeliveryTermsOnPO_Yes(driver, groupName))
				{

					logger.info("After Clicking on Radio No for Allow users to change default supplier delivery terms on the PO. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio No for Allow users to change default supplier delivery terms on the PO. Setting Key: " + groupName);

				}
			}
			else
			{
				logger.info("Incorrect Option provided for Setting:Allow users to change default supplier delivery terms on the PO. Option: "
					+ purchaseOrderMap.get(SettingMapConstants.PurchaseOrder5));
			}
		}

		//Purchase Order 6: Auto-generate line item numbers on the PO
		if (purchaseOrderMap.get(SettingMapConstants.PurchaseOrder6) != null)
		{
			if (purchaseOrderMap.get(SettingMapConstants.PurchaseOrder6).equalsIgnoreCase(IConstantsData.PurchaseOrder_Yes))
			{
				if (PagePurchaseOrderSetting.clickOnAutoGenerateLineItemNumbersOnPO_Yes(driver, groupName))
				{

					logger.info("After Clicking on Radio Yes Auto-generate line item numbers on the PO. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Yes Auto-generate line item numbers on the PO. Setting Key: " + groupName);

				}
			}
			else if (purchaseOrderMap.get(SettingMapConstants.PurchaseOrder6).equalsIgnoreCase(IConstantsData.PurchaseOrder_No))
			{
				if (PagePurchaseOrderSetting.clickOnAutoGenerateLineItemNumbersOnPO_No(driver, groupName))
				{

					logger.info("After Clicking on Radio No for Auto-generate line item numbers on the PO. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio No for Auto-generate line item numbers on the PO. Setting Key: " + groupName);

				}
			}
			else
			{
				logger.info("Incorrect Option provided for Setting:Auto-generate line item numbers on the PO. Option: " + purchaseOrderMap.get(SettingMapConstants.PurchaseOrder6));
			}
		}

		//Purchase Order 7: Allow editing auto-generated PO Number
		if (purchaseOrderMap.get(SettingMapConstants.PurchaseOrder7) != null)
		{
			if (purchaseOrderMap.get(SettingMapConstants.PurchaseOrder7).equalsIgnoreCase(IConstantsData.PurchaseOrder_Yes))
			{
				if (PagePurchaseOrderSetting.clickOnAllowEditingAutoGeneratedPONumber_Yes(driver, groupName))
				{

					logger.info("After Clicking on Radio Yes Allow editing auto-generated PO Number. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Yes Allow editing auto-generated PO Number. Setting Key: " + groupName);

				}
			}
			else if (purchaseOrderMap.get(SettingMapConstants.PurchaseOrder7).equalsIgnoreCase(IConstantsData.PurchaseOrder_No))
			{
				if (PagePurchaseOrderSetting.clickOnAllowEditingAutoGeneratedPONumber_No(driver, groupName))
				{

					logger.info("After Clicking on Radio No for Allow editing auto-generated PO Number. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio No for Allow editing auto-generated PO Number. Setting Key: " + groupName);

				}
			}
			else
			{
				logger.info("Incorrect Option provided for Setting: Allow editing auto-generated PO Number. Option: " + purchaseOrderMap.get(SettingMapConstants.PurchaseOrder7));
			}
		}

		//Purchase Order 8: Do not allow buyers to increase item unit price while amending PO more than(Percent)
		if (purchaseOrderMap.get(SettingMapConstants.PurchaseOrder8) != null)
		{
			Integer percentage = Integer.parseInt(purchaseOrderMap.get(SettingMapConstants.PurchaseOrder8));
			if (PagePurchaseOrderSetting.fillPOAmendingLimiationOnItemUnitPrice(driver, groupName, percentage) == percentage)
			{

				logger.info("After Filling Do not allow buyers to increase item unit price while amending PO more than(Percent)" + percentage + "  . Setting Key: " + groupName);
			}
			else
			{
				logger.info("Error Filling Do not allow buyers to increase item unit price while amending PO more than(Percent)" + percentage + " . Setting Key: " + groupName);
			}
		}

		//Purchase Order 9: Do not allow buyers to increase item quantity while amending PO more than(Percent)
		if (purchaseOrderMap.get(SettingMapConstants.PurchaseOrder9) != null)
		{
			Integer percentage = Integer.parseInt(purchaseOrderMap.get(SettingMapConstants.PurchaseOrder8));
			if (PagePurchaseOrderSetting.fillPOAmendingLimiationOnItemQuantity(driver, groupName, percentage) == percentage)
			{

				logger.info("After Filling Do not allow buyers to increase item quantity while amending PO more than(Percent)" + percentage + " . Setting Key: " + groupName);
			}
			else
			{
				logger.info("Error Filling Do not allow buyers to increase item quantity while amending PO more than(Percent)" + percentage + " . Setting Key: " + groupName);

			}
		}

		//Purchase Order 10: Allow users to modify the item classification code assigned by the system
		if (purchaseOrderMap.get(SettingMapConstants.PurchaseOrder10) != null)
		{
			if (purchaseOrderMap.get(SettingMapConstants.PurchaseOrder10).equalsIgnoreCase(IConstantsData.PurchaseOrder_Yes))
			{
				if (PagePurchaseOrderSetting.clickOnAllowModificationOfItemClassificationCode_Yes(driver, groupName))
				{

					logger.info("After Clicking on Radio Yes Allow users to modify the item classification code assigned by the system. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Yes Allow users to modify the item classification code assigned by the system. Setting Key: " + groupName);

				}
			}
			else if (purchaseOrderMap.get(SettingMapConstants.PurchaseOrder10).equalsIgnoreCase(IConstantsData.PurchaseOrder_No))
			{
				if (PagePurchaseOrderSetting.clickOnAllowModificationOfItemClassificationCode_Yes(driver, groupName))
				{

					logger.info("After Clicking on Radio No for Allow users to modify the item classification code assigned by the system. Setting Key: " + groupName);
				}
				else
				{
					logger.info("After Clicking on Radio No for Allow users to modify the item classification code assigned by the system. Setting Key: " + groupName);

				}
			}
			else
			{
				logger.info("Incorrect Option provided for Setting: Allow users to modify the item classification code assigned by the system. Option: "
					+ purchaseOrderMap.get(SettingMapConstants.PurchaseOrder10));
			}
		}

		//Purchase Order 11: Select level to use PO number format
		if (purchaseOrderMap.get(SettingMapConstants.PurchaseOrder11) != null)
		{
			if (PagePurchaseOrderSetting.selectLevelToUsePONumberFormat(driver, groupName, purchaseOrderMap.get(SettingMapConstants.PurchaseOrder11))
				.equalsIgnoreCase(purchaseOrderMap.get(SettingMapConstants.PurchaseOrder11)))
			{

				logger.info("After selecting - Select level to use PO number format " + purchaseOrderMap.get(SettingMapConstants.PurchaseOrder11) + " . Setting Key: " + groupName);
			}
			else
			{
				logger.info("Error selecting - Select level to use PO number format " + purchaseOrderMap.get(SettingMapConstants.PurchaseOrder11) + " . Setting Key: " + groupName);

			}
		}

		//Purchase Order 12: Allow manual orders to be released without a delivery date
		if (purchaseOrderMap.get(SettingMapConstants.PurchaseOrder12) != null)
		{
			if (purchaseOrderMap.get(SettingMapConstants.PurchaseOrder12).equalsIgnoreCase(IConstantsData.PurchaseOrder_Yes))
			{
				if (PagePurchaseOrderSetting.clickOnAllowManualOrdersReleasedWithoutDeliveryDate_Yes(driver, groupName))
				{

					logger.info("After Clicking on Radio Yes Allow manual orders to be released without a delivery date. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Yes Allow manual orders to be released without a delivery date. Setting Key: " + groupName);

				}
			}
			else if (purchaseOrderMap.get(SettingMapConstants.PurchaseOrder12).equalsIgnoreCase(IConstantsData.PurchaseOrder_No))
			{
				if (PagePurchaseOrderSetting.clickOnAllowManualOrdersReleasedWithoutDeliveryDate_No(driver, groupName))
				{

					logger.info("After Clicking on Radio No for Allow manual orders to be released without a delivery date. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio No for Allow manual orders to be released without a delivery date. Setting Key: " + groupName);

				}
			}
			else
			{
				logger.info("Incorrect Option provided for Setting:Allow manual orders to be released without a delivery date. Option: "
					+ purchaseOrderMap.get(SettingMapConstants.PurchaseOrder12));
			}
		}

		//Purchase Order 13:Require PO approval when PO total exceeds compared to the previous approved version by
		if (purchaseOrderMap.get(SettingMapConstants.PurchaseOrder13) != null)
		{
			Integer percent = Integer.parseInt(purchaseOrderMap.get(SettingMapConstants.PurchaseOrder13).split("|")[1]);
			Integer unitPrice = Integer.parseInt(purchaseOrderMap.get(SettingMapConstants.PurchaseOrder13).split("|")[2]);

			if (purchaseOrderMap.get(SettingMapConstants.PurchaseOrder13).equalsIgnoreCase(IConstantsData.PurchaseOrder_ExceedLimit_Smaller))
			{
				if (PagePurchaseOrderSetting.clickOnRequiredPOApprovalWhenPOTotalExceedsSmaller(driver, groupName))
				{
					logger.info("After clicling radio button for Require PO approval when PO total exceeds compared to the previous approved version by : Smaller. Setting Key: "
						+ groupName);
					if (PagePurchaseOrderSetting.fillRequiredPOApprovalWhenPOTotalExceedsUnitPricePer(driver, groupName, percent).equals(percent))
					{
						logger.info("After filling percentage of amount " + percent + " . Setting Key: " + groupName);
					}
					else
					{
						logger.info("Error filling percentage of amount " + percent + " . Setting Key: " + groupName);
					}

					if (PagePurchaseOrderSetting.fillRequiredPOApprovalWhenPOTotalExceedsUnitPricePerAmount(driver, groupName, percent).equals(unitPrice))
					{
						logger.info("After filling unit price " + unitPrice + " . Setting Key: " + groupName);
					}
					else
					{
						logger.info("Error filling unit price " + unitPrice + " . Setting Key: " + groupName);
					}
				}
				else
				{
					logger.info("Error clicling radio button for Require PO approval when PO total exceeds compared to the previous approved version by : Smaller. Setting Key: "
						+ groupName);

				}
			}
			else if (purchaseOrderMap.get(SettingMapConstants.PurchaseOrder13).equalsIgnoreCase(IConstantsData.PurchaseOrder_ExceedLimit_Larger))
			{
				if (PagePurchaseOrderSetting.clickOnRequiredPOApprovalWhenPOTotalExceedsLarger(driver, groupName))
				{

					logger.info("After clicling radio button for Require PO approval when PO total exceeds compared to the previous approved version by : Smaller");
					if (PagePurchaseOrderSetting.fillRequiredPOApprovalWhenPOTotalExceedsUnitPricePer(driver, groupName, percent).equals(percent))
					{
						logger.info("After filling percentage of amount " + percent + " . Setting Key: " + groupName);
					}
					else
					{
						logger.info("Error filling percentage of amount " + percent + " . Setting Key: " + groupName);
					}

					if (PagePurchaseOrderSetting.fillRequiredPOApprovalWhenPOTotalExceedsUnitPricePerAmount(driver, groupName, percent).equals(unitPrice))
					{
						logger.info("After filling unit price " + unitPrice + " . Setting Key: " + groupName);
					}
					else
					{
						logger.info("Error filling unit price " + unitPrice + " . Setting Key: " + groupName);
					}
				}
				else
				{
					logger.info("Error clicling radio button for Require PO approval when PO total exceeds compared to the previous approved version by : Larger. Setting Key: "
						+ groupName);

				}
			}
		}

		ScreenShot.screenshot(driver, groupName, "After filling all required settings for PO");
		//save setting changes
		if (PagePurchaseOrderSetting.clickOnSaveButton(driver, groupName))
		{
			logger.info("PO setting saved ! . Setting Key: " + groupName);
		}
		else
		{
			logger.info("PO setting was not able to save ! . Setting Key: " + groupName);
		}

	}

	public static void changeCostBookingSettings(Map<String, String> costBookingMap, WebDriver driver, String groupName) throws ActionBotException, FactoryMethodException
	{

		// to click on customize tab
		MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);
		ActionBot.waitForPageLoad(driver);

		// to click on requisition setting link
		PageCustomizeSettings.clickOnCostBookingLink(driver, groupName);
		ActionBot.waitForPageLoad(driver);

		//CostBooking1 : Allow budget utilization
		if (costBookingMap.get(SettingMapConstants.CostBooking1) != null)
		{
			if (costBookingMap.get(SettingMapConstants.CostBooking1).equalsIgnoreCase(IConstantsData.CostBooking_Yes))
			{
				if (PageBudgetSettings.clickOnAllowBudgetUtilizationYES(driver, groupName))
				{

					logger.info("After Clicking on Radio Yes Allow budget utilization. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Yes Allow budget utilization. Setting Key: " + groupName);

				}
			}
			else if (costBookingMap.get(SettingMapConstants.CostBooking1).equalsIgnoreCase(IConstantsData.CostBooking_No))
			{
				if (PageBudgetSettings.clickOnAllowBudgetUtilizationNO(driver, groupName))
				{

					logger.info("After Clicking on Radio No for Allow budget utilization. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio No for Allow budget utilization. Setting Key: " + groupName);

				}
			}
			else
			{
				logger.info("Incorrect Option provided for Setting: Allow budget utilization. Option: " + costBookingMap.get(SettingMapConstants.CostBooking1));
			}
		}

		ScreenShot.screenshot(driver, groupName, "After filling all requires settings for cost booking");
		//save  cost Booking setting
		if (PageBuyersDeskSettings.clickSaveButton(driver, groupName))
		{
			logger.info("cost Booking setting saved ! . Setting Key: " + groupName);
		}
		else
		{
			logger.info("cost Booking setting was not able to save ! . Setting Key: " + groupName);
		}

	}

	public static void changeMasterDataControlSettings(Map<String, String> masterDataControlMap, WebDriver driver, String groupName)
		throws ActionBotException, FactoryMethodException
	{

		// navigates to TMS
		driver.get(ConfigProperty.getConfig("TMS_URL"));
		ActionBot.waitForPageLoad(driver);

		ScreenShot.screenshot(driver, groupName, "After navigating to TMS Page");

		// navigates to Master data
		PageCustomizeSettings.clickOnMasterDataLink(driver, groupName);
		ActionBot.waitForPageLoad(driver);
		
		MainPageHeaderLevelTab.clickOnCustomize(driver, groupName);
		ActionBot.waitForPageLoad(driver);
		// click on cost booking link
		PageCustomizeSettings.clickOnControlLink(driver, groupName);
		ActionBot.waitForPageLoad(driver);

		//Master Data - Control 1: Use the 'Purchase Type' field to classify purchases
		if (masterDataControlMap.get(SettingMapConstants.MDControl1) != null)
		{
			if (masterDataControlMap.get(SettingMapConstants.MDControl1).equalsIgnoreCase(IConstantsData.MasterData_Control_Yes))
			{
				if (PageMasterDataTenantLevelConfigSettings.clickOnUsethePurchaseTypeFieldToclassifyPurchasesYes(driver, groupName))
				{

					logger.info("After Clicking on Radio Yes for Use the 'Purchase Type' field to classify purchases. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Yes for Use the 'Purchase Type' field to classify purchases. Setting Key: " + groupName);

				}
			}
			else if (masterDataControlMap.get(SettingMapConstants.MDControl1).equalsIgnoreCase(IConstantsData.MasterData_Control_No))
			{
				if (PageMasterDataTenantLevelConfigSettings.clickOnUsethePurchaseTypeFieldToclassifyPurchasesNo(driver, groupName))
				{

					logger.info("After Clicking on Radio No for Use the 'Purchase Type' field to classify purchases. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio No for Use the 'Purchase Type' field to classify purchases. Setting Key: " + groupName);

				}
			}
			else
			{
				logger.info("Incorrect Option provided for Setting: Allow budget utilization. Option: " + masterDataControlMap.get(SettingMapConstants.MDControl1));
			}
		}

		//Master Data - Control 2: Allow editing of Purchase type at line level
		if (masterDataControlMap.get(SettingMapConstants.MDControl2) != null)
		{
			if (masterDataControlMap.get(SettingMapConstants.MDControl2).equalsIgnoreCase(IConstantsData.MasterData_Control_Yes))
			{
				if (PageMasterDataTenantLevelConfigSettings.clickOnAllowEditingPurchaseTypeLineLevel_Yes(driver, groupName))
				{

					logger.info("After Clicking on Radio Yes for Allow editing of Purchase type at line level. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Yes for Allow editing of Purchase type at line level. Setting Key: " + groupName);

				}
			}
			else if (masterDataControlMap.get(SettingMapConstants.MDControl2).equalsIgnoreCase(IConstantsData.MasterData_Control_No))
			{
				if (PageMasterDataTenantLevelConfigSettings.clickOnAllowEditingPurchaseTypeLineLevel_No(driver, groupName))
				{

					logger.info("After Clicking on Radio No for Allow editing of Purchase type at line level. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio No for Allow editing of Purchase type at line level. Setting Key: " + groupName);

				}
			}
			else
			{
				logger.info(
					"Incorrect Option provided for Setting: Allow editing of Purchase type at line level. Option: " + masterDataControlMap.get(SettingMapConstants.MDControl2));
			}
		}

		//Master Data - Control 3: Enforce purchase type-based validation of GL accounts
		if (masterDataControlMap.get(SettingMapConstants.MDControl3) != null)
		{
			if (masterDataControlMap.get(SettingMapConstants.MDControl3).equalsIgnoreCase(IConstantsData.MasterData_Control_Yes))
			{
				if (PageMasterDataTenantLevelConfigSettings.clickOnEnforcePTBasedValidationOfGLAccountsYES(driver, groupName))
				{

					logger.info("After Clicking on Radio Yes Enforce purchase type-based validation of GL accounts. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Yes for Use the 'Purchase Type' field to classify purchases. Setting Key: " + groupName);

				}
			}
			else if (masterDataControlMap.get(SettingMapConstants.MDControl3).equalsIgnoreCase(IConstantsData.MasterData_Control_No))
			{
				if (PageMasterDataTenantLevelConfigSettings.clickOnEnforcePTBasedValidationOfGLAccountsNO(driver, groupName))
				{

					logger.info("After Clicking on Radio No for Enforce purchase type-based validation of GL accounts. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio No for Enforce purchase type-based validation of GL accounts. Setting Key: " + groupName);

				}
			}
			else
			{
				logger.info("Incorrect Option provided for Setting: Allow budget utilization. Option: " + masterDataControlMap.get(SettingMapConstants.MDControl3));
			}
		}

		//Master Data - Control 4: Allow Cost Center owners with overlapping approval limits
		if (masterDataControlMap.get(SettingMapConstants.MDControl4) != null)
		{
			if (masterDataControlMap.get(SettingMapConstants.MDControl4).equalsIgnoreCase(IConstantsData.MasterData_Control_Yes))
			{
				if (PageMasterDataTenantLevelConfigSettings.clickOnAllowCostCenterOwnerWithOverlappingLimit_Yes(driver, groupName))
				{

					logger.info("After Clicking on Radio Yes for Allow Cost Center owners with overlapping approval limits. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Yes for Allow Cost Center owners with overlapping approval limits. Setting Key: " + groupName);

				}
			}
			else if (masterDataControlMap.get(SettingMapConstants.MDControl4).equalsIgnoreCase(IConstantsData.MasterData_Control_No))
			{
				if (PageMasterDataTenantLevelConfigSettings.clickOnAllowCostCenterOwnerWithOverlappingLimit_No(driver, groupName))
				{

					logger.info("After Clicking on Radio No for Allow Cost Center owners with overlapping approval limits. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio No for Allow Cost Center owners with overlapping approval limits. Setting Key: " + groupName);

				}
			}
			else
			{
				logger.info("Incorrect Option provided for Setting: Allow Cost Center owners with overlapping approval limits. Option: "
					+ masterDataControlMap.get(SettingMapConstants.MDControl4));
			}
		}

		//Master Data - Control 5: Allow Project owners with overlapping approval limits
		if (masterDataControlMap.get(SettingMapConstants.MDControl5) != null)
		{
			if (masterDataControlMap.get(SettingMapConstants.MDControl5).equalsIgnoreCase(IConstantsData.MasterData_Control_Yes))
			{
				if (PageMasterDataTenantLevelConfigSettings.clickOnAllowProjectOwnerWithOverlappingLimit_Yes(driver, groupName))
				{

					logger.info("After Clicking on Radio Yes for Allow Project owners with overlapping approval limits. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Yes for Allow Project owners with overlapping approval limits. Setting Key: " + groupName);

				}
			}
			else if (masterDataControlMap.get(SettingMapConstants.MDControl5).equalsIgnoreCase(IConstantsData.MasterData_Control_No))
			{
				if (PageMasterDataTenantLevelConfigSettings.clickOnAllowProjectOwnerWithOverlappingLimit_No(driver, groupName))
				{

					logger.info("After Clicking on Radio No for Allow Project owners with overlapping approval limits. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio No for Allow Project owners with overlapping approval limits. Setting Key: " + groupName);

				}
			}
			else
			{
				logger.info("Incorrect Option provided for Setting: Allow Project owners with overlapping approval limits. Option: "
					+ masterDataControlMap.get(SettingMapConstants.MDControl5));
			}
		}

		//Master Data - Control 6: Allow GL Account owners with overlapping approval limits
		if (masterDataControlMap.get(SettingMapConstants.MDControl6) != null)
		{
			if (masterDataControlMap.get(SettingMapConstants.MDControl6).equalsIgnoreCase(IConstantsData.MasterData_Control_Yes))
			{
				if (PageMasterDataTenantLevelConfigSettings.clickOnAllowGLAccountOwnerWithOverlappingLimit_Yes(driver, groupName))
				{

					logger.info("After Clicking on Radio Yes for  Allow GL Account owners with overlapping approval limits. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Yes for  Allow GL Account owners with overlapping approval limits. Setting Key: " + groupName);

				}
			}
			else if (masterDataControlMap.get(SettingMapConstants.MDControl6).equalsIgnoreCase(IConstantsData.MasterData_Control_No))
			{
				if (PageMasterDataTenantLevelConfigSettings.clickOnAllowGLAccountOwnerWithOverlappingLimit_No(driver, groupName))
				{

					logger.info("After Clicking on Radio No for Allow GL Account owners with overlapping approval limits. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio No for  Allow GL Account owners with overlapping approval limits. Setting Key: " + groupName);

				}
			}
			else
			{
				logger.info("Incorrect Option provided for Setting:  Allow GL Account owners with overlapping approval limits. Option: "
					+ masterDataControlMap.get(SettingMapConstants.MDControl6));
			}
		}

		//Master Data - Control 7: Allow multiple category owners
		if (masterDataControlMap.get(SettingMapConstants.MDControl7) != null)
		{
			if (masterDataControlMap.get(SettingMapConstants.MDControl7).equalsIgnoreCase(IConstantsData.MasterData_Control_Yes))
			{
				if (PageMasterDataTenantLevelConfigSettings.clickOnAllowMultipleCatagoryOwners_Yes(driver, groupName))
				{

					logger.info("After Clicking on Radio Yes for Allow multiple category owners. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Yes for Allow multiple category owners. Setting Key: " + groupName);

				}
			}
			else if (masterDataControlMap.get(SettingMapConstants.MDControl7).equalsIgnoreCase(IConstantsData.MasterData_Control_No))
			{
				if (PageMasterDataTenantLevelConfigSettings.clickOnAllowMultipleCatagoryOwners_No(driver, groupName))
				{

					logger.info("After Clicking on Radio No for Allow multiple category owners. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio No for Allow multiple category owners. Setting Key: " + groupName);

				}
			}
			else
			{
				logger.info("Incorrect Option provided for Setting: Allow multiple category owners. Option: " + masterDataControlMap.get(SettingMapConstants.MDControl7));
			}
		}

		//Master Data - Control 8:Prevent selecting suppliers not extended to the ordering location
		if (masterDataControlMap.get(SettingMapConstants.MDControl8) != null)
		{
			if (masterDataControlMap.get(SettingMapConstants.MDControl8).equalsIgnoreCase(IConstantsData.MasterData_Control_Yes))
			{
				if (PageMasterDataTenantLevelConfigSettings.clickOnPreventSupplierNotEntendedToOrderingLocation_Yes(driver, groupName))
				{

					logger.info("After Clicking on Radio Yes for Prevent selecting suppliers not extended to the ordering location. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Yes for Prevent selecting suppliers not extended to the ordering location. Setting Key: " + groupName);

				}
			}
			else if (masterDataControlMap.get(SettingMapConstants.MDControl8).equalsIgnoreCase(IConstantsData.MasterData_Control_No))
			{
				if (PageMasterDataTenantLevelConfigSettings.clickOnPreventSupplierNotEntendedToOrderingLocation_No(driver, groupName))
				{

					logger.info("After Clicking on Radio No for Prevent selecting suppliers not extended to the ordering location. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio No for Prevent selecting suppliers not extended to the ordering location. Setting Key: " + groupName);

				}
			}
			else
			{
				logger.info("Incorrect Option provided for Setting: Allow multiple category owners. Option: " + masterDataControlMap.get(SettingMapConstants.MDControl8));
			}
		}

		ScreenShot.screenshot(driver, groupName, "After filling mater data-control settings");
		//save  Master Data Control setting
		if (PageMasterDataTenantLevelConfigSettings.clickOnSave(driver, groupName))
		{
			logger.info("Master Data Control setting saved ! . Setting Key: " + groupName);
		}
		else
		{
			logger.info("Master Data Control setting was not able to save ! . Setting Key: " + groupName);
		}

	}

	public static void changeMasterDataCostBookingSettings(Map<String, String> masterDataCostBookingMap, WebDriver driver, String groupName)
		throws ActionBotException, FactoryMethodException
	{
		// navigates to TMS
		driver.get(ConfigProperty.getConfig("TMS_URL"));
		ActionBot.waitForPageLoad(driver);

		ScreenShot.screenshot(driver, groupName, "After navigating to TMS Page");

		// navigates to Master data
		PageCustomizeSettings.clickOnMasterDataLink(driver, groupName);
		ActionBot.waitForPageLoad(driver);
		
		MainPageHeaderLevelTab.clickOnCustomize(driver, groupName);
		ActionBot.waitForPageLoad(driver);
		// click on cost booking link
		PageCustomizeSettings.clickOnCostBookingLink(driver, groupName);
		ActionBot.waitForPageLoad(driver);

		//Master Data - Cost Booking 1: Display "Asset code" field for assigning a code to an asset item
		if (masterDataCostBookingMap.get(SettingMapConstants.MDCostBooking1) != null)
		{
			if (masterDataCostBookingMap.get(SettingMapConstants.MDCostBooking1).equalsIgnoreCase(IConstantsData.MasterData_CostBooking_Yes))
			{
				if (PageProjectsSettings.clickOnDisplayAssetCodeForAssigningCodeToItem_Yes(driver, groupName))
				{

					logger.info("After Clicking on Radio Yes for Display 'Asset code' field for assigning a code to an asset item. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Yes for Display 'Asset code' field for assigning a code to an asset item. Setting Key: " + groupName);

				}
			}
			else if (masterDataCostBookingMap.get(SettingMapConstants.MDCostBooking1).equalsIgnoreCase(IConstantsData.MasterData_CostBooking_No))
			{
				if (PageProjectsSettings.clickOnDisplayAssetCodeForAssigningCodeToItem_No(driver, groupName))
				{

					logger.info("After Clicking on Radio No for Display 'Asset code' field for assigning a code to an asset item. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio No for Display 'Asset code' field for assigning a code to an asset item. Setting Key: " + groupName);

				}
			}
			else
			{
				logger.info("Incorrect Option provided for Setting: Assign purchase cost to projects. Option: " + masterDataCostBookingMap.get(SettingMapConstants.MDCostBooking1));
			}
		}

		//Master Data - Cost Booking 2: Assign purchase cost to projects
		if (masterDataCostBookingMap.get(SettingMapConstants.MDCostBooking2) != null)
		{
			if (masterDataCostBookingMap.get(SettingMapConstants.MDCostBooking2).equalsIgnoreCase(IConstantsData.MasterData_CostBooking_LetUsersDecide))
			{
				if (PageProjectsSettings.clickOnLetUsersDecide(driver))
				{

					logger.info("After Clicking on Radio Yes for Assign purchase cost to projects. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Yes for Assign purchase cost to projects. Setting Key: " + groupName);

				}
			}
			else if (masterDataCostBookingMap.get(SettingMapConstants.MDCostBooking2).equalsIgnoreCase(IConstantsData.MasterData_CostBooking_Always))
			{
				if (PageProjectsSettings.clickOnAlways(driver))
				{

					logger.info("After Clicking on Radio Yes for Assign purchase cost to projects. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Yes for Assign purchase cost to projects. Setting Key: " + groupName);

				}
			}
			else if (masterDataCostBookingMap.get(SettingMapConstants.MDCostBooking2).equalsIgnoreCase(IConstantsData.MasterData_CostBooking_LetUsersDecide))
			{
				if (PageProjectsSettings.clickOnNever(driver))
				{

					logger.info("After Clicking on Radio Yes for Assign purchase cost to projects. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio Yes for Assign purchase cost to projects. Setting Key: " + groupName);

				}
			}
			else
			{
				logger.info("Incorrect Option provided for Setting: Assign purchase cost to projects. Option: " + masterDataCostBookingMap.get(SettingMapConstants.MDCostBooking2));
			}
		}

		ScreenShot.screenshot(driver, groupName, "After filling master data- cost booking settings");
		//save Master Data - Cost Booking setting
		if (PageProjectsSettings.clickOnSave(driver))
		{
			logger.info("Master Data - Cost Booking setting saved ! . Setting Key: " + groupName);
		}
		else
		{
			logger.info("Master Data - Cost Booking setting was not able to save ! . Setting Key: " + groupName);
		}

		// navigates to EPROC
		driver.get(ConfigProperty.getConfig("Product_URL"));
		ActionBot.waitForPageLoad(driver);

		MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
	}

	public static void changeWorkflowSettings(Map<String, String> masterDataCostBookingMap, WebDriver driver, String groupName) throws ActionBotException, FactoryMethodException
	{

		// to click on cuatomize tab
		MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);

		// to click on requisition setting link
		PageCustomizeSettings.clickOnWorkflowLink(driver, groupName);
		ActionBot.waitForPageLoad(driver);

		//Workflow 1: When replacing an approver having higher approval limit than the new approver
		if (masterDataCostBookingMap.get(SettingMapConstants.Workflow1) != null)
		{
			if (masterDataCostBookingMap.get(SettingMapConstants.Workflow1).equalsIgnoreCase(IConstantsData.Workflow_Block))
			{
				if (PageWorkflowSettings.clickOnReplacingAnApproverWithHigherApprovalLimitThanNewApprover_BLOCK(driver, groupName))
				{

					logger.info("After Clicking on Radio BLOCK for  replacing an approver having higher approval limit than the new approver. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio BLOCK for replacing an approver having higher approval limit than the new approver. Setting Key: " + groupName);

				}
			}
			else if (masterDataCostBookingMap.get(SettingMapConstants.Workflow1).equalsIgnoreCase(IConstantsData.Workflow_Warning))
			{
				if (PageWorkflowSettings.clickOnReplacingAnApproverWithHigherApprovalLimitThanNewApprover_WARNING(driver, groupName))
				{

					logger.info("After Clicking on Radio DISPLY_WARNING for replacing an approver having higher approval limit than the new approver. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio DISPLY_WARNING for replacing an approver having higher approval limit than the new approver. Setting Key: " + groupName);

				}
			}
			else
			{
				logger.info("Incorrect Option provided for Setting: replacing an approver having higher approval limit than the new approver. Option: "
					+ masterDataCostBookingMap.get(SettingMapConstants.Workflow1));
			}
		}

		//Workflow 2: When replacing an approver with non-overlapping scope
		if (masterDataCostBookingMap.get(SettingMapConstants.Workflow2) != null)
		{
			if (masterDataCostBookingMap.get(SettingMapConstants.Workflow2).equalsIgnoreCase(IConstantsData.Workflow_Block))
			{
				if (PageWorkflowSettings.clickOnReplacingAnApproverWithNonOverlappingScopeBLOCK(driver, groupName))
				{

					logger.info("After Clicking on Radio BLOCK for replacing an approver with non-overlapping scope. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio BLOCK for replacing an approver with non-overlapping scope. Setting Key: " + groupName);

				}
			}
			else if (masterDataCostBookingMap.get(SettingMapConstants.Workflow2).equalsIgnoreCase(IConstantsData.Workflow_Warning))
			{
				if (PageWorkflowSettings.clickOnReplacingAnApproverWithNonOverLappingScopeDISPLAY_WARNING(driver, groupName))
				{

					logger.info("After Clicking on Radio DISPLY_WARNING for replacing an approver with non-overlapping scope. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio DISPLY_WARNING for replacing an approver with non-overlapping scope. Setting Key: " + groupName);

				}
			}
			else
			{
				logger.info("Incorrect Option provided for Setting: replacing an approver with non-overlapping scope. Option: "
					+ masterDataCostBookingMap.get(SettingMapConstants.Workflow2));
			}
		}

		//Workflow 3: When replacing an approver having higher designation than the new approver
		if (masterDataCostBookingMap.get(SettingMapConstants.Workflow3) != null)
		{
			if (masterDataCostBookingMap.get(SettingMapConstants.Workflow3).equalsIgnoreCase(IConstantsData.Workflow_Block))
			{
				if (PageWorkflowSettings.clickOnReplacingAnApproverWithHigherDesignationThanNewApprover_BLOCK(driver, groupName))
				{

					logger.info("After Clicking on Radio BLOCK for When replacing an approver having higher designation than the new approver. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio BLOCK for When replacing an approver having higher designation than the new approver. Setting Key: " + groupName);

				}
			}
			else if (masterDataCostBookingMap.get(SettingMapConstants.Workflow3).equalsIgnoreCase(IConstantsData.Workflow_Warning))
			{
				if (PageWorkflowSettings.clickOnReplacingAnApproverWithHigherDesignationThanNewApprover_WARNING(driver, groupName))
				{

					logger.info("After Clicking on Radio DISPLY_WARNING for When replacing an approver having higher designation than the new approver. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio DISPLY_WARNING for When replacing an approver having higher designation than the new approver. Setting Key: " + groupName);

				}
			}
			else
			{
				logger.info("Incorrect Option provided for Setting:When replacing an approver having higher designation than the new approver. Option: "
					+ masterDataCostBookingMap.get(SettingMapConstants.Workflow3));
			}
		}

		//Workflow 4: When replacing an approver with a different designation
		if (masterDataCostBookingMap.get(SettingMapConstants.Workflow4) != null)
		{
			if (masterDataCostBookingMap.get(SettingMapConstants.Workflow4).equalsIgnoreCase(IConstantsData.Workflow_Block))
			{
				if (PageWorkflowSettings.clickOnReplacingAnApproverWithDifferentDesignation_BLOCK(driver, groupName))
				{

					logger.info("After Clicking on Radio BLOCK replacing an approver with a different designation. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio BLOCK replacing an approver with a different designation. Setting Key: " + groupName);

				}
			}
			else if (masterDataCostBookingMap.get(SettingMapConstants.Workflow4).equalsIgnoreCase(IConstantsData.Workflow_Warning))
			{
				if (PageWorkflowSettings.clickOnReplacingAnApproverWithDifferentDesignation_WARNING(driver, groupName))
				{

					logger.info("After Clicking on Radio DISPLY_WARNING replacing an approver with a different designation. Setting Key: " + groupName);
				}
				else
				{
					logger.info("Error Clicking on Radio DISPLY_WARNING for replacing an approver with a different designation. Setting Key: " + groupName);

				}
			}
			else
			{
				logger.info("Incorrect Option provided for Setting: replacing an approver with a different designation. Option: "
					+ masterDataCostBookingMap.get(SettingMapConstants.Workflow4));
			}
		}

		ScreenShot.screenshot(driver, groupName, "After filling all the settings for workflow");
		//save Master Data - Cost Booking setting
		if (PageWorkflowSettings.clickOnSaveWorkflowSettings(driver, groupName))
		{
			logger.info("Master Data - Cost Booking setting saved ! . Setting Key: " + groupName);
		}
		else
		{
			logger.info("Master Data - Cost Booking setting was not able to save ! . Setting Key: " + groupName);
		}
	}

}
