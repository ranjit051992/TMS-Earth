/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.ceformlisting;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPageCEformListing
{
	static UI_Elements	BUTTON_NEW_EFORM					= UIFactory.getElements("BUTTON_NEW_EFORM");
	static UI_Elements	BUTTON_ONLINE_EDITOR_EFORM			= UIFactory.getElements("BUTTON_ONLINE_EDITOR_EFORM");
	static UI_Elements	BUTTON_FILE_UPLOAD_EFORM			= UIFactory.getElements("BUTTON_FILE_UPLOAD_EFORM");
	static UI_Elements	LINK_CREATED_EFORM_NAMES			= UIFactory.getElements("LINK_CREATED_EFORM_NAMES");
	static UI_Elements	LINK_DEACTIVATE_EFORM				= UIFactory.getElements("LINK_DEACTIVATE_EFORM");
	static UI_Elements	LINK_ACTIVATE_EFORM					= UIFactory.getElements("LINK_ACTIVATE_EFORM");
	static UI_Elements	LINK_DELETE_EFORM					= UIFactory.getElements("LINK_DELETE_EFORM");
	static UI_Elements	CEFORM_DEACTIVATION_SUCCESS_MSG		= UIFactory.getElements("CEFORM_DEACTIVATION_SUCCESS_MSG");
	static UI_Elements	SUCCESS_MSG_FOR_EFORM_CREATION		= UIFactory.getElements("SUCCESS_MSG_FOR_EFORM_CREATION");
	static UI_Elements	INPUT_SEARCH_CEFORM					= UIFactory.getElements("INPUT_SEARCH_CEFORM");
	static UI_Elements	SELECT_SEARCH_IN_FOR_CEFORM			= UIFactory.getElements("SELECT_SEARCH_IN_FOR_CEFORM");
	static UI_Elements	LINK_COPY_CEFORM					= UIFactory.getElements("LINK_COPY_CEFORM");
	static UI_Elements	LINK_MODIFY_CEFORM					= UIFactory.getElements("LINK_MODIFY_CEFORM");
	static UI_Elements	LABEL_STATUS_OF_CEFORM				= UIFactory.getElements("LABEL_STATUS_OF_CEFORM");
	static UI_Elements	LINK_EXPORT_CEFORM					= UIFactory.getElements("LINK_EXPORT_CEFORM");
	static UI_Elements	LINK_DISPLAY_CEFORM					= UIFactory.getElements("LINK_DISPLAY_CEFORM");
	static UI_Elements	LINK_UPDATE_CEFORM					= UIFactory.getElements("LINK_UPDATE_CEFORM");
	static UI_Elements	LINK_SAVE_AND_CONTINUE_CEFORM		= UIFactory.getElements("LINK_SAVE_AND_CONTINUE_CEFORM");
	static UI_Elements	TEXTAREA_DESCRIPTION_CEFORM			= UIFactory.getElements("TEXTAREA_DESCRIPTION_CEFORM");
	static UI_Elements	INPUT_DISPLAY_NAME_CEFORM			= UIFactory.getElements("INPUT_DISPLAY_NAME_CEFORM");
	static UI_Elements	INPUT_FORM_NAME_CEFORM				= UIFactory.getElements("INPUT_FORM_NAME_CEFORM");
	static UI_Elements	FORM_NAME_MODIFY_CEFORM				= UIFactory.getElements("FORM_NAME_MODIFY_CEFORM");
	static UI_Elements	FORM_NAME_ON_COPYING_CEFORM			= UIFactory.getElements("FORM_NAME_ON_COPYING_CEFORM");
	static UI_Elements	LINK_CONFIRM_ON_DEACTIVATING_CEFORM	= UIFactory.getElements("LINK_CONFIRM_ON_DEACTIVATING_CEFORM");
	static UI_Elements	LINK_CONFIRM_ON_ACTIVATING_CEFORM	= UIFactory.getElements("LINK_CONFIRM_ON_ACTIVATING_CEFORM");
	static UI_Elements	TEXT_AREA_FILED_NAME				= UIFactory.getElements("TEXT_AREA_FILED_NAME");
	static UI_Elements	NAME_FIELD_ERROR					= UIFactory.getElements("NAME_FIELD_ERROR");
	static UI_Elements	DISPLAY_NAME_FIELD_ERROR			= UIFactory.getElements("DISPLAY_NAME_FIELD_ERROR");
	static UI_Elements	SCOPE_ERROR							= UIFactory.getElements("SCOPE_ERROR");
	static UI_Elements	SECTIONNAME_ERROR					= UIFactory.getElements("SECTIONNAME_ERROR");
	static String		FILE_UPLOAD_ATTACHMENT				= ".//*[@id='attachmentInput_attachment']";

	public void clickOnOnlineEditor(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnFileUpload(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getAllCEforms(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDeactivateCEform(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnActivateCEform(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDeleteCEform(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCopyCEform(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnModifyCEform(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillSearchCEform(WebDriver driver, String testCaseName, String cEformName) throws ActionBotException;

	public String selectSearchInOptionForCEform(WebDriver driver, String testCaseName, int searchInOptionIndex) throws ActionBotException;

	public String getStatusOfFirstCEform(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isFillSearchCEformPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnUpdateCEform(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnExportCEform(WebDriver driver, String testCaseName) throws ActionBotException;

}
