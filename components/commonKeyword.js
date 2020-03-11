/* eslint-disable linebreak-style */
/* eslint-disable max-len */
"use strict";
const { I } = inject();

/**
 * Radio Button class
 */
class CommonKeyword {
 
    async click(locator){       
        I.clickElement(locator);
    }

    async enterText(fieldLbl,dataToFill){
        I.clearField(`.//p[contains(.,'${fieldLbl}')]/following-sibling::p/input|.//*[label[div[contains(.,'${fieldLbl}')]]]//input`);
        I.fillField(`.//p[contains(.,'${fieldLbl}')]/following-sibling::p/input|.//*[label[div[contains(.,'${fieldLbl}')]]]//input`,dataToFill);
        I.seeInField(`.//p[contains(.,'${fieldLbl}')]/following-sibling::p/input|.//*[label[div[contains(.,'${fieldLbl}')]]]//input`,dataToFill);
    }


    async enterTextUsingPlaceHolder(placeholder,dataToFill){

        I.clearField(".//input[@placeholder='" + placeholder + "']", dataToFill);
        I.fillField(".//input[@placeholder='" + placeholder + "']", dataToFill);
        I.seeInField(".//input[@placeholder='" + placeholder + "']", dataToFill);
    }
}

module.exports = new CommonKeyword();
module.exports.CommonKeyword = CommonKeyword; // for inheritance
