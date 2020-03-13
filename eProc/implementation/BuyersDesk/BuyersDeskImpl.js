const { I } = inject();
const logger = require("../../../Framework/FrameworkUtilities/Logger/logger");
const iBuyersDeskObject = require("./BuyersDeskObject");
const commonComponent = require("../../commonKeywords/CommonComponent");
const lmtVar = require("../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const prop=global.confi_prop;
const commonKeywordImpl = require("../../commonKeywords/CommonComponent");
const approvalObject = require("../Approval/ApprovalObject");
const poListingObject = require("../PO/PoListing/PoListingObject");
const requisitionBo = require("../../dataCreation/bo/Requisition");
const onlineStore = require("../Requisition/OnlineStore/OnlineStoreObject");

module.exports = {

    async navigateToBuyerListing() {
        await I.amOnPage(prop.DDS_BuyersDesk_Url);
        await I.waitForVisible(I.getElement(poListingObject.PO_NUMBER_LINK));
        logger.info("Navigated to Buyers Desk listing page");
    },

    async clickonStatusFilterButton(){
        I.click(I.getElement(iBuyersDeskObject.STATUS_FILTER));
    },
    
    async clickOnStatusApplyButton(){
        I.click(I.getElement(iBuyersDeskObject.BUYER_DESK_STATUS_APPLY));  
        },

     async clickonRequestorFilter(){
         I.click(I.getElement(iBuyersDeskObject.REQUESTOR_FILTER))
     } , 
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

  async fillPurchaseAmount(minValue,maxValue)
  { 
     I.waitForClickable(I.getElement(iBuyersDeskObject.PURCHASE_AMOUNT_MIN_INPUT),prop.DEFAULT_MEDIUM_WAIT);
     logger.info("Entered the min value " +I.getData(minValue));
     await I.fillField(I.getElement(iBuyersDeskObject.PURCHASE_AMOUNT_MIN_INPUT),I.getData(minValue));
    
     await I.fillField(I.getElement(iBuyersDeskObject.PURCHASE_AMOUNT_MAX_INPUT),I.getData(maxValue));
     logger.info("Entered the max value " +I.getData(maxValue));
     await this.clickonApplyButton();
    
  },

   async fetchSearchedBuyer()
   {
        I.waitForVisible(I.getElement(iBuyersDeskObject.BUYER_NAME_LISTING),prop.DEFAULT_MEDIUM_WAIT);
        let buyerName = await I.grabTextFrom(I.getElement(iBuyersDeskObject.BUYER_NAME_LISTING));
        return buyerName;
   },

    async selectBuyerOption(buyerName ,option) {
    let index;
    let xpathIndex;
    if(option === lmtVar.getLabel("SEARCH_BY_ME")) {
        index = 1;
        xpathIndex="";
    }
    else if(option === lmtVar.getLabel("SEARCH_BY_BUYER")) {
        index = 2;
        xpathIndex=1;
        await this.fillBuyerName(buyerName,index);
    }
    else if(option === lmtVar.getLabel("SEARCH_BY_BUYER_GROUP")) {
        index = 3;
        xpathIndex=2;
        await this.fillBuyerName(buyerName,index);
    }
    else if(option === lmtVar.getLabel("SEARCH_BY_UNASSIGNED")) {
        index = 4;
        xpathIndex=3;
    }
    else {
        throw new Error("Invalid search option!");
    }

    //let buyersOption = `//*[@id='cdk-overlay-0']//ul/li[${index}]/div/label`;
    let buyersOption = `(//label[@for='MST_AssignedBuyerlk${xpathIndex}'])[2]`
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
       I.click(I.getElement(iBuyersDeskObject.APPLY_STATUS_BUTTON));
       await commonComponent.waitForLoadingSymbolNotDisplayed();
       let spinner = `//div[@class='spinnerTop']`;
       I.waitForInvisible(spinner,prop.DEFAULT_HIGH_WAIT);
       logger.info('Clicked on Apply Button');
    },

    async fillBuyerName(buyerName,index){
        requisitionBo.buyer = await this.fillBuyer(I.getData(buyerName));
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
        let purchaseamountwithcurrency = await I.grabTextFrom(I.getElement(iBuyersDeskObject.PURCHASE_AMOUNT_LISTING));
        let purchaseamount = purchaseamountwithcurrency.slice(3);
        return purchaseamount;

    },

    async fetchStatus(){
        I.waitForVisible(I.getElement(iBuyersDeskObject.BUYER_NAME_LISTING),prop.DEFAULT_MEDIUM_WAIT);
        let status = await I.grabTextFrom(I.getElement(iBuyersDeskObject.STATUS_LISTING));
        return status;

    },

    async SearchRequestor(requestor){
      
        logger.info('Searched Requestor :' +requestor);
        I.waitForClickable(I.getElement(iBuyersDeskObject.REQUESTOR_TEXT_BOX),prop.DEFAULT_MEDIUM_WAIT);
        let searchXpath = `//label[contains(text(),'${requestor}')]`;
        requestor = commonComponent.searchAndSelectFromDropdown(I.getElement(iBuyersDeskObject.REQUESTOR_TEXT_BOX),requestor,searchXpath);
        //logger.info(`Entered requestor: ${requestor}`)
        await this.clickonApplyButton();
    },
 
    
    async EditRequisition(requistion){

        logger.info('Requistion to be edited: '+requistion);
        I.waitForVisible(I.getElement(iBuyersDeskObject.REQUISITION_NAME_LISTING),prop.DEFAULT_MEDIUM_WAIT);
        await I.click("//div[contains(text(),'" + lmtVar.getLabel("EDIT_ACTION") + "')]");
        logger.info("Clicking on Selected Requistion");
        await commonKeywordImpl.waitForLoadingSymbolNotDisplayed();
    },
  
    async validateReqinEditMode(){

    I.waitForVisible("//footer//span[contains(text(),'" + lmtVar.getLabel("SAVE") + "')]", prop.DEFAULT_MEDIUM_WAIT);
    let flag = await commonKeywordImpl.isElementPresent("//footer//span[contains(text(),'"+lmtVar.getLabel("SAVE") + "')]");
    I.click("//footer//span[contains(text(),'" + lmtVar.getLabel("SAVE") + "')]");
        if (flag)
         {
         logger.info("Requistion is openend in Edit mode");
         }
        else 
        {
         logger.info("Requisition is opened in View Mode")
        }
    return flag;
    },

    async clickOnReturnButton(){
        I.click(I.getElement(iBuyersDeskObject.REQ_RETURN_BUTTON));   
    },

    async clickonResubmitReq(){
     await I.waitForVisible(I.getElement(iBuyersDeskObject.BUTTON_REQ_RESUBMIT_YES),prop.DEFAULT_MEDIUM_WAIT);
     I.click(I.getElement(iBuyersDeskObject.BUTTON_REQ_RESUBMIT_YES));
     await commonKeywordImpl.waitForLoadingSymbolNotDisplayed();
     await I.waitForVisible(I.getElement(poListingObject.PO_NUMBER_LINK),prop.DEFAULT_MEDIUM_WAIT);

    },

    async clickonDoNotResubmitReq(){
        await I.waitForVisible(I.getElement(iBuyersDeskObject.BUTTON_REQ_RESUBMIT_YES),prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iBuyersDeskObject.BUTTON_REQ_RESUBMIT_NO));
        await commonKeywordImpl.waitForLoadingSymbolNotDisplayed();
        await I.waitForVisible(I.getElement(poListingObject.PO_NUMBER_LINK),prop.DEFAULT_MEDIUM_WAIT);
   
       },

    async fillReturnReqComments(comments) {
        await I.scrollIntoView(I.getElement(iBuyersDeskObject.RETURN_REQ_COMMENTS_TEXTAREA));
        await I.wait(prop.DEFAULT_WAIT);
        await I.scrollIntoView(I.getElement(iBuyersDeskObject.RETURN_REQ_COMMENTS_TEXTAREA));
        await I.wait(prop.DEFAULT_WAIT);
        await I.waitForVisible(I.getElement(iBuyersDeskObject.RETURN_REQ_COMMENTS_TEXTAREA));
        await I.click(I.getElement(iBuyersDeskObject.RETURN_REQ_COMMENTS_TEXTAREA));
        await I.clearField(I.getElement(iBuyersDeskObject.RETURN_REQ_COMMENTS_TEXTAREA));
        await I.fillField(I.getElement(iBuyersDeskObject.RETURN_REQ_COMMENTS_TEXTAREA), comments);
        logger.info(`Entered po amend comments --> ${comments}`);
    }, 

    async clickonReturnrequestorYes() {

        await I.click(I.getElement(iBuyersDeskObject.RESUBMIT_REQ_BUTTON_YES));
        await commonComponent.waitForLoadingSymbolNotDisplayed();
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

    async fetchSearchedRequestor()
   {
        I.waitForVisible(I.getElement(iBuyersDeskObject.REQUESTER_NAME_LISTING),prop.DEFAULT_MEDIUM_WAIT);
        let requestorName = await I.grabTextFrom(I.getElement(iBuyersDeskObject.REQUESTER_NAME_LISTING));
        return requestorName;
   },

   async verifyReqStatusAfterReSubmitReq(){
       let reqstatus = await I.grabTextFrom(I.getElement(iBuyersDeskObject.REQUISITION_STATUS_LISTING));
       let flag = true;
       if(reqstatus === lmtVar.getLabel("STATUS_IN_PROCESS"))
        {
            logger.info(`Requisition is in -> ${reqstatus}`);
            flag = true;
        }
        else if(reqstatus === lmtVar.getLabel("REJECTED_STATUS"))
        {
            logger.info(`Requisition is in -> ${reqstatus}`);
            flag = true;
        }
        else {
            throw new Error("Requistion is in any other status except ");
            flag = false;
        }

        return flag;
    },

   async navigateToAllRequests() {
    I.amOnPage(prop.DDS_AllRequests_Url);
    I.waitForVisible(I.getElement(iBuyersDeskObject.REQUISITION_NAME_LISTING),prop.DEFAULT_MEDIUM_WAIT);
    logger.info("Navigated to All Request Approval page");
   },

   async navigateToOnlineStore() {
    I.amOnPage(prop.DDS_OnlineStore_Url);
    I.waitForVisible(I.getElement(onlineStore.SEARCH_TEXTBOX),prop.DEFAULT_MEDIUM_WAIT);
    logger.info("Navigated to Online Store page");
   },

   async navigateToUpcomingRequisition() {
    I.amOnPage(global.confi_prop.DDS_UpcomingRequisitions_Url);
    logger.info("Navigated to Upcoming Requisitions Page");
   },

   async selectReceivedOnOption(option){
       let optionXpath =`(//label[@for='MST_Receivedonlk'])[2]`;
       let xpathIndex;
    if(option == "Create Date")
    {
        logger.info('Selected Received on option is : Create Date');
    }

    else if(option == "Date Within")
    {
        xpathIndex = 1;
        logger.info('Selected Received on option is : Date Within');    
    }

    else if(option == "Date Period")
    {
        xpathIndex = 2;
        logger.info('Selected Received on option is : Date Period');
    }

    else{
        throw new Error("Invalid search option!");
    }
    optionXpath = `(//label[@for='MST_Receivedonlk${xpathIndex}'])[2]`

   }
}

 
