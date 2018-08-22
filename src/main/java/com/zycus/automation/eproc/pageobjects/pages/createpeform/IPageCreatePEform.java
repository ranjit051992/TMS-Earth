/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.createpeform;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPageCreatePEform
{
	static UI_Elements	TEXTBOX_PROCESS_EFORM_NAME				= UIFactory.getElements("TEXTBOX_PROCESS_EFORM_NAME");
	static UI_Elements	SELECT_PROCESS_FOR_PEFORM				= UIFactory.getElements("SELECT_PROCESS_FOR_PEFORM");
	static UI_Elements	LINK_SELECT_OU_FOR_PEFORM				= UIFactory.getElements("LINK_SELECT_OU_FOR_PEFORM");
	static UI_Elements	SELECT_PURCHASE_TYPE_FOR_PEFORM			= UIFactory.getElements("SELECT_PURCHASE_TYPE_FOR_PEFORM");
	static UI_Elements	BUTTON_SAVE_PEFORM_DETAILS				= UIFactory.getElements("BUTTON_SAVE_PEFORM_DETAILS");
	static UI_Elements	BUTTON_CANCEL_PEFORM_DETAILS			= UIFactory.getElements("BUTTON_CANCEL_PEFORM_DETAILS");
	static UI_Elements	BUTTON_SAVE_PEFORM_AS_DRAFT				= UIFactory.getElements("BUTTON_SAVE_PEFORM_AS_DRAFT");
	static UI_Elements	BUTTON_PREVIEW_PEFORM					= UIFactory.getElements("BUTTON_PREVIEW_PEFORM");
	static UI_Elements	LABEL_ADDED_SECTION_NAME_ON_FORM_FIELDS	= UIFactory.getElements("LABEL_ADDED_SECTION_NAME_ON_FORM_FIELDS");
	static UI_Elements	LABEL_ADDED_FIELD_NAME_ON_FORM_FIELDS	= UIFactory.getElements("LABEL_ADDED_FIELD_NAME_ON_FORM_FIELDS");
	static UI_Elements	INPUT_ADDED_FIELD_VALUE_ON_FORM_FIELDS	= UIFactory.getElements("INPUT_ADDED_FIELD_VALUE_ON_FORM_FIELDS");
	static UI_Elements	INVALID_FILETYPE_ERROR					= UIFactory.getElements("INVALID_FILETYPE_ERROR");
	//client specific- QTS
	static UI_Elements	UPLOAD_EFORM_NAME						= UIFactory.getElements("UPLOAD_EFORM_NAME");
	static UI_Elements	BUTTON_SELECT_FILE						= UIFactory.getElements("BUTTON_SELECT_FILE");
	static UI_Elements	IMPORT_PEFORM_BUTTON					= UIFactory.getElements("IMPORT_PEFORM_BUTTON");
	static UI_Elements	EFORM_CLICK_FIRST_EFORM_LINK			= UIFactory.getElements("EFORM_CLICK_FIRST_EFORM_LINK");

	public String fillPEformName(WebDriver driver, String testCaseName, String peformName) throws ActionBotException;

	public String selectProcessForPEform(WebDriver driver, String testCaseName, String processName) throws ActionBotException;

	public void clickOnSelectOU(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectPurhcaseTypeForPEform(WebDriver driver, String testCaseName, String purchaseType) throws ActionBotException;

	public void clickOnSavePEformButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelPEformButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSaveAsDraftButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnPreviewButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getPEformName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSelectedProcessFoePEform(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSelectedPurchaseTypeForPEform(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAddedSectionName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getAddedFieldName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTagOFAddedFieldValue(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFileUploadedPEformName(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectFile(WebDriver driver, String testCaseName) throws ActionBotException, Exception;

	public void clickOnImportButton(WebDriver driver, String testCaseName) throws ActionBotException;

	void selectFile(WebDriver driver, String testCaseName, String attachmentFileName) throws Exception;
}
