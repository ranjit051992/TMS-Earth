const { I } = inject();
const customizePage = require("../../pages/Customize/customizePage");

//Scenario: modify configuration settings
Given('I navigate to customize', function () {
    customizePage.invoicecustomize();
});
When('I modify the settings for invoice', function () {
    customizePage.modifysettingyes();
});
Then('I should be able to see the updated configuration settings', function () {
    customizePage.verifysettingyes();
});

//Scenario: modify matching setting
When('I modify matching setting', function () {
    customizePage.matchingsetting();
});
Then('I should be able to see the updated matching setting', function () {
    customizePage.Checkmatchingsetting();
});

