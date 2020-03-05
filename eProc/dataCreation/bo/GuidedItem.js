class GuidedItem
{
    constructor()
    {
        this.itemName;
        this.category;
        this.partNumber;
        this.description;
        this.type;
        this.receiveBillBy;
        this.sourcingStatus;
        this.quantity;
        this.uom;
        this.price;
        this.currency;
        this.zeroPriceItem;
        this.buyerReviewRequired;
        this.manufacturerName;
        this.imageUrl;
        this.producUrl;
        this.manufacturerUrl;
        this.manufacturerPartId;
        this.isGreen;
        this.isPreferred;
        this.specificationsName;
        this.specification;
        this.specificationDetails;
        this.attachmentPath;
        this.attachmentUrl;
    }
    setItemName(itemName)
    {
        this.itemName = itemName;
    }
    setCategory(category)
    {
        this.category = category;
    }
    setPartNumber(partNumber)
    {
        this.partNumber = partNumber;
    }
    
    setDescription(description)
    {
        this.description = description;
    }
    setType(type)
    {
        this.type = type;
    }
    setReceiveBillBy(receiveBillBy)
    {
        this.receiveBillBy = receiveBillBy;
    }
    setSourcingStatus(sourcingStatus)
    {
        this.sourcingStatus = sourcingStatus;
    }
    
    setQuantity(quantity)
    {
        this.quantity = quantity;
    }
    setUom(uom)
    {
        this.uom = uom;
    }
    
    setPrice(price)
    {
        this.price = price;
    }
    setCurrency(currency)
    {
        this.currency = currency;
    }
    setZeroPriceItem(zeroPriceItem)
    {
        this.zeroPriceItem = zeroPriceItem;
    }
    setBuyerReviewRequired(buyerReviewRequired)
    {
        this.buyerReviewRequired = buyerReviewRequired;
    }
    
    setManufacturerName(manufacturerName)
    {
        this.manufacturerName = manufacturerName;
    }
    setImageUrl(imageUrl)
    {
        this.imageUrl = imageUrl;
    }
    setProducUrl(producUrl)
    {
        this.producUrl = producUrl;
    }
    
    setManufacturerUrl(manufacturerUrl)
    {
        this.manufacturerUrl = manufacturerUrl;
    }
    setManufacturerPartId(manufacturerPartId)
    {
        this.manufacturerPartId = manufacturerPartId;
    }
    setIsGreen(isGreen)
    {
        this.isGreen = isGreen;
    }
    setIsPreferred(isPreferred)
    {
        this.isPreferred = isPreferred;
    }
    setSpecificationsName(specificationsName)
    {
        this.specificationsName = specificationsName;
    }
    setSpecification(specification)
    {
        this.specification = specification;
    }
    setSpecificationDetails(specificationDetails)
    {
        this.specificationDetails = specificationDetails;
    }
    setAttachmentPath(attachmentPath)
    {
        this.attachmentPath = attachmentPath;
    }
    setAttachmentUrl(attachmentUrl)
    {
        this.attachmentUrl = attachmentUrl;
    }
    
}
module.exports=GuidedItem;