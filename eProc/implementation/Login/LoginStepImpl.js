const { I } = inject();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
const dbKeys = require("../../../Framework/FrameworkUtilities/DatabaseOperations/dbKeys");
const loginImpl = require("./LoginImpl");
const prop=global.confi_prop;
const commonUtils = require("../../../Framework/FrameworkUtilities/CommonUtilities");
const faker = require('faker');
const commonComponentImpl = require("../../commonKeywords/CommonComponent");
const iOnlineStoreObj = require("./../Requisition/OnlineStore/OnlineStoreObject");

Given("I am logged in eProc", async function () {
    if(!prop.LOGIN_WITH_PASSWORD_MANAGER) {
        await loginImpl.login();
        await commonComponentImpl.waitForLoadingSymbolNotDisplayed();
        await I.waitForVisible(I.getElement(iOnlineStoreObj.SEARCH_TEXTBOX));
        let flag = await commonComponentImpl.isElementVisible(I.getElement(iOnlineStoreObj.SEARCH_TEXTBOX));
        if(flag)
        {
            logger.info("Navigated to DDS Online Store page");
        }
        else
        {
            await loginImpl.login();
        }
    }
    else {
        await loginImpl.loginWithPasswordManager();

    }
});