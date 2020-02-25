const item = require("../bo/ItemsBo")

class Spo
{
    constructor()
    {
  
        let poNumber;
        let poDescription;
        let purchaseType;
        let company;
        let businessUnit;
        let location;
        let supplierName;
        let supplierAddress;
        let paymentTerm;
        let deliveryTerm;
        let currency;
        let buyer;
        let deliverTo;
        let requiredBy;
        let assignCostProject;
        let bookCostToSingleMultipleCC;
        let bookCostAtLineItemLevel;
        let costBookingPercentage;
        let itemName;
        let glAccount;
        let costCenter;
        let items;
        let termsAndConditions;
        let notes;
        let receiptRuleAtHeaderLevel;
        let receiptCreationDefault;

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

    setCompany(company)
    {
        this.company = company;
    }

    setBusinessUnit(businessUnit)
    {
        this.businessUnit = businessUnit;
    }

    setLocation(location)
    {
        this.location = location;
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

    setDeliverTo(deliverTo)
    {
        this.deliverTo = deliverTo;
    }

    setRequiredBy(requiredBy)
    {
        this.requiredBy = requiredBy;
    }

    setCostBookingPercentage(costBookingPercentage)
    {
        this.costBookingPercentage = costBookingPercentage;
    }

    setTermsAndConditions(termsAndConditions)
    {
        this.termsAndConditions = termsAndConditions;
    }

    setNotes(notes)
    {
        this.notes = notes;
    }
    
    setReceiptRuleAtHeaderLevel(receiptRuleAtHeaderLevel)
    {
        this.receiptRuleAtHeaderLevel = receiptRuleAtHeaderLevel;
    }

    setReceiptCreationDefault(receiptCreationDefault)
    {
        this.receiptCreationDefault = receiptCreationDefault;
    }
}
module.exports = new Spo();