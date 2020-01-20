package implementation;

import BO.CatalogItemBO;
import BO.RequisitionBO;
import Pages.ExcelReader;
import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.Table;
import com.thoughtworks.gauge.TableRow;
import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class StepImplementation
{

	@Step("Create Requisition Default Object")
	public void getDefaultObjectOfReqBo(int noOfItem,String itemType) throws Exception
	{
		Map<String, String> map = ExcelReader.getDefaultObjectOfReq();

		RequisitionBO requisitionBO = new RequisitionBO();

		RequisitionBO req=new RequisitionBO();

		//List<GuidedItemBO> guidedItemList=new ArrayList<GuidedItemBO>();
		List<CatalogItemBO> catalogItemlist=new ArrayList<CatalogItemBO>();

		//For catalog Item Name;
		if (itemType.equalsIgnoreCase("CatalogItem"))
		{
			for (int i = 0; i < noOfItem; i++)
			{
				CatalogItemBO catalogItem = new CatalogItemBO();
				catalogItem.setItemName(map.get("ITEM_NAME_FOR_SEARCHING"));
				System.out.println(catalogItem.getItemName());
				catalogItem.setSupplierName(map.get("SUPPLIER_NAME"));
				catalogItem.setQuantity(Integer.parseInt(map.get("quantity")));

				catalogItemlist.add(catalogItem);
			}
			req.setCatalogItemList(catalogItemlist);
		}
		//For guided item;
		List<String> guidedItemNamelist = new ArrayList<String>();
		if (itemType.equalsIgnoreCase("GuidedItem"))
		{
			for (int i = 0; i < noOfItem; i++)
			{
				GuidedItemBO guidedItem = new GuidedItemBO();

				guidedItem.setGuidedItemItemName(commonUtilities.uniqueGuidedItemName());

				guidedItem.setGuidedItemShortDescription(map.get("SHORT_DESC_FOR_FREE_TEXT_ITEM", i));
				guidedItem.setProductCategory(map.get("ITEM_CATEGORY_FOR_SEARCHING", i));
				guidedItem.setGuidedItemPartNumber(commonUtilities.randomNumberBetweenRange(1, 999));
				guidedItem.setGuidedItemQuantity(commonUtilities.getNonZeroRandomNumbers(1));
				//guidedItem.setGuidedItemQuantity(5f);
				guidedItem.setGuidedItemLongDescription(map.get("GUIDED_ITEM_DESCRIPTION", i));

				guidedItem.setGuidedItemUom(map.get("ITEM_UOM",  i));

				guidedItem.setGuidedItemItemType(map.get("ITEM_TYPE", i));
				guidedItem.setGuidedItemSourcingStatus(map.get("SOURCING_STATUS_OPTION",  i));
				guidedItem.setGuidedItemReceiveBy(map.get("RECEIVE_BY_OPTION", i));
				guidedItem.setGuidedItemCurrency(map.get("ITEM_CURRENCY", i));
				guidedItem.setGuidedItemSupplierNameInSuppInfo(map.get("SUPPLIER_NAME", i));
				guidedItem.setGuidedItemSupplierAddress(map.get("OTHER_DELIVERY_ADD",i));
				guidedItem.setGuidedItemPrice(commonUtilities.getNonZeroRandomNumbers(1));
				guidedItem.setGuidedItemSupplierContact(map.get("SUPPLIER_CONTACT_NAME",i));
				guidedItem.setGuidedItemSupplierEmailid(map.get("SUPPLIER_EMAIL", i));
				guidedItem.setGuidedItemSupplierPhone(map.get("NEW_SUPPLIER_PHONE_NO", i));
				guidedItem.setGuidedItemContractOrderNumber(map.get("CONTRACT_NO", i));
				guidedItem.setGuidedItemSupplierOtherDetails(map.get("OTHER_DELIVERY_ADD",i));
				guidedItem.setBuyerPreviewRequired(true);
				guidedItem.setGuidedItemNextAction(iConstants.ADD_TO_CART);
				guidedItem.setGuidedItemDetailsModalNextAction(iConstants.GUIDED_ITEM_DETAILS_MODAL_DONE);
				guidedItemList.add(guidedItem);
			}
			req.setGuidedItemList(guidedItemList);
		}

		//For Checkout Form;
		String reqName= commonUtilities.uniqueRequisitionName();

		req.setReqName(reqName);
		req.setBuyingUnit(true);
		req.setUrgentRequirement(true);

		req.setReasonForOrdering(map.get("REASON_FOR_ORDERING"));
		req.setCommentForSupplier(map.get("COMMENTS_FOR_SUPPLIERS"));

		//req.setOnBehalfOf(map.get("onBehalfOFWithRightUser",0));
		req.setPurchaseType(map.get("PURCHASE_TYPE"));
		req.setAssignedBuyer(map.get("BUYER_NAME"));

		req.setSelectViaInvoice(true);
		//req.setPcard(map.get("PURCHASE_TYPE",0));
		req.setRetrospectivePurchase(false);

		//filling requisition summary;
		req.setReqCurrency(map.get("CURRENCY_TYPE"));
		req.setReqCompany(map.get("ORGANIZATION_UNIT/COMPANY_NAME"));
		req.setReqbBusinessUnit(map.get("BUSINESS_UNIT_NAME"));
		req.setReqLocation(map.get("LOCATION_NAME"));
		req.setReqDeliverTo(map.get("DELIVERES_TO/OWNER"));
		//req.setRequiredBy(map.get("purchaseType",1));

		req.setReqSelectDeliveryAddress(map.get("OTHER_DELIVERY_ADD"));
		req.setReqDeliveryAddress(map.get("OTHER_DELIVERY_ADD"));


		req.setReqSelectDeliveryAddress(map.get("OTHER_DELIVERY_ADD"));
		req.setReqDeliveryAddress(map.get("OTHER_DELIVERY_ADD"));
		req.setReqDefaultAddressOption(true);
		req.setReqOtherAddressesOption(false);


		req.setReqBillToAddressCode(map.get("BILL_TO_ADDRESS_CODE"));
		req.setReqDeliveryAddressCode(map.get("SHIP_TO_ADDRESS_CODE"));

		//Update all lines;
		req.setReqGlAccount(map.get("GL_ACCOUNT"));
		req.setBudgetUtilization(false);
		req.setReqBookCostToSingleCostCenter(true);
		req.setReqSplitCostToMultipleCostCenter(false);
		req.setReqSplitCostAtLineItemLevel(false);

		req.setCostCenter(map.get("COST_CENTER"));
		req.setProject(map.get("PROJECT"));
		req.setBudget(map.get("BUDGET"));
		//req.setReqAssignedCost(iConstants.NO);
		//req.setAllowBudget(iConstants.NO);

		//filligng item level details;
		req.setCostBookingItemGlAccount(map.get("PURCHASE_TYPE"));

		//coa form details;
		String[] coaDataType = new String[0];
		coaDataType[0] = map.get("COA_DATA_TYPE");
		req.setCoaDataType(coaDataType);
		req.setNoOfCoaSplit(Integer.parseInt(map.get("NO_OF_COA_SPLIT")));
		req.setSplitBy(map.get("SPLIT_BY"));

		req.setReqNextAction(iConstants.SUBMIT);
		req.setPoNextAction(iConstants.SUBMIT_PO_FOR_PROCESSING);

		//Object creation for virtual item;
		List<VirtualItemBO> virtualItemList = new ArrayList<VirtualItemBO>();
		if(itemtype.equalsIgnoreCase(iConstants.VIRTUAL_ITEM))
		{
			for(int i = 0; i < noOfItem; i++)
			{
				VirtualItemBO virtualItemBO = ObjectCreation.getDefaultObjectOfVirtualItem();
				virtualItemList.add(virtualItemBO);
			}
			req.setVirtualItemList(virtualItemList);
		}

		//Object creation for non stock item without supplier;
		List<AddNonStockItem> nonStockItemList = new ArrayList<AddNonStockItem>();
		if(itemtype.equalsIgnoreCase(iConstants.NON_STOCK_ITEM))
		{
			for(int i = 0; i < noOfItem; i++)
			{
				AddNonStockItem addNonStockItem = ObjectCreation.getObjectOfAddNonStockItem();
				nonStockItemList.add(addNonStockItem);
			}
			req.setNonStockItemList(nonStockItemList);
		}


		//Object Creation for Stock Item;
		List<StockItemBO> stockItemList = new ArrayList<StockItemBO>();
		if(itemtype.equalsIgnoreCase(iConstants.ITEM_TYPE_STOCK))
		{
			for(int i=0; i<noOfItem; i++)
			{
				StockItemBO addStockItemBo = ObjectCreation.getDefaultObjectOfStockItemBO();
				stockItemList.add(addStockItemBo);

			}
			req.setStockItemList(stockItemList);

			req.setCommentForSupplier(null);

			req.setSelectViaInvoice(false);

			req.setSelectViaDisburesement(false);

			req.setSelectViaUserPCard(false);

			req.setRetrospectivePurchase(false);

			req.setSelectPurchaseOrder(null);

			req.setAssignedBuyer(null);

			req.setStockItemList(stockItemList);
		}

		return req;


		DataStore suiteStore = DataStoreFactory.getSuiteDataStore();
		suiteStore.put("requisitionBO", requisitionBO);
	}

	@Step("Modify Deafult Requisition Object <table>")
	public void modifyReqDefaultObject(Table table) throws NoSuchFieldException, IllegalAccessException
	{
		RequisitionBO reqBo = new RequisitionBO();
		for (TableRow row : table.getTableRows())
		{
			String fieldKey = row.getCell("Field");
			String value = row.getCell("Value");
			Field field = reqBo.getClass().getDeclaredField(fieldKey);
			field.setAccessible(true);
			field.set(reqBo, value);
		}
	}
}
