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
    
    clickOnStatusApplyButton(){
        I.click(I.getElement(iBuyersDeskObject.BUYER_DESK_STATUS_APPLY));  
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
   },

   async clickPurchaseAmountFilter(){
        I.click(I.getElement(iBuyersDeskObject.PURCHASE_AMOUNT_FILTER));
  },

  async fillPurchaseAmount(maxValue,minValue)
  {
    I.waitForVisible(I.getElement(iBuyersDeskObject.PURCHASE_AMOUNT_MIN_INPUT),prop.DEFAULT_MEDIUM_WAIT);
    await I.fillField(I.getElement(iBuyersDeskObject.PURCHASE_AMOUNT_MIN_INPUT,minValue));
    logger.info("Entered the min value " +minValue);
    await I.fillField(I.getElement(iBuyersDeskObject.PURCHASE_AMOUNT_MAX_INPUT,maxValue));
    logger.info("Entered the min value " +maxValue);
    this.clickOnStatusApplyButton();
  },

  async filterStatus(status)
  {
      I.waitForVisible(I.getElement(iBuyersDeskObject.STATUS_FILTER),prop.DEFAULT_MEDIUM_WAIT);
      let incomingstatus = I.grabAttributeFrom(I,getElement(iBuyersDeskObject.STATUS_FILTER));
      if( incomingstatus == "In Process")
      {
          I.checkOption(I.getElement(iBuyersDeskObject.STATUS_FILTER));
          logger.info("Status selected is In Process");
          this.clickOnStatusApplyButton();
      }

      else if(incomingstatus == "Sourcing Status")
      {
        I.checkOption(I.getElement(iBuyersDeskObject.STATUS_FILTER));
        logger.info("Status selected is Sourcing Status");
        this.clickOnStatusApplyButton();
      }

    else if(incomingstatus == "Released")
    {
      I.checkOption(I.getElement(iBuyersDeskObject.STATUS_FILTER));
      logger.info("Status selected is Released");
      this.clickOnStatusApplyButton();
    }

     else if(incomingstatus == "Rejected")
   {
    I.checkOption(I.getElement(iBuyersDeskObject.STATUS_FILTER));
    logger.info("Status selected is Rejected");
    this.clickOnStatusApplyButton();
   }

   else if(incomingstatus == "Cancelled")
  {
   I.checkOption(I.getElement(iBuyersDeskObject.STATUS_FILTER));
   logger.info("Status selected is Cancelled");
   this.clickOnStatusApplyButton();
  }
    else if(incomingstatus == "Closed")
  {
   I.checkOption(I.getElement(iBuyersDeskObject.STATUS_FILTER));
   logger.info("Status selected is Closed");
   this.clickOnStatusApplyButton();
  }
},


}

 
