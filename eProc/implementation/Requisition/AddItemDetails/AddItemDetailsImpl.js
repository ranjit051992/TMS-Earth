const { I } = inject();
const iAddItemDetails = require("./AddItemDetailsObject");
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const commonComponent = require("../../../commonKeywords/CommonComponent");
const lmtVar = require("../../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const prop = global.confi_prop;
const faker = require("faker");
const onlineStoreImpl = require("../OnlineStore/OnlineStoreImpl");

module.exports ={

    async clickOnAddItemDetailsButton(itemName)
    {
        let xpath ="//span[contains(text(),'"+itemName+"')]//ancestor::dew-card"+I.getElement(iAddItemDetails.ADD_ITEM_DETAILS_BUTTON);
        await I.waitForVisible(xpath);
        await I.waitForClickable(xpath);
        await I.click(xpath);
    },

    async selectQuotedBySupplierRadioButton()
    {
        await I.waitForVisible(I.getElement(iAddItemDetails.QUOTED_BY_SUPPLIER_RADIO_BUTTON));
        await I.click(I.getElement(iAddItemDetails.QUOTED_BY_SUPPLIER_RADIO_BUTTON));
    },

    async selectNeedAQuoteRadioButton()
    {
        await I.waitForVisible(I.getElement(iAddItemDetails.NEED_QUOTE_RADIO_BUTTON));
        await I.click(I.getElement(iAddItemDetails.NEED_QUOTE_RADIO_BUTTON)); 
    },

    async fillSupplier(supplier)
    {
        await I.waitForVisible(I.getElement(iAddItemDetails.SUPPLIER_TEXTBOX));
        await I.waitForClickable(I.getElement(iAddItemDetails.SUPPLIER_TEXTBOX)); 
        await commonComponent.searchAndSelectFromDropdown(I.getElement(iAddItemDetails.SUPPLIER_TEXTBOX),supplier,"//p[contains(text(),'"+supplier+"')]");
    },  

    async fillQuantity(quantity)
    {
        await I.scrollIntoView(I.getElement(iAddItemDetails.QUANTITY_TEXTBOX));
        await I.waitForVisible(I.getElement(iAddItemDetails.QUANTITY_TEXTBOX));
        await I.waitForClickable(I.getElement(iAddItemDetails.QUANTITY_TEXTBOX)); 
        await I.fillField(I.getElement(iAddItemDetails.QUANTITY_TEXTBOX),quantity.toString());

    },

    async fillItemDescriprtion(description)
    {
        await I.scrollIntoView(I.getElement(iAddItemDetails.ITEM_DESCRIPTION_TEXTBOX));
        await I.waitForVisible(I.getElement(iAddItemDetails.ITEM_DESCRIPTION_TEXTBOX));
        await I.waitForClickable(I.getElement(iAddItemDetails.ITEM_DESCRIPTION_TEXTBOX)); 
        await I.fillField(I.getElement(iAddItemDetails.ITEM_DESCRIPTION_TEXTBOX),description);

    },

    async fillPartId(partId)
    {
        await I.scrollIntoView(I.getElement(iAddItemDetails.SUPPLIER_PART_ID_TEXTBOX));
        await I.waitForVisible(I.getElement(iAddItemDetails.SUPPLIER_PART_ID_TEXTBOX));
        await I.waitForClickable(I.getElement(iAddItemDetails.SUPPLIER_PART_ID_TEXTBOX)); 
        await I.fillField(I.getElement(iAddItemDetails.SUPPLIER_PART_ID_TEXTBOX),partId.toString());

    },

    async fillUom(uom)
    {

        await I.waitForVisible(I.getElement(iAddItemDetails.UOM_TEXTBOX));
        await I.waitForClickable(I.getElement(iAddItemDetails.UOM_TEXTBOX)); 
        await commonComponent.searchAndSelectFromDropdown(I.getElement(iAddItemDetails.UOM_TEXTBOX),uom,"//*[contains(text(),'"+uom+"')]");
    
    },

    async fillPrice(price)
    {     
        await I.waitForVisible(I.getElement(iAddItemDetails.PRICE_TEXTBOX));
        await I.waitForClickable(I.getElement(iAddItemDetails.PRICE_TEXTBOX)); 
        await I.fillField(I.getElement(iAddItemDetails.PRICE_TEXTBOX),price.toString());
    },

    async fillCurrency(currency)
    {
     
        await I.waitForVisible(I.getElement(iAddItemDetails.CURRENCY_TEXTBOX));
        await I.waitForClickable(I.getElement(iAddItemDetails.CURRENCY_TEXTBOX)); 
        await commonComponent.searchAndSelectFromDropdown(I.getElement(iAddItemDetails.CURRENCY_TEXTBOX),currency,"//*[contains(text(),'"+currency+"')]");
    },

    async clickOnAddToCartButton()
    {
        await I.waitForVisible(I.getElement(iAddItemDetails.ADD_TO_CART_BUTTON));
        await I.waitForClickable(I.getElement(iAddItemDetails.ADD_TO_CART_BUTTON));
        await I.click(I.getElement(iAddItemDetails.ADD_TO_CART_BUTTON));
    },

    async clickOnAddToBasketButton()
    {
        await I.waitForVisible(I.getElement(iAddItemDetails.ADD_TO_BASKET_BUTTON));
        await I.waitForClickable(I.getElement(iAddItemDetails.ADD_TO_BASKET_BUTTON));
        await I.click(I.getElement(iAddItemDetails.ADD_TO_BASKET_BUTTON));
    },

    async selectZeroPriceCheckbox()
    {
        await I.waitForVisible(I.getElement(iAddItemDetails.ZERO_PRICE_ITEM_CHECKBOX));
        await I.waitForClickable(I.getElement(iAddItemDetails.ZERO_PRICE_ITEM_CHECKBOX));
        await I.click(I.getElement(iAddItemDetails.ZERO_PRICE_ITEM_CHECKBOX));
    },

    async fillItemDetails(nonstockItem)
    {
        await this.selectSourcingStatus(nonstockItem.sourcingStatus);

        if(typeof nonstockItem.supplier!=='undefined')
        {
            await this.fillSupplier(nonstockItem.supplier);
        }

        if(typeof nonstockItem.partId!=='undefined')
        {
            await this.fillPartId(nonstockItem.partId);
        }

        if(nonstockItem.quantity>0)
        {
            await this.fillQuantity(nonstockItem.quantity);
        }

        if(nonstockItem.price>0)
        {
            await this.fillPrice(nonstockItem.price);
        }

        if(typeof nonstockItem.uom!=='undefined')
        {
            await this.fillUom(nonstockItem.uom);
        }

        if(typeof nonstockItem.currency!=='undefined')
        {
            //await this.fillUom(nonstockItem.currency);
        }

        if (nonstockItem.zeroPriceItem) {
            await this.selectZeroPriceCheckbox();
        }

        if (nonstockItem.nextAction === lmtVar.getLabel("ADD_TO_CART")) {
            await this.clickOnAddToCartButton();
        }
        else if (nonstockItem.nextAction === lmtVar.getLabel("ADD_TO_BASKET")) {
            await this.clickOnAddToBasketButton();
        }

        return nonstockItem;
    },

    async selectSourcingStatus(sourcingStatus)
    {
        logger.info(`Selecting sourcing status : ${sourcingStatus}`);
        if (sourcingStatus === lmtVar.getLabel("SOURCING_STATUS_NEED_QUOTE")) {
            await this.selectNeedAQuoteRadioButton();
        }

        if (sourcingStatus === lmtVar.getLabel("SOURCING_STATUS_ESTIMATED_PRICE")) {
        }

        if (sourcingStatus === lmtVar.getLabel("SOURCING_STATUS_QUOTED_BY_SUPPLIER")) {
            await this.selectQuotedBySupplierRadioButton();
        }
    },

    async addNonStockItemToCart(nonstockItem)
    {
        await onlineStoreImpl.searchItem(nonstockItem.itemName);
        await this.clickOnAddItemDetailsButton(nonstockItem.itemName);
        await this.fillItemDetails(nonstockItem);
        await commonComponent.waitForElementVisible("//div[contains(text(),'"+lmtVar.getLabel("NONSTOCK_ITEM_CART_MSG")+"')]");
        logger.info("Item added to cart.")
    }

}