const { I } = inject();
const iApprovalObject = require("./ApprovalObject");
const prop = require("../../../Framework/PropertiesConfigurator");
const ApprovalImpl = require("./ApprovalImpl");
const lmtVar = require("../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp")
const commonKeywordImpl = require("../../commonKeywords/CommonComponent");
const poListingObject = require("../PO/PoListing/PoListingObject");



Given ("I am on requisition approval listing page", async function() {
    await I.amOnPage(prop.All_Approval_Listing);
    await I.seeElement(I.getElement(iApprovalObject.SEARCH_FIELD), prop.DEFAULT_MEDIUM_WAIT);
});

Given ("I have requisition In Approval status", async function() {
    //
    I.assertEqual(reqstatus,status);
});

When ("I search for that requisition name on approval listing", async function() {
    await I.click(I.getElement(iApprovalObject.SEARCH_FIELD));
    await commonKeywordImpl.searchDocOnListing(this.reqBO.reqNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
});


Then ("I see the same requester", () => {
    let name = ApprovalImpl.fetchRequesterNameOnReqApprovalListing();
    const user = global.confi_prop.username;
    user = user.substring(0,str.indexOf("@"));
    I.assertEqual(user,name);
});

Then ("I see the same Received on date", () => {
    let date = ApprovalImpl.fetchReceivedOnDateOnReqApprovalListing();
    let day = new Date().getDate();
    I.assertEqual(day,date);
});

Then ("I see the same Amount to be approved", () => {
    let amount = ApprovalImpl.fetchAmountToBeApprovedOnReqApprovalListing();
    //Use approved amount from create req flow
    //I.assertEqual(,amount);
});

Then ("I see the same status of Requisition", () => {
    let approvalStatus = ApprovalImpl.fetchReqStatusOnReqApprovalListing();
    //status capture from req listing
    //I.assertEqual(,status);
});

Given ("I am on PO approval listing page", async function() {
    await ApprovalImpl.navigateToApprovalListing();
    await ApprovalImpl.navigateToPOApprovalListingTab();
});

When ("I Approve 1 PO", async function() {
    let status = await ApprovalImpl.approveDoc(POArray[0].poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
    this.POArray[0].setStatus(status); 
});

When ("I Approve 2 POs", async function() {
    this.POArray = await ApprovalImpl.approveMultipleDocs(POArray[i].poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
});

Then ("I should be able to see the status of all POs as Approved", async function() {
    await ApprovalImpl.checkMultiplePOStatus();
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

Given ("I search for that PO name on PO approval listing", async function() {
    await I.click(I.getElement(iApprovalObject.SEARCH_FIELD));
    await commonKeywordImpl.searchDocOnListing(this.spo.poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
    I.waitForVisible(poListingObject.PO_NUMBER_LINK);
});

Then ("I see the same Buyer name displayed for the corresponding PO number", async function() {
    await I.waitForVisible(poListingObject.PO_NUMBER_LINK);
    let buyerName = await ApprovalImpl.fetchBuyerOnPoApprovalListing();
    I.assertEqual(buyerName, this.spo.buyer);
});

Then ("I see the same Received on date on PO Approval listing", async function() {
    await I.waitForVisible(poListingObject.PO_NUMBER_LINK);
    let date = await ApprovalImpl.fetchReceivedOnDateOnPOApprovalListing();
    let day = new Date().getDate();
    I.assertEqual(day, date);
});


