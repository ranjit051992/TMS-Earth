const { I } = inject();
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const iApprovalObject = require("./ApprovalObject");
const prop = require("../../../../Framework/PropertiesConfigurator");

module.exports = {

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