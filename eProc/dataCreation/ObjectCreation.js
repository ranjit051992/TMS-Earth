const spo = require("../bo/Spo");
const itemsBo = require("../bo/ItemsBo")
const catalogItem = require("../bo/CatalogItem")


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
        spo.setItemName(global.testData.get("ITEM_NAME_FOR_SEARCHING"));
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

        var itemName = global.testData.get("ITEM_NAME_FOR_SEARCHING");
        var array = itemName.split("||");
        console.log("Items array : "+array);
        catalogItem.setItemName(array[itemIndex]);
        return catalogItem;
    }

}
module.exports = new ObjectCreation();