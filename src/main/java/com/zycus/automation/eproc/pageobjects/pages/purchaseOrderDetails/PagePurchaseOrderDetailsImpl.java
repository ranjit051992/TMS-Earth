package com.zycus.automation.eproc.pageobjects.pages.purchaseOrderDetails;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

public class PagePurchaseOrderDetailsImpl implements IPagePurchaseOrderDetails

{

	@Override
	public void clickOnCostBookingLink(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, COSTBOOKING_LINK);

	}

	@Override
	public String getProjectTaskName(WebDriver driver) throws ActionBotException
	{
		return ActionBot.findElement(driver, PROJECT_TASK_FIELD).getText();
	}

	@Override
	public String getCatalogItemName(WebDriver driver, String testCasename, int index) throws ActionBotException
	{

		return null;
	}

	@Override
	public void clickOnCatalogItem(WebDriver driver, String testCasename, int index) throws ActionBotException
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void clickOnReqLink(WebDriver driver, String testCasename) throws ActionBotException
	{
		ActionBot.click(driver, REQ_LINK);
		ActionBot.defaultLowSleep();
	}

	@Override
	public boolean veirfyOpenedRequisitionDetailsNewWindow(WebDriver driver, String testCasename, String parentWindow) throws ActionBotException
	{
		boolean flag = false;
		// Switch to new window opened
		for (String chString : driver.getWindowHandles())
		{
			driver.switchTo().window(chString);
		}
		ActionBot.defaultLowSleep();
		flag = ActionBot.isElementDisplayed(driver, IS_REQUISITION_DETAILS_POPUP_WINDOW);
		driver.close();
		driver.switchTo().window(parentWindow);

		return flag;
	}

	@Override
	public String getCommentForSupplier(WebDriver driver) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, COMMENT_FOR_SUPPLIER);
	}

	@Override
	public boolean isCommentForSupplierAvailable(WebDriver driver) throws ActionBotException
	{
		return ActionBot.isElementDisplayed(driver, COMMENT_FOR_SUPPLIER);
	}

	@Override
	public boolean isAllItemsAvailable(WebDriver driver, int item_count) throws ActionBotException
	{
		boolean status = false;
		if (ActionBot.findElements(driver, ITEMS_PO_LINK).size() == item_count)
			status = true;
		return status;
	}
}
