package com.zycus.automation.eproc.businessflow.requisitionsettingsflow;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.RequisitionSettings;
import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.pageobjects.pages.settings.cusomizesettings.PageCustomizeSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.requisitionsettings.IPageRequisitionSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.requisitionsettings.PageRequisitionSettings;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

public class IFlowRequisitionSettingsImpl implements IFlowRequisitionSettings
{

	@Override
	public RequisitionSettings changeRequisitionSettings(WebDriver driver, String testCaseName, RequisitionSettings requisitionSettings) throws ActionBotException
	{
		// to click on cuatomize tab
		MainPageHeaderLevelTab.clickOnCustomizeSubTab(driver);

		// to click on requisition setting link
		PageCustomizeSettings.clickOnRequisitionLink(driver, testCaseName);
		ActionBot.defaultSleep();

		// reqNoFromat
		if (requisitionSettings.getReqNumberFormat() != null)
		{
			requisitionSettings.setReqNumberFormat(PageRequisitionSettings.fillRequisitionNumberFormat(driver, testCaseName, requisitionSettings.getReqNumberFormat()));
		}

		// seqNoStartsAt
		if (requisitionSettings.getReqNoStartsAt() != 0)
		{
			requisitionSettings.setReqNoStartsAt(PageRequisitionSettings.fillSequenceNumberStartsAt(driver, testCaseName, requisitionSettings.getReqNoStartsAt()));
		}

		// seqNoEdnsAt
		if (requisitionSettings.getReqNoEndsAt() != 0)
		{
			requisitionSettings.setReqNoEndsAt(PageRequisitionSettings.fillSequenceNumberEndsAt(driver, testCaseName, requisitionSettings.getReqNoEndsAt()));
		}

		// reqNameFromat
		if (requisitionSettings.getReqNameFormat() != null)
		{
			requisitionSettings.setReqNameFormat(PageRequisitionSettings.fillRequisitionNameFormat(driver, testCaseName, requisitionSettings.getReqNameFormat()));
		}

		// most frequently searched Item
		if (requisitionSettings.getMostFrequentlySearchedItems() != null)
		{
			requisitionSettings
				.setMostFrequentlySearchedItems(PageRequisitionSettings.fillMostFreqentlySearchedItems(driver, testCaseName, requisitionSettings.getMostFrequentlySearchedItems()));
		}

		// itemQuantityThreshold
		if (requisitionSettings.getItemQuantityThreshold() != 0)
		{
			requisitionSettings.setItemQuantityThreshold(PageRequisitionSettings.fillItemQuantityThreshold(driver, testCaseName, requisitionSettings.getItemQuantityThreshold()));
		}

		// order free text items-Always
		if (requisitionSettings.getAllowRequetserToOrderFreeTextItemsType() != null)
		{
			if (requisitionSettings.getAllowRequetserToOrderFreeTextItemsType().equalsIgnoreCase(IPageRequisitionSettings.ALWAYS))
			{
				PageRequisitionSettings.clickOnOrderFreeTextItemsAlways(driver, testCaseName);
			}

			// order free text items-Never
			if (requisitionSettings.getAllowRequetserToOrderFreeTextItemsType().equalsIgnoreCase(IPageRequisitionSettings.NEVER))
			{
				PageRequisitionSettings.clickOnOrderFreeTextItemsNever(driver, testCaseName);
			}

			// order free text items-Permission Based
			if (requisitionSettings.getAllowRequetserToOrderFreeTextItemsType().equalsIgnoreCase(IPageRequisitionSettings.PERMISSION_BASED))
			{
				PageRequisitionSettings.clickOnOrderFreeTextItemsPermissionBased(driver, testCaseName);
			}
		}

		if (requisitionSettings.getAllowFreeTextItemsRequestedWithoutSelectingCategoryOption() != null)
		{
			// order free text items without category-Yes
			if (requisitionSettings.getAllowFreeTextItemsRequestedWithoutSelectingCategoryOption().equalsIgnoreCase(IConstants.YES))
			{
				PageRequisitionSettings.clickOnFreeTextItemsRequestedWithoutSelectingCategory_yes(driver, testCaseName);
			}

			// order free text items without category-Yes
			if (requisitionSettings.getAllowFreeTextItemsRequestedWithoutSelectingCategoryOption().equalsIgnoreCase(IConstants.NO))
			{
				PageRequisitionSettings.clickOnFreeTextItemsRequestedWithoutSelectingCategory_no(driver, testCaseName);
			}
		}

		if (requisitionSettings.getAllowReqToBeSubmittedWithoutRequiredByDateOption() != null)
		{
			// without required by date-Yes
			if (requisitionSettings.getAllowReqToBeSubmittedWithoutRequiredByDateOption().equalsIgnoreCase(IConstants.YES))
			{
				PageRequisitionSettings.clickOnReqToBeSubmittedWithoutRequiredByDate_yes(driver, testCaseName);
			}

			// without required by date-No
			if (requisitionSettings.getAllowReqToBeSubmittedWithoutRequiredByDateOption().equalsIgnoreCase(IConstants.NO))
			{
				PageRequisitionSettings.clickOnReqToBeSubmittedWithoutRequiredByDate_no(driver, testCaseName);
			}
		}

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300);");

		if (requisitionSettings.getAllowBuyerToModifyRequiredByDateOption() != null)
		{
			// buyer to modify required by date-Yes
			if (requisitionSettings.getAllowBuyerToModifyRequiredByDateOption().equalsIgnoreCase(IConstants.YES))
			{
				PageRequisitionSettings.clickOnAllowBuyerToModifyRequiredByDate_yes(driver, testCaseName);
			}

			// buyer to modify required by date-No
			if (requisitionSettings.getAllowBuyerToModifyRequiredByDateOption().equalsIgnoreCase(IConstants.NO))
			{
				PageRequisitionSettings.clickOnAllowBuyerToModifyRequiredByDate_no(driver, testCaseName);
			}
		}

		if (requisitionSettings.getAllowReqToBeSubmittedWithoutCostCenterInfoOption() != null)
		{
			// without cost center info-Yes
			if (requisitionSettings.getAllowReqToBeSubmittedWithoutCostCenterInfoOption().equalsIgnoreCase(IConstants.YES))
			{
				PageRequisitionSettings.clickOnAllowReqToBeSubmittedWithoutCostCenterInfo_yes(driver, testCaseName);
			}

			// without cost center info-No
			if (requisitionSettings.getAllowReqToBeSubmittedWithoutCostCenterInfoOption().equalsIgnoreCase(IConstants.NO))
			{
				PageRequisitionSettings.clickOnAllowReqToBeSubmittedWithoutCostCenterInfo_no(driver, testCaseName);
			}
		}

		if (requisitionSettings.getAllowBuyerToModifyCostCenterInfoOption() != null)
		{
			// allow buyer to modify cost center info-Yes
			if (requisitionSettings.getAllowBuyerToModifyCostCenterInfoOption().equalsIgnoreCase(IConstants.YES))
			{
				PageRequisitionSettings.clickOnAllowBuyerToModifyCostCenterInfo_yes(driver, testCaseName);
			}

			// allow buyer to modify cost center info-No
			if (requisitionSettings.getAllowBuyerToModifyCostCenterInfoOption().equalsIgnoreCase(IConstants.NO))
			{
				PageRequisitionSettings.clickOnAllowBuyerToModifyCostCenterInfo_no(driver, testCaseName);
			}
		}

		if (requisitionSettings.getDisplayAccountingInfoToRequesterOption() != null)
		{
			// display accounting info-Yes
			if (requisitionSettings.getDisplayAccountingInfoToRequesterOption().equalsIgnoreCase(IConstants.YES))
			{
				PageRequisitionSettings.clickOnDisplayAccountingInfoToRequester_yes(driver, testCaseName);
			}
			// display accounting info-No
			if (requisitionSettings.getDisplayAccountingInfoToRequesterOption().equalsIgnoreCase(IConstants.NO))
			{
				PageRequisitionSettings.clickOnDisplayAccountingInfoToRequester_no(driver, testCaseName);
			}
		}

		if (requisitionSettings.getRequesterIsRequiredToProvideAccountingInfoOption() != null)
		{
			// requester is required to provide accounting info-Yes
			if (requisitionSettings.getRequesterIsRequiredToProvideAccountingInfoOption().equalsIgnoreCase(IConstants.YES))
			{
				PageRequisitionSettings.clickOnRequesterIsRequiredToProvideAccountingInfo_yes(driver, testCaseName);
			}
			// requester is required to provide accounting info-No
			if (requisitionSettings.getRequesterIsRequiredToProvideAccountingInfoOption().equalsIgnoreCase(IConstants.NO))
			{
				PageRequisitionSettings.clickOnRequesterIsRequiredToProvideAccountingInfo_no(driver, testCaseName);
			}
		}

		if (requisitionSettings.getAllowRequesterToOverrideDefaultGLAccountOption() != null)
		{
			// override default GL Account-Yes
			if (requisitionSettings.getAllowRequesterToOverrideDefaultGLAccountOption().equalsIgnoreCase(IConstants.YES))
			{
				PageRequisitionSettings.clickOnAllowRequesterToOverrideDefaultGLAccount_yes(driver, testCaseName);
			}

			// override default GL Account-No
			if (requisitionSettings.getAllowRequesterToOverrideDefaultGLAccountOption().equalsIgnoreCase(IConstants.NO))
			{
				PageRequisitionSettings.clickOnAllowRequesterToOverrideDefaultGLAccount_no(driver, testCaseName);
			}
		}

		if (requisitionSettings.getRequesterRequiredToAssignBuyerOption() != null)
		{
			// assign buyer-Required
			if (requisitionSettings.getRequesterRequiredToAssignBuyerOption().equalsIgnoreCase(IConstantsData.REQUIRED))
			{
				PageRequisitionSettings.clickOnRequesterRequiredToAssignBuyer_Required(driver, testCaseName);
			}

			// assign buyer-Optional
			if (requisitionSettings.getRequesterRequiredToAssignBuyerOption().equalsIgnoreCase(IConstantsData.OPTIONAL))
			{
				PageRequisitionSettings.clickOnRequesterRequiredToAssignBuyer_Optional(driver, testCaseName);
			}

			// assign buyer-Hidden
			if (requisitionSettings.getRequesterRequiredToAssignBuyerOption().equalsIgnoreCase(IConstantsData.HIDDEN))
			{
				PageRequisitionSettings.clickOnRequesterRequiredToAssignBuyer_Hidden(driver, testCaseName);
			}
		}

		if (requisitionSettings.getApplyCategoryBasedWorkflowOption() != null)
		{
			// apply category based work flow -Yes
			if (requisitionSettings.getApplyCategoryBasedWorkflowOption().equalsIgnoreCase(IConstants.YES))
			{
				PageRequisitionSettings.clickOnApplyCategoryBasedWorkflow_yes(driver, testCaseName);
			}

			// apply category based work flow -No
			if (requisitionSettings.getApplyCategoryBasedWorkflowOption().equalsIgnoreCase(IConstants.NO))
			{
				PageRequisitionSettings.clickOnApplyCategoryBasedWorkflow_no(driver, testCaseName);
			}
		}

		// forking is disabled on settings page
		/*
		 * if (requisitionSettings.isEnableReqForking()) { //enable req
		 * forking-Yes
		 * PageRequisitionSettings.clickOnEnableRequisitionForking_yes(driver,
		 * testCaseName); } else
		 * if(requisitionSettings.isEnableReqForking()==false) { //enable req
		 * forking-No
		 * PageRequisitionSettings.clickOnEnableRequisitionForking_no(driver,
		 * testCaseName); }
		 */

		// SplitReqAsPerCategories
		if (requisitionSettings.isForReqByCategory())
		{
			PageRequisitionSettings.clickOnSplitReqAsPerCategories(driver, testCaseName);
		}
		// SplitReqAsPerPriceTypes
		if (requisitionSettings.isForReqBySourcingStatus())
		{
			PageRequisitionSettings.clickOnSplitReqAsPerPriceType(driver, testCaseName);
		}

		// Disbursement
		if (requisitionSettings.isAddDisbursementAsSettlementViaOption())
		{
			PageRequisitionSettings.clickOnAddDisbursementAsSettlementViaOptionYes(driver, testCaseName);

			if (requisitionSettings.isSendPOToSupplier())
			{
				PageRequisitionSettings.clickOnSendPOToSupplierOptionYes(driver, testCaseName);
			}
			else
			{
				PageRequisitionSettings.clickOnSendPOToSupplierOptionNo(driver, testCaseName);
			}
		}
		else
		{
			PageRequisitionSettings.clickOnAddDisbursementAsSettlementViaOptionNo(driver, testCaseName);
		}

		// change in sourcing status
		if (requisitionSettings.isQuotedBySupplier_SourcingStatus())
		{
			// to select
			if (!PageRequisitionSettings.isQuotedBySupplierSourcingStatusSelected(driver, testCaseName))
			{
				PageRequisitionSettings.clickOnQuotedBySupplierSourcingStatus(driver, testCaseName);
			}
		}
		else
		{
			// to unselect
			if (PageRequisitionSettings.isQuotedBySupplierSourcingStatusSelected(driver, testCaseName))
			{
				PageRequisitionSettings.clickOnQuotedBySupplierSourcingStatus(driver, testCaseName);
			}
		}
		if (requisitionSettings.isEstimatedPrice_SourcingStatus())
		{
			// to select
			if (!PageRequisitionSettings.isEstimatedPriceSourcingStatusSelected(driver, testCaseName))
			{
				PageRequisitionSettings.clickOnEstimatedPriceSourcingStatus(driver, testCaseName);
			}
		}
		else
		{
			// to unselect
			if (PageRequisitionSettings.isEstimatedPriceSourcingStatusSelected(driver, testCaseName))
			{
				PageRequisitionSettings.clickOnEstimatedPriceSourcingStatus(driver, testCaseName);
			}
		}
		if (requisitionSettings.isNeedAQuote_SourcingStatus())
		{
			if (!PageRequisitionSettings.isNeedAQuoteSourcingStatusSelected(driver, testCaseName))
			{
				PageRequisitionSettings.clickOnNeedAQuoteSourcingStatus(driver, testCaseName);
			}
		}
		else
		{
			if (PageRequisitionSettings.isNeedAQuoteSourcingStatusSelected(driver, testCaseName))
			{
				PageRequisitionSettings.clickOnNeedAQuoteSourcingStatus(driver, testCaseName);
			}
		}

		ActionBot.defaultSleep();
		ActionBot.scroll(driver, "400");
		PageRequisitionSettings.clickOnSaveButton(driver, testCaseName);
		ActionBot.defaultSleep();
		return requisitionSettings;

	}

	@Override
	public RequisitionSettings getRequisitionSettings(WebDriver driver, String testCaseName) throws ActionBotException
	{
		RequisitionSettings requisitionSettings = new RequisitionSettings();

		// reqNumberFormat
		requisitionSettings.setReqNumberFormat(PageRequisitionSettings.getRequisitionNumberFormat(driver, testCaseName));

		// reqNoStartsAt
		requisitionSettings.setReqNoStartsAt(PageRequisitionSettings.getSequenceNumberStartsAt(driver, testCaseName));

		// reqNoEndsAt
		requisitionSettings.setReqNoEndsAt(PageRequisitionSettings.getSequenceNumberEndsAt(driver, testCaseName));

		// reqNameFormat
		requisitionSettings.setReqNameFormat(PageRequisitionSettings.getRequisitionNameFormat(driver, testCaseName));

		// mostFrquentlySearchedItems
		requisitionSettings.setMostFrequentlySearchedItems(PageRequisitionSettings.getMostFreqentlySearchedItems(driver, testCaseName));

		// itemQuantityThreshold
		requisitionSettings.setItemQuantityThreshold(PageRequisitionSettings.getItemQuantityThreshold(driver, testCaseName));

		// AllowRequetserToOrderFreeTextItemsType
		requisitionSettings.setAllowRequetserToOrderFreeTextItemsType(PageRequisitionSettings.getAllowRequetserToOrderFreeTextItemsType(driver, testCaseName));

		// AllowFreeTextItemsRequestedWithoutSelectingCategoryOption
		requisitionSettings.setAllowFreeTextItemsRequestedWithoutSelectingCategoryOption(
			PageRequisitionSettings.getAllowFreeTextItemsRequestedWithoutSelectingCategoryOption(driver, testCaseName));

		// AllowReqToBeSubmittedWithoutRequiredByDateOption
		requisitionSettings.setAllowReqToBeSubmittedWithoutRequiredByDateOption(PageRequisitionSettings.getAllowReqToBeSubmittedWithoutRequiredByDateOption(driver, testCaseName));

		// AllowBuyerToModifyRequiredByDateOption
		requisitionSettings.setAllowBuyerToModifyRequiredByDateOption(PageRequisitionSettings.getAllowBuyerToModifyRequiredByDateOption(driver, testCaseName));

		// AllowReqToBeSubmittedWithoutCostCenterInfoOption
		requisitionSettings.setAllowReqToBeSubmittedWithoutCostCenterInfoOption(PageRequisitionSettings.getAllowBuyerToModifyCostCenterInfoOption(driver, testCaseName));

		// AllowBuyerToModifyCostCenterInfoOption
		requisitionSettings.setAllowBuyerToModifyCostCenterInfoOption(PageRequisitionSettings.getAllowBuyerToModifyCostCenterInfoOption(driver, testCaseName));

		// DisplayAccountingInfoToRequesterOption
		requisitionSettings.setDisplayAccountingInfoToRequesterOption(PageRequisitionSettings.getDisplayAccountingInfoToRequesterOption(driver, testCaseName));

		// RequesterIsRequiredToProvideAccountingInfoOption
		requisitionSettings.setRequesterIsRequiredToProvideAccountingInfoOption(PageRequisitionSettings.getRequesterIsRequiredToProvideAccountingInfoOption(driver, testCaseName));

		// AllowRequesterToOverrideDefaultGLAccountOption
		requisitionSettings.setAllowRequesterToOverrideDefaultGLAccountOption(PageRequisitionSettings.getAllowRequesterToOverrideDefaultGLAccountOption(driver, testCaseName));

		// RequesterRequiredToAssignBuyerOption
		requisitionSettings.setRequesterRequiredToAssignBuyerOption(PageRequisitionSettings.getRequesterRequiredToAssignBuyerOption(driver, testCaseName));

		// ApplyCategoryBasedWorkflowOption
		requisitionSettings.setApplyCategoryBasedWorkflowOption(PageRequisitionSettings.getApplyCategoryBasedWorkflowOption(driver, testCaseName));

		// EnableRequisitionForkingOption
		requisitionSettings.setEnableRequisitionForkingOption(PageRequisitionSettings.getEnableRequisitionForkingOption(driver, testCaseName));

		// SplitReqTypeOption
		if (PageRequisitionSettings.getSplitReqTypeOption(driver, testCaseName).equalsIgnoreCase(IPageRequisitionSettings.CATEGORIES))
		{
			requisitionSettings.setForReqByCategory(true);
		}
		else if (PageRequisitionSettings.getSplitReqTypeOption(driver, testCaseName).equalsIgnoreCase(IPageRequisitionSettings.PRICE_TYPE))
		{
			requisitionSettings.setForReqBySourcingStatus(true);
		}

		return requisitionSettings;

	}
}
