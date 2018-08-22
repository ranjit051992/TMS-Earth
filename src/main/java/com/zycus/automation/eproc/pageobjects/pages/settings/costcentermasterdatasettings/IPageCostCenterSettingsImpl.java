package com.zycus.automation.eproc.pageobjects.pages.settings.costcentermasterdatasettings;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPageCostCenterSettingsImpl implements IPageCostCenterSettings
{
	static Logger logger = Logger.getLogger(IPageCostCenterSettingsImpl.class);

	@Override
	public String fillSearchCostCenter(WebDriver driver, String testCaseName, String search) throws ActionBotException
	{
		ActionBot.findElement(driver, SEARCHBOX_CC).sendKeys(search);
		return search;

	}

	@Override
	public void clickOnGoBtn(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, GO_BTN_CC);
		ActionBot.defaultSleep();
	}

	@Override
	public void clickOnActiveCCLin(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CC_ACTIVE);

	}

	@Override
	public void clickOnDeActiveCCLin(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, LINK_CC_DEACTIVE);

	}

	@Override
	public String selectSearchCCIn(WebDriver driver, String testCaseName, String selectCCIn) throws ActionBotException
	{
		String selectedCCIn = ActionBot.selectElement(driver, SELECT_SEARCH_CC_IN, IConstantsData.SELECT_BY_VISIBLE_TEXT, selectCCIn);
		return selectedCCIn;
	}

	@Override
	public void clickOnEditCC(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_EDIT_CC_IN_MASTER_DATA);
	}

	@Override
	public void clickOnAllSelectedBUsLink(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_ALL_SELECTED_BU_FOR_CC);
	}

	@Override
	public String getFirstCostCenterSearched(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String cc = ActionBot.getTextWithInElement(driver, LABEL_FIRST_COST_CENTER_SEARCHED);
		logger.info("Searched Cost Center : " + cc);
		return cc;
	}

	@Override
	public void clickOnUpdateCostCenter(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on update cost center");
		ActionBot.click(driver, BUTTON_UPDATE_COST_CENTER);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on update cost center");
	}

	@Override
	public void clickOnImportCCViaFiles(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_IMPORT_CC_VIA_FILE);
	}

	@Override
	public String fillFileName(WebDriver driver, String testCaseName, String fileName) throws ActionBotException
	{
		ActionBot.sendKeys(driver, FILE_UPLOAD_COST_CENTERS, fileName);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
		return fileName;
	}

	@Override
	public void clickOnUploadCCButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before uploading CC");
		ActionBot.click(driver, BUTTON_UPLOAD_CC_FILES);
		ScreenShot.screenshot(driver, testCaseName, "After uploading CC");
	}

}
