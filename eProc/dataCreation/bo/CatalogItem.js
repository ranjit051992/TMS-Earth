class CatalogItem
{
    constructor()
    {
        let itemName;
        let quantity;
    }

    setItemName(itemName)
    {
        this.itemName = itemName;
    }

    setQuantity(quantity)
    {
        this.quantity = quantity;
    }
}
module.exports = CatalogItem;