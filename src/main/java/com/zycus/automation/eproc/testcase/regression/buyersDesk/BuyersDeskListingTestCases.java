package com.zycus.automation.eproc.testcase.regression.buyersDesk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.zycus.automation.bo.MappedTestCase;
import com.zycus.automation.bo.User;
import com.zycus.automation.eproc.pageobjects.pages.buyersdesklisting.PageBuyersDeskListing;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.services.LoginLogoutServices;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.framework.DriverSelector;
import com.zycus.framework.framework_version_2_4.framework.TestDataProvider;

/**
 * 
 * @author t.amarnath
 *         T Amarnath-Cases Start
 */
public class BuyersDeskListingTestCases extends TestDataProvider
{
	static Logger logger = Logger.getLogger(BuyersDeskListingTestCases.class);

	@Test(dataProvider = "dataProvider")
	public void EPROC_20895(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		boolean EPROC_20895 = false;
		List<String> expectedColumnNames = new ArrayList<String>() {
			{
				add(IConstantsData.Requisition_Status);
				add(IConstantsData.Requisition_No);
				add(IConstantsData.Requisition_Name);
				add(IConstantsData.Requisition_Requester);
				add(IConstantsData.Received_on);
				add(IConstantsData.Assigned_buyer);
				add(IConstantsData.Purchase_Amount);
				add(IConstantsData.Actions);
			}
		};
		try
		{
			//Login to eproc
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Go to buyers desk listing
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);

			//Get all the column names and verify
			List<String> columnNamesPresentOnPage = PageBuyersDeskListing.getBuyersDeskListingTableColumnNames(driver, testCaseName);
			EPROC_20895 = columnNamesPresentOnPage.containsAll(expectedColumnNames);
			Assert.assertTrue(EPROC_20895, "Some column names are not present");
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
	 * <b>Author: t.amarnath </b> <b>Created On : 28-Dec-2017 </b> <b>Method :
	 * EPROC_20897 <b>Description : Buyer's Desk Listing>Verify that by default,
	 * the list should be sorted by descending order of "Received On"
	 * 
	 * 
	 * </font><b><br>
	 * 
	 * @param testCase {@link String}
	 *        </font><b><br>
	 * @throws Exception @{@link Exception}
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_20897(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		boolean EPROC_20897 = false;
		try
		{
			//Login to eproc
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);
			//go to buyers desk listing page
			MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
			//get the sorting status of recieved on and check whether it is descending
			EPROC_20897 = PageBuyersDeskListing.getRecievedOnSortingStatus(driver, testCaseName).equalsIgnoreCase("descending");
			Assert.assertTrue(EPROC_20897, "Not sorted by descending order");
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
}
