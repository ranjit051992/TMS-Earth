const { I } = inject();
const iCheckout= require("./CheckoutObject");
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const commonComponent = require("../../../commonKeywords/CommonComponent");
const lmtVar = require("../../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const prop = global.confi_prop;
const ObjectCreation = require("../../../dataCreation/ObjectCreation");
const requisitionBO = require("../../../dataCreation/bo/Requisition");
const cartImpl = require("../Cart/CartImpl");
const iCart = require("../Cart/CartObject");
const onlineStoreImpl = require("../OnlineStore/OnlineStoreImpl");
const faker = require("faker");

module.exports={

       /**
     * createRequisitionFlow: Creats a Requisition
     * @param {*} requisitionBO 
     * @ return requisitionBO
     */
    async createRequisitionFlow(requisitionBO)
    { 

        cartImpl.clearCart();

        onlineStoreImpl.addItemToCart(requisitionBO.itemName, faker.random.number(20));

        onlineStoreImpl.clickOnCartIcon();

        I.waitForVisible(I.getElement(iCart.CART_ITEM_TABLE));
        
        cartImpl.clickOnCheckoutButton();

        requisitionBO = await this.fillBasicDetails(requisitionBO);

        requisitionBO = await this.fillAdditionalDetails(requisitionBO);

        requisitionBO = await this.fillShippingDetails(requisitionBO);

        requisitionBO = await this.fillCostAllocation(requisitionBO);

        requisitionBO = await this. fillItemDetails(requisitionBO);

        // if(requisitionBO.nextAction === lmtVar.getLabel("SUBMIT"))
        // {
            this.clickOnImDoneButton();
            I.wait(prop.DEFAULT_MEDIUM_WAIT);
            this.clickOnContinueButton();
            commonComponent.waitForLoadingSymbolNotDisplayed();
        // }

        // else if(requisitionBO.nextAction === lmtVar.getLabel("SAVE_AS_DRAFT"))
        // {
        //     this.clickOnSaveAsDraftButton();
           
        // }

        // else if(requisitionBO.nextAction === lmtVar.getLabel("CANCEL"))
        // {
        //     this.clickOnCancelButton();
        // }

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

        I.waitForVisible(I.getElement(iCheckout.REQUISITION_NAME), prop.DEFAULT_MEDIUM_WAIT);
        I.waitForClickable(I.getElement(iCheckout.REQUISITION_NAME), prop.DEFAULT_MEDIUM_WAIT);
        I.clearField(I.getElement(iCheckout.REQUISITION_NAME));
        I.fillField(I.getElement(iCheckout.REQUISITION_NAME), reqName);
        //reqName = await I.grabTextFrom(I.getElement(iCheckout.REQUISITION_NAME));
        reqName = await I.grabAttributeFrom(I.getElement(iCheckout.REQUISITION_NAME),"value");
        logger.info(`Entered Requisition Name: ${reqName[0]}`);

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
        let suggXpath = `//p[contains(text(),'${onBehalfOf}')]`;
        commonComponent.searchAndSelectFromDropdown(I.getElement(iCheckout.ON_BEHALF_OF), onBehalfOf, suggXpath);
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
        let suggXpath = `//div[contains(text(),'${companyName}')]`;
        commonComponent.searchAndSelectFromDropdown(I.getElement(iCheckout.COMPANY_NAME),companyName, suggXpath);
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
        let suggXpath = `//div[contains(text(),'${businessUnit}')]`;
        commonComponent.searchAndSelectFromDropdown(I.getElement(iCheckout.BUSINESS_UNIT),businessUnit, suggXpath);
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
        let suggXpath = `//div[contains(text(),'${location}')]`;
        commonComponent.searchAndSelectFromDropdown(I.getElement(iCheckout.LOCATION),location, suggXpath);
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
        let suggXpath = `//div[contains(text(),'${currency}')]`;
        commonComponent.searchAndSelectFromDropdown(I.getElement(iCheckout.CURRENCY),currency, suggXpath);
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

    /**
     * clickOnPurchaseTypeYesButton: Clicks on Yes Button on Confirm Pop after selecting PurchaseType
     */
    clickOnPurchaseTypeYesButton()
    {
        I.click(I.getElement(iCheckout.PURCHASE_TYPE_CONFIRM_POPUP_YES_BUTTON));
        logger.info("Clicked on Purchase Type YES button");
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
        let suggXpath = `//span[contains(text(),'${deliverTo}')]`;
        commonComponent.searchAndSelectFromDropdown(I.getElement(iCheckout.DELIVER_TO),deliverTo, suggXpath);
        deliverTo =  await I.grabAttributeFrom(I.getElement(iCheckout.DELIVER_TO), "value");
        logger.info(`Entered Deliver To is ${deliverTo}`);
        return deliverTo;
    },

    async selectRequiredByDate() {
        logger.info("Selecting date");
        let day = new Date().getDate();
        let dayXpath = `//div[text()='${day}']/..`;
        I.click(I.getElement(iCheckout.REQUIRED_BY));
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
     * @returns enterCostCenter
     */
    async fillCostCenter(costCenter)
    {
        I.waitForVisible(I.getElement(iCheckout.COST_CENTER), prop.DEFAULT_MEDIUM_WAIT);
        let suggXpath = `//div[contains(text(),'${costCenter}')]`;
        commonComponent.searchAndSelectFromDropdown(I.getElement(iCheckout.COST_CENTER),costCenter, suggXpath);
        let enterCostCenter = await I.grabTextFrom(I.getElement(iCheckout.COST_CENTER));
        logger.info(`Entered Cost Center is : ${enterCostCenter}`);
        return enterCostCenter;
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
        I.waitForVisible(I.getElement(iCheckout.GL_ACCOUNT), prop.DEFAULT_MEDIUM_WAIT);
        let suggXpath = `//div[contains(text(),'${glAccount}')]`;
        commonComponent.searchAndSelectFromDropdown(I.getElement(iCheckout.GL_ACCOUNT),glAccount, suggXpath);
        glAccount = await I.grabAttributeFrom(I.getElement(iCheckout.GL_ACCOUNT), "value");
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
        let suggXpath = "//div[contains(@class,'flex-column ac-main')]";
        commonComponent.searchAndSelectFromDropdown(I.getElement(iCheckout.ASSET_CODE),assetCode, suggXpath);
        assetCode = await I.grabAttributeFrom(I.getElement(iCheckout.ASSET_CODE), "value");
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
        I.click(path);
        logger.info("Clicked on tab "+tabName);
    },

    selectBuyerDropDownOption(buyerOption)
    {
        //commonComponent.selectValueFromDropDown(I.getElement(iCheckout.BUYER_DROPDOWN_ICON), buyerOption);
        I.click(I.getElement(iCheckout.BUYER_DROPDOWN_ICON));
        I.wait(prop.DEFAULT_MEDIUM_WAIT);
        let xpath = "//a[contains(text(),'Buyer')]";
        I.click(xpath);
        logger.info("Selected Assigned Buyer")
    },

    /**
     * fillBuyerInTextBox: fills Buyer in text box
     * @param {*} buyerName 
     */
    async fillBuyerInTextBox(buyerName)
    {
        I.waitForVisible(I.getElement(iCheckout.BUYER_TEXTBOX), prop.DEFAULT_MEDIUM_WAIT);
        let optionXpath = "//div[contains(@class,'flex-column ac-main')]";
        commonComponent.searchAndSelectFromDropdown(I.getElement(iCheckout.BUYER_TEXTBOX),buyerName, optionXpath);
        buyerName = await I.grabAttributeFrom(I.getElement(iCheckout.BUYER_TEXTBOX), "value");
        logger.info(`Entered Buyer is: ${buyerName}`);
        return buyerName;
    },

    /**
     * clickOnCostBookingSaveButton: clicks on line Level details Save button
     */
    clickOnCostBookingSaveButton()
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
        commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_BASIC_DETAILS_SECTION"));
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
        let suggXpath = `//div[contains(text(),'${project}')]`;
        commonComponent.searchAndSelectFromDropdown(I.getElement(iCheckout.PROJECT),project, suggXpath);
        let enteredProject = await I.grabAttributeFrom(I.getElement(iCheckout.PROJECT), "value");
        logger.info("Entered Project is "+enteredProject);
        return enteredProject;
    },

    async fillAdditionalDetails(requisitionBO)
    {
        logger.info("*********Filling Requisition Additional Details");
        commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ADDITIONAL_DETAILS_SECTION"));
        
        if(requisitionBO.purchaseType !== "undefined")
        {
            let purchaseType =  this.selectPurchaseType(requisitionBO.purchaseType);
            requisitionBO.setPurchaseType(purchaseType);
            this.clickOnPurchaseTypeYesButton();
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
        commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_SHIPPING_DETAILS_SECTION"));

       if(requisitionBO.isDefaultAddressOption === true)
       {
            let defaultAddress = this.getDefaultShippingAddress();
            requisitionBO.shipToDefaultAddress(defaultAddress);
       }

       if(requisitionBO.isOtherAddressOption === true)
       {
            //otherAddress
       }

        let deliverto =  this.fillDeliverTo(requisitionBO.deliverTo);
        requisitionBO.setDeliverTo(deliverto);
        this.selectRequiredByDate();

        return requisitionBO;
    },

    async fillCostAllocation(requisitionBO)
    {
        logger.info("*********Filling Requisition Cost Allocation Details");
        commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_COST_ALLOCATION_SECTION"));

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

    async fillItemDetails(requisitionBO)
    {
        logger.info("*********Filling Requisition Item Details Details");
        commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));

        this.clickOnCostBookingLink(requisitionBO.itemName);

        if(requisitionBO.buyer !== "undefined")
        {
            this.clickOnTab(lmtVar.getLabel("CHECKOUT_BUYER_TAB"));
            this.selectBuyerDropDownOption(requisitionBO.buyerOption);
            let buyer = this.fillBuyerInTextBox(requisitionBO.buyer);
            requisitionBO.setBuyer(buyer);

        }

        else if(requisitionBO.assignedBuyerGroup !== "undefined")
        {
            this.clickOnTab(lmtVar.getLabel("CHECKOUT_BUYER_TAB"));
            /// assigned BuyerGroup code
        }

        this.clickOnCostBookingTab();
        if(!prop.isCOA)
        {
            if(requisitionBO.glAccount !== "undefined")
            {
               let glAccount =  this.fillGLAccount(requisitionBO.glAccount);
               requisitionBO.setGlAccount(glAccount);
            }
        }

        // if(requisitionBO.assetCode !== "undefined")
        // {
        //     let assetCode = this.fillAssetCode(requisitionBO.assetCode);
        //     requisitionBO.setAssetCode(assetCode);
        // }

        if(prop.isCOA)
        {
            //fill COA form code
        }
        else
        {
            this.clickOnCostBookingSaveButton();
            commonComponent.waitForLoadingSymbolNotDisplayed();
            I.wait(prop.DEFAULT_HIGH_WAIT);
        }

       
        
        return requisitionBO;

    },

    clickOnCostBookingTab()
    {
        this.clickOnTab(lmtVar.getLabel("CHECKOUT_COST_BOOKING_DETAILS_TAB"));
        logger.info("Clicked on Cost Booking Tab")
    },

    async fetchedTotalItemAmount()
    {
        let totalAmount = await grabTextFrom(I.getElement(iCheckout.FETCHED_TOTAL_AMOUNT));
        logger.info("Total amount is "+totalAmount);
        return totalAmount;
    }, 
};