package com.zycus.automation.eproc.pageobjects.modals.entityownership;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModalSelectRequisitionEntityOwnership
{
	UI_Elements	SELECT_STATUS_OF_ENTITIES		= UIFactory.getElements("SELECT_STATUS_OF_ENTITIES");
	UI_Elements	SELECT_ENTITIES_IN				= UIFactory.getElements("SELECT_ENTITIES_IN");
	UI_Elements	TEXTBOX_ENTITY_SEARCH_BOX		= UIFactory.getElements("TEXTBOX_ENTITY_SEARCH_BOX");
	UI_Elements	BUTTON_ENTITIES_SEARCH_GO		= UIFactory.getElements("BUTTON_ENTITIES_SEARCH_GO");
	UI_Elements	CHECKBOX_FIRST_ROW_ENTITY		= UIFactory.getElements("CHECKBOX_FIRST_ROW_ENTITY");
	UI_Elements	TEXTBOX_COMMENTS_FOR_ENTITY		= UIFactory.getElements("TEXTBOX_COMMENTS_FOR_ENTITY");
	UI_Elements	BUTTON_SAVE_SELECTED_ENTITES	= UIFactory.getElements("BUTTON_SAVE_SELECTED_ENTITES");
	UI_Elements	BUTTON_CANCEL_SELECTED_ENTITES	= UIFactory.getElements("BUTTON_CANCEL_SELECTED_ENTITES");
	UI_Elements	TEXTBOX_SHOWING_PAGE_NUMBER		= UIFactory.getElements("TEXTBOX_SHOWING_PAGE_NUMBER");
	UI_Elements	LIST_OF_REQUISITIONS_ON_SELECT_REQUISITIONS_POPUP		= UIFactory.getElements("LIST_OF_REQUISITIONS_ON_SELECT_REQUISITIONS_POPUP");

	public String selectStatusOfEntities(WebDriver driver, String testCaseName, String status) throws ActionBotException;

	public String selectEntitiesIn(WebDriver driver, String testCaseName, String entitiesIn) throws ActionBotException;

	public String fillEntitySearchBox(WebDriver driver, String testCaseName, String entity) throws ActionBotException;

	public void clickOnSearchGoButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnFirstRowEntityCheckbox(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillComments(WebDriver driver, String testCaseName, String comments) throws ActionBotException;

	public void clickOnSaveSelectedEntitiesButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelSelectedEntitiesButton(WebDriver driver, String testCaseName) throws ActionBotException;
	
	public List<String> getListOfRequisitionsOnSelectRequisitionsPoUp(WebDriver driver, String testCaseName, int showingPageNumber) throws ActionBotException, FactoryMethodException;
	
	public String fillShowingPageNumberAndEnter(WebDriver driver, String testCaseName, int showingPageNumber) throws ActionBotException,FactoryMethodException;
	
	public boolean clickOnSpecificRowCheckBoxOnSelectRequisitionsPopUp(WebDriver driver, String testCaseName, String rowNo) throws ActionBotException,FactoryMethodException;

	
}
