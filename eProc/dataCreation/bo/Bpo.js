
class Bpo
{
    constructor()
    {
        this.poNumber;
        this.poDescription;
        this.purchaseType;
        this.company;
        this.businessUnit;
        this.location;
        this.supplierName;
        this.supplierAddress;
        this.paymentTerm;
        this.deliveryTerm;
        this.currency;
        this.buyer;
        this.deliverTo;
        this.requiredBy;
        this.assignCostProject;
        this.bookCostToSingleMultipleCC;
        this.bookCostAtLineItemLevel;
        this.costBookingPercentage;
        this.itemName;
        this.glAccount;
        this.costCenter;
        this.items = [];
        this.termsAndConditions;
        this.notes;
        this.receiptRuleAtHeaderLevel;
        this.receiptCreationDefault;
        this.taxInclusive;
        this.billToAddress;
        this.status;
        this.PoAmount;
        this.fillCbl;
        this.fillShippingDetails;
        this.fillControlSettings;
        this.fillAdditionalDetails;
        this.attachmentPath;
        this.fromDate;
        this.toDate;
        this.date;
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
        this.items =items;
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

    setTaxInclusive(taxInclusive)
    {
        this.taxInclusive = taxInclusive;
    }

    setBillToAddress(billToAddress)
    {
        this.billToAddress = billToAddress;
    }

    setStatus(status)
    {
        this.status = status;
    }

    setPoAmount(PoAmount)
    {
        this.PoAmount = PoAmount;
    }
    setFillCbl(fillCbl)
    {
        this.fillCbl = fillCbl;
    }

    setFillShippingDetails(fillShippingDetails) {
        this.fillShippingDetails = fillShippingDetails;
    }

    setFillControlSettings(fillControlSettings) 
    {
        this.fillControlSettings = fillControlSettings;
    }

    setFillAdditionalDetails(fillAdditionalDetails) {
        this.fillAdditionalDetails = fillAdditionalDetails;
    }
    setAttachmentPath(attachmentPath)
    {
        this.attachmentPath = attachmentPath;
    }
    setFromDate(fromDate)
    {
        this.fromDate = fromDate;
    }
    setToDate(toDate)
    {
        this.toDate = toDate;
    }
    setDate(date)
    {
        this.date=date;
    }

}
module.exports = Bpo;