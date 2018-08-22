package com.zycus.automation.eproc.pageobjects.tabs.freeTextFrom_ItemDetails_Tab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

public class ITabsItemDetailsTabImpl extends ITabsItemDetailsTabUtil implements ITabsItemDetailsTab
{

	@Override
	public void toClickItemTab(WebDriver driver, String testcaseName, String itemID) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='guidedItemContainer_" + itemID + "']//*/a[@href='#guidedItemDetails']"));

	}

	@Override
	public void toClickRequirementDetailsTab(WebDriver driver, String testcaseName, String itemID) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='guidedItemContainer_" + itemID + "']//*/a[@href='#guidedEformDetails']"));

	}

	@Override
	public void toClickSuppliersTab(WebDriver driver, String testcaseName, String itemID) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='guidedItemContainer_" + itemID + "']//*/a[@href='#guidedItemSuppliers']/span"));

	}

}
