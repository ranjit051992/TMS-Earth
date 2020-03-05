const {I} = inject();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
const iCOATenant = require("./ICOATenant");
const homePage = require("../../../eInvoice/pages/Home/homePage");

module.exports = {
  costbookingnav() {
    I.switchToNextTab()
    I.click(I.getElement(iCOATenant.masterdata));
    logger.info("navigated to master data");
    I.click(I.getElement(iCOATenant.customize));
    I.click(I.getElement(iCOATenant.costbookingTab));
  },

  linelevelcostSetting() {
    I.dontSee(I.getElement(iCOATenant.mutiCCsetting));
    logger.info("setting book cost at line level is disabled");

  },
  headerlevelcostSetting() {
    I.see(I.getElement(iCOATenant.headerlevelcostSetting));
    logger.info("setting header level cost Setting is persent");
  },
  eformlistingnavigation() {
    I.switchToPreviousTab
    homePage.selectModule('eInvoice','eForms');
    logger.info("setting header level cost Setting is persent");
  },
}