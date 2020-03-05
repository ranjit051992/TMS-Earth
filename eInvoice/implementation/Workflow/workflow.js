const { I } = inject();
const workflowPage = require("../../pages/Workflow/workflowPage");

//  Scenario: Activate the workflow
Given('I search the workflow', function () {
    workflowPage.searchWorkflow(global.testData.get("WF_NAME"));
});
When('I activate the workflow', function () {
    workflowPage.activateWorkflow(global.testData.get("WF_NAME"));
});
Then('I should be able to see the workflow as activated', function () {
    workflowPage.deactivatedWorkflow();
});

//Scenario: Deactivate the workflow
When('I deactivate the workflow', function () {
    workflowPage.deactivateWorkflow(global.testData.get("WF_NAME"));
});
Then('I should be able to see the workflow as deactivated', function () {
    workflowPage.ActivatedWorkflow();
});