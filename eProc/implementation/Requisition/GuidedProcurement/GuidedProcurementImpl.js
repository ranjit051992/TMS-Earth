const { I } = inject();
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const iGuided = require("./GuidedProcurementObject");
const prop = global.confi_prop;
const lmtVar = require("../../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const commonKeywordImpl = require("../../../commonKeywords/CommonComponent");

module.exports= {
    async addGuidedItemForPo(guidedItem){
        await this.clickOnAddItemServiceButton();
        await this.fillShortDescription();  //pass parameter
        await this.selectProductCategory(); //pass category
        if(guidedItem.selectGoods) {
            await this.selectItemTypeGoods();
        }
        
        if(guidedItem.selectQuantity) {
            await this.selectReceiveByQuantity();
        }
        else if(guidedItem.selectAmount) {
            await this.selectReceiveByAmount();
        }
    },
    async clickOnAddItemServiceButton() {
        await I.waitForVisible(I.getElement(iGuided.ADD_ITEM_SERVICE_BUTTON));
        await I.click(I.getElement(iGuided.ADD_ITEM_SERVICE_BUTTON));
        logger.info("Clicked on Add Item/Service button");
    },
    async fillShortDescription(shortDescription) {
        await I.waitForVisible(I.getElement(iGuided.PO_GUIDED_ITEM_SHORT_DESCRIPTION_TEXTBOX));
        await I.click(I.getElement(iGuided.PO_GUIDED_ITEM_SHORT_DESCRIPTION_TEXTBOX));
        await I.clearField(I.getElement(iGuided.PO_GUIDED_ITEM_SHORT_DESCRIPTION_TEXTBOX));
        await I.fillField(I.getElement(iGuided.PO_GUIDED_ITEM_SHORT_DESCRIPTION_TEXTBOX), shortDescription);
        logger.info(`Filled Short Description --> ${shortDescription}`);
    },
    async selectProductCategory(category) {
        let optionXpath = `//span[text()='${category}']`;
        category = await commonKeywordImpl.searchAndSelectFromDropdown(I.getElement(iGuided.PO_GUIDED_ITEM_PRODUCT_CATEGORY_TEXTBOX), category, optionXpath);
        logger.info(`Selected product category --> ${category}`);
        return category;
    },
    async selectItemTypeGoods() {
        await commonKeywordImpl.waitForElementPresent(I.getElement(iGuided.PO_GUIDED_ITEM_GOODS_RADIO_BUTTON));
        await commonKeywordImpl.clickUsingJsByXpath(I.getElement(iGuided.PO_GUIDED_ITEM_GOODS_RADIO_BUTTON));
        logger.info("Selected item type goods");
    },
    async selectReceiveByQuantity() {
        await commonKeywordImpl.waitForElementPresent(I.getElement(iGuided.PO_GUIDED_ITEM_QUANTITY_RADIO_BUTTON));
        await commonKeywordImpl.clickUsingJsByXpath(I.getElement(iGuided.PO_GUIDED_ITEM_QUANTITY_RADIO_BUTTON));
        logger.info("Selected receive by quantity");
    },
    async selectReceiveByAmount() {
        await commonKeywordImpl.waitForElementPresent(I.getElement(iGuided.PO_GUIDED_ITEM_AMOUNT_RADIO_BUTTON));
        await commonKeywordImpl.clickUsingJsByXpath(I.getElement(iGuided.PO_GUIDED_ITEM_AMOUNT_RADIO_BUTTON));
        logger.info("Selected receive by amount");
    },
    async fillMarketPrice(price) {
        await I.waitForVisible(I.getElement(iGuided.PO_GUIDED_ITEM_MARKET_PRICE_TEXTBOX));
        await I.click(I.getElement(iGuided.PO_GUIDED_ITEM_MARKET_PRICE_TEXTBOX));
        await I.clearField(I.getElement(iGuided.PO_GUIDED_ITEM_MARKET_PRICE_TEXTBOX));
        await I.fillField(I.getElement(iGuided.PO_GUIDED_ITEM_MARKET_PRICE_TEXTBOX), price);
        logger.info(`Filled Market Price --> ${price}`);
        return price;
    },
    async fillQuantity(quantity) {
        await I.waitForVisible(I.getElement(iGuided.PO_GUIDED_ITEM_MARKET_PRICE_TEXTBOX));
        await I.click(I.getElement(iGuided.PO_GUIDED_ITEM_MARKET_PRICE_TEXTBOX));
        await I.clearField(I.getElement(iGuided.PO_GUIDED_ITEM_MARKET_PRICE_TEXTBOX));
        await I.fillField(I.getElement(iGuided.PO_GUIDED_ITEM_MARKET_PRICE_TEXTBOX), price);
        logger.info(`Filled quantity --> ${quantity}`);
        return price;
    }
     
};