const {I} = inject();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
const ieforms = require("./IeForms");
const homePage = require("../Home/homePage");

module.exports = {
  eformonlineeditor() {
    I.switchToNextTab();
    I.click(I.getElement(ieforms.neweFormBtn));
    I.click(I.getElement(ieforms.onlineeditor));
    logger.info("navigated to eForm Online Editor form");
  },

  createnewformheaderlevel() {
    I.fillField(I.getElement(ieforms.formname));
    I.checkOption(I.getElement(ieforms.typeofform));
    I.selectOption(I.getElement(ieforms.typeofform),'EINVOICE')
    I.click(I.getElement(ieforms.selectou));
    I.click(I.getElement(ieforms.chooseou));
    I.click(I.getElement(ieforms.saveou));
    I.click(I.getElement(ieforms.saveandcontinue));
    logger.info("navigated to form fields");   
  },
  formfields() {
    I.click(I.getElement()ieforms.
    I.click(I.getElement(icustomize.savebutton));
    logger.info("Attachment settings to no");   
  },
  
}