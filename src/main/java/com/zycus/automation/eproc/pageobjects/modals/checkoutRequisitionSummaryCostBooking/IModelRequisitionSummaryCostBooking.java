package com.zycus.automation.eproc.pageobjects.modals.checkoutRequisitionSummaryCostBooking;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.framework.dom_parser.framework.UI_Elements;

public interface IModelRequisitionSummaryCostBooking
{

	final static UI_Elements	COSTBOOKING_OPTION_SINGLE_CC							= UIFactory.getElements("COSTBOOKING_OPTION_SINGLE_CC");
	final static UI_Elements	COSTBOOKING_OPTION_MULTIPLE_CC							= UIFactory.getElements("COSTBOOKING_OPTION_MULTIPLE_CC");
	final static UI_Elements	COSTBOOKING_OPTION_LINEITEM_CC							= UIFactory.getElements("COSTBOOKING_OPTION_LINEITEM_CC");
	final static UI_Elements	COSTBOOKING_SINGLE_CC									= UIFactory.getElements("COSTBOOKING_SINGLE_CC");
	final static UI_Elements	COSTBOOKING_ITEMLEVEL_CC_NAME							= UIFactory.getElements("COSTBOOKING_ITEMLEVEL_CC_NAME");
	final static UI_Elements	COSTBOOKING_ITEMLEVEL_CC_AMOUNT							= UIFactory.getElements("COSTBOOKING_ITEMLEVEL_CC_AMOUNT");
	final static UI_Elements	COSTBOOKING_TOTAL_AMOUNT								= UIFactory.getElements("COSTBOOKING_TOTAL_AMOUNT");
	final static UI_Elements	COSTBOOKING_SINGLE_BUDGET								= UIFactory.getElements("COSTBOOKING_SINGLE_BUDGET");
	final static UI_Elements	COSTBOOKING_ITEMLEVEL_CC_BUDGET							= UIFactory.getElements("COSTBOOKING_ITEMLEVEL_CC_BUDGET");
	final static UI_Elements	COSTBOOKING_SINGLE_PROJECT								= UIFactory.getElements("COSTBOOKING_SINGLE_PROJECT");
	final static UI_Elements	MODAL_CHECKOUT_COSTBOOKING_YES_RADIO_BUTTON				= UIFactory.getElements("MODAL_CHECKOUT_COSTBOOKING_YES_RADIO_BUTTON");
	final static UI_Elements	MODAL_CHECKOUT_COSTBOOKING_NO_RADIO_BUTTON				= UIFactory.getElements("MODAL_CHECKOUT_COSTBOOKING_NO_RADIO_BUTTON");
	final static UI_Elements	COSTBOOKING_HEADER_PROJECT_TOOL_TIP						= UIFactory.getElements("COSTBOOKING_HEADER_PROJECT_TOOL_TIP");
	final static UI_Elements	COSTBOOKING_HEADER_PROJECT_TOOL_TIP_DETAILS				= UIFactory.getElements("COSTBOOKING_HEADER_PROJECT_TOOL_TIP_DETAILS");

	final static UI_Elements	RADIO_BUTTON_ALLOW_BUDGET_UTILIZATION_YES				= UIFactory.getElements("RADIO_BUTTON_ALLOW_BUDGET_UTILIZATION_YES");
	final static UI_Elements	RADIO_BUTTON_ALLOW_BUDGET_UTILIZATION_NO				= UIFactory.getElements("RADIO_BUTTON_ALLOW_BUDGET_UTILIZATION_NO");
	final static UI_Elements	COSTING_SPLIT_ITEM_LEVEL_CONTENT_COSTBOOKING_SUMMARY	= UIFactory.getElements("COSTING_SPLIT_ITEM_LEVEL_CONTENT_COSTBOOKING_SUMMARY");
	UI_Elements					LIST_OF_COST_CENTERS_IN_REQUISITION_SUMMARY				= UIFactory.getElements("LIST_OF_COST_CENTERS_IN_REQUISITION_SUMMARY");
	UI_Elements					LIST_OF_PROJECT_IN_REQUISITION_SUMMARY					= UIFactory.getElements("LIST_OF_PROJECT_IN_REQUISITION_SUMMARY");

	UI_Elements					LABEL_COST_CENTER_AT_HEADER_LEVEL						= UIFactory.getElements("LABEL_COST_CENTER_AT_HEADER_LEVEL");
	UI_Elements					LABEL_PROJECT_AT_HEADER_LEVEL							= UIFactory.getElements("LABEL_PROJECT_AT_HEADER_LEVEL");

	UI_Elements					LABEL_BUDGET_AT_HEADER_LEVEL							= UIFactory.getElements("LABEL_BUDGET_AT_HEADER_LEVEL");

	//client specific- QTS

	UI_Elements					NO_ALLOW_BUDGET_UTILIZATION								= UIFactory.getElements("NO_ALLOW_BUDGET_UTILIZATION");

	void clickMultiAddCostCenter(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	void clickYesAssignToPurchaseCost(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickNoAssignToPurchaseCost(WebDriver driver, String testCaseName) throws ActionBotException;

	void clickMultiDeleteCostCenter(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String fillCostBookingSingleBudget(WebDriver driver, String testCaseName, String costBookingSingleBudget) throws ActionBotException;

	String fillCostBookingSingleCC(WebDriver driver, String testCaseName, String costBookingSingleCC) throws ActionBotException;

	String fillCostBookingSingleProject(WebDriver driver, String testCaseName, String costBookingSingleProject) throws ActionBotException;

	String fillMultiCostCenterBudget(WebDriver driver, String testCaseName, String multiCostCenterBudget, int index) throws ActionBotException;

	String fillMultiCostCenterName(WebDriver driver, String testCaseName, String multiCostCenterName, int index) throws ActionBotException;

	int fillMultiCostCenterPercent(WebDriver driver, String testCaseName, int multiCostCenterPercent, int index) throws ActionBotException;

	String getCostBookingItemLevelCCAmount(WebDriver driver, String testCaseName) throws ActionBotException;

	String getCostBookingItemLevelCCBudget(WebDriver driver, String testCaseName) throws ActionBotException;

	String getCostBookingItemLevelCCName(WebDriver driver, String testCaseName) throws ActionBotException;

	String getCostBookingMultiCostCenterAmount(WebDriver driver, String testCaseName, int index) throws ActionBotException;

	String getCostBookingTotalAmount(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean selectCostBookingOptionLineItemCC(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean selectCostBookingOptionMultipleCC(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean isselectCostBookingOptionMultipleCCDisplayed(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean selectCostBookingOptionSingleCC(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean isAssingToPurchasOrderRedioBtnYesSelected(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean isAssingToPurchasOrderRedioBtnNOSelected(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean isAssingToPurchasOrderRedioDisabled(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean isCostbookingSingleCCRadioBtnSelected(WebDriver driver, String testCaseName) throws ActionBotException;

	boolean isReqSummaryProjectToolTipContainsProjectDetails(WebDriver driver, String testCaseName) throws ActionBotException;

	String fillMultiCostCenterProject(WebDriver driver, String testCaseName, String multiCostCenterProject, int index) throws ActionBotException;

	boolean isCCSplitAtItemLevelContentPresentAtHeader(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getListOfCostCenters(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<String> getListOfCostCentersNames(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getCostCenterName(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<WebElement> getListOfPrjects(WebDriver driver, String testCaseName) throws ActionBotException;

	public List<String> getListOfProjectNames(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getProjectName(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clearCostCenterWithSpace(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clearProjectWithSpace(WebDriver driver, String testCaseName) throws ActionBotException;

	public String getCostCenterLabelAtHeaderLevel(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickOnSinglePoject(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickNoAllowBudgetUtilization(WebDriver driver, String testCaseName) throws ActionBotException;

	public void clickYesAllowBudgetUtilization(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isYesAllowBudgetUtilization(WebDriver driver, String testCaseName) throws ActionBotException;

	public boolean isNoAllowBudgetUtilization(WebDriver driver, String testCaseName) throws ActionBotException;
}
