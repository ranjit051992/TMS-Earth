/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.popups.invoiceerror;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPopUpInvoicingError
{
	static UI_Elements	BUTTON_IGNORE_AND_SUBMIT_INVOICE	= UIFactory.getElements("BUTTON_IGNORE_AND_SUBMIT_INVOICE");
	static UI_Elements	BUTTON_REVIEW_INVOICE				= UIFactory.getElements("BUTTON_REVIEW_INVOICE");

	public boolean isIgnoreAndSubmitInvoiceButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isReviewInvoiceButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnIgnoreAndSubmitInvoiceButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnReviewInvoiceButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException;

}
