package com.zycus.automation.eproc.pageobjects.modals.purchaseordersummarycostbooking;

import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.modals.FactoryModal;
import com.zycus.automation.exception.ActionBotException;

public class ModalPOSummaryCostBooking
{

	public static void clearAndclickOnProject(WebDriver driver, String testCaseName) throws ActionBotException

	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		iModalPOSummaryCostBookingImpl.clearAndclickOnProject(driver, testCaseName);
	}

	public static String clearandfillInProjectField(WebDriver driver, String testCaseName, String projectField) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		return iModalPOSummaryCostBookingImpl.clearandfillInProjectField(driver, testCaseName, projectField);
	}

	public static String clearProjectField(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		return iModalPOSummaryCostBookingImpl.clearProjectField(driver, testCaseName);
	}

	public static void clickOnCancel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		iModalPOSummaryCostBookingImpl.clickOnCancel(driver, testCaseName);
	}

	public static void clickOnNoRadioBttn(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		iModalPOSummaryCostBookingImpl.clickOnNoRadioBttn(driver, testCaseName);
	}

	public static void clickOnProjectField(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		iModalPOSummaryCostBookingImpl.clickOnProjectField(driver, testCaseName);

	}

	public static void clickOnSave(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		iModalPOSummaryCostBookingImpl.clickOnSave(driver, testCaseName);
	}

	public static String fillInBudgetField(WebDriver driver, String testCaseName, String budgetField) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		return iModalPOSummaryCostBookingImpl.fillInBudgetField(driver, testCaseName, budgetField);
	}

	public static String fillInCostCenterField(WebDriver driver, String testCaseName, String costCenterField) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		return iModalPOSummaryCostBookingImpl.fillInCostCenterField(driver, testCaseName, costCenterField);
	}

	public static String fillInProjectField(WebDriver driver, String testCaseName, String projectField) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		return iModalPOSummaryCostBookingImpl.fillInProjectField(driver, testCaseName, projectField);
	}

	public static String getAssignProjectToPurchaseCost(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		String input = iModalPOSummaryCostBookingImpl.getAssignProjectToPurchaseCost(driver, testCaseName);
		return input;

	}

	public static String getProjecduration(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		return iModalPOSummaryCostBookingImpl.getProjecduration(driver, testCaseName);
	}

	public static String getProjecmanagerInfo(WebDriver driver, String testCaseName) throws ActionBotException

	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		return iModalPOSummaryCostBookingImpl.getProjecmanagerInfo(driver, testCaseName);
	}

	public static String getProjecmanagerInfoField(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		return iModalPOSummaryCostBookingImpl.getProjecmanagerInfoField(driver, testCaseName);
	}

	public static String getProjectCodeAndProjectName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		return iModalPOSummaryCostBookingImpl.getProjectCodeAndProjectName(driver, testCaseName);
	}

	public static String getProjectCodeInfo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		return iModalPOSummaryCostBookingImpl.getProjectCodeInfo(driver, testCaseName);
	}

	public static String getProjectFieldname(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		return iModalPOSummaryCostBookingImpl.getProjectFieldname(driver, testCaseName);
	}

	public static String getHeaderLevelCostingDetails(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		return iModalPOSummaryCostBookingImpl.getHeaderLevelCostingDetails(driver, testCaseName);
	}

	public static String getHeaderLevelProjectDetails(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		return iModalPOSummaryCostBookingImpl.getHeaderLevelProjectDetails(driver, testCaseName);
	}

	public static String getProjectNameInfo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		return iModalPOSummaryCostBookingImpl.getProjectNameInfo(driver, testCaseName);
	}

	public static void hoverOnInfoIcon(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		iModalPOSummaryCostBookingImpl.hoverOnInfoIcon(driver, testCaseName);

	}

	public static boolean isAutocompleteFieldOfProjectDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		boolean input = iModalPOSummaryCostBookingImpl.isAutocompleteFieldOfProjectDisplayed(driver, testCaseName);
		return input;
	}

	public static boolean isDurationFieldPresentInInfoIcon(WebDriver driver, String testCaseName, int index1) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		return iModalPOSummaryCostBookingImpl.isDurationFieldPresentInInfoIcon(driver, testCaseName, index1);
	}

	public static boolean isElementAssignProjectToPurchaseCostDisabled(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		boolean input = iModalPOSummaryCostBookingImpl.isElementAssignProjectToPurchaseCostDisabled(driver, testCaseName);
		return input;
	}

	public static boolean isElementNoSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		boolean input = iModalPOSummaryCostBookingImpl.isElementNoSelected(driver, testCaseName);
		return input;
	}

	public static boolean isElementYesSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		boolean input = iModalPOSummaryCostBookingImpl.isElementYesSelected(driver, testCaseName);
		return input;
	}

	public static boolean isFieldProjectDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		boolean input = iModalPOSummaryCostBookingImpl.isFieldProjectDisplayed(driver, testCaseName);
		return input;
	}

	public static boolean isFieldReset(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		return iModalPOSummaryCostBookingImpl.isFieldReset(driver, testCaseName);

	}

	public static boolean isInfoIconDisplayed(WebDriver driver, String testCaseName) throws ActionBotException

	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		return iModalPOSummaryCostBookingImpl.isInfoIconDisplayed(driver, testCaseName);
	}

	public static boolean isInfoIconPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		return iModalPOSummaryCostBookingImpl.isInfoIconPresent(driver, testCaseName);
	}

	public static boolean isProjectCodeAndProjectNameFieldPresentInInfoIcon(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		return iModalPOSummaryCostBookingImpl.isProjectCodeAndProjectNameFieldPresentInInfoIcon(driver, testCaseName);
	}

	public static boolean isProjectFieldEmpty(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		return iModalPOSummaryCostBookingImpl.isProjectFieldEmpty(driver, testCaseName);
	}

	public static boolean isProjectInAutocompleteFieldPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		return iModalPOSummaryCostBookingImpl.isProjectInAutocompleteFieldPresent(driver, testCaseName);
	}

	public static boolean isProjectInfoIconDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		return iModalPOSummaryCostBookingImpl.isProjectInfoIconDisplayed(driver, testCaseName);
	}

	public static boolean isProjectManagerFieldPresentInInfoIcon(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		return iModalPOSummaryCostBookingImpl.isProjectManagerFieldPresentInInfoIcon(driver, testCaseName, index);
	}

	public static boolean isProjectOrTaskIconPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		return iModalPOSummaryCostBookingImpl.isProjectOrTaskIconPresent(driver, testCaseName);
	}

	public static boolean isRadioBottomSingleCostCenterSelected(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		return iModalPOSummaryCostBookingImpl.isRadioBottomSingleCostCenterSelected(driver, testCaseName);
	}

	public static boolean isTaskInfoIconDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		return iModalPOSummaryCostBookingImpl.isTaskInfoIconDisplayed(driver, testCaseName);
	}

	public static String getNonEditableCCFromReqToPO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		return iModalPOSummaryCostBookingImpl.getNonEditableCCFromReqToPO(driver, testCaseName);
	}

	public static void clickOnYESradioButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		iModalPOSummaryCostBookingImpl.clickOnYESradioButton(driver, testCaseName);
	}

	public static String getCostCenterName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		return iModalPOSummaryCostBookingImpl.getCostCenterName(driver, testCaseName);
	}

	public static String getBudgetName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		return iModalPOSummaryCostBookingImpl.getBudgetName(driver, testCaseName);
	}

	public static String getProjectName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		return iModalPOSummaryCostBookingImpl.getProjectName(driver, testCaseName);
	}

	public static void clearCostCenterField(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		iModalPOSummaryCostBookingImpl.clearCostCenterField(driver, testCaseName);
	}

	public static String getLabelValueOfProjectField(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		return iModalPOSummaryCostBookingImpl.getLabelValueOfProjectField(driver, testCaseName);
	}

	public static boolean isProjectErrorPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		return iModalPOSummaryCostBookingImpl.isProjectErrorPresent(driver, testCaseName);
	}

	/**
	 * @author omkar.jagdale
	 *         method to check radio button single cost center is enable or not
	 */
	public static boolean isRadioBottonSingleCostCenterEnable(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		return iModalPOSummaryCostBookingImpl.isRadioBottonSingleCostCenterEnable(driver, testCaseName);
	}

	public static String getHeaderLevelBudgetDetails(WebDriver driver, String testCaseName) throws ActionBotException
	{
		IModalPOSummaryCostBookingImpl iModalPOSummaryCostBookingImpl = FactoryModal.getInstanceOfStandardPO();
		return iModalPOSummaryCostBookingImpl.getHeaderLevelBudgetDetails(driver, testCaseName);
	}
}
