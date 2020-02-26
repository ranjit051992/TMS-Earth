
const { I } = inject();
const logger = require("../Framework/FrameworkUtilities/Logger/logger");
const databaseOperations = require("../Framework/FrameworkUtilities/DatabaseOperations/databaseOperations");
const dbKeys = require("../Framework/FrameworkUtilities/DatabaseOperations/dbKeys");
const coe = require("../COE/COE");
const username = global.confi_prop.username;
const password = global.confi_prop.password;
let map = new Map();


Given('logged in to iContract with {string} and {string}',function (username1,pasword1) {
 

    logger.info(global.confi_prop.poListingUrl);
    I.amOnPage(global.confi_prop.url);
    logger.info("Enter Url");
    I.seeElement(global.uiElements.get(coe.EMAIL_ADDRESS_GHOST_TEXTBOX));
    logger.info("Navigated to login page");
    I.click(global.uiElements.get(coe.EMAIL_ADDRESS_GHOST_TEXTBOX));
    if(!username1 && !pasword1)
    {
    I.fillField(global.uiElements.get(coe.EMAIL_ADDRESS_TEXTBOX), username1);
    logger.info(`Entered email address --> ${username}`);
    I.click(global.uiElements.get(coe.PASSWORD_GHOST_TEXTBOX));
    I.fillField(global.uiElements.get(coe.PASSWORD_TEXTBOX), pasword1);
    logger.info(`Entered password --> ${password}`);
    I.click(global.uiElements.get(coe.LOGIN_BUTTON));
    logger.info("Clicked on Login button");
    }
    else{
        I.fillField(global.uiElements.get(coe.EMAIL_ADDRESS_TEXTBOX), username);
        logger.info(`Entered email address --> ${username}`);
        I.click(global.uiElements.get(coe.PASSWORD_GHOST_TEXTBOX));
        I.fillField(global.uiElements.get(coe.PASSWORD_TEXTBOX), password);
        logger.info(`Entered password --> ${password}`); 
        I.click(global.uiElements.get(coe.LOGIN_BUTTON));
        logger.info("Clicked on Login button");
    }
          
});