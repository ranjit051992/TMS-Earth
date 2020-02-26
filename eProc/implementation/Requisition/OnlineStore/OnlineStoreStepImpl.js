const { I } = inject();
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const databaseOperations = require("../../../../Framework/FrameworkUtilities/DatabaseOperations/databaseOperations");
const dbKeys = require("../../../../Framework/FrameworkUtilities/DatabaseOperations/dbKeys");
const iOnlineStore = require("./OnlineStoreObject");
const username = global.confi_prop.username;
const password = global.confi_prop.password;
const prop=require("../../../../Framework/PropertiesConfigurator");

let map = new Map();

Given("I am logged in eproc", async () => {
    logger.info(global.confi_prop.poListingUrl);
    I.amOnPage(global.confi_prop.url);
    I.seeElement(global.uiElements.get(iOnlineStore.EMAIL_ADDRESS_GHOST_TEXTBOX));
    logger.info("Navigated to login page");
    I.click(global.uiElements.get(iOnlineStore.EMAIL_ADDRESS_GHOST_TEXTBOX));
    I.fillField(global.uiElements.get(iOnlineStore.EMAIL_ADDRESS_TEXTBOX), username);
    logger.info(`Entered email address --> ${username}`);
    I.click(global.uiElements.get(iOnlineStore.PASSWORD_GHOST_TEXTBOX));
    I.fillField(global.uiElements.get(iOnlineStore.PASSWORD_TEXTBOX), password);
    logger.info(`Entered password --> ${password}`);
    I.click(global.uiElements.get(iOnlineStore.LOGIN_BUTTON));
    logger.info("Clicked on Login button");
    I.waitForVisible(global.uiElements.get(iOnlineStore.DDS_LOGIN_PAGE));
    I.amOnPage(global.confi_prop.DDS_OnlineStore_Url);
    I.waitForVisible(global.uiElements.get(iOnlineStore.REQ_TABLE_OPTION_ICON));
    logger.info("Navigated to DDS Online Store page");
});
Given(/^i am on login page "(.*?)"$/, (name) => {
    I.assertEqual(1, 1);
    console.log("hey " + name + " i am on login page");
});
Given(/^i am main page "(.*?)"$/, (name) => {
    I.assertEqual('given', 'given');
    console.log("hey " + name + " i am main page");
});
Given("i am on Online Store page", async () => {
    I.waitForVisible(global.uiElements.get(iOnlineStore.REQ_TABLE_OPTION_ICON),prop.DEFAULT_MEDIUM_WAIT);
    logger.info("Navigated to DDS Online Store page");
});
When(/^i search "(.*?)"$/, async (itemName) => {
    const searchItem = global.testData.get(itemName);
    I.fillField(global.uiElements.get(iOnlineStore.SEARCH_TEXTBOX), searchItem);
    I.waitForElement("//span[contains(text(),'"+searchItem+"')]",prop.DEFAULT_MEDIUM_WAIT);
    logger.info(`Entered search text --> ${searchItem}`);
    I.pressKey("Enter");
    logger.info("Pressed Enter on search textbox");
});
Then("results for catalog item are displayed", () => {
    const searchItem = global.testData.get(dbKeys.ITEM_NAME_FOR_SEARCHING);
    let searchResultXpath = `//eproc-product-list//span[contains(text(),'${searchItem}')]`;
    I.waitForVisible(searchResultXpath);
    logger.info(`Search results displayed for --> ${searchItem}`);
});
When("cart is empty", () => {
    logger.info("cart is empty");
});
When(/^add quantity "(.*?)"$/, (quantity) => {
    I.fillField(global.uiElements.get(iOnlineStore.QUANTITY_TEXTBOX),quantity);
    logger.info("added quantity : "+quantity);
});
When("click on Add to Cart button", () => {
    I.click(global.uiElements.get(iOnlineStore.ADD_TO_CART_BUTTON));
    logger.info("click on Add to Cart button");
});
Then("item should be added to cart", () => {
    I.waitForElement(global.uiElements.get(iOnlineStore.ADD_TO_CART_SUCCESS_MSG),prop.DEFAULT_MEDIUM_WAIT);
    logger.info("item is added to cart");
});
Then(/^item should have supplier "(.*?)"$/, async (supplier) => {
    const supplierName = global.testData.get(supplier);
   // let searchResultXpath = `//eproc-product-list//span[contains(text(),'${searchItem}')]`;
    let text = await I.grabTextFrom(global.uiElements.get(iOnlineStore.SUPPLIER_NAME));
    logger.info("Actual supplier name found : "+text.toUpperCase());
    let isPresent = false;
    if(text.toUpperCase() === supplierName)
    {
        isPresent = true;
    }
   
    I.assertEqual(true,isPresent);

   // logger.info(`Search results displayed for --> ${searchItem}`);
});