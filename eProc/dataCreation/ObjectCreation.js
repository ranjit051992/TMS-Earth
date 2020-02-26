const faker = require("faker");
const spo = require("../bo/Spo");
const itemsBo = require("../bo/ItemsBo")
const catalogItem = require("../bo/CatalogItem")


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
        spo.setItemName(global.testData.get("ITEM_NAME_FOR_SEARCHING"));
        let item = this.getObjectOfItemsBo(noOfItems,itemType);
        spo.setItems(item);
        spo.setGlAccount(global.testData.get("GL_ACCOUNT"));
        spo.setCostCenter(global.testData.get("COST_CENTER"));
        spo.setTermsAndConditions("This is an auto generated term and condition");
        spo.setNotes("This is an auto generated note");
        spo.setReceiptRuleAtHeaderLevel(true);
        spo.setReceiptCreationDefault(true);
        spo.setTaxInclusive(true);
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

        var itemName = global.testData.get("ITEM_NAME_FOR_SEARCHING");
        var array = itemName.split("||");
        console.log("Items array : "+array);
        catalogItem.setItemName(array[itemIndex]);
        return catalogItem;
    }

}
module.exports = new ObjectCreation();