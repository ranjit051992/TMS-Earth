/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.cataloglistingactions;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 * 
 */
public interface IModalCatalogListingActions
{
	static UI_Elements	LINK_UPDATE_SCOPE_AND_VALIDITY	= UIFactory.getElements("LINK_UPDATE_SCOPE_AND_VALIDITY");
	static UI_Elements	LINK_UPDATE_CATALOG				= UIFactory.getElements("LINK_UPDATE_CATALOG");
	static UI_Elements	LINK_DEACTIVE_CATALOG			= UIFactory.getElements("LINK_DEACTIVE_CATALOG");
	static UI_Elements	LINK_EXPORT_CATALOG				= UIFactory.getElements("LINK_EXPORT_CATALOG");
	static UI_Elements	LINK_VIEW_CATALOG				= UIFactory.getElements("LINK_VIEW_CATALOG");
	static UI_Elements	LINK_DELETE_CATALOG				= UIFactory.getElements("LINK_DELETE_CATALOG");
	static UI_Elements	LINK_RECALL_CATALOG				= UIFactory.getElements("LINK_RECALL_CATALOG");
	UI_Elements			LINK_CANCEL_CATALOG				= UIFactory.getElements("LINK_CANCEL_CATALOG");

	public void clickOnUpdateScopeAndValidity(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnUpdateCatalog(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDeactivateCatalog(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnExportCatalog(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnViewCatalog(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDeletCatalog(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnRecallCatalog(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelCatalog(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isUpdateCatalogPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isViewCatalogPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isDeactivateCatalogPresent(WebDriver driver, String testCaseName) throws ActionBotException;
}
