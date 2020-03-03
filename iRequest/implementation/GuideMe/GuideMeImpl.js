const { I } = inject();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
const iGuideMe = require("./GuideMeObject");
const prop = global.confi_prop;


module.exports = {

    async MyReqNav() {
        I.click(I.getElement(iGuideMe.MY_REQ_NAV));
        logger.info("Successfully on MyRequest Listing");

    },

    async AccessGuideMe() {
        I.waitForVisible(I.getElement(iGuideMe.GUIDE_ME), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iGuideMe.GUIDE_ME));
        logger.info("Successfully aceessing GuideMe");
        I.click(I.getElement(iGuideMe.START_BTN));
        logger.info("Lets get started with GuideMe");
    },

    async ProcessGuideMe() {
        I.waitForVisible(I.getElement(iGuideMe.GENERIC_RADIO_BTN), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iGuideMe.GENERIC_RADIO_BTN));
        logger.info("RequestType choosen");
        I.waitForVisible(I.getElement(iGuideMe.GENERIC_NEXT_BTN), prop.DEFAULT_HIGH_WAIT);
        I.click(I.getElement(iGuideMe.GENERIC_NEXT_BTN));
        I.waitForVisible(I.getElement(iGuideMe.GUIDE_ME), prop.DEFAULT_HIGH_WAIT);
        I.click(I.getElement(iGuideMe.HR_BTN));
        I.waitForVisible(I.getElement(iGuideMe.HR_BTN), prop.DEFAULT_HIGH_WAIT);
        I.click(I.getElement(iGuideMe.HR_NEXT_BTN));
        I.waitForVisible(I.getElement(iGuideMe.HR_BTN), prop.DEFAULT_LOW_WAIT);
        logger.info("GuideMe is working fine");


    },
    async MapGuideMe() {

    }
}