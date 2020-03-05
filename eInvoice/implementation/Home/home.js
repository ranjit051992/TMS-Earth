const homePage = require("../../../eInvoice/pages/Home/homePage");

Given('I navigate to Invoice module', function () {
    homePage.selectModule('eInvoice','Invoices');
});

Given('I navigate to CreditMemo module', function () {
    homePage.selectModule('eInvoice','Credit Memos');
});
Given('I navigate to setup module', function () {
    homePage.selectModule('eInvoice','Setup');
});
Given('I navigate to TMS', function () {
    homePage.selectModule('TMS','');
});
Given('I navigate to workflow module', function () {
    homePage.selectModule('eInvoice','Workflow');
});
Given('I navigate to workflow module', function () {
    homePage.selectModule('eInvoice','eForm');
});
