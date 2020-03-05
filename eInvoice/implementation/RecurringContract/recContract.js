const { I } = inject();
const homePage = require("../../../eInvoice/pages/Home/homePage");
const rCHomePage = require("../../../eInvoice/pages/RecurringContract/createRecurringContractPage");
const recurringContractHomePage = require("../../../eInvoice/pages/RecurringContract/recurringContractHomePage");

const commonElements = require("../../pages/Common/commonElements");
const createInvoicePage = require("../../pages/Invoice/createInvoicePage");

//Scenario:1

Given('I can see the list of eInvoice modules', function () {
    I.see('Recurring Contracts');
});

Then('I should be able to see the Recurring Contracts option in the list', function () {
    recurringContractHomePage.verifyModule();
});


//Scenario:2
Given('I select the required field to be shown on listing', function () {
    recurringContractHomePage.CustomizeOption('Type');
});

When('I applied the customized filter', function () {
    recurringContractHomePage.cliOnApplyBtn();
});

Then('I should able to see the customized list on the page', function () {
    I.dontSee('Type');
});

//Scenario:3
Given('I have access to given activity in TMS', function () {
    rCHomePage.contractCreation();
});
Then('I should see the list of recurring contracts in contracts listing', function () {
    rCHomePage.contractDetails();
});

//Scenario:4 Create Contract
Given('I navigated to creation page of manual contract', function () {
    rCHomePage.contractCreation();
});

When('I select the supplier, contract name, contract owner', function () {
    rCHomePage.selectSupplier('ZYCUS_EDIT');
    rCHomePage.selectContract('RMZ-RC02');
    rCHomePage.selectContractOwner('admin');
});

When('I added supplier details', function () {
    commonElements.selectAddress();
    commonElements.selectRemitToAddress();

});
When('I added contract details', function () {
    //commonElements.selectPurchaseType(global.testData.get("PURCHASE_TYPE"));
    rCHomePage.contractDetails('RMZ-201');
});
When('I added release schedule', function () {
    rCHomePage.releaseSchedule('1');
    I.wait(3);
});
When('I added line items', function () {
    createInvoicePage.clickOnAddItemsTab();
    I.wait(2);
    commonElements.addItem(I.getData("ITEM_NAME"),I.getData("CATEGORY"),I.getData("QTY_OR_AMT"),I.getData("UOM"),I.getData("PRICE"));
});
When('I provided cost booking information', function () {
    createInvoicePage.clickOnBillingAndCostBookingDetailsTab();
    commonElements.addCBL(I.getData("COMPANY"),I.getData("BUSINESS_UNIT"),I.getData("LOCATION"));
    commonElements.addCostBookingDetails(I.getData("BU"),I.getData("COST_CENTER"),I.getData("PERCENTAGE"));
    createInvoicePage.clickOnAddItemsTab();
    I.wait(2);
    commonElements.selectGLAccount(I.getData("GL_ACCOUNT"))
});

When('I submit the recurring contract', function () {
    commonElements.clickOnSubmitBtn();
    I.wait(2);
    createInvoicePage.clickOnSendForConfirmationBtn();
    I.wait(5);
   
});

Then('I should see that recurring contract is created successfully', function () {
    I.waitForElement('dew-listing',30);
    I.see('RMZ-RC01');
});












