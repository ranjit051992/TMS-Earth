/**
 * 
 */
package com.zycus.automation.eproc.businessflow.requisitionflow;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.exec.util.StringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.zycus.automation.bo.AccountingItemSummary;
import com.zycus.automation.bo.AttachmentsAndCommentsItemSummary;
import com.zycus.automation.bo.BillingRequisitionSummary;
import com.zycus.automation.bo.BuyersDesk;
import com.zycus.automation.bo.COAMayerBrownDataBO;
import com.zycus.automation.bo.CatelogItem;
import com.zycus.automation.bo.ChangeMultiple;
import com.zycus.automation.bo.CostBookingAndAccountingItemSummaryCOA;
import com.zycus.automation.bo.CostBookingItemSummary;
import com.zycus.automation.bo.CostBookingRequisitionSummary;
import com.zycus.automation.bo.CostCenterSplitInfo;
import com.zycus.automation.bo.CustomDate;
import com.zycus.automation.bo.DeliveryItemSummary;
import com.zycus.automation.bo.DeliveryRequisitionSummary;
import com.zycus.automation.bo.DeliverySplitInfo;
import com.zycus.automation.bo.ExistingSupplier;
import com.zycus.automation.bo.FileAttachment;
import com.zycus.automation.bo.GLMap;
import com.zycus.automation.bo.GuidedItem;
import com.zycus.automation.bo.GuidedItemSuggestSupplier;
import com.zycus.automation.bo.Item;
import com.zycus.automation.bo.ItemMasterItem;
import com.zycus.automation.bo.ModalGuidedItemSelectCategory;
import com.zycus.automation.bo.ModalGuidedItemSelectSupplierContract;
import com.zycus.automation.bo.ModalGuidedItemSelectSupplierName;
import com.zycus.automation.bo.OnlineStore;
import com.zycus.automation.bo.PunchoutItem;
import com.zycus.automation.bo.Requisition;
import com.zycus.automation.bo.Search;
import com.zycus.automation.bo.User;
import com.zycus.automation.constants.IConstants;
import com.zycus.automation.datacreation.ObjectCreation;
import com.zycus.automation.eproc.businessflow.coaflow.COAFlow;
import com.zycus.automation.eproc.businessflow.myrequisitionsflow.FlowMyRequisitions;
import com.zycus.automation.eproc.businessflow.onlinestoreflow.FlowOnlineStore;
import com.zycus.automation.eproc.businessflow.searchlistingpageflow.FlowSearchListing;
import com.zycus.automation.eproc.pageobjects.modals.BuyersRequisitionSummaryBilling.ModelBuyersdeskSummaryBilling;
import com.zycus.automation.eproc.pageobjects.modals.checkoutChangeMultiple.ModelChangeMultiple;
import com.zycus.automation.eproc.pageobjects.modals.checkoutGuidedItemDetails.IModalGuidedItemDetails;
import com.zycus.automation.eproc.pageobjects.modals.checkoutGuidedItemDetails.ModalGuidedItemDetails;
import com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryAttachment.ModelItemSummaryAttachment;
import com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryCommon.ModelItemSummaryCommon;
import com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryCostBooking.IModelItemSummaryCostBooking;
import com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryCostBooking.ModelItemSummaryCostBooking;
import com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryDelivery.ModelItemSummaryDelivery;
import com.zycus.automation.eproc.pageobjects.modals.checkoutItemSummaryMiscellaneous.ModelItemSummaryMiscellaneous;
import com.zycus.automation.eproc.pageobjects.modals.checkoutRequisitionSummaryBilling.ModelRequisitionSummaryBilling;
import com.zycus.automation.eproc.pageobjects.modals.checkoutRequisitionSummaryCommon.ModelRequisitionSummaryCommon;
import com.zycus.automation.eproc.pageobjects.modals.checkoutRequisitionSummaryCostBooking.ModelRequisitionSummaryCostBooking;
import com.zycus.automation.eproc.pageobjects.modals.checkoutRequisitionSummaryDelivery.ModelRequisitionSummaryDelivery;
import com.zycus.automation.eproc.pageobjects.modals.deletereport.ModalDeleteReport;
import com.zycus.automation.eproc.pageobjects.modals.shoppingcart.ModalShoppingCart;
import com.zycus.automation.eproc.pageobjects.modals.showallpos.ModalShowAllPos;
import com.zycus.automation.eproc.pageobjects.pages.BuyersDesk.PageBuyersDesk;
import com.zycus.automation.eproc.pageobjects.pages.myfavorites.PageMyFavorites;
import com.zycus.automation.eproc.pageobjects.pages.myrequisition.IPageMyRequisition;
import com.zycus.automation.eproc.pageobjects.pages.myrequisition.PageMyRequisition;
import com.zycus.automation.eproc.pageobjects.pages.onlinestore.PageOnlineStore;
import com.zycus.automation.eproc.pageobjects.pages.requisitionCheckOut.IPageRequisitionCheckOut;
import com.zycus.automation.eproc.pageobjects.pages.requisitionCheckOut.PageRequisitionCheckOut;
import com.zycus.automation.eproc.pageobjects.pages.searchlisting.IPageSearchListing;
import com.zycus.automation.eproc.pageobjects.pages.searchlisting.IPageSearchListingImpl;
import com.zycus.automation.eproc.pageobjects.pages.searchlisting.PageSearchListing;
import com.zycus.automation.eproc.pageobjects.pages.standardpo.PageStandardPO;
import com.zycus.automation.eproc.pageobjects.pages.viewrequisition.PageRequisitionView;
import com.zycus.automation.eproc.pageobjects.popups.checkoutsendforapproval.PopUpSendForApproval;
import com.zycus.automation.eproc.pageobjects.popups.defaultconfirmation.PopUpDefaultConfirmation;
import com.zycus.automation.eproc.pageobjects.popups.deleteconfirmation.PopUpDeleteConfirmation;
import com.zycus.automation.eproc.pageobjects.tabs.checkoutTabItemSummary.TabCheckoutItemSummary;
import com.zycus.automation.eproc.pageobjects.tabs.checkoutTabRequisitionSummary.TabCheckoutReqSummary;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.pageobjects.tabs.poSummary.TabPOSummary;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.eproc.validation.VerifyShoppingItemsWithShoppingCarts;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.common.CommonUtilities;
import com.zycus.automation.utilities.screenshot.ScreenShot;
import com.zycus.framework.dom_parser.framework.UI_Elements;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;
import com.zycus.framework.framework_version_2_4.framework.Helper;
import com.zycus.framework.framework_version_2_4.framework_exception.TestCaseException;

/**
 * @author puneet.sharma
 */
public class FlowRequisition
{
	public static List<COAMayerBrownDataBO>	mayerBrownDataList	= new ArrayList<COAMayerBrownDataBO>();
	static Logger							logger				= Logger.getLogger(FlowRequisition.class);

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To create requisition <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param requisition
	 *        </font><b><br>
	 * @param item
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	public static Requisition createRequisition(WebDriver driver, String testCaseName, Requisition requisition) throws Exception
	{
		// to add items
		Item items = new Item();
		if (requisition.getItems() != null)
		{
			items = FlowSearchListing.addItem(driver, testCaseName, requisition.getItems());
			requisition.setItems(items);

			WebDriverWait wait = new WebDriverWait(driver, Long.parseLong(ActionBot.defaultMediumSleep));
			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(IPageSearchListingImpl.LABEL_SUCCESS_MSG_AFTER_ITEM_ADDED_TO_CART.getValue())));

			boolean flag = VerifyShoppingItemsWithShoppingCarts.checkIfItemsAddedToCart(driver, testCaseName, items);
			assertTrue("Item added to cart are wrong", flag);
			ModalShoppingCart.continueWithCart(driver, testCaseName);
		}

		// to remove
		Thread.sleep(6000);
		// to checkout
		PageSearchListing.clickOnCheckOutButton(driver, testCaseName);

		// to fill checkout form and submit
		fillcheckoutForm(driver, testCaseName, requisition, items);
		requisition.setItems(items);

		// to check/modify workflow
		ActionBot.scroll(driver, "400");

		if (requisition.isVerifyWorkflow())
		{
			if (requisition.isModifyWorkflowSettings())
			{
				PageRequisitionCheckOut.clickOnModifyWorkFlowSettings(driver, testCaseName);
				// ActionBot.defaultMediumSleep();
				ActionBot.defaultSleep();
			}
			else
			{
				PageRequisitionCheckOut.waitForLoadingDivOfWorkFlowTrail(driver, testCaseName);
				ActionBot.defaultSleep();
			}
			requisition.setApprover(PageRequisitionCheckOut.getFirstApproverNameFromWorkflow(driver, testCaseName));
			requisition.setExternalAgentAvailable(PageRequisitionCheckOut.checkForExternalAgent(driver, testCaseName));
		}
		// to perform next action
		if (requisition.getNextAction().equalsIgnoreCase(IConstantsData.SUBMIT_REQ))
		{
			submitReq(driver, testCaseName, false);
		}
		else if (requisition.getNextAction().equalsIgnoreCase(IConstantsData.SUBMIT_REQ_FOR_APPROVAL))
		{
			submitReq(driver, testCaseName, true);
		}
		else if (requisition.getNextAction().equalsIgnoreCase(IConstantsData.SAVE_AS_DRAFT_REQ))
		{
			saveReqAsDraft(driver, testCaseName);
		}
		else if (requisition.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL_REQ))
		{
			cancelReq(driver, testCaseName);
		}
		else if (requisition.getNextAction().equalsIgnoreCase(IConstantsData.NONE))
		{
			logger.info("No Action to be performed for requisition");
		}
		else
		{
			logger.info("Invalid next action is specified for requisition");
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
			billingRequisitionSummary.setCurrency(ModelRequisitionSummaryBilling.fillBillingCurrency(driver, testCaseName, billingRequisitionSummary.getCurrency()));
		}

		// to fill company
		if (billingRequisitionSummary.getCompany() != null)
		{
			billingRequisitionSummary.setCompany(ModelRequisitionSummaryBilling.fillBillingCompany(driver, testCaseName, billingRequisitionSummary.getCompany()));

			// to check remaining fields are blank or not
			if (ModelRequisitionSummaryBilling.getBillingBU(driver, testCaseName).length() == 0)
			{
				billingRequisitionSummary.setBusinessUnit(ModelRequisitionSummaryBilling.fillBillingBU(driver, testCaseName, billingRequisitionSummary.getBusinessUnit()));
			}
			if (ModelRequisitionSummaryBilling.getBillingLocation(driver, testCaseName).length() == 0)
			{
				billingRequisitionSummary.setLocation(ModelRequisitionSummaryBilling.fillBillingLocation(driver, testCaseName, billingRequisitionSummary.getLocation()));
			}
		}

		// to fill BU
		if (billingRequisitionSummary.getBusinessUnit() != null)
		{
			billingRequisitionSummary.setBusinessUnit(ModelRequisitionSummaryBilling.fillBillingBU(driver, testCaseName, billingRequisitionSummary.getBusinessUnit()));

			// to check remaining fields are blank or not
			if (ModelRequisitionSummaryBilling.getBillingLocation(driver, testCaseName).length() == 0)
			{
				billingRequisitionSummary.setLocation(ModelRequisitionSummaryBilling.fillBillingLocation(driver, testCaseName, billingRequisitionSummary.getLocation()));
			}
		}

		// to fill Location
		if (billingRequisitionSummary.getLocation() != null)
		{
			billingRequisitionSummary.setLocation(ModelRequisitionSummaryBilling.fillBillingLocation(driver, testCaseName, billingRequisitionSummary.getLocation()));
		}

		// to perform next action
		if (billingRequisitionSummary.getNextAction().equalsIgnoreCase(IConstantsData.SAVE))
		{
			ModelRequisitionSummaryCommon.clickSaveReqSummary(driver, testCaseName);
		}
		else if (billingRequisitionSummary.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			ModelRequisitionSummaryCommon.clickCancleReqSummary(driver, testCaseName);
		}
		else if (billingRequisitionSummary.getNextAction().equalsIgnoreCase(IConstantsData.NONE))
		{
			logger.info("Action specified as None");
		}
		else
		{
			logger.info("Invalid action specified");
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
			deliveryRequisitionSummary.setDeliverTo(ModelRequisitionSummaryDelivery.fillDeliveryDeliverTo(driver, testCaseName, deliveryRequisitionSummary.getDeliverTo()));
		}

		// required by date
		if (deliveryRequisitionSummary.getCustomDate() != null)
		{
			deliveryRequisitionSummary.getCustomDate().setDate(ModelRequisitionSummaryDelivery.selectRequiredByDate(driver, testCaseName,
				deliveryRequisitionSummary.getCustomDate().getDay(), deliveryRequisitionSummary.getCustomDate().getMonth(), deliveryRequisitionSummary.getCustomDate().getYear()));
		}

		// OU address
		if (deliveryRequisitionSummary.isOUAddressOption())
		{
			ModelRequisitionSummaryDelivery.selectDeliveryOUAddress(driver, testCaseName);
		}

		// other address
		if (deliveryRequisitionSummary.isOtherAddressesOption())
		{
			ModelRequisitionSummaryDelivery.selectDeliveryOtherAddress(driver, testCaseName);
			deliveryRequisitionSummary
				.setOtherAddresses(ModelRequisitionSummaryDelivery.fillDeliveryOtherAddress(driver, testCaseName, deliveryRequisitionSummary.getOtherAddresses()));
		}

		// my address
		if (deliveryRequisitionSummary.isMyAddressOption())
		{
			ModelRequisitionSummaryDelivery.selectDeliveryMyAddress(driver, testCaseName);
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
			ModelRequisitionSummaryCommon.clickSaveReqSummary(driver, testCaseName);
		}
		if (deliveryRequisitionSummary.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			ModelRequisitionSummaryCommon.clickCancleReqSummary(driver, testCaseName);
		}
		if (deliveryRequisitionSummary.getNextAction().equalsIgnoreCase(IConstantsData.NONE))
		{
			// only fill the form and do nothing
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
		if (costBookingRequisitionSummary.getAssignedProjectToPurchaseCost() != null)
		{
			if (costBookingRequisitionSummary.getAssignedProjectToPurchaseCost().equalsIgnoreCase(IConstants.YES))
			{
				ModelRequisitionSummaryCostBooking.clickYesAssignToPurchaseCost(driver, testCaseName);
			}
			else
			{
				ModelRequisitionSummaryCostBooking.clickNoAssignToPurchaseCost(driver, testCaseName);
			}
			ActionBot.waitForPageLoad(driver);
		}

		if (costBookingRequisitionSummary.getAllowBudgetUtilization() != null)
		{
			if (costBookingRequisitionSummary.getAllowBudgetUtilization().equalsIgnoreCase(IConstants.NO))
			{
				ModelRequisitionSummaryCostBooking.clickNoAllowBudgetUtilization(driver, testCaseName);
			}
			ActionBot.waitForPageLoad(driver);
		}

		// book cost to single cost center
		if (costBookingRequisitionSummary.isBookCostToSingleCostCenter())
		{
			ModelRequisitionSummaryCostBooking.selectCostBookingOptionSingleCC(driver, testCaseName);
			costBookingRequisitionSummary
				.setCostCenter(ModelRequisitionSummaryCostBooking.fillCostBookingSingleCC(driver, testCaseName, costBookingRequisitionSummary.getCostCenter()));
			// if (costBookingRequisitionSummary.getProject() != null)
			if (costBookingRequisitionSummary.getAssignedProjectToPurchaseCost() != null)
			{
				if (costBookingRequisitionSummary.getAssignedProjectToPurchaseCost().equalsIgnoreCase(IConstants.NO))
				{
					// ActionBot.waitForPageLoad(driver);
				}
				if (costBookingRequisitionSummary.getAssignedProjectToPurchaseCost().equalsIgnoreCase(IConstants.YES))
				{
					costBookingRequisitionSummary
						.setProject(ModelRequisitionSummaryCostBooking.fillCostBookingSingleProject(driver, testCaseName, costBookingRequisitionSummary.getProject()));
				}
			}

			else
			{
				costBookingRequisitionSummary
					.setProject(ModelRequisitionSummaryCostBooking.fillCostBookingSingleProject(driver, testCaseName, costBookingRequisitionSummary.getProject()));
				ActionBot.waitForPageLoad(driver);
			}
			// if (costBookingRequisitionSummary.getBudget() != null)
			if (costBookingRequisitionSummary.getAllowBudgetUtilization() != null)
			{
				if (costBookingRequisitionSummary.getAllowBudgetUtilization().equalsIgnoreCase(IConstants.NO))
				{
					// ActionBot.waitForPageLoad(driver);
				}
				if (costBookingRequisitionSummary.getAllowBudgetUtilization().equalsIgnoreCase(IConstants.YES))
				{
					costBookingRequisitionSummary
						.setBudget(ModelRequisitionSummaryCostBooking.fillCostBookingSingleBudget(driver, testCaseName, costBookingRequisitionSummary.getBudget()));
				}
			}
			else
			{
				costBookingRequisitionSummary
					.setBudget(ModelRequisitionSummaryCostBooking.fillCostBookingSingleBudget(driver, testCaseName, costBookingRequisitionSummary.getBudget()));
				// ActionBot.waitForPageLoad(driver);
			}
		}

		// book cost to multiple cost center at header level
		if (costBookingRequisitionSummary.isSplitCostToMultipleCostCenter())
		{
			ModelRequisitionSummaryCostBooking.selectCostBookingOptionMultipleCC(driver, testCaseName);

			costBookingRequisitionSummary
				.setListOfSplitedCostCenters(splitCostCenterAtHeaderLevel(driver, testCaseName, costBookingRequisitionSummary.getListOfSplitedCostCenters()));
		}

		// split cost at line item level
		if (costBookingRequisitionSummary.isSplitCostAtLineItemLevel())
		{
			ModelRequisitionSummaryCostBooking.selectCostBookingOptionLineItemCC(driver, testCaseName);
		}

		// to perform next action
		if (costBookingRequisitionSummary.getNextAction().equalsIgnoreCase(IConstantsData.SAVE))
		{
			ModelRequisitionSummaryCommon.clickSaveReqSummary(driver, testCaseName);
		}
		if (costBookingRequisitionSummary.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			ModelRequisitionSummaryCommon.clickCancleReqSummary(driver, testCaseName);
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
			ModelItemSummaryDelivery.selectDeliveryOptionSingleSplit(driver, testCaseName);

			if (deliveryItemSummary.isCreateAssetTags())
			{
				ModelItemSummaryDelivery.clickCreateAssetTagsForThisItemCheckBox(driver, testCaseName);
				ModelItemSummaryDelivery.clickOnTagAssetsLink(driver, testCaseName);

				if (!deliveryItemSummary.getAssetTaggings().isEmpty())
				{

				}
			}
		}

		// multiple split
		if (deliveryItemSummary.isSplitDeliveryToMultipleLocations())
		{
			ModelItemSummaryDelivery.selectDeliveryOptionMultiSplit(driver, testCaseName);
			deliveryItemSummary.setDeliverySplitInfo(splitDeliveryLocationsToMultiple(driver, testCaseName, deliveryItemSummary.getDeliverySplitInfo(), itemId));
		}

		// to perform next action
		if (deliveryItemSummary.getNextAction().equalsIgnoreCase(IConstantsData.SAVE))
		{
			ModelItemSummaryCommon.clickItemSummarySave(driver, testCaseName);
		}
		if (deliveryItemSummary.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			ModelItemSummaryCommon.clickItemSummaryCancle(driver, testCaseName);
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
	 * @throws TestCaseException
	 */
	public static CostBookingItemSummary fillCostBookingItemSummary(WebDriver driver, String testCaseName, CostBookingItemSummary costBookingItemSummary, String itemId)
		throws ActionBotException, TestCaseException
	{
		CostBookingItemSummary costBookingItemSummary2 = new CostBookingItemSummary();
		AccountingItemSummary accountingItemSummary = new AccountingItemSummary();
		costBookingItemSummary2.setAccountingItemSummary(accountingItemSummary);
		// changed as per accounting-cost booking merging feature
		costBookingItemSummary2.getAccountingItemSummary()
			.setGlAccount(ModelItemSummaryCostBooking.fillAccountingGLAccount(driver, testCaseName, costBookingItemSummary.getAccountingItemSummary().getGlAccount(), itemId, 0));
		// if asset code present then fill it
		if (ModelItemSummaryCostBooking.isAssetCodeTextboxPresent(driver, testCaseName, itemId))
		{
			ModelItemSummaryCostBooking.fillAssetCode(driver, testCaseName, costBookingItemSummary.getAccountingItemSummary().getAssetCode(), itemId);
		}

		if (costBookingItemSummary.isSplitCostCenterAtItemLevel())
		{
			ModelItemSummaryCostBooking.selectCostBookingOptionMultiSplit(driver, testCaseName);

			if (costBookingItemSummary.isSplitCostCenterAtItemLevel_quantityProportionalToDelivery())
			{
				costBookingItemSummary2.setCostCenterSplitInfo(splitCCProportionalToDelivery(driver, testCaseName, costBookingItemSummary.getCostCenterSplitInfo(), itemId));
			}
			else
			{
				if (costBookingItemSummary.isSplitCostCenterAtItemLevel_percentage())
				{
					ModelItemSummaryCostBooking.selectCostBookingOptionItemSplitPercent(driver, testCaseName);
				}
				if (costBookingItemSummary.isSplitCostCenterAtItemLevel_quantity())
				{
					ModelItemSummaryCostBooking.selectCostBookingOptionItemSplitQuantity(driver, testCaseName);
				}
				costBookingItemSummary2.setCostCenterSplitInfo(splitCostCenterAtItemLevel(driver, testCaseName, costBookingItemSummary.getCostCenterSplitInfo(), itemId));
			}

		}

		// to get sub total price
		costBookingItemSummary.setSubTotalPrice(ModelItemSummaryCostBooking.getSubTotalPrice(driver, testCaseName));
		// to perform next action
		if (costBookingItemSummary.getNextAction().equalsIgnoreCase(IConstantsData.SAVE))
		{
			ModelItemSummaryCommon.clickItemSummarySave(driver, testCaseName);
		}
		if (costBookingItemSummary.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			ModelItemSummaryCommon.clickItemSummaryCancle(driver, testCaseName);
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
				.setInternalComments(ModelItemSummaryAttachment.fillAttachmentInternalComment(driver, testCaseName, attachmentsAndCommentsItemSummary.getInternalComments()));
		}
		if (attachmentsAndCommentsItemSummary.getCommentsForSupplier() != null)
		{
			attachmentsAndCommentsItemSummary.setCommentsForSupplier(
				ModelItemSummaryAttachment.fillAttachmentSupplierlComment(driver, testCaseName, attachmentsAndCommentsItemSummary.getCommentsForSupplier()));
		}
		if (attachmentsAndCommentsItemSummary.getAttachments().size() > 0)
		{
			int index = 2;
			for (FileAttachment attachment : attachmentsAndCommentsItemSummary.getAttachments())
			{
				ModelItemSummaryAttachment.fillAttachmentFileName(driver, testCaseName, attachment.getFileName());

				attachment.setFileName(ModelItemSummaryAttachment.getAttachmentName(driver, testCaseName, index));

				String status = ModelItemSummaryAttachment.getAttachmentStatus(driver, testCaseName, attachment.getFileName());
				String size = ModelItemSummaryAttachment.getAttachmentSize(driver, testCaseName, attachment.getFileName());
				attachment.setFileStatus(status);
				attachment.setFileSize(size);

				attachment.setFileVisibility(ModelItemSummaryAttachment.selectVisibility(driver, testCaseName, attachment.getFileVisibility(), attachment.getFileName()));

				if (!status.equalsIgnoreCase(IConstantsData.Uploaded) || size.equalsIgnoreCase("0 KB"))
				{
					Assert.assertFalse(true, "File was not uploaded");
				}
				index++;
			}
		}
		// to perform next action
		if (attachmentsAndCommentsItemSummary.getNextAction().equalsIgnoreCase(IConstantsData.SAVE))
		{
			ModelItemSummaryCommon.clickItemSummarySave(driver, testCaseName);
		}
		if (attachmentsAndCommentsItemSummary.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			ModelItemSummaryCommon.clickItemSummaryCancle(driver, testCaseName);
		}

		return attachmentsAndCommentsItemSummary;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To fill checkout form <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param requisition
	 *        </font><b><br>
	 * @param item
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 * @throws Exception
	 */
	public static Requisition fillcheckoutForm(WebDriver driver, String testCaseName, Requisition requisition, Item item) throws Exception
	{
		// on behalf
		if (requisition.getOnBehalfOf() != null)
		{
			requisition.setOnBehalfOf(PageRequisitionCheckOut.fillOnBehalfOf(driver, testCaseName, requisition.getOnBehalfOf()));
		}

		// add attachment
		if (requisition.getAttactmentFile() != null)
		{
			PageRequisitionCheckOut.addAttachment(driver, testCaseName, requisition.getAttactmentFile());
		}
		// req name
		if (requisition.getReqName() != null)
		{
			requisition.setReqName(PageRequisitionCheckOut.fillCheckoutReqName(driver, testCaseName, requisition.getReqName()));
		}

		// urg req
		if (requisition.isRequired())
		{
			PageRequisitionCheckOut.checkUrgentRequirement(driver, testCaseName);
		}

		// reason for ordering
		if (requisition.getReasonForOrdering() != null)
		{
			requisition.setReasonForOrdering(PageRequisitionCheckOut.fillReasonForOrdering(driver, testCaseName, requisition.getReasonForOrdering()));
		}

		// on Retrospective Purchase
		if (requisition.isRetrospectivePurchase())
		{
			PageRequisitionCheckOut.checkRetrospectivePurchase(driver, testCaseName);
		}

		/*
		 * // assigned buyer if
		 * (PageRequisitionCheckOut.isAssignedBuyerTextBoxPresent(driver,
		 * testCaseName)) {
		 * 
		 * PageBuyersDesk.clickOnExpandAllLink(driver, testCaseName);
		 * PageBuyersDesk.clickEditLinkForAssignedBuyerItemLevel(driver,
		 * testCaseName); requisition.setAssignedBuyer(PageRequisitionCheckOut.
		 * fillAssignedBuyer(driver, testCaseName,
		 * requisition.getAssignedBuyer()));
		 * PageBuyersDesk.clickButtonOkCostAllocationTab(driver, testCaseName);
		 * 
		 * }
		 */

		// settlement via
		if (requisition.getSettlementvia() != null)
		{
			requisition.setSettlementvia(PageRequisitionCheckOut.selectSettlementVia(driver, testCaseName, requisition.getSettlementvia()));

			// select PCard
			if (requisition.getSettlementvia().contains("P-card"))
			{
				requisition.setPcard(PageRequisitionCheckOut.selectPCard(driver, testCaseName, requisition.getPcard()));
			}
		}

		// purchase type
		requisition.setPurchaseType(PageRequisitionCheckOut.selectPurchaseType(driver, testCaseName, requisition.getPurchaseType()));

		// to overrideGLAccount
		overrideGLAccount(driver, testCaseName, requisition.isOverrideGlAccount());

		// required by date
		if (requisition.getCustomDate() != null)
		{
			requisition.getCustomDate().setDate(PageRequisitionCheckOut.selectRequiredByDate(driver, testCaseName, requisition.getCustomDate().getDay(),
				requisition.getCustomDate().getMonth(), requisition.getCustomDate().getYear()));
		}

		if (requisition.isEditHeaderLevelInfo())
		{
			// edit billing info
			PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
			ActionBot.waitForPageLoad(driver);
			ActionBot.defaultSleep();

			// billing info
			if (requisition.getBillingRequisitionSummary() != null)
			{
				TabCheckoutReqSummary.clickBillingTab(driver, testCaseName);
				requisition.setBillingRequisitionSummary(fillBillingRequisitionSummary(driver, testCaseName, requisition.getBillingRequisitionSummary()));
			}
			else
			{
				// get billing req summary info
				BillingRequisitionSummary billingRequisitionSummary = new BillingRequisitionSummary();
				billingRequisitionSummary.setCompany(ModelRequisitionSummaryBilling.getBillingCompany(driver, testCaseName));
				billingRequisitionSummary.setBusinessUnit(ModelRequisitionSummaryBilling.getBillingBU(driver, testCaseName));
				billingRequisitionSummary.setLocation(ModelRequisitionSummaryBilling.getBillingLocation(driver, testCaseName));
				requisition.setBillingRequisitionSummary(billingRequisitionSummary);
			}

			// delivery info
			if (requisition.getDeliveryRequisitionSummary() != null)
			{
				TabCheckoutReqSummary.clickDeliveryTab(driver, testCaseName);
				requisition.setDeliveryRequisitionSummary(fillDelivryRequisitionSummary(driver, testCaseName, requisition.getDeliveryRequisitionSummary()));
			}

			// cost booking info
			if (requisition.getCostBookingRequisitionSummary() != null)
			{
				ActionBot.defaultSleep();
				TabCheckoutReqSummary.clickCostBookingTab(driver, testCaseName);
				requisition.setCostBookingRequisitionSummary(fillCostBookingRequisitionSummary(driver, testCaseName, requisition.getCostBookingRequisitionSummary()));
			}
		}

		// to attach PO/BPO in req
		if (requisition.getPoNo() != null)
		{
			requisition.setPoNo(SelctShowAllPos(driver, testCaseName, requisition.getPoNo()));
		}

		((JavascriptExecutor) driver).executeScript("window.scrollBy(0,400);");
		PageRequisitionCheckOut.clickExpandAll(driver, testCaseName);
		// ActionBot.defaultMediumSleep();

		// change Mulitple
		if (requisition.isChangeMultiple())
		{
			if (requisition.getChangeMultiple() != null)
			{
				requisition.setChangeMultiple(changeMultiple(driver, testCaseName, requisition.getChangeMultiple()));
			}
		}

		ActionBot.scroll(driver, "400");
		if (item.getPunchoutItems() != null)
		{
			for (PunchoutItem punchoutItem : item.getPunchoutItems())
			{
				punchoutItem.setItemId(PageRequisitionCheckOut.getItemIdByNameAtRequisitionCheckout(driver, testCaseName, punchoutItem.getPunchoutItemName()));
			}
		}

		//delete non added items
		deleteNonAddedItems(driver, testCaseName, item);

		// to edit item level info

		int i = 0;
		if (requisition.isEditItemLevelInfo())
		{

			// for catalog items
			if (requisition.getItems().getCatelogItems() != null)
			{
				if (requisition.getItems().getCatelogItems().size() > 0)
				{
					for (CatelogItem catelogItem : requisition.getItems().getCatelogItems())
					{
						String itemId = catelogItem.getItemID();
						logger.info("\n### Editing item level requisition summary for Item " + i++ + " : " + catelogItem.getItemName());

						PageRequisitionCheckOut.clickEditItemSummary(driver, testCaseName, itemId);
						// PageRequisitionCheckOut.clickOnCostBookingItemEdit(driver,
						// testCaseName);

						// delivery info
						// if set in requisition object
						if (requisition.getDeliveryItemSummary() != null)
						{
							TabCheckoutItemSummary.clickItemSummaryDeliveryTab(driver, testCaseName);
							requisition.setDeliveryItemSummary(fillDeliveryItemSummary(driver, testCaseName, requisition.getDeliveryItemSummary(), itemId));
						}
						// if set in catalog object
						else if (catelogItem.getDeliveryItemSummary() != null)
						{
							catelogItem.setDeliveryItemSummary(fillDeliveryItemSummary(driver, testCaseName, catelogItem.getDeliveryItemSummary(), itemId));

						}

						// assigned buyer
						if (requisition.getAssignedBuyer() != null)
						{
							TabCheckoutItemSummary.clickItemSummaryAssignedBuyerTab(driver, testCaseName);
							PageRequisitionCheckOut.clickOnAssignedBuyerDropdown(driver, testCaseName);
							PageRequisitionCheckOut.clickOnSingleAssignedBuyer(driver, testCaseName);
							PageRequisitionCheckOut.fillAssignedBuyer(driver, testCaseName, requisition.getAssignedBuyer());

						}
						if (requisition.getAssignedBuyerGroup() != null)
						{
							TabCheckoutItemSummary.clickItemSummaryAssignedBuyerTab(driver, testCaseName);
							PageRequisitionCheckOut.clickOnAssignedBuyerDropdown(driver, testCaseName);
							PageRequisitionCheckOut.clickOnGroupAssignedBuyer(driver, testCaseName);
							PageRequisitionCheckOut.fillAssignedBuyerGroup(driver, testCaseName, requisition.getAssignedBuyerGroup());
						}

						// cost booking info
						// if set in requisition object
						if (requisition.getCostBookingItemSummary() != null)
						{
							ActionBot.waitForPageLoad(driver);
							TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
							fillCostBookingItemSummary(driver, testCaseName, requisition.getCostBookingItemSummary(), itemId);
						}
						// if set in catalog object
						else if (catelogItem.getCostBookingItemSummary() != null)
						{
							TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
							catelogItem.setCostBookingItemSummary(fillCostBookingItemSummary(driver, testCaseName, catelogItem.getCostBookingItemSummary(), itemId));
						}
						// attachments/comments
						// if set in requisition object
						if (requisition.getAttachmentsAndCommentsItemSummary() != null)
						{
							TabCheckoutItemSummary.clickItemSummaryAttachmentTab(driver, testCaseName);
							fillAttachmentsAndComments(driver, testCaseName, requisition.getAttachmentsAndCommentsItemSummary());
						}
						// if set in catalog object
						else if (catelogItem.getAttachmentsAndCommentsItemSummary() != null)
						{
							TabCheckoutItemSummary.clickItemSummaryAttachmentTab(driver, testCaseName);
							catelogItem.setAttachmentsAndCommentsItemSummary(fillAttachmentsAndComments(driver, testCaseName, catelogItem.getAttachmentsAndCommentsItemSummary()));
						}

						// to edit miscellaneous section
						if (requisition.isEditMiscellaneous())
						{
							PageRequisitionCheckOut.clickEditItemSummary(driver, testCaseName, itemId);
							TabCheckoutItemSummary.clickItemSummaryMiscellaneousTab(driver, testCaseName);
							ModelItemSummaryMiscellaneous.enterFieldValue(driver, testCaseName);
							ModelItemSummaryCommon.clickItemSummarySave(driver, testCaseName);
						}

						// to fill COA form details
						if (requisition.isEditCOAInfo())
						{
							TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);

							ModelItemSummaryCostBooking.waitTillCOAFormLoaderDisplayed(driver, testCaseName);
							CostBookingAndAccountingItemSummaryCOA coa = new CostBookingAndAccountingItemSummaryCOA();
							coa.setQuantity(catelogItem.getQuantity() + "");

							// to fill COA form
							fillCOAForm(driver, testCaseName, requisition);
						}
					}
				}
			}

			// for guided items
			if (requisition.getItems().getGuidedItems() != null)
			{
				if (requisition.getItems().getGuidedItems().size() > 0)
				{
					for (GuidedItem guidedItem : requisition.getItems().getGuidedItems())
					{
						String itemId = guidedItem.getItemID();
						logger.info("Item Id : " + itemId);
						logger.info("\n### Editing item level requisition summary for Item " + i++ + " : " + guidedItem.getShortDescription());
						PageRequisitionCheckOut.clickEditItemSummary(driver, testCaseName, itemId);

						// ActionBot.waitTillPopUpIsPresent(driver,
						// IPageRequisitionCheckOut.PROGRESSING_DIV_STATUS_OVERLAY_PLEASE_WAIT);
						ActionBot.waitForPageLoad(driver);

						// PageRequisitionCheckOut.clickOnCostBookingItemEdit(driver,
						// testCaseName);

						// delivery info
						// if set in requisition object
						if (requisition.getDeliveryItemSummary() != null)
						{
							TabCheckoutItemSummary.clickItemSummaryDeliveryTab(driver, testCaseName);
							fillDeliveryItemSummary(driver, testCaseName, requisition.getDeliveryItemSummary(), itemId);
						}
						// if set in guided object
						else if (guidedItem.getDeliveryItemSummary() != null)
						{
							TabCheckoutItemSummary.clickItemSummaryDeliveryTab(driver, testCaseName);
							guidedItem.setDeliveryItemSummary(fillDeliveryItemSummary(driver, testCaseName, guidedItem.getDeliveryItemSummary(), itemId));
						}

						// assigned buyer
						if (requisition.getAssignedBuyer() != null)
							if (requisition.getAssignedBuyer() != null)
							{
								TabCheckoutItemSummary.clickItemSummaryAssignedBuyerTab(driver, testCaseName);
								PageRequisitionCheckOut.clickOnAssignedBuyerDropdown(driver, testCaseName);
								PageRequisitionCheckOut.clickOnSingleAssignedBuyer(driver, testCaseName);
								PageRequisitionCheckOut.fillAssignedBuyer(driver, testCaseName, requisition.getAssignedBuyer());
							}
						if (requisition.getAssignedBuyerGroup() != null)
						{
							TabCheckoutItemSummary.clickItemSummaryAssignedBuyerTab(driver, testCaseName);
							PageRequisitionCheckOut.clickOnAssignedBuyerDropdown(driver, testCaseName);
							PageRequisitionCheckOut.clickOnGroupAssignedBuyer(driver, testCaseName);
							PageRequisitionCheckOut.fillAssignedBuyerGroup(driver, testCaseName, requisition.getAssignedBuyerGroup());
						}

						// cost booking info
						// if set in requisition object
						if (requisition.getCostBookingItemSummary() != null)
						{
							TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
							fillCostBookingItemSummary(driver, testCaseName, requisition.getCostBookingItemSummary(), itemId);
						}
						// if set in guided object
						else if (guidedItem.getCostBookingItemSummary() != null)
						{
							TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
							guidedItem.setCostBookingItemSummary(fillCostBookingItemSummary(driver, testCaseName, guidedItem.getCostBookingItemSummary(), itemId));
						}
						// attachments/comments
						if (requisition.getAttachmentsAndCommentsItemSummary() != null)
						{
							TabCheckoutItemSummary.clickItemSummaryAttachmentTab(driver, testCaseName);
							fillAttachmentsAndComments(driver, testCaseName, requisition.getAttachmentsAndCommentsItemSummary());
						}
						else if (guidedItem.getAttachmentsAndCommentsItemSummary() != null)
						{
							TabCheckoutItemSummary.clickItemSummaryAttachmentTab(driver, testCaseName);
							guidedItem.setAttachmentsAndCommentsItemSummary(fillAttachmentsAndComments(driver, testCaseName, guidedItem.getAttachmentsAndCommentsItemSummary()));
						}

						// to edit miscellaneous section
						if (requisition.isEditMiscellaneous())
						{
							PageRequisitionCheckOut.clickEditItemSummary(driver, testCaseName, itemId);
							TabCheckoutItemSummary.clickItemSummaryMiscellaneousTab(driver, testCaseName);
							ModelItemSummaryMiscellaneous.enterFieldValue(driver, testCaseName);
							ModelItemSummaryCommon.clickItemSummarySave(driver, testCaseName);
						}

						// to fill COA form details
						if (requisition.isEditCOAInfo())
						{
							ActionBot.defaultSleep();
							TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);

							ModelItemSummaryCostBooking.waitTillCOAFormLoaderDisplayed(driver, testCaseName);
							CostBookingAndAccountingItemSummaryCOA coa = new CostBookingAndAccountingItemSummaryCOA();
							coa.setQuantity(guidedItem.getQuantity() + "");

							// to fill COA form
							fillCOAForm(driver, testCaseName, requisition);
						}
					}
				}
			}

			// for item Master items
			if (requisition.getItems().getItemMasterItems() != null)
			{
				if (requisition.getItems().getItemMasterItems().size() > 0)
				{
					for (ItemMasterItem itemMasterItem : requisition.getItems().getItemMasterItems())
					{
						String itemId = itemMasterItem.getItemId();
						logger.info("Item Id : " + itemId);
						logger.info("\n### Editing item level requisition summary for Item " + i++ + " : " + itemMasterItem.getDescription());
						PageRequisitionCheckOut.clickEditItemSummary(driver, testCaseName, itemId);

						// PageRequisitionCheckOut.clickOnCostBookingItemEdit(driver,
						// testCaseName);

						// to fill COA form details
						if (requisition.isEditCOAInfo())
						{
							ActionBot.defaultSleep();
							TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);

							ModelItemSummaryCostBooking.waitTillCOAFormLoaderDisplayed(driver, testCaseName);
							CostBookingAndAccountingItemSummaryCOA coa = new CostBookingAndAccountingItemSummaryCOA();
							coa.setQuantity(itemMasterItem.getQuantity() + "");

							// to fill COA form
							fillCOAForm(driver, testCaseName, requisition);
						}
					}
				}
			}
		}

		// total price
		requisition.setTotalPrice(PageRequisitionCheckOut.getTotalPriceAtCheckoutHead(driver, testCaseName));

		return requisition;
	}

	public static List<Search> getListOfListAdded(Item items)
	{
		List<Search> searchItem = new ArrayList<Search>();
		List<CatelogItem> catalogItems = items.getCatelogItems();
		if (catalogItems == null)
		{
			logger.info("No catalog items");
		}
		else
		{

			for (CatelogItem catelogItem : catalogItems)
			{
				Search search = new Search();
				search.setItemName(catelogItem.getItemName());
				search.setSearchQuantity(catelogItem.getQuantity());
				searchItem.add(search);
				// searchItem.add(new Search(catelogItem.getItemName(),
				// catelogItem.getQuantity()));
			}
		}

		if (items.getGuidedItems() == null)
		{
			logger.info("No guided items");
		}
		else
		{
			for (GuidedItem guidedItem : items.getGuidedItems())
			{
				searchItem.add(new Search(guidedItem.getShortDescription(), guidedItem.getQuantity()));
			}
		}

		if (items.getItemMasterItems() == null)
		{
			logger.info("No item master items");
		}
		else
		{
			for (ItemMasterItem itemMasterItem : items.getItemMasterItems())
			{
				Search search = new Search();
				search.setItemName(itemMasterItem.getName());
				search.setSearchQuantity(itemMasterItem.getQuantity());
				searchItem.add(search);
			}
		}
		return searchItem;
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
		ModelRequisitionSummaryDelivery.clickDeliveryCreateNewAddress(driver, testCaseName);

		if (deliveryRequisitionSummary.getMyAddress_Name() != null)
		{
			deliveryRequisitionSummary
				.setMyAddress_Name(ModelRequisitionSummaryDelivery.fillDeliveryNewAddressName(driver, testCaseName, deliveryRequisitionSummary.getMyAddress_Name()));
		}
		if (deliveryRequisitionSummary.getMyAddress_Street1() != null)
		{
			deliveryRequisitionSummary
				.setMyAddress_Street1(ModelRequisitionSummaryDelivery.fillDeliveryNewAddressStreet1(driver, testCaseName, deliveryRequisitionSummary.getMyAddress_Street1()));
		}
		if (deliveryRequisitionSummary.getMyAddress_Street2() != null)
		{
			deliveryRequisitionSummary
				.setMyAddress_Street2(ModelRequisitionSummaryDelivery.fillDeliveryNewAddressStreet2(driver, testCaseName, deliveryRequisitionSummary.getMyAddress_Street2()));
		}
		if (deliveryRequisitionSummary.getMyAddress_country() != null)
		{
			deliveryRequisitionSummary
				.setMyAddress_country(ModelRequisitionSummaryDelivery.fillDeliveryNewAddressCountry(driver, testCaseName, deliveryRequisitionSummary.getMyAddress_country()));
		}
		if (deliveryRequisitionSummary.getMyAddress_state() != null)
		{
			deliveryRequisitionSummary
				.setMyAddress_state(ModelRequisitionSummaryDelivery.fillDeliveryNewAddressState(driver, testCaseName, deliveryRequisitionSummary.getMyAddress_state()));
		}
		if (deliveryRequisitionSummary.getMyAddress_city() != null)
		{
			deliveryRequisitionSummary
				.setMyAddress_city(ModelRequisitionSummaryDelivery.fillDeliveryNewAddressCity(driver, testCaseName, deliveryRequisitionSummary.getMyAddress_city()));
		}
		if (deliveryRequisitionSummary.getMyAddress_zip() != 0)
		{
			deliveryRequisitionSummary
				.setMyAddress_zip(ModelRequisitionSummaryDelivery.fillDeliveryNewAddressZip(driver, testCaseName, deliveryRequisitionSummary.getMyAddress_zip()));
		}

		return deliveryRequisitionSummary;
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
			.setSelectDeliveryAddress(ModelRequisitionSummaryDelivery.fillDeliveryMyAddress(driver, testCaseName, deliveryRequisitionSummary.getSelectDeliveryAddress()));
		return deliveryRequisitionSummary;

	}

	/**
	 * <b>Author: amitkumar.dash </b> <b><br>
	 * <font color="blue">Method :</b> To select ShowAllPos <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param pono
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 * @return
	 * @return
	 */
	public static String SelctShowAllPos(WebDriver driver, String testCaseName, String PONo) throws ActionBotException
	{
		PageRequisitionCheckOut.clickOnShowAllPosBtn(driver, testCaseName);
		// click On ShowAllPos Btn
		ModalShowAllPos.fillPonoShowAllpo(driver, testCaseName, PONo);
		ModalShowAllPos.clickOnHeaderPoNo(driver, testCaseName);
		// clickon radio btn under ShowAll po Modal
		ModalShowAllPos.clickOnPoNoRadioBtn(driver, testCaseName);
		ModalShowAllPos.clickOnSelectPoBtn(driver, testCaseName);
		PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
		logger.info("Selected PO/BPO : " + PONo);
		return PONo;
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
		String totalPrice = ModelRequisitionSummaryCostBooking.getCostBookingMultiCostCenterAmount(driver, testCaseName, index);
		for (CostCenterSplitInfo costCenterSplitInfo : listOfSplitedCostCenters)
		{
			// cost center
			if (costCenterSplitInfo.getCostCenter() != null)
			{
				costCenterSplitInfo.setCostCenter(ModelRequisitionSummaryCostBooking.fillMultiCostCenterName(driver, testCaseName, costCenterSplitInfo.getCostCenter(), index));
			}

			// project
			if (costCenterSplitInfo.getProject() != null)
			{
				costCenterSplitInfo.setProject(ModelRequisitionSummaryCostBooking.fillMultiCostCenterProject(driver, testCaseName, costCenterSplitInfo.getProject(), index));
			}

			// budget
			if (costCenterSplitInfo.getBudget() != null)
			{
				costCenterSplitInfo.setBudget(ModelRequisitionSummaryCostBooking.fillMultiCostCenterBudget(driver, testCaseName, costCenterSplitInfo.getBudget(), index));
			}

			// percentage
			costCenterSplitInfo.setPercentage(ModelRequisitionSummaryCostBooking.fillMultiCostCenterPercent(driver, testCaseName, costCenterSplitInfo.getPercentage(), index));

			// price
			costCenterSplitInfo.setPrice(ModelRequisitionSummaryCostBooking.getCostBookingMultiCostCenterAmount(driver, testCaseName, index));

			// total price
			costCenterSplitInfo.setTotalPrice(totalPrice);

			// to add another cc
			if (i <= listOfSplitedCostCenters.size() - 1)
			{
				ModelRequisitionSummaryCostBooking.clickMultiAddCostCenter(driver, testCaseName, index);
			}
			i++;
			index++;
			costCenterSplitInfos.add(costCenterSplitInfo);
		}
		ScreenShot.screenshot(driver, testCaseName, "Split CC at header level");
		return costCenterSplitInfos;

	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Split delivery location to multiple <br>
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
			if (deliverySplitInfo.getDeliverTo() != null)
			{
				deliverySplitInfo.setDeliverTo(ModelItemSummaryDelivery.fillDeliveryMultiSplitDeliverTo(driver, testCaseName, deliverySplitInfo.getDeliverTo(), itemId, index));
			}
			else
			{
				deliverySplitInfo.setDeliverTo(ModelItemSummaryDelivery.getDeliveryMultiSplitDeliverTo(driver, testCaseName, itemId, index));
			}

			if (deliverySplitInfo.getDeliveryAddress() != null)
			{
				deliverySplitInfo
					.setDeliveryAddress(ModelItemSummaryDelivery.fillDeliveryMultiSplitAddress(driver, testCaseName, deliverySplitInfo.getDeliveryAddress(), itemId, index));
			}
			else
			{
				deliverySplitInfo.setDeliveryAddress(ModelItemSummaryDelivery.getDeliveryMultiSplitDeliveryAddress(driver, testCaseName, itemId, index));
			}

			// code for required by date
			if (deliverySplitInfo.getCustomDate() != null)
			{
				deliverySplitInfo.getCustomDate().setDate(ModelItemSummaryDelivery.selectRequiredByDate(driver, testCaseName, deliverySplitInfo.getCustomDate().getDay(),
					deliverySplitInfo.getCustomDate().getMonth(), deliverySplitInfo.getCustomDate().getYear(), itemId, index));
			}
			else
			{
				CustomDate customDate = new CustomDate();
				deliverySplitInfo.setCustomDate(customDate);
				deliverySplitInfo.getCustomDate().setDate(ModelItemSummaryDelivery.getDeliveryMultiSplitRequiredDate(driver, testCaseName, itemId, index));
			}

			// fill to date
			if (deliverySplitInfo.getToCustomDate() != null)
			{
				deliverySplitInfo.getToCustomDate().setDate(ModelItemSummaryDelivery.selectDeliveryUptoDate(driver, testCaseName, deliverySplitInfo.getToCustomDate().getDay(),
					deliverySplitInfo.getToCustomDate().getMonth(), deliverySplitInfo.getToCustomDate().getYear(), itemId, index));
			}

			if (deliverySplitInfo.getQuantity() != 0)
			{
				deliverySplitInfo.setQuantity(ModelItemSummaryDelivery.fillDeliveryMultiSplitQuantity(driver, testCaseName, deliverySplitInfo.getQuantity(), itemId, index));
			}

			// to add another delivery location
			if (i <= listOfSplitedDeliveryLocations.size() - 1)
			{
				ModelItemSummaryDelivery.clickDeliveryAddMultiSplit(driver, testCaseName, itemId, index);
			}
			i++;
			index++;
			deliverySplitInfos.add(deliverySplitInfo);
		}
		ScreenShot.screenshot(driver, testCaseName, "Split Delivery");
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
				.setCostCenter(ModelItemSummaryCostBooking.fillCostBookingItemSplitCostCenter(driver, testCaseName, costCenterSplitInfo.getCostCenter(), itemId, index));

			// project
			if (costCenterSplitInfo.getProject() != null)
			{
				costCenterSplitInfo.setProject(ModelItemSummaryCostBooking.fillCostBookingItemSplitProject(driver, testCaseName, costCenterSplitInfo.getProject(), itemId, index));
			}

			// budget
			if (costCenterSplitInfo.getBudget() != null)
			{
				costCenterSplitInfo.setBudget(ModelItemSummaryCostBooking.fillCostBookingItemSplitBudget(driver, testCaseName, costCenterSplitInfo.getBudget(), itemId, index));
			}

			// percentage
			if (costCenterSplitInfo.getPercentage() != 0)
			{
				costCenterSplitInfo
					.setPercentage(ModelItemSummaryCostBooking.fillCostBookingItemSplitPercentage(driver, testCaseName, costCenterSplitInfo.getPercentage(), itemId, index));
			}

			// quantity
			if (costCenterSplitInfo.getQuantity() != 0)
			{
				costCenterSplitInfo
					.setQuantity(ModelItemSummaryCostBooking.fillCostBookingItemSplitQuantity(driver, testCaseName, costCenterSplitInfo.getQuantity(), itemId, index));
			}

			// amount
			costCenterSplitInfo.setPrice(ModelItemSummaryCostBooking.getCostBookingItemSplitAmount(driver, testCaseName, itemId, index));

			// to add another cc
			if (i <= listOfSplitedCostCenters.size() - 1)
			{
				ModelItemSummaryCostBooking.clickCostBookingItemSplitAdd(driver, testCaseName, itemId, index);
			}
			i++;
			index++;
			costCenterSplitInfos.add(costCenterSplitInfo);
		}
		ScreenShot.screenshot(driver, testCaseName, "Split CC at item level");
		return costCenterSplitInfos;

	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> To submit the requisition <br>
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
	public static boolean submitReq(WebDriver driver, String testCaseName, boolean submitForApproval) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "After Filling reguisition form");
		PageRequisitionCheckOut.clickIAmDone(driver, testCaseName);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on I AM DONE");

		if (ActionBot.isElementDisplayed(driver, IPageRequisitionCheckOut.BUDGET_LINE_ERROR_MESSAGE))
		{
			logger.info(" budgets have been exhausted, expired or temporarily disabled for use");
			return false;
		}

		// to check select approver list
		// ActionBot.defaultSleep();
		if (PageRequisitionCheckOut.isApproverListPresent(driver, testCaseName))
		{
			// Checking for Selecting Approver
			boolean selectApprover = false;
			if (PageRequisitionCheckOut.isMessagePresent(driver, testCaseName))
			{
				List<WebElement> msg = PageRequisitionCheckOut.getListOfMessages(driver, testCaseName);
				for (WebElement ele : msg)
				{
					if (ele.getText().trim().contains("Please select/add approvers"))
					{
						selectApprover = true;
					}
				}
			}

			if (selectApprover)
			{
				ActionBot.defaultSleep();
				ActionBot.scroll(driver);
				List<WebElement> listOfApprover = PageRequisitionCheckOut.getListOfApprovers(driver, testCaseName);
				for (WebElement ele : listOfApprover)
				{
					if (ele.getText().trim().equalsIgnoreCase("Select approver"))
					{
						ele.click();
						ActionBot.defaultSleep();
						PageRequisitionCheckOut.clickOnSelectApprovalButton(driver, testCaseName);
					}
				}
			}
			PageRequisitionCheckOut.clickIAmDone(driver, testCaseName);
			ScreenShot.screenshot(driver, testCaseName, "After clicking on I AM DONE");
		}

		// to submit the req
		// for forking
		if (PageRequisitionCheckOut.isConfirmReqPresent(driver, testCaseName))
		{
			PageRequisitionCheckOut.clickOnConfirmReqButton(driver, testCaseName);
		}
		// normal flow
		else
		{
			PageRequisitionCheckOut.clickOnConfirmContinueButton(driver, testCaseName);
		}

		// ActionBot.defaultSleep();
		// PageRequisitionCheckOut.waitForUpdateRequisitionProcessingDiv(driver,
		// testCaseName);
		if (submitForApproval)
		{
			// ready for approval stage
			if (PageRequisitionView.isSubmitForApprovalButtonPresent(driver, testCaseName))
			{
				PageRequisitionView.clickOnSubmitForApproval(driver, testCaseName);
			}
		}

		if (PopUpSendForApproval.isSendForApprovalYesButtonPresent(driver, testCaseName))
		{
			PopUpSendForApproval.clickOnSendForApprovalYesButton(driver, testCaseName);
		}
		PageRequisitionCheckOut.waitTillReqSubmitProcessingDivPresent(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
		// ActionBot.waitTillPopUpIsPresent(driver,
		// IPageMyRequisition.REQ_LIST_PROCESSING);
		// ActionBot.findElement(driver, IPageMyRequisition.ADD_REQ_BUTTON);
		return PageMyRequisition.isAddReqButtonPresent(driver, testCaseName);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> To save the requisition <br>
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
	public static boolean saveReqAsDraft(WebDriver driver, String testCaseName) throws Exception
	{
		PageRequisitionCheckOut.clickSaveAsDraft(driver, testCaseName);
		PageRequisitionCheckOut.waitForUpdateRequisitionProcessingDiv(driver, testCaseName);
		ActionBot.waitTillPopUpIsPresent(driver, IPageRequisitionCheckOut.DRAFT_SAVED_SUCCESS);
		ActionBot.waitTillPopUpIsPresent(driver, IPageMyRequisition.REQ_LIST_PROCESSING);
		return PageMyRequisition.isAddReqButtonPresent(driver, testCaseName);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> To cancel the requisition <br>
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
	public static boolean cancelReq(WebDriver driver, String testCaseName) throws ActionBotException
	{
		PageRequisitionCheckOut.clickCancleRequisition(driver, testCaseName);
		PageRequisitionCheckOut.waitForUpdateRequisitionProcessingDiv(driver, testCaseName);
		return PageMyRequisition.isAddReqButtonPresent(driver, testCaseName);
	}

	public static List<DeliverySplitInfo> getDeliverySplitInfoOnCheckoutPage(WebDriver driver, String testCaseName, String itemId, int noOfSplit) throws ActionBotException
	{
		int index = 2;
		List<DeliverySplitInfo> deliverySplitInfos = new ArrayList<DeliverySplitInfo>();
		DeliverySplitInfo deliverySplitInfo1 = new DeliverySplitInfo();
		DeliverySplitInfo deliverySplitInfo2 = new DeliverySplitInfo();
		CustomDate customDate = new CustomDate();

		deliverySplitInfo1.setDeliverTo(PageRequisitionCheckOut.getDeliveryMultiSplitDeliverTo(driver, testCaseName, itemId, index));
		deliverySplitInfo1.setDeliveryAddress(PageRequisitionCheckOut.getDeliveryMultiSplitDeliveryAddress(driver, testCaseName, itemId, index));
		deliverySplitInfo1.setQuantity(PageRequisitionCheckOut.getDeliveryMultiSplitQuantity(driver, testCaseName, itemId, index));
		customDate.setDate(PageRequisitionCheckOut.getDeliveryMultiSplitRequiredDate(driver, testCaseName, itemId, index));
		deliverySplitInfo1.setCustomDate(customDate);

		index++;
		deliverySplitInfo2.setDeliverTo(PageRequisitionCheckOut.getDeliveryMultiSplitDeliverTo(driver, testCaseName, itemId, index));
		deliverySplitInfo2.setDeliveryAddress(PageRequisitionCheckOut.getDeliveryMultiSplitDeliveryAddress(driver, testCaseName, itemId, index));
		deliverySplitInfo2.setQuantity(PageRequisitionCheckOut.getDeliveryMultiSplitQuantity(driver, testCaseName, itemId, index));
		customDate.setDate(PageRequisitionCheckOut.getDeliveryMultiSplitRequiredDate(driver, testCaseName, itemId, index));
		deliverySplitInfo2.setCustomDate(customDate);

		deliverySplitInfos.add(deliverySplitInfo1);
		deliverySplitInfos.add(deliverySplitInfo2);

		return deliverySplitInfos;
	}

	public static boolean checkIfDeliverySplitAtItemLevel(List<DeliverySplitInfo> deliverySplitInfos, List<DeliverySplitInfo> deliverySplitInfosOnCheckoutPage)
	{
		int index = 0;
		boolean flag = false;
		for (DeliverySplitInfo deliverySplitInfo : deliverySplitInfos)
		{
			String[] temp;
			String var = null;
			if (deliverySplitInfosOnCheckoutPage.get(index).getDeliveryAddress().contains(" "))
			{
				temp = StringUtils.split(deliverySplitInfosOnCheckoutPage.get(index).getDeliveryAddress(), " ");
				deliverySplitInfosOnCheckoutPage.get(index).setDeliveryAddress(temp[0]);
			}

			if (deliverySplitInfo.getDeliveryAddress().contains(" "))
			{
				temp = StringUtils.split(deliverySplitInfo.getDeliveryAddress(), " ");
				deliverySplitInfo.setDeliveryAddress(temp[0]);
			}

			if (deliverySplitInfo.getToCustomDate() != null)
			{
				var = deliverySplitInfo.getCustomDate().getDate().trim() + " to " + deliverySplitInfo.getToCustomDate().getDate().trim();
				flag = var.equalsIgnoreCase(deliverySplitInfosOnCheckoutPage.get(index).getCustomDate().getDate());

			}
			else
			{
				var = deliverySplitInfo.getCustomDate().getDate().trim();
			}

			flag = deliverySplitInfo.getDeliverTo().equalsIgnoreCase(deliverySplitInfosOnCheckoutPage.get(index).getDeliverTo())
				&& deliverySplitInfosOnCheckoutPage.get(index).getDeliveryAddress().contains(deliverySplitInfo.getDeliveryAddress())
				&& deliverySplitInfo.getQuantity() == deliverySplitInfosOnCheckoutPage.get(index).getQuantity()
				&& var.equalsIgnoreCase(deliverySplitInfosOnCheckoutPage.get(index).getCustomDate().getDate());

			index++;
		}
		return flag;
	}

	public static List<CostCenterSplitInfo> getCostCenterSplitInfoOnCheckoutPage(WebDriver driver, String testCaseName, String itemId, int noOfSplit) throws ActionBotException
	{
		int index = 2;
		List<CostCenterSplitInfo> costCenterSplitInfos = new ArrayList<CostCenterSplitInfo>();
		CostCenterSplitInfo centerSplitInfo1 = new CostCenterSplitInfo();
		CostCenterSplitInfo centerSplitInfo2 = new CostCenterSplitInfo();

		logger.info("Cost center split info on checkout page : ");
		centerSplitInfo1.setCostCenter(PageRequisitionCheckOut.getCostBookingMultiSplitAtItemLevelCostCenter(driver, testCaseName, itemId, index));
		centerSplitInfo1.setBudget(PageRequisitionCheckOut.getCostBookingMultiSplitAtItemLevelBudget(driver, testCaseName, itemId, index));
		centerSplitInfo1.setProject(PageRequisitionCheckOut.getCostBookingMultiSplitAtItemLevelProject(driver, testCaseName, itemId, index));
		centerSplitInfo1.setPrice(PageRequisitionCheckOut.getCostBookingMultiSplitAtItemLevelPrice(driver, testCaseName, itemId, index));

		index = index + 1;

		centerSplitInfo2.setCostCenter(PageRequisitionCheckOut.getCostBookingMultiSplitAtItemLevelCostCenter(driver, testCaseName, itemId, index));
		centerSplitInfo2.setBudget(PageRequisitionCheckOut.getCostBookingMultiSplitAtItemLevelBudget(driver, testCaseName, itemId, index));
		centerSplitInfo2.setProject(PageRequisitionCheckOut.getCostBookingMultiSplitAtItemLevelProject(driver, testCaseName, itemId, index));
		centerSplitInfo2.setPrice(PageRequisitionCheckOut.getCostBookingMultiSplitAtItemLevelPrice(driver, testCaseName, itemId, index));

		costCenterSplitInfos.add(centerSplitInfo1);
		costCenterSplitInfos.add(centerSplitInfo2);
		return costCenterSplitInfos;
	}

	public static boolean checkIfCostCenterSplit(List<CostCenterSplitInfo> costCenterSplitInfos, List<CostCenterSplitInfo> costCenterSplitInfosOnCheckoutPage)
	{
		int index = 0;
		List<CostCenterSplitInfo> costCenterSplitInfos2 = new ArrayList<CostCenterSplitInfo>();
		boolean flag = false;
		for (CostCenterSplitInfo costCenterSplitInfo : costCenterSplitInfos)
		{
			costCenterSplitInfo = CommonUtilities.getProperCC_Budget_Project(costCenterSplitInfo);
			costCenterSplitInfos2.add(CommonUtilities.getProperCC_Budget_Project(costCenterSplitInfosOnCheckoutPage.get(index)));

			if (costCenterSplitInfos2.get(index).getCostCenter().equalsIgnoreCase(costCenterSplitInfo.getCostCenter()))
			{
				flag = true;
				// for budget
				if (costCenterSplitInfos2.get(index).getBudget() != null)
				{
					if (costCenterSplitInfos2.get(index).getBudget().equalsIgnoreCase(costCenterSplitInfo.getBudget()))
					{
						flag = true;
					}
					else
					{
						flag = false;
					}
				}
				// for project
				if (costCenterSplitInfos2.get(index).getProject() != null)
				{
					if (costCenterSplitInfos2.get(index).getProject().equalsIgnoreCase(costCenterSplitInfo.getProject()))
					{
						flag = true;
					}
					else
					{
						flag = false;
					}
				}
				// for price
				if (costCenterSplitInfos2.get(index).getPrice().equalsIgnoreCase(costCenterSplitInfo.getPrice()))
				{
					flag = true;
				}
				else
				{
					flag = false;
				}
			}
			else
			{
				flag = false;
			}
			index = index + 1;
		}
		return flag;
	}

	public static List<CostCenterSplitInfo> splitCCProportionalToDelivery(WebDriver driver, String testCaseName, List<CostCenterSplitInfo> centerSplitInfos, String itemId)
		throws ActionBotException
	{
		int index = 0;
		List<CostCenterSplitInfo> centerSplitInfos2 = new ArrayList<CostCenterSplitInfo>();
		for (CostCenterSplitInfo costCenterSplitInfo : centerSplitInfos)
		{
			if (costCenterSplitInfo.getCostCenter() != null)
			{
				costCenterSplitInfo
					.setCostCenter(ModelItemSummaryCostBooking.fillCostBookingItemSplitCostCenter(driver, testCaseName, costCenterSplitInfo.getCostCenter(), itemId, index));
			}
			else
			{
				costCenterSplitInfo.setCostCenter(ModelItemSummaryCostBooking.getCostCenterForCCSplitPropotionalToDelivery(driver, testCaseName, itemId, index));
			}

			if (costCenterSplitInfo.getProject() != null)
			{
				costCenterSplitInfo.setProject(ModelItemSummaryCostBooking.fillCostBookingItemSplitProject(driver, testCaseName, costCenterSplitInfo.getProject(), itemId, index));
			}

			if (costCenterSplitInfo.getBudget() != null)
			{
				costCenterSplitInfo.setBudget(ModelItemSummaryCostBooking.fillCostBookingItemSplitBudget(driver, testCaseName, costCenterSplitInfo.getBudget(), itemId, index));
			}

			costCenterSplitInfo.setDeliverTo(ModelItemSummaryCostBooking.getDeliverToForCCSplitPropotionalToDelivery(driver, testCaseName, itemId, index));

			costCenterSplitInfo.setDeliveryAddress(ModelItemSummaryCostBooking.getDeliveryAddressForCCSplitPropotionalToDelivery(driver, testCaseName, itemId, index));

			costCenterSplitInfo.setQuantity(ModelItemSummaryCostBooking.getQuantityForCCSplitPropotionalToDelivery(driver, testCaseName, itemId, index));

			costCenterSplitInfo.setPrice(ModelItemSummaryCostBooking.getAmountForCCSplitPropotionalToDelivery(driver, testCaseName, itemId, index));

			centerSplitInfos2.add(costCenterSplitInfo);
			index++;
		}
		ScreenShot.screenshot(driver, testCaseName, "Split CC at item level proportional to delivery");
		return centerSplitInfos2;

	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To check cost center split amount <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param requisition
	 *        </font><b><br>
	 * @return </b> <br>
	 */
	public static boolean checkCostCenterSplitAmount(Requisition requisition)
	{
		boolean flag = false;
		String price1 = null, price2 = null, totalPrice = null;
		float calculatedPrice1 = 0, calculatedPrice2 = 0, unitPrice;
		int totalQuantity = 0;
		// to check proper split price
		totalPrice = CommonUtilities.getDecimalPriceAlongWithCurrency(requisition.getTotalPrice());
		if (requisition.getCostBookingRequisitionSummary().isSplitCostToMultipleCostCenter())
		{
			price1 = CommonUtilities.getRoundedDecimalPriceAlongWithCurrency(requisition.getCostBookingRequisitionSummary().getListOfSplitedCostCenters().get(0).getPrice());
			price2 = CommonUtilities.getRoundedDecimalPriceAlongWithCurrency(requisition.getCostBookingRequisitionSummary().getListOfSplitedCostCenters().get(1).getPrice());

			if (requisition.getCostBookingRequisitionSummary().getListOfSplitedCostCenters().get(0).getPercentage() != 0)
			{
				calculatedPrice1 = CommonUtilities.calculatePercentageOf(Float.parseFloat(totalPrice),
					requisition.getCostBookingRequisitionSummary().getListOfSplitedCostCenters().get(0).getPercentage());
				calculatedPrice2 = CommonUtilities.calculatePercentageOf(Float.parseFloat(totalPrice),
					requisition.getCostBookingRequisitionSummary().getListOfSplitedCostCenters().get(1).getPercentage());
			}
		}
		else if (requisition.getCostBookingRequisitionSummary().isSplitCostAtLineItemLevel())
		{
			price1 = CommonUtilities.getRoundedDecimalPriceAlongWithCurrency(requisition.getCostBookingItemSummary().getCostCenterSplitInfo().get(0).getPrice());
			price2 = CommonUtilities.getRoundedDecimalPriceAlongWithCurrency(requisition.getCostBookingItemSummary().getCostCenterSplitInfo().get(1).getPrice());

			if (requisition.getCostBookingItemSummary() != null)
			{
				// percentage
				if (requisition.getCostBookingItemSummary().isSplitCostCenterAtItemLevel_percentage())
				{
					calculatedPrice1 = CommonUtilities.calculatePercentageOf(Float.parseFloat(totalPrice),
						requisition.getCostBookingItemSummary().getCostCenterSplitInfo().get(0).getPercentage());
					calculatedPrice2 = CommonUtilities.calculatePercentageOf(Float.parseFloat(totalPrice),
						requisition.getCostBookingItemSummary().getCostCenterSplitInfo().get(1).getPercentage());
				}
				// quantity
				else
				{
					totalQuantity = requisition.getCostBookingItemSummary().getCostCenterSplitInfo().get(0).getQuantity()
						+ requisition.getCostBookingItemSummary().getCostCenterSplitInfo().get(1).getQuantity();
					unitPrice = Float.parseFloat(totalPrice) / totalQuantity;

					calculatedPrice1 = (float) CommonUtilities.calculatePrice(unitPrice, requisition.getCostBookingItemSummary().getCostCenterSplitInfo().get(0).getQuantity());
					calculatedPrice2 = (float) CommonUtilities.calculatePrice(unitPrice, requisition.getCostBookingItemSummary().getCostCenterSplitInfo().get(2).getQuantity());

				}
			}
		}

		logger.info("Total Price : " + totalPrice);
		logger.info("First Cost Center Split Price : " + price1);
		logger.info("Second Cost Center Split Price : " + price2);

		// calculatedPrice1 = Math.round(calculatedPrice1);
		// calculatedPrice2 = Math.round(calculatedPrice2);

		calculatedPrice1 = Float.parseFloat(CommonUtilities.getRoundedDecimalPrice(Float.toString(calculatedPrice1)));
		calculatedPrice2 = Float.parseFloat(CommonUtilities.getRoundedDecimalPrice(Float.toString(calculatedPrice2)));

		logger.info("Calculated First Cost Center Split Price : " + calculatedPrice1);
		logger.info("Calculated Second Cost Center Split Price : " + calculatedPrice2);

		flag = Float.parseFloat(price1) == calculatedPrice1 && Float.parseFloat(price2) == calculatedPrice2;
		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To check amount of cost center split at
	 * item level <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param requisition
	 *        </font><b><br>
	 * @return </b> <br>
	 */
	public static boolean checkAmountOfCostCenterSplitAtItemLevel(CostBookingItemSummary costBookingItemSummary)
	{
		boolean flag = false;
		String price1 = null, price2 = null, total_Price = null;
		float calculatedPrice1 = 0, calculatedPrice2 = 0, unitPrice;
		int totalQuantity = 0;
		// to check proper split price
		total_Price = CommonUtilities.getDecimalPriceAlongWithCurrency(costBookingItemSummary.getSubTotalPrice());

		price1 = CommonUtilities.getRoundedDecimalPriceAlongWithCurrency(costBookingItemSummary.getCostCenterSplitInfo().get(0).getPrice());
		price2 = CommonUtilities.getRoundedDecimalPriceAlongWithCurrency(costBookingItemSummary.getCostCenterSplitInfo().get(1).getPrice());

		// percentage
		if (costBookingItemSummary.isSplitCostCenterAtItemLevel_percentage())
		{
			calculatedPrice1 = CommonUtilities.calculatePercentageOf(Float.parseFloat(total_Price), costBookingItemSummary.getCostCenterSplitInfo().get(0).getPercentage());
			calculatedPrice2 = CommonUtilities.calculatePercentageOf(Float.parseFloat(total_Price), costBookingItemSummary.getCostCenterSplitInfo().get(1).getPercentage());
		}
		// quantity
		else
		{
			totalQuantity = costBookingItemSummary.getCostCenterSplitInfo().get(0).getQuantity() + costBookingItemSummary.getCostCenterSplitInfo().get(1).getQuantity();
			unitPrice = Float.parseFloat(total_Price) / totalQuantity;

			calculatedPrice1 = (float) CommonUtilities.calculatePrice(unitPrice, costBookingItemSummary.getCostCenterSplitInfo().get(0).getQuantity());
			calculatedPrice2 = (float) CommonUtilities.calculatePrice(unitPrice, costBookingItemSummary.getCostCenterSplitInfo().get(1).getQuantity());

		}

		logger.info("Total Price : " + total_Price);
		logger.info("First Cost Center Split Price : " + price1);
		logger.info("Second Cost Center Split Price : " + price2);

		// calculatedPrice1 = Math.round(calculatedPrice1);
		// calculatedPrice2 = Math.round(calculatedPrice2);

		calculatedPrice1 = Float.parseFloat(CommonUtilities.getRoundedDecimalPrice(Float.toString(calculatedPrice1)));
		calculatedPrice2 = Float.parseFloat(CommonUtilities.getRoundedDecimalPrice(Float.toString(calculatedPrice2)));

		logger.info("Calculated First Cost Center Split Price : " + calculatedPrice1);
		logger.info("Calculated Second Cost Center Split Price : " + calculatedPrice2);

		flag = Float.parseFloat(CommonUtilities.getRoundedDecimalPrice(price1)) == calculatedPrice1
			&& Float.parseFloat(CommonUtilities.getRoundedDecimalPrice(price2)) == calculatedPrice2;
		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To check amount of cost center split at
	 * header level <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param requisition
	 *        </font><b><br>
	 * @return </b> <br>
	 */
	public static boolean checkAmountOfCostCenterSplitAtHeaderLevel(CostBookingRequisitionSummary costBookingRequisitionSummary, String reqTotalPrice)
	{
		boolean flag = false;
		String price1 = null, price2 = null, totalPrice = null;
		float calculatedPrice1 = 0, calculatedPrice2 = 0;
		// to check proper split price
		totalPrice = CommonUtilities.getDecimalPriceAlongWithCurrency(reqTotalPrice);

		price1 = CommonUtilities.getRoundedDecimalPriceAlongWithCurrency(costBookingRequisitionSummary.getListOfSplitedCostCenters().get(0).getPrice());
		price2 = CommonUtilities.getRoundedDecimalPriceAlongWithCurrency(costBookingRequisitionSummary.getListOfSplitedCostCenters().get(1).getPrice());

		calculatedPrice1 = CommonUtilities.calculatePercentageOf(Float.parseFloat(totalPrice), costBookingRequisitionSummary.getListOfSplitedCostCenters().get(0).getPercentage());
		calculatedPrice2 = CommonUtilities.calculatePercentageOf(Float.parseFloat(totalPrice), costBookingRequisitionSummary.getListOfSplitedCostCenters().get(1).getPercentage());

		logger.info("Total Price : " + totalPrice);
		logger.info("First Cost Center Split Price : " + price1);
		logger.info("Second Cost Center Split Price : " + price2);

		// calculatedPrice1 = Math.round(calculatedPrice1);
		// calculatedPrice2 = Math.round(calculatedPrice2);

		calculatedPrice1 = Float.parseFloat(CommonUtilities.getRoundedDecimalPrice(Float.toString(calculatedPrice1)));
		calculatedPrice2 = Float.parseFloat(CommonUtilities.getRoundedDecimalPrice(Float.toString(calculatedPrice2)));

		logger.info("Calculated First Cost Center Split Price : " + calculatedPrice1);
		logger.info("Calculated Second Cost Center Split Price : " + calculatedPrice2);

		flag = Float.parseFloat(CommonUtilities.getRoundedDecimalPrice(price1)) == calculatedPrice1
			&& Float.parseFloat(CommonUtilities.getRoundedDecimalPrice(price2)) == calculatedPrice2;
		return flag;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To add item and checkout <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param item
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	public static Item addItemAndCheckout(WebDriver driver, String testCaseName, Item item) throws Exception
	{
		// to add items
		Item items = FlowSearchListing.addItem(driver, testCaseName, item);

		boolean flag = VerifyShoppingItemsWithShoppingCarts.checkIfItemsAddedToCart(driver, testCaseName, items);
		assertTrue("Item added to cart are wrong", flag);
		ModalShoppingCart.continueWithCart(driver, testCaseName);

		// to checkout
		PageSearchListing.clickOnCheckOutButton(driver, testCaseName);

		return items;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Override GL Account <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param overrideGlAccount
	 *        </font><b><br>
	 * @throws ActionBotException
	 *         </b> <br>
	 */
	public static void overrideGLAccount(WebDriver driver, String testCaseName, boolean overrideGlAccount) throws ActionBotException
	{
		// to overrideGLAccount
		if (overrideGlAccount)
		{
			if (PopUpDeleteConfirmation.isYesButtonPresent(driver, testCaseName))
			{
				PopUpDeleteConfirmation.clickOnYesButton(driver, testCaseName);
			}
		}
		else
		{
			if (PopUpDeleteConfirmation.isNoButtonPresent(driver, testCaseName))
			{
				PopUpDeleteConfirmation.clickOnNoButton(driver, testCaseName);
			}
		}
		ScreenShot.screenshot(driver, testCaseName, "After Selecting Purchase Type");
	}

	public static void viewItemDetails(WebDriver driver, String testCaseName, String itemId) throws ActionBotException
	{
		PageRequisitionCheckOut.clickOnItemNameToViewItemDetails(driver, testCaseName, itemId);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To change guided item details on checkout
	 * page <br>
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
	public static GuidedItem changeGuidedItemDetailsOnCheckoutPage(WebDriver driver, String testCaseName, GuidedItem guidedItem) throws ActionBotException, FactoryMethodException
	{
		GuidedItem changedGuidedItem = new GuidedItem();

		// price
		if (guidedItem.getPrice() != 0)
		{
			guidedItem.setPrice(ModalGuidedItemDetails.fillPrice(driver, testCaseName, guidedItem.getPrice()));
		}
		// currency
		if (guidedItem.getCurrency() != null)
		{
			guidedItem.setCurrency(ModalGuidedItemDetails.fillCurrency(driver, testCaseName, guidedItem.getCurrency()));
		}
		// product category
		if (guidedItem.getCategory() != null)
		{
			ModalGuidedItemSelectCategory guidedItemSelectCategory = new ModalGuidedItemSelectCategory();
			guidedItemSelectCategory.setCategory(ModalGuidedItemDetails.fillProductCategory(driver, testCaseName, guidedItem.getCategory().getCategory()));
			if (PageBuyersDesk.isEformDialogPresent(driver, testCaseName))
			{
				if (guidedItem.getCategory().getCategoryEFormName() != null)
					PageBuyersDesk.selectEFormForCategoryNamewise(driver, testCaseName, guidedItem.getCategory().getCategoryEFormName());

				else
				{
					ActionBot.click(driver, IModalGuidedItemDetails.FIRST_EFORM_NAME_LINK);
					ActionBot.defaultSleep();
				}
			}
			// if (ModalSelectCategory.isSelectEformIsPresent(driver,
			// testCaseName))
			// {
			// ModalSelectCategory.clickOnSelectEform(driver, testCaseName);
			// // click on continue btn
			// PopUpSelectCategoryEForm.toClickContinueBtn(driver,
			// testCaseName);
			// }else
			// {
			// ModalSelectCategory.toClickSelectThisCategoryLink(driver,
			// testCaseName);
			// // click on continue btn
			// PopUpSelectCategoryEForm.toClickContinueBtn(driver,
			// testCaseName);
			// }
			changedGuidedItem.setCategory(guidedItemSelectCategory);
		}
		// item type
		if (guidedItem.getItemType() != null)
		{
			if (guidedItem.getItemType().equalsIgnoreCase(IConstantsData.Goods))
			{
				ModalGuidedItemDetails.clickOnItemTypeGoods(driver, testCaseName);
			}
			else
			{
				ModalGuidedItemDetails.clickOnItemTypeServices(driver, testCaseName);
			}
		}
		// supplier contract
		if (guidedItem.getSuppliercontract() != null)
		{
			ModalGuidedItemDetails.clickOnSupplierDetailsTab(driver, testCaseName);
			ModalGuidedItemSelectSupplierContract guidedItemSelectSupplierContract = new ModalGuidedItemSelectSupplierContract();
			guidedItemSelectSupplierContract.setcontract(ModalGuidedItemDetails.fillSupplierContract(driver, testCaseName, guidedItem.getContractNo()));
		}
		// supplier name
		if (guidedItem.getSupplierName() != null)
		{
			ModalGuidedItemDetails.clickOnSupplierDetailsTab(driver, testCaseName);
			ModalGuidedItemSelectSupplierName guidedItemSelectSupplierName = new ModalGuidedItemSelectSupplierName();
			guidedItemSelectSupplierName.setSuppliersName(ModalGuidedItemDetails.fillSuplierName(driver, testCaseName, guidedItem.getSupplierName()));
		}
		if (guidedItem.getNextAction().equalsIgnoreCase(IConstantsData.SAVE))
		{
			ModalGuidedItemDetails.clickOnOkButton(driver, testCaseName);
		}
		else if (guidedItem.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			ModalGuidedItemDetails.clickOnCancelButton(driver, testCaseName);
		}
		else
		{
			logger.info("Invalid next action");
		}

		return changedGuidedItem;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To check whether the same glAccount is
	 * present as glmap <br>
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
	public static boolean isGLAccountSameAsGLMap(WebDriver driver, String testCaseName, GLMap glMap, String itemID) throws ActionBotException, FactoryMethodException
	{
		String glAccount = PageRequisitionCheckOut.getAccountingInExpandAll(driver, testCaseName, itemID);
		String temp[] = StringUtils.split(glAccount, ":");
		String gl_Account = temp[1].trim();
		if (gl_Account.equalsIgnoreCase(glMap.getGlAccount()))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Change Multiple <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param changeMultiple
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </font><b><br>
	 * @throws FactoryMethodException
	 *         </b> <br>
	 */
	public static ChangeMultiple changeMultiple(WebDriver driver, String testCaseName, ChangeMultiple changeMultiple) throws ActionBotException, FactoryMethodException
	{
		PageRequisitionCheckOut.clickCheckboxAllItems(driver, testCaseName);
		PageRequisitionCheckOut.clickChangeMultiple(driver, testCaseName);
		if (changeMultiple.getGlAccount() != null)
		{
			changeMultiple.setGlAccount(ModelChangeMultiple.fillChangeMultipleGLAccount(driver, testCaseName, changeMultiple.getGlAccount()));
		}
		if (changeMultiple.getCostCenter() != null)
		{
			changeMultiple.setCostCenter(ModelChangeMultiple.fillChangeMultipleCostCenter(driver, testCaseName, changeMultiple.getCostCenter()));
		}
		if (changeMultiple.getProject() != null)
		{
			changeMultiple.setProject(ModelChangeMultiple.fillChangeMultipleProject(driver, testCaseName, changeMultiple.getProject()));
		}
		if (changeMultiple.getBudget() != null)
		{
			changeMultiple.setBudget(ModelChangeMultiple.fillChangeMultipleBudget(driver, testCaseName, changeMultiple.getBudget()));
		}
		if (changeMultiple.getRequiredByDate() != null)
		{
			ModelChangeMultiple.clickDeliveryTab(driver, testCaseName);
			changeMultiple.getRequiredByDate().setDate(ModelChangeMultiple.selectRequiredByDate(driver, testCaseName, changeMultiple.getRequiredByDate().getDay(),
				changeMultiple.getRequiredByDate().getMonth(), changeMultiple.getRequiredByDate().getYear()));
		}
		ModelChangeMultiple.clickChangeMultipleApply(driver, testCaseName);
		return changeMultiple;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> Get Suggested New Supplier From Requested
	 * Selected Suppliers Table <br>
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
	public static GuidedItemSuggestSupplier getSuggestedNewSupplierFromRequestedSelectedSuppliersTable(WebDriver driver, String testCaseName)
		throws ActionBotException, FactoryMethodException
	{
		GuidedItemSuggestSupplier guidedItemSuggestSupplier = new GuidedItemSuggestSupplier();
		guidedItemSuggestSupplier.setSuggestNewSupplierName(ModalGuidedItemDetails.getFirstSuggestNewSupplierFromRequestedSelectedSupplier(driver, testCaseName));
		guidedItemSuggestSupplier.setSupplierAddress(ModalGuidedItemDetails.getFirstSuggestNewSupplierAddressFromRequestedSelectedSupplier(driver, testCaseName));
		guidedItemSuggestSupplier.setSupplierContact(ModalGuidedItemDetails.getFirstSuggestNewSupplierContactFromRequestedSelectedSupplier(driver, testCaseName));
		/*
		 * guidedItemSuggestSupplier.setContractNo(ModalGuidedItemDetails
		 * .getFirstSuggestNewContractNoFromRequestedSelectedSupplier(driver,
		 * testCaseName));
		 */
		return guidedItemSuggestSupplier;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> Fill existing supplier details <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param existingSupplier
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </font><b><br>
	 * @throws FactoryMethodException
	 *         </b> <br>
	 */
	public static ExistingSupplier fillExistingSupplierDetails(WebDriver driver, String testCaseName, ExistingSupplier existingSupplier)
		throws ActionBotException, FactoryMethodException
	{
		if (existingSupplier.getSupplierName() != null)
		{
			existingSupplier.setSupplierName(ModalGuidedItemDetails.fillExistingSupplierName(driver, testCaseName, existingSupplier.getSupplierName()));
		}
		existingSupplier.setSupplierAddress(ModalGuidedItemDetails.selectSupplierAddressForExistingSupplier(driver, testCaseName, existingSupplier.getSupplierAddress()));
		if (existingSupplier.getSupplierContact() != null)
		{
			existingSupplier.setSupplierContact(ModalGuidedItemDetails.fillSupplierContactForExistingSupplier(driver, testCaseName, existingSupplier.getSupplierContact()));
		}
		if (existingSupplier.getEmailId() != null)
		{
			existingSupplier.setEmailId(ModalGuidedItemDetails.fillSupplierEmailIdForExistingSupplier(driver, testCaseName, existingSupplier.getEmailId()));
		}
		if (existingSupplier.getPhone() != null)
		{
			existingSupplier.setPhone(ModalGuidedItemDetails.fillSupplierPhoneForExistingSupplier(driver, testCaseName, existingSupplier.getPhone()));
		}
		if (existingSupplier.getContractNo() != null)
		{
			existingSupplier.setContractNo(ModalGuidedItemDetails.fillContractNoForExistingSupplier(driver, testCaseName, existingSupplier.getContractNo()));
		}
		if (existingSupplier.getOtherDetails() != null)
		{
			existingSupplier.setOtherDetails(ModalGuidedItemDetails.fillOtherDetailsForExistingSupplier(driver, testCaseName, existingSupplier.getOtherDetails()));
		}

		if (existingSupplier.getNextAction().equalsIgnoreCase(IConstantsData.SAVE))
		{
			ModalGuidedItemDetails.clickOnOkButton(driver, testCaseName);
		}
		else if (existingSupplier.getNextAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			ModalGuidedItemDetails.clickOnCancelButton(driver, testCaseName);
		}

		return existingSupplier;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Get existing supplier details from item
	 * detail modal <br>
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
	public static ExistingSupplier getExistingSupplierDetailsInItemDetailsModal(WebDriver driver, String testCaseName) throws ActionBotException, FactoryMethodException
	{
		ExistingSupplier existingSupplier = new ExistingSupplier();
		existingSupplier.setSupplierContact(ModalGuidedItemDetails.getSupplierContactForExistingSupplier(driver, testCaseName));
		existingSupplier.setEmailId(ModalGuidedItemDetails.getSupplierEmailIdForExistingSupplier(driver, testCaseName));
		existingSupplier.setPhone(ModalGuidedItemDetails.getSupplierPhoneForExistingSupplier(driver, testCaseName));
		existingSupplier.setContractNo(ModalGuidedItemDetails.getContractNoForExistingSupplier(driver, testCaseName));
		existingSupplier.setOtherDetails(ModalGuidedItemDetails.getOtherDetailsForExistingSupplier(driver, testCaseName));

		return existingSupplier;
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>Get existing supplier details from item
	 * detail modal <br>
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
	 * @throws Exception
	 */

	public static String fillReqDetailsForBuyerDeskTC(WebDriver driver, String testCaseName, String reqNumber) throws Exception

	{
		String purchaseType = null;
		ActionBot.waitForPageLoad(driver);
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

		ActionBot.scroll(driver, "1000");
		ActionBot.defaultSleep();
		PageRequisitionCheckOut.clickIAmDone(driver, testCaseName);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on I AM DONE");
		PageRequisitionCheckOut.clickContinueButtonForConfirmPopup(driver, testCaseName);
		ScreenShot.screenshot(driver, testCaseName, "After clicking Continue Button");

		// getting created req number
		reqNumber = PageBuyersDesk.getCreatedReqNumber(driver, testCaseName, reqNumber);
		return reqNumber;
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>Change Company/BusinessUnit/Locaiton of
	 * user <br>
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
	 * @throws Exception
	 */
	public static void changeCompanyBULocationOfUser(WebDriver driver, String testCaseName) throws Exception
	{
		ModelBuyersdeskSummaryBilling.fillBillingCompany(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_Company_Name));
		ModelBuyersdeskSummaryBilling.fillBillingBU(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_BusinessUnit));
		ModelBuyersdeskSummaryBilling.fillBillingLocation(driver, testCaseName, CommonServices.getTestData(IConstantsData.Other_Location));

	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>Submit Requisition <br>
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
	 * @throws Exception
	 */
	public static void submitRequisiiton(WebDriver driver, String testCaseName) throws Exception
	{
		PageRequisitionCheckOut.clickIAmDone(driver, testCaseName);
		PageRequisitionCheckOut.clickContinueButtonForConfirmPopup(driver, testCaseName);
	}

	/**
	 * <b>Author: raj.singh </b> <b><br>
	 * <font color="blue">Method :</b>fill checkoutForm for mandatory fields
	 * <br>
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
	 * @throws Exception
	 */

	public static boolean fillCheckOutRequistionSummary(WebDriver driver, String testCaseName) throws Exception

	{
		Requisition requisition = ObjectCreation.getRequisition(driver);
		ActionBot.waitForPageLoad(driver);

		requisition.setReqName(CommonServices.getTestData(IConstantsData.SPECIAL_CHAR_USER) + Helper.getRandomString(5));
		ActionBot.defaultLowSleep();
		PageRequisitionCheckOut.fillCheckoutReqName(driver, testCaseName, requisition.getReqName());
		PageRequisitionCheckOut.selectPurchaseType(driver, testCaseName, requisition.getPurchaseType());
		ActionBot.defaultLowSleep();
		if (requisition.getCustomDate() != null)
		{
			requisition.getCustomDate().setDate(PageRequisitionCheckOut.selectRequiredByDate(driver, testCaseName, requisition.getCustomDate().getDay(),
				requisition.getCustomDate().getMonth(), requisition.getCustomDate().getYear()));
		}
		PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
		fillCostAllocationRequistionSummary(driver, testCaseName);
		PageRequisitionCheckOut.selectSettlementVia(driver, testCaseName, IConstantsData.SETTLEMENT_VIA_OPTION_INVOICE);
		ActionBot.defaultLowSleep();
		PageRequisitionCheckOut.clickIAmDone(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
		return FlowMyRequisitions.toCheckSuccessMessageMyRequisitions(driver, testCaseName);
	}

	/**
	 * <b>Author: raj.singh </b> <b><br>
	 * <font color="blue">Method :</b>fill checkoutForm for mandatory fields
	 * with scripted input for billing to address details <br>
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
	 * @throws Exception
	 */
	public static void fillCheckOutRequistionSummaryWithBillingToAddressScriptedInput(WebDriver driver, String testCaseName) throws Exception
	{
		Requisition requisition = ObjectCreation.getRequisition(driver);

		ActionBot.waitForPageLoad(driver);
		requisition.setReqName(CommonServices.getTestData(IConstantsData.SPECIAL_CHAR_USER) + Helper.getRandomString(5));

		PageRequisitionCheckOut.fillCheckoutReqName(driver, testCaseName, requisition.getReqName());
		PageRequisitionCheckOut.selectPurchaseType(driver, testCaseName, requisition.getPurchaseType());
		PageRequisitionCheckOut.selectRequiredByDate(driver, testCaseName, requisition.getCustomDate().getDay(), requisition.getCustomDate().getMonth(),
			requisition.getCustomDate().getYear());
		ActionBot.defaultMediumSleep();
		PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
		//fillScriptedBillingToAddressRequistionSummary(driver, testCaseName);
		fillCostAllocationRequistionSummary(driver, testCaseName);
		PageRequisitionCheckOut.selectSettlementVia(driver, testCaseName, IConstantsData.SETTLEMENT_VIA_OPTION_INVOICE);
		ActionBot.defaultMediumSleep();
		PageRequisitionCheckOut.clickIAmDone(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
	}

	/**
	 * <b>Author: raj.singh </b> <b><br>
	 * <font color="blue">Method :</b>fill checkoutForm for mandatory fields and
	 * save as draft <br>
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
	 * @throws Exception
	 */
	public static void fillCheckOutRequistionSummarySaveAsDraft(WebDriver driver, String testCaseName) throws Exception
	{
		Requisition requisition = ObjectCreation.getRequisition(driver);
		ActionBot.waitForPageLoad(driver);
		requisition.setReqName(CommonServices.getTestData(IConstantsData.SPECIAL_CHAR_USER) + Helper.getRandomString(5));
		PageRequisitionCheckOut.fillCheckoutReqName(driver, testCaseName, requisition.getReqName());
		PageRequisitionCheckOut.selectPurchaseType(driver, testCaseName, requisition.getPurchaseType());
		PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
		fillCostAllocationRequistionSummary(driver, testCaseName);
		PageRequisitionCheckOut.selectSettlementVia(driver, testCaseName, IConstantsData.SETTLEMENT_VIA_OPTION_INVOICE);
		PageRequisitionCheckOut.clickSaveAsDraft(driver, testCaseName);
		ActionBot.waitForPageLoad(driver);
	}

	/**
	 * <b>Author: raj.singh </b> <b><br>
	 * <font color="blue">Method :</b>fill checkoutForm for mandatory fields
	 * with Custom Delivery address <br>
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
	 * @throws Exception
	 */
	public static void fillCustomDeliveryCheckOutRequistionSummary(WebDriver driver, String testCaseName) throws Exception
	{
		Requisition requisition = ObjectCreation.getRequisition(driver);
		ActionBot.waitForPageLoad(driver);
		requisition.setReqName(CommonServices.getTestData(IConstantsData.SPECIAL_CHAR_USER) + Helper.getRandomString(5));
		PageRequisitionCheckOut.fillCheckoutReqName(driver, testCaseName, requisition.getReqName());
		PageRequisitionCheckOut.selectPurchaseType(driver, testCaseName, requisition.getPurchaseType());
		PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
		fillCustomDelieryAddressRequistionSummary(driver, testCaseName);
		fillCostAllocationRequistionSummary(driver, testCaseName);
		PageRequisitionCheckOut.clickSaveRequisitionSummary(driver, testCaseName);
		/*
		 * PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
		 * fillCostAllocationRequistionSummary(driver, testCaseName);
		 * PageRequisitionCheckOut.clickSaveRequisitionSummary(driver,
		 * testCaseName);
		 */
	}

	/**
	 * <b>Author: raj.singh </b> <b><br>
	 * <font color="blue">Method :</b>fill checkout Form for mandatory fields
	 * with Custom Delivery address with inputs as scripts <br>
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
	 * @throws Exception
	 */
	public static void fillCustomDeliveryCheckOutRequistionSummaryWithScriptedInput(WebDriver driver, String testCaseName) throws Exception
	{
		Requisition requisition = ObjectCreation.getRequisition(driver);
		ActionBot.waitForPageLoad(driver);
		requisition.setReqName(CommonServices.getTestData(IConstantsData.SPECIAL_CHAR_USER) + Helper.getRandomString(5));
		PageRequisitionCheckOut.fillCheckoutReqName(driver, testCaseName, requisition.getReqName());
		PageRequisitionCheckOut.selectPurchaseType(driver, testCaseName, requisition.getPurchaseType());
		PageRequisitionCheckOut.selectRequiredByDate(driver, testCaseName, requisition.getCustomDate().getDay(), requisition.getCustomDate().getMonth(),
			requisition.getCustomDate().getYear());
		PageRequisitionCheckOut.selectSettlementVia(driver, testCaseName, IConstantsData.SETTLEMENT_VIA_OPTION_INVOICE);
		PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
		fillCustomDelieryAddressRequistionSummaryWithScriptedInput(driver, testCaseName);
		fillCostAllocationRequistionSummary(driver, testCaseName);
		/*
		 * PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
		 * fillCostAllocationRequistionSummary(driver, testCaseName);
		 * PageRequisitionCheckOut.clickSaveRequisitionSummary(driver,
		 * testCaseName);
		 */
	}

	/**
	 * <b>Author: raj.singh </b> <b><br>
	 * <font color="blue">Method :</b>cost allocation entries <br>
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
	 * @throws Exception
	 */
	public static void fillCostAllocationRequistionSummary(WebDriver driver, String testCaseName) throws Exception
	{
		ActionBot.defaultLowSleep();
		PageRequisitionCheckOut.clickCostAllocation(driver, testCaseName);
		PageRequisitionCheckOut.fillCostbookingSingleProject(driver, testCaseName, IConstantsData.COST_BOOKING_SINGLE_PROJECT);
		PageRequisitionCheckOut.fillCostbookingSingleBudget(driver, testCaseName, IConstantsData.COST_BOOKING_SINGLE_BUDGET);
		PageRequisitionCheckOut.clickSaveRequisitionSummary(driver, testCaseName);
	}

	/**
	 * <b>Author: raj.singh </b> <b><br>
	 * <font color="blue">Method :</b>Script input for Billing to Address <br>
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
	 * @throws Exception
	 */

	public static void fillScriptedBillingToAddressRequistionSummary(WebDriver driver, String testCaseName) throws Exception
	{
		ActionBot.defaultMediumSleep();
		PageRequisitionCheckOut.fillBillingCompanyName(driver, testCaseName, IConstantsData.Company_TATA);
		PageRequisitionCheckOut.fillBillingBusinessUnitName(driver, testCaseName, IConstantsData.Company_TATA);
		PageRequisitionCheckOut.fillBillingLocationName(driver, testCaseName, IConstantsData.SCRIPT_INPUT);
	}

	/**
	 * <b>Author: raj.singh </b> <b><br>
	 * <font color="blue">Method :</b>custom delivery address <br>
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
	 * @throws Exception
	 */
	public static void fillCustomDelieryAddressRequistionSummary(WebDriver driver, String testCaseName) throws Exception
	{
		ActionBot.waitForPageLoad(driver);
		PageRequisitionCheckOut.clickDeliveryEditRequisitionSummary(driver, testCaseName);
		PageRequisitionCheckOut.clickMyAddressRadioButton(driver, testCaseName);
		PageRequisitionCheckOut.clickToEnterNewAddressLink(driver, testCaseName);
		PageRequisitionCheckOut.fillMyCustomDeliveryAddressName(driver, testCaseName);
		PageRequisitionCheckOut.fillMyCustomDeliveryStreetAddress(driver, testCaseName);
		PageRequisitionCheckOut.fillMyCustomDeliveryCountry(driver, testCaseName);
		PageRequisitionCheckOut.fillMyCustomDeliveryCity(driver, testCaseName);
	}

	/**
	 * <b>Author: raj.singh </b> <b><br>
	 * <font color="blue">Method :</b>custom delivery address with HTML scripts
	 * as inputs <br>
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
	 * @throws Exception
	 */
	public static void fillCustomDelieryAddressRequistionSummaryWithScriptedInput(WebDriver driver, String testCaseName) throws Exception
	{
		ActionBot.waitForPageLoad(driver);
		PageRequisitionCheckOut.clickDeliveryEditRequisitionSummary(driver, testCaseName);
		PageRequisitionCheckOut.clickMyAddressRadioButton(driver, testCaseName);
		PageRequisitionCheckOut.clickToEnterNewAddressLink(driver, testCaseName);
		PageRequisitionCheckOut.fillMyCustomDeliveryScriptedAddressName(driver, testCaseName);
		PageRequisitionCheckOut.fillMyCustomDeliveryScriptedStreetAddress(driver, testCaseName);
		PageRequisitionCheckOut.fillMyCustomDeliveryCountry(driver, testCaseName);
		PageRequisitionCheckOut.fillMyCustomDeliveryCity(driver, testCaseName);
	}

	/**
	 * <b>Author: raj.singh </b> <b><br>
	 * <font color="blue">Method :</b>delivery split <br>
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
	 * @throws Exception
	 */
	public static void splitDeliveryRequistions(WebDriver driver, String testCaseName) throws Exception
	{
		ActionBot.waitForPageLoad(driver);
		PageRequisitionCheckOut.fillCheckoutReqName(driver, testCaseName, PageRequisitionCheckOut.fetchRequisitionName(driver, testCaseName) + Helper.getRandomString(4));
		ActionBot.scroll(driver, "200");
		PageRequisitionCheckOut.clickEditItemRequisitionindexwise(driver, testCaseName, 1);
		PageRequisitionCheckOut.clickDeliveryMultiOptionSplit(driver, testCaseName);
		PageRequisitionCheckOut.clickToAddADeliverySplitIndexwise(driver, testCaseName, 1);

		PageRequisitionCheckOut.decreaseDeliverQunatityInDeliverySplitIndexwise(driver, testCaseName, 1, 1);

		PageRequisitionCheckOut.enterDeliverToNameInDeliverySplitIndexwise(driver, testCaseName, 4, IConstantsData.DELIVERY_NAME2);
		//int qty = Integer.parseInt(CommonServices.getTestData(IConstantsData.Item_Quantity));
		//PageRequisitionCheckOut.increaseDeliverQunatityInDeliverySplitIndexwise(driver, testCaseName, 2, qty);
		//PageRequisitionCheckOut.decreaseDeliverQunatityInDeliverySplitIndexwise(driver, testCaseName, 1, qty + 1);
		ActionBot.click(driver, IPageRequisitionCheckOut.ITEMSUMMARY_SAVE);
		PageRequisitionCheckOut.clickIAmDone(driver, testCaseName);
	}

	/**
	 * <b>Author: raj.singh </b> <b><br>
	 * <font color="blue">Method :</b>add a new item to the req check out cart
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param user
	 * @param testCase
	 * @param map
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </font><b><br>
	 * @throws FactoryMethodException
	 *         </b> <br>
	 * @throws Exception
	 */
	public static boolean addNewItemToCheckOutCart(WebDriver driver, String testCaseName, TestCase testCase, User user, Map<String, String> map)
	{
		try
		{
			PageRequisitionCheckOut.toAddNewReqItemInCart(driver, testCaseName, 1);
			PageMyFavorites.clickOnConfirmation_YES_NO(driver, testCaseName, IConstantsData.CONFIRMATION_YES);

			// to search a product
			OnlineStore onlineStore = ObjectCreation.searchItem();
			FlowOnlineStore.clearCart(driver, testCaseName);
			MainPageHeaderLevelTab.clickOnOnlineStoreSubTab(driver);
			String searchText = CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING, 1);
			onlineStore.setSearchItem(searchText);
			PageOnlineStore.fillSearchText(driver, testCaseName, onlineStore.getSearchItem());
			PageOnlineStore.clickSearchButton(driver, testCaseName);
			ActionBot.waitForOperations(5000);

			if (ActionBot.isElementDisplayed(driver, IPageSearchListing.NO_CATLOGUE_FOUND))
			{
				CommonServices.afterExecutionOfTestcase(driver, testCase, map, user);
			}

			// select check box for an items to add to cart
			Thread.sleep(5000);
			for (int i = 0; i <= 1; i++)
			{
				onlineStore = FlowOnlineStore.getItemId(driver, testCaseName, i, onlineStore);
				String item_id = onlineStore.getItemId();
				PageSearchListing.clickOnCheckBoxOfItem(driver, testCaseName, item_id);
			}
			PageSearchListing.clickOnAddMultipleItemsToCart(driver, testCaseName);

			// to checkout and create a new requistion and submit
			ActionBot.defaultMediumSleep();
			PageSearchListing.clickOnCheckOutButton(driver, testCaseName);
			PageRequisitionCheckOut.clickIAmDone(driver, testCaseName);
			return true;
		}
		catch (Exception e)
		{
			return false;
		}
	}

	/**
	 * <b>Author: raj.singh </b> <b><br>
	 * <font color="blue">Method :</b> free text checkout requisition summary
	 * form fill up <br>
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
	 * @throws Exception
	 */
	public static void fillFreeTextRequistionSummary(WebDriver driver, String testCaseName) throws Exception
	{
		Requisition requisition = ObjectCreation.getRequisition(driver);
		requisition.setReqName(CommonServices.getTestData(IConstantsData.SPECIAL_CHAR_USER) + Helper.getRandomString(5));
		FlowRequisition.fillCheckOutRequistionSummary(driver, testCaseName);
	}

	/**
	 * <b>Author: raj.singh </b> <b><br>
	 * <font color="blue">Method :</b> to verify the Delivery, Billing and
	 * Costing should be shown in single modal with titke
	 * "Requisition Summary" </font><b><font color="green">Note :</b> </font>
	 * <b><br>
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
	public static boolean toVerifyDeliveryBillingCostingModal(WebDriver driver, String testCaseName) throws Exception
	{
		ActionBot.waitForPageLoad(driver);
		boolean status = false;
		if (PageRequisitionCheckOut.isCostAllocationTabVisible(driver, testCaseName) && PageRequisitionCheckOut.isDeliveryTabVisible(driver, testCaseName)
			&& PageRequisitionCheckOut.isBillingTabVisible(driver, testCaseName))
			status = true;
		if (PageRequisitionCheckOut.isEditRequistionSummaryVisible(driver, testCaseName) && status != false)
			status = true;
		else
			status = false;
		return status;
	}

	/**
	 * <b>Author: raj.singh </b> <b><br>
	 * <font color="blue">Method :</b> to verify the Delivery, Billing and
	 * Costing should be shown in single modal with titke
	 * "Requisition Summary" </font><b><font color="green">Note :</b> </font>
	 * <b><br>
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
	public static boolean toVerifyDeliveryBillingCostingChangableModals(WebDriver driver, String testCaseName) throws Exception
	{
		ActionBot.waitForPageLoad(driver);
		boolean status = false;
		if (PageRequisitionCheckOut.isRequisitionSummaryButtonVisible(driver, testCaseName))
			status = true;
		return status;
	}

	/**
	 * <b>Author: raj.singh </b> <b><br>
	 * <font color="blue">Method :</b> to do a header level cost
	 * splitting </font><b><font color="green">Note :</b> </font><b><br>
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
	public static String[] toDoHeaderLevelCostSplitting(WebDriver driver, String testCaseName) throws Exception
	{
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
		String cost_center[] = new String[2];
		PageRequisitionCheckOut.toSplitIntoMultipleCostCenter(driver, testCaseName);
		PageRequisitionCheckOut.clicktoAddCostSplitIndexwise(driver, testCaseName, 1);
		PageRequisitionCheckOut.selectCostCenter(driver, testCaseName, 2);
		ActionBot.defaultSleep();
		PageRequisitionCheckOut.toDecreaseCostPercentageIndexwise(driver, testCaseName, 1);
		PageRequisitionCheckOut.toIncreaseCostPercentageIndexwise(driver, testCaseName, 2);
		PageRequisitionCheckOut.toSelectProjectIndexwise(driver, testCaseName, 1);
		PageRequisitionCheckOut.toSelectProjectIndexwise(driver, testCaseName, 2);
		PageRequisitionCheckOut.toSelectBudgetIndexwise(driver, testCaseName, 1);
		PageRequisitionCheckOut.toSelectBudgetIndexwise(driver, testCaseName, 2);
		ActionBot.defaultSleep();
		PageRequisitionCheckOut.clickSaveRequisitionSummary(driver, testCaseName);
		for (int i = 0; i < 2; i++)
		{
			cost_center[i] = PageRequisitionCheckOut.fetchCostCenterHeaderIndexwise(driver, testCaseName, (i + 1));
		}
		return cost_center;
	}

	/**
	 * <b>Author: raj.singh </b> <b><br>
	 * <font color="blue">Method :</b>
	 * toCheckDeliveryNameWithDefaultName </font><b><font color="green">Note
	 * :</b> </font><b><br>
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
	public static boolean toCheckDeliveryNameWithDefaultName(WebDriver driver, String testCaseName, User user) throws Exception
	{
		ActionBot.defaultHighSleep();
		String delivery_to_name = PageRequisitionCheckOut.getDeliverToHeader(driver, testCaseName);
		String username = user.getDisplayName();
		if ((username.equalsIgnoreCase(delivery_to_name)))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * <b>Author: raj.singh </b> <b><br>
	 * <font color="blue">Method :</b> toCheckout without filling mandatory
	 * fields </font><b><font color="green">Note :</b> </font><b><br>
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
	public static boolean toVerifyCheckoutWithoutFillingMandatoryFields(WebDriver driver, String testCaseName) throws Exception
	{
		ActionBot.waitForPageLoad(driver);
		if (!PageRequisitionCheckOut.isEditable(driver, testCaseName))
			PageMyFavorites.clickToCheckOutFromCart(driver, testCaseName);
		try
		{
			PageRequisitionCheckOut.clickIAmDone(driver, testCaseName);
		}
		catch (Exception e)
		{
			return true;
		}
		return false;
	}

	/**
	 * <b>Author: raj.singh </b> <b><br>
	 * <font color="blue">Method :</b> to change delivery reciever name in the
	 * check out page </font><b><font color="green">Note :</b> </font><b><br>
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
	public static boolean toEditDeliveryRecipientName(WebDriver driver, String testCaseName) throws Exception
	{
		String name = CommonServices.getTestData(IConstantsData.BUYER_NAME);
		PageRequisitionCheckOut.clickEditHeaderInfo(driver, testCaseName);
		//PageRequisitionCheckOut.clickOnDeliveryItemEdit(driver, testCaseName);
		PageRequisitionCheckOut.clickDeliveryEditRequisitionSummary(driver, testCaseName);
		PageRequisitionCheckOut.fillDeliveryRecipientName(driver, testCaseName, name);

		// to verify the name edited successfully
		boolean status = PageRequisitionCheckOut.isDeliveryRecipientNameEdited(driver, testCaseName, name);
		return status;
	}

	/**
	 * <b>Author: raj.singh </b> <b><br>
	 * <font color="blue">Method :</b> to verify comments option availability
	 * for each item in the checkout page </font><b><font color="green">Note
	 * :</b> </font><b><br>
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
	public static boolean verifyCommentsForAlltemsInCheckout(WebDriver driver, String testCaseName) throws Exception
	{
		boolean status = false;
		if (PageRequisitionCheckOut.isCommentForItemAvailable(driver, testCaseName, 1) && PageRequisitionCheckOut.isCommentForItemAvailable(driver, testCaseName, 2))
			status = true;
		return status;
	}

	/**
	 * <b>Author: raj.singh </b> <b><br>
	 * <font color="blue">Method :</b> verify that if cost has been booked to
	 * multiple cost centers, show "Multiple" at header summary </font>
	 * <b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param cost_center2
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </font><b><br>
	 * @throws FactoryMethodException
	 *         </b> <br>
	 * @throws Exception
	 */
	public static boolean toCheckCostCenterValuesInHeaderSummary(WebDriver driver, String testCaseName, String[] cost_center2) throws Exception
	{
		ActionBot.defaultHighSleep();
		boolean status = false;
		int count = 0;
		String cost_center = PageRequisitionCheckOut.fetchCostCenterHeaderIndexwise(driver, testCaseName, 1);
		for (int i = 0; i < cost_center2.length; i++)
		{
			if (cost_center.equals(PageRequisitionCheckOut.fetchCostCenterHeaderIndexwise(driver, testCaseName, (i + 1))))
				count++;
		}
		if (count == cost_center2.length)
			status = true;
		return status;
	}

	/**
	 * <b>Author: raj.singh </b> <b><br>
	 * <font color="blue">Method :</b> verify that if category for the free text
	 * item is changed then the basic item information remains the same </font>
	 * <b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param cost_center2
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </font><b><br>
	 * @throws FactoryMethodException
	 *         </b> <br>
	 * @throws Exception
	 */
	public static boolean toCheckBasicItemInformationRemainSameAfterChangingItemCategory(WebDriver driver, String testCaseName) throws Exception
	{
		boolean status = false;
		int count = 0;
		String descrpition = PageRequisitionCheckOut.getDescriptionFreeTextItemValue(driver, testCaseName);
		String quantity = PageRequisitionCheckOut.getQuantityFreeTextItemValue(driver, testCaseName);
		// String
		// price=PageRequisitionCheckOut.getPriceFreeTextItemValue(driver,
		// testCaseName);
		ActionBot.defaultLowSleep();
		PageRequisitionCheckOut.searchCategoryinGuidedItemPopup(driver, testCaseName, IConstantsData.Paper_Materials_and_Products);

		ActionBot.defaultLowSleep();
		if (descrpition.equals(PageRequisitionCheckOut.getDescriptionFreeTextItemValue(driver, testCaseName)))
			count++;
		if (quantity.equals(PageRequisitionCheckOut.getQuantityFreeTextItemValue(driver, testCaseName)))
			count++;
		/*
		 * if(price.equals(PageRequisitionCheckOut.getPriceFreeTextItemValue(
		 * driver , testCaseName))) count++;
		 */
		if (count == 2)
			status = true;
		status = status && PageRequisitionCheckOut.clickCancelFreeTextButton(driver, testCaseName);
		return status;
	}

	/**
	 * <b>Author: raj.singh </b> <b><br>
	 * <font color="blue">Method :</b> verify that if category for the free text
	 * item is changed then the basic item information remains the same </font>
	 * <b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCaseName
	 *        </font><b><br>
	 * @param cost_center2
	 * @return </font><b><br>
	 * @throws ActionBotException
	 *         </font><b><br>
	 * @throws FactoryMethodException
	 *         </b> <br>
	 * @throws Exception
	 */
	public static OnlineStore flow_IamDone_SaveAsDraft_Cancel(WebDriver driver, String testCaseName, OnlineStore onlineStore) throws Exception
	{
		if (onlineStore.getNextAction().equals(IConstantsData.Checkout))
		{
			onlineStore.setResult(fillCheckOutRequistionSummary(driver, testCaseName));
		}
		else if (onlineStore.getNextAction().equals(IConstantsData.SAVE_AS_DRAFT))
		{
			PageRequisitionCheckOut.clickSaveAsDraft(driver, testCaseName);
			onlineStore.setResult(PageMyRequisition.isReqNamePresentIndexwise(driver, testCaseName, 1));
		}
		else
		{
			PageRequisitionCheckOut.clickCancleRequisition(driver, testCaseName);
			onlineStore.setResult(!PageRequisitionCheckOut.isEditable(driver, testCaseName));
		}
		return onlineStore;
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>create/ change address on PR <br>
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
	 * @throws Exception
	 */

	public static void changeAddressDeliveryTab(WebDriver driver, String testCaseName, String addressType) throws Exception
	{
		// naviagte to delivery tab and click on create new address
		TabPOSummary.clickOnDeliveryPOSummary(driver);
		PageStandardPO.clickOnMyDeliveryAddressRadioBtm(driver);
		if (addressType.equalsIgnoreCase(IConstantsData.DeliveryAddress_MyAddress))
		{
			PageStandardPO.clickLinkCreateNewAddress(driver, testCaseName);
			// fill address details
			PageStandardPO.fillCustomAddressName(driver, testCaseName, Helper.getRandomString(5));
			PageStandardPO.fillCustomAddressStreet1(driver, testCaseName, Helper.getRandomString(5));
			PageStandardPO.fillCustomAddressCountry(driver, testCaseName, "1");
			PageStandardPO.fillCustomAddressCity(driver, testCaseName, Helper.getRandomString(5));
		}
		if (addressType.equalsIgnoreCase(IConstantsData.DeliveryAddress_OtherAddress))
		{
			PageStandardPO.selectOtherAddress(driver, testCaseName);
		}

		PageBuyersDesk.clickOkButtonForReqSummary(driver, testCaseName);
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>fill COA form<br>
	 */
	public static Requisition fillCOAForm(WebDriver driver, String testCaseName, Requisition requisition) throws Exception
	{
		// to verify multiple split scenario
		int size = CommonUtilities.getSizeOfNumber(requisition.getItemSummaryCoa().getTotalRows());

		// to verify number of splits required
		int splitSize = requisition.getItemSummaryCoa().getSplit();

		COAMayerBrownDataBO mayerBrownData = null;

		// to verify if edit form scenario
		boolean verifyEdit = requisition.getItemSummaryCoa().isCoaEdit();
		// to iterate for total requested splits
		for (int i = 1; i <= splitSize; i++)
		{
			mayerBrownData = new COAMayerBrownDataBO();
			// to fetch random row from excel
			int number = CommonUtilities.getRandomNumbersBetweenRange(size, 0, (requisition.getItemSummaryCoa().getTotalRows()));
			logger.info("Generated Random Number: " + number + " for range between 0 and " + requisition.getItemSummaryCoa().getTotalRows());

			// to click on Split by radio button.
			ModelItemSummaryCostBooking.clickCostBookingOnRadioButton_CoaForm(driver, testCaseName, requisition.getItemSummaryCoa().getSplitBy());

			// to fill form for American Family
			if (ConfigProperty.getConfig("coaDataFile").toLowerCase().contains(IConstantsData.AMFAM.toLowerCase()))
			{
				if (requisition.getCoaDataList().get(number).getBusinessUnit() != null)
				{
					ModelItemSummaryCostBooking.fillBU_CoaForm(driver, testCaseName, requisition.getCoaDataList().get(number).getBusinessUnit(), verifyEdit);
				}

				if (requisition.getCoaDataList().get(number).getGlAccount() != null)
				{
					ModelItemSummaryCostBooking.fillGeneralLedger_CoaForm(driver, testCaseName, requisition.getCoaDataList().get(number).getGlAccount(), verifyEdit);
				}

				if (requisition.getCoaDataList().get(number).getCostCenter() != null)
				{
					ModelItemSummaryCostBooking.fillCostCenter_CoaForm(driver, testCaseName, requisition.getCoaDataList().get(number).getCostCenter(), verifyEdit);
				}

				if (requisition.getCoaDataList().get(number).getProject() != null)
				{
					ModelItemSummaryCostBooking.fillProject_CoaForm(driver, testCaseName, requisition.getCoaDataList().get(number).getProject(), verifyEdit);
				}

				if (requisition.getCoaDataList().get(number).getSubAccount() != null)
				{
					ModelItemSummaryCostBooking.fillSubAccount_CoaForm(driver, testCaseName, requisition.getCoaDataList().get(number).getSubAccount(), verifyEdit);
				}

				if (requisition.getCoaDataList().get(number).getProduct() != null)
				{
					ModelItemSummaryCostBooking.fillProduct_CoaForm(driver, testCaseName, requisition.getCoaDataList().get(number).getProduct(), verifyEdit);
				}

				if (requisition.getCoaDataList().get(number).getGeoAccount() != null)
				{
					ModelItemSummaryCostBooking.fillGeoAccount_CoaForm(driver, testCaseName, requisition.getCoaDataList().get(number).getGeoAccount(), verifyEdit);
				}

				if (requisition.getCoaDataList().get(number).getOperationalUnit() != null)
				{
					ModelItemSummaryCostBooking.fillOperationalUnit_CoaForm(driver, testCaseName, requisition.getCoaDataList().get(number).getOperationalUnit(), verifyEdit);
				}

			}

			// to fill form for Mayer Brown
			else if (ConfigProperty.getConfig("coaDataFile").toLowerCase().contains(IConstantsData.MAYER_BROWN.toLowerCase()))
			{
				if (requisition.getCoaDataList().get(number).getBookCostTo() != null)
				{
					ModelItemSummaryCostBooking.fillBookCostTo_CoaForm(driver, testCaseName, requisition.getCoaDataList().get(number).getBookCostTo(), verifyEdit);
					mayerBrownData.setBookCostTo(requisition.getCoaDataList().get(number).getBookCostTo());
				}

				if (requisition.getCoaDataList().get(number).getMatter() != null)
				{
					ModelItemSummaryCostBooking.fillProject_CoaForm(driver, testCaseName, requisition.getCoaDataList().get(number).getMatter(), verifyEdit);
					mayerBrownData.setMatter(requisition.getCoaDataList().get(number).getMatter());
				}

				if (requisition.getCoaDataList().get(number).getClient() != null)
				{
					ModelItemSummaryCostBooking.fillClient_CoaForm(driver, testCaseName, requisition.getCoaDataList().get(number).getClient(), verifyEdit);
					mayerBrownData.setClient(requisition.getCoaDataList().get(number).getClient());
				}

				if (requisition.getCoaDataList().get(number).getGlAccount() != null)
				{
					ModelItemSummaryCostBooking.fillGeneralLedger_CoaForm(driver, testCaseName, requisition.getCoaDataList().get(number).getGlAccount(), verifyEdit);
					mayerBrownData.setGlAccount(requisition.getCoaDataList().get(number).getGlAccount());
				}

				if (requisition.getCoaDataList().get(number).getEmployee_Timekeeper() != null)
				{
					ModelItemSummaryCostBooking.fillEmployeeTimekeeper_CoaForm(driver, testCaseName, requisition.getCoaDataList().get(number).getEmployee_Timekeeper(), verifyEdit);
					mayerBrownData.setEmpTimekeeper(requisition.getCoaDataList().get(number).getEmployee_Timekeeper());
					ActionBot.defaultSleep();
				}

				if (requisition.getCoaDataList().get(number).getOffice() != null)
				{
					ModelItemSummaryCostBooking.fillBU_CoaForm(driver, testCaseName, requisition.getCoaDataList().get(number).getOffice(), verifyEdit);
					mayerBrownData.setOffice(requisition.getCoaDataList().get(number).getOffice());
				}

				if (requisition.getCoaDataList().get(number).getDisbursementCode() != null)
				{
					ModelItemSummaryCostBooking.fillCostDisbursementCode_CoaForm(driver, testCaseName, requisition.getCoaDataList().get(number).getDisbursementCode(), verifyEdit);
					mayerBrownData.setCostDisburseMentCode((requisition.getCoaDataList().get(number).getDisbursementCode()));
				}

				if (requisition.getCoaDataList().get(number).getDepartment() != null)
				{
					ModelItemSummaryCostBooking.fillDepartment_CoaForm(driver, testCaseName, requisition.getCoaDataList().get(number).getDepartment(), verifyEdit);
					mayerBrownData.setDepartment(requisition.getCoaDataList().get(number).getDepartment());
				}

				if (requisition.getCoaDataList().get(number).getCostCenter() != null)
				{
					ModelItemSummaryCostBooking.fillCostCenter_CoaForm(driver, testCaseName, requisition.getCoaDataList().get(number).getCostCenter(), verifyEdit);

				}

				// fill transaction date based on Book Cost To
				if (requisition.getCoaDataList().get(number).getBookCostTo().equalsIgnoreCase("Journal"))
				{
					logger.info("Ignoring Date field for Book Cost To: Journal");
				}
				else if (requisition.getCoaDataList().get(number).getBookCostTo().equalsIgnoreCase("Disbursement"))
				{
					ModelItemSummaryCostBooking.fillTransactionDate_CoaForm(driver, testCaseName, requisition.getCustomDate().getDay(), requisition.getCustomDate().getMonth(),
						requisition.getCustomDate().getYear(), verifyEdit);
				}

				if (requisition.getCoaDataList().get(number).getDescription() != null)
				{
					ModelItemSummaryCostBooking.fillDescription_CoaForm(driver, testCaseName, requisition.getCoaDataList().get(number).getDescription(), verifyEdit);
					mayerBrownData.setDescription(requisition.getCoaDataList().get(number).getDescription());
				}
			}

			// for coa edit form scenario
			if (requisition.getItemSummaryCoa().isCoaEdit())
			{
				// to edit on percentage
				if (requisition.getItemSummaryCoa().getSplitBy().equalsIgnoreCase(IConstantsData.PERCENTAGE))
				{
					String firstSplitPercent = ActionBot.getAttributeOfElement(driver, IModelItemSummaryCostBooking.TEXT_FIRST_SPLIT_PERCENTAGE, "value");
					ModelItemSummaryCostBooking.fillPercentage_CoaForm(driver, testCaseName, firstSplitPercent, verifyEdit);

					mayerBrownData.setPercentage(firstSplitPercent);

					// mayerBrownData.setPercentage(requisition.getItemSummaryCoa().getPercentage());

				}
				// to edit on quantity
				else if (requisition.getItemSummaryCoa().getSplitBy().equalsIgnoreCase(IConstantsData.Quantity))
				{
					String firstSplitQuantity = ActionBot.getAttributeOfElement(driver, IModelItemSummaryCostBooking.TEXT_FIRST_SPLIT_QUANTITY, "value");
					ModelItemSummaryCostBooking.fillQuantity_CoaForm(driver, testCaseName, firstSplitQuantity, verifyEdit);
					mayerBrownData.setQuantity(firstSplitQuantity);
				}
				// to edit on amount
				else if (requisition.getItemSummaryCoa().getSplitBy().equalsIgnoreCase(IConstantsData.AMOUNT))
				{
					String firstSplitAmount = ActionBot.getAttributeOfElement(driver, IModelItemSummaryCostBooking.TEXT_FIRST_SPLIT_AMOUNT, "value");
					ModelItemSummaryCostBooking.fillAmount_CoaForm(driver, testCaseName, firstSplitAmount, verifyEdit);
					mayerBrownData.setQuantity(firstSplitAmount);
				}
			}
			// for coa create form scenario
			else
			{
				// to split on percentage
				if (requisition.getItemSummaryCoa().getSplitBy().equalsIgnoreCase(IConstantsData.PERCENTAGE))
				{
					if (splitSize == 1)
					{
						ModelItemSummaryCostBooking.fillPercentage_CoaForm(driver, testCaseName, requisition.getItemSummaryCoa().getPercentage(), verifyEdit);
						mayerBrownData.setPercentage(requisition.getItemSummaryCoa().getPercentage());
					}
					else if (i < splitSize)
					{
						ModelItemSummaryCostBooking.fillPercentage_CoaForm(driver, testCaseName, 1 + "", verifyEdit);
						mayerBrownData.setPercentage("1");
					}
					else if (i == splitSize)
					{
						ModelItemSummaryCostBooking.fillPercentage_CoaForm(driver, testCaseName, (101 - splitSize) + "", verifyEdit);
						mayerBrownData.setPercentage((101 - splitSize) + "");
					}

				}
				// to split on quantity
				else if (requisition.getItemSummaryCoa().getSplitBy().equalsIgnoreCase(IConstantsData.Quantity))
				{
					int quantity = ModelItemSummaryCostBooking.getQuantityFromItemSummary(driver, testCaseName);
					// int quantity =
					// Integer.parseInt(requisition.getItemSummaryCoa().getQuantity());

					// splitting based on item quantity
					if (splitSize == 1)
					{
						ModelItemSummaryCostBooking.fillQuantity_CoaForm(driver, testCaseName, quantity + "", verifyEdit);
						mayerBrownData.setQuantity(quantity + "");
					}
					else if (i < splitSize)
					{
						ModelItemSummaryCostBooking.fillQuantity_CoaForm(driver, testCaseName, 1 + "", verifyEdit);
						mayerBrownData.setQuantity(1 + "");
					}
					else if (i == splitSize)
					{
						ModelItemSummaryCostBooking.fillQuantity_CoaForm(driver, testCaseName, ((quantity + 1) - splitSize) + "", verifyEdit);
						mayerBrownData.setQuantity(((quantity + 1) - splitSize) + "");
					}

				}
				// to split on amount
				else if (requisition.getItemSummaryCoa().getSplitBy().equalsIgnoreCase(IConstantsData.AMOUNT))
				{
					// int amount =
					// ModelItemSummaryCostBooking.getTotalAmountFromItemSummary(driver,
					// testCaseName);
					double amount = ModelItemSummaryCostBooking.getTotalAmountFromItemSummary(driver, testCaseName);

					// to fill amount value for 0 price item. for -ve scenario
					// add splitSize:2
					if (requisition.getItems().getGuidedItems().size() > 0)
					{
						if (requisition.getItems().getGuidedItems().get(0).isZeroPriceItem() && splitSize == 1)
						{
							ModelItemSummaryCostBooking.fillAmount_CoaForm(driver, testCaseName, 0 + "", verifyEdit);
							mayerBrownData.setAmount(0 + "");
						}
					}

					if (splitSize == 1)
					{
						ModelItemSummaryCostBooking.fillAmount_CoaForm(driver, testCaseName, amount + "", verifyEdit);
						mayerBrownData.setAmount(amount + "");
					}
					else if (i < splitSize)
					{
						ModelItemSummaryCostBooking.fillAmount_CoaForm(driver, testCaseName, 1 + "", verifyEdit);
						mayerBrownData.setAmount(1 + "");
					}
					else if (i == splitSize)
					{
						ModelItemSummaryCostBooking.fillAmount_CoaForm(driver, testCaseName, ((amount + 1) - splitSize) + "", verifyEdit);
						mayerBrownData.setAmount((amount + 1) - splitSize + "");
					}
				}

				ModelItemSummaryCostBooking.clickAddButton_CoaForm(driver, testCaseName);

				// to verify if final amount is generated
				/*
				 * try { mayerBrownData.setFinalAmount((Double
				 * .parseDouble(ActionBot.findElement(driver, By. xpath(
				 * "(.//*[contains(@class,'eformDataTable ')]//*[contains(@class,'FinalAmount')])["
				 * + i + "]")).getText())) + ""); } catch (NumberFormatException
				 * e) { logger.info("Final Amount is not generated"); }
				 */
				// to click again due to UI issue.
				ModelItemSummaryCostBooking.clickAddButton_CoaForm(driver, testCaseName);
			}
			mayerBrownDataList.add(mayerBrownData);
			ActionBot.defaultSleep();
			logger.info("Split Count: " + i);

		}

		// to be removed
		ActionBot.defaultMediumSleep();

		// Actions to be performed on Item Summary PopUp
		if (requisition.getCoaAction().equalsIgnoreCase(IConstantsData.SAVE))
		{
			ModelItemSummaryCommon.clickItemSummarySave(driver, testCaseName);
		}
		else if (requisition.getCoaAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			ModelItemSummaryCommon.clickItemSummaryCancle(driver, testCaseName);
		}
		else if (requisition.getCoaAction().equalsIgnoreCase(IConstantsData.NONE))
		{
			logger.info("No Action to be performed for COA section");
		}

		return requisition;
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>COA form Actions<br>
	 * Note: set split value to 1 at req level to edit single COA split value
	 * and also set actions to be performed.
	 * 
	 * @throws Exception
	 */
	public static void coaFormActions(WebDriver driver, String testCaseName, Requisition requisition) throws Exception
	{
		int splitCount = requisition.getItemSummaryCoa().getSplit();
		// to iterate over all rows to edit and delete
		for (int i = 1; i <= splitCount; i++)
		{
			if (requisition.getItemSummaryCoa().getInitialAction().equalsIgnoreCase(IConstants.Action_Edit))
			{
				if (splitCount == 1)
				{
					// set split count to 1
					requisition.getItemSummaryCoa().setSplit(splitCount);

					// remove last record from list;
					int listSize = mayerBrownDataList.size();
					mayerBrownDataList.remove(listSize - 1);
					logger.info("Removing last record from list");

					ModelItemSummaryCostBooking.clickOnEditIcon_CoaForm(driver, testCaseName);
					logger.info("Editing COA form");

					// edit coa forom with new values
					fillCOAForm(driver, testCaseName, requisition);

					if (requisition.getItemSummaryCoa().getNextAction().equalsIgnoreCase(IConstants.Action_Save))
					{
						ModelItemSummaryCostBooking.clickOnSaveIcon_CoaForm(driver, testCaseName);

						logger.info("Editing Saved for COA form");
					}
					else if (requisition.getItemSummaryCoa().getNextAction().equalsIgnoreCase(IConstants.Action_Cancel))
					{
						ModelItemSummaryCostBooking.clickOnCancelIcon_CoaForm(driver, testCaseName);
						logger.info("Editing Cancelled for COA form");
					}
				}
				else
				{
					mayerBrownDataList.removeAll(mayerBrownDataList);
					logger.info("Removing all records from List");
					splitCount--;
				}

			}
			else if (requisition.getItemSummaryCoa().getInitialAction().equalsIgnoreCase(IConstants.Action_Delete))
			{
				ModelItemSummaryCostBooking.clickOnDeleteIcon_CoaForm(driver, testCaseName);
				PopUpDefaultConfirmation.clickOnConfirmYesButton(driver, testCaseName);
				logger.info("COA split deleted");
			}
			else if (requisition.getItemSummaryCoa().getInitialAction().equalsIgnoreCase(IConstants.Action_None))
			{
				logger.info("No Actions to be performed for COA splits");
			}
		}

		// to perform actions on Item Summary Pop-up
		if (requisition.getCoaAction().equalsIgnoreCase(IConstantsData.SAVE))
		{
			ModelItemSummaryCommon.clickItemSummarySave(driver, testCaseName);
		}
		else if (requisition.getCoaAction().equalsIgnoreCase(IConstantsData.CANCEL))
		{
			ModelItemSummaryCommon.clickItemSummaryCancle(driver, testCaseName);
		}
		else if (requisition.getCoaAction().equalsIgnoreCase(IConstantsData.NONE))
		{
			logger.info("No Action to be performed for COA section");
		}
	}

	/**
	 * <b>Author: amar.singh </b> <b><br>
	 * <font color="blue">Method :</b>fill COA form<br>
	 */
	public static List<Boolean> verifyCoaFormOnReqView(WebDriver driver, String testCaseName, int split)
		throws ActionBotException, InterruptedException, com.zycus.zsn.automation.exception.ActionBotException
	{
		List<Boolean> flagList = new ArrayList<Boolean>();
		try
		{
			PageRequisitionView.clickOnViewCoaButton(driver, testCaseName);
			Thread.sleep(3000);
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
			Thread.sleep(1000);
			flagList = COAFlow.verifyCoaFormOnViewPage(driver, testCaseName, split);
		}
		catch (Exception e)
		{
			flagList.add(false);
			e.printStackTrace();
		}
		finally
		{
			return flagList;
		}

	}

	/**
	 * <b>Author: amar.singh </b> <b><br>
	 * <font color="blue">Method :</b>To verify Pagination<br>
	 */
	public static boolean checkPaginationFlow(WebDriver driver, String testCaseName, int split, UI_Elements gridSummary) throws ActionBotException, InterruptedException
	{
		boolean flag = false;
		int noOfItemToVerify = 0;

		if (split > 10)
		{

			while (split > 0)
			{
				boolean clickPagination = false;
				if (split > 10)
				{
					clickPagination = true;
					noOfItemToVerify = 10;
				}
				else if (split == 10)
				{
					clickPagination = false;
					noOfItemToVerify = 10;
				}
				else
				{
					clickPagination = false;
					noOfItemToVerify = split;
				}
				split = split - 10;
				flag = PageRequisitionView.checkPagination(driver, testCaseName, noOfItemToVerify, clickPagination, gridSummary);
			}
		}
		return flag;
	}

	/**
	 * <b>Author: amar.singh </b> <b><br>
	 * <font color="blue">Method :</b>Veifying Audit Trail for COA info<br>
	 */
	public static void auditTrailFlow(WebDriver driver, String testCaseName, int split) throws ActionBotException, InterruptedException
	{
		boolean flag = false;
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,500)", "");
		PageRequisitionView.clickOnAuditTrailVersionOnReqView(driver, testCaseName);
		String parentWindow = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		WebDriver auditTrailDriver = null;
		for (String window : windowHandles)
		{
			WebDriver driver1 = driver.switchTo().window(window);
			if (driver1.findElements(By.xpath("//h1[contains(text(),'Requisition Details')]")).size() > 0)
			{
				auditTrailDriver = driver1;
				break;
			}
		}
		if (auditTrailDriver != null)
		{
			auditTrailDriver.manage().window().maximize();
			WebElement auditTrailViewSummary = auditTrailDriver.findElement(By.xpath("//a[@class='icon comments itemComments']"));
			auditTrailViewSummary.click();
			List<WebElement> dataOnAuditTrailList = auditTrailDriver.findElements(By.xpath("//div/div/form/div/div[2]/ul/li[2]/div[2]/div[2]/div[3]/div[2]/table/tbody/tr"));
			int size = dataOnAuditTrailList.size();
			if (split >= 10)
			{
				if (size == 10)
				{
					flag = true;
				}
			}
			else
			{
				if (size == split)
				{
					flag = true;
				}
			}
		}
	}

	/**
	 * <b>Author: amar.singh </b> <b><br>
	 * <font color="blue">Method :</b>fill values for Percentage/Quantity/Amount
	 * by Rounding -off<br>
	 */

	public static void main(String str[])
	{
		double i = 5;
		int split = 50;
		double sum = 0;
		double total = 0.0;
		double[] j = new double[split];
		double remainingNum = 0.0;
		int temp = split + 1;
		for (int k = 1; k < temp; k++)
		{
			if (k == temp)
			{
				j[k - 1] = i - sum;
			}
			else
			{
				j[k - 1] = i / split;
				sum = sum + j[k - 1];
			}
			j[k - 1] = Math.round(j[k - 1] * 100.0) / 100.0;
			System.out.println(j[k - 1]);
		}
		sum = Math.round(sum * 100.0) / 100.0;
		System.out.println(sum);
		if (sum > i)
		{
			remainingNum = sum - i;
			remainingNum = Math.round(remainingNum * 100.0) / 100.0;
			j[split - 1] = j[split - 1] - remainingNum;
		}
		else if (sum < i)
		{
			remainingNum = i - sum;
			remainingNum = Math.round(remainingNum * 100.0) / 100.0;
			j[split - 1] = j[split - 1] + remainingNum;
		}
		else
		{
		}
		for (int k = 0; k < split; k++)
		{
			total = total + j[k];
		}
		System.out.println(total);
	}

	/**
	 * <b>Author: akashdeep.singh || swet.shah </b><br>
	 * <font color="blue">Method :</b>Filling the eForm in Requisition [SAWater]
	 * <br>
	 * 
	 * @throws Exception
	 */
	public static Requisition fillEFormInRequisition(WebDriver driver, String testCaseName, Requisition requisition) throws Exception
	{
		if (requisition.getSharePointURL_eForm() != null)
			PageRequisitionCheckOut.fillSharePointURL_EForm(driver, testCaseName, requisition.getSharePointURL_eForm());
		if (requisition.getInternalDeliveryLocation_eForm() != null)
			PageRequisitionCheckOut.fillInternalDeliveryLocation_EForm(driver, testCaseName, requisition.getInternalDeliveryLocation_eForm());
		if (requisition.getDeliveryInstruction_eForm() != null)
			PageRequisitionCheckOut.fillDeliveryInstructions_EForm(driver, testCaseName, requisition.getDeliveryInstruction_eForm());
		if (requisition.getEstimatedFreight_eForm() != null)
			PageRequisitionCheckOut.fillEstimatedFreight_EForm(driver, testCaseName, requisition.getEstimatedFreight_eForm());
		if (requisition.getPurchasingInstructions_eForm() != null)
			PageRequisitionCheckOut.fillPurchasingInstructions_EForm(driver, testCaseName, requisition.getPurchasingInstructions_eForm());

		return requisition;
	}

	/**
	 * <b>Author: bhakti.sawant </b><br>
	 * <font color="blue">Method :</b>Filling the QTS eForm in Requisition [QTS]
	 * <br>
	 * 
	 * @throws Exception
	 */
	public static Requisition fillQTSeFormInRequisition(WebDriver driver, String testCaseName, Requisition requisition) throws Exception
	{
		if (requisition.getIsPurchasedBefore() != null)
			PageRequisitionCheckOut.fillIsPurchaseBudgeted(driver, testCaseName, requisition.getIsThePurchaseBudgeted());
		if (requisition.getWhatIsPurchasedandWHY() != null)
			PageRequisitionCheckOut.fillWhatIsPurchasedAndWhy(driver, testCaseName, requisition.getWhatIsPurchasedandWHY());
		if (requisition.getIsPurchasedBefore() != null)
			PageRequisitionCheckOut.fillIsPurchasedBefore(driver, testCaseName, requisition.getIsPurchasedBefore());
		if (requisition.getIsPriceIncrease() != null)
			PageRequisitionCheckOut.fillIsPriceIncrease(driver, testCaseName, requisition.getIsPriceIncrease());
		if (requisition.getIsAdditionalSavings() != null)
			PageRequisitionCheckOut.fillIsAdditionalSavings(driver, testCaseName, requisition.getIsAdditionalSavings());
		if (requisition.getSavingsAchieved() != null)
			PageRequisitionCheckOut.fillSavingsAchieved(driver, testCaseName, requisition.getSavingsAchieved());
		return requisition;
	}

	/**
	 * @author omkar.jagdale
	 *         method to delete Non added items at requisition checkout page
	 * @throws FactoryMethodException
	 * @throws ActionBotException
	 */
	public static void deleteNonAddedItems(WebDriver driver, String testCaseName, Item item) throws ActionBotException, FactoryMethodException
	{
		List<String> addedItemIds = new ArrayList<String>();
		List<String> checkoutItemIds = PageRequisitionCheckOut.getListOfItemIdsOfCheckoutPageItem(driver, testCaseName);

		if (item.getCatelogItems() != null)
		{
			for (CatelogItem item1 : item.getCatelogItems())
			{
				addedItemIds.add(item1.getItemID());
			}
		}
		if (item.getGuidedItems() != null)
		{
			for (GuidedItem item1 : item.getGuidedItems())
			{
				addedItemIds.add(item1.getItemID());
			}
		}
		if (item.getPunchoutItems() != null)
		{
			for (PunchoutItem item1 : item.getPunchoutItems())
			{
				addedItemIds.add(item1.getItemId());
			}
		}
		if (item.getItemMasterItems() != null)
		{
			for (ItemMasterItem item1 : item.getItemMasterItems())
			{
				addedItemIds.add(item1.getItemId());
			}
		}
		checkoutItemIds.removeAll(addedItemIds);

		for (String id : checkoutItemIds)
		{
			PageRequisitionCheckOut.clickDeleteItem(driver, testCaseName, id);
			PopUpDeleteConfirmation.clickOnYesButton(driver, testCaseName);

		}
	}
}
