/**
 * 
 */
package com.zycus.automation.datacreation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.exec.util.StringUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;


import com.zycus.automation.bo.AccountingItemSummary;
import com.zycus.automation.bo.AddApprover;
import com.zycus.automation.bo.AdminMonitoring;
import com.zycus.automation.bo.ApiConsole;
import com.zycus.automation.bo.ApprovalAllRequests;
import com.zycus.automation.bo.AttachmentsAndCommentsItemSummary;
import com.zycus.automation.bo.BPO;
import com.zycus.automation.bo.BPOBuyingScope;
import com.zycus.automation.bo.Basket;
import com.zycus.automation.bo.Budget;
import com.zycus.automation.bo.BudgetDimension;
import com.zycus.automation.bo.BudgetLine;
import com.zycus.automation.bo.BudgetPeriod;
import com.zycus.automation.bo.BuyersDesk;
import com.zycus.automation.bo.BuyersDeskSetting;
import com.zycus.automation.bo.CEform;
import com.zycus.automation.bo.Catalog;
import com.zycus.automation.bo.CategoryManagerMap;
import com.zycus.automation.bo.CatelogItem;
import com.zycus.automation.bo.CostBookingItemSummary;
import com.zycus.automation.bo.CostBookingRequisitionSummary;
import com.zycus.automation.bo.CostCenterSplitInfo;
import com.zycus.automation.bo.CustomDate;
import com.zycus.automation.bo.DeliveryItemSummary;
import com.zycus.automation.bo.DeliverySplitInfo;
import com.zycus.automation.bo.DocumentInformation;
import com.zycus.automation.bo.EmailDetails;
import com.zycus.automation.bo.EntityOwnership;
import com.zycus.automation.bo.FileAttachment;
import com.zycus.automation.bo.GLAccount;
import com.zycus.automation.bo.GLMap;
import com.zycus.automation.bo.GuidedItem;
import com.zycus.automation.bo.GuidedItemSuggestSupplier;
import com.zycus.automation.bo.InviteSupplier;
import com.zycus.automation.bo.Invoice;
import com.zycus.automation.bo.Item;
import com.zycus.automation.bo.ItemMasterCatalog;
import com.zycus.automation.bo.ItemMasterItem;
import com.zycus.automation.bo.MySettings;
import com.zycus.automation.bo.OnlineStore;
import com.zycus.automation.bo.PCard;
import com.zycus.automation.bo.PEform;
import com.zycus.automation.bo.Project;
import com.zycus.automation.bo.PunchoutItem;
import com.zycus.automation.bo.PurchaseOrder;
import com.zycus.automation.bo.PurchaseOrderSettings;
import com.zycus.automation.bo.Receipt;
import com.zycus.automation.bo.Report;
import com.zycus.automation.bo.Requisition;
import com.zycus.automation.bo.RequisitionSettings;
import com.zycus.automation.bo.ReturnNote;
import com.zycus.automation.bo.StandardPO;
import com.zycus.automation.bo.TMS_paymentTermsSettings;
import com.zycus.automation.bo.Tax;
import com.zycus.automation.bo.UpdateAllLinesApplyTax;
import com.zycus.automation.bo.TMS.Warehouse;
import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.pageobjects.pages.settings.requisitionsettings.IPageRequisitionSettings;
import com.zycus.automation.eproc.reader.PropertyReader;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.eproc.testdata.IEmailTestingConstants;
import com.zycus.automation.services.CommonServices;
import com.zycus.automation.utilities.common.CommonUtilities;
import com.zycus.automation.utilities.utilitieshelpers.RandomCreditCardNumberGenerator;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;
import com.zycus.framework.framework_version_2_4.framework.Helper;
import com.zycus.framework.framework_version_2_4.framework_exception.TestCaseException;

/**
 * @author amitkumar.dash
 */
public class ObjectCreation
{
	static Logger logger = Logger.getLogger(ObjectCreation.class);

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get All Combination of guided item
	 * objects <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param configParams
	 *        </font><b><br>
	 * @param withNeedAQuote
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws TestCaseException
	 *         </b> <br>
	 * 
	 * @throws Exception
	 */
	public static List<GuidedItem> getAllCombinationOfGuidedItemObject() throws Exception
	{
		List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();
		for (int i = 1; i <= 2; i++)// item type
		{
			for (int j = 1; j <= 2; j++)// receive by
			{
				for (int k = 1; k <= 3; k++)// sourcing status
				{
					// if ((k == 3) || k != 3)
					if (k != 3)
					{
						if (j != 2 || k != 3)
						{
							GuidedItem guidedItem = getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);
							// set item type
							if (i == 1)
							{
								guidedItem.setItemType(IConstantsData.Goods);
							}
							else
							{
								guidedItem.setItemType(IConstantsData.Services);
							}

							// set Received By
							if (j == 1)
							{
								guidedItem.setReceiveBy(IConstantsData.Quantity);
							}
							else
							{
								guidedItem.setReceiveBy(IConstantsData.Amount);
							}

							// set Sourcing status
							if (k == 1)
							{
								guidedItem.setSourcingStatus(IConstantsData.Quoted_by_supplier);
								// count++;
								// to suggest supplier
								GuidedItemSuggestSupplier suggestSupplier = new GuidedItemSuggestSupplier();
								guidedItem.setSupplierType(IConstantsData.SUGGEST_NEW_SUPPLIER);
								suggestSupplier = getDefaultObjectOfGuidedItemSuggestSupplier(IConstantsData.SUGGEST_NEW_SUPPLIER);
								guidedItem.setGuidedItemSuggestSupplier(suggestSupplier);
							}
							else if (k == 2)
							{
								guidedItem.setSourcingStatus(IConstantsData.Estimated_price);

								// to suggest supplier
								GuidedItemSuggestSupplier suggestSupplier = new GuidedItemSuggestSupplier();
								if (i != 2)
								{
									guidedItem.setSupplierType(IConstantsData.SUGGEST_EXISTING_SUPPLIER);
									suggestSupplier = getDefaultObjectOfGuidedItemSuggestSupplier(IConstantsData.SUGGEST_EXISTING_SUPPLIER);
								}
								else
								{
									guidedItem.setSupplierType(IConstantsData.SUGGEST_NEW_SUPPLIER);
									suggestSupplier = getDefaultObjectOfGuidedItemSuggestSupplier(IConstantsData.SUGGEST_NEW_SUPPLIER);
								}
								guidedItem.setGuidedItemSuggestSupplier(suggestSupplier);
							}
							else if (k == 3)
							{
								guidedItem.setSourcingStatus(IConstantsData.Need_a_Quote);
								// count++;
								// to suggest supplier
								GuidedItemSuggestSupplier suggestSupplier = new GuidedItemSuggestSupplier();
								guidedItem.setSupplierType(IConstantsData.SUGGEST_NEW_SUPPLIER);
								suggestSupplier = getDefaultObjectOfGuidedItemSuggestSupplier(IConstantsData.SUGGEST_NEW_SUPPLIER);
								guidedItem.setGuidedItemSuggestSupplier(suggestSupplier);
							}
							/*
							 * if (count >= 2) { System.out.println(
							 * "@@@@@@ Inside count if : " + count); count = 0;
							 * //to suggest supplier GuidedItemSuggestSupplier
							 * suggestSupplier = new
							 * GuidedItemSuggestSupplier();
							 * guidedItem.setSupplierType(IConstantsData.
							 * SUGGEST_NEW_SUPPLIER); suggestSupplier =
							 * getDefaultObjectOfGuidedItemSuggestSupplier(
							 * IConstantsData.SUGGEST_NEW_SUPPLIER);
							 * guidedItem.setGuidedItemSuggestSupplier(
							 * suggestSupplier); }
							 */

							guidedItems.add(guidedItem);

						} // inner if
					} // outer if
				} // inner for
			} // outer for
		} // outer for
		return guidedItems;
	}

	public static Map<String, String> getCostCenterProjectAndBudget() throws Exception
	{
		Map<String, String> map = new HashMap<String, String>();
		String costCenterBudgetAndProject = CommonServices.getTestData(IConstantsData.CC_PROJECT_BUDGET);
		String costCenter, budget, project;
		String temp[] = StringUtils.split(costCenterBudgetAndProject.trim(), ",");
		costCenter = temp[0].trim();
		project = temp[1].trim();
		budget = temp[2].trim();

		map.put(IConstantsData.costCenter, costCenter);
		map.put(IConstantsData.project, project);
		map.put(IConstantsData.budget, budget);

		return map;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get default catalog item <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	public static CatelogItem getDefaultCatalogItemObject() throws Exception
	{
		int quantity = CommonUtilities.getNonZeroRandomNumbers(2);
		// catelog item
		CatelogItem catelogItem = new CatelogItem();
		catelogItem.setItemName(CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING));
		catelogItem.setQuantity(quantity);
		return catelogItem;

	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get Default guided item object <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	public static GuidedItem getDefaultGuidedItemObject(String supplierType) throws Exception
	{
		float quantity = CommonUtilities.getNonZeroRandomNumbers(2);
		GuidedItem guidedItem = new GuidedItem();

		guidedItem.setItemName(CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING));
		guidedItem.setShortDescription(CommonUtilities.getShortDescriptionOfGuidedItem());
		guidedItem.setItemType(IConstantsData.Goods);
		guidedItem.setPartNumber("Item_Part_Id_" + CommonUtilities.getNonZeroRandomNumbers(2));
		guidedItem.setQuantity(quantity);
		guidedItem.setContractNoInSuppInfo(Integer.toString(CommonUtilities.getNonZeroRandomNumbers(2)));
		guidedItem.setCurrency("USD");
		guidedItem.setItemType(CommonServices.getTestData(IConstantsData.ITEM_TYPE_OPTION));
		guidedItem.setLongDescription("Auto generated Long Description for Guided Item");
		guidedItem.setPrice((float) 596.13269);
		guidedItem.setQuantity(quantity);
		guidedItem.setReceiveBy(CommonServices.getTestData(IConstantsData.RECEIVE_BY_OPTION));
		guidedItem.setSourcingStatus(CommonServices.getTestData(IConstantsData.SOURCING_STATUS_OPTION));
		guidedItem.setEditCategory(true);
		if (supplierType != null)
		{
			if (supplierType.equalsIgnoreCase(IConstantsData.SUGGEST_NEW_SUPPLIER) || supplierType.equalsIgnoreCase(IConstantsData.SUGGEST_EXISTING_SUPPLIER))
			{
				guidedItem.setSupplierType(supplierType);
				GuidedItemSuggestSupplier guidedItemSuggestSupplier = getDefaultObjectOfGuidedItemSuggestSupplier(supplierType);
				guidedItem.setGuidedItemSuggestSupplier(guidedItemSuggestSupplier);
			}
			else if (supplierType.equalsIgnoreCase(IConstantsData.EXISTING_SUPPLIER))
			{
				if (guidedItem.getSupplierNameInSuppInfo() != null)
				{
					guidedItem.setSupplierNameInSuppInfo(guidedItem.getSupplierNameInSuppInfo());
				}
				else
				{
					guidedItem.setSupplierNameInSuppInfo(CommonServices.getTestData(IConstantsData.SUPPLIER_NAME));
				}
				guidedItem.setSupplierType(IConstantsData.EXISTING_SUPPLIER);
				guidedItem.setContractNoInSuppInfo(Integer.toString(CommonUtilities.getNonZeroRandomNumbers(2)));
			}

		}
		else
		{
			guidedItem.setSupplierType(IConstantsData.EXISTING_SUPPLIER);
			guidedItem.setSupplierNameInSuppInfo(CommonServices.getTestData(IConstantsData.SUPPLIER_NAME));
			guidedItem.setContractNoInSuppInfo(Integer.toString(CommonUtilities.getNonZeroRandomNumbers(2)));
		}
		guidedItem.setUom("Each");
		// guidedItem.setIsPreferred(IConstantsData.Is_Preferred);
		guidedItem.setSpecification("Unique");
		// guidedItem.setActivity(IConstantsData.ViewItem);
		guidedItem.setActivity(IConstantsData.AddAnotherItem);
		guidedItem.setNextAction(IConstantsData.SAVE);

		return guidedItem;
	}

	/**
	 * <b>Author: priyanka.jadhav</b> <b><br>
	 * <font color="blue">Method :</b>To get Default guided item object with
	 * additional fields(i.e Requirement Details) <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	public static GuidedItem getDefaultGuidedItemObjectWithRequirementDetails(String supplierType) throws Exception
	{
		GuidedItem guidedItem = getDefaultGuidedItemObject(supplierType);
		guidedItem.setRequirementDetails(true);
		guidedItem.setRequisitionAppliesTo_RequirementDetail(IConstantsData.UNKNOWN_REQUISITION_APPLIES_TO_CONTRACT_DETAILS);
		guidedItem.setResponse_RequirementDetail(IConstants.NO);
		guidedItem.setPoSentToSupplier_RequirementDetail(IConstants.YES);
		guidedItem.setQuoteObtained_RequirementDetail(IConstants.NO);

		return guidedItem;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get default accounting object <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCase
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	public static AccountingItemSummary getDefaultObjectOfAccounting() throws Exception
	{
		AccountingItemSummary accountingItemSummary = new AccountingItemSummary();

		// comment glaccount type once the build is changed
		accountingItemSummary.setGlAccount(CommonServices.getTestData(IConstantsData.GL_ACCOUNT));
		accountingItemSummary.setNextAction(IConstantsData.SAVE);
		return accountingItemSummary;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get default object of cost booking <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCase
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	public static CostBookingRequisitionSummary getDefaultObjectOfCostBooking() throws Exception
	{
		String costCenterAndBudget = CommonServices.getTestData(IConstantsData.CC_PROJECT_BUDGET);
		String costCenter, budget, project;
		String[] temp = costCenterAndBudget.split(",");
		costCenter = temp[0];
		project = temp[1];
		budget = temp[2];

		CostBookingRequisitionSummary costBookingRequisitionSummary = new CostBookingRequisitionSummary();
		costBookingRequisitionSummary.setBookCostToSingleCostCenter(true);
		costBookingRequisitionSummary.setCostCenter(costCenter);
		costBookingRequisitionSummary.setProject(project);
		costBookingRequisitionSummary.setBudget(budget);
		costBookingRequisitionSummary.setGlAccount(CommonServices.getTestData(IConstantsData.GL_ACCOUNT));
		costBookingRequisitionSummary.setNextAction(IConstantsData.SAVE);

		return costBookingRequisitionSummary;
	}

	public static Requisition getDefaultRequisitionObjectWithItems(WebDriver driver) throws Exception
	{
		Item item = new Item();
		CatelogItem catelogItem = new CatelogItem();
		List<CatelogItem> catelogItems = new ArrayList<CatelogItem>();
		List<GuidedItem> guidedItems = new ArrayList<GuidedItem>();
		Requisition requisition = new Requisition();

		// to get default Catalog Item
		catelogItem = ObjectCreation.getDefaultCatalogItemObject();
		catelogItems.add(catelogItem);

		// to get all combinations of guided items
		guidedItems = ObjectCreation.getAllCombinationOfGuidedItemObject();

		// to set item
		item.setCatelogItems(catelogItems);
		item.setGuidedItems(guidedItems);

		// to get default req object
		requisition = ObjectCreation.getRequisition(driver);
		requisition.setItems(item);
		requisition.setNextAction(IConstantsData.SUBMIT_REQ);

		return requisition;
	}

	public static Item getItem(String itemType) throws Exception
	{
		Item item = new Item();
		CommonUtilities.getNonZeroRandomNumbers(2);

		if (IConstantsData.CATALOG_ITEM.equalsIgnoreCase(itemType))
		{
			// catelog item list
			List<CatelogItem> catelogItemList = new ArrayList<CatelogItem>();

			// catelog item
			CatelogItem catelogItem = new CatelogItem();
			catelogItem = getDefaultCatalogItemObject();

			// Add item
			catelogItemList.add(catelogItem);

			item.setCatelogItems(catelogItemList);
		}
		else if (IConstantsData.GUIDED_ITEM.equalsIgnoreCase(itemType))
		{
			// Guided item list
			List<GuidedItem> guidedItemList = new ArrayList<GuidedItem>();

			GuidedItem guidedItem = new GuidedItem();

			guidedItem = getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);

			// Add item
			guidedItemList.add(guidedItem);

			item.setGuidedItems(guidedItemList);
		}
		else if (IConstantsData.BOTH.equalsIgnoreCase(itemType))
		{
			// catelog item list
			List<CatelogItem> catelogItemList = new ArrayList<CatelogItem>();

			// catelog item
			CatelogItem catelogItem = new CatelogItem();
			catelogItem = getDefaultCatalogItemObject();

			// Add item
			catelogItemList.add(catelogItem);

			item.setCatelogItems(catelogItemList);

			// Guided item list
			List<GuidedItem> guidedItemList = new ArrayList<GuidedItem>();

			GuidedItem guidedItem = new GuidedItem();

			guidedItem = getDefaultGuidedItemObject(IConstantsData.EXISTING_SUPPLIER);

			// Add item
			guidedItemList.add(guidedItem);

			item.setGuidedItems(guidedItemList);
		}
		else if (IConstantsData.ITEM_MASTER_ITEM.equalsIgnoreCase(itemType))
		{
			// item master item list
			List<ItemMasterItem> itemMasterItems = new ArrayList<ItemMasterItem>();

			// item master item
			ItemMasterItem itemMasterItem = new ItemMasterItem();
			itemMasterItem = getDefaultItemMasterItemObject();

			// Add item
			itemMasterItems.add(itemMasterItem);

			item.setItemMasterItems(itemMasterItems);
		}

		return item;
	}

	public static Requisition getRequisition(WebDriver driver) throws Exception
	{
		Requisition requisition = new Requisition();
		requisition.setReqName(CommonUtilities.getReqName());
		requisition.setCustomDate(CommonUtilities.getRequiredBy());
		requisition.setAssignedBuyer(CommonServices.getTestData(IConstantsData.BUYER_NAME));
		requisition.setSettlementvia(IConstantsData.SETTLEMENT_VIA_OPTION_INVOICE);
		requisition.setEditHeaderLevelInfo(true);
		requisition.setEditItemLevelInfo(true);
		requisition.setAssignedBuyer(null);
		requisition.setVerifyWorkflow(true);
		requisition.setEditMiscellaneous(false);
		requisition.setRecallRequisitionVia(IConstantsData.VIA_ACTION_DROPDOWN);
		requisition.setPurchaseType(CommonServices.getTestData(IConstantsData.PURCHASE_TYPE).trim());

		CostBookingRequisitionSummary costBookingRequisitionSummary = getDefaultObjectOfCostBooking();
		requisition.setCostBookingRequisitionSummary(costBookingRequisitionSummary);

		CostBookingItemSummary costBookingItemSummary = getDefaultObjectOfCostBookingItemSummary();
		requisition.setCostBookingItemSummary(costBookingItemSummary);
		requisition.setNextAction(IConstantsData.SUBMIT_REQ);
		return requisition;
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>To get default object of Basket <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCase
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	public static Basket createBasket() throws Exception
	{
		Basket basket = new Basket();
		basket.setBasketName(CommonServices.getTestData(IConstantsData.BASKET_NAME) + RandomStringUtils.randomAlphabetic(3));
		basket.setCompanyCode(CommonServices.getTestData(IConstantsData.COMP_CODE));
		basket.setDepartmentCode(CommonServices.getTestData(IConstantsData.DEPT_CODE));
		return basket;
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>To get default object of Item to be
	 * searched <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCase
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	public static OnlineStore searchItem() throws Exception
	{

		OnlineStore onlinestore = new OnlineStore();
		// onlinestore.setSearchItem(CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING,
		// 2));
		onlinestore.setSearchItem(CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING));
		onlinestore.setQuantity(Integer.parseInt(CommonServices.getTestData(IConstantsData.Item_Quantity, 2)));
		onlinestore.setAddItemTo(IConstantsData.ADD_TO_CART);
		onlinestore.setItemType(IConstantsData.CATALOG_ITEM);
		onlinestore.setNextAction(IConstantsData.Checkout);
		return onlinestore;
	}

	public static StandardPO getStandardPoCreation(String itemType) throws Exception
	{
		StandardPO standardpo = new StandardPO();
		standardpo.setSupplierName(CommonServices.getTestData(IConstantsData.SUPPLIER_NAME));
		standardpo.setOrderDescription(CommonServices.getTestData(IConstantsData.ORDER_DESCRIPTION));
		standardpo.setPurchaseType(CommonServices.getTestData(IConstantsData.PURCHASE_TYPE).trim());
		standardpo.setBuyer(CommonServices.getTestData(IConstantsData.BUYER_NAME));
		standardpo.setCustomDate(CommonUtilities.getRequiredBy());
		standardpo.setDeliveryTerms(CommonServices.getTestData(IConstantsData.DELIVERY_TERMS));
		standardpo.setEditHeaderLevelInfo(true);

		CostBookingRequisitionSummary costBookingRequisitionSummary = getDefaultObjectOfCostBooking();

		standardpo.setCostBookingRequisitionSummary(costBookingRequisitionSummary);

		standardpo.setItems(getItem(itemType));
		if (standardpo.getItems().getGuidedItems() != null)
		{
			List<GuidedItem> guidedItems = standardpo.getItems().getGuidedItems();
			for (GuidedItem guidedItem : guidedItems)
			{
				guidedItem.setNextAction(IConstantsData.SAVE);
			}
		}

		AccountingItemSummary accountingItemSummary = getDefaultObjectOfAccounting();

		// AttachmentsAndCommentsItemSummary attachmentsAndCommentsItemSummary =
		// getDefaultObjectOfAttachmentAnCommentsItemSummary();

		// standardpo.setAttachmentsAndCommentsItemSummary(attachmentsAndCommentsItemSummary);
		standardpo.setAccountingItemSummary(accountingItemSummary);
		standardpo.setNextAction(IConstantsData.SUBMIT_PO_FOR_PROCESSING);
		// standardpo.setPoChange(IConstantsData.PO_CHANGE_COMMENT);
		return standardpo;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get default NON PO Invoice object <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @return </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	public static Invoice getDefaultNonPOInvoiceObject() throws Exception
	{
		Invoice invoice = new Invoice();
		invoice.setAddAttachment(false);
		invoice.setFileName(null);
		invoice.setInvoiceNo(CommonUtilities.getRandomInvoiceNo());
		invoice.setInvoiceDate(CommonUtilities.getTodaysDate());
		invoice.setInvoiceDueDate(CommonUtilities.getDayAfterTodaysDate());
		invoice.setBuyer(CommonServices.getTestData(IConstantsData.BUYER_NAME));
		invoice.setPurchaseType(CommonServices.getTestData(IConstantsData.PURCHASE_TYPE).trim());
		invoice.setNextAction(IConstantsData.SUBMIT_INVOICE);
		invoice.setStandardPO(getStandardPoCreation(IConstantsData.BOTH));
		invoice.getStandardPO().getItems().getGuidedItems().get(0).setNextAction(IConstantsData.SAVE);
		return invoice;

	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get default NON PO Invoice object <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @return </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	public static Invoice getDefaultFlipInvoiceObject() throws Exception
	{
		Invoice invoice = new Invoice();

		invoice.setInvoiceNo(CommonUtilities.getRandomInvoiceNo());
		invoice.setInvoiceDate(CommonUtilities.getTodaysDate());
		invoice.setInvoiceDueDate(CommonUtilities.getDayAfterTodaysDate());
		invoice.setNextAction(IConstantsData.SUBMIT_INVOICE);
		return invoice;

	}

	public static Catalog getDefaultCatalogObject() throws Exception
	{
		Catalog catalog = new Catalog();
		catalog.setFillCatalogDetails(true);
		catalog.setCatalogName(CommonUtilities.getCatalogName());
		catalog.setContractNumber(Integer.toString(CommonUtilities.getNonZeroRandomNumbers(3)));
		catalog.setSupplierName(CommonServices.getTestData(IConstantsData.SUPPLIER_NAME));
		catalog.setSupplierERPId(CommonServices.getTestData(IConstantsData.SUPPLIER_ERP_ID));
		catalog.setCatalogDetailsNextAction(IConstantsData.NEXT);
		List<CatelogItem> listOfCatalogItems = new ArrayList<CatelogItem>();
		CatelogItem catalogItem = getDefaultCatalogItemObject();
		catalogItem.setItemName(IConstantsData.ITEM_NAME_FOR_CREATING_NEW_CATALOG + "_" + System.currentTimeMillis());
		catalogItem.setDescription("Automation_item_description");
		catalogItem.setUnitPrice(236.69);
		catalogItem.setSupplierPartID(Integer.toString(CommonUtilities.getNonZeroRandomNumbers(3)));
		catalogItem.setNextAction(IConstantsData.ADD_ITEM_TO_CATALOG);
		catalogItem.setProductURL("https://cdn.shopify.com/s/files/1/0227/0033/products/Davek_Umbrella_Elite_Open_Straight.jpg?v=1487711086");
		catalogItem.setManufacturerName("Automation_manufacturer_name");
		catalogItem.setManufacturerPartId("Automation_manufacturer_part_id");
		catalogItem.setManufacturerURL("Automation_manufacturer_url");
		catalogItem.setMarketPrice("323.123");
		catalogItem.setDelieveryDays(CommonUtilities.getNonZeroRandomNumbers(2));
		catalogItem.setContractNo(Float.toString(CommonUtilities.getNonZeroRandomNumber(3)));
		catalogItem.setGreen(true);
		catalogItem.setPreferred(true);
		catalogItem.setSpecificationName("Automation_spec_name");
		catalogItem.setSpecificationType("Automation_spec_type");
		catalogItem.setSpecificationValue("Automation_spec_value");
		catalogItem.setErpPartNo("ERPID12345");
		List<String> attachments = new ArrayList<>();
		attachments.add("https://cdn.shopify.com/s/files/1/0227/0033/products/Davek_Umbrella_Elite_Open_Straight.jpg?v=1487711086");
		catalogItem.setAttachments(attachments);
		listOfCatalogItems.add(catalogItem);
		catalog.setCatelogItems(listOfCatalogItems);
		catalog.setItemDetailsNextAction(IConstantsData.NEXT);
		catalog.setOrganizationUnit(CommonServices.getTestData(IConstantsData.ORGANIZATION_UNIT_OR_COMPANY_NAME));
		catalog.setRegion(null);
		catalog.setCompany(IConstantsData.ALL);
		catalog.setBusinessUnit(IConstantsData.ALL);
		catalog.setLocation(IConstantsData.ALL);
		catalog.setNextAction(IConstantsData.SUBMIT_CATALOG);
		return catalog;
	}

	public static Receipt getDefaultReceiptObject() throws Exception
	{
		Receipt receipt = new Receipt();
		receipt.setStandardPO(getStandardPoCreation(IConstantsData.BOTH));
		receipt.setNextAction(IConstantsData.SUBMIT_INVOICE);
		return receipt;
	}

	public static ReturnNote getDefaultReturnNoteObject() throws Exception
	{
		ReturnNote returnNote = new ReturnNote();
		returnNote.setNextAction(IConstantsData.SUBMIT);
		return returnNote;
	}

	public static CEform getDefaultCEformObject() throws Exception
	{
		CEform cEform = new CEform();
		cEform.setCeformName(CommonUtilities.getCEformName());
		cEform.setCeformDisplayName(CommonUtilities.getCEformName());
		cEform.setChangeCategory(true);
		cEform.setChangeOU(true);
		cEform.setAddSectionAndField(true);
		cEform.setSectionName(CommonUtilities.getSectionName());
		cEform.setFieldName(CommonUtilities.getFieldName());
		//		 cEform.setCategory(CommonServices.getTestData(IConstantsData.SEARCH_FOR_CATEGORY));
		cEform.setCategory("Paper Materials and Products");
		cEform.setRegionName(CommonServices.getTestData(IConstantsData.Region_Name));
		cEform.setOU(CommonServices.getTestData(IConstantsData.BU_NAME_FOR_CEFORM));
		cEform.setNextAction(IConstantsData.PUBLISH_EFORM);
		return cEform;
	}

	public static PEform getDefaultPEformObject() throws Exception
	{
		PEform pEform = new PEform();
		pEform.setPeformName(CommonUtilities.getPEformName());
		pEform.setProcessName(IConstantsData.REQUISITION_FORMS);
		pEform.setPurchaseType(CommonServices.getTestData(IConstantsData.PURCHASE_TYPE).trim());
		pEform.setChangeOU(true);
		pEform.setAddSectionAndField(true);
		pEform.setSectionName(CommonUtilities.getSectionName());
		pEform.setFieldName(CommonUtilities.getFieldName());
		pEform.setRegionName(CommonServices.getTestData(IConstantsData.Region_Name));
		pEform.setOU(CommonServices.getTestData(IConstantsData.BU_NAME_FOR_CEFORM));
		pEform.setNextAction(IConstantsData.PUBLISH_EFORM);
		pEform.setAddMultipleFields(false);
		return pEform;
	}

	public static GuidedItemSuggestSupplier getDefaultObjectOfGuidedItemSuggestSupplier(String supplierType) throws Exception
	{
		GuidedItemSuggestSupplier suggestSupplier = new GuidedItemSuggestSupplier();
		if (supplierType.equalsIgnoreCase(IConstantsData.SUGGEST_EXISTING_SUPPLIER))
		{
			suggestSupplier.setExistingSupplierName(CommonServices.getTestData(IConstantsData.SUPPLIER_NAME));
			suggestSupplier.setContractNo(Integer.toString(CommonUtilities.getNonZeroRandomNumbers(2)));
		}
		// IConstantsData.SUGGEST_NEW_SUPPLIER
		else
		{
			suggestSupplier.setSuggestNewSupplierName(CommonServices.getTestData(IConstantsData.NEW_SUPPLIER_NAME));
			suggestSupplier.setSupplierAddress(CommonServices.getTestData(IConstantsData.NEW_SUPPLIER_LOCATION));
			suggestSupplier.setContractNo(Integer.toString(CommonUtilities.getNonZeroRandomNumbers(2)));
			suggestSupplier.setSupplierContact(CommonServices.getTestData(IConstantsData.NEW_SUPPLIER_CONTACT_PERSON));
			suggestSupplier.setEmailId(CommonServices.getTestData(IConstantsData.NEW_SUPPLIER_EMAIL_ID));
			suggestSupplier.setPhone(Integer.parseInt(CommonServices.getTestData(IConstantsData.NEW_SUPPLIER_PHONE_NO)));
			// add any text in other details
			suggestSupplier.setOtherDetails(CommonUtilities.getShortDescriptionOfGuidedItem());
		}
		suggestSupplier.setNextAction(IConstantsData.ADD_SUGGEST_SUPPLIER);
		return suggestSupplier;
	}

	public static AttachmentsAndCommentsItemSummary getDefaultObjectOfAttachmentAnCommentsItemSummary()
	{
		AttachmentsAndCommentsItemSummary attachmentsAndCommentsItemSummary = new AttachmentsAndCommentsItemSummary();
		FileAttachment attachment = new FileAttachment();
		attachment.setFileName(IConstants.ATTACHMENT_FILES_PATH + ConfigProperty.getConfig(IConstants.reqAttachment));
		List<FileAttachment> attachments = new ArrayList<FileAttachment>();
		attachments.add(attachment);
		attachmentsAndCommentsItemSummary.setAttachments(attachments);
		attachmentsAndCommentsItemSummary.setNextAction(IConstantsData.SAVE);

		return attachmentsAndCommentsItemSummary;
	}

	public static Map<String, String> getOtherCostCenterProjectAndBudget() throws Exception
	{
		Map<String, String> map = new HashMap<String, String>();
		String costCenterBudgetAndProject = CommonServices.getTestData(IConstantsData.other_CC_other_project_other_budget);
		String costCenter, budget, project;
		String temp[] = StringUtils.split(costCenterBudgetAndProject.trim(), ",");
		costCenter = temp[0].trim();
		project = temp[1].trim();
		budget = temp[2].trim();

		map.put(IConstantsData.costCenter, costCenter);
		map.put(IConstantsData.project, project);
		map.put(IConstantsData.budget, budget);

		return map;

	}

	public static CostBookingItemSummary getDefaultObjectOfCCSplitAtItemLevel(boolean isSplitWithQuantity, float quantity) throws Exception
	{
		CostBookingItemSummary costBookingItemSummary = new CostBookingItemSummary();
		List<CostCenterSplitInfo> centerSplitInfos = new ArrayList<CostCenterSplitInfo>();
		Map<String, String> cc_budget_project = getCostCenterProjectAndBudget();
		int percentage1 = 0, percentage2 = 0, quant1 = 0, quant2 = 0;

		// to set CC split object
		costBookingItemSummary.setSplitCostCenterAtItemLevel(true);

		// for 1st split data
		CostCenterSplitInfo centerSplitInfo1 = new CostCenterSplitInfo();
		centerSplitInfo1.setCostCenter(cc_budget_project.get(IConstantsData.costCenter));
		centerSplitInfo1.setProject(cc_budget_project.get(IConstantsData.project));
		centerSplitInfo1.setBudget(cc_budget_project.get(IConstantsData.budget));
		if (isSplitWithQuantity)
		{
			costBookingItemSummary.setSplitCostCenterAtItemLevel_quantity(true);
			quant1 = CommonUtilities.getRandomNumbersBetweenRange(1, 1, quantity);
			centerSplitInfo1.setQuantity(quant1);
		}
		else
		{
			costBookingItemSummary.setSplitCostCenterAtItemLevel_percentage(true);
			percentage1 = CommonUtilities.getRandomNumbersBetweenRange(2, 1, 100);
			centerSplitInfo1.setPercentage(percentage1);
		}

		String other_cc_project_budget = CommonServices.getTestData(IConstantsData.other_CC_other_project_other_budget);
		String[] temp = StringUtils.split(other_cc_project_budget, ",");
		// for 2nd split data
		CostCenterSplitInfo centerSplitInfo2 = new CostCenterSplitInfo();
		centerSplitInfo2.setCostCenter(temp[0].trim());
		centerSplitInfo2.setProject(temp[1].trim());
		centerSplitInfo2.setBudget(temp[2].trim());
		if (isSplitWithQuantity)
		{
			quant2 = (int) (quantity - quant1);
			centerSplitInfo2.setQuantity(quant2);
		}
		else
		{
			percentage2 = 100 - percentage1;
			centerSplitInfo2.setPercentage(percentage2);
		}
		centerSplitInfos.add(centerSplitInfo1);
		centerSplitInfos.add(centerSplitInfo2);
		costBookingItemSummary.setCostCenterSplitInfo(centerSplitInfos);
		costBookingItemSummary.setNextAction(IConstantsData.SAVE);
		AccountingItemSummary accountingItemSummary = getDefaultObjectOfAccounting();
		costBookingItemSummary.setAccountingItemSummary(accountingItemSummary);

		return costBookingItemSummary;
	}

	public static Requisition getDefaultObjectOfRequisitionWithItems(WebDriver driver, String itemType) throws Exception
	{
		Requisition requisition = new Requisition();
		Item item = getItem(itemType);

		// to get default req object
		requisition = ObjectCreation.getRequisition(driver);
		requisition.setItems(item);

		return requisition;
	}

	public static DeliveryItemSummary getDefaultObjectOfDeliverySplitAtItemLevel(float quantity) throws Exception
	{
		DeliveryItemSummary deliveryItemSummary = new DeliveryItemSummary();
		List<DeliverySplitInfo> deliverySplitInfos = new ArrayList<DeliverySplitInfo>();
		int quant1 = 0, quant2 = 0;

		// to set delivery split object
		deliveryItemSummary.setSplitDeliveryToMultipleLocations(true);

		// for 1st split data
		DeliverySplitInfo deliverySplitInfo1 = new DeliverySplitInfo();
		quant1 = (int) (quantity / 2);
		quant2 = (int) (quantity - quant1);

		deliverySplitInfo1.setQuantity(quant1);

		// for 2nd split data
		DeliverySplitInfo deliverySplitInfo2 = new DeliverySplitInfo();
		deliverySplitInfo2.setDeliveryAddress(CommonServices.getTestData(IConstantsData.OTHER_ADDRESS));
		deliverySplitInfo2.setQuantity(quant2);

		deliverySplitInfos.add(deliverySplitInfo1);
		deliverySplitInfos.add(deliverySplitInfo2);

		deliveryItemSummary.setDeliverySplitInfo(deliverySplitInfos);
		deliveryItemSummary.setNextAction(IConstantsData.NONE);
		return deliveryItemSummary;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get object of approval all requests
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param docSearchByType
	 *        </font><b><br>
	 * @param doc
	 *        </font><b><br>
	 * @param docType
	 *        </font><b><br>
	 * @param action
	 *        </font><b><br>
	 * @return </b> <br>
	 */
	public static ApprovalAllRequests getObjectOfApprovalAllRequests(String docSearchByType, String doc, String docType, String action)
	{
		ApprovalAllRequests approvalAllRequests = new ApprovalAllRequests();
		// to set docSearchType
		if (docSearchByType.equalsIgnoreCase(IConstantsData.DOC_NO))
		{
			approvalAllRequests.setDocumentNo(doc);
		}
		else if (docSearchByType.equalsIgnoreCase(IConstantsData.DOC_NAME))
		{
			approvalAllRequests.setDocumentName(doc);
		}
		else if (docSearchByType.equalsIgnoreCase(IConstantsData.INITIATOR_NAME))
		{
			approvalAllRequests.setInitiatorName(doc);
		}

		// to set doc type
		if (docType.equalsIgnoreCase(IConstantsData.REQUISITION))
		{
			approvalAllRequests.setDocumentType(IConstantsData.REQUISITION);
		}
		else if (docType.equalsIgnoreCase(IConstantsData.PURCHASE_ORDER))
		{
			approvalAllRequests.setDocumentType(IConstantsData.PURCHASE_ORDER);
		}
		else if (docType.equalsIgnoreCase(IConstantsData.BPO))
		{
			approvalAllRequests.setDocumentType(IConstantsData.BPO);
		}
		else if (docType.equalsIgnoreCase(IConstantsData.INVOICE))
		{
			approvalAllRequests.setDocumentType(IConstantsData.INVOICE);
		}
		else if (docType.equalsIgnoreCase(IConstantsData.CATALOG))
		{
			approvalAllRequests.setDocumentType(IConstantsData.CATALOG);
		}

		// to set action
		if (action.equalsIgnoreCase(IConstantsData.APPROVE))
		{
			approvalAllRequests.setActions(IConstantsData.APPROVE);
			approvalAllRequests.setComment(IConstantsData.APPROVE_COMMENT);
		}
		else if (action.equalsIgnoreCase(IConstantsData.REJECT))
		{
			approvalAllRequests.setActions(IConstantsData.REJECT);
			approvalAllRequests.setComment(IConstantsData.REJECT_COMMENT);
		}
		else if (action.equalsIgnoreCase(IConstantsData.DELEGATE))
		{
			approvalAllRequests.setActions(IConstantsData.DELEGATE);
			approvalAllRequests.setComment(IConstantsData.DELEGATE_COMMENT);
		}

		return approvalAllRequests;

	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Default object of budget <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @return </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	public static Budget getDefaultObjectOfBudget() throws Exception
	{
		Budget budget = new Budget();
		budget.setOwnerName(CommonServices.getTestData(IConstantsData.DELIVERS_TO_OR_OWNER));
		budget.setCompanyName(CommonServices.getTestData(IConstantsData.ORGANIZATION_UNIT_OR_COMPANY_NAME));
		budget.setBudgetName(CommonUtilities.getBudgetName());
		budget.setCurrencyType(CommonServices.getTestData(IConstantsData.CURRENCY_TYPE));
		budget.setAddPeriod(true);

		// budget period
		BudgetPeriod budgetPeriod = new BudgetPeriod();
		budgetPeriod.setPeriodStartDate(CommonUtilities.getTodaysDate());
		CustomDate customDate = new CustomDate();
		customDate = CommonUtilities.getDayAfterTodaysDate();
		customDate.setYear(customDate.getYear() + CommonUtilities.getNonZeroRandomNumbers(1));
		budgetPeriod.setPeriodEndDate(customDate);
		// budgetPeriod.setPeriodName("Period_" + System.currentTimeMillis());
		budgetPeriod.setNextAction(IConstantsData.ADD);
		budget.setBudgetPeriod(budgetPeriod);

		budget.setAddBudgetLine(true);

		// budget dimension
		budget.setAddBudgetDimensions(true);
		BudgetDimension budgetDimension = new BudgetDimension();
		budgetDimension.setLocation(true);
		budgetDimension.setCostCenter(true);
		budgetDimension.setDepartment(true);
		budgetDimension.setDesignation(true);

		budget.setBudgetDimension(budgetDimension);

		// budget line
		BudgetLine budgetLine = getDefaultObjetOfBudgetLine();

		List<BudgetLine> budgetLines = new ArrayList<BudgetLine>();
		budgetLines.add(budgetLine);
		budget.setBudgetLines(budgetLines);

		budget.setNextAction(IConstantsData.SAVE_AND_FREEZE_BUDGET);
		return budget;
	}

	public static BudgetLine getDefaultObjetOfBudgetLine() throws Exception
	{
		// budget line
		BudgetLine budgetLine = new BudgetLine();
		budgetLine.setBusinessUnit(CommonServices.getTestData(IConstantsData.BUSINESS_UNIT_NAME));
		budgetLine.setLocation(CommonServices.getTestData(IConstantsData.LOCATION_NAME));
		budgetLine.setCostCenter(CommonUtilities.getCostCenterInfoFromTestData().getCostCenter());
		budgetLine.setDepartment(CommonServices.getTestData(IConstantsData.DEPATMENT_NAME));
		budgetLine.setBudgetLineCode(System.currentTimeMillis()+ "BudgetLineCode" + CommonUtilities.getNonZeroRandomNumber(2));
		budgetLine.setBudgetLineName("Budget_Line_" + System.currentTimeMillis());
		budgetLine.setOwner(CommonServices.getTestData(IConstantsData.DELIVERS_TO_OR_OWNER));
		budgetLine.setPlannedAmount("999999999");
		budgetLine.setNextAction(IConstantsData.SAVE);
		return budgetLine;
	}

	public static Map<String, String> getCostCenterProjectAndBudgetOfOtherCompany() throws Exception
	{
		Map<String, String> map = new HashMap<String, String>();
		String costCenterProjectAndBudget = CommonServices.getTestData(IConstantsData.OTHER_COMPANY_CC_OTHER_COMPANY_PROJECT_OTHER_COMPANY_BUDGET);
		String costCenter, budget, project;
		String temp[] = StringUtils.split(costCenterProjectAndBudget.trim(), ",");
		costCenter = temp[0].trim();
		project = temp[1].trim();
		budget = temp[2].trim();

		map.put(IConstantsData.costCenter, costCenter);
		map.put(IConstantsData.project, project);
		map.put(IConstantsData.budget, budget);

		return map;

	}

	public static CostBookingItemSummary getDefaultObjectOfCostBookingItemSummary() throws Exception
	{
		AccountingItemSummary accountingItemSummary = new AccountingItemSummary();
		accountingItemSummary.setGlAccount(CommonServices.getTestData(IConstantsData.GL_ACCOUNT));
		accountingItemSummary.setAssetCode(CommonServices.getTestData(IConstantsData.ASSET_CODE));
		CostBookingItemSummary costBookingItemSummary = new CostBookingItemSummary();
		costBookingItemSummary.setAccountingItemSummary(accountingItemSummary);
		costBookingItemSummary.setNextAction(IConstantsData.SAVE);

		return costBookingItemSummary;

	}

	public static BPO getBPOCreation(String itemType) throws Exception
	{
		BPO bpo = new BPO();
		bpo.setSupplierName(CommonServices.getTestData(IConstantsData.SUPPLIER_NAME));
		bpo.setOrderDescription(CommonServices.getTestData(IConstantsData.ORDER_DESCRIPTION));
		bpo.setCurrencyType("USD");
		bpo.setPurchaseType(CommonServices.getTestData(IConstantsData.PURCHASE_TYPE).trim());
		bpo.setBuyer(CommonServices.getTestData(IConstantsData.BUYER_NAME));
		bpo.setDeliveryTerms(CommonServices.getTestData(IConstantsData.DELIVERY_TERMS));
		bpo.setRemoveAllTaxes(true);
		// standardpo.setCustomDate(CommonUtilities.getRequiredBy());

		/*
		 * standardpo.setAttachmentFileName(IConstants.ATTACHMENT_FILES_PATH +
		 * ConfigProperty.getConfig(IConstants.reqAttachment));
		 */
		CostBookingRequisitionSummary costBookingRequisitionSummary = getDefaultObjectOfCostBooking();

		bpo.setCostBookingRequisitionSummary(costBookingRequisitionSummary);

		/*
		 * bpo.setItems(getItem(itemType)); if (bpo.getItems().getGuidedItems()
		 * != null) { List<GuidedItem> guidedItems =
		 * bpo.getItems().getGuidedItems(); List<GuidedItem> list = new
		 * ArrayList<GuidedItem>(); for (GuidedItem guidedItem : guidedItems) {
		 * guidedItem.setNextAction(IConstantsData.SAVE);
		 * guidedItem.setItemType(null); guidedItem.setSourcingStatus(null);
		 * guidedItem.setReceiveBy(null); guidedItems.add(guidedItem); } }
		 */

		// Change by Payal
		Item item = getItem(itemType);
		if (item.getGuidedItems() != null)
		{
			List<GuidedItem> guidedItems = item.getGuidedItems();
			List<GuidedItem> list = new ArrayList<GuidedItem>();
			for (GuidedItem guidedItem : guidedItems)
			{
				guidedItem.setNextAction(IConstantsData.SAVE);
				guidedItem.setItemType(null);
				guidedItem.setSourcingStatus(null);
				guidedItem.setReceiveBy(null);
				list.add(guidedItem);
			}
			item.setGuidedItems(list);
		}
		bpo.setItems(item);
		// AttachmentsAndCommentsItemSummary attachmentsAndCommentsItemSummary =
		// getDefaultObjectOfAttachmentAnCommentsItemSummary();

		// standardpo.setAttachmentsAndCommentsItemSummary(attachmentsAndCommentsItemSummary);
		CostBookingItemSummary costBookingItemSummary = getDefaultObjectOfCostBookingItemSummary();
		costBookingItemSummary.getAccountingItemSummary().setNextAction(IConstantsData.SAVE);
		bpo.setCostBookingItemSummary(costBookingItemSummary);

		// define buying scope
		BPOBuyingScope bpoBuyingScope = new BPOBuyingScope();
		bpoBuyingScope.setBusinessUnit(CommonServices.getTestData(IConstantsData.BUSINESS_UNIT_NAME));
		bpoBuyingScope.setLocation(CommonServices.getTestData(IConstantsData.LOCATION_NAME));
		bpoBuyingScope.setCostCenter(getCostCenterProjectAndBudget().get(IConstantsData.costCenter));
		bpo.setBpoBuyingScope(bpoBuyingScope);

		// from validity date
		CustomDate fromDate = CommonUtilities.getTodaysDate();
		bpo.setFromValidityDate(fromDate);

		// to validity date
		CustomDate toDate = CommonUtilities.getTodaysDate();
		toDate.setYear(toDate.getYear() + CommonUtilities.getNonZeroRandomNumbers(1));
		bpo.setToValidityDate(toDate);

		bpo.setNextAction(IConstantsData.SUBMIT_PO_FOR_PROCESSING);
		return bpo;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get default object of BPO release <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @return </b> <br>
	 * 
	 * @throws Exception
	 */
	public static BPO getDefaultObjectOfBOR() throws Exception
	{
		BPO bpo_release = new BPO();
		CostBookingRequisitionSummary costBookingRequisitionSummary = getDefaultObjectOfCostBooking();
		bpo_release.setCostBookingRequisitionSummary(costBookingRequisitionSummary);
		bpo_release.setRequiredByDate(CommonUtilities.getDayAfterTodaysDate());
		bpo_release.setNextAction(IConstantsData.SUBMIT_PO_FOR_PROCESSING);
		bpo_release.setDeliveryTerms(CommonServices.getTestData(IConstantsData.DELIVERY_TERMS));
		return bpo_release;
	}

	public static PCard getDefaultObjectOfPCard(String issuedToType) throws Exception
	{
		PCard pCard = new PCard();
		pCard.setpCardType(CommonServices.getTestData(IConstantsData.PCard_Type));

		String pCardNo = null;
		pCard.setIssuingBank(CommonServices.getTestData(IConstantsData.PCARD_ISSUING_BANK));

		CustomDate customDate = CommonUtilities.getDayAfterTodaysDate();
		customDate.setYear(customDate.getYear() + CommonUtilities.getNonZeroRandomNumbers(1));
		pCard.setExpiryDate(customDate);

		customDate = CommonUtilities.getTodaysDate();
		pCard.setLastBilledOnDate(customDate);
		pCard.setCreditDays(CommonUtilities.getNonZeroRandomNumbers(1));

		if (issuedToType.equalsIgnoreCase(IConstantsData.ISSUED_TO_USER))
		{
			pCardNo = CommonServices.getTestData(IConstantsData.PCard_No_For_Creating_User_Pcard).trim();

			pCardNo = pCardNo.substring(1, pCardNo.length() - 1);
			pCard.setpCardNo(pCardNo.trim());

			pCard.setIssuedToUser(true);
			pCard.setIssuedTo(CommonServices.getTestData(IConstantsData.DELIVERS_TO_OR_OWNER));

			pCard.setSpendPerTransaction(100);
			pCard.setSpendPerDay(1000);
			pCard.setSpendPerCycle(10000);
			pCard.setTransactionsPerDay(1000);
			pCard.setTransactionsPerCycle(1000);
		}
		else if (issuedToType.equalsIgnoreCase(IConstantsData.ISSUED_TO_SUPPLIER))
		{
			pCardNo = CommonServices.getTestData(IConstantsData.PCard_No_For_Creating_Supplier_Pcard).trim();

			pCardNo = pCardNo.substring(1, pCardNo.length() - 1);
			pCard.setpCardNo(pCardNo.trim());

			pCard.setIssuedToSupplier(true);
			pCard.setIssuedTo(CommonServices.getTestData(IConstantsData.SUPPLIER_NAME));
			// pCard.setAllowedOUs(CommonServices.getTestData(IConstantsData.ORGANIZATION_UNIT_OR_COMPANY_NAME));
			pCard.setAllowedOUs(IConstantsData.ALL);
		}
		else
		{
			logger.info("Invalid option");
		}

		pCardNo = RandomCreditCardNumberGenerator.generateCardNumbersByType(1, pCard.getpCardType())[0];
		pCard.setpCardNo(pCardNo);
		logger.info("Genrated pcard no: " + pCardNo);
		pCard.setNextAction(IConstantsData.ACTIVATE_PCARD);
		return pCard;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get Default guided item object for BPO
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	public static GuidedItem getDefaultGuidedItemObjectForBPO() throws Exception
	{
		float quantity = CommonUtilities.getNonZeroRandomNumbers(2);
		GuidedItem guidedItem = new GuidedItem();

		guidedItem.setItemName(CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING));
		guidedItem.setShortDescription(CommonUtilities.getShortDescriptionOfGuidedItem());
		guidedItem.setPartNumber("Item_Part_Id_" + CommonUtilities.getNonZeroRandomNumbers(2));
		guidedItem.setQuantity(quantity);
		guidedItem.setContractNoInSuppInfo(Integer.toString(CommonUtilities.getNonZeroRandomNumbers(2)));
		guidedItem.setLongDescription("Auto generated Long Description for Guided Item");
		guidedItem.setPrice((float) 596.13269);
		guidedItem.setUom("Each");
		guidedItem.setNextAction(IConstantsData.SAVE);
		return guidedItem;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get default object of report <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @return </b> <br>
	 */
	public static Report getDefaultObjectOfReport()
	{
		Report report = new Report();
		report.setReportName(CommonUtilities.getReportName());
		report.setFolderName(CommonUtilities.getFolderName());
		// report.setReportType(IConstantsData.SUMMARY_REPORT_TYPE);
		report.setShowAllGroups(true);
		report.setSelectReoprtColumns(true);
		report.setSummarizeReoprtBySum(true);
		report.setSummarizeReoprtByMaximumValue(true);
		report.setDurationFilterOn(IConstantsData.FILTER_ON_PO_DELIVERY_DATE);
		report.setDurationFilterPeriod(IConstantsData.FILTER_PERIOD_CUSTOM);
		report.setStartDate(CommonUtilities.getTodaysDate());
		CustomDate endDate = CommonUtilities.getDayAfterTodaysDate();
		endDate.setYear(endDate.getYear() + 1);
		report.setEndDate(endDate);
		report.setMatchAllConditions(true);
		report.setChartType(IConstantsData.CHART_TYPE_PIE_CHART_2D);
		report.setNextAction(IConstantsData.RUN_REPORT);
		return report;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get default object of punchout <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @return </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	public static PunchoutItem getDefaultObjectOfPunchoutItem() throws Exception
	{
		PunchoutItem punchoutItem = new PunchoutItem();
		punchoutItem.setPunchoutItemName(CommonServices.getTestData(IConstantsData.Punchout_Item_Name));
		punchoutItem.setQuantity(CommonUtilities.getNonZeroRandomNumbers(2));
		punchoutItem.setPunchoutItemCategory(CommonServices.getTestData(IConstantsData.ITEM_CATEGORY_FOR_SEARCHING));
		punchoutItem.setNextAction(IConstantsData.ADD_TO_CART_AND_CHECKOUT);
		return punchoutItem;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>to get default object of invite supplier
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @return </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	public static InviteSupplier getDefaultObjectOfInviteSupplier() throws Exception
	{
		InviteSupplier inviteSupplier = new InviteSupplier();
		inviteSupplier.setInviteSelectedSuppliers(true);
		inviteSupplier.setSupplierName(CommonServices.getTestData(IConstantsData.SUPPLIER_NAME));
		inviteSupplier.setNextAction(IConstantsData.SEND_INVITATION);
		return inviteSupplier;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get object of catelog item from
	 * property file <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param fileName
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws IOException
	 *         </b> <br>
	 */
	public static CatelogItem getCatalogItemFromPropertyFile(String fileName) throws IOException
	{
		CatelogItem catelogItem = new CatelogItem();

		Properties properties = PropertyReader.getProperties(fileName);
		catelogItem.setItemName(properties.getProperty(IConstantsData.Item_Name));
		catelogItem.setDescription(properties.getProperty(IConstantsData.Description));
		catelogItem.setManufacturerName(properties.getProperty(IConstantsData.Manufacturer));
		catelogItem.setCategory(properties.getProperty(IConstantsData.Category));
		catelogItem.setSupplier(properties.getProperty(IConstantsData.Supplier));
		catelogItem.setAvailability(properties.getProperty(IConstantsData.Delivery_Lead_Time));
		catelogItem.setSupplierPartID(properties.getProperty(IConstantsData.Supplier_Part_Id));
		catelogItem.setUnit_Price(properties.getProperty(IConstantsData.Item_Price));

		logger.info("=================================================");
		logger.info("Item Details from property file : ");
		logger.info("Item Name : " + catelogItem.getItemName());
		logger.info("Item Description : " + catelogItem.getDescription());
		logger.info("Manufacturer Name : " + catelogItem.getManufacturerName());
		logger.info("Product Category : " + catelogItem.getCategory());
		logger.info("Supplier Name : " + catelogItem.getSupplier());
		logger.info("Availability : " + catelogItem.getAvailability());
		logger.info("Supplier Part Id : " + catelogItem.getSupplierPartID());
		logger.info("Unit Price : " + catelogItem.getUnit_Price());
		logger.info("Specifications : ");

		Map<String, String> specKeyValue = new HashMap<String, String>();
		String log = "";
		if (properties.getProperty(IConstantsData.Spec_Key) != null)
		{
			if (properties.getProperty(IConstantsData.Spec_Value) != null)
			{
				String key = properties.getProperty(IConstantsData.Spec_Key);
				String value = properties.getProperty(IConstantsData.Spec_Value);
				if (key.contains(",") || value.contains(","))
				{
					String[] temp_key = StringUtils.split(key, ",");
					String[] temp_value = StringUtils.split(value, ",");
					for (int i = 0; i < temp_key.length; i++)
					{
						log += "\n" + temp_key[i] + " : " + temp_value[i];
						specKeyValue.put(temp_key[i], temp_value[i]);
					}
				}
				else
				{
					log += "\n" + key + " : " + value;
					specKeyValue.put(key, value);
				}
				logger.info(log);
			}
		}
		catelogItem.setSpeckey_valueMap(specKeyValue);

		List<String> attachments = new ArrayList<String>();
		if (properties.getProperty(IConstantsData.Attachment) != null)
		{
			String attachment = properties.getProperty(IConstantsData.Attachment).trim();
			if (attachment.contains(","))
			{
				String[] temp = StringUtils.split(attachment, ",");
				for (String str : temp)
				{
					attachments.add(str);
				}
			}
			else
			{
				attachments.add(attachment);
			}
			catelogItem.setAttachments(attachments);
		}

		logger.info("=================================================");

		return catelogItem;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get GL Map object created from data in
	 * testdata.xls <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param key
	 *        </font><b><br>
	 * @return </b> <br>
	 * 
	 * @throws Exception
	 */
	public static GLMap getGLMapObject(String key) throws Exception
	{
		GLMap glMap = new GLMap();
		String ct_pt_gl_map = CommonServices.getTestData(key);

		String[] temp = StringUtils.split(ct_pt_gl_map, ",");

		glMap.setCategory(temp[0].trim());
		glMap.setPurchaseType(temp[1].trim());
		glMap.setCostCenter(temp[2].trim());
		glMap.setAmount(Float.parseFloat(temp[3].trim()));
		glMap.setGlAccountType(temp[4].trim());
		glMap.setGlAccount(temp[5].trim());
		glMap.setCompany(temp[6].trim());
		return glMap;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get default object of cost booking of
	 * other company <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCase
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	public static CostBookingRequisitionSummary getDefaultObjectOfCostBookingOfOtherCompany() throws Exception
	{
		Map<String, String> costBookingMap = getCostCenterProjectAndBudgetOfOtherCompany();
		String costCenter, budget, project;
		costCenter = costBookingMap.get(IConstantsData.costCenter);
		project = costBookingMap.get(IConstantsData.project);
		budget = costBookingMap.get(IConstantsData.budget);
		CostBookingRequisitionSummary costBookingRequisitionSummary = new CostBookingRequisitionSummary();
		costBookingRequisitionSummary.setBookCostToSingleCostCenter(true);
		costBookingRequisitionSummary.setCostCenter(costCenter);
		costBookingRequisitionSummary.setProject(project);
		costBookingRequisitionSummary.setBudget(budget);
		costBookingRequisitionSummary.setGlAccount(CommonServices.getTestData(IConstantsData.GL_ACCOUNT));
		costBookingRequisitionSummary.setNextAction(IConstantsData.SAVE);

		return costBookingRequisitionSummary;

	}

	public static GLAccount getDefaultObjectsOfGLAccount() throws Exception
	{
		GLAccount glAccount = new GLAccount();
		glAccount.setGlAccountName(CommonServices.getTestData(IConstantsData.TEMP_GL_ACCOUNT));
		glAccount.setCompany(CommonServices.getTestData(IConstantsData.ORGANIZATION_UNIT_OR_COMPANY_NAME));
		glAccount.setGlAccountType(CommonServices.getTestData(IConstantsData.GL_ACCOUNT));
		glAccount.setGlAccountCode(CommonUtilities.getNonZeroRandomNumbers(2));
		return glAccount;
	}

	public static GLMap getDefaultObjectOfGLMap() throws Exception
	{
		GLMap glMap = new GLMap();
		glMap.setCategory(CommonServices.getTestData(IConstantsData.TEMP_GL_MAP_CATEGORY));
		glMap.setPurchaseType(CommonServices.getTestData(IConstantsData.PURCHASE_TYPE).trim());
		glMap.setCompany(CommonServices.getTestData(IConstantsData.ORGANIZATION_UNIT_OR_COMPANY_NAME));
		glMap.setGlAccountType(CommonServices.getTestData(IConstantsData.OTHER_GL_ACCOUNT_TYPE));
		glMap.setGlAccount(CommonServices.getTestData(IConstantsData.VALIDATION_MAP_CHECK_GL_ACCOUNT));
		return glMap;
	}

	public static Project getDefaultObjectsOfProject() throws Exception
	{
		Project project = new Project();
		project.setProjectNumber(CommonUtilities.getNonZeroRandomNumbers(2));
		project.setProjectName(CommonServices.getTestData(IConstantsData.TEMP_PROJECT) + "_" + System.currentTimeMillis());
		project.setCompany(CommonServices.getTestData(IConstantsData.ORGANIZATION_UNIT_OR_COMPANY_NAME));
		project.setBUName(CommonServices.getTestData(IConstantsData.BUSINESS_UNIT_NAME));
		return project;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> To get object of email details <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param userName
	 *        </font><b><br>
	 * @param password
	 *        </font><b><br>
	 * @param folderName
	 *        </font><b><br>
	 * @param eventType
	 *        </font><b><br>
	 * @param documentInformation
	 *        </font><b><br>
	 * @return </b> <br>
	 */
	public static EmailDetails getEmailDetailsObject(String userName, String password, String folderName, String eventType, DocumentInformation documentInformation)
	{
		String subject = null;
		EmailDetails emailDetails = new EmailDetails();
		emailDetails.setUsername(userName);
		emailDetails.setPassword(password);
		emailDetails.setFolderName(folderName);
		emailDetails.setEventType(eventType);

		// to set subject according to event type
		switch (eventType)
		{
			case IEmailTestingConstants.EventType_Document_Submitted:
				subject = IEmailTestingConstants.Subject_Document_Submitted;
				subject = subject.replace(IEmailTestingConstants.DOC_NO, documentInformation.getDocNo());
				break;
			case IEmailTestingConstants.EventType_Document_Approval_Pending:
				subject = IEmailTestingConstants.Subject_Document_Awaiting_Approval;
				subject = subject.replace(IEmailTestingConstants.DOC_NO, documentInformation.getDocNo());
				break;
			case IEmailTestingConstants.EventType_Document_Recalled:
				subject = IEmailTestingConstants.Subject_Document_Recalled;
				subject = subject.replace(IEmailTestingConstants.DOC_NO, documentInformation.getDocNo());
				break;
			case IEmailTestingConstants.EventType_Document_Approved:
				subject = IEmailTestingConstants.Subject_Document_Approved;
				subject = subject.replace(IEmailTestingConstants.DOC_NO, documentInformation.getDocNo());
				// subject = subject.replace(IEmailTestingConstants.ACTOR,
				// IConstantsData.Approval_Actor_Name);
				subject = subject.replace(IEmailTestingConstants.ACTOR, documentInformation.getUser().getDisplayName());
				break;
			case IEmailTestingConstants.EventType_Remind_Buyer:
				subject = IEmailTestingConstants.Subject_On_Buyer_Desk;
				subject = subject.replace(IEmailTestingConstants.DOC_NO, documentInformation.getDocNo());
				break;
			case IEmailTestingConstants.EventType_Assigned_Buyer_Changed:
				subject = IEmailTestingConstants.Subject_Assigned_Buyer_Changed;
				subject = subject.replace(IEmailTestingConstants.DOC_NO, documentInformation.getDocNo());
				break;
			case IEmailTestingConstants.EventType_Assigned_Buyer_Removed:
				subject = IEmailTestingConstants.Subject_Assigned_Buyer_Removed;
				subject = subject.replace(IEmailTestingConstants.DOC_NO, documentInformation.getDocNo());
				subject = subject.replace(IEmailTestingConstants.OLD_BUYER, documentInformation.getRequisition().getAssignedBuyer());
				break;
			case IEmailTestingConstants.EventType_Requisition_Modified_By_Buyer:
				subject = IEmailTestingConstants.Subject_Requisition_Modified_By_Buyer;
				subject = subject.replace(IEmailTestingConstants.DOC_NO, documentInformation.getDocNo());
				break;
			case IEmailTestingConstants.EventType_Released_PO:
				subject = IEmailTestingConstants.Subject_Released_PO;
				if (subject.contains(IEmailTestingConstants.DOC_NO))
				{
					subject = subject.replace(IEmailTestingConstants.DOC_NO, documentInformation.getDocNo());
				}
				else
				{
					subject = subject.replace(IEmailTestingConstants.PO_NO, documentInformation.getDocNo());
				}
				break;
			case IEmailTestingConstants.EventType_Released_Requisition:
				subject = IEmailTestingConstants.Subject_Released_Requisition;
				subject = subject.replace(IEmailTestingConstants.DOC_NO, documentInformation.getDocNo());
				break;
			case IEmailTestingConstants.EventType_Amended_Released_PO:
				subject = IEmailTestingConstants.Subject_Amended_Released_PO;
				if (subject.contains(IEmailTestingConstants.DOC_NO))
				{
					subject = subject.replace(IEmailTestingConstants.DOC_NO, documentInformation.getDocNo());
				}
				else
				{
					subject = subject.replace(IEmailTestingConstants.PO_NO, documentInformation.getDocNo());
				}
				break;
			case IEmailTestingConstants.EventType_Email_PO:
				subject = IEmailTestingConstants.Subject_Email_PO;
				subject = subject.replace(IEmailTestingConstants.DOC_NO, documentInformation.getDocNo());
				// subject = subject.replace("%PO_NO%",
				// documentInformation.getDocNo());
				break;
			case IEmailTestingConstants.EventType_Remind_Receipt:
				subject = IEmailTestingConstants.Subject_Remind_Receipt;
				if (subject.contains(IEmailTestingConstants.DOC_NO))
				{
					subject = subject.replace(IEmailTestingConstants.DOC_NO, documentInformation.getDocNo());
				}
				else
				{
					subject = subject.replace(IEmailTestingConstants.PO_NO, documentInformation.getDocNo());
				}
				break;
			case IEmailTestingConstants.EventType_Cancel_PO:
				subject = IEmailTestingConstants.Subject_Cancel_PO;
				subject = subject.replace(IEmailTestingConstants.DOC_NO, documentInformation.getDocNo());
				break;
			case IEmailTestingConstants.EventType_Sent_For_Quote:
				subject = IEmailTestingConstants.Subject_Sent_For_Quote;
				subject = subject.replace(IEmailTestingConstants.DOC_NO, documentInformation.getDocNo());
				break;
			case IEmailTestingConstants.EventType_Document_Rejected:
				subject = IEmailTestingConstants.Subject_Document_Rejected;
				subject = subject.replace(IEmailTestingConstants.DOC_NO, documentInformation.getDocNo());
				subject = subject.replace(IEmailTestingConstants.ACTOR, documentInformation.getUser().getDisplayName());
				break;
			case IEmailTestingConstants.EventType_Returned_Req_From_Buyers_Desk:
				subject = IEmailTestingConstants.Subject_Returned_Req_From_Buyers_Desk;
				subject = subject.replace(IEmailTestingConstants.DOC_NO, documentInformation.getDocNo());
				subject = subject.replace(IEmailTestingConstants.ACTOR_WHO_RETURNED, documentInformation.getRequester());
				break;
			case IEmailTestingConstants.EventType_Delegate_Assigned:
				subject = IEmailTestingConstants.Subject_Delegate_Assigned;
				subject = subject.replace(IEmailTestingConstants.DELEGATED_FROM, documentInformation.getRequester());
				subject = subject.replace(IEmailTestingConstants.TO_DATE, documentInformation.getMySettingsForApproval().getDelegateDateTo().getDate());
				break;
			case IEmailTestingConstants.EventType_Delegate_Revoked:
				subject = IEmailTestingConstants.Subject_Delegate_Revoked;
				subject = subject.replace(IEmailTestingConstants.DELEGATED_FROM, documentInformation.getRequester());
				break;
			case IEmailTestingConstants.EventType_Approval_Delegated:
				subject = IEmailTestingConstants.Subject_Approval_Delegated;
				// subject = subject.replace(IEmailTestingConstants.DOC_TYPE,
				// documentInformation.getDocType());
				subject = subject.replace(IEmailTestingConstants.DOC_NO, documentInformation.getDocNo());
				subject = subject.replace(IEmailTestingConstants.ACTOR, documentInformation.getUser().getDisplayName());
				break;
			case IEmailTestingConstants.EventType_Parked:
				subject = IEmailTestingConstants.Subject_Parked;
				subject = subject.replace(IEmailTestingConstants.DOC_NO, documentInformation.getDocNo());
				break;

			default:
				logger.info("Invalid event type");
				break;
		}

		// document type specific data in subject
		if (documentInformation.getRequisition() != null)
		{
			if (subject.contains(IEmailTestingConstants.NEW_BUYER))
			{
				subject = subject.replace(IEmailTestingConstants.NEW_BUYER, documentInformation.getRequisition().getAssignedBuyer());
			}
			if (subject.contains(IEmailTestingConstants.DOC_TYPE))
			{
				subject = subject.replace(IEmailTestingConstants.DOC_TYPE, documentInformation.getDocType());
			}

		}
		else if (documentInformation.getPurchaseOrder() != null)
		{
			if (subject.contains(IEmailTestingConstants.NEW_BUYER))
			{
				subject = subject.replace(IEmailTestingConstants.NEW_BUYER, documentInformation.getPurchaseOrder().getRequisition().getAssignedBuyer());
			}
			String companyName = "";
			if (documentInformation.getPurchaseOrder().getRequisition().getBillingRequisitionSummary().getCompany() != null)
			{
				companyName = documentInformation.getPurchaseOrder().getRequisition().getBillingRequisitionSummary().getCompany();
			}
			if (subject.contains(IEmailTestingConstants.COMPANY_NAME))
			{
				subject = subject.replace(IEmailTestingConstants.COMPANY_NAME, companyName);
			}
			if (subject.contains(IEmailTestingConstants.DOC_TYPE))
			{
				subject = subject.replace(IEmailTestingConstants.DOC_TYPE, documentInformation.getDocType());
			}

		}
		else if (documentInformation.getStandardPO() != null)
		{
			if (subject.contains(IEmailTestingConstants.NEW_BUYER))
			{
				subject = subject.replace(IEmailTestingConstants.NEW_BUYER, documentInformation.getStandardPO().getBuyer());
			}
			String companyName = "";
			if (documentInformation.getStandardPO().getBillingRequisitionSummary().getCompany() != null)
			{
				companyName = documentInformation.getStandardPO().getBillingRequisitionSummary().getCompany();
			}
			if (subject.contains(IEmailTestingConstants.COMPANY_NAME))
			{
				subject = subject.replace(IEmailTestingConstants.COMPANY_NAME, companyName);
			}
			if (subject.contains(IEmailTestingConstants.DOC_TYPE))
			{
				subject = subject.replace(IEmailTestingConstants.DOC_TYPE, DocumentInformation.docType_PO);
			}

		}
		else if (documentInformation.getInvoice() != null)
		{
			if (subject.contains(IEmailTestingConstants.NEW_BUYER))
			{
				subject = subject.replace(IEmailTestingConstants.NEW_BUYER, documentInformation.getInvoice().getBuyer());
			}
			if (subject.contains(IEmailTestingConstants.DOC_TYPE))
			{
				subject = subject.replace(IEmailTestingConstants.DOC_TYPE, documentInformation.getDocType());
			}

		}
		emailDetails.setSubject(subject.trim());

		/*
		 * if (documentInformation.getDocType() != null) { //to set the email
		 * body switch (documentInformation.getDocType()) { case
		 * DocumentInformation.docType_Requisition: switch
		 * (documentInformation.getDocStatus()) { case
		 * IConstantsData.WITH_BUYER_FILTER_LABEL: bodyTemplate =
		 * FlowEmailTesting.Email_Body_For_BuyersDesk; break; default:
		 * bodyTemplate = FlowEmailTesting.Email_Body_For_Requisition; break; }
		 * break; case DocumentInformation.docType_PO: switch
		 * (documentInformation.getDocStatus()) { case
		 * IConstantsData.COMPLETE_RELEASED_FILTER_LABEL: bodyTemplate =
		 * FlowEmailTesting.Email_Body_For_PO_Released; break; default:
		 * bodyTemplate = FlowEmailTesting.Email_Body_For_PO; break; } break;
		 * default: logger.info("Invalid document type"); break; }
		 * emailDetails.setEmailBody(FlowEmailTesting
		 * .getBodyOfEmailFromBodyTemplate(bodyTemplate, documentInformation));
		 * }
		 */
		return emailDetails;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Object of document information <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param docType
	 *        </font><b><br>
	 * @param requisition
	 *        </font><b><br>
	 * @param standardPO
	 *        </font><b><br>
	 * @param invoice
	 *        </font><b><br>
	 * @return </b> <br>
	 */
	public static DocumentInformation getObjectOfDocumentInformation(String docType, Requisition requisition, StandardPO standardPO, Invoice invoice, PurchaseOrder purchaseOrder)
	{
		DocumentInformation documentInformation = new DocumentInformation();

		documentInformation.setDocType(docType);
		if (requisition != null)
		{
			documentInformation.setDocNo(requisition.getReqNo());
			documentInformation.setDocName(requisition.getReqName());
			documentInformation.setRequester(requisition.getRequesterName());
			documentInformation.setCreatedOn(requisition.getCustomDate().getDate());
			documentInformation.setDocStatus(requisition.getStatus());
			documentInformation.setRequisition(requisition);
			documentInformation.setItem(requisition.getItems());
		}
		else if (standardPO != null)
		{
			documentInformation.setItem(standardPO.getItems());
			documentInformation.setDocNo(standardPO.getPoNumber());
			documentInformation.setDocName(standardPO.getOrderDescription());
			documentInformation.setStandardPO(standardPO);
			// documentInformation.setRequester(requisition.getRequesterName());
			documentInformation.setCreatedOn(standardPO.getCustomDate().getDate());
		}
		else if (invoice != null)
		{
			documentInformation.setItem(invoice.getStandardPO().getItems());
		}
		else if (purchaseOrder != null)
		{
			documentInformation.setDocNo(purchaseOrder.getPoNo());
			documentInformation.setDocName(purchaseOrder.getPoName());
			documentInformation.setRequester(purchaseOrder.getRequisition().getRequesterName());
			documentInformation.setDocStatus(purchaseOrder.getStatus());
			documentInformation.setItem(purchaseOrder.getRequisition().getItems());
			documentInformation.setPurchaseOrder(purchaseOrder);
			documentInformation.setCreatedOn(purchaseOrder.getCreatedOn().getDate());
		}

		return documentInformation;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get default object of My Settings <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param action
	 *        </font><b><br>
	 * @param delegateUserFrom
	 *        </font><b><br>
	 * @param delegateUserTo
	 *        </font><b><br>
	 * @param revokeUserFrom
	 *        </font><b><br>
	 * @return </b> <br>
	 */
	public static MySettings getDefaultObjectOfMySettings(String action, String delegateUserFrom, String delegateUserTo, String revokeUserFrom)
	{
		MySettings mySettings = new MySettings();

		mySettings.setAction(action);
		mySettings.setNextAction(action);
		if (delegateUserFrom != null)
		{
			mySettings.setDelegateUserFrom(delegateUserFrom);
		}
		if (delegateUserTo != null)
		{
			mySettings.setDelegateUserTo(delegateUserTo);
		}
		if (revokeUserFrom != null)
		{
			mySettings.setRevokeFrom(revokeUserFrom);
		}
		return mySettings;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param currentOwner
	 *        </font><b><br>
	 * @param newOwner
	 *        </font><b><br>
	 * @param searchEntityIn
	 *        </font><b><br>
	 * @param searchEntity
	 *        </font><b><br>
	 * @return </b> <br>
	 */
	public static EntityOwnership getDefaultObjectOfEnityOwnerShip(String currentOwner, String newOwner, String searchEntityIn, String searchEntity)
	{
		EntityOwnership entityOwnership = new EntityOwnership();
		entityOwnership.setCurrentOwner(currentOwner);
		entityOwnership.setNewOwner(newOwner);
		entityOwnership.setRequisitionEntity(true);
		entityOwnership.setSearchEntityIn(searchEntityIn);
		entityOwnership.setSearchEntity(searchEntity);
		entityOwnership.setSelectEntityNextAction(IConstantsData.SAVE);
		entityOwnership.setChangeOwnerNextAction(IConstantsData.SAVE);
		return entityOwnership;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get category manager map <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param key
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	public static CategoryManagerMap getObjectOfCategoryManagerMap(String key) throws Exception
	{
		CategoryManagerMap categoryManagerMap = new CategoryManagerMap();
		String value = CommonServices.getTestData(key);

		String[] temp = StringUtils.split(value, ",");

		categoryManagerMap.setCategory(temp[0].trim());
		categoryManagerMap.setBuyer(temp[1].trim());
		categoryManagerMap.setPurpose(temp[2].trim());
		categoryManagerMap.setChildCategory(temp[3].trim());

		return categoryManagerMap;
	}

	public static TMS_paymentTermsSettings getDefaultObjectOfPaymentTerms(String paymentTermSearch, String paymentTermName)
	{
		TMS_paymentTermsSettings tms_paymentTermsSettings = new TMS_paymentTermsSettings();
		tms_paymentTermsSettings.setPaymentTermOption(IConstantsData.PAYMENT_TERM_TMS);
		tms_paymentTermsSettings.setPaymentTermSearch(paymentTermSearch);
		tms_paymentTermsSettings.setPaymentTermName(paymentTermName);
		return tms_paymentTermsSettings;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get default object of Update All Lines
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @return </font><b><br>
	 * @throws NumberFormatException
	 *         </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	public static UpdateAllLinesApplyTax getDefaultObjetOfUpdateAllLines() throws NumberFormatException, Exception
	{
		UpdateAllLinesApplyTax updateAllLinesApplyTax = new UpdateAllLinesApplyTax();
		List<Tax> taxes = new ArrayList<>();
		Tax tax = new Tax();
		tax.setTaxType(CommonServices.getTestData(IConstantsData.TAX_TYPE));
		tax.setTaxName(CommonServices.getTestData(IConstantsData.TAX_NAME));
		tax.setTaxRate(Float.parseFloat(CommonServices.getTestData(IConstantsData.TAX_RATE)));

		taxes.add(tax);

		updateAllLinesApplyTax.setTaxes(taxes);
		updateAllLinesApplyTax.setNextAction(IConstantsData.applyTax_UpdateAllLines);
		return updateAllLinesApplyTax;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>to get default object of Add approver <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param approverName
	 *        </font><b><br>
	 * @param addApprovalAfter
	 *        </font><b><br>
	 * @return </b> <br>
	 */
	public static AddApprover getDefaultObjectOfAddApprover(String approverName, String addApprovalAfter)
	{
		AddApprover addApprover = new AddApprover();
		addApprover.setApproverName(approverName);
		addApprover.setAddApproverAfter(addApprovalAfter);
		addApprover.setNextAction(IConstantsData.SAVE);
		return addApprover;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get default object of contract details
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @return </b> <br>
	 * 
	 * @throws Exception
	 */
	/*public static ContractDetails getDefaultObjectOfContractDetails() throws Exception
	{
		ContractDetails contractDetails = new ContractDetails();
		contractDetails.setIsConfigDigitalDocument("No");
		contractDetails.setIsConfigContractTitle("Yes");
		contractDetails.setContractTitle("Auto_Contract_" + CommonUtilities.getNonZeroRandomNumbers(4));
		contractDetails.setIsConfigCurrency("Yes");
		contractDetails.setCurrency("USD");
		contractDetails.setIsEverGreen("No");
		contractDetails.setIsContractConfidential("No");
		contractDetails.setIsNaCheckBox("No");
		contractDetails.setContractStatus("Active");
		contractDetails.setHierarchyStatus("Master Agreement");
		contractDetails.setContactName("Auto_Contract_" + CommonUtilities.getNonZeroRandomNumbers(4));
		contractDetails.setSectionsId("TD001");
		List<Sections> sectionList = new ArrayList<>();
		Sections section = new Sections();
		section.setSectionName("Section_001");
		section.setClausesID("TD001");
		List<ClauseDetails> clauseDetailsList = new ArrayList<>();
		ClauseDetails clauseDetails = new ClauseDetails();
		clauseDetails.setClauseTitle("Clause_Template_1");
		clauseDetails.setClauseCategory("SERVICES DISASTER");
		clauseDetails.setClauseText("Clause text 1");
		clauseDetailsList.add(clauseDetails);
		section.setClauseDetailsList(clauseDetailsList);
		sectionList.add(section);
		contractDetails.setSectionList(sectionList);
		contractDetails.setContractingPartyID("TD001");
		List<ContractingParty> contractingPartyList = new ArrayList<>();
		ContractingParty contractingParty = new ContractingParty();
		contractingParty.setContractingPartyName(CommonServices.getTestData(IConstantsData.SUPPLIER_NAME));
		contractingPartyList.add(contractingParty);
		contractDetails.setContractingPartyList(contractingPartyList);
		contractDetails.setCategory(CommonServices.getTestData(IConstantsData.ITEM_CATEGORY_FOR_SEARCHING));
		contractDetails.setPaymentOption("Cheque");
		contractDetails.setContractType("Procurement");
		contractDetails.setContractSubType("Purchase Agreement");
		contractDetails.setIsConfigBuisnessUnit("No");
		contractDetails.setFolder("Default");
		contractDetails.setRepo(true);

		return contractDetails;
	}*/

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get Default requisition setting <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @return </b> <br>
	 */
	public static RequisitionSettings getDefaultRequisitionSettingsObject()
	{
		RequisitionSettings requisitionSettings = new RequisitionSettings();

		requisitionSettings.setItemQuantityThreshold(500);
		requisitionSettings.setAllowRequetserToOrderFreeTextItemsType(IPageRequisitionSettings.ALWAYS);
		requisitionSettings.setAllowFreeTextItemsRequestedWithoutSelectingCategoryOption(IConstants.YES);
		requisitionSettings.setAllowReqToBeSubmittedWithoutRequiredByDateOption(IConstants.YES);
		requisitionSettings.setDisplayAccountingInfoToRequesterOption(IConstants.YES);
		requisitionSettings.setRequesterIsRequiredToProvideAccountingInfoOption(IConstants.NO);
		requisitionSettings.setAllowRequesterToOverrideDefaultGLAccountOption(IConstants.YES);
		requisitionSettings.setRequesterRequiredToAssignBuyerOption(IConstantsData.OPTIONAL);
		// requisitionSettings.setApplyCategoryBasedWorkflowOption(IConstants.NO);
		// requisitionSettings.setEnableReqForking(false);
		requisitionSettings.setAddDisbursementAsSettlementViaOption(false);
		requisitionSettings.setQuotedBySupplier_SourcingStatus(true);
		requisitionSettings.setEstimatedPrice_SourcingStatus(true);
		requisitionSettings.setNeedAQuote_SourcingStatus(true);

		return requisitionSettings;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> To get default purchase order object <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @return </b> <br>
	 */
	public static PurchaseOrderSettings getDefaultPurchaseOrderSettingsObject()
	{
		PurchaseOrderSettings purchaseOrderSettings = new PurchaseOrderSettings();

		purchaseOrderSettings.setAutoGenerateLineItemNumbers(true);
		purchaseOrderSettings.setModifyItemClassificationCode(true);
		purchaseOrderSettings.setAllowManualOrdersReleasedWithoutDeliveryDate(true);
		purchaseOrderSettings.setReleaseOrdersImmediately(true);
		purchaseOrderSettings.setAllowEmailingPOToContactsOtherThanSuppliersContact(true);
		// purchaseOrderSettings.setAllowEmailingPOToUsersOutsideCompany(true);
		purchaseOrderSettings.setAllowUsersToChangeDefaultSupplierCurrency(true);
		purchaseOrderSettings.setAllowUsersToChangeDefaultSupplierPaymentTerms(true);
		purchaseOrderSettings.setAllowUsersToChangeDefaultSupplierDeliveryTerms(true);
		purchaseOrderSettings.setAllowEditingAutoGeneratedPONO(true);
		purchaseOrderSettings.setAllowBuyersToAddNewItemsToExistingPO(true);
		purchaseOrderSettings.setAutomaticallyGenerateOrders(false);
		purchaseOrderSettings.setBPOAuthorizationType(IConstantsData.BPO_AUTH_TYPE_RELEASE_ORDER);
		purchaseOrderSettings.setNextAction(IConstantsData.SAVE);

		return purchaseOrderSettings;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get default object of Item Master
	 * Catalog <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @return </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	public static ItemMasterCatalog getDefaultItemMasterCatalogObject(String itemMasterType) throws Exception
	{
		ItemMasterCatalog itemMasterCatalog = new ItemMasterCatalog();
		itemMasterCatalog.setFillItemMasterDetails(true);
		itemMasterCatalog.setItemMasterName(CommonUtilities.getCatalogName());
		ItemMasterItem itemMasterItem = getDefaultItemMasterItemObjectForItemMasterCreation();

		// String itemMasterType =
		// CommonServices.getTestData(IConstantsData.Item_Master_Type);
		if (itemMasterType.equalsIgnoreCase(IConstantsData.Inventory_Item_Master_Type))
		{
			itemMasterCatalog.setItemMasterType_inventory(true);
			itemMasterCatalog.setWarehouse(CommonServices.getTestData(IConstantsData.WAREHOUSE));
			// set this value at test case level according to requirement.
			// itemMasterItem.setSupplierRequired(false);
		}
		else
		{
			itemMasterCatalog.setItemMasterType_nonInventory(true);
			itemMasterItem.setSupplierRequired(true);
		}
		itemMasterCatalog.setNextActionItemMasterDetails(IConstantsData.NEXT);

		List<ItemMasterItem> listOfItemMasterItems = new ArrayList<ItemMasterItem>();
		itemMasterItem.setName(itemMasterItem.getName() + "_" + System.currentTimeMillis());
		itemMasterCatalog.setNextActionAddItem(IConstantsData.ADD_ITEM_TO_CATALOG);
		listOfItemMasterItems.add(itemMasterItem);
		itemMasterCatalog.setItemMasterItems(listOfItemMasterItems);

		itemMasterCatalog.setNextActionItemDetails(IConstantsData.NEXT);
		itemMasterCatalog.setOrganizationUnit(CommonServices.getTestData(IConstantsData.ORGANIZATION_UNIT_OR_COMPANY_NAME));
		// set this value at test case level for carlson tenant
		// itemMasterCatalog.setRegion(CommonServices.getTestData(IConstantsData.Region_Name));
		itemMasterCatalog.setCompany(IConstantsData.ALL);
		itemMasterCatalog.setBusinessUnit(IConstantsData.ALL);
		itemMasterCatalog.setLocation(IConstantsData.ALL);
		itemMasterCatalog.setNextActionScopeAndValidity(IConstantsData.SUBMIT_CATALOG);
		return itemMasterCatalog;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get Default object of item master item
	 * for item master creation <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	public static ItemMasterItem getDefaultItemMasterItemObjectForItemMasterCreation() throws Exception
	{
		ItemMasterItem itemMasterItem = new ItemMasterItem();

		itemMasterItem.setSupplierName(CommonServices.getTestData(IConstantsData.SUPPLIER_NAME));
		itemMasterItem.setSupplierPartId("Supplier_Part_Id_" + CommonUtilities.getNonZeroRandomNumbers(3));
		itemMasterItem.setName(CommonServices.getTestData(IConstantsData.ITEM_NAME_FOR_SEARCHING, 1));
		itemMasterItem.setDescription(CommonUtilities.getShortDescriptionOfGuidedItem());
		itemMasterItem.setCategoryName(CommonServices.getTestData(IConstantsData.ITEM_CATEGORY_FOR_SEARCHING));
		itemMasterItem.setUom("Each");
		itemMasterItem.setPrice(596.13269);
		itemMasterItem.setCurrency("USD");
		itemMasterItem.setSourceRefNo("ERP_Part_Id_" + CommonUtilities.getNonZeroRandomNumbers(2));
		itemMasterItem.setMarketPrice("650.23");
		// itemMasterItem.setSupplierRequired(true);
		return itemMasterItem;
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>To add item on Req page of Buyers Desk
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCase
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	public static BuyersDesk createItem() throws Exception
	{
		BuyersDesk buyersdesk = new BuyersDesk();
		buyersdesk.setItemNumber(CommonServices.getTestData(IConstantsData.Item_Number, 1) + Helper.getRandomString(5));
		buyersdesk.setItemShortDescription(CommonServices.getTestData(IConstantsData.Item_Short_Description, 1));
		buyersdesk.setItemLongDescription(CommonServices.getTestData(IConstantsData.Item_Long_Description, 1));
		buyersdesk.setProductCategory(CommonServices.getTestData(IConstantsData.Item_Product_Category, 1));
		buyersdesk.setQuantity(CommonServices.getTestData(IConstantsData.Item_Quantity, 2));
		buyersdesk.setPrice(CommonServices.getTestData(IConstantsData.Item_Price0, 1));
		buyersdesk.setItemCurrency(CommonServices.getTestData(IConstantsData.Item_Currency));
		buyersdesk.setUOM(CommonServices.getTestData(IConstantsData.Item_UOM, 1));
		buyersdesk.setItemSourcingStatus(CommonServices.getTestData(IConstantsData.Item_Sourcing_Status));
		buyersdesk.setSupplierName(CommonServices.getTestData(IConstantsData.Item_Supplier_Name));
		buyersdesk.setManufacturerName(CommonServices.getTestData(IConstantsData.Item_Manufacturer_Name, 1));
		buyersdesk.setManufacturerPartId(CommonServices.getTestData(IConstantsData.Item_Manufacturer_Part_Id, 1));
		buyersdesk.setSpecificationName(CommonServices.getTestData(IConstantsData.Item_Specification_Name, 1));
		buyersdesk.setSpecificationKey(CommonServices.getTestData(IConstantsData.Item_Specification_Key, 1));
		buyersdesk.setSpecificationValue(CommonServices.getTestData(IConstantsData.Item_Specification_Value, 1));
		buyersdesk.setSpecificationCount(CommonServices.getTestData(IConstantsData.Item_Specification_Count));
		buyersdesk.setImageUrl(CommonServices.getTestData(IConstantsData.Item_Image_URL0));
		buyersdesk.setProductUrl(CommonServices.getTestData(IConstantsData.Item_Product_URL));
		buyersdesk.setManufacturerUrl(CommonServices.getTestData(IConstantsData.Item_Manufacturer_URL));
		buyersdesk.setAddressInRequirementTab(CommonServices.getTestData(IConstantsData.Item_Address_Requirement_Tab));
		buyersdesk.setReqChangeComments(CommonServices.getTestData(IConstantsData.Item_Req_Change_Comments));
		buyersdesk.setGLAccount(CommonServices.getTestData(IConstantsData.Item_GL_Account));
		buyersdesk.setContractNumber(Helper.getRandomAlphaNumeric(6));
		return buyersdesk;
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>To change Cost Center/Project/Budget on
	 * Req page of Buyers Desk <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCase
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	public static BuyersDesk changeCostcenterProjectBudget() throws Exception
	{
		BuyersDesk buyersdesk = new BuyersDesk();
		buyersdesk.setCostCenter(CommonServices.getTestData(IConstantsData.Item_Cost_Center, 1));
		buyersdesk.setProject(CommonServices.getTestData(IConstantsData.Item_Project, 1));
		buyersdesk.setBudget(CommonServices.getTestData(IConstantsData.Item_Budget, 1));
		return buyersdesk;
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>To set values for Buyers Desk Setting page
	 * <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param driver
	 *        </font><b><br>
	 * @param testCase
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	public static BuyersDeskSetting enterAllowPrValues() throws Exception
	{
		BuyersDeskSetting buyersdesksetting = new BuyersDeskSetting();
		buyersdesksetting.setAllowPrPercentTotalAmount(CommonServices.getTestData(IConstantsData.Item_AllowPR_Percent_Total_Amount));
		buyersdesksetting.setAllowPrCurrenctUnits(CommonServices.getTestData(IConstantsData.Item_AllowPR_CurrencyUnits));
		return buyersdesksetting;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get Default object of item master item
	 * with asset tagging required <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param testCase
	 *        </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception
	 *         </b> <br>
	 */
	public static ItemMasterItem getDefaultItemMasterItemObject() throws Exception
	{
		ItemMasterItem itemMasterItem = new ItemMasterItem();

		itemMasterItem.setName(CommonServices.getTestData(IConstantsData.Non_Inventory_Item_With_Asset_Tagging));
		itemMasterItem.setQuantity(10);
		return itemMasterItem;
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b>To set values for admin monitoring
	 * activities <br>
	 */
	public static AdminMonitoring getDefaultAdminMonitoringActivities() throws Exception
	{
		AdminMonitoring adminMonitoring = new AdminMonitoring();
		adminMonitoring.setAdminUrl(PropertyReader.monitoringProperty.getProperty("admin_Page_URL"));
		adminMonitoring.setUsername(PropertyReader.monitoringProperty.getProperty("Username"));
		adminMonitoring.setPassword(PropertyReader.monitoringProperty.getProperty("Password"));
		adminMonitoring.setUserAccount(PropertyReader.monitoringProperty.getProperty("UserAccount"));
		adminMonitoring.setActivity(PropertyReader.monitoringProperty.getProperty("Monitoring_Activity"));
		adminMonitoring.setTenant(PropertyReader.monitoringProperty.getProperty("Tenant"));
		adminMonitoring.setEntityType(PropertyReader.monitoringProperty.getProperty("Entity_Type"));
		adminMonitoring.setDestinationSystem(PropertyReader.monitoringProperty.getProperty("Destination_System"));
		adminMonitoring.setStatus(PropertyReader.monitoringProperty.getProperty("Status"));
		adminMonitoring.setNextAction(IConstantsData.SEARCH_EVENT);
		return adminMonitoring;
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b> api automation from iConsole
	 */
	public static ApiConsole getDefaultApiData() throws Exception
	{
		ApiConsole apiConsole = new ApiConsole();
		apiConsole.setUserAuthenticationRequired(true);
		apiConsole.setAuthenticationMpin(ConfigProperty.getConfig("iConsole_Authentication_mPin"));
		apiConsole.setProductName(IConstants.eProc);
		apiConsole.setApiAction(IConstantsData.API_ACTION_UPDATE);
		apiConsole.setApiName(IConstantsData.API_REQUISITION_APPROVAL);
		apiConsole.setRequisitionAction(IConstantsData.APPROVE);
		return apiConsole;
	}

	public static ApiConsole getDefaultApiDataForPO() throws Exception
	{
		ApiConsole apiConsole = new ApiConsole();
		apiConsole.setUserAuthenticationRequired(true);
		apiConsole.setAuthenticationMpin(ConfigProperty.getConfig("iConsole_Authentication_mPin"));
		apiConsole.setProductName(IConstants.eProc);
		apiConsole.setApiAction(IConstantsData.API_ACTION_UPDATE);
		apiConsole.setApiName(IConstantsData.API_PURCHASE_ORDER_APPROVAL);

		apiConsole.setPurchaseOrderAction(IConstantsData.APPROVE);

		return apiConsole;
	}

	// Client Specific: SAWater

	/**
	 * <b>Author: akashdeep.singh || swet.shah</b> <b><br>
	 * <font color="blue">Method :</b> Setting the eForm values for Requisition.
	 * 
	 * @throws Exception
	 */
	public static Requisition getEFormDataForRequisition(Requisition requisition) throws Exception
	{
		requisition.setSharePointURL_eForm(CommonServices.getTestData(IConstantsData.SHARE_POINT_URL_EFORM));
		requisition.setInternalDeliveryLocation_eForm(CommonServices.getTestData(IConstantsData.INTERNAL_DELIVERY_LOCATION_EFORM));
		requisition.setDeliveryInstruction_eForm(CommonServices.getTestData(IConstantsData.DELIVERY_INSTRUCTION_EFORM));
		requisition.setEstimatedFreight_eForm(CommonServices.getTestData(IConstantsData.ESTIMATED_FREIGHT_EFORM));
		requisition.setPurchasingInstructions_eForm(CommonServices.getTestData(IConstantsData.PURCHASING_INSTRUCTIONS_EFORM));
		return requisition;
	}

	// Client Specific: QTS
	/**
	 * @author bhakti sawant for setting QTS specific fields on Requisition Form
	 * @throws Exception
	 */
	public static Requisition setQTSRequisitionSpecificDetails(Requisition requisition) throws Exception
	{
		requisition.setIsThePurchaseBudgeted(CommonServices.getTestData(IConstantsData.IS_PURCHASE_BUDGETED));
		requisition.setWhatIsPurchasedandWHY(CommonServices.getTestData(IConstantsData.WHAT_IS_PURCHASED_AND_WHY));
		requisition.setIsPurchasedBefore(CommonServices.getTestData(IConstantsData.IS_PURCHASED_BEFORE));
		requisition.setIsPriceIncrease(CommonServices.getTestData(IConstantsData.IS_PRICE_INCREASE));
		requisition.setIsAdditionalSavings(CommonServices.getTestData(IConstantsData.IS_ADDITIONAL_SAVINGS));
		requisition.setSavingsAchieved(CommonServices.getTestData(IConstantsData.SAVINGS_ACHIEVED));
		return requisition;
	}

	/**
	 * <b>Author: priyanka.jadhav</b> <b><br>
	 * <font color="blue">Method :</b> Creating purchase order with Further
	 * Details.
	 * 
	 * @throws Exception
	 */
	public static PurchaseOrder getDefaultPurchaseOrderOfFurtherDetails() throws Exception
	{
		PurchaseOrder purchaseOrder = new PurchaseOrder();

		purchaseOrder.setCmsRegistered(IConstants.NO);
		purchaseOrder.setRecommendationMemoProvided(IConstants.NO);
		purchaseOrder.setQuote(IConstantsData.NA_QUOTE_FURTHER_DETAILS);
		purchaseOrder.setProccurementInvolvement(IConstants.NO);
		purchaseOrder.setPoMedium(IConstantsData.EMAIL_PO_MEDIUM_FURTHER_DETAILS);
		purchaseOrder.setPanelApply(IConstants.NO);
		purchaseOrder.setIsPOValue(IConstants.NO);

		return purchaseOrder;
	}

	/**
	 * @author t.amarnath
	 * @return
	 * @throws Exception
	 */
	public static Warehouse getDefaultWarehouseObject() throws Exception
	{
		Warehouse warehouse = new Warehouse();
		warehouse.setWarehouseName(CommonServices.getTestData(IConstantsData.Warehouse_Name) + System.currentTimeMillis());
		warehouse.setWarehouseStatus(CommonServices.getTestData(IConstantsData.ACTIVE));
		warehouse.setWarehouseAddress(CommonServices.getTestData(IConstantsData.Warehouse_Address));
		warehouse.setWarehouseLocation(CommonServices.getTestData(IConstantsData.Warehouse_Location));
		warehouse.setIsfillWarehouseScope(true);
		warehouse.setNextActionFillWarehouseDetails(IConstantsData.Add_Warehouse);
		return warehouse;
	}

}
