const { I } = inject();
const poListingObject = require("./PoListingObject");
const prop=global.confi_prop;
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const iSpoObject = require("../Spo/SpoObject");
const approvalObject = require("../../Approval/ApprovalObject");
const commonKeywordImpl = require("../../../commonKeywords/CommonComponent");
const lmtVar = require("../../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");

module.exports = {
    async navigateToPoListing() {
        await I.amOnPage(prop.poListingUrl);
        await I.waitForInvisible(I.getElement(iSpoObject.spinner), prop.DEFAULT_HIGH_WAIT);
        await I.waitForVisible(I.getElement(poListingObject.PO_NUMBER_LINK));
        await I.waitForClickable(I.getElement(poListingObject.PO_NUMBER_LINK));
        logger.info("Navigated to Po Listing page");
    },
    async fillRecallApprovalRequestComments(comments) {
        await I.waitForVisible(I.getElement(poListingObject.RECALL_APPROVAL_REQUEST_COMMENTS_TEXTAREA));
        await I.click(I.getElement(poListingObject.RECALL_APPROVAL_REQUEST_COMMENTS_TEXTAREA));
        await I.clearField(I.getElement(poListingObject.RECALL_APPROVAL_REQUEST_COMMENTS_TEXTAREA));
        await I.fillField(I.getElement(poListingObject.RECALL_APPROVAL_REQUEST_COMMENTS_TEXTAREA), comments);
        logger.info(`Entered recall comments --> ${comments}`);
    },
    async clickOnRecallButton() {
        await I.waitForVisible(I.getElement(poListingObject.RECALL_APPROVAL_REQUEST_RECALL_BUTTON));
        await I.click(I.getElement(poListingObject.RECALL_APPROVAL_REQUEST_RECALL_BUTTON));
        await I.waitForVisible(I.getElement(poListingObject.PO_NUMBER_LINK));
        logger.info("Clicked on Recall button");
    },
    async clickOnRecalledSuccessDoneButton() {
        await I.waitForVisible(I.getElement(poListingObject.RECALLED_SUCCESS_DONE_BUTTON));
        await I.click(I.getElement(poListingObject.RECALLED_SUCCESS_DONE_BUTTON));
        logger.info("Clicked on Recalled Success Done button");
    },
    async getPoStatus(){
        let status = await (await commonKeywordImpl.getValueForColumnName(lmtVar.getLabel("STATUS_COLUMN"))).toString();
        // await I.scrollIntoView(I.getElement(poListingObject.PO_STATUS));
        // await I.wait(prop.DEFAULT_WAIT);
        // logger.info("Scrolled to Status column");
        // await I.waitForVisible(I.getElement(poListingObject.PO_STATUS));
        // let status = await I.grabTextFrom(I.getElement(poListingObject.PO_STATUS));
        logger.info(`Retrieved status --> ${status}`);
        return status;
    },
    async fillClosePoComments(comments) {
        await I.waitForVisible(I.getElement(poListingObject.CLOSE_PO_POPUP_COMMENTS_TEXTAREA));
        await I.click(I.getElement(poListingObject.CLOSE_PO_POPUP_COMMENTS_TEXTAREA));
        await I.clearField(I.getElement(poListingObject.CLOSE_PO_POPUP_COMMENTS_TEXTAREA));
        await I.fillField(I.getElement(poListingObject.CLOSE_PO_POPUP_COMMENTS_TEXTAREA), comments);
        logger.info(`Entered close po comments --> ${comments}`);
    },
    async clickOnClosePoButton() {
        await I.waitForVisible(I.getElement(poListingObject.CLOSE_PO_POPUP_CLOSE_PO_BUTTON));
        await I.click(I.getElement(poListingObject.CLOSE_PO_POPUP_CLOSE_PO_BUTTON));
        logger.info("Clicked on Close PO button");
    },
    async clickOnClosedPoSuccessDoneButton() {
        await I.waitForVisible(I.getElement(poListingObject.RECALLED_SUCCESS_DONE_BUTTON));
        await I.click(I.getElement(poListingObject.RECALLED_SUCCESS_DONE_BUTTON));
        await I.waitForVisible(I.getElement(poListingObject.PO_NUMBER_LINK));
        logger.info("Clicked on Closed PO Success Done button");
    },
    async clickOnEditAction() {
        await I.waitForVisible(I.getElement(poListingObject.EDIT_ACTION));
        await I.click(I.getElement(poListingObject.EDIT_ACTION));
        await I.waitForVisible(I.getElement(iSpoObject.poNumberTextbox));
        logger.info("Clicked on PO edit action");
    },
    async clickOnRemindApproverAction() {
        await I.waitForVisible(I.getElement(approvalObject.APPROVE_ACTION));
        await I.click(I.getElement(approvalObject.APPROVE_ACTION));
        logger.info("Clicked on Remind Approver action");
    },
    async clickOnSuccessPopupDoneButton() {
        await I.waitForVisible(I.getElement(poListingObject.RECALLED_SUCCESS_DONE_BUTTON));
        await I.click(I.getElement(poListingObject.RECALLED_SUCCESS_DONE_BUTTON));
        logger.info("Clicked on Success popup Done button");
    },
    async openPoInAmendMode(poNumber) {
        await this.navigateToPoListing();
        await commonKeywordImpl.searchDocOnListing(poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
        await commonKeywordImpl.clickOnActionMenuIcon();
        await commonKeywordImpl.clickOnActionMenuOption(lmtVar.getLabel("AMEND_PO"));
        await I.waitForVisible(I.getElement(iSpoObject.poDescriptionTextbox));
        logger.info("Opened po in amend mode");
    },
    async clickOnPoNumber() {
        await commonKeywordImpl.clickOnDocNumberLink();
        await I.waitForVisible(I.getElement(iSpoObject.PO_VIEW_BASIC_DETAILS_SECTION));
    },
    
}