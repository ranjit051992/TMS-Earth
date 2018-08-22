/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.viewpoactions;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalViewPOActions
{
	static UI_Elements	LINK_PREVIEW_PO					= UIFactory.getElements("LINK_PREVIEW_PO");
	static UI_Elements	LINK_PRINT_PO					= UIFactory.getElements("LINK_PRINT_PO");
	static UI_Elements	LINK_PDF_PO						= UIFactory.getElements("LINK_PDF_PO");
	static UI_Elements	LINK_EMAIL_PO					= UIFactory.getElements("LINK_EMAIL_PO");
	static UI_Elements	LINK_COPY_PO					= UIFactory.getElements("LINK_COPY_PO");
	static UI_Elements	LINK_REMIND_PO					= UIFactory.getElements("LINK_REMIND_PO");
	static UI_Elements	LINK_CREATE_RECEIPT				= UIFactory.getElements("LINK_CREATE_RECEIPT");
	static UI_Elements	LINK_CREATE_RECEIPT_DROPDOWN	= UIFactory.getElements("LINK_CREATE_RECEIPT_DROPDOWN");
	static UI_Elements	LINK_CREATE_INVOICE				= UIFactory.getElements("LINK_CREATE_INVOICE");
	static UI_Elements	LINK_CANCEL_PO					= UIFactory.getElements("LINK_CANCEL_PO");
	static UI_Elements	LINK_CLOSE_PO					= UIFactory.getElements("LINK_CLOSE_PO");
	static UI_Elements	LINK_AMEND_PO					= UIFactory.getElements("LINK_AMEND_PO");
	static UI_Elements	LINK_RELEASE_FIRST_PO			= UIFactory.getElements("LINK_RELEASE_FIRST_PO");
	static UI_Elements	BUTTON_RELEASE_PO				= UIFactory.getElements("BUTTON_RELEASE_PO");

	public void clickOnPreviewPoLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnPrintPoLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnPDFPoLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnEmailPoLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCopyPoLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnRemindPoLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCreateReceiptPoLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCreateInvoicePoLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelPoLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnClosePoLink(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnAmendPoLink(WebDriver driver, String testCaseName) throws ActionBotException;
	
	public void clickOnReleasePoLink(WebDriver driver, String testCaseName) throws ActionBotException;
	
	public void clickOnReleasePOButton(WebDriver driver, String testCaseName) throws ActionBotException;

	/*
	 * author : bhakti.sawant
	 */
	void clickOnCreateReceiptViewPoDrpodownLink(WebDriver driver, String testCaseName) throws ActionBotException;
}
