package com.zycus.automation.eproc.testcase.regression.requisition;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.zycus.automation.bo.Basket;
import com.zycus.automation.bo.MappedTestCase;
import com.zycus.automation.bo.OnlineStore;
import com.zycus.automation.bo.User;
import com.zycus.automation.boutils.MappedTestCaseUtil;
import com.zycus.automation.datacreation.ObjectCreation;
import com.zycus.automation.eproc.businessflow.mybasketflow.FlowMyBasket;
import com.zycus.automation.eproc.businessflow.onlinestoreflow.FlowOnlineStore;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.services.LoginLogoutServices;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.framework.DriverSelector;
import com.zycus.framework.framework_version_2_4.framework.TestDataProvider;

/**
 * @author kunal.ashar
 * 
 */

public class SearchItemTestCase extends TestDataProvider
{

	static Logger logger = Logger.getLogger(SearchItemTestCase.class);

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>User should be able to search items,
	 * specify quantity and add them to newly created basket having multilingual
	 * name.<br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_13766(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		// String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = null;
		int index = 0; // index of item to be operated. 0 will select first item
						// from list.
		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			String testCaseName = testCase.getTestMethodName();
			{
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_13002"));
				mappedTestCases.add(MappedTestCaseUtil.findMappedTestCase("RTC_13758"));
			}
			CommonServices.startTestCase(driver, testCase, mappedTestCases);

			String itemId;
			int itemQuantity;

			// Searching for item
			OnlineStore onlinestore = ObjectCreation.searchItem();
			onlinestore = FlowOnlineStore.searchItem(driver, testCaseName, onlinestore);
			onlinestore = FlowOnlineStore.getItemId(driver, testCaseName, index, onlinestore);

			itemId = onlinestore.getItemId();
			itemQuantity = onlinestore.getQuantity();

			// filling item quantity
			onlinestore = FlowOnlineStore.fillItemQuantity(driver, testCaseName, itemId, itemQuantity, onlinestore);

			// adding item to cart
			onlinestore = FlowOnlineStore.clickAddToCart(driver, testCaseName, itemId, onlinestore);

			//Popup For Confirmation
			if (PopUpDefaultConfirmation.isConfirmYesButtonPresent(driver, testCaseName))
			{
				PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			}

			// viewing cart
			onlinestore = FlowOnlineStore.clickOnViewCart(driver, testCaseName, onlinestore);

			// saving cart as Basket
			onlinestore = FlowOnlineStore.saveCartAsBasket(driver, testCaseName, onlinestore);

			// Creating new basket with Multilingual Name
			Basket basket = ObjectCreation.createBasket();
			basket = FlowMyBasket.createNewBasket(driver, testCaseName, basket);

			boolean flag = basket.equals(basket);
			Assert.assertTrue(flag);
			mappedTestCases.get(0).setTestResult(flag);
			mappedTestCases.get(1).setTestResult(flag);
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
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>User should be able to search items and
	 * click on Item to see product details pop-up<br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	@Test(dataProvider = "dataProvider")
	public void RTC_13779(TestCase testCase) throws Exception
	{
		WebDriver driver = DriverSelector.getDriver(testCase);
		// String testCaseName = testCase.getDescription();
		Map<String, String> map = new HashMap<String, String>();
		CommonServices.startTestCase(driver, testCase);
		User user = null;
		boolean flag = false;
		int index = 0; // index of item to be operated. 0 will select first item
						// from list.

		try
		{
			user = LoginLogoutServices.login(driver, testCase);
			String testCaseName = testCase.getTestMethodName();
			String itemId, itemTitleInPopup;
			String searchItem;

			// Searching for item
			OnlineStore onlinestore = ObjectCreation.searchItem();
			onlinestore = FlowOnlineStore.searchItem(driver, testCaseName, onlinestore);
			onlinestore = FlowOnlineStore.getItemId(driver, testCaseName, index, onlinestore);

			itemId = onlinestore.getItemId();

			// click on Item to view product details
			onlinestore = FlowOnlineStore.clickOnItemName(driver, testCaseName, itemId, onlinestore);

			onlinestore = FlowOnlineStore.getItemTitleInPopup(driver, testCaseName, onlinestore);

			itemTitleInPopup = onlinestore.getItemTitleInPopup();
			searchItem = onlinestore.getSearchItem();

			// locator to be checked for closing pop-up
			onlinestore = FlowOnlineStore.closeItemPopup(driver, testCaseName, onlinestore);

			flag = itemTitleInPopup.equalsIgnoreCase(searchItem);

			assertTrue("Product details pop-up displayed on page", flag);
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

}
