const { I } = inject();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
const iBuyersDeskObject = require("./BuyersDeskObject");

const lmtVar = require("../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const prop=global.confi_prop;
const commonKeywordImpl = require("../../commonKeywords/CommonComponent");

module.exports = {

    clickonStatusFilterButton(){
        I.click(I.getElement(iBuyersDeskObject.FILTER_BUTTON))
    },

    FilterWithRequisitionNumber(reqNumber){
        this.clickonStatusFilterButton();
        logger.info("Requisition number is :" + reqNumber);
        I.fillField(I.getElement(iBuyersDeskObject.SEARCH_REQUISITION_NUMBER),reqNumber);
        I.click(I.getElement(iBuyersDeskObject.FILTER_APPLY_BUTTON));
    },

    async SearchRequisitionNumber(reqNumber, searchBy){
        await commonKeywordImpl.searchDocOnListing(reqNumber, searchBy);
    },

    async fetchSearchedRequisitionNumber()
   {
        I.waitForVisible(I.getElement(iBuyersDeskObject.REQUISITION_NUMBER_LISTING),prop.DEFAULT_MEDIUM_WAIT);
        let requisitionNo = await I.grabTextFrom(I.getElement(iBuyersDeskObject.REQUISITION_NUMBER_LISTING));
        logger.info("Searched Requisition number is : "+requisitionNo);
        return requisitionNo;
   },

   async fetchSearchedRequisitionName()
   {
        I.waitForVisible(I.getElement(iBuyersDeskObject.REQUISITION_NAME_LISTING),prop.DEFAULT_MEDIUM_WAIT);
        let requisitionName = await I.grabTextFrom(I.getElement(iBuyersDeskObject.REQUISITION_NAME_LISTING));
        logger.info("Searched Requisition name is : "+requisitionName);
        return requisitionName;
   }

}

 
