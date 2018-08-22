/**
 * 
 */
package com.zycus.automation.eproc.businessflow.viewreqflow;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.exec.util.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.AuditTrail;
import com.zycus.automation.bo.CatelogItem;
import com.zycus.automation.bo.CostCenterSplitInfo;
import com.zycus.automation.bo.CustomDate;
import com.zycus.automation.bo.DeliverySplitInfo;
import com.zycus.automation.bo.Item;
import com.zycus.automation.bo.Requisition;
import com.zycus.automation.eproc.businessflow.myrequisitionsflow.FlowMyRequisitions;
import com.zycus.automation.eproc.pageobjects.pages.myrequisition.PageMyRequisition;
import com.zycus.automation.eproc.pageobjects.pages.requisitionCheckOut.PageRequisitionCheckOut;
import com.zycus.automation.eproc.pageobjects.pages.searchlisting.PageSearchListing;
import com.zycus.automation.eproc.pageobjects.pages.viewrequisition.IPageRequisitionView;
import com.zycus.automation.eproc.pageobjects.pages.viewrequisition.PageRequisitionView;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.common.CommonUtilities;

/**
 * @author ankita.sawant
 */
public class FlowViewRequisition
{
	static Logger logger = Logger.getLogger(FlowViewRequisition.class);

	public static List<DeliverySplitInfo> getDeliverySplitInfoOnReqViewPage(WebDriver driver, String testCaseName, String itemId, int noOfSplit) throws Exception
	{
		List<DeliverySplitInfo> deliverySplitInfos = new ArrayList<DeliverySplitInfo>();
		DeliverySplitInfo deliverySplitInfo1 = new DeliverySplitInfo();
		DeliverySplitInfo deliverySplitInfo2 = new DeliverySplitInfo();
		CustomDate customDate = new CustomDate();
		int index = 2;

		ActionBot.scroll(driver, "350");

		PageRequisitionCheckOut.clickExpandAll(driver, testCaseName);

		// 1st delivery info
		deliverySplitInfo1.setDeliverTo(PageRequisitionView.getDeliverTo(driver, testCaseName, index));
		deliverySplitInfo1.setQuantity(PageRequisitionView.getDeliveryQuantity(driver, testCaseName, index));
		// deliverySplitInfo1.setDeliveryAddress(PageRequisitionView.getShipToAddress(driver,
		// testCaseName, itemId, (index + 1)));
		deliverySplitInfo1.setDeliveryAddress(PageRequisitionView.getShipToAddress(driver, testCaseName, itemId, (index)));
		customDate.setDate(PageRequisitionView.getDeliveryDate(driver, testCaseName, index));
		deliverySplitInfo1.setCustomDate(customDate);

		index++;

		// 2st delivery info
		deliverySplitInfo2.setDeliverTo(PageRequisitionView.getDeliverTo(driver, testCaseName, index));
		deliverySplitInfo2.setQuantity(PageRequisitionView.getDeliveryQuantity(driver, testCaseName, index));
		// deliverySplitInfo2.setDeliveryAddress(PageRequisitionView.getShipToAddress(driver,
		// testCaseName, itemId, (index + 1)));
		deliverySplitInfo2.setDeliveryAddress(PageRequisitionView.getShipToAddress(driver, testCaseName, itemId, (index)));
		customDate.setDate(PageRequisitionView.getDeliveryDate(driver, testCaseName, index));
		deliverySplitInfo2.setCustomDate(customDate);

		deliverySplitInfos.add(deliverySplitInfo1);
		deliverySplitInfos.add(deliverySplitInfo2);
		return deliverySplitInfos;
	}

	public static List<CostCenterSplitInfo> getCostCenterSplitInfoOnReqViewPage(WebDriver driver, String testCaseName, int noOfSplit, String splitType) throws Exception
	{
		List<CostCenterSplitInfo> costCenterSplitInfos = new ArrayList<CostCenterSplitInfo>();
		CostCenterSplitInfo costCenterSplitInfo1 = new CostCenterSplitInfo();
		CostCenterSplitInfo costCenterSplitInfo2 = new CostCenterSplitInfo();
		int index = 1;

		ActionBot.scroll(driver, "350");

		PageRequisitionCheckOut.clickExpandAll(driver, testCaseName);

		//PageRequisitionView.clickOnExpandCostBooking(driver, testCaseName);

		logger.info("Cost Center information on requisition view page : ");

		if (splitType.equalsIgnoreCase(IConstantsData.CC_SPLIT_AT_ITEM_LEVEL))
		{
			// 1st cc info
			costCenterSplitInfo1.setCostCenter(PageRequisitionView.getCostCenterForItemLevelCCSplit(driver, testCaseName, index));
			costCenterSplitInfo1.setBudget(PageRequisitionView.getBudgetForItemLevelCCSplit(driver, testCaseName, index));
			costCenterSplitInfo1.setProject(PageRequisitionView.getProjectForItemLevelCCSplit(driver, testCaseName, index));
			costCenterSplitInfo1.setPrice(PageRequisitionView.getPrice(driver, testCaseName, index));

			index++;
			// 2st cc info
			costCenterSplitInfo2.setCostCenter(PageRequisitionView.getCostCenterForItemLevelCCSplit(driver, testCaseName, index));
			costCenterSplitInfo2.setBudget(PageRequisitionView.getBudgetForItemLevelCCSplit(driver, testCaseName, index));
			costCenterSplitInfo2.setProject(PageRequisitionView.getProjectForItemLevelCCSplit(driver, testCaseName, index));
			costCenterSplitInfo2.setPrice(PageRequisitionView.getPrice(driver, testCaseName, index));
		}
		else if (splitType.equalsIgnoreCase(IConstantsData.CC_SPLIT_AT_HEADER_LEVEL))
		{
			// 1st cc info
			costCenterSplitInfo1.setCostCenter(PageRequisitionView.getCostCenterForHeaderLevelCCSplit(driver, testCaseName, index));
			costCenterSplitInfo1.setBudget(PageRequisitionView.getBudgetForHeaderLevelCCSplit(driver, testCaseName, index));
			costCenterSplitInfo1.setProject(PageRequisitionView.getProjectForHeaderLevelCCSplit(driver, testCaseName, index));
			costCenterSplitInfo1.setPrice(PageRequisitionView.getPrice(driver, testCaseName, index));

			index++;
			// 2st cc info
			costCenterSplitInfo2.setCostCenter(PageRequisitionView.getCostCenterForHeaderLevelCCSplit(driver, testCaseName, index));
			costCenterSplitInfo2.setBudget(PageRequisitionView.getBudgetForHeaderLevelCCSplit(driver, testCaseName, index));
			costCenterSplitInfo2.setProject(PageRequisitionView.getProjectForHeaderLevelCCSplit(driver, testCaseName, index));
			costCenterSplitInfo2.setPrice(PageRequisitionView.getPrice(driver, testCaseName, index));
		}
		costCenterSplitInfos.add(costCenterSplitInfo1);
		costCenterSplitInfos.add(costCenterSplitInfo2);
		return costCenterSplitInfos;
	}

	public static Requisition getRequisitionInfo(WebDriver driver, String testCaseName, int noOfItems) throws ActionBotException
	{
		Requisition requisition = new Requisition();

		logger.info("Information on requistion view page : ");
		requisition.setReqNo(PageRequisitionView.getRequisitionNo(driver, testCaseName));
		requisition.setReqName(PageRequisitionView.getRequisitionName(driver, testCaseName));
		requisition.setRequired(PageRequisitionView.getUrgRequirement(driver, testCaseName));
		// requisition.setRequesterName(PageRequisitionView.getCreatedBy(driver,
		// testCaseName));
		requisition.setSettlementvia(PageRequisitionView.getSettlementVia(driver, testCaseName));
		requisition.setReasonForOrdering(PageRequisitionView.getReasonForOrdering(driver, testCaseName));
		// requisition.setCommentForSupplier(PageRequisitionView.getCommentsForSupplier(driver,
		// testCaseName));
		requisition.setPurchaseType(PageRequisitionView.getPurchaseType(driver, testCaseName));

		ActionBot.scroll(driver, "500");

		Item items = new Item();
		List<CatelogItem> catelogItems = new ArrayList<CatelogItem>();
		// to get item inform
		// for ( int i = 1 ; i <= noOfItems ; i++ )
		for (int i = 2; i <= noOfItems + 1; i++)
		{
			CatelogItem catelogItem = new CatelogItem();
			catelogItem.setItemName(PageRequisitionView.getItemName(driver, testCaseName, i));
			String[] temp = StringUtils.split(PageRequisitionView.getItemUnitPrice(driver, testCaseName, i), " ");
			catelogItem.setUnitCurrency(temp[0].trim());
			catelogItem.setUnitPrice(Double.parseDouble(CommonUtilities.getDecimalPrice(temp[1].trim())));
			catelogItem.setQuantity(PageRequisitionView.getItemQuantity(driver, testCaseName, i));

			catelogItems.add(catelogItem);
		}
		items.setCatelogItems(catelogItems);

		requisition.setItems(items);

		return requisition;
	}

	public static boolean checkIfInformationOnReqViewPage(Requisition requisition, Requisition viewRequisition)
	{
		boolean flag = false;

		if ((requisition.getReqNo().equalsIgnoreCase(viewRequisition.getReqNo())) && (requisition.getReqName().equalsIgnoreCase(viewRequisition.getReqName()))
			&& (requisition.isRequired() == viewRequisition.isRequired()) && (requisition.getSettlementvia().equalsIgnoreCase(viewRequisition.getSettlementvia()))
			&& (requisition.getReasonForOrdering().equalsIgnoreCase(viewRequisition.getReasonForOrdering()))
			&& (requisition.getPurchaseType().equalsIgnoreCase(viewRequisition.getPurchaseType())))
		{
			flag = true;
		}

		int index = 0;
		for (CatelogItem catelogItem : viewRequisition.getItems().getCatelogItems())
		{
			if ((catelogItem.getItemName().equalsIgnoreCase(requisition.getItems().getCatelogItems().get(index).getItemName()))
				&& (catelogItem.getQuantity() == requisition.getItems().getCatelogItems().get(index).getQuantity()))
			{
				flag = true;
			}
			else
			{
				flag = false;
			}
		}

		return flag;

	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get audit trail info <br>
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
	public static AuditTrail getAuditTrailInfo(WebDriver driver, String testCaseName, int rowNo) throws ActionBotException
	{
		AuditTrail auditTrail = new AuditTrail();
		// to get audit trail info
		auditTrail.setAction(PageRequisitionView.getAuditTrailAction(driver, testCaseName, rowNo));
		auditTrail.setUser(PageRequisitionView.getAuditTrailActor(driver, testCaseName, rowNo));
		auditTrail.setSharedWith(PageRequisitionView.getAuditTrailSharedWith(driver, testCaseName, rowNo));
		auditTrail.setRole(PageRequisitionView.getAuditTrailRole(driver, testCaseName, rowNo));
		auditTrail.setDateTime(PageRequisitionView.getAuditTrailDateTime(driver, testCaseName, rowNo));
		auditTrail.setVersion(PageRequisitionView.getAuditTrailVersion(driver, testCaseName, rowNo));
		auditTrail.setMessage(PageRequisitionView.getAuditTrailMessage(driver, testCaseName, rowNo));

		return auditTrail;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Copy req from req view <br>
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
	public static void copyReq(WebDriver driver, String testCaseName) throws ActionBotException
	{
		PageRequisitionView.clickOnCopyActionsLink(driver, testCaseName);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To compare assigned buyer names <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param multipleAssignedBuyerNamesAsOnViewPage
	 *        </font><b><br>
	 * @param assignedBuyerNames
	 *        </font><b><br>
	 * @return </b> <br>
	 */
	public static boolean compareAssignedBuyers(List<String> multipleAssignedBuyerNamesAsOnViewPage, List<String> assignedBuyerNames)
	{
		boolean flag = false;
		for (String assignedBuyerAsOnViewPage : multipleAssignedBuyerNamesAsOnViewPage)
		{
			System.out.println("@@@@@ assignedBuyerAsOnViewPage : " + assignedBuyerAsOnViewPage);
			for (String assignedBuyer : assignedBuyerNames)
			{
				System.out.println("@@@@@ assignedBuyer : " + assignedBuyer);
				if (assignedBuyer.equalsIgnoreCase(assignedBuyerAsOnViewPage))
				{
					flag = true;
					break;
				}
				else
				{
					flag = false;
				}
				System.out.println("@@@@ Flag : " + flag);
			}
		}
		return flag;
	}

	/**
	 * <b>Author: raj.singh </b> <b><br>
	 * <font color="blue">Method :</b>To verify the presence of audit log in
	 * requisition view <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param multipleAssignedBuyerNamesAsOnViewPage
	 *        </font><b><br>
	 * @param assignedBuyerNames
	 *        </font><b><br>
	 * @return </b> <br>
	 */
	public static boolean isActivityLogPresent(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		Thread.sleep(4000);
		MainPageHeaderLevelTab.clickOnMyRequisitionSubTab(driver);
		FlowMyRequisitions.toFilterOutOrderingReqFromMyRequisitions(driver, testCaseName);
		PageMyRequisition.clickOnFirstReqNo(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
		if (ActionBot.isElementPresent(driver, IPageRequisitionView.AUDIT_TRAIL_MORE_INFO))
			return true;
		else
			return false;
	}

	/**
	 * <b>Author: raj.singh </b> <b><br>
	 * <font color="blue">Method :</b>To fetch business unit and business
	 * location from the view requisition indexwise(item wise) <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param multipleAssignedBuyerNamesAsOnViewPage
	 *        </font><b><br>
	 * @param assignedBuyerNames
	 *        </font><b><br>
	 * @return </b> <br>
	 */
	public static String[] fetchBU_BusinessLocationIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException, InterruptedException
	{
		String businessloc_BusinessUnit[] = new String[2];
		businessloc_BusinessUnit[0] = PageRequisitionView.get_BU_Indexwise(driver, testCaseName, index);
		businessloc_BusinessUnit[1] = PageRequisitionView.get_BusinessLocation_Indexwise(driver, testCaseName, index);
		return businessloc_BusinessUnit;
	}

	/**
	 * <b>Author: raj.singh </b> <b><br>
	 * <font color="blue">Method :</b>To verify the presence of complete info in
	 * audit log in requisition view <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param multipleAssignedBuyerNamesAsOnViewPage
	 *        </font><b><br>
	 * @param assignedBuyerNames
	 *        </font><b><br>
	 * @return </b> <br>
	 */
	public static boolean isCompleteInfoPresentInAuditTrail(WebDriver driver, String testCaseName) throws ActionBotException, InterruptedException
	{
		int count = 0;
		ActionBot.scroll(driver, "400");
		if (ActionBot.isElementDisplayed(driver, IPageRequisitionView.DATETIME_HEADER_AUDIT_TRAIL))
			count++;
		if (ActionBot.isElementDisplayed(driver, IPageRequisitionView.MESSAGE_HEADER_AUDIT_TRAIL))
			count++;
		if (count == 2)
			return true;
		else
			return false;
	}

	/**
	 * <b>Author: raj.singh </b> <b><br>
	 * <font color="blue">Method :</b>To confirm viewing the complete info of
	 * the item index wise in requisition view <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param multipleAssignedBuyerNamesAsOnViewPage
	 *        </font><b><br>
	 * @param assignedBuyerNames
	 *        </font><b><br>
	 * @return </b> <br>
	 */
	public static boolean isCompleteItemInfoPresentIndexwise(WebDriver driver, String testCaseName, int index) throws ActionBotException, InterruptedException
	{
		try
		{
			PageRequisitionView.clickItemDescriptionLinkIndexwise(driver, testCaseName, 1);
			ActionBot.defaultMediumSleep();
			PageSearchListing.clickCloseOnItemPopUp(driver, testCaseName);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	/**
	 * <b>Author: raj.singh </b> <b><br>
	 * <font color="blue">Method :</b>To confirm viewing the item description
	 * index wise is editable <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param multipleAssignedBuyerNamesAsOnViewPage
	 *        </font><b><br>
	 * @param assignedBuyerNames
	 *        </font><b><br>
	 * @return </b> <br>
	 * @throws Exception
	 */
	public static boolean isItemDescriptionIndexwiseEditable(WebDriver driver, String testCaseName, int index) throws Exception
	{
		PageRequisitionCheckOut.clickItemDescriptionLinkIndexwise(driver, testCaseName, 1);
		ActionBot.defaultMediumSleep();
		boolean status = PageRequisitionCheckOut.clickSaveFreeTextButton(driver, testCaseName);
		return status;
	}
}
