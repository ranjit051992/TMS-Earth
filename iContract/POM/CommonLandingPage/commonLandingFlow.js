const {I}=inject();
const commonLandingPageAction = require("./commonLandingAction")
const lmt = require("./../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp")
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger")
class commonLandingFlow{

    navigateToTab(applicationNameKey , tabKey , subtabKey){
        logger.info(tabKey);

        I.click(global.uiElements.get(commonLandingPageAction.HAMBURGER_MENU));
        I.seeElement(global.uiElements.get(commonLandingPageAction.SIDE_MENU_PANE));
        I.click(global.uiElements.get(commonLandingPageAction.APPLICATION_MENU).replace("<<applicationName>>",lmt.getLabel(applicationNameKey)));
        I.click(global.uiElements.get(commonLandingPageAction.MENU_LOCATOR).replace("<<menuName>>",lmt.getLabel(tabKey)))
        if(typeof subtabKey !== "undefined"){
        I.click(global.uiElements.get(commonLandingPageAction.MENU_LOCATOR).replace("<<subMenuName>>",lmt.getLabel(subtabKey)))
        }
    }

    navigateToTab(applicationNameKey , tabKey ){
        I.click(global.uiElements.get(commonLandingPageAction.HAMBURGER_MENU));
        I.seeElement(global.uiElements.get(commonLandingPageAction.SIDE_MENU_PANE));
        I.click(global.uiElements.get(commonLandingPageAction.APPLICATION_MENU).replace("<<applicationName>>",lmt.getLabel(applicationNameKey)));
        I.click(global.uiElements.get(commonLandingPageAction.MENU_LOCATOR).replace("<<menuName>>",lmt.getLabel(tabKey)));
    }
}

module.exports = new commonLandingFlow;