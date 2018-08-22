/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.uploaditemsincatalog;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalUploadItemsInCatalog
{
	static UI_Elements	BUTTON_UPLOAD_ITEMS_VIA_FILE	= UIFactory.getElements("BUTTON_UPLOAD_ITEMS_VIA_FILE");
	static UI_Elements	INPUT_UPLOAD_ITEMS				= UIFactory.getElements("INPUT_UPLOAD_ITEMS");
	static UI_Elements	BUTTON_UPLOAD_CATALOG			= UIFactory.getElements("BUTTON_UPLOAD_CATALOG");
	static UI_Elements	BUTTON_CANCEL_CATALOG			= UIFactory.getElements("BUTTON_CANCEL_CATALOG");
	static UI_Elements	CATALOG_UPLOAD_PROCESSING_DIV	= UIFactory.getElements("CATALOG_UPLOAD_PROCESSING_DIV");
	static UI_Elements	BUTTON_MAP_CATALOG_COLUMNS_OK	= UIFactory.getElements("BUTTON_MAP_CATALOG_COLUMNS_OK");

	public void clickOnUploadItemsViaFileButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillFileName(WebDriver driver, String testCaseName, String fileName) throws Exception;

	public void clickOnUploadCatalogButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelCatalogButton(WebDriver driver, String testCaseName) throws ActionBotException;

}
