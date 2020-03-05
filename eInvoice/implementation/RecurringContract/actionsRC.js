const { I } = inject();
const homePage = require("../../../eInvoice/pages/Home/homePage");
const commonElements = require("../../pages/Common/commonElements");
const createInvoicePage = require("../../pages/Invoice/createInvoicePage");
const rCHomePage = require("../../../eInvoice/pages/RecurringContract/createRecurringContractPage");
const actionsRCPage = require("../../../eInvoice/pages/RecurringContract/recurringContractHomePage");

//This page contains actions, approval
//Scenario:5 To approve the Recurring Contract
Given('I created a recurring contract', function () {
    actionsRCPage.searchInApprovalContract('RMZ-RC01');
});

Given('I see that it is in approval state', function () {
    I.see('In approval');
});
When('I navigates to recurring contract approval listing', function () {
    homePage.selectModule('eInvoice','All Requests');
    actionsRCPage.allRequestsRC();
    actionsRCPage.searchActContract('RMZ-RC01');

});
When('I approve the recurring contract', function () {
    actionsRCPage.approveRecurringContract();
});
When('I navigates to recurring contract module', function () {
    homePage.selectModule('eInvoice','Recurring Contracts');
});
Then('I should be able to see recurring contract in approved state', function () {
    actionsRCPage.searchActContract('RMZ-RC01');
    I.wait();
    I.see('Approved');
});

//Scenario:6 Reject Recurring Contract
Given('I created a recurring contract', function () {
    actionsRCPage.searchInApprovalContract('DFGRTH');
});
Given('I see that it is in approval state', function () {
    I.see('In Approval','dew-listing');
});
When('I navigates to recurring contract approval listing', function () {
    homePage.selectModule('eInvoice','All Requests');
    actionsRCPage.allRequestsRC();
    actionsRCPage.searchActContract('DFGRTH');

});
When('I reject the recurring contract', function () {
    actionsRCPage.rejectRecurringContract();
});
When('I navigates to recurring contract module', function () {
    homePage.selectModule('eInvoice','Recurring Contracts');
});
Then('I should be able to see recurring contract in rejected state', function () {
    actionsRCPage.searchActContract('RMZ-RC01');
    I.wait(5);
    I.see('Approved');
});

//Scenario:7
Given('I have a activated recurring contract', function () {
    actionsRCPage.searchActContract('draft_edit');
});

When('I deactivate the contract from actions', function () {
    actionsRCPage.deactContract();
});

Then('I should be able to see the contract in deactivated state in listing', function () {
    I.see('Recurring Contract Deactivated Successfully');

});

//Scenario:8
Given('I have a deactivated recurring contract', function () {
    actionsRCPage.searchDeactContract('3d345');
});

When('I activate the recurring contract', function () {
    actionsRCPage.activateContract();
});

Then('I should be able to see the recurring contract in activated state', function () {
    I.see('Recurring Contract Activated Successfully');

});

//Scenario:9
Given('I have a rejected recurring contract', function () {
    actionsRCPage.searchRejectedContract('RC_31thJan');
    pause();
});

When('I edit the rejected contract after updating info', function () {
    actionsRCPage.editRejectedContract();
    
});

Then('I should be able to see that rejected recurring contract is edited successfully', function () {
    I.see('Recurring Contract Activated Successfully');
    commonElements.clickOnSubmitBtn();
    I.wait(2);
    createInvoicePage.clickOnSendForConfirmationBtn();
    I.wait(2);

});

//Scenario:10 -Utilized methods of Scenario:4
Given('I have a recurring contract', function () {
    actionsRCPage.searchDeactContract('gross_29_inv');
});
When('I create a new recurring contract with same name providing all details', function () {
    rCHomePage.contractCreation();
    rCHomePage.selectSupplier('ZYCUS SUPPLIER');
    rCHomePage.selectContract('gross_29_inv');
    rCHomePage.selectContractOwner('Admin');

});
Then('I should be thrown a validation message on submit for duplicate contract name', function () {
    I.see('Duplicate Contract Name');

});


//Scenario:11
Given('I have a recurring contract in listing', function () {
    actionsRCPage.searchDeactContract('RMZ-RC01');
});

When('I view the same recurring contract', function () {
    rCHomePage.viewContract();
});

Then('I should able to see the audit trail on bottom of the page', function () {
    I.see('Poorva');

});