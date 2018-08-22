/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.settings.entityownership;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPageEntityOwnership
{
	UI_Elements	TEXTBOX_CURRENT_OWNER			= UIFactory.getElements("TEXTBOX_CURRENT_OWNER");
	UI_Elements	TEXTBOX_NEW_OWNER				= UIFactory.getElements("TEXTBOX_NEW_OWNER");
	UI_Elements	CHECKBOX_REQUISITION			= UIFactory.getElements("CHECKBOX_REQUISITION");
	UI_Elements	TEXTBOX_OWNERSHIP_SEARCH_BOX	= UIFactory.getElements("TEXTBOX_OWNERSHIP_SEARCH_BOX");
	UI_Elements	SELECT_OWNERSHIP				= UIFactory.getElements("SELECT_OWNERSHIP");
	UI_Elements	BUTTON_OWNERSHIP_SEARCH_GO		= UIFactory.getElements("BUTTON_OWNERSHIP_SEARCH_GO");
	UI_Elements	BUTTON_START_CHANGE_OWNER		= UIFactory.getElements("BUTTON_START_CHANGE_OWNER");
	UI_Elements	BUTTON_RESET_CHANGE_OWNER		= UIFactory.getElements("BUTTON_RESET_CHANGE_OWNER");
	UI_Elements	BUTTON_CHANGE_OWNER				= UIFactory.getElements("BUTTON_CHANGE_OWNER");
	UI_Elements	CHANGE_OWNER_PROCESSING_DIV		= UIFactory.getElements("CHANGE_OWNER_PROCESSING_DIV");

	public String fillCurrentOwnerName(WebDriver driver, String testCaseName, String currentOwnerName) throws ActionBotException;

	public String fillNewOwnerName(WebDriver driver, String testCaseName, String newOwnerName) throws ActionBotException;

	public void clickOnRequisitionCheckbox(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnStartChangeOwnerButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnResetChangeOwnerButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillSearchOwnerName(WebDriver driver, String testCaseName, String ownerName) throws ActionBotException;

	public String selectSearchOwnerIn(WebDriver driver, String testCaseName, String searchOwnerIn) throws ActionBotException;

	public void clickOnSearchGo(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnChangeOwner(WebDriver driver, String testCaseName) throws ActionBotException;

}
