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
        I.wait(prop.DEFAULT_WAIT);
        I.fillField(I.getElement(iBuyersDeskObject.SEARCH_REQUISITION_NUMBER),reqNumber);
        I.wait(prop.DEFAULT_WAIT);
        I.click(I.getElement(iBuyersDeskObject.FILTER_APPLY_BUTTON));
        I.wait(prop.DEFAULT_WAIT);
    },

    async SearchRequisitionNumber(reqNumber, searchBy){
        I.wait(prop.DEFAULT_WAIT);
        await commonKeywordImpl.searchDocOnListing(reqNumber, searchBy);
    },

    async fetchSearchedRequisitionNumber()
   {
        I.waitForVisible(I.getElement(iBuyersDeskObject.REQUISITION_NUMBER_LISTING),prop.DEFAULT_MEDIUM_WAIT);
        let requisitionNo = await I.grabTextFrom(I.getElement(iBuyersDeskObject.REQUISITION_NUMBER_LISTING));
        logger.info("Searched Requisition number is : "+requisitionNo);
        I.wait(prop.DEFAULT_WAIT);
        return requisitionNo;
   }

}

 
