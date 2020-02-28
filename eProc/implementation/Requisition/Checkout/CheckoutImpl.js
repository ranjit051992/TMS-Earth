const iCheckout= require("./CheckoutObject");
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const commonComponent = require("../../../commonKeywords/CommonComponent");
const lmtVar = require("../../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const prop = global.confi_prop;
//const requisitionBO = require("/..");

module.exports={

 /** 
     * enterRequisitionName Enters Requsition Name
     * 
     * @param reqName
     * @returns reqName  
     * 
    */
    async enterRequisitionName(reqName)
    {
        I.waitForVisible(I.getElement(iCheckout.REQUISITION_NAME), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(I.getElement(iCheckout.REQUISITION_NAME), prop.DEFAULT_MEDIUM_WAIT);
        I.clearField(I.getElement(iCheckout.REQUISITION_NAME));
        I.fillField(I.getElement(iCheckout.REQUISITION_NAME), reqName);
        reqName = await I.grabTextFrom(I.getElement(iCheckout.REQUISITION_NAME));
        logger.info(`Entered Requisition Name: ${reqName}`);
        return reqName;
    },

    /** 
     * Fill onBehalfOf value
     * 
     * @param onBehalfOf
     * @returns onBehalfOf  
     * 
    */
    async fillOnBehalfOf(onBehalfOf)
    {
        I.waitForVisible(I.getElement(iCheckout.ON_BEHALF_OF), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(I.getElement(iCheckout.ON_BEHALF_OF), prop.DEFAULT_MEDIUM_WAIT);
        commonComponent.searchAndSelectFromDropdown(I.getElement(iCheckout.ON_BEHALF_OF), onBehalfOf);
        
        onBehalfOf = await I.grabTextFrom(I.getElement(iCheckout.ON_BEHALF_OF));
        logger.info(`Entered OnBehalf of : ${onBehalfOf}`);
        return onBehalfOf;
    },

     /** 
     * click on Buying Unit Edit Button
     * 
    */
    clickOnBuyingUnitEditButton()
    {
        I.waitForVisible(I.getElement(iCheckout.BUYING_UNIT_EDIT_ICON), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(I.getElement(iCheckout.BUYING_UNIT_EDIT_ICON), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iCheckout.BUYING_UNIT_EDIT_ICON));
        logger.info("Clicked on buying Unit Edit Button");
    },

     /** 
     * fillCompany Fills Company value
     * 
     * @param companyName
     * @returns companyName  
     * 
    */
    async fillCompany(companyName)
    {
        I.waitForVisible(I.getElement(iCheckout.COMPANY_NAME), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(I.getElement(iCheckout.COMPANY_NAME), prop.DEFAULT_MEDIUM_WAIT);
        commonComponent.searchAndSelectFromDropdown(I.getElement(iCheckout.COMPANY_NAME), companyName);
        companyName = await I.grabTextFrom(I.getElement(iCheckout.COMPANY_NAME));
        logger.info(`Entered Company Name: ${companyName}`);
        return companyName;
    },

    /**
     * fillBusinessUnit Fills Businessunit value
     * 
     * @param businessUnit
     * @returns businessUnit
     */
    async fillBusinessUnit(businessUnit)
    {
        I.waitForVisible(I.getElement(iCheckout.BUSINESS_UNIT), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(I.getElement(iCheckout.BUSINESS_UNIT), prop.DEFAULT_MEDIUM_WAIT);
        commonComponent.searchAndSelectFromDropdown(I.getElement(iCheckout.BUSINESS_UNIT), businessUnit);
        businessUnit = await I.grabTextFrom(I.getElement(iCheckout.BUSINESS_UNIT));
        logger.info(`Entered Business unit: ${businessUnit}`);
        return businessUnit;
    },

      /**
     * fillLocation Fills Location value
     * 
     * @param location
     * @returns location
     */
    async fillLocation(location)
    {
        I.waitForVisible(I.getElement(iCheckout.LOCATION), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(I.getElement(iCheckout.LOCATION), prop.DEFAULT_MEDIUM_WAIT);
        commonComponent.searchAndSelectFromDropdown(I.getElement(iCheckout.LOCATION),location);
        location = await I.grabTextFrom(I.getElement(iCheckout.LOCATION));
        logger.info(`Entered Business unit: ${location}`);
        return location;
    },

       /**
     * fillLocation Fills Currency value
     * 
     * @param currency
     * @returns currency
     */
    async fillCurrency(currency)
    {
        I.waitForVisible(I.getElement(iCheckout.CURRENCY), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(I.getElement(iCheckout.CURRENCY), prop.DEFAULT_MEDIUM_WAIT);
        commonComponent.searchAndSelectFromDropdown(I.getElement(iCheckout.CURRENCY), currency);
        location = await I.grabTextFrom(I.getElement(iCheckout.CURRENCY));
        logger.info(`Entered Business unit: ${currency}`);
        return currency;
    },

    /**
     * clickOnBuyingUnitDoneButton clicks on Buying Unit Done Button
     */
    clickOnBuyingUnitDoneButton()
    {
        I.waitForVisible(I.getElement(iCheckout.BUYING_UNIT_DONE_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(I.getElement(iCheckout.BUYING_UNIT_DONE_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iCheckout.BUYING_UNIT_DONE_BUTTON));
        logger.info("Clicked on Buying Inut Done Button");
    },

    clickOnUrgentRequirementYesButton()
    {
        I.waitForVisible(I.getElement(iCheckout.URGENT_REQUIREMENT_YES_RADIO_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(I.getElement(iCheckout.URGENT_REQUIREMENT_YES_RADIO_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iCheckout.URGENT_REQUIREMENT_YES_RADIO_BUTTON));
        logger.info("Clicked on UrgentRequirement Yes Button ");
    },

    clickOnUrgentRequirementNoButton()
    {
        I.waitForVisible(I.getElement(iCheckout.URGENT_REQUIREMENT_NO_RADIO_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(I.getElement(iCheckout.URGENT_REQUIREMENT_NO_RADIO_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iCheckout.URGENT_REQUIREMENT_NO_RADIO_BUTTON));
        logger.info("Clicked on UrgentRequirement NO Button ");
    },

    /**
     * clickOnReasonForOrderingLink 
     */
    clickOnReasonForOrderingLink()
    {
        I.waitForVisible(I.getElement(iCheckout.REASON_FOR_ORDERING_LINK), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(I.getElement(iCheckout.REASON_FOR_ORDERING_LINK), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iCheckout.REASON_FOR_ORDERING_LINK));
        logger.info("Cliked on Reason For Ordering Link ");
    },

    /**
     * enterReasonForOrdering enters Reason for ordering comments
     * @param {*} reasonForOrdering 
     */
    async enterReasonForOrdering(reasonForOrdering)
    {
        I.waitForVisible(I.getElement(iCheckout.REASON_FOR_ORDERING_TEXTAREA), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(I.getElement(iCheckout.REASON_FOR_ORDERING_TEXTAREA), prop.DEFAULT_MEDIUM_WAIT);
        I.clearField(I.getElement(iCheckout.REASON_FOR_ORDERING_TEXTAREA));
        I.fillField(I.getElement(iCheckout.REASON_FOR_ORDERING_TEXTAREA), reasonForOrdering);
        reasonForOrdering = await I.grabTextFrom(I.getElement(iCheckout.REASON_FOR_ORDERING_TEXTAREA));
        logger.info(`Entered Reason For Ordering ${reasonForOrdering}`);
        return reasonForOrdering;
    },
    /**
     * clickOnCommentsForSupplierLink 
     */
    clickOnCommentsForSupplierLink()
    {
        I.waitForVisible(I.getElement(iCheckout.COMMENTS_FOR_SUPPLIER_LINK), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(I.getElement(iCheckout.COMMENTS_FOR_SUPPLIER_LINK), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iCheckout.COMMENTS_FOR_SUPPLIER_LINK));
        logger.info("Cliked on Comments For Supplier Link ");
    },

      /**
     * enterCommentsForSupplier enters comments for Supplier
     * @param {*} reasonForOrdering 
     */
    async enterCommentsForSupplier(commentForSupplier)
    {
        I.waitForVisible(I.getElement(iCheckout.COMMENTS_FOR_SUPPLIER_TEXTAREA), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(I.getElement(iCheckout.COMMENTS_FOR_SUPPLIER_TEXTAREA), prop.DEFAULT_MEDIUM_WAIT);
        I.clearField(I.getElement(iCheckout.COMMENTS_FOR_SUPPLIER_TEXTAREA));
        I.fillField(I.getElement(iCheckout.COMMENTS_FOR_SUPPLIER_TEXTAREA), commentForSupplier);
        commentForSupplier = await I.grabTextFrom(I.getElement(iCheckout.COMMENTS_FOR_SUPPLIER_TEXTAREA));
        logger.info(`Entered Comments For Supplier ${commentForSupplier}`);
        return commentForSupplier;
    },

    /**
     * selectPurchaseType selects Purchase Type from drop down
     * @param {*} purchaseType 
     */
    async selectPurchaseType(purchaseType)
    {
        commonComponent.selectValueFromDropDown(I.getElement(iCheckout.PURCHASE_TYPE), purchaseType);
        purchaseType = await I.grabTextFrom(I.getElement(iCheckout.PURCHASE_TYPE));
        return purchaseType;
    },

    async selectSettlementVia(settlementVia)
    {
        commonComponent.selectValueFromDropDown(I.getElement(iCheckout.SETTLEMENT_VIA), settlementVia);
        settlementVia = await I.grabTextFrom(I.getElement(iCheckout.SETTLEMENT_VIA));
        return settlementVia;
    },

    clickOnRetrospectivePurchaseYesButton()
    {
        I.waitForVisible(I.getElement(iCheckout.RETROSPECTIVE_PURCHASE_YES_RADIO_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(I.getElement(iCheckout.RETROSPECTIVE_PURCHASE_YES_RADIO_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iCheckout.RETROSPECTIVE_PURCHASE_YES_RADIO_BUTTON));
        logger.info("Click On Retrospective Purchase Yes Button");
    },

    clickOnRetrospectivePurchaseNoButton()
    {
        I.waitForVisible(I.getElement(iCheckout.RETROSPECTIVE_PURCHASE_NO_RADIO_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(I.getElement(iCheckout.RETROSPECTIVE_PURCHASE_NO_RADIO_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iCheckout.RETROSPECTIVE_PURCHASE_NO_RADIO_BUTTON));
        logger.info("Click On Retrospective Purchase No Button");
    },

    selectPurchaseOrder(purchaseOrder)
    {

    },

    addAttachments(attachmentFile)
    {

    },

    /**
     * getDefaultShippingAddress fetched Default shipping address
     */
    async getDefaultShippingAddress()
    {
        I.waitForVisible(I.getElement(iCheckout.DEFAULT_SHIPPING_ADDRESS), prop.DEFAULT_MEDIUM_WAIT);
        let shippingAddress = await I.grabTextFrom(I.getElement(iCheckout.DEFAULT_SHIPPING_ADDRESS));
        logger.info(`Default Shipping Address is ${shippingAddress}`);
        return shippingAddress;
    },

    /**
     * fillDeliverTo fills the Deliver To
     * @param {*} deliverTo 
     */
    async fillDeliverTo(deliverTo)
    {
        I.waitForVisible(I.getElement(iCheckout.DELIVER_TO), prop.DEFAULT_MEDIUM_WAIT);
        commonComponent.searchAndSelectFromDropdown(I.getElement(iCheckout.DELIVER_TO), deliverTo);
        deliverTo =  await I.grabTextFrom(I.getElement(iCheckout.DELIVER_TO));
        logger.info(`Entered Deliver To is ${deliverTo}`);
        return deliverTo;
    },

   selectRequiredBy()
    {

    },

    /**
     * clickOnAssignCostYesButton clicks on Assign Cost Project YES radio Button
     */
    clickOnAssignCostProjectYesButton()
    {
        I.waitForVisible(I.getElement(iCheckout.ASSIGN_COST_PROJECT_YES), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(I.getElement(iCheckout.ASSIGN_COST_PROJECT_YES), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iCheckout.ASSIGN_COST_PROJECT_YES));
        logger.info("Clicked On Assign Cost Project YES Button");
    },

       /**
     * clickOnAssignCostNoButton clicks on Assign Cost Project NO radio Button
     */
    clickOnAssignCostProjectNoButton()
    {
        I.waitForVisible(I.getElement(iCheckout.ASSIGN_COST_PROJECT_NO), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(I.getElement(iCheckout.ASSIGN_COST_PROJECT_NO), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iCheckout.ASSIGN_COST_PROJECT_NO));
        logger.info("Clicked On Assign Cost Project NO Button");
    },

    /**
     * fillCostCenter: Fills Cost Center
     * @param {*} costCenter 
     */
    async fillCostCenter(costCenter)
    {
        I.waitForVisible(I.getElement(iCheckout.COST_CENTER), prop.DEFAULT_MEDIUM_WAIT);
        commonComponent.searchAndSelectFromDropdown(I.getElement(iCheckout.COST_CENTER), costCenter);
        costCenter = await I.grabTextFrom(I.getElement(iCheckout.COST_CENTER));
        logger.info(`Entered Cost Center is : ${costCenter}`);
        return costCenter;
    },

    /**
     * clickOnCostBookingLink: Clicks on Cost booking link for specified item
     * @param {*} itemName 
     */
    clickOnCostBookingLink(itemName)
    {   
        let path = `//span[contains(text(),'${itemName}')]//ancestor::dew-row//following-sibling::dew-row//dew-flex-item[3]`;
        I.waitForVisible(path, prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(path, prop.DEFAULT_MEDIUM_WAIT);
        I.click(path);
        logger.info("Clicked on Cost Booking Details link");
    },

    /**
     * fillGLAccount: fills GL Account
     * @param {*} glAccount 
     */
    async fillGLAccount(glAccount)
    {
        I.waitForVisible(I.getElement(iCheckout.GL_ACCOUNT), prop.DEFAULT_MEDIUM_WAIT);
        commonComponent.searchAndSelectFromDropdown(I.getElement(iCheckout.GL_ACCOUNT), glAccount);
        glAccount = await I.grabTextFrom(I.getElement(iCheckout.GL_ACCOUNT));
        logger.info(`GL Account is: ${glAccount}`);
        return glAccount;
    },

      /**
     * fillAssetCode: fills Asset Code
     * @param {*} glAccount 
     */
    async fillAssetCode(assetCode)
    {
        I.waitForVisible(I.getElement(iCheckout.ASSET_CODE), prop.DEFAULT_MEDIUM_WAIT);
        commonComponent.searchAndSelectFromDropdown(I.getElement(iCheckout.ASSET_CODE), assetCode);
        assetCode = await I.grabTextFrom(I.getElement(iCheckout.ASSET_CODE));
        logger.info(`Asset Code is: ${assetCode}`);
        return assetCode;
    },

    /**
     * clickOnTab: Clicks on specified Tab Name
     * @param {*} tabName 
     */
    clickOnTab(tabName)
    {
        let path = `//dew-default-tab-head[contains(text(),'${tabName}')]`;
        I.waitForVisible(path, prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(path, prop.DEFAULT_MEDIUM_WAIT);
        I.click();
        logger.info("Clicked on tab "+tabName);
    },

    selectBuyerDropDownOption(buyerOption)
    {
        commonComponent.selectValueFromDropDown(global.uiElements.ge(iCheckout.BUYER_DROPDOWN_ICON), buyerOption);
    },

    /**
     * fillBuyerInTextBox: fills Buyer in text box
     * @param {*} buyerName 
     */
    async fillBuyerInTextBox(buyerName)
    {
        I.waitForVisible(I.getElement(iCheckout.BUYER_TEXTBOX), prop.DEFAULT_MEDIUM_WAIT);
        commonComponent.searchAndSelectFromDropdown(I.getElement(iCheckout.BUYER_TEXTBOX), buyerName);
        buyerName = await I.grabTextFrom(I.getElement(iCheckout.BUYER_TEXTBOX));
        logger.info(`Entered Buyer is: ${buyerName}`);
        return buyerName;
    },

    /**
     * clickInCostBookingSaveButton: clicks on line Level details Save button
     */
    clickInCostBookingSaveButton()
    {
        I.waitForVisible(I.getElement(iCheckout.COST_BOOKING_SAVE_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(I.getElement(iCheckout.COST_BOOKING_SAVE_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iCheckout.COST_BOOKING_SAVE_BUTTON));
        logger.info("Clicked on Cost Booking Save Button");
    },

    /**
     * clickOnImDoneButton: clicks on I M Done Button
     */
    clickOnImDoneButton()
    {
        I.waitForVisible(I.getElement(iCheckout.I_M_DONE_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(I.getElement(iCheckout.I_M_DONE_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iCheckout.I_M_DONE_BUTTON));
        logger.info("Clicked on I M Button");
    },

      /**
     * clickOnSaveAsDraftButton: clicks on Save As Draft Button
     */
    clickOnSaveAsDraftButton()
    {
        I.waitForVisible(I.getElement(iCheckout.SAVE_AS_DRAFT), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(I.getElement(iCheckout.SAVE_AS_DRAFT), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iCheckout.SAVE_AS_DRAFT));
        logger.info("Clicked on Save As Draft Button");
    },

      /**
     * clickOnCancelButton: clicks on Cancel Button
     */
    clickOnCancelButton()
    {
        I.waitForVisible(I.getElement(iCheckout.CANCEL_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(I.getElement(iCheckout.CANCEL_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iCheckout.CANCEL_BUTTON));
        logger.info("Clicked on Cancel Button");
    },

     /**
     * clickOnContinueButton: clicks on Contine Button
     */
    clickOnContinueButton()
    {
        I.waitForVisible(I.getElement(iCheckout.CONTINUE_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(I.getElement(iCheckout.CONTINUE_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.click(I.getElement(iCheckout.CONTINUE_BUTTON));
        logger.info("Clicked on Continue Button");
    },

    async fillBasicDetails(requisitionBO)
    {
        logger.info("*********Filling Requisition Basic Details");
        if(requisitionBO.reqName !== "null")
        {
           let reqName =  this.enterRequisitionName(requisitionBO.reqName);
           requisitionBO.setReqName(reqName);
        }

        if(requisitionBO.onBehalfOf !== "null")
        {
            let onBehalfOf = this.fillOnBehalfOf(requisitionBO.onBehalfOf);
            requisitionBO.setOnBehalfOf(onBehalfOf);
        }

        if(requisitionBO.fillCBL === true)
        {
            logger.info("****Filling CBL ****");
            this.clickOnBuyingUnitEditButton();

            let company = fillCompany(requisitionBO.company);
            requisitionBO.setCompany(company);

            let businessUnit = this.fillBusinessUnit(requisitionBO.businessUnit);
            requisitionBO.businessUnit(businessUnit);

            let location = this.fillLocation(requisitionBO.location);
            requisitionBO.setLocation(location);

            let currency = this.fillCurrency(requisitionBO.currency);
            requisitionBO.setCurrency(currency);

            this.clickOnBuyingUnitDoneButton();
        }

        if(requisitionBO.urgentRequirement === "Yes")
        {
            this.clickOnUrgentRequirementYesButton();
        }
        else
        {
            this.clickOnUrgentRequirementNoButton();
        }

        if(requisitionBO.reasonForOrdering !== "null")
        {
            this.clickOnReasonForOrderingLink();
            let reasonForOrdering = this.enterReasonForOrdering(requisitionBO.reasonForOrdering);
            requisitionBO.setReasonForOrdering(reasonForOrdering);
        }

        if(requisitionBO.commentsForSupplier !== "null")
        {
            this.clickOnCommentsForSupplierLink();
            let commentsForSupplier = this.enterCommentsForSupplier(requisitionBO.commentsForSupplier);
            requisitionBO.setCommentsForSupplier(commentsForSupplier);
        }

        return requisitionBO;

    },


    async fillAdditionalDetails(requisitionBO)
    {
        commonComponent.scrollToSection(lmtVar.getLabel(ADDITIONAL_DETAILS));
        return requisitionBO;
    }
};