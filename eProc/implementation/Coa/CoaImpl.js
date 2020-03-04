const { I } = inject();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
const commonKeywordsImpl = require("../../commonKeywords/CommonComponent");
const coaObject = require("./CoaObject");
// const spoImpl = require("../PO/Spo/SpoImpl");
const iSpoObject = require("../PO/Spo/SpoObject");
const prop = global.confi_prop;
const lmtVar = require("../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");

module.exports = {
    async fillCoaDetails() {
        logger.info(`**************Filling Coa Details**************`);
        if(prop.isCoa) {
            await this.fillCoaForm();
        }
        else {
            await this.fillNonCoaForm();
        }
    },
    async fillCoaForm() {
        await I.waitForVisible(I.getElement(coaObject.AUTO_COMPLETE_TEXTBOX));

        let quantity = await this.getQuantityValue();
        
        await this.selectQuantityRadioButton();

        await this.fillAutoCompleteFields();

        await this.fillQuantity(quantity.toString());

        await this.clickOnCostBookingSaveButton();

        await I.waitForInvisible(I.getElement(coaObject.AUTO_COMPLETE_TEXTBOX));

        logger.info("Coa form filled successfully");
    },
    async fillNonCoaForm() {
        await this.fillGlAccount(I.getData("GL_ACCOUNT"));
        
        await this.clickOnCostBookingSaveButton();

        await I.waitForInvisible(I.getElement(iSpoObject.GLACCOUNT));

        logger.info("Non Coa form filled successfully");
    },
    async getQuantityValue() {
        let quantityValueXpath = `//p[contains(text(),'${lmtVar.getLabel("COA_QUANTITY_AMOUNT_LABEL")}')]//following-sibling::p`;
        await I.waitForVisible(quantityValueXpath);
        let quantity = await I.grabTextFrom(quantityValueXpath);
        logger.info(`Retrieved quantity --> ${quantity}`);
        return quantity;
    },
    async selectQuantityRadioButton() {
        await commonKeywordsImpl.clickUsingJsByXpath(I.getElement(coaObject.QUANTITY_RADIO_BUTTON));
        await I.waitForVisible(I.getElement(coaObject.SPINNER_COA));
        await I.waitForInvisible(I.getElement(coaObject.SPINNER_COA));
        await I.waitForVisible(I.getElement(coaObject.AUTO_COMPLETE_TEXTBOX));
        logger.info("Selected Quantity radio button");
    },
    async fillAutoCompleteFields() {
        let flag;
        let index = 1;

        let autoCompleteTextboxXpath = await (await this.getAutoCompleteTextboxXpath(I.getElement(coaObject.AUTO_COMPLETE_TEXTBOX), index)).toString();
        flag = await commonKeywordsImpl.waitForElementPresent(autoCompleteTextboxXpath);
        if(flag) {
            while (flag) {
                await I.scrollIntoView(autoCompleteTextboxXpath);
                await I.wait(prop.DEFAULT_WAIT);
                let isEnabled = await commonKeywordsImpl.isEnabledByXpath(autoCompleteTextboxXpath);
                if(isEnabled) {
                    await I.waitForVisible(autoCompleteTextboxXpath);
                    await I.click(autoCompleteTextboxXpath);
                    await I.clearField(autoCompleteTextboxXpath);
                    await I.fillField(autoCompleteTextboxXpath, coaObject.COA_DATA[index]);
                    await I.waitForVisible(I.getElement(coaObject.AUTO_COMPLETE_OPTION));
                    await I.click(I.getElement(coaObject.AUTO_COMPLETE_OPTION));
                    await I.waitForVisible(I.getElement(coaObject.SPINNER_COA));
                    await I.waitForInvisible(I.getElement(coaObject.SPINNER_COA));
                    await I.waitForVisible(I.getElement(coaObject.AUTO_COMPLETE_TEXTBOX));
                    logger.info(`Filled value for field at index ${index}`);
                }
                index++;
                autoCompleteTextboxXpath = await (await this.getAutoCompleteTextboxXpath(I.getElement(coaObject.AUTO_COMPLETE_TEXTBOX), index)).toString();
                flag = await commonKeywordsImpl.isElementPresent(autoCompleteTextboxXpath);
            }
        }
        else {
            throw new Error(`Coa fields not found with locator --> ${autoCompleteTextboxXpath}`);
        }
    },
    async fillQuantity(quantity) {
        await I.waitForVisible(I.getElement(coaObject.QUANTITY_TEXTBOX));
        await I.click(I.getElement(coaObject.QUANTITY_TEXTBOX));
        await I.clearField(I.getElement(coaObject.QUANTITY_TEXTBOX));
        await I.fillField(I.getElement(coaObject.QUANTITY_TEXTBOX), quantity);
        logger.info(`Entered quantity --> ${quantity}`);
    },
    async clickOnCostBookingSaveButton(){
        await I.waitForVisible(I.getElement(iSpoObject.COSTBOOKING_SAVE_BUUTON));
        await I.doubleClick(I.getElement(iSpoObject.COSTBOOKING_SAVE_BUUTON));
        logger.info("Clicked on coa form save button");
    },
    async getAutoCompleteTextboxXpath(autoCompleteTextboxXpath, index) {
        autoCompleteTextboxXpath = `(${autoCompleteTextboxXpath})[${index}]`;
        logger.info(`field xpath generated --> ${autoCompleteTextboxXpath}`);
        return autoCompleteTextboxXpath;
    },
    async fillGlAccount(glAccount) {
        await I.waitForVisible(I.getElement(iSpoObject.GLACCOUNT));
        await I.fillField(I.getElement(iSpoObject.GLACCOUNT), glAccount);
        let glAccountSuggXpath = `//div[contains(text(),'${glAccount}')]`;
        await I.waitForVisible(glAccountSuggXpath, prop.DEFAULT_MEDIUM_WAIT);
        await I.click(glAccountSuggXpath);
        glAccount = await I.grabAttributeFrom(I.getElement(iSpoObject.GLACCOUNT), "value");
        logger.info(`Selected GlAccount: ${glAccount}`);
        return glAccount;
    },
}