const spo = require("../bo/Spo");

class ObjectCreation
{
    getObjectOfStandardPO(noOfItems,itemType)
    {
        spo.setPoNumber("");
        spo.setPoDescription("");
        spo.setPurchaseType("");
        spo.setSupplierName("");
        spo.setSupplierAddress("");
        spo.setPaymentTerm("");
        spo.setDeliveryTerm("");
        spo.setCurrency("");
        spo.setBuyer("");
        spo.setBookCostAtLineItemLevel("");
        spo.setBookCostToSingleMultipleCC("");
        spo.setAssignCostProject("");
        spo.setItemName("");
        spo.setGlAccount("");
        spo.setCostCenter("");
        return spo;
    }

}

getObjectOfStandardPO();

module.exports = new ObjectCreation();