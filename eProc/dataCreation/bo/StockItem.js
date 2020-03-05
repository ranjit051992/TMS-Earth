class StockItem
{
    constructor()
    {
        this.itemName;
        this.itemQuantity;

    }

    setItemName(itemName)
    {
        this.itemName = itemName;
    }

    setItemQuantity(itemQuantity)
    {
        this.itemQuantity = itemQuantity;
    }
}

module.exports = StockItem;