const { I } = inject();
const faker = require("faker");
const spoBO = require("../dataCreation/bo/Spo");
const bpoBO = require("../dataCreation/bo/Bpo");
const catalogItem = require("../dataCreation/bo/CatalogItem")
const requisition1 = require("../dataCreation/bo/Requisition");
const logger = require("../../Framework/FrameworkUtilities/Logger/logger");
const commonUtilities = require("../../Framework/FrameworkUtilities/CommonUtilities");
const prop = global.confi_prop;
const lmtVar = require("../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const guidedItemBo = require("../dataCreation/bo/GuidedItem")
const stockItemBo = require("../dataCreation/bo/StockItem")
const nonStockItemBo = require("../dataCreation/bo/NonStockItem");


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
        if(itemType.includes("ITEM_NAME_FOR_SEARCHING"))
        {
            for(let i =0;i<noOfItems;i++)
            {
                let catalog = await this.getObjectOfCatalogItem(i, itemType);
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
        
        if(itemType === "SEARCH_ITEM_NON_STOCK_WO_SUPPLIER" || itemType === "SEARCH_ITEM_NON_STOCK_WITH_SUPPLIER" || itemType === "SEARCH_ITEM_NONSTOCK")
        {
            for(let i=0; i<noOfItems; i++)
            {
                let nonstock = await this.getObjectOfNonStockItem(i,itemType);
                items[i] = nonstock;
            }
        }
        
        return items;
    }

    async getObjectOfCatalogItem(itemIndex, itemType)
    {
        let catalog = new catalogItem()
        catalog.setItemName(await I.getData(itemType));
        catalog.quantity = faker.random.number(20);
        catalog.itemType = lmtVar.getLabel("ITEM_TYPE_CATALOG");
        return catalog;
    }

    async getObjectOfRequisition(noOfItems,itemType)
     {
        let requisition = new requisition1();
        //requisition.reqName = "Automation_Req"+faker.random.number(200000);
        requisition.reqName = `Automation_req_${new Date().getTime()}`
        requisition.noOfItems = noOfItems;
        requisition.onBehalfOf = I.getData("ON_BEHALF_OF_WITH_RIGHT_USER");
        //requisition.onBehalfOf = (global.users.get("USERNAME"));
        requisition.company = I.getData("ORGANIZATION_UNIT/COMPANY_NAME");
        requisition.businessUnit = I.getData("BUSINESS_UNIT_NAME");
        requisition.location = I.getData("LOCATION_NAME");
       // requisition.urgentRequirement = I.getData("No");
       //  requisition.reasonForOrdering = I.getData("REASON_FOR_ORDERING");
       // requisition.commentsForSupplier = I.getData("COMMENTS_FOR_SUPPLIERS");
        requisition.purchaseType = I.getData("PURCHASE_TYPE");
        // requisition.attachmentPath = "";
        requisition.settlementVia = "Invoice";
        requisition.retrospectivePurchase = "No";
        requisition.shipToDefaultAddress = "Yes";
        requisition.shipToAnotherAddress = "No";
        requisition.deliverTo = I.getData("DELIVERES_TO/OWNER");
        requisition.newApprover = I.getData("NEW_APPROVER");
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
        requisition.fillTaxes = false;
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
        guidedItem.quantity = faker.random.number({min:1, max:5})
        guidedItem.uom = I.getData("ITEM_UOM");
        guidedItem.price = faker.random.number({min:1, max:20});
        guidedItem.currency = I.getData("ITEM_CURRENCY");
        guidedItem.zeroPriceItem = false;
        guidedItem.buyerReviewRequired = false;
        let supplier = new Array();
        supplier.push(I.getData("SUPPLIER_NAME"));
        guidedItem.suppliers = supplier;
        guidedItem.nextAction = lmtVar.getLabel("ADD_TO_CART");
        guidedItem.supplierAddress= (I.getData("OTHER_DELIVERY_ADD"));
        guidedItem.supplierContact=(I.getData("SUPPLIER_CONTACT_NAME"));
        guidedItem.supplierEmail=(I.getData("SUPPLIER_EMAIL"));
        guidedItem.supplierPhone= (faker.phone.phoneNumber());

        guidedItem.eform = I.getData("CATEGORY_EFORM");
        guidedItem.marketPrice = faker.random.number({min:1, max:10});
        guidedItem.itemType = lmtVar.getLabel("ITEM_TYPE_GUIDED");
        guidedItem.supplierContractId = I.getData("SUPPLIER_CONTRACT_ID");
        return guidedItem;
    }

    getObjectOfStockItem(index)
    {
        let stockItem = new stockItemBo();
        stockItem.itemName = I.getData("SEARCH_ITEM_STOCK");
        stockItem.quantity = faker.random.number(50);
        return stockItem;
    }

    async getObjectOfBlanketPO(noOfItems,itemType)
    {
        let bpo = new bpoBO();
        bpo.setPoNumber(`Automation_Bpo_${new Date().getTime()}`);
        bpo.setPoDescription(`Automation_Description_${new Date().getTime()}`);
        bpo.setPurchaseType(I.getData("PURCHASE_TYPE"));
        bpo.setCompany(I.getData("ORGANIZATION_UNIT/COMPANY_NAME"));
        bpo.setBusinessUnit(I.getData("BUSINESS_UNIT_NAME"));
        bpo.setLocation(I.getData("LOCATION_NAME"));
        bpo.setSupplierName(I.getData("SUPPLIER_NAME"));
        bpo.setSupplierAddress(I.getData("SUPPLIER_ADDRESS"));
        bpo.setPaymentTerm(I.getData("PAYMENT_TERMS"));
        bpo.setDeliveryTerm(I.getData("DELIVERY_TERMS"));
        bpo.setCurrency(I.getData("CURRENCY_TYPE"));
        bpo.setBuyer(I.getData("BUYER_NAME"));
        // bpo.setDeliverTo(I.getData("DELIVERES_TO/OWNER"));
        bpo.setDeliverTo(global.users.get("USERNAME"));
        bpo.setNewApprover(I.getData("NEW_APPROVER"));
        bpo.setBookCostAtLineItemLevel("No");
        bpo.setBookCostToSingleMultipleCC("Yes");
        bpo.setAssignCostProject("No");
        bpo.setDate(I.getData("DATE"));
        bpo.items = await this.getArrayOfItems(noOfItems,itemType);
        bpo.setGlAccount(I.getData("GL_ACCOUNT"));
        bpo.setCostCenter(I.getData("COST_CENTER"));
        bpo.setTermsAndConditions("This is an auto generated term and condition");
        bpo.setNotes("This is an auto generated note");
        bpo.setReceiptRuleAtHeaderLevel(true);
        bpo.setReceiptCreationDefault(true);
        bpo.setTaxInclusive(true);
        bpo.setFillCbl(false);
        bpo.setFillShippingDetails(false);
        bpo.setFillControlSettings(false);
        bpo.setFillAdditionalDetails(false);
        return bpo;
    }

    async getObjectOfGuidedItemForPo(index)
    {
        let guidedItem = new guidedItemBo();
        guidedItem.itemName = `GuidedItem_${new Date().getTime()}`;
        guidedItem.category = I.getData("ITEM_CATEGORY_FOR_SEARCHING");
        guidedItem.type = I.getData("ITEM_TYPE");
        guidedItem.receiveBillBy = I.getData("RECEIVE_BY");
        guidedItem.quantity = faker.random.number({min:1, max:100})
        guidedItem.uom = I.getData("ITEM_UOM");
        guidedItem.zeroPriceItem = false;
        return guidedItem;
    }
    

    async getObjectOfNonStockItem(index,itemType)
    {
        let nonStockItem = new nonStockItemBo();
        nonStockItem.itemName = I.getData(itemType+"["+index+"]");
        //nonStockItem.category = I.getData("ITEM_CATEGORY_FOR_SEARCHING");
        //nonStockItem.partId = faker.random.number(10000);
        nonStockItem.itemDescription= "Description_"+faker.random.alphaNumeric(10);
        nonStockItem.sourcingStatus = I.getData("SOURCING_STATUS_OPTION");
        nonStockItem.quantity = faker.random.number({min:1, max:50})
        //nonStockItem.uom = I.getData("ITEM_UOM");
        nonStockItem.price = faker.random.number({min:1, max:1000});
        nonStockItem.currency = I.getData("ITEM_CURRENCY");
        nonStockItem.zeroPriceItem = false;
        nonStockItem.supplier=I.getData("SUPPLIER_NAME");
        nonStockItem.nextAction = lmtVar.getLabel("ADD_TO_CART");

        return nonStockItem;
    }
}

module.exports = new ObjectCreation();