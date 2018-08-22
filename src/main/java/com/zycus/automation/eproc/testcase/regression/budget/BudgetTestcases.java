package com.zycus.automation.eproc.testcase.regression.budget;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.zycus.automation.bo.Budget;
import com.zycus.automation.bo.BudgetDimension;
import com.zycus.automation.bo.BudgetLine;
import com.zycus.automation.bo.MappedTestCase;
import com.zycus.automation.bo.OnlineStore;
import com.zycus.automation.bo.Requisition;
import com.zycus.automation.bo.User;
import com.zycus.automation.boutils.MappedTestCaseUtil;
import com.zycus.automation.datacreation.ObjectCreation;
import com.zycus.automation.eproc.businessflow.budget.FlowCreateBudget;
import com.zycus.automation.eproc.businessflow.budgetlisting.FlowBudgetListing;
import com.zycus.automation.eproc.businessflow.onlinestoreflow.FlowOnlineStore;
import com.zycus.automation.eproc.pageobjects.modals.checkoutRequisitionSummaryBilling.IModelRequisitionSummaryBilling;
import com.zycus.automation.eproc.pageobjects.modals.checkoutRequisitionSummaryCostBooking.IModelRequisitionSummaryCostBooking;
import com.zycus.automation.eproc.pageobjects.modals.checkoutRequisitionSummaryCostBooking.IModelRequisitionSummaryCostBookingImpl;
import com.zycus.automation.eproc.pageobjects.modals.checkoutRequisitionSummaryCostBooking.ModelRequisitionSummaryCostBooking;
import com.zycus.automation.eproc.pageobjects.pages.budgetlisting.PageBudgetListing;
import com.zycus.automation.eproc.pageobjects.pages.createbudget.IPageCreateBudget;
import com.zycus.automation.eproc.pageobjects.pages.createbudget.PageCreateBudget;
import com.zycus.automation.eproc.pageobjects.pages.requisitionCheckOut.IPageRequisitionCheckOut;
import com.zycus.automation.eproc.pageobjects.pages.requisitionCheckOut.PageRequisitionCheckOut;
import com.zycus.automation.eproc.pageobjects.pages.settings.budgetsettings.IPageBudgetSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.budgetsettings.PageBudgetSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.cusomizesettings.PageCustomizeSettings;
import com.zycus.automation.eproc.pageobjects.pages.settings.projectssettings.PageProjectsSettings;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.services.LoginLogoutServices;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.common.CommonUtilities;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;
import com.zycus.framework.framework_version_2_4.framework.DriverSelector;
import com.zycus.framework.framework_version_2_4.framework.TestDataProvider;

public class BudgetTestcases extends TestDataProvider
{

	String	reqNumber_11835	= null;
	String	reqNumber_11906	= null;
	String	reqNumber_12119	= null;

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :If multiple Budget dimensions
	 * are selected, except last budget dimension, all other dimensions are
	 * mandatory to be selected.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24492(TestCase testCase) throws Exception
	{
		WebDriver driver = null;

		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		BudgetLine budgetLine = null;
		boolean EPROC_24492 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();
			budgetLine = budget.getBudgetLines().get(0);

			budget.setNextAction(IConstantsData.NONE);
			budget.setAddBudgetLine(false);
			// creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();
			// generate budget dimension
			PageCreateBudget.clickOnGenerateBudgetDimension(driver, testCaseName);
			// adding budget line
			PageCreateBudget.clickOnAddBudgetLineButton(driver, testCaseName);
			PageCreateBudget.fillBusinessUnit(driver, testCaseName, budgetLine.getBusinessUnit());
			PageCreateBudget.fillBudgetLineLocation(driver, testCaseName, budgetLine.getLocation());
			PageCreateBudget.fillBudgetLineCostCenter(driver, testCaseName, budgetLine.getCostCenter());
			PageCreateBudget.selectBudgetLineDepartment(driver, testCaseName, budgetLine.getDepartment());

			PageCreateBudget.fillBudgetLineCode(driver, testCaseName, budgetLine.getBudgetLineCode());
			PageCreateBudget.fillBudgetLineName(driver, testCaseName, budgetLine.getBudgetLineName());
			PageCreateBudget.fillBudgetLineOwner(driver, testCaseName, budgetLine.getOwner());
			PageCreateBudget.fillPlannedAmount(driver, testCaseName, budgetLine.getPlannedAmount());
			ActionBot.defaultMediumSleep();
			// saving budget line
			PageCreateBudget.clickOnSaveBudgetLine(driver, testCaseName);
			// saving budget
			PageCreateBudget.clickOnSaveAndFreezeBudgetButton(driver, testCaseName);
			//search budget
			EPROC_24492 = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);
			Assert.assertTrue(EPROC_24492, "Unable to search budget");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> <b>Created On : 6 -April-2016 </b>
	 * <b>Method : EPROC-24209 <b>Description : User should be able to save the
	 * budget in draft if mandatory details are filled, Budget line codes are
	 * added for budget for the budget on budget creation page. Reviewed By:
	 * kunal.ashar
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24209(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		boolean EPROC_24209 = false;
		BudgetLine budgetLine = null;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();
			budgetLine = budget.getBudgetLines().get(0);

			budget.setNextAction(IConstantsData.NONE);
			budget.setAddBudgetLine(false);
			// creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();
			// generate budget dimension
			PageCreateBudget.clickOnGenerateBudgetDimension(driver, testCaseName);
			// adding budget line
			budgetLine = FlowCreateBudget.addBudgetLine(driver, testCaseName, budgetLine);
			PageCreateBudget.clickOnSaveAsDraftButton(driver, testCaseName);

			// searching budget
			String status = PageBudgetListing.getStatusOfFirstBudget(driver, testCaseName);
			EPROC_24209 = status.equalsIgnoreCase(IConstantsData.DRAFT);

			Assert.assertTrue(EPROC_24209, "Unable to save budget in draft");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> <b>Created On : 6 -April-2016 </b>
	 * <b>Method : EPROC-24280 <b>If 8 dimensions are added for the budget, and
	 * then if one more dimension is deleted, 'Add another' link should be
	 * visible for Budget Dimensions on budget creation page.
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_24282(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		int i = 1;
		boolean EPROC_24282 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();
			budget.setNextAction(IConstantsData.NONE);
			budget.setAddBudgetLine(false);
			budget.setAddBudgetDimensions(false);

			// creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();
			// count the budget dimensions
			for (i = 1; i <= 7; i++)
			{
				PageCreateBudget.clickOnAddAnotherBudgetDimension(driver, testCaseName);
			}
			// checking for delete dimension button
			ActionBot.findElement(driver, IPageCreateBudget.BUTTON_DELETE_DIMENSION).click();
			ActionBot.defaultMediumSleep();
			// checking for add dimension button
			if (ActionBot.isElementDisplayed(driver, IPageCreateBudget.BUTTON_ADD_DIMENSION))
			{
				EPROC_24282 = true;
			}
			Assert.assertTrue(EPROC_24282, "'Add another' link not visible");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> <b>Created On : 6 -April-2016 </b>
	 * <b>Method : EPROC-24280 <b>Maximum 8 budget dimensions can be added for
	 * budget on Budget creation page Reviewed By: kunal.ashar
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_24280(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		int i = 1;
		boolean EPROC_24280 = false;
		try
		{
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("EPROC_24281"));
			}

			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();
			budget.setNextAction(IConstantsData.NONE);
			budget.setAddBudgetLine(false);
			budget.setAddBudgetDimensions(false);
			// creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();
			// count the budget dimensions
			for (i = 1; i <= 7; i++)
			{
				PageCreateBudget.clickOnAddAnotherBudgetDimension(driver, testCaseName);

			}
			if (!ActionBot.isElementDisplayed(driver, IPageCreateBudget.BUTTON_ADD_DIMENSION))
			{
				EPROC_24280 = true;
			}

			Assert.assertTrue(EPROC_24280, "Can not add more than 8 dimesnions..");
			mappedTestCases.get(0).setTestResult(EPROC_24280);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> <b>Created On : 6 -April-2016 </b>
	 * <b>Method : EPROC_24283 <b>User should not be allowed to generate budget
	 * dimensions, if duplicate dimension values are entered for budget
	 * dimensions on budget creation page.
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_24283(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		boolean EPROC_24283 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();

			budget.setNextAction(IConstantsData.NONE);
			budget.setAddBudgetLine(false);
			budget.setAddBudgetDimensions(false);
			// creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();
			// adding budget dimensions
			PageCreateBudget.clickOnAddAnotherBudgetDimension(driver, testCaseName);
			PageCreateBudget.clickOnAddAnotherBudgetDimension(driver, testCaseName);
			// generate budget dimension
			PageCreateBudget.clickOnGenerateBudgetDimension(driver, testCaseName);
			EPROC_24283 = ActionBot.isElementDisplayed(driver, IPageCreateBudget.ALERT_DUPLICATE_DIMENSION);

			Assert.assertTrue(EPROC_24283, "Unable to add duplicate dimensions.");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description : Minimum 1 dimension should
	 * be present in Budget Dimensions on Budget Creation page
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24291(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		boolean EPROC_24291 = false;
		boolean budgetCreatedFlag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();

			// creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();
			budgetCreatedFlag = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);
			// select first budget
			FlowBudgetListing.viewBudget(driver, testCaseName);

			String searchedBU = PageCreateBudget.getBusinessUnitOfBudgetLine(driver, testCaseName, 1);

			// checking addition of budget dimension
			if (searchedBU.equalsIgnoreCase(budget.getBudgetLines().get(0).getBusinessUnit()))
			{
				EPROC_24291 = true;
			}

			Assert.assertTrue(EPROC_24291, "No budget dimension is present");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :User should be allowed to
	 * save the budget line code, if all parameters(Budget dimensions,budget
	 * line code, budget line name,owner, planned amount ) for budget line code
	 * are entered on budget creation/updation page.
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_24312(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		BudgetLine budgetLine = null;
		boolean EPROC_24312 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();
			budgetLine = budget.getBudgetLines().get(0);

			budget.setNextAction(IConstantsData.NONE);
			budget.setAddBudgetLine(false);
			// creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();
			// generate budget dimension
			PageCreateBudget.clickOnGenerateBudgetDimension(driver, testCaseName);
			// adding budget line
			PageCreateBudget.clickOnAddBudgetLineButton(driver, testCaseName);
			PageCreateBudget.fillBusinessUnit(driver, testCaseName, budgetLine.getBusinessUnit());
			PageCreateBudget.fillBudgetLineLocation(driver, testCaseName, budgetLine.getLocation());
			PageCreateBudget.fillBudgetLineCostCenter(driver, testCaseName, budgetLine.getCostCenter());
			PageCreateBudget.selectBudgetLineDepartment(driver, testCaseName, budgetLine.getDepartment());
			PageCreateBudget.selectBudgetLineDesignation(driver, testCaseName, budgetLine.getDesignation());

			PageCreateBudget.fillBudgetLineCode(driver, testCaseName, budgetLine.getBudgetLineCode());
			PageCreateBudget.fillBudgetLineName(driver, testCaseName, budgetLine.getBudgetLineName());
			PageCreateBudget.fillBudgetLineOwner(driver, testCaseName, budgetLine.getOwner());
			PageCreateBudget.fillPlannedAmount(driver, testCaseName, budgetLine.getPlannedAmount());
			// saving budget line
			PageCreateBudget.clickOnSaveBudgetLine(driver, testCaseName);
			// saving budget
			PageCreateBudget.clickOnSaveAndFreezeBudgetButton(driver, testCaseName);

			// searching budget
			EPROC_24312 = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);

			Assert.assertTrue(EPROC_24312, "Unable to search budget");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description : User should be allowed to
	 * delete budget line codes on clicking on delete option on budget
	 * creation/updation page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24313(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		boolean EPROC_24313 = false;
		boolean budgetCreatedFlag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();

			// creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();

			//search Budget
			budgetCreatedFlag = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);

			// select first budget
			FlowBudgetListing.viewBudget(driver, testCaseName);

			// delete budget line
			EPROC_24313 = FlowCreateBudget.deletBudgetLine(driver, testCaseName, budget.getBudgetLines().get(0).getBudgetLineName());

			Assert.assertTrue(EPROC_24313, "Unable to delete budget line");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description : Planned amount textbox
	 * should accept only numbers while creating budget lines on budget
	 * creation/updation page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24320(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		BudgetLine budgetLine = null;
		boolean EPROC_24320 = false;
		boolean budgetCreatedFlag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();

			// create budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();
			budgetCreatedFlag = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);

			// select first budget
			FlowBudgetListing.viewBudget(driver, testCaseName);
			budgetLine = budget.getBudgetLines().get(0);
			String amount = budgetLine.getPlannedAmount();

			// Creating pattern for validating planned amount using regex(Regular Expressions)
			Pattern pattern = Pattern.compile("[0-9]");
			Matcher matcher = pattern.matcher(amount);
			EPROC_24320 = matcher.find();

			Assert.assertTrue(EPROC_24320, "Planned amount is not valid");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :Planned amount textbox should
	 * not accept only alphabets,special characters while creating budget lines
	 * on budget creation/updation page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24321(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		BudgetLine budgetLine = null;
		boolean EPROC_24321 = false;
		boolean budgetCreatedFlag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();

			// creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();

			//search budget
			budgetCreatedFlag = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);
			// select first budget
			FlowBudgetListing.viewBudget(driver, testCaseName);
			budgetLine = budget.getBudgetLines().get(0);
			String amount = budgetLine.getPlannedAmount();
			// Creating pattern for validating planned amount using regex
			// (Regular Expressions)
			Pattern pattern = Pattern.compile("[a-z#$%^&*@#!_-]");
			Matcher matcher = pattern.matcher(amount);
			EPROC_24321 = matcher.find();
			Assert.assertTrue(!(EPROC_24321), "Planned amount is not valid");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :User should be able to edit
	 * the budget lines from Actions in Budget Lines on budget creation/updation
	 * page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24324(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		BudgetLine budgetLine = null;
		boolean EPROC_24324 = false;
		boolean budgetCreatedFlag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();

			// creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();
			budgetCreatedFlag = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);
			// select first budget
			FlowBudgetListing.viewBudget(driver, testCaseName);
			// click on actions of budget line
			PageCreateBudget.clickOnActionsOfBudgetLine(driver, testCaseName, budget.getBudgetLines().get(0).getBudgetLineName());
			ActionBot.defaultMediumSleep();

			ActionBot.findElement(driver, IPageCreateBudget.BUTTON_EDIT_BUDGETLINE_FROM_ACTIONS).click();
			budgetLine = budget.getBudgetLines().get(0);
			//IConstantsData.NAME
			budgetLine.setBudgetLineName(IConstantsData.NAME);
			PageCreateBudget.clickOnSaveBudgetLine(driver, testCaseName);
			PageCreateBudget.clickOnSaveAndFreezeBudgetButton(driver, testCaseName);

			EPROC_24324 = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);
			Assert.assertTrue(EPROC_24324, "Unable to search budget");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description : Business unit dimension
	 * value is present only in first dimension drop down on budget creation
	 * page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24287(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		boolean EPROC_24287 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();
			budget.setAddBudgetLine(false);
			budget.setNextAction(IConstantsData.NONE);
			// creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();
			// generate budget dimension
			PageCreateBudget.clickOnGenerateBudgetDimension(driver, testCaseName);
			// getting first budget dimension
			WebElement budgetDimension = ActionBot.findElement(driver, IPageCreateBudget.TEXT_FIRST_DIMENSION);

			if (budgetDimension.getText().matches(IConstantsData.BUSINESS_UNIT_TEXT))
				EPROC_24287 = true;
			// getting budget dimensions
			if (ActionBot.findElement(driver, IPageCreateBudget.TEXT_SECOND_DIMENSION).getText().equals(IConstantsData.BUSINESS_UNIT_TEXT))
				EPROC_24287 = false;
			if (ActionBot.findElement(driver, IPageCreateBudget.TEXT_THIRD_DIMENSION).getText().equals(IConstantsData.BUSINESS_UNIT_TEXT))
				EPROC_24287 = false;
			if (ActionBot.findElement(driver, IPageCreateBudget.TEXT_FOURTH_DIMENSION).getText().equals(IConstantsData.BUSINESS_UNIT_TEXT))
				EPROC_24287 = false;
			if (ActionBot.findElement(driver, IPageCreateBudget.TEXT_FIFTH_DIMENSION).getText().equals(IConstantsData.BUSINESS_UNIT_TEXT))
				EPROC_24287 = false;

			Assert.assertTrue(EPROC_24287, "Invalid dimesion sequence");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :Verify user should be able to
	 * search budget line through Owner name field on budget creation/update
	 * page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24301(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		boolean EPROC_24301 = false;
		boolean budgetCreatedFlag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();

			budget.setNextAction(IConstantsData.NONE);
			// creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();

			// searchbudget line by owner name
			WebElement ownerTextFeild = ActionBot.findElement(driver, IPageCreateBudget.INPUT_OWNER_NAME_SEARCH);
			ownerTextFeild.sendKeys(budget.getBudgetLines().get(0).getOwner().charAt(0) + "");

			// check searching of budget line
			boolean isBudgetLineSearched = ActionBot.isElementDisplayed(driver, IPageCreateBudget.LABEL_IS_BUDGET_LINE_SEARCHED);
			if (isBudgetLineSearched)
			{
				EPROC_24301 = true;
			}
			Assert.assertTrue(EPROC_24301, "Unable to search budget line through owner name ");

			// saving budget
			PageCreateBudget.clickOnSaveAndFreezeBudgetButton(driver, testCaseName);
			budgetCreatedFlag = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);
			Assert.assertTrue(budgetCreatedFlag, "Budget not created");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :Following options should be
	 * displayed for created budget lines on budget creation/updation page :
	 * Edit, delete, Audit on budget creation/updation page.-
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24323(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		boolean delete, edit, audit = false;
		boolean budgetCreatedFlag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();

			// creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();

			budgetCreatedFlag = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);
			Assert.assertTrue(budgetCreatedFlag, "Budget not created");

			// select first budget
			FlowBudgetListing.viewBudget(driver, testCaseName);
			// click on actions of budget line
			PageCreateBudget.clickOnActionsOfBudgetLine(driver, testCaseName, budget.getBudgetLines().get(0).getBudgetLineName());
			// actions for budget line
			edit = ActionBot.isElementDisplayed(driver, IPageCreateBudget.BUTTON_EDIT_BUDGETLINE_FROM_ACTIONS);
			delete = ActionBot.isElementDisplayed(driver, IPageCreateBudget.BUTTON_DELETE_BUDGETLINE_FROM_ACTIONS);
			audit = ActionBot.isElementDisplayed(driver, IPageCreateBudget.BUTTON_AUDIT_BUDGETLINE_FROM_ACTIONS);

			Assert.assertTrue(edit, "Edit option for budget line not found");
			Assert.assertTrue(delete, "Delete option for budget line not found");
			Assert.assertTrue(audit, "Audit option for budget line not found");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :Budget Name should get
	 * auto-populated in following format : PeriodName/CompanyName after
	 * selecting Period & Company on Budget creation page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24214(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		boolean EPROC_24214 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();

			MainPageHeaderLevelTab.clickOnBudgetTab(driver, testCaseName);
			PageBudgetListing.clickOnAddBudgetButton(driver, testCaseName);
			String companyName = PageCreateBudget.fillCompanyName(driver, testCaseName, budget.getCompanyName());
			String period = PageCreateBudget.selectFirstBudgetPeriod(driver, testCaseName);
			PageCreateBudget.fillOwnerName(driver, testCaseName, budget.getOwnerName());
			PageCreateBudget.fillCurrencyType(driver, testCaseName, budget.getCurrencyType());

			// generate budget dimension
			PageCreateBudget.clickOnGenerateBudgetDimension(driver, testCaseName);

			WebElement budgetNameText = ActionBot.findElement(driver, IPageCreateBudget.TEXT_AUTOPOPULATED_BUDGET_NAME);
			String budgetName = budgetNameText.getText();
			if (budgetName.equals(period + "/" + companyName))
			{
				EPROC_24214 = true;
			}

			Assert.assertTrue(EPROC_24214, "Budget name not populated correctly");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :User should not be allowed to
	 * save the budget line code, if all parameters(Budget dimensions,budget
	 * line code, budget line name,owner, planned amount ) for budget line code
	 * are not entered on budget creation/updation page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24311(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		BudgetLine budgetLine = null;
		boolean EPROC_24311 = false;
		String alertMessage = null;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();
			budget.setNextAction(IConstantsData.NONE);
			budget.setAddBudgetLine(false);

			// creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();
			// generate budget dimension
			PageCreateBudget.clickOnGenerateBudgetDimension(driver, testCaseName);
			// adding budget line
			PageCreateBudget.clickOnAddBudgetLineButton(driver, testCaseName);

			budgetLine = budget.getBudgetLines().get(0);

			PageCreateBudget.fillBusinessUnit(driver, testCaseName, budgetLine.getBusinessUnit());
			PageCreateBudget.fillBudgetLineLocation(driver, testCaseName, budgetLine.getLocation());
			PageCreateBudget.fillBudgetLineCostCenter(driver, testCaseName, budgetLine.getCostCenter());
			PageCreateBudget.selectBudgetLineDepartment(driver, testCaseName, budgetLine.getDepartment());
			PageCreateBudget.selectBudgetLineDesignation(driver, testCaseName, budgetLine.getDesignation());

			PageCreateBudget.fillBudgetLineCode(driver, testCaseName, budgetLine.getBudgetLineCode());
			//	PageCreateBudget.fillBudgetLineName(driver, testCaseName, budgetLine.getBudgetLineName());
			PageCreateBudget.fillBudgetLineOwner(driver, testCaseName, budgetLine.getOwner());
			PageCreateBudget.fillPlannedAmount(driver, testCaseName, budgetLine.getPlannedAmount());
			// save budget line
			PageCreateBudget.clickOnSaveBudgetLine(driver, testCaseName);

			ActionBot.defaultSleep();

			if (ActionBot.isElementPresent(driver, IPageCreateBudget.ALERT_ENTER_ALL_PARAMETERS_OF_BUDGET_LINE))
			{
				alertMessage = ActionBot.findElement(driver, IPageCreateBudget.ALERT_ENTER_ALL_PARAMETERS_OF_BUDGET_LINE).getText();

				if (alertMessage.equalsIgnoreCase(IConstantsData.ErrorMsg_BudgetLineAlertMessage))
				{
					EPROC_24311 = true;
				}
			}

			Assert.assertTrue(EPROC_24311, "Error message not received when all parameters were not filled. Message: " + alertMessage);
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :User should be allowed to
	 * delete multiple budget line codes on clicking on Delete Selected Lines on
	 * budget creation/updation page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24314(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		boolean EPROC_24314 = false;
		boolean budgetCreatedFlag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();

			// creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();

			budgetCreatedFlag = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);
			Assert.assertTrue(budgetCreatedFlag, "Budget not created");

			// select first budget
			FlowBudgetListing.viewBudget(driver, testCaseName);
			PageCreateBudget.selectBudgetLine(driver, testCaseName, budget.getBudgetLines().get(0).getBudgetLineName());
			EPROC_24314 = FlowCreateBudget.deletBudgetLine(driver, testCaseName, budget.getBudgetLines().get(0).getBudgetLineName());

			Assert.assertTrue(EPROC_24314, "Unable to delete multiple budget lines");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description : Dimension values present in
	 * dimensions drop down Cost centre, Project,GL Account, Department,
	 * Designation, Category, Location on budget creation page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24288(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		boolean EPROC_24288 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();
			budget.setAddBudgetLine(false);
			budget.setNextAction(IConstantsData.NONE);
			// creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();
			// generate budget dimension
			PageCreateBudget.clickOnGenerateBudgetDimension(driver, testCaseName);
			// getting first budget dimension

			if (ActionBot.findElement(driver, IPageCreateBudget.TEXT_FIRST_DIMENSION).getText().equals(IConstantsData.BUSINESS_UNIT_TEXT)
				& ActionBot.findElement(driver, IPageCreateBudget.TEXT_SECOND_DIMENSION).getText().equals(IConstantsData.LOCATION_SCOPE)
				& ActionBot.findElement(driver, IPageCreateBudget.TEXT_THIRD_DIMENSION).getText().equals(IConstantsData.COST_CENTER)
				& ActionBot.findElement(driver, IPageCreateBudget.TEXT_FOURTH_DIMENSION).getText().equals(IConstantsData.DEPARTMENT_SCOPE)
				& ActionBot.findElement(driver, IPageCreateBudget.TEXT_FIFTH_DIMENSION).getText().equals(IConstantsData.DESIGNATION))
			{
				EPROC_24288 = true;

			}
			Assert.assertTrue(EPROC_24288, "No correct dimension values present on dropdown");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description : Delete icon should be
	 * present for all dimensions except first dimension on budget creation
	 * page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24289(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		boolean EPROC_24289 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();
			budget.setAddBudgetLine(false);
			budget.setNextAction(IConstantsData.NONE);
			// creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();
			if (ActionBot.isElementDisplayed(driver, IPageCreateBudget.BUTTON_DELETE_ICON_FOR_FIRST_DIMENSION))
				EPROC_24289 = false;

			if (ActionBot.isElementDisplayed(driver, IPageCreateBudget.BUTTON_DELETE_ICON_FOR_SECOND_DIMENSION)
				&& ActionBot.isElementDisplayed(driver, IPageCreateBudget.BUTTON_DELETE_ICON_FOR_THIRD_DIMENSION)
				&& ActionBot.isElementDisplayed(driver, IPageCreateBudget.BUTTON_DELETE_ICON_FOR_FOURTH_DIMENSION)
				&& ActionBot.isElementDisplayed(driver, IPageCreateBudget.BUTTON_DELETE_ICON_FOR_FIFTH_DIMENSION))
				EPROC_24289 = true;

			Assert.assertTrue(EPROC_24289, "Delete icon must be present for all dimensions except first");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description : User should be allowed to
	 * create budget if budget already exists for same combination of Budget
	 * Period, Company name,budget Name but different currency on budget
	 * creation page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24205(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget1 = null, budget2 = null;
		boolean EPROC_24205 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);

			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);
			budget1 = ObjectCreation.getDefaultObjectOfBudget();
			budget2 = ObjectCreation.getDefaultObjectOfBudget();

			// creating budget
			budget1 = FlowCreateBudget.createBudget(driver, testCaseName, budget1);
			ActionBot.defaultSleep();

			budget2.setBudgetPeriod(budget1.getBudgetPeriod());
			budget2.setCompanyName(budget1.getCompanyName());
			budget2.setBudgetName(budget1.getBudgetName());
			budget2.setCurrencyType(CommonServices.getTestData(IConstantsData.CHANGED_CURRENCY));
			budget2 = FlowCreateBudget.createBudget(driver, testCaseName, budget2);
			// searching budget
			EPROC_24205 = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget2);
			Assert.assertTrue(EPROC_24205, "Unable to search budget");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description : User should be allowed to
	 * create budget if budget already exists for same combination of Currency,
	 * Company name, budget Period but different budget name on budget creation
	 * page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24206(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget1 = null, budget2 = null;
		boolean EPROC_24206 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);

			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);
			budget1 = ObjectCreation.getDefaultObjectOfBudget();
			budget2 = ObjectCreation.getDefaultObjectOfBudget();

			// creating budget
			budget1 = FlowCreateBudget.createBudget(driver, testCaseName, budget1);
			ActionBot.defaultSleep();

			budget2.setBudgetPeriod(budget1.getBudgetPeriod());
			budget2.setCompanyName(budget1.getCompanyName());
			budget2.setCurrencyType(budget1.getCurrencyType());
			budget2.setBudgetName(budget1.getBudgetName() + IConstantsData.NAME);
			budget2 = FlowCreateBudget.createBudget(driver, testCaseName, budget2);
			// searching budget
			EPROC_24206 = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget2);
			Assert.assertTrue(EPROC_24206, "Unable to search budget");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :User should be allowed to
	 * create budget if budget already exists for same combination of Currency,
	 * Company name,budget Name but different Budget Period on budget creation
	 * page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24207(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget1 = null, budget2 = null;
		boolean EPROC_24207 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);

			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);
			budget1 = ObjectCreation.getDefaultObjectOfBudget();
			budget2 = ObjectCreation.getDefaultObjectOfBudget();

			// creating budget
			budget1 = FlowCreateBudget.createBudget(driver, testCaseName, budget1);
			ActionBot.defaultSleep();

			budget2.setBudgetName(budget1.getBudgetName());
			budget2.setCompanyName(budget1.getCompanyName());
			budget2.setCurrencyType(budget1.getCurrencyType());
			budget2 = FlowCreateBudget.createBudget(driver, testCaseName, budget2);
			// searching budget
			EPROC_24207 = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget2);
			Assert.assertTrue(EPROC_24207, "Unable to search budget");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description : User should be allowed to
	 * create budget if budget already exists for same combination of
	 * Currency,Budget Period, budget Name but different Company Name on budget
	 * creation page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24208(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget1 = null, budget2 = null;
		BudgetLine budgetLine = null;
		boolean EPROC_24208 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);

			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);
			budget1 = ObjectCreation.getDefaultObjectOfBudget();
			budget2 = ObjectCreation.getDefaultObjectOfBudget();

			budgetLine = budget2.getBudgetLines().get(0);
			// creating budget
			budget1 = FlowCreateBudget.createBudget(driver, testCaseName, budget1);
			ActionBot.defaultSleep();

			budget2.setBudgetName(budget1.getBudgetName());
			budget2.setCurrencyType(budget1.getCurrencyType());
			budget2.setBudgetPeriod(budget1.getBudgetPeriod());
			budget2.setCompanyName(CommonServices.getTestData(IConstantsData.Other_Company_Name));
			budget2.setNextAction(IConstantsData.NONE);
			budget2.setAddBudgetLine(false);
			budget2 = FlowCreateBudget.createBudget(driver, testCaseName, budget2);
			PageCreateBudget.clickOnGenerateBudgetDimension(driver, testCaseName);
			budgetLine.setBusinessUnit(CommonServices.getTestData(IConstantsData.Other_BusinessUnit1));
			budgetLine.setCostCenter(CommonServices.getTestData(IConstantsData.OTHER_COMPANY_CC));
			budgetLine.setBudgetLineCode(budgetLine.getBudgetLineCode() + CommonUtilities.getNonZeroRandomNumber(4));
			FlowCreateBudget.addBudgetLine(driver, testCaseName, budgetLine);
			FlowCreateBudget.saveAndFreezeBudget(driver, testCaseName);
			// searching budget
			EPROC_24208 = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget2);
			Assert.assertTrue(EPROC_24208, "Unable to search budget");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description : If the Budget dimensions are
	 * created with valid sequence, same dimensions should be present in budget
	 * lines on budget creation page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24290(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		boolean EPROC_24290 = true;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();
			budget.setAddBudgetLine(false);
			budget.setNextAction(IConstantsData.NONE);

			// creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();

			// generate budget dimension
			PageCreateBudget.clickOnGenerateBudgetDimension(driver, testCaseName);

			// checking dimensions sequence
			if (!(ActionBot.findElement(driver, IPageCreateBudget.TEXT_FIRST_DIMENSION).getText()
				.matches(ActionBot.findElement(driver, IPageCreateBudget.TEXT_FIRST_DIMENSION_FROM_BUDGET_LINE).getText())))
			{
				EPROC_24290 = false;
			}

			if (!(ActionBot.findElement(driver, IPageCreateBudget.TEXT_SECOND_DIMENSION).getText()
				.matches(ActionBot.findElement(driver, IPageCreateBudget.TEXT_SECOND_DIMENSION_FROM_BUDGET_LINE).getText())))
			{
				EPROC_24290 = false;
			}

			if (!(ActionBot.findElement(driver, IPageCreateBudget.TEXT_THIRD_DIMENSION).getText()
				.matches(ActionBot.findElement(driver, IPageCreateBudget.TEXT_THIRD_DIMENSION_FROM_BUDGET_LINE).getText())))
			{
				EPROC_24290 = false;
			}

			if (!(ActionBot.findElement(driver, IPageCreateBudget.TEXT_FOURTH_DIMENSION).getText()
				.matches(ActionBot.findElement(driver, IPageCreateBudget.TEXT_FOURTH_DIMENSION_FROM_BUDGET_LINE).getText())))
			{
				EPROC_24290 = false;
			}

			if (!(ActionBot.findElement(driver, IPageCreateBudget.TEXT_FIFTH_DIMENSION).getText()
				.matches(ActionBot.findElement(driver, IPageCreateBudget.TEXT_FIFTH_DIMENSION_FROM_BUDGET_LINE).getText())))
			{
				EPROC_24290 = false;
			}
			Assert.assertTrue(EPROC_24290, "Sequence of dimensions and budget line not matched");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :Location autocomplete text
	 * box should display all the Locations present in selected Business unit in
	 * Budget Lines on budget creation/updation page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24329(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		boolean EPROC_24329 = false;
		boolean budgetCreatedFlag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();

			// creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();

			budgetCreatedFlag = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);
			Assert.assertTrue(budgetCreatedFlag, "Budget not created");

			// select first budget
			FlowBudgetListing.viewBudget(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");

			// adding budget line
			PageCreateBudget.clickOnAddBudgetLineButton(driver, testCaseName);
			PageCreateBudget.fillBusinessUnit(driver, testCaseName, budget.getBudgetLines().get(0).getBusinessUnit());
			jsx.executeScript("window.scrollBy(0,850)", "");

			// Checking for autopopulation of location
			WebElement location = ActionBot.findElement(driver, IPageCreateBudget.TEXTFIELD_LOCATION_FROM_BUDGETLINE);
			location.click();
			ActionBot.defaultMediumSleep();
			EPROC_24329 = ActionBot.isElementDisplayed(driver, IPageCreateBudget.SELECT_AUTOPOPULATED_LOCATION);

			Assert.assertTrue(EPROC_24329, "location not auto populated");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :User should be able to
	 * download Budget template on Upload via file pop-up on Budget creation
	 * page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24411(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		boolean EPROC_24411 = false;
		boolean budgetCreatedFlag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();

			// creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);

			ActionBot.defaultSleep();
			budgetCreatedFlag = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);
			Assert.assertTrue(budgetCreatedFlag, "Budget not created");

			// select first budget
			FlowBudgetListing.viewBudget(driver, testCaseName);
			PageCreateBudget.clickOnUploadViaFile(driver, testCaseName);

			boolean uploadViaFile = ActionBot.isElementDisplayed(driver, IPageCreateBudget.BUTTON_UPLOAD_VIA_FILE);
			if (uploadViaFile)
				EPROC_24411 = true;
			Assert.assertTrue(EPROC_24411, "Unable to upload budget line via file");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :Business Unit autocomplete
	 * text box should display all the Business units in the tenant in Budget
	 * Lines on budget creation/updation page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24327(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		boolean EPROC_24327 = false;
		boolean budgetCreatedFlag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();

			// creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();

			//search budget
			budgetCreatedFlag = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);
			Assert.assertTrue(budgetCreatedFlag, "Budget not created");

			// select first budget
			FlowBudgetListing.viewBudget(driver, testCaseName);

			// adding budget line
			PageCreateBudget.clickOnAddBudgetLineButton(driver, testCaseName);

			// Checking for autopopulation of business unit
			ActionBot.findElement(driver, IPageCreateBudget.TEXTFIELD_BUSINESS_UNIT_FROM_BUDGETLINE).click();

			EPROC_24327 = ActionBot.isElementDisplayed(driver, IPageCreateBudget.SELECT_AUTOPOPULATED_BUSINESS_UNIT);

			Assert.assertTrue(EPROC_24327, "Business Unit not auto populated");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :If the setting
	 * "Allow budget utilization" is set to 'YES' in Setup>> Customize>> Cost
	 * booking , Allow budget utilization setting should be set default to YES
	 * in 'Cost allocation tab' on checkout page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24348(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		boolean EPROC_24348 = false;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();

			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);

			// to checkout
			OnlineStore onlineStore = ObjectCreation.searchItem();
			// adding item and checkout
			FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlineStore);

			PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
			PageRequisitionCheckOut.clickCostAllocation(driver, testCaseName);

			if (ActionBot.isElementPresent(driver, IModelRequisitionSummaryCostBookingImpl.COSTBOOKING_SINGLE_BUDGET))
			{
				EPROC_24348 = true;
			}

			Assert.assertTrue(EPROC_24348, " Allow budget utilization setting should be set default to YES");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :User should not be able to
	 * create duplicate budget lines codes within the budget on budget
	 * creation/updation page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24316(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		BudgetLine budgetLine = null;
		boolean EPROC_24316 = false;
		boolean budgetCreatedFlag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);
			budget = ObjectCreation.getDefaultObjectOfBudget();
			budgetLine = budget.getBudgetLines().get(0);

			// creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();

			//search budget
			budgetCreatedFlag = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);
			Assert.assertTrue(budgetCreatedFlag, "Unable to search budget: " + budget.getBudgetName());

			// select first budget
			FlowBudgetListing.viewBudget(driver, testCaseName);

			// adding budget line
			PageCreateBudget.clickOnAddBudgetLineButton(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageCreateBudget.fillBusinessUnit(driver, testCaseName, budget.getBudgetLines().get(0).getBusinessUnit());
			PageCreateBudget.fillBudgetLineLocation(driver, testCaseName, budget.getBudgetLines().get(0).getLocation());
			PageCreateBudget.fillBudgetLineCostCenter(driver, testCaseName, budget.getBudgetLines().get(0).getCostCenter());
			PageCreateBudget.selectBudgetLineDepartment(driver, testCaseName, budget.getBudgetLines().get(0).getDepartment());

			PageCreateBudget.fillBudgetLineCode(driver, testCaseName, budget.getBudgetLines().get(0).getBudgetLineCode());
			PageCreateBudget.fillBudgetLineName(driver, testCaseName, budget.getBudgetLines().get(0).getBudgetLineName());
			PageCreateBudget.fillBudgetLineOwner(driver, testCaseName, budget.getBudgetLines().get(0).getOwner());
			PageCreateBudget.fillPlannedAmount(driver, testCaseName, budget.getBudgetLines().get(0).getPlannedAmount());
			ActionBot.defaultMediumSleep();
			// saving budget line
			PageCreateBudget.clickOnSaveBudgetLine(driver, testCaseName);

			ActionBot.defaultMediumSleep();

			EPROC_24316 = (ActionBot.isElementDisplayed(driver, IPageCreateBudget.ALERT_DUPLICATE_BUDGET_LINE)
				|| ActionBot.isElementDisplayed(driver, IPageCreateBudget.ALERT_DUPLICATE_BUDGET_LINE_CODE));
			Assert.assertTrue(EPROC_24316, " Duplicate budget line codes within same budget...");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :Cost Centres should display
	 * all the Active Cost centres in the tenant in Auto-generate combinations
	 * pop-up.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24496(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		boolean EPROC_24495 = false;
		boolean budgetCreatedFlag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();

			//create budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();

			//search budget
			budgetCreatedFlag = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);
			Assert.assertTrue(budgetCreatedFlag, "Unable to search budget: " + budget.getBudgetName());

			// select first budget
			FlowBudgetListing.viewBudget(driver, testCaseName);

			// click on auto generate combinations
			PageCreateBudget.clickOnAutoGenerateCombinations(driver, testCaseName);

			boolean businessUnit = ActionBot.isElementDisplayed(driver, IPageCreateBudget.TEXT_BUSIENSS_UNIT_AUTOGENERATE_BUDGET_LINE);
			boolean autoGenerate1 = ActionBot.isElementDisplayed(driver, IPageCreateBudget.WINDOW_AUTOGENERATE_BUDGET_LINE);
			boolean costCenters = ActionBot.isElementDisplayed(driver, IPageCreateBudget.TEXT_COST_CENTER_AUTOGENERATE_BUDGET_LINE);
			boolean autoGenerate2 = ActionBot.isElementDisplayed(driver, IPageCreateBudget.WINDOW_AUTOGENERATE_BUDGET_LINE);

			boolean costCenter_1 = ActionBot.isElementDisplayed(driver, IPageCreateBudget.CHECKBOX_COST_CENTER_AUTOGENERATE_BUDGET_LINE_1);
			boolean costCenter_2 = ActionBot.isElementDisplayed(driver, IPageCreateBudget.CHECKBOX_COST_CENTER_AUTOGENERATE_BUDGET_LINE_2);
			boolean costCenter_3 = ActionBot.isElementDisplayed(driver, IPageCreateBudget.CHECKBOX_COST_CENTER_AUTOGENERATE_BUDGET_LINE_3);

			if (costCenter_1 || costCenter_2 || costCenter_3)
			{
				EPROC_24495 = true;
			}
			ActionBot.defaultMediumSleep();
			Assert.assertTrue(EPROC_24495, " Business Units must be displayed to all the Active Business units.");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :If user selects
	 * "Book cost to a single cost center", user should be able to use single
	 * budget in cost allocation tab of Requisition Summary pop-up on checkout
	 * page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24377(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		boolean EPROC_24377 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			OnlineStore onlineStore = ObjectCreation.searchItem();
			// adding item and checkout
			FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlineStore);
			// PageSearchListing.clickOnCheckOutButton(driver, testCaseName);
			PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
			PageRequisitionCheckOut.clickCostAllocation(driver, testCaseName);

			// costToSingleCostCenter

			ActionBot.findElement(driver, IPageCreateBudget.BUTTON_BOOK_COST_TO_SINGLE_COST_CENTER).click();

			boolean isAddAnotherBudgetButton1 = ActionBot.isElementDisplayed(driver, IPageCreateBudget.BUTTON_ADD_ANOTHER_BUDGET_IN_COST_ALLOCATION);

			if (!isAddAnotherBudgetButton1)
			{
				EPROC_24377 = true;
			}
			Assert.assertTrue(EPROC_24377, "able to add multiple budget after selecting 'Book cost to a single cost center'");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :If user selects
	 * "Book cost to multiple cost center", user should be able to add and use
	 * multiple budgets in cost allocation tab of Requisition Summary pop-up on
	 * checkout page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24378(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		boolean EPROC_24378 = false;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			OnlineStore onlineStore = ObjectCreation.searchItem();
			// adding item and checkout
			FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlineStore);

			PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
			PageRequisitionCheckOut.clickCostAllocation(driver, testCaseName);

			ActionBot.findElement(driver, IPageCreateBudget.BUTTON_BOOK_COST_TO_MULTIPLE_COST_CENTER).click();
			ActionBot.defaultMediumSleep();
			boolean isAddAnotherBudgetButton2 = ActionBot.isElementDisplayed(driver, IPageCreateBudget.BUTTON_ADD_ANOTHER_BUDGET_IN_COST_ALLOCATION);

			ActionBot.findElement(driver, IPageCreateBudget.BUTTON_ADD_ANOTHER_BUDGET_IN_COST_ALLOCATION).click();

			if (isAddAnotherBudgetButton2)
			{
				EPROC_24378 = true;
			}

			Assert.assertTrue(EPROC_24378, "Unable to add multiple budgets after selectsing 'Book cost to multiple cost center'");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :Verify user should be able to
	 * search budget line through budget dimension values field on budget
	 * creation/update page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24298(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		boolean EPROC_24298 = false;
		boolean budgetCreatedFlag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();

			// creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();
			//search budget
			budgetCreatedFlag = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);
			Assert.assertTrue(budgetCreatedFlag, "Unable to search budget: " + budget.getBudgetName());

			// select first budget
			FlowBudgetListing.viewBudget(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			EPROC_24298 = ActionBot.isElementDisplayed(driver, IPageCreateBudget.CHECKBOX_OF_FIRST_BUDGET_LINE);

			Assert.assertTrue(EPROC_24298, "Unable to search budget line through budget dimensions");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :User should not be able to
	 * add duplicate budget lines codes for the different budgets.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24317(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget1 = null;
		Budget budget2 = null;
		BudgetLine budgetLine = null;
		boolean EPROC_24317 = false;

		try
		{
			driver = DriverSelector.getDriver(testCase);

			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);
			budget1 = ObjectCreation.getDefaultObjectOfBudget();
			budget2 = ObjectCreation.getDefaultObjectOfBudget();

			budgetLine = budget2.getBudgetLines().get(0);
			// creating budget
			budget1 = FlowCreateBudget.createBudget(driver, testCaseName, budget1);
			ActionBot.defaultSleep();

			budget2.setBudgetName(budget1.getBudgetName());
			budget2.setCurrencyType(budget1.getCurrencyType());
			budget2.setBudgetPeriod(budget1.getBudgetPeriod());
			budget2.setCompanyName(CommonServices.getTestData(IConstantsData.Other_Company_Name));
			budget2.setNextAction(IConstantsData.NONE);
			budget2.setAddBudgetLine(false);
			budget2 = FlowCreateBudget.createBudget(driver, testCaseName, budget2);
			PageCreateBudget.clickOnGenerateBudgetDimension(driver, testCaseName);
			budgetLine.setBusinessUnit(CommonServices.getTestData(IConstantsData.Other_BusinessUnit1));
			budgetLine.setCostCenter(CommonServices.getTestData(IConstantsData.OTHER_COMPANY_CC));
			budgetLine.setBudgetLineCode(budgetLine.getBudgetLineCode());
			FlowCreateBudget.addBudgetLine(driver, testCaseName, budgetLine);

			EPROC_24317 = ActionBot.isElementDisplayed(driver, IPageCreateBudget.ALERT_DUPLICATE_BUDGET_LINE);
			Assert.assertTrue(EPROC_24317, " Duplicate budget line codes within same budget...");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :Info icon of budget in cost
	 * allocation tab should display the following things (mentioned in expected
	 * result).
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24372(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		boolean EPROC_24372 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			OnlineStore onlineStore = ObjectCreation.searchItem();
			// adding item and checkout
			FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlineStore);
			PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
			PageRequisitionCheckOut.clickCostAllocation(driver, testCaseName);

			EPROC_24372 = ActionBot.isElementDisplayed(driver, IPageCreateBudget.TEXT_INFO_ICON_IN_COST_ALLOCATION);

			String text = ActionBot.findElement(driver, IPageCreateBudget.TEXT_INFO_ICON_IN_COST_ALLOCATION).getText();
			if (text.contains("Select cost-center before selecting a budget-line"))
			{
				EPROC_24372 = true;
			}
			Assert.assertTrue(EPROC_24372, "Info icon of budget in cost allocation tab not displaying..!");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :Budget Line code should get
	 * auto-populated in following format:#/BudgetDimensionCode1/�2/..3after
	 * entering the budget dimension while creating budget lines on budget
	 * creation/updation page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24319(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		BudgetLine budgetLine = null;
		boolean EPROC_24372 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();
			budgetLine = budget.getBudgetLines().get(0);
			budget.setNextAction(IConstantsData.NONE);
			budget.setAddBudgetLine(false);

			// creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();

			// generate budget dimension
			PageCreateBudget.clickOnGenerateBudgetDimension(driver, testCaseName);

			// adding budget line
			PageCreateBudget.clickOnAddBudgetLineButton(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			budgetLine.setBusinessUnit(PageCreateBudget.fillBusinessUnit(driver, testCaseName, budgetLine.getBusinessUnit()));
			budgetLine.setLocation(PageCreateBudget.fillBudgetLineLocation(driver, testCaseName, budgetLine.getLocation()));
			budgetLine.setCostCenter(PageCreateBudget.fillBudgetLineCostCenter(driver, testCaseName, budgetLine.getCostCenter()));
			budgetLine.setDepartment(PageCreateBudget.selectBudgetLineDepartment(driver, testCaseName, budgetLine.getDepartment()));
			budgetLine.setDesignation(PageCreateBudget.selectBudgetLineDesignation(driver, testCaseName, budgetLine.getDesignation()));
			budgetLine.setBudgetLineName(PageCreateBudget.fillBudgetLineName(driver, testCaseName, budgetLine.getBudgetLineName()));
			budgetLine.setOwner(PageCreateBudget.fillBudgetLineOwner(driver, testCaseName, budgetLine.getOwner()));
			budgetLine.setPlannedAmount(PageCreateBudget.fillPlannedAmount(driver, testCaseName, budgetLine.getPlannedAmount()));
			ActionBot.defaultMediumSleep();
			jsx.executeScript("window.scrollBy(0,850)", "");
			ActionBot.findElement(driver, IPageCreateBudget.INPUT_TEXTFEILD_BUDGET_LINE_CODE).click();

			// save budget line
			PageCreateBudget.clickOnSaveBudgetLine(driver, testCaseName);
			PageCreateBudget.clickOnSaveAndFreezeBudgetButton(driver, testCaseName);

			EPROC_24372 = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);
			Assert.assertTrue(EPROC_24372, "Budget line code not populated");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :Budget lines with * dimension
	 * values: Business Unit should be displayed to all active Business Units in
	 * tenant on checkout page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24340(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		boolean EPROC_24340 = false;
		boolean budgetCreatedFlag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();

			// creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();

			//search budget
			budgetCreatedFlag = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);
			Assert.assertTrue(budgetCreatedFlag, "Unable to search budget: " + budget.getBudgetName());

			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			OnlineStore onlineStore = ObjectCreation.searchItem();

			// adding item and checkout
			FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlineStore);
			PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
			ActionBot.findElement(driver, IPageCreateBudget.TEXTFEILD_BUSINESS_UNIT_ON_CHECKOUT).clear();
			ActionBot.findElement(driver, IPageCreateBudget.TEXTFEILD_BUSINESS_UNIT_ON_CHECKOUT).click();

			EPROC_24340 = ActionBot.isElementDisplayed(driver, IPageCreateBudget.SELECT_AUTOCOMPLETE_BUSINESS_UNIT_ON_CHECKOUT);
			Assert.assertTrue(!EPROC_24340, "Business unit not displying all active business units.!");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :User should be able to view
	 * the reserved amount in % on budget listing page if requisition is
	 * converted to PO.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24370(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		boolean EPROC_24370 = false;
		Requisition requisition = null;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();

			requisition = ObjectCreation.getDefaultRequisitionObjectWithItems(driver);

			//creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();
			MainPageHeaderLevelTab.clickOnBudgetTab(driver, testCaseName);
			// getting reserved amount
			String reservedAmount = ActionBot.findElement(driver, IPageCreateBudget.TEXT_FIRST_RESERVED_AMOUNT_ON_BUDGET_LISTING).getText();
			Pattern pattern = Pattern.compile("[0-9]*[.]*[0-9]*[%]");
			Matcher matcher = pattern.matcher(reservedAmount);
			EPROC_24370 = matcher.find();
			Assert.assertTrue(EPROC_24370, "Unable to view reserved amount in %.!!");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :Budget Dimensions should be
	 * displayed in same sequence in Auto-generate combinations pop-up as
	 * defined in Budget Dimensions .
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24506(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		BudgetLine budgetLine = null;
		boolean EPROC_24506 = false;
		boolean budgetCreatedFlag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();
			budgetLine = budget.getBudgetLines().get(0);
			budget.setAddBudgetLine(false);
			budget.setNextAction(IConstantsData.NONE);

			// creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();

			// generate budget dimension
			PageCreateBudget.clickOnGenerateBudgetDimension(driver, testCaseName);
			ActionBot.defaultMediumSleep();

			String dimension_1 = ActionBot.findElement(driver, IPageCreateBudget.TEXT_FIRST_DIMENSION).getText();

			String dimension_2 = ActionBot.findElement(driver, IPageCreateBudget.TEXT_SECOND_DIMENSION).getText();
			String dimension_3 = ActionBot.findElement(driver, IPageCreateBudget.TEXT_THIRD_DIMENSION).getText();
			String dimension_4 = ActionBot.findElement(driver, IPageCreateBudget.TEXT_FOURTH_DIMENSION).getText();
			String dimension_5 = ActionBot.findElement(driver, IPageCreateBudget.TEXT_FIFTH_DIMENSION).getText();

			FlowCreateBudget.addBudgetLine(driver, testCaseName, budgetLine);
			// saving budget
			PageCreateBudget.clickOnSaveAndFreezeBudgetButton(driver, testCaseName);

			//search budget
			budgetCreatedFlag = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);
			Assert.assertTrue(budgetCreatedFlag, "Unable to search budget: " + budget.getBudgetName());

			// select first budget
			FlowBudgetListing.viewBudget(driver, testCaseName);
			// click on auto generate combinations
			PageCreateBudget.clickOnAutoGenerateCombinations(driver, testCaseName);
			// getting budget dimension from autogenerate combinations

			String auto_dimension_1 = ActionBot.findElement(driver, IPageCreateBudget.TEXT_FIRST_DIMENSION_FROM_AUTOGENERATE_COMBINATION).getText();
			String auto_dimension_2 = ActionBot.findElement(driver, IPageCreateBudget.TEXT_SECOND_DIMENSION_FROM_AUTOGENERATE_COMBINATION).getText();
			String auto_dimension_3 = ActionBot.findElement(driver, IPageCreateBudget.TEXT_THIRD_DIMENSION_FROM_AUTOGENERATE_COMBINATION).getText();
			String auto_dimension_4 = ActionBot.findElement(driver, IPageCreateBudget.TEXT_FOURTH_DIMENSION_FROM_AUTOGENERATE_COMBINATION).getText();
			String auto_dimension_5 = ActionBot.findElement(driver, IPageCreateBudget.TEXT_FIFTH_DIMENSION_FROM_AUTOGENERATE_COMBINATION).getText();

			String dimensions1 = dimension_1 + "s *" + dimension_2 + "s *" + dimension_3 + "s *" + dimension_4 + "s *" + dimension_5 + "s";
			String dimensions2 = auto_dimension_1 + auto_dimension_2 + auto_dimension_3 + auto_dimension_4 + auto_dimension_5;
			ActionBot.defaultMediumSleep();

			EPROC_24506 = dimensions1.equals(dimensions2);
			Assert.assertTrue(EPROC_24506, " Dimensions not in sequence with Auto-generate combinations");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :User should be able to select
	 * multiple values for particular Budget Dimensions in Auto-generate
	 * combinations pop-up.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24503(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		boolean EPROC_24503 = false;
		boolean budgetCreatedFlag = false;
		try
		{

			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();

			//creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();

			//search budget
			budgetCreatedFlag = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);
			Assert.assertTrue(budgetCreatedFlag, "Unable to search budget: " + budget.getBudgetName());

			// select first budget
			FlowBudgetListing.viewBudget(driver, testCaseName);
			// click on auto generate combinations
			PageCreateBudget.clickOnAutoGenerateCombinations(driver, testCaseName);
			boolean businessUnit = ActionBot.isElementDisplayed(driver, IPageCreateBudget.TEXT_BUSIENSS_UNIT_AUTOGENERATE_BUDGET_LINE);
			boolean autoGenerate1 = ActionBot.isElementDisplayed(driver, IPageCreateBudget.WINDOW_AUTOGENERATE_BUDGET_LINE);
			boolean costCenters = ActionBot.isElementDisplayed(driver, IPageCreateBudget.TEXT_COST_CENTER_AUTOGENERATE_BUDGET_LINE);
			boolean autoGenerate2 = ActionBot.isElementDisplayed(driver, IPageCreateBudget.WINDOW_AUTOGENERATE_BUDGET_LINE);
			boolean costCenter_1 = ActionBot.isElementDisplayed(driver, IPageCreateBudget.CHECKBOX_COST_CENTER_AUTOGENERATE_BUDGET_LINE_1);
			boolean costCenter_2 = ActionBot.isElementDisplayed(driver, IPageCreateBudget.CHECKBOX_COST_CENTER_AUTOGENERATE_BUDGET_LINE_2);

			costCenter_1 = ActionBot.isElementDisplayed(driver, IPageCreateBudget.CHECKBOX_COST_CENTER_AUTOGENERATE_BUDGET_LINE_1);
			costCenter_2 = ActionBot.isElementDisplayed(driver, IPageCreateBudget.CHECKBOX_COST_CENTER_AUTOGENERATE_BUDGET_LINE_2);

			if (costCenter_1 || costCenter_2)
			{

				EPROC_24503 = true;
			}

			ActionBot.findElement(driver, IPageCreateBudget.CHECKBOX_COST_CENTER_AUTOGENERATE_BUDGET_LINE_1).click();

			ActionBot.findElement(driver, IPageCreateBudget.CHECKBOX_COST_CENTER_AUTOGENERATE_BUDGET_LINE_2).click();

			ActionBot.defaultMediumSleep();
			Assert.assertTrue(EPROC_24503, "Unable to select multiple values for Dimensions in Auto-generate combinations");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (

		AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :Auto-generate combinations
	 * should be displayed according to selected Budget Dimensions on Budget
	 * Creation/ Updation page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24491(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		BudgetLine budgetLine = null;
		boolean EPROC_24491 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();
			budgetLine = budget.getBudgetLines().get(0);
			budget.setAddBudgetLine(false);
			budget.setNextAction(IConstantsData.NONE);

			// creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();

			// generate budget dimension
			PageCreateBudget.clickOnGenerateBudgetDimension(driver, testCaseName);

			ActionBot.defaultMediumSleep();
			String dimension_1 = ActionBot.findElement(driver, IPageCreateBudget.TEXT_FIRST_DIMENSION).getText();
			String dimension_2 = ActionBot.findElement(driver, IPageCreateBudget.TEXT_SECOND_DIMENSION).getText();
			String dimension_3 = ActionBot.findElement(driver, IPageCreateBudget.TEXT_THIRD_DIMENSION).getText();
			String dimension_4 = ActionBot.findElement(driver, IPageCreateBudget.TEXT_FOURTH_DIMENSION).getText();
			String dimension_5 = ActionBot.findElement(driver, IPageCreateBudget.TEXT_FIFTH_DIMENSION).getText();

			FlowCreateBudget.addBudgetLine(driver, testCaseName, budgetLine);

			// saving budget
			PageCreateBudget.clickOnSaveAndFreezeBudgetButton(driver, testCaseName);

			// select first budget
			FlowBudgetListing.viewBudget(driver, testCaseName);

			// click on auto generate combinations
			PageCreateBudget.clickOnAutoGenerateCombinations(driver, testCaseName);

			// getting budget dimension from autogenerate combinations
			String auto_dimension_1 = ActionBot.findElement(driver, IPageCreateBudget.TEXT_FIRST_DIMENSION_FROM_AUTOGENERATE_COMBINATION).getText();
			String auto_dimension_2 = ActionBot.findElement(driver, IPageCreateBudget.TEXT_SECOND_DIMENSION_FROM_AUTOGENERATE_COMBINATION).getText();
			String auto_dimension_3 = ActionBot.findElement(driver, IPageCreateBudget.TEXT_THIRD_DIMENSION_FROM_AUTOGENERATE_COMBINATION).getText();
			String auto_dimension_4 = ActionBot.findElement(driver, IPageCreateBudget.TEXT_FOURTH_DIMENSION_FROM_AUTOGENERATE_COMBINATION).getText();
			String auto_dimension_5 = ActionBot.findElement(driver, IPageCreateBudget.TEXT_FIFTH_DIMENSION_FROM_AUTOGENERATE_COMBINATION).getText();

			String dimensions1 = dimension_1 + "s *" + dimension_2 + "s *" + dimension_3 + "s *" + dimension_4 + "s *" + dimension_5 + "s";
			String dimensions2 = auto_dimension_1 + auto_dimension_2 + auto_dimension_3 + auto_dimension_4 + auto_dimension_5;

			EPROC_24491 = dimensions1.equals(dimensions2);
			ActionBot.defaultHighSleep();

			Assert.assertTrue((EPROC_24491), "Auto-generate combinations not displayed according to selected Budget Dimensions on Budget Creation page");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :If user does not select any
	 * of mandatory budget dimension in Auto-generate combinations pop-up, alert
	 * box should appear with message : Please select proper set of combinations
	 * with last dimension being optional.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24493(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		boolean EPROC_24493 = false;
		boolean budgetCreatedFlag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();

			// creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();

			//search budget
			budgetCreatedFlag = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);
			Assert.assertTrue(budgetCreatedFlag, "Budget not created");

			// select first budget
			FlowBudgetListing.viewBudget(driver, testCaseName);

			// click on auto generate combinations
			PageCreateBudget.clickOnAutoGenerateCombinations(driver, testCaseName);
			ActionBot.findElement(driver, IPageCreateBudget.BUTTON_GENERATE_AUTOGENRATE_BUDGET_LINES).click();

			EPROC_24493 = ActionBot.isElementDisplayed(driver, IPageCreateBudget.ALERT_PROPER_COMBINATIONS_IN_AUTOGENERATE);
			Assert.assertTrue(EPROC_24493, "Proper set of combinations not selected..!!");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :Verify user should
	 * be able to search budget line through budget line Code field on budget creation/update page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24299(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		boolean EPROC_24299 = false;
		boolean budgetCreatedFlag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();

			// creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();

			//search budget
			budgetCreatedFlag = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);
			Assert.assertTrue(budgetCreatedFlag, "Budget not created");

			// select first budget
			FlowBudgetListing.viewBudget(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			ActionBot.findElement(driver, IPageCreateBudget.TEXTFEILD_BUDGET_LINE_CODE).sendKeys("" + budget.getBudgetLines().get(0).getBudgetLineCode().charAt(0));

			EPROC_24299 = ActionBot.isElementDisplayed(driver, IPageCreateBudget.CHECKBOX_OF_FIRST_BUDGET_LINE);

			Assert.assertTrue(EPROC_24299, "Unable to search budget line through budget dimensions");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :Verify user should be able
	 * to search budget line through budget line name field on budget creation/update page.et creation/update page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24300(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		BudgetLine budgetLine = null;

		boolean EPROC_24300 = false;
		boolean budgetCreatedFlag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();
			budgetLine = budget.getBudgetLines().get(0);
			// creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();

			//search budget
			budgetCreatedFlag = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);
			Assert.assertTrue(budgetCreatedFlag, "Budget not created");

			// select first budget
			FlowBudgetListing.viewBudget(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			ActionBot.findElement(driver, IPageCreateBudget.TEXTFIELD_BUDGET_LINE_NAME).sendKeys("" + budgetLine.getBudgetLineName().charAt(0));

			EPROC_24300 = ActionBot.isElementDisplayed(driver, IPageCreateBudget.CHECKBOX_OF_FIRST_BUDGET_LINE);

			Assert.assertTrue(EPROC_24300, "Unable to search budget line through budget dimensions");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :User should be allowed to
	 * delete multiple budget line codes on clicking on Delete Selected Lines on
	 * budget creation/updation page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24315(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		BudgetLine budgetLine = null;
		boolean EPROC_24315 = false;
		boolean budgetCreatedFlag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;

			budget = ObjectCreation.getDefaultObjectOfBudget();
			budgetLine = budget.getBudgetLines().get(0);
			// creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();

			//search budget
			budgetCreatedFlag = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);
			Assert.assertTrue(budgetCreatedFlag, "Budget not created");

			// select first budget
			FlowBudgetListing.viewBudget(driver, testCaseName);
			jsx.executeScript("window.scrollBy(0,850)", "");
			budgetLine.setBusinessUnit(CommonServices.getTestData(IConstantsData.BusinessUnit_Name1));
			budgetLine.setBudgetLineCode(budgetLine.getBudgetLineCode() + CommonUtilities.getNonZeroRandomNumber(5));
			FlowCreateBudget.addBudgetLine(driver, testCaseName, budgetLine);
			ActionBot.defaultSleep();
			//select all budget lines
			ActionBot.findElement(driver, IPageCreateBudget.CHECKBOX_SELECT_ALL_BUDGET_LINE).click();
			//delete selected button
			ActionBot.findElement(driver, IPageCreateBudget.BUTTON_DELETE_SELECTED_BUDGET_LINE).click();
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			ActionBot.defaultSleep();
			EPROC_24315 = PageCreateBudget.isBudgetLineDeleted(driver, testCaseName, budget.getBudgetLines().get(0).getBudgetLineName());
			Assert.assertTrue(EPROC_24315, "Total number of budget lines not on budget creation page");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :User should be allowed to
	 * generate budget dimensions, if unique dimension values are entered for
	 * budget dimensions on budget creation page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24284(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		BudgetLine budgetLine = null;
		boolean EPROC_24284 = false;
		boolean budgetCreatedFlag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);
			ArrayList<String> list = new ArrayList<>();
			LinkedHashSet<String> set = new LinkedHashSet<>();

			budget = ObjectCreation.getDefaultObjectOfBudget();
			budgetLine = budget.getBudgetLines().get(0);
			budget.setNextAction(IConstantsData.NONE);
			budget.setAddBudgetLine(false);

			//create budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();

			PageCreateBudget.clickOnGenerateBudgetDimension(driver, testCaseName);
			list.add(ActionBot.findElement(driver, IPageCreateBudget.TEXT_FIRST_DIMENSION).getText());
			list.add(ActionBot.findElement(driver, IPageCreateBudget.TEXT_SECOND_DIMENSION).getText());
			list.add(ActionBot.findElement(driver, IPageCreateBudget.TEXT_THIRD_DIMENSION).getText());
			list.add(ActionBot.findElement(driver, IPageCreateBudget.TEXT_FOURTH_DIMENSION).getText());
			list.add(ActionBot.findElement(driver, IPageCreateBudget.TEXT_FIFTH_DIMENSION).getText());

			for (String dimensions : list)
			{
				set.add(dimensions);
			}
			EPROC_24284 = (list.size() == set.size());

			org.testng.Assert.assertTrue(EPROC_24284, "Unique dimensions not present");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description : Owner name autocomplete text
	 * box should display all the Active users of the tenant while creating
	 * budget lines on budget creation/updation page.
	 */

	@Test(dataProvider = "dataProvider")
	public void EPROC_24325(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		BudgetLine budgetLine = null;
		boolean EPROC_24325 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();
			budget.setNextAction(IConstantsData.NONE);
			budget.setAddBudgetLine(false);

			//Creqting budet
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();

			budgetLine = budget.getBudgetLines().get(0);

			PageCreateBudget.clickOnGenerateBudgetDimension(driver, testCaseName);
			PageCreateBudget.clickOnAddBudgetLineButton(driver, testCaseName);
			PageCreateBudget.fillBusinessUnit(driver, testCaseName, budgetLine.getBusinessUnit());
			PageCreateBudget.fillBudgetLineLocation(driver, testCaseName, budgetLine.getLocation());
			PageCreateBudget.fillBudgetLineCostCenter(driver, testCaseName, budgetLine.getCostCenter());
			PageCreateBudget.selectBudgetLineDepartment(driver, testCaseName, budgetLine.getDepartment());
			PageCreateBudget.selectBudgetLineDesignation(driver, testCaseName, budgetLine.getDesignation());

			PageCreateBudget.fillBudgetLineCode(driver, testCaseName, budgetLine.getBudgetLineCode());
			PageCreateBudget.fillBudgetLineName(driver, testCaseName, budgetLine.getBudgetLineName());
			PageCreateBudget.fillBudgetLineOwner(driver, testCaseName, (budgetLine.getOwner().charAt(0) + ""));
			PageCreateBudget.fillPlannedAmount(driver, testCaseName, budgetLine.getPlannedAmount());
			PageCreateBudget.clickOnSaveBudgetLine(driver, testCaseName);
			//saving budget
			PageCreateBudget.clickOnSaveAndFreezeBudgetButton(driver, testCaseName);

			//search budget			
			EPROC_24325 = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);
			Assert.assertTrue(EPROC_24325, "Owner name autocomplete text box not displaying active users");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :Cost centre autocomplete
	 * text
	 * box should display all the Cost Centres present in selected Business
	 * unit
	 * in Budget Lines on budget creation/updation page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24328(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		BudgetLine budgetLine = null;
		boolean EPROC_24328 = false;
		boolean budgetCreatedFlag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();

			//creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();

			budgetLine = budget.getBudgetLines().get(0);

			//search budget
			budgetCreatedFlag = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);
			Assert.assertTrue(budgetCreatedFlag, "Budget not created");

			//view budget
			FlowBudgetListing.viewBudget(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageCreateBudget.clickOnAddBudgetLineButton(driver, testCaseName);
			PageCreateBudget.fillBusinessUnit(driver, testCaseName, budgetLine.getBusinessUnit());
			PageCreateBudget.fillBudgetLineLocation(driver, testCaseName, budgetLine.getLocation());

			// Checking for autopopulation of cost center
			jsx.executeScript("window.scrollBy(0,850)", "");
			ActionBot.findElement(driver, IPageCreateBudget.TEXTFIELD_COST_CENTER_FROM_BUDGETLINE).click();
			ActionBot.defaultMediumSleep();

			EPROC_24328 = ActionBot.isElementDisplayed(driver, IPageCreateBudget.SELECT_AUTOPOPULATED_COST_CENTER);

			Assert.assertTrue(EPROC_24328, "Cost Center not auto populated");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :Departments autocomplete text box
	 * should display all the Departments present in selected Business unit in Budget Lines on budget creation/updation page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24331(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		BudgetLine budgetLine = null;
		boolean EPROC_24331 = false;
		boolean budgetCreatedFlag = false;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();
			budgetLine = budget.getBudgetLines().get(0);
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();

			//search budget
			budgetCreatedFlag = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);
			Assert.assertTrue(budgetCreatedFlag, "Budget not created");

			//view budget			
			FlowBudgetListing.viewBudget(driver, testCaseName);
			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");

			PageCreateBudget.clickOnAddBudgetLineButton(driver, testCaseName);
			PageCreateBudget.fillBusinessUnit(driver, testCaseName, budgetLine.getBusinessUnit());
			PageCreateBudget.fillBudgetLineLocation(driver, testCaseName, budgetLine.getLocation());
			PageCreateBudget.fillBudgetLineCostCenter(driver, testCaseName, budgetLine.getCostCenter());

			// Checking for autopopulation of cost center
			jsx.executeScript("window.scrollBy(0,850)", "");
			ActionBot.findElement(driver, IPageCreateBudget.TEXTFIELD_DEPARTMENT_FROM_BUDGETLINE).click();
			ActionBot.defaultMediumSleep();

			EPROC_24331 = ActionBot.isElementDisplayed(driver, IPageCreateBudget.SELECT_AUTOPOPULATED_DEPARTMENT);
			Assert.assertTrue(EPROC_24331, "department autocomplete not displaying all depts");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :Designations autocomplete text box
	 * should display all the Designations present in selected Business unit in Budget Lines on budget creation/updation page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24332(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		BudgetLine budgetLine = null;
		boolean EPROC_24332 = false;
		boolean budgetCreatedFlag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();
			budgetLine = budget.getBudgetLines().get(0);
			//creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();

			//search budget
			budgetCreatedFlag = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);
			Assert.assertTrue(budgetCreatedFlag, "Budget not created");

			//view budget
			FlowBudgetListing.viewBudget(driver, testCaseName);
			PageCreateBudget.clickOnAddBudgetLineButton(driver, testCaseName);
			PageCreateBudget.fillBusinessUnit(driver, testCaseName, budgetLine.getBusinessUnit());
			PageCreateBudget.fillBudgetLineLocation(driver, testCaseName, budgetLine.getLocation());
			PageCreateBudget.fillBudgetLineCostCenter(driver, testCaseName, budgetLine.getCostCenter());
			PageCreateBudget.selectBudgetLineDepartment(driver, testCaseName, budgetLine.getDepartment());

			// Checking for autopopulation of cost center
			ActionBot.findElement(driver, IPageCreateBudget.TEXTFIELD_DESIGNATION_FROM_BUDGETLINE).click();

			EPROC_24332 = ActionBot.isElementDisplayed(driver, IPageCreateBudget.SELECT_AUTOPOPULATED_DESIGNATION);

			Assert.assertTrue(EPROC_24332, "designation autocomplete not displaying all depts");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :User should not be able to
	 * create duplicate budget lines codes within the budget on budget
	 * creation/updation page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24339(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		BudgetLine budgetLine = null;
		boolean EPROC_24339 = false;
		boolean budgetCreatedFlag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();

			// creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();

			//search budget
			budgetCreatedFlag = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);
			Assert.assertTrue(budgetCreatedFlag, "Budget not created");

			budgetLine = budget.getBudgetLines().get(0);

			// select first budget
			FlowBudgetListing.viewBudget(driver, testCaseName);

			String budgetLinecode = ActionBot.findElement(driver, IPageCreateBudget.TEXT_BUDGET_LINE_CODE).getText();

			// adding budget line
			PageCreateBudget.clickOnAddBudgetLineButton(driver, testCaseName);
			PageCreateBudget.fillBusinessUnit(driver, testCaseName, budgetLine.getBusinessUnit());
			PageCreateBudget.fillBudgetLineLocation(driver, testCaseName, budgetLine.getLocation());
			PageCreateBudget.fillBudgetLineCostCenter(driver, testCaseName, budgetLine.getCostCenter());
			PageCreateBudget.selectBudgetLineDepartment(driver, testCaseName, budgetLine.getDepartment());

			PageCreateBudget.fillBudgetLineCode(driver, testCaseName, budgetLinecode);
			PageCreateBudget.fillBudgetLineName(driver, testCaseName, budgetLine.getBudgetLineName());
			PageCreateBudget.fillBudgetLineOwner(driver, testCaseName, budgetLine.getOwner());
			PageCreateBudget.fillPlannedAmount(driver, testCaseName, budgetLine.getPlannedAmount());
			ActionBot.defaultMediumSleep();
			// saving budget line
			PageCreateBudget.clickOnSaveBudgetLine(driver, testCaseName);

			ActionBot.defaultMediumSleep();

			EPROC_24339 = (ActionBot.isElementDisplayed(driver, IPageCreateBudget.ALERT_DUPLICATE_BUDGET_LINE)
				|| ActionBot.isElementDisplayed(driver, IPageCreateBudget.ALERT_DUPLICATE_BUDGET_LINE_CODE));
			Assert.assertTrue(EPROC_24339, " Duplicate budget line within same budget...");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (

		AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :Owner name autocomplete text
	 * box should display all the Active users of the tenant while creating
	 * budget lines on budget creation/updation page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24322(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		BudgetLine budgetLine = null;
		boolean EPROC_24322 = false;
		boolean budgetCreatedFlag = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();
			budgetLine = budget.getBudgetLines().get(0);
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();

			//search budget
			budgetCreatedFlag = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);
			Assert.assertTrue(budgetCreatedFlag, "Budget not created");

			//view budget
			FlowBudgetListing.viewBudget(driver, testCaseName);

			//delete budget line
			FlowCreateBudget.deletBudgetLine(driver, testCaseName, budget.getBudgetLines().get(0).getBudgetLineName());

			PageCreateBudget.clickOnAddBudgetLineButton(driver, testCaseName);
			PageCreateBudget.fillBusinessUnit(driver, testCaseName, budgetLine.getBusinessUnit());
			PageCreateBudget.fillBudgetLineLocation(driver, testCaseName, budgetLine.getLocation());
			PageCreateBudget.fillBudgetLineCostCenter(driver, testCaseName, budgetLine.getCostCenter());
			PageCreateBudget.selectBudgetLineDepartment(driver, testCaseName, budgetLine.getDepartment());

			PageCreateBudget.fillBudgetLineCode(driver, testCaseName, budgetLine.getBudgetLineCode());
			PageCreateBudget.fillBudgetLineName(driver, testCaseName, budgetLine.getBudgetLineName());
			PageCreateBudget.fillBudgetLineOwner(driver, testCaseName, budgetLine.getOwner().charAt(0) + "");

			//autopopulated owner name xpath
			EPROC_24322 = ActionBot.isElementDisplayed(driver, IPageCreateBudget.SELECT_AUTOPOPULATED_OWNER_NAME);
			Assert.assertTrue(EPROC_24322, "Owner name autocomplete textbox not displaying Active users ");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :If the Budget dimensions are created with valid sequence, and if the user clicks on 'Change
	 * Sequence button, the budget dimensions fields value Mentioned in expected Result
	 * should be become editable on budget creation page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24286(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		boolean EPROC_24286 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();
			budget.setNextAction(IConstantsData.NONE);
			budget.setAddBudgetLine(false);

			//create budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultSleep();

			PageCreateBudget.clickOnGenerateBudgetDimension(driver, testCaseName);
			ActionBot.findElement(driver, IPageCreateBudget.BUTTON_CHANGE_SEQUENCE).click();
			WebElement deleteButton = ActionBot.findElement(driver, IPageCreateBudget.BUTTON_DELETE_DIMENSION);
			WebElement addButton = ActionBot.findElement(driver, IPageCreateBudget.BUTTON_ADD_DIMENSION);

			boolean addDimension = deleteButton.isDisplayed();
			boolean deleteDimension = addButton.isDisplayed();
			deleteButton.click();
			addButton.click();

			// add budget dimension or delete budget dimension should be present
			// after clicking on change sequence...
			if (addDimension || deleteDimension)
			{
				EPROC_24286 = true;
			}

			Assert.assertTrue(EPROC_24286, "budget dimensions fields value Mentioned in expected Result should be become editable after clicking on chenge sequence...");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :Projects autocomplete text
	 * box should display all the Projects present in selected Business unit
	 * in
	 * Budget Lines on budget creation/updation page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24330(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		BudgetLine budgetLine = null;
		boolean EPROC_24330 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();
			budgetLine = budget.getBudgetLines().get(0);

			BudgetDimension budgetDimension = budget.getBudgetDimension();
			budgetDimension.setProject(true);
			budgetDimension.setLocation(false);
			budgetDimension.setCostCenter(false);
			budgetDimension.setDepartment(false);
			budgetDimension.setDesignation(false);

			budget.setBudgetDimension(budgetDimension);
			budget.setNextAction(IConstantsData.NONE);
			budget.setAddBudgetLine(false);
			//creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			PageCreateBudget.clickOnGenerateBudgetDimension(driver, testCaseName);

			//adding budget line
			PageCreateBudget.clickOnAddBudgetLineButton(driver, testCaseName);
			PageCreateBudget.fillBusinessUnit(driver, testCaseName, budgetLine.getBusinessUnit());
			ActionBot.fillAutoCompleteField(driver, IPageCreateBudget.TEXTFIELD_PROJECT_FROM_BUDGETLINE, IConstantsData.DELIVERY_NAME2);
			PageCreateBudget.fillBudgetLineCode(driver, testCaseName, budgetLine.getBudgetLineCode());
			PageCreateBudget.fillBudgetLineName(driver, testCaseName, budgetLine.getBudgetLineName());
			PageCreateBudget.fillBudgetLineOwner(driver, testCaseName, budgetLine.getOwner());
			PageCreateBudget.fillPlannedAmount(driver, testCaseName, budgetLine.getPlannedAmount());
			ActionBot.defaultMediumSleep();
			// saving budget line
			PageCreateBudget.clickOnSaveBudgetLine(driver, testCaseName);
			// saving budget
			PageCreateBudget.clickOnSaveAndFreezeBudgetButton(driver, testCaseName);
			EPROC_24330 = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);
			Assert.assertTrue(EPROC_24330, "Unable to search budget");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :Category autocomplete text box
	 * should display all the Categories present in selected Business unit in Budget Lines on budget creation/updation page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24333(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		BudgetLine budgetLine = null;
		boolean EPROC_24333 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();
			budgetLine = budget.getBudgetLines().get(0);

			BudgetDimension budgetDimension = budget.getBudgetDimension();

			budgetDimension.setCategory(true);
			budgetDimension.setLocation(false);
			budgetDimension.setCostCenter(false);
			budgetDimension.setDepartment(false);
			budgetDimension.setDesignation(false);
			budget.setBudgetDimension(budgetDimension);
			budget.setNextAction(IConstantsData.NONE);
			budget.setAddBudgetLine(false);
			//creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			ActionBot.defaultMediumSleep();
			PageCreateBudget.clickOnGenerateBudgetDimension(driver, testCaseName);
			//adding budget ;ine
			PageCreateBudget.clickOnAddBudgetLineButton(driver, testCaseName);
			PageCreateBudget.fillBusinessUnit(driver, testCaseName, budgetLine.getBusinessUnit());
			ActionBot.fillAutoCompleteField(driver, IPageCreateBudget.TEXTFIELD_PROJECT_FROM_BUDGETLINE, IConstantsData.DELIVERY_NAME2);
			PageCreateBudget.fillBudgetLineCode(driver, testCaseName, budgetLine.getBudgetLineCode());
			PageCreateBudget.fillBudgetLineName(driver, testCaseName, budgetLine.getBudgetLineName());
			PageCreateBudget.fillBudgetLineOwner(driver, testCaseName, budgetLine.getOwner());
			PageCreateBudget.fillPlannedAmount(driver, testCaseName, budgetLine.getPlannedAmount());
			ActionBot.defaultMediumSleep();
			// saving budget line
			PageCreateBudget.clickOnSaveBudgetLine(driver, testCaseName);
			// saving budget
			PageCreateBudget.clickOnSaveAndFreezeBudgetButton(driver, testCaseName);
			EPROC_24333 = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);
			Assert.assertTrue(EPROC_24333, "Unable to search budget");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :Budget lines with * dimension values:
	 * Location should be displayed to all active Locations in tenant on checkout page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24341(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		BudgetLine budgetLine = null;
		boolean EPROC_24341 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();
			budgetLine = budget.getBudgetLines().get(0);
			//creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);

			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			OnlineStore onlineStore = ObjectCreation.searchItem();

			// adding item and checkout
			FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlineStore);
			PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
			ActionBot.findElement(driver, IModelRequisitionSummaryBilling.BILLING_LOCATION).clear();
			String autoCompleteLocation = ActionBot.fillAutoCompleteField(driver, IModelRequisitionSummaryBilling.BILLING_LOCATION, IConstantsData.DELIVERY_NAME2);
			PageRequisitionCheckOut.clickCostAllocation(driver, testCaseName);
			ActionBot.findElement(driver, IModelRequisitionSummaryCostBookingImpl.COSTBOOKING_SINGLE_BUDGET).clear();
			ActionBot.fillAutoCompleteField(driver, IModelRequisitionSummaryCostBookingImpl.COSTBOOKING_SINGLE_BUDGET, IConstantsData.DELIVERY_NAME2);
			//save requisition summary
			PageRequisitionCheckOut.clickSaveRequisitionSummary(driver, testCaseName);
			EPROC_24341 = autoCompleteLocation.contains(IConstantsData.DELIVERY_NAME2);
			Assert.assertTrue(EPROC_24341, "Location not displaying to all active Locations");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :Budget lines with * dimension
	 * values:Project Unit should be displayed to all active Projects in tenant on checkout page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24342(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		BudgetLine budgetLine = null;
		boolean EPROC_24342 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();
			budgetLine = budget.getBudgetLines().get(0);
			//creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);

			// navigates to TMS
			driver.get(ConfigProperty.getConfig("TMS_URL"));
			ActionBot.waitForPageLoad(driver);
			ScreenShot.screenshot(driver, testCaseName, "After navigating to TMS Page");
			//Master Data tab
			MainPageHeaderLevelTab.clickOnTMSMasterDataTab(driver, testCaseName);
			//Customize tab
			MainPageHeaderLevelTab.clickOnTMSCustomizeSubTab(driver, testCaseName);
			//Cost booking link
			PageCustomizeSettings.clickOnCostBookingLink(driver, testCaseName);
			PageProjectsSettings.clickOnLetUsersDecide(driver);
			//save setting
			PageProjectsSettings.clickOnSave(driver);

			// navigates to EPROC
			driver.get(ConfigProperty.getConfig("Product_URL"));
			ActionBot.waitForPageLoad(driver);

			ScreenShot.screenshot(driver, testCaseName, "After navigating to EPROC Page");
			ActionBot.defaultSleep();
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			OnlineStore onlineStore = ObjectCreation.searchItem();

			// adding item and checkout
			FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlineStore);
			PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);

			PageRequisitionCheckOut.clickCostAllocation(driver, testCaseName);

			ModelRequisitionSummaryCostBooking.clickYesAssignToPurchaseCost(driver, testCaseName);

			String autoCompleteProject = ActionBot.fillAutoCompleteField(driver, IModelRequisitionSummaryCostBookingImpl.COSTBOOKING_SINGLE_PROJECT, IConstantsData.DELIVERY_NAME2);

			ActionBot.fillAutoCompleteField(driver, IModelRequisitionSummaryCostBookingImpl.COSTBOOKING_SINGLE_BUDGET, IConstantsData.DELIVERY_NAME2);
			//save requisition summary
			PageRequisitionCheckOut.clickSaveRequisitionSummary(driver, testCaseName);
			EPROC_24342 = autoCompleteProject.contains(IConstantsData.DELIVERY_NAME2);
			Assert.assertTrue(EPROC_24342, "Location not displaying to all active Locations");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :Budget lines with * dimension values: Cost center should be
	 * displayed to all active Cost centers in tenant on checkout page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24345(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		BudgetLine budgetLine = null;
		boolean EPROC_24345 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();
			budgetLine = budget.getBudgetLines().get(0);
			//creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);

			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			OnlineStore onlineStore = ObjectCreation.searchItem();

			// adding item and checkout
			FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlineStore);
			PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);

			PageRequisitionCheckOut.clickCostAllocation(driver, testCaseName);

			String autoCompleteCostCenter = ActionBot.fillAutoCompleteField(driver, IModelRequisitionSummaryCostBooking.COSTBOOKING_SINGLE_CC, IConstantsData.DELIVERY_NAME2);

			EPROC_24345 = autoCompleteCostCenter.contains(IConstantsData.DELIVERY_NAME2);
			Assert.assertTrue(EPROC_24345, "Cost center not displaying to all cost center");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :Budget lines with * dimension values: GL account
	 * should be displayed to all active GL Accounts in tenant on checkout page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24344(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		BudgetLine budgetLine = null;
		boolean EPROC_24344 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();
			budgetLine = budget.getBudgetLines().get(0);

			//creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			FlowOnlineStore.clearCart(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			OnlineStore onlineStore = ObjectCreation.searchItem();

			// adding item and checkout
			onlineStore = FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlineStore);

			JavascriptExecutor jsx = (JavascriptExecutor) driver;
			jsx.executeScript("window.scrollBy(0,850)", "");
			PageRequisitionCheckOut.clickExpandAll(driver, testCaseName);
			PageRequisitionCheckOut.clickOnCostBookingItemEdit(driver, testCaseName);

			ActionBot.defaultSleep();

			String autoCompleteGlAccount = ActionBot.fillAutoCompleteField(driver, IPageRequisitionCheckOut.TEXTBOX_ITEM_DETAILS_GL_ACCOUNT, IConstantsData.DELIVERY_NAME2);
			EPROC_24344 = autoCompleteGlAccount.contains(IConstantsData.DELIVERY_NAME2);
			Assert.assertTrue(EPROC_24344, "Cost center not displaying to all cost center");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :User should not be allowed to
	 * add budget lines for closed budget.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24375(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		BudgetLine budgetLine = null;
		boolean EPROC_24375 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();
			budgetLine = budget.getBudgetLines().get(0);

			MainPageHeaderLevelTab.clickOnBudgetTab(driver, testCaseName);
			String status = PageBudgetListing.getStatusOfFirstBudget(driver, testCaseName);

			if (status.equalsIgnoreCase(IConstantsData.CLOSED))
			{
				PageBudgetListing.clickOnFirstBudget(driver, testCaseName);
			}

			else
			{

				FlowBudgetListing.viewFirstClosedBudget(driver, testCaseName, budget);
			}

			EPROC_24375 = ActionBot.isElementDisplayed(driver, IPageCreateBudget.BUTTON_ADD_BUDGET_LINE);
			Assert.assertTrue(EPROC_24375, "Budget line should not be for closed budget");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :If de-activated/closed budget is viewed,
	 * no fields are editable on budget View page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24376(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		BudgetLine budgetLine = null;
		boolean EPROC_24376 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();
			budgetLine = budget.getBudgetLines().get(0);

			MainPageHeaderLevelTab.clickOnBudgetTab(driver, testCaseName);
			//getting status of budget
			String status = PageBudgetListing.getStatusOfFirstBudget(driver, testCaseName);

			if (status.equalsIgnoreCase(IConstantsData.CLOSED))
			{
				PageBudgetListing.clickOnFirstBudget(driver, testCaseName);
			}
			else
			{
				FlowBudgetListing.viewFirstClosedBudget(driver, testCaseName, budget);
			}

			EPROC_24376 = (!ActionBot.isElementDisplayed(driver, IPageCreateBudget.BUTTON_ADD_BUDGET_LINE)
				& !ActionBot.isElementDisplayed(driver, IPageCreateBudget.CHECKBOX_OF_FIRST_BUDGET_LINE)
				& !ActionBot.isElementDisplayed(driver, IPageCreateBudget.LINK_AUTO_GENERATE_COMBINATIONS));
			Assert.assertTrue(EPROC_24376, "No field should be editable");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :Budget should get closed if its validity is
	 * expired on budget listing page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24359(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		BudgetLine budgetLine = null;
		boolean EPROC_24376 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();
			budgetLine = budget.getBudgetLines().get(0);

			MainPageHeaderLevelTab.clickOnBudgetTab(driver, testCaseName);
			//getting status of budget
			String status = PageBudgetListing.getStatusOfFirstBudget(driver, testCaseName);

			if (status.equalsIgnoreCase(IConstantsData.CLOSED))
			{
				PageBudgetListing.clickOnFirstBudget(driver, testCaseName);
			}
			else
			{
				FlowBudgetListing.viewFirstClosedBudget(driver, testCaseName, budget);
			}

			String toDate = PageCreateBudget.getToBudgetDateOnBudgetViewPage(driver, testCaseName);
			Date date = new Date();
			String today = new SimpleDateFormat("dd/MM/yyyy").format(date);

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			EPROC_24376 = sdf.parse(toDate).before(sdf.parse(today));
			Assert.assertTrue(EPROC_24376, "Validity not expired for closed budget");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :If the setting
	 * "Allow budget utilization" is set to 'NO' in Setup>> Customize>> Cost
	 * booking , Allow budget utilization settingshould not be visible in 'Cost
	 * allocation tab' on checkout page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24349(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		boolean EPROC_24349 = false;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();

			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);

			//allow budget utilization no
			MainPageHeaderLevelTab.clickOnSetupAndCustomize(driver, testCaseName);
			PageCustomizeSettings.clickOnCostBookingLink(driver, testCaseName);
			PageBudgetSettings.clickOnAllowBudgetUtilizationNO(driver, testCaseName);
			//save setting
			PageCustomizeSettings.clickOnSaveButtom(driver, testCaseName);

			// to checkout
			OnlineStore onlineStore = ObjectCreation.searchItem();
			// adding item and checkout
			FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlineStore);

			PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
			PageRequisitionCheckOut.clickCostAllocation(driver, testCaseName);

			if (!ActionBot.isElementPresent(driver, IModelRequisitionSummaryCostBookingImpl.COSTBOOKING_SINGLE_BUDGET))
			{
				EPROC_24349 = true;
			}

			Assert.assertTrue(EPROC_24349, " Allow budget utilization setting should be set default to YES");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :If the setting "Allow budget utilization" is set
	 * to 'Let users decide' in Setup>> Customize>> Cost booking , Allow budget utilization setting should be visible
	 * & editable with both options(Yes/No) to user 'Cost allocation tab' on checkout page.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24350(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		boolean EPROC_24350 = false;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();

			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);

			//allow budget utilization let user decide
			MainPageHeaderLevelTab.clickOnSetupAndCustomize(driver, testCaseName);
			PageCustomizeSettings.clickOnCostBookingLink(driver, testCaseName);
			PageBudgetSettings.clickOnAllowBudgetUtilizationLetUserDecide(driver, testCaseName);
			ActionBot.findElement(driver, IPageBudgetSettings.ALLOW_BUDGET_UTILIZATION_LET_USER_DECIDE).click();
			//save setting
			PageCustomizeSettings.clickOnSaveButtom(driver, testCaseName);

			// to checkout
			OnlineStore onlineStore = ObjectCreation.searchItem();
			// adding item and checkout
			FlowOnlineStore.addSingleItemAndCheckout(driver, testCaseName, onlineStore);

			PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
			PageRequisitionCheckOut.clickCostAllocation(driver, testCaseName);

			if (ModelRequisitionSummaryCostBooking.isYesAllowBudgetUtilization(driver, testCaseName)
				& ModelRequisitionSummaryCostBooking.isNoAllowBudgetUtilization(driver, testCaseName))
			{
				EPROC_24350 = true;
			}

			Assert.assertTrue(EPROC_24350, " Allow budget utilization setting should be visible & editable with both options(Yes/No)");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);

		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :User should not
	 * be allowed to create budget with de-activated budget names.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24354(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget1 = null;
		Budget budget2 = null;
		boolean EPROC_24354 = false;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget1 = ObjectCreation.getDefaultObjectOfBudget();
			budget2 = ObjectCreation.getDefaultObjectOfBudget();

			budget1 = FlowCreateBudget.createBudget(driver, testCaseName, budget1);

			FlowBudgetListing.deactivateBudget(driver, testCaseName, budget1);
			budget2.setBudgetName(budget1.getBudgetName());
			budget2 = FlowCreateBudget.createBudget(driver, testCaseName, budget2);
			EPROC_24354 = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget2);
			Assert.assertTrue(EPROC_24354, "Unable to search budget");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :On editing 'In Use' budgets,
	 * User should be able to add or delete the budget lines.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24356(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		BudgetLine budgetLine = null;
		boolean EPROC_24356 = false;

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();
			budgetLine = budget.getBudgetLines().get(0);
			// creating budget
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			// select budget
			PageBudgetListing.clickOnFirstBudget(driver, testCaseName);

			boolean deleteBudgetLine = FlowCreateBudget.deletBudgetLine(driver, testCaseName, budget.getBudgetLines().get(0).getBudgetLineName());
			Assert.assertTrue(deleteBudgetLine, "Unable to delete budget line");
			FlowCreateBudget.addBudgetLine(driver, testCaseName, budgetLine);
			FlowCreateBudget.saveAndFreezeBudget(driver, testCaseName);
			EPROC_24356 = FlowBudgetListing.searchBudget(driver, testCaseName, IConstantsData.SEARCH_BUDGET_BY_BUDGET_NAME, budget);
			Assert.assertTrue(EPROC_24356, "Unable to search budget");
			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :User should get the
	 * confirmation message mentioned in expected result, when user clicks on
	 * auto-generate combinations after adding budget lines code.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24407(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		BudgetLine budgetLine = null;
		boolean a, b, EPROC_24407 = false;
		int countDimesions = 0;
		boolean sequence = true;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();
			budgetLine = budget.getBudgetLines().get(0);

			//	MainPageHeaderLevelTab.clickOnBudgetTab(driver, testCaseName);
			budget = FlowCreateBudget.createBudget(driver, testCaseName, budget);
			FlowBudgetListing.viewBudget(driver, testCaseName);
			PageCreateBudget.clickOnAddBudgetLineButton(driver, testCaseName);
			ActionBot.defaultMediumSleep();
			PageCreateBudget.clickOnAutoGenerateCombinations(driver, testCaseName);
			boolean isConfirmationMsgDisplayed = ActionBot.isElementPresent(driver, IPageCreateBudget.ALERT_CONFIRM_AUTOGENERATE);
			if (isConfirmationMsgDisplayed)
			{
				EPROC_24407 = true;
			}
			org.testng.Assert.assertTrue(EPROC_24407, " Confirmation msg not displayed..!!");

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (

		AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

	/**
	 * <b>Author: dnyanesh.joshi </b> Description :If the user clicks on
	 * Review
	 * of Confirmation message, user should be able to review the Budget lines
	 * code.
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_24408(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		Budget budget = null;
		BudgetLine budgetLine = null;
		boolean a, b, EPROC_24408 = false;
		int countDimesions = 0;
		boolean sequence = true;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			budget = ObjectCreation.getDefaultObjectOfBudget();
			budgetLine = ObjectCreation.getDefaultObjetOfBudgetLine();

			MainPageHeaderLevelTab.clickOnBudgetTab(driver, testCaseName);
			FlowBudgetListing.viewBudget(driver, testCaseName);
			PageCreateBudget.clickOnAddBudgetLineButton(driver, testCaseName);
			PageCreateBudget.clickOnAutoGenerateCombinations(driver, testCaseName);

			ActionBot.findElement(driver, IPageCreateBudget.ALERT_REVIEW_LINE).click();

			EPROC_24408 = ActionBot.isElementDisplayed(driver, IPageCreateBudget.CHECKBOX_OF_FIRST_BUDGET_LINE);

			CommonServices.successfulExecutionOfTestCase(driver, testCase);
		}
		catch (

		AssertionError e)
		{
			CommonServices.assertionMethod(driver, testCase, user, e);
		}
		catch (Exception e)
		{
			CommonServices.exceptionMethod(driver, testCase, user, e);
		}
		finally
		{
			CommonServices.afterExecutionOfTestcase(driver, testCase, map, user, mappedTestCases);
		}
	}

}
