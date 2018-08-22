/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.createpcard;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.factory.FactoryPage;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;

/**
 * @author ankita.sawant
 *
 */
public class PageCreatePCard
{
	static Logger logger = Logger.getLogger(PageCreatePCard.class);

	public static String selectPCardType(WebDriver driver, String testCaseName, String pCardType) throws ActionBotException, FactoryMethodException
	{
		IPageCreatePCard createPCard = FactoryPage.getInstanceOf(IPageCreatePCardImpl.class);
		return createPCard.selectPCardType(driver, testCaseName, pCardType);
	}

	public static String fillPCardNo(WebDriver driver, String testCaseName, String pCardNo) throws ActionBotException, FactoryMethodException
	{
		IPageCreatePCard createPCard = FactoryPage.getInstanceOf(IPageCreatePCardImpl.class);
		return createPCard.fillPCardNo(driver, testCaseName, pCardNo);
	}

	public static String fillIssuingBank(WebDriver driver, String testCaseName, String issusingBankName) throws ActionBotException, FactoryMethodException
	{
		IPageCreatePCard createPCard = FactoryPage.getInstanceOf(IPageCreatePCardImpl.class);
		return createPCard.fillIssuingBank(driver, testCaseName, issusingBankName);
	}

	public static String fillParentAccountNo(WebDriver driver, String testCaseName, String parentAccountNo) throws ActionBotException, FactoryMethodException
	{
		IPageCreatePCard createPCard = FactoryPage.getInstanceOf(IPageCreatePCardImpl.class);
		return createPCard.fillParentAccountNo(driver, testCaseName, parentAccountNo);
	}

	public static void clickOnIssuedToUser(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreatePCard createPCard = FactoryPage.getInstanceOf(IPageCreatePCardImpl.class);
		createPCard.clickOnIssuedToUser(driver, testCaseName);
	}

	public static void clickOnIssuedToSupplier(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreatePCard createPCard = FactoryPage.getInstanceOf(IPageCreatePCardImpl.class);
		createPCard.clickOnIssuedToSupplier(driver, testCaseName);
	}

	public static String fillIssuedToUser(WebDriver driver, String testCaseName, String issuedTo) throws ActionBotException, FactoryMethodException
	{
		IPageCreatePCard createPCard = FactoryPage.getInstanceOf(IPageCreatePCardImpl.class);
		return createPCard.fillIssuedToUser(driver, testCaseName, issuedTo);
	}

	public static String fillIssuedToSupplier(WebDriver driver, String testCaseName, String issuedTo) throws ActionBotException, FactoryMethodException
	{
		IPageCreatePCard createPCard = FactoryPage.getInstanceOf(IPageCreatePCardImpl.class);
		return createPCard.fillIssuedToSupplier(driver, testCaseName, issuedTo);
	}

	public static String fillNameOnCard(WebDriver driver, String testCaseName, String nameOnCard) throws ActionBotException, FactoryMethodException
	{
		IPageCreatePCard createPCard = FactoryPage.getInstanceOf(IPageCreatePCardImpl.class);
		return createPCard.fillNameOnCard(driver, testCaseName, nameOnCard);
	}

	public static String selectExpiryMonthAndYear(WebDriver driver, String testCaseName, int month, int year) throws ActionBotException, FactoryMethodException
	{
		IPageCreatePCard createPCard = FactoryPage.getInstanceOf(IPageCreatePCardImpl.class);
		return createPCard.selectExpiryMonthAndYear(driver, testCaseName, "" + month, "" + year);
	}

	public static String fillSecurityKey(WebDriver driver, String testCaseName, String securityKey) throws ActionBotException, FactoryMethodException
	{
		IPageCreatePCard createPCard = FactoryPage.getInstanceOf(IPageCreatePCardImpl.class);
		return createPCard.fillSecurityKey(driver, testCaseName, securityKey);
	}

	public static String fillBillingCurrency(WebDriver driver, String testCaseName, String currency) throws ActionBotException, FactoryMethodException
	{
		IPageCreatePCard createPCard = FactoryPage.getInstanceOf(IPageCreatePCardImpl.class);
		return createPCard.fillBillingCurrency(driver, testCaseName, currency);
	}

	public static void clickOnLastBilledOnDatePicker(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreatePCard createPCard = FactoryPage.getInstanceOf(IPageCreatePCardImpl.class);
		createPCard.clickOnLastBilledOnDatePicker(driver, testCaseName);
	}

	public static String selectLastBilledOnDate(WebDriver driver, String testCaseName, int day, int month, int year) throws ActionBotException, FactoryMethodException
	{
		IPageCreatePCard createPCard = FactoryPage.getInstanceOf(IPageCreatePCardImpl.class);
		clickOnLastBilledOnDatePicker(driver, testCaseName);
		return createPCard.selectLastBilledOnDate(driver, testCaseName, "" + day, "" + month, "" + year);
	}

	public static String getLastBilledOnDate(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreatePCard createPCard = FactoryPage.getInstanceOf(IPageCreatePCardImpl.class);
		return createPCard.getLastBilledOnDate(driver, testCaseName);
	}

	public static String selectStatementFrequency(WebDriver driver, String testCaseName, String statementFrequency) throws ActionBotException, FactoryMethodException
	{
		IPageCreatePCard createPCard = FactoryPage.getInstanceOf(IPageCreatePCardImpl.class);
		return createPCard.selectStatementFrequency(driver, testCaseName, statementFrequency);
	}

	public static int fillCreditDays(WebDriver driver, String testCaseName, int creditDays) throws ActionBotException, FactoryMethodException
	{
		IPageCreatePCard createPCard = FactoryPage.getInstanceOf(IPageCreatePCardImpl.class);
		return createPCard.fillCreditDays(driver, testCaseName, creditDays);
	}

	public static String selectAllowedOUs(WebDriver driver, String testCaseName, String OU) throws ActionBotException, FactoryMethodException
	{
		IPageCreatePCard createPCard = FactoryPage.getInstanceOf(IPageCreatePCardImpl.class);
		return createPCard.selectAllowedOUs(driver, testCaseName, OU);
	}

	public static int fillSpendPerTransaction(WebDriver driver, String testCaseName, int amount) throws ActionBotException, FactoryMethodException
	{
		IPageCreatePCard createPCard = FactoryPage.getInstanceOf(IPageCreatePCardImpl.class);
		return createPCard.fillSpendPerTransaction(driver, testCaseName, amount);
	}

	public static int fillSpendPerDay(WebDriver driver, String testCaseName, int amount) throws ActionBotException, FactoryMethodException
	{
		IPageCreatePCard createPCard = FactoryPage.getInstanceOf(IPageCreatePCardImpl.class);
		return createPCard.fillSpendPerDay(driver, testCaseName, amount);
	}

	public static int fillSpendPerCycle(WebDriver driver, String testCaseName, int amount) throws ActionBotException, FactoryMethodException
	{
		IPageCreatePCard createPCard = FactoryPage.getInstanceOf(IPageCreatePCardImpl.class);
		return createPCard.fillSpendPerCycle(driver, testCaseName, amount);
	}

	public static int fillTransactionsPerDay(WebDriver driver, String testCaseName, int transactions) throws ActionBotException, FactoryMethodException
	{
		IPageCreatePCard createPCard = FactoryPage.getInstanceOf(IPageCreatePCardImpl.class);
		return createPCard.fillTransactionsPerDay(driver, testCaseName, transactions);
	}

	public static int fillTransactionsPerCycle(WebDriver driver, String testCaseName, int transactions) throws ActionBotException, FactoryMethodException
	{
		IPageCreatePCard createPCard = FactoryPage.getInstanceOf(IPageCreatePCardImpl.class);
		return createPCard.fillTransactionsPerCycle(driver, testCaseName, transactions);
	}

	public static void clickOnSelectCompany(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreatePCard createPCard = FactoryPage.getInstanceOf(IPageCreatePCardImpl.class);
		createPCard.clickOnSelectCompany(driver, testCaseName);
	}

	public static void clickOnMatchSupplierInvoiceCheckBox(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreatePCard createPCard = FactoryPage.getInstanceOf(IPageCreatePCardImpl.class);
		createPCard.clickOnMatchSupplierInvoiceCheckBox(driver, testCaseName);
	}

	public static void clickOnActivatePCardButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreatePCard createPCard = FactoryPage.getInstanceOf(IPageCreatePCardImpl.class);
		createPCard.clickOnActivatePCardButton(driver, testCaseName);
	}

	public static void clickOnSavePCardButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreatePCard createPCard = FactoryPage.getInstanceOf(IPageCreatePCardImpl.class);
		createPCard.clickOnSavePCardButton(driver, testCaseName);
	}

	public static void clickOnCancelPCardButton(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreatePCard createPCard = FactoryPage.getInstanceOf(IPageCreatePCardImpl.class);
		createPCard.clickOnCancelPCardButton(driver, testCaseName);
	}

	public static boolean isAddPCardButtonPresent(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreatePCard createPCard = FactoryPage.getInstanceOf(IPageCreatePCardImpl.class);
		return createPCard.isAddPCardButtonPresent(driver, testCaseName);
	}

	public static String getPcardSaveError(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreatePCard createPCard = FactoryPage.getInstanceOf(IPageCreatePCardImpl.class);
		return createPCard.getPcardSaveError(driver, testCaseName);
	}

	public static String getUserLimitError(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreatePCard createPCard = FactoryPage.getInstanceOf(IPageCreatePCardImpl.class);
		return createPCard.getUsesLimitError(driver, testCaseName);
	}

	/**
	 * @author omkar.jagdale
	 *         method to get the card no error
	 */
	public static String getCardNoError(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreatePCard createPCard = FactoryPage.getInstanceOf(IPageCreatePCardImpl.class);
		return createPCard.getCardNoError(driver, testCaseName);
	}
	
	/**
	 * @author omkar.jagdale
	 *         method to get Pcard number
	 */
	public static String getPCardNumber(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		IPageCreatePCard createPCard = FactoryPage.getInstanceOf(IPageCreatePCardImpl.class);
		return createPCard.getPCardNumber(driver, testCaseName);
	}

}
