const item = require("../bo/ItemsBo")

class Spo
{
    constructor()
    {
  
        let poNumber;
        let poDescription;
        let purchaseType;
        let supplierName;
        let supplierAddress;
        let paymentTerm;
        let deliveryTerm;
        let currency;
        let buyer;
        let assignCostProject;
        let bookCostToSingleMultipleCC;
        let bookCostAtLineItemLevel; 
        let itemName;
        let glAccount;
        let costCenter;
        let items;
    }
    setPoNumber(poNumber)
    {
        this.poNumber = poNumber;
    }
 
    setPoDescription(poDescription)
    {
        this.poDescription = poDescription;
    }
    
    setPurchaseType(purchaseType)
    {
        this.purchaseType = purchaseType;
    }
  
    setSupplierName(supplierName)
    {
        this.supplierName = supplierName;
    }
    
    setSupplierAddress(supplierAddress)
    {
        this.supplierAddress = supplierAddress;
    }
    
    setPaymentTerm(paymentTerm)
    {
        this.paymentTerm = paymentTerm;
    }
    
    setDeliveryTerm(deliveryTerm)
    {
        this.deliveryTerm = deliveryTerm;
    }
    
    setCurrency(currency)
    {
        this.currency = currency;
    }
    
    setBuyer(buyer)
    {
        this.buyer = buyer;
    }
   
    setAssignCostProject(assignCostProject)
    {
        this.assignCostProject = assignCostProject;
    }
    
    setBookCostToSingleMultipleCC(bookCostToSingleMultipleCC)
    {
        this.bookCostToSingleMultipleCC = bookCostToSingleMultipleCC;
    }
    
    setBookCostAtLineItemLevel(bookCostAtLineItemLevel)
    {
        this.bookCostAtLineItemLevel = bookCostAtLineItemLevel;
    }
    
    setItemName(itemName)
    {
        this.itemName = itemName;
    }
    
    setGlAccount(glAccount)
    {
        this.glAccount = glAccount;
    }
    
    setCostCenter(costCenter)
    {
        this.costCenter = costCenter;
    }
    
    setItems(items)
    {
        this.items = items;
    }
}
module.exports = new Spo();