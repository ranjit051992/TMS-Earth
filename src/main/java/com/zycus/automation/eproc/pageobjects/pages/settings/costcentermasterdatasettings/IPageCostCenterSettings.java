package com.zycus.automation.eproc.pageobjects.pages.settings.costcentermasterdatasettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPageCostCenterSettings
{

	final UI_Elements	SEARCHBOX_CC						= UIFactory.getElements("SEARCHBOX_CC");
	final UI_Elements	GO_BTN_CC							= UIFactory.getElements("GO_BTN_CC");
	final UI_Elements	LINK_CC_ACTIVE						= UIFactory.getElements("LINK_CC_ACTIVE");
	final UI_Elements	LINK_CC_DEACTIVE					= UIFactory.getElements("LINK_CC_DEACTIVE");
	UI_Elements			SELECT_SEARCH_CC_IN					= UIFactory.getElements("SELECT_SEARCH_CC_IN");
	UI_Elements			LINK_EDIT_CC_IN_MASTER_DATA			= UIFactory.getElements("LINK_EDIT_CC_IN_MASTER_DATA");
	UI_Elements			LINK_ALL_SELECTED_BU_FOR_CC			= UIFactory.getElements("LINK_ALL_SELECTED_BU_FOR_CC");
	UI_Elements			LABEL_FIRST_COST_CENTER_SEARCHED	= UIFactory.getElements("LABEL_FIRST_COST_CENTER_SEARCHED");
	UI_Elements			BUTTON_UPDATE_COST_CENTER			= UIFactory.getElements("BUTTON_UPDATE_COST_CENTER");
	UI_Elements			LINK_IMPORT_CC_VIA_FILE				= UIFactory.getElements("LINK_IMPORT_CC_VIA_FILE");
	UI_Elements			FILE_UPLOAD_COST_CENTERS			= UIFactory.getElements("FILE_UPLOAD_COST_CENTERS");
	UI_Elements			BUTTON_UPLOAD_CC_FILES				= UIFactory.getElements("BUTTON_UPLOAD_CC_FILES");

	public String fillSearchCostCenter(WebDriver driver, String testCaseName, String search) throws ActionBotException;

	public void clickOnGoBtn(WebDriver driver) throws ActionBotException;

	public void clickOnActiveCCLin(WebDriver driver) throws ActionBotException;

	public void clickOnDeActiveCCLin(WebDriver driver) throws ActionBotException;

	public String selectSearchCCIn(WebDriver driver, String testCaseName, String selectCCIn) throws ActionBotException;

	public void clickOnEditCC(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAllSelectedBUsLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstCostCenterSearched(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnUpdateCostCenter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnImportCCViaFiles(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillFileName(WebDriver driver, String testCaseName, String fileName) throws ActionBotException;

	public void clickOnUploadCCButton(WebDriver driver, String testCaseName) throws ActionBotException;

}
