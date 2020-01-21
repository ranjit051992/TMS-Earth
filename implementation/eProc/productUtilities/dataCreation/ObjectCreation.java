package eProc.productUtilities.dataCreation;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.DataStore;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import eProc.bo.CatalogItemBO;
import eProc.bo.RequisitionBO;
import eProc.productUtilities.CommonUtilities;
import eProc.productUtilities.constants.Constants;
import framework.utilities.GetData;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class ObjectCreation
{
    public static Logger logger = Logger.getLogger(ObjectCreation.class);

    @Step("Get Default of Requisition with noOfItem <noOfItem> and itemType <itemtype>")
    public static RequisitionBO getDefaultObjectOfRequsition(int noOfItem, String itemtype) throws Exception
    {
        RequisitionBO requisitionBO=new RequisitionBO();
        List<CatalogItemBO> catalogItemlist=new ArrayList<CatalogItemBO>();

        //For catalog Item Name;
        if (itemtype.equalsIgnoreCase(Constants.CatalogItem))
        {
            for (int i = 0; i < noOfItem; i++)
            {
                CatalogItemBO catalogItem = new CatalogItemBO();
                catalogItem.setItemName(GetData.getValueFromSpecificIndex("ITEM_NAME_FOR_SEARCHING", i));
                logger.info(catalogItem.getItemName());
                catalogItem.setSupplierName(GetData.getValueFromSpecificIndex("SUPPLIER_NAME", 0));
                catalogItem.setQuantity(CommonUtilities.randomNumberBetweenRange(1, 9));

                catalogItemlist.add(catalogItem);
            }
            requisitionBO.setCatalogItemList(catalogItemlist);

        }

        //Checkout Form data
        String reqName= CommonUtilities.uniqueRequisitionName();

        requisitionBO.setReqName(reqName);
        requisitionBO.setBuyingUnit(true);
        requisitionBO.setUrgentRequirement(true);

        //requisitionBO.setReasonForOrdering(GetData.getValueFromSpecificIndex("REASON_FOR_ORDERING", 0));
        //requisitionBO.setCommentForSupplier(GetData.getValueFromSpecificIndex("COMMENTS_FOR_SUPPLIERS", 0));

        //requisitionBO.setOnBehalfOf(GetData.getValueFromSpecificIndex("onBehalfOFWithRightUser",0));
        requisitionBO.setPurchaseType(GetData.getValueFromSpecificIndex("PURCHASE_TYPE",0));
        requisitionBO.setAssignedBuyer(GetData.getValueFromSpecificIndex("BUYER_NAME", 0));

        requisitionBO.setSelectViaInvoice(true);
        //requisitionBO.setPcard(GetData.getValueFromSpecificIndex("PURCHASE_TYPE",0));
        requisitionBO.setRetrospectivePurchase(false);

        //filling requisition summary;
        requisitionBO.setReqCurrency(GetData.getValueFromSpecificIndex("CURRENCY_TYPE",0));
        requisitionBO.setReqCompany(GetData.getValueFromSpecificIndex("ORGANIZATION_UNIT/COMPANY_NAME",0));
        requisitionBO.setReqbBusinessUnit(GetData.getValueFromSpecificIndex("BUSINESS_UNIT_NAME",0));
        requisitionBO.setReqLocation(GetData.getValueFromSpecificIndex("LOCATION_NAME",0));
        requisitionBO.setReqDeliverTo(GetData.getValueFromSpecificIndex("DELIVERES_TO/OWNER",0));
        //requisitionBO.setRequiredBy(GetData.getValueFromSpecificIndex("purchaseType",1));

        requisitionBO.setReqSelectDeliveryAddress(GetData.getValueFromSpecificIndex("OTHER_DELIVERY_ADD",0));
        requisitionBO.setReqDeliveryAddress(GetData.getValueFromSpecificIndex("OTHER_DELIVERY_ADD",0));


        requisitionBO.setReqSelectDeliveryAddress(GetData.getValueFromSpecificIndex("OTHER_DELIVERY_ADD",0));
        requisitionBO.setReqDeliveryAddress(GetData.getValueFromSpecificIndex("OTHER_DELIVERY_ADD",0));
        requisitionBO.setReqDefaultAddressOption(true);
        requisitionBO.setReqOtherAddressesOption(false);


        requisitionBO.setReqBillToAddressCode(GetData.getValueFromSpecificIndex("BILL_TO_ADDRESS_CODE",0));
        requisitionBO.setReqDeliveryAddressCode(GetData.getValueFromSpecificIndex("SHIP_TO_ADDRESS_CODE",0));

        //Update all lines;
        requisitionBO.setReqGlAccount(GetData.getValueFromSpecificIndex("GL_ACCOUNT",0));
        requisitionBO.setBudgetUtilization(false);
        requisitionBO.setReqBookCostToSingleCostCenter(true);
        requisitionBO.setReqSplitCostToMultipleCostCenter(false);
        requisitionBO.setReqSplitCostAtLineItemLevel(false);

        requisitionBO.setCostCenter(GetData.getValueFromSpecificIndex("COST_CENTER", 0));
        requisitionBO.setProject(GetData.getValueFromSpecificIndex("PROJECT", 0));
        requisitionBO.setBudget(GetData.getValueFromSpecificIndex("BUDGET", 0));
        //requisitionBO.setrequisitionBOAssignedCost(iConstants.NO);
        //requisitionBO.setAllowBudget(iConstants.NO);

        //filligng item level details;
        requisitionBO.setCostBookingItemGlAccount(GetData.getValueFromSpecificIndex("PURCHASE_TYPE",0));

        //coa form details;
        String[] coaDataType = new String[1];
        coaDataType[0] = GetData.getValueFromSpecificIndex("COA_DATA_TYPE",0);
        requisitionBO.setCoaDataType(coaDataType);
        requisitionBO.setNoOfCoaSplit(Integer.parseInt(GetData.getValueFromSpecificIndex("NO_OF_COA_SPLIT", 0)));
        requisitionBO.setSplitBy(GetData.getValueFromSpecificIndex("SPLIT_BY", 0));

        requisitionBO.setReqNextAction(Constants.SUBMIT);
        requisitionBO.setPoNextAction(Constants.SUBMIT_PO_FOR_PROCESSING);

        DataStore store = DataStoreFactory.getScenarioDataStore();
        store.put("RequisitionBO", requisitionBO);
        return requisitionBO;
    }
}
