package com.zycus.automation.eproc.testcase.regression.pcard;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.zycus.automation.bo.ApprovalAllRequests;
import com.zycus.automation.bo.GuidedItem;
import com.zycus.automation.bo.Item;
import com.zycus.automation.bo.MappedTestCase;
import com.zycus.automation.bo.PCard;
import com.zycus.automation.bo.PurchaseOrder;
import com.zycus.automation.bo.Requisition;
import com.zycus.automation.bo.User;
import com.zycus.automation.boutilshelper.UserUtilHelper;
import com.zycus.automation.datacreation.ObjectCreation;
import com.zycus.automation.eproc.businessflow.allrequestsapprovalflow.FlowAllRequestsApproval;
import com.zycus.automation.eproc.businessflow.buyersdesk.FlowBuyersDesk;
import com.zycus.automation.eproc.businessflow.buyersdesklistingflow.FlowBuyersDeskListing;
import com.zycus.automation.eproc.businessflow.combineflow.CombineFlowImpl;
import com.zycus.automation.eproc.businessflow.createpcardflow.FlowCreatePCard;
import com.zycus.automation.eproc.businessflow.myrequisitionsflow.FlowMyRequisitions;
import com.zycus.automation.eproc.businessflow.pcardlistingflow.FlowPCardListing;
import com.zycus.automation.eproc.businessflow.polistingflow.FlowPoListing;
import com.zycus.automation.eproc.businessflow.requisitionflow.FlowRequisition;
import com.zycus.automation.eproc.businessflow.searchlistingpageflow.FlowSearchListing;
import com.zycus.automation.eproc.pageobjects.modals.pcardactions.ModalPCardListingActions;
import com.zycus.automation.eproc.pageobjects.modals.polistingactions.ModalPOListingActions;
import com.zycus.automation.eproc.pageobjects.modals.shoppingcart.ModalShoppingCart;
import com.zycus.automation.eproc.pageobjects.modals.viewpoactions.ModalViewPOActions;
import com.zycus.automation.eproc.pageobjects.pages.BuyersDesk.PageBuyersDesk;
import com.zycus.automation.eproc.pageobjects.pages.createpcard.PageCreatePCard;
import com.zycus.automation.eproc.pageobjects.pages.onlinestore.PageOnlineStore;
import com.zycus.automation.eproc.pageobjects.pages.pcardlisting.PagePCardListing;
import com.zycus.automation.eproc.pageobjects.pages.po.PagePO;
import com.zycus.automation.eproc.pageobjects.pages.purchaseorderlisting.PagePurchaseOrderListing;
import com.zycus.automation.eproc.pageobjects.pages.requisitionCheckOut.PageRequisitionCheckOut;
import com.zycus.automation.eproc.pageobjects.pages.searchlisting.IPageSearchListingImpl;
import com.zycus.automation.eproc.pageobjects.pages.searchlisting.PageSearchListing;
import com.zycus.automation.eproc.pageobjects.pages.standardpo.PageStandardPO;
import com.zycus.automation.eproc.pageobjects.pages.viewpurchaseorder.PageViewPurchaseOrder;
import com.zycus.automation.eproc.pageobjects.popups.confirmationPopUp.PopUpConfirmation;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.eproc.validation.VerifyShoppingItemsWithShoppingCarts;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.services.LoginLogoutServices;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.common.CommonUtilities;
import com.zycus.automation.utilities.utilitieshelpers.RandomCreditCardNumberGenerator;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.framework.DriverSelector;
import com.zycus.framework.framework_version_2_4.framework.TestDataProvider;
import com.zycus.zsn.automation.scripts.businessFlow.PurchaseOrdersFlow.FlowPurchaseOrder;
import com.zycus.zsn.automation.scripts.pageObjects.modal.ModalConfirmPO;

/**
 * @author Sanjay.kundu
 * 
 */

public class PCardTestCases extends TestDataProvider
{
	static Logger logger = Logger.getLogger(PCardTestCases.class);

	/**
	 * <b>@author omkar.jagdale</b> <b><br>
	 * <font color="blue">Method :</b>Check creating a supplier Pcard and activate it<br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_21158(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = new User();
		PCard pCard = new PCard();
		boolean flag;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			pCard = ObjectCreation.getDefaultObjectOfPCard(IConstantsData.ISSUED_TO_SUPPLIER);
			pCard.setpCardNo(RandomCreditCardNumberGenerator.getCreditCardNumber(1, IConstantsData.PCARD_TYPE_MASTER_CARD)[0]);
			pCard = FlowCreatePCard.createPCard(driver, testCaseName, pCard);

			flag = FlowPCardListing.searchPCard(driver, testCaseName, null, pCard.getpCardNo());
			Assert.assertTrue(flag, "Pcard is not generated");
			//Deactivate Pcard so we can create pCard with same supplier
			flag = FlowPCardListing.deactivatePCard(driver, testCaseName, pCard.getpCardNo());
			Assert.assertTrue(flag, "Pcard with supplier " + pCard.getIssuedTo() + " is not deactivated created by user " + user.getUsername());
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
	 * <b>@author omkar.jagdale</b> <b><br>
	 * <font color="blue">Method :</b>Check creating a user Pcard and activate it.<br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_21159(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = new User();
		PCard pCard = new PCard();
		boolean flag;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			pCard = ObjectCreation.getDefaultObjectOfPCard(IConstantsData.ISSUED_TO_USER);
			pCard.setpCardNo(RandomCreditCardNumberGenerator.getCreditCardNumber(1, IConstantsData.PCARD_TYPE_VISA)[0]);
			pCard = FlowCreatePCard.createPCard(driver, testCaseName, pCard);

			flag = FlowPCardListing.searchPCard(driver, testCaseName, null, pCard.getpCardNo());
			Assert.assertTrue(flag, "Pcard is not generated");
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
	 * <b>@author omkar.jagdale</b> <b><br>
	 * <font color="blue">Method :</b>Verify that Deactivated and Archived Pcards can be changed to Activate status.<br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_21160(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = new User();
		PCard pCard = new PCard();
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//creating a new pcard
			pCard = ObjectCreation.getDefaultObjectOfPCard(IConstantsData.ISSUED_TO_USER);
			pCard.setpCardNo(RandomCreditCardNumberGenerator.getCreditCardNumber(1, IConstantsData.PCARD_TYPE_AMEX)[0]);
			pCard = FlowCreatePCard.createPCard(driver, testCaseName, pCard);

			if (!FlowPCardListing.searchPCard(driver, testCaseName, null, pCard.getpCardNo()))
				CommonServices.assertionMethod(driver, testCase, user, null);

			//deactivating it
			FlowPCardListing.deactivatePCard(driver, testCaseName, pCard.getpCardNo());
			FlowPCardListing.activatePCard(driver, testCaseName, pCard.getpCardNo());

			FlowPCardListing.deactivatePCard(driver, testCaseName, pCard.getpCardNo());
			FlowPCardListing.archivePCard(driver, testCaseName, pCard.getpCardNo());
			boolean flag = FlowPCardListing.searchArchivedPCard(driver, testCaseName, null, pCard.getpCardNo());
			Assert.assertTrue(flag, "Pcard is not in archieved state");
			flag = FlowPCardListing.activatePCard(driver, testCaseName, pCard.getpCardNo());

			Assert.assertTrue(flag, "Pcard is not in activated state");

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
	 * <b>@author omkar.jagdale</b> <b><br>
	 * <font color="blue">Method :</b>Card number should be unique for a particular card type.<br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_21177(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = new User();
		PCard pCard = new PCard();
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//creatinng a new pcard
			pCard = ObjectCreation.getDefaultObjectOfPCard(IConstantsData.ISSUED_TO_USER);
			pCard.setpCardNo(RandomCreditCardNumberGenerator.getCreditCardNumber(1, IConstantsData.PCARD_TYPE_AMEX)[0]);
			pCard = FlowCreatePCard.createPCard(driver, testCaseName, pCard);
			boolean flag = FlowCreatePCard.createPCardWithError(driver, testCaseName, pCard);
			if (flag)
			{
				flag = PageCreatePCard.getCardNoError(driver, testCaseName).toLowerCase().contains(IConstantsData.ERROR_PCARD_NO_ALL_READY_USED.toLowerCase());
				Assert.assertTrue(flag, IConstantsData.ERROR_PCARD_NO_ALL_READY_USED + " this error message is not getting");
			}
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
	 * <b>@author omkar.jagdale</b> <b><br>
	 * <font color="blue">Method :</b>Verify that user should be able to perform actions for Pcards only created by themselves.<br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_21175(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = new User();
		PCard pCard = new PCard();
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//creatinng a new pcard
			pCard = ObjectCreation.getDefaultObjectOfPCard(IConstantsData.ISSUED_TO_USER);
			pCard.setpCardNo(RandomCreditCardNumberGenerator.getCreditCardNumber(1, IConstantsData.PCARD_TYPE_AMEX)[0]);
			pCard = FlowCreatePCard.createPCard(driver, testCaseName, pCard);

			User user2 = UserUtilHelper.getAvailableUserFromList();
			logger.info("New User is : " + user2);
			ActionBot.defaultMediumSleep();

			// log out
			LoginLogoutServices.logout(driver, testCase, user);
			LoginLogoutServices.afterLogout(driver, testCase, user);

			// login with other user
			LoginLogoutServices.login(driver, testCase, user2);
			ActionBot.defaultSleep();

			//searching the pcard
			boolean flag = FlowPCardListing.searchPCard(driver, testCaseName, null, pCard.getpCardNo());
			if (flag)
			{
				flag = PagePCardListing.isActionButtonDisplayed(driver, testCaseName);
				Assert.assertTrue(!flag, "Other user can perform the action on Pcard");

			}
			else
			{
				logger.assertLog(true, "Pcard Not Found");
			}
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
	 * <b>@author omkar.jagdale</b> <b><br>
	 * <font color="blue">Method :</b>While creating user Pcard,daily transactions should not accept numbers exceeding transactions per cycle.<br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_21185(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = new User();
		PCard pCard = new PCard();
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//creatinng a new pcard
			pCard = ObjectCreation.getDefaultObjectOfPCard(IConstantsData.ISSUED_TO_USER);
			pCard.setpCardNo(RandomCreditCardNumberGenerator.getCreditCardNumber(1, IConstantsData.PCARD_TYPE_MASTER_CARD)[0]);
			//setting transactionpercycle less than transactionperday 
			pCard.setTransactionsPerCycle(pCard.getTransactionsPerDay() - 1);

			boolean flag = FlowCreatePCard.createPCardWithError(driver, testCaseName, pCard);

			//checking if pcard is created or not
			if (flag)
			{
				flag = PageCreatePCard.getUserLimitError(driver, testCaseName).toLowerCase().contains(IConstantsData.ERROR_PCARD_DAILY_TRANSACTION);
				Assert.assertTrue(flag, IConstantsData.ERROR_PCARD_DAILY_TRANSACTION + " this error message is not getting");
			}
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
	 * <b>@author omkar.jagdale</b> <b><br>
	 * <font color="blue">Method :</b>While creating user Pcard,daily amount should not be less than amount per use.<br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_21186(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = new User();
		PCard pCard = new PCard();
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//creatinng a new pcard
			pCard = ObjectCreation.getDefaultObjectOfPCard(IConstantsData.ISSUED_TO_USER);
			pCard.setpCardNo(RandomCreditCardNumberGenerator.getCreditCardNumber(1, IConstantsData.PCARD_TYPE_MASTER_CARD)[0]);
			//setting dailyamount less than amount per use
			pCard.setSpendPerDay(pCard.getSpendPerTransaction() - 1);
			//create pcard with error
			boolean flag = FlowCreatePCard.createPCardWithError(driver, testCaseName, pCard);

			//checking if pcard is not created or not
			if (flag)
			{
				flag = PageCreatePCard.getUserLimitError(driver, testCaseName).toLowerCase().contains(IConstantsData.ERROR_PCARD_DAILY_SPEND);
				Assert.assertTrue(flag, IConstantsData.ERROR_PCARD_DAILY_SPEND + " this error message is not getting");
			}
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
	 * <b>@author omkar.jagdale</b> <b><br>
	 * <font color="blue">Method :</b>While creating user Pcard,daily amount should not exceed amount per cycle.<br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_21187(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = new User();
		PCard pCard = new PCard();
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//creatinng a new pcard
			pCard = ObjectCreation.getDefaultObjectOfPCard(IConstantsData.ISSUED_TO_USER);
			pCard.setpCardNo(RandomCreditCardNumberGenerator.getCreditCardNumber(1, IConstantsData.PCARD_TYPE_MASTER_CARD)[0]);
			//setting cycle amount less than daily amount
			pCard.setSpendPerCycle(pCard.getSpendPerDay() - 1);
			//create pcard with error
			boolean flag = FlowCreatePCard.createPCardWithError(driver, testCaseName, pCard);

			//checking if pcard is not created or not
			if (flag)
			{
				flag = PageCreatePCard.getUserLimitError(driver, testCaseName).toLowerCase().contains(IConstantsData.ERROR_PCARD_DAILY_SPEND_MORE_THAN_SPEND_CYCLE);
				Assert.assertTrue(flag, IConstantsData.ERROR_PCARD_DAILY_SPEND_MORE_THAN_SPEND_CYCLE + " this error message is not getting");
			}
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
	 * <b>@author omkar.jagdale</b> <b><br>
	 * <font color="blue">Method :</b>User should get an option to edit the Pcard and reuse it,once it gets expired and deactivated.<br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_21188(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = new User();
		PCard pCard = new PCard();
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//Create New PCard
			pCard = ObjectCreation.getDefaultObjectOfPCard(IConstantsData.ISSUED_TO_USER);
			pCard.setIssuedTo(user.getUsername());
			pCard.setpCardNo(RandomCreditCardNumberGenerator.getCreditCardNumber(1, IConstantsData.PCARD_TYPE_MASTER_CARD)[0]);
			pCard = FlowCreatePCard.createPCard(driver, testCaseName, pCard);

			if (!FlowPCardListing.searchPCard(driver, testCaseName, null, pCard.getpCardNo()))
				CommonServices.assertionMethod(driver, testCase, user, null);

			//deactivation it
			boolean flag = FlowPCardListing.deactivatePCard(driver, testCaseName, pCard.getpCardNo());
			Assert.assertTrue(flag, "Pcard is not in deactivated status");
			//click on actionlink
			if (flag)
			{
				PCard pCard1 = new PCard();
				pCard1.setIssuingBank(CommonServices.getTestData(IConstantsData.PCARD_ISSUING_BANK));
				flag = FlowPCardListing.editPcard(driver, testCaseName, pCard1);
				Assert.assertTrue(flag, "PCard is not successfully edited");
				pCard1.setpCardNo(pCard.getpCardNo());

				Item item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
				item.getGuidedItems().get(0).setPrice(pCard.getSpendPerTransaction());
				item.getGuidedItems().get(0).setQuantity(1.0f);
				MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
				Requisition requisition = ObjectCreation.getRequisition(driver);
				requisition.setItems(item);
				//requisition.setOnBehalfOf(CommonServices.getTestData(IConstantsData.BUYER_NAME));
				requisition.setSettlementvia(IConstantsData.SETTLEMENT_VIA_OPTION_PCARD);
				requisition.setPcard("XXXX XXXX XXXX " + pCard.getpCardNo().substring(pCard.getpCardNo().length() - 4));
				FlowRequisition.createRequisition(driver, testCaseName, requisition);
				requisition = FlowMyRequisitions.searchRequisition(driver, testCaseName, requisition);
				Assert.assertTrue(requisition.getReqNo() != null, "requisition is not created");

			}
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
	 * <b>@author omkar.jagdale</b> <b><br>
	 * <font color="blue">Method :</b>User Pcards can not be used for orders with multiple currencies within the same requisition.<br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_21190(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = new User();

		Requisition requisition = new Requisition();
		Item item = new Item();
		List<GuidedItem> guidedItems = new ArrayList<>();
		PCard pCard = new PCard();
		boolean flag;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//create pcard
			pCard = ObjectCreation.getDefaultObjectOfPCard(IConstantsData.ISSUED_TO_USER);
			pCard.setIssuedTo(user.getUsername());
			pCard.setpCardNo(RandomCreditCardNumberGenerator.getCreditCardNumber(1, IConstantsData.PCARD_TYPE_VISA)[0]);
			pCard = FlowCreatePCard.createPCard(driver, testCaseName, pCard);

			flag = FlowPCardListing.searchPCard(driver, testCaseName, null, pCard.getpCardNo());
			Assert.assertTrue(flag, "PCard is not created");

			//create 2 guided items with different currency
			guidedItems.add(ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER));
			guidedItems.add(ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER));
			float itemPrice = pCard.getSpendPerTransaction() / 2;
			guidedItems.get(0).setCurrency(CommonServices.getTestData(IConstantsData.CURRENCY_TYPE));
			guidedItems.get(0).setQuantity(1.0f);
			guidedItems.get(0).setPrice(itemPrice);
			guidedItems.get(1).setCurrency(CommonServices.getTestData(IConstantsData.CHANGED_CURRENCY));
			guidedItems.get(1).setQuantity(1.0f);
			guidedItems.get(1).setPrice(itemPrice);

			item.setGuidedItems(guidedItems);

			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);

			//creating requisition
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);
			//	requisition.setOnBehalfOf(CommonServices.getTestData(IConstantsData.BUYER_NAME));
			requisition.setSettlementvia(IConstantsData.SETTLEMENT_VIA_OPTION_PCARD);
			requisition.setPcard("XXXX XXXX XXXX " + pCard.getpCardNo().substring(pCard.getpCardNo().length() - 4));

			requisition.setModifyWorkflowSettings(true);
			FlowRequisition.createRequisition(driver, testCaseName, requisition);

			//check if error msg contains multiple currencies error or not
			flag = PageRequisitionCheckOut.getGlobelErrorMsg(driver, testCaseName).toLowerCase().contains(IConstantsData.ERROR_PCARD_ORDERS_MULTI_CURR);
			Assert.assertTrue(flag, "p-card orders cannot be of multiple currencies error not displayed OR requisition is submitted");
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
	 * <b>@author omkar.jagdale</b> <b><br>
	 * <font color="blue">Method :</b>Create a requisition using user Pcard,with items from different suppliers.<br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_21191(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = new User();

		Requisition requisition = new Requisition();
		Item item = new Item();
		List<GuidedItem> guidedItems = new ArrayList<>();
		PCard pCard = new PCard();

		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//create pcard
			pCard = ObjectCreation.getDefaultObjectOfPCard(IConstantsData.ISSUED_TO_USER);
			pCard.setIssuedTo(user.getUsername());
			pCard = FlowCreatePCard.createPCard(driver, testCaseName, pCard);

			if (!FlowPCardListing.searchPCard(driver, testCaseName, null, pCard.getpCardNo()))
				CommonServices.assertionMethod(driver, testCase, user, null);

			//create 2 guided items with different currency
			guidedItems.add(ObjectCreation.getDefaultGuidedItemObject(IConstantsData.SUGGEST_NEW_SUPPLIER));
			guidedItems.add(ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER));
			float itemPrice = pCard.getSpendPerTransaction() / 2;
			guidedItems.get(0).setPrice(itemPrice);
			guidedItems.get(1).setPrice(itemPrice);
			guidedItems.get(0).setQuantity(1.0f);
			guidedItems.get(1).setQuantity(1.0f);

			item.setGuidedItems(guidedItems);

			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);

			//creating requisition
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);
			//requisition.setOnBehalfOf(CommonServices.getTestData(IConstantsData.BUYER_NAME));
			requisition.setSettlementvia(IConstantsData.SETTLEMENT_VIA_OPTION_PCARD);
			requisition.setPcard("XXXX XXXX XXXX " + pCard.getpCardNo().substring(pCard.getpCardNo().length() - 4));

			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			requisition = FlowMyRequisitions.searchRequisition(driver, testCaseName, requisition);
			Assert.assertTrue(requisition.getReqNo() != null, "Requisition is not created");

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
	 * <b>@author omkar.jagdale</b> <b><br>
	 * <font color="blue">Method :</b>User should not be allowed to use a user Pcard once the transactions exceeds per day limit.<br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_21200(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = new User();

		Requisition requisition = new Requisition();
		Item item = new Item();
		PCard pCard = new PCard();
		boolean flag;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//create pcard
			pCard = ObjectCreation.getDefaultObjectOfPCard(IConstantsData.ISSUED_TO_USER);
			pCard.setIssuedTo(user.getUsername());
			pCard.setTransactionsPerDay(1);
			pCard.setSpendPerDay(pCard.getSpendPerTransaction());
			pCard.setTransactionsPerCycle(1);
			pCard.setSpendPerCycle(pCard.getSpendPerTransaction());
			logger.info("Spend per transaction amount : " + pCard.getSpendPerTransaction());
			pCard = FlowCreatePCard.createPCard(driver, testCaseName, pCard);
			pCard = FlowCreatePCard.createPCard(driver, testCaseName, pCard);

			flag = FlowPCardListing.searchPCard(driver, testCaseName, null, pCard.getpCardNo());
			Assert.assertTrue(flag, "Pcard is not created");

			//creating item object
			item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
			item.getGuidedItems().get(0).setPrice(pCard.getSpendPerTransaction());
			item.getGuidedItems().get(0).setQuantity(1.0f);

			//creating requisition
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);

			//set settlement via pcard
			requisition.setSettlementvia(IConstantsData.SETTLEMENT_VIA_OPTION_PCARD);
			//requisition.setOnBehalfOf(CommonServices.getTestData(IConstantsData.BUYER_NAME));
			requisition.setPcard("XXXX XXXX XXXX " + pCard.getpCardNo().substring(pCard.getpCardNo().length() - 4));
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);

			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			//create requisition again to check the number transaction exceed error getting or not
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);
			//set settlement via pcard
			requisition.setSettlementvia(IConstantsData.SETTLEMENT_VIA_OPTION_PCARD);
			//	requisition.setOnBehalfOf(CommonServices.getTestData(IConstantsData.BUYER_NAME));
			requisition.setPcard("XXXX XXXX XXXX " + pCard.getpCardNo().substring(pCard.getpCardNo().length() - 4));
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);

			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

			flag = PageRequisitionCheckOut.getPcardErrorMsg(driver, testCaseName).toLowerCase().contains(IConstantsData.ERROR_PCARD_TRANSACTION_LIMIT_EXCEEDED);
			Assert.assertTrue(flag, IConstantsData.ERROR_PCARD_TRANSACTION_LIMIT_EXCEEDED + " This error message is not getting or requsition has been created");
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
	 * <b>@author omkar.jagdale</b> <b><br>
	 * <font color="blue">Method :</b>User should not be allowed to use a user Pcard once the spend exceeds per day limit.<br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_21201(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = new User();

		Requisition requisition = new Requisition();
		Item item = new Item();
		PCard pCard = new PCard();
		boolean flag;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//create pcard
			pCard = ObjectCreation.getDefaultObjectOfPCard(IConstantsData.ISSUED_TO_USER);
			pCard.setIssuedTo(user.getUsername());
			pCard.setTransactionsPerDay(1);
			pCard.setSpendPerDay(pCard.getSpendPerTransaction());
			pCard.setTransactionsPerCycle(1);
			pCard.setSpendPerCycle(pCard.getSpendPerTransaction());
			logger.info("Spend per transaction amount : " + pCard.getSpendPerTransaction());
			pCard = FlowCreatePCard.createPCard(driver, testCaseName, pCard);
			pCard = FlowCreatePCard.createPCard(driver, testCaseName, pCard);

			flag = FlowPCardListing.searchPCard(driver, testCaseName, null, pCard.getpCardNo());
			Assert.assertTrue(flag, "Pcard is not created");

			//creating item object
			item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
			item.getGuidedItems().get(0).setPrice(pCard.getSpendPerTransaction() + 1);
			item.getGuidedItems().get(0).setQuantity(1.0f);

			//creating requisition
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);

			//set settlement via pcard
			requisition.setSettlementvia(IConstantsData.SETTLEMENT_VIA_OPTION_PCARD);
			//requisition.setOnBehalfOf(CommonServices.getTestData(IConstantsData.BUYER_NAME));
			requisition.setPcard("XXXX XXXX XXXX " + pCard.getpCardNo().substring(pCard.getpCardNo().length() - 4));
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);

			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			//check spend per limit exceed error message is getting or not
			flag = PageRequisitionCheckOut.getPcardErrorMsg(driver, testCaseName).toLowerCase().contains(IConstantsData.ERROR_PCARD_SPEND_LIMIT_EXCEEDED);
			Assert.assertTrue(flag, IConstantsData.ERROR_PCARD_SPEND_LIMIT_EXCEEDED + " this error message is not getting or requition is created");
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
	 * <b>@author omkar.jagdale</b> <b><br>
	 * <font color="blue">Method :</b>User should not be allowed to use a user Pcard when the user exceeds per use spend limit.<br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_21202(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = new User();

		Requisition requisition = new Requisition();
		Item item = new Item();
		List<GuidedItem> guidedItems = new ArrayList<>();
		PCard pCard = new PCard();
		boolean flag;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//create pcard
			pCard = ObjectCreation.getDefaultObjectOfPCard(IConstantsData.ISSUED_TO_USER);
			pCard.setIssuedTo(user.getUsername());
			pCard = FlowCreatePCard.createPCard(driver, testCaseName, pCard);

			if (!FlowPCardListing.searchPCard(driver, testCaseName, null, pCard.getpCardNo()))
				CommonServices.assertionMethod(driver, testCase, user, null);

			//create a guided item
			guidedItems.add(ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER));
			guidedItems.get(0).setPrice(pCard.getSpendPerTransaction() + 1);
			guidedItems.get(0).setQuantity(1.0f);

			item.setGuidedItems(guidedItems);

			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);

			//creating requisition
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);
			requisition.setItems(item);
			//requisition.setOnBehalfOf(CommonServices.getTestData(IConstantsData.BUYER_NAME));
			requisition.setSettlementvia(IConstantsData.SETTLEMENT_VIA_OPTION_PCARD);
			requisition.setPcard("XXXX XXXX XXXX " + pCard.getpCardNo().substring(pCard.getpCardNo().length() - 4));

			requisition.setModifyWorkflowSettings(true);
			FlowRequisition.createRequisition(driver, testCaseName, requisition);
			requisition.setNextAction(IConstantsData.SUBMIT_REQ_FOR_APPROVAL);

			//check if error msg contains multiple currencies error or not
			flag = PageRequisitionCheckOut.getPcardErrorMsg(driver, testCaseName).toLowerCase().contains(IConstantsData.ERROR_PCARD_SPEND_LIMIT_EXCEEDED);
			Assert.assertTrue(flag, "spend limit on this user p-card has been exceeded this error is not displayed OR requisition is submitted");
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
	 * <b>@author omkar.jagdale</b> <b><br>
	 * <font color="blue">Method :</b>User should not be allowed to use a user Pcard when the user exceeds per cycle transaction limit.<br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_21203(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = new User();

		Requisition requisition = new Requisition();
		Item item = new Item();
		List<GuidedItem> guidedItems = new ArrayList<>();
		PCard pCard = new PCard();
		boolean flag;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//create pcard
			pCard = ObjectCreation.getDefaultObjectOfPCard(IConstantsData.ISSUED_TO_USER);
			pCard.setIssuedTo(user.getUsername());
			pCard.setTransactionsPerDay(1);
			pCard.setSpendPerDay(pCard.getSpendPerTransaction());
			pCard.setTransactionsPerCycle(1);
			pCard.setSpendPerCycle(pCard.getSpendPerTransaction());

			pCard = FlowCreatePCard.createPCard(driver, testCaseName, pCard);

			flag = FlowPCardListing.searchPCard(driver, testCaseName, null, pCard.getpCardNo());
			Assert.assertTrue(flag, "Pcard is not created");

			//create a guided item
			guidedItems.add(ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER));
			guidedItems.get(0).setPrice(pCard.getSpendPerTransaction());
			guidedItems.get(0).setQuantity(1.0f);

			item.setGuidedItems(guidedItems);

			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);

			//creating requisition
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);
			requisition.setItems(item);
			//requisition.setOnBehalfOf(CommonServices.getTestData(IConstantsData.BUYER_NAME));
			requisition.setSettlementvia(IConstantsData.SETTLEMENT_VIA_OPTION_PCARD);
			requisition.setPcard("XXXX XXXX XXXX " + pCard.getpCardNo().substring(pCard.getpCardNo().length() - 4));

			requisition.setModifyWorkflowSettings(true);

			FlowRequisition.createRequisition(driver, testCaseName, requisition);

			//creating requisition again to check the error
			Requisition requisition2 = new Requisition();
			requisition2 = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);
			//requisition2.setOnBehalfOf(CommonServices.getTestData(IConstantsData.BUYER_NAME));
			requisition2.setSettlementvia(IConstantsData.SETTLEMENT_VIA_OPTION_PCARD);
			requisition2.setPcard("XXXX XXXX XXXX " + pCard.getpCardNo().substring(pCard.getpCardNo().length() - 4));

			requisition2.setModifyWorkflowSettings(true);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			FlowRequisition.createRequisition(driver, testCaseName, requisition2);
			ActionBot.defaultHighSleep();

			//check if error msg contains multiple currencies error or not
			flag = PageRequisitionCheckOut.getPcardErrorMsg(driver, testCaseName).toLowerCase().contains(IConstantsData.ERROR_PCARD_TRANSACTION_LIMIT_EXCEEDED);
			Assert.assertTrue(flag, "number of transactions allowed have been exceeded this error is not occured  OR requisition is submitted");
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
	 * <b>@author omkar.jagdale</b> <b><br>
	 * <font color="blue">Method :</b>User should not be allowed to use a user Pcard when the user exceeds per cycle spend limit.<br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_21204(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = new User();

		Requisition requisition = new Requisition();
		Item item = new Item();
		List<GuidedItem> guidedItems = new ArrayList<>();
		PCard pCard = new PCard();
		boolean flag;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//create pcard
			pCard = ObjectCreation.getDefaultObjectOfPCard(IConstantsData.ISSUED_TO_USER);
			pCard.setIssuedTo(user.getUsername());
			pCard.setTransactionsPerDay(1);
			pCard.setSpendPerDay(pCard.getSpendPerTransaction());
			pCard.setTransactionsPerCycle(1);
			pCard.setSpendPerCycle(pCard.getSpendPerTransaction());

			pCard = FlowCreatePCard.createPCard(driver, testCaseName, pCard);

			if (!FlowPCardListing.searchPCard(driver, testCaseName, null, pCard.getpCardNo()))
				CommonServices.assertionMethod(driver, testCase, user, null);

			//create a guided item
			guidedItems.add(ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER));
			guidedItems.get(0).setPrice(pCard.getSpendPerCycle() + 1);
			guidedItems.get(0).setQuantity(1.0f);

			item.setGuidedItems(guidedItems);

			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);

			//creating requisition
			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);
			requisition.setItems(item);
			//requisition.setOnBehalfOf(CommonServices.getTestData(IConstantsData.BUYER_NAME));
			requisition.setSettlementvia(IConstantsData.SETTLEMENT_VIA_OPTION_PCARD);
			requisition.setPcard("XXXX XXXX XXXX " + pCard.getpCardNo().substring(pCard.getpCardNo().length() - 4));

			FlowRequisition.createRequisition(driver, testCaseName, requisition);

			//check if error msg contains multiple currencies error or not
			flag = PageRequisitionCheckOut.getPcardErrorMsg(driver, testCaseName).toLowerCase().contains(IConstantsData.ERROR_PCARD_SPEND_LIMIT_EXCEEDED);
			Assert.assertTrue(flag, IConstantsData.ERROR_PCARD_SPEND_LIMIT_EXCEEDED + " this error is not occured or requisition is submitted");
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
	 * <b>@author omkar.jagdale</b> <b><br>
	 * <font color="blue">Method :</b>A supplier Pcard when deactivated and edited,can be issued to a different supplier other than the previous one.<br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_21219(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = new User();
		PCard pCard = new PCard();
		boolean flag;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			pCard = ObjectCreation.getDefaultObjectOfPCard(IConstantsData.ISSUED_TO_SUPPLIER);
			pCard.setIssuedTo(CommonServices.getTestData(IConstantsData.OTHER_SUPPLIER_NAME));
			pCard.setpCardNo(RandomCreditCardNumberGenerator.getCreditCardNumber(1, IConstantsData.PCARD_TYPE_AMEX)[0]);
			pCard = FlowCreatePCard.createPCard(driver, testCaseName, pCard);

			flag = FlowPCardListing.searchPCard(driver, testCaseName, null, pCard.getpCardNo());
			Assert.assertTrue(flag, "Pcard is not generated");
			flag = FlowPCardListing.deactivatePCard(driver, testCaseName, pCard.getpCardNo());
			Assert.assertTrue(flag, "Pcard with supplier " + pCard.getIssuedTo() + " is not deactivated created by user " + user.getUsername());
			//change the issue to supplier
			pCard.setIssuedTo(CommonServices.getTestData(IConstantsData.OTHER_SUPPLIER_NAME));
			PagePCardListing.clickOnPCardActionsOfFirstRow(driver, testCaseName);
			ModalPCardListingActions.clickOnEditPCardActionsLink(driver, testCaseName);
			pCard.setIssuedTo(PageCreatePCard.fillIssuedToSupplier(driver, testCaseName, pCard.getIssuedTo()));
			// activate pcard
			PageCreatePCard.clickOnActivatePCardButton(driver, testCaseName);

			// verifying actiation of pcard
			// search PCard
			flag = FlowPCardListing.searchPCard(driver, testCaseName, null, pCard.getpCardNo());
			String status = PagePCardListing.getStatusOfPCard(driver, testCaseName);
			logger.info("Status of PCard after editing it : " + status);
			flag = status.equalsIgnoreCase(IConstantsData.IN_USE);
			Assert.assertTrue(flag, "Pcard is not edited successfully");
			flag = PagePCardListing.getIssueToOfPCard(driver, testCaseName).equalsIgnoreCase(pCard.getIssuedTo());
			Assert.assertTrue(flag, "Pcard with supplier " + pCard.getIssuedTo() + " is not created successfully");
			//Deactivate Pcard so we can create pCard with same supplier
			flag = FlowPCardListing.deactivatePCard(driver, testCaseName, pCard.getpCardNo());
			Assert.assertTrue(flag, "Pcard with supplier " + pCard.getIssuedTo() + " is not deactivated created by user " + user.getUsername());
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
	 * <b>@author omkar.jagdale</b> <b><br>
	 * <font color="blue">Method :</b>User should be able to view count increment in transaction details of user Pcard,after each successfull transaction.<br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_21221(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = new User();
		PCard pCard = new PCard();
		Item item = new Item();
		Requisition requisition = new Requisition();
		boolean flag;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//create pcard
			pCard = ObjectCreation.getDefaultObjectOfPCard(IConstantsData.ISSUED_TO_USER);
			pCard.setIssuedTo(user.getUsername());
			pCard = FlowCreatePCard.createPCard(driver, testCaseName, pCard);

			flag = FlowPCardListing.searchPCard(driver, testCaseName, null, pCard.getpCardNo());
			Assert.assertTrue(flag, "Pcard is not created");

			//creating item object
			item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
			item.getGuidedItems().get(0).setPrice(pCard.getSpendPerTransaction() / 2);
			item.getGuidedItems().get(0).setQuantity(1.0f);

			//creating requisition
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);

			//set settlement via pcard
			requisition.setSettlementvia(IConstantsData.SETTLEMENT_VIA_OPTION_PCARD);
			//requisition.setOnBehalfOf(CommonServices.getTestData(IConstantsData.BUYER_NAME));
			requisition.setPcard("XXXX XXXX XXXX " + pCard.getpCardNo().substring(pCard.getpCardNo().length() - 4));
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			FlowRequisition.createRequisition(driver, testCaseName, requisition);

			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			requisition = ObjectCreation.getRequisition(driver);
			item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
			item.getGuidedItems().get(0).setPrice(pCard.getSpendPerTransaction() / 2);
			item.getGuidedItems().get(0).setQuantity(1.0f);
			requisition.setItems(item);

			//set settlement via pcard
			requisition.setSettlementvia(IConstantsData.SETTLEMENT_VIA_OPTION_PCARD);
			//requisition.setOnBehalfOf(CommonServices.getTestData(IConstantsData.BUYER_NAME));
			requisition.setPcard("XXXX XXXX XXXX " + pCard.getpCardNo().substring(pCard.getpCardNo().length() - 4));
			requisition.setNextAction(IConstantsData.NONE);
			FlowRequisition.createRequisition(driver, testCaseName, requisition);

			//check if transaction msg is appeared
			flag = PageRequisitionCheckOut.getPcardTransactionCount(driver, testCaseName).toLowerCase().contains(IConstantsData.PCARD_TRANSACTION_COUNT.toLowerCase());
			Assert.assertTrue(flag, "Transaction count is not displayed");
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
	 * <b>@author omkar.jagdale</b> <b><br>
	 * <font color="blue">Method :</b>Create a requisition with a given user Pcard and Convert to PO at buyer's desk,deactivate the Pcard now and try to release the PO.<br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_21226(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = new User();
		PCard pCard = new PCard();
		Item item = new Item();
		Requisition requisition = new Requisition();
		boolean flag;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//create pcard
			pCard = ObjectCreation.getDefaultObjectOfPCard(IConstantsData.ISSUED_TO_USER);
			pCard.setIssuedTo(user.getUsername());
			pCard = FlowCreatePCard.createPCard(driver, testCaseName, pCard);

			flag = FlowPCardListing.searchPCard(driver, testCaseName, null, pCard.getpCardNo());
			Assert.assertTrue(flag, "Pcard is not created");

			//creating item object
			item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
			item.getGuidedItems().get(0).setPrice(pCard.getSpendPerTransaction() / 2);
			item.getGuidedItems().get(0).setQuantity(1.0f);

			//creating requisition
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);

			//set settlement via pcard
			requisition.setSettlementvia(IConstantsData.SETTLEMENT_VIA_OPTION_PCARD);
			//requisition.setOnBehalfOf(CommonServices.getTestData(IConstantsData.BUYER_NAME));
			requisition.setPcard("XXXX XXXX XXXX " + pCard.getpCardNo().substring(pCard.getpCardNo().length() - 4));
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);

			requisition = CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			FlowBuyersDeskListing.viewRequisitionAtBuyersDesk(driver, testCaseName);
			FlowBuyersDesk.convertToPo(driver, testCaseName);
			List<PurchaseOrder> purchaseOrders = FlowBuyersDesk.submitAllSuggestedPosForProcessing(driver, testCaseName);
			//Deactivate Pcard
			FlowPCardListing.searchPCard(driver, testCaseName, null, pCard.getpCardNo());
			flag = FlowPCardListing.deactivatePCard(driver, testCaseName, pCard.getpCardNo());
			Assert.assertTrue(flag, "Pcard is not deactivated");
			//Release Po
			FlowPoListing.searchPo(driver, testCaseName, requisition.getReqNo(), IConstantsData.SEARCH_BY_ORDER_DESCRIPTION);
			if (PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				ApprovalAllRequests approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, purchaseOrders.get(0).getPoNo(),
					IConstantsData.PURCHASE_ORDER, IConstantsData.APPROVE);
				FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);
				FlowPoListing.searchPo(driver, testCaseName, requisition.getReqNo(), IConstantsData.SEARCH_BY_ORDER_DESCRIPTION);
			}

			if (PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.PARKED_FILTER_LABEL))
			{
				PagePurchaseOrderListing.clickOnPoActionsLink(driver, testCaseName);
				PagePurchaseOrderListing.clickonReleaseActionLink(driver, testCaseName);
				ModalViewPOActions.clickOnReleasePoButton(driver, testCaseName);
			}
			FlowPoListing.searchPo(driver, testCaseName, requisition.getReqNo(), IConstantsData.SEARCH_BY_ORDER_DESCRIPTION);
			flag = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.PARKED_FILTER_LABEL);
			Assert.assertTrue(flag, "PO can be released even Pcard is deactivated");
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
	 * <b>@author omkar.jagdale</b> <b><br>
	 * <font color="blue">Method :</b>At checkout page,choose a Pcard for which transaction or spend limit has exceeded,edit the Pcard and increase the transaction and spend limit,user should now be able to use the same Pcard for transaction.</br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_21228(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = new User();

		Requisition requisition = new Requisition();
		Item item = new Item();
		List<GuidedItem> guidedItems = new ArrayList<>();
		PCard pCard = new PCard();
		boolean flag;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//create pcard
			pCard = ObjectCreation.getDefaultObjectOfPCard(IConstantsData.ISSUED_TO_USER);
			pCard.setIssuedTo(user.getUsername());
			pCard.setTransactionsPerDay(1);
			pCard.setSpendPerDay(pCard.getSpendPerTransaction());
			pCard.setTransactionsPerCycle(1);
			pCard.setSpendPerCycle(pCard.getSpendPerTransaction());

			pCard = FlowCreatePCard.createPCard(driver, testCaseName, pCard);
			flag = FlowPCardListing.searchPCard(driver, testCaseName, null, pCard.getpCardNo());
			Assert.assertTrue(flag, "PCard is not created");
			int amount = CommonUtilities.getNonZeroRandomNumbers(1);
			logger.info("Amount :" + amount);
			//create a guided item
			guidedItems.add(ObjectCreation.getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER));
			guidedItems.get(0).setPrice(pCard.getSpendPerCycle() + amount);
			guidedItems.get(0).setQuantity(1.0f);

			item.setGuidedItems(guidedItems);

			MainPageHeaderLevelTab.clickOnRequisitionTab(driver);

			//creating requisition
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);
			requisition.setSettlementvia(IConstantsData.SETTLEMENT_VIA_OPTION_PCARD);
			//requisition.setOnBehalfOf(CommonServices.getTestData(IConstantsData.BUYER_NAME));
			requisition.setPcard("XXXX XXXX XXXX " + pCard.getpCardNo().substring(pCard.getpCardNo().length() - 4));
			FlowRequisition.createRequisition(driver, testCaseName, requisition);

			//check if error msg contains multiple currencies error or not
			flag = PageRequisitionCheckOut.getPcardErrorMsg(driver, testCaseName).toLowerCase().contains(IConstantsData.ERROR_PCARD_SPEND_LIMIT_EXCEEDED);
			Assert.assertTrue(flag, IConstantsData.ERROR_PCARD_SPEND_LIMIT_EXCEEDED + " This error message is not getting or requsition has been created");

			PCard pCard1 = new PCard();
			pCard1.setSpendPerTransaction(pCard.getSpendPerTransaction() + amount);
			pCard1.setTransactionsPerDay(10);
			pCard1.setSpendPerDay(pCard1.getSpendPerTransaction() * 10);
			pCard1.setTransactionsPerCycle(100);
			pCard1.setSpendPerCycle(pCard1.getSpendPerTransaction() * 100);
			FlowPCardListing.searchPCard(driver, testCaseName, null, pCard.getpCardNo());
			FlowPCardListing.deactivatePCard(driver, testCaseName, pCard.getpCardNo());

			FlowPCardListing.editPcard(driver, testCaseName, pCard1);

			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);
			requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);
			requisition = FlowMyRequisitions.searchRequisition(driver, testCaseName, requisition);
			Assert.assertTrue(requisition.getReqNo() != null, "Requisition is not created");

			CommonServices.successfulExecution(driver, testCase);

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
	 * <b>@author omkar.jagdale</b> <b><br>
	 * <font color="blue">Method :</b>Orders with settlement via user Pcard should not get amended.<br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_21197(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = new User();
		PCard pCard = new PCard();
		Item item = new Item();
		Requisition requisition = new Requisition();
		boolean flag;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//create pcard
			pCard = ObjectCreation.getDefaultObjectOfPCard(IConstantsData.ISSUED_TO_USER);
			pCard.setIssuedTo(user.getUsername());
			pCard = FlowCreatePCard.createPCard(driver, testCaseName, pCard);

			flag = FlowPCardListing.searchPCard(driver, testCaseName, null, pCard.getpCardNo());
			Assert.assertTrue(flag, "Pcard is not created");

			//creating item object
			item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
			item.getGuidedItems().get(0).setPrice(pCard.getSpendPerTransaction() / 2);
			item.getGuidedItems().get(0).setQuantity(1.0f);

			//creating requisition
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);

			//set settlement via pcard
			requisition.setSettlementvia(IConstantsData.SETTLEMENT_VIA_OPTION_PCARD);
			//requisition.setOnBehalfOf(CommonServices.getTestData(IConstantsData.BUYER_NAME));
			requisition.setPcard("XXXX XXXX XXXX " + pCard.getpCardNo().substring(pCard.getpCardNo().length() - 4));
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);

			requisition = CombineFlowImpl.reqToBuyersDesk(driver, testCaseName, requisition);
			FlowBuyersDeskListing.viewRequisitionAtBuyersDesk(driver, testCaseName);
			FlowBuyersDesk.convertToPo(driver, testCaseName);
			List<PurchaseOrder> purchaseOrders = FlowBuyersDesk.submitAllSuggestedPosForProcessing(driver, testCaseName);
			//Release Po
			FlowPoListing.searchPo(driver, testCaseName, requisition.getReqNo(), IConstantsData.SEARCH_BY_ORDER_DESCRIPTION);
			if (PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				ApprovalAllRequests approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, purchaseOrders.get(0).getPoNo(),
					IConstantsData.PURCHASE_ORDER, IConstantsData.APPROVE);
				FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);
			}

			FlowPoListing.searchPo(driver, testCaseName, requisition.getReqNo(), IConstantsData.SEARCH_BY_ORDER_DESCRIPTION);
			flag = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.RELEASED);
			Assert.assertTrue(flag, "PO is not in release state");

			PagePurchaseOrderListing.clickOnPoActionsLink(driver, testCaseName);
			flag = ModalPOListingActions.isAmendPOLinkEnable(driver, testCaseName);
			Assert.assertTrue(!flag, "User can ammend the PO");

			CommonServices.successfulExecution(driver, testCase);
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
	 * <b>@author omkar.jagdale</b> <b><br>
	 * <font color="blue">Method :</b>For retrospective purchase with user Pcard,count of transaction and spend per transaction must be updated into transaction details with each successful transaction.<br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 */
	@Test(dataProvider = "dataProvider")
	public void EPROC_21194(TestCase testCase) throws Exception
	{
		WebDriver driver = null;
		String testCaseName = testCase.getTestMethodName();
		Map<String, String> map = new HashMap<String, String>();
		List<MappedTestCase> mappedTestCases = new ArrayList<MappedTestCase>();
		User user = new User();
		PCard pCard = new PCard();
		List<GuidedItem> guidedItems = new ArrayList<>();
		Item item = new Item();
		Requisition requisition = new Requisition();
		boolean flag;
		try
		{
			driver = DriverSelector.getDriver(testCase);
			CommonServices.startTestCase(driver, testCase, mappedTestCases);
			user = LoginLogoutServices.login(driver, testCase);

			//create pcard
			pCard = ObjectCreation.getDefaultObjectOfPCard(IConstantsData.ISSUED_TO_USER);
			pCard.setIssuedTo(user.getUsername());
			pCard = FlowCreatePCard.createPCard(driver, testCaseName, pCard);
			flag = FlowPCardListing.searchPCard(driver, testCaseName, null, pCard.getpCardNo());
			Assert.assertTrue(flag, "Pcard is not created");

			item = ObjectCreation.getItem(IConstantsData.GUIDED_ITEM);
			item.getGuidedItems().get(0).setCurrency(pCard.getBillingCurrency());
			item.getGuidedItems().get(0).setQuantity(1.0f);
			item.getGuidedItems().get(0).setPrice(10.0f);

			//creating requisition
			requisition = ObjectCreation.getRequisition(driver);
			requisition.setItems(item);
			requisition.setRetrospectivePurchase(true);
			requisition.setSettlementvia(IConstantsData.SETTLEMENT_VIA_OPTION_PCARD);
			//requisition.setOnBehalfOf(CommonServices.getTestData(IConstantsData.BUYER_NAME));
			requisition.setPcard("XXXX XXXX XXXX " + pCard.getpCardNo().substring(pCard.getpCardNo().length() - 4));
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			FlowRequisition.createRequisition(driver, testCaseName, requisition);

			//Creating 2nd Requisition without submition to check the transaction details
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);

			requisition = ObjectCreation.getDefaultObjectOfRequisitionWithItems(driver, IConstantsData.CATALOG_ITEM);
			requisition.setSettlementvia(IConstantsData.SETTLEMENT_VIA_OPTION_PCARD);
			//requisition.setOnBehalfOf(CommonServices.getTestData(IConstantsData.BUYER_NAME));
			requisition.setPcard("XXXX XXXX XXXX " + pCard.getpCardNo().substring(pCard.getpCardNo().length() - 4));
			requisition.setNextAction(IConstantsData.NONE);
			FlowRequisition.createRequisition(driver, testCaseName, requisition);

			//check if transaction msg is appeared
			flag = PageRequisitionCheckOut.getPcardTransactionCount(driver, testCaseName).toLowerCase().contains(IConstantsData.PCARD_TRANSACTION_COUNT.toLowerCase());
			Assert.assertTrue(flag, "Transaction count is not presents");
			flag = PageRequisitionCheckOut.getPcardTransactionCount(driver, testCaseName).toLowerCase().contains(Float.toString(item.getGuidedItems().get(0).getPrice()));
			Assert.assertTrue(flag, "Spend per transaction is not present");
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
