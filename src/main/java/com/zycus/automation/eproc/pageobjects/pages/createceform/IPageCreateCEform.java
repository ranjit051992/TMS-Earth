/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.createceform;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.CEform;
import com.zycus.automation.bo.PEform;
import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPageCreateCEform
{
	static UI_Elements	TEXTBOX_CFORM_NAME						= UIFactory.getElements("TEXTBOX_CFORM_NAME");
	static UI_Elements	TEXTBOX_CFORM_DISPLAY_NAME				= UIFactory.getElements("TEXTBOX_CFORM_DISPLAY_NAME");
	static UI_Elements	LINK_SELECT_CATEGORIES_FOR_CFORM		= UIFactory.getElements("LINK_SELECT_CATEGORIES_FOR_CFORM");
	static UI_Elements	LINK_SELECT_OU_FOR_CFORM				= UIFactory.getElements("LINK_SELECT_OU_FOR_CFORM");
	static UI_Elements	BUTTON_SAVE_AND_CONTINUE_CFORM_DETAILS	= UIFactory.getElements("BUTTON_SAVE_AND_CONTINUE_CFORM_DETAILS");
	static UI_Elements	LINK_ADD_SECTION_TO_CFORM				= UIFactory.getElements("LINK_ADD_SECTION_TO_CFORM");
	static UI_Elements	LINK_ADD_FIELD_CEFORM					= UIFactory.getElements("LINK_ADD_FIELD_CEFORM");
	static UI_Elements	BUTTON_PUBLISH_CEFORM					= UIFactory.getElements("BUTTON_PUBLISH_CEFORM");
	static UI_Elements	BUTTON_SAVE_CEFORM						= UIFactory.getElements("BUTTON_SAVE_CEFORM");
	static UI_Elements	BUTTON_PREVIEW_CEFORM					= UIFactory.getElements("BUTTON_PREVIEW_CEFORM");
	static UI_Elements	BUTTON_CANCEL_CFORM						= UIFactory.getElements("BUTTON_CANCEL_CFORM");
	static UI_Elements	LABEL_ADDED_CEFORM_SECTION_NAME			= UIFactory.getElements("LABEL_ADDED_CEFORM_SECTION_NAME");
	static UI_Elements	LABEL_ADDED_CEFORM_FIELD_NAME			= UIFactory.getElements("LABEL_ADDED_CEFORM_FIELD_NAME");
	static UI_Elements	LABEL_ADDED_CEFORM_FIELD_VALUE_NAME		= UIFactory.getElements("LABEL_ADDED_CEFORM_FIELD_VALUE_NAME");

	static UI_Elements	IMPORT_CEFORM_BUTTON					= UIFactory.getElements("IMPORT_CEFORM_BUTTON");

	static UI_Elements	BUTTON_SELECT_FILE_FOR_CEFORM			= UIFactory.getElements("BUTTON_SELECT_FILE_FOR_CEFORM");
	static UI_Elements	INVALID_FILETYPE_ERROR					= UIFactory.getElements("INVALID_FILETYPE_ERROR");
	static UI_Elements	EFORM_CLICK_FIRST_EFORM_LINK			= UIFactory.getElements("EFORM_CLICK_FIRST_EFORM_LINK");
	static UI_Elements	FILE_UPLOAD_EFORM						= UIFactory.getElements("FILE_UPLOAD_EFORM");

	public String fillCFormName(WebDriver driver, String testCaseName, String cformName) throws ActionBotException;

	public String fillCFormDisplayName(WebDriver driver, String testCaseName, String cformDisplayName) throws ActionBotException;

	public void clickOnLinkSelectCategoriesForCForm(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnLinkSelectOUForCForm(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSaveAndContinue(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddSectionLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddFieldLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnPublishCEformButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSaveCEformButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnPreviewCEformButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelCEformButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSectionName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFieldName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTagNameOfFieldValue(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean verifySectionName(WebDriver driver, String testCaseName, String sectionName) throws ActionBotException;

	public boolean verifyTextField(WebDriver driver, String testCaseName, String textFieldName, int labelNumber, int noOfTextFields) throws ActionBotException;

	public boolean verifyTextArea(WebDriver driver, String testCaseName, String textAreaName, int labelNumber, int textAreaNumber) throws ActionBotException;

	public boolean verifyCheckBoxDetails(WebDriver driver, String testCaseName, String fieldName, int labelNumber, List<String> checkBoxChoiceslist) throws ActionBotException;

	public PEform getFileUploadedPEformDetails(WebDriver driver, String testCaseName, PEform pEform) throws ActionBotException;

	public CEform getFileUploadedCEformDetails(WebDriver driver, String testCaseName, CEform cEform) throws ActionBotException;

	public void clickOnImportCEformButton(WebDriver driver, String testCaseName);

	public void selectFileForCeformUpload(WebDriver driver, String testCaseName);

	public void clickOnLogoUpload(WebDriver driver, String testCaseName);

	void selectFileForCeformUpload(WebDriver driver, String testCaseName, String attachmentFileName);

}
