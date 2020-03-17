
class Requisition
{

    constructor()
    {
        this.reqNumber;
        this.reqName;
        this.onBehalfOf;
        this.company;
        this.businessUnit;
        this.location;
        this.urgentRequirement;
        this.reasonForOrdering;
        this.commentsForSupplier;
        this.purchaseType;
        this.attachmentPath;
        this.settlementVia;
        this.retrospectivePurchase;
        this.isDefaultAddressOption;
        this.shipToDefaultAddress;
        this.isOtherAddressOption;
        this.shipToAnotherAddress;
        this.deliverTo;
        this.requiredBy;
        this.assignCostProject;
        this.bookCostToSingleMultipleCC;
        this.bookCostAtLineLevel;
        this.costCenter;
        this.project;
        this.itemName;
        this.glAccount;
        this.assetCode;
        this.buyer;
        this.buyerOption;
        this.assignedBuyerGroup;
        this.items = [];
        this.fillCBL;
        this.fillCostAllocation;
        this.nextAction;
        this.customAddressName;
        this.customAddressStreet1;
        this.customAddressStreet2;
        this.customAddressCountry;
        this.customAddressState;
        this.customAddressZip;
        this.customAddressCity;
        this.reqNumbers = [];
        this.isApplyTaxItemLevel;
        this.taxType;
        this.TaxName;
        this.taxRate;
        this.taxAmount;
        this.reqAmount;
        this.status;
        this.requestor;
        this.receivedOn;
        
        //let items = [];
        this.poNumber;
        this.convertToPoFlag;
        this.approvePoFlag;
        this.linkedPoNumber;
        this.newApprover;
    }

    setReqName(reqName)
    {
        this.reqName = reqName;
    }

    setReqNumber(reqNumber)
    {
        this.reqNumber = reqNumber;
    }

    setOnBehalfOf(onBehalfOf)
    {
        this.onBehalfOf = onBehalfOf;
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

    setUrgentRequirement(urgentRequirement)
    {
        this.urgentRequirement = urgentRequirement;
    }

    setReasonForOrdering(reasonForOrdering)
    {
        this.reasonForOrdering = reasonForOrdering;
    }

    setCommentsForSupplier(commentsForSupplier)
    {
        this.commentsForSupplier = commentsForSupplier;
    }

    setPurchaseType(purchaseType)
    {
        this.purchaseType = purchaseType;
    }

    setAttachmentPath(attachmentPath)
    {
        this.attachmentPath = attachmentPath;
    }

    setSettlementVia(settlementVia)
    {
        this.settlementVia = settlementVia;
    }

    setRetrospectivePurchase(retrospectivePurchase)
    {
        this.retrospectivePurchase = retrospectivePurchase;
    }

    setShipToDefaultAddress(shipToDefaultAddress)
    {
        this.shipToDefaultAddress = shipToDefaultAddress;
    }

    setDefaultAddressOption(defaultAddressOption)
    {
        this.defaultAddressOption = defaultAddressOption;
    }

    setOtherAddressOption(OtherAddressOption)
    {
        this.OtherAddressOption = OtherAddressOption;
    }

    setShipToAnotherAddress(shipToAnotherAddress)
    {
        this.shipToAnotherAddress = shipToAnotherAddress;
    }

    setDeliverTo(deliverTo)
    {
        this.deliverTo = deliverTo;
    }

    setRequiredBy(requiredBy)
    {
        this.requiredBy = requiredBy;
    }

    setAssignCostProject(assignCostProject)
    {
        this.assignCostProject = assignCostProject;
    }

    setBookCostToSingleMultipleCC(bookCostToSingleMultipleCC)
    {
        this.bookCostToSingleMultipleCC = bookCostToSingleMultipleCC;
    }

    setBookCostAtLineLevel(bookCostAtLineLevel)
    {
        this.bookCostAtLineLevel = bookCostAtLineLevel;
    }

    setCostCenter(costCenter)
    {
        this.costCenter = costCenter;
    }

    setItemName(itemName)
    {
        this.itemName = itemName;
    }

    setGlAccount(glAccount)
    {
        this.glAccount = glAccount;
    }

    setAssetCode(assetCode)
    {
        this.assetCode = assetCode;
    }

    setBuyer(buyer)
    {
        this.buyer = buyer;
    }

    setItems(items)
    {
        this.items =items;
    }

    setFillCBL(fillCBL)
    {
        this.fillCBL = fillCBL;
    }

    setProject(project)
    {
        this.project = project;
    }

    setBuyerOption(buyerOption)
    {
        this.buyerOption = buyerOption;
    }

    setFillCostAllocation(fillCostAllocation)
    {
        this.fillCostAllocation = fillCostAllocation;
    }

    setNextAction(nextAction)
    {
        this.nextAction = nextAction;
    }

    setTaxType(taxType)
    {
        this.taxType = taxType;
    }

    setTaxName(taxName)
    {
        this.taxName = taxName;
    }

    setTaxRate(taxRate)
    {
        this.taxRate = taxRate;
    }

    setTaxAmount(taxAmount)
    {
        this.taxAmount = taxAmount;
    }

    setApplyTaxItemLevel(isApplyTaxItemLevel)
	{
		this.isApplyTaxItemLevel = isApplyTaxItemLevel;
    }
    
    setreqAmount(reqAmount)
    {
        this.reqAmount = reqAmount;
    }

    setStatus(status)
    {
        this.status = status;
    }

    setPoNumber(poNumber) {
        this.poNumber = poNumber
    }

    setApprovePoFlag(approvePoFlag) {
        this.approvePoFlag = approvePoFlag;
    }

    setConvertToPoFlag(convertToPoFlag) {
        this.convertToPoFlag = convertToPoFlag;
    }

    setLinkedPoNumber(linkedPoNumber) {
        this.linkedPoNumber = linkedPoNumber;
    }

    setNewApprover(newApprover) {
        this.newApprover = newApprover;
    }
}

module.exports = Requisition;