/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.ceformlisting;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 */
public class IPageCEformListingImpl implements IPageCEformListing
{
	static Logger logger = Logger.getLogger(IPageCEformListingImpl.class);

	@Override
	public void clickOnOnlineEditor(WebDriver driver, String testCaseName) throws ActionBotException
	{
		WebElement element = driver.findElement(By.xpath("//a[@class='b-button b-primary b-small mnBtnTxt']"));
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
		// ActionBot.hover(driver, BUTTON_NEW_EFORM);
		ActionBot.click(driver, BUTTON_ONLINE_EDITOR_EFORM);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Online Editor Eform");
	}

	@Override
	public void clickOnFileUpload(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.hover(driver, BUTTON_NEW_EFORM);
		ActionBot.click(driver, BUTTON_FILE_UPLOAD_EFORM);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on File Upload Eform");
	}

	@Override
	public List<WebElement> getAllCEforms(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		return ActionBot.findElements(driver, LINK_CREATED_EFORM_NAMES);
	}

	@Override
	public void clickOnDeactivateCEform(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		ActionBot.click(driver, LINK_DEACTIVATE_EFORM);
		// ActionBot.waitTillPopUpIsPresent(driver,
		// CEFORM_DEACTIVATION_SUCCESS_MSG);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on deactivate eform");
	}

	@Override
	public void clickOnDeleteCEform(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_DELETE_EFORM);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on delete eform");

	}

	@Override
	public void clickOnCopyCEform(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_COPY_CEFORM);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on copy eform");
	}

	@Override
	public void clickOnModifyCEform(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_MODIFY_CEFORM);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on modify eform");
	}

	@Override
	public String fillSearchCEform(WebDriver driver, String testCaseName, String cEformName) throws ActionBotException
	{
		String enteredSearchCEform = null;
		ActionBot.sendKeys(driver, INPUT_SEARCH_CEFORM, cEformName);
		ActionBot.findElement(driver, INPUT_SEARCH_CEFORM).sendKeys(Keys.ENTER);
		enteredSearchCEform = ActionBot.getAttributeOfElement(driver, INPUT_SEARCH_CEFORM, "value");
		logger.info("Entered ceform name for search: " + enteredSearchCEform);
		return enteredSearchCEform;
	}

	@Override
	public String selectSearchInOptionForCEform(WebDriver driver, String testCaseName, int searchInOptionIndex)
			throws ActionBotException
	{
		String searchInOption = ActionBot.selectElement(driver, SELECT_SEARCH_IN_FOR_CEFORM,
				IConstantsData.SELECT_BY_INDEX, Integer.toString(searchInOptionIndex));
		logger.info("Selected Search In Option : " + searchInOption);
		return searchInOption;
	}

	@Override
	public String getStatusOfFirstCEform(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String status = ActionBot.getTextWithInElement(driver, LABEL_STATUS_OF_CEFORM);
		logger.info("Status of CEform : " + status);
		return status;
	}

	/**
	 * @author Rohini Shinge
	 */
	@Override
	public boolean isFillSearchCEformPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean isPresent = ActionBot.isElementPresent(driver, INPUT_SEARCH_CEFORM);
		logger.info("is FillSearchTextBox present : " + isPresent);
		return isPresent;
	}

	/**
	 * @author Rohini Shinge
	 */
	@Override
	public void clickOnActivateCEform(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, LINK_ACTIVATE_EFORM);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on activate eform");
	}

	/**
	 * @author Rohini Shinge
	 */
	@Override
	public void clickOnUpdateCEform(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_UPDATE_CEFORM);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on update eform");

	}

	/**
	 * @author Rohini Shinge
	 */
	@Override
	public void clickOnExportCEform(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_EXPORT_CEFORM);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on export eform");
	}

}
