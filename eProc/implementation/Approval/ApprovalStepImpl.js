const { I } = inject();
const iApprovalObject = require("./ApprovalObject");
const prop = global.confi_prop;
const ApprovalImpl = require("./ApprovalImpl");
const lmtVar = require("../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp")
const commonKeywordImpl = require("../../commonKeywords/CommonComponent");
const poListingObject = require("../PO/PoListing/PoListingObject");
const reqListingImpl = require("../Requisition/RequisitionListing/RequisitionListingImpl");



Given ("I am on requisition approval listing page", async function() {
    await I.amOnPage(prop.All_Approval_Listing);
    await I.waitForVisible(I.getElement(iApprovalObject.SEARCH_FIELD));
});

Given ("I have requisition In Approval status", async function() {
    await commonKeywordImpl.searchDocOnListing(this.reqBO.reqNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
    let reqStatus = await reqListingImpl.getRequisitionStatus();
    I.assertEqual(reqStatus, lmtVar.getLabel("IN_APPROVAL_STATUS"));
    logger.info("Status is In Approval");
});

When ("I search for that requisition name on approval listing", async function() {
    await commonKeywordImpl.searchDocOnListing(this.reqBO.reqNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
    logger.info("Searched with Requisition number");
});

Then ("I see the same requester", async function() {
    let requester = ApprovalImpl.fetchRequesterNameOnReqApprovalListing();
    let user = prop.username;
    user = user.substring(0,user.indexOf("@"));
    I.assertEqual(user, requester);
});

Then ("I see the same Received on date", async function() {
    let receivedOn = await ApprovalImpl.fetchReceivedOnDateOnReqApprovalListing();
    let reqDate = await new Date(receivedOn).toLocaleDateString(); 
    let sysDate = await new Date().toLocaleDateString();
    logger.info(`*****${reqDate === sysDate}*****`);
    I.assertEqual(reqDate, sysDate);
});

Then ("I see the same Amount to be approved", async function() {
    let amount = await ApprovalImpl.fetchAmountToBeApprovedOnReqApprovalListing();
    I.assertEqual(amount, this.reqBO.reqAmount);
});

Then ("I see the same status of Requisition", async function() {
    let reqStatus = ApprovalImpl.fetchReqStatusOnReqApprovalListing();
    logger.info(`Status of requisition captured is ${reqStatus}`);
    I.assertEqual(lmtVar.getLabel("PENDING_STATUS"), reqStatus);
});

Given ("I am on PO approval listing page", async function() {
    await ApprovalImpl.navigateToApprovalListing();
    await ApprovalImpl.navigateToPOApprovalListingTab();
});

When ("I Approve 1 PO", async function() {
    await ApprovalImpl.approveDoc(POArray[0].poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
    let status = await ApprovalImpl.checkPOApprovalStatus();
    this.POArray[0].setStatus(status); 
});

When ("I Approve 2 POs", async function() {
    this.POArray = await ApprovalImpl.approveMultiplePOs(POArray[i].poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
});

Then ("I should be able to see the status of all POs as Approved", async function() {
    await ApprovalImpl.checkMultiplePOStatus(reqArray, searchBy);
});

When ("I Reject 1 PO", async function() {
    let status = await ApprovalImpl.rejectDoc(POArray[0].poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
    this.POArray[0].setStatus(status);
});

When ("I Reject 2 POs", async function() {
    this.POArray = await ApprovalImpl.rejectMultipleDocs(POArray[i].poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
});

Then ("I should be able to see the status of all POs as Rejected", async function() {
    await ApprovalImpl.checkMultiplePOStatus();
});

When ("I Delegate 1 PO", async function() {
    let status = await ApprovalImpl.delegateDoc(POArray[0].poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
    await this.POArray[0].setStatus(status);
});

When ("I Delegate 2 POs", async function() {
    this.POArray = await ApprovalImpl.delegateMultipleDocs(POArray[i].poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
});

Then ("I should be able to see the status of all POs as Delegated", async function() {
    await ApprovalImpl.checkMultiplePOStatus();
});

When ("I search for that PO name on PO approval listing", async function() {
    await I.waitForVisible(I.getElement(iApprovalObject.SEARCH_FIELD));
    await commonKeywordImpl.searchDocOnListing(this.spo.poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
});

Then ("I see the same Buyer name displayed for the corresponding PO number", async function() {
    let buyerName = await ApprovalImpl.fetchBuyerOnPoApprovalListing(this.spo.buyer);
    I.assertEqual(buyerName, this.spo.buyer.toString().substring(0,9));
});

Then ("I see the same Received on date on PO Approval listing", async function() {
    let receivedOn = await ApprovalImpl.fetchReceivedOnDateOnPOApprovalListing();
    let day = new Date();
    let today = "0"+(day.getMonth()+1)+"/"+"0"+day.getDate()+"/"+day.getFullYear();
    I.assertEqual(today, receivedOn);
});

Then ("I see the same Amount to be approved on PO Approval listing", async function() {
    let amount = await ApprovalImpl.fetchAmountToBeApprovedOnPoApprovalListing();
    let poTotal = await this.spo.PoAmount;
    I.assertEqual(amount, poTotal);
});

Then ("I see the same status of SPO on PO Approval listing", async function() {
    let PoStatus = await ApprovalImpl.fetchPoStatusOnPoApprovalListing();
    I.assertEqual(PoStatus, lmtVar.getLabel("PENDING_STATUS"));
});

When ("I Approve 1 Requisition", async function() {
    await ApprovalImpl.approveDoc(reqArray[0].reqNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
    let status = await ApprovalImpl.checkApprovalStatus();
    this.reqArray[0].setStatus(status);
});

When ("I Approve 2 Requisitions", async function() {
    this.reqArray = await ApprovalImpl.approveMultipleReqs(reqArray[i].reqNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
});

Then ("I should be able to see the status of all Requisitions as Approved", async function() {
    await ApprovalImpl.checkMultipleReqStatus(reqArray, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
});
