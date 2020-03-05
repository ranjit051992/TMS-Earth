const { I } = inject();
const prop = require("../../../Framework/PropertiesConfigurator");
const workflowPage = require("../../pages/Workflow/workflowPage");
const loginPage = require("../../pages/Login/loginPage");
const homePage = require("../../pages/Home/homePage");


//Scenario: create new process form by online editor
Given('I navigate to the new eForms online editor', function () {
});
When('I fill the online editor form', function () {
});
When('I submit the form', function () {
});
Then('I should be able to see the created eForms', function () {
});

//Scenario: update the process form
Given('I see the process eForm listing', function () {
});
When('I edit the eForm', function () {
});
Then('I should be able to see the updated values', function () {
});

//Scenario: delete the process form
Given('I see the process eForm listing', function () {
});
When('I delete the eForm', function () {
});
Then('I should not be able to see the deleted eForm', function () {
});

//Scenario: create & activate an eform for recurring by online editor
Given('I navigate to the new eForms online editor', function () {
});
When('I fill the online editor form', function () {
});
When('I publish the eform', function () {
});
Then('I should see the activated eform', function () {
});

//Scenario: create & activate an eform for recurring by file upload
Given('I navigate to the new eForms file upload', function () {
});
When('I import the eform file', function () {
});
Then('I should able to see the created eform', function () {
});

//Scenario: recurring contract creation with created eform
Given('I navigate to recurring contract creation page', function () {
});
Given('I create the recurring contract', function () {
});
When('I view the created recurring contract', function () {
});
Then('I should be able to view the eform field', function () {
});

//Scenario: filtering the created eform
Given('I navigate to the eform listing page', function () {
});
When('I filter the eForm', function () {
});
Then('I should able to see the filterd eForms', function () {
});