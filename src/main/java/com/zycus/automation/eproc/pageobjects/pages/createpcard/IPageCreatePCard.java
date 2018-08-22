/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.createpcard;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IPageCreatePCard
{
	static UI_Elements	SELECT_PCARD_TYPE									= UIFactory.getElements("SELECT_PCARD_TYPE");
	static UI_Elements	TEXTBOX_PCARD_NO									= UIFactory.getElements("TEXTBOX_PCARD_NO");
	static UI_Elements	TEXTBOX_ISSUING_BANK								= UIFactory.getElements("TEXTBOX_ISSUING_BANK");
	static UI_Elements	TEXTBOX_PARENT_ACCOUNT								= UIFactory.getElements("TEXTBOX_PARENT_ACCOUNT");
	static UI_Elements	RADIO_BUTTON_ISSUED_TO_USER							= UIFactory.getElements("RADIO_BUTTON_ISSUED_TO_USER");
	static UI_Elements	RADIO_BUTTON_ISSUED_TO_SUPPLIER						= UIFactory.getElements("RADIO_BUTTON_ISSUED_TO_SUPPLIER");
	static UI_Elements	TEXTBOX_ISSUED_TO_USER								= UIFactory.getElements("TEXTBOX_ISSUED_TO_USER");
	static UI_Elements	TEXTBOX_NAME_ON_CARD								= UIFactory.getElements("TEXTBOX_NAME_ON_CARD");
	static UI_Elements	SELECT_EXPIRY_MONTH									= UIFactory.getElements("SELECT_EXPIRY_MONTH");
	static UI_Elements	SELECT_EXPIRY_YEAR									= UIFactory.getElements("SELECT_EXPIRY_YEAR");
	static UI_Elements	TEXTBOX_SECURITY_CODE								= UIFactory.getElements("TEXTBOX_SECURITY_CODE");
	static UI_Elements	TEXTBOX_BILLING_CURRENCY							= UIFactory.getElements("TEXTBOX_BILLING_CURRENCY");
	static UI_Elements	TEXTBOX_LAST_BILLED_ON								= UIFactory.getElements("TEXTBOX_LAST_BILLED_ON");
	static UI_Elements	DATE_PICKER_LAST_BILLED_ON							= UIFactory.getElements("DATE_PICKER_LAST_BILLED_ON");
	static UI_Elements	SELECT_STATEMENT_FREQUENCY							= UIFactory.getElements("SELECT_STATEMENT_FREQUENCY");
	static UI_Elements	TEXTBOX_CREDIT_DAYS									= UIFactory.getElements("TEXTBOX_CREDIT_DAYS");
	static UI_Elements	SELECT_ALLOWED_OUS									= UIFactory.getElements("SELECT_ALLOWED_OUS");
	static UI_Elements	TEXTBOX_SPEND_PER_TRANSACTION						= UIFactory.getElements("TEXTBOX_SPEND_PER_TRANSACTION");
	static UI_Elements	TEXTBOX_TRANSACTIONS_PER_DAY						= UIFactory.getElements("TEXTBOX_TRANSACTIONS_PER_DAY");
	static UI_Elements	TEXTBOX_SPEND_PER_DAY								= UIFactory.getElements("TEXTBOX_SPEND_PER_DAY");
	static UI_Elements	TEXTBOX_TRANSACTIONS_PER_CYCLE						= UIFactory.getElements("TEXTBOX_TRANSACTIONS_PER_CYCLE");
	static UI_Elements	TEXTBOX_SPEND_PER_CYCLE								= UIFactory.getElements("TEXTBOX_SPEND_PER_CYCLE");
	static UI_Elements	BUTTON_ACTIVATE_PCARD								= UIFactory.getElements("BUTTON_ACTIVATE_PCARD");
	static UI_Elements	BUTTON_SAVE_PCARD									= UIFactory.getElements("BUTTON_SAVE_PCARD");
	static UI_Elements	BUTTON_CANCEL_PCARD									= UIFactory.getElements("BUTTON_CANCEL_PCARD");
	static UI_Elements	LINK_SELECT_COMPANY_PCARD_CREATION					= UIFactory.getElements("LINK_SELECT_COMPANY_PCARD_CREATION");
	static UI_Elements	CHECKBOX_MATCH_SUPPLIER_INVOICE_DURING_BATCH_RECO	= UIFactory.getElements("CHECKBOX_MATCH_SUPPLIER_INVOICE_DURING_BATCH_RECO");
	static UI_Elements	TEXTBOX_ISSUED_TO_SUPPLIER							= UIFactory.getElements("TEXTBOX_ISSUED_TO_SUPPLIER");
	static UI_Elements	PCARD_SAVE_ERROR_CONTAINER							= UIFactory.getElements("PCARD_SAVE_ERROR_CONTAINER");
	static UI_Elements	LABEL_USES_LIMIT_ERROR								= UIFactory.getElements("LABEL_USES_LIMIT_ERROR");
	static UI_Elements	LABLE_CARD_NO_ERROR									= UIFactory.getElements("LABLE_CARD_NO_ERROR");
	static UI_Elements	LABLE_PCARD_NO										= UIFactory.getElements("LABLE_PCARD_NO");

	public String selectPCardType(WebDriver driver, String testCaseName, String pCardType) throws ActionBotException;

	public String fillPCardNo(WebDriver driver, String testCaseName, String pCardNo) throws ActionBotException;

	public String fillIssuingBank(WebDriver driver, String testCaseName, String issusingBankName) throws ActionBotException;

	public String fillParentAccountNo(WebDriver driver, String testCaseName, String parentAccountNo) throws ActionBotException;

	public void clickOnIssuedToUser(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnIssuedToSupplier(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillIssuedToUser(WebDriver driver, String testCaseName, String issuedTo) throws ActionBotException;

	public String fillIssuedToSupplier(WebDriver driver, String testCaseName, String issuedTo) throws ActionBotException;

	public String fillNameOnCard(WebDriver driver, String testCaseName, String nameOnCard) throws ActionBotException;

	public String selectExpiryMonthAndYear(WebDriver driver, String testCaseName, String month, String year) throws ActionBotException;

	public String fillSecurityKey(WebDriver driver, String testCaseName, String securityKey) throws ActionBotException;

	public String fillBillingCurrency(WebDriver driver, String testCaseName, String currency) throws ActionBotException;

	public void clickOnLastBilledOnDatePicker(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectLastBilledOnDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException;

	public String getLastBilledOnDate(WebDriver driver, String testCaseName) throws ActionBotException;

	public String selectStatementFrequency(WebDriver driver, String testCaseName, String statementFrequency) throws ActionBotException;

	public int fillCreditDays(WebDriver driver, String testCaseName, int creditDays) throws ActionBotException;

	public String selectAllowedOUs(WebDriver driver, String testCaseName, String OU) throws ActionBotException;

	public int fillSpendPerTransaction(WebDriver driver, String testCaseName, int amount) throws ActionBotException;

	public int fillSpendPerDay(WebDriver driver, String testCaseName, int amount) throws ActionBotException;

	public int fillSpendPerCycle(WebDriver driver, String testCaseName, int amount) throws ActionBotException;

	public int fillTransactionsPerDay(WebDriver driver, String testCaseName, int transactions) throws ActionBotException;

	public int fillTransactionsPerCycle(WebDriver driver, String testCaseName, int transactions) throws ActionBotException;

	public void clickOnSelectCompany(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnMatchSupplierInvoiceCheckBox(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnActivatePCardButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSavePCardButton(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelPCardButton(WebDriver driver, String testCaseName) throws ActionBotException;

	/**
	 * @author sanjay.kundu
	 */
	public String getPcardSaveError(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getUsesLimitError(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isAddPCardButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	String getCardNoError(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException;

	String getPCardNumber(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException;

}
