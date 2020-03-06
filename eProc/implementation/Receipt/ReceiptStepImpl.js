const { I } = inject();
const iSpoObject = require("../PO/Spo/SpoObject");
const iReceiptObject = require("./ReceiptObject");
const objectCreation = require("../../dataCreation/ObjectCreation")
const spoImpl = require("../PO/Spo/SpoImpl");
const receiptImpl = require("./ReceiptImpl");
const iLogin = require("../../implementation/Login/LoginImpl")
const prop = global.confi_prop;
const lmtVar = require("../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp")
const spo = require("../../dataCreation/bo/Spo")


//********************************Save a receipt as draft for SPO********************************
// Given("I navigate to PO listing", async function(){
//     await I.amOnPage(prop.poListingUrl)
//     await I.waitForInvisible(I.getElement(iSpoObject.spinner), prop.DEFAULT_MEDIUM_WAIT);
// });

// Given("I Create Standard po with {string} {string} item", async function (noOfItems, itemType){
//     this.spo = await objectCreation.getObjectOfStandardPO(noOfItems, itemType);
//     this.spo = await spoImpl.createSpoFlow(this.spo);
//  });

// Given("I have approved the PO to release it", async function()
// {
    
// });

When("I navigate to PO listing", async function(){
    await I.amOnPage(prop.poListingUrl)
    await I.waitForInvisible(global.uiElements.get(iSpoObject.spinner), prop.DEFAULT_MEDIUM_WAIT);
});

When("I search for the po", async function(){
    const poNumber = this.spo.poNumber;
    await receiptImpl.searchPONumber(poNumber);
});

When("I view the created PO", async function(){
    await receiptImpl.viewPO();
});

When("I navigate to Receipt tab", async function(){
    await receiptImpl.viewReceiptTab();
});


When("I click on Create receipt action", async function(){
    await receiptImpl.createReceipt();
});

When("I select the items at item level on receipt creation page", async function(){
    await receiptImpl.clickSelectionCheckbox();
});

When("I save the receipt as draft", async function(){
    await receiptImpl.clickSaveAsDraft();
});

Then("I should be able to see the status of reciept created as Draft", async function(){
    let status = await receiptImpl.fetchStatus();
    await I.assertEqual(status, lmtVar.getLabel("DRAFT_STATUS"));

});



// Given("I have submitted a Req-PO with a catalog item", async function () {

// });



//**************************Create receipt with partial items : SPO**************************

When("I update the quantity", async function(){
    await receiptImpl.updateReceivedQty();
});

When("I click on Create Receipt button", async function(){
    await receiptImpl.clickSubmitReceipt()
    await receiptImpl.clickConfirmation();
});

Then("I should be able to see the status of receipt as confirmed on Receipt Listing", async function(){
    let status = await receiptImpl.fetchStatus();
    I.assertEqual(status, lmtVar.getLabel("CONFIRMED_STATUS"));
});



// **************************Create receipt with partial items : Req to PO**************************

// Given("I have created a Req-PO with catalog item with 2 items", async function () {

// });

// **************************Save a return note as draft for SPO**************************

Given("I have created a Receipt", async function(){
    const poNumber = spo.poNumber;
    await  receiptImpl.createReceipt(poNumber);
});

When("I submit the receipt", async function(){
    await receiptImpl.clickSubmitReceipt();
    await receiptImpl.clickConfirmation();
});

// **************************Delete Receipt for SPO**************************

When("I delete the receipt in draft status from receipt listing page", async function(){
    await receiptImpl.clickDeleteAction();
    await receiptImpl.clickDeleteActionConfirmation();
});

Then("I should be able to delete the receipt in draft status", async function(){
    let noDataText = await receiptImpl.verifyNoDataAvailable();
    I.assertEqual(noDataText, lmtVar.getLabel("NO_DATA_AVAILABLE"));    
});

When("I have Receipt created", async function(){
    await receiptImpl.receiptCreation();
});
