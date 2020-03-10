const { I } = inject();
const iApprovalObject = require("./ApprovalObject");
const prop = global.confi_prop;
const ApprovalImpl = require("./ApprovalImpl");
const lmtVar = require("../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp")
const commonKeywordImpl = require("../../commonKeywords/CommonComponent");
const poListingObject = require("../PO/PoListing/PoListingObject");
const reqListingImpl = require("../Requisition/RequisitionListing/RequisitionListingImpl");
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");



Given ("I am on requisition approval listing page", async function() {
    await I.amOnPage(prop.DDS_Approval_Listing);
    await I.waitForVisible(I.getElement(iApprovalObject.SEARCH_FIELD), prop.DEFAULT_MEDIUM_WAIT);
});

Given ("I have requisition In Approval status", async function() {
    await I.amOnPage(prop.DDS_Requisition_Listing);
    await I.waitForVisible(I.getElement(iApprovalObject.SEARCH_FIELD));
    this.reqBO.reqNumber =  await reqListingImpl.getRequisitionNumber(this.reqBO.reqName);
    let reqStatus = await commonKeywordImpl.getValueForColumnName(lmtVar.getLabel("STATUS_COLUMN"))
    let flag = reqStatus.includes(lmtVar.getLabel("IN_APPROVAL_STATUS")) === true
        if(!flag) {
            logger.info(`Failed to get In Approval status`);
            throw new Error(`Failed to get In Approval status`);
        }
        else {
            logger.info("Requisition is in In Approval status");
        }
    logger.info("Status is In Approval");
});

When ("I search for that requisition name on approval listing", async function() {
    await commonKeywordImpl.searchDocOnListing(this.reqBO.reqNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
    logger.info("Searched with Requisition number");
});

Then ("I see the same requester", async function() {
    let requester = await ApprovalImpl.fetchRequesterNameOnReqApprovalListing();
    let user = this.reqBO.onBehalfOf.toString();
    //let user = "auto.zcs2@zycus.com";
    logger.info(`****${user}****`);
    let flag = user.includes(requester);
    logger.info(`substring****${user}****`);
    I.assertEqual(flag, true);

});

Then ("I see the same Received on date", async function() {
    let receivedOn = await ApprovalImpl.fetchReceivedOnDateOnReqApprovalListing();
    let reqDate = await new Date(receivedOn.toString()).toLocaleDateString(); 
    let sysDate = await new Date().toLocaleDateString();
    logger.info(`*****${reqDate === sysDate}*****`);
    I.assertEqual(reqDate, sysDate);
});

Then ("I see the same Amount to be approved", async function() {
    let amount = await ApprovalImpl.fetchAmountToBeApprovedOnReqApprovalListing();
    I.assertEqual(amount, this.reqBO.reqAmount.toString());
    // I.assertEqual(amount, "USD 375.00");
});

Then ("I see the same status of Requisition", async function() {
    let reqStatus = ApprovalImpl.fetchReqStatusOnReqApprovalListing();
    logger.info(`Status of requisition captured is ${reqStatus}`);
    I.assertEqual(lmtVar.getLabel("PENDING_STATUS"), (await reqStatus).toString());
});

Given ("I am on PO approval listing page", async function() {
    await ApprovalImpl.navigateToApprovalListing();
    await ApprovalImpl.navigateToPOApprovalListingTab();
});

When ("I Approve 1 PO", async function() {
    await ApprovalImpl.approveDoc(this.POArray[0].poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
    let status = await ApprovalImpl.checkPOApprovalStatus(this.POArray[0].poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
    this.POArray[0].setStatus(status); 
});

When ("I Approve 2 POs", async function() {
    this.POArray = await ApprovalImpl.approveMultiplePOs(this.POArray, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
});

Then ("I should be able to see the status of all POs as Approved", async function() {
    await ApprovalImpl.checkMultiplePOStatus(this.POArray, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
});

When ("I Reject 1 PO", async function() {
    await ApprovalImpl.rejectDoc(this.POArray[0].poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
    let status = await ApprovalImpl.checkPOApprovalStatus(this.POArray[0].poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
    this.POArray[0].setStatus(status);
});

When ("I Reject 2 POs", async function() {
    this.POArray = await ApprovalImpl.rejectMultipleDocs(this.POArray, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
});

Then ("I should be able to see the status of all POs as Rejected", async function() {
    await ApprovalImpl.checkMultiplePOStatus(POArray, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
});

When ("I Delegate 1 PO", async function() {
    let status = await ApprovalImpl.delegateDoc(this.POArray[0].poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"), this.POArray[0].newApprover);
    await this.POArray[0].setStatus(status);
});

When ("I Delegate 2 POs", async function() {
    this.POArray = await ApprovalImpl.delegateMultipleDocs(this.POArray, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
});

Then ("I should be able to see the status of all POs as Delegated", async function() {
    await ApprovalImpl.checkMultiplePOStatus();
});

When ("I search for that PO name on PO approval listing", async function() {
    await I.waitForVisible(I.getElement(iApprovalObject.SEARCH_FIELD));
    await commonKeywordImpl.searchDocOnListing(this.spo.poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
});

Then ("I see the same Buyer name displayed for the corresponding PO number", async function() {
    let buyer = this.spo.buyer.toString();
    logger.info(`Buyer name stored in BO is ---> ${buyer}`);
    let updatedBuyer = await ApprovalImpl.fetchBuyerOnPoApprovalListing(buyer);
    I.assertEqual(updatedBuyer, buyer.substring(0, buyer.indexOf("@")));
});

Then ("I see the same Received on date on PO Approval listing", async function() {
    let receivedOn = await ApprovalImpl.fetchReceivedOnDateOnPOApprovalListing();
    let PODate = await new Date(receivedOn.toString()).toLocaleDateString(); 
    let sysDate = await new Date().toLocaleDateString();
    logger.info(`*****${PODate === sysDate}*****`);
    I.assertEqual(PODate, sysDate);
});

Then ("I see the same Amount to be approved on PO Approval listing", async function() {
    let amount = await ApprovalImpl.fetchAmountToBeApprovedOnPoApprovalListing();
    let poTotal = await this.spo.PoAmount.toString();
    I.assertEqual(amount, poTotal);
});

Then ("I see the same status of SPO on PO Approval listing", async function() {
    let PoStatus = await ApprovalImpl.fetchPoStatusOnPoApprovalListing();
    I.assertEqual(PoStatus, lmtVar.getLabel("PENDING_STATUS"));
});

When ("I Approve 1 Requisition", async function() {
    await ApprovalImpl.approveDoc(reqArray[0].reqNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
    let status = await (lmtVar.getLabel("STATUS_COLUMN")).toString();
    I.assertEqual(status, lmtVar(getLabel("APPROVED_STATUS")));
});

When ("I Approve 2 Requisitions", async function() {
    this.reqArray = await ApprovalImpl.approveMultipleReqs(reqArray[i].reqNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
    logger.info("All Requisitions are in Approved status")
});

Then ("I should be able to see the status of all Requisitions as Approved", async function() {
    await ApprovalImpl.checkMultipleReqStatus(reqArray, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
});

When ("I Reject 1 Requisition", async function() {
    await ApprovalImpl.rejectDoc(reqArray[0].reqNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
    let status = await ApprovalImpl.checkReqStatus();
    I.assertEqual(status, lmtVar.getLabel("REJECTED_STATUS"));
});

When ("I Reject 2 Requisitions", async function() {
    this.reqArray = await ApprovalImpl.rejectMultipleReqs(reqArray[i].reqNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
    logger.info("All Requisitions are in Approved status")
});

Then ("I should be able to see the status of all Requisitions as Rejected", async function() {
    await ApprovalImpl.checkMultipleReqStatus(reqArray, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
});


When("I approve the requisition", async function(){
    await reqListingImpl.navigateToRequisitionListing();
    this.reqBO.reqNumber = await reqListingImpl.getRequisitionNumber(this.reqBO.reqName);
    logger.info(`Requisition Number is ---> ${this.reqBO.reqNumber}`);
    await ApprovalImpl.navigateToApprovalListing();
    await ApprovalImpl.approveDoc(this.reqBO.reqNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
    await I.wait(prop.DEFAULT_MEDIUM_WAIT);
    this.reqStatus = await ApprovalImpl.getReqStatus();
    
});