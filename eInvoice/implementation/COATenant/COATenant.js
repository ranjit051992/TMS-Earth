const { I } = inject();
const COATenantPage = require("../../../eInvoice/pages/COATenant/COATenantPage");
const loginPage = require("../../../eInvoice/pages/Login/loginPage");
const homePage = require("../../../eInvoice/pages/Home/homePage");


//Scenario: setting for header level coa split is present in CMD
Given('I navigate to the cost booking settings in master data', function () {
    COATenantPage.costbookingnav();
});
Then('I verify setting is present for header level coa split', function () {
    I.headerlevelcostSetting();
});

//Scenario: checking option for "book cost at line level"
When('I verify setting is enabled for header level COA split', function () {
    customize.linelevelcostSetting();
});
When('I navigate to the eform listing', function () {
    customize.invoicecustomize();
});
Then('I see the setting book cost at line level disabled', function () {
    customize.invoicecustomize();
});

//Scenario: header level sum up to the document total
Given('I navigate to the nonpo invoice creation', function () {
    customize.invoicecustomize();
});
Given('I fill the splits at header level', function () {
    customize.invoicecustomize();
});
Then('I find splits added at header level sum up to the document total', function () {
});

//Scenario: adding COA details using only account as split type
Given('I add COA details using only account as split type', function () {
    customize.invoicecustomize();
});
Given('I submit the invoice', function () {
    customize.invoicecustomize();
});

//Scenario: view the cost booking and accounting split information in the Cost Booking and Accounting Section
Then('I should be able to view the cost booking and accounting split information in the invoice', function () {
});