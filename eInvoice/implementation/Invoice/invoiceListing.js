const { I } = inject();
const invoiceHomePage = require("../../pages/Invoice/invoiceHomePage");

When('I am on the invoice listing page', function () {
    I.amOnPage('https://dewdrops-qcvw.zycus.net/einvoice/#/home/invoice/list');
});

Then('I should be able to view all the invoices', function () {
    I.seeElement('dew-listing');
});

When('I filter invoices', function () {
    invoiceHomePage.filterByStatus('Approved');
});