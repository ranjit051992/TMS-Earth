package com.zycus.automation.eproc.pageobjects.modals.forkingCommentsForSupplier;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IModelCommentsForSupplierImpl implements IModelCommentsForSupplier
{

	@Override
	public void clickCancleCommentsForSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		ActionBot.click(driver, FORKING_CANCLE_SUPPLIER_COMMENT);
		ScreenShot.screenshot(driver, testCaseName, "Cancle Supplier Comment");
	}

	@Override
	public void clickSaveCommentsForSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		// TODO Auto-generated method stub
		ActionBot.click(driver, FORKING_SAVE_SUPPLIER_COMMENT);
		ScreenShot.screenshot(driver, testCaseName, "Save Supplier Comment");
	}

	@Override
	public String provideCommentsForSupplier(WebDriver driver, String testCaseName, String supplierComment) throws ActionBotException
	{
		// TODO Auto-generated method stub
		WebElement ele = ActionBot.findElement(driver, FORKINH_SUPPLIER_COMMENT_TEXT);
		ele.sendKeys(supplierComment);
		if (ele.getAttribute("value") != null)
		{
			return ele.getAttribute("value");
		}
		else
		{
			return null;
		}
	}

}
