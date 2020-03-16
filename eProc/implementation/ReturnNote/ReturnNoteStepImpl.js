const { I } = inject();
const iSpoObject = require("../PO/Spo/SpoObject");
const iReceiptObject = require("../Receipt/ReceiptObject");
const iReturnNoteObject = require("./ReturnNoteObject");
const objectCreation = require("../../dataCreation/ObjectCreation")
const spoImpl = require("../PO/Spo/SpoImpl");
const receiptImpl = require("../Receipt/ReceiptImpl");
const returnNoteImpl = require("./ReturnNoteImpl");
const iLogin = require("../../implementation/Login/LoginImpl")
const prop = global.confi_prop;
const lmtVar = require("../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp")
const spo = require("../../dataCreation/bo/Spo")
const commonComponent =require("../../commonKeywords/CommonComponent")
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");

Given("I am logged in eproc", async function(){
    await iLogin.login();
});

Given("I navigate to PO listing", async function(){
    await I.amOnPage(prop.poListingUrl)
    await I.waitForInvisible(global.uiElements.get(iSpoObject.spinner), prop.DEFAULT_MEDIUM_WAIT);
});

Given("I Create Standard po with {string} {string} item", async function (noOfItems, itemType){
    this.spo = await objectCreation.getObjectOfStandardPO(noOfItems, itemType);
    this.spo = await spoImpl.createSpoFlow(this.spo);
 });

// Given("I have approved the PO to release it", async function()
// {
    
// });

When("I navigate to PO listing", async function(){
    await I.amOnPage(prop.poListingUrl)
    await I.waitForInvisible(global.uiElements.get(iSpoObject.spinner), prop.DEFAULT_MEDIUM_WAIT);
});

When("And I search for the created po", async function(){
    const poNumber = spo.poNumber;
    await receiptImpl.searchPONumber(poNumber);
});

When("I view the created PO", async function(){
    await receiptImpl.viewPO();
});

When("I create a receipt", async function(){
    await receiptImpl.receiptCreation();
});


When("I navigate to Receipt tab", async function(){
    await receiptImpl.viewReceiptTab();
});

When("I create a Receipt", async function(){
    await receiptImpl.createReceipt();
});


When("I click on the Create return note option", async function(){
    await returnNoteImpl.createReturnNote();
});

When("I select the items", async function(){
    await returnNoteImpl.selectItemReturnNote();
});

When("I enter quantity same as ordered quantity", async function(){
    await returnNoteImpl.addQuantity();
});

When("I enter Reason for Return", async function(){
    await returnNoteImpl.addReasonForReturn();
});

When("I enter Return Method", async function(){
    await returnNoteImpl.addReturnMethod();
});

When("I save the return note as draft", async function(){
    await returnNoteImpl.clickReturnNoteSaveAsDraft();
    //logged a bug to remove confirmation here 
});

Then("I should be able to see the return note in draft status", async function(){
    await returnNoteImpl.waitForReturnNoteCreation();
    let status = await receiptImpl.fetchStatus();
    await I.assertEqual(status, lmtVar.getLabel("DRAFT_STATUS"));
});

When("I submit the return note", async function(){
    await receiptImpl.clickSubmitReceipt();
    await receiptImpl.clickConfirmation();
});

Then("I should be able to see the return note created", async function(){
    await returnNoteImpl.waitForReturnNoteCreation();
    let returnStatus = await receiptImpl.fetchStatus();
    await I.assertEqual(returnStatus, lmtVar.getLabel("RETURNED_STATUS"));
});   


When("I delete the return note in draft status", async function(){
    this.returnNoteNumber = await returnNoteImpl.getReturnNoteNumber();
    await receiptImpl.clickDeleteAction();
    await receiptImpl.clickDeleteActionConfirmation();
});

Then("I should be able to delete the return note in draft state", async function(){
    await I.wait(prop.DEFAULT_HIGH_WAIT);
    let status = await commonComponent.waitForElementVisible(`//a[contains(text(),'${this.returnNoteNumber}')]`);
    await I.assertEqual(status, false);
});