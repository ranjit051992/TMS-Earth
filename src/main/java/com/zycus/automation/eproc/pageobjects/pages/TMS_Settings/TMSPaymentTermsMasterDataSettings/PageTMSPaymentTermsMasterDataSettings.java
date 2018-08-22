package com.zycus.automation.eproc.pageobjects.pages.TMS_Settings.TMSPaymentTermsMasterDataSettings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public class PageTMSPaymentTermsMasterDataSettings
{
	static String		INACTIVE						= "Inactive";
	static String		ACTIVE							= "Active";
	static UI_Elements	TEXTBOX_SEARCH_PT_TMS			= UIFactory.getElements("TEXTBOX_SEARCH_PT_TMS");
	static UI_Elements	SELECT_PT_OPTIONS_TMS			= UIFactory.getElements("SELECT_PT_OPTIONS_TMS");
	static UI_Elements	BUTTON_GO_PT_TMS				= UIFactory.getElements("BUTTON_GO_PT_TMS");
	static UI_Elements	TEXTBOX_PAYMENT_TERM_NAME_TMS	= UIFactory.getElements("TEXTBOX_PAYMENT_TERM_NAME_TMS");
	static UI_Elements	BUTTON_UPDATE_PT_TMS			= UIFactory.getElements("BUTTON_UPDATE_PT_TMS");

	static String		paymentTerms_xpath1				= ".//*[@id='payTermListing']//td[";
	static String		paymentTerms_xpath2				= "]";
	static String		actionsPaymentTerms_xpath1		= ".//*[@id='payTermListing']//tr[";
	static String		editPaymentTerms_xpath			= "]//a[contains(@class,'edit')]";
	static String		activePaymentTerms_xpath		= "]//a[contains(@class,'active')]";
	static String		deactivePaymentTerms_xpath		= "]//a[contains(@class,'deactive')]";

	public static String enterInSearch(WebDriver driver, String testCaseName, String search) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before filling in search box");
		String str = ActionBot.sendKeys(driver, TEXTBOX_SEARCH_PT_TMS, search);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After filing search box");
		return str;
	}

	public static String selectPaymentTermsOption(WebDriver driver, String testCaseName, String option) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before selecting PT option");
		ActionBot.defaultSleep();
		String str = ActionBot.selectElement(driver, SELECT_PT_OPTIONS_TMS, IConstantsData.SELECT_BY_VISIBLE_TEXT, option);
		ScreenShot.screenshot(driver, testCaseName, "After selecting PT option");
		return str;
	}

	public static void clickonOnGO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clickon on GO");
		ActionBot.click(driver, BUTTON_GO_PT_TMS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on GO");
	}

	public static String getPaymentTermsOfFirstRow(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		return ActionBot.getTextWithInElement(driver, By.xpath(paymentTerms_xpath1 + index + paymentTerms_xpath2));
	}

	public static void clickOnEditLink(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(actionsPaymentTerms_xpath1 + index + editPaymentTerms_xpath));
	}

	public static String fillPaymentTermName(WebDriver driver, String testCaseName, String paymentTerm) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before filling in PT name");
		String str = ActionBot.sendKeys(driver, TEXTBOX_PAYMENT_TERM_NAME_TMS, paymentTerm);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After filing in PT name");
		return str;
	}

	public static void clickOnUpdatePaymentTerm(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_UPDATE_PT_TMS);
	}

	public static void clickOnActiveLink(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(actionsPaymentTerms_xpath1 + index + activePaymentTerms_xpath));
	}

	public static void clickOnDeactiveLink(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(actionsPaymentTerms_xpath1 + index + deactivePaymentTerms_xpath));
	}
}
