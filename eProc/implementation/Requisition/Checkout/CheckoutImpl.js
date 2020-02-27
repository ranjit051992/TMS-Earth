const { I } = inject();
const iCheckout= require("./CheckoutObject");
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const commonComponent = require("../..//..//commonComponent/CommonComponent");
const prop = require("../../../../Framework/PropertiesConfigurator");
const ObjectCreation = require("../../../dataCreation/ObjectCreation");
const iConstants = require("../../../../eProc/constants/iConstants");
const requisitionBO = require("../../../bo/Requisition");

module.exports={

       /**
     * createRequisitionFlow: Creats a Requisition
     * @param {*} requisitionBO 
     * @ return requisitionBO
     */
    async createRequisitionFlow(requisitionBO)
    { 
        requisitionBO = await this.fillBasicDetails(requisitionBO);

        requisitionBO = await this.fillAdditionalDetails(requisitionBO);

        requisitionBO = await this.fillShippingDetails(requisitionBO);

        requisitionBO = await this.fillCostAllocation(requisitionBO);

        requisitionBO = await this. fillItemDetails(requisitionBO);

        if(requisitionBO.nextAction === iConstants.SUBMIT)
        {
            this.clickOnImDoneButton();
            I.wait(prop.DEFAULT_MEDIUM_WAIT);
            this.clickOnContinueButton();
            commonComponent.waitForLoadingSymbolNotDisplayed();
        }

        else if(requisitionBO.nextAction === iConstants.SAVE_AS_DRAFT)
        {
            this.clickOnSaveAsDraftButton();
           
        }

        else if(requisitionBO.nextAction === iConstants.CANCEL)
        {
            this.clickOnCancelButton();
        }

        return requisitionBO;

    },

 /** 
     * enterRequisitionName Enters Requsition Name
     * 
     * @param reqName
     * @returns reqName  
     * 
    */
    async enterRequisitionName(reqName)
    {
        I.waitForVisible(global.uiElements.get(iCheckout.REQUISITION_NAME), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(global.uiElements.get(iCheckout.REQUISITION_NAME), prop.DEFAULT_MEDIUM_WAIT);
        I.clearField(global.uiElements.get(iCheckout.REQUISITION_NAME));
        I.fillField(global.uiElements.get(iCheckout.REQUISITION_NAME), reqName);
        reqName = await I.grabTextFrom(global.uiElements.get(iCheckout.REQUISITION_NAME));
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
        I.waitForVisible(global.uiElements.get(iCheckout.ON_BEHALF_OF), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(global.uiElements.get(iCheckout.ON_BEHALF_OF), prop.DEFAULT_MEDIUM_WAIT);
        commonComponent.searchAndSelectFromDropdown(global.uiElements.get(iCheckout.ON_BEHALF_OF), onBehalfOf);
        
        onBehalfOf = await I.grabTextFrom(global.uiElements.get(iCheckout.ON_BEHALF_OF));
        logger.info(`Entered OnBehalf of : ${onBehalfOf}`);
        return onBehalfOf;
    },

     /** 
     * click on Buying Unit Edit Button
     * 
    */
    clickOnBuyingUnitEditButton()
    {
        I.waitForVisible(global.uiElements.get(iCheckout.BUYING_UNIT_EDIT_ICON), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(global.uiElements.get(iCheckout.BUYING_UNIT_EDIT_ICON), prop.DEFAULT_MEDIUM_WAIT);
        I.click(global.uiElements.get(iCheckout.BUYING_UNIT_EDIT_ICON));
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
        I.waitForVisible(global.uiElements.get(iCheckout.COMPANY_NAME), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(global.uiElements.get(iCheckout.COMPANY_NAME), prop.DEFAULT_MEDIUM_WAIT);
        commonComponent.searchAndSelectFromDropdown(global.uiElements.get(iCheckout.COMPANY_NAME), companyName);
        companyName = await I.grabTextFrom(global.uiElements.get(iCheckout.COMPANY_NAME));
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
        I.waitForVisible(global.uiElements.get(iCheckout.BUSINESS_UNIT), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(global.uiElements.get(iCheckout.BUSINESS_UNIT), prop.DEFAULT_MEDIUM_WAIT);
        commonComponent.searchAndSelectFromDropdown(global.uiElements.get(iCheckout.BUSINESS_UNIT), businessUnit);
        businessUnit = await I.grabTextFrom(global.uiElements.get(iCheckout.BUSINESS_UNIT));
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
        I.waitForVisible(global.uiElements.get(iCheckout.LOCATION), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(global.uiElements.get(iCheckout.LOCATION), prop.DEFAULT_MEDIUM_WAIT);
        commonComponent.searchAndSelectFromDropdown(global.uiElements.get(iCheckout.LOCATION),location);
        location = await I.grabTextFrom(global.uiElements.get(iCheckout.LOCATION));
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
        I.waitForVisible(global.uiElements.get(iCheckout.CURRENCY), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(global.uiElements.get(iCheckout.CURRENCY), prop.DEFAULT_MEDIUM_WAIT);
        commonComponent.searchAndSelectFromDropdown(global.uiElements.get(iCheckout.CURRENCY), currency);
        location = await I.grabTextFrom(global.uiElements.get(iCheckout.CURRENCY));
        logger.info(`Entered Business unit: ${currency}`);
        return currency;
    },

    /**
     * clickOnBuyingUnitDoneButton clicks on Buying Unit Done Button
     */
    clickOnBuyingUnitDoneButton()
    {
        I.waitForVisible(global.uiElements.get(iCheckout.BUYING_UNIT_DONE_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(global.uiElements.get(iCheckout.BUYING_UNIT_DONE_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.click(global.uiElements.get(iCheckout.BUYING_UNIT_DONE_BUTTON));
        logger.info("Clicked on Buying Inut Done Button");
    },

    clickOnUrgentRequirementYesButton()
    {
        I.waitForVisible(global.uiElements.get(iCheckout.URGENT_REQUIREMENT_YES_RADIO_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(global.uiElements.get(iCheckout.URGENT_REQUIREMENT_YES_RADIO_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.click(global.uiElements.get(iCheckout.URGENT_REQUIREMENT_YES_RADIO_BUTTON));
        logger.info("Clicked on UrgentRequirement Yes Button ");
    },

    clickOnUrgentRequirementNoButton()
    {
        I.waitForVisible(global.uiElements.get(iCheckout.URGENT_REQUIREMENT_NO_RADIO_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(global.uiElements.get(iCheckout.URGENT_REQUIREMENT_NO_RADIO_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.click(global.uiElements.get(iCheckout.URGENT_REQUIREMENT_NO_RADIO_BUTTON));
        logger.info("Clicked on UrgentRequirement NO Button ");
    },

    /**
     * clickOnReasonForOrderingLink 
     */
    clickOnReasonForOrderingLink()
    {
        I.waitForVisible(global.uiElements.get(iCheckout.REASON_FOR_ORDERING_LINK), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(global.uiElements.get(iCheckout.REASON_FOR_ORDERING_LINK), prop.DEFAULT_MEDIUM_WAIT);
        I.click(global.uiElements.get(iCheckout.REASON_FOR_ORDERING_LINK));
        logger.info("Cliked on Reason For Ordering Link ");
    },

    /**
     * enterReasonForOrdering enters Reason for ordering comments
     * @param {*} reasonForOrdering 
     */
    async enterReasonForOrdering(reasonForOrdering)
    {
        I.waitForVisible(global.uiElements.get(iCheckout.REASON_FOR_ORDERING_TEXTAREA), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(global.uiElements.get(iCheckout.REASON_FOR_ORDERING_TEXTAREA), prop.DEFAULT_MEDIUM_WAIT);
        I.clearField(global.uiElements.get(iCheckout.REASON_FOR_ORDERING_TEXTAREA));
        I.fillField(global.uiElements.get(iCheckout.REASON_FOR_ORDERING_TEXTAREA), reasonForOrdering);
        reasonForOrdering = await I.grabTextFrom(global.uiElements.get(iCheckout.REASON_FOR_ORDERING_TEXTAREA));
        logger.info(`Entered Reason For Ordering ${reasonForOrdering}`);
        return reasonForOrdering;
    },
    /**
     * clickOnCommentsForSupplierLink 
     */
    clickOnCommentsForSupplierLink()
    {
        I.waitForVisible(global.uiElements.get(iCheckout.COMMENTS_FOR_SUPPLIER_LINK), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(global.uiElements.get(iCheckout.COMMENTS_FOR_SUPPLIER_LINK), prop.DEFAULT_MEDIUM_WAIT);
        I.click(global.uiElements.get(iCheckout.COMMENTS_FOR_SUPPLIER_LINK));
        logger.info("Cliked on Comments For Supplier Link ");
    },

      /**
     * enterCommentsForSupplier enters comments for Supplier
     * @param {*} reasonForOrdering 
     */
    async enterCommentsForSupplier(commentForSupplier)
    {
        I.waitForVisible(global.uiElements.get(iCheckout.COMMENTS_FOR_SUPPLIER_TEXTAREA), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(global.uiElements.get(iCheckout.COMMENTS_FOR_SUPPLIER_TEXTAREA), prop.DEFAULT_MEDIUM_WAIT);
        I.clearField(global.uiElements.get(iCheckout.COMMENTS_FOR_SUPPLIER_TEXTAREA));
        I.fillField(global.uiElements.get(iCheckout.COMMENTS_FOR_SUPPLIER_TEXTAREA), commentForSupplier);
        commentForSupplier = await I.grabTextFrom(global.uiElements.get(iCheckout.COMMENTS_FOR_SUPPLIER_TEXTAREA));
        logger.info(`Entered Comments For Supplier ${commentForSupplier}`);
        return commentForSupplier;
    },

    /**
     * selectPurchaseType selects Purchase Type from drop down
     * @param {*} purchaseType 
     */
    async selectPurchaseType(purchaseType)
    {
        commonComponent.selectValueFromDropDown(global.uiElements.get(iCheckout.PURCHASE_TYPE), purchaseType);
        purchaseType = await I.grabTextFrom(global.uiElements.get(iCheckout.PURCHASE_TYPE));
        return purchaseType;
    },

    /**
     * clickOnPurchaseTypeYesButton: Clicks on Yes Button on Confirm Pop after selecting PurchaseType
     */
    clickOnPurchaseTypeYesButton()
    {
        I.click(iCheckout.PURCHASE_TYPE_CONFIRM_POPUP_YES_BUTTON);
        logger.info("Clicked on Purchase Type YES button");
    },

    async selectSettlementVia(settlementVia)
    {
        commonComponent.selectValueFromDropDown(global.uiElements.get(iCheckout.SETTLEMENT_VIA), settlementVia);
        settlementVia = await I.grabTextFrom(global.uiElements.get(iCheckout.SETTLEMENT_VIA));
        return settlementVia;
    },

    clickOnRetrospectivePurchaseYesButton()
    {
        I.waitForVisible(global.uiElements.get(iCheckout.RETROSPECTIVE_PURCHASE_YES_RADIO_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(global.uiElements.get(iCheckout.RETROSPECTIVE_PURCHASE_YES_RADIO_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.click(global.uiElements.get(iCheckout.RETROSPECTIVE_PURCHASE_YES_RADIO_BUTTON));
        logger.info("Click On Retrospective Purchase Yes Button");
    },

    clickOnRetrospectivePurchaseNoButton()
    {
        I.waitForVisible(global.uiElements.get(iCheckout.RETROSPECTIVE_PURCHASE_NO_RADIO_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(global.uiElements.get(iCheckout.RETROSPECTIVE_PURCHASE_NO_RADIO_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.click(global.uiElements.get(iCheckout.RETROSPECTIVE_PURCHASE_NO_RADIO_BUTTON));
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
        I.waitForVisible(global.uiElements.get(iCheckout.DEFAULT_SHIPPING_ADDRESS), prop.DEFAULT_MEDIUM_WAIT);
        let shippingAddress = await I.grabTextFrom(global.uiElements.get(iCheckout.DEFAULT_SHIPPING_ADDRESS));
        logger.info(`Default Shipping Address is ${shippingAddress}`);
        return shippingAddress;
    },

    /**
     * fillDeliverTo fills the Deliver To
     * @param {*} deliverTo 
     */
    async fillDeliverTo(deliverTo)
    {
        I.waitForVisible(global.uiElements.get(iCheckout.DELIVER_TO), prop.DEFAULT_MEDIUM_WAIT);
        commonComponent.searchAndSelectFromDropdown(global.uiElements.get(iCheckout.DELIVER_TO), deliverTo);
        deliverTo =  await I.grabTextFrom(global.uiElements.get(iCheckout.DELIVER_TO));
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
        I.waitForVisible(global.uiElements.get(iCheckout.ASSIGN_COST_PROJECT_YES), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(global.uiElements.get(iCheckout.ASSIGN_COST_PROJECT_YES), prop.DEFAULT_MEDIUM_WAIT);
        I.click(global.uiElements.get(iCheckout.ASSIGN_COST_PROJECT_YES));
        logger.info("Clicked On Assign Cost Project YES Button");
    },

       /**
     * clickOnAssignCostNoButton clicks on Assign Cost Project NO radio Button
     */
    clickOnAssignCostProjectNoButton()
    {
        I.waitForVisible(global.uiElements.get(iCheckout.ASSIGN_COST_PROJECT_NO), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(global.uiElements.get(iCheckout.ASSIGN_COST_PROJECT_NO), prop.DEFAULT_MEDIUM_WAIT);
        I.click(global.uiElements.get(iCheckout.ASSIGN_COST_PROJECT_NO));
        logger.info("Clicked On Assign Cost Project NO Button");
    },

    /**
     * fillCostCenter: Fills Cost Center
     * @param {*} costCenter 
     * @returns costCenter
     */
    async fillCostCenter(costCenter)
    {
        I.waitForVisible(global.uiElements.get(iCheckout.COST_CENTER), prop.DEFAULT_MEDIUM_WAIT);
        commonComponent.searchAndSelectFromDropdown(global.uiElements.get(iCheckout.COST_CENTER), costCenter);
        costCenter = await I.grabTextFrom(global.uiElements.get(iCheckout.COST_CENTER));
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
     * @returns glAccount
     */
    async fillGLAccount(glAccount)
    {
        I.waitForVisible(global.uiElements.get(iCheckout.GL_ACCOUNT), prop.DEFAULT_MEDIUM_WAIT);
        commonComponent.searchAndSelectFromDropdown(global.uiElements.get(iCheckout.GL_ACCOUNT), glAccount);
        glAccount = await I.grabTextFrom(global.uiElements.get(iCheckout.GL_ACCOUNT));
        logger.info(`GL Account is: ${glAccount}`);
        return glAccount;
    },

      /**
     * fillAssetCode: fills Asset Code
     * @param {*} glAccount 
     */
    async fillAssetCode(assetCode)
    {
        I.waitForVisible(global.uiElements.get(iCheckout.ASSET_CODE), prop.DEFAULT_MEDIUM_WAIT);
        commonComponent.searchAndSelectFromDropdown(global.uiElements.get(iCheckout.ASSET_CODE), assetCode);
        assetCode = await I.grabTextFrom(global.uiElements.get(iCheckout.ASSET_CODE));
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
        I.waitForVisible(global.uiElements.get(iCheckout.BUYER_TEXTBOX), prop.DEFAULT_MEDIUM_WAIT);
        commonComponent.searchAndSelectFromDropdown(global.uiElements.get(iCheckout.BUYER_TEXTBOX), buyerName);
        buyerName = await I.grabTextFrom(global.uiElements.get(iCheckout.BUYER_TEXTBOX));
        logger.info(`Entered Buyer is: ${buyerName}`);
        return buyerName;
    },

    /**
     * clickInCostBookingSaveButton: clicks on line Level details Save button
     */
    clickInCostBookingSaveButton()
    {
        I.waitForVisible(global.uiElements.get(iCheckout.COST_BOOKING_SAVE_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(global.uiElements.get(iCheckout.COST_BOOKING_SAVE_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.click(global.uiElements.get(iCheckout.COST_BOOKING_SAVE_BUTTON));
        logger.info("Clicked on Cost Booking Save Button");
    },

    /**
     * clickOnImDoneButton: clicks on I M Done Button
     */
    clickOnImDoneButton()
    {
        I.waitForVisible(global.uiElements.get(iCheckout.I_M_DONE_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(global.uiElements.get(iCheckout.I_M_DONE_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.click(global.uiElements.get(iCheckout.I_M_DONE_BUTTON));
        logger.info("Clicked on I M Button");
    },

      /**
     * clickOnSaveAsDraftButton: clicks on Save As Draft Button
     */
    clickOnSaveAsDraftButton()
    {
        I.waitForVisible(global.uiElements.get(iCheckout.SAVE_AS_DRAFT), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(global.uiElements.get(iCheckout.SAVE_AS_DRAFT), prop.DEFAULT_MEDIUM_WAIT);
        I.click(global.uiElements.get(iCheckout.SAVE_AS_DRAFT));
        logger.info("Clicked on Save As Draft Button");
    },

      /**
     * clickOnCancelButton: clicks on Cancel Button
     */
    clickOnCancelButton()
    {
        I.waitForVisible(global.uiElements.get(iCheckout.CANCEL_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(global.uiElements.get(iCheckout.CANCEL_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.click(global.uiElements.get(iCheckout.CANCEL_BUTTON));
        logger.info("Clicked on Cancel Button");
    },

     /**
     * clickOnContinueButton: clicks on Contine Button
     */
    clickOnContinueButton()
    {
        I.waitForVisible(global.uiElements.get(iCheckout.CONTINUE_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(global.uiElements.get(iCheckout.CONTINUE_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        I.click(global.uiElements.get(iCheckout.CONTINUE_BUTTON));
        logger.info("Clicked on Continue Button");
    },

    async fillBasicDetails(requisitionBO)
    {
        logger.info("*********Filling Requisition Basic Details");
        commonComponent.scrollToSection(iConstants.CHECKOUT_BASIC_DETAILS_SECTION);
        if(requisitionBO.reqName !== "undefined")
        {
           let reqName =  this.enterRequisitionName(requisitionBO.reqName);
           requisitionBO.setReqName(reqName);
        }

        if(requisitionBO.onBehalfOf !== "undefined")
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

        if(requisitionBO.reasonForOrdering !== "undefined")
        {
            this.clickOnReasonForOrderingLink();
            let reasonForOrdering = this.enterReasonForOrdering(requisitionBO.reasonForOrdering);
            requisitionBO.setReasonForOrdering(reasonForOrdering);
        }

        if(requisitionBO.commentsForSupplier !== "undefined")
        {
            this.clickOnCommentsForSupplierLink();
            let commentsForSupplier = this.enterCommentsForSupplier(requisitionBO.commentsForSupplier);
            requisitionBO.setCommentsForSupplier(commentsForSupplier);
        }

        return requisitionBO;

    },

    /**
     * fillProject: Fills Assign Cost Project
     * @param {*} project 
     * @returns project
     */
    async fillProject(project)
    {
        commonComponent.searchAndSelectFromDropdown(global.uiElements.get(iCheckout.PROJECT), project);
        project = await I.grabTextFrom(global.uiElements.get(iCheckout.PROJECT));
        logger.info("Entered Project is "+project);
        return project;
    },

    async fillAdditionalDetails(requisitionBO)
    {
        logger.info("*********Filling Requisition Additional Details");
        commonComponent.scrollToSection(iConstants.CHECKOUT_ADDITIONAL_DETAILS_SECTION);
        
        if(requisitionBO.purchaseType !== "undefined")
        {
            let purchaseType =  this.selectPurchaseType(requisitionBO.purchaseType);
            requisitionBO.setPurchaseType(purchaseType);
        }

        if(requisitionBO.settlementVia !== "undefined")
        {
            let settlementVia = this.selectSettlementVia(requisitionBO.settlementVia);
            requisitionBO.setSettlementVia(settlementVia);
        }

        if(requisitionBO.retrospectivePurchase === "Yes")
        {
            this.clickOnRetrospectivePurchaseYesButton();
        }
        else
        {
            this.clickOnRetrospectivePurchaseNoButton();
        }

        if(requisitionBO.attachmentPath !== "undefined")
        {
            this.addAttachments();
        }

        return requisitionBO;
    },

    async fillShippingDetails(requisitionBO)
    {
        logger.info("*********Filling Requisition Shipping Details");
        commonComponent.scrollToSection(iConstants.CHECKOUT_SHIPPING_DETAILS_SECTION);

       if(requisitionBO.isDefaultAddressOption === true)
       {
            let defaultAddress = this.getDefaultShippingAddress();
            requisitionBO.shipToDefaultAddress(defaultAddress);
       }

       if(requisitionBO.isOtherAddressOption === true)
       {
            //otherAddress
       }



        return requisitionBO;
    },

    async fillCostAllocation(requisitionBO)
    {
        logger.info("*********Filling Requisition Cost Allocation Details");
        commonComponent.scrollToSection(iConstants.CHECKOUT_COST_ALLOCATION_SECTION);

        if(requisitionBO.fillCostAllocation === true)
        {
            if(requisitionBO.assignCostProject === "Yes")
            {
                this.clickOnAssignCostProjectYesButton();
            }

        if(requisitionBO.bookCostToSingleMultipleCC)
        {
            if(requisitionBO.costCenter !== "undefined")
            {
                let costCenter = this.fillCostCenter(requisitionBO.costCenter);
                requisitionBO.setCostCenter(costCenter);
            }
            if(requisitionBO.assignCostProject === "Yes")
            {
            let project =  this.fillProject(requisitionBO.project);
            requisitionBO.setProject(project);
            }

        }

        if(requisitionBO.bookCostAtLineLevel)
        {
            ///line level code
        }
        }

       return requisitionBO;

    },

    async fillItemDetails()
    {
        logger.info("*********Filling Requisition Item Details Details");
        commonComponent.scrollToSection(iConstants.CHECKOUT_ITEM_DETAILS_SECTION);

        for(let i=0; i< requisitionBO.items.length; i++)
        {
            this.clickOnCostBookingLink(items[i]);

        if(requisitionBO.buyer !== "undefined")
        {
            this.clickOnTab(iConstants.CHECKOUT_BUYER_TAB);
            this.selectBuyerDropDownOption(requisitionBO.buyerOption);
            let buyer = this.fillBuyerInTextBox(requisitionBO.buyer);
            requisitionBO.setBuyer(buyer);

        }

        else if(requisitionBO.assignedBuyerGroup !== "undefined")
        {
            this.clickOnTab(iConstants.CHECKOUT_BUYER_TAB);
            /// assigned BuyerGroup code
        }

        if(!prop.isCOA)
        {
            if(requisitionBO.glAccount !== "undefined")
            {
               let glAccount =  this.fillGLAccount(requisitionBO.glAccount);
               requisitionBO.setGlAccount(glAccount);
            }
        }

        if(prop.isCOA)
        {
            //fill COA form code
        }
        else
        {
            clickInCostBookingSaveButton();
            commonComponent.waitForLoadingSymbolNotDisplayed();
        }

        if(requisitionBO.assetCode !== "undefined")
        {
            let assetCode = this.fillAssetCode(requisitionBO.assetCode);
            requisitionBO.setAssetCode(assetCode);
        }
        }
        return requisitionBO;

    },

 


};