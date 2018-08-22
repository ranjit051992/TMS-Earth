package com.zycus.automation.eproc.pageobjects.pages.settings.documentinformationsettings;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPageDocumentInformationSettingsImpl implements IPageDocumentInformationSettings
{
	static Logger logger = Logger.getLogger(IPageDocumentInformationSettingsImpl.class);

	@Override
	public void clickOnRequisitionInfo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_REQUISITION_INFO);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on req info");

	}

	@Override
	public void clickOnPOInfo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_PO_INFO);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on PO info");

	}

	@Override
	public String fillPODetailsTemplate(WebDriver driver, String testCaseName, String detailsTemplate) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, TEXTBOX_PO_DETAILS_TEMPLATE);
		ele.clear();
		ele.sendKeys(detailsTemplate);
		ActionBot.defaultSleep();
		String str = ele.getAttribute("value");
		return str;
	}

	@Override
	public String fillPOItemRowTemplate(WebDriver driver, String testCaseName, String itemRowTemplate) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, TEXTBOX_PO_ITEM_ROW_TEMPLATE);
		ele.clear();
		ele.sendKeys(itemRowTemplate);
		ActionBot.defaultSleep();
		String str = ele.getAttribute("value");
		return str;
	}

	@Override
	public void clickOnSave(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SAVE_DOCUMENT_INFORMATION);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on save button");

	}

	@Override
	public String getDetailsTemplate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String detailsTemplate = ActionBot.getTextWithInElement(driver, TEXTBOX_PO_DETAILS_TEMPLATE);
		logger.info("Details Template : " + detailsTemplate);
		return detailsTemplate;
	}

	@Override
	public String getItemRowTemplate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String itemRowTemplate = ActionBot.getAttributeOfElement(driver, TEXTBOX_PO_ITEM_ROW_TEMPLATE, "value");
		logger.info("Item Row Template : " + itemRowTemplate);
		return itemRowTemplate;
	}

}
