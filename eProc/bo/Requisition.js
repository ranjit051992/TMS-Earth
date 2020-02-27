
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
        this.shipToDefaultAddress;
        this.shipToAnotherAddress;
        this.deliverTo;
        this.requiredBy;
        this.assignCostProject;
        this.bookCostToSingleMultipleCC;
        this.bookCostAtLineLevel;
        this.costCenter;
        this.itemName;
        this.glAccount;
        this.assetCode;
        this.buyer;
        this.items = [];
        this.fillCBL;
        //let items = [];
    }

    setReqName(reqName)
    {
        this.reqName = reqName;
    }

    setReqNumber(reqNumber)
    {
        this.reqNumber = reqNumber
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
}

module.exports = new Requisition();