const { I } = inject();
const poListingObject = require("./PoListingObject");
const prop=global.confi_prop;
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const iSpoObject = require("../Spo/SpoObject");

module.exports = {
    async navigateToPoListing() {
        await I.amOnPage(prop.poListingUrl);
        await I.waitForInvisible(global.uiElements.get(iSpoObject.spinner), prop.DEFAULT_MEDIUM_WAIT);
        await I.seeElement(global.uiElements.get(poListingObject.PO_NUMBER_LINK));
        logger.info("Navigated to Po Listing page");
    },
    async fillRecallApprovalRequestComments(comments) {
        await I.seeElement(global.uiElements.get(poListingObject.RECALL_APPROVAL_REQUEST_COMMENTS_TEXTAREA));
        await I.click(global.uiElements.get(poListingObject.RECALL_APPROVAL_REQUEST_COMMENTS_TEXTAREA));
        await I.clearField(global.uiElements.get(poListingObject.RECALL_APPROVAL_REQUEST_COMMENTS_TEXTAREA));
        await I.fillField(global.uiElements.get(poListingObject.RECALL_APPROVAL_REQUEST_COMMENTS_TEXTAREA), comments);
        logger.info(`Entered recall comments --> ${comments}`);
    },
    async clickOnRecallButton() {
        await I.seeElement(global.uiElements.get(poListingObject.RECALL_APPROVAL_REQUEST_RECALL_BUTTON));
        await I.click(global.uiElements.get(poListingObject.RECALL_APPROVAL_REQUEST_RECALL_BUTTON));
        await I.seeElement(global.uiElements.get(poListingObject.PO_NUMBER_LINK));
        logger.info("Clicked on Recall button");
    },
    async clickOnRecalledSuccessDoneButton() {
        await I.seeElement(global.uiElements.get(poListingObject.RECALLED_SUCCESS_DONE_BUTTON));
        await I.click(global.uiElements.get(poListingObject.RECALLED_SUCCESS_DONE_BUTTON));
        logger.info("Clicked on Recalled Success Done button");
    },
    async getPoStatus(){
        await I.scrollIntoView(global.uiElements.get(poListingObject.PO_STATUS));
        await I.wait(prop.DEFAULT_WAIT);
        logger.info("Scrolled to Status column");
        await I.seeElement(global.uiElements.get(poListingObject.PO_STATUS));
        let status = await I.grabTextFrom(global.uiElements.get(poListingObject.PO_STATUS));
        logger.info(`Retrieved status --> ${status}`);
        return status;
    },
    async fillClosePoComments(comments) {
        await I.seeElement(global.uiElements.get(poListingObject.CLOSE_PO_POPUP_COMMENTS_TEXTAREA));
        await I.click(global.uiElements.get(poListingObject.CLOSE_PO_POPUP_COMMENTS_TEXTAREA));
        await I.clearField(global.uiElements.get(poListingObject.CLOSE_PO_POPUP_COMMENTS_TEXTAREA));
        await I.fillField(global.uiElements.get(poListingObject.CLOSE_PO_POPUP_COMMENTS_TEXTAREA), comments);
        logger.info(`Entered close po comments --> ${comments}`);
    },
    async clickOnClosePoButton() {
        await I.seeElement(global.uiElements.get(poListingObject.CLOSE_PO_POPUP_CLOSE_PO_BUTTON));
        await I.click(global.uiElements.get(poListingObject.CLOSE_PO_POPUP_CLOSE_PO_BUTTON));
        logger.info("Clicked on Close PO button");
    },
    async clickOnClosedPoSuccessDoneButton() {
        await I.seeElement(global.uiElements.get(poListingObject.RECALLED_SUCCESS_DONE_BUTTON));
        await I.click(global.uiElements.get(poListingObject.RECALLED_SUCCESS_DONE_BUTTON));
        await I.seeElement(global.uiElements.get(poListingObject.PO_NUMBER_LINK));
        logger.info("Clicked on Closed PO Success Done button");
    },
    async clickOnEditAction() {
        await I.seeElement(global.uiElements.get(poListingObject.EDIT_ACTION));
        await I.click(global.uiElements.get(poListingObject.EDIT_ACTION));
        await I.seeElement(global.uiElements.get(iSpoObject.poNumberTextbox));
        logger.info("Clicked on PO edit action");
    },
    
}