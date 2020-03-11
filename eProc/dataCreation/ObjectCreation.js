const { I } = inject();
const faker = require("faker");
const spoBO = require("../dataCreation/bo/Spo");
const catalogItem = require("../dataCreation/bo/CatalogItem")
const requisition = require("../dataCreation/bo/Requisition");
const logger = require("../../Framework/FrameworkUtilities/Logger/logger");
const commonUtilities = require("../../Framework/FrameworkUtilities/CommonUtilities");
const prop = global.confi_prop;
const lmtVar = require("../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const guidedItemBo = require("../dataCreation/bo/GuidedItem")
const stockItemBo = require("../dataCreation/bo/StockItem")


class ObjectCreation
{
    async getObjectOfStandardPO(noOfItems,itemType)
    {
        let spo = new spoBO();
        spo.setPoNumber(`Automation_Spo_${new Date().getTime()}`);
        spo.setPoDescription(`Automation_Description_${new Date().getTime()}`);
        spo.setPurchaseType(I.getData("PURCHASE_TYPE"));
        spo.setCompany(I.getData("ORGANIZATION_UNIT/COMPANY_NAME"));
        spo.setBusinessUnit(I.getData("BUSINESS_UNIT_NAME"));
        spo.setLocation(I.getData("LOCATION_NAME"));
        spo.setSupplierName(I.getData("SUPPLIER_NAME"));
        spo.setSupplierAddress(I.getData("SUPPLIER_ADDRESS"));
        spo.setPaymentTerm(I.getData("PAYMENT_TERMS"));
        spo.setDeliveryTerm(I.getData("DELIVERY_TERMS"));
        spo.setCurrency(I.getData("CURRENCY_TYPE"));
        spo.setBuyer(I.getData("BUYER_NAME"));
        // spo.setDeliverTo(I.getData("DELIVERES_TO/OWNER"));
        spo.setDeliverTo(global.users.get("USERNAME"));
        spo.setNewApprover(I.getData("NEW_APPROVER"));
        spo.setBookCostAtLineItemLevel("No");
        spo.setBookCostToSingleMultipleCC("Yes");
        spo.setAssignCostProject("No");
        spo.items = await this.getArrayOfItems(noOfItems,itemType);
        spo.setGlAccount(I.getData("GL_ACCOUNT"));
        spo.setCostCenter(I.getData("COST_CENTER"));
        spo.setTermsAndConditions("This is an auto generated term and condition");
        spo.setNotes("This is an auto generated note");
        spo.setReceiptRuleAtHeaderLevel(true);
        spo.setReceiptCreationDefault(true);
        spo.setTaxInclusive(true);
        spo.setFillCbl(false);
        spo.setFillShippingDetails(false);
        spo.setFillControlSettings(false);
        spo.setFillAdditionalDetails(false);
        return spo;
    }

    async getArrayOfItems(noOfItems,itemType)
    {
        let items = new Array();
        
        if(itemType==="ITEM_NAME_FOR_SEARCHING")
        {
            for(let i =0;i<noOfItems;i++)
            {
                let catalog = await this.getObjectOfCatalogItem(i);
                items[i] = catalog;
            }
        }
        if(itemType==="SEARCH_ITEM_STOCK")
        {
            for(let i =0;i<noOfItems;i++)
            {
                let stock = await this.getObjectOfStockItem(i);
                items[i] = stock;
            }
        }
        if(itemType==="SEARCH_GUIDED_ITEM")
        {
            for(let i =0;i<noOfItems;i++)
            {
                let guided = await this.getObjectOfGuidedItem(i);
                items[i] = guided;
            }
        }
        
        if(itemType === "SEARCH_GUIDED_ITEM")
        {
            for(let i=0; i<noOfItems; i++)
            {
                let guided = await this.getObjectOfGuidedItem(i);
                items[i] = guided;
            }
        }
        
        return items;
    }

    async getObjectOfCatalogItem(itemIndex)
    {
        let catalog = new catalogItem()
        catalog.setItemName(await commonUtilities.splitData(1,"ITEM_NAME_FOR_SEARCHING"));
        catalog.quantity = faker.random.number(20);
        return catalog;
    }

    async getObjectOfRequisition(noOfItems,itemType)
     {
        requisition.reqName = "Automation_Req"+faker.random.number(200000);
        requisition.noOfItems = noOfItems;
        requisition.onBehalfOf = I.getData("ON_BEHALF_OF_WITH_RIGHT_USER");
        //requisition.onBehalfOf = (global.users.get("USERNAME"));
        requisition.company = I.getData("ORGANIZATION_UNIT/COMPANY_NAME");
        requisition.businessUnit = I.getData("BUSINESS_UNIT_NAME");
        requisition.location = I.getData("LOCATION_NAME");
       // requisition.urgentRequirement = I.getData("No");
        requisition.reasonForOrdering = I.getData("REASON_FOR_ORDERING");
        requisition.commentsForSupplier = I.getData("COMMENTS_FOR_SUPPLIERS");
        requisition.purchaseType = I.getData("PURCHASE_TYPE");
        requisition.attachmentPath = "";
        requisition.settlementVia = "Invoice";
        requisition.retrospectivePurchase = "No";
        requisition.shipToDefaultAddress = "Yes";
        requisition.shipToAnotherAddress = "No";
        requisition.deliverTo = I.getData("DELIVERES_TO/OWNER");
       // requisition.deliverTo = (global.users.get("USERNAME"));
        //requisition.requiredBy = faker.date.
        requisition.assignCostProject = "No";
        requisition.bookCostToSingleMultipleCC= "Yes";
        requisition.bookCostAtLineLevel = "No";
        requisition.costCenter = I.getData("COST_CENTER");
        requisition.itemName = I.getData(itemType);
        requisition.glAccount = I.getData("GL_ACCOUNT");
        requisition.assetCode = I.getData("COST_BOOKING_DETAILS_ASSET_CODE");
        requisition.buyer = I.getData("BUYER_NAME");
        requisition.assignedBuyerGroup = "undefined";
        requisition.nextAction = lmtVar.getLabel("SUBMIT")
        requisition.fillCBL = false;
        requisition.items  = await this.getArrayOfItems(noOfItems,itemType);
        requisition.taxType = I.getData("TAX_TYPE");
        requisition.taxName = I.getData("TAX_NAME");
        requisition.setApplyTaxItemLevel = false;
        requisition.convertToPoFlag = true;
        requisition.approvePoFlag = true;
        return requisition;
    }

    async getObjectOfGuidedItem(index)
    {
        let guidedItem = new guidedItemBo();
        guidedItem.itemName = "GuidedItem_"+faker.random.number(500000);
        guidedItem.category = I.getData("ITEM_CATEGORY_FOR_SEARCHING");
        guidedItem.partNumber = faker.random.number(10000);
        guidedItem.description = "Description_"+faker.random.alphaNumeric(10);
        guidedItem.type = I.getData("ITEM_TYPE");
        guidedItem.receiveBillBy = I.getData("RECEIVE_BY");
        guidedItem.sourcingStatus = I.getData("SOURCING_STATUS_OPTION");
        guidedItem.quantity = faker.random.number({min:1, max:100})
        guidedItem.uom = I.getData("ITEM_UOM");
        guidedItem.price = faker.random.number({min:1, max:2000});
        guidedItem.currency = I.getData("ITEM_CURRENCY");
        guidedItem.zeroPriceItem = false;
        guidedItem.buyerReviewRequired = true;
        let supplier = new Array();
        supplier.push(I.getData("SUPPLIER_NAME"));
        guidedItem.suppliers = supplier;
        guidedItem.nextAction = lmtVar.getLabel("ADD_TO_CART");
        guidedItem.supplierAddress= (I.getData("OTHER_DELIVERY_ADD"));
        guidedItem.supplierContact=(I.getData("SUPPLIER_CONTACT_NAME"));
        guidedItem.supplierEmail=(I.getData("SUPPLIER_EMAIL"));
        guidedItem.supplierPhone= (faker.phone.phoneNumber());
        return guidedItem;
    }

    getObjectOfStockItem(index)
    {
        let stockItem = new stockItemBo();
        stockItem.itemName = I.getData("SEARCH_ITEM_STOCK");
        stockItem.quantity = faker.random.number(50);
        return stockItem;
    }
    
}

module.exports = new ObjectCreation();