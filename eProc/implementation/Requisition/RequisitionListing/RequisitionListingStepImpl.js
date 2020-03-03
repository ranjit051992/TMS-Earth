const {I} = inject();
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const prop = global.confi_prop;
const reqListingImpl = require("./RequisitionListingImpl");
const reqListingObject = require("./RequisitionListingObject");
const commonComponent = require("../../../commonKeywords/CommonComponent");
const lmtVar = require("../../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const checkoutObject = require("../Checkout/CheckoutObject");
const checkoutImpl =  require("../Checkout/CheckoutImpl");

Then("I should be able to view the actions for the draft requisition on Listing page", async function(){
    let verifyDraftReqActions = false;
    let primaryActionStatus = false;
    let secondaryActionStatus = false;
    
    reqListingImpl.navigateToRequisitionListing();

    this.reqNumber = await reqListingImpl.getRequisitionNumber(this.reqName);

    await reqListingImpl.searchRequisitionByReqNumber(this.reqNumber);

    let reqStatus = await reqListingImpl.getRequisitionStatus();
    
    if(reqStatus.toString().trim() === lmtVar.getLabel("DRAFT_STATUS"))
    {
        let primaryAction = await I.grabTextFrom(I.getElement(reqListingObject.EDIT_ACTION));

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

    await reqListingImpl.editAndUpdateDraftRequisition(this.reqNumber, this.reqBO);
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
    this.reqNo = await reqListingImpl.getRequisitionNumber(this.reqName);

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