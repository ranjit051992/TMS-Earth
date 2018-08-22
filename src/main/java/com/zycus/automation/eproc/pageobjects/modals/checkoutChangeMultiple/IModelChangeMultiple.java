package com.zycus.automation.eproc.pageobjects.modals.checkoutChangeMultiple;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModelChangeMultiple
{
	final static UI_Elements	CHANGE_MULTIPLE_COST_CENTER										= UIFactory.getElements("CHANGE_MULTIPLE_COST_CENTER");
	final static UI_Elements	CHANGE_MULTIPLE_BUDGET											= UIFactory.getElements("CHANGE_MULTIPLE_BUDGET");
	final static UI_Elements	CHANGE_MULTIPLE_DATE											= UIFactory.getElements("CHANGE_MULTIPLE_DATE");
	final static UI_Elements	CHANGE_MULTIPLE_CLEAR_DATE										= UIFactory.getElements("CHANGE_MULTIPLE_CLEAR_DATE");
	final static UI_Elements	CHANGE_MULTIPLE_APPLY											= UIFactory.getElements("CHANGE_MULTIPLE_APPLY");
	final static UI_Elements	CHANGE_MULTIPLE_CLOSE											= UIFactory.getElements("CHANGE_MULTIPLE_CLOSE");
	final static UI_Elements	LIST_OF_GL_ACCOUNTS_AVAILABLE_FOR_SELECTION_UPDATE_ALL_LINES	= UIFactory
		.getElements("LIST_OF_GL_ACCOUNTS_AVAILABLE_FOR_SELECTION_UPDATE_ALL_LINES");
	final static UI_Elements	CHANGE_MULTIPLE_GL_ACCOUNT										= UIFactory.getElements("CHANGE_MULTIPLE_GL_ACCOUNT");
	final static UI_Elements	TEXTBOX_SUPPLIER_UPDATE_ALL_LINES_BUYERS_DESK					= UIFactory.getElements("TEXTBOX_SUPPLIER_UPDATE_ALL_LINES_BUYERS_DESK");
	final static UI_Elements	UPDATE_ALL_LINES_COST_CENTER									= UIFactory.getElements("UPDATE_ALL_LINES_COST_CENTER");
	UI_Elements					TEXTBOX_PROJECT_CHANGE_MULTIPLE									= UIFactory.getElements("TEXTBOX_PROJECT_CHANGE_MULTIPLE");
	UI_Elements					DATE_PICKER_REQUIRED_BY_DATE_CHANGE_MULTIPLE					= UIFactory.getElements("DATE_PICKER_REQUIRED_BY_DATE_CHANGE_MULTIPLE");
	final static UI_Elements	CHANGE_MULTIPLE_DELIVERY_TAB									= UIFactory.getElements("CHANGE_MULTIPLE_DELIVERY_TAB");
	final static UI_Elements	CHANGE_MULTIPLE_SUPPLIER_TAB									= UIFactory.getElements("CHANGE_MULTIPLE_SUPPLIER_TAB");

	void clickChangeMultipleApply(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickChangeMultipleClose(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickClearChangeMultipleDate(WebDriver driver, String testCaseName) throws ActionBotException;

	String fillChangeMultipleBudget(WebDriver driver, String testCaseName, String changeMultipleBudget) throws ActionBotException;

	String fillChangeMultipleCostCenter(WebDriver driver, String testCaseName, String changeMultipleCostCenter) throws ActionBotException;

	String fillChangeMultipleProject(WebDriver driver, String testCaseName, String project) throws ActionBotException;

	String getChangeMultipleDate(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getListOfAvailableGLAccounts(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<String> getListOfNamesAvailableGLAccounts(WebDriver driver, String testCaseName) throws ActionBotException;

	String fillChangeMultipleGLAccount(WebDriver driver, String testCaseName, String changeMultipleGLAccount) throws ActionBotException;

	public void clearChangeMultipleGLAccount(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillSupplierName(WebDriver driver, String testCaseName, String supplierName) throws ActionBotException;

	public String selectRequiredByDate(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException;

	public void clickDeliveryTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickSupplierTab(WebDriver driver, String testCaseName) throws ActionBotException;
}
