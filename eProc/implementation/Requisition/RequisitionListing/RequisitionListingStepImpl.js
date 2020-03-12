const {I} = inject();
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const prop = global.confi_prop;
const reqListingImpl = require("./RequisitionListingImpl");
const reqListingObject = require("./RequisitionListingObject");
const commonComponent = require("../../../commonKeywords/CommonComponent");
const lmtVar = require("../../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const checkoutObject = require("../Checkout/CheckoutObject");
const checkoutImpl =  require("../Checkout/CheckoutImpl");
const objectCreation = require("../../../dataCreation/ObjectCreation");

Then("I should be able to view the actions for the draft requisition on Listing page", async function(){
    let verifyDraftReqActions = false;
    let primaryActionStatus = false;
    let secondaryActionStatus = false;
    
    reqListingImpl.navigateToRequisitionListing();

    this.reqNumber = await reqListingImpl.getRequisitionNumber(this.reqBO.reqName);

    await reqListingImpl.searchRequisitionByReqNumber(this.reqNumber);

    let reqStatus = await reqListingImpl.getRequisitionStatus();
    
    if(reqStatus.toString().trim() === lmtVar.getLabel("DRAFT_STATUS"))
    {
        let primaryAction = await I.grabTextFrom(I.getElement(reqListingObject.EDIT_ACTION));
        //let primaryAction = await commonComponent.getValueForColumnName(lmtVar.getLabel("ACTIONS_COLUMN"));
        if(primaryAction.toString() === lmtVar.getLabel("EDIT_ACTION"))
        {
            primaryActionStatus = true;
            logger.info("Draft Requiistion has primary action as---> "+primaryAction);
        }
    
        await commonComponent.clickOnActionMenuIcon();

        let actionOptions = await commonComponent.getActionMenuOptions();
        if(actionOptions.toString().includes(lmtVar.getLabel("DELETE_ACTION")))
        {
            secondaryActionStatus = true;
            logger.info("Draft Requiistion has secondary action as---> "+actionOptions);
        }
    }

    verifyDraftReqActions = (primaryActionStatus && secondaryActionStatus);    
    I.assertEqual(verifyDraftReqActions, true);
});

Then("I should be able to Edit and submit the Draft requisition", async function(){
    let editDraftReq = false;
    await checkoutImpl.editAndUpdateDraftRequisition(this.reqNumber, this.reqBO);
    await reqListingImpl.navigateToRequisitionListing();
    await reqListingImpl.searchRequisitionByReqNumber(this.reqNumber);

    let reqStatus = await reqListingImpl.getRequisitionStatus();

    if(reqStatus.toString().trim() === lmtVar.getLabel("DRAFT_STATUS"))
    {
        editDraftReq = true;
        logger.info("Updated Draft Requisition")
    }

    I.assertEqual(editDraftReq, true);
    
});


Then("I should be able to delete the requisition", async function(){
    let isReqDeleted = false;
    await reqListingImpl.deleteRequisition(this.reqNumber);
    isReqDeleted = await commonComponent.isElementPresent(I.getElement(reqListingObject.NO_RECORDS_FOUND));
    logger.info("Deleted Draft Requisition Successfully")
   
    I.assertEqual(isReqDeleted, true);
});

Then("I should be able see the status of requisition on the Listing page", async function(){

    let verifyReqStatus = false;

    await reqListingImpl.navigateToRequisitionListing();
    this.reqNo = await reqListingImpl.getRequisitionNumber(this.reqBO.reqName);

    await reqListingImpl.searchRequisitionByReqNumber(this.reqNo);

    let reqStatus = await reqListingImpl.getRequisitionStatus();

    if(reqStatus.toString().trim().includes(lmtVar.getLabel("IN_APPROVAL_STATUS")))
    {
        verifyReqStatus = true;
        logger.info("Requisition status is---> "+reqStatus);
    }

    I.assertEqual(verifyReqStatus, true);
});

When("I copy that requisition", async function(){
    await reqListingImpl.navigateToRequisitionListing();

    this.reqNumber = await reqListingImpl.getRequisitionNumber(this.reqBO.reqName);

    await reqListingImpl.copyRequisition(this.reqNumber);
    logger.info(`Requisition ${this.reqNumber} is Copied Successfully`);
});


Given("I have created a req to PO with PO in In Approval status", async function() {
    this.reqBO = await objectCreation.getObjectOfRequisition(1, "ITEM_NAME_FOR_SEARCHING");
    this.reqBO.approvePoFlag = false;
    this.reqBO = await checkoutImpl.createReqToPoFlow(this.reqBO);
 });

Given("I have created a requisition with {int} {string} and not converted it to PO", async function(noOfItems,itemType) {
    this.reqBO = await objectCreation.getObjectOfRequisition(noOfItems, itemType);
    this.reqBO.convertToPoFlag = false;
    // this.reqBO.reqName = "Automation_Req63021";
    // this.reqBO.reqNumber = "48160000";
    this.reqBO = await checkoutImpl.createReqToPoFlow(this.reqBO);
 });

 Given("I have created a requisition with that PO linked and with {int} {string}", async function(noOfItems, itemType) {
    // this.reqBO = await objectCreation.getObjectOfRequisition(1, "ITEM_NAME_FOR_SEARCHING");
    // this.reqBO.poNumber = "blue sanity -/2607";
    logger.info(`PO number of previous req --> ${this.reqBO.poNumber}`);
    this.reqBO1 = await objectCreation.getObjectOfRequisition(noOfItems, itemType);
    this.reqBO1.linkedPoNumber = this.reqBO.poNumber;
    this.reqBO = await checkoutImpl.createRequisitionFlow(this.reqBO1);
 });

 Given("I navigate to req listing", async function() {
    await reqListingImpl.navigateToRequisitionListing();
 });

 Given("I search for the created req on req listing", async function() {
    await commonComponent.searchDocOnListing(this.reqBO.reqName, lmtVar.getLabel("SEARCH_BY_DOC_NAME_OR_DESCRIPTION"));
 });

 Given("I fetch the req status on req listing", async function() {
    this.reqBO.status = await reqListingImpl.getRequisitionStatus();
 });

 Given("I fetch the req number on req listing", async function() {
    this.reqBO.reqNumber = await commonComponent.getDocNumber();
 });

When("I navigate to Requisition Listing page", async function(){
    await commonComponent.navigateToPage(lmtVar.getLabel("APPLICATION_NAME"), lmtVar.getLabel("REQUISITION_LISTING_PAGE"));
});

When("I close the requisition from actions",async function(){
    
});

