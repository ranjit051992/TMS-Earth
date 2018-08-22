/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.modals.purchaseorderitemsummarycostallocation;

import java.util.List;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

/**
 * @author ankita.sawant
 *
 */
public interface IModalPOItemSummaryCostAllocation
{
	static UI_Elements			TEXTBOX_STANDARD_PO_ITEM_SUMMARY_CC				= UIFactory.getElements("TEXTBOX_STANDARD_PO_ITEM_SUMMARY_CC");
	static UI_Elements			TEXTBOX_STANDARD_PO_ITEM_SUMMARY_PROJECT		= UIFactory.getElements("TEXTBOX_STANDARD_PO_ITEM_SUMMARY_PROJECT");
	static UI_Elements			TEXTBOX_STANDARD_PO_ITEM_SUMMARY_BUDGET			= UIFactory.getElements("TEXTBOX_STANDARD_PO_ITEM_SUMMARY_BUDGET");
	static UI_Elements			TEXTBOX_STANDARD_PO_ITEM_SUMMARY_AMOUNT			= UIFactory.getElements("TEXTBOX_STANDARD_PO_ITEM_SUMMARY_AMOUNT");
	static UI_Elements			LABEL_STANDARD_PO_ITEM_SUMMARY_AMOUNT_ASSIGNED	= UIFactory.getElements("LABEL_STANDARD_PO_ITEM_SUMMARY_AMOUNT_ASSIGNED");
	static UI_Elements			TAB_STANDARD_PO_ITEM_SUMMARY_COST_BOOKING		= UIFactory.getElements("TAB_STANDARD_PO_ITEM_SUMMARY_COST_BOOKING");
	final static UI_Elements	TEXTBOX_AMEND_ITEM_MARKET_PRICE					= UIFactory.getElements("TEXTBOX_AMEND_ITEM_MARKET_PRICE");
	final static UI_Elements	TEXTBOX_AMEND_ITEM_DESCRIPTION					= UIFactory.getElements("TEXTBOX_AMEND_ITEM_DESCRIPTION");
	final static UI_Elements	TEXTBOX_AMEND_ITEM_QUANTITY						= UIFactory.getElements("TEXTBOX_AMEND_ITEM_QUANTITY");
	final UI_Elements			TEXTBOX_GL_ACCOUNT_ITEM_SUMMARY					= UIFactory.getElements("TEXTBOX_GL_ACCOUNT_ITEM_SUMMARY");
	final UI_Elements			BUTTON_SAVE_ITEM_SUMMARY						= UIFactory.getElements("BUTTON_SAVE_ITEM_SUMMARY");
	final UI_Elements			BUTTON_CANCEL_ITEM_SUMMARY						= UIFactory.getElements("BUTTON_CANCEL_ITEM_SUMMARY");
	final UI_Elements			LABEL_PROJECT_ITEM_SUMMARY						= UIFactory.getElements("LABEL_PROJECT_ITEM_SUMMARY");
	final UI_Elements			PROJECT_OR_TASK_ICON_ITEM_SUMMARY				= UIFactory.getElements("PROJECT_OR_TASK_ICON_ITEM_SUMMARY");
	final UI_Elements			PROJECT_INFO_ICON_ITEM_SUMMARY					= UIFactory.getElements("PROJECT_INFO_ICON_ITEM_SUMMARY");
	final UI_Elements			ITEM_LEVEL_PROJECT_DETAILS						= UIFactory.getElements("ITEM_LEVEL_PROJECT_DETAILS");
	final UI_Elements			ITEM_LEVEL_COSTING_DETAILS						= UIFactory.getElements("ITEM_LEVEL_COSTING_DETAILS");
	final UI_Elements			LABEL_AMOUNT_ASSIGNED_COST_BOOKING_ITEM_SUMMARY	= UIFactory.getElements("LABEL_AMOUNT_ASSIGNED_COST_BOOKING_ITEM_SUMMARY");
	final UI_Elements			ACCOUNTING_ERROR_MSG							= UIFactory.getElements("ACCOUNTING_ERROR_MSG");
	UI_Elements					LIST_LABEL_GL_ACCOUNTS							= UIFactory.getElements("LIST_LABEL_GL_ACCOUNTS");

	final UI_Elements			LABEL_GL_ACCOUNT_ITEM_SUMMARY					= UIFactory.getElements("LABEL_GL_ACCOUNT_ITEM_SUMMARY");
	final UI_Elements			DELIVERY_TAB_MODAL_PO_ITEM_SUMMARY				= UIFactory.getElements("DELIVERY_TAB_MODAL_PO_ITEM_SUMMARY");
	final UI_Elements			OTHER_ADDRESS_MODAL_PO_ITEM_SUMMARY				= UIFactory.getElements("OTHER_ADDRESS_MODAL_PO_ITEM_SUMMARY");
	final UI_Elements			OTHER_ADDRESS_TEXTBOX_MODAL_ITEM_SUMMARY		= UIFactory.getElements("OTHER_ADDRESS_TEXTBOX_MODAL_ITEM_SUMMARY");

	public void clickOnCostBookingTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillAmount(WebDriver driver, String testCaseName, String amount) throws ActionBotException;

	public String clearAndfillAmount(WebDriver driver, String testCaseName, String amount) throws ActionBotException;

	public String fillBudget(WebDriver driver, String testCaseName, String budget) throws ActionBotException;

	public String fillCostCenter(WebDriver driver, String testCaseName, String costCenter) throws ActionBotException;

	public String fillProject(WebDriver driver, String testCaseName, String project) throws ActionBotException;

	public String getAmount(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isEditableAmendItemDescription(WebDriver driver) throws ActionBotException;

	public boolean isEditableAmendModelItemQuantity(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isEditableMarketPrice(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getCostCenter(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillGLAccount(WebDriver driver, String glAccount) throws ActionBotException;

	public boolean isGLAccountFieldFilled(WebDriver driver) throws ActionBotException;

	public void clickOnSave(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancel(WebDriver driver) throws ActionBotException;

	public boolean isGLAccountSameAsGLMap(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getGLAccount(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getTagNameOfProjectFieldLabel(WebDriver driver) throws ActionBotException;

	public String getItemlevelCostingdetails(WebDriver driver) throws ActionBotException;

	public String getItemlevelProjectdetails(WebDriver driver) throws ActionBotException;

	public boolean isProjectFieldALabel(WebDriver driver) throws Exception;

	public boolean isProjectOrTaskIconPresent(WebDriver driver) throws ActionBotException;

	public boolean isProjectInfoIconPresent(WebDriver driver) throws ActionBotException;

	public String getaccuntTypeErrorMsg(WebDriver driver, String accountTypeErrorMsg) throws ActionBotException;

	public boolean isGLAccountNotEmpty(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clearGLAccount(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<String> getListOfGLAccountsNames(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getProject(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getBudget(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDeliveryTab(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnOtherAddressOption(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillOtherDeliveryAddress(WebDriver driver, String testCaseName, String address) throws ActionBotException;
}
