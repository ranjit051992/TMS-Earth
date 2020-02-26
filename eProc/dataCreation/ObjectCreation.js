const faker = require("faker");
const spo = require("../bo/Spo");
const catalogItem = require("../bo/CatalogItem")
const requisition = require("../bo/Requisition")
const logger = require("../../Framework/FrameworkUtilities/Logger/logger");
const commonUtilities = require("../../Framework/FrameworkUtilities/CommonUtilities")
const faker = require('faker')


class ObjectCreation
{
    async getObjectOfStandardPO(noOfItems,itemType)
    {
        spo.setPoNumber(`Automation_Spo_${new Date().getTime()}`);
        spo.setPoDescription(`Automation_Description_${new Date().getTime()}`);
        spo.setPurchaseType(global.testData.get("PURCHASE_TYPE"));
        spo.setCompany(global.testData.get("ORGANIZATION_UNIT/COMPANY_NAME"));
        spo.setBusinessUnit(global.testData.get("BUSINESS_UNIT_NAME"));
        spo.setLocation(global.testData.get("LOCATION_NAME"));
        spo.setSupplierName(global.testData.get("SUPPLIER_NAME"));
        spo.setSupplierAddress(global.testData.get("SUPPLIER_ADDRESS"));
        spo.setPaymentTerm(global.testData.get("PAYMENT_TERMS"));
        spo.setDeliveryTerm(global.testData.get("DELIVERY_TERMS"));
        spo.setCurrency(global.testData.get("CURRENCY_TYPE"));
        spo.setBuyer(global.testData.get("BUYER_NAME"));
        spo.setDeliverTo(global.testData.get("DELIVERES_TO/OWNER"));
        spo.setBookCostAtLineItemLevel("No");
        spo.setBookCostToSingleMultipleCC("Yes");
        spo.setAssignCostProject("No");
        spo.setItemName(global.testData.get(itemType));
        spo.items  =  this.getArrayOfItems(noOfItems,itemType);
        spo.setGlAccount(global.testData.get("GL_ACCOUNT"));
        spo.setCostCenter(global.testData.get("COST_CENTER"));
        spo.setTermsAndConditions("This is an auto generated term and condition");
        spo.setNotes("This is an auto generated note");
        spo.setReceiptRuleAtHeaderLevel(true);
        spo.setReceiptCreationDefault(true);
        spo.setTaxInclusive(true);
        return spo;
    }

    getArrayOfItems(noOfItems,itemType)
    {
        
        let catalogItems = new Array();
        
        if(itemType==="Catalog")
        {
            for(let i =0;i<noOfItems;i++)
            {
                let catalog = this.getObjectOfCatalogItem(i);
                catalogItems[i] = catalog;
            }
        }

        
        return catalogItems;
    }

    getObjectOfCatalogItem(itemIndex)
    {
        let catalog = new catalogItem()
        catalog.setItemName(commonUtilities.splitData(1,"ITEM_NAME_FOR_SEARCHING"));
        catalog.quantity = faker.random.number(20);
        return catalog;
    }

    getObjectOfRequisition(noOfItems,itemType)
     {
         requisition.reqName = "Automation_Req"+faker.random.number(200000);
        requisition.onBehalfOf = global.testData.get("ON_BEHALF_OF_WITH_RIGHT_USER");
        requisition.company = global.testData.get("ORGANIZATION_UNIT/COMPANY_NAME");
        requisition.businessUnit = global.testData.get("BUSINESS_UNIT_NAME");
        requisition.location = global.testData.get("LOCATION_NAME");
        requisition.urgentRequirement = global.testData.get("No");
        requisition.reasonForOrdering = global.testData.get("REASON_FOR_ORDERING");
        requisition.commentsForSupplier = global.testData.get("COMMENTS_FOR_SUPPLIERS");
        requisition.purchaseType = global.testData.get("PURCHASE_TYPE");
        requisition.attachmentPath = "";
        requisition.settlementVia = "Invoice";
        requisition.retrospectivePurchase = "No";
        requisition.shipToDefaultAddress = "Yes";
        requisition.shipToAnotherAddress = "No";
        requisition.deliverTo = global.testData.get("DELIVERES_TO/OWNER");
        //requisition.requiredBy = faker.date.
        requisition.assignCostProject = "No";
        requisition.bookCostToSingleMultipleCC= "Yes";
        requisition.bookCostAtLineLevel = "No";
        requisition.costCenter = global.testData.get("COST_CENTER");
        requisition.itemName = global.testData.get("ITEM_NAME_FOR_SEARCHING");
        requisition.glAccount = global.testData.get("GL_ACCOUNT");
        requisition.assetCode = global.testData.get("COST_BOOKING_DETAILS_ASSET_CODE");
        requisition.buyer = global.testData.get("BUYER_NAME");
        requisition.itemName = global.testData.get("ITEM_NAME_FOR_SEARCHING");
        requisition.fillCBL = false;
        requisition.items  =  this.getArrayOfItems(noOfItems,itemType);
       
        return requisition;
    }

    
}

module.exports = new ObjectCreation();