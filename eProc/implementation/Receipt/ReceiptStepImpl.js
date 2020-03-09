const { I } = inject();
const iSpoObject = require("../PO/Spo/SpoObject");
const iReceiptObject = require("./ReceiptObject");
const objectCreation = require("../../dataCreation/ObjectCreation")
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger")
const spoImpl = require("../PO/Spo/SpoImpl");
const receiptImpl = require("./ReceiptImpl");
const iLogin = require("../../implementation/Login/LoginImpl")
const prop = global.confi_prop;
const lmtVar = require("../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp")
const spo = require("../../dataCreation/bo/Spo")
const reqListingImpl = require("../Requisition/RequisitionListing/RequisitionListingImpl")
const req = require("../../dataCreation/bo/Requisition")
const approve = require("../Approval/ApprovalImpl")
const commonKeywordImpl = require("../../commonKeywords/CommonComponent")

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

When("I save the requisition", async function(){
    await reqListingImpl.navigateToRequisitionListing();
    let reqName = this.reqBO.reqName;
    logger.info("Requisition name " + reqName);
    this.reqNo= await reqListingImpl.getRequisitionNumber(reqName);
    logger.info("Requisition number: "+this.reqNo);
});

When("I have approved the requisition", async function(){
    await approve.navigateToApprovalListing();
    await approve.approveDoc(this.reqNo, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
    // await approve.checkPOApprovalStatus(this.reqNo, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
});

When("I search for the created Requisition", async function(){
    //await commonKeywordImpl.searchDocOnListing(this.reqNo, lmtVar.getLabel("SEARCH_BY_DOC_NAME_OR_DESCRIPTION"));
    await receiptImpl.searchRequisition(this.reqNo);
    let poNumber = await receiptImpl.getPoNumber();
    logger.info("PO number" +poNumber);
});

When("I approve the PO", async function(){
    await receiptImpl.releasePoFlow();
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
