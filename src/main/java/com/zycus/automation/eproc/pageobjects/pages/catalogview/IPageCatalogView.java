/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.catalogview;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPageCatalogView
{
	static UI_Elements	LABEL_VALIDITY_ON_CATALOG_VIEW					= UIFactory.getElements("LABEL_VALIDITY_ON_CATALOG_VIEW");
	static UI_Elements	LABEL_SUPPLIER_VIEW_CATALOG						= UIFactory.getElements("LABEL_SUPPLIER_VIEW_CATALOG");
	static UI_Elements	LINK_ITEM_NAMES_VIEW_CATALOG					= UIFactory.getElements("LINK_ITEM_NAMES_VIEW_CATALOG");
	static UI_Elements	LABEL_OU_VIEW_CATALOG							= UIFactory.getElements("LABEL_OU_VIEW_CATALOG");
	static UI_Elements	LINK_HIDE_ITEM									= UIFactory.getElements("LINK_HIDE_ITEM");
	static UI_Elements	LINK_UNHIDE_ITEM								= UIFactory.getElements("LINK_UNHIDE_ITEM");
	static UI_Elements	SUCCESS_MSG_VISIBILITY_UPDATED					= UIFactory.getElements("SUCCESS_MSG_VISIBILITY_UPDATED");
	static UI_Elements	BUTTON_SBUMIT_FOR_APPROVAL_CATALOG_VIEW_PAGE	= UIFactory.getElements("BUTTON_SBUMIT_FOR_APPROVAL_CATALOG_VIEW_PAGE");
	static UI_Elements	PROCESSING_DIV_SUBMIT_CATALOG					= UIFactory.getElements("PROCESSING_DIV_SUBMIT_CATALOG");

	static UI_Elements	AUDIT_TRAIL_TAB_LINK							= UIFactory.getElements("AUDIT_TRAIL_TAB_LINK");
	static UI_Elements	TABLE_AUDIT_TRAIL								= UIFactory.getElements("TABLE_AUDIT_TRAIL");

	public String getCatalogValidity(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSupplierName(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<String> getItemNames(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<String> getOUs(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnItemActionsLink(WebDriver driver, String testCaseName, String itemName) throws ActionBotException;

	public void clickOnHideItemLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnUnHideItemLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isItemHiddenStatusIconPresent(WebDriver driver, String testCaseName, String itemName) throws ActionBotException;

	public boolean isItemUnHideStatusIconPresent(WebDriver driver, String testCaseName, String itemName) throws ActionBotException;

	public void waitTillSuccessMsgPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSubmitForApprovalButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isSubmitForApprovalButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAuditTrailTabLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAuditTrailTablePresent(WebDriver driver, String testCaseName) throws ActionBotException;
}
