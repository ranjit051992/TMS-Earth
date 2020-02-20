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
    }

    setPoNumber(poNumber)
    {
        this.poNumber = poNumber;
    }

    getPoNumber()
    {
        return this.poNumber;
    }

    setPoDescription(poDescription)
    {
        this.poDescription = poDescription;
    }

    getPoDescription()
    {
        return this.poDescription;
    }

    setPurchaseType(purchaseType)
    {
        this.purchaseType = purchaseType;
    }

    getPurchaseType()
    {
        return this.purchaseType;
    }

    setSupplierName(supplierName)
    {
        this.supplierName = supplierName;
    }

    getSupplierName()
    {
        return this.supplierName;
    }

    setSupplierAddress(supplierAddress)
    {
        this.supplierAddress = supplierAddress;
    }

    getSupplierAddress()
    {
        return this.supplierAddress;
    }


    setPaymentTerm(paymentTerm)
    {
        this.paymentTerm = paymentTerm;
    }

    getPaymentTerm()
    {
        return this.paymentTerm;
    }

    setDeliveryTerm(deliveryTerm)
    {
        this.deliveryTerm = deliveryTerm;
    }

    getDeliveryTerm()
    {
        return this.deliveryTerm;
    }

    setCurrency(currency)
    {
        this.currency = currency;
    }

    getCurrency()
    {
        return this.currency;
    }

    setBuyer(buyer)
    {
        this.buyer = buyer;
    }

    getBuyer()
    {
        return this.buyer;
    }

    setAssignCostProject(assignCostProject)
    {
        this.deliveryTerm = deliveryTerm;
    }

    getAssignCostProject()
    {
        return this.deliveryTerm;
    }

    setBookCostToSingleMultipleCC(bookCostToSingleMultipleCC)
    {
        this.bookCostToSingleMultipleCC = bookCostToSingleMultipleCC;
    }

    getBookCostToSingleMultipleCC()
    {
        return this.bookCostToSingleMultipleCC;
    }

    setBookCostAtLineItemLevel(bookCostAtLineItemLevel)
    {
        this.bookCostAtLineItemLevel = bookCostAtLineItemLevel;
    }

    getBookCostAtLineItemLevel()
    {
        return this.bookCostAtLineItemLevel;
    }

    setItemName(itemName)
    {
        this.itemName = itemName;
    }

    getItemName()
    {
        return this.itemName;
    }

    setGlAccount(glAccount)
    {
        this.glAccount = glAccount;
    }

    getGlAccount()
    {
        return this.glAccount;
    }

    setCostCenter(costCenter)
    {
        this.costCenter = costCenter;
    }

    getCostCenter()
    {
        return this.costCenter;
    }
}

module.exports = new Spo();