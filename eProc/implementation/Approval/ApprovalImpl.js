const { I } = inject();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
const iSpoObject = require("../PO/Spo/SpoObject");
const prop = global.confi_prop
const iConstants = require("../../constants/iConstants");
const poListingObject = require("../PO/PoListing/PoListingObject");
const approvalObject = require("./ApprovalObject");
const commonKeywordImpl = require("../../commonComponent/CommonComponent");

module.exports = {
    async navigateToApprovalListing() {
        await I.amOnPage(prop.DDS_Approval_Listing);
        await I.seeElement(global.uiElements.get(poListingObject.PO_NUMBER_LINK));
        logger.info("Navigated to approval listing page");
    },
    async clickOnApproveAction(){
        await I.seeElement(global.uiElements.get(approvalObject.APPROVE_ACTION));
        await I.click(global.uiElements.get(approvalObject.APPROVE_ACTION));
        logger.info("Clicked on Approve action");
    },
    async fillApprovalComments(comments) {
        await I.seeElement(global.uiElements.get(approvalObject.APPROVE_SPO_POPUP_COMMENT_TEXTAREA));
        await I.click(global.uiElements.get(approvalObject.APPROVE_SPO_POPUP_COMMENT_TEXTAREA));
        await I.clearField(global.uiElements.get(approvalObject.APPROVE_SPO_POPUP_COMMENT_TEXTAREA));
        await I.fillField(global.uiElements.get(approvalObject.APPROVE_SPO_POPUP_COMMENT_TEXTAREA), comments);
        logger.info(`Entered approval comments --> ${comments}`);
    },
    async clickOnApproveSpoPopupApproveButton() {
        await I.seeElement(global.uiElements.get(approvalObject.APPROVE_SPO_POPUP_APPROVE_BUTTON));
        await I.click(global.uiElements.get(approvalObject.APPROVE_SPO_POPUP_APPROVE_BUTTON));
        logger.info("Clicked on Approve button");
    },
    async getSpoStatus() {
        let status = await I.grabTextFrom(global.uiElements.get(approvalObject.APPROVAL_LISTING_SPO_STATUS));
        logger.info(`Retrieved status --> ${status}`);
        return status;
    },
    async approveSpo(docNumber, searchBy){
        await this.navigateToApprovalListing();
        // click on spo tab
        await I.seeElement(global.uiElements.get(poListingObject.PO_NUMBER_LINK));
        await commonKeywordImpl.searchDocOnListing(docNumber, searchBy);
        await this.clickOnApproveAction();
        await this.fillApprovalComments(iConstants.AUTO_GENERATED_COMMENT);
        await this.clickOnApproveSpoPopupApproveButton();
        await I.wait(prop.DEFAULT_WAIT);
        await I.seeElement(global.uiElements.get(poListingObject.PO_NUMBER_LINK));
        await I.waitForClickable(global.uiElements.get(poListingObject.PO_NUMBER_LINK));
        await commonKeywordImpl.searchDocOnListing(docNumber, searchBy);
        let status = await this.getSpoStatus();
        let flag = status === iConstants.APPROVED_STATUS
        if(!flag) {
            logger.info(`Failed to approve spo because status is ${status} on Approval listing after approving`);
            throw new Error(`Failed to approve spo because status is ${status} on Approval listing after approving`);
        }
        else {
            logger.info("Spo is approved successfully");
        }
        return status;
    }
}