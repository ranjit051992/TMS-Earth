package com.zycus.automation.eproc.pageobjects.modals.myrequisitionstatusfilters;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IModalMyRequisitionStatusFiltersImpl extends IModalMyRequisitionStatusFiltersUtil implements IModalMyRequisitionStatusFilters
{

	@Override
	public boolean clickOnApplyDraftFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String screenshotName = "draft";
		if (isFilterSelected(driver, DRAFT_FILTER))
		{
			ScreenShot.screenshot(driver, testCaseName, "click To Apply " + screenshotName + " Filter true");
			return true;
		}
		else
		{
			ScreenShot.screenshot(driver, testCaseName, screenshotName + "filter false");
			return false;
		}
	}

	@Override
	public boolean clickOnApplyReadyForApprovalFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String screenshotName = "ready for for approval";
		if (isFilterSelected(driver, READY_FOR_APPROVAL_FILTER))
		{
			ScreenShot.screenshot(driver, testCaseName, "click To Apply " + screenshotName + " Filter true");
			return true;
		}
		else
		{
			ScreenShot.screenshot(driver, testCaseName, screenshotName + "filter false");
			return false;
		}
	}

	@Override
	public boolean clickOnApplyInApprovalFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, IN_PROCESS_EXPAND);

		String screenshotName = "In approval";
		if (isFilterSelected(driver, IN_APPROVAL_FILTER))
		{

			ScreenShot.screenshot(driver, testCaseName, "applied filter " + screenshotName + " Filter true");
			return true;
		}
		else
		{
			ScreenShot.screenshot(driver, testCaseName, screenshotName + "filter false");
			return false;
		}
	}

	@Override
	public boolean clickOnApplyWithBuyerFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String screenshotName = "with buyer";
		if (isFilterSelected(driver, WITH_BUYER_FILTER))
		{

			ScreenShot.screenshot(driver, testCaseName, "click To Apply " + screenshotName + " Filter true");
			return true;
		}
		else
		{
			ScreenShot.screenshot(driver, testCaseName, screenshotName + "filter false");
			return false;
		}
	}

	@Override
	public boolean clickOnApplyReturnForAmendmentFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String screenshotName = "Return for Amendment";
		if (isFilterSelected(driver, RETURNED_FOR_AMENDMENT))
		{

			ScreenShot.screenshot(driver, testCaseName, "click To Apply " + screenshotName + " Filter true");
			return true;
		}
		else
		{
			ScreenShot.screenshot(driver, testCaseName, screenshotName + "filter false");
			return false;
		}
	}

	@Override
	public boolean clickOnApplyScheduledFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String screenshotName = "scheduled";
		if (isFilterSelected(driver, SCHEDULED_FILTER))
		{

			ScreenShot.screenshot(driver, testCaseName, "click To Apply " + screenshotName + " Filter true");
			return true;
		}
		else
		{
			ScreenShot.screenshot(driver, testCaseName, screenshotName + "filter false");
			return false;
		}
	}

	@Override
	public boolean clickOnApplyReleasedFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String screenshotName = "released";
		if (isFilterSelected(driver, RELEASED_FILTER))
		{

			ScreenShot.screenshot(driver, testCaseName, "click To Apply " + screenshotName + " Filter true");
			return true;
		}
		else
		{
			ScreenShot.screenshot(driver, testCaseName, screenshotName + "filter false");
			return false;
		}
	}

	@Override
	public boolean clickOnApplyPartiallyOrderedFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		clickOnExpandReleasedBtn(driver, testCaseName);
		String screenshotName = "partially ordered";
		if (isFilterSelected(driver, PARTIALLY_ORDERED))
		{

			ScreenShot.screenshot(driver, testCaseName, "click To Apply " + screenshotName + " Filter true");
			return true;
		}
		else
		{
			ScreenShot.screenshot(driver, testCaseName, screenshotName + "filter false");
			return false;
		}
	}

	@Override
	public boolean clickOnApplyFullyReceivedFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		clickOnExpandReleasedBtn(driver, testCaseName);
		String screenshotName = "fully received";
		if (isFilterSelected(driver, FULLY_RECEIVED_FILTER))
		{

			ScreenShot.screenshot(driver, testCaseName, "click To Apply " + screenshotName + " Filter true");
			return true;
		}
		else
		{
			ScreenShot.screenshot(driver, testCaseName, screenshotName + "filter false");
			return false;
		}
	}

	@Override
	public boolean clickOnApplyRejectedFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String screenshotName = "rejected";
		if (isFilterSelected(driver, REJECTED_FILTER))
		{

			ScreenShot.screenshot(driver, testCaseName, "click To Apply " + screenshotName + " Filter true");
			return true;
		}
		else
		{
			ActionBot.click(driver, REJECTED_FILTER);
			ScreenShot.screenshot(driver, testCaseName, screenshotName + "filter false");
			return false;
		}
	}

	@Override
	public boolean clickOnApplyClosedFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String screenshotName = "closed";
		if (isFilterSelected(driver, CLOSED_FILTER))
		{

			ScreenShot.screenshot(driver, testCaseName, "click To Apply " + screenshotName + " Filter true");
			return true;
		}
		else
		{
			ScreenShot.screenshot(driver, testCaseName, screenshotName + "filter false");
			return false;
		}
	}

	@Override
	public boolean clickOnApplyCancelledFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String screenshotName = "Cancelled";
		if (isFilterSelected(driver, CANCELLED_FILTER))
		{

			ScreenShot.screenshot(driver, testCaseName, "click To Apply " + screenshotName + " Filter true");
			return true;
		}
		else
		{
			ScreenShot.screenshot(driver, testCaseName, screenshotName + "filter false");
			return false;
		}
	}

	@Override
	public boolean clickOnApplyReturnedWithQouteFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String screenshotName = "click To Apply Returned With Qoute";
		if (isFilterSelected(driver, RETURNED_WITH_QUOTE_FILTER))
		{

			ScreenShot.screenshot(driver, testCaseName, screenshotName + " Filter true");
			return true;
		}
		else
		{
			ScreenShot.screenshot(driver, testCaseName, screenshotName + "filter false");
			return false;
		}
	}

	@Override
	public boolean clickOnApplySetForQuoteFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String screenshotName = "click To Apply Set For Quote";
		if (isFilterSelected(driver, SET_FOR_OUOTE_FILTER))
		{

			ScreenShot.screenshot(driver, testCaseName, screenshotName + " true");
			return true;
		}
		else
		{
			ScreenShot.screenshot(driver, testCaseName, screenshotName + " false");
			return false;
		}
	}

	@Override
	public void clickOnCancelBtn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CANCEL_BTN_STATUS_FILTER);

	}

	@Override
	public void clickOnFilterBtn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, FILTER_BTN);

	}

	@Override
	public void clickOnClearFilterBtn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CLEAR_FILTER_BTN);

	}

	@Override
	public void clickOnExpandReleasedBtn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, EXPAND_RELEASED_BTN);

	}

	@Override
	public boolean clickOnApplyNotReceivedFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		clickOnExpandReleasedBtn(driver, testCaseName);
		String screenshotName = "Click To Apply Not Received Filter";
		if (isFilterSelected(driver, NOT_RECEIVED_FILTER))
		{

			ScreenShot.screenshot(driver, testCaseName, screenshotName + " true");
			return true;
		}
		else
		{
			ScreenShot.screenshot(driver, testCaseName, screenshotName + " false");
			return false;
		}
	}

	@Override
	public boolean clickOnApplyPartiallyReceivedFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		clickOnExpandReleasedBtn(driver, testCaseName);
		String screenshotName = "Click To Apply Not Received Filter";
		if (isFilterSelected(driver, PARTIALLY_RECEIVED_FILTER))
		{

			ScreenShot.screenshot(driver, testCaseName, screenshotName + " true");
			return true;
		}
		else
		{
			ScreenShot.screenshot(driver, testCaseName, screenshotName + " false");
			return false;
		}
	}

	@Override
	public void clickOnTransferredToMeCheckbox(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_TRANSFERRED_TO_ME_FILTER);
	}

}
