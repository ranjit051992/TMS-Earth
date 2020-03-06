const { I } = inject();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
const iMyReq = require("./MyReqObject");
const prop = global.confi_prop;
const faker = require("faker");


module.exports = {

    async CreateReqNavNone() {
        I.waitForVisible(I.getElement(iMyReq.CREATE_REQ_BTN), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iMyReq.CREATE_REQ_BTN));
        logger.info("Create Request button is clicked");
        I.waitForVisible(I.getElement(iMyReq.SEARCH_RD_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.fillField(I.getElement(iMyReq.SEARCH_RD_BUTTON), 'RD_Auto_None1');
        I.waitForVisible(I.getElement(iMyReq.RD_SELECTION_OPTION), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iMyReq.RD_SELECTION_OPTION));
        logger.info("RD Selection has been done");
        I.waitForVisible(I.getElement(iMyReq.RD_MOUSEOVER_ID), prop.DEFAULT_MEDIUM_WAIT);
        I.moveCursorTo(I.getElement(iMyReq.RD_MOUSEOVER_ID));
        I.waitForVisible(I.getElement(iMyReq.CREATE_REQ_POPUP), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iMyReq.CREATE_REQ_POPUP));
        logger.info("Create RD popup is clicked");

    },

    async CreateReqBasicDetails() {
        I.waitForVisible(I.getElement(iMyReq.REQ_NAME_INPUT), prop.DEFAULT_MEDIUM_WAIT);
        I.fillField(I.getElement(iMyReq.REQ_NAME_INPUT), 'Req_Auto_None1');
        logger.info("RequestName got filled");
    },

    async ReqUrgentReqmnt() {
        I.waitForVisible(I.getElement(iMyReq.URGNT_YES_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iMyReq.URGNT_YES_BUTTON));
        I.waitForVisible(I.getElement(iMyReq.REASON_URGENCY_TEXTBOX), prop.DEFAULT_MEDIUM_WAIT);
        I.fillField(I.getElement(iMyReq.REASON_URGENCY_TEXTBOX));
        logger.info("UrgentRequirement option is clicked");
    },
    async ReqSubmit() {
        I.waitForVisible(I.getElement(iMyReq.SUBMIT_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iMyReq.SUBMIT_BUTTON));
        I.waitForVisible(I.getElement(iMyReq.SUBMIT_DONE_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iMyReq.SUBMIT_DONE_BUTTON));
        logger.info("Request got submitted successfully");
    },
    async ReqSaveAsDraft() {
        I.waitForVisible(I.getElement(iMyReq.SAVE_AS_DRAFT_BTN), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iMyReq.SAVE_AS_DRAFT_BTN));
        I.waitForVisible(I.getElement(iMyReq.SUBMIT_DONE_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iMyReq.SUBMIT_DONE_BUTTON));
        logger.info("Request got saveasdraft successfully");
    },
    async ReqCancel() {
        I.waitForVisible(I.getElement(iMyReq.CANCEL_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iMyReq.CANCEL_BUTTON));
        logger.info("Request got cancelled successfully");
    },
    async iSourceFF() {
        I.waitForVisible(I.getElement(iMyReq.ISOURCE_ITEM_NAME), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iMyReq.ISOURCE_ITEM_NAME));
        I.waitForVisible(I.getElement(iMyReq.ISOURCE_PRICE_TYPE_OPTION), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iMyReq.ISOURCE_PRICE_TYPE_OPTION));
        logger.info("iSource PriceType Option choosen");
        I.waitForVisible(I.getElement(iMyReq.ISOURCE_UNIT_TYPE), prop.DEFAULT_LOW_WAIT);
        I.click(I.getElement(iMyReq.ISOURCE_UNIT_TYPE));
        logger.info("iSource PriceType Option clicked");
        I.waitForVisible(I.getElement(iMyReq.ISOURCE_ITEM_NUMBER), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iMyReq.ISOURCE_ITEM_NUMBER));
        I.waitForVisible(I.getElement(iMyReq.ISOURCE_UNIT_OF_MEASURES), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iMyReq.ISOURCE_UNIT_OF_MEASURES));
        I.waitForVisible(I.getElement(iMyReq.ISOURCE_QUANTITY), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iMyReq.ISOURCE_QUANTITY));
        I.waitForVisible(I.getElement(iMyReq.ISOURCE_QUANTITY), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iMyReq.ISOURCE_QUANTITY));
        I.waitForVisible(I.getElement(iMyReq.ISOURCE_EVENT_CURRENCY_SELECTION), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iMyReq.ISOURCE_EVENT_CURRENCY_SELECTION));
        logger.info("iSource EventCurrency Option choosen");
        I.waitForVisible(I.getElement(iMyReq.ISOURCE_EVENT_CURRENCY), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iMyReq.ISOURCE_EVENT_CURRENCY));
        logger.info("iSource FF got added successfully");


},
async CreateReqNaviSource() {
    I.waitForVisible(I.getElement(iMyReq.CREATE_REQ_BTN), prop.DEFAULT_MEDIUM_WAIT);
    I.click(I.getElement(iMyReq.CREATE_REQ_BTN));
    logger.info("Create Request button is clicked");
    I.waitForVisible(I.getElement(iMyReq.SEARCH_RD_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
    I.fillField(I.getElement(iMyReq.SEARCH_RD_BUTTON), 'RD_Auto_iSource');
    I.waitForVisible(I.getElement(iMyReq.RD_SELECTION_OPTION), prop.DEFAULT_MEDIUM_WAIT);
    I.click(I.getElement(iMyReq.RD_SELECTION_OPTION));
    logger.info("RD Selection has been done");
    I.waitForVisible(I.getElement(iMyReq.RD_MOUSEOVER_ID), prop.DEFAULT_MEDIUM_WAIT);
    I.moveCursorTo(I.getElement(iMyReq.RD_MOUSEOVER_ID));
    I.waitForVisible(I.getElement(iMyReq.CREATE_REQ_POPUP), prop.DEFAULT_MEDIUM_WAIT);
    I.click(I.getElement(iMyReq.CREATE_REQ_POPUP));
    logger.info("iSource RD Navigation successfully");
},


}