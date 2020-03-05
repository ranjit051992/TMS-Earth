const { I } = inject();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
const iManageProfile = require("./ManageProfileObject");
const prop = global.confi_prop;

module.exports = {

    async UserLogo() {
        I.click(I.getElement(iManageProfile.USER_LOGO));
        logger.info("UserLogo is coming");

    },

    async ManageProfile() {
        I.waitForVisible(I.getElement(iManageProfile.MANAGE_PROFILE), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iManageProfile.MANAGE_PROFILE));
        logger.info("Successfully changed user details");

    },

    async SaveManageProfile() {
        I.waitForVisible(I.getElement(iManageProfile.SAVE_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iManageProfile.SAVE_BUTTON));
        logger.info("Saved UserDetails");



    },
    async CancelManageProfile() {
        I.waitForVisible(I.getElement(iManageProfile.CANCEL_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iManageProfile.CANCEL_BUTTON));
        logger.info("Cancelled the datas in user profile");


    },

    async Logout() {
        I.waitForVisible(I.getElement(iManageProfile.LOGOUT_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iManageProfile.LOGOUT_BUTTON));
        I.waitForVisible(I.getElement(iManageProfile.LOGOUT_YES_BTN), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iManageProfile.LOGOUT_YES_BTN));
        logger.info("Logged out successfully");

    },

    async LogoutValid() {
        let url = await I.grabCurrentUrl();
        console.log(`Current URL is [${url}]`);
        

    }
}