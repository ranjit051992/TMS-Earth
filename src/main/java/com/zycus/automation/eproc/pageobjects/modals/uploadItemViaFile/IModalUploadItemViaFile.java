package com.zycus.automation.eproc.pageobjects.modals.uploadItemViaFile;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModalUploadItemViaFile
{
	final static UI_Elements	TEXTBOX_ITEM_FILE_ULOAD								= UIFactory.getElements("TEXTBOX_ITEM_FILE_ULOAD");

	final static UI_Elements	BUTTON_UPLOAD_ITEM_FILE								= UIFactory.getElements("BUTTON_UPLOAD_ITEM_FILE");

	final static UI_Elements	ERROR_INVALID_DATA_ON_UPLOAD_ITEM_VIA_FILE			= UIFactory.getElements("ERROR_INVALID_DATA_ON_UPLOAD_ITEM_VIA_FILE");
	final static UI_Elements	BUTTON_CLOSE_ERROR_DETAILS_ON_UPLOAD_DATA_VIA_FILE	= UIFactory.getElements("BUTTON_CLOSE_ERROR_DETAILS_ON_UPLOAD_DATA_VIA_FILE");
	final static UI_Elements	BLANK_LINE_NUMBER_ERROR								= UIFactory.getElements("BLANK_LINE_NUMBER_ERROR");

	public String enterFilePath(WebDriver driver, String testCaseName, String filePath) throws ActionBotException, Exception;

	public void clickOnUploadFile(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isErrorDetailsOfValidationOfDataPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCloseErrorDetails(WebDriver driver, String testCaseName) throws ActionBotException;

	//check for blank item error
	public boolean isBlankLineNumberErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException;
}
