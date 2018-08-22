package com.zycus.automation.eproc.pageobjects.pages.settings.supplierCodeMapMasterDataSetting;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public class PageSupplierCodeMapMasterDataSetting
{
	static UI_Elements	LINK_ADD_SUPPLIER_CODE_MAP					= UIFactory.getElements("LINK_ADD_SUPPLIER_CODE_MAP");
	static UI_Elements	SELECT_TYPE_OF_MAP							= UIFactory.getElements("SELECT_TYPE_OF_MAP");
	static UI_Elements	TEXTBOX_SUPPLIER_SIDE_CODE					= UIFactory.getElements("TEXTBOX_SUPPLIER_SIDE_CODE");
	static UI_Elements	TEXTBOX_SUPPLIER_NAME_IN_SUPPLIER_CODE_MAP	= UIFactory.getElements("TEXTBOX_SUPPLIER_NAME_IN_SUPPLIER_CODE_MAP");
	static UI_Elements	CHECKBOX_PUNCTOUTITEMS_OR_INVOICE			= UIFactory.getElements("CHECKBOX_PUNCTOUTITEMS_OR_INVOICE");
	static UI_Elements	CHECKBOX_PURCHASE_ORDERS					= UIFactory.getElements("CHECKBOX_PURCHASE_ORDERS");
	static UI_Elements	BUTTON_ADD_SUPPLIER_CODE_MAP				= UIFactory.getElements("BUTTON_ADD_SUPPLIER_CODE_MAP");
	static UI_Elements	TEXTBOX_SEARCH_SUPPLIER_CODE_MAP			= UIFactory.getElements("TEXTBOX_SEARCH_SUPPLIER_CODE_MAP");
	static UI_Elements	SELECT_SUPPLIER_CODE_MAP_FIELDS_OPTION		= UIFactory.getElements("SELECT_SUPPLIER_CODE_MAP_FIELDS_OPTION");
	static UI_Elements	BUTTON_GO_SUPPLIER_CODE_MAP					= UIFactory.getElements("BUTTON_GO_SUPPLIER_CODE_MAP");
	static UI_Elements	SELECT_SEARCH_TYPE_OF_MAP_OPTION			= UIFactory.getElements("SELECT_SEARCH_TYPE_OF_MAP_OPTION");
	static UI_Elements	LINK_EDIT_SUPPLIER_CODE_MAP					= UIFactory.getElements("LINK_EDIT_SUPPLIER_CODE_MAP");
	static UI_Elements	BUTTON_UPDATE_SUPPLIER_CODE_MAP				= UIFactory.getElements("BUTTON_UPDATE_SUPPLIER_CODE_MAP");
	static UI_Elements	LINK_CLEAR_RESULTS_SUPPLIER_CODE_MAP		= UIFactory.getElements("LINK_CLEAR_RESULTS_SUPPLIER_CODE_MAP");

	static String		supplier_code_xpath1						= ".//*[@id='txt";
	static String		supplier_code_xpath2						= "']";

	public static void clickOnAddSupplierCodeMap(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_ADD_SUPPLIER_CODE_MAP);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on add supplier code map link");

	}

	public static String selectTypeOfMap(WebDriver driver, String testCaseName, String typeOfMap) throws ActionBotException
	{
		return ActionBot.selectElement(driver, SELECT_TYPE_OF_MAP, IConstantsData.SELECT_BY_VISIBLE_TEXT, typeOfMap);
	}

	public static String fillSupplierSideCode(WebDriver driver, String testCaseName, String supplierSideCode) throws ActionBotException
	{
		return ActionBot.sendKeys(driver, TEXTBOX_SUPPLIER_SIDE_CODE, supplierSideCode);
	}

	public static String fillSystemCode(WebDriver driver, String testCaseName, String value, String systemCode) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, By.xpath("supplier_code_xpath1" + value + "supplier_code_xpath2"));
		ele.sendKeys(systemCode);
		ActionBot.defaultSleep();
		ele.sendKeys(Keys.ARROW_DOWN);
		ele.sendKeys(Keys.ENTER);
		ActionBot.defaultSleep();
		return systemCode;

	}

	public static String fillSupplierName(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException
	{
		return ActionBot.fillAutoCompleteField(driver, TEXTBOX_SUPPLIER_NAME_IN_SUPPLIER_CODE_MAP, supplierName);
	}

	public static void clickPunchoutItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_PUNCTOUTITEMS_OR_INVOICE);
	}

	public static void clickPurchaseOrders(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_PURCHASE_ORDERS);
	}

	public static void clickOnApplyAddSupplierCodeMap(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_ADD_SUPPLIER_CODE_MAP);
	}

	public static String fillSearch(WebDriver driver, String testCaseName, String supplierCodeMapOption) throws ActionBotException
	{
		return ActionBot.sendKeys(driver, TEXTBOX_SEARCH_SUPPLIER_CODE_MAP, supplierCodeMapOption);
	}

	public static String selectTypeOfMapOption(WebDriver driver, String testCaseName, String typeOfMap) throws ActionBotException
	{
		return ActionBot.selectElement(driver, SELECT_SEARCH_TYPE_OF_MAP_OPTION, IConstantsData.SELECT_BY_VISIBLE_TEXT, typeOfMap);
	}

	public static String selectSupplierCodeMapOptions(WebDriver driver, String testCaseName, String supplierCodeMapOptions) throws ActionBotException
	{
		return ActionBot.selectElement(driver, SELECT_SUPPLIER_CODE_MAP_FIELDS_OPTION, IConstantsData.SELECT_BY_VISIBLE_TEXT, supplierCodeMapOptions);
	}

	public static void clickOnGO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, BUTTON_GO_SUPPLIER_CODE_MAP);
		ActionBot.defaultSleep();
	}

	public static void clickOnEdit(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, LINK_EDIT_SUPPLIER_CODE_MAP);
		ActionBot.defaultSleep();
	}

	public static void clickOnButtonUpdateSupplierCodeMap(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, BUTTON_UPDATE_SUPPLIER_CODE_MAP);
		ActionBot.defaultSleep();
	}

	public static void clickOnClearResultsSupplierCodeMap(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, LINK_CLEAR_RESULTS_SUPPLIER_CODE_MAP);
		ActionBot.defaultSleep();
	}
}
