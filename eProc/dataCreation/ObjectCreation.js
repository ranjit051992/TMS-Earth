const spo = require("../bo/Spo");
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
        spo.setGlAccount(global.testData.get("GL_ACCOUNT"));
        spo.setCostCenter(global.testData.get("COST_CENTER"));
        return spo;
    }
}
module.exports = new ObjectCreation();