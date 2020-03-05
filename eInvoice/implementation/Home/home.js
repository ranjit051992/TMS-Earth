const homePage = require("../../../eInvoice/pages/Home/homePage");

Given('I navigate to Invoice module', function () {
    homePage.selectModule('eInvoice','Invoices');
});

Given('I navigate to CreditMemo module', function () {
    homePage.selectModule('eInvoice','Credit Memos');
});