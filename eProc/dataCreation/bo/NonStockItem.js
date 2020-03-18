
class NonStockItem
{

    constructor()
    {
        this.itemName;
        this.sourcingStatus;
        this.supplier;
        this.quantity;
        this.price;
        this.uom;
        this.currency;
        this.category;
        this.itemDescription;
        this.partId;
        this.nextAction;
    }

    setItemName(itemName)
    {
        this.itemName =itemName;
    }

    setSourcingStatus(sourcingStatus)
    {
        this.sourcingStatus =sourcingStatus;
    }

    setSupplier(supplier)
    {
        this.supplier =supplier;
    }

    setUom(uom)
    {
        this.uom =uom;
    }

    setQuantity(quantity)
    {
        this.quantity =quantity;
    }

    setPrice(price)
    {
        this.price =price;
    }

    setCurrency(currency)
    {
        this.currency =currency;
    }

    setCategory(category)
    {
        this.category =category;
    }

    setPartId(partId)
    {
        this.partId =partId;
    }

    setItemDescription(itemDescription)
    {
        this.itemDescription =itemDescription;
    }

    setNextAction(nextAction)
    {
        this.nextAction =nextAction;
    }
}

module.exports= NonStockItem;