class CatalogItem
{
    constructor()
    {
        let itemName;
        let quantity;
        let itemType;
    }

    setItemName(itemName)
    {
        this.itemName = itemName;
    }

    setQuantity(quantity)
    {
        this.quantity = quantity;
    }

    setItemType(itemType) {
        this.itemType = itemType;
    }
}
module.exports = CatalogItem;