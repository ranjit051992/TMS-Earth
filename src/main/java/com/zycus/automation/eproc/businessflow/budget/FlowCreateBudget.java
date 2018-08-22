/**
 * 
 */
package com.zycus.automation.eproc.businessflow.budget;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.Budget;
import com.zycus.automation.bo.BudgetAudit;
import com.zycus.automation.bo.BudgetDimension;
import com.zycus.automation.bo.BudgetLine;
import com.zycus.automation.bo.BudgetLineSetting;
import com.zycus.automation.bo.BudgetPeriod;
import com.zycus.automation.bo.CustomDate;
import com.zycus.automation.eproc.pageobjects.modals.addbudgetperiod.ModalAddBudgetPeriod;
import com.zycus.automation.eproc.pageobjects.modals.budgetaudit.ModalBudgetAudit;
import com.zycus.automation.eproc.pageobjects.modals.budgetlineactions.ModalBudgetLineActions;
import com.zycus.automation.eproc.pageobjects.modals.budgetlinesetting.ModalBudgetLineSetting;
import com.zycus.automation.eproc.pageobjects.pages.budgetlisting.PageBudgetListing;
import com.zycus.automation.eproc.pageobjects.pages.createbudget.PageCreateBudget;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 *
 */
public class FlowCreateBudget
{
	static Logger logger = Logger.getLogger(FlowCreateBudget.class);

	public static Budget createBudget(WebDriver driver, String testCaseName, Budget budget) throws ActionBotException
	{
		MainPageHeaderLevelTab.clickOnBudgetTab(driver, testCaseName);

		PageBudgetListing.clickOnAddBudgetButton(driver, testCaseName);

		budget = fillBudgetDetails(driver, testCaseName, budget);

		if (budget.getNextAction().equalsIgnoreCase(IConstantsData.SAVE_AND_FREEZE_BUDGET))
		{
			saveAndFreezeBudget(driver, testCaseName);
		}
		else if (budget.getNextAction().equalsIgnoreCase(IConstantsData.SAVE_AS_DRAFT))
		{
			PageCreateBudget.clickOnSaveAsDraftButton(driver, testCaseName);
		}
		else if (budget.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			PageCreateBudget.clickOnCancelBudgetButton(driver, testCaseName);
		}
		else if (budget.getNextAction().equalsIgnoreCase(IConstantsData.NONE))
		{
			logger.info("No Action to be performed on Budget");
		}
		else
		{
			logger.info("Invalid Budget action provided. Action: " + budget.getNextAction());
		}
		return budget;
	}

	public static Budget fillBudgetDetails(WebDriver driver, String testCaseName, Budget budget) throws ActionBotException
	{
		// owner name
		if (budget.getOwnerName() != null)
		{
			budget.setOwnerName(PageCreateBudget.fillOwnerName(driver, testCaseName, budget.getOwnerName()));
		}
		// company name
		if (budget.getCompanyName() != null)
		{
			budget.setCompanyName(PageCreateBudget.fillCompanyName(driver, testCaseName, budget.getCompanyName()));
		}

		// currency type
		if (budget.getCurrencyType() != null)
		{
			budget.setCurrencyType(PageCreateBudget.fillCurrencyType(driver, testCaseName, budget.getCurrencyType()));
			ActionBot.defaultSleep();
		}
		else
		{
			budget.setCurrencyType(PageCreateBudget.fillCurrencyType(driver, testCaseName, null));
		}

		// budget name
		if (budget.getBudgetName() != null)
		{
			budget.setBudgetName(PageCreateBudget.fillBudgetName(driver, testCaseName, budget.getBudgetName()));
		}
		// budget notes
		if (budget.getBudgetNotes() != null)
		{
			budget.setBudgetNotes(PageCreateBudget.fillBudgetNotes(driver, testCaseName, budget.getBudgetNotes()));
		}

		// add budget period
		if (budget.isAddPeriod())
		{
			if (budget.getBudgetPeriod() != null)
			{
				PageBudgetListing.clickOnAddPeriod(driver, testCaseName);
				budget.setBudgetPeriod(addBudgetPeriod(driver, testCaseName, budget.getBudgetPeriod()));
			}
		}

		/*
		 * //to select first budget period
		 * PageCreateBudget.selectFirstBudgetPeriod(driver, testCaseName);
		 */

		String periodName = PageCreateBudget.selectBudgetPeriod(driver, testCaseName, budget.getBudgetPeriod().getPeriodName());
		ActionBot.defaultSleep();
		budget.getBudgetPeriod().setResult(periodName.equalsIgnoreCase(budget.getBudgetPeriod().getPeriodName()));

		// to set from and to validity date
		CustomDate customDate = new CustomDate();
		customDate.setDate(PageCreateBudget.getFromValidityDate(driver, testCaseName));
		budget.setFromValidityDate(customDate);

		customDate.setDate(PageCreateBudget.getToValidityDate(driver, testCaseName));
		budget.setToValidityDate(customDate);

		// DisplayUtilizationOfBudgetsToApprovers
		if (budget.isDisplayUtilizationOfBudgetsToApprovers())
		{
			budget.setDisplayUtilizationOfBudgetsToApprovers(PageCreateBudget.selectDisplayUtilizationOfBudgetToApprovers(driver, testCaseName));
		}
		// DisplayUtilizationOfBudgetsToRequesters
		if (budget.isDisplayUtilizationOfBudgetsToRequesters())
		{
			budget.setDisplayUtilizationOfBudgetsToRequesters(PageCreateBudget.selectDisplayUtilizationOfBudgetToRequesters(driver, testCaseName));
		}
		// PercentageConsumpationForOwnerAsApprover
		if (budget.getPercentageConsumpationForOwnerAsApprover() != 0)
		{
			budget.setPercentageConsumpationForOwnerAsApprover(
				PageCreateBudget.fillPercentageConsumptionOfOwnerAsApproverToRequest(driver, testCaseName, budget.getPercentageConsumpationForOwnerAsApprover()));
		}
		// PercentageConsumpationForOwnerAsObserver
		if (budget.getPercentageConsumpationForOwnerAsObserver() != 0)
		{
			budget.setPercentageConsumpationForOwnerAsObserver(
				PageCreateBudget.fillPercentageConsumptionOfOwnerAsObserverToRequest(driver, testCaseName, budget.getPercentageConsumpationForOwnerAsObserver()));
		}

		// add budget dimensions
		if (budget.isAddBudgetDimensions())
		{
			budget.setBudgetDimension(addBudgetDimesion(driver, testCaseName, budget.getBudgetDimension()));
		}

		// add budget line
		if (budget.isAddBudgetLine())
		{
			int index = 1;
			PageCreateBudget.clickOnGenerateBudgetDimension(driver, testCaseName);
			if (budget.getBudgetLines() != null)
			{
				List<BudgetLine> addedBudgetLines = new ArrayList<BudgetLine>();
				for (BudgetLine budgetLine : budget.getBudgetLines())
				{
					budgetLine = addBudgetLine(driver, testCaseName, budgetLine);
					budgetLine.setResult(checkIfBudgetLineAdded(driver, testCaseName, budgetLine, index));
					if (budgetLine.isIsbudgetLineSetting())
					{
						PageCreateBudget.clickOnSettingsOfBudgetLine(driver, testCaseName, budgetLine.getBudgetLineName());
						budgetLine.setBudgetLineSetting(fillBudgetLineSetting(driver, testCaseName, budgetLine.getBudgetLineSetting()));
					}
					addedBudgetLines.add(budgetLine);
					index++;
				}
				budget.setBudgetLines(addedBudgetLines);
			}
		}

		return budget;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To add budget period <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param budgetPeriod </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static BudgetPeriod addBudgetPeriod(WebDriver driver, String testCaseName, BudgetPeriod budgetPeriod) throws ActionBotException
	{
		// period start date
		if (budgetPeriod.getPeriodStartDate() != null)
		{
			budgetPeriod.getPeriodStartDate().setDate(ModalAddBudgetPeriod.selectStartDateForPeriod(driver, testCaseName, budgetPeriod.getPeriodStartDate().getDay(),
				budgetPeriod.getPeriodStartDate().getMonth(), budgetPeriod.getPeriodStartDate().getYear()));
		}

		// period end date
		if (budgetPeriod.getPeriodEndDate() != null)
		{
			budgetPeriod.getPeriodEndDate().setDate(ModalAddBudgetPeriod.selectEndDateForPeriod(driver, testCaseName, budgetPeriod.getPeriodEndDate().getDay(),
				budgetPeriod.getPeriodEndDate().getMonth(), budgetPeriod.getPeriodEndDate().getYear()));
		}

		// period name
		if (budgetPeriod.getPeriodName() != null)
		{
			budgetPeriod.setPeriodName(ModalAddBudgetPeriod.fillPeriodName(driver, testCaseName, budgetPeriod.getPeriodName()));
		}
		else
		{
			budgetPeriod.setPeriodName(ModalAddBudgetPeriod.getPeriodName(driver, testCaseName));
		}

		// next action
		if (budgetPeriod.getNextAction().equalsIgnoreCase(IConstantsData.ADD))
		{
			ModalAddBudgetPeriod.clickOnAddPeriodButton(driver, testCaseName);
			// in case of budget period already exists
			if (ModalAddBudgetPeriod.isAddPeriodButtonPresent(driver, testCaseName))
			{
				ModalAddBudgetPeriod.clickOnClosePeriodButton(driver, testCaseName);
			}
		}
		else if (budgetPeriod.getNextAction().equalsIgnoreCase(IConstantsData.CLOSE))
		{
			ModalAddBudgetPeriod.clickOnClosePeriodButton(driver, testCaseName);
		}
		return budgetPeriod;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To add budget dimension <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param budgetDimension </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static BudgetDimension addBudgetDimesion(WebDriver driver, String testCaseName, BudgetDimension budgetDimension) throws ActionBotException
	{
		int index = 1;
		if (budgetDimension.isBusinessUnit())
		{
			PageCreateBudget.selectBudgetDimension(driver, testCaseName, IConstantsData.BUDGET_DIMENSION_BUSINESS_UNIT, index);
		}
		if (budgetDimension.isLocation())
		{
			PageCreateBudget.clickOnAddAnotherBudgetDimension(driver, testCaseName);
			index++;
			PageCreateBudget.selectBudgetDimension(driver, testCaseName, IConstantsData.BUDGET_DIMENSION_LOCATION, index);
		}
		if (budgetDimension.isCostCenter())
		{
			PageCreateBudget.clickOnAddAnotherBudgetDimension(driver, testCaseName);
			index++;
			PageCreateBudget.selectBudgetDimension(driver, testCaseName, IConstantsData.BUDGET_DIMENSION_COST_CENTER, index);
		}
		if (budgetDimension.isDepartment())
		{
			PageCreateBudget.clickOnAddAnotherBudgetDimension(driver, testCaseName);
			index++;
			PageCreateBudget.selectBudgetDimension(driver, testCaseName, IConstantsData.BUDGET_DIMENSION_DEPARTMENT, index);
		}
		if (budgetDimension.isDesignation())
		{
			PageCreateBudget.clickOnAddAnotherBudgetDimension(driver, testCaseName);
			index++;
			PageCreateBudget.selectBudgetDimension(driver, testCaseName, IConstantsData.BUDGET_DIMENSION_DESIGNATION, index);
		}
		if (budgetDimension.isProject())
		{
			PageCreateBudget.clickOnAddAnotherBudgetDimension(driver, testCaseName);
			index++;
			PageCreateBudget.selectBudgetDimension(driver, testCaseName, IConstantsData.BUDGET_DIMENSION_PROJECT, index);
		}
		if (budgetDimension.isGlAccount())
		{
			PageCreateBudget.clickOnAddAnotherBudgetDimension(driver, testCaseName);
			index++;
			PageCreateBudget.selectBudgetDimension(driver, testCaseName, IConstantsData.BUDGET_DIMENSION_GENERAL_LEDGER, index);
		}
		if (budgetDimension.isCategory())
		{
			PageCreateBudget.clickOnAddAnotherBudgetDimension(driver, testCaseName);
			index++;
			PageCreateBudget.selectBudgetDimension(driver, testCaseName, IConstantsData.BUDGET_DIMENSION_CATEGORY, index);
		}
		ScreenShot.screenshot(driver, testCaseName, "After adding budget dimensions");

		return budgetDimension;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To add budget line <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param budgetLine </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static BudgetLine addBudgetLine(WebDriver driver, String testCaseName, BudgetLine budgetLine) throws ActionBotException
	{
		ActionBot.scroll(driver);
		if (budgetLine.isAutoGenerate())
		{
			PageCreateBudget.clickOnAutoGenerateCombinations(driver, testCaseName);
		}
		else if (budgetLine.isUploadViaFile())
		{
			PageCreateBudget.clickOnUploadViaFile(driver, testCaseName);
		}
		else
		{
			PageCreateBudget.clickOnAddBudgetLineButton(driver, testCaseName);
			if (budgetLine.getBusinessUnit() != null)
			{
				budgetLine.setBusinessUnit(PageCreateBudget.fillBusinessUnit(driver, testCaseName, budgetLine.getBusinessUnit()));
			}

			if (budgetLine.getLocation() != null)
			{
				budgetLine.setLocation(PageCreateBudget.fillBudgetLineLocation(driver, testCaseName, budgetLine.getLocation()));
			}

			if (budgetLine.getCostCenter() != null)
			{
				budgetLine.setCostCenter(PageCreateBudget.fillBudgetLineCostCenter(driver, testCaseName, budgetLine.getCostCenter()));
			}

			if (budgetLine.getDepartment() != null)
			{
				budgetLine.setDepartment(PageCreateBudget.selectBudgetLineDepartment(driver, testCaseName, budgetLine.getDepartment()));
			}
			/*
			 * else { budgetLine.setDepartment(PageCreateBudget.
			 * selectBudgetLineDepartment(driver, testCaseName, null)); }
			 */

			if (budgetLine.getDesignation() != null)
			{
				budgetLine.setDesignation(PageCreateBudget.selectBudgetLineDesignation(driver, testCaseName, budgetLine.getDesignation()));
			}
			/*
			 * else { budgetLine.setDesignation(PageCreateBudget.
			 * selectBudgetLineDesignation(driver, testCaseName, null)); }
			 */

			if (budgetLine.getProject() != null)
			{
				budgetLine.setProject(PageCreateBudget.fillProjectBudgetLine(driver, testCaseName, budgetLine.getProject()));
			}

			if (budgetLine.getBudgetLineCode() != null)
			{
				budgetLine.setBudgetLineCode(PageCreateBudget.fillBudgetLineCode(driver, testCaseName, budgetLine.getBudgetLineCode()));
			}

			if (budgetLine.getBudgetLineName() != null)
			{
				budgetLine.setBudgetLineName(PageCreateBudget.fillBudgetLineName(driver, testCaseName, budgetLine.getBudgetLineName()));
			}

			if (budgetLine.getOwner() != null)
			{
				budgetLine.setOwner(PageCreateBudget.fillBudgetLineOwner(driver, testCaseName, budgetLine.getOwner()));
			}

			if (budgetLine.getPlannedAmount() != null)
			{
				budgetLine.setPlannedAmount(PageCreateBudget.fillPlannedAmount(driver, testCaseName, budgetLine.getPlannedAmount()));
			}
		}

		if (budgetLine.getNextAction().equalsIgnoreCase(IConstantsData.SAVE))
		{
			PageCreateBudget.clickOnSaveBudgetLine(driver, testCaseName);
		}
		else if (budgetLine.getNextAction().equalsIgnoreCase(IConstantsData.DELETE))
		{
			PageCreateBudget.clickOnDeleteBudgetLine(driver, testCaseName);
		}
		//added bu dnyanesh joshi
		else if (budgetLine.getNextAction().equalsIgnoreCase(IConstantsData.NONE))
		{
			logger.info("No Action to be performed on Budget");
		}
		else
		{
			logger.info("Invalid Budget action provided. Action: " + budgetLine.getNextAction());
		}

		return budgetLine;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To check if budget line added <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param budgetLine </font><b><br>
	 * @param index </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static boolean checkIfBudgetLineAdded(WebDriver driver, String testCaseName, BudgetLine budgetLine, int index) throws ActionBotException
	{
		boolean businessUnitFlag = false, locationFlag = false, ccFlag = false, departmentFlag = true, budgetLineNameFlag = false, budgetLineOwnerFlag = false;
		String error = "";

		logger.info("Added budget lines : ");
		if (budgetLine.getBusinessUnit() != null)
		{
			businessUnitFlag = budgetLine.getBusinessUnit().equalsIgnoreCase(PageCreateBudget.getBusinessUnitOfBudgetLine(driver, testCaseName, index));
			if (!businessUnitFlag)
			{
				error += "Business Unit was wrong \n";
			}
		}
		if (budgetLine.getLocation() != null)
		{
			locationFlag = budgetLine.getLocation().equalsIgnoreCase(PageCreateBudget.getLocationOfBudgetLine(driver, testCaseName, index));
			if (!locationFlag)
			{
				error += "Location was wrong \n";
			}
		}
		if (budgetLine.getCostCenter() != null)
		{
			ccFlag = budgetLine.getCostCenter().equalsIgnoreCase(PageCreateBudget.getCostCenterOfBudgetLine(driver, testCaseName, index));
			if (!ccFlag)
			{
				error += "Cost Center was wrong \n";
			}
		}
		if (budgetLine.getDepartment() != null)
		{
			departmentFlag = budgetLine.getDepartment().equalsIgnoreCase(PageCreateBudget.getDepartmentOfBudgetLine(driver, testCaseName, index));
			if (!locationFlag)
			{
				error += "Department was wrong \n";
			}
		}
		/*
		 * budgetLineCodeFlag = budgetLine.getBudgetLineCode().equalsIgnoreCase(
		 * PageCreateBudget.getBudgetLineCode(driver, testCaseName, index)); if
		 * (!budgetLineCodeFlag) { error += "Budget Line Code was wrong"; }
		 */

		budgetLineNameFlag = budgetLine.getBudgetLineName().equalsIgnoreCase(PageCreateBudget.getBudgetLineName(driver, testCaseName, index));
		if (!budgetLineNameFlag)
		{
			error += "Budget Line Name was wrong";
		}

		budgetLineOwnerFlag = budgetLine.getOwner().equalsIgnoreCase(PageCreateBudget.getOwnerOfBudgetLine(driver, testCaseName, index));
		if (!budgetLineOwnerFlag)
		{
			error += "Budget Line Owner was wrong";
		}

		/*
		 * flag =
		 * (budgetLine.getBudgetLineCode().equalsIgnoreCase(PageCreateBudget.
		 * getBudgetLineCode(driver, testCaseName, index))) &&
		 * (budgetLine.getBudgetLineName().equalsIgnoreCase(PageCreateBudget.
		 * getBudgetLineName(driver, testCaseName, index))) &&
		 * (budgetLine.getOwner().equalsIgnoreCase(PageCreateBudget.
		 * getOwnerOfBudgetLine(driver, testCaseName, index)));
		 */
		logger.info(error);
		return budgetLineNameFlag && budgetLineOwnerFlag && businessUnitFlag && locationFlag && ccFlag && departmentFlag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To save and freeze budget <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static void saveAndFreezeBudget(WebDriver driver, String testCaseName) throws ActionBotException
	{
		PageCreateBudget.clickOnSaveAndFreezeBudgetButton(driver, testCaseName);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> To delete the budget line <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param budgetLineName </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static boolean deletBudgetLine(WebDriver driver, String testCaseName, String budgetLineName) throws ActionBotException
	{
		boolean flag = false;

		PageCreateBudget.selectBudgetLine(driver, testCaseName, budgetLineName);
		PageCreateBudget.clickOnActionsOfBudgetLine(driver, testCaseName, budgetLineName);
		ModalBudgetLineActions.clickOndeleteAction(driver, testCaseName, budgetLineName);
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		ActionBot.defaultSleep();
		flag = PageCreateBudget.isBudgetLineDeleted(driver, testCaseName, budgetLineName);
		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Fill budget line settings <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param budgetLineSetting </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static BudgetLineSetting fillBudgetLineSetting(WebDriver driver, String testCaseName, BudgetLineSetting budgetLineSetting) throws ActionBotException
	{
		if (budgetLineSetting.getBudgetExceptionWorkflowUtilizationPercentage() >= 0)
		{
			budgetLineSetting.setBudgetExceptionWorkflowUtilizationPercentage(
				ModalBudgetLineSetting.fillBudgetExceptionWorkflowUtilizationLimit(driver, testCaseName, budgetLineSetting.getBudgetExceptionWorkflowUtilizationPercentage()));
		}
		if (budgetLineSetting.getOwnerInclusionUtilizationLimit() >= 0)
		{
			budgetLineSetting.setOwnerInclusionUtilizationLimit(
				ModalBudgetLineSetting.fillBudgetOwnerInclusionUtilizationLimit(driver, testCaseName, budgetLineSetting.getOwnerInclusionUtilizationLimit()));
		}

		if (budgetLineSetting.isExceedPercentToleranceToInfinite())
		{
			ModalBudgetLineSetting.clearExceedPercentageTolerance(driver, testCaseName);
		}
		else
		{
			if (budgetLineSetting.getExceedPercentTolerance() >= 0)
			{
				budgetLineSetting
					.setExceedPercentTolerance(ModalBudgetLineSetting.fillExceedPercentageTolerance(driver, testCaseName, budgetLineSetting.getExceedPercentTolerance()));
			}
		}

		if (budgetLineSetting.isExceedAmountToleranceToInfinite())
		{
			ModalBudgetLineSetting.clearExceedAmountTolerance(driver, testCaseName);
		}
		else
		{
			if (budgetLineSetting.getExceedAmountTolerance() >= 0)
			{
				budgetLineSetting.setExceedAmountTolerance(ModalBudgetLineSetting.fillExceedAmountTolerance(driver, testCaseName, budgetLineSetting.getExceedAmountTolerance()));
			}
		}
		if (budgetLineSetting.getNextAction().equalsIgnoreCase(IConstantsData.SAVE))
		{
			ModalBudgetLineSetting.clickOnSaveButton(driver, testCaseName);
		}
		else if (budgetLineSetting.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			ModalBudgetLineSetting.clickOnCancelButton(driver, testCaseName);
		}
		return budgetLineSetting;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get budget audit details <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param budgetLineName </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static BudgetAudit getBudgetAuditDetails(WebDriver driver, String testCaseName, String budgetLineName) throws ActionBotException
	{
		BudgetAudit budgetAudit = new BudgetAudit();

		PageCreateBudget.clickOnActionsOfBudgetLine(driver, testCaseName, budgetLineName);
		ModalBudgetLineActions.clickOnAuditAction(driver, testCaseName, budgetLineName);

		budgetAudit.setDate(ModalBudgetAudit.getBudgetAuditDate(driver, testCaseName));
		budgetAudit.setDocName(ModalBudgetAudit.getDocumentName(driver, testCaseName));
		budgetAudit.setDocType(ModalBudgetAudit.getDocumentType(driver, testCaseName));
		budgetAudit.setEvent(ModalBudgetAudit.getBudgetAuditEvent(driver, testCaseName));
		budgetAudit.setUser(ModalBudgetAudit.getBudgetAuditUser(driver, testCaseName));
		budgetAudit.setReqReserved(ModalBudgetAudit.getBudgetRequisitionReservedAmount(driver, testCaseName));
		budgetAudit.setPoReserved(ModalBudgetAudit.getBudgetPOReservedAmount(driver, testCaseName));
		budgetAudit.setInvoiceReserved(ModalBudgetAudit.getBudgetInvoiceReservedAmount(driver, testCaseName));
		budgetAudit.setUtilizedAmount(ModalBudgetAudit.getBudgetAuditUtilizedAmount(driver, testCaseName));
		budgetAudit.setNetAmount(ModalBudgetAudit.getBudgetAuditNet(driver, testCaseName));
		budgetAudit.setBalanceAmount(ModalBudgetAudit.getBudgetAuditBalance(driver, testCaseName));
		budgetAudit.setBalanaceAmountWithTolerance(ModalBudgetAudit.getBudgetAuditBalanceAmountWithTolerance(driver, testCaseName));

		ModalBudgetAudit.clickOnCloseBudgetAuditButton(driver, testCaseName);
		return budgetAudit;
	}
}
