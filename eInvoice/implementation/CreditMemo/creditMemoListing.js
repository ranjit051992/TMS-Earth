const { I } = inject();
const invoiceHomePage = require("../../pages/Invoice/invoiceHomePage");

When('I am on the credit memo listing', function () {
    I.amOnPage('https://partner-zcs.zycus.com/einvoice/#/home/credit-memo/list');
});

Then('I should be able to view all the credit memos', function () {
    I.seeElement('dew-listing');
});

