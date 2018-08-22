package com.zycus.automation.eproc.pageobjects.modals.uploadItemViaFile;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IModalUploadItemViaFileImpl implements IModalUploadItemViaFile
{

	@Override
	public String enterFilePath(WebDriver driver, String testCaseName, String filePath) throws Exception
	{
		WebElement ele = ActionBot.getElement(driver, TEXTBOX_ITEM_FILE_ULOAD);
		System.out.println(TEXTBOX_ITEM_FILE_ULOAD.getBy().toString());
		ele.sendKeys(filePath);
		ActionBot.defaultSleep();
		return filePath;

	}

	@Override
	public void clickOnUploadFile(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_UPLOAD_ITEM_FILE);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on upload file");

	}

	@Override
	public boolean isErrorDetailsOfValidationOfDataPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, ERROR_INVALID_DATA_ON_UPLOAD_ITEM_VIA_FILE))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnCloseErrorDetails(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CLOSE_ERROR_DETAILS_ON_UPLOAD_DATA_VIA_FILE);
		ScreenShot.screenshot(driver, testCaseName, "After closing error details modal of data validation on upload item via file");

	}

	//check for blank item error
	@Override
	public boolean isBlankLineNumberErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		try
		{
			return ActionBot.getTextWithInElement(driver, BLANK_LINE_NUMBER_ERROR).equalsIgnoreCase(IConstantsData.Line_No_cannot_be_empty);
		}
		catch (Exception exception)
		{
			exception.printStackTrace();
		}
		return false;
	}

}
