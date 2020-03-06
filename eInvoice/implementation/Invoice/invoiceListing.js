const { I } = inject();
const invoiceHomePage = require("../../pages/Invoice/invoiceHomePage");

When('I am on the invoice listing page', function () {
    I.amOnPage('https://partner-zcs.zycus.com/einvoice/#/home/invoice/list');
});

Then('I should be able to view all the invoices', function () {
    I.seeElement('dew-listing');
});

Given('I filter invoices', function () {
    invoiceHomePage.filterByStatus('Approved');
});

When('I save view', function () {
    invoiceHomePage.saveView('Test view');
});

When('I should be able to save and see the desired invoices on invoice listing', function () {
    I.see('Test view');
    invoiceHomePage.deleteView();
});
