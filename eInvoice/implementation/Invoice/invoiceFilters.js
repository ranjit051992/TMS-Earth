const { I } = inject();
//const prop = require("../../../Framework/PropertiesConfigurator");
const invoiceHomePage = require("../../pages/Invoice/invoiceHomePage");
const prop = global.confi_prop;

When('I filter invoice by status', function () {
    invoiceHomePage.filterByStatus('Approved');
});

Then('I should be able to see the invoices with the desired status', function () {
    I.waitForElement("dew-listing", prop.DEFAULT_MEDIUM_WAIT);
    I.see('Approved');
});

When('I filter invoice by invoice number', function () {
    invoiceHomePage.filterByInvoiceNumber(global.testData.get("INVOICE_NUMBER"));
});

Then('I should be able to see the invoice with the desired invoice number', function () {
    I.waitForElement("dew-listing", prop.DEFAULT_MEDIUM_WAIT);
    I.see(global.testData.get("INVOICE_NUMBER"));
});

When('I filter invoice by supplier', function () {
    invoiceHomePage.filterBySupplier('AUTOCOMPANY_699270');
});

Then('I should be able to see the invocies with the desired supplier', function () {
    I.waitForElement("dew-listing", prop.DEFAULT_MEDIUM_WAIT);
    I.see('AUTOCOMPANY_699270');
});

When('I filter invoice by reference number', function () {
    invoiceHomePage.filterByReferenceNumber('SRS_ZSN_TEST');
});

Then('I should be able to see the invoice with the desired reference number', function () {
    I.waitForElement("dew-listing", prop.DEFAULT_MEDIUM_WAIT);
    I.see('SRS_ZSN_TEST');
});