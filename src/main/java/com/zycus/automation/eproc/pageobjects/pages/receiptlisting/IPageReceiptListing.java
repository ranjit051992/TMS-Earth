/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.receiptlisting;

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
public interface IPageReceiptListing
{
	static UI_Elements	BUTTON_CREATE_RECEIPT								= UIFactory.getElements("BUTTON_CREATE_RECEIPT");
	static UI_Elements	RECEIPT_LISTING_PROCESSING_DIV						= UIFactory.getElements("RECEIPT_LISTING_PROCESSING_DIV");
	static UI_Elements	LINK_RECEIPT_NO										= UIFactory.getElements("LINK_RECEIPT_NO");
	static UI_Elements	LABEL_RECEIPT_DATE									= UIFactory.getElements("LABEL_RECEIPT_DATE");
	static UI_Elements	LABEL_RECEIPT_STATUS								= UIFactory.getElements("LABEL_RECEIPT_STATUS");
	static UI_Elements	LINK_VIEW_RECEIPT									= UIFactory.getElements("LINK_VIEW_RECEIPT");
	static UI_Elements	LINK_CANCEL_RECEIPT									= UIFactory.getElements("LINK_CANCEL_RECEIPT");
	static UI_Elements	CANCELLING_RECEIPT_PROCESSING_DIV					= UIFactory.getElements("CANCELLING_RECEIPT_PROCESSING_DIV");
	static UI_Elements	LINK_EDIT_RECEIPT									= UIFactory.getElements("LINK_EDIT_RECEIPT");

	static UI_Elements	DELETE_DRAFTED_RETURN_NOTE							= UIFactory.getElements("DELETE_DRAFTED_RETURN_NOTE");

	static UI_Elements	GENERIC_DOCUMENT_TYPE								= UIFactory.getElements("GENERIC_DOCUMENT_TYPE");
	static UI_Elements	DELETE_DRAFTED_RETURN_NOTE_POPUP					= UIFactory.getElements("DELETE_DRAFTED_RETURN_NOTE_POPUP");
	static UI_Elements	CLICK_FILTER_RECEIPT_LISTING_STATUS					= UIFactory.getElements("CLICK_FILTER_RECEIPT_LISTING_STATUS");
	static UI_Elements	CLICK_ON_SELECT_RECEIPT_FILTER_STATUS				= UIFactory.getElements("CLICK_ON_SELECT_RECEIPT_FILTER_STATUS");
	static UI_Elements	CLICK_ON_SELECT_RETURN_NOTE_FILTER_STATUS			= UIFactory.getElements("CLICK_ON_SELECT_RETURN_NOTE_FILTER_STATUS");
	static UI_Elements	CLICK_ON_FILTER_BUTTON_RECEIPT_LISTING_STATUS		= UIFactory.getElements("CLICK_ON_FILTER_BUTTON_RECEIPT_LISTING_STATUS");
	static UI_Elements	CLICK_ON_CLEAR_FILTER_BUTTON_RECEIPT_LISTING_STATUS	= UIFactory.getElements("CLICK_ON_CLEAR_FILTER_BUTTON_RECEIPT_LISTING_STATUS");
	static UI_Elements	STATUS_OF_RETURN_NOTE								= UIFactory.getElements("STATUS_OF_RETURN_NOTE");
	static UI_Elements	RETURN_NOTE_NAME_LIST								= UIFactory.getElements("RETURN_NOTE_NAME_LIST");

	public String getFirstReturnNoteNumber(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean checkSuccessfulCreationOfReturnNote(WebDriver driver, String testCaseName, String returnNoteNo) throws ActionBotException;

	public String getStatusOfFirstReturnNote(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectReceiptInStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void selectReturnNoteStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnClearFilterStatusButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnYesButtonReturnNotePopUp(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCreateReceiptButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnFirstReceiptNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstReceiptNo(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstReceiptDate(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getFirstReceiptStatus(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnViewReceiptButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelReceiptButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnEditReceiptLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getWebElementOfDeleteReturnNote(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDeleteReturnNote(WebDriver driver, String testCaseName, WebElement element) throws ActionBotException;

}
