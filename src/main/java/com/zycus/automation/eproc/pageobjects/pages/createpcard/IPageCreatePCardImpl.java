/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.createpcard;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.pcardlisting.IPagePCardListing;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IPageCreatePCardImpl implements IPageCreatePCard
{
	static Logger logger = Logger.getLogger(IPageCreatePCardImpl.class);

	@Override
	public String selectPCardType(WebDriver driver, String testCaseName, String pCardType) throws ActionBotException
	{
		String selectedPCardType = ActionBot.selectElement(driver, SELECT_PCARD_TYPE, IConstantsData.SELECT_BY_VALUE, pCardType);
		logger.info("Selected PCard Type : " + selectedPCardType);
		return selectedPCardType;
	}

	@Override
	public String fillPCardNo(WebDriver driver, String testCaseName, String pCardNo) throws ActionBotException
	{
		String enteredPCardNo = ActionBot.sendKeys(driver, TEXTBOX_PCARD_NO, pCardNo.trim());
		/*
		 * String enteredPCardNo = null; WebElement element =
		 * ActionBot.findElement(driver, TEXTBOX_PCARD_NO); element.clear();
		 * element.sendKeys(pCardNo.trim()); enteredPCardNo =
		 * element.getAttribute("value");
		 */
		logger.info("Entered PCard No : " + enteredPCardNo);
		return enteredPCardNo;
	}

	@Override
	public String fillIssuingBank(WebDriver driver, String testCaseName, String issusingBankName) throws ActionBotException
	{
		String enteredIssuingBankName = ActionBot.sendKeys(driver, TEXTBOX_ISSUING_BANK, issusingBankName);
		logger.info("Entered Issuing Bank Name : " + enteredIssuingBankName);
		return enteredIssuingBankName;
	}

	@Override
	public String fillParentAccountNo(WebDriver driver, String testCaseName, String parentAccountNo) throws ActionBotException
	{
		String enteredParentAccNo = ActionBot.sendKeys(driver, TEXTBOX_PARENT_ACCOUNT, parentAccountNo);
		logger.info("Entered Parent Account No : " + enteredParentAccNo);
		return enteredParentAccNo;
	}

	@Override
	public void clickOnIssuedToUser(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_ISSUED_TO_USER);
	}

	@Override
	public void clickOnIssuedToSupplier(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIO_BUTTON_ISSUED_TO_SUPPLIER);
	}

	@Override
	public String fillIssuedToUser(WebDriver driver, String testCaseName, String issuedTo) throws ActionBotException
	{
		String enteredIssuedTo = ActionBot.fillAutoCompleteField(driver, TEXTBOX_ISSUED_TO_USER, issuedTo);
		logger.info("Entered Issued To : " + enteredIssuedTo);
		return enteredIssuedTo;
	}

	@Override
	public String fillIssuedToSupplier(WebDriver driver, String testCaseName, String issuedTo) throws ActionBotException
	{
		String enteredIssuedTo = ActionBot.fillAutoCompleteField(driver, TEXTBOX_ISSUED_TO_SUPPLIER, issuedTo);
		logger.info("Entered Issued To : " + enteredIssuedTo);
		return enteredIssuedTo;
	}

	@Override
	public String fillNameOnCard(WebDriver driver, String testCaseName, String nameOnCard) throws ActionBotException
	{
		String enteredNameOnCard = ActionBot.sendKeys(driver, TEXTBOX_NAME_ON_CARD, nameOnCard);
		logger.info("Entered Name on Card : " + enteredNameOnCard);
		return enteredNameOnCard;
	}

	@Override
	public String selectExpiryMonthAndYear(WebDriver driver, String testCaseName, String month, String year) throws ActionBotException
	{
		String selectedMonthAndYear = "";
		// month
		selectedMonthAndYear = ActionBot.selectElement(driver, SELECT_EXPIRY_MONTH, IConstantsData.SELECT_BY_VALUE, month);
		// year
		selectedMonthAndYear = "/" + ActionBot.selectElement(driver, SELECT_EXPIRY_YEAR, IConstantsData.SELECT_BY_VALUE, year);

		logger.info("Selected Expiry Month and Year : " + selectedMonthAndYear);

		return selectedMonthAndYear;
	}

	@Override
	public String fillSecurityKey(WebDriver driver, String testCaseName, String securityKey) throws ActionBotException
	{
		String enteredSecurityKey = ActionBot.sendKeys(driver, TEXTBOX_SECURITY_CODE, securityKey);
		logger.info("Entered Security Key : " + enteredSecurityKey);
		return enteredSecurityKey;
	}

	@Override
	public String fillBillingCurrency(WebDriver driver, String testCaseName, String currency) throws ActionBotException
	{
		String selectedBillingCurrency = ActionBot.fillAutoCompleteField(driver, TEXTBOX_BILLING_CURRENCY, currency);
		logger.info("Selected Billing Currency : " + selectedBillingCurrency);
		return selectedBillingCurrency;
	}

	@Override
	public void clickOnLastBilledOnDatePicker(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, DATE_PICKER_LAST_BILLED_ON);
	}

	@Override
	public String selectLastBilledOnDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException
	{
		ActionBot.selectDate(driver, day, month, year);
		return getLastBilledOnDate(driver, testCaseName);
	}

	@Override
	public String getLastBilledOnDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String lastBilledOnDate = ActionBot.getAttributeOfElement(driver, TEXTBOX_LAST_BILLED_ON, "value");
		logger.info("Selected last billed on date : " + lastBilledOnDate);
		return lastBilledOnDate;
	}

	@Override
	public String selectStatementFrequency(WebDriver driver, String testCaseName, String statementFrequency) throws ActionBotException
	{
		String selectedStatementFrequency = ActionBot.selectElement(driver, SELECT_STATEMENT_FREQUENCY, IConstantsData.SELECT_BY_VALUE, statementFrequency);
		logger.info("Selected Statement Frequency : " + selectedStatementFrequency);
		return selectedStatementFrequency;
	}

	@Override
	public int fillCreditDays(WebDriver driver, String testCaseName, int creditDays) throws ActionBotException
	{
		int enteredCreditDays = Integer.parseInt(ActionBot.sendKeys(driver, TEXTBOX_CREDIT_DAYS, Integer.toString(creditDays)));
		logger.info("Entered Credit Days : " + enteredCreditDays);
		return enteredCreditDays;
	}

	@Override
	public String selectAllowedOUs(WebDriver driver, String testCaseName, String OU) throws ActionBotException
	{
		String selectedAllowedOUs = ActionBot.selectElement(driver, SELECT_ALLOWED_OUS, IConstantsData.SELECT_BY_VALUE, OU);
		logger.info("Selected OUs : " + selectedAllowedOUs);
		return selectedAllowedOUs;
	}

	@Override
	public int fillSpendPerTransaction(WebDriver driver, String testCaseName, int amount) throws ActionBotException
	{
		int enteredAmount = Integer.parseInt(ActionBot.sendKeys(driver, TEXTBOX_SPEND_PER_TRANSACTION, Integer.toString(amount)));
		logger.info("Entered Spend Per Transaction : " + enteredAmount);
		return enteredAmount;
	}

	@Override
	public int fillSpendPerDay(WebDriver driver, String testCaseName, int amount) throws ActionBotException
	{
		int enteredAmount = Integer.parseInt(ActionBot.sendKeys(driver, TEXTBOX_SPEND_PER_DAY, Integer.toString(amount)));
		logger.info("Entered Spend Per Day : " + enteredAmount);
		return enteredAmount;
	}

	@Override
	public int fillSpendPerCycle(WebDriver driver, String testCaseName, int amount) throws ActionBotException
	{
		int enteredAmount = Integer.parseInt(ActionBot.sendKeys(driver, TEXTBOX_SPEND_PER_CYCLE, Integer.toString(amount)));
		logger.info("Entered Spend Per Cycle : " + enteredAmount);
		return enteredAmount;
	}

	@Override
	public int fillTransactionsPerDay(WebDriver driver, String testCaseName, int transactions) throws ActionBotException
	{
		int enteredAmount = Integer.parseInt(ActionBot.sendKeys(driver, TEXTBOX_TRANSACTIONS_PER_DAY, Integer.toString(transactions)));
		logger.info("Entered Transactions Per Day : " + enteredAmount);
		return enteredAmount;
	}

	@Override
	public int fillTransactionsPerCycle(WebDriver driver, String testCaseName, int transactions) throws ActionBotException
	{
		int enteredAmount = Integer.parseInt(ActionBot.sendKeys(driver, TEXTBOX_TRANSACTIONS_PER_CYCLE, Integer.toString(transactions)));
		logger.info("Entered Transactions Per Cycle : " + enteredAmount);
		return enteredAmount;
	}

	@Override
	public void clickOnSelectCompany(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_SELECT_COMPANY_PCARD_CREATION);
	}

	@Override
	public void clickOnMatchSupplierInvoiceCheckBox(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_MATCH_SUPPLIER_INVOICE_DURING_BATCH_RECO);
	}

	@Override
	public void clickOnActivatePCardButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on activate PCard button");
		ActionBot.click(driver, BUTTON_ACTIVATE_PCARD);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on activate PCard button");
		//ActionBot.findElement(driver, IPagePCardListing.BUTTON_ADD_PCARD);
	}

	@Override
	public void clickOnSavePCardButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on save PCard button");
		ActionBot.click(driver, BUTTON_SAVE_PCARD);
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on save PCard button");
		ActionBot.findElement(driver, IPagePCardListing.BUTTON_ADD_PCARD);
	}

	@Override
	public void clickOnCancelPCardButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CANCEL_PCARD);
	}

	@Override
	public boolean isAddPCardButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, IPagePCardListing.BUTTON_ADD_PCARD))
		{
			return true;
		}
		return false;
	}

	@Override
	public String getPcardSaveError(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElement(driver, PCARD_SAVE_ERROR_CONTAINER).getText();
	}

	@Override
	public String getUsesLimitError(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElement(driver, LABEL_USES_LIMIT_ERROR).getText();
	}

	@Override
	public String getCardNoError(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		if (ActionBot.isElementDisplayed(driver, LABLE_CARD_NO_ERROR))
		{
			return ActionBot.getTextWithInElement(driver, LABLE_CARD_NO_ERROR);
		}
		return null;
	}

	@Override
	public String getPCardNumber(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		if (ActionBot.isElementDisplayed(driver, LABLE_PCARD_NO))
			return ActionBot.getTextWithInElement(driver, LABLE_PCARD_NO);
		return null;
	}

}
