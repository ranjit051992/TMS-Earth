/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.budgetaudit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public class ModalBudgetAudit
{
	static Logger		logger												= Logger.getLogger(ModalBudgetAudit.class);
	static UI_Elements	TEXTBOX_DOCUMENT_REFERENCE							= UIFactory.getElements("TEXTBOX_DOCUMENT_REFERENCE");
	static UI_Elements	LABEL_FIRST_ROW_AUDIT_DATE							= UIFactory.getElements("LABEL_FIRST_ROW_AUDIT_DATE");
	static UI_Elements	LABEL_FIRST_ROW_AUDIT_DOC_REFERENCE_NAME			= UIFactory.getElements("LABEL_FIRST_ROW_AUDIT_DOC_REFERENCE_NAME");
	static UI_Elements	LABEL_FIRST_ROW_AUDIT_DOC_TYPE						= UIFactory.getElements("LABEL_FIRST_ROW_AUDIT_DOC_TYPE");
	static UI_Elements	LABEL_FIRST_ROW_AUDIT_EVENT							= UIFactory.getElements("LABEL_FIRST_ROW_AUDIT_EVENT");
	static UI_Elements	LABEL_FIRST_ROW_AUDIT_USER							= UIFactory.getElements("LABEL_FIRST_ROW_AUDIT_USER");
	static UI_Elements	LABEL_FIRST_ROW_AUDIT_REQ_RESERVED					= UIFactory.getElements("LABEL_FIRST_ROW_AUDIT_REQ_RESERVED");
	static UI_Elements	LABEL_FIRST_ROW_AUDIT_PO_RESERVED					= UIFactory.getElements("LABEL_FIRST_ROW_AUDIT_PO_RESERVED");
	static UI_Elements	LABEL_FIRST_ROW_AUDIT_INVOICE_RESERVED				= UIFactory.getElements("LABEL_FIRST_ROW_AUDIT_INVOICE_RESERVED");
	static UI_Elements	LABEL_FIRST_ROW_AUDIT_UTILIZED						= UIFactory.getElements("LABEL_FIRST_ROW_AUDIT_UTILIZED");
	static UI_Elements	LABEL_FIRST_ROW_AUDIT_NET							= UIFactory.getElements("LABEL_FIRST_ROW_AUDIT_NET");
	static UI_Elements	LABEL_FIRST_ROW_AUDIT_BALANCE_AMOUNT				= UIFactory.getElements("LABEL_FIRST_ROW_AUDIT_BALANCE_AMOUNT");
	static UI_Elements	LABEL_FIRST_ROW_AUDIT_BALANCE_AMOUNT_WITH_TOLERANCE	= UIFactory.getElements("LABEL_FIRST_ROW_AUDIT_BALANCE_AMOUNT_WITH_TOLERANCE");
	static UI_Elements	BUTTON_CLOSE_BUDGET_AUDIT							= UIFactory.getElements("BUTTON_CLOSE_BUDGET_AUDIT");

	public static String fillDocumentReferenceName(WebDriver driver, String testCaseName, String docName) throws ActionBotException
	{
		String enteredDocName = null;
		WebElement element = ActionBot.findElement(driver, TEXTBOX_DOCUMENT_REFERENCE);
		element.clear();
		element.sendKeys(docName);
		element.sendKeys(Keys.ENTER);
		enteredDocName = element.getAttribute("value").trim();
		logger.info("Entered Document Name : " + enteredDocName);
		return enteredDocName;
	}

	public static String getBudgetAuditDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String auditDate = ActionBot.getTextWithInElement(driver, LABEL_FIRST_ROW_AUDIT_DATE);
		logger.info("Audit Date : " + auditDate);
		return auditDate;
	}

	public static String getDocumentName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String documentName = ActionBot.getTextWithInElement(driver, LABEL_FIRST_ROW_AUDIT_DOC_REFERENCE_NAME);
		logger.info("Document Name : " + documentName);
		return documentName;
	}

	public static String getDocumentType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String documentType = ActionBot.getTextWithInElement(driver, LABEL_FIRST_ROW_AUDIT_DOC_TYPE);
		logger.info("Document type : " + documentType);
		return documentType;
	}

	public static String getBudgetAuditEvent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String auditEvent = ActionBot.getTextWithInElement(driver, LABEL_FIRST_ROW_AUDIT_EVENT);
		logger.info("Audit Event : " + auditEvent);
		return auditEvent;
	}

	public static String getBudgetAuditUser(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String auditUser = ActionBot.getTextWithInElement(driver, LABEL_FIRST_ROW_AUDIT_USER);
		logger.info("Audit User : " + auditUser);
		return auditUser;
	}

	public static String getBudgetRequisitionReservedAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String reqReservedAmount = ActionBot.getTextWithInElement(driver, LABEL_FIRST_ROW_AUDIT_REQ_RESERVED);
		logger.info("Audit Requisition Reserved Amount : " + reqReservedAmount);
		return reqReservedAmount;
	}

	public static String getBudgetPOReservedAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String poReservedAmount = ActionBot.getTextWithInElement(driver, LABEL_FIRST_ROW_AUDIT_PO_RESERVED);
		logger.info("Audit PO Reserved Amount : " + poReservedAmount);
		return poReservedAmount;
	}

	public static String getBudgetInvoiceReservedAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String invoiceReservedAmount = ActionBot.getTextWithInElement(driver, LABEL_FIRST_ROW_AUDIT_INVOICE_RESERVED);
		logger.info("Audit Invoice Reserved Amount : " + invoiceReservedAmount);
		return invoiceReservedAmount;
	}

	public static String getBudgetAuditUtilizedAmount(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String utilizedAmount = ActionBot.getTextWithInElement(driver, LABEL_FIRST_ROW_AUDIT_UTILIZED);
		logger.info("Utilized Amount : " + utilizedAmount);
		return utilizedAmount;
	}

	public static String getBudgetAuditNet(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String auditNet = ActionBot.getTextWithInElement(driver, LABEL_FIRST_ROW_AUDIT_NET);
		logger.info("Audit Net : " + auditNet);
		return auditNet;
	}

	public static String getBudgetAuditBalance(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String auditBalance = ActionBot.getTextWithInElement(driver, LABEL_FIRST_ROW_AUDIT_BALANCE_AMOUNT);
		logger.info("Audit Balance : " + auditBalance);
		return auditBalance;
	}

	public static String getBudgetAuditBalanceAmountWithTolerance(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String auditBalanceWithTolerance = ActionBot.getTextWithInElement(driver, LABEL_FIRST_ROW_AUDIT_BALANCE_AMOUNT_WITH_TOLERANCE);
		logger.info("Audit Balance Amount With Tolerance : " + auditBalanceWithTolerance);
		return auditBalanceWithTolerance;
	}

	public static void clickOnCloseBudgetAuditButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on close budget audit button");
		ActionBot.click(driver, BUTTON_CLOSE_BUDGET_AUDIT);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on close budget audit button");
	}
}
