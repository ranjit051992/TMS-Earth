
const { I } = inject();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
const iLogin = require("./LoginObject");
const onlinestore = require("../Requisition/OnlineStore/OnlineStoreImpl");
const prop = global.confi_prop;
const username = global.confi_prop.username;
const password = global.confi_prop.password;

module.exports = {

    async login()
    {
        logger.info(global.confi_prop.url);
        I.amOnPage(global.confi_prop.url);
        I.seeElement(global.uiElements.get(iLogin.EMAIL_ADDRESS_GHOST_TEXTBOX));
        logger.info("Navigated to login page");
        I.click(global.uiElements.get(iLogin.EMAIL_ADDRESS_GHOST_TEXTBOX));
        I.fillField(global.uiElements.get(iLogin.EMAIL_ADDRESS_TEXTBOX), username);
        logger.info(`Entered email address --> ${username}`);
        I.click(global.uiElements.get(iLogin.PASSWORD_GHOST_TEXTBOX));
        I.fillField(global.uiElements.get(iLogin.PASSWORD_TEXTBOX), password);
        logger.info(`Entered password --> ${password}`);
        I.click(global.uiElements.get(iLogin.LOGIN_BUTTON));
        logger.info("Clicked on Login button");
      //  I.waitForVisible(global.uiElements.get(iLogin.DDS_LOGIN_PAGE));
        I.amOnPage(global.confi_prop.DDS_OnlineStore_Url);
        I.waitForVisible(global.uiElements.get(iLogin.REQ_TABLE_OPTION_ICON));
        logger.info("Navigated to DDS Online Store page");
        onlinestore.waitForOnlineStoreToLoad();
    },

}