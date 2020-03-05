const { I } = inject();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
const iInvoiceHome = require("../../../eInvoice/pages/Invoice/IinvoiceHome");
const iCreditMemoHome = require("./IcreditMemoHome");

module.exports = {
    filterByStatus(status) {
        I.click(I.getElement(iInvoiceHome.statusFilterIcon));
        I.fillField(I.getElement(iInvoiceHome.searchField), status);
        I.click(`//dew-popover-body//label[contains(text(),"${status}")]`);
        I.click(I.getElement(iInvoiceHome.applyBtn));
        logger.info("Searched status :" + status);
    },
    filterByCreditMemoNumber(creditMemoNumber) {
        I.click(I.getElement(iCreditMemoHome.cmFilterIcon));
        I.fillField(I.getElement(iInvoiceHome.searchField), creditMemoNumber);
        I.click(I.getElement(iInvoiceHome.applyBtn));
        logger.info("Searched credit memo :"+creditMemoNumber);
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