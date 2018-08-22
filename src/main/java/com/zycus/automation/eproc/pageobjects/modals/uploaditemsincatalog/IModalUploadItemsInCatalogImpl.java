/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.uploaditemsincatalog;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * @author ankita.sawant
 *
 */
public class IModalUploadItemsInCatalogImpl implements IModalUploadItemsInCatalog
{
	static Logger logger = Logger.getLogger(IModalUploadItemsInCatalogImpl.class);

	@Override
	public void clickOnUploadItemsViaFileButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_UPLOAD_ITEMS_VIA_FILE);
	}

	@Override
	public String fillFileName(WebDriver driver, String testCaseName, String fileName) throws Exception
	{
		WebElement element = ActionBot.getElement(driver, INPUT_UPLOAD_ITEMS);
		element.sendKeys(fileName);
		logger.info("Uploaded file name : " + fileName);
		return fileName;
	}

	@Override
	public void clickOnUploadCatalogButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_UPLOAD_CATALOG);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
		ActionBot.click(driver, BUTTON_MAP_CATALOG_COLUMNS_OK);
		ActionBot.waitTillPopUpIsPresent(driver, CATALOG_UPLOAD_PROCESSING_DIV);
		ActionBot.defaultHighSleep();
	}

	@Override
	public void clickOnCancelCatalogButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CANCEL_CATALOG);
		ActionBot.waitForPageLoad(driver);
	}

}
