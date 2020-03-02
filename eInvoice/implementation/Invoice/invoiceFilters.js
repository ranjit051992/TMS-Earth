const { I } = inject();
//const prop = require("../../../Framework/PropertiesConfigurator");
const invoiceHomePage = require("../../pages/Invoice/invoiceHomePage");
const prop = global.confi_prop;

Given('I search for a status', function () {
    invoiceHomePage.filterByStatus('Approved');
});

Given('I select it', function () {
    invoiceHomePage.selectStatus('Approved');
});

Then('I should be able to see the invoices with the desired status', function () {
    I.waitForElement("dew-listing", prop.DEFAULT_MEDIUM_WAIT);
    I.see('Approved');
});

When('I apply it', function () {
    invoiceHomePage.cliOnApplyBtn();
});

Then('I should be able to see the fitlered invoices', function () {
    I.waitForElement("dew-listing", prop.DEFAULT_MEDIUM_WAIT);
    I.see('Approved');
});

Given('I search for a invoice number', function () {
    invoiceHomePage.filterByInvoiceNumber(global.testData.get("INVOICE_NUMBER"));
});

Then('I should be able to see the invoice with the desired invoice number', function () {
    I.waitForElement("dew-listing", prop.DEFAULT_MEDIUM_WAIT);
    I.see(global.testData.get("INVOICE_NUMBER"));
});