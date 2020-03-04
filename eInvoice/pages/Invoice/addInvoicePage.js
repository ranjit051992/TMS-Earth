const { I } = inject();
const iAddInvoice = require("./IaddInvoice");
module.exports = {

    selectNonPoInvoice() {    
        I.click(global.uiElements.get(iAddInvoice.nonPoInvoiceRadioBtn));
    },
    enterInvocieNumber(invoiceNumber) {
        I.fillField(global.uiElements.get(iAddInvoice.invoiceNumberField), invoiceNumber);
    },
    selectInvoiceDate() {
        I.click(global.uiElements.get(iAddInvoice.datePicker));
        I.click(global.uiElements.get(iAddInvoice.currentDate));
    },
   
}   