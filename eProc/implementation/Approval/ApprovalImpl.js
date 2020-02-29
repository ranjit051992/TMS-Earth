const { I } = inject();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
const iSpoObject = require("../PO/Spo/SpoObject");
const prop = global.confi_prop;
const lmtVar = require("../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const poListingObject = require("../PO/PoListing/PoListingObject");
const approvalObject = require("./ApprovalObject");
const commonKeywordImpl = require("../../commonKeywords/CommonComponent");

module.exports = {
    async navigateToApprovalListing() {
        await I.amOnPage(prop.DDS_Approval_Listing);
        await I.seeElement(I.getElement(poListingObject.PO_NUMBER_LINK));
        logger.info("Navigated to approval listing page");
    },
    async clickOnApproveAction(){
        await I.seeElement(I.getElement(approvalObject.APPROVE_ACTION));
        await I.click(I.getElement(approvalObject.APPROVE_ACTION));
        logger.info("Clicked on Approve action");
    },
    async fillApprovalComments(comments) {
        await I.seeElement(I.getElement(approvalObject.APPROVE_SPO_POPUP_COMMENT_TEXTAREA));
        await I.click(I.getElement(approvalObject.APPROVE_SPO_POPUP_COMMENT_TEXTAREA));
        await I.clearField(I.getElement(approvalObject.APPROVE_SPO_POPUP_COMMENT_TEXTAREA));
        await I.fillField(I.getElement(approvalObject.APPROVE_SPO_POPUP_COMMENT_TEXTAREA), comments);
        logger.info(`Entered approval comments --> ${comments}`);
    },
    async clickOnApproveSpoPopupApproveButton() {
        await I.seeElement(I.getElement(approvalObject.APPROVE_SPO_POPUP_APPROVE_BUTTON));
        await I.click(I.getElement(approvalObject.APPROVE_SPO_POPUP_APPROVE_BUTTON));
        logger.info("Clicked on Approve button");
    },
    async getSpoStatus() {
        let status = await I.grabTextFrom(I.getElement(approvalObject.APPROVAL_LISTING_SPO_STATUS));
        logger.info(`Retrieved status --> ${status}`);
        return status;
    },
    async approveDoc(docNumber, searchBy){
        await I.seeElement(I.getElement(poListingObject.PO_NUMBER_LINK));
        await commonKeywordImpl.searchDocOnListing(docNumber, searchBy);
        await this.clickOnApproveAction();
        await this.fillApprovalComments(lmtVar.getLabel("AUTO_GENERATED_COMMENT"));
        await this.clickOnApproveSpoPopupApproveButton();
        await I.wait(prop.DEFAULT_WAIT);
        await I.seeElement(I.getElement(poListingObject.PO_NUMBER_LINK));
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
    }

    fetchRequesterName() {
        let name = I.grabTextFrom(global.uiElements.get(iApprovalObject.REQUESTER_NAME));
        logger.info("Requester name fetched from listing");
        return name;
    },

    fetchReceivedOnDate() {
        let date = I.grabTextFrom(global.uiElements.get(iApprovalObject.RECEIVED_ON));
        logger.info("Received on date fetched from listing");
        return date;
    },

    fetchAmountToBeApproved() {
        let amount = I.grabTextFrom(global.uiElements.get(iApprovalObject.AMOUNT_TO_BE_APPROVED));
        logger.info("Amount to be approved fetched from listing");
        return amount;
    },

    fetchReqStatus() {
        let status = I.grabTextFrom(global.uiElements.get(iApprovalObject.STATUS));
        logger.info("Requisition status fetched from listing");
        return status;
    },

}