const { I } = inject();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
const iBuyersDeskObject = require("./BuyersDeskObject");
const commonComponent = require("../../commonKeywords/CommonComponent");
const lmtVar = require("../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const prop=global.confi_prop;
const commonKeywordImpl = require("../../commonKeywords/CommonComponent");
const requisitionBo = require("../../dataCreation/bo/Requisition")

module.exports = {

    clickonStatusFilterButton(){
        I.click(I.getElement(iBuyersDeskObject.STATUS_FILTER))
    },
    
    clickOnStatusApplyButton(){
        I.click(I.getElement(iBuyersDeskObject.BUYER_DESK_STATUS_APPLY));  
        },
    // clickonStatusFilterButton(){
    //     I.click(I.getElement(iBuyersDeskObject.FILTER_BUTTON))
    // },

    // FilterWithRequisitionNumber(reqNumber){
    //     this.clickonStatusFilterButton();
    //     logger.info("Requisition number is :" + reqNumber);
    //     I.fillField(I.getElement(iBuyersDeskObject.SEARCH_REQUISITION_NUMBER),reqNumber);
    //     I.click(I.getElement(iBuyersDeskObject.FILTER_APPLY_BUTTON));
    // },

    async SearchRequisitionNumber(reqNumber, searchBy){
        await commonKeywordImpl.searchDocOnListing(reqNumber, searchBy);
        await commonKeywordImpl.waitForLoadingSymbolNotDisplayed();
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
    // await I.fillField(I.getElement(iBuyersDeskObject.PURCHASE_AMOUNT_MIN_INPUT,minValue));
    // logger.info("Entered the min value " +minValue);
    // await I.fillField(I.getElement(iBuyersDeskObject.PURCHASE_AMOUNT_MAX_INPUT,maxValue));
    // logger.info("Entered the min value " +maxValue);
    // this.clickOnStatusApplyButton();
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

    let buyersOption = `//*[@id='cdk-overlay-0']//ul/li[${index}]/div/label`;
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
        I.click(I.getElement(iBuyersDeskObject.REQUISITION_CHECKBOX));
    },

    async convertToPO(){
        I.waitForVisible(I.getElement(iBuyersDeskObject.CONVERT_PO_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iBuyersDeskObject.CONVERT_PO_BUTTON));
        await commonKeywordImpl.waitForLoadingSymbolNotDisplayed();
        await this.clickOnPODetailsCheckbox();
        await this.clickOnSubmitPOBtn();
        await commonKeywordImpl.waitForLoadingSymbolNotDisplayed();
    },

    async fetchPurchaseAmount(){
        I.waitForVisible(I.getElement(iBuyersDeskObject.BUYER_NAME_LISTING),prop.DEFAULT_MEDIUM_WAIT);
        let purchaseamount = await I.grabTextFrom(I.getElement(iBuyersDeskObject.PURCHASE_AMOUNT_LISTING));
        return purchaseamount;

    },

    async fetchStatus(){
        I.waitForVisible(I.getElement(iBuyersDeskObject.BUYER_NAME_LISTING),prop.DEFAULT_MEDIUM_WAIT);
        let status = await I.grabTextFrom(I.getElement(iBuyersDeskObject.STATUS_LISTING));
        return status;

    },

    async clickOnPODetailsCheckbox(){
        I.waitForVisible(I.getElement(iBuyersDeskObject.PO_DETAILS_CHECKBOX),prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iBuyersDeskObject.PO_DETAILS_CHECKBOX));

    },

    async clickOnSubmitPOBtn(){
        I.waitForVisible(I.getElement(iBuyersDeskObject.SUBMIT_PO_BUTTON),prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iBuyersDeskObject.SUBMIT_PO_BUTTON));
    },

    async verifyPage(){
        I.waitForVisible(I.getElement(iBuyersDeskObject.VIEW_PO),prop.DEFAULT_MEDIUM_WAIT);
        let status = await I.grabTextFrom(I.getElement(iBuyersDeskObject.VIEW_PO));
        return status;
    },
     
    async SearchRequester(requester){
        I.waitForVisible(I.getElement(iBuyersDeskObject.REQUISITION_NAME_LISTING),prop.DEFAULT_MEDIUM_WAIT);
        await this.clickOnRequesterFilter();
        let requesterName = await this.selectRequester(requester);
        requisitionBo.requester = requesterName;
        logger.info('Requester after selector is '+requisitionBo.requester);
        await this.clickonApplyButton();
        I.waitForVisible(I.getElement(iBuyersDeskObject.REQUESTER_NAME_LISTING),prop.DEFAULT_MEDIUM_WAIT);
    },

    async clickOnRequesterFilter(){
        I.click(I.getElement(iBuyersDeskObject.REQUESTER_FILTER));
    },

    async selectRequester(requester){
        I.waitForVisible(I.getElement(iBuyersDeskObject.SEARCH_REQUESTOR_TEXTBOX),global.confi_prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(I.getElement(iBuyersDeskObject.SEARCH_REQUESTOR_TEXTBOX),confi_prop.DEFAULT_HIGH_WAIT);
        I.fillField(I.getElement(iBuyersDeskObject.SEARCH_REQUESTOR_TEXTBOX),requester);
        let suggXpath = `//label[contains(text(),'${requester}')]`;
        I.click(suggXpath);
        requester = await I.grabTextFrom(suggXpath);
       logger.info(`Entered Requester is : ${requester}`);
       return requester;
    },

    async fetchSearchedBuyer()
   {
        I.waitForVisible(I.getElement(iBuyersDeskObject.BUYER_NAME_LISTING),prop.DEFAULT_MEDIUM_WAIT);
        let buyerName = await I.grabTextFrom(I.getElement(iBuyersDeskObject.BUYER_NAME_LISTING));
        return buyerName;
   },

   async fetchSearchedRequestor()
   {
        I.waitForVisible(I.getElement(iBuyersDeskObject.REQUESTER_NAME_LISTING),prop.DEFAULT_MEDIUM_WAIT);
        let requestorName = await I.grabTextFrom(I.getElement(iBuyersDeskObject.REQUESTER_NAME_LISTING));
        return requestorName;
   }
}

 
