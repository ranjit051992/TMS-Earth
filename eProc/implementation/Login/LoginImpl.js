
const { I } = inject();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
const iLogin = require("./LoginObject");
const onlinestore = require("../Requisition/OnlineStore/OnlineStoreImpl");
const prop = global.confi_prop;
const commonKeywordImpl = require("../../commonKeywords/CommonComponent");

module.exports = {

    async login()
    {
        logger.info(global.confi_prop.url);
        I.amOnPage(global.confi_prop.url);
        I.seeElement(I.getElement(iLogin.EMAIL_ADDRESS_GHOST_TEXTBOX));
        logger.info("Navigated to login page");
        I.click(I.getElement(iLogin.EMAIL_ADDRESS_GHOST_TEXTBOX));
        I.fillField(I.getElement(iLogin.EMAIL_ADDRESS_TEXTBOX), global.users.get("USERNAME"));
        logger.info(`Entered email address --> ${global.users.get("USERNAME")}`);
        I.click(I.getElement(iLogin.PASSWORD_GHOST_TEXTBOX));
        I.fillField(I.getElement(iLogin.PASSWORD_TEXTBOX), global.users.get("PASSWORD"));
        logger.info(`Entered password --> ${global.users.get("PASSWORD")}`);
        I.click(I.getElement(iLogin.LOGIN_BUTTON));
        logger.info("Clicked on Login button");
       // I.waitForVisible(I.getElement(iLogin.DDS_LOGIN_PAGE));

        I.amOnPage(global.confi_prop.DDS_OnlineStore_Url);
        I.waitForVisible(I.getElement(iLogin.REQ_TABLE_OPTION_ICON));
        logger.info("Navigated to DDS Online Store page");
        //onlinestore.waitForOnlineStoreToLoad();
    },
    async loginWithPasswordManager() {
        logger.info("Logging with password manager");
        await I.amOnPage(prop.PASSWORD_MANAGER_URL);
        await this.enterPmUsername("non_AD_user1");
        await this.enterPmPassword("Password@234");
        await this.selectPmLogOnto("Local Authentication");
        await this.clickOnPmLoginButton();
        await this.clickOnPmSearchIcon();
        await this.filterByPmResourceName("CDK Global -(RM)");
        await this.filterByPmUserAccount("cdk.support@zycus.com");
        await I.wait(prop.DEFAULT_WAIT);
        let searchWindow = await I.grabCurrentWindowHandle();
        await this.clickOnPmOpenConnectionButton();
        await this.switchToNewWindow();
        await I.closeCurrentTab();
        await I.switchToWindow(searchWindow);
        await this.clickOnPmOpenConnectionButton();
        await this.switchToNewWindow();
        await I.amOnPage(global.confi_prop.DDS_OnlineStore_Url);
        logger.info("Navigated to DDS Online Store page");
        await onlinestore.waitForOnlineStoreToLoad();
        await I.waitForVisible(I.getElement(iLogin.REQ_TABLE_OPTION_ICON));
    },
    async enterPmUsername(username) {
        await I.waitForVisible(I.getElement(iLogin.USERNAME_TEXTBOX_PM));
        await I.click(I.getElement(iLogin.USERNAME_TEXTBOX_PM));
        await I.clearField(I.getElement(iLogin.USERNAME_TEXTBOX_PM));
        await I.fillField(I.getElement(iLogin.USERNAME_TEXTBOX_PM), username);
        logger.info("Entered PM username --> " + username);
    },
    async enterPmPassword(password) {
        await I.waitForVisible(I.getElement(iLogin.PASSWORD_TEXTBOX_PM));
        await I.click(I.getElement(iLogin.PASSWORD_TEXTBOX_PM));
        await I.clearField(I.getElement(iLogin.PASSWORD_TEXTBOX_PM));
        await I.fillField(I.getElement(iLogin.PASSWORD_TEXTBOX_PM), password);
        logger.info("Entered PM password");
    },
    async selectPmLogOnto(logOnto) {
        await I.waitForVisible(I.getElement(iLogin.LOG_ONTO_DROPDOWN_PM));
        await I.selectOption(I.getElement(iLogin.LOG_ONTO_DROPDOWN_PM), logOnto);
        logger.info(`Selected log onto --> ${logOnto}`);
    },
    async clickOnPmLoginButton() {
        await I.waitForVisible(I.getElement(iLogin.LOGIN_BUTTON_PM));
        await I.click(I.getElement(iLogin.LOGIN_BUTTON_PM));
        await I.waitForVisible(I.getElement(iLogin.SEARCH_BUTTON_PM));
        logger.info("Clicked on Login button");
    },
    async clickOnPmSearchIcon() {
        await I.waitForVisible(I.getElement(iLogin.SEARCH_BUTTON_PM));
        await I.click(I.getElement(iLogin.SEARCH_BUTTON_PM));
        await I.waitForVisible(I.getElement(iLogin.RESOURCE_NAME_FILTER_TEXTBOX_PM));
        logger.info("Clicked on Search icon");
    },
    async filterByPmResourceName(resourceName) {
        await I.waitForVisible(I.getElement(iLogin.RESOURCE_NAME_FILTER_TEXTBOX_PM));
        await I.click(I.getElement(iLogin.RESOURCE_NAME_FILTER_TEXTBOX_PM));
        await I.clearField(I.getElement(iLogin.RESOURCE_NAME_FILTER_TEXTBOX_PM));
        await I.fillField(I.getElement(iLogin.RESOURCE_NAME_FILTER_TEXTBOX_PM), resourceName);
        logger.info("Entered resource name filter --> " + resourceName);
    },
    async filterByPmUserAccount(userAccount) {
        await I.waitForVisible(I.getElement(iLogin.USER_ACCOUNT_FILTER_TEXTBOX_PM));
        await I.click(I.getElement(iLogin.USER_ACCOUNT_FILTER_TEXTBOX_PM));
        await I.clearField(I.getElement(iLogin.USER_ACCOUNT_FILTER_TEXTBOX_PM));
        await I.fillField(I.getElement(iLogin.USER_ACCOUNT_FILTER_TEXTBOX_PM), userAccount);
        await I.pressKey("Enter");
        let linkXpath = "//*[text()='" + userAccount + "']";
        await I.waitForVisible(linkXpath);
        await I.waitForClickable(linkXpath);
        logger.info("Searched with filter --> " + userAccount);
    },
    async clickOnPmOpenConnectionButton() {
        await I.waitForVisible(I.getElement(iLogin.OPEN_CONNECTION_BUTTON_PM));
        await I.click(I.getElement(iLogin.OPEN_CONNECTION_BUTTON_PM));
        logger.info("Clicked on Open connection button");
        await I.waitForVisible(I.getElement(iLogin.OPEN_URL_LINK_PM));
        await I.click(I.getElement(iLogin.OPEN_URL_LINK_PM));
        await I.wait(prop.DEFAULT_WAIT);
        logger.info("Clicked on Open URL in browser link");
    },
    async switchToNewWindow() {
        let windows = await I.grabAllWindowHandles();
        await I.switchToWindow(windows[1]);
        await I.wait(prop.DEFAULT_WAIT);
        logger.info("Switched to new window");
        return windows[1];
    }

}