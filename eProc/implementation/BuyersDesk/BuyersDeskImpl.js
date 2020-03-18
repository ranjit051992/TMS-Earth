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
const cartImpl = require("../Requisition/Cart/CartImpl");
const onlineStoreImpl = require("../Requisition/OnlineStore/OnlineStoreImpl");
const faker = require("faker");
const reqListingImpl = require("./../Requisition/RequisitionListing/RequisitionListingImpl");

module.exports = {

    async navigateToBuyerListing() {
        await I.amOnPage(prop.DDS_BuyersDesk_Url);
        await I.waitForVisible(I.getElement(poListingObject.PO_NUMBER_LINK));
        logger.info("Navigated to Buyers Desk listing page");
    },

    async clickonStatusFilterButton(){
        await I.click(I.getElement(iBuyersDeskObject.STATUS_FILTER));
    },
    
    async clickOnStatusApplyButton(){
        await I.click(I.getElement(iBuyersDeskObject.BUYER_DESK_STATUS_APPLY));  
        },

     async clickonRequestorFilter(){
         await I.click(I.getElement(iBuyersDeskObject.REQUESTOR_FILTER))
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
        let status = await I.grabTextFrom(I.getElement(iBuyersDeskObject.REQUISITION_STATUS_LISTING));
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
        let requestor = requesterName.toString().substring(0,requesterName.toString().indexOf('|'));
        logger.info('Requester Name is >> '+requestor);
        requisitionBo.requestor = requestor.toString().trim();
        logger.info('Requester after selector is '+requisitionBo.requestor);
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
        else if(reqstatus === lmtVar.getLabel("SOURCING_STATUS"))
        {
            logger.info(`Requisition is in -> ${reqstatus}`);
            flag = true;
        }
        else if(reqstatus === lmtVar.getLabel("CLOSED_STATUS"))
        {
            logger.info(`Requisition is in -> ${reqstatus}`);
            flag = true;
        }
        else if(reqstatus === lmtVar.getLabel("CANCELLED_STATUS"))
        {
            logger.info(`Requisition is in -> ${reqstatus}`);
            flag = true;
        }
        else if(reqstatus === lmtVar.getLabel("RELEASED_STATUS"))
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

   async clickOnReceivedOnFilter(){
    I.click(I.getElement(iBuyersDeskObject.RECEIVEDON_FILTER));
    logger.info('Clicked on Received on filter')
    },

   async selectReceivedOnOption(option){
       await this.clickOnReceivedOnFilter();
       let optionXpath =`(//label[@for='MST_Receivedonlk'])[2]`;
       let xpathIndex;
    if(option === lmtVar.getLabel("SEARCH_BY_CREATE_DATE"))
    {
        logger.info('Selected Received on option is : Create Date');
        let createDate = await this.selectCreateDate();
        requisitionBo.receivedOn = createDate;
    }

    else if(option === lmtVar.getLabel("SEARCH_BY_DATE_WITHIN"))
    {
        xpathIndex = 1;
        logger.info('Selected Received on option is : Date Within');
        await this.selectDateWithin(lmtVar.getLabel("DATE_WITHIN_LAST_WEEK")); 
    }

    else if(option === lmtVar.getLabel("SEARCH_BY_DATE_PERIOD"))
    {
        xpathIndex = 2;
        logger.info('Selected Received on option is : Date Period');
        await this.selectDatePeriod();
    }

    else{
        throw new Error("Invalid search option!");
    }
    optionXpath = `(//label[@for='MST_Receivedonlk${xpathIndex}'])[2]`
    await this.clickonApplyButton();

   },

   async clickOnSavePoAsDraftButton() {
    let buttonXpath = `//button[contains(@aria-label,'${lmtVar.getLabel("SAVE_PO_AS_DRAFT_BUTTON_TEXT")}')]`;
    await I.waitForVisible(buttonXpath);
    await I.click(buttonXpath);
    logger.info("Clicked on Save PO as Draft button");
   },

   async clickOnPoDetailsCheckbox() {
        await I.waitForVisible(I.getElement(iBuyersDeskObject.PO_DETAILS_CHECKBOX));
        await I.click(I.getElement(iBuyersDeskObject.PO_DETAILS_CHECKBOX));
        logger.info("Clicked on PO Details checkbox");
    },

    async clickOnSubmitPoButton() {
        await I.waitForVisible(I.getElement(iBuyersDeskObject.SUBMIT_PO_BUTTON));
        await I.click(I.getElement(iBuyersDeskObject.SUBMIT_PO_BUTTON));
        logger.info("Clicked on Submit PO button");
    },

    async clickOnConvertToPoConfirmYesButton() {
        await I.waitForVisible(I.getElement(iBuyersDeskObject.CONVERT_TO_PO_CONFIRM_YES_BUTTON));
        await I.click(I.getElement(iBuyersDeskObject.CONVERT_TO_PO_CONFIRM_YES_BUTTON));
        logger.info("Clicked on Convert to PO confirm Yes button");
    },
    async selectDateWithin(option){
        let xpath =`//dew-popover-body//button[contains(text(),'${option}')]`
        await I.waitForVisible(xpath,prop.DEFAULT_MEDIUM_WAIT);
        await I.click(xpath);    
       },
    
       async selectDatePeriod()
       {
           let startDate = await this.selectStartDate();
           let endDate = await this.selectEndDate();
       },
    
       async selectStartDate() {
        logger.info("Selecting Start date");
            let day = new Date().getDate();
            day = day - 2;
            let dayXpath = `//div[text()='${day}']/..`;
            await I.click(I.getElement(iBuyersDeskObject.START_DATE_TEXTBOX));
            let numberOfElements = await I.grabNumberOfVisibleElements(dayXpath);
            for (let i = 0; i < numberOfElements; i++) {
                dayXpath = `(//div[text()='${day}']/..)[${i + 1}]`;
                try {
                    await I.waitForEnabled(dayXpath, 2);
                    logger.info(`Date enabled for xpath --> ${dayXpath}`);
                    I.click(dayXpath);
                    logger.info(`Clicked on date ${day}`);
                    break;
                } catch (e) {
                    logger.info(`Date disabled for xpath --> ${dayXpath}`);
                }
    
                if (i == numberOfElements) {
                    throw new Error(`Day --> ${day} not present in the datepicker`);
                }
            }
            let startDate = await I.grabAttributeFrom(I.getElement(iBuyersDeskObject.START_DATE_TEXTBOX),"value");
            logger.info("Start Date selected is : "+startDate);
            return startDate;
        },
    
        async selectEndDate() {
            logger.info("Selecting End date");
                let day = new Date().getDate();
                let dayXpath = `//div[text()='${day}']/..`;
                await I.click(I.getElement(iBuyersDeskObject.END_DATE_TEXTBOX));
                let numberOfElements = await I.grabNumberOfVisibleElements(dayXpath);
                for (let i = 0; i < numberOfElements; i++) {
                    dayXpath = `(//div[text()='${day}']/..)[${i + 1}]`;
                    try {
                        await I.waitForEnabled(dayXpath, 2);
                        logger.info(`Date enabled for xpath --> ${dayXpath}`);
                        I.click(dayXpath);
                        logger.info(`Clicked on date ${day}`);
                        break;
                    } catch (e) {
                        logger.info(`Date disabled for xpath --> ${dayXpath}`);
                    }
        
                    if (i == numberOfElements) {
                        throw new Error(`Day --> ${day} not present in the datepicker`);
                    }
                }
                let endDate = await I.grabAttributeFrom(I.getElement(iBuyersDeskObject.END_DATE_TEXTBOX),"value");
                logger.info("End Date selected is : "+endDate);
                return endDate;
        },
    
        async selectCreateDate() {
            logger.info("Selecting Create date");
                let day = new Date().getDate();
                let dayXpath = `//div[text()='${day}']/..`;
                await I.click(I.getElement(iBuyersDeskObject.CREATE_DATE_TEXTBOX));
                let numberOfElements = await I.grabNumberOfVisibleElements(dayXpath);
                for (let i = 0; i < numberOfElements; i++) {
                    dayXpath = `(//div[text()='${day}']/..)[${i + 1}]`;
                     try {
                        await I.waitForEnabled(dayXpath, 2);
                        logger.info(`Date enabled for xpath --> ${dayXpath}`);
                        I.click(dayXpath);
                        logger.info(`Clicked on date ${day}`);
                        break;
                    } catch (e) {
                        logger.info(`Date disabled for xpath --> ${dayXpath}`);
                    }
            
                    if (i == numberOfElements) {
                            throw new Error(`Day --> ${day} not present in the datepicker`);
                    }
                }
                let createDate = await I.grabAttributeFrom(I.getElement(iBuyersDeskObject.CREATE_DATE_TEXTBOX),"value");
                logger.info("Create Date selected is : "+createDate);
                return createDate;
        },
    
        async verifyReceivedOn(){
            let fetchedReceivedOn = await this.FetchReceivedOn();
            let flag = true;
            if(fetchedReceivedOn == requisitionBo.receivedOn)
             {
                 logger.info(`Fetched Received On Date is -> ${fetchedReceivedOn}`);
                 flag = true;
             }
             else{
                 logger.info(`Fetched Received On Date is -> ${fetchedReceivedOn}`);
                 flag = false;
             }
     
             return flag;
         },
    
         async FetchReceivedOn()
       {
            I.waitForVisible(I.getElement(iBuyersDeskObject.RECEIVED_ON_LISTING),prop.DEFAULT_MEDIUM_WAIT);
            let receivedOn = await I.grabTextFrom(I.getElement(iBuyersDeskObject.RECEIVED_ON_LISTING));
            return receivedOn;
        },
    
        async clickOnPoDetailsCheckbox() {
         await I.waitForVisible(I.getElement(iBuyersDeskObject.PO_DETAILS_CHECKBOX));
         await I.click(I.getElement(iBuyersDeskObject.PO_DETAILS_CHECKBOX));
         logger.info("Clicked on PO Details checkbox");
         },
     
         async clickOnSubmitPoButton() {
         await I.waitForVisible(I.getElement(iBuyersDeskObject.SUBMIT_PO_BUTTON));
         await I.click(I.getElement(iBuyersDeskObject.SUBMIT_PO_BUTTON));
         logger.info("Clicked on Submit PO button");
        },


        async verifyBuyer(){
            let flag = true;
            let searchedBuyer = await this.fetchSearchedBuyer();
            logger.info('Searched Buyer is '+searchedBuyer);
                      
            if(searchedBuyer.includes(requisitionBo.buyer))
             {
                 logger.info(`Fetched Buyer is -> ${searchedBuyer}`);
                 flag = true;
             }
             else if(searchedBuyer.toString().includes('More')){
                logger.info('Buyer is Hidden');
                let noOfbuyers = await I.grabTextFrom(I.getElement(iBuyersDeskObject.BUYER_NAME_PLUSMORE));
                noOfbuyers = noOfbuyers.toString().charAt(1);
                logger.info('Number of buyers hidden are '+noOfbuyers)
                await I.moveCursorTo(I.getElement(iBuyersDeskObject.BUYER_NAME_PLUSMORE));
                logger.info('Mouse over on +More')
                for(let x=0;x<noOfbuyers;x++){
                    let xpath = `/html/body/ngb-tooltip-window/div[2]/div/div[${x+1}]`
                    let hiddenBuyer =  await I.grabAttributeFrom(xpath,"textContent");
                    if(hiddenBuyer.toString().trim==requisitionBo.buyer.toString().trim){
                        logger.info('Fetched Hidden buyer is >> '+hiddenBuyer);
                        flag = true;
                        break;
                    }
                }

            }
             else{
                 logger.info(`Fetched Buyer is -> ${searchedBuyer}`);
                 flag = false;
             }
     
             return flag;
         },

    async selectSubmiitedOnOption(option){
        await this.clickOnSubmittedOnFilter();
        if(option === lmtVar.getLabel("SEARCH_BY_CREATE_DATE"))
        {
            logger.info('Selected Submitted on option is : Create Date');
            let createDate = await this.selectCreateDate();
            requisitionBo.receivedOn = createDate;
        }
     
        else if(option === lmtVar.getLabel("SEARCH_BY_DATE_WITHIN"))
        {
            logger.info('Selected Submitted on option is : Date Within');
            await this.selectDateWithin(lmtVar.getLabel("DATE_WITHIN_LAST_WEEK")); 
        }
     
        else if(option === lmtVar.getLabel("SEARCH_BY_DATE_PERIOD"))
        {
            logger.info('Selected Submitted on option is : Date Period');
            await this.selectDatePeriod();
        }
     
        else{
            throw new Error("Invalid search option!");
        }
        await this.clickonApplyButton();
     
    },

    async clickOnSubmittedOnFilter(){
        I.click(I.getElement(iBuyersDeskObject.SUBMITTEDON_FILTER));
        logger.info('Clicked on Submitted on filter')
    },

    async verifySubmittedOn(){
        let fetchedSubmittedOn = await this.FetchSubmittedOn();
        let flag = true;
        if(fetchedSubmittedOn == requisitionBo.receivedOn)
         {
             logger.info(`Fetched Submiited On Date is -> ${fetchedSubmittedOn}`);
             flag = true;
         }
         else{
             logger.info(`Fetched Submitted On Date is -> ${fetchedSubmittedOn}`);
             flag = false;
         }
 
         return flag;
    },

    async FetchSubmittedOn()
   {
        I.waitForVisible(I.getElement(iBuyersDeskObject.RECEIVED_ON_LISTING),prop.DEFAULT_MEDIUM_WAIT);
        let submittedOn = await I.grabTextFrom(I.getElement(iBuyersDeskObject.RECEIVED_ON_LISTING));
        return submittedOn;
    },

    async addCatalogItem(requisitionBO) {
        await onlineStoreImpl.navigateToOnlineStore();
        await cartImpl.clearCart();
        await onlineStoreImpl.addItemToCart(requisitionBO.itemName, faker.random.number(20));
    },

    async selectReqStatusFilter(status){
      let index;
      let selectedStatus;
      await I.waitForVisible(I.getElement(iBuyersDeskObject.FILTER_BUTTON),prop.DEFAULT_MEDIUM_WAIT);
      await I.click(I.getElement(iBuyersDeskObject.FILTER_BUTTON));
      await I.fillField(I.getElement(iBuyersDeskObject.FILTER_SEARCH_BOX),lmtVar.getLabel("STATUS_COLUMN"));
        if(status === lmtVar.getLabel("STATUS_IN_PROCESS"))
         {
           index = 1;
           logger.info("Requisition Status to be searched is : In Process");
         }
         else if (status === lmtVar.getLabel("SOURCING_STATUS"))
         {
            index = 2;
            logger.info("Requisition Status to be searched is : Sourcing Status");
         }
         else if (status === lmtVar.getLabel("RELEASED_STATUS"))
         {
            index = 3;
            logger.info("Requisition Status to be searched is : Released");
         }
         else if (status === lmtVar.getLabel("REJECTED_STATUS"))
         {
            index = 4;
            logger.info("Requisition Status to be searched is : Rejected");
         }
         else if (status === lmtVar.getLabel("CANCELLED_STATUS"))
         {
            index = 5;
            logger.info("Requisition Status to be searched is : Cancelled");
         }
         else if (status === lmtVar.getLabel("CLOSED_STATUS"))
         {
            index = 6;
            logger.info("Requisition Status to be searched is : Closed");
         }
         else
         {
             throw new Error("Invalid status search option");
             
         }

         let xpath = `(//dew-master-filter//dew-checkbox//label)[${index}]`;
         I.waitForVisible(xpath);
         I.click(xpath);
         I.waitForClickable(I.getElement(iBuyersDeskObject.FILTER_APPLY_BUTTON),prop.DEFAULT_MEDIUM_WAIT);
         I.click(I.getElement(iBuyersDeskObject.FILTER_APPLY_BUTTON));
         await commonComponent.waitForLoadingSymbolNotDisplayed();
    },

    async clickonViewReq()
    {
      let clickOnView = `(//dew-row[contains(@class,'scrolling')]//a[contains(text(),'${lmtVar.getLabel("VIEW_ACTION")}')])[1]`;
      I.waitForVisible(clickOnView);
      I.click(clickOnView);
    },

    async verifyBuyerOnRequisitionPage()
    {
        await reqListingImpl.navigateToRequisitionListing();
        await commonComponent.clickOnDocNumberLink();
        commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));
        I.click(I.getElement(iBuyersDeskObject.BUYER_LINK_LINEITEM));
        let buyer = await I.grabTextFrom(I.getElement(iBuyersDeskObject.ASSIGNED_BUYER_REQUISITION));
        return buyer;
    },

    
    
}

 
