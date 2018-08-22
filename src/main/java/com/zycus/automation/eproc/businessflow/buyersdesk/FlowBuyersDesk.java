/**
 * 
 */
package com.zycus.automation.eproc.businessflow.buyersdesk;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.exec.util.StringUtils;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.bo.AttachmentsAndCommentsItemSummary;
import com.zycus.automation.bo.BillingRequisitionSummary;
import com.zycus.automation.bo.BuyersDesk;
import com.zycus.automation.bo.CEform;
import com.zycus.automation.bo.CatelogItem;
import com.zycus.automation.bo.CostBookingItemSummary;
import com.zycus.automation.bo.CostBookingRequisitionSummary;
import com.zycus.automation.bo.CostCenterSplitInfo;
import com.zycus.automation.bo.DeliveryItemSummary;
import com.zycus.automation.bo.DeliveryRequisitionSummary;
import com.zycus.automation.bo.DeliverySplitInfo;
import com.zycus.automation.bo.GuidedItem;
import com.zycus.automation.bo.PunchoutItem;
import com.zycus.automation.bo.PurchaseOrder;
import com.zycus.automation.bo.Requisition;
import com.zycus.automation.bo.SourcingEvent;
import com.zycus.automation.datacreation.ObjectCreation;
import com.zycus.automation.eproc.businessflow.buyersdesklistingflow.FlowBuyersDeskListing;
import com.zycus.automation.eproc.businessflow.createsourcingeventflow.FlowCreateSourcingEvent;
import com.zycus.automation.eproc.businessflow.punchoutflow.FlowPunchout;
import com.zycus.automation.eproc.businessflow.standardpoflow.FlowStandardPo;
import com.zycus.automation.eproc.pageobjects.modals.BuyersItemSummaryAttachment.ModelBuyersItemSummaryAttachment;
import com.zycus.automation.eproc.pageobjects.modals.BuyersItemSummaryCommon.ModelItemBuyersSummaryCommon;
import com.zycus.automation.eproc.pageobjects.modals.BuyersItemSummaryCostBooking.ModelItemBuyersdeskSummaryCostBooking;
import com.zycus.automation.eproc.pageobjects.modals.BuyersItemSummaryDelivery.ModelItemBuyersSummaryDelivery;
import com.zycus.automation.eproc.pageobjects.modals.BuyersRequisitionSummaryBilling.ModelBuyersdeskSummaryBilling;
import com.zycus.automation.eproc.pageobjects.modals.BuyersRequisitionSummaryCostBooking.ModelBuyersdeskSummaryCostBooking;
import com.zycus.automation.eproc.pageobjects.modals.BuyersRequisitionSummaryDelivery.ModelBuyersDeskRequisitionSummaryDelivery;
import com.zycus.automation.eproc.pageobjects.modals.buyersdeskguideditemdetails.ModalBuyersDeskGuidedItemSourcingDetails;
import com.zycus.automation.eproc.pageobjects.modals.checkoutGuidedItemDetails.ModalGuidedItemDetails;
import com.zycus.automation.eproc.pageobjects.pages.BuyersDesk.IPageBuyersDesk;
import com.zycus.automation.eproc.pageobjects.pages.BuyersDesk.IPageBuyersDeskImpl;
import com.zycus.automation.eproc.pageobjects.pages.BuyersDesk.PageBuyersDesk;
import com.zycus.automation.eproc.pageobjects.pages.ConvertedPurchaseOrder.PageConvertedPurchaseOrder;
import com.zycus.automation.eproc.pageobjects.pages.FreeTextItemForm.PageFreeTextForm;
import com.zycus.automation.eproc.pageobjects.pages.approval.PageAllRequestsApproval;
import com.zycus.automation.eproc.pageobjects.pages.cdwpunchout.PageCDWPunchout;
import com.zycus.automation.eproc.pageobjects.pages.onlinestore.PageOnlineStore;
import com.zycus.automation.eproc.pageobjects.pages.purchaseordertobegenerated.IPurchaseOrderToBeGenerated;
import com.zycus.automation.eproc.pageobjects.pages.purchaseordertobegenerated.PagePurchaseOrderToBeGenerated;
import com.zycus.automation.eproc.pageobjects.pages.replaceItem.PageReplaceItem;
import com.zycus.automation.eproc.pageobjects.pages.requisitionCheckOut.PageRequisitionCheckOut;
import com.zycus.automation.eproc.pageobjects.pages.searchlisting.PageSearchListing;
import com.zycus.automation.eproc.pageobjects.pages.standardpo.PageStandardPO;
import com.zycus.automation.eproc.pageobjects.pages.viewpurchaseorder.PageViewPurchaseOrder;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.pageobjects.tabs.checkoutTabItemSummary.TabCheckoutItemSummary;
import com.zycus.automation.eproc.pageobjects.tabs.checkoutTabRequisitionSummary.TabCheckoutReqSummary;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ASyncRequestNotCompletedInSpecifiedTimeException;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.exception.PageloadNotCompletedInSpecifiedTimeException;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.common.CommonUtilities;
import com.zycus.automation.utilities.screenshot.ScreenShot;

/**
 * @author ankita.sawant
 */
public class FlowBuyersDesk
{
	static Logger logger = Logger.getLogger(FlowBuyersDesk.class);

	public static Requisition editRequisitionAtBuyersDesk(WebDriver driver, String testCaseName, Requisition requisition)
		throws ActionBotException, ASyncRequestNotCompletedInSpecifiedTimeException, PageloadNotCompletedInSpecifiedTimeException, FactoryMethodException
	{
		// comments for supplier

		if (requisition.getCommentForSupplier() != null)
		{
			requisition.setCommentForSupplier(PageBuyersDesk.fillCommentsForSupplier(driver, testCaseName, requisition.getCommentForSupplier()));
		}

		// assigned buyer
		if (requisition.getAssignedBuyer() != null)
		{
			requisition.setAssignedBuyer(PageBuyersDesk.fillAssignedBuyer(driver, testCaseName, requisition.getAssignedBuyer()));
		}

		/** Need to change */
		// required by date
		if (requisition.getCustomDate() != null)
		{
			requisition.getCustomDate().setDate(PageRequisitionCheckOut.selectRequiredByDate(driver, testCaseName, requisition.getCustomDate().getDay(),
				requisition.getCustomDate().getMonth(), requisition.getCustomDate().getYear()));
		}

		// edit billing info

		// billing info
		if (requisition.getBillingRequisitionSummary() != null)
		{
			PageBuyersDesk.clickOnBDCLINK(driver, testCaseName);
			TabCheckoutReqSummary.clickBillingTab(driver, testCaseName);
			fillBillingRequisitionSummary(driver, testCaseName, requisition.getBillingRequisitionSummary());
		}

		// delivery info
		if (requisition.getDeliveryRequisitionSummary() != null)
		{
			TabCheckoutReqSummary.clickDeliveryTab(driver, testCaseName);
			fillDelivryRequisitionSummary(driver, testCaseName, requisition.getDeliveryRequisitionSummary());
		}

		// cost booking info
		if (requisition.getCostBookingRequisitionSummary() != null)
		{
			TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
			fillCostBookingRequisitionSummary(driver, testCaseName, requisition.getCostBookingRequisitionSummary());
		}

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300);");
		PageBuyersDesk.clickOnExpandAllLink(driver, testCaseName);
		ActionBot.defaultSleep();

		int catalogItemSize = 0, guidedItemSize = 0;
		if (requisition.getItems() != null)
		{
			if (requisition.getItems().getCatelogItems() != null)
			{
				catalogItemSize = requisition.getItems().getCatelogItems().size();
			}
			if (requisition.getItems().getGuidedItems() != null)
			{
				guidedItemSize = requisition.getItems().getGuidedItems().size();
			}
		}

		// to edit item level info
		// for catalog items
		if (catalogItemSize > 0)
		{
			for (CatelogItem catelogItem : requisition.getItems().getCatelogItems())
			{
				String itemId = catelogItem.getItemID();
				PageBuyersDesk.clickItemCheckbox(driver, testCaseName);
				PageBuyersDesk.clickEditItemSummary(driver, testCaseName, itemId);

				// delivery info
				if (requisition.getDeliveryItemSummary() != null)
				{
					TabCheckoutItemSummary.clickItemSummaryDeliveryTab(driver, testCaseName);
					fillDeliveryItemSummary(driver, testCaseName, requisition.getDeliveryItemSummary(), itemId);
				}

				// cost booking info
				if (requisition.getCostBookingItemSummary() != null)
				{
					TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
					fillCostBookingItemSummary(driver, testCaseName, requisition.getCostBookingItemSummary(), itemId);
				}

				// attachments/comments
				if (requisition.getAttachmentsAndCommentsItemSummary() != null)
				{
					TabCheckoutItemSummary.clickItemSummaryAttachmentTab(driver, testCaseName);
					fillAttachmentsAndComments(driver, testCaseName, requisition.getAttachmentsAndCommentsItemSummary());
				}
			}
		}

		// for guided items
		if (guidedItemSize > 0)
		{
			for (GuidedItem guidedItem : requisition.getItems().getGuidedItems())
			{
				String itemId = guidedItem.getItemID();

				PageBuyersDesk.clickItemCheckbox(driver, testCaseName);

				PageRequisitionCheckOut.clickEditItemSummary(driver, testCaseName, itemId);

				// delivery info
				if (requisition.getDeliveryItemSummary() != null)
				{
					TabCheckoutItemSummary.clickItemSummaryDeliveryTab(driver, testCaseName);
					fillDeliveryItemSummary(driver, testCaseName, requisition.getDeliveryItemSummary(), itemId);
				}

				// cost booking info
				if (requisition.getCostBookingItemSummary() != null)
				{
					TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
					fillCostBookingItemSummary(driver, testCaseName, requisition.getCostBookingItemSummary(), itemId);
				}

				// attachments/comments
				if (requisition.getAttachmentsAndCommentsItemSummary() != null)
				{
					TabCheckoutItemSummary.clickItemSummaryAttachmentTab(driver, testCaseName);
					fillAttachmentsAndComments(driver, testCaseName, requisition.getAttachmentsAndCommentsItemSummary());
				}
			}
		}
		return requisition;

	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To fill billing requisition summary <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param billingRequisitionSummary
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static BillingRequisitionSummary fillBillingRequisitionSummary(WebDriver driver, String testCaseName, BillingRequisitionSummary billingRequisitionSummary)
		throws ActionBotException
	{
		// to fill currency
		if (billingRequisitionSummary.getCurrency() != null)
		{
			billingRequisitionSummary.setCurrency(ModelBuyersdeskSummaryBilling.fillBillingCurrency(driver, testCaseName, billingRequisitionSummary.getCurrency()));
		}

		// to fill company
		if (billingRequisitionSummary.getCompany() != null)
		{
			billingRequisitionSummary.setCompany(ModelBuyersdeskSummaryBilling.fillBillingCompany(driver, testCaseName, billingRequisitionSummary.getCompany()));

			// to check remaining fields are blank or not
			if (ModelBuyersdeskSummaryBilling.getBillingBU(driver, testCaseName).length() == 0)
			{
				billingRequisitionSummary.setBusinessUnit(ModelBuyersdeskSummaryBilling.fillBillingBU(driver, testCaseName, billingRequisitionSummary.getBusinessUnit()));
			}
			if (ModelBuyersdeskSummaryBilling.getBillingLocation(driver, testCaseName).length() == 0)
			{
				billingRequisitionSummary.setLocation(ModelBuyersdeskSummaryBilling.fillBillingLocation(driver, testCaseName, billingRequisitionSummary.getLocation()));
			}
		}

		// to fill BU
		if (billingRequisitionSummary.getBusinessUnit() != null)
		{
			billingRequisitionSummary.setBusinessUnit(ModelBuyersdeskSummaryBilling.fillBillingBU(driver, testCaseName, billingRequisitionSummary.getBusinessUnit()));

			// to check remaining fields are blank or not
			if (ModelBuyersdeskSummaryBilling.getBillingLocation(driver, testCaseName).length() == 0)
			{
				billingRequisitionSummary.setLocation(ModelBuyersdeskSummaryBilling.fillBillingLocation(driver, testCaseName, billingRequisitionSummary.getLocation()));
			}
		}

		// to fill Location
		if (billingRequisitionSummary.getLocation() != null)
		{
			billingRequisitionSummary.setLocation(ModelBuyersdeskSummaryBilling.fillBillingLocation(driver, testCaseName, billingRequisitionSummary.getLocation()));
		}

		// to perform next action
		if (billingRequisitionSummary.getNextAction().equalsIgnoreCase(IConstantsData.SAVE))
		{
			ModelBuyersdeskSummaryBilling.clickOnSaveButton(driver, testCaseName);
		}
		if (billingRequisitionSummary.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			ModelBuyersdeskSummaryBilling.clickOnCancelButton(driver, testCaseName);
		}
		return billingRequisitionSummary;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To fill delivery requisition summary <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param deliveryRequisitionSummary
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static DeliveryRequisitionSummary fillDelivryRequisitionSummary(WebDriver driver, String testCaseName, DeliveryRequisitionSummary deliveryRequisitionSummary)
		throws ActionBotException
	{
		// deliver to
		if (deliveryRequisitionSummary.getDeliverTo() != null)
		{
			deliveryRequisitionSummary
				.setDeliverTo(ModelBuyersDeskRequisitionSummaryDelivery.fillDeliveryDeliverTo(driver, testCaseName, deliveryRequisitionSummary.getDeliverTo()));
		}

		// required by date
		if (deliveryRequisitionSummary.getCustomDate() != null)
		{
			deliveryRequisitionSummary.getCustomDate().setDate(ModelBuyersDeskRequisitionSummaryDelivery.selectRequiredByDate(driver, testCaseName,
				deliveryRequisitionSummary.getCustomDate().getDay(), deliveryRequisitionSummary.getCustomDate().getMonth(), deliveryRequisitionSummary.getCustomDate().getYear()));
		}

		// OU address
		if (deliveryRequisitionSummary.isOUAddressOption())
		{
			ModelBuyersDeskRequisitionSummaryDelivery.selectDeliveryOUAddress(driver, testCaseName);
		}

		// other address
		if (deliveryRequisitionSummary.isOtherAddressesOption())
		{
			ModelBuyersDeskRequisitionSummaryDelivery.selectDeliveryOtherAddress(driver, testCaseName);
			deliveryRequisitionSummary
				.setOtherAddresses(ModelBuyersDeskRequisitionSummaryDelivery.fillDeliveryOtherAddress(driver, testCaseName, deliveryRequisitionSummary.getOtherAddresses()));
		}

		// my address
		if (deliveryRequisitionSummary.isMyAddressOption())
		{
			// select from list
			if (deliveryRequisitionSummary.getSelectDeliveryAddress() != null)
			{
				deliveryRequisitionSummary = selectDeliveryAddressFromList(driver, testCaseName, deliveryRequisitionSummary);
			}
			// create new address
			else
			{
				deliveryRequisitionSummary = createCustomNewDeliveryAddress(driver, testCaseName, deliveryRequisitionSummary);
			}
		}

		// to perform next action
		if (deliveryRequisitionSummary.getNextAction().equalsIgnoreCase(IConstantsData.SAVE))
		{
			ModelBuyersdeskSummaryBilling.clickOnSaveButton(driver, testCaseName);
		}
		if (deliveryRequisitionSummary.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			ModelBuyersdeskSummaryBilling.clickOnCancelButton(driver, testCaseName);
		}
		return deliveryRequisitionSummary;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To fill cost booking requisition summary
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param costBookingRequisitionSummary
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static CostBookingRequisitionSummary fillCostBookingRequisitionSummary(WebDriver driver, String testCaseName,
		CostBookingRequisitionSummary costBookingRequisitionSummary) throws ActionBotException
	{
		// book cost to single cost center
		if (costBookingRequisitionSummary.isBookCostToSingleCostCenter())
		{
			ModelBuyersdeskSummaryCostBooking.selectCostBookingOptionSingleCC(driver, testCaseName);
			costBookingRequisitionSummary
				.setCostCenter(ModelBuyersdeskSummaryCostBooking.fillCostBookingSingleCC(driver, testCaseName, costBookingRequisitionSummary.getCostCenter()));

			costBookingRequisitionSummary.setBudget(ModelBuyersdeskSummaryCostBooking.fillCostBookingSingleBudget(driver, testCaseName, costBookingRequisitionSummary.getBudget()));

			costBookingRequisitionSummary
				.setProject(ModelBuyersdeskSummaryCostBooking.fillCostBookingSingleProject(driver, testCaseName, costBookingRequisitionSummary.getProject()));
		}

		// book cost to multiple cost center at header level
		if (costBookingRequisitionSummary.isSplitCostToMultipleCostCenter())
		{
			ModelBuyersdeskSummaryCostBooking.selectCostBookingOptionMultipleCC(driver, testCaseName);

			costBookingRequisitionSummary
				.setListOfSplitedCostCenters(splitCostCenterAtHeaderLevel(driver, testCaseName, costBookingRequisitionSummary.getListOfSplitedCostCenters()));
		}

		// split cost at line item level
		if (costBookingRequisitionSummary.isSplitCostAtLineItemLevel())
		{
			ModelBuyersdeskSummaryCostBooking.selectCostBookingOptionLineItemCC(driver, testCaseName);
		}

		// to perform next action
		if (costBookingRequisitionSummary.getNextAction().equalsIgnoreCase(IConstantsData.SAVE))
		{
			ModelBuyersdeskSummaryBilling.clickOnSaveButton(driver, testCaseName);
		}
		if (costBookingRequisitionSummary.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			ModelBuyersdeskSummaryBilling.clickOnCancelButton(driver, testCaseName);
		}
		return costBookingRequisitionSummary;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To fill delivery item summary <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param deliveryItemSummary
	 *        </font><b><br>
	 * @param itemId
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static DeliveryItemSummary fillDeliveryItemSummary(WebDriver driver, String testCaseName, DeliveryItemSummary deliveryItemSummary, String itemId)
		throws ActionBotException
	{
		// single split
		if (deliveryItemSummary.isUseDeliveryInfoFromReqSummary())
		{
			ModelItemBuyersSummaryDelivery.selectDeliveryOptionSingleSplit(driver, testCaseName);
		}

		// multiple split
		if (deliveryItemSummary.isSplitDeliveryToMultipleLocations())
		{
			ModelItemBuyersSummaryDelivery.selectDeliveryOptionMultiSplit(driver, testCaseName);
			deliveryItemSummary.setDeliverySplitInfo(splitDeliveryLocationsToMultiple(driver, testCaseName, deliveryItemSummary.getDeliverySplitInfo(), itemId));
		}

		// to perform next action
		if (deliveryItemSummary.getNextAction().equalsIgnoreCase(IConstantsData.SAVE))
		{
			ModelItemBuyersSummaryCommon.clickItemSummarySave(driver, testCaseName);
		}
		if (deliveryItemSummary.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			ModelItemBuyersSummaryCommon.clickItemSummaryCancle(driver, testCaseName);
		}

		return deliveryItemSummary;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To fill cost booking item summary <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param costBookingItemSummary
	 *        </font><b><br>
	 * @param itemId
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static CostBookingItemSummary fillCostBookingItemSummary(WebDriver driver, String testCaseName, CostBookingItemSummary costBookingItemSummary, String itemId)
		throws ActionBotException
	{
		// changed as per accounting-cost booking merging feature
		costBookingItemSummary.getAccountingItemSummary().setGlAccount(
			ModelItemBuyersdeskSummaryCostBooking.fillAccountingGLAccount(driver, testCaseName, costBookingItemSummary.getAccountingItemSummary().getGlAccount(), itemId, 0));

		if (costBookingItemSummary.isSplitCostCenterAtItemLevel())
		{
			ModelItemBuyersdeskSummaryCostBooking.selectCostBookingOptionMultiSplit(driver, testCaseName);
			if (costBookingItemSummary.isSplitCostCenterAtItemLevel_percentage())
			{
				ModelItemBuyersdeskSummaryCostBooking.selectCostBookingOptionItemSplitPercent(driver, testCaseName);
			}
			if (costBookingItemSummary.isSplitCostCenterAtItemLevel_quantity())
			{
				ModelItemBuyersdeskSummaryCostBooking.selectCostBookingOptionItemSplitQuantity(driver, testCaseName);
			}

			costBookingItemSummary.setCostCenterSplitInfo(splitCostCenterAtItemLevel(driver, testCaseName, costBookingItemSummary.getCostCenterSplitInfo(), itemId));
		}
		// to perform next action
		if (costBookingItemSummary.getNextAction().equalsIgnoreCase(IConstantsData.SAVE))
		{
			ModelItemBuyersSummaryCommon.clickItemSummarySave(driver, testCaseName);
		}
		if (costBookingItemSummary.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			ModelItemBuyersSummaryCommon.clickItemSummaryCancle(driver, testCaseName);
		}

		return costBookingItemSummary;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To fill attachments and comments <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param attachmentsAndCommentsItemSummary
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static AttachmentsAndCommentsItemSummary fillAttachmentsAndComments(WebDriver driver, String testCaseName,
		AttachmentsAndCommentsItemSummary attachmentsAndCommentsItemSummary) throws ActionBotException
	{
		if (attachmentsAndCommentsItemSummary.getInternalComments() != null)
		{
			attachmentsAndCommentsItemSummary
				.setInternalComments(ModelBuyersItemSummaryAttachment.fillAttachmentInternalComment(driver, testCaseName, attachmentsAndCommentsItemSummary.getInternalComments()));
		}
		if (attachmentsAndCommentsItemSummary.getCommentsForSupplier() != null)
		{
			attachmentsAndCommentsItemSummary.setCommentsForSupplier(
				ModelBuyersItemSummaryAttachment.fillAttachmentSupplierlComment(driver, testCaseName, attachmentsAndCommentsItemSummary.getCommentsForSupplier()));
		}
		// to perform next action
		if (attachmentsAndCommentsItemSummary.getNextAction().equalsIgnoreCase(IConstantsData.SAVE))
		{
			ModelItemBuyersSummaryCommon.clickItemSummarySave(driver, testCaseName);
		}
		if (attachmentsAndCommentsItemSummary.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			ModelItemBuyersSummaryCommon.clickItemSummaryCancle(driver, testCaseName);
		}

		return attachmentsAndCommentsItemSummary;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> To select my address from list <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param deliveryRequisitionSummary
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static DeliveryRequisitionSummary selectDeliveryAddressFromList(WebDriver driver, String testCaseName, DeliveryRequisitionSummary deliveryRequisitionSummary)
		throws ActionBotException
	{
		deliveryRequisitionSummary
			.setSelectDeliveryAddress(ModelBuyersDeskRequisitionSummaryDelivery.fillDeliveryMyAddress(driver, testCaseName, deliveryRequisitionSummary.getSelectDeliveryAddress()));
		return deliveryRequisitionSummary;

	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To create new delivery address <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param deliveryRequisitionSummary
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static DeliveryRequisitionSummary createCustomNewDeliveryAddress(WebDriver driver, String testCaseName, DeliveryRequisitionSummary deliveryRequisitionSummary)
		throws ActionBotException
	{
		ModelBuyersDeskRequisitionSummaryDelivery.clickDeliveryCreateNewAddress(driver, testCaseName);

		if (deliveryRequisitionSummary.getMyAddress_Name() != null)
		{
			deliveryRequisitionSummary
				.setMyAddress_Name(ModelBuyersDeskRequisitionSummaryDelivery.fillDeliveryNewAddressName(driver, testCaseName, deliveryRequisitionSummary.getMyAddress_Name()));
		}
		if (deliveryRequisitionSummary.getMyAddress_Street1() != null)
		{
			deliveryRequisitionSummary.setMyAddress_Street1(
				ModelBuyersDeskRequisitionSummaryDelivery.fillDeliveryNewAddressStreet1(driver, testCaseName, deliveryRequisitionSummary.getMyAddress_Street1()));
		}
		if (deliveryRequisitionSummary.getMyAddress_Street2() != null)
		{
			deliveryRequisitionSummary.setMyAddress_Street2(
				ModelBuyersDeskRequisitionSummaryDelivery.fillDeliveryNewAddressStreet2(driver, testCaseName, deliveryRequisitionSummary.getMyAddress_Street2()));
		}
		if (deliveryRequisitionSummary.getMyAddress_country() != null)
		{
			deliveryRequisitionSummary.setMyAddress_country(
				ModelBuyersDeskRequisitionSummaryDelivery.fillDeliveryNewAddressCountry(driver, testCaseName, deliveryRequisitionSummary.getMyAddress_country()));
		}
		if (deliveryRequisitionSummary.getMyAddress_state() != null)
		{
			deliveryRequisitionSummary
				.setMyAddress_state(ModelBuyersDeskRequisitionSummaryDelivery.fillDeliveryNewAddressState(driver, testCaseName, deliveryRequisitionSummary.getMyAddress_state()));
		}
		if (deliveryRequisitionSummary.getMyAddress_city() != null)
		{
			deliveryRequisitionSummary
				.setMyAddress_city(ModelBuyersDeskRequisitionSummaryDelivery.fillDeliveryNewAddressCity(driver, testCaseName, deliveryRequisitionSummary.getMyAddress_city()));
		}
		if (deliveryRequisitionSummary.getMyAddress_zip() != 0)
		{
			deliveryRequisitionSummary
				.setMyAddress_zip(ModelBuyersDeskRequisitionSummaryDelivery.fillDeliveryNewAddressZip(driver, testCaseName, deliveryRequisitionSummary.getMyAddress_zip()));
		}

		return deliveryRequisitionSummary;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Split cost center info at header level
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param listOfSplitedCostCenters
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static List<CostCenterSplitInfo> splitCostCenterAtHeaderLevel(WebDriver driver, String testCaseName, List<CostCenterSplitInfo> listOfSplitedCostCenters)
		throws ActionBotException
	{
		int index = 0, i = 1;
		List<CostCenterSplitInfo> costCenterSplitInfos = new ArrayList<CostCenterSplitInfo>();
		for (CostCenterSplitInfo costCenterSplitInfo : listOfSplitedCostCenters)
		{
			// cost center
			costCenterSplitInfo.setCostCenter(ModelBuyersdeskSummaryCostBooking.fillMultiCostCenterName(driver, testCaseName, costCenterSplitInfo.getCostCenter(), index));

			// budget
			costCenterSplitInfo.setBudget(ModelBuyersdeskSummaryCostBooking.fillMultiCostCenterBudget(driver, testCaseName, costCenterSplitInfo.getBudget(), index));

			// percentage
			costCenterSplitInfo.setPercentage(ModelBuyersdeskSummaryCostBooking.fillMultiCostCenterPercent(driver, testCaseName, costCenterSplitInfo.getPercentage(), index));

			// to add another cc
			if (i <= (listOfSplitedCostCenters.size() - 1))
			{
				ModelBuyersdeskSummaryCostBooking.clickMultiAddCostCenter(driver, testCaseName, index);
			}
			i++;
			index++;
			costCenterSplitInfos.add(costCenterSplitInfo);
		}

		return costCenterSplitInfos;

	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Split delivery location to multiple at
	 * item level <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param listOfSplitedCostCenters
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static List<DeliverySplitInfo> splitDeliveryLocationsToMultiple(WebDriver driver, String testCaseName, List<DeliverySplitInfo> listOfSplitedDeliveryLocations,
		String itemId) throws ActionBotException
	{
		int index = 0, i = 1;
		List<DeliverySplitInfo> deliverySplitInfos = new ArrayList<DeliverySplitInfo>();
		for (DeliverySplitInfo deliverySplitInfo : listOfSplitedDeliveryLocations)
		{
			if (deliverySplitInfo.getDeliveryAddress() != null)
			{
				ModelItemBuyersSummaryDelivery.fillDeliveryMultiSplitAddress(driver, testCaseName, deliverySplitInfo.getDeliveryAddress(), itemId, index);
			}

			// code for required by date

			if (deliverySplitInfo.getQuantity() != 0)
			{
				deliverySplitInfo.setQuantity(ModelItemBuyersSummaryDelivery.fillDeliveryMultiSplitQuantity(driver, testCaseName, deliverySplitInfo.getQuantity(), itemId, index));
			}

			// to add another delivery location
			if (i <= (listOfSplitedDeliveryLocations.size() - 1))
			{
				ModelItemBuyersSummaryDelivery.clickDeliveryAddMultiSplit(driver, testCaseName, itemId, index);
			}
			i++;
			index++;
			deliverySplitInfos.add(deliverySplitInfo);
		}

		return deliverySplitInfos;

	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Split cost center info at item level <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param listOfSplitedCostCenters
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static List<CostCenterSplitInfo> splitCostCenterAtItemLevel(WebDriver driver, String testCaseName, List<CostCenterSplitInfo> listOfSplitedCostCenters, String itemId)
		throws ActionBotException
	{
		int index = 0, i = 1;
		List<CostCenterSplitInfo> costCenterSplitInfos = new ArrayList<CostCenterSplitInfo>();
		for (CostCenterSplitInfo costCenterSplitInfo : listOfSplitedCostCenters)
		{
			// cost center
			costCenterSplitInfo
				.setCostCenter(ModelItemBuyersdeskSummaryCostBooking.fillCostBookingItemSplitCostCenter(driver, testCaseName, costCenterSplitInfo.getCostCenter(), itemId, index));

			// budget
			if (costCenterSplitInfo.getBudget() != null)
			{
				costCenterSplitInfo
					.setBudget(ModelItemBuyersdeskSummaryCostBooking.fillCostBookingItemSplitBudget(driver, testCaseName, costCenterSplitInfo.getBudget(), itemId, index));
			}

			// percentage
			if (costCenterSplitInfo.getPercentage() != 0)
			{
				costCenterSplitInfo.setPercentage(
					ModelItemBuyersdeskSummaryCostBooking.fillCostBookingItemSplitPercentage(driver, testCaseName, costCenterSplitInfo.getPercentage(), itemId, index));
			}

			// quantity
			if (costCenterSplitInfo.getQuantity() != 0)
			{
				costCenterSplitInfo
					.setQuantity(ModelItemBuyersdeskSummaryCostBooking.fillCostBookingItemSplitQuantity(driver, testCaseName, costCenterSplitInfo.getQuantity(), itemId, index));
			}

			// to add another cc
			if (i <= (listOfSplitedCostCenters.size() - 1))
			{
				ModelItemBuyersdeskSummaryCostBooking.clickCostBookingItemSplitAdd(driver, testCaseName, itemId, index);
			}
			i++;
			index++;
			costCenterSplitInfos.add(costCenterSplitInfo);
		}

		return costCenterSplitInfos;

	}

	public static void saveRequisitionFromBuyersDesk(WebDriver driver, String testCaseName) throws ActionBotException
	{
		PageBuyersDesk.clickOnSave(driver, testCaseName);
		PageBuyersDesk.waitTillUpdateProcessingDivIsPresent(driver, testCaseName);
	}

	public static void convertToPo(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{

		PageBuyersDesk.clickItemCheckbox(driver, testCaseName);

		PageBuyersDesk.fillReqChangeComment(driver, testCaseName, IConstantsData.CONVERT_TO_PO_COMMENT);

		PageBuyersDesk.clickOnConvertToPo(driver, testCaseName);
		PageBuyersDesk.waitTillUpdateProcessingDivIsPresent(driver, testCaseName);
		if (!PagePurchaseOrderToBeGenerated.isSubmitPOForProcessingPresent(driver, testCaseName))
		{
			ActionBot.defaultSleep();
		}
		ScreenShot.screenshot(driver, testCaseName, "After converting to po");
		// ActionBot.waitForPageLoad(driver);
	}

	public static void convertToPo(WebDriver driver, String testCaseName, List<String> itemIds) throws ActionBotException, FactoryMethodException
	{
		ActionBot.scroll(driver, "500");
		for (String itemId : itemIds)
		{
			PageBuyersDesk.clickOnSelectItemToUncheck(driver, testCaseName, itemId);
		}
		PageBuyersDesk.fillReqChangeComment(driver, testCaseName, IConstantsData.CONVERT_TO_PO_COMMENT);
		PageBuyersDesk.clickOnConvertToPo(driver, testCaseName);
		PageBuyersDesk.waitTillUpdateProcessingDivIsPresent(driver, testCaseName);
		ScreenShot.screenshot(driver, testCaseName, "After converting to po");
	}

	public static boolean checkIfRequisitionEditedAtBuyersDesk(WebDriver driver, String testCaseName, Requisition requisition) throws ActionBotException
	{
		boolean flag = false;
		String log = "";
		/*
		 * //comments for supplier if (requisition.getCommentForSupplier() !=
		 * null) { flag = requisition.getCommentForSupplier().equalsIgnoreCase(
		 * PageBuyersDesk.getCommentsForSupplier(driver, testCaseName)); if
		 * (!flag) { log += "Comment for supplier is not edited \n"; } }
		 */

		// assigned buyer
		if (requisition.getAssignedBuyer() != null)
		{
			flag = requisition.getAssignedBuyer().equalsIgnoreCase(PageBuyersDesk.getAssignedBuyer(driver, testCaseName));
			if (!flag)
			{
				log += "Assigned buyer is not edited \n";
			}
		}

		/** Need to change */
		// required by date
		if (requisition.getCustomDate() != null)
		{
			flag = requisition.getAssignedBuyer().equalsIgnoreCase(PageBuyersDesk.getAssignedBuyer(driver, testCaseName));
			if (!flag)
			{
				log += "Assigned buyer is not edited \n";
			}
		}

		// edit billing info

		// billing info
		if (requisition.getBillingRequisitionSummary() != null)
		{
			PageBuyersDesk.clickOnBDCLINK(driver, testCaseName);
			TabCheckoutReqSummary.clickBillingTab(driver, testCaseName);
			if (requisition.getBillingRequisitionSummary().getCompany() != null)
			{
				flag = requisition.getBillingRequisitionSummary().getCompany().equalsIgnoreCase(ModelBuyersdeskSummaryBilling.getBillingCompany(driver, testCaseName));
				if (!flag)
				{
					log += "Company is not edited \n";
				}
			}
			if (requisition.getBillingRequisitionSummary().getLocation() != null)
			{
				flag = requisition.getBillingRequisitionSummary().getLocation().equalsIgnoreCase(ModelBuyersdeskSummaryBilling.getBillingLocation(driver, testCaseName));
				if (!flag)
				{
					log += "Location is not edited \n";
				}
			}
			if (requisition.getBillingRequisitionSummary().getBusinessUnit() != null)
			{
				flag = requisition.getBillingRequisitionSummary().getBusinessUnit().equalsIgnoreCase(ModelBuyersdeskSummaryBilling.getBillingBU(driver, testCaseName));
				if (!flag)
				{
					log += "Business Unit is not edited \n";
				}
			}
		}

		/** need to change **/

		/*
		 * //delivery info if (requisition.getDeliveryRequisitionSummary() !=
		 * null) { TabCheckoutReqSummary.clickDeliveryTab(driver, testCaseName);
		 * fillDelivryRequisitionSummary(driver, testCaseName,
		 * requisition.getDeliveryRequisitionSummary()); } //cost booking info
		 * if (requisition.getCostBookingRequisitionSummary() != null) {
		 * TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
		 * fillCostBookingRequisitionSummary(driver, testCaseName,
		 * requisition.getCostBookingRequisitionSummary()); }
		 * ((JavascriptExecutor)
		 * driver).executeScript("window.scrollBy(0,300);");
		 * PageBuyersDesk.clickOnExpandAllLink(driver, testCaseName); //to edit
		 * item level info if (requisition.getItems() != null) { if
		 * (requisition.getItems().getCatelogItems() != null) {
		 * requisition.getItems().getCatelogItems().size(); } if
		 * (requisition.getItems().getGuidedItems() != null) {
		 * requisition.getItems().getGuidedItems().size(); } } //for catalog
		 * items for (CatelogItem catelogItem :
		 * requisition.getItems().getCatelogItems()) { String itemId =
		 * catelogItem.getItemID(); PageBuyersDesk.clickEditItemSummary(driver,
		 * testCaseName, itemId); //delivery info if
		 * (requisition.getDeliveryItemSummary() != null) {
		 * TabCheckoutItemSummary.clickItemSummaryDeliveryTab(driver,
		 * testCaseName); fillDeliveryItemSummary(driver, testCaseName,
		 * requisition.getDeliveryItemSummary(), itemId); } //cost booking info
		 * if (requisition.getCostBookingItemSummary() != null) {
		 * TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver,
		 * testCaseName); fillCostBookingItemSummary(driver, testCaseName,
		 * requisition.getCostBookingItemSummary(), itemId); } //accounting info
		 * if (requisition.getAccountingItemSummary() != null) {
		 * TabCheckoutItemSummary.clickItemSummaryAccountingTab(driver,
		 * testCaseName); fillAccountingInfo(driver, testCaseName,
		 * requisition.getAccountingItemSummary(), itemId); }
		 * //attachments/comments if
		 * (requisition.getAttachmentsAndCommentsItemSummary() != null) {
		 * TabCheckoutItemSummary.clickItemSummaryAttachmentTab(driver,
		 * testCaseName); fillAttachmentsAndComments(driver, testCaseName,
		 * requisition.getAttachmentsAndCommentsItemSummary()); } } //for guided
		 * items for (GuidedItem guidedItem :
		 * requisition.getItems().getGuidedItems()) { String itemId =
		 * guidedItem.getItemID();
		 * PageRequisitionCheckOut.clickEditItemSummary(driver, testCaseName,
		 * itemId); //delivery info if (requisition.getDeliveryItemSummary() !=
		 * null) { TabCheckoutItemSummary.clickItemSummaryDeliveryTab(driver,
		 * testCaseName); fillDeliveryItemSummary(driver, testCaseName,
		 * requisition.getDeliveryItemSummary(), itemId); } //cost booking info
		 * if (requisition.getCostBookingItemSummary() != null) {
		 * TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver,
		 * testCaseName); fillCostBookingItemSummary(driver, testCaseName,
		 * requisition.getCostBookingItemSummary(), itemId); } //accounting info
		 * if (requisition.getAccountingItemSummary() != null) {
		 * TabCheckoutItemSummary.clickItemSummaryAccountingTab(driver,
		 * testCaseName); fillAccountingInfo(driver, testCaseName,
		 * requisition.getAccountingItemSummary(), itemId); }
		 * //attachments/comments if
		 * (requisition.getAttachmentsAndCommentsItemSummary() != null) {
		 * TabCheckoutItemSummary.clickItemSummaryAttachmentTab(driver,
		 * testCaseName); fillAttachmentsAndComments(driver, testCaseName,
		 * requisition.getAttachmentsAndCommentsItemSummary()); } }
		 */logger.info(log);
		return flag;
	}

	public static boolean checkSuggestedPOInfo(WebDriver driver, String testCaseName, Requisition requisition) throws ActionBotException
	{
		List<String> itemNames = new ArrayList<String>();
		if (requisition.getItems().getCatelogItems() != null)
		{
			List<CatelogItem> catalogItemList = requisition.getItems().getCatelogItems();
			for (CatelogItem catelogItem : catalogItemList)
			{
				itemNames.add(catelogItem.getItemName());
			}
		}
		if (requisition.getItems().getGuidedItems() != null)
		{
			List<GuidedItem> guidedItemList = requisition.getItems().getGuidedItems();
			for (GuidedItem guidedItem : guidedItemList)
			{
				itemNames.add(guidedItem.getShortDescription());
			}
		}

		int totalCount = itemNames.size(), count = 0;
		for (String str : itemNames)
		{
			for (String str1 : PagePurchaseOrderToBeGenerated.getListOfItems(driver, testCaseName))
			{
				if (str.equalsIgnoreCase(str1))
				{
					count++;
				}
			}
		}

		if (count >= totalCount)
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	public static List<PurchaseOrder> submitAllSuggestedPosForProcessing(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> listOfCheckBoxes = PagePurchaseOrderToBeGenerated.getListOfAllSuggestedPOCheckboxes(driver, testCaseName);
		for (WebElement element : listOfCheckBoxes)
		{
			if (!element.isSelected())
			{
				element.click();
			}
		}

		PagePurchaseOrderToBeGenerated.clickOnSubmitPoForProcessing(driver, testCaseName);
		ActionBot.defaultSleep();
		ActionBot.waitForPageLoad(driver);
		List<PurchaseOrder> listOfPOs = new ArrayList<PurchaseOrder>();
		int i = 1;
		List<WebElement> list = PageConvertedPurchaseOrder.getListOfPurchaseOrderGenerated(driver, testCaseName);
		for (WebElement element : list)
		{
			PurchaseOrder purchaseOrder = new PurchaseOrder();
			purchaseOrder.setPoNo(element.getText().trim());
			purchaseOrder.setSupplierName(PageConvertedPurchaseOrder.getPurchaseOrderSupplier(driver, testCaseName, i));
			purchaseOrder.setBUName(PageConvertedPurchaseOrder.getPurchaseOrderBu(driver, testCaseName, i));
			purchaseOrder.setDeliveryDate(PageConvertedPurchaseOrder.getPurchaseOrderDeliverydate(driver, testCaseName, i));
			purchaseOrder.setPoTotal(PageConvertedPurchaseOrder.getPurchaseOrderPoTotal(driver, testCaseName, i));
			purchaseOrder.setReqNo(PageConvertedPurchaseOrder.getPurchaseOrderReqNo(driver, testCaseName, i));
			listOfPOs.add(purchaseOrder);
			i = i + 1;
		}
		ScreenShot.screenshot(driver, testCaseName, "Submit Suggested POs");
		return listOfPOs;
	}

	/**
	 * <b>Author: priyanka.jadhav </b> <b><br>
	 * <font color="blue">Method :</b> To save PO and continue <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param deliveryRequisitionSummary
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static PurchaseOrder savePOAndContinue(WebDriver driver, String testCaseName, PurchaseOrder purchaseOrder)
		throws ActionBotException, FactoryMethodException, com.zycus.zsn.automation.exception.ActionBotException
	{
		List<WebElement> listOfCheckBoxes = PagePurchaseOrderToBeGenerated.getListOfAllSuggestedPOCheckboxes(driver, testCaseName);
		for (WebElement element : listOfCheckBoxes)
		{
			if (!element.isSelected())
			{
				element.click();
				break;
			}
		}

		PagePurchaseOrderToBeGenerated.clickOnSavePoAndContinue(driver, testCaseName);
		purchaseOrder = FlowStandardPo.fillFurtherDetails(driver, testCaseName, purchaseOrder);

		PagePurchaseOrderToBeGenerated.clickOnSubmitPoForProcessing(driver, testCaseName);
		PageStandardPO.clickOnSubmitPOForApproval(driver, testCaseName);

		// wait till processing bar is present
		ActionBot.waitTillPopUpIsPresent(driver, IPurchaseOrderToBeGenerated.STATUS_PROCESS);
		purchaseOrder.setPoNo(PageViewPurchaseOrder.getPONo(driver, testCaseName));

		return purchaseOrder;
	}

	/**
	 * <b>Author: priyanka.jadhav </b> <b><br>
	 * <font color="blue">Method :</b> To save PO as draft <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param deliveryRequisitionSummary
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static void saveAllSuggestedPosAsDraft(WebDriver driver, String testCaseName) throws ActionBotException
	{
		boolean flag = false;

		List<WebElement> listOfCheckBoxes = PagePurchaseOrderToBeGenerated.getListOfAllSuggestedPOCheckboxes(driver, testCaseName);
		for (WebElement element : listOfCheckBoxes)
		{
			if (!element.isSelected())
			{
				element.click();
			}
		}

		PagePurchaseOrderToBeGenerated.clickOnSavePosAsDraft(driver, testCaseName);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To remove assigned buyer and new assign
	 * buyer <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param assignedBuyerToBeRemoved
	 *        </font><b><br>
	 * @param newAssignedBuyer
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </font><b><br>
	 * @throws FactoryMethodException
	 *         </b> <br>
	 */
	public static boolean removeAndChangeAssignedBuyer(WebDriver driver, String testCaseName, String assignedBuyerToBeRemoved, String newAssignedBuyer)
		throws ActionBotException, FactoryMethodException
	{
		boolean flag = false;
		String assignedBuyerName = null;
		// remove assigned buyer
		PageBuyersDesk.clickOnRemoveBuyerLink(driver, testCaseName);

		// assign buyer
		PageBuyersDesk.fillAssignedBuyer(driver, testCaseName, newAssignedBuyer);

		assignedBuyerName = PageBuyersDesk.getAssignedBuyerName(driver, testCaseName);

		System.out.println("New Assign Buyer : " + newAssignedBuyer);
		System.out.println("Assigned Buyer : " + assignedBuyerName);
		flag = assignedBuyerName.equalsIgnoreCase(newAssignedBuyer);
		return flag;

	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To edit guided item details <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param guidedItem
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </font><b><br>
	 * @throws FactoryMethodException
	 *         </b> <br>
	 */
	public static GuidedItem editGuidedItemDetailsatBuyersDesk(WebDriver driver, String testCaseName, GuidedItem guidedItem) throws ActionBotException, FactoryMethodException
	{
		// edit sourcing status
		if (guidedItem.getSourcingStatus() != null)
		{
			if (guidedItem.getSourcingStatus().equalsIgnoreCase(IConstantsData.Estimated_price))
			{
				ModalGuidedItemDetails.clickOnSourcingStatusEstimatedPrice(driver, testCaseName);
			}
			else if (guidedItem.getSourcingStatus().equalsIgnoreCase(IConstantsData.Quoted_by_supplier))
			{
				ModalGuidedItemDetails.clickOnSourcingStatusQuotedBySupplierRadioButton(driver, testCaseName);
			}
			else if (guidedItem.getSourcingStatus().equalsIgnoreCase(IConstantsData.Need_a_Quote))
			{
				ModalGuidedItemDetails.clickOnSourcingStatusNeedAQuoteOnBuyersDesk(driver, testCaseName);
			}
			else if (guidedItem.getSourcingStatus().equalsIgnoreCase(IConstantsData.BUYER_NEGOTIATED_PRICE))
			{
				ModalGuidedItemDetails.clickOnSourcingStatusBuyerNegotiatedPriceOnBuyersDesk(driver, testCaseName);
			}
		}

		// price
		if (guidedItem.getPrice() != 0)
		{
			guidedItem.setPrice(ModalGuidedItemDetails.fillPrice(driver, testCaseName, guidedItem.getPrice()));
		}

		ModalGuidedItemDetails.clickOnSupplierDetailsTab(driver, testCaseName);

		if (guidedItem.getSupplierType() != null)
		{

			if (guidedItem.getSupplierType().equalsIgnoreCase(IConstantsData.EXISTING_SUPPLIER))
			{

				PageFreeTextForm.clickPlaceOrderWithExistingSupplier(driver, testCaseName);

				if (guidedItem.getSupplierNameInSuppInfo() != null)
				{
					String nameOfSupplier = PageFreeTextForm.fillsupplierNameInSuppInfo(driver, testCaseName, guidedItem.getSupplierNameInSuppInfo());
					guidedItem.setSupplierNameInSuppInfo(nameOfSupplier);
				}

				// supplier address
				String addInSuppInfo = PageFreeTextForm.filladdressInSuppInfo(driver, testCaseName, null);
				guidedItem.setAddressInSuppInfo(addInSuppInfo);

				// contract no
				if (guidedItem.getContractNoInSuppInfo() != null)
				{
					String contractInSuppInfo = PageFreeTextForm.fillcontractNoInSuppInfo(driver, testCaseName, guidedItem.getContractNoInSuppInfo());

					guidedItem.setContractNoInSuppInfo(contractInSuppInfo);
				}
			}

			if (guidedItem.getSupplierType().equalsIgnoreCase(IConstantsData.SUGGEST_EXISTING_SUPPLIER))

			{
				ModalGuidedItemDetails.clickOnSelectOnSupplierDetailsTab(driver, testCaseName);
			}
			else if (guidedItem.getSupplierType().equalsIgnoreCase(IConstantsData.SUGGEST_NEW_SUPPLIER))
			{
				ModalGuidedItemDetails.clickOnSystemSuggestedSupplierOnSupplierDetailsTab(driver, testCaseName);
				ModalGuidedItemDetails.clickOnSelectOnSupplierDetailsTab(driver, testCaseName);
			}
		}
		// next action
		if (guidedItem.getNextAction().equalsIgnoreCase(IConstantsData.SAVE))
		{
			ModalGuidedItemDetails.clickOnOkButton(driver, testCaseName);
			// confirmation pop up for changing sourcing status from need a
			// quote to other
			if (PopUpDefaultConfirmation.isConfirmYesButtonPresent(driver, testCaseName))
			{
				PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
			}
		}

		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
		return guidedItem;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To send req for approval <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 * @throws FactoryMethodException
	 */
	public static void sendReqForApproval(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		PageBuyersDesk.clickOnSendForApproval(driver, testCaseName);
	}

	public static void changeCurrencyOfRequisition(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		PageBuyersDesk.clickOnBDCLINK(driver, testCaseName);
		String currency = ModelBuyersdeskSummaryBilling.getRequisitionCurrency(driver, testCaseName);
		if (currency.equalsIgnoreCase("INR"))
		{
			ModelBuyersdeskSummaryBilling.fillBillingCurrency(driver, testCaseName, "USD");

		}
		else
		{
			if (currency.equals("USD"))
			{
				ModelBuyersdeskSummaryBilling.fillBillingCurrency(driver, testCaseName, "INR");
			}
		}
		ModelBuyersdeskSummaryBilling.clickOnSaveButton(driver, testCaseName);
	}

	public static void checkImpactAfterCurrencyChangeAtBuyersDesk(WebDriver driver, String testCaseName, String price, String itemPrice, String itemId)
		throws ActionBotException, FactoryMethodException
	{
		// get header level price after changing currency
		String price1 = PageBuyersDesk.getHeaderTotalPrice(driver, testCaseName);
		if (price1.contains(" "))
		{
			String[] str = StringUtils.split(price, " ");
			price1 = "";
			price1 = str[0].trim();

		}
		// check the changed currency at header level
		boolean flag1 = !price1.equalsIgnoreCase(price) ? true : false;
		Assert.assertTrue("Price has not changed at header level after changing currency", flag1);

		PageBuyersDesk.clickOnExpandAllLink(driver, testCaseName);

		// get item level price after changing currency
		String itemPrice1 = PageBuyersDesk.getItemLevelSubTotalPrice(driver, testCaseName, itemId);
		if (itemPrice1.contains(" "))
		{
			String[] str1 = StringUtils.split(itemPrice, " ");
			itemPrice1 = "";
			itemPrice1 = str1[0].trim();
		}

		// check the changed currency at item level
		boolean flag2 = !itemPrice1.equalsIgnoreCase(itemPrice) ? true : false;
		Assert.assertTrue("Price has not changed at item level after changing currency", flag2);

	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Return req with quote <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @throws ActionBotException
	 *         </font><b><br>
	 * @throws FactoryMethodException
	 *         </b> <br>
	 */
	public static void returnReqWithQuote(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		PageBuyersDesk.fillReqChangeComment(driver, testCaseName, IConstantsData.REC_CHANGE_COMM);
		PageBuyersDesk.clickOnReturnToRequester(driver, testCaseName);
		if (PopUpDefaultConfirmation.isConfirmYesButtonPresent(driver, testCaseName))
		{
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Create sourcing event <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param event
	 *        </font><b><br>
	 * @return </b> <br>
	 * @throws FactoryMethodException
	 * @throws ActionBotException
	 */
	public static SourcingEvent createSourcingEvent(WebDriver driver, String testCaseName, SourcingEvent sourcingEvent) throws ActionBotException, FactoryMethodException
	{
		PageBuyersDesk.clickOnCreateSourcingEventButton(driver, testCaseName);
		// fill event details
		FlowCreateSourcingEvent.createSourcingEvent(driver, testCaseName, sourcingEvent);

		if (sourcingEvent.getNextActionAfterCreatingSourcingEvent().equalsIgnoreCase(IConstantsData.next_action_after_creating_sourcing_event_OK))
		{
			PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		}
		else if (sourcingEvent.getNextActionAfterCreatingSourcingEvent().equalsIgnoreCase(IConstantsData.next_action_after_creating_sourcing_event_GO_TO_ISource))
		{
			PopUpDefaultConfirmation.clickOnConfirmNoButton(driver, testCaseName);
		}
		return sourcingEvent;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To remove item <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
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
	 */
	public static boolean removeItem(WebDriver driver, String testCaseName, String itemId) throws ActionBotException, FactoryMethodException
	{
		boolean flag = false;
		PageRequisitionCheckOut.clickDeleteItem(driver, testCaseName, itemId);
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		flag = PageBuyersDesk.isItemNameLinkPresent(driver, testCaseName, itemId);
		ScreenShot.screenshot(driver, testCaseName, "After removing item");
		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> To copy sourcing details <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </font><b><br>
	 * @throws FactoryMethodException
	 *         </b> <br>
	 */
	public static boolean copySourcingDetails(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		boolean flag = true;
		String bidPrice, itemPrice, UOM, currency, sourcing_currency, quant, sourcing_uom, log = "";
		float quantity, sourcing_quantity;

		ModalBuyersDeskGuidedItemSourcingDetails.clickOnSourcingTab(driver, testCaseName);

		// get sourcing details
		bidPrice = ModalBuyersDeskGuidedItemSourcingDetails.getBidPrice(driver, testCaseName);
		String[] temp = StringUtils.split(bidPrice, " ");
		sourcing_currency = temp[0].trim();
		bidPrice = CommonUtilities.getDecimalPrice(bidPrice);

		quant = ModalBuyersDeskGuidedItemSourcingDetails.getBidQuantity(driver, testCaseName);
		String[] temp1 = StringUtils.split(quant, " ");
		sourcing_uom = temp1[1].trim();
		sourcing_quantity = Float.parseFloat(temp1[0].trim());

		ModalBuyersDeskGuidedItemSourcingDetails.getSupplierName(driver, testCaseName);

		// copy sourcing details
		ModalBuyersDeskGuidedItemSourcingDetails.clickOnCopyUnitPriceLink(driver, testCaseName);
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);

		itemPrice = ModalGuidedItemDetails.getItemPrice(driver, testCaseName);
		quantity = ModalGuidedItemDetails.getQuantity(driver, testCaseName);
		UOM = ModalGuidedItemDetails.getUOM(driver, testCaseName);
		currency = ModalGuidedItemDetails.getCurrency(driver, testCaseName);

		ModalGuidedItemDetails.clickOnSupplierDetailsTab(driver, testCaseName);
		ModalGuidedItemDetails.getSupplierName(driver, testCaseName);

		// item price
		if (!itemPrice.equalsIgnoreCase(bidPrice))
		{
			flag = false;
			log = "Sourcing price was not getting copied into item price";
		}
		// currency
		if (!currency.equalsIgnoreCase(sourcing_currency))
		{
			flag = false;
			log = "Sourcing currency was not getting copied into item currency";
		}
		// uom
		if (!UOM.equalsIgnoreCase(sourcing_uom))
		{
			flag = false;
			log = "Sourcing UOM was not getting copied into item UOM";
		}
		// quantity
		if (quantity != sourcing_quantity)
		{
			flag = false;
			log = "Sourcing Quantity was not getting copied into item quantity";
		}
		/*
		 * //supplier name if (selectedSupplierName != sourcing_supplierName) {
		 * flag = false; log =
		 * "Sourcing Supplier Name was not getting copied into item supplier name"
		 * ; }
		 */
		logger.info(log);
		return flag;
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>Fills all the filed details for create new
	 * item pop-up. <br>
	 * </font><b><font color="green">Note : Add button needs to be clicked
	 * externally, not part of this flow</b> </font><b><br>
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
	public static BuyersDesk fillItemDetails(WebDriver driver, String testCaseName, BuyersDesk buyersdesk) throws Exception
	{
		// String itemNumber
		if (buyersdesk.getItemNumber() != null)
		{
			buyersdesk.setItemNumber(PageBuyersDesk.enterItemNumber(driver, testCaseName, buyersdesk.getItemNumber()));
		}

		if (buyersdesk.getItemShortDescription() != null)
		{
			buyersdesk.setItemShortDescription(PageBuyersDesk.enterItemShortDescription(driver, testCaseName, buyersdesk.getItemShortDescription()));
		}
		if (buyersdesk.getItemLongDescription() != null)
		{
			buyersdesk.setItemLongDescription(PageBuyersDesk.enterItemLongDescription(driver, testCaseName, buyersdesk.getItemLongDescription()));

		}

		if (buyersdesk.getProductCategory() != null)
		{
			buyersdesk.setProductCategory(PageBuyersDesk.enterProductCategory(driver, testCaseName, buyersdesk.getProductCategory()));
		}

		// to verify selected radio buttons
		buyersdesk.setSelectedItemType(PageBuyersDesk.getSelectedItemType(driver, testCaseName));
		buyersdesk.setSelectedReceivedBy(PageBuyersDesk.getSelectedReceivedBy(driver, testCaseName));

		// to verify is radio received by is disabled by default.
		boolean radioReceiveBy = PageBuyersDesk.isRadioButtonReceiveByNoReceiptEnabled(driver, testCaseName);
		if (radioReceiveBy == false)
		{
			Assert.assertFalse("Radio Button received by is enabled", radioReceiveBy);
		}
		if (buyersdesk.getUOM() != null)
		{
			PageBuyersDesk.enterItemUOM(driver, testCaseName, buyersdesk.getUOM());
		}

		if (buyersdesk.getQuantity() != null)
		{
			PageBuyersDesk.enterItemQuantity(driver, testCaseName, buyersdesk.getQuantity());
			ActionBot.defaultLowSleep();
		}

		// to verify entered quantity. If quantity is 0, if loop will execute
		// else it'll ignore
		boolean flag = PageBuyersDesk.checkForQuantityError(driver, testCaseName);
		if (flag == true)
		{
			buyersdesk.setQuantity(CommonServices.getTestData(IConstantsData.Item_Quantity, 0));
			PageBuyersDesk.enterItemQuantity(driver, testCaseName, buyersdesk.getQuantity());
		}

		boolean flag_sourcingStatus = PageBuyersDesk.verifySourcingStatusValue(driver, testCaseName, buyersdesk.getItemSourcingStatus());
		if (flag_sourcingStatus == false)
		{
			Assert.assertTrue("Item sourcing status is not set to: " + buyersdesk.getItemSourcingStatus(), flag_sourcingStatus);

		}
		if (buyersdesk.getItemSourcingStatus() != null)
		{
			PageBuyersDesk.enterSourcingStatus(driver, testCaseName, buyersdesk.getItemSourcingStatus());
		}

		if (buyersdesk.getPrice() != null)
		{
			buyersdesk.setPrice(PageBuyersDesk.enterItemPrice(driver, testCaseName, buyersdesk.getPrice()));
		}

		if (buyersdesk.getItemCurrency() != null)
		{
			buyersdesk.setItemCurrency(PageBuyersDesk.enterItemCurrency(driver, testCaseName, buyersdesk.getItemCurrency()));
		}

		ScreenShot.screenshot(driver, testCaseName, "item details");
		return buyersdesk;
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b> Checks if Requirement details tab is
	 * visible and if single eform is present for the selected category then
	 * eform has to be displayed under Requirement Tab. <br>
	 * </font><b><font color="green">Note : </font><b><br>
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
	 * @throws ActionBotException
	 * @throws FactoryMethodException
	 */
	public static boolean verifyEformPresentInRequirementTab(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		PageBuyersDesk.clickRequirementDetailsTab(driver, testCaseName);
		return PageBuyersDesk.isEformPresentInRequirementTab(driver, testCaseName);
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>Fills all the EXTRA filed details for
	 * create new item pop-up. <br>
	 * </font><b><font color="green">Note : Add button needs to be clicked
	 * externally, not part of this flow</b> </font><b><br>
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
	public static BuyersDesk fillExtraItemDetails(WebDriver driver, String testCaseName, BuyersDesk buyersdesk) throws Exception
	{
		PageBuyersDesk.clickShowExtraFieldsLink(driver, testCaseName);

		// to verify selected radio buttons
		buyersdesk.setSelectedIsGreen(PageBuyersDesk.getSelectedIsGreen(driver, testCaseName));
		buyersdesk.setSelectedIsPreferred(PageBuyersDesk.getSelectedIsPreferred(driver, testCaseName));

		PageBuyersDesk.enterManufacturerName(driver, testCaseName, buyersdesk.getManufacturerName());
		PageBuyersDesk.enterManufacturerPartId(driver, testCaseName, buyersdesk.getManufacturerPartId());
		PageBuyersDesk.enterSpecificationName(driver, testCaseName, buyersdesk.getSpecificationName());
		PageBuyersDesk.enterImageUrl(driver, testCaseName, buyersdesk.getImageUrl());
		PageBuyersDesk.enterProductUrl(driver, testCaseName, buyersdesk.getProductUrl());
		PageBuyersDesk.enterManufacturerUrl(driver, testCaseName, buyersdesk.getManufacturerUrl());
		PageBuyersDesk.clickAddSpecificationButton(driver, testCaseName, buyersdesk.getSpecificationCount());
		PageBuyersDesk.enterSpecificationKey(driver, testCaseName, buyersdesk.getSpecificationKey());
		PageBuyersDesk.enterSpecificationValue(driver, testCaseName, buyersdesk.getSpecificationValue());
		ScreenShot.screenshot(driver, testCaseName, "extra item details");
		return buyersdesk;
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>Edit Cost Center / project / budget fields
	 * <br>
	 * </font><b><font color="green">Note : Add button needs to be clicked
	 * externally, not part of this flow</b> </font><b><br>
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
	public static BuyersDesk changeCostcenterProjectBudget(WebDriver driver, String testCaseName, BuyersDesk buyersdesk) throws Exception
	{
		PageBuyersDesk.clickEditLinkForBillingDeliverySummary(driver, testCaseName);
		PageBuyersDesk.clickCostAllocationTab(driver, testCaseName);
		PageBuyersDesk.enterCostCenterSummary(driver, testCaseName, buyersdesk.getCostCenter());
		PageBuyersDesk.enterProjectSummary(driver, testCaseName, buyersdesk.getProject());
		PageBuyersDesk.enterBudgetSummary(driver, testCaseName, buyersdesk.getBudget());
		PageBuyersDesk.clickOkButtonForReqSummary(driver, testCaseName);
		return buyersdesk;
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>Creates New Requisition, Approves Req and
	 * list it under Buyers Desk. <br>
	 * </font><b><font color="green">Note : Add button needs to be clicked
	 * externally, not part of this flow</b> </font><b><br>
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
	public static String createReqForBuyersDesk(WebDriver driver, String testCaseName, String reqNumber) throws Exception
	{
		String purchaseType = null;
		boolean flag_req_approval = false;

		// filling mandatory information requried to create requisiton
		PageRequisitionCheckOut.fillCheckoutReqName(driver, testCaseName, CommonUtilities.getReqName());
		PageRequisitionCheckOut.selectPurchaseType(driver, testCaseName, purchaseType);
		String settlementVia = "SETTLEMENT_VIA_OPTION_INVOICE";
		PageRequisitionCheckOut.selectSettlementVia(driver, testCaseName, settlementVia);
		PageBuyersDesk.clickEditLinkForBillingDeliverySummary(driver, testCaseName);
		PageBuyersDesk.clickCostAllocationTab(driver, testCaseName);
		BuyersDesk buyersdesk = ObjectCreation.changeCostcenterProjectBudget();
		PageBuyersDesk.enterCostCenterSummary(driver, testCaseName, buyersdesk.getCostCenter());
		PageBuyersDesk.enterProjectSummary(driver, testCaseName, buyersdesk.getProject());
		PageBuyersDesk.enterBudgetSummary(driver, testCaseName, buyersdesk.getBudget());
		PageBuyersDesk.clickOkButtonForReqSummary(driver, testCaseName);
		PageRequisitionCheckOut.clickIAmDone(driver, testCaseName);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on I AM DONE");
		PageRequisitionCheckOut.clickContinueButtonForConfirmPopup(driver, testCaseName);
		ScreenShot.screenshot(driver, testCaseName, "After clicking Continue Button");

		// getting created req number
		reqNumber = PageBuyersDesk.getCreatedReqNumber(driver, testCaseName, reqNumber);

		// Approving created Req
		MainPageHeaderLevelTab.clickOnApprovalAllRequestsTab(driver);
		PageAllRequestsApproval.enterReqNoFilter(driver, testCaseName, reqNumber);
		PageAllRequestsApproval.clickActionButton(driver, testCaseName);
		flag_req_approval = PageAllRequestsApproval.approveRequisition(driver, testCaseName);
		Assert.assertTrue("Requisition Approved", flag_req_approval);

		return reqNumber;

	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>Select cost center at line level <br>
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
	public static void changeToCostAtLineLevel(WebDriver driver, String testCaseName) throws Exception
	{
		PageBuyersDesk.clickEditLinkForBillingDeliverySummary(driver, testCaseName);
		PageBuyersDesk.clickCostAllocationTab(driver, testCaseName);
		PageBuyersDesk.clickCostAtLineLevelRadioButton(driver, testCaseName);
		PageBuyersDesk.clickOkButtonForReqSummary(driver, testCaseName);
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>Change Cost center/ project/budget at line
	 * level <br>
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
	public static void changeCostcenterProjectBudgetLineLevel(WebDriver driver, String testCaseName, BuyersDesk buyersdesk) throws Exception
	{
		PageBuyersDesk.clickOnExpandAllLink(driver, testCaseName);
		PageBuyersDesk.clickEditLinkForCostBookingItemLevel(driver, testCaseName);
		PageBuyersDesk.enterGLAccountForCostBookingItemLevel(driver, testCaseName);
		PageBuyersDesk.enterCostCenterForCostBookingItemLevel(driver, testCaseName, buyersdesk.getCostCenter());
		PageBuyersDesk.enterProjectForCostBookingItemLevel(driver, testCaseName, buyersdesk.getProject());
		PageBuyersDesk.enterBudgetForCostBookingItemLevel(driver, testCaseName, buyersdesk.getBudget());
		PageBuyersDesk.clickButtonOkCostAllocationTab(driver, testCaseName);
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>Change Cost center/ project/budget at line
	 * level <br>
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
	public static String getUserDefaultCurrency(WebDriver driver, String testCaseName) throws Exception
	{
		MainPageHeaderLevelTab.clickOnManageProfileTab(driver, testCaseName);
		String parentWindow = MainPageHeaderLevelTab.switchToUserProfileWindow(driver, testCaseName);
		String userCurrency = MainPageHeaderLevelTab.getUserCurrencyValue(driver, testCaseName);
		MainPageHeaderLevelTab.closeUserProfileWindow(driver, testCaseName, parentWindow);
		return userCurrency;
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>To create item with default values <br>
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
	public static BuyersDesk createSimpleFreeTextItem(WebDriver driver, String testCaseName, BuyersDesk buyersdesk) throws Exception
	{
		FlowBuyersDesk.fillItemDetails(driver, testCaseName, buyersdesk);
		PageBuyersDesk.clickAddItemsButton(driver, testCaseName);
		PageBuyersDesk.clickSuppliersTab(driver, testCaseName);
		PageBuyersDesk.enterSupplierName(driver, testCaseName, buyersdesk.getSupplierName());
		PageBuyersDesk.selectSupplierAddress(driver, testCaseName);
		PageBuyersDesk.clickAddItemsButton(driver, testCaseName);
		return buyersdesk;
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>Enters GL account for Req Default Item
	 * <br>
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
	public static void enterGLAccoutnForReqDefaultItem(WebDriver driver, String testCaseName) throws Exception
	{
		PageBuyersDesk.clickItemCheckbox(driver, testCaseName);
		PageBuyersDesk.clickOnExpandAllLink(driver, testCaseName);
		PageBuyersDesk.clickEditLinkForCostBookingItemLevel(driver, testCaseName);
		PageBuyersDesk.enterGLAccountForCostBookingItemLevel(driver, testCaseName);
		ModelItemBuyersdeskSummaryCostBooking.clickOnSaveItemSummary(driver, testCaseName);
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>Enters GL account for Req Free Text Item
	 * <br>
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
	public static void enterGLAccoutnForReqFreeTextItem(WebDriver driver, String testCaseName, String itemNumber) throws Exception
	{
		PageBuyersDesk.clickItemCheckbox(driver, testCaseName);
		PageBuyersDesk.clickOnExpandAllLink(driver, testCaseName);
		PageBuyersDesk.clickEditLinkForFreeTextItem(driver, testCaseName, itemNumber);
		PageBuyersDesk.enterGLAccountForCostBookingItemLevel(driver, testCaseName);
		ModelItemBuyersdeskSummaryCostBooking.clickOnSaveItemSummary(driver, testCaseName);
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>Replaces item and verify change comment
	 * under Audit Trail <br>
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
	public static String replaceItemAndVerifyAuditTrailComment(WebDriver driver, String testCaseName, String itemNumber, String changeComment, String reqNumber, int index)
		throws Exception
	{
		// select item checkbox
		PageBuyersDesk.clickItemCheckbox(driver, testCaseName);

		// verify Change comment displayed under Audit Trail
		PageBuyersDesk.clickOnReplaceItem(driver, testCaseName, itemNumber);
		// If save changes pop-up is displayed on page.
		PageBuyersDesk.clickConfimSave_DontSave(driver, testCaseName);

		// search item and replace item.
		PageOnlineStore.fillSearchText(driver, testCaseName, CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING, 1));
		PageOnlineStore.clickSearchButton(driver, testCaseName);
		PageSearchListing.clickSortByPriceHighToLow(driver, testCaseName);
		PageSearchListing.clickRadioButtonUsingIndex(driver, testCaseName, index);
		PageReplaceItem.clickOnReplaceItemButton(driver, testCaseName);
		PageReplaceItem.fillChangeComment(driver, testCaseName, changeComment);
		PageReplaceItem.clickOnConfirm(driver, testCaseName);

		// save requisition
		PageBuyersDesk.clickOnSave(driver, testCaseName);

		// search req and edit
		FlowBuyersDeskListing.setStatusAsPendingAndEditReq(driver, testCaseName, reqNumber);

		// click on audit trail link and get change comment
		PageBuyersDesk.clickAuditTrailLink(driver, testCaseName);
		String auditMessage = PageBuyersDesk.getAuditTrailMessage(driver, testCaseName);

		return auditMessage;
	}

	/**
	 * <b>Author: raj.singh </b> <b><br>
	 * <font color="blue">Method :</b>checks if the user is able to change the
	 * free text item category or not <br>
	 */
	public static boolean isCategoryFreeTextItemEditable(WebDriver driver, String testCaseName, CEform cEform) throws Exception
	{
		PageBuyersDesk.clickOnItemLinkDiscriptionIndexwise(driver, testCaseName, 1);
		ActionBot.defaultLowSleep();
		try
		{
			PageBuyersDesk.searchAndFillCategory(driver, testCaseName, cEform.getCategory());
			// verifies if multiple forms are present on page then selects eform
			if (PageBuyersDesk.isEformDialogPresent(driver, testCaseName))
			{
				PageBuyersDesk.selectEFormForCategoryNamewise(driver, testCaseName,cEform.getCeformDisplayName());
			}
			PageBuyersDesk.clickRequirementDetailsTab(driver, testCaseName);
			boolean status = PageBuyersDesk.isEFormFieldVisible(driver, testCaseName, cEform.getFieldName()) ? true : false;
			// ActionBot.click(driver, By.id("cancelGuidedItem"));
			ActionBot.defaultLowSleep();
			PageBuyersDesk.clickItemTab(driver, testCaseName);
			return (true && status);
		}
		catch (Exception e)
		{
			return false;
		}
	}

	/**
	 * <b>Author: raj.singh </b> <b><br>
	 * <font color="blue">Method :</b>checks if when the user changes the free
	 * text item category new tab for requirement details should open up
	 * seperately <br>
	 * </font><b><font color="green"> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </font><b><br>
	 * @throws FactoryMethodException
	 *         </b> <br>
	 * @throws Exception
	 */
	public static boolean isRequirementDetailTabThereAfterCategoryFreeTextItemChange(WebDriver driver, String testCaseName, CEform cEform) throws Exception
	{
		try
		{
			ActionBot.defaultSleep();
			PageBuyersDesk.clickOnItemLinkDiscriptionIndexwise(driver, testCaseName, 1);
			ActionBot.defaultSleep();
			PageBuyersDesk.searchAndFillCategory(driver, testCaseName, cEform.getCategory());
			if (PageBuyersDesk.isEformDialogPresent(driver, testCaseName))
			{
				PageBuyersDesk.selectEFormForCategoryNamewise(driver, testCaseName,cEform.getCeformDisplayName());
			}
			PageBuyersDesk.clickRequirementDetailsTab(driver, testCaseName);
			return (ActionBot.isElementDisplayed(driver, IPageBuyersDesk.TAB_REQUIREMENT_DETAILS)
				&& PageBuyersDesk.isEFormFieldVisible(driver, testCaseName, cEform.getFieldName()));
		}
		catch (Exception e)
		{
			return false;
		}
	}

	/**
	 * <b>Author: raj.singh </b> <b><br>
	 * <font color="blue">Method :</b>to fill up the supplier tab in the free
	 * text modal <br>
	 * </font><b><font color="green"> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </font><b><br>
	 * @throws FactoryMethodException
	 *         </b> <br>
	 * @throws Exception
	 */
	public static String toFillSupplierTab(WebDriver driver, String testCaseName) throws Exception
	{
		ActionBot.defaultLowSleep();
		PageBuyersDesk.clickOnSupplierTabInFreeText(driver, testCaseName);
		/*
		 * WebElement element=ActionBot.findElement(driver,
		 * By.id("dev_singleSupplierInput"));
		 * ActionBot.fillAutoCompleteField(driver, element, "e");
		 */
		PageBuyersDesk.clickReqSelectedSupplier(driver, testCaseName, 1);
		return PageBuyersDesk.getFreeTextSupplier(driver, testCaseName);
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>Links Po to req <br>
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
	public static String linkReqWithPO(WebDriver driver, String testCaseName, String poNumber) throws Exception
	{
		PageBuyersDesk.clickButtonShowAllPo(driver, testCaseName);
		PageBuyersDesk.fillPoNumberFilterPomodal(driver, testCaseName, poNumber);
		PageBuyersDesk.selectFirstPoRadioButton(driver, testCaseName);
		PageBuyersDesk.clickButtonSelectOnPoModal(driver, testCaseName);
		PageBuyersDesk.clickConfirmReturnToReq_Yes(driver, testCaseName);
		return poNumber;
	}

	/**
	 * <b>Author: raj.singh </b> <b><br>
	 * <font color="blue">Method :</b>fills up the extra fields of the guided
	 * item and verify validations over each fields <br>
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
	public static boolean fillExtraFields(WebDriver driver, String testCaseName, String choice)
	{
		boolean status = false;
		try
		{
			PageBuyersDesk.clickShowMoreExtraFields(driver, testCaseName);
			ActionBot.defaultLowSleep();

			PageBuyersDesk.fillManufacturerUrlInGuidedItemPopup(driver, testCaseName, CommonServices.getTestData(IConstantsData.Item_Manufacturer_URL));
			PageBuyersDesk.fillManufacturerIdInGuidedItemPopup(driver, testCaseName, CommonServices.getTestData(IConstantsData.Item_Manufacturer_Part_Id));
			PageBuyersDesk.fillImageUrlInGuidedItemPopup(driver, testCaseName, CommonServices.getTestData(IConstantsData.ITEM_IMAGE_URL));
			PageBuyersDesk.fillProductUrlInGuidedItemPopup(driver, testCaseName, CommonServices.getTestData(IConstantsData.Item_Product_URL));
			PageBuyersDesk.fillSpecificationkeyInGuidedItemPopup(driver, testCaseName, CommonServices.getTestData(IConstantsData.Item_Specification_Key));

			if (choice.equals(IConstantsData.SCRIPT_INPUT))
			{
				PageBuyersDesk.fillManufacturerNameInGuidedItemPopup(driver, testCaseName, CommonServices.getTestData(IConstantsData.Script_char_item_name));
				PageBuyersDesk.fillSpecificationNameInGuidedItemPopup(driver, testCaseName, CommonServices.getTestData(IConstantsData.Script_char_item_name));
				PageBuyersDesk.fillSpecificationValueInGuidedItemPopup(driver, testCaseName, CommonServices.getTestData(IConstantsData.Script_char_item_name));
			}
			else if (choice.equals(IConstantsData.NONE))
			{
				PageBuyersDesk.fillManufacturerNameInGuidedItemPopup(driver, testCaseName, CommonServices.getTestData(IConstantsData.Item_Manufacturer_Name));
				PageBuyersDesk.fillSpecificationNameInGuidedItemPopup(driver, testCaseName, CommonServices.getTestData(IConstantsData.Item_Specification_Name));
				PageBuyersDesk.fillSpecificationValueInGuidedItemPopup(driver, testCaseName, CommonServices.getTestData(IConstantsData.Item_Specification_Value));
			}

			List<WebElement> errorList = PageBuyersDesk.fetchErrorLists(driver, testCaseName);
			if (errorList.size() == 0)
				status = true;
		}
		catch (ActionBotException e)
		{
		}
		catch (Exception e)
		{
		}
		return status;
	}

	public static PunchoutItem createPunchoutItemFromBuyersDesk(WebDriver driver, String testCaseName, PunchoutItem punchoutItem) throws ActionBotException, FactoryMethodException
	{
		try
		{
			By actions = By.xpath("//span[@class='dIblock vMiddle'][contains(text(),'Actions')]");
			WebElement actionEle = driver.findElement(actions);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", actionEle);
			IPageBuyersDeskImpl.clickOnPunchoutItem(driver, testCaseName);
			IPageBuyersDeskImpl.clickOnSupplierOnPunchOutPOpUp(driver, testCaseName, "PROTECH");
			ActionBot.defaultHighSleep();

			PageCDWPunchout.fillSearchPunchoutItem(driver, testCaseName, punchoutItem.getPunchoutItemName());
			PageCDWPunchout.clickOnSearchButton(driver, testCaseName);

			List<WebElement> listOfSearchedPunchoutItems = PageCDWPunchout.getListOfSearchedProducts(driver, testCaseName);
			punchoutItem.setPunchoutItemName(listOfSearchedPunchoutItems.get(0).getText().trim());

			punchoutItem.setQuantity(PageCDWPunchout.fillItemQuantity(driver, testCaseName, punchoutItem.getQuantity(), punchoutItem.getPunchoutItemName()));
			PageCDWPunchout.clickOnAddToCartButton(driver, testCaseName, punchoutItem.getPunchoutItemName());

			punchoutItem.setUnitPrice(PageCDWPunchout.getUnitPriceOfAddedItem(driver, testCaseName));
			punchoutItem.setTotalPrice(PageCDWPunchout.getTotalPriceOfAddedItem(driver, testCaseName));

			// checkout
			PageCDWPunchout.clickOnCheckoutButton(driver, testCaseName);
			PageCDWPunchout.clickOnTransferSubmitButton(driver, testCaseName);
			Thread.sleep(1000);
			// if category not present in item
			// PageCDWPunchout.fillItemCategory(driver, testCaseName,
			// punchoutItem.getPunchoutItemcategory());

			boolean flag = FlowPunchout.checkIfPunchoutItemAdded(driver, testCaseName, punchoutItem);
			assertTrue("Punchout item was not added to cart", flag);
			ActionBot.defaultSleep();
			WebElement addItem = driver.findElement(By.xpath("//span[@id='addBuyerItemToReq'][contains(text(),'Add Item(s)')]"));
			addItem.click();
			/*
			 * if (punchoutItem.getNextAction().equalsIgnoreCase(IConstantsData.
			 * ADD_TO_CART_AND_CHECKOUT)) {
			 * PageReturnFromPunchout.clickOnAddToCardAndCheckoutButton(driver,
			 * testCaseName); } else if
			 * (punchoutItem.getNextAction().equalsIgnoreCase(IConstantsData.
			 * ADD_TO_CART_AND_CONTINUE_SHOPPING)) {
			 * PageReturnFromPunchout.clickOnAddToCardAndContinueShoppingButton(
			 * driver, testCaseName); } else if
			 * (punchoutItem.getNextAction().equalsIgnoreCase(IConstantsData.
			 * DISCARD_ALL_ITEMS)) {
			 * PageReturnFromPunchout.clickOnDiscardAllItems(driver,
			 * testCaseName); } else { logger.info("Invalid next action"); }
			 */
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return punchoutItem;
	}

}
