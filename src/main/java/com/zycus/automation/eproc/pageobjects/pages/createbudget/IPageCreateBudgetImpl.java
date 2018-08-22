/**
 * 
 */
package com.zycus.automation.eproc.pageobjects.pages.createbudget;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.eproc.pageobjects.pages.budgetlisting.IPageBudgetListing;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.common.CommonUtilities;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class IPageCreateBudgetImpl implements IPageCreateBudget
{
	static Logger logger = Logger.getLogger(IPageCreateBudgetImpl.class);

	@Override
	public String fillOwnerName(WebDriver driver, String testCaseName, String ownerName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		String owner_name = ActionBot.fillAutoCompleteField(driver, INPUT_OWNER_NAME, ownerName);
		logger.info("Entered Owner Name : " + owner_name);
		return owner_name;
	}

	@Override
	public String fillCompanyName(WebDriver driver, String testCaseName, String companyName) throws ActionBotException
	{
		String company_name = ActionBot.fillAutoCompleteField(driver, INPUT_COMPANY_NAME, companyName);
		logger.info("Entered Company Name : " + company_name);
		return company_name;
	}

	@Override
	public String fillCurrencyType(WebDriver driver, String testCaseName, String currencyType) throws ActionBotException
	{
		String currency_type = null;
		if (currencyType != null)
		{
			currency_type = ActionBot.fillAutoCompleteField(driver, INPUT_CURRENCY_TYPE, currencyType);
		}
		else
		{
			int counter = CommonUtilities.getNonZeroRandomNumbers(1) + 1;
			if (counter >= 5)
			{
				while (counter >= 5)
				{
					counter = CommonUtilities.getNonZeroRandomNumbers(1) + 1;
					if (counter <= 5)
					{
						break;
					}
				}
			}
			WebElement element = ActionBot.findElement(driver, INPUT_CURRENCY_TYPE);
			element.clear();
			element.sendKeys(Keys.SPACE);
			ActionBot.defaultSleep();
			for (int i = 0; i < counter; i++)
			{
				element.sendKeys(Keys.ARROW_DOWN);
			}
			ActionBot.defaultSleep();
			element.sendKeys(Keys.ENTER);
			currency_type = element.getAttribute("value");
		}
		logger.info("Entered Currency Type : " + currency_type);
		ScreenShot.screenshot(driver, testCaseName, "After selecting currency type "+currency_type);
		return currency_type;
	}

	@Override
	public String fillBudgetName(WebDriver driver, String testCaseName, String budgetName) throws ActionBotException
	{
		String budget_name = ActionBot.fillAutoCompleteField(driver, INPUT_BUDGET_NAME, budgetName);
		logger.info("Entered Budget Name : " + budget_name);
		return budget_name;
	}

	@Override
	public String fillBudgetNotes(WebDriver driver, String testCaseName, String budgetNotes) throws ActionBotException
	{
		String budget_notes = ActionBot.sendKeys(driver, INPUT_BUDGET_NOTES, budgetNotes);
		logger.info("Entered Budget Notes : " + budget_notes);
		return budget_notes;
	}

	@Override
	public String selectBudgetValidityDateFrom(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException
	{
		ActionBot.click(driver, DATE_PICKER_VALIDITY_FROM);
		ActionBot.selectDate(driver, day, month, year);

		String fromValidityDate = ActionBot.findElement(driver, INPUT_FROM_VALIDITY_DATE).getAttribute("value").trim();
		logger.info("Selected From Validity Date : " + fromValidityDate);

		return fromValidityDate;
	}

	@Override
	public String selectBudgetValidityDateTo(WebDriver driver, String testCaseName, String day, String month, String year) throws ActionBotException
	{
		ActionBot.click(driver, DATE_PICKER_VALIDITY_TO);
		ActionBot.selectDate(driver, day, month, year);

		String toValidityDate = ActionBot.findElement(driver, INPUT_TO_VALIDITY_DATE).getAttribute("value").trim();
		logger.info("Selected To Validity Date : " + toValidityDate);

		return toValidityDate;
	}

	@Override
	public boolean selectDisplayUtilizationOfBudgetToApprovers(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_DISPLAY_UTILIZATION_OF_APPROVER);
		return ActionBot.isElementSelected(driver, CHECKBOX_DISPLAY_UTILIZATION_OF_APPROVER);
	}

	@Override
	public boolean selectDisplayUtilizationOfBudgetToRequesters(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, CHECKBOX_DISPLAY_UTILIZATION_OF_REQUESTER);
		return ActionBot.isElementSelected(driver, CHECKBOX_DISPLAY_UTILIZATION_OF_REQUESTER);
	}

	@Override
	public int fillPercentageConsumptionOfOwnerAsObserverToRequest(WebDriver driver, String testCaseName, int percentageConsumption) throws ActionBotException
	{
		ActionBot.sendKeys(driver, INPUT_OWNER_AS_OBSERVER_CONSUMPTION, Integer.toString(percentageConsumption));
		String percentage_consumption = ActionBot.getAttributeOfElement(driver, INPUT_OWNER_AS_OBSERVER_CONSUMPTION, "value");
		logger.info("Percentage consumption of owner as observer to request : " + percentage_consumption);
		return Integer.parseInt(percentage_consumption);
	}

	@Override
	public int fillPercentageConsumptionOfOwnerAsApproverToRequest(WebDriver driver, String testCaseName, int percentageConsumption) throws ActionBotException

	{
		ActionBot.sendKeys(driver, INPUT_OWNER_AS_APPROVER_CONSUMPTION, Integer.toString(percentageConsumption));
		String percentage_consumption = ActionBot.getAttributeOfElement(driver, INPUT_OWNER_AS_APPROVER_CONSUMPTION, "value");
		logger.info("Percentage consumption of owner as aprover to request : " + percentage_consumption);
		return Integer.parseInt(percentage_consumption);
	}

	@Override
	public void clickOnAddAnotherBudgetDimension(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_ADD_ANOTHER_BUDGET_DIMENSIONS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Button Another Budget Dimension");
	}

	@Override
	public void clickOnGenerateBudgetDimension(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_GENETARE_DIMENSIONS);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Button Generate Budget Dimension");
	}

	@Override
	public void clickOnAddBudgetLineButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_ADD_BUDGET_LINE);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Button Add Budget Line");
	}

	@Override
	public String fillBusinessUnit(WebDriver driver, String testCaseName, String BU) throws ActionBotException
	{
		String business_unit = ActionBot.fillAutoCompleteField(driver, INPUT_BUSINESS_UNIT_FOR_BUDGET_LINE, BU);
		logger.info("Entered Business Unit : " + business_unit);
		return business_unit;
	}

	@Override
	public String fillBudgetLineCode(WebDriver driver, String testCaseName, String budgetLineCode) throws ActionBotException
	{
		String budget_Line_Code = null;
		if (budgetLineCode != null)
		{
			budget_Line_Code = ActionBot.sendKeys(driver, INPUT_BUDGET_LINE_CODE, budgetLineCode);
		}
		else
		{
			ActionBot.click(driver, INPUT_BUDGET_LINE_CODE);
			budget_Line_Code = ActionBot.getAttributeOfElement(driver, INPUT_BUDGET_LINE_CODE, "value");
		}
		logger.info("Entered Budget Line Code : " + budget_Line_Code);
		return budget_Line_Code;
	}

	@Override
	public String fillBudgetLineName(WebDriver driver, String testCaseName, String budgetLineName) throws ActionBotException
	{
		String budget_line_name = ActionBot.sendKeys(driver, INPUT_BUDGET_LINE_NAME, budgetLineName);
		logger.info("Entered Budget Line Name : " + budget_line_name);
		return budget_line_name;
	}

	@Override
	public String fillBudgetLineOwner(WebDriver driver, String testCaseName, String ownerName) throws ActionBotException
	{
		String budget_line_owner = ActionBot.fillAutoCompleteField(driver, INPUT_BUDGET_LINE_OWNER_NAME, ownerName);
		logger.info("Entered Budget Line Owner Name : " + budget_line_owner);
		return budget_line_owner;
	}

	@Override
	public String fillPlannedAmount(WebDriver driver, String testCaseName, String amount) throws ActionBotException
	{
		String planned_amount = ActionBot.sendKeys(driver, INPUT_PLANNED_AMOUNT_FOR_BUDGET_LINE, amount);
		logger.info("Entered Planned Amount : " + planned_amount);
		return planned_amount;
	}

	@Override
	public void clickOnSaveBudgetLine(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on save budget line");
		ActionBot.click(driver, BUTTON_SAVE_ROW_FOR_BUDGET_LINE);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on save budget line");
	}

	@Override
	public void clickOnDeleteBudgetLine(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_DELETE_ROW_FOR_BUDGET_LINE);
	}

	@Override
	public String selectFirstBudgetPeriod(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.hover(driver, SELECT_BUDGET_PERIOD);
		String selectedBudgetPeriod = ActionBot.getTextWithInElement(driver, SELECT_FIRST_PERIOD_FOR_BUDGET);
		ActionBot.click(driver, SELECT_FIRST_PERIOD_FOR_BUDGET);
		logger.info("Selected Budget Period : " + selectedBudgetPeriod);
		return selectedBudgetPeriod;
	}

	@Override
	public void clickOnSaveAndFreezeBudgetButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Save and Freeze button");
		ActionBot.click(driver, BUTTON_SAVE_AND_FREEZE_BUDGET);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Save and Freeze button");
	}

	@Override
	public void clickOnSaveAsDraftButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "Before clicking on Save As Draft button");
		ActionBot.click(driver, BUTTON_SAVE_AS_DRAFT_BUDGET);
		ActionBot.defaultSleep();
		ActionBot.waitTillPopUpIsPresent(driver, IPageBudgetListing.PROCESSING_DIV_BUDGET_LISTING);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on Save As Draft button");
	}

	@Override
	public void clickOnCancelBudgetButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CANCEL_BUDGET);
	}

	@Override
	public String getFromValidityDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String fromValidityDate = ActionBot.findElement(driver, INPUT_FROM_VALIDITY_DATE).getAttribute("value").trim();
		logger.info("Selected From Validity Date : " + fromValidityDate);

		return fromValidityDate;
	}

	@Override
	public String getToValidityDate(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String toValidityDate = ActionBot.findElement(driver, INPUT_TO_VALIDITY_DATE).getAttribute("value").trim();
		logger.info("Selected To Validity Date : " + toValidityDate);

		return toValidityDate;
	}

	@Override
	public String selectBudgetDimension(WebDriver driver, String testCaseName, String dimension, int index) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, By.xpath(".//*[@id='budgetDefineOl']/li[" + index + "]//select[contains(@class,'dimensionSelect')]"));
		String selectedDimension = ActionBot.selectElement(driver, element, IConstantsData.SELECT_BY_VALUE, dimension);
		logger.info("Selected Dimension : " + selectedDimension);
		ActionBot.defaultSleep();
		return selectedDimension;
	}

	@Override
	public String fillBudgetLineLocation(WebDriver driver, String testCaseName, String location) throws ActionBotException
	{
		String enteredLocation = ActionBot.fillAutoCompleteField(driver, INPUT_LOCATION_FOR_BUDGET_LINE, location);
		logger.info("Entered budget line location : " + enteredLocation);
		return enteredLocation;
	}

	@Override
	public String fillBudgetLineCostCenter(WebDriver driver, String testCaseName, String costCenter) throws ActionBotException
	{
		String enteredCostCenter = ActionBot.fillAutoCompleteField(driver, INPUT_COST_CENTER_FOR_BUDGET_LINE, costCenter);
		logger.info("Entered budget line cost center : " + enteredCostCenter);
		return enteredCostCenter;
	}

	@Override
	public String selectBudgetLineDepartment(WebDriver driver, String testCaseName, String department) throws ActionBotException
	{
		/*
		 * String selectedDepartment = null; if (department != null) {
		 * selectedDepartment = ActionBot.selectElement(driver,
		 * SELECT_DEPARTMENT_FOR_BUDGET_LINE, IConstantsData.SELECT_BY_VALUE,
		 * department); } else { selectedDepartment =
		 * ActionBot.selectElement(driver, SELECT_DEPARTMENT_FOR_BUDGET_LINE,
		 * null, null);
		 * 
		 * } logger.info("Selected budget line department : " +
		 * selectedDepartment); return selectedDepartment;
		 */

		String enteredDepartment = ActionBot.fillAutoCompleteField(driver, SELECT_DEPARTMENT_FOR_BUDGET_LINE, department);
		logger.info("Entered budget line cost center : " + enteredDepartment);
		return enteredDepartment;
	}

	@Override
	public String selectBudgetLineDesignation(WebDriver driver, String testCaseName, String designation) throws ActionBotException
	{
		String selectedDesignation = null;
		if (designation != null)
		{
			selectedDesignation = ActionBot.selectElement(driver, SELECT_DESIGNATION_FOR_BUDGET_LINE, IConstantsData.SELECT_BY_VALUE, designation);
		}
		else
		{
			selectedDesignation = ActionBot.selectElement(driver, SELECT_DESIGNATION_FOR_BUDGET_LINE, null, null);
		}
		logger.info("Selected budget line designation : " + selectedDesignation);
		return selectedDesignation;
	}

	@Override
	public void clickOnAutoGenerateCombinations(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_AUTO_GENERATE_COMBINATIONS);
	}

	@Override
	public void clickOnUploadViaFile(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_UPLOAD_BUDGET_LINE_VIA_FILE);
	}

	@Override
	public String selectBudgetPeriod(WebDriver driver, String testCaseName, String periodName) throws ActionBotException
	{
		ActionBot.hover(driver, SELECT_BUDGET_PERIOD);
		WebElement element = ActionBot.findElement(driver,
			By.xpath(".//*[contains(@class,'drpDwnBxCnt-autowidth budgetPeriodContainer')]/a[contains(text(),'" + periodName + "')]"));
		String selectedPeriod = element.getText().trim();
		element.click();
		logger.info("Selected budget period : " + selectedPeriod);
		ScreenShot.screenshot(driver, testCaseName, "After selecting budget period");
		return selectedPeriod;
	}

	@Override
	public String getBusinessUnitOfBudgetLine(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String businessUnit = ActionBot.getTextWithInElement(driver,
			By.xpath(".//*[@id='budgetLineListingTable_budgetlistbx']//tr[" + index + "]/td[contains(@class,'BUSINESS_UNIT_column dimension_column')]"));
		logger.info("Business Unit : " + businessUnit);
		return businessUnit;
	}

	@Override
	public String getLocationOfBudgetLine(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String location = ActionBot.getTextWithInElement(driver,
			By.xpath(".//*[@id='budgetLineListingTable_budgetlistbx']//tr[" + index + "]/td[contains(@class,'LOCATION_column dimension_column')]"));
		logger.info("Location : " + location);
		return location;
	}

	@Override
	public String getCostCenterOfBudgetLine(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String costCenter = ActionBot.getTextWithInElement(driver,
			By.xpath(".//*[@id='budgetLineListingTable_budgetlistbx']//tr[" + index + "]/td[contains(@class,'COST_CENTER_column dimension_column')]"));
		logger.info("Cost Center : " + costCenter);
		return costCenter;
	}

	@Override
	public String getDepartmentOfBudgetLine(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String department = ActionBot.getTextWithInElement(driver,
			By.xpath(".//*[@id='budgetLineListingTable_budgetlistbx']//tr[" + index + "]/td[contains(@class,'DEPARTMENT_column dimension_column')]"));
		logger.info("Department : " + department);
		return department;
	}

	@Override
	public String getDesignationOfBudgetLine(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String designation = ActionBot.getTextWithInElement(driver,
			By.xpath(".//*[@id='budgetLineListingTable_budgetlistbx']//tr[" + index + "]/td[contains(@class,'DESIGNATION_column dimension_column')]"));
		logger.info("Designation : " + designation);
		return designation;
	}

	@Override
	public String getBudgetLineCode(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String budgetLineCode = ActionBot.getAttributeOfElement(driver,
			By.xpath(".//*[@id='budgetLineListingTable_budgetlistbx']//tr[" + index + "]/td[contains(@class,'budgetLineId_column')]"), "title");
		logger.info("Budget Line Code : " + budgetLineCode);
		return budgetLineCode;
	}

	@Override
	public String getBudgetLineName(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String budgetLineName = ActionBot.getTextWithInElement(driver,
			By.xpath(".//*[@id='budgetLineListingTable_budgetlistbx']//tr[" + index + "]/td[contains(@class,'budgetLineName_column')]"));
		logger.info("Budget Line Name : " + budgetLineName);
		return budgetLineName;
	}

	@Override
	public String getOwnerOfBudgetLine(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String owner = ActionBot.getTextWithInElement(driver,
			By.xpath(".//*[@id='budgetLineListingTable_budgetlistbx']//tr[" + index + "]/td[contains(@class,'ownerUserId_column')]"));
		logger.info("Owner : " + owner);
		return owner;
	}

	@Override
	public String getPlannedAmountOfBudgetLine(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		String plannedAmount = ActionBot.getTextWithInElement(driver,
			By.xpath(".//*[@id='budgetLineListingTable_budgetlistbx']//tr[" + index + "]/td[contains(@class,'plannedAmount_column')]"));
		logger.info("Planned Amount : " + plannedAmount);
		return plannedAmount;
	}

	@Override
	public void selectBudgetLine(WebDriver driver, String testCaseName, String budgetLineName) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='budgetLineListingTable_budgetlistbx']//tr[.//*[contains(text(),'" + budgetLineName + "')]]/td[1]/input"));
	}

	@Override
	public void clickOnActionsOfBudgetLine(WebDriver driver, String testCaseName, String budgetLineName) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='budgetLineListingTable_budgetlistbx']//tr[.//*[contains(text(),'" + budgetLineName + "')]]//a[contains(@class,'actLnk')]"));
	}

	@Override
	public boolean isBudgetLineDeleted(WebDriver driver, String testCaseName, String budgetLineName) throws ActionBotException
	{
		return !ActionBot.isElementPresent(driver, By.xpath(".//*[@id='budgetLineListingTable_budgetlistbx']//tr[.//*[contains(text(),'" + budgetLineName + "')]]/td[1]/input"));
	}

	@Override
	public String getToBudgetDateOnBudgetViewPage(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String toBudgetDate = ActionBot.getTextWithInElement(driver, LABEL_TO_BUDGET_DATE_ON_VIEW_BUDGET_PAGE);
		logger.info("To Budget Date : " + toBudgetDate);
		return toBudgetDate;
	}

	@Override
	public void clickOnSettingsOfBudgetLine(WebDriver driver, String testCaseName, String budgetLineName) throws ActionBotException
	{
		ActionBot.click(driver,
			By.xpath(".//*[@id='budgetLineListingTable_budgetlistbx']//tr[.//*[contains(text(),'" + budgetLineName + "')]]//span[contains(@class,'budgetLineSetting')]"));
	}

	@Override
	public String fillProjectBudgetLine(WebDriver driver, String testCaseName, String project) throws ActionBotException
	{
		String enteredProject = ActionBot.fillAutoCompleteField(driver, TEXTBOX_PROJECT_BUDGET_LINES, project);
		logger.info("Entered Project Name : " + enteredProject);
		return enteredProject;
	}

}
