
const { I } = inject();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
const iLogin = require("./LoginObject");
const prop = global.confi_prop;
const username = global.confi_prop.username;
const password = global.confi_prop.password;

module.exports = {

    async login() {
        logger.info(global.confi_prop.url);
        I.amOnPage(global.confi_prop.url);
        I.fillField(I.getElement(iLogin.EMAIL_ADDRESS_TEXTBOX), username);
        logger.info(`Entered email address --> ${username}`);
        I.fillField(I.getElement(iLogin.PASSWORD_TEXTBOX), password);
        logger.info(`Entered password --> ${password}`);
        I.click(I.getElement(iLogin.LOGIN_BUTTON));
        logger.info("Clicked on Login button");
        I.click(I.getElement(iLogin.MENU_PAGE));
        logger.info("Clicked on Menu Buttton")
        I.click(I.getElement(iLogin.MENU_iREQUEST));
        logger.info("Successfully on iRequest Page")
    }

}