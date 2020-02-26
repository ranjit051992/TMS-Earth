const spo = require("../bo/Spo");
const itemsBo = require("../bo/ItemsBo")
const catalogItem = require("../bo/CatalogItem")
const requisition = require("../bo/Requisition")
const faker = require('faker')


class ObjectCreation
{
    getObjectOfStandardPO(noOfItems,itemType)
    {
        
        //spo.setPoNumber();
        spo.setPoDescription("AutomationSPO");
        spo.setPurchaseType(global.testData.get("PURCHASE_TYPE"));
        spo.setSupplierName(global.testData.get("SUPPLIER_NAME"));
        spo.setSupplierAddress(global.testData.get("SUPPLIER_ADDRESS"));
        spo.setPaymentTerm(global.testData.get("PAYMENT_TERMS"));
        spo.setDeliveryTerm(global.testData.get("DELIVERY_TERMS"));
        spo.setCurrency(global.testData.get("CURRENCY_TYPE"));
        spo.setBuyer(global.testData.get("BUYER_NAME"));
        spo.setBookCostAtLineItemLevel("No");
        spo.setBookCostToSingleMultipleCC("Yes");
        spo.setAssignCostProject("No");
        spo.setItemName(global.testData.get(itemType));
        let item = this.getObjectOfItemsBo(noOfItems,itemType);
        spo.setItems(item);
        spo.setGlAccount(global.testData.get("GL_ACCOUNT"));
        spo.setCostCenter(global.testData.get("COST_CENTER"));
        return spo;
    }

    getObjectOfItemsBo(noOfItems,itemType)
    {
        let catalogItems = new Set();

        if(itemType==='Catalog')
        {
            for(const i in noOfItems)
            {
                let itemNo = 0;
                let catalog = this.getObjectOfCatalogItem(itemNo);
                catalogItems.add(catalog);
                itemNo++;
            }
        }

        itemsBo.setCatalogItemSet(catalogItems);

        return itemsBo;
    }

    getObjectOfCatalogItem(itemIndex)
    {
        catalogItem.setItemName(global.testData.get("ITEM_NAME_FOR_SEARCHING"));
        return catalogItem;
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
        // let itemArray = new Array();
        
        // for(let i in noOfItems)
        // {
        //     itemArray.push(this.getObjectOfItemsBo(noOfItems,itemType));
        // }

        // requisition.items = itemArray;
        return requisition;
    }

}

module.exports = new ObjectCreation();