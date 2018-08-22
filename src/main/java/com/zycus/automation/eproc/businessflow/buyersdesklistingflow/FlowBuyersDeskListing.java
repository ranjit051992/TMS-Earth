/**
 * 
 */
package com.zycus.automation.eproc.businessflow.buyersdesklistingflow;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.BuyersDeskFilter;
import com.zycus.automation.bo.Requisition;
import com.zycus.automation.eproc.businessflow.myrequisitionsflow.FlowMyRequisitions;
import com.zycus.automation.eproc.pageobjects.modals.addassignedbuyer.ModalAddAssignedBuyer;
import com.zycus.automation.eproc.pageobjects.modals.buyersdesklistingactions.ModalBuersDeskListingActions;
import com.zycus.automation.eproc.pageobjects.modals.buyersdesklistingreturnreq.ModalBuyersDeskReturnRequisition;
import com.zycus.automation.eproc.pageobjects.pages.BuyersDesk.IPageBuyersDesk;
import com.zycus.automation.eproc.pageobjects.pages.BuyersDesk.IPageBuyersDeskImpl;
import com.zycus.automation.eproc.pageobjects.pages.BuyersDesk.PageBuyersDesk;
import com.zycus.automation.eproc.pageobjects.pages.approval.PageAllRequestsApproval;
import com.zycus.automation.eproc.pageobjects.pages.buyersdesklisting.IPageBuyersDeskListing;
import com.zycus.automation.eproc.pageobjects.pages.buyersdesklisting.PageBuyersDeskListing;
import com.zycus.automation.eproc.pageobjects.pages.myrequisition.IPageMyRequisition;
import com.zycus.automation.eproc.pageobjects.pages.myrequisition.PageMyRequisition;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 */
public class FlowBuyersDeskListing
{

	static Logger logger = Logger.getLogger(FlowBuyersDeskListing.class);

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To search the requisition at buyers desk
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param requisition
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 * @throws FactoryMethodException
	 */
	public static Requisition searchAtBuyersDeskListing(WebDriver driver, String testCaseName, Requisition requisition) throws ActionBotException, FactoryMethodException
	{
		MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);

		if (PageBuyersDeskListing.isClearStatusFilterPresent(driver, testCaseName))
		{
			PageBuyersDeskListing.clickOnClearStatusFilter(driver, testCaseName);
		}
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
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param requisition
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
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
	 * <font color="blue">Method :</b>To view the requisition at buyers desk
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static void viewRequisitionAtBuyersDesk(WebDriver driver, String testCaseName) throws ActionBotException
	{
		PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
		ActionBot.findElement(driver, IPageBuyersDeskImpl.REQUISITION_NAME);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To return requisition from buyers desk
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param requisition
	 *        </font><b><br>
	 * @param reqCanBeResubmitted
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception
	 */
	public static boolean returnRequisitionFromBuyersDesk(WebDriver driver, String testCaseName, Requisition requisition, boolean reqCanBeResubmitted) throws Exception
	{
		boolean flag = false;

		//PageBuyersDeskListing.clickOnFirstReqNoLink(driver, testCaseName);
		//ActionBot.scroll(driver, "1000");
		PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
		PageBuyersDeskListing.clickOnReturnLinkIndexwise(driver, testCaseName, 1);
		ModalBuyersDeskReturnRequisition.fillReturnRequisitionComment(driver, testCaseName, IConstantsData.COMMENT_FOR_RETURN_REQUISITION);
		if (reqCanBeResubmitted == false)
			ModalBuyersDeskReturnRequisition.clickOnReqResubmit(driver, testCaseName);
		//ModalBuersDeskListingActions.clickOnRejectAction(driver, testCaseName);
		PageBuyersDeskListing.clickReturnSubmitFromBuyer(driver, testCaseName);

		if (reqCanBeResubmitted)
		{
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		}
		else
		{
			PopUpDefaultConfirmation.clickOnConfirmNoButton(driver, testCaseName);
		}

		ActionBot.waitTillPopUpIsPresent(driver, IPageBuyersDesk.UPDATE_REQUISITION_PROCESSING_DIV);
		/*
		 * PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
		 * ModalBuersDeskListingActions.clickOnRejectAction(driver,
		 * testCaseName);
		 * ModalBuyersDeskReturnRequisition.fillReturnRequisitionComment(driver,
		 * testCaseName, IConstantsData.COMMENT_FOR_RETURN_REQUISITION); if (
		 * !reqCanBeResubmitted ) {
		 * ModalBuyersDeskReturnRequisition.clickOnReqResubmit(driver,
		 * testCaseName); }
		 * ModalBuyersDeskReturnRequisition.clickOnReturnReqButton(driver,
		 * testCaseName);
		 */

		// to search req at my req
		//requisition.setReqNo(null);
		FlowMyRequisitions.searchInMyRequisitionTab(driver, testCaseName, requisition);

		String status = PageMyRequisition.getStatusOfFirstReq(driver, testCaseName);
		if (reqCanBeResubmitted)
		{

			// flag =
			// status.equalsIgnoreCase(IConstantsData.RETURNED_FOR_AMENDMENT_FILTER_LABEL);
			flag = status.contains(IConstantsData.IN_PROCESS_FILTER_LABEL);
		}
		else
		{
			flag = status.equalsIgnoreCase(IConstantsData.REJECTED_FILTER_LABEL);
		}
		return flag;

	}

	public static Requisition changeAssignedBuyer(WebDriver driver, String testCaseName, Requisition requisition) throws ActionBotException
	{
		PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
		ModalBuersDeskListingActions.clickOnChangeBuyerAction(driver, testCaseName);

		requisition.setAssignedBuyer(ModalAddAssignedBuyer.fillAssignedBuyerName(driver, testCaseName, requisition.getAssignedBuyer()));
		ModalAddAssignedBuyer.fillChangedBuyerComments(driver, testCaseName, "This is auto generated comment for changing assigned buyer");
		if (requisition.getNextAction().equalsIgnoreCase(IConstantsData.SAVE))
		{
			ModalAddAssignedBuyer.clickOnSaveAssignedBuyerButton(driver, testCaseName);
		}
		else if (requisition.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			ModalAddAssignedBuyer.clickOnCancelAssignedBuyerButton(driver, testCaseName);
		}
		else
		{

		}
		requisition.setResult(checkIfAssignedBuyerIsChanged(driver, testCaseName, IConstantsData.Label_Change_Buyer_Multiple));
		return requisition;
	}

	public static boolean checkIfAssignedBuyerIsChanged(WebDriver driver, String testCaseName, String multiple) throws ActionBotException
	{
		String changedBuyerName = PageBuyersDeskListing.getFirstRowAssignedBuyer(driver, testCaseName);
		boolean flag = changedBuyerName.contains(multiple);
		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To apply status filter <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param buyersDeskFilter
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </font><b><br>
	 * @throws FactoryMethodException
	 *         </b> <br>
	 */
	public static BuyersDeskFilter applyStatusFilter(WebDriver driver, String testCaseName, BuyersDeskFilter buyersDeskFilter) throws ActionBotException, FactoryMethodException
	{
		MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
		PageBuyersDeskListing.clickOnClearStatusFilter(driver, testCaseName);
		PageBuyersDeskListing.clickOnStatusFilterButton(driver, testCaseName);

		if (buyersDeskFilter.isPartiallyOrderFilter())
		{
			PageMyRequisition.clickOnExpandInProcessInStatusFilterBtn(driver, testCaseName);
			PageBuyersDeskListing.clickOnExpandPendingOrderFilter(driver, testCaseName);
			PageBuyersDeskListing.clickOnPartiallyOrderedFilter(driver, testCaseName);
		}

		PageBuyersDeskListing.clickOnApplyStatusFilter(driver, testCaseName);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After applying filter");

		buyersDeskFilter.setResult(checkForStatusFilter(driver, testCaseName, buyersDeskFilter));

		return buyersDeskFilter;
	}

	public static boolean checkForStatusFilter(WebDriver driver, String testCaseName, BuyersDeskFilter buyersDeskFilter) throws ActionBotException
	{
		boolean statusFilterResult = false;
		int i = 0, totalReqCount = 0;
		String statusName, statusName2 = null, log = "";

		// list of status taken from My req page
		List<String> statusList = PageBuyersDeskListing.getStatusOfAllReq(driver, testCaseName);
		totalReqCount = statusList.size();
		logger.info("After appying filter Total Requisition Count : " + totalReqCount);

		// list of status taken from MyRequisitionFilter bo
		List<String> statusOfFilter = buyersDeskFilter.getStatusOfFilter();
		statusName = statusOfFilter.get(0);
		if (statusOfFilter.size() > 1)
		{
			statusName2 = statusOfFilter.get(1);
		}
		if (totalReqCount != 0)
		{
			for (String status : statusList)
			{
				if (status.equalsIgnoreCase(statusName) || status.equalsIgnoreCase(statusName2) && statusName2 != null)
				{
					log += status + "\n";
					i++;
					if (i == totalReqCount)
					{
						statusFilterResult = true;
						break;
					}
				}
			}
			logger.info("Status of Requisitions are : \n " + log);
		}
		else
		{
			logger.info("No requisition found");
			statusFilterResult = true;
		}
		return statusFilterResult;
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>To set status as Pending Order. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param buyersDeskFilter
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </font><b><br>
	 * @throws FactoryMethodException
	 *         </b> <br>
	 * @return
	 * @throws FactoryMethodException
	 * @throws ActionBotException
	 */
	public static void setStatusAsPendingQrder(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		PageBuyersDeskListing.clickOnLinkStatusFilter(driver, testCaseName);
		PageBuyersDeskListing.clickOnPendingOrderStatusFilter(driver, testCaseName);
		PageBuyersDeskListing.clickOnApplyStatusFilter(driver, testCaseName);
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>To clear status. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param buyersDeskFilter
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </font><b><br>
	 * @throws FactoryMethodException
	 *         </b> <br>
	 * @return
	 * @throws FactoryMethodException
	 * @throws ActionBotException
	 */
	public static void clearStatusFilter(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		PageBuyersDeskListing.clickOnLinkStatusFilter(driver, testCaseName);
		PageBuyersDeskListing.clickOnClearStatusFilter(driver, testCaseName);
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>To click on Edit link under Actions. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param buyersDeskFilter
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </font><b><br>
	 * @throws FactoryMethodException
	 *         </b> <br>
	 * @return
	 * @throws FactoryMethodException
	 * @throws ActionBotException
	 */
	public static void clickOnEditAction(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
		PageBuyersDeskListing.clickOnEditAction(driver, testCaseName);
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>To verify Edit link present under Actions.
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param buyersDeskFilter
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </font><b><br>
	 * @throws FactoryMethodException
	 *         </b> <br>
	 * @return
	 * @throws FactoryMethodException
	 * @throws ActionBotException
	 */
	public static boolean verifyEditAction(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		PageBuyersDeskListing.clickOnFirstActionButton(driver, testCaseName);
		return PageBuyersDeskListing.verifyEditAction(driver, testCaseName);
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>To set status as Awaiting Quote. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param buyersDeskFilter
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </font><b><br>
	 * @throws FactoryMethodException
	 *         </b> <br>
	 * @return
	 * @throws FactoryMethodException
	 * @throws ActionBotException
	 */
	public static void setStatusAsAwaitingQuote(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		PageBuyersDeskListing.clickOnLinkStatusFilter(driver, testCaseName);
		PageBuyersDeskListing.clickOnAwaitingQueueFilter(driver, testCaseName);
		PageBuyersDeskListing.clickOnApplyStatusFilter(driver, testCaseName);
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b> Sets Buyers Desk Status as Pending and
	 * selects req. <br>
	 * </font><b><font color="green"> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param itemId
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </font><b><br>
	 * @throws FactoryMethodException
	 *         </b> <br>
	 * @throws Exception
	 */
	public static void setStatusAsPendingAndEditReq(WebDriver driver, String testCaseName, String reqNumber) throws Exception
	{
		MainPageHeaderLevelTab.clickOnBuyersDeskTopTab(driver);
		FlowBuyersDeskListing.clearStatusFilter(driver, testCaseName);
		FlowBuyersDeskListing.setStatusAsPendingQrder(driver, testCaseName);
		PageBuyersDeskListing.searchRequisitionNumberInFilter(driver, testCaseName, reqNumber);
		FlowBuyersDeskListing.clickOnEditAction(driver, testCaseName);
	}

	/**
	 * <b>Author: Raj.Singh </b> <b><br>
	 * Reviewed By: kunal.ashar
	 */
	public static void toFilterPendingReqStatusFilter(WebDriver driver, String testCaseName) throws Exception
	{
		ActionBot.waitForPageLoad(driver);
		PageBuyersDeskListing.clearFilter(driver, testCaseName);
		PageBuyersDeskListing.clickOnStatusFilterButton(driver, testCaseName);
		PageBuyersDeskListing.clickOnPendingOrderStatusFilter(driver, testCaseName);
		PageBuyersDeskListing.clickOnApplyStatusFilter(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
	}

	/**
	 * <b>Author: Raj.Singh </b> <b><br>
	 * Reviewed By: kunal.ashar
	 */
	public static boolean checkFilterByAmountRequisitions(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		filterByAmountRequisitions(driver, testCaseName);
		int count = 0, success = 0;
		while (PageBuyersDeskListing.isReqPresentIndexwise(driver, testCaseName, count + 1))
		{
			count++;
			String amountString = PageBuyersDeskListing.fetchRequisitionAmountIndexwise(driver, testCaseName, count);
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

	/**
	 * <b>Author: Raj.Singh </b> <b><br>
	 * Reviewed By: kunal.ashar
	 */
	public static void filterByAmountRequisitions(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		PageBuyersDeskListing.clickAmountFilterButton(driver, testCaseName);
		ActionBot.defaultLowSleep();
		PageBuyersDeskListing.enterMaxAmountFilter(driver, testCaseName, "20000");
		PageBuyersDeskListing.enterMinAmountFilter(driver, testCaseName, "10000");
		ActionBot.click(driver, IPageBuyersDeskListing.BUYER_CHECK_INR_INPUT_CURRENCIES);
		PageBuyersDeskListing.clickApplyAmountFilter(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultLowSleep();
	}

	/**
	 * <b>Author: Raj.Singh </b> <b><br>
	 * Reviewed By: kunal.ashar
	 */
	public static void toFilterPartiallyOrderedStatusFilter(WebDriver driver, String testCaseName) throws Exception
	{
		ActionBot.waitForPageLoad(driver);
		PageBuyersDeskListing.clearFilter(driver, testCaseName);
		PageBuyersDeskListing.clickOnStatusFilterButton(driver, testCaseName);
		if (!ActionBot.isElementDisplayed(driver, IPageBuyersDeskListing.CHECKBOX_PENDING_ORDER_FILTER))
			ActionBot.click(driver, IPageBuyersDeskListing.IN_PROCESS_EXPAND);
		ActionBot.defaultSleep();
		PageBuyersDeskListing.clickOnPartiallyOrderedStatusFilter(driver, testCaseName);
		PageBuyersDeskListing.clickOnApplyStatusFilter(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
	}

	/**
	 * <b>Author: Raj.Singh </b> <b><br>
	 * Reviewed By: kunal.ashar
	 */
	public static void toFilterSourcingStatusFilter(WebDriver driver, String testCaseName) throws Exception
	{
		ActionBot.waitForPageLoad(driver);
		PageBuyersDeskListing.clearFilter(driver, testCaseName);
		PageBuyersDeskListing.clickOnStatusFilterButton(driver, testCaseName);
		PageBuyersDeskListing.clickOnSourcingStatusFilter(driver, testCaseName);
		PageBuyersDeskListing.clickOnApplyStatusFilter(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
	}

	/**
	 * <b>Author: Raj.Singh </b> <b><br>
	 * Reviewed By: kunal.ashar
	 */
	public static void toFilterCancelledStatusFilter(WebDriver driver, String testCaseName) throws Exception
	{
		ActionBot.waitForPageLoad(driver);
		PageBuyersDeskListing.clearFilter(driver, testCaseName);
		PageBuyersDeskListing.clickOnStatusFilterButton(driver, testCaseName);
		PageBuyersDeskListing.clickOnCancelledStatusFilter(driver, testCaseName);
		PageBuyersDeskListing.clickOnApplyStatusFilter(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
	}

	/**
	 * <b>Author: Raj.Singh </b> <b><br>
	 * Reviewed By: kunal.ashar
	 */
	public static void toFilterClosedStatusFilter(WebDriver driver, String testCaseName) throws Exception
	{
		ActionBot.waitForPageLoad(driver);
		PageBuyersDeskListing.clearFilter(driver, testCaseName);
		PageBuyersDeskListing.clickOnStatusFilterButton(driver, testCaseName);
		PageBuyersDeskListing.clickOnClosedStatusFilter(driver, testCaseName);
		PageBuyersDeskListing.clickOnApplyStatusFilter(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
	}

	/**
	 * <b>Author: Raj.Singh </b> <b><br>
	 * Reviewed By: kunal.ashar
	 */
	public static void toFilterAwaitingQuoteStatusFilter(WebDriver driver, String testCaseName) throws Exception
	{
		ActionBot.waitForPageLoad(driver);
		PageBuyersDeskListing.clearFilter(driver, testCaseName);
		PageBuyersDeskListing.clickOnStatusFilterButton(driver, testCaseName);
		PageBuyersDeskListing.clickOnAwaitingQuoteStatusFilter(driver, testCaseName);
		PageBuyersDeskListing.clickOnApplyStatusFilter(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
	}

	/**
	 * <b>Author: Raj.Singh </b> <b><br>
	 * Reviewed By: kunal.ashar
	 */
	public static void toFilterAwaitingReviewStatusFilter(WebDriver driver, String testCaseName) throws Exception
	{
		ActionBot.waitForPageLoad(driver);
		PageBuyersDeskListing.clearFilter(driver, testCaseName);
		PageBuyersDeskListing.clickOnStatusFilterButton(driver, testCaseName);
		PageBuyersDeskListing.clickOnAwaitingReviewStatusFilter(driver, testCaseName);
		PageBuyersDeskListing.clickOnApplyStatusFilter(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
	}

	/**
	 * <b>Author: Raj.Singh </b> <b><br>
	 * Reviewed By: kunal.ashar
	 */
	public static String[] toConvertReqToPartiallyOrderedReqIndexwise(WebDriver driver, String testCaseName, int index) throws Exception
	{
		String[] Req_PO_number = new String[2];
		// to create a partially ordered requisition indexwise
		//PageBuyersDeskListing.clickOnReqIndexwise(driver, testCaseName, index);
		PageBuyersDesk.clickItemCheckboxIndexwise(driver, testCaseName, 1);
		//PageBuyersDesk.clickEditItemIndexwise(driver, testCaseName, 1);
		PageBuyersDesk.clickCostAllocationTab(driver, testCaseName);
		PageBuyersDesk.fillGLAccount(driver, testCaseName, CommonServices.getTestData(IConstantsData.GL_ACCOUNT));
		PageBuyersDesk.clickButtonOkCostAllocationTab(driver, testCaseName);
		PageBuyersDesk.enterReqChangeComments(driver, testCaseName, IConstantsData.COMMENT_FOR_CHANGE_IN_REQUISITION);
		PageBuyersDesk.clickOnConvertToPo(driver, testCaseName);
		PageBuyersDesk.waitTillUpdateProcessingDivIsPresent(driver, testCaseName);

		// to finalize items for Releasing PO
		PageBuyersDesk.selectItemCheckBoxsToConvertToPO(driver, testCaseName);
		PageBuyersDesk.clickReleasePOButton(driver, testCaseName);
		ActionBot.defaultLowSleep();
		PageBuyersDesk.waitForLoadingPurchaseOrders(driver, testCaseName);

		// to fetch PO number and Requisition number
		String reqNumber = PageBuyersDesk.fetchReqNumberForPORelease(driver, testCaseName);
		String poNumber = PageBuyersDesk.fetchPONumberForRelease(driver, testCaseName);

		Req_PO_number[0] = reqNumber;
		Req_PO_number[1] = poNumber;

		// to navigate to approval sub tab and approve the PO
		MainPageHeaderLevelTab.clickOnApprovalAllRequestsTab(driver);
		PageAllRequestsApproval.clickOnPurchaseOrderTab(driver, testCaseName);
		PageAllRequestsApproval.searchRequition(driver, testCaseName, reqNumber);
		PageAllRequestsApproval.clickActionButton(driver, testCaseName);
		PageAllRequestsApproval.approveRequisition(driver, testCaseName);
		ActionBot.defaultLowSleep();

		return Req_PO_number;
	}

	/**
	 * <b>Author: Raj.Singh </b> <b><br>
	 * Reviewed By: kunal.ashar
	 */
	public static boolean toVerifyFilterStatusPerformance(WebDriver driver, String testCaseName, String filterStatus) throws Exception
	{
		boolean status = false;
		int pagelength = PageBuyersDeskListing.getNumberOfReqOnPage(driver, testCaseName);
		int successfullyMatchedStatusCount = 0;

		for (int i = 1; i <= pagelength; i++)
		{
			if (filterStatus.equals(IConstantsData.SOURCING_STATUS))
			{
				if (getReqStatusIndexwise(driver, testCaseName, i).equals(IConstantsData.RELEASED))
				{
					successfullyMatchedStatusCount++;
				}
				else if (getReqStatusIndexwise(driver, testCaseName, i).contains(IConstantsData.IN_PROCESS_FILTER_LABEL))
				{
					successfullyMatchedStatusCount++;
				}
			}
			else if (filterStatus.equals(IConstantsData.PROCESSED))
			{
				if (getReqStatusIndexwise(driver, testCaseName, i).contains(IConstantsData.IN_PROCESS_FILTER_LABEL))
				{
					successfullyMatchedStatusCount++;
				}
			}
			else if (filterStatus.equals(IConstantsData.PENDING_ORDER))
			{
				if (getReqStatusIndexwise(driver, testCaseName, i).contains(IConstantsData.PENDING_ORDER))
				{
					successfullyMatchedStatusCount++;
				}
			}
			else if (filterStatus.equals(IConstantsData.AWAITING_QUOTE))
			{
				if (getReqStatusIndexwise(driver, testCaseName, i).contains(IConstantsData.AWAITING_QUOTE))
				{
					successfullyMatchedStatusCount++;
				}
			}
			else if (filterStatus.equals(IConstantsData.AWAITING_REVIEW))
			{
				if (getReqStatusIndexwise(driver, testCaseName, i).equals(IConstantsData.AWAITING_REVIEW))
				{
					successfullyMatchedStatusCount++;
				}
			}
			else if (filterStatus.equals(IConstantsData.CANCELLED))
			{
				if (getReqStatusIndexwise(driver, testCaseName, i).equals(IConstantsData.CANCELLED))
				{
					successfullyMatchedStatusCount++;
				}
			}
			else if (filterStatus.equals(IConstantsData.CLOSED))
			{
				if (getReqStatusIndexwise(driver, testCaseName, i).equals(IConstantsData.CLOSED))
				{
					successfullyMatchedStatusCount++;
				}
			}
		}

		if (successfullyMatchedStatusCount == pagelength)
			status = true;

		return status;
	}

	/**
	 * <b>Author: Raj.Singh </b> <b><br>
	 * Reviewed By: kunal.ashar
	 */
	public static String getReqStatusIndexwise(WebDriver driver, String testCaseName, int index) throws Exception
	{
		return PageBuyersDeskListing.getReqStatusIndexwise(driver, testCaseName, index);
	}

}
