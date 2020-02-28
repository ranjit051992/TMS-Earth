const { I } = inject();
const prop = require("../../../Framework/PropertiesConfigurator");
const invoiceHomePage = require("../../../eInvoice/pages/Invoice/invoiceHomePage");
const loginPage = require("../../../eInvoice/pages/Login/loginPage");
const homePage = require("../../../eInvoice/pages/HomePage/homePage");

Given('User logged in to the application', function () {
    loginPage.login('poorva.qa2@zycus.com', 'Pass@123');
});

Given('User navigates to eInvoice module', function () {
    homePage.selectModule('Invoices');
});

Given('User search for a status', function () {
    invoiceHomePage.filterByStatus('Approved');
});

When('User applies it', function () {
    invoiceHomePage.cliOnApplyBtn();
});

Then('User should be able to see the fitlered invoices', function () {
    I.waitForElement("dew-listing", prop.DEFAULT_MEDIUM_WAIT);
    I.see('Approved');
});

Given('User search for a invoice number', function () {
    invoiceHomePage.filterByInvoiceNumber(global.testData.get("INVOICE_NUMBER"));
});

Then('User should be able to see the fitlered invoice', function () {
    I.waitForElement("dew-listing", 30);
    I.see(global.testData.get("INVOICE_NUMBER"));
});