const { I } = inject();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
const iApprovalObject = require("./ApprovalObject");
const prop = require("../../../Framework/PropertiesConfigurator");
const ApprovalImpl = require("./ApprovalImpl");
const lmtVar = require("../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp")


Given ("I am on requisition approval listing page", () => {
    I.amOnPage(prop.All_Approval_Listing);
    I.seeElement(I.getElement(iApprovalObject.SEARCH_FIELD), prop.DEFAULT_MEDIUM_WAIT);
});

Given ("I have requisition In Approval status", () => {
    //let reqstatus = //call method from requisition impl to get status of requisition from req listing
    let status = Approval.fetchReqStatus();
    I.assertEqual(reqstatus,status);
});

When ("I search for that requisition name on approval listing", () => {
    I.click(global.uiElements.get(iApprovalObject.SEARCH_FIELD));
    I.fillField(global.uiElements.get(iApprovalObject.SEARCH_FIELD));
    I.click(global.uiElements.get(iApprovalObject.SEARCH_BY_DOC_NAME));
});


Then ("I see the same requester", () => {
    let name = ApprovalImpl.fetchRequesterName();
    const user = global.confi_prop.username;
    user = user.substring(0,str.indexOf("@"));
    I.assertEqual(user,name);
});

Then ("I see the same Received on date", () => {
    let date = ApprovalImpl.fetchReceivedOnDate();
    let day = new Date().getDate();
    I.assertEqual(day,date);
});

Then ("I see the same Amount to be approved", () => {
    let amount = ApprovalImpl.fetchAmountToBeApproved();
    //Use approved amount from create req flow
    //I.assertEqual(,amount);
});

Then ("I see the same status of Requisition", () => {
    let status = ApprovalImpl.fetchReqStatus();
    //status capture from req listing
    //I.assertEqual(,status);
});

Given ("I am on PO approval listing page", async function() {
    await ApprovalImpl.navigateToApprovalListing();
    await ApprovalImpl.navigateToPOApprovalListingTab();
});

When ("I Approve 1 PO", async function() {
    let status = await ApprovalImpl.approveDoc(this.POArray[0].poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
    this.POArray[0].setStatus(status); 
});

When ("I Approve 2 POs", async function() {
    this.POArray = await ApprovalImpl.approveMultipleDocs(this.POArray, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
});

When ("I should be able to see the status of all POs as Approved", async function() {
    await ApprovalImpl.checkMultiplePOStatus();
});
