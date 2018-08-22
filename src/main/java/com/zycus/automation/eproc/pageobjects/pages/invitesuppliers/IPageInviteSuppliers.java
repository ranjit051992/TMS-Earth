/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.invitesuppliers;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPageInviteSuppliers
{
	static UI_Elements	LINK_SEND_INVITATIONS								= UIFactory.getElements("LINK_SEND_INVITATIONS");
	static UI_Elements	RADIO_BUTTON_SEND_ALL_SUPPLIERS						= UIFactory.getElements("RADIO_BUTTON_SEND_ALL_SUPPLIERS");
	static UI_Elements	RADIO_BUTTON_SELECTED_SUPPLIERS						= UIFactory.getElements("RADIO_BUTTON_SELECTED_SUPPLIERS");
	static UI_Elements	SELECT_SEARCH_SUPPLIERS_BY							= UIFactory.getElements("SELECT_SEARCH_SUPPLIERS_BY");
	static UI_Elements	TEXTBOX_SEARCH_SUPPLIER								= UIFactory.getElements("TEXTBOX_SEARCH_SUPPLIER");
	static UI_Elements	BUTTON_SEARCH_SUPPLIER_GO							= UIFactory.getElements("BUTTON_SEARCH_SUPPLIER_GO");
	static UI_Elements	CHECKBOX_SELECT_SUPPLIER							= UIFactory.getElements("CHECKBOX_SELECT_SUPPLIER");
	static UI_Elements	LINK_FIRST_SEARCHED_SUPPLIER_NAME					= UIFactory.getElements("LINK_FIRST_SEARCHED_SUPPLIER_NAME");
	static UI_Elements	LABEL_OFFERED_PRODUCTS_SERVICES_BY_SUPPLIER			= UIFactory.getElements("LABEL_OFFERED_PRODUCTS_SERVICES_BY_SUPPLIER");
	static UI_Elements	BUTTON_SAVE_AND_CONTINUE_SUPPLIER_INVITATIONS		= UIFactory.getElements("BUTTON_SAVE_AND_CONTINUE_SUPPLIER_INVITATIONS");
	static UI_Elements	BUTTON_CANCEL_SUPPLIER_INVITATIONS					= UIFactory.getElements("BUTTON_CANCEL_SUPPLIER_INVITATIONS");
	static UI_Elements	TEXTBOX_EMAIL_BODY									= UIFactory.getElements("TEXTBOX_EMAIL_BODY");
	static UI_Elements	CHECKBO_SAVE_CHANGES_TO_INVITATION_TEMPLATE			= UIFactory.getElements("CHECKBO_SAVE_CHANGES_TO_INVITATION_TEMPLATE");
	static UI_Elements	BUTTON_NEXT_INVITE_SUPPLIER							= UIFactory.getElements("BUTTON_NEXT_INVITE_SUPPLIER");
	static UI_Elements	BUTTON_BACK_INVITE_SUPPLIER							= UIFactory.getElements("BUTTON_BACK_INVITE_SUPPLIER");
	static UI_Elements	CHECKBOX_SEND_COPIES_OF_INVITATION					= UIFactory.getElements("CHECKBOX_SEND_COPIES_OF_INVITATION");
	static UI_Elements	SELECT_SEND_COPY_TO_ME								= UIFactory.getElements("SELECT_SEND_COPY_TO_ME");
	static UI_Elements	SELECT_SEND_COPY_TO_OTHER							= UIFactory.getElements("SELECT_SEND_COPY_TO_OTHER");
	static UI_Elements	CHECKBOX_REMIND_SUPPLIERS_THAT_WERE_INVITED_BEFORE	= UIFactory.getElements("CHECKBOX_REMIND_SUPPLIERS_THAT_WERE_INVITED_BEFORE");
	static UI_Elements	BUTTON_SEND_INVITATION								= UIFactory.getElements("BUTTON_SEND_INVITATION");
	static UI_Elements	PROCESSING_DIV_SENDING_SUPPLIER_INVITATIONS			= UIFactory.getElements("PROCESSING_DIV_SENDING_SUPPLIER_INVITATIONS");

	public void clickOnSendInvitationLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSelectAllSuppliers(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSelectedSuppliers(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectSearchSuppliersBy(WebDriver driver, String testCaseName, String searchSuppliersBy) throws ActionBotException;

	public void fillSearchSuppliers(WebDriver driver, String testCaseName, String searchSuppliers) throws ActionBotException;

	public void clickOnSearchSuppliersGoButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstSearchedSupplierName(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstSupplierOfferedProductsAndServices(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectFirstSearchedSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSaveAndContinue(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getInvitationTemplateText(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSaveChangesToInvitationTemplate(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnNextButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnBackButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSendInvitationButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void waitTillSendInvitationProgressingDivPresent(WebDriver driver, String testCaseName) throws ActionBotException;

}
