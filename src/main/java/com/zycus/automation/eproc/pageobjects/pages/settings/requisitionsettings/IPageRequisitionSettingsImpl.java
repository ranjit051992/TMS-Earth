/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.settings.requisitionsettings;

import java.awt.Desktop.Action;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.constants.IConstants;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IPageRequisitionSettingsImpl implements IPageRequisitionSettings, IConstants
{

	@Override
	public String fillRequisitionNumberFormat(WebDriver driver, String testCaseName, String reqNumberFormat) throws ActionBotException
	{
		String reqNumber_format;
		ActionBot.sendKeys(driver, REQ_NO_FORMAT, reqNumberFormat);
		// ScreenShot.screenshot(driver, testCaseName, "After filling
		// requisition number format");

		reqNumber_format = ActionBot.findElement(driver, REQ_NO_FORMAT).getAttribute("value");
		return reqNumber_format;
	}

	@Override
	public Integer fillSequenceNumberStartsAt(WebDriver driver, String testCaseName, int seqNoStartsAt) throws ActionBotException
	{
		String seq_no_startsAt = Integer.toString(seqNoStartsAt);
		ActionBot.sendKeys(driver, REQ_SEQUENCE_NO_STARTS_AT, seq_no_startsAt);
		// ScreenShot.screenshot(driver, testCaseName, "After filling sequence
		// number starts at");

		seq_no_startsAt = ActionBot.findElement(driver, REQ_SEQUENCE_NO_STARTS_AT).getAttribute("value");
		return Integer.parseInt(seq_no_startsAt);
	}

	@Override
	public Integer fillSequenceNumberEndsAt(WebDriver driver, String testCaseName, int seqNoEndsAt) throws ActionBotException
	{
		String seq_no_endsAt = Integer.toString(seqNoEndsAt);
		ActionBot.sendKeys(driver, REQ_SEQUENCE_NO_ENDS_AT, seq_no_endsAt);
		// ScreenShot.screenshot(driver, testCaseName, "After filling Sequence
		// number ends at");

		seq_no_endsAt = ActionBot.findElement(driver, REQ_SEQUENCE_NO_ENDS_AT).getAttribute("value");
		return Integer.parseInt(seq_no_endsAt);
	}

	@Override
	public String fillRequisitionNameFormat(WebDriver driver, String testCaseName, String reqNameFormat) throws ActionBotException
	{
		String reqName_format;
		ActionBot.sendKeys(driver, REQ_NAME_FORMAT, reqNameFormat);
		// ScreenShot.screenshot(driver, testCaseName, "After filling
		// Requisition Name Format");

		reqName_format = ActionBot.findElement(driver, REQ_NAME_FORMAT).getAttribute("value");
		return reqName_format;
	}

	@Override
	public String fillMostFreqentlySearchedItems(WebDriver driver, String testCaseName, String mostFrequentlySearchedItems) throws ActionBotException
	{
		String frequentlySearchedItems;
		ActionBot.sendKeys(driver, FREQUENTLY_SEARCHED_ITEM, mostFrequentlySearchedItems);
		// ScreenShot.screenshot(driver, testCaseName, "After filling Most
		// frequently searched items");

		frequentlySearchedItems = ActionBot.findElement(driver, FREQUENTLY_SEARCHED_ITEM).getAttribute("value");
		return frequentlySearchedItems;
	}

	@Override
	public Integer fillItemQuantityThreshold(WebDriver driver, String testCaseName, int itemQuantityThreshold) throws ActionBotException
	{
		String item_quantity_threshold = Integer.toString(itemQuantityThreshold);
		ActionBot.sendKeys(driver, REQ_ITEM_QUQNTITY_THRESHOLD, item_quantity_threshold);

		// ScreenShot.screenshot(driver, testCaseName, "After filling Item
		// quantity threshold");
		item_quantity_threshold = ActionBot.findElement(driver, REQ_ITEM_QUQNTITY_THRESHOLD).getAttribute("value");
		return Integer.parseInt(item_quantity_threshold);
	}

	@Override
	public boolean clickOnOrderFreeTextItemsAlways(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, FREE_TEXT_ITEMS_ALWAYS);
		// ScreenShot.screenshot(driver, testCaseName, "After selecting order
		// free text items always option ");
		if (ActionBot.isElementSelected(driver, FREE_TEXT_ITEMS_ALWAYS))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickOnOrderFreeTextItemsNever(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, FREE_TEXT_ITEMS_NEVER);
		// ScreenShot.screenshot(driver, testCaseName, "After selecting order
		// free text items never option ");
		if (ActionBot.isElementSelected(driver, FREE_TEXT_ITEMS_NEVER))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickOnOrderFreeTextItemsPermissionBased(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, FREE_TEXT_ITEMS_PERMISSION_BASED);
		// ScreenShot.screenshot(driver, testCaseName, "After selecting order
		// free text items permission based option ");
		if (ActionBot.isElementSelected(driver, FREE_TEXT_ITEMS_PERMISSION_BASED))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickOnFreeTextItemsRequestedWithoutSelectingCategory_yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, FREE_TEXT_ITEM_WITHOUT_CATEGORY_YES);
		// ScreenShot.screenshot(driver, testCaseName,
		// "After selecting order free text items without category yes option
		// ");
		if (ActionBot.isElementSelected(driver, FREE_TEXT_ITEM_WITHOUT_CATEGORY_YES))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickOnFreeTextItemsRequestedWithoutSelectingCategory_no(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, FREE_TEXT_ITEM_WITHOUT_CATEGORY_NO);
		// ScreenShot
		// .screenshot(driver, testCaseName, "After selecting order free text
		// items without category no option ");
		if (ActionBot.isElementSelected(driver, FREE_TEXT_ITEM_WITHOUT_CATEGORY_NO))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickOnReqToBeSubmittedWithoutRequiredByDate_yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, WITHOUT_REQUIRED_BY_DATE_YES);
		// ScreenShot.screenshot(driver, testCaseName,
		// "After selecting req to be submitted without required by date yes
		// option ");
		if (ActionBot.isElementSelected(driver, WITHOUT_REQUIRED_BY_DATE_YES))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickOnReqToBeSubmittedWithoutRequiredByDate_no(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, WITHOUT_REQUIRED_BY_DATE_NO);
		// ScreenShot.screenshot(driver, testCaseName,
		// "After selecting req to be submitted without required by date no
		// option ");
		if (ActionBot.isElementSelected(driver, WITHOUT_REQUIRED_BY_DATE_NO))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickOnAllowBuyerToModifyRequiredByDate_yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ALLOW_BUYER_TO_MODIFY_REQUIRED_BY_DATE_YES);
		// ScreenShot.screenshot(driver, testCaseName,
		// "After selecting allow buyer to modify required by date yes option
		// ");
		if (ActionBot.isElementSelected(driver, ALLOW_BUYER_TO_MODIFY_REQUIRED_BY_DATE_YES))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	@Override
	public boolean clickOnAllowBuyerToModifyRequiredByDate_no(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ALLOW_BUYER_TO_MODIFY_REQUIRED_BY_DATE_NO);
		// ScreenShot
		// .screenshot(driver, testCaseName, "After selecting allow buyer to
		// modify required by date no option ");
		if (ActionBot.isElementSelected(driver, ALLOW_BUYER_TO_MODIFY_REQUIRED_BY_DATE_NO))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickOnAllowReqToBeSubmittedWithoutCostCenterInfo_yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, COST_CENTER_INFO_YES);
		// ScreenShot.screenshot(driver, testCaseName,
		// "After selecting req to be submmited without cost center info yes
		// option ");
		if (ActionBot.isElementSelected(driver, COST_CENTER_INFO_YES))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickOnAllowReqToBeSubmittedWithoutCostCenterInfo_no(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, COST_CENTER_INFO_NO);
		// ScreenShot.screenshot(driver, testCaseName,
		// "After selecting req to be submmited without cost center info no
		// option ");
		if (ActionBot.isElementSelected(driver, COST_CENTER_INFO_NO))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickOnAllowBuyerToModifyCostCenterInfo_yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ALLOW_BUYER_TO_MODIFY_COST_CENTER_INFO_YES);
		// ScreenShot.screenshot(driver, testCaseName,
		// "After selecting Allow buyer to modify cost center info yes option
		// ");
		if (ActionBot.isElementSelected(driver, ALLOW_BUYER_TO_MODIFY_COST_CENTER_INFO_YES))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickOnAllowBuyerToModifyCostCenterInfo_no(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ALLOW_BUYER_TO_MODIFY_COST_CENTER_INFO_NO);
		// ScreenShot
		// .screenshot(driver, testCaseName, "After selecting Allow buyer to
		// modify cost center info no option ");
		if (ActionBot.isElementSelected(driver, ALLOW_BUYER_TO_MODIFY_COST_CENTER_INFO_NO))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickOnDisplayAccountingInfoToRequester_yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, DISPLAY_ACCOUNTING_INFO_YES);
		// ScreenShot.screenshot(driver, testCaseName, "After selecting Display
		// accounting info to requester yes option ");
		if (ActionBot.isElementSelected(driver, DISPLAY_ACCOUNTING_INFO_YES))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickOnDisplayAccountingInfoToRequester_no(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, DISPLAY_ACCOUNTING_INFO_NO);
		// ScreenShot.screenshot(driver, testCaseName, "After selecting Display
		// accounting info to requester no option ");
		if (ActionBot.isElementSelected(driver, DISPLAY_ACCOUNTING_INFO_NO))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickOnRequesterIsRequiredToProvideAccountingInfo_yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, REQUIRED_ACCOUNTING_INFO_YES);
		// ScreenShot.screenshot(driver, testCaseName,
		// "After selecting Requester is required to provide accounting info yes
		// option ");
		if (ActionBot.isElementSelected(driver, REQUIRED_ACCOUNTING_INFO_YES))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickOnRequesterIsRequiredToProvideAccountingInfo_no(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, REQUIRED_ACCOUNTING_INFO_NO);
		// ScreenShot.screenshot(driver, testCaseName,
		// "After selecting Requester is required to provide accounting info no
		// option ");
		if (ActionBot.isElementSelected(driver, REQUIRED_ACCOUNTING_INFO_NO))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickOnAllowRequesterToOverrideDefaultGLAccount_yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ALLOW_OVERRIDE_GLACCOUNT_YES);
		// ScreenShot.screenshot(driver, testCaseName,
		// "After selecting Allow Requester to override GL Account yes option
		// ");
		if (ActionBot.isElementSelected(driver, ALLOW_OVERRIDE_GLACCOUNT_YES))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickOnAllowRequesterToOverrideDefaultGLAccount_no(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ALLOW_OVERRIDE_GLACCOUNT_NO);
		// ScreenShot
		// .screenshot(driver, testCaseName, "After selecting Allow Requester to
		// override GL Account no option ");
		if (ActionBot.isElementSelected(driver, ALLOW_OVERRIDE_GLACCOUNT_NO))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickOnApplyCategoryBasedWorkflow_yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CATEGORY_BASED_WORKFLOW_YES);
		// ScreenShot.screenshot(driver, testCaseName, "After selecting Apply
		// category based workflow yes option ");
		if (ActionBot.isElementSelected(driver, CATEGORY_BASED_WORKFLOW_YES))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickOnApplyCategoryBasedWorkflow_no(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CATEGORY_BASED_WORKFLOW_NO);
		// ScreenShot.screenshot(driver, testCaseName, "After selecting Apply
		// category based workflow no option ");
		if (ActionBot.isElementSelected(driver, CATEGORY_BASED_WORKFLOW_NO))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickOnEnableRequisitionForking_yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, REQ_FORKING_YES);
		// ScreenShot.screenshot(driver, testCaseName, "After selecting Enable
		// requisition forking yes option ");
		if (ActionBot.isElementSelected(driver, REQ_FORKING_YES))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickOnEnableRequisitionForking_no(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, REQ_FORKING_NO);
		// ScreenShot.screenshot(driver, testCaseName, "After selecting Enable
		// requisition forking no option ");
		if (ActionBot.isElementSelected(driver, REQ_FORKING_NO))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickOnSplitReqAsPerCategories(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		if (!ActionBot.isElementSelected(driver, FORKING_CATERIA_CATEGORIES))
		{
			ActionBot.click(driver, FORKING_CATERIA_CATEGORIES);
		}
		ScreenShot.screenshot(driver, testCaseName, "After selecting Split req as per categories option ");
		if (ActionBot.isElementSelected(driver, FORKING_CATERIA_CATEGORIES))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickOnSplitReqAsPerPriceType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (!ActionBot.isElementSelected(driver, FORKING_CATERIA_PRICE_TYPE))
		{
			ActionBot.click(driver, FORKING_CATERIA_PRICE_TYPE);
		}
		ScreenShot.screenshot(driver, testCaseName, "After selecting Split req as per price type option ");
		if (ActionBot.isElementSelected(driver, FORKING_CATERIA_PRICE_TYPE))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getRequisitionNumberFormat(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElement(driver, REQ_NO_FORMAT).getAttribute("value");
	}

	@Override
	public Integer getSequenceNumberStartsAt(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return Integer.parseInt(ActionBot.findElement(driver, REQ_SEQUENCE_NO_STARTS_AT).getAttribute("value"));
	}

	@Override
	public Integer getSequenceNumberEndsAt(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return Integer.parseInt(ActionBot.findElement(driver, REQ_SEQUENCE_NO_ENDS_AT).getAttribute("value"));
	}

	@Override
	public String getRequisitionNameFormat(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElement(driver, REQ_NAME_FORMAT).getAttribute("value");
	}

	@Override
	public String getMostFreqentlySearchedItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElement(driver, FREQUENTLY_SEARCHED_ITEM).getAttribute("value");
	}

	@Override
	public Integer getItemQuantityThreshold(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return Integer.parseInt(ActionBot.findElement(driver, REQ_ITEM_QUQNTITY_THRESHOLD).getAttribute("value"));
	}

	@Override
	public String getAllowRequetserToOrderFreeTextItemsType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String orderFreeTextItemsType;
		if (ActionBot.isElementSelected(driver, FREE_TEXT_ITEMS_ALWAYS))
		{
			orderFreeTextItemsType = ALWAYS;
		}
		else if (ActionBot.isElementSelected(driver, FREE_TEXT_ITEMS_NEVER))
		{
			orderFreeTextItemsType = NEVER;
		}
		else
		{
			orderFreeTextItemsType = PERMISSION_BASED;
		}

		return orderFreeTextItemsType;
	}

	@Override
	public String getAllowFreeTextItemsRequestedWithoutSelectingCategoryOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String freeTextItemWithoutCategory;
		if (ActionBot.isElementSelected(driver, FREE_TEXT_ITEM_WITHOUT_CATEGORY_YES))
		{
			freeTextItemWithoutCategory = YES;
		}
		else
		{
			freeTextItemWithoutCategory = NO;
		}

		return freeTextItemWithoutCategory;
	}

	@Override
	public String getAllowReqToBeSubmittedWithoutRequiredByDateOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String withoutRequiredByDate;
		if (ActionBot.isElementSelected(driver, WITHOUT_REQUIRED_BY_DATE_YES))
		{
			withoutRequiredByDate = YES;
		}
		else
		{
			withoutRequiredByDate = NO;
		}

		return withoutRequiredByDate;
	}

	@Override
	public String getAllowBuyerToModifyRequiredByDateOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String allowBuyerToModifyReqiredByDate;
		if (ActionBot.isElementSelected(driver, ALLOW_BUYER_TO_MODIFY_REQUIRED_BY_DATE_YES))
		{
			allowBuyerToModifyReqiredByDate = YES;
		}
		else
		{
			allowBuyerToModifyReqiredByDate = NO;
		}

		return allowBuyerToModifyReqiredByDate;
	}

	@Override
	public String getAllowReqToBeSubmittedWithoutCostCenterInfoOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String allowReqToBeSubmittedWithoutCostCenterInfo;
		if (ActionBot.isElementSelected(driver, COST_CENTER_INFO_YES))
		{
			allowReqToBeSubmittedWithoutCostCenterInfo = YES;
		}
		else
		{
			allowReqToBeSubmittedWithoutCostCenterInfo = NO;
		}

		return allowReqToBeSubmittedWithoutCostCenterInfo;
	}

	@Override
	public String getAllowBuyerToModifyCostCenterInfoOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String allowBuyerToModifyCostCenterInfo;
		if (ActionBot.isElementSelected(driver, ALLOW_BUYER_TO_MODIFY_COST_CENTER_INFO_YES))
		{
			allowBuyerToModifyCostCenterInfo = YES;
		}
		else
		{
			allowBuyerToModifyCostCenterInfo = NO;
		}

		return allowBuyerToModifyCostCenterInfo;
	}

	@Override
	public String getDisplayAccountingInfoToRequesterOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String displayAccountingInfoToRequester;
		if (ActionBot.isElementSelected(driver, DISPLAY_ACCOUNTING_INFO_YES))
		{
			displayAccountingInfoToRequester = YES;
		}
		else
		{
			displayAccountingInfoToRequester = NO;
		}

		return displayAccountingInfoToRequester;
	}

	@Override
	public String getRequesterIsRequiredToProvideAccountingInfoOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String requiredAccountingInfo;
		if (ActionBot.isElementSelected(driver, REQUIRED_ACCOUNTING_INFO_YES))
		{
			requiredAccountingInfo = YES;
		}
		else
		{
			requiredAccountingInfo = NO;
		}

		return requiredAccountingInfo;
	}

	@Override
	public String getAllowRequesterToOverrideDefaultGLAccountOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String overrideDefaultGLAccount;
		if (ActionBot.isElementSelected(driver, ALLOW_OVERRIDE_GLACCOUNT_YES))
		{
			overrideDefaultGLAccount = YES;
		}
		else
		{
			overrideDefaultGLAccount = NO;
		}

		return overrideDefaultGLAccount;
	}

	@Override
	public String getRequesterRequiredToAssignBuyerOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String assignBuyer;
		if (ActionBot.isElementSelected(driver, ASSIGN_BUYER_REQUIRED))
		{
			assignBuyer = YES;
		}
		else
		{
			assignBuyer = NO;
		}

		return assignBuyer;
	}

	@Override
	public String getApplyCategoryBasedWorkflowOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String applyCategoryBasedWorkFlow;
		if (ActionBot.isElementSelected(driver, CATEGORY_BASED_WORKFLOW_YES))
		{
			applyCategoryBasedWorkFlow = YES;
		}
		else
		{
			applyCategoryBasedWorkFlow = NO;
		}

		return applyCategoryBasedWorkFlow;
	}

	@Override
	public boolean getEnableRequisitionForkingOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementSelected(driver, REQ_FORKING_YES))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public String getSplitReqTypeOption(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String reqSplitType;
		if (ActionBot.isElementSelected(driver, FORKING_CATERIA_CATEGORIES))
		{
			reqSplitType = CATEGORIES;
		}
		else if (ActionBot.isElementSelected(driver, FORKING_CATERIA_PRICE_TYPE))
		{
			reqSplitType = PRICE_TYPE;
		}
		else
		{
			reqSplitType = null;
		}

		return reqSplitType;
	}

	@Override
	public boolean clickOnSaveButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on save button");
		ActionBot.click(driver, SAVE_BUTTON);

		ScreenShot.screenshot(driver, testCaseName, "After clicking on save button");

		return ActionBot.isElementPresent(driver, SUCCESS_MSG);
	}

	@Override
	public boolean clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on cancel button");
		ActionBot.click(driver, CANCEL_BUTTON_REQ_SETTING);

		ScreenShot.screenshot(driver, testCaseName, "After clicking on cancel button");

		return ActionBot.isElementPresent(driver, SUCCESS_MSG);
	}

	@Override
	public boolean clickOnRequesterRequiredToAssignBuyer_Required(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ASSIGN_BUYER_REQUIRED);
		if (ActionBot.isElementSelected(driver, ASSIGN_BUYER_REQUIRED))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickOnRequesterRequiredToAssignBuyer_Optional(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ASSIGN_BUYER_OPTIONAL);
		if (ActionBot.isElementSelected(driver, ASSIGN_BUYER_OPTIONAL))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickOnRequesterRequiredToAssignBuyer_Hidden(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ASSIGN_BUYER_HIDDEN);
		if (ActionBot.isElementSelected(driver, ASSIGN_BUYER_HIDDEN))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnSourcingStatus_QuotedBySupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, SOURCING_STATUS_QUOTED_BY_SUPPLIER);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on sorcing status Quoted by supplier");

	}

	@Override
	public void clickOnSourcingStatus_EstimatedPrice(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, SOURCING_STATUS_ESTIMATED_PRICE);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on sorcing status Estimated price");

	}

	@Override
	public void clickOnSourcingStatus_NeedAQuote(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, SOURCING_STATUS_NEED_A_QUOTE);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on sorcing status Need a quote");

	}

	@Override
	public boolean clickOnAddDisbursementAsSettlementViaOptionYes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_ADD_DISBURSEMENT_AS_SETTLEMENT_VIA_OPTION_YES);
		return ActionBot.isElementSelected(driver, RADIO_BUTTON_ADD_DISBURSEMENT_AS_SETTLEMENT_VIA_OPTION_YES);
	}

	@Override
	public boolean clickOnAddDisbursementAsSettlementViaOptionNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_ADD_DISBURSEMENT_AS_SETTLEMENT_VIA_OPTION_NO);
		return ActionBot.isElementSelected(driver, RADIO_BUTTON_ADD_DISBURSEMENT_AS_SETTLEMENT_VIA_OPTION_NO);
	}

	@Override
	public boolean clickOnSendPOToSupplierOptionYes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_SEND_PO_TO_SUPPLIER_YES);
		if (ActionBot.isElementSelected(driver, RADIO_BUTTON_SEND_PO_TO_SUPPLIER_YES))
		{
			return true;
		}
		return false;

	}

	@Override
	public boolean clickOnSendPOToSupplierOptionNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_SEND_PO_TO_SUPPLIER_NO);
		if (ActionBot.isElementSelected(driver, RADIO_BUTTON_SEND_PO_TO_SUPPLIER_NO))
		{
			return true;
		}
		return false;

	}

	@Override
	public boolean isSendPOToSupplierOptionYesEnabled(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementEnabled(driver, RADIO_BUTTON_SEND_PO_TO_SUPPLIER_YES);
	}

	@Override
	public boolean isSendPOToSupplierOptionNoEnabled(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementEnabled(driver, RADIO_BUTTON_SEND_PO_TO_SUPPLIER_NO);
	}

	@Override
	public void clickOnQuotedBySupplierSourcingStatus(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_QUOTED_BY_SUPPLIER_SOURCING_STATUS_REQ_SETTING_PAGE);
	}

	@Override
	public void clickOnEstimatedPriceSourcingStatus(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_ESTIMATED_PRICE_SOURCING_STATUS_REQ_SETTING_PAGE);
	}

	@Override
	public void clickOnNeedAQuoteSourcingStatus(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_NEED_A_QUOTE_SOURCING_STATUS_REQ_SETTING_PAGE);
	}

	@Override
	public boolean isQuotedBySupplierSourcingStatusSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementSelected(driver, CHECKBOX_QUOTED_BY_SUPPLIER_SOURCING_STATUS_REQ_SETTING_PAGE);
	}

	@Override
	public boolean isEstimatedPriceSourcingStatusSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementSelected(driver, CHECKBOX_ESTIMATED_PRICE_SOURCING_STATUS_REQ_SETTING_PAGE);
	}

	@Override
	public boolean isNeedAQuoteSourcingStatusSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.isElementSelected(driver, CHECKBOX_NEED_A_QUOTE_SOURCING_STATUS_REQ_SETTING_PAGE);
	}

	@Override
	public boolean clickOnBuyerDefaultOption_Buyer(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUYER_DEFAULT_BUYER);
		if (ActionBot.isElementSelected(driver, BUYER_DEFAULT_BUYER))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickOnBuyerDefaultOption_BuyerGroup(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUYER_DEFAULT_BUYER_GROUP);
		if (ActionBot.isElementSelected(driver, BUYER_DEFAULT_BUYER_GROUP))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickOnPoToReqTagging_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, PO_TO_REQ_TAGGING_YES);
		if (ActionBot.isElementSelected(driver, PO_TO_REQ_TAGGING_YES))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickOnPoToReqTagging_No(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, PO_TO_REQ_TAGGING_NO);
		if (ActionBot.isElementSelected(driver, PO_TO_REQ_TAGGING_NO))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickOnAllowRequesterToSuggestSupplierForBuyersReview_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, IPageRequisitionSettings.ALLOW_REQUESTER_TO_SUGGEST_SUPPLIER_FOR_BUYER_REVIEW_YES);
		if (ActionBot.isElementSelected(driver, IPageRequisitionSettings.ALLOW_REQUESTER_TO_SUGGEST_SUPPLIER_FOR_BUYER_REVIEW_YES))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean clickOnAllowRequesterToSuggestSupplierForBuyersReview_No(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, IPageRequisitionSettings.ALLOW_REQUESTER_TO_SUGGEST_SUPPLIER_FOR_BUYER_REVIEW_NO);
		if (ActionBot.isElementSelected(driver, IPageRequisitionSettings.ALLOW_REQUESTER_TO_SUGGEST_SUPPLIER_FOR_BUYER_REVIEW_NO))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean clickOnRequiredByDateAutoCalculatedAsPerLeadTimeInCatalog_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, IPageRequisitionSettings.REQUIRED_BY_DATE_AUTO_CALCULATED_AS_LEAD_TIME_IN_CATALOG_YES);
		if (ActionBot.isElementSelected(driver, IPageRequisitionSettings.REQUIRED_BY_DATE_AUTO_CALCULATED_AS_LEAD_TIME_IN_CATALOG_YES))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean clickOnRequiredByDateAutoCalculatedAsPerLeadTimeInCatalog_No(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ActionBot.click(driver, IPageRequisitionSettings.REQUIRED_BY_DATE_AUTO_CALCULATED_AS_LEAD_TIME_IN_CATALOG_NO);
		if (ActionBot.isElementSelected(driver, IPageRequisitionSettings.REQUIRED_BY_DATE_AUTO_CALCULATED_AS_LEAD_TIME_IN_CATALOG_NO))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean allowSplitDeliveryLocationAtItemLevel_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, IPageRequisitionSettings.ALLOW_SPLIT_DELIVERY_LOCATION_AT_ITEM_LEVEL_YES);
		return ActionBot.isElementSelected(driver, IPageRequisitionSettings.ALLOW_SPLIT_DELIVERY_LOCATION_AT_ITEM_LEVEL_YES);
	}

	@Override
	public boolean allowSplitDeliveryLocationAtItemLevel_No(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, IPageRequisitionSettings.ALLOW_SPLIT_DELIVERY_LOCATION_AT_ITEM_LEVEL_NO);
		return ActionBot.isElementSelected(driver, IPageRequisitionSettings.ALLOW_SPLIT_DELIVERY_LOCATION_AT_ITEM_LEVEL_NO);
	}

	@Override
	public Integer enterQuantityToAlertUserWhenShoppingCartIsBeyondQuantity(WebDriver driver, Integer quantity) throws ActionBotException
	{
		String quantityToEnter = Integer.toString(quantity);
		ActionBot.sendKeys(driver, TEXTBOX_ALERT_USER_WHEN_SHOPPINGCART_BEYOND_QUANTITY, quantityToEnter);

		quantityToEnter = ActionBot.findElement(driver, TEXTBOX_ALERT_USER_WHEN_SHOPPINGCART_BEYOND_QUANTITY).getAttribute("value");
		return Integer.parseInt(quantityToEnter);

	}

}
