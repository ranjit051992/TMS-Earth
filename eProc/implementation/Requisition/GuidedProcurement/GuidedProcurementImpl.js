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
     
};