package com.zycus.automation.eproc.pageobjects.pages.settings.projectsmasterdatasettings;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IPageProjectsMasterDataSettings
{
	final static String			ACTIVE										= "active";
	final static String			INACTIVE									= "inactivate";

	final static UI_Elements	TEXTBOX_SEARCH_PROJECTS						= UIFactory.getElements("TEXTBOX_SEARCH_PROJECTS");
	final static UI_Elements	BUTTON_GO_PROJECT_PAGE						= UIFactory.getElements("BUTTON_GO_PROJECT_PAGE");
	final static UI_Elements	PROJECT_NAME								= UIFactory.getElements("PROJECT_NAME");
	final static UI_Elements	LINK_ACTIVE									= UIFactory.getElements("LINK_ACTIVE");
	final static UI_Elements	LINK_DELETE									= UIFactory.getElements("LINK_DELETE");
	final static UI_Elements	OUTDATED_PROJECT							= UIFactory.getElements("OUTDATED_PROJECT");
	final static UI_Elements	PROJECT_CODE								= UIFactory.getElements("PROJECT_CODE");
	final static UI_Elements	LINK_EDIT									= UIFactory.getElements("LINK_EDIT");
	final static UI_Elements	PROJECTMANAGER_NAME							= UIFactory.getElements("PROJECTMANAGER_NAME");
	final static UI_Elements	DURATION_DATE								= UIFactory.getElements("DURATION_DATE");
	final static UI_Elements	LINK_DEACTIVE								= UIFactory.getElements("LINK_DEACTIVE");
	final static UI_Elements	TEXTBOX_NUMBER								= UIFactory.getElements("TEXTBOX_NUMBER");
	final static UI_Elements	TEXTBOX_NAME								= UIFactory.getElements("TEXTBOX_NAME");
	final static UI_Elements	SELECT_COMPANY_IN_PROJECT					= UIFactory.getElements("SELECT_COMPANY_IN_PROJECT");
	final static UI_Elements	LINK_ADD_PROJECT							= UIFactory.getElements("LINK_ADD_PROJECT");
	final static UI_Elements	BUTTON_SAVE_ADD_PROJECT						= UIFactory.getElements("BUTTON_SAVE_ADD_PROJECT");
	final static UI_Elements	LINK_SELECT_BU								= UIFactory.getElements("LINK_SELECT_BU");
	final static UI_Elements	PROJECT_END_DATE							= UIFactory.getElements("PROJECT_END_DATE");
	final static UI_Elements	SELECT_MONTH								= UIFactory.getElements("SELECT_MONTH");
	final static UI_Elements	SELECT_YEAR									= UIFactory.getElements("SELECT_YEAR");
	final static UI_Elements	LINK_CLEAR_END_DATE_IN_PROJECT				= UIFactory.getElements("LINK_CLEAR_END_DATE_IN_PROJECT");
	UI_Elements					SELECT_SEARCH_PROJECT_IN					= UIFactory.getElements("SELECT_SEARCH_PROJECT_IN");
	UI_Elements					LABEL_DATA_TABLES_EMPTY_FOR_PROJECT_LISTING	= UIFactory.getElements("LABEL_DATA_TABLES_EMPTY_FOR_PROJECT_LISTING");

	public String getSearch(WebDriver driver, String testCaseName, String search) throws ActionBotException;

	public void clickOnGo(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getProjectName(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnActive(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDelete(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isProjectActive(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isProjectOutdated(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillProjectSearchBox(WebDriver driver, String testCaseName, String SearchItem) throws ActionBotException;

	public String getProjectCode(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnEdit(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getProjectManagername(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getDurationDate(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnActiveProjectToDeactivateIt(WebDriver driver, String testCaseName, int id) throws ActionBotException;

	public void clickOnDeActive(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAddProjectLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public int fillProjectNumber(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	public String fillProjectName(WebDriver driver, String testCaseName, String name) throws ActionBotException;

	public String fillProjectEndDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException;

	public String selectCompany(WebDriver driver, String testCaseName, String company) throws ActionBotException;

	public void clickOnSaveAddedProject(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSelectBU(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnClearDate(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectSearchProjectIn(WebDriver driver, String testCaseName, String searchIn) throws ActionBotException;

	public boolean isDataTableEmptyPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isProjectDeactive(WebDriver driver, String testCaseName) throws ActionBotException;
}
