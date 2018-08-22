/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.invitesupplierlisting;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPageInviteSupplierListing
{
	UI_Elements	BUTTON_SEND_INVITATIONS							= UIFactory.getElements("BUTTON_SEND_INVITATIONS");
	UI_Elements	TEXTBOX_SEARCH_SUPPLIER_NAME_INVITE_SUPPLIER	= UIFactory.getElements("TEXTBOX_SEARCH_SUPPLIER_NAME_INVITE_SUPPLIER");
	UI_Elements	BUTTON_FILTER_SUPPLIERS_INVITATIONS				= UIFactory.getElements("BUTTON_FILTER_SUPPLIERS_INVITATIONS");
	UI_Elements	LABEL_INVITED_SUPPLIER_NAME						= UIFactory.getElements("LABEL_INVITED_SUPPLIER_NAME");
	UI_Elements	LABEL_INVITED_SUPPLIER_INFO						= UIFactory.getElements("LABEL_INVITED_SUPPLIER_INFO");
	UI_Elements	LINK_REMIND_SUPPLIER_INVITE_SUPPLIER_LISTING	= UIFactory.getElements("LINK_REMIND_SUPPLIER_INVITE_SUPPLIER_LISTING");
	UI_Elements	LINK_CANCEL_INVITATION_INVITE_SUPPLIER_LISTING	= UIFactory.getElements("LINK_CANCEL_INVITATION_INVITE_SUPPLIER_LISTING");
	UI_Elements	PROGRESSING_DIV_INVITE_SUPPLIER_LISTING			= UIFactory.getElements("PROGRESSING_DIV_INVITE_SUPPLIER_LISTING");
	UI_Elements	DIV_DATA_TABLES_EMPTY							= UIFactory.getElements("DIV_DATA_TABLES_EMPTY");
	UI_Elements	LINK_CANCELLED_INVITATION_STATUS				= UIFactory.getElements("LINK_CANCELLED_INVITATION_STATUS");
	UI_Elements	LINK_INVITED_INVITATION_STATUS					= UIFactory.getElements("LINK_INVITED_INVITATION_STATUS");
	UI_Elements	BUTTON_CLEAR_FILTER_INVITE_SUPPLIER_LISTING		= UIFactory.getElements("BUTTON_CLEAR_FILTER_INVITE_SUPPLIER_LISTING");

	public void clickOnSendInvitationsButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillSearchSupplier(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException;

	public void clickOnFilterButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnClearFilterButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnInvitedStatusFilterButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelledStatusFilterButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSearchedSupplierName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getSearchedSupplierInfo(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnRemindSupplierLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelInvitationLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public String waitTillProgressingDivIsPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isDataTableEmptyPresent(WebDriver driver, String testCaseName) throws ActionBotException;

}
