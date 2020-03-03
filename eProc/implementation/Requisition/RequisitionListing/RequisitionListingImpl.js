const {I} = inject();
const reqListingObj = require("./RequisitionListingObject");
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const lmtVar = require("../../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const commomComponent = require("../../../commonKeywords/CommonComponent");
const prop = global.confi_prop;
const checkoutObject = require("../Checkout/CheckoutObject")
const checkoutImpl = require("../Checkout/CheckoutImpl");
const requisitionBO = require("../../../dataCreation/bo/Requisition");

module.exports = {

    async navigateToRequisitionListing() {
        await I.amOnPage(prop.DDS_Requisition_Listing);
        await commomComponent.waitForLoadingSymbolNotDisplayed();
        await I.waitForVisible(I.getElement(reqListingObj.REQUISITION_LISTING_PAGE));
        logger.info("Navigated to Requisition Listing page");
    },

    async isRequisitionListingPageDisplayed()
    {
        let flag = false;
        let noOfEle = await I.grabNumberOfVisibleElements(I.getElement(reqListingObj.REQUISITION_LISTING_PAGE));
        if(noOfEle>0)
        {
            flag = true;
            logger.info("Requistion Listing Page is Displayed");
        }
        else
        {
            logger.info("Requistion Listing Page is not Displayed");
        }
        return flag;
    },

    /**
     * getRequisitionNumber: Returns Requisition Number
     * @param {String} reqName 
     * @return {String} reqNumber
     */
    async getRequisitionNumber(reqName)
    {
        await commomComponent.searchDocOnListing(reqName, lmtVar.getLabel("SEARCH_BY_DOC_NAME_OR_DESCRIPTION"));
        let reqNumber = await commomComponent.getDocNumber(reqName);
        return reqNumber;
    },

    async searchRequisitionByReqNumber(reqNumber)
    {
        await commomComponent.searchDocOnListing(reqNumber,  lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
        await I.wait(prop.DEFAULT_MEDIUM_WAIT);
    },

    async viewRequisition(reqNumber)
    {
        await commomComponent.clickOnDocNumberLink();
        
    },

    /**
     * getRequisitionStatus: Returns Requisition Primary Status
     * @return reqStatus
     */
    async getRequisitionStatus()
    {
        await I.scrollIntoView(I.getElement(reqListingObj.REQUISITION_STATUS));
        await I.wait(prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForVisible(I.getElement(reqListingObj.REQUISITION_STATUS));
        let reqStatus = await I.grabTextFrom(I.getElement(reqListingObj.REQUISITION_STATUS));
        logger.info(`Requisition status is ---->${reqStatus}`);
        return reqStatus;
    },

    async clickOnEditAction()
    {
        await I.waitForVisible(I.getElement(reqListingObj.EDIT_ACTION));
        await I.waitForClickable(I.getElement(reqListingObj.EDIT_ACTION));
        await I.click(I.getElement(reqListingObj.EDIT_ACTION));
        logger.info("Clicked on Requisition Edit Link");
    },

    async editAndUpdateDraftRequisition(reqNumber, requisitionBO)
    {
        await this.navigateToRequisitionListing();
        await this.searchRequisitionByReqNumber(reqNumber);
        await this.clickOnEditAction();
        await commomComponent.waitForLoadingSymbolNotDisplayed();
        await I.waitForVisible(I.getElement(checkoutObject.REQUISITION_NAME));
        await checkoutImpl.fillOnBehalfOf(requisitionBO.onBehalfOf);
        await checkoutImpl.clickOnUpdateDraftButton();
        await commomComponent.waitForLoadingSymbolNotDisplayed();
    },

    async deleteRequisition(reqNumber)
    {
      await this.navigateToRequisitionListing();

       await this.searchRequisitionByReqNumber(reqNumber);

        let reqStatus = await reqListingImpl.getRequisitionStatus();
        if(reqStatus.toString().trim() === lmtVar.getLabel("DRAFT_STATUS"))
        {
            await commomComponent.clickOnActionMenuIcon();
            await commomComponent.clickOnActionMenuOption(lmtVar.getLabel("DELETE_ACTION"));
            if(await I.grabNumberOfVisibleElements(I.getElement(reqListingObj.DELETE_CONFIRM_POPUP))>0)
            {
                await I.waitForVisible(I.getElement(reqListingObj.DELETE_CONFIRM_YES_BUTTON))
                await I.waitForClickable(I.getElement(reqListingObj.DELETE_CONFIRM_YES_BUTTON));
                await I.click(I.getElement(reqListingObj.DELETE_CONFIRM_YES_BUTTON));
                await I.wait(prop.DEFAULT_MEDIUM_WAIT);
                if(await I.grabNumberOfVisibleElements(I.getElement(reqListingObj.DELETE_SUCCESS_MESSAGE))>0)
                {
                    await I.waitForVisible(I.getElement(reqListingObj.DELETE_SUCCESS_MESSAGE_OK_BUTTON));
                    I.click(I.getElement(reqListingObj.DELETE_SUCCESS_MESSAGE_OK_BUTTON));
                    logger.info("Clicked on OK Button");
                }
            }  
        }
    },


    async searchAndViewReqByName(reqName)
    {
        let reqNumber = await this.getRequisitionNumber(reqName);
        await this.searchRequisitionByReqNumber(reqNumber);
        await this.viewRequisition(reqNumber);
    },
};