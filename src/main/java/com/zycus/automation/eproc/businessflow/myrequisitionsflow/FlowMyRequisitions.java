/**
 * 
 */
package com.zycus.automation.eproc.businessflow.myrequisitionsflow;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.cxf.common.util.SortedArraySet;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.bo.MyRequisitionFilter;
import com.zycus.automation.bo.Requisition;
import com.zycus.automation.eproc.businessflow.viewreqflow.FlowViewRequisition;
import com.zycus.automation.eproc.pageobjects.modals.closereq.ModalCloseReq;
import com.zycus.automation.eproc.pageobjects.modals.myRequisition_Actions_CancelRequisition.ModalCancelRequisition;
import com.zycus.automation.eproc.pageobjects.modals.myrequisitionactions.ModalMyRequisitionActions;
import com.zycus.automation.eproc.pageobjects.modals.myrequisitionstatusfilters.ModalMyRequisitionStatusFilters;
import com.zycus.automation.eproc.pageobjects.pages.myrequisition.IPageMyRequisition;
import com.zycus.automation.eproc.pageobjects.pages.myrequisition.PageMyRequisition;
import com.zycus.automation.eproc.pageobjects.pages.requisitionCheckOut.IPageRequisitionCheckOut;
import com.zycus.automation.eproc.pageobjects.pages.requisitionCheckOut.PageRequisitionCheckOut;
import com.zycus.automation.eproc.pageobjects.pages.viewrequisition.PageRequisitionView;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 */
public class FlowMyRequisitions
{

	static Logger logger = Logger.getLogger(FlowMyRequisitions.class);

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>search req in My req tab <br>
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
	public static Requisition searchInMyRequisitionTab(WebDriver driver, String testCaseName, Requisition requisition) throws ActionBotException
	{
		return searchReqInMyRequisitionTab(driver, testCaseName, requisition);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>search req in My req tab <br>
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
	private static Requisition searchReqInMyRequisitionTab(WebDriver driver, String testCaseName, Requisition requisition) throws ActionBotException
	{
		MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
		return searchRequisition(driver, testCaseName, requisition);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Apply status filter <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param myRequisitionFilter
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static MyRequisitionFilter applyMyRequisitionStatusFilter(WebDriver driver, String testCaseName, MyRequisitionFilter myRequisitionFilter) throws ActionBotException
	{
		MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
		PageMyRequisition.clickOnStatusFilterBtn(driver, testCaseName);

		if (myRequisitionFilter.isDraftFilter())
		{
			ModalMyRequisitionStatusFilters.clickOnApplyDraftFilter(driver, testCaseName);
		}
		if (myRequisitionFilter.isReadyForApprovalFilter())
		{
			ModalMyRequisitionStatusFilters.clickOnApplyReadyForApprovalFilter(driver, testCaseName);
		}
		if (myRequisitionFilter.isInApprovalFilter())
		{
			ModalMyRequisitionStatusFilters.clickOnApplyInApprovalFilter(driver, testCaseName);
		}
		if (myRequisitionFilter.isWithBuyerFilter())
		{
			ModalMyRequisitionStatusFilters.clickOnApplyWithBuyerFilter(driver, testCaseName);
		}
		if (myRequisitionFilter.isReturnedForAmendmentFilter())
		{
			ModalMyRequisitionStatusFilters.clickOnApplyReturnForAmendmentFilter(driver, testCaseName);
		}
		if (myRequisitionFilter.isReturnedForAmendmentFilter())
		{
			ModalMyRequisitionStatusFilters.clickOnApplyReturnForAmendmentFilter(driver, testCaseName);
		}
		if (myRequisitionFilter.isScheduledFilter())
		{
			ModalMyRequisitionStatusFilters.clickOnApplyScheduledFilter(driver, testCaseName);
		}
		if (myRequisitionFilter.isCompleteReleasedFilter())
		{
			ModalMyRequisitionStatusFilters.clickOnApplyReleasedFilter(driver, testCaseName);
		}
		if (myRequisitionFilter.isPartiallyOrderedFilter())
		{
			ModalMyRequisitionStatusFilters.clickOnApplyPartiallyOrderedFilter(driver, testCaseName);
		}
		if (myRequisitionFilter.isNotReceivedFilter())
		{
			ModalMyRequisitionStatusFilters.clickOnApplyNotReceivedFilter(driver, testCaseName);
		}
		if (myRequisitionFilter.isPartiallyReceivedFilter())
		{
			ModalMyRequisitionStatusFilters.clickOnApplyPartiallyReceivedFilter(driver, testCaseName);
		}
		if (myRequisitionFilter.isFullyReceivedFilter())
		{
			ModalMyRequisitionStatusFilters.clickOnApplyFullyReceivedFilter(driver, testCaseName);
		}
		if (myRequisitionFilter.isFullyReceivedFilter())
		{
			ModalMyRequisitionStatusFilters.clickOnApplyFullyReceivedFilter(driver, testCaseName);
		}
		if (myRequisitionFilter.isRejectedFilter())
		{
			ModalMyRequisitionStatusFilters.clickOnApplyRejectedFilter(driver, testCaseName);
		}
		if (myRequisitionFilter.isClosedFilter())
		{
			ModalMyRequisitionStatusFilters.clickOnApplyClosedFilter(driver, testCaseName);
		}
		if (myRequisitionFilter.isCancelledFilter())
		{
			ModalMyRequisitionStatusFilters.clickOnApplyCancelledFilter(driver, testCaseName);
		}
		if (myRequisitionFilter.isReturnedWithQuote())
		{
			ModalMyRequisitionStatusFilters.clickOnApplyReturnedWithQouteFilter(driver, testCaseName);
		}
		if (myRequisitionFilter.isSentForQuote())
		{
			ModalMyRequisitionStatusFilters.clickOnApplySetForQuoteFilter(driver, testCaseName);
		}
		if (myRequisitionFilter.isTransferredToMe())
		{
			ModalMyRequisitionStatusFilters.clickOnTransferredToMeCheckbox(driver, testCaseName);
		}

		ModalMyRequisitionStatusFilters.clickOnFilterBtn(driver, testCaseName);
		ActionBot.defaultHighSleep();
		ScreenShot.screenshot(driver, testCaseName, "After applying filter");

		myRequisitionFilter.setResult(IFlowMyRequisitionUtil.checkForStatusFilter(driver, testCaseName, myRequisitionFilter));

		return myRequisitionFilter;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Recall approval request <br>
	 */
	public static void recallApprovalRequest(WebDriver driver, String testCaseName, Requisition requisition) throws ActionBotException, FactoryMethodException
	{
		searchInMyRequisitionTab(driver, testCaseName, requisition);
		ActionBot.defaultSleep();
		ActionBot.waitForPageLoad(driver);
		try
		{
			if (requisition.getRecallRequisitionVia() != null)
			{
				if (requisition.getRecallRequisitionVia().equalsIgnoreCase(IConstantsData.VIA_ACTION_DROPDOWN))
				{
					PageMyRequisition.clickOnActionBtnOfFirstReq(driver, testCaseName);
					ModalMyRequisitionActions.clickOnRecallApproveRequestLink(driver, testCaseName);
				}
				else if (requisition.getRecallRequisitionVia().equalsIgnoreCase(IConstantsData.VIA_TOOL_TIP))
				{
					PageMyRequisition.clickOnRecallLink_ReqHover(driver, testCaseName);
				}
				else if (requisition.getRecallRequisitionVia().equalsIgnoreCase(IConstantsData.VIA_VIEW_PAGE))
				{
					// click on first requisition number
					PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
					ActionBot.waitForPageLoad(driver);

					// recall via view requisition page
					ModalMyRequisitionActions.clickOnRecallApproveRequestLink(driver, testCaseName);
				}
				else
				{
					logger.info("Invalid recall via option provided: " + requisition.getRecallRequisitionVia());
				}

				// to perform recall action
				if (requisition.getNextAction() != null)
				{
					ModalMyRequisitionActions.performRecallActions(driver, testCaseName, requisition.getNextAction());
				}

			}
		}
		catch (Exception e)
		{
			logger.info("Exception occured while performing recall operation" + e);

		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>View Req <br>
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
	public static void viewRequisition(WebDriver driver, String testCaseName) throws ActionBotException
	{
		PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Search req <br>
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
	public static Requisition searchRequisition(WebDriver driver, String testCaseName, Requisition requisition) throws ActionBotException
	{
		MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
		if (requisition.getReqNo() != null)
		{
			logger.info("Searching requisition using requisition number");
			String reqNo = requisition.getReqNo();
			PageMyRequisition.fillReqNumberOnMyReq(driver, testCaseName, reqNo);
			ActionBot.defaultMediumSleep();
			requisition.setResult(IFlowMyRequisitionUtil.checkIfRequisitionSearched(driver, testCaseName, requisition));
		}
		else if (requisition.getReqName() != null)
		{
			logger.info("Searching requisition using requisition name");
			String reqName = requisition.getReqName();
			PageMyRequisition.fillReqName(driver, testCaseName, reqName);
			// ActionBot.defaultMediumSleep();
			requisition.setResult(IFlowMyRequisitionUtil.checkIfRequisitionSearched(driver, testCaseName, requisition));
		}
		else if (requisition.getRequesterName() != null)
		{
			logger.info("Searching requisition using requester name");
			PageMyRequisition.fillRequester(driver, testCaseName, requisition.getRequesterName());
			ActionBot.defaultMediumSleep();
			requisition.setResult(IFlowMyRequisitionUtil.checkIfRequisitionSearched(driver, testCaseName, requisition));
		}
		else
		{
			logger.info("Invalid searching option");
		}

		// to fetch req external id if requisiton is searched
		if (requisition.isResult())
		{
			requisition.setId(PageMyRequisition.getRequisitionId(driver, testCaseName));
			if (requisition.getId() != null)
			{
				requisition.setRequisitionExternalId(PageMyRequisition.getRequisitionExternalId(driver, testCaseName, requisition.getId()));
			}
			else
			{
				logger.info("Requisiton Id not found. Req Id: " + requisition.getId());
			}
			requisition.setReqNo(PageMyRequisition.getFirstReqNo(driver, testCaseName));
			requisition.setRequesterName(PageMyRequisition.getFirstRequester(driver, testCaseName));
			requisition.setStatus(PageMyRequisition.getStatusOfFirstReq(driver, testCaseName));
			ScreenShot.screenshot(driver, testCaseName, "Search in my req tab");
		}

		return requisition;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Copy requisition <br>
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
	public static void copyReq(WebDriver driver, String testCaseName, boolean proceedWithExistingItems) throws ActionBotException
	{
		PageMyRequisition.clickOnActionBtnOfFirstReq(driver, testCaseName);
		try
		{
			ModalMyRequisitionActions.clickOnCopyLink(driver, testCaseName);
		}
		catch (ActionBotException e)
		{
			PageMyRequisition.clickOnActionBtnOfFirstReq(driver, testCaseName);
			ModalMyRequisitionActions.clickOnCopyLink(driver, testCaseName);
		}
		catch (StaleElementReferenceException e)
		{
			PageMyRequisition.clickOnActionBtnOfFirstReq(driver, testCaseName);
			ModalMyRequisitionActions.clickOnCopyLink(driver, testCaseName);
		}
		if (proceedWithExistingItems)
		{
			// saWater added
			if (PageMyRequisition.isPopUpProceedWithReqAndExistingCartItemsPreset(driver, testCaseName))
			{
				PageMyRequisition.clickProceedWithReqAndExistingCartItems(driver, testCaseName);
			}
			if (PopUpDefaultConfirmation.isConfirmYesButtonPresent(driver, testCaseName))
			{
				PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			}

		}
		else
		{
			// saWater added
			if (PageMyRequisition.isPopUpProceedOnlyWithReqItems(driver, testCaseName))
			{
				PageMyRequisition.clickProceedOnlyWithReqItems(driver, testCaseName);
			}

			if (PopUpDefaultConfirmation.isConfirmNoButtonPresent(driver, testCaseName))
			{
				PopUpDefaultConfirmation.clickOnConfirmNoButton(driver, testCaseName);
			}
		}
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Close Requisition <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static boolean closeRequisition(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean flag = false;
		PageMyRequisition.clickOnActionBtnOfFirstReq(driver, testCaseName);
		ModalMyRequisitionActions.clickOnCloseLink(driver, testCaseName);
		ModalCloseReq.fillCloseComment(driver, testCaseName, "Auto Generated Comment For closing requisition");
		ModalCloseReq.clickOnCloseReqButton(driver, testCaseName);

		flag = PageMyRequisition.getStatusOfFirstReq(driver, testCaseName).equalsIgnoreCase(IConstantsData.CLOSED_FILTER_LABEL);

		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To cancel requisition <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static boolean cancelRequisition(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean flag = false;
		PageMyRequisition.clickOnActionBtnOfFirstReq(driver, testCaseName);
		ModalMyRequisitionActions.clickOnCancelLink(driver, testCaseName);
		ModalCancelRequisition.fillCancelRequisitionComment(driver, testCaseName, "Auto Generated Comment For cancelling requisition");
		ModalCancelRequisition.toClickCancelRequisitionBtn(driver, testCaseName);

		flag = PageMyRequisition.getStatusOfFirstReq(driver, testCaseName).equalsIgnoreCase(IConstantsData.CANCELLED_FILTER_LABEL);
		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Edit requisition <br>
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
	public static void editReq(WebDriver driver, String testCaseName) throws ActionBotException
	{
		PageMyRequisition.clickOnActionBtnOfFirstReq(driver, testCaseName);
		ModalMyRequisitionActions.clickOnEditLink(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>Remind approver <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @throws FactoryMethodException
	 */
	public static boolean remindApprover(WebDriver driver, String testCaseName, Requisition requisition) throws ActionBotException, FactoryMethodException
	{
		// search and view requisiiton
		searchInMyRequisitionTab(driver, testCaseName, requisition);
		viewRequisition(driver, testCaseName);

		ActionBot.scroll(driver, "2000");

		// click on workflow link and remind approver
		PageRequisitionCheckOut.waitForLoadingDivOfWorkFlowTrail(driver, testCaseName);
		boolean flag = PageMyRequisition.clickOnLinkRemindApprover(driver, testCaseName);
		return flag;
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>Submit Req <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @throws FactoryMethodException
	 */
	public static boolean submitRequisition(WebDriver driver, String testCaseName, Requisition requisition) throws ActionBotException, FactoryMethodException
	{
		// search and view requisiiton
		searchInMyRequisitionTab(driver, testCaseName, requisition);
		viewRequisition(driver, testCaseName);

		ActionBot.scroll(driver, "500");
		boolean flag = PageMyRequisition.clickOnSubmitButton(driver, testCaseName);
		return flag;
	}

	/*************************************
	 * Ignore below methods for time-being
	 ************************************************/

	public static boolean isSearchByReqNamePossible(WebDriver driver, String testCaseName, String name) throws Exception
	{
		String reqName = PageMyRequisition.fillReqName(driver, testCaseName, name);
		ActionBot.defaultMediumSleep();
		if (reqName != null)
			return true;
		else
			return false;
	}

	public static boolean isSearchByReqNoPossible(WebDriver driver, String testCaseName, String no) throws Exception
	{
		String reqNo = PageMyRequisition.fillReqNumberOnMyReq(driver, testCaseName, no);
		ActionBot.defaultMediumSleep();
		if (reqNo != null)
			return true;
		else
			return false;
	}

	public static boolean isSearchByRequisiterPossible(WebDriver driver, String testCaseName, String requisiter) throws Exception
	{
		String requisiterName = PageMyRequisition.fillRequester(driver, testCaseName, requisiter);
		ActionBot.defaultMediumSleep();
		if (requisiterName != null)
			return true;
		else
			return false;
	}

	public static void toSearchAndClickReqFromMyRequisitions(WebDriver driver, String testCaseName, String req_number) throws ActionBotException, InterruptedException
	{
		MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
		PageMyRequisition.fillReqNumberOnMyReq(driver, testCaseName, req_number);
		ActionBot.defaultLowSleep();
		PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
	}

	public static void toFilterOutOrderingReqFromMyRequisitions(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		PageMyRequisition.clickOnStatusFilterBtn(driver, testCaseName);
		PageMyRequisition.clickOnExpandInProcessInStatusFilterBtn(driver, testCaseName);
		PageMyRequisition.clickOnOrderingInStatusFilterBtn(driver, testCaseName);
		PageMyRequisition.clickOnPerformFilterBtn(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
	}

	public static void toFilterOutInApprovalReqFromMyRequisitions(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		PageMyRequisition.clickOnStatusFilterBtn(driver, testCaseName);
		PageMyRequisition.clickOnExpandInProcessInStatusFilterBtn(driver, testCaseName);
		PageMyRequisition.clickOnInApprovalInStatusFilterBtn(driver, testCaseName);
		PageMyRequisition.clickOnPerformFilterBtn(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
	}

	public static void toFilterOutDraftReqFromMyRequisitions(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		PageMyRequisition.clickOnStatusFilterBtn(driver, testCaseName);
		PageMyRequisition.clickOnDraftInStatusFilterBtn(driver, testCaseName);
		PageMyRequisition.clickOnPerformFilterBtn(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
	}

	public static void toFilterOutReleasedReqFromMyRequisitions(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		PageMyRequisition.clickOnStatusFilterBtn(driver, testCaseName);
		PageMyRequisition.clickOnReleasedInStatusFilterBtn(driver, testCaseName);
		PageMyRequisition.clickOnPerformFilterBtn(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
	}

	public static void toFilterOutReturnedReqFromMyRequisitions(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		PageMyRequisition.clickOnStatusFilterBtn(driver, testCaseName);
		PageMyRequisition.clickOnExpandInProcessInStatusFilterBtn(driver, testCaseName);
		PageMyRequisition.clickOnReturnedForAmendInStatusFilterBtn(driver, testCaseName);
		PageMyRequisition.clickOnPerformFilterBtn(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
	}

	public static void toFilterOutWithBuyerReqFromMyRequisitions(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		PageMyRequisition.clickOnStatusFilterBtn(driver, testCaseName);
		PageMyRequisition.clickOnExpandInProcessInStatusFilterBtn(driver, testCaseName);
		PageMyRequisition.clickOnBuyersDeskInStatusFilterBtn(driver, testCaseName);
		PageMyRequisition.clickOnPerformFilterBtn(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
	}

	public static void toFilterOutRejectedReqFromMyRequisitions(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		PageMyRequisition.clickOnStatusFilterBtn(driver, testCaseName);
		PageMyRequisition.clickOnRejectedInStatusFilterBtn(driver, testCaseName);
		PageMyRequisition.clickOnPerformFilterBtn(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
	}

	public static void toFilterOutPartiallyOrderedReqFromMyRequisitions(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{

		PageMyRequisition.clickOnStatusFilterBtn(driver, testCaseName);
		if (!ActionBot.isElementDisplayed(driver, IPageMyRequisition.RELEASED_PARTIALLY_ORDERED))
		{
			PageMyRequisition.clickOnExpandReleasedInProcessInStatusFilterBtn(driver, testCaseName);
			ActionBot.defaultLowSleep();
		}
		ActionBot.click(driver, IPageMyRequisition.RELEASED_PARTIALLY_ORDERED);
		PageMyRequisition.clickOnPerformFilterBtn(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
	}

	public static void toFilterOutNotRecievedReqFromMyRequisitions(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		PageMyRequisition.clickOnStatusFilterBtn(driver, testCaseName);
		if (!ActionBot.isElementDisplayed(driver, IPageMyRequisition.RELEASED_NOT_RECIEVED))
		{
			PageMyRequisition.clickOnExpandReleasedInStatusFilterBtn(driver, testCaseName);
			ActionBot.defaultLowSleep();
		}
		ActionBot.click(driver, IPageMyRequisition.RELEASED_NOT_RECIEVED);
		PageMyRequisition.clickOnPerformFilterBtn(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
	}

	public static void toFilterOutPartiallyRecievedReqFromMyRequisitions(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		PageMyRequisition.clickOnStatusFilterBtn(driver, testCaseName);
		if (!ActionBot.isElementDisplayed(driver, IPageMyRequisition.RELEASED_PARTIALLY_RECIEVED))
		{
			PageMyRequisition.clickOnExpandReleasedInStatusFilterBtn(driver, testCaseName);
			ActionBot.defaultLowSleep();
		}
		ActionBot.click(driver, IPageMyRequisition.RELEASED_PARTIALLY_RECIEVED);
		PageMyRequisition.clickOnPerformFilterBtn(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
	}

	public static void toFilterOutFullyRecievedReqFromMyRequisitions(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		PageMyRequisition.clickOnStatusFilterBtn(driver, testCaseName);
		if (!ActionBot.isElementDisplayed(driver, IPageMyRequisition.RELEASED_FULLY_RECIEVED))
		{
			PageMyRequisition.clickOnExpandReleasedInStatusFilterBtn(driver, testCaseName);
			ActionBot.defaultLowSleep();
		}
		ActionBot.click(driver, IPageMyRequisition.RELEASED_FULLY_RECIEVED);
		PageMyRequisition.clickOnPerformFilterBtn(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
	}

	public static void toFilterOutClosedReqFromMyRequisitions(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		PageMyRequisition.clickOnStatusFilterBtn(driver, testCaseName);
		ActionBot.click(driver, IPageMyRequisition.CLOSED);
		PageMyRequisition.clickOnPerformFilterBtn(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
	}

	public static void toFilterOutCanceledReqFromMyRequisitions(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		PageMyRequisition.clickOnStatusFilterBtn(driver, testCaseName);
		ActionBot.click(driver, IPageMyRequisition.CANCELED);
		PageMyRequisition.clickOnPerformFilterBtn(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
	}

	public static void toFilterOutReturnedWithQuoteReqFromMyRequisitions(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		PageMyRequisition.clickOnStatusFilterBtn(driver, testCaseName);
		if (!ActionBot.isElementDisplayed(driver, IPageMyRequisition.RETURNED_WITH_QUOTE))
		{
			PageMyRequisition.clickOnExpandInProcessInStatusFilterBtn(driver, testCaseName);
		}
		ActionBot.click(driver, IPageMyRequisition.RETURNED_WITH_QUOTE);
		PageMyRequisition.clickOnPerformFilterBtn(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
	}

	public static void toFilterOutSentForQuoteReqFromMyRequisitions(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		PageMyRequisition.clickOnStatusFilterBtn(driver, testCaseName);
		if (!ActionBot.isElementDisplayed(driver, IPageMyRequisition.SENT_FOR_QUOTE))
		{
			PageMyRequisition.clickOnExpandInProcessInStatusFilterBtn(driver, testCaseName);
		}
		ActionBot.click(driver, IPageMyRequisition.SENT_FOR_QUOTE);
		PageMyRequisition.clickOnPerformFilterBtn(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
	}

	public static boolean toCopyReqFromMyRequisitions(WebDriver driver, String testCaseName, int index) throws ActionBotException, InterruptedException
	{
		Thread.sleep(4000);
		ActionBot.waitForElementToBePresent(driver, By.xpath("(.//*[@id='reqList']//*[@class='actBx'])[" + index + "]"));
		PageMyRequisition.clickOnReqAction(driver, testCaseName, index);
		PageMyRequisition.clickOnCopyActionReq(driver, testCaseName, index);
		ActionBot.defaultMediumSleep();
		if (ActionBot.isElementDisplayed(driver, IPageRequisitionCheckOut.NO_CONFIRMATION))
		{
			ActionBot.click(driver, IPageRequisitionCheckOut.NO_CONFIRMATION);
			ActionBot.waitForPageLoad(driver);
			return true;
		}
		else
		{
			return false;
		}
	}

	public static boolean toCancelReqFromMyRequisitions(WebDriver driver, String testCaseName, int index) throws Exception
	{
		PageMyRequisition.clickOnReqAction(driver, testCaseName, index);
		PageMyRequisition.clickOnCancelActionReq(driver, testCaseName, index);
		PageMyRequisition.fillCancelComment(driver, testCaseName, "Auto generated comment for cancelling requisition");
		PageMyRequisition.clickCancelActionReqButton(driver, testCaseName);
		// PageMyRequisition.fillRecallApprovalComment(driver, testCaseName,
		// CommonServices.getTestData(IConstantsData.CANCEL_REQ));
		// PageMyRequisition.clickOnCancelActionReq(driver, testCaseName, 1);

		//ActionBot.waitForPageLoad(driver);
		try
		{
			// ActionBot.waitForElementToBeDisplayed(driver,
			// IPageMyRequisition.SUCCESSFUL_SAVING_PROCESS, 60);
			if (ActionBot.isElementDisplayed(driver, IPageMyRequisition.SUCCESSFUL_SAVING_PROCESS))
			{
				ActionBot.waitTillPopUpIsPresent(driver, IPageMyRequisition.SUCCESSFUL_SAVING_PROCESS);
				ActionBot.waitForPageLoad(driver);
				ActionBot.defaultSleep();
				ActionBot.refreshPage(driver, testCaseName);
				return true;
			}
			else
				return false;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	public static boolean toCheckSuccessMessageMyRequisitions(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		ActionBot.waitForElementToBeDisplayed(driver, IPageMyRequisition.SUCCESS_MESSAGE, 6);
		if (ActionBot.isElementDisplayed(driver, IPageMyRequisition.SUCCESS_MESSAGE))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static boolean waitAndCheckForConfirmationOptionAvailability(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		ActionBot.waitForElementToBeDisplayed(driver, IPageMyRequisition.CONFIRMATION_OPTIONS, 6);
		return ActionBot.isElementPresent(driver, IPageMyRequisition.CONFIRMATION_OPTIONS);
	}

	public static boolean isMyRequisitionsPage(WebDriver driver, String testCaseName, int index) throws ActionBotException, InterruptedException
	{
		Thread.sleep(4000);
		ActionBot.waitForElementToBePresent(driver, By.xpath("(.//*[@id='reqList']//*[@class='actBx'])[" + index + "]"));
		return ActionBot.isElementPresent(driver, By.xpath("(.//*[@id='reqList']//*[@class='actBx'])[" + index + "]"));
	}

	public static boolean isFreewTextItemDetailPopup(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		Thread.sleep(4000);
		try
		{
			PageMyRequisition.clickOnReqItemIndexwise(driver, testCaseName, 1);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	public static boolean isCatlogItemDetailPopup(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		Thread.sleep(4000);
		ActionBot.waitForElementToBePresent(driver, 10, IPageMyRequisition.Cat_ITEM_DETAILS_POPUP_FIELD);
		return ActionBot.isElementPresent(driver, IPageMyRequisition.Cat_ITEM_DETAILS_POPUP_FIELD);
	}

	public static boolean isDraftStatusRequisitionDeletable(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
		ActionBot.waitForPageLoad(driver);
		toFilterOutDraftReqFromMyRequisitions(driver, testCaseName);
		ActionBot.defaultSleep();
		String req_no = PageMyRequisition.getReqNumberRowise(driver, testCaseName, 1);
		PageMyRequisition.clickOnReqAction(driver, testCaseName, 1);
		ActionBot.defaultLowSleep();
		PageMyRequisition.clickOnDeleteReq(driver, testCaseName, 1);
		ActionBot.waitForPageLoad(driver);
		PageMyRequisition.searchRequisitionByReqNo(driver, testCaseName, req_no);

		boolean status = false;
		if (ActionBot.isElementPresent(driver, IPageMyRequisition.FIRST_REQ_NAME))
			status = true;
		return status;
	}

	public static boolean isInApprovalStatusRequisitionPresentAfterRecall(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
		ActionBot.waitForPageLoad(driver);
		toFilterOutInApprovalReqFromMyRequisitions(driver, testCaseName);
		String req_no = PageMyRequisition.getReqNumberRowise(driver, testCaseName, 2);
		PageMyRequisition.clickOnReqAction(driver, testCaseName, 2);
		PageMyRequisition.clickApprovalReqButton(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
		PageMyRequisition.searchRequisitionByReqNo(driver, testCaseName, req_no);
		boolean status = false;
		if (ActionBot.isElementPresent(driver, IPageMyRequisition.FIRST_REQ_NAME))
			status = true;
		return status;
	}

	public static boolean isBillingAddressSameInViewAndCheckOutOfReqIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException, InterruptedException
	{
		MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
		ActionBot.waitForPageLoad(driver);
		toFilterOutInApprovalReqFromMyRequisitions(driver, testCaseName);
		PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
		PageRequisitionView.clickOnExpandDelivery(driver, testCaseName);
		String businessloc_BusinessUnit[] = FlowViewRequisition.fetchBU_BusinessLocationIndexwise(driver, testCaseName, 1);
		PageRequisitionView.clickOnActionsLink(driver, testCaseName);
		PageRequisitionView.clickOnCopyActionsLink(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
		// String businessUnit=PageRequisitionCheckOut.get
		boolean status = false;
		if (ActionBot.isElementDisplayed(driver, IPageMyRequisition.FIRST_REQ_NAME))
			status = true;
		return status;
	}

	public static boolean isDraftRequisitionCancelledSuccessfully(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		boolean status = false;
		ActionBot.defaultMediumSleep();
		if (ActionBot.isElementDisplayed(driver, By.xpath("(.//*[@id='reqList']//a[@class='scLnk'])[1]")))
			status = true;
		return status;
	}

	public static String fetchRequisitionBillingAddressIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException, InterruptedException
	{
		PageMyRequisition.toHoverUponRequistionIndexwise(driver, testCaseName, 1);
		String requisition_view_billing_address = PageMyRequisition.fetchRequisitionBillingAddress(driver, testCaseName, 1);
		return requisition_view_billing_address;
	}

	public static boolean isBillingAddressSimilarIn_Checkout_MyRequisitionView(WebDriver driver, String testCaseName, String billing_addres,
		String requisition_view_billing_address) throws ActionBotException, InterruptedException
	{
		if (billing_addres.equals(requisition_view_billing_address))
			return true;
		else
			return false;
	}

	public static void filterByAmountRequisitions(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		PageMyRequisition.clickAmountFilterButton(driver, testCaseName);
		ActionBot.defaultLowSleep();
		PageMyRequisition.enterMaxAmountFilter(driver, testCaseName, "20000");
		PageMyRequisition.enterMinAmountFilter(driver, testCaseName, "10000");
		ActionBot.click(driver, IPageMyRequisition.CHECK_INR_INPUT_CURRENCIES);
		PageMyRequisition.clickApplyAmountFilter(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultLowSleep();
	}

	public static boolean checkFilterByAmountRequisitions(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		filterByAmountRequisitions(driver, testCaseName);
		int count = 0, success = 0;
		while (PageMyRequisition.isReqPresentIndexwise(driver, testCaseName, count + 1))
		{
			count++;
			String amountString = PageMyRequisition.fetchRequisitionAmountIndexwise(driver, testCaseName, count);
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

	public static boolean checkStatusForEachRequisitionPresent(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		boolean status = false;
		int count = 0, index = 1;
		MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
		while (PageMyRequisition.isReqPresentIndexwise(driver, testCaseName, index))
		{
			if (PageMyRequisition.isReqStatusPresentIndexwise(driver, testCaseName, index))
				count++;
			index++;
		}
		index--;
		if (count == index)
			status = true;
		else
			status = false;
		return status;
	}

	public static boolean checkForEachRequisitionNamePresent(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		boolean status = false;
		int count = 0, index = 1;
		MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
		while (PageMyRequisition.isReqPresentIndexwise(driver, testCaseName, index))
		{
			if (PageMyRequisition.isReqNamePresentIndexwise(driver, testCaseName, index))
				count++;
			index++;
		}
		index--;
		if (count == index)
			status = true;
		else
			status = false;
		return status;
	}

	public static boolean checkRequesterForEachRequisitionPresent(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		boolean status = false;
		int count = 0, index = 1;
		MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
		while (PageMyRequisition.isReqPresentIndexwise(driver, testCaseName, index))
		{
			if (PageMyRequisition.isReqRequesterPresentIndexwise(driver, testCaseName, index))
				count++;
			index++;
		}
		index--;
		if (count == index)
			status = true;
		else
			status = false;
		return status;
	}

	public static boolean checkSubmittedonForEachRequisitionPresent(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		boolean status = false;
		int count = 0, index = 1;
		MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
		while (PageMyRequisition.isReqPresentIndexwise(driver, testCaseName, index))
		{
			if (PageMyRequisition.isReqSubmittedonPresentIndexwise(driver, testCaseName, index))
				count++;
			index++;
		}
		index--;
		if (count == index)
			status = true;
		else
			status = false;
		return status;
	}

	public static boolean checkAmountForEachRequisitionPresent(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		boolean status = false;
		int count = 0, index = 1;
		MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
		while (PageMyRequisition.isReqPresentIndexwise(driver, testCaseName, index))
		{
			if (PageMyRequisition.isReqAmountPresentIndexwise(driver, testCaseName, index))
				count++;
			index++;
		}
		index--;
		if (count == index)
			status = true;
		else
			status = false;
		return status;
	}

	public static boolean checkAscendingSortForRequisitionPresent(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		String[] req_nos = null;
		SortedArraySet<String> sorted_req_nos = new SortedArraySet<String>();
		Iterator<String> iterator = null;
		int counter = 0, loop_var = 0;

		ActionBot.defaultLowSleep();
		toFilterOutDraftReqFromMyRequisitions(driver, testCaseName);
		PageMyRequisition.clickToApplyAscendingSort(driver, testCaseName);
		ActionBot.defaultSleep();

		// storing the list of all requisition numbers in array and SortedArraySet
		List<WebElement> elements = PageMyRequisition.fetchRequisitionNumbers(driver, testCaseName);
		req_nos = new String[elements.size()];
		for (int i = 0; i < elements.size(); i++)
		{
			ActionBot.defaultLowSleep();
			String req_no = PageMyRequisition.getReqNumberRowise(driver, testCaseName, i + 1);
			if (req_no != null)
			{
				req_nos[i] = req_no;
				sorted_req_nos.add(req_no);
			}
		}

		// comparing the contents to get our result
		iterator = sorted_req_nos.iterator();
		while (iterator.hasNext())
		{
			if (req_nos[loop_var].equals(iterator.next()))
			{
				counter++;
			}
			loop_var++;
		}
		if (counter == elements.size())
			return true;
		else
			return false;

	}

	public static boolean checkDesscendingSortForRequisitionPresent(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		String[] req_nos = null;
		SortedArraySet<String> sorted_req_nos = new SortedArraySet<String>();
		Iterator<String> iterator = null;
		int counter = 0, loop_var = 0;

		ActionBot.defaultLowSleep();
		toFilterOutDraftReqFromMyRequisitions(driver, testCaseName);
		PageMyRequisition.clickToApplyDescendingSort(driver, testCaseName);
		ActionBot.defaultSleep();

		// storing the list of all requisition numbers in array and
		// SortedArraySet
		List<WebElement> elements = PageMyRequisition.fetchRequisitionNumbers(driver, testCaseName);
		req_nos = new String[elements.size()];
		for (int i = 0; i < elements.size(); i++)
		{
			ActionBot.defaultLowSleep();
			String req_no = PageMyRequisition.getReqNumberRowise(driver, testCaseName, i + 1);
			if (req_no != null)
			{
				req_nos[i] = req_no;
				sorted_req_nos.add(req_no);
			}
		}

		// comparing the contents to get our result
		loop_var = elements.size() - 1;
		iterator = sorted_req_nos.iterator();
		while (iterator.hasNext() && loop_var >= 0)
		{
			if (req_nos[loop_var].equals(iterator.next()))
			{
				counter++;
			}
			loop_var--;
		}
		if (counter == elements.size())
			return true;
		else
			return false;

	}

	public static boolean checkAscendingSortForRequisitionPresentOnDate(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException, ParseException
	{
		ActionBot.defaultLowSleep();
		toFilterOutInApprovalReqFromMyRequisitions(driver, testCaseName);
		ActionBot.defaultLowSleep();
		PageMyRequisition.clickToApplyAscendingSortOnDate(driver, testCaseName);
		boolean status = false;
		int count = 0, index = 1;
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		ActionBot.defaultLowSleep();
		String req_date = PageMyRequisition.fetchRequisitionSubumitionDateIndexwise(driver, testCaseName, index);
		Date newDate = dateFormat.parse(convertToDateStringFormat(req_date));
		index++;
		ActionBot.defaultLowSleep();
		while (PageMyRequisition.isReqPresentIndexwise(driver, testCaseName, index))
		{
			ActionBot.defaultLowSleep();
			req_date = PageMyRequisition.fetchRequisitionSubumitionDateIndexwise(driver, testCaseName, index);
			Date oldDate = dateFormat.parse(convertToDateStringFormat(req_date));
			if (newDate.before(oldDate) || newDate.equals(oldDate))
				count++;
			newDate = oldDate;
			index++;
		}
		index = index - 2;
		if (count == index)
			status = true;
		else
			status = false;
		return status;
	}

	public static String convertToDateStringFormat(String dateRawString)
	{
		String dateString = "";
		for (int i = 0; i < dateRawString.length(); i++)
		{
			if (dateRawString.charAt(i) == '/')
			{
				dateString = dateString + "-";
			}
			else
			{
				dateString = dateString + dateRawString.charAt(i);
			}
		}
		return dateString;
	}

	public static boolean checkDesscendingSortForRequisitionPresentOnDate(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException, ParseException
	{
		ActionBot.defaultMediumSleep();
		toFilterOutInApprovalReqFromMyRequisitions(driver, testCaseName);
		ActionBot.defaultLowSleep();
		PageMyRequisition.clickToApplyDescendingSortOnDate(driver, testCaseName);
		boolean status = false;
		int count = 0, index = 1;
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		ActionBot.defaultLowSleep();
		String req_date = PageMyRequisition.fetchRequisitionSubumitionDateIndexwise(driver, testCaseName, index);
		Date newDate = dateFormat.parse(convertToDateStringFormat(req_date));
		index++;
		ActionBot.defaultLowSleep();
		while (PageMyRequisition.isReqPresentIndexwise(driver, testCaseName, index))
		{
			ActionBot.defaultLowSleep();
			req_date = PageMyRequisition.fetchRequisitionSubumitionDateIndexwise(driver, testCaseName, index);
			Date oldDate = dateFormat.parse(convertToDateStringFormat(req_date));
			if (newDate.after(oldDate) || newDate.equals(oldDate))
				count++;
			newDate = oldDate;
			index++;
		}
		index = index - 2;
		;
		if (count == index)
			status = true;
		else
			status = false;
		return status;
	}

	public static boolean checkAllRequisitionStatusPresent(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException, ParseException
	{
		int count = 0;

		PageMyRequisition.clickOnStatusFilterBtn(driver, testCaseName);
		PageMyRequisition.clickOnExpandInProcessInStatusFilterBtn(driver, testCaseName);
		ActionBot.defaultLowSleep();

		// Draft
		if (PageMyRequisition.isReqStatusPresentInStatusFilter(driver, testCaseName, IConstantsData.DRAFT_FILTER_LABEL))
			count++;
		logger.info("Draft status status present::" + count);

		// readyForApproval
		if (PageMyRequisition.isReqStatusPresentInStatusFilter(driver, testCaseName, IConstantsData.READY_FOR_APPROVAL_FILTER_LABEL))
			count++;
		logger.info("Ready for approval status present::" + count);

		// inApproval
		if (PageMyRequisition.isReqStatusPresentInStatusFilter(driver, testCaseName, IConstantsData.IN_APPROVAL_FILTER_LABEL))
			count++;
		logger.info("In approval status present::" + count);

		// withBuyer
		if (PageMyRequisition.isReqStatusPresentInStatusFilter(driver, testCaseName, IConstantsData.WITH_BUYER_FILTER_LABEL_TEXT))
			count++;
		logger.info("With buyer status present::" + count);

		// returnedForAmendment
		if (PageMyRequisition.isReqStatusPresentInStatusFilter(driver, testCaseName, IConstantsData.RETURNED_FOR_AMENDMENT_FILTER_LABEL))
			count++;
		logger.info("Returned for amendment status present::" + count);

		// ordering
		if (PageMyRequisition.isReqStatusPresentInStatusFilter(driver, testCaseName, IConstantsData.ORDERING_FILTER_LABEL))
			count++;
		logger.info("Ordering status present::" + count);

		// rejected
		if (PageMyRequisition.isReqStatusPresentInStatusFilter(driver, testCaseName, IConstantsData.REJECTED_FILTER_LABEL))
			count++;
		logger.info("Rejected recevied status present::" + count);

		// closed
		if (PageMyRequisition.isReqStatusPresentInStatusFilter(driver, testCaseName, IConstantsData.CLOSED_FILTER_LABEL))
			count++;
		logger.info("Closed status present::" + count);

		// cancelled
		if (PageMyRequisition.isReqStatusPresentInStatusFilter(driver, testCaseName, IConstantsData.CANCELLED_FILTER_LABEL))
			count++;
		logger.info("Cancelled status present::" + count);

		// returnedWithQuote
		if (PageMyRequisition.isReqStatusPresentInStatusFilter(driver, testCaseName, IConstantsData.RETURNED_WITH_QUOTE_FILTER_LABEL))
			count++;
		logger.info("Returned with quote status present::" + count);

		// sentForQuote
		if (PageMyRequisition.isReqStatusPresentInStatusFilter(driver, testCaseName, IConstantsData.SENT_FOR_QUOTE_FILTER_LABEL))
			count++;
		logger.info("Sent for quote status present::" + count);

		// transferredToMe
		if (PageMyRequisition.isReqStatusPresentInStatusFilter(driver, testCaseName, IConstantsData.TRANSFERRED_TO_ME_FILTER_LABEL_TEXT))
			count++;
		logger.info("Transfered to me status present::" + count);

		// sentForBuyerReview
		if (PageMyRequisition.isReqStatusPresentInStatusFilter(driver, testCaseName, IConstantsData.SENT_FOR_BUYER_REVIEW_FILTER_LABEL_TEXT))
			count++;
		logger.info("Sent for buyer review status present::" + count);

		// released
		if (PageMyRequisition.isReqStatusPresentInStatusFilter(driver, testCaseName, IConstantsData.RELEASED))
			count++;
		logger.info("Released status present::" + count);

		PageMyRequisition.clickOnExpandInProcessInStatusFilterBtn(driver, testCaseName);

		PageMyRequisition.clickOnExpandReleasedInStatusFilterBtn(driver, testCaseName);

		// partiallyOrdered
		if (PageMyRequisition.isReqStatusPresentInStatusFilter(driver, testCaseName, IConstantsData.PARTIALLY_ORDERED_FILTER_LABEL))
			count++;
		logger.info("Partailly ordered status present::" + count);

		// notReceived
		if (PageMyRequisition.isReqStatusPresentInStatusFilter(driver, testCaseName, IConstantsData.NOT_RECEIVED_FILTER_LABEL))
			count++;
		logger.info("Not received status present::" + count);

		// partiallyReceived
		if (PageMyRequisition.isReqStatusPresentInStatusFilter(driver, testCaseName, IConstantsData.PARTIALLY_RECEIVED_FILTER_LABEL))
			count++;
		logger.info("Partially recevied status present::" + count);

		// fullyReceived
		if (PageMyRequisition.isReqStatusPresentInStatusFilter(driver, testCaseName, IConstantsData.FULLY_RECEIVED_FILTER_LABEL))
			count++;
		logger.info("Fully recevied status present::" + count);

		logger.info("Total count::" + count);

		if (count == 18)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	public static void saveReturnedReqFromBuyerDesk(WebDriver driver, String testCaseName, String reqNumber) throws ActionBotException, FactoryMethodException
	{
		MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
		PageMyRequisition.fillReqNumberOnMyReq(driver, testCaseName, reqNumber);
		FlowMyRequisitions.editReq(driver, testCaseName);
		PageRequisitionCheckOut.clickIAmDone(driver, testCaseName);
		PageRequisitionCheckOut.clickContinueButtonForConfirmPopup(driver, testCaseName);
	}

	/**
	 * <b>Author: akashdeep.singh || swet.shah </b> <b><br>
	 * <font color="blue">Method :</b>delete requisition <br>
	 */
	public static void deleteReq(WebDriver driver, String testCaseName) throws ActionBotException
	{
		PageMyRequisition.clickOnActionBtnOfFirstReq(driver, testCaseName);
		PageMyRequisition.clickOnDeleteReq(driver, testCaseName, 1);
		ActionBot.waitForPageLoad(driver);
	}
}
