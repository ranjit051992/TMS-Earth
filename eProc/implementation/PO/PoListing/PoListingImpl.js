const { I } = inject();
const poListingObject = require("./PoListingObject");

module.exports = {
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
        logger.info("Clicked on Recall button");
    },
    async clickOnRecalledSuccessDoneButton() {
        await I.seeElement(global.uiElements.get(poListingObject.RECALLED_SUCCESS_DONE_BUTTON));
        await I.click(global.uiElements.get(poListingObject.RECALLED_SUCCESS_DONE_BUTTON));
        logger.info("Clicked on Recalled Success Done button");
    }
}