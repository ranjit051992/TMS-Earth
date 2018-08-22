/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.peformlisting;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IPagePEformListingImpl implements IPagePEformListing
{
	static Logger logger = Logger.getLogger(IPagePEformListingImpl.class);

	@Override
	public List<WebElement> getListOfPEformNames(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		return ActionBot.findElements(driver, LINK_CREATED_PEFORM_NAMES);
	}

	@Override
	public void clickOnDeactivatePEformLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeEnable(driver, LINK_DEACTIVATE_PEFORM, 30);
		WebElement ele = ActionBot.findElement(driver, LINK_DEACTIVATE_PEFORM);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", ele);
		// ActionBot.click(driver, LINK_DEACTIVATE_PEFORM);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Deactivate Link");
	}

	@Override
	public void clickOnDeletePEformLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.waitForElementToBeEnable(driver, LINK_DELETE_PEFORM, 30);
		// ActionBot.click(driver, LINK_DELETE_PEFORM);
		WebElement ele = ActionBot.findElement(driver, LINK_DELETE_PEFORM);
		((JavascriptExecutor) driver).executeScript("arguments[0].click()", ele);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Delete Link");
	}

	@Override
	public void clickOnModifyPEformLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, LINK_MODIFY_PEFORM);
		ActionBot.click(driver, LINK_MODIFY_PEFORM);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Modify Link");
	}

	@Override
	public void clickOnUpdatePEformLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, LINK_UPDATE_PEFORM);
		ActionBot.click(driver, LINK_UPDATE_PEFORM);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Update Link");
	}

	@Override
	public void clickOnCopyPEformLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, LINK_COPY_PEFORM);
		ActionBot.click(driver, LINK_COPY_PEFORM);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Copy Link");
	}

	@Override
	public void clickOnExportPEformLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.moveToElement(driver, LINK_EXPORT_PEFORM);
		ActionBot.click(driver, LINK_EXPORT_PEFORM);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Export Link");
	}

	@Override
	public String fillSearchPEform(WebDriver driver, String testCaseName, String pEformName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_SEARCH_PEFORM, pEformName);
		ActionBot.findElement(driver, TEXTBOX_SEARCH_PEFORM).sendKeys(Keys.ENTER);
		String enteredPEformName = ActionBot.getAttributeOfElement(driver, TEXTBOX_SEARCH_PEFORM, "value");
		logger.info("Entered PEForm Name : " + enteredPEformName);
		return enteredPEformName;
	}

	@Override
	public String getStatusOFFirstPEForm(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String status = ActionBot.getTextWithInElement(driver, LABEL_STATUS_OF_PEFORM);
		logger.info("Status of PEform : " + status);
		return status;
	}

}
