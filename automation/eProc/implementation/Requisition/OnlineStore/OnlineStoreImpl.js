const { I } = inject();
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const dataMap = require("../../../../Framework/FrameworkUtilities/DatabaseOperations/databaseOperations");
const dbKeys = require("../../../../Framework/FrameworkUtilities/DatabaseOperations/dbKeys");
const iOnlineStore = require("./IOnlineStore");

const username = "auto.zcs1@zycus.com";
const password = "eProc@123";

let map = new Map();

Given('logged in on eproc Page', async () => {
    I.amOnPage("https://login-partner.zycus.com/sso/login");
    I.seeElement(iOnlineStore.emailAddressGhostTextbox);
    logger.info("Navigated to login page");
    I.click(iOnlineStore.emailAddressGhostTextbox);
    I.fillField(iOnlineStore.emailAddressTextbox, username);
    logger.info(`Entered email address --> ${username}`);
    I.click(iOnlineStore.passwordGhostTextbox);
    I.fillField(iOnlineStore.passwordTextbox, password);
    logger.info(`Entered password --> ${password}`);
    I.click(iOnlineStore.loginButton);
    logger.info("Clicked on Login button");
    I.waitForVisible(iOnlineStore.ddsLoginPage);
    I.amOnPage("https://dewdrops-partner.zycus.com/eproc/#/online-store");
    I.waitForVisible(iOnlineStore.ddsOnlineStorePageReqTableOptionIcon);
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

Given("i am on Online Store page", () => {
    I.waitForVisible(iOnlineStore.ddsOnlineStorePageReqTableOptionIcon);
    logger.info("Navigated to DDS Online Store page");
});

When("i search catalog item", async () => {
    map = await dataMap.getTestData();
    logger.info(`Data map size in onlineStore.js file --> ${map.size}`);
    const searchItem = map.get(dbKeys.ITEM_NAME_FOR_SEARCHING);
    I.fillField(iOnlineStore.searchTextbox, searchItem);
    logger.info(`Entered search text --> ${searchItem}`);
    I.pressKey("Enter");
    logger.info("Pressed Enter on search textbox");
});

Then("results for catalog item are displayed", () => {
    const searchItem = map.get(dbKeys.ITEM_NAME_FOR_SEARCHING);
    let searchResultXpath = `//eproc-product-list//span[contains(text(),'${searchItem}')]`;
    I.waitForInvisible(searchResultXpath);
    logger.info(`Search results displayed for --> ${searchItem}`);
});