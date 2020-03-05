const {I} = inject();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
const icustomize = require("./Icustomize");

module.exports = {

  invoicecustomize() {
    I.switchToNextTab();
    I.click(I.getElement(icustomize.customizebtn));
    I.click(I.getElement(icustomize.invoicebtn));
    logger.info("change the invoice setting");   
  },

  modifysettingyes() {
    if (I.seeCheckboxIsChecked(I.getElement(icustomize.attachmentsettingno))) {
      I.click(I.getElement(icustomize.attachmentsettingyes));
    } 
    I.click(I.getElement(icustomize.savebutton));
    logger.info("Attachment settings set to yes");   
  },

  modifysettingno() {
    if (I.seeCheckboxIsChecked(I.getElement(icustomize.attachmentsettingyes))) {
      I.click(I.getElement(icustomize.attachmentsettingno));
    } 
    I.click(I.getElement(icustomize.savebutton));
    logger.info("Attachment settings to no");   
  },
  verifysettingyes() {
    I.seeCheckboxIsChecked(I.getElement(icustomize.attachmentsettingyes));
    logger.info("Attachment settings is yes");   
  },
  verifysettingno() {
    I.seeCheckboxIsChecked(I.getElement(icustomize.attachmentsettingno));
    logger.info("Attachment settings is no");   
  },

  matchingsetting() {
    I.click(I.getElement(icustomize.matchingsetting));
    if (I.seeCheckboxIsChecked(I.getElement(icustomize.eNonPosubmittedsetting))) {
      I.click(I.getElement(icustomize.savebutton));
    } else {
      I.checkOption(I.getElement(icustomize.eNonPosubmittedsetting));
      I.click(I.getElement(icustomize.savebutton));
    } 
    logger.info("changed the matching setting");
  },

  Checkmatchingsetting() {
    I.click(I.getElement(icustomize.matchingsetting));
    I.seeCheckboxIsChecked(I.getElement(icustomize.eNonPosubmittedsetting));
    logger.info("matching setting is enabled");
  },

}