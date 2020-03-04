const { I } = inject();
const faker = require("faker");
const spoBO = require("../dataCreation/bo/Spo");
const catalogItem = require("../dataCreation/bo/CatalogItem")
const requisition = require("../dataCreation/bo/Requisition")
const logger = require("../../Framework/FrameworkUtilities/Logger/logger");
const commonUtilities = require("../../Framework/FrameworkUtilities/CommonUtilities");
const prop = global.confi_prop;
const lmtVar = require("../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");


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
        let catalogItems = new Array();
        
        if(itemType==="Catalog")
        {
            for(let i =0;i<noOfItems;i++)
            {
                let catalog = await this.getObjectOfCatalogItem(i);
                catalogItems[i] = catalog;
            }
        }
        
        return catalogItems;
    }

    async getObjectOfCatalogItem(itemIndex)
    {
        let catalog = new catalogItem()
        catalog.setItemName(await commonUtilities.splitData(1,"ITEM_NAME_FOR_SEARCHING"));
        catalog.quantity = faker.random.number(20);
        return catalog;
    }

    getObjectOfRequisition(noOfItems,itemType)
     {
         requisition.reqName = "Automation_Req"+faker.random.number(200000);
        //requisition.onBehalfOf = I.getData("ON_BEHALF_OF_WITH_RIGHT_USER");
        requisition.onBehalfOf = (global.users.get("USERNAME"));
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
        //requisition.deliverTo = I.getData("DELIVERES_TO/OWNER");
        requisition.deliverTo = (global.users.get("USERNAME"));
        //requisition.requiredBy = faker.date.
        requisition.assignCostProject = "No";
        requisition.bookCostToSingleMultipleCC= "Yes";
        requisition.bookCostAtLineLevel = "No";
        requisition.costCenter = I.getData("COST_CENTER");
        requisition.itemName = I.getData("ITEM_NAME_FOR_SEARCHING");
        requisition.glAccount = I.getData("GL_ACCOUNT");
        requisition.assetCode = I.getData("COST_BOOKING_DETAILS_ASSET_CODE");
        requisition.buyer = I.getData("BUYER_NAME");
        requisition.itemName = I.getData("ITEM_NAME_FOR_SEARCHING");
        requisition.nextAction = lmtVar.getLabel("SUBMIT")
        requisition.fillCBL = false;
        requisition.items  =  this.getArrayOfItems(noOfItems,itemType);
        requisition.taxType = I.getData("TAX_TYPE");
        requisition.taxName = I.getData("TAX_NAME");
        requisition.setApplyTaxItemLevel = false;
        return requisition;
    }

    
}

module.exports = new ObjectCreation();