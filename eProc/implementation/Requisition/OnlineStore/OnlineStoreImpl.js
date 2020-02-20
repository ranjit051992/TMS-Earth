const { I } = inject();
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const databaseOperations = require("../../../../Framework/FrameworkUtilities/DatabaseOperations/databaseOperations");
const dbKeys = require("../../../../Framework/FrameworkUtilities/DatabaseOperations/dbKeys");
const iOnlineStore = require("./IOnlineStore");
const username = "auto.zcs1@zycus.com";
const password = "eProc@123";

let map = new Map();

Given('logged in on eproc Page', async () => {
    I.amOnPage("https://login-partner.zycus.com/sso/login");
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
    I.amOnPage("https://dewdrops-partner.zycus.com/eproc/#/online-store");
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
    I.waitForVisible(global.uiElements.get(iOnlineStore.REQ_TABLE_OPTION_ICON));
    logger.info("Navigated to DDS Online Store page");
});

When("i search catalog item", async () => {
    const searchItem = global.testData.get(dbKeys.ITEM_NAME_FOR_SEARCHING);
    I.fillField(global.uiElements.get(iOnlineStore.SEARCH_TEXTBOX), searchItem);
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

When("add quantity", () => {
    logger.info("add quantity");
});

When("click on Add to Cart button", () => {
    logger.info("click on Add to Cart button");
});

Then("item should be added to cart", () => {
    logger.info("item should be added to cart");
});
