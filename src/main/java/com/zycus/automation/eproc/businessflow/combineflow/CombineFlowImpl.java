/**
 * 
 */
package com.zycus.automation.eproc.businessflow.combineflow;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.bo.ApprovalAllRequests;
import com.zycus.automation.bo.COAMayerBrownDataBO;
import com.zycus.automation.bo.PurchaseOrder;
import com.zycus.automation.bo.Requisition;
import com.zycus.automation.datacreation.ObjectCreation;
import com.zycus.automation.eproc.businessflow.allrequestsapprovalflow.FlowAllRequestsApproval;
import com.zycus.automation.eproc.businessflow.buyersdesk.FlowBuyersDesk;
import com.zycus.automation.eproc.businessflow.buyersdesklistingflow.FlowBuyersDeskListing;
import com.zycus.automation.eproc.businessflow.coaflow.COAFlow;
import com.zycus.automation.eproc.businessflow.myrequisitionsflow.FlowMyRequisitions;
import com.zycus.automation.eproc.businessflow.polistingflow.FlowPoListing;
import com.zycus.automation.eproc.businessflow.requisitionflow.FlowRequisition;
import com.zycus.automation.eproc.pageobjects.pages.purchaseorderlisting.PagePurchaseOrderListing;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.utilities.actionbot.ActionBot;

/**
 * @author ankita.sawant
 *
 */
public class CombineFlowImpl
{
	static Logger logger = Logger.getLogger(CombineFlowImpl.class);

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Req to Buyers Desk Flow <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param requisition </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception </b> <br>
	 */
	public static Requisition reqToBuyersDesk(WebDriver driver, String testCaseName, Requisition requisition) throws Exception
	{
		requisition = FlowRequisition.createRequisition(driver, testCaseName, requisition);

		requisition = FlowMyRequisitions.searchRequisition(driver, testCaseName, requisition);
		assertTrue("Error while searching requisition at my requisition", requisition.isResult());

		ApprovalAllRequests approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, requisition.getReqNo(), IConstantsData.REQUISITION,
			IConstantsData.APPROVE);

		approvalAllRequests = FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

		requisition = FlowBuyersDeskListing.searchAtBuyersDeskListing(driver, testCaseName, requisition);
		assertTrue("Error while searching requisition at Buyers Desk", requisition.isResult());

		return requisition;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To create PO from requisition and released
	 * it <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @param requisition </font><b><br>
	 * @return </b> <br>
	 * 
	 * @throws Exception
	 */
	public static Requisition reqToPO(WebDriver driver, String testCaseName, Requisition requisition) throws Exception
	{
		String status = null;
		boolean flag = false;
		requisition = reqToBuyersDesk(driver, testCaseName, requisition);

		logger.info("================== View req at Buyers Desk ==================");
		// to view the req
		FlowBuyersDeskListing.viewRequisitionAtBuyersDesk(driver, testCaseName);

		// convert To Po
		logger.info("================== Converting req to PO ==================");
		FlowBuyersDesk.convertToPo(driver, testCaseName);

		// submit all POs
		logger.info("================== Submit all POs ==================");
		List<PurchaseOrder> purchaseOrders = FlowBuyersDesk.submitAllSuggestedPosForProcessing(driver, testCaseName);
		requisition.setPurchaseOrdersList(purchaseOrders);

		// to search PO
		logger.info("================== Searching PO ==================");
		for (PurchaseOrder purchaseOrder : purchaseOrders)
		{
			flag = FlowPoListing.searchPo(driver, testCaseName, purchaseOrder.getPoNo(), IConstantsData.SEARCH_BY_PO_NO);
			assertTrue("PO was not created against requisition", flag);

			status = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName);
			if (status.equalsIgnoreCase(IConstantsData.IN_APPROVAL_FILTER_LABEL))
			{
				// to approve the PO
				ApprovalAllRequests approvalAllRequests = ObjectCreation.getObjectOfApprovalAllRequests(IConstantsData.DOC_NO, purchaseOrder.getPoNo(),
					IConstantsData.PURCHASE_ORDER, IConstantsData.APPROVE);
				FlowAllRequestsApproval.searchAndPerformActions(driver, testCaseName, approvalAllRequests);

				ActionBot.defaultHighSleep();
				driver.navigate().refresh();
				driver.navigate().refresh();

				// search po
				flag = FlowPoListing.searchPo(driver, testCaseName, purchaseOrder.getPoNo(), IConstantsData.SEARCH_BY_PO_NO);

				if (requisition.isVerificationRequiredOnPO() == true)
				{
					FlowPoListing.searchPo(driver, testCaseName, purchaseOrder.getPoNo(), IConstantsData.SEARCH_BY_PO_NO);
					WebElement actionlink = driver.findElement(By.xpath("(//a[@class='icon actLnk'])[1]"));
					actionlink.click();

					WebElement releaseLink = driver.findElement(By.xpath("//a[@class='scLnk icon releasepo']"));
					releaseLink.click();

					WebElement releasePoButton = driver.findElement(By.xpath("//span[@class='ui-button-text'][contains(text(),'Release PO')]"));
					releasePoButton.click();

					FlowPoListing.searchPo(driver, testCaseName, purchaseOrder.getPoNo(), IConstantsData.SEARCH_BY_PO_NO);

					PagePurchaseOrderListing.clickOnFirstPoNo(driver, testCaseName);
					List<COAMayerBrownDataBO> mayerDataList = COAFlow.viewCoaDataFromPOPage(driver);
					List<COAMayerBrownDataBO> enteredData = FlowRequisition.mayerBrownDataList;
					List<Boolean> flagList = COAFlow.compareTwoObject(enteredData, mayerDataList);

					for (COAMayerBrownDataBO mayerData : mayerDataList)
					{
						System.out.println(mayerData.getBookCostTo() + "--" + mayerData.getClient() + "---" + mayerData.getDepartment());
					}
				}
				else
				{
					assertTrue("Error while searching PO created against requisition", flag);
					// check status
					flag = PagePurchaseOrderListing.getFirstPoStatus(driver, testCaseName).equalsIgnoreCase(IConstantsData.COMPLETE_RELEASED_FILTER_LABEL);
					assertTrue("Status of PO was not Released", flag);
				}

			}

		}
		return requisition;

	}
}
