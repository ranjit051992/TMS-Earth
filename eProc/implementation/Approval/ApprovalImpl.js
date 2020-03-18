const { I } = inject();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
// const iSpoObject = require("../PO/Spo/SpoObject");
const prop = global.confi_prop;
const lmtVar = require("../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const poListingObject = require("../PO/PoListing/PoListingObject");
const approvalObject = require("./ApprovalObject");
const commonKeywordImpl = require("../../commonKeywords/CommonComponent");
const poListingImpl = require("../PO/PoListing/PoListingImpl");

module.exports = {
    async navigateToApprovalListing() {
        await I.amOnPage(prop.DDS_Approval_Listing);
      // await commonKeywordImpl.navigateToPage(lmtVar.getLabel("APPLICATION_NAME"), lmtVar.getLabel("APPROVAL_LISTING_PAGE"));
        await I.waitForVisible(I.getElement(poListingObject.PO_NUMBER_LINK));
        logger.info("Navigated to approval listing page");
        await commonKeywordImpl.selectValueFromDropDown(I.getElement(approvalObject.LISTING_SELECTION_DROP_DOWN), lmtVar.getLabel("LISTING_ALL_ITEMS_OPTION"));
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
        await I.waitForVisible(I.getElement(poListingObject.PO_NUMBER_LINK));
        await I.wait(prop.DEFAULT_HIGH_WAIT);
        logger.info("Clicked on Approve button");
    },
    async clickOnRejectSpoPopupRejectButton() {
        await I.waitForVisible(I.getElement(approvalObject.APPROVE_SPO_POPUP_APPROVE_BUTTON));
        await I.click(I.getElement(approvalObject.APPROVE_SPO_POPUP_APPROVE_BUTTON));
        logger.info("Clicked on Reject button");
    },
    async getSpoStatus() {
        let status = await commonKeywordImpl.getValueForColumnName(lmtVar.getLabel("STATUS_COLUMN"));
        logger.info(`Retrieved status --> ${status}`);
        return status;
    },
    async approveDoc(docNumber, searchBy){
        await I.wait(prop.DEFAULT_HIGH_WAIT);
        await I.waitForVisible(I.getElement(poListingObject.PO_NUMBER_LINK));
        await commonKeywordImpl.searchDocOnListing(docNumber, searchBy);
        await this.clickOnApproveAction();
        await this.fillApprovalComments(lmtVar.getLabel("AUTO_GENERATED_COMMENT"));
        await this.clickOnApproveSpoPopupApproveButton();
    },
    async checkPOApprovalStatus(docNumber, searchBy) {
        await I.waitForVisible(I.getElement(poListingObject.PO_NUMBER_LINK));
        await I.waitForClickable(I.getElement(poListingObject.PO_NUMBER_LINK));
        await commonKeywordImpl.searchDocOnListing(docNumber, searchBy);
        let status = await this.getSpoStatus();
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
        logger.info(`Received on date fetched from listing ${date}`);
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

    async approveMultiplePOs(POArray, searchBy){
        for (let i=1; i<POArray.length; i++) {
            await commonKeywordImpl.searchDocOnListing(POArray[i].poNumber, searchBy);
            await I.executeScript(function() {
            document.getElementById("ApprovalSPOListing0").click();
            })
            await this.clearSearchField();
        } 
        await I.click(I.getElement(approvalObject.FOOTER_APPROVE_ACTION));
        await this.fillApprovalComments(lmtVar.getLabel("AUTO_GENERATED_COMMENT"));
        await this.clickOnApproveSpoPopupApproveButton();
        for (let i=1; i<POArray.length; i++) {
            await commonKeywordImpl.searchDocOnListing(POArray[i].poNumber, searchBy);
            let status = await this.getSpoStatus();
            POArray[i].setStatus(status);
        } 
        return POArray;
    },

    async approveMultipleReqs(reqArray, searchBy){
        for (let i=1; i<reqArray.length; i++) {
            await commonKeywordImpl.searchDocOnListing(reqArray[i].reqNumber, searchBy);
            await I.executeScript(function() {
            document.getElementById("ApprovalReqListing0").click();
            })
        } 
        await I.waitForVisible(I.getElement(approvalObject.FOOTER_APPROVE_ACTION));
        await I.click(I.getElement(approvalObject.FOOTER_APPROVE_ACTION));
        await this.fillApprovalComments(lmtVar.getLabel("AUTO_GENERATED_COMMENT"));
        await this.clickOnApproveSpoPopupApproveButton();
        for (i=1; i<reqArray.length; i++)
        {   
            await commonKeywordImpl.searchDocOnListing(reqArray[i].reqNumber, searchBy);
            let status = await commonKeywordImpl.getValueForColumnName(lmtVar.getLabel("STATUS_COLUMN"));
            await reqArray[i].setStatus(status);
        }
        return reqArray;
    },

    async clearSearchField(){
        await I.click(I.getElement(approvalObject.CLEAR_SEARCH_FIELD));
    },

    async checkMultiplePOStatus(POArray, searchBy) {
        for (let i=1; i<POArray.length; i++) {
            await commonKeywordImpl.searchDocOnListing(POArray[i].poNumber, searchBy);
            let POStatus = await I.grabTextFrom(I.getElement(approvalObject.APPROVAL_LISTING_SPO_STATUS));
            await I.assertEqual(POStatus, POArray[i].status.toString());
            let flag = POStatus === POArray[i].status.toString();
        if(!flag) {
            logger.info(`Failed to match the status of doc as ${POStatus} is different from ${POArray[i].status}`);
            throw new Error(`Failed to match the status of doc as ${POStatus} is different from ${POArray[i].status}`);
        }
        else {
            logger.info("Status of docs matched successfully");
        }
        }     
    },

    async checkMultipleReqStatus(reqArray) {
        for (let i=0; i<reqArray.length; i++) {
            await commonKeywordImpl.searchDocOnListing(reqArray[i].reqNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
            let status = await commonKeywordImpl.getValueForColumnName(lmtVar.getLabel("STATUS_COLUMN"));
            await I.assertEqual(status.toString(), reqArray[i].status);
            let flag = status.toString() === reqArray[i].status;
        if(!flag) {
            logger.info(`Expected status is different from Actual i.e ${status.toString()}`);
            throw new Error(`Expected status is different from Actual i.e ${status.toString()}`);
        }
        else {
            logger.info(`Status of requisition is ${status.toString()}`);
        }
        }     
    },
    
    async rejectDoc(docNumber, searchBy){
        await I.waitForVisible(I.getElement(poListingObject.PO_NUMBER_LINK));
        await commonKeywordImpl.searchDocOnListing(docNumber, searchBy);
        await this.clickOnRejectAction();
        await this.fillApprovalComments(lmtVar.getLabel("AUTO_GENERATED_COMMENT"));
        await this.clickOnRejectSpoPopupRejectButton();
    },

    async checkReqStatus(docNumber, searchBy) {
        await I.waitForVisible(I.getElement(poListingObject.PO_NUMBER_LINK));
        await I.waitForClickable(I.getElement(poListingObject.PO_NUMBER_LINK));
        await commonKeywordImpl.searchDocOnListing(docNumber, searchBy);
        let status = await this.getReqStatus();
        let flag = status === lmtVar.getLabel("REJECTED_STATUS")
        if(!flag) {
            logger.info(`Failed to reject req because status is ${status} on Approval listing after rejecting`);
            throw new Error(`Failed to reject req because status is ${status} on Approval listing after rejecting`);
        }
        else {
            logger.info("Spo is rejected successfully");
        }
        return status;
    },

    async rejectMultipleDocs(POArray, searchBy){
        for (let i=1; i<POArray.length; i++) {
            await commonKeywordImpl.searchDocOnListing(POArray[i].poNumber, searchBy);
            await I.executeScript(function() {
            document.getElementById("ApprovalSPOListing0").click();
            })
            await this.clearSearchField();
        } 
        I.click(I.getElement(approvalObject.FOOTER_REJECT_ACTION));
        await this.fillApprovalComments(lmtVar.getLabel("AUTO_GENERATED_COMMENT"));
        await this.clickOnApproveSpoPopupApproveButton();
        for (let i=1; i<POArray.length; i++) {
            await commonKeywordImpl.searchDocOnListing(POArray[i].poNumber, searchBy);
            await I.waitForVisible(I.getElement(poListingObject.PO_NUMBER_LINK));
            let status = await this.getSpoStatus();
            POArray[i].setStatus(status);
        } 
        return POArray;
    },

    async delegateDoc(docNumber, searchBy, newApprover){
        await I.waitForVisible(I.getElement(poListingObject.PO_NUMBER_LINK));
        await commonKeywordImpl.searchDocOnListing(docNumber, searchBy);
        await commonKeywordImpl.clickOnActionMenuIcon();
        await commonKeywordImpl.clickOnActionMenuOption(lmtVar.getLabel("DELEGATE_ACTION"));
        await this.selectDelegateApprovalToUser(newApprover);
        await this.fillReasonForDelegate(lmtVar.getLabel("AUTO_GENERATED_COMMENT"));
        await this.clickOnDelegateSpoPopupDelegateButton();
        await I.waitForVisible(I.getElement(poListingObject.PO_NUMBER_LINK));
        await I.waitForClickable(I.getElement(poListingObject.PO_NUMBER_LINK));
        await commonKeywordImpl.searchDocOnListing(docNumber, searchBy);
        await I.waitForVisible(I.getElement(poListingObject.PO_NUMBER_LINK));
        let status = await this.getSpoStatus();
        let flag = status === lmtVar.getLabel("DELEGATED_STATUS")
        if(!flag) {
            logger.info(`Failed to delegate doc because status is ${status} on Approval listing after delegation`);
            throw new Error(`Failed to delegate doc because status is ${status} on Approval listing after delegating`);
        }
        else {
            logger.info("Document is delegated successfully");
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
        let optionXpath = await `//p[contains(text(),'${option}')]`;
        await I.waitForVisible(optionXpath);
        await I.click(optionXpath);
        await logger.info(`Selected Delegate Approval To user --> ${option}`);
    },

    async delegateMultipleDocs(POArray, searchBy){
        await I.waitForVisible(I.getElement(poListingObject.PO_NUMBER_LINK));
        for (let i=1; i<POArray.length; i++) {
            await commonKeywordImpl.searchDocOnListing(POArray[i].poNumber, searchBy);
            await I.executeScript(function() {
            document.getElementById("ApprovalSPOListing0").click();
            })
            await this.clearSearchField();
        }
        await I.waitForVisible(I.getElement(approvalObject.FOOTER_DELEGATE_ACTION));
        await I.click(I.getElement(approvalObject.FOOTER_DELEGATE_ACTION));
        await this.selectDelegateApprovalToUser(POArray[0].newApprover);
        await this.fillReasonForDelegate(lmtVar.getLabel("AUTO_GENERATED_COMMENT"));
        await this.clickOnDelegateSpoPopupDelegateButton();
        for (let i=1; i<POArray.length; i++) {
            await commonKeywordImpl.searchDocOnListing(POArray[i].poNumber, searchBy);
            let status = await this.getSpoStatus();
            POArray[i].setStatus(status);
        } 
        return POArray;
    },

    async fetchBuyerOnPoApprovalListing(buyer) {
        let buyerXpath = `//span[contains(text(),'${buyer}')]`;
        await I.waitForVisible(buyerXpath);
        let buyerName = await I.grabTextFrom(buyerXpath);
        logger.info(`Buyer name fetched from listing is ---> ${buyerName}`);
        return buyerName;
    },

    async fetchReceivedOnDateOnPOApprovalListing() {
        let date = await commonKeywordImpl.getValueForColumnName(lmtVar.getLabel("RECEIVED_ON"));;
        logger.info(`Received on date fetched from listing is ---> ${date}`);
        return date;
    },

    async fetchAmountToBeApprovedOnPoApprovalListing() {
        let amount = await commonKeywordImpl.getValueForColumnName(lmtVar.getLabel("AMOUNT_TO_BE_APPROVED"));
        logger.info(`Amount to be approved fetched from listing is ---> ${amount}`);
        return amount;
    },

    async fetchPoStatusOnPoApprovalListing() {
        let status = await commonKeywordImpl.getValueForColumnName(lmtVar.getLabel("STATUS_COLUMN"));
        logger.info(`Status of doc fetched from listing is ---> ${status}`);
        return status;
    },

    async checkReqApprovalStatus() {
        I.waitForVisible(I.getElement(poListingObject.PO_NUMBER_LINK));
        I.waitForClickable(I.getElement(poListingObject.PO_NUMBER_LINK));
        await commonKeywordImpl.searchDocOnListing(docNumber, searchBy);
        let status = await this.getReqStatus();
        return status;
    },

    async getReqStatus() {
        I.waitForVisible(I.getElement(poListingObject.PO_NUMBER_LINK));
        let status = await commonKeywordImpl.getValueForColumnName(lmtVar.getLabel("STATUS_COLUMN"));
        //let status = await I.grabTextFrom(I.getElement(approvalObject.APPROVAL_LISTING_REQ_STATUS));
        logger.info(`Retrieved status --> ${status.toString()}`);
        return status;
    },

    async rejectMultipleReqs(reqArray, searchBy){
        for (let i=1; i<reqArray.length; i++) {
            await commonKeywordImpl.searchDocOnListing(reqArray[i].reqNumber, searchBy);
            await I.executeScript(function() {
            document.getElementById("ApprovalReqListing0").click();
            })
        } 
        await I.waitForVisible(I.getElement(approvalObject.FOOTER_REJECT_ACTION));
        await I.click(I.getElement(approvalObject.FOOTER_REJECT_ACTION));
        await this.fillApprovalComments(lmtVar.getLabel("AUTO_GENERATED_COMMENT"));
        await this.clickOnApproveSpoPopupApproveButton();
        for (i=1; i<reqArray.length; i++)
        {   
            await commonKeywordImpl.searchDocOnListing(reqArray[i].reqNumber, searchBy);
            let status = await commonKeywordImpl.getValueForColumnName(lmtVar.getLabel("STATUS_COLUMN"));
            await reqArray[i].setStatus(status);
        }
        return reqArray;
    },

    async approvePoFlow(poNumber) {
        await this.navigateToApprovalListing();
        await this.navigateToPOApprovalListingTab();
        await this.approveDoc(poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
        await this.checkPOApprovalStatus(poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
        let status = await this.getSpoStatus();

        let flag = status.toString() === lmtVar.getLabel("APPROVED_STATUS")
        if(!flag) {
            logger.info(`Failed to approve spo because status is ${status} on Approval listing after approving`);
            throw new Error(`Failed to approve spo because status is ${status} on Approval listing after approving`);
        }
        else {
            logger.info("Spo is approved successfully");
        }
        
        await I.wait(prop.DEFAULT_HIGH_WAIT);
        await poListingImpl.navigateToPoListing();
        await commonKeywordImpl.searchDocOnListing(poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
        status = await poListingImpl.getPoStatus();
        logger.info(`Status in db --> ${lmtVar.getLabel("RELEASED_STATUS")}`);
        flag = status.toString().includes(lmtVar.getLabel("RELEASED_STATUS"));
        if(!flag) {
            logger.info(`Failed to release spo because status is ${status} on po listing after approving`);
            throw new Error(`Failed to release spo because status is ${status} on po listing after approving`);
        }
        else {
            logger.info("Spo is released successfully");
        }
    },

    async approveReqFlow(reqNumber) {
        await this.navigateToApprovalListing();
        await this.approveDoc(reqNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
        await commonKeywordImpl.searchDocOnListing(reqNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
        let status = await commonKeywordImpl.getValueForColumnName(lmtVar.getLabel("STATUS_COLUMN"));
        if(status.toString() !== lmtVar.getLabel("APPROVED_STATUS")) {
            throw new Error(`Req status after approval is not Approved. Current status is --> ${status}`);
        }
    },
    async navigateToBPOApprovalListingTab() {
        await I.waitForVisible(I.getElement(approvalObject.BPO_TAB));
        await I.waitForClickable(I.getElement(approvalObject.BPO_TAB));
        await I.click(I.getElement(approvalObject.BPO_TAB));
        await I.waitForVisible(I.getElement(poListingObject.PO_NUMBER_LINK));
        await I.waitForClickable(I.getElement(poListingObject.PO_NUMBER_LINK));
        logger.info("I am on BPO approval listing");
    },

    async delegateMultipleReqs(reqArray, searchBy){
        await I.waitForVisible(I.getElement(poListingObject.PO_NUMBER_LINK));
        for (let i=1; i<reqArray.length; i++) {
            await commonKeywordImpl.searchDocOnListing(reqArray[i].reqNumber, searchBy);
            await I.executeScript(function() {
            document.getElementById("ApprovalReqListing0").click();
            })
            await this.clearSearchField();
        }
        await I.waitForVisible(I.getElement(approvalObject.FOOTER_DELEGATE_ACTION));
        await I.click(I.getElement(approvalObject.FOOTER_DELEGATE_ACTION));
        await this.selectDelegateApprovalToUser(reqArray[0].newApprover);
        await this.fillReasonForDelegate(lmtVar.getLabel("AUTO_GENERATED_COMMENT"));
        await this.clickOnDelegateSpoPopupDelegateButton();
        for (let i=1; i<reqArray.length; i++) {
            await commonKeywordImpl.searchDocOnListing(reqArray[i].reqNumber, searchBy);
            let status = await commonKeywordImpl.getValueForColumnName(lmtVar.getLabel("STATUS_COLUMN"));
            reqArray[i].setStatus(status);
        }
        return reqArray;
    },

    async approveMultipleBPOs(bpoArray, searchBy){
        for (let i=1; i<bpoArray.length; i++) {
            await commonKeywordImpl.searchDocOnListing(bpoArray[i].poNumber, searchBy);
            await I.executeScript(function() {
            document.getElementById("ApprovalBPOListing0").click();
            })
            await this.clearSearchField();
        } 
        await I.click(I.getElement(approvalObject.FOOTER_APPROVE_ACTION));
        await this.fillApprovalComments(lmtVar.getLabel("AUTO_GENERATED_COMMENT"));
        await this.clickOnApproveSpoPopupApproveButton();
        for (let i=1; i<bpoArray.length; i++) {
            await commonKeywordImpl.searchDocOnListing(bpoArray[i].poNumber, searchBy);
            let status = await this.getSpoStatus();
            bpoArray[i].setStatus(status);
        } 
        return bpoArray;
    },

    async checkMultipleBPOStatus(bpoArray, searchBy) {
        for (let i=1; i<bpoArray.length; i++) {
            await commonKeywordImpl.searchDocOnListing(bpoArray[i].poNumber, searchBy);
            let BPOStatus = await commonKeywordImpl.getValueForColumnName(lmtVar.getLabel("STATUS_COLUMN"));
            await I.assertEqual(BPOStatus, bpoArray[i].status.toString());
            let flag = BPOStatus === bpoArray[i].status.toString();
        if(!flag) {
            logger.info(`Failed to match the status of doc as ${BPOStatus} is different from ${bpoArray[i].status}`);
            throw new Error(`Failed to match the status of doc as ${BPOStatus} is different from ${bpoArray[i].status}`);
        }
        else {
            logger.info("Status of docs matched successfully");
        }
        }     
    },

    async rejectMultipleBPOs(bpoArray, searchBy){
        for (let i=1; i<bpoArray.length; i++) {
            await commonKeywordImpl.searchDocOnListing(bpoArray[i].poNumber, searchBy);
            await I.executeScript(function() {
            document.getElementById("ApprovalBPOListing0").click();
            })
            await this.clearSearchField();
        } 
        await I.click(I.getElement(approvalObject.FOOTER_REJECT_ACTION));
        await this.fillApprovalComments(lmtVar.getLabel("AUTO_GENERATED_COMMENT"));
        await this.clickOnApproveSpoPopupApproveButton();
        for (let i=1; i<bpoArray.length; i++) {
            await commonKeywordImpl.searchDocOnListing(bpoArray[i].poNumber, searchBy);
            let status = await this.getSpoStatus();
            bpoArray[i].setStatus(status);
        } 
        return bpoArray;
    },

    async delegateMultipleBPOs(bpoArray, searchBy){
        await I.waitForVisible(I.getElement(poListingObject.PO_NUMBER_LINK));
        for (let i=1; i<bpoArray.length; i++) {
            await commonKeywordImpl.searchDocOnListing(bpoArray[i].poNumber, searchBy);
            await I.executeScript(function() {
            document.getElementById("ApprovalBPOListing0").click();
            })
            await this.clearSearchField();
        }
        await I.waitForVisible(I.getElement(approvalObject.FOOTER_DELEGATE_ACTION));
        await I.click(I.getElement(approvalObject.FOOTER_DELEGATE_ACTION));
        await this.selectDelegateApprovalToUser(bpoArray[0].newApprover);
        await this.fillReasonForDelegate(lmtVar.getLabel("AUTO_GENERATED_COMMENT"));
        await this.clickOnDelegateSpoPopupDelegateButton();
        for (let i=1; i<bpoArray.length; i++) {
            await commonKeywordImpl.searchDocOnListing(bpoArray[i].poNumber, searchBy);
            let status = await this.getSpoStatus();
            bpoArray[i].setStatus(status);
        } 
        return bpoArray;
    },
}