package com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryCostBooking;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.bo.Requisition;
import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;
import com.zycus.framework.framework_version_2_4.framework_exception.TestCaseException;

public interface IModelItemSummaryCostBooking
{

	final static UI_Elements	COSTBOOKING_ITEM_SPLIT_OPTION_PERCENT				= UIFactory.getElements("COSTBOOKING_ITEM_SPLIT_OPTION_PERCENT");
	final static UI_Elements	COSTBOOKING_ITEM_SPLIT_OPTION_QUANTITY				= UIFactory.getElements("COSTBOOKING_ITEM_SPLIT_OPTION_QUANTITY");
	final static UI_Elements	COSTBOOKING_ITEM_SPLIT_OPTION_QTY_DELIVERY			= UIFactory.getElements("COSTBOOKING_ITEM_SPLIT_OPTION_QTY_DELIVERY");

	final static UI_Elements	COSTBOOKING_OPTION_HEADER_SPLIT						= UIFactory.getElements("COSTBOOKING_OPTION_HEADER_SPLIT");
	final static UI_Elements	COSTBOOKING_OPTION_ITEM_SPLIT						= UIFactory.getElements("COSTBOOKING_OPTION_ITEM_SPLIT");
	final static UI_Elements	COSTBOOKING_HEADER_SPLIT_COSTCENTER					= UIFactory.getElements("COSTBOOKING_HEADER_SPLIT_COSTCENTER");
	final static UI_Elements	COSTBOOKING_HEADER_SPLIT_BUDGET						= UIFactory.getElements("COSTBOOKING_HEADER_SPLIT_BUDGET");
	final static UI_Elements	COSTBOOKING_HEADER_SPLIT_AMOUNT						= UIFactory.getElements("COSTBOOKING_HEADER_SPLIT_AMOUNT");
	final static UI_Elements	ITEMSUMMARY_ITEM_TOTALPRICE							= UIFactory.getElements("ITEMSUMMARY_ITEM_TOTALPRICE");
	final static UI_Elements	Q_TIP_ACCOUNTING_INFO								= UIFactory.getElements("Q_TIP_ACCOUNTING_INFO");
	final static UI_Elements	MESSAGE_ACCOUNTING_INFO_OF_Q_TIP					= UIFactory.getElements("MESSAGE_ACCOUNTING_INFO_OF_Q_TIP");
	final static UI_Elements	BUTTON_SAVE_ITEM_SUMMARY_BUYERS_DESK				= UIFactory.getElements("BUTTON_SAVE_ITEM_SUMMARY_BUYERS_DESK");
	final static UI_Elements	BUTTON_CANCEL_ITEM_SUMMARY_BUYERS_DESK				= UIFactory.getElements("BUTTON_CANCEL_ITEM_SUMMARY_BUYERS_DESK");
	final static UI_Elements	LIST_OF_GL_ACCOUNTS_AVAILABLE_FOR_SELECTION			= UIFactory.getElements("LIST_OF_GL_ACCOUNTS_AVAILABLE_FOR_SELECTION");
	final static UI_Elements	NON_EDITABLE_SPLIT_PROJECT_LABEL_AT_ITEM_SUMMARY	= UIFactory.getElements("NON_EDITABLE_SPLIT_PROJECT_LABEL_AT_ITEM_SUMMARY");
	final static UI_Elements	SPLITCOSTINGLEVEL_HEADER_LINK						= UIFactory.getElements("SPLITCOSTINGLEVEL_HEADER_LINK");
	UI_Elements					LIST_OF_COST_CENTERS_IN_REQUISITION_ITEM_SUMMARY	= UIFactory.getElements("LIST_OF_COST_CENTERS_IN_REQUISITION_ITEM_SUMMARY");
	UI_Elements					LIST_OF_PROJECT_IN_REQUISITION_ITEM_SUMMARY			= UIFactory.getElements("LIST_OF_PROJECT_IN_REQUISITION_ITEM_SUMMARY");
	UI_Elements					LABEL_GL_ACCOUNT_AT_ITEM_LEVEL						= UIFactory.getElements("LABEL_GL_ACCOUNT_AT_ITEM_LEVEL");
	UI_Elements					GL_LEDGER_DETAILS									= UIFactory.getElements("GL_LEDGER_DETAILS");
	UI_Elements					GL_ACCOUNT_MANDATORY_SIGN							= UIFactory.getElements("GL_ACCOUNT_MANDATORY_SIGN");
	final static UI_Elements	LOADER_COA_FORM										= UIFactory.getElements("LOADER_COA_FORM");
	final static UI_Elements	COA_FORM_POPUP_LOADER								= UIFactory.getElements("COA_FORM_POPUP_LOADER");
	final static UI_Elements	COA_FORM_TEXT_BUSINESS_UNIT							= UIFactory.getElements("COA_FORM_TEXT_BUSINESS_UNIT");
	final static UI_Elements	COA_FORM_TEXT_GENERAL_LEDGER						= UIFactory.getElements("COA_FORM_TEXT_GENERAL_LEDGER");
	final static UI_Elements	COA_FORM_TEXT_COST_CENTER							= UIFactory.getElements("COA_FORM_TEXT_COST_CENTER");
	final static UI_Elements	COA_FORM_TEXT_PROJECT								= UIFactory.getElements("COA_FORM_TEXT_PROJECT");
	final static UI_Elements	COA_FORM_RADIO_PERCENTAGE							= UIFactory.getElements("COA_FORM_RADIO_PERCENTAGE");
	final static UI_Elements	COA_FORM_RADIO_QUANTITY								= UIFactory.getElements("COA_FORM_RADIO_QUANTITY");
	final static UI_Elements	COA_FORM_RADIO_AMOUNT								= UIFactory.getElements("COA_FORM_RADIO_AMOUNT");
	final static UI_Elements	COA_FORM_TEXT_PERCENTAGE							= UIFactory.getElements("COA_FORM_TEXT_PERCENTAGE");
	final static UI_Elements	COA_FORM_TEXT_QUANTITY								= UIFactory.getElements("COA_FORM_TEXT_QUANTITY");
	final static UI_Elements	COA_FORM_TEXT_AMOUNT								= UIFactory.getElements("COA_FORM_TEXT_AMOUNT");
	final static UI_Elements	COA_FORM_TEXT_SUB_ACCOUNT							= UIFactory.getElements("COA_FORM_TEXT_SUB_ACCOUNT");
	final static UI_Elements	COA_FORM_TEXT_PRODUCT								= UIFactory.getElements("COA_FORM_TEXT_PRODUCT");
	final static UI_Elements	COA_FORM_TEXT_GEO_ACCOUNT							= UIFactory.getElements("COA_FORM_TEXT_GEO_ACCOUNT");
	final static UI_Elements	COA_FORM_TEXT_OPERATIONAL_UNIT						= UIFactory.getElements("COA_FORM_TEXT_OPERATIONAL_UNIT");
	final static UI_Elements	COA_FORM_TEXT_FINAL_AMOUNT							= UIFactory.getElements("COA_FORM_TEXT_FINAL_AMOUNT");
	final static UI_Elements	COA_FORM_TEXT_BOOK_COST_TO							= UIFactory.getElements("COA_FORM_TEXT_BOOK_COST_TO");
	final static UI_Elements	COA_FORM_TEXT_CLIENT								= UIFactory.getElements("COA_FORM_TEXT_CLIENT");
	final static UI_Elements	COA_FORM_TEXT_EMPLOYEE_TIMEKEEPER					= UIFactory.getElements("COA_FORM_TEXT_EMPLOYEE_TIMEKEEPER");
	final static UI_Elements	COA_FORM_TEXT_COST_DISBURSEMENT_CODE				= UIFactory.getElements("COA_FORM_TEXT_COST_DISBURSEMENT_CODE");
	final static UI_Elements	COA_FORM_TEXT_DEPARTMENT							= UIFactory.getElements("COA_FORM_TEXT_DEPARTMENT");
	final static UI_Elements	COA_FORM_TEXT_TRANSACTION_DATE						= UIFactory.getElements("COA_FORM_TEXT_TRANSACTION_DATE");
	final static UI_Elements	COA_FORM_TEXT_DESCRIPTION							= UIFactory.getElements("COA_FORM_TEXT_DESCRIPTION");
	final static UI_Elements	COA_FORM_BUTTON_ADD									= UIFactory.getElements("COA_FORM_BUTTON_ADD");
	final static UI_Elements	COA_FORM_BUTTON_EDIT_FIRST_ITEM						= UIFactory.getElements("COA_FORM_BUTTON_EDIT_FIRST_ITEM");
	final static UI_Elements	COA_FORM_BUTTON_DELETE_FIRST_ITEM					= UIFactory.getElements("COA_FORM_BUTTON_DELETE_FIRST_ITEM");
	final static UI_Elements	ITEMSUMMARY_LABEL_ITEM_QUANTITY						= UIFactory.getElements("ITEMSUMMARY_LABEL_ITEM_QUANTITY");
	final static UI_Elements	ICON_EDIT_COA_FORM									= UIFactory.getElements("ICON_EDIT_COA_FORM");
	final static UI_Elements	ICON_DELETE_COA_FORM								= UIFactory.getElements("ICON_DELETE_COA_FORM");
	final static UI_Elements	ICON_EDIT_SAVE_COA_FORM								= UIFactory.getElements("ICON_EDIT_SAVE_COA_FORM");
	final static UI_Elements	ICON_EDIT_CANCEL_COA_FORM							= UIFactory.getElements("ICON_EDIT_CANCEL_COA_FORM");
	final static UI_Elements	COA_FORM_TEXT_BOOK_COST_TO_EDIT						= UIFactory.getElements("COA_FORM_TEXT_BOOK_COST_TO_EDIT");
	final static UI_Elements	COA_FORM_TEXT_CLIENT_EDIT							= UIFactory.getElements("COA_FORM_TEXT_CLIENT_EDIT");
	final static UI_Elements	COA_FORM_TEXT_EMPLOYEE_TIMEKEEPER_EDIT				= UIFactory.getElements("COA_FORM_TEXT_EMPLOYEE_TIMEKEEPER_EDIT");
	final static UI_Elements	COA_FORM_TEXT_COST_DISBURSEMENT_CODE_EDIT			= UIFactory.getElements("COA_FORM_TEXT_COST_DISBURSEMENT_CODE_EDIT");
	final static UI_Elements	COA_FORM_TEXT_DEPARTMENT_EDIT						= UIFactory.getElements("COA_FORM_TEXT_DEPARTMENT_EDIT");
	final static UI_Elements	COA_FORM_TEXT_TRANSACTION_DATE_EDIT					= UIFactory.getElements("COA_FORM_TEXT_TRANSACTION_DATE_EDIT");
	final static UI_Elements	COA_FORM_TEXT_DESCRIPTION_EDIT						= UIFactory.getElements("COA_FORM_TEXT_DESCRIPTION_EDIT");
	final static UI_Elements	COA_FORM_TEXT_PERCENTAGE_EDIT						= UIFactory.getElements("COA_FORM_TEXT_PERCENTAGE_EDIT");
	final static UI_Elements	COA_FORM_TEXT_QUANTITY_EDIT							= UIFactory.getElements("COA_FORM_TEXT_QUANTITY_EDIT");
	final static UI_Elements	COA_FORM_TEXT_AMOUNT_EDIT							= UIFactory.getElements("COA_FORM_TEXT_AMOUNT_EDIT");
	final static UI_Elements	COA_FORM_TEXT_BUSINESS_UNIT_EDIT					= UIFactory.getElements("COA_FORM_TEXT_BUSINESS_UNIT_EDIT");
	final static UI_Elements	COA_FORM_TEXT_GENERAL_LEDGER_EDIT					= UIFactory.getElements("COA_FORM_TEXT_GENERAL_LEDGER_EDIT");
	final static UI_Elements	COA_FORM_TEXT_COST_CENTER_EDIT						= UIFactory.getElements("COA_FORM_TEXT_COST_CENTER_EDIT");
	final static UI_Elements	COA_FORM_TEXT_PROJECT_EDIT							= UIFactory.getElements("COA_FORM_TEXT_PROJECT_EDIT");
	final static UI_Elements	COA_FORM_TEXT_SUB_ACCOUNT_EDIT						= UIFactory.getElements("COA_FORM_TEXT_SUB_ACCOUNT_EDIT");
	final static UI_Elements	COA_FORM_TEXT_PRODUCT_EDIT							= UIFactory.getElements("COA_FORM_TEXT_PRODUCT_EDIT");
	final static UI_Elements	COA_FORM_TEXT_GEO_ACCOUNT_EDIT						= UIFactory.getElements("COA_FORM_TEXT_GEO_ACCOUNT_EDIT");
	final static UI_Elements	COA_FORM_TEXT_OPERATIONAL_UNIT_EDIT					= UIFactory.getElements("COA_FORM_TEXT_OPERATIONAL_UNIT_EDIT");
	final static UI_Elements	ICON_BOOK_COST_TO_EDIT_CLOSE						= UIFactory.getElements("ICON_BOOK_COST_TO_EDIT_CLOSE");
	final static UI_Elements	ERROR_MESSAGE_COA_FORM								= UIFactory.getElements("ERROR_MESSAGE_COA_FORM");

	final static UI_Elements	TEXT_FIRST_SPLIT_PERCENTAGE							= UIFactory.getElements("TEXT_FIRST_SPLIT_PERCENTAGE");
	final static UI_Elements	TEXT_FIRST_SPLIT_QUANTITY							= UIFactory.getElements("TEXT_FIRST_SPLIT_QUANTITY");
	final static UI_Elements	TEXT_FIRST_SPLIT_AMOUNT								= UIFactory.getElements("TEXT_FIRST_SPLIT_AMOUNT");

	String						assetCodeXpath1										= ".//*[@id='assetCode_";
	String						assetCodeXpath2										= "']";

	// for click

	void clickCostBookingItemSplitAdd(WebDriver driver, String testCaseName, String itemID, int index) throws ActionBotException;

	void clickCostBookingItemSplitDelete(WebDriver driver, String testCaseName, String itemID, int index) throws ActionBotException;

	void clickOnBookCostTOSingleCostCenter(WebDriver driver, String testCaseName) throws ActionBotException;

	// for fill

	String fillCostBookingItemSplitBudget(WebDriver driver, String testCaseName, String itemSplitBudget, String itemID, int index) throws ActionBotException;

	String fillCostBookingItemSplitCostCenter(WebDriver driver, String testCaseName, String itemSplitCostCenter, String itemID, int index) throws ActionBotException;

	String fillCostBookingItemSplitProject(WebDriver driver, String testCaseName, String itemSplitProject, String itemID, int index) throws ActionBotException;

	int fillCostBookingItemSplitPercentage(WebDriver driver, String testCaseName, int itemSplitPercentage, String itemID, int index) throws ActionBotException;

	int fillCostBookingItemSplitQuantity(WebDriver driver, String testCaseName, int itemSplitQty, String itemID, int index) throws ActionBotException;

	// for get
	String getCostBookingItemSplitAmount(WebDriver driver, String testCaseName, String itemID, int index) throws ActionBotException;

	String getCostBookingSingleSplitAmount(WebDriver driver, String testCaseName) throws ActionBotException;

	String getCostBookingSingleSplitBudget(WebDriver driver, String testCaseName) throws ActionBotException;

	String getCostBookingSingleSplitCostCenter(WebDriver driver, String testCaseName) throws ActionBotException;

	String getCostCenterForCCSplitPropotionalToDelivery(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException;

	String getDeliverToForCCSplitPropotionalToDelivery(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException;

	String getDeliveryAddressForCCSplitPropotionalToDelivery(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException;

	int getQuantityForCCSplitPropotionalToDelivery(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException;

	String getAmountForCCSplitPropotionalToDelivery(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException;

	// for option selection
	boolean selectCostBookingOptionItemSplitPercent(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean selectCostBookingOptionItemSplitQtyDelivery(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean selectCostBookingOptionItemSplitQuantity(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean selectCostBookingOptionMultiSplit(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean selectCostBookingOptionSingleSplit(WebDriver driver, String testCaseName) throws ActionBotException;

	// changed as per accounting-cost booking merging feature
	String fillAccountingGLAccount(WebDriver driver, String testCaseName, String accountingGLAccountCode, String itemID, int index) throws ActionBotException;

	String getSubTotalPrice(WebDriver driver, String testCaseName) throws ActionBotException;

	String getMessageOfAccountingInfoFromQtip(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnSaveItemSummary(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickOnCancelItemSummary(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean isGLAccountPresent(WebDriver driver, String testCaseName, String id, int index) throws ActionBotException;

	public List<WebElement> getListOfAvailableGLAccounts(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<String> getListOfNamesAvailableGLAccounts(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clearGLAccounts(WebDriver driver, String testCaseName, String itemID, int index) throws ActionBotException, TestCaseException;

	public String getGLAccount(WebDriver driver, String testCaseName, String itemID, int index) throws ActionBotException, TestCaseException;

	public boolean isProjectNonEditable(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillAssetCode(WebDriver driver, String testCaseName, String assetCode, String itemID) throws ActionBotException, TestCaseException;

	public boolean isAssetCodeTextboxPresent(WebDriver driver, String testCaseName, String itemID) throws ActionBotException;

	public String getAssetCode(WebDriver driver, String testCaseName, String itemID) throws ActionBotException;

	public List<WebElement> getListOfCostCenters(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<String> getListOfCostCentersNames(WebDriver driver, String testCaseName) throws ActionBotException;

	String getCostBookingItemSplitCostCenter(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException;

	public void clearCostCenterWithSpace(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException;

	public List<WebElement> getListOfProjects(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<String> getListOfProjectNames(WebDriver driver, String testCaseName) throws ActionBotException;

	String getCostBookingItemSplitProject(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException;

	public void clearProjectWithSpace(WebDriver driver, String testCaseName, String itemId, int index) throws ActionBotException;

	public String getGLAccountHeaderAtItemLevel(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isGeneralLedgerDetailsPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isGlAccountMandatorySignPresent(WebDriver driver, String testCaseName) throws ActionBotException;

	// COA form Filling

	public void waitTillCOAFormLoaderDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillBU_CoaForm(WebDriver driver, String testCaseName, String businessUnit, boolean editForm) throws ActionBotException;

	public String fillGeneralLedger_CoaForm(WebDriver driver, String testCaseName, String generalLedger, boolean editForm) throws ActionBotException;

	public String fillCostCenter_CoaForm(WebDriver driver, String testCaseName, String costCenter, boolean editForm) throws ActionBotException;

	public String fillProject_CoaForm(WebDriver driver, String testCaseName, String project, boolean editForm) throws ActionBotException;

	public String clickCostBookingOnRadioButton_CoaForm(WebDriver driver, String testCaseName, String radioButtonName) throws ActionBotException;

	public String fillSubAccount_CoaForm(WebDriver driver, String testCaseName, String subAccount, boolean editForm) throws ActionBotException;

	public String fillProduct_CoaForm(WebDriver driver, String testCaseName, String product, boolean editForm) throws ActionBotException;

	public String fillGeoAccount_CoaForm(WebDriver driver, String testCaseName, String geoAccount, boolean editForm) throws ActionBotException;

	public String fillOperationalUnit_CoaForm(WebDriver driver, String testCaseName, String operationalUnit, boolean editForm) throws ActionBotException;

	public String fillPercentage_CoaForm(WebDriver driver, String testCaseName, String percentage, boolean editForm) throws ActionBotException;

	public String fillQuantity_CoaForm(WebDriver driver, String testCaseName, String quantity, boolean editForm) throws ActionBotException;

	public String fillAmount_CoaForm(WebDriver driver, String testCaseName, String amount, boolean editForm) throws ActionBotException;

	public boolean clickAddButton_CoaForm(WebDriver driver, String testCaseName) throws ActionBotException;

	public String fillBookCostTo_CoaForm(WebDriver driver, String testCaseName, String bookCostTo, boolean editForm) throws ActionBotException;

	public String fillClient_CoaForm(WebDriver driver, String testCaseName, String client, boolean editForm) throws ActionBotException;

	public String fillEmployeeTimekeeper_CoaForm(WebDriver driver, String testCaseName, String empTimeKeeper, boolean editForm) throws ActionBotException;

	public String fillCostDisbursementCode_CoaForm(WebDriver driver, String testCaseName, String costDisCode, boolean editForm) throws ActionBotException;

	public String fillDepartment_CoaForm(WebDriver driver, String testCaseName, String department, boolean editForm) throws ActionBotException;

	public void fillTransactionDate_CoaForm(WebDriver driver, String testCaseName, int day, int month, int year, boolean editForm) throws ActionBotException;

	public String fillDescription_CoaForm(WebDriver driver, String testCaseName, String description, boolean editForm) throws ActionBotException;

	public int getQuantityFromItemSummary(WebDriver driver, String testCaseName) throws ActionBotException;

	public void updateQuantityFromItemSummary(WebDriver driver, String testCaseName, int quantity) throws ActionBotException;

	public double getTotalAmountFromItemSummary(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnEditIcon_CoaForm(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnDeleteIcon_CoaForm(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSaveIcon_CoaForm(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnCancelIcon_CoaForm(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getErrorMessage_CoaForm(WebDriver driver, String testCaseName) throws ActionBotException;

}