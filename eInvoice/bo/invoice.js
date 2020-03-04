class Invoice {
    constructor() {
        this.supplier;
        this.requester;
        this.itemName;
        this.category;
        this.qtyOrAmt;
        this.uom;
        this.price;
        this.glAccount;
        this.company;
        this.businessUnit;
        this.location;
        this.bu;
        this.costCenter;
        this.percentage;
    }
    setSupplier(supplier){
        this.supplier = supplier;
    }
    setRequester(requester){
        this.requester = requester;
    }
    setItemName(itemName){
        this.itemName = itemName;
    }
    setCategory(category){
        this.category = category;
    }
    setQtyOrAmt(qtyOrAmt){
        this.qtyOrAmt = qtyOrAmt;
    }
    setUom(uom){
        this.uom = uom;
    }
    setPrice(price){
        this.price = price;
    }
    setGlAccount(glAccount){
        this.glAccount = glAccount;
    }
    setCompany(company){
        this.company = company;
    }
    setBusinessUnit(businessUnit){
        this.businessUnit = businessUnit;
    }
    setLocation(location){
        this.location = location;
    }
    setCostCenter(costCenter){
        this.costCenter = costCenter;
    }
    setBu(bu){
        this.bu = bu;
    }
    setPercentage(percentage){
        this.percentage = percentage;
    }
}
module.exports = new Invoice();