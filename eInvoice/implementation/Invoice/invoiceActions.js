const { I } = inject();
//const prop = require("../../../Framework/PropertiesConfigurator");
const invoiceHomePage = require("../../pages/Invoice/invoiceHomePage");
const prop = global.confi_prop;
const customizeHomePage = require("../../../eInvoice/pages/Customize/customizeHomePage");

Given('I navigate to Setup Customize', function () {
    homePage.selectModule('eInvoice','Setup');

});

Given('I changed the settings for submitted invoice', function () {
    customizeHomePage.invoicecustomize();

});
When('I create an invoice', function () {
    invoiceHomePage.cliOnApplyBtn();
});

When('I confirm and match the invoice from actions in listing', function () {
    invoiceHomePage.cliOnApplyBtn();
});

Then('I should be able to see the status change of invoice from submitted to in approval on invoice listing', function () {
    I.waitForElement("dew-listing", prop.DEFAULT_MEDIUM_WAIT);
    I.see('Approved');
});