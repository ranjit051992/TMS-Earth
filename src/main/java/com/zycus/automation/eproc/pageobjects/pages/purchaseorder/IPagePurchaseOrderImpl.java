package com.zycus.automation.eproc.pageobjects.pages.purchaseorder;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPagePurchaseOrderImpl implements IPagePurchaseOrder
{

	static Logger logger = Logger.getLogger(IPagePurchaseOrderImpl.class);

	@Override
	public void clickOnEditLink(WebDriver driver, String testCaseName) throws Exception
	{
		ScreenShot.screenshot(driver, testCaseName, "Purchase Order Edit Link");
		ActionBot.click(driver, PURCHASE_ORDER_BILLING_EDIT_LINK);
	}

}
