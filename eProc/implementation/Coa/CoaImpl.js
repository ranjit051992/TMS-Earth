const { I } = inject();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
// const commonKeywordsImpl = require("../../commonKeywords/CommonComponent");
const coaObject = require("./CoaObject");
const spoImpl = require("../PO/Spo/SpoImpl");
const prop = global.confi_prop;

module.exports = {
    async fillCoaForm() {
        // pause();
        await I.waitForVisible(I.getElement(coaObject.AUTO_COMPLETE_TEXTBOX));

        let quantity = await this.getQuantityValue();
        
        await this.selectQuantityRadioButton();

        await this.fillAutoCompleteFields();

        await this.fillQuantity(quantity);

        await spoImpl.clickOnCostBookingSaveButton();

        await I.waitForInvisible(I.getElement(coaObject.AUTO_COMPLETE_TEXTBOX));

        logger.info("Coa form filled successfully");
    },
    // async fillNonCoaForm() {

    // },
    async getQuantityValue() {
        await I.waitForVisible(coaObject.QUANTITY_VALUE);
        let quantity = await (await I.grabTextFrom(coaObject.QUANTITY_VALUE)).toString().trim();
        logger.info(`Retrieved quantity --> ${quantity}`);
        return quantity;
    },
    async selectQuantityRadioButton() {
        // await commonKeywordsImpl.clickUsingJsByXpath(I.getElement(coaObject.QUANTITY_RADIO_BUTTON));
        await I.waitForVisible(I.getElement(coaObject.SPINNER_COA));
        await I.waitForInvisible(I.getElement(coaObject.SPINNER_COA));
        await I.waitForVisible(I.getElement(coaObject.AUTOCOMPLETE_TEXTBOX));
        logger.info("Selected Quantity radio button");
    },
    async fillAutoCompleteFields() {
        let flag;
        let index = 1;
        let autoCompleteTextboxXpath = I.getElement(coaObject.AUTO_COMPLETE_TEXTBOX);

        autoCompleteTextboxXpath = `(${autoCompleteTextboxXpath})[${index}]`;
        // flag = await commonKeywordsImpl.waitForElementPresent(autoCompleteTextboxXpath);

        if(flag) {
            while (flag) {
                await I.scrollIntoView(autoCompleteTextboxXpath);
                await I.wait(prop.DEFAULT_WAIT);
                let isEnabled = await commonKeywordsImpl.isEnabledByXpath(autoCompleteTextboxXpath);
                if(isEnabled) {
                    await I.waitForVisible(autoCompleteTextboxXpath);
                    await I.click(autoCompleteTextboxXpath);
                    await I.clearField(autoCompleteTextboxXpath);
                    // await I.fillField(autoCompleteTextboxXpath, coaObject.coaData[index]);
                    await I.waitForVisible(I.getElement(coaObject.AUTO_COMPLETE_OPTION));
                    await I.click(I.getElement(coaObject.AUTO_COMPLETE_OPTION));
                    await I.waitForVisible(I.getElement(coaObject.SPINNER_COA));
                    await I.waitForInvisible(I.getElement(coaObject.SPINNER_COA));
                    await I.waitForVisible(I.getElement(coaObject.AUTOCOMPLETE_TEXTBOX));
                    logger.info(`Filled value for field at index ${index}`);
                }
                index++;
                autoCompleteTextboxXpath = `(${autoCompleteTextboxXpath})[${index}]`;
                // flag = await commonKeywordsImpl.waitForElementPresent(autoCompleteTextboxXpath);
            }
        }
        else {
            throw new Error(`Coa fields not found with locator --> ${autoCompleteTextboxXpath}`);
        }
    },
    async fillQuantity(quantity1) {
        await I.waitForVisible(I.getElement(coaObject.QUANTITY_TEXTBOX));
        await I.click(I.getElement(coaObject.QUANTITY_TEXTBOX));
        await I.clearField(I.getElement(coaObject.QUANTITY_TEXTBOX));
        await I.fillField(I.getElement(coaObject.QUANTITY_TEXTBOX), quantity1);
        logger.info(`Entered quantity --> ${quantity1}`);
    },
}