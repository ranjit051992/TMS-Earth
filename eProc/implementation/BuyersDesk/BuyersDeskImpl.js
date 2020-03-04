const { I } = inject();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
const iBuyersDeskObject = require("./BuyersDeskObject");
const commonComponent = require("../../commonKeywords/CommonComponent");
const lmtVar = require("../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const prop=global.confi_prop;
const commonKeywordImpl = require("../../commonKeywords/CommonComponent");
const requisitionBo = require("../../dataCreation/bo/Requisition")

module.exports = {

<<<<<<< HEAD
    clickonStatusFilterButton(){
        I.click(I.getElement(iBuyersDeskObject.FILTER_BUTTON))
    },
    
    clickOnStatusApplyButton(){
        I.click(I.getElement(iBuyersDeskObject.BUYER_DESK_STATUS_APPLY));  
        },
=======
    // clickonStatusFilterButton(){
    //     I.click(I.getElement(iBuyersDeskObject.FILTER_BUTTON))
    // },
>>>>>>> 953f619f7aa07299c552473cf8a22361166f0b92

    // FilterWithRequisitionNumber(reqNumber){
    //     this.clickonStatusFilterButton();
    //     logger.info("Requisition number is :" + reqNumber);
    //     I.fillField(I.getElement(iBuyersDeskObject.SEARCH_REQUISITION_NUMBER),reqNumber);
    //     I.click(I.getElement(iBuyersDeskObject.FILTER_APPLY_BUTTON));
    // },

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

<<<<<<< HEAD
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
=======
   async fetchSearchedBuyer()
   {
        I.waitForVisible(I.getElement(iBuyersDeskObject.BUYER_NAME_LISTING),prop.DEFAULT_MEDIUM_WAIT);
        let buyerName = await I.grabTextFrom(I.getElement(iBuyersDeskObject.BUYER_NAME_LISTING));
        return buyerName;
   },

    async selectBuyerOption(buyerName ,option) {
    let index;
    if(option === lmtVar.getLabel("SEARCH_BY_ME")) {
        index = 1;
    }
    else if(option === lmtVar.getLabel("SEARCH_BY_BUYER")) {
        index = 2;
        await this.fillBuyerName(buyerName,index);
    }
    else if(option === lmtVar.getLabel("SEARCH_BY_BUYER_GROUP")) {
        index = 3;
        await this.fillBuyerName(buyerName,index);
    }
    else if(option === lmtVar.getLabel("SEARCH_BY_UNASSIGNED")) {
        index = 4;
    }
    else {
        throw new Error("Invalid search option!");
    }

    let buyersOption = `//*[@id='cdk-overlay-0']/div/div/dew-popover-body/eproc-assigned-buyer-filter/ul/li[${index}]/div/label`;
    logger.info(`buyersOption --> ${buyersOption}`);

    I.waitForVisible(buyersOption);
    I.click(buyersOption);
    logger.info(`Selected Search By option --> ${option}`);
    },

    async SearchBuyer(buyerName, searchBy)
   {
        await I.waitForVisible(I.getElement(iBuyersDeskObject.REQUISITION_NAME_LISTING),prop.DEFAULT_MEDIUM_WAIT);
        await this.clickOnAssignedBuyerFilter();
        await this.selectBuyerOption(buyerName,searchBy);
        await this.clickonApplyButton();
        await I.waitForVisible(I.getElement(iBuyersDeskObject.BUYER_NAME_LISTING),prop.DEFAULT_MEDIUM_WAIT);
   },
   
   async clickOnAssignedBuyerFilter(){
    I.click(I.getElement(iBuyersDeskObject.ASSIGNED_BUYER_FILTER));
    },

    async clickonApplyButton(){
       await  I.click(I.getElement(iBuyersDeskObject.APPLY_STATUS_BUTTON));
       await commonComponent.waitForLoadingSymbolNotDisplayed();
       let spinner = `//div[@class='spinnerTop']`;
       I.waitForInvisible(spinner,prop.DEFAULT_HIGH_WAIT);
    },

    async fillBuyerName(buyerName,index){
        requisitionBo.buyer = await this.fillBuyer(requisitionBo.buyer);
    },

    async fillBuyer(buyer)
    {
        logger.info('Fill Buyer name : ' + buyer);
       I.waitForVisible(I.getElement(iBuyersDeskObject.ASSIGNED_BUYER), prop.DEFAULT_MEDIUM_WAIT);
       I.waitForClickable(I.getElement(iBuyersDeskObject.ASSIGNED_BUYER), prop.DEFAULT_MEDIUM_WAIT);
        let suggXpath = `//p[contains(text(),'${buyer}')]`;
        buyer = await commonComponent.searchAndSelectFromDropdown(I.getElement(iBuyersDeskObject.ASSIGNED_BUYER), buyer, suggXpath);
        logger.info(`Entered buyer : ${buyer}`);
        return buyer;
    },

    async selectRequisitionCheckbox(){
        I.waitForVisible(I.getElement(iBuyersDeskObject.REQUISITION_CHECKBOX), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iCheckout.REQUISITION_CHECKBOX));
    },

    async convertToPO(){
        I.waitForVisible(I.getElement(iBuyersDeskObject.CONVERT_PO_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iBuyersDeskObject.CONVERT_PO_BUTTON));
    }

>>>>>>> 953f619f7aa07299c552473cf8a22361166f0b92

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

 
