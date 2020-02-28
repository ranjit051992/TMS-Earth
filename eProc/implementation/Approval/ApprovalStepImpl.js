const { I } = inject();
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const iApprovalObject = require("./ApprovalObject");
const prop = require("../../../../Framework/PropertiesConfigurator");
const objectCreation = require("../../../dataCreation/ObjectCreation");
const ApprovalImpl = require("./ApprovalImpl");
const catalogItem = require("../../../bo/CatalogItem");
const iConstants = require("../../../constants/iConstants");


Given ("I am on requisition approval listing page", () => {
    I.amOnPage(prop.All_Approval_Listing);
    I.waitForInvisible(global.uiElements.get(iApprovalObject.SEARCH_FIELD), prop.DEFAULT_MEDIUM_WAIT);
});

Given ("I have requisition In Approval status", () => {
    let reqstatus = //call method from requisition impl to get status of requisition from req listing
    let status = Approval.fetchReqStatus();
    I.assertEqual(reqstatus,status);
});

When ("I search for that requisition name on approval listing", () => {
    ApprovalImpl.searchDocOnListing(docDetail, searchBy)
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
    I.assertEqual(,amount);
});

Then ("I see the same status of Requisition", () => {
    let status = ApprovalImpl.fetchReqStatus();
    //status capture from req listing
    I.assertEqual(,status);
});

When ("I Approve 1 requisition", async function() {
    ApprovalImpl.clickOnSearchField();
    ApprovalImpl.fillReqNumber();    
    ApprovalImpl.searchReqNumber();
    
});
