/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.cataloglisting;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPageCatalogListing
{
	static UI_Elements	BUTTON_ADD_CATALOG					= UIFactory.getElements("BUTTON_ADD_CATALOG");
	static UI_Elements	TEXTBOX_SEARCH_CATALOG_NAME			= UIFactory.getElements("TEXTBOX_SEARCH_CATALOG_NAME");
	static UI_Elements	FIRST_CATALOG_NAME					= UIFactory.getElements("FIRST_CATALOG_NAME");
	static UI_Elements	LINK_CATALOG_ACTIONS				= UIFactory.getElements("LINK_CATALOG_ACTIONS");
	static UI_Elements	LABEL_STATUS_OF_FIRST_CATALOG		= UIFactory.getElements("LABEL_STATUS_OF_FIRST_CATALOG");
	static UI_Elements	LABEL_SUCCESS_MESSAGE				= UIFactory.getElements("LABEL_SUCCESS_MESSAGE");
	static UI_Elements	PROGRESSING_DIV_FOR_UPDATE_CATALOG	= UIFactory.getElements("PROGRESSING_DIV_FOR_UPDATE_CATALOG");
	static UI_Elements	CLEAR_SEARCH_FILTER					= UIFactory.getElements("CLEAR_SEARCH_FILTER");

	public void clickOnAddCatalogButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillSearchCatalogName(WebDriver driver, String testCaseName, String catalogName) throws ActionBotException;

	public String getFirstCatalogName(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCatalogActions(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getStatusOfFirstCatalog(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnFirstCatalogName(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSearchCatalogClearFilter(WebDriver driver, String testCaseName) throws ActionBotException;

}
