const {I} = inject();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
const iInvoiceHome = require("./IinvoiceHome");

module.exports = {

  clickOnAddInvoiceBtn() {
    I.click(I.getElement(iInvoiceHome.addInvoiceBtn));
  },

  saveView(viewName){
    I.click(I.getElement(iInvoiceHome.saveViewBtn));
    I.fillField(I.getElement(iInvoiceHome.viewNameField),viewName);
    I.click(I.getElement(iInvoiceHome.saveBtn));
  },
  deleteView(){
    I.click(I.getElement(iInvoiceHome.viewMenuBtn));
    I.click(I.getElement(iInvoiceHome.deleteViewBtn));
    I.click(I.getElement(iInvoiceHome.deleteBtn));
  },
  filterByStatus(status) {
    I.click(I.getElement(iInvoiceHome.statusFilterIcon));
    I.fillField(I.getElement(iInvoiceHome.searchField), status);
    I.click(`//dew-popover-body//label[contains(text(),"${status}")]`);
    I.click(I.getElement(iInvoiceHome.applyBtn));
    logger.info("Searched status :"+status);   
  },
  filterByInvoiceNumber(invoiceNumber) {
    I.click(I.getElement(iInvoiceHome.invoiceFilterIcon));
    I.fillField(I.getElement(iInvoiceHome.searchField), invoiceNumber);
    I.click(I.getElement(iInvoiceHome.applyBtn));
    logger.info("Searched invoice :"+invoiceNumber);
  },
  filterBySupplier(supplier) {
    I.click(I.getElement(iInvoiceHome.supplierFilterIcon));
    I.fillField(I.getElement(iInvoiceHome.searchField), supplier);
    I.click(`//dew-popover-body//label[contains(text(),"${supplier}")]`);
    I.click(I.getElement(iInvoiceHome.applyBtn));
    logger.info("Searched supplier :"+supplier);   
  },
  filterByReferenceNumber(referenceNumber) {
    I.click(I.getElement(iInvoiceHome.referenceNumFilterIcon));
    I.fillField(I.getElement(iInvoiceHome.referenceNumSearchField), referenceNumber);
    I.click(I.getElement(iInvoiceHome.applyBtn));
    logger.info("Searched referenceNumber :"+referenceNumber);
  },
}