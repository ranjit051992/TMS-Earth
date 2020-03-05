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
const poListingObject = require("../../PO/PoListing/PoListingObject");
const coaImpl = require("../../Coa/CoaImpl");

module.exports={

       /**
     * createRequisitionFlow: Creats a Requisition
     * @param {*} requisitionBO 
     * @ return requisitionBO
     */
    async createRequisitionFlow(requisitionBO)
    { 

        await cartImpl.clearCart();
        await onlineStoreImpl.addItemToCart(requisitionBO.itemName, faker.random.number(20));
        await onlineStoreImpl.clickOnCartIcon();
        await I.waitForVisible(I.getElement(iCart.CART_ITEM_TABLE));
        await cartImpl.clickOnCheckoutButton();

        requisitionBO = await this.fillBasicDetails(requisitionBO);

        requisitionBO = await this.fillAdditionalDetails(requisitionBO);

        requisitionBO = await this.fillShippingDetails(requisitionBO);
        
        requisitionBO = await this.fillCostAllocation(requisitionBO);

        requisitionBO = await this. fillItemDetails(requisitionBO);

        if(requisitionBO.nextAction === lmtVar.getLabel("SUBMIT"))
        {
            await this.submitRequisition();
        }

        else if(requisitionBO.nextAction === lmtVar.getLabel("SAVE_AS_DRAFT"))
        {
          await this.saveRequisitionAsDraft();
           
        }

        else if(requisitionBO.nextAction === lmtVar.getLabel("CANCEL"))
        {
            this.clickOnCancelButton();
        }

        return requisitionBO;

    },


    async fetchCreatedRequisitionNumber()
   {
        I.waitForVisible(I.getElement(iCart.REQUISITION_NUMBER),prop.DEFAULT_MEDIUM_WAIT);
        let reuisitionNo = await I.grabTextFrom(I.getElement(iCart.REQUISITION_NUMBER));
        logger.info("Created Requisition number is : "+reuisitionNo);
        return reuisitionNo;
   },

   async fetchCreatedRequisitionName()
   {
        let reuisitionName = await I.grabTextFrom(I.getElement(iCart.REQUISITION_NAME));
        logger.info("Created Requisition name is : "+reuisitionName);
        return reuisitionName;
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

        await I.waitForVisible(I.getElement(iCheckout.REQUISITION_NAME), prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(I.getElement(iCheckout.REQUISITION_NAME), prop.DEFAULT_MEDIUM_WAIT);
        await I.click(I.getElement(iCheckout.REQUISITION_NAME));
        await I.clearField(I.getElement(iCheckout.REQUISITION_NAME));
        await I.fillField(I.getElement(iCheckout.REQUISITION_NAME), reqName);
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

         await I.waitForVisible(I.getElement(iCheckout.ON_BEHALF_OF), prop.DEFAULT_MEDIUM_WAIT);
         await I.waitForClickable(I.getElement(iCheckout.ON_BEHALF_OF), prop.DEFAULT_MEDIUM_WAIT);
        let suggXpath = `//p[contains(text(),'${onBehalfOf}')]`;
        onBehalfOf = await commonComponent.searchAndSelectFromDropdown(I.getElement(iCheckout.ON_BEHALF_OF), onBehalfOf, suggXpath);
        //onBehalfOf = await I.grabTextFrom(I.getElement(iCheckout.ON_BEHALF_OF));
        logger.info(`Entered OnBehalf of : ${onBehalfOf}`);
        return onBehalfOf;
    },

     /** 
     * click on Buying Unit Edit Button
     * 
    */
   async clickOnBuyingUnitEditButton()
    {
        await I.waitForVisible(I.getElement(iCheckout.BUYING_UNIT_EDIT_ICON), prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(I.getElement(iCheckout.BUYING_UNIT_EDIT_ICON), prop.DEFAULT_MEDIUM_WAIT);
        await I.click(I.getElement(iCheckout.BUYING_UNIT_EDIT_ICON));
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

        await I.waitForVisible(I.getElement(iCheckout.COMPANY_NAME), prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(I.getElement(iCheckout.COMPANY_NAME), prop.DEFAULT_MEDIUM_WAIT);
        let suggXpath = `//div[contains(text(),'${companyName}')]`;
        companyName = await commonComponent.searchAndSelectFromDropdown(I.getElement(iCheckout.COMPANY_NAME),companyName, suggXpath);
    
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
        await I.waitForVisible(I.getElement(iCheckout.BUSINESS_UNIT), prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(I.getElement(iCheckout.BUSINESS_UNIT), prop.DEFAULT_MEDIUM_WAIT);
        let suggXpath = `//div[contains(text(),'${businessUnit}')]`;
        await commonComponent.searchAndSelectFromDropdown(I.getElement(iCheckout.BUSINESS_UNIT),businessUnit, suggXpath);
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
        await I.waitForVisible(I.getElement(iCheckout.LOCATION), prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(I.getElement(iCheckout.LOCATION), prop.DEFAULT_MEDIUM_WAIT);
        let suggXpath = `//div[contains(text(),'${location}')]`;
        await commonComponent.searchAndSelectFromDropdown(I.getElement(iCheckout.LOCATION),location, suggXpath);
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
        await I.waitForVisible(I.getElement(iCheckout.CURRENCY), prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(I.getElement(iCheckout.CURRENCY), prop.DEFAULT_MEDIUM_WAIT);
        let suggXpath = `//div[contains(text(),'${currency}')]`;
        await commonComponent.searchAndSelectFromDropdown(I.getElement(iCheckout.CURRENCY),currency, suggXpath);
        location = await I.grabTextFrom(I.getElement(iCheckout.CURRENCY));
        logger.info(`Entered Business unit: ${currency}`);
        return currency;
    },

    /**
     * clickOnBuyingUnitDoneButton clicks on Buying Unit Done Button
     */
    async clickOnBuyingUnitDoneButton()
    {
        await I.waitForVisible(I.getElement(iCheckout.BUYING_UNIT_DONE_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(I.getElement(iCheckout.BUYING_UNIT_DONE_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        await I.click(I.getElement(iCheckout.BUYING_UNIT_DONE_BUTTON));
        logger.info("Clicked on Buying Inut Done Button");
    },

    async clickOnUrgentRequirementYesButton()
    {
        await I.waitForVisible(I.getElement(iCheckout.URGENT_REQUIREMENT_YES_RADIO_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(I.getElement(iCheckout.URGENT_REQUIREMENT_YES_RADIO_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        await  I.click(I.getElement(iCheckout.URGENT_REQUIREMENT_YES_RADIO_BUTTON));
        logger.info("Clicked on UrgentRequirement Yes Button ");
    },

    async clickOnUrgentRequirementNoButton()
    {
        await I.waitForVisible(I.getElement(iCheckout.URGENT_REQUIREMENT_NO_RADIO_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(I.getElement(iCheckout.URGENT_REQUIREMENT_NO_RADIO_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        await I.click(I.getElement(iCheckout.URGENT_REQUIREMENT_NO_RADIO_BUTTON));
        logger.info("Clicked on UrgentRequirement NO Button ");
    },

    /**
     * clickOnReasonForOrderingLink 
     */
    async clickOnReasonForOrderingLink()
    {
        await I.waitForVisible(I.getElement(iCheckout.REASON_FOR_ORDERING_LINK), prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(I.getElement(iCheckout.REASON_FOR_ORDERING_LINK), prop.DEFAULT_MEDIUM_WAIT);
        await I.click(I.getElement(iCheckout.REASON_FOR_ORDERING_LINK));
        logger.info("Cliked on Reason For Ordering Link ");
    },

    /**
     * enterReasonForOrdering enters Reason for ordering comments
     * @param {*} reasonForOrdering 
     */
    async enterReasonForOrdering(reasonForOrdering)
    {
        await I.waitForVisible(I.getElement(iCheckout.REASON_FOR_ORDERING_TEXTAREA), prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(I.getElement(iCheckout.REASON_FOR_ORDERING_TEXTAREA), prop.DEFAULT_MEDIUM_WAIT);
        await I.clearField(I.getElement(iCheckout.REASON_FOR_ORDERING_TEXTAREA));
        await I.fillField(I.getElement(iCheckout.REASON_FOR_ORDERING_TEXTAREA), reasonForOrdering);
        reasonForOrdering = await I.grabAttributeFrom(I.getElement(iCheckout.REASON_FOR_ORDERING_TEXTAREA), "value");
        logger.info(`Entered Reason For Ordering ${reasonForOrdering}`);
        return reasonForOrdering;
    },
    /**
     * clickOnCommentsForSupplierLink 
     */
    async clickOnCommentsForSupplierLink()
    {
        await I.waitForVisible(I.getElement(iCheckout.COMMENTS_FOR_SUPPLIER_LINK), prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(I.getElement(iCheckout.COMMENTS_FOR_SUPPLIER_LINK), prop.DEFAULT_MEDIUM_WAIT);
        await I.click(I.getElement(iCheckout.COMMENTS_FOR_SUPPLIER_LINK));
        logger.info("Cliked on Comments For Supplier Link ");
    },

      /**
     * enterCommentsForSupplier enters comments for Supplier
     * @param {*} reasonForOrdering 
     */
    async enterCommentsForSupplier(commentForSupplier)
    {
        await I.waitForVisible(I.getElement(iCheckout.COMMENTS_FOR_SUPPLIER_TEXTAREA), prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(I.getElement(iCheckout.COMMENTS_FOR_SUPPLIER_TEXTAREA), prop.DEFAULT_MEDIUM_WAIT);
        await I.clearField(I.getElement(iCheckout.COMMENTS_FOR_SUPPLIER_TEXTAREA));
        await I.fillField(I.getElement(iCheckout.COMMENTS_FOR_SUPPLIER_TEXTAREA), commentForSupplier);
        commentForSupplier = await I.grabAttributeFrom(I.getElement(iCheckout.COMMENTS_FOR_SUPPLIER_TEXTAREA), "value");
        logger.info(`Entered Comments For Supplier ${commentForSupplier}`);
        return commentForSupplier;
    },

    /**
     * selectPurchaseType selects Purchase Type from drop down
     * @param {*} purchaseType 
     */
    async selectPurchaseType(purchaseType)
    {
        await commonComponent.selectValueFromDropDown(I.getElement(iCheckout.PURCHASE_TYPE), purchaseType);
        purchaseType = await I.grabTextFrom(I.getElement(iCheckout.PURCHASE_TYPE));
        logger.info("Selected Purchase Type is ---->"+purchaseType);
        let noOfEle = await I.grabNumberOfVisibleElements(I.getElement(iCheckout.PURCHASE_TYPE_CONFIRM_POPUP))
        if(noOfEle>0)
        {
            await this.clickOnPurchaseTypeYesButton();
        }
        return purchaseType;
    },

    /**
     * clickOnPurchaseTypeYesButton: Clicks on Yes Button on Confirm Pop after selecting PurchaseType
     */
    async clickOnPurchaseTypeYesButton()
    {
        await  I.click(I.getElement(iCheckout.PURCHASE_TYPE_CONFIRM_POPUP_YES_BUTTON));
        logger.info("Clicked on Purchase Type YES button");
    },

    async selectSettlementVia(settlementVia)
    {
        //await commonComponent.selectValueFromDropDown(I.getElement(iCheckout.SETTLEMENT_VIA), settlementVia);
        await I.waitForVisible(I.getElement(iCheckout.SETTLEMENT_VIA));
        await I.waitForClickable(I.getElement(iCheckout.SETTLEMENT_VIA));
        await I.click(I.getElement(iCheckout.SETTLEMENT_VIA));
        await I.waitForVisible("//a[contains(text(),'"+settlementVia+"')]");
        await I.click("//a[contains(text(),'"+settlementVia+"')]");
        settlementVia = await I.grabTextFrom(I.getElement(iCheckout.SETTLEMENT_VIA));
        logger.info(`Selected Settement Via option is ---> ${settlementVia}`);
        return settlementVia;
    },

    async clickOnRetrospectivePurchaseYesButton()
    {
        await I.waitForVisible(I.getElement(iCheckout.RETROSPECTIVE_PURCHASE_YES_RADIO_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(I.getElement(iCheckout.RETROSPECTIVE_PURCHASE_YES_RADIO_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        await I.click(I.getElement(iCheckout.RETROSPECTIVE_PURCHASE_YES_RADIO_BUTTON));
        logger.info("Click On Retrospective Purchase Yes Button");
    },

    async clickOnRetrospectivePurchaseNoButton()
    {
        await I.waitForVisible(I.getElement(iCheckout.RETROSPECTIVE_PURCHASE_NO_RADIO_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(I.getElement(iCheckout.RETROSPECTIVE_PURCHASE_NO_RADIO_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        await I.click(I.getElement(iCheckout.RETROSPECTIVE_PURCHASE_NO_RADIO_BUTTON));
        logger.info("Click On Retrospective Purchase No Button");
    },

    async selectPurchaseOrder(purchaseOrder)
    {
        await I.waitForVisible(I.getElement(iCheckout.SELECT_PURCHASE_ORDER),prop.DEFAULT_HIGH_WAIT);
        await I.waitForClickable(I.getElement(iCheckout.SELECT_PURCHASE_ORDER),prop.DEFAULT_HIGH_WAIT);
        //commonComponent.searchAndSelectFromDropdown(I.getElement(iCheckout.SELECT_PURCHASE_ORDER),purchaseOrder,"//dew-col[contains(text(),'"+purchaseOrder+"')]")
        await I.fillField(I.getElement(iCheckout.SELECT_PURCHASE_ORDER),purchaseOrder);
        await I.waitForVisible("//dew-col[contains(text(),'"+purchaseOrder+"')]",prop.DEFAULT_MEDIUM_WAIT);
        await I.click("//dew-col[contains(text(),'"+purchaseOrder+"')]");
    },

    async addAttachments(attachmentFile)
    {
        logger.info(`filepath-------${attachmentFile.toString()}`);
    //    await I.fillField(I.getElement(iCheckout.ADD_ATTACHMENTS),"\\\\192.168.3.40\\AutomationSharing\\Katalon_File_Attachment\\RM\\validation.jpg");
      await I.fillField(I.getElement(iCheckout.ADD_ATTACHMENTS),attachmentFile.toString());

    },

    async checkAddedAttachment(attachmentFile)
    {
        let attachment = attachmentFile.substring(attachmentFile.lastIndexOf("\\"),attachmentFile.length);
        attachment = attachment.replace("\\","");
        logger.info("attachement name "+attachment);

        await I.waitForVisible("//span[contains(@title,'"+attachment+"')]",prop.DEFAULT_HIGH_WAIT);
        let noOfElement = await I.grabNumberOfVisibleElements("//span[contains(@title,'"+attachment+"')]");
        let isPresent = false;
        if(noOfElement>0)
        {
            isPresent = true;
            logger.info("attachement present");
        }

        return isPresent;
    },
    
    /**
     * getDefaultShippingAddress fetched Default shipping address
     */
    async getDefaultShippingAddress()
    {
        await I.waitForVisible(I.getElement(iCheckout.DEFAULT_SHIPPING_ADDRESS_TEXTBOX), prop.DEFAULT_MEDIUM_WAIT);
        let shippingAddress = await I.grabTextFrom(I.getElement(iCheckout.DEFAULT_SHIPPING_ADDRESS_TEXTBOX));
        logger.info(`Default Shipping Address is ---> ${shippingAddress}`);
        return shippingAddress;
    },

    /**
     * fillDeliverTo fills the Deliver To
     * @param {*} deliverTo 
     */
    async fillDeliverTo(deliverTo)
    {
        await I.waitForVisible(I.getElement(iCheckout.DELIVER_TO), prop.DEFAULT_MEDIUM_WAIT);
        let suggXpath = `//span[contains(text(),'${deliverTo}')]`;
        deliverTo = await commonComponent.searchAndSelectFromDropdown(I.getElement(iCheckout.DELIVER_TO),deliverTo, suggXpath);
        logger.info(`Entered Deliver To is ${deliverTo}`);
        return deliverTo;
    },

    async selectRequiredByDate() {
        logger.info("Selecting date");
        let day = new Date().getDate();
        let dayXpath = `//div[text()='${day}']/..`;
        await I.click(I.getElement(iCheckout.REQUIRED_BY));
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
    async clickOnAssignCostProjectYesButton()
    {
      await I.waitForVisible(I.getElement(iCheckout.ASSIGN_COST_PROJECT_YES), prop.DEFAULT_MEDIUM_WAIT);
      await I.waitForClickable(I.getElement(iCheckout.ASSIGN_COST_PROJECT_YES), prop.DEFAULT_MEDIUM_WAIT);
      await I.click(I.getElement(iCheckout.ASSIGN_COST_PROJECT_YES));
      logger.info("Clicked On Assign Cost Project YES Button");
    },

       /**
     * clickOnAssignCostNoButton clicks on Assign Cost Project NO radio Button
     */
    async clickOnAssignCostProjectNoButton()
    {
        await I.waitForVisible(I.getElement(iCheckout.ASSIGN_COST_PROJECT_NO), prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(I.getElement(iCheckout.ASSIGN_COST_PROJECT_NO), prop.DEFAULT_MEDIUM_WAIT);
        await I.click(I.getElement(iCheckout.ASSIGN_COST_PROJECT_NO));
        logger.info("Clicked On Assign Cost Project NO Button");
    },

    /**
     * fillCostCenter: Fills Cost Center
     * @param {*} costCenter 
     * @returns enterCostCenter
     */
    async fillCostCenter(costCenter)
    {
        await I.waitForVisible(I.getElement(iCheckout.COST_CENTER), prop.DEFAULT_MEDIUM_WAIT);
        let suggXpath = `//div[contains(text(),'${costCenter}')]`;
        let enterCostCenter = await commonComponent.searchAndSelectFromDropdown(I.getElement(iCheckout.COST_CENTER),costCenter, suggXpath);
        logger.info(`Entered Cost Center is : ${enterCostCenter}`);
        return enterCostCenter;
    },

    /**
     * clickOnCostBookingLink: Clicks on Cost booking link for specified item
     * @param {*} itemName 
     */
    async clickOnCostBookingLink(itemName)
    {   
        let path = `//span[contains(text(),'${itemName}')]//ancestor::dew-row//following-sibling::dew-row//dew-flex-item[3]`;
        await I.waitForVisible(path, prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(path, prop.DEFAULT_MEDIUM_WAIT);
        await I.click(path);
        logger.info("Clicked on Cost Booking Details link");
    },

    /**
     * fillGLAccount: fills GL Account
     * @param {*} glAccount 
     * @returns glAccount
     */
    async fillGLAccount(glAccount)
    {
        await I.waitForVisible(I.getElement(iCheckout.GL_ACCOUNT), prop.DEFAULT_MEDIUM_WAIT);
        let suggXpath = `//div[contains(text(),'${glAccount}')]`;
        await  commonComponent.searchAndSelectFromDropdown(I.getElement(iCheckout.GL_ACCOUNT),glAccount, suggXpath);
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
        await I.waitForVisible(I.getElement(iCheckout.ASSET_CODE), prop.DEFAULT_MEDIUM_WAIT);
        let suggXpath = "//div[contains(@class,'flex-column ac-main')]";
        await commonComponent.searchAndSelectFromDropdown(I.getElement(iCheckout.ASSET_CODE),assetCode, suggXpath);
        assetCode = await I.grabAttributeFrom(I.getElement(iCheckout.ASSET_CODE), "value");
        logger.info(`Asset Code is: ${assetCode}`);
        return assetCode;
    },

    /**
     * clickOnTab: Clicks on specified Tab Name
     * @param {*} tabName 
     */
    async clickOnTab(tabName)
    {
        let path = `//dew-default-tab-head[contains(text(),'${tabName}')]`;
        await I.waitForVisible(path, prop.DEFAULT_MEDIUM_WAIT);
        await  I.waitForClickable(path, prop.DEFAULT_MEDIUM_WAIT);
        await I.click(path);
        logger.info("Clicked on tab "+tabName);
    },

    /**
     * fillBuyerInTextBox: fills Buyer in text box
     * @param {*} buyerName 
     */
    async fillBuyerInTextBox(buyerName)
    {
        await I.waitForVisible(I.getElement(iCheckout.BUYER_TEXTBOX), prop.DEFAULT_MEDIUM_WAIT);
        //let buyer = buyerName.substring(0,buyerName.indexOf('@'));
        await commonComponent.searchAndSelectFromDropdown(I.getElement(iCheckout.BUYER_TEXTBOX),buyerName, I.getElement(iCheckout.BUYER_SUGGESTION_OPTION));
        logger.info(`Entered Buyer is: ${buyerName}`);
        return buyerName;
    },

    /**
     * clickOnCostBookingSaveButton: clicks on line Level details Save button
     */
    async clickOnCostBookingSaveButton()
    {
        await  I.waitForVisible(I.getElement(iCheckout.COST_BOOKING_SAVE_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        await  I.waitForClickable(I.getElement(iCheckout.COST_BOOKING_SAVE_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        await  I.click(I.getElement(iCheckout.COST_BOOKING_SAVE_BUTTON));
        logger.info("Clicked on Cost Booking Save Button");
    },

    /**
     * clickOnImDoneButton: clicks on I M Done Button
     */
    async clickOnImDoneButton()
    {
        await I.waitForVisible(I.getElement(iCheckout.I_M_DONE_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(I.getElement(iCheckout.I_M_DONE_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        await I.click(I.getElement(iCheckout.I_M_DONE_BUTTON));
        await logger.info("Clicked on I M Button");
    },

      /**
     * clickOnSaveAsDraftButton: clicks on Save As Draft Button
     */
    async clickOnSaveAsDraftButton()
    {
        await I.waitForVisible(I.getElement(iCheckout.SAVE_AS_DRAFT), prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(I.getElement(iCheckout.SAVE_AS_DRAFT), prop.DEFAULT_MEDIUM_WAIT);
        await  I.click(I.getElement(iCheckout.SAVE_AS_DRAFT));
        logger.info("Clicked on Save As Draft Button");
    },

      /**
     * clickOnCancelButton: clicks on Cancel Button
     */
    async clickOnCancelButton()
    {
        await I.waitForVisible(I.getElement(iCheckout.CANCEL_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(I.getElement(iCheckout.CANCEL_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        await I.click(I.getElement(iCheckout.CANCEL_BUTTON));
        logger.info("Clicked on Cancel Button");
    },

     /**
     * clickOnContinueButton: clicks on Contine Button
     */
    async clickOnContinueButton()
    {
        await I.waitForVisible(I.getElement(iCheckout.CONTINUE_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(I.getElement(iCheckout.CONTINUE_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        await I.click(I.getElement(iCheckout.CONTINUE_BUTTON));
        logger.info("Clicked on Continue Button");
    },

    async fillBasicDetails(requisitionBO)
    {
        logger.info("*********Filling Requisition Basic Details");
        commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_BASIC_DETAILS_SECTION"));
        if(requisitionBO.reqName !== "undefined")
        {
           let reqName =  await this.enterRequisitionName(requisitionBO.reqName);
           requisitionBO.setReqName(reqName);
        }

        if(requisitionBO.onBehalfOf !== "undefined")
        {
            let onBehalfOf = await this.fillOnBehalfOf(requisitionBO.onBehalfOf);
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
            await this.clickOnReasonForOrderingLink();
            let reasonForOrdering = await this.enterReasonForOrdering(requisitionBO.reasonForOrdering);
            requisitionBO.setReasonForOrdering(reasonForOrdering);
        }

        if(requisitionBO.commentsForSupplier !== "undefined")
        {
            await this.clickOnCommentsForSupplierLink();
            let commentsForSupplier = await this.enterCommentsForSupplier(requisitionBO.commentsForSupplier);
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
        let enteredProject = await commonComponent.searchAndSelectFromDropdown(I.getElement(iCheckout.PROJECT),project, suggXpath);
        //let enteredProject = await I.grabAttributeFrom(I.getElement(iCheckout.PROJECT), "value");
        logger.info("Entered Project is --->"+enteredProject);
        return enteredProject;
    },

    async fillAdditionalDetails(requisitionBO)
    {
        logger.info("*********Filling Requisition Additional Details");
        commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ADDITIONAL_DETAILS_SECTION"));
        
        if(requisitionBO.purchaseType !== "undefined")
        {
            let purchaseType = await this.selectPurchaseType(requisitionBO.purchaseType);
            requisitionBO.setPurchaseType(purchaseType);
        }

        if(requisitionBO.settlementVia !== "undefined")
        {
            let settlementVia = await this.selectSettlementVia(requisitionBO.settlementVia);
            requisitionBO.setSettlementVia(settlementVia);
        }

        if(requisitionBO.retrospectivePurchase === "Yes")
        {
            await this.clickOnRetrospectivePurchaseYesButton();
        }
        else
        {
            await this.clickOnRetrospectivePurchaseNoButton();
        }

        if(requisitionBO.attachmentPath.toString() !== null)
        {
            await this.addAttachments(requisitionBO.attachmentPath.toString());
        }

        return requisitionBO;
    },

    async fillShippingDetails(requisitionBO)
    {
        logger.info("*********Filling Requisition Shipping Details");
        commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_SHIPPING_DETAILS_SECTION"));

       if(requisitionBO.isDefaultAddressOption === true)
       {
            let defaultAddress = await this.getDefaultShippingAddress();
            requisitionBO.shipToDefaultAddress(defaultAddress);
       }

       if(requisitionBO.isOtherAddressOption === true)
       {
            //otherAddress
       }

        let deliverto = await this.fillDeliverTo(requisitionBO.deliverTo);
        requisitionBO.setDeliverTo(deliverto);
        await this.selectRequiredByDate();

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
                await this.clickOnAssignCostProjectYesButton();
            }

        if(requisitionBO.bookCostToSingleMultipleCC)
        {
            if(requisitionBO.costCenter !== "undefined")
            {
                let costCenter = await this.fillCostCenter(requisitionBO.costCenter);
                requisitionBO.setCostCenter(costCenter);
            }
            if(requisitionBO.assignCostProject === "Yes")
            {
            let project = await this.fillProject(requisitionBO.project);
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
        await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));
 
        await this.clickOnCostBookingLink(requisitionBO.itemName);

        if(requisitionBO.buyer !== "undefined")
        {
            await this.clickOnTab(lmtVar.getLabel("CHECKOUT_BUYER_TAB"));
            let buyer = await this.fillBuyerInTextBox(requisitionBO.buyer);
            requisitionBO.setBuyer(buyer);

        }

        else if(requisitionBO.assignedBuyerGroup !== "undefined")
        {
            await this.clickOnTab(lmtVar.getLabel("CHECKOUT_BUYER_TAB"));
            /// assigned BuyerGroup code
        }

        await this.clickOnCostBookingTab();

        await coaImpl.fillCoaDetails();

        // if(!prop.isCoa)
        // {
        //     if(requisitionBO.glAccount !== "undefined")
        //     {
        //        let glAccount =  this.fillGLAccount(requisitionBO.glAccount);
        //        requisitionBO.setGlAccount(glAccount);
        //     }
        // }

        // // if(requisitionBO.assetCode !== "undefined")
        // // {
        // //     let assetCode = this.fillAssetCode(requisitionBO.assetCode);
        // //     requisitionBO.setAssetCode(assetCode);
        // // }

        // if(prop.isCoa)
        // {
        //     //fill COA form code
        // }
        // else
        // {
        //     this.clickOnCostBookingSaveButton();
        //     commonComponent.waitForLoadingSymbolNotDisplayed();
        //     I.wait(prop.DEFAULT_HIGH_WAIT);
        // }

        return requisitionBO;

    },

    async clickOnCostBookingTab()
    {
        await this.clickOnTab(lmtVar.getLabel("CHECKOUT_COST_BOOKING_DETAILS_TAB"));
        logger.info("Clicked on Cost Booking Tab")
    },

    async fetchedTotalItemAmount()
    {
        let totalAmount = await grabTextFrom(I.getElement(iCheckout.FETCHED_TOTAL_AMOUNT));
        logger.info("Total amount is "+totalAmount);
        return totalAmount;
    }, 

    async clickOnShippingDetailsAndAssetTagging()
    {
        await I.click(I.getElement(iCheckout.SHIPPING_DETAILS_AND_ASSET_TAGGING_LINK));
        logger.info("Clicked on Shipping details and Asset Tagging")
    },

    async fetchedLineLevelAddress()
    {
        let address = await I.grabTextFrom(I.getElement(iCheckout.LINE_LEVEL_ADDRESS));
        logger.info("Line Level Address is---> "+address);
        return address;
    },

    async isRequisitionSubmitted()
    {
        let flag = false;
        await I.waitForVisible(I.getElement(poListingObject.SEARCH_TEXTBOX), prop.DEFAULT_MEDIUM_WAIT);
        let number = await I.grabNumberOfVisibleElements(I.getElement(poListingObject.SEARCH_TEXTBOX));
        if(number>0)
        {
            flag = true;
            logger.info("Requisition Created Successfully");
        }
        else if(await I.grabNumberOfVisibleElements(I.getElement(iCheckout.REQUISITION_NAME))>0)
        {
            flag = false;
            logger.info("Requisition did not submit. Chekcout page is still displayed.");
            throw new Exception("Requisition did not submit. Chekcout page is still displayed.");
        }
        return flag;

    },

    async clickOnUpdateDraftButton()
    {
        await I.waitForVisible(I.getElement(iCheckout.UPDATE_DRAFT_BUTTON));
        await I.waitForClickable(I.getElement(iCheckout.UPDATE_DRAFT_BUTTON));
        await I.click(I.getElement(iCheckout.UPDATE_DRAFT_BUTTON));
        logger.info("Clicked on Update Draft");

    },

    async clickOnSelectedPOContinueButton()
    {
        await I.waitForVisible(I.getElement(iCheckout.SELECT_PURCHASE_ORDER_CONTINUE_BUTTON),prop.DEFAULT_HIGH_WAIT);
        await I.waitForClickable(I.getElement(iCheckout.SELECT_PURCHASE_ORDER_CONTINUE_BUTTON),prop.DEFAULT_HIGH_WAIT);
        await I.click(I.getElement(iCheckout.SELECT_PURCHASE_ORDER_CONTINUE_BUTTON));   
    },

    async getSelectedPurchaseOrder()
    {
        await I.waitForVisible(I.getElement(iCheckout.SELECT_PURCHASE_ORDER),prop.DEFAULT_HIGH_WAIT);
        await I.waitForClickable(I.getElement(iCheckout.SELECT_PURCHASE_ORDER),prop.DEFAULT_HIGH_WAIT);
        let po = await I.grabAttributeFrom(I.getElement(iCheckout.SELECT_PURCHASE_ORDER),"value");
        logger.info("Po found : "+po.toString().trim());
        return po;

    },

    async clickOnShipToAnotherAddressButton()
    {
        await I.waitForVisible(I.getElement(iCheckout.SHIP_TO_ANOTHER_ADDRESS_BUTTON),prop.DEFAULT_HIGH_WAIT);
        await I.click(I.getElement(iCheckout.SHIP_TO_ANOTHER_ADDRESS_BUTTON));
        logger.info("Clicked on Ship to another radio button");
    },

    async selectBuyerGroupOption()
    {
        await I.waitForVisible(I.getElement(iCheckout.BUYER_DROPDOWN_ICON),prop.DEFAULT_HIGH_WAIT);
        await commonComponent.selectValueFromDropDown(I.getElement(iCheckout.BUYER_DROPDOWN_ICON),lmtVar.getLabel("BUYER_GROUP"));
    }, 

     /**
     * fetch selected buyer/group name
     * @return  buyer/group name
     */
    async getBuyer()
    {
        await I.waitForVisible(I.getElement(iCheckout.SELECTED_BUYER), prop.DEFAULT_MEDIUM_WAIT);
        let buyer = await I.grabTextFrom(I.getElement(iCheckout.SELECTED_BUYER));
        logger.info(`Entered Buyer is: ${buyer}`);
        return buyer;
    },

    async submitRequisition()
    {
        await this.clickOnImDoneButton();
        await I.wait(prop.DEFAULT_MEDIUM_WAIT);
        await this.clickOnContinueButton();
        await commonComponent.waitForLoadingSymbolNotDisplayed();
        await this.isRequisitionSubmitted();
    },


    async fillShipToAnotherAddress(addressName)
    {
        await I.waitForVisible(I.getElement(iCheckout.SHIP_TO_ANOTHER_ADDRESS_TEXTBOX),prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(I.getElement(iCheckout.SHIP_TO_ANOTHER_ADDRESS_TEXTBOX),prop.DEFAULT_MEDIUM_WAIT);
        await I.clearField(I.getElement(iCheckout.SHIP_TO_ANOTHER_ADDRESS_TEXTBOX));
        await I.fillField(I.getElement(iCheckout.SHIP_TO_ANOTHER_ADDRESS_TEXTBOX),addressName);
    },

    async clickOnCreateNewAddressOption()
    {
        await I.waitForVisible("//div[contains(text(),'"+lmtVar.getLabel("CREATE_NEW_ADDRESS")+"')]",prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable("//div[contains(text(),'"+lmtVar.getLabel("CREATE_NEW_ADDRESS")+"')]",prop.DEFAULT_MEDIUM_WAIT);
        await I.click("//div[contains(text(),'"+lmtVar.getLabel("CREATE_NEW_ADDRESS")+"')]");
    },

    async fillAddressName(addressName)
    {
        await I.waitForVisible(I.getElement(iCheckout.ADDRESS_NAME_TEXTBOX),prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(I.getElement(iCheckout.ADDRESS_NAME_TEXTBOX),prop.DEFAULT_MEDIUM_WAIT);
        await I.clearField(I.getElement(iCheckout.ADDRESS_NAME_TEXTBOX));
        await I.fillField(I.getElement(iCheckout.ADDRESS_NAME_TEXTBOX),addressName);
    },

    async fillStreet1(street)
    {
        await I.waitForVisible(I.getElement(iCheckout.STREET_ONE_TEXTBOX),prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(I.getElement(iCheckout.STREET_ONE_TEXTBOX),prop.DEFAULT_MEDIUM_WAIT);
        await I.clearField(I.getElement(iCheckout.STREET_ONE_TEXTBOX));
        await I.fillField(I.getElement(iCheckout.STREET_ONE_TEXTBOX),street);
    },

    async fillStreet2(street)
    {
        await I.waitForVisible(I.getElement(iCheckout.STREET_TWO_TEXTBOX),prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(I.getElement(iCheckout.STREET_TWO_TEXTBOX),prop.DEFAULT_MEDIUM_WAIT);
        await I.clearField(I.getElement(iCheckout.STREET_TWO_TEXTBOX));
        await I.fillField(I.getElement(iCheckout.STREET_TWO_TEXTBOX),street);
    },

    async fillCountry(country)
    {
        await I.waitForVisible(I.getElement(iCheckout.COUNTRY_DROPDOWN),prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(I.getElement(iCheckout.COUNTRY_DROPDOWN),prop.DEFAULT_MEDIUM_WAIT);
        await commonComponent.selectValueFromDropDown(I.getElement(iCheckout.COUNTRY_DROPDOWN),country);  
    },

    async fillCity(city)
    {
        await I.waitForVisible(I.getElement(iCheckout.CITY_TEXTBOX),prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(I.getElement(iCheckout.CITY_TEXTBOX),prop.DEFAULT_MEDIUM_WAIT);
        await I.clearField(I.getElement(iCheckout.CITY_TEXTBOX));
        await I.fillField(I.getElement(iCheckout.CITY_TEXTBOX),city);    
    },

    async clickOnSaveCheckbox()
    {
        await I.waitForVisible(I.getElement(iCheckout.SAVE_FOR_NEXT_TIME_CHECKBOX),prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(I.getElement(iCheckout.SAVE_FOR_NEXT_TIME_CHECKBOX),prop.DEFAULT_MEDIUM_WAIT);
        await I.click(I.getElement(iCheckout.SAVE_FOR_NEXT_TIME_CHECKBOX));
    },

    async clickOnCreateAddressButton()
    {
        await I.waitForVisible(I.getElement(iCheckout.CREATE_BUTTON),prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(I.getElement(iCheckout.CREATE_BUTTON),prop.DEFAULT_MEDIUM_WAIT);
        await I.click(I.getElement(iCheckout.CREATE_BUTTON));
    },

    async getCustomShippingAddress()
    {
        await I.waitForVisible(I.getElement(iCheckout.SHIP_TO_ANOTHER_ADDRESS_TEXTBOX),prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(I.getElement(iCheckout.SHIP_TO_ANOTHER_ADDRESS_TEXTBOX),prop.DEFAULT_MEDIUM_WAIT);
        let address = await I.grabAttributeFrom(I.getElement(iCheckout.SHIP_TO_ANOTHER_ADDRESS_TEXTBOX),"value");
        address = address.toString().replace('\n','').trim();
        logger.info("Custom Address is : "+address);
        return address;
    },

    async createNewShippingAddress(reqBo)
    {
        await this.fillShipToAnotherAddress(reqBo.customAddressName);
        await this.clickOnCreateNewAddressOption();
        await this.fillAddressName(reqBo.customAddressName);
        await this.fillStreet1(reqBo.customAddressStreet1);
        await this.fillStreet2(reqBo.customAddressStreet2);
        await this.fillCountry(reqBo.customAddressCountry);
        await this.fillCity(reqBo.customAddressCity);
        
    },

    async clickOnCreateAddress()
    {
        await this.clickOnCreateAddressButton();
        await commonComponent.waitForLoadingSymbolNotDisplayed();
        let address = await this.getCustomShippingAddress();
        return address;
    },

   

    async selectExistingShipToAnotherAddress()
    {
        await I.waitForVisible(I.getElement(iCheckout.CUSTOM_ADDRESS_SUGGESTION),prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(I.getElement(iCheckout.CUSTOM_ADDRESS_SUGGESTION),prop.DEFAULT_MEDIUM_WAIT);
        await I.click(I.getElement(iCheckout.CUSTOM_ADDRESS_SUGGESTION));
        
    },


    /**
     * Enters quantity at Line Level for specified Item
     * @param {String} itemName 
     * @param {} quantity 
     * @returns quantity
     */
    async enterItemLevelQuantity(itemName, quantity)
    {
        let xpath = `//span[contains(text(),'${itemName}')]//following::dew-col//input[@formcontrolname='quantity']`;
        await I.waitForVisible(xpath);
        await I.waitForClickable(xpath);
        await I.click(xpath);
        await I.clearField(xpath);
        await I.fillField(xpath, quantity);
        quantity = await I.grabAttributeFrom(xpath, "value");
        logger.info(`Enter Item Level Quantity ---> ${quantity}`);
        return quantity;
    },

    async clickOnRemoveAllTaxesButton()
    {
        await I.waitForVisible(I.getElement(iCheckout.REMOVE_ALL_TAXES_BUTTON));
        await I.waitForClickable(I.getElement(iCheckout.REMOVE_ALL_TAXES_BUTTON));
        await I.click(I.getElement(iCheckout.REMOVE_ALL_TAXES_BUTTON));
        logger.info("Clicked on Remove All Taxes button");
    },

    async fillTaxType(taxType)
    {
        let suggXpath = `//div[contains(text(),'${taxType}')]`;
        taxType = await commonComponent.searchAndSelectFromDropdown(I.getElement(iCheckout.TAX_TYPE_DROPDOWN), taxType, suggXpath);
        logger.info("Selected Tax Type is ---> "+taxType);
        return taxType;
    },

    async fillTaxName(taxName)
    {
        let suggXpath = `//div[contains(text(),'${taxName}')]`;
        taxType = await commonComponent.searchAndSelectFromDropdown(I.getElement(iCheckout.TAX_NAME_DROPDOWN), taxName, suggXpath);
        logger.info("Selected Tax Type is ---> "+taxName);
        return taxName;
    },

    async fetchTaxRate()
    {
        await I.waitForVisible(I.getElement(iCheckout.TAX_RATE_TEXTBOX));
        let taxRate = await I.grabAttributeFrom(I.getElement(iCheckout.TAX_RATE_TEXTBOX), "value");
        logger.info("Tax Rate is ---> "+taxRate);
        return taxRate;
    },

    async fetchTaxAmount()
    {
        await I.waitForVisible(I.getElement(iCheckout.TAX_AMOUNT_TEXTBOX));
        let taxAmount = await I.grabAttributeFrom(I.getElement(iCheckout.TAX_AMOUNT_TEXTBOX), "value");
        logger.info("Tax Rate is ---> "+taxAmount);
        return taxAmount;
    },

    async fillTaxDetails(requisitionBO)
    {
        await this.clickOnTab(lmtVar.getLabel("CHECKOUT_TAXES_TAB"));

        await this.clickOnRemoveAllTaxesButton();

        if(requisitionBO.taxType !== "undefined")
        {
            let taxType = await this.fillTaxType(requisitionBO.taxType);
            requisitionBO.setTaxType(taxType);
        }

        if(requisitionBO.taxName !== "undefined")
        {
            let taxName = await this.fillTaxName(requisitionBO.taxName);
            requisitionBO.setTaxName(taxName);
        }

        requisitionBO.setTaxRate(this.fetchTaxRate());
        requisitionBO.setTaxAmount(this.fetchTaxAmount());

        return requisitionBO;
    },

    async saveRequisitionAsDraft()
    {
        await this.clickOnSaveAsDraftButton();
        await commonComponent.waitForLoadingSymbolNotDisplayed();
        await I.wait(prop.DEFAULT_MEDIUM_WAIT);
    },

    async fillTaxDetailsAtLineLevel(requisitionBO)
    {
        await commonComponent.scrollToSection(lmtVar.getLabel("CHECKOUT_ITEM_DETAILS_SECTION"));
        await this.clickOnCostBookingLink(requisitionBO.itemName);
        requisitionBO = this.fillTaxDetails(requisitionBO);
        
        return requisitionBO;
    },


};