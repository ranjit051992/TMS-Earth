package com.zycus.automation.eproc.pageobjects.modals.requisitionStatusfilters;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IModalRequisitionFilterImpl extends IModalRequisitionFilterUtil implements IModalRequisitionFilter
{

	@Override
	public boolean clickToApplyDraftFilter(WebDriver driver, String testCaseName) throws ActionBotException
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
	public boolean clickToApplyReadyForApprovalFilter(WebDriver driver, String testCaseName) throws ActionBotException
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
	public boolean clickToApplyInApprovalFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String screenshotName = "In approval";
		if (isFilterSelected(driver, IN_APPROVAL_FILTER))
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
	public boolean clickToApplyWithBuyerFilter(WebDriver driver, String testCaseName) throws ActionBotException
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
	public boolean clickToApplyScheduledFilter(WebDriver driver, String testCaseName) throws ActionBotException
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
	public boolean clickToApplyReleasedFilter(WebDriver driver, String testCaseName) throws ActionBotException
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
	public boolean clickToApplyPartiallyOrderedFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
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
	public boolean clickToApplyFullyReceivedFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
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
	public boolean clickToApplyRejectedFilter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String screenshotName = "rejected";
		if (isFilterSelected(driver, REJECTED_FILTER))
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
	public boolean clickToApplyClosedFilter(WebDriver driver, String testCaseName) throws ActionBotException
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
	public boolean clickToApplyCancelledFilter(WebDriver driver, String testCaseName) throws ActionBotException
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
	public boolean clickToApplyReturnedWithQouteFilter(WebDriver driver, String testCaseName) throws ActionBotException
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
	public boolean clickToApplySetForQuoteFilter(WebDriver driver, String testCaseName) throws ActionBotException
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

}
