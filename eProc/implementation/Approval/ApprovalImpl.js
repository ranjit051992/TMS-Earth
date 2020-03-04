const { I } = inject();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
// const iSpoObject = require("../PO/Spo/SpoObject");
const prop = global.confi_prop;
const lmtVar = require("../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const poListingObject = require("../PO/PoListing/PoListingObject");
const approvalObject = require("./ApprovalObject");
const commonKeywordImpl = require("../../commonKeywords/CommonComponent");
// const spoImpl = require("../../implementation/PO/Spo/SpoImpl");

module.exports = {
    async navigateToApprovalListing() {
        await I.amOnPage(prop.DDS_Approval_Listing);
        await I.waitForVisible(I.getElement(poListingObject.PO_NUMBER_LINK));
        logger.info("Navigated to approval listing page");
    },
    async clickOnApproveAction(){
        await I.waitForVisible(I.getElement(approvalObject.APPROVE_ACTION));
        await I.click(I.getElement(approvalObject.APPROVE_ACTION));
        logger.info("Clicked on Approve action");
    },
    async clickOnRejectAction(){
        await I.waitForVisible(I.getElement(approvalObject.REJECT_ACTION));
        await I.click(I.getElement(approvalObject.REJECT_ACTION));
        logger.info("Clicked on Reject action");
    },
    async fillApprovalComments(comments) {
        await I.waitForVisible(I.getElement(approvalObject.APPROVE_SPO_POPUP_COMMENT_TEXTAREA));
        await I.click(I.getElement(approvalObject.APPROVE_SPO_POPUP_COMMENT_TEXTAREA));
        await I.clearField(I.getElement(approvalObject.APPROVE_SPO_POPUP_COMMENT_TEXTAREA));
        await I.fillField(I.getElement(approvalObject.APPROVE_SPO_POPUP_COMMENT_TEXTAREA), comments);
        logger.info(`Entered approval comments --> ${comments}`);
    },
    async clickOnApproveSpoPopupApproveButton() {
        await I.waitForVisible(I.getElement(approvalObject.APPROVE_SPO_POPUP_APPROVE_BUTTON));
        await I.click(I.getElement(approvalObject.APPROVE_SPO_POPUP_APPROVE_BUTTON));
        logger.info("Clicked on Approve button");
    },
    async clickOnRejectSpoPopupRejectButton() {
        await I.waitForVisible(I.getElement(approvalObject.APPROVE_SPO_POPUP_APPROVE_BUTTON));
        await I.click(I.getElement(approvalObject.APPROVE_SPO_POPUP_APPROVE_BUTTON));
        logger.info("Clicked on Reject button");
    },
    async getSpoStatus() {
        let status = await I.grabTextFrom(I.getElement(approvalObject.APPROVAL_LISTING_SPO_STATUS));
        logger.info(`Retrieved status --> ${status}`);
        return status;
    },
    async approveDoc(docNumber, searchBy){
        await I.waitForVisible(I.getElement(poListingObject.PO_NUMBER_LINK));
        await commonKeywordImpl.searchDocOnListing(docNumber, searchBy);
        await this.clickOnApproveAction();
        await this.fillApprovalComments(lmtVar.getLabel("AUTO_GENERATED_COMMENT"));
        await this.clickOnApproveSpoPopupApproveButton();
        await I.waitForVisible(I.getElement(poListingObject.PO_NUMBER_LINK));
        await I.waitForClickable(I.getElement(poListingObject.PO_NUMBER_LINK));
        await commonKeywordImpl.searchDocOnListing(docNumber, searchBy);
        let status = await this.getSpoStatus();
        let flag = status === lmtVar.getLabel("APPROVED_STATUS")
        if(!flag) {
            logger.info(`Failed to approve spo because status is ${status} on Approval listing after approving`);
            throw new Error(`Failed to approve spo because status is ${status} on Approval listing after approving`);
        }
        else {
            logger.info("Spo is approved successfully");
        }
        return status;
    },

    async fetchRequesterNameOnReqApprovalListing() {
        I.waitForVisible(I.getElement(approvalObject.REQUESTER_NAME));
        let requester = await I.grabTextFrom(I.getElement(approvalObject.REQUESTER_NAME));
        logger.info("Requester name fetched from listing");
        return requester;
    },

    async fetchReceivedOnDateOnReqApprovalListing() {
        let date = await I.grabTextFrom(I.getElement(approvalObject.RECEIVED_ON));
        logger.info("Received on date fetched from listing");
        return date;
    },

    async fetchAmountToBeApprovedOnReqApprovalListing() {
        let amount = await I.grabTextFrom(I.getElement(approvalObject.AMOUNT_TO_BE_APPROVED));
        logger.info("Amount to be approved fetched from listing");
        return amount;
    },

    async fetchReqStatusOnReqApprovalListing() {
        let status = await I.grabTextFrom(I.getElement(approvalObject.STATUS));
        logger.info("Requisition status fetched from listing");
        return status;
    },

    async navigateToPOApprovalListingTab() {
        await I.waitForVisible(I.getElement(approvalObject.SPO_TAB));
        await I.waitForClickable(I.getElement(approvalObject.SPO_TAB));
        await I.click(I.getElement(approvalObject.SPO_TAB));
        await I.waitForVisible(I.getElement(poListingObject.PO_NUMBER_LINK));
        await I.waitForClickable(I.getElement(poListingObject.PO_NUMBER_LINK));
        logger.info("I am on PO approval listing");
    },

    async approveMultipleDocs(POArray, searchBy){
        for (let i=1; i<POArray.length; i++) {
            await commonKeywordImpl.searchDocOnListing(this.POArray[i].poNumber, searchBy);
            await I.executeScript(function() {
            document.getElementById("ApprovalSPOListing0").click();
            })
            await this.clearSearchField();
        } 
        await I.click(I.getElement(approvalObject.FOOTER_APPROVE_ACTION));
        for (let i=1; i<POArray.length; i++) {
            let status = await getSpoStatus();
            this.POArray[i].setStatus(status);
        } 
        return POArray;
    },

    async clearSearchField(){
        await I.click(I.getElement(approvalObject.CLEAR_SEARCH_FIELD));
    },

    async checkMultiplePOStatus() {
        for (let i=1; i<POArray.length; i++) {
            await commonKeywordImpl.searchDocOnListing(docNumber, searchBy);
            let POStatus = await I.grabTextFrom(I.getElement(approvalObject.APPROVAL_LISTING_SPO_STATUS));
            await I.assertEqual(POStatus, POArray[i].status);
            let flag = POStatus === POArray[i].status;
        if(!flag) {
            logger.info(`Failed to match the status of doc as ${POStatus} is different from ${POArray[i].status}`);
            throw new Error(`Failed to match the status of doc as ${POStatus} is different from ${POArray[i].status}`);
        }
        else {
            logger.info("Status of docs matched successfully");
        }
        }     
    },
    
    async rejectDoc(docNumber, searchBy){
        await I.waitForVisible(I.getElement(poListingObject.PO_NUMBER_LINK));
        await commonKeywordImpl.searchDocOnListing(docNumber, searchBy);
        await this.clickOnRejectAction();
        await this.fillApprovalComments(lmtVar.getLabel("AUTO_GENERATED_COMMENT"));
        await this.clickOnRejectSpoPopupRejectButton();
        await I.wait(prop.DEFAULT_WAIT);
        await I.waitForVisible(I.getElement(poListingObject.PO_NUMBER_LINK));
        await I.waitForClickable(I.getElement(poListingObject.PO_NUMBER_LINK));
        await commonKeywordImpl.searchDocOnListing(docNumber, searchBy);
        let status = await this.getSpoStatus();
        let flag = status === lmtVar.getLabel("REJECTED_STATUS")
        if(!flag) {
            logger.info(`Failed to reject spo because status is ${status} on Approval listing after rejecting`);
            throw new Error(`Failed to reject spo because status is ${status} on Approval listing after rejecting`);
        }
        else {
            logger.info("Spo is rejected successfully");
        }
        return status;
    },

    async rejectMultipleDocs(docNumber, searchBy){
        for (let i=1; i<POArray.length; i++) {
            await commonKeywordImpl.searchDocOnListing(docNumber, searchBy);
            await I.executeScript(function() {
            document.getElementById("ApprovalSPOListing0").click();
            })
            await this.clearSearchField();
        } 
        I.click(I.getElement(approvalObject.FOOTER_REJECT_ACTION));
        await this.fillApprovalComments(lmtVar.getLabel("AUTO_GENERATED_COMMENT"));
        for (let i=1; i<POArray.length; i++) {
            await commonKeywordImpl.searchDocOnListing(docNumber, searchBy);
            let status = await getSpoStatus();
            this.POArray[i].setStatus(status);
        } 
        return POArray;
    },

    async delegateDoc(docNumber, searchBy){
        await I.waitForVisible(I.getElement(poListingObject.PO_NUMBER_LINK));
        await commonKeywordImpl.searchDocOnListing(docNumber, searchBy);
        await commonKeywordImpl.clickOnActionMenuIcon();
        await commonKeywordImpl.clickOnActionMenuOption(lmtVar.getLabel("DELEGATE_ACTION"));
        await selectDelegateApprovalToUser(POArray[0].deliverTo);
        await this.fillReasonForDelegate(lmtVar.getLabel("AUTO_GENERATED_COMMENT"));
        await this.clickOnDelegateSpoPopupDelegateButton();
        await I.wait(prop.DEFAULT_WAIT);
        await I.waitForVisible(I.getElement(poListingObject.PO_NUMBER_LINK));
        await I.waitForClickable(I.getElement(poListingObject.PO_NUMBER_LINK));
        await commonKeywordImpl.searchDocOnListing(docNumber, searchBy);
        let status = await this.getSpoStatus();
        let flag = status === lmtVar.getLabel("DELEGATED_STATUS")
        if(!flag) {
            logger.info(`Failed to delegate spo because status is ${status} on Approval listing after delegation`);
            throw new Error(`Failed to delegate spo because status is ${status} on Approval listing after delegating`);
        }
        else {
            logger.info("Spo is delegated successfully");
        }
        return status;
    },

    async fillReasonForDelegate(comments) {
        await I.waitForVisible(I.getElement(approvalObject.DELEGATE_SPO_POPUP_REASON_TEXTBOX));
        await I.click(I.getElement(approvalObject.DELEGATE_SPO_POPUP_REASON_TEXTBOX));
        await I.clearField(I.getElement(approvalObject.DELEGATE_SPO_POPUP_REASON_TEXTBOX));
        await I.fillField(I.getElement(approvalObject.DELEGATE_SPO_POPUP_REASON_TEXTBOX), comments);
        logger.info(`Entered approval comments --> ${comments}`);

    },

    async clickOnDelegateSpoPopupDelegateButton() {
        await I.waitForVisible(I.getElement(approvalObject.DELEGATE_ACTION_POPUP_DELEGATE_BUTTON));
        await I.click(I.getElement(approvalObject.DELEGATE_ACTION_POPUP_DELEGATE_BUTTON));
        logger.info("Clicked on delegate button");
    },

    async selectDelegateApprovalToUser(approver) {
        await I.click(I.getElement(approvalObject.DELEGATE_APPROVAL_TO_USER));
        await I.clearField(I.getElement(approvalObject.DELEGATE_APPROVAL_TO_USER));
        await I.fillField(I.getElement(approvalObject.DELEGATE_APPROVAL_TO_USER), approver);
        await this.selectDelegateApprovalToOption(approver);
        approver = await I.grabAttributeFrom(I.getElement(approvalObject.DELEGATE_APPROVAL_TO_USER), "value");
        logger.info(`Selected deliverTo -->${approver}`);
        return approver;
    },

    async selectDelegateApprovalToOption(option) {
        let optionXpath = await `//span[contains(text(),'${option}')]`;
        await I.waitForVisible(optionXpath);
        await I.click(optionXpath);
        await logger.info(`Selected Delegate Approval To user --> ${option}`);
    },

    async delegateMultipleDocs(docNumber, searchBy){
        for (let i=1; i<POArray.length; i++) {
            await commonKeywordImpl.searchDocOnListing(docNumber, searchBy);
            await I.executeScript(function() {
            document.getElementById("ApprovalSPOListing0").click();
            })
            await this.clearSearchField();
        }
        await I.waitForVisible(I.getElement(approvalObject.FOOTER_DELEGATE_ACTION));
        await I.click(I.getElement(approvalObject.FOOTER_DELEGATE_ACTION));
        await selectDelegateApprovalToUser(POArray[i].deliverTo);
        await this.fillReasonForDelegate(lmtVar.getLabel("AUTO_GENERATED_COMMENT"));
        await this.clickOnDelegateSpoPopupDelegateButton();
        await I.wait(prop.DEFAULT_WAIT);
        for (let i=1; i<POArray.length; i++) {
            await commonKeywordImpl.searchDocOnListing(docNumber, searchBy);
            let status = await this.getSpoStatus();
            this.POArray[i].setStatus(status);
        } 
        return POArray;
    },

    async fetchBuyerOnPoApprovalListing(buyer) {
        let username = buyer.toString().substring(0,str.indexOf("@"));
        let buyerXpath = `//span[contains(text(),'${username}')]`;
        let buyerName = await I.grabTextFrom(buyerXpath);
        logger.info("Requester name fetched from listing");
        return buyerName;
    },

    async fetchReceivedOnDateOnPOApprovalListing() {
        let date = await I.grabTextFrom(I.getElement(approvalObject.RECEIVED_ON_SPO));
        logger.info("Received on date fetched from listing");
        return date;
    },

    async fetchAmountToBeApprovedOnPoApprovalListing() {
        let amount = await I.grabTextFrom(I.getElement(approvalObject.AMOUNT_TO_BE_APPROVED_SPO));
        logger.info("Amount to be approved fetched from listing");
        return amount;
    },

    async fetchPoStatusOnPoApprovalListing() {
        let status = await I.grabTextFrom(I.getElement(approvalObject.STATUS_SPO));
        logger.info("PO status fetched from listing");
        return status;
    },
}