const I = actor();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
const iInvoiceHome = require("./IinvoiceHome");

module.exports = {

  // clickOnAddInvoiceBtn() {
  //   I.click(global.uiElements.get(iInvoiceHome.addInvoiceBtn));
  // },

  filterByStatus(status) {
    I.click(global.uiElements.get(iInvoiceHome.statusFilterIcon));
    I.fillField(global.uiElements.get(iInvoiceHome.searchField), status);
    I.click(`//dew-popover-body//label[contains(text(),"${status}")]`);
    logger.info("Searched status :"+status);   
  },

  filterByInvoiceNumber(invoiceNumber) {
    I.click(global.uiElements.get(iInvoiceHome.invoiceFilterIcon));
    I.fillField(global.uiElements.get(iInvoiceHome.searchField), invoiceNumber);
    logger.info("Searched invoice :"+invoiceNumber);
  },

  cliOnApplyBtn(){
    I.click(global.uiElements.get(iInvoiceHome.applyBtn));
    logger.info("Clicked on Apply button");   
  },

}