/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.peformlisting;

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
public interface IPagePEformListing
{
	static UI_Elements	LINK_CREATED_PEFORM_NAMES			= UIFactory.getElements("LINK_CREATED_PEFORM_NAMES");
	static UI_Elements	LINK_DEACTIVATE_PEFORM				= UIFactory.getElements("LINK_DEACTIVATE_PEFORM");
	static UI_Elements	LINK_DELETE_PEFORM					= UIFactory.getElements("LINK_DELETE_PEFORM");
	static UI_Elements	PROCESSING_DIV_PEFORM_GRID_LISTING	= UIFactory.getElements("PROCESSING_DIV_PEFORM_GRID_LISTING");
	static UI_Elements	TEXTBOX_SEARCH_PEFORM				= UIFactory.getElements("TEXTBOX_SEARCH_PEFORM");
	static UI_Elements	LINK_MODIFY_PEFORM					= UIFactory.getElements("LINK_MODIFY_PEFORM");
	static UI_Elements	LINK_UPDATE_PEFORM					= UIFactory.getElements("LINK_UPDATE_PEFORM");
	static UI_Elements	LINK_COPY_PEFORM					= UIFactory.getElements("LINK_COPY_PEFORM");
	static UI_Elements	LINK_EXPORT_PEFORM					= UIFactory.getElements("LINK_EXPORT_PEFORM");
	static UI_Elements	LABEL_STATUS_OF_PEFORM				= UIFactory.getElements("LABEL_STATUS_OF_PEFORM");
	static UI_Elements	FORM_NAME_ON_COPYING_PEFORM			= UIFactory.getElements("FORM_NAME_ON_COPYING_PEFORM");
	static UI_Elements	LINK_CONFIRM_ON_DEACTIVATING_PEFORM	= UIFactory.getElements("LINK_CONFIRM_ON_DEACTIVATING_PEFORM");
	static UI_Elements	FORM_NAME_ON_UPDATING_PEFORM		= UIFactory.getElements("FORM_NAME_ON_UPDATING_PEFORM");
	static UI_Elements	TEXTAREA_DESCRIPTION_PEFORM			= UIFactory.getElements("TEXTAREA_DESCRIPTION_PEFORM");

	public List<WebElement> getListOfPEformNames(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDeactivatePEformLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDeletePEformLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnModifyPEformLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnUpdatePEformLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCopyPEformLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnExportPEformLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillSearchPEform(WebDriver driver, String testCaseName, String pEformName) throws ActionBotException;

	public String getStatusOFFirstPEForm(WebDriver driver, String testCaseName) throws ActionBotException;

}
