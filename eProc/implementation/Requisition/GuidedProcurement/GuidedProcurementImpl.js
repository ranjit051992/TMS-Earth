const { I } = inject();
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const iGuided = require("./GuidedProcurementObject");
const prop = global.confi_prop;
const lmtVar = require("../../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const commonKeywordImpl = require("../../../commonKeywords/CommonComponent");

module.exports= {
    async addGuidedItemForPo(guidedItem){
        await this.clickOnAddItemServiceButtonPo();
        await this.fillShortDescriptionPo();  //pass parameter
        await this.selectProductCategoryPo(); //pass category
        if(guidedItem.itemType === lmtVar.getLabel("ITEM_TYPE_GOODS")) {
            await this.selectItemTypeGoods();
        }
        else {
            logger.info(`Incorrect Item type passed --> ${guidedItem.itemType}`);
            throw new Error(`Incorrect Item type passed --> ${guidedItem.itemType}`);
        }
        
        if(guidedItem.receiveBy === lmtVar.getLabel("RECEIVE_BY_QUANTITY")) {
            await this.selectReceiveByQuantity();
        }
        else if(lmtVar.getLabel("RECEIVE_BY_AMOUNT")) {
            await this.selectReceiveByAmount();
        }
        else {
            logger.info(`Incorrect Receive By passed --> ${guidedItem.receiveBy}`);
            throw new Error(`Incorrect Receive By passed --> ${guidedItem.receiveBy}`);
        }

        await this.fillMarketPricePo();   //pass market price

        await this.fillQuantityPo();  //pass quantity

        await this.fillUomPo();   //pass uom

        await this.clickOnOkayButtonPo();
    },
    async clickOnAddItemServiceButtonPo() {
        await I.waitForVisible(I.getElement(iGuided.ADD_ITEM_SERVICE_BUTTON));
        await I.click(I.getElement(iGuided.ADD_ITEM_SERVICE_BUTTON));
        logger.info("Clicked on Add Item/Service button");
    },
    async fillShortDescriptionPo(shortDescription) {
        await I.waitForVisible(I.getElement(iGuided.PO_GUIDED_ITEM_SHORT_DESCRIPTION_TEXTBOX));
        await I.click(I.getElement(iGuided.PO_GUIDED_ITEM_SHORT_DESCRIPTION_TEXTBOX));
        await I.clearField(I.getElement(iGuided.PO_GUIDED_ITEM_SHORT_DESCRIPTION_TEXTBOX));
        await I.fillField(I.getElement(iGuided.PO_GUIDED_ITEM_SHORT_DESCRIPTION_TEXTBOX), shortDescription);
        logger.info(`Filled Short Description --> ${shortDescription}`);
    },
    async selectProductCategoryPo(category) {
        let optionXpath = `//span[text()='${category}']`;
        category = await commonKeywordImpl.searchAndSelectFromDropdown(I.getElement(iGuided.PO_GUIDED_ITEM_PRODUCT_CATEGORY_TEXTBOX), category, optionXpath);
        logger.info(`Selected product category --> ${category}`);
        return category;
    },
    async selectItemTypeGoodsPo() {
        await commonKeywordImpl.waitForElementPresent(I.getElement(iGuided.PO_GUIDED_ITEM_GOODS_RADIO_BUTTON));
        await commonKeywordImpl.clickUsingJsByXpath(I.getElement(iGuided.PO_GUIDED_ITEM_GOODS_RADIO_BUTTON));
        logger.info("Selected item type goods");
    },
    async selectReceiveByQuantityPo() {
        await commonKeywordImpl.waitForElementPresent(I.getElement(iGuided.PO_GUIDED_ITEM_QUANTITY_RADIO_BUTTON));
        await commonKeywordImpl.clickUsingJsByXpath(I.getElement(iGuided.PO_GUIDED_ITEM_QUANTITY_RADIO_BUTTON));
        logger.info("Selected receive by quantity");
    },
    async selectReceiveByAmountPo() {
        await commonKeywordImpl.waitForElementPresent(I.getElement(iGuided.PO_GUIDED_ITEM_AMOUNT_RADIO_BUTTON));
        await commonKeywordImpl.clickUsingJsByXpath(I.getElement(iGuided.PO_GUIDED_ITEM_AMOUNT_RADIO_BUTTON));
        logger.info("Selected receive by amount");
    },
    async fillMarketPricePo(price) {
        await I.waitForVisible(I.getElement(iGuided.PO_GUIDED_ITEM_MARKET_PRICE_TEXTBOX));
        await I.click(I.getElement(iGuided.PO_GUIDED_ITEM_MARKET_PRICE_TEXTBOX));
        await I.clearField(I.getElement(iGuided.PO_GUIDED_ITEM_MARKET_PRICE_TEXTBOX));
        await I.fillField(I.getElement(iGuided.PO_GUIDED_ITEM_MARKET_PRICE_TEXTBOX), price);
        logger.info(`Filled Market Price --> ${price}`);
        return price;
    },
    async fillQuantityPo(quantity) {
        await I.waitForVisible(I.getElement(iGuided.PO_GUIDED_ITEM_MARKET_PRICE_TEXTBOX));
        await I.click(I.getElement(iGuided.PO_GUIDED_ITEM_MARKET_PRICE_TEXTBOX));
        await I.clearField(I.getElement(iGuided.PO_GUIDED_ITEM_MARKET_PRICE_TEXTBOX));
        await I.fillField(I.getElement(iGuided.PO_GUIDED_ITEM_MARKET_PRICE_TEXTBOX), price);
        logger.info(`Filled quantity --> ${quantity}`);
        return price;
    },
    async fillUomPo(uom) {
        let optionXpath = `//span[text()='${uom}']`;
        uom = await commonKeywordImpl.searchAndSelectFromDropdown(I.getElement(iGuided.PO_GUIDED_ITEM_UOM_TEXTBOX), uom, optionXpath);
        logger.info(`Selected Uom --> ${uom}`);
        return uom;
    },
    async clickOnOkayButtonPo(uom) {
        let optionXpath = `//span[text()='${uom}']`;
        uom = await commonKeywordImpl.searchAndSelectFromDropdown(I.getElement(iGuided.PO_GUIDED_ITEM_UOM_TEXTBOX), uom, optionXpath);
        logger.info(`Selected Uom --> ${uom}`);
        return uom;
    },
    async fillItemServiceName(itemName)
    {
        await I.waitForVisible(I.getElement(iGuided.ITEM_NAME_TEXTBOX));
        await I.waitForClickable(I.getElement(iGuided.ITEM_NAME_TEXTBOX));
        await I.clearField(I.getElement(iGuided.ITEM_NAME_TEXTBOX));
        await I.fillField(I.getElement(iGuided.ITEM_NAME_TEXTBOX),itemName);
    },

    async clickOnAddItemServiceButton()
    {
        await I.waitForVisible(I.getElement(iGuided.ADD_ITEM_SERVICE_BUTTON));
        await I.waitForClickable(I.getElement(iGuided.ADD_ITEM_SERVICE_BUTTON));
        await I.click(I.getElement(iGuided.ADD_ITEM_SERVICE_BUTTON));
        logger.info("Clicked on Add Item/Service button");
    },
    async fillCategory(category)
    {
        await commonKeywordImpl.searchAndSelectFromDropdown(I.getElement(iGuided.CATEGORY_TEXTBOX),category,"//span[contains(text(),'"+category+"')]");
    },

    async clickOnGoodsRadioButton()
    {
        await I.waitForVisible(I.getElement(iGuided.ITEM_TYPE_GOODS_RADIO_BUTTON));
        await I.waitForClickable(I.getElement(iGuided.ITEM_TYPE_GOODS_RADIO_BUTTON));
        await I.click(I.getElement(iGuided.ITEM_TYPE_GOODS_RADIO_BUTTON));
    },

    async clickOnServiceRadioButton()
    {
        await I.waitForVisible(I.getElement(iGuided.ITEM_TYPE_SERVICE_RADIO_BUTTON));
        await I.waitForClickable(I.getElement(iGuided.ITEM_TYPE_SERVICE_RADIO_BUTTON));
        await I.click(I.getElement(iGuided.ITEM_TYPE_SERVICE_RADIO_BUTTON));
    },

    async clickOnQuantityRadioButton()
    {
        await I.waitForVisible(I.getElement(iGuided.RECEIVE_BY_QUANTITY_RADIO_BUTTON));
        await I.waitForClickable(I.getElement(iGuided.RECEIVE_BY_QUANTITY_RADIO_BUTTON));
        await I.click(I.getElement(iGuided.RECEIVE_BY_QUANTITY_RADIO_BUTTON));
    },

    async clickOnAmountRadioButton()
    {
        await I.waitForVisible(I.getElement(iGuided.RECEIVE_BY_AMOUNT_RADIO_BUTTON));
        await I.waitForClickable(I.getElement(iGuided.RECEIVE_BY_AMOUNT_RADIO_BUTTON));
        await I.click(I.getElement(iGuided.RECEIVE_BY_AMOUNT_RADIO_BUTTON));
    },

    async clickOnQuotedBySupplierRadioButton()
    {
        await I.waitForVisible(I.getElement(iGuided.QUOTED_BY_SUPPLIER_RADIO_BUTTON));
        await I.waitForClickable(I.getElement(iGuided.QUOTED_BY_SUPPLIER_RADIO_BUTTON));
        await I.click(I.getElement(iGuided.QUOTED_BY_SUPPLIER_RADIO_BUTTON));
    },

    async clickOnEstimatedPriceRadioButton()
    {
        await I.waitForVisible(I.getElement(iGuided.ESTIMATED_PRICE_RADIO_BUTTON));
        await I.waitForClickable(I.getElement(iGuided.ESTIMATED_PRICE_RADIO_BUTTON));
        await I.click(I.getElement(iGuided.ESTIMATED_PRICE_RADIO_BUTTON));
    },

    async clickOnNeedAQuoteRadioButton()
    {
        await I.waitForVisible(I.getElement(iGuided.NEED_A_QUOTE_RADIO_BUTTON));
        await I.waitForClickable(I.getElement(iGuided.NEED_A_QUOTE_RADIO_BUTTON));
        await I.click(I.getElement(iGuided.NEED_A_QUOTE_RADIO_BUTTON));
    },

    async fillQuantity(quantity)
    {
        await I.waitForVisible(I.getElement(iGuided.QUANTITY_TEXTBOX));
        await I.waitForClickable(I.getElement(iGuided.QUANTITY_TEXTBOX));
        await I.clearField(I.getElement(iGuided.QUANTITY_TEXTBOX));
        await I.fillField(I.getElement(iGuided.QUANTITY_TEXTBOX),quantity);
    },

    async fillUom(uom)
    {
        await commonKeywordImpl.searchAndSelectFromDropdown(I.getElement(iGuided.UOM_TEXTBOX),uom,"//span[contains(text(),'"+uom+"')]");
    },

    async fillPrice(price)
    {
        await I.waitForVisible(I.getElement(iGuided.PRICE_TEXTBOX));
        await I.waitForClickable(I.getElement(iGuided.PRICE_TEXTBOX));
        await I.clearField(I.getElement(iGuided.PRICE_TEXTBOX));
        await I.fillField(I.getElement(iGuided.PRICE_TEXTBOX),price);
    },

    async fillCurrency(currency)
    {
        await commonKeywordImpl.searchAndSelectFromDropdown(I.getElement(iGuided.CURRENCY_TEXTBOX),currency,"//span[contains(text(),'"+currency+"')]");
    },

    async clickOnZeroPriceItemCheckbox()
    {
        await I.waitForVisible(I.getElement(iGuided.ZERO_PRICE_ITEM_CHECKBOX));
        await I.click(I.getElement(iGuided.ZERO_PRICE_ITEM_CHECKBOX));
    },

    async clickOnBuyerReviewYesRadioButton()
    {
        await I.waitForVisible(I.getElement(iGuided.BUYER_REVIEW_REQUIRED_YES_CHECKBOX));
        await I.waitForClickable(I.getElement(iGuided.ESTIMATED_PRICE_RADIO_BUTTON));
        await I.click(I.getElement(iGuided.ESTIMATED_PRICE_RADIO_BUTTON));
    },

    async clickOnBuyerReviewNoRadioButton()
    {
        await I.waitForVisible(I.getElement(iGuided.NEED_A_QUOTE_RADIO_BUTTON));
        await I.waitForClickable(I.getElement(iGuided.NEED_A_QUOTE_RADIO_BUTTON));
        await I.click(I.getElement(iGuided.NEED_A_QUOTE_RADIO_BUTTON));
    },

    async clickOnDoneButton()
    {
        await I.waitForVisible(I.getElement(iGuided.DONE_BUTTON));
        await I.waitForClickable(I.getElement(iGuided.DONE_BUTTON));
        await I.click(I.getElement(iGuided.DONE_BUTTON));
    },

};