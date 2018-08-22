/**
 * 
 */
package com.zycus.automation.eproc.businessflow.upcomingrequisitionlistingflow;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.Requisition;
import com.zycus.automation.eproc.pageobjects.pages.buyersdesklisting.IPageBuyersDeskListing;
import com.zycus.automation.eproc.pageobjects.pages.buyersdesklisting.PageBuyersDeskListing;
import com.zycus.automation.eproc.pageobjects.pages.myrequisition.IPageMyRequisition;
import com.zycus.automation.eproc.pageobjects.pages.upcomingRequisitions.IPageUpcomingRequisitions;
import com.zycus.automation.eproc.pageobjects.pages.upcomingRequisitions.PageUpcomingRequisitions;
import com.zycus.automation.eproc.pageobjects.pages.viewrequisition.IPageRequisitionView;
import com.zycus.automation.eproc.pageobjects.pages.viewrequisition.PageRequisitionView;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * @author ankita.sawant
 *
 */
public class FlowUpcomingRequisitionListing
{
	static Logger logger = Logger.getLogger(FlowUpcomingRequisitionListing.class);

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To search the requisition at buyers desk
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param requisition </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 * 
	 * @throws FactoryMethodException
	 */
	public static Requisition searchAtUpcomingRequisitionListing(WebDriver driver, String testCaseName, Requisition requisition) throws ActionBotException, FactoryMethodException
	{
		MainPageHeaderLevelTab.clickOnUpcomingRequisitionTab(driver, testCaseName);
		if (PageBuyersDeskListing.isAssignedBuyerFilterPresent(driver, testCaseName))
		{
			PageBuyersDeskListing.clickOnClearIconOfAssignedBuyerFilter(driver, testCaseName);
		}
		if (requisition.getReqNo() != null)
		{
			PageBuyersDeskListing.fillRequisitionNo(driver, testCaseName, requisition.getReqNo());
			requisition.setResult(checkIfRequisitionSearched(driver, testCaseName, requisition));
		}
		else if (requisition.getReqName() != null)
		{
			PageBuyersDeskListing.fillRequisitionName(driver, testCaseName, requisition.getReqName());
			requisition.setResult(checkIfRequisitionSearched(driver, testCaseName, requisition));
		}
		else if (requisition.getRequesterName() != null)
		{
			PageBuyersDeskListing.fillRequester(driver, testCaseName, requisition.getRequesterName());
			requisition.setResult(checkIfRequisitionSearched(driver, testCaseName, requisition));
		}
		else
		{

			logger.info("Wrong search option is set");
		}

		return requisition;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Check if requisition is searched <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param requisition </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static boolean checkIfRequisitionSearched(WebDriver driver, String testCaseName, Requisition requisition) throws ActionBotException
	{
		boolean result = false;
		if (ActionBot.isElementPresent(driver, IPageMyRequisition.DATA_TABLE_EMPTY))
		{
			logger.info("No records found");
			return result;
		}
		else
		{
			if (requisition.getReqNo() != null)
			{
				String searchedReqNo = PageBuyersDeskListing.getFirstRowReqNo(driver, testCaseName);
				result = searchedReqNo.equalsIgnoreCase(requisition.getReqNo());
			}
			else if (requisition.getReqName() != null)
			{
				String searchedReqName = PageBuyersDeskListing.getFirstRowReqName(driver, testCaseName);
				result = searchedReqName.contains(requisition.getReqName());
			}
			else if (requisition.getRequesterName() != null)
			{
				String searchedRequesterName = PageBuyersDeskListing.getFirstRowRequester(driver, testCaseName);
				result = searchedRequesterName.equalsIgnoreCase(requisition.getRequesterName());
			}
			else
			{
				logger.info("Wrong search option is set");
			}
		}
		return result;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To view the requisition <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static void viewRequisition(WebDriver driver, String testCaseName) throws ActionBotException
	{
		//ActionBot.waitForPageLoad(driver);
		PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
		if (!PageRequisitionView.isRequisitionNoLabelPresent(driver, testCaseName))
		{
			PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
		}
		ActionBot.findElement(driver, IPageRequisitionView.LABEL_REQUISITION_NO_ON_REQ_VIEW_PAGE);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To filter the upcoming requisition amount
	 * wise <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @throws ActionBotException </b> <br>
	 */
	public static void filterByAmountRequisitions(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException, FactoryMethodException
	{
		PageUpcomingRequisitions.clickAmountFilterButton(driver, testCaseName);
		ActionBot.defaultLowSleep();
		PageUpcomingRequisitions.enterMaxAmountFilter(driver, testCaseName, "20000");
		PageUpcomingRequisitions.enterMinAmountFilter(driver, testCaseName, "10000");
		ActionBot.click(driver, IPageUpcomingRequisitions.UPCOMING_CHECK_INR_INPUT_CURRENCIES);
		PageUpcomingRequisitions.clickApplyAmountFilter(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultLowSleep();
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>check upcoming requisition's with amount
	 * filter functionality <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @throws ActionBotException </b> <br>
	 * 
	 * @throws FactoryMethodException
	 */
	public static boolean checkFilterByAmountRequisitions(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException, FactoryMethodException
	{
		filterByAmountRequisitions(driver, testCaseName);
		int count = 0, success = 0;
		while (PageUpcomingRequisitions.isReqPresentIndexwise(driver, testCaseName, count + 1))
		{
			count++;
			String amountString = PageUpcomingRequisitions.fetchRequisitionAmountIndexwise(driver, testCaseName, count);
			double amount = Double.parseDouble(amountString);
			if ((amount >= 10000d) && (amount <= 20000d))
			{
				success++;
			}
		}
		if (success == count)
			return true;
		else
			return false;
	}
}
