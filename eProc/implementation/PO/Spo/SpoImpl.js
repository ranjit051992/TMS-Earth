const { I } = inject();
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const iSpoObject = require("./SpoObject");
const lmtVar = require("../../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const prop = global.confi_prop;
const commonComponent = require("../../../commonComponent/CommonComponent");
const approvalImpl = require("../../Approval/ApprovalImpl");
const poListingImpl = require("../PoListing/PoListingImpl");
const poListingObject = require("../PoListing/PoListingObject");

module.exports = {
    async clickOnCreatePOButton() {
        await I.seeElement(I.getElement(iSpoObject.createPOButton));
        await I.click(I.getElement(iSpoObject.createPOButton));
        logger.info("Clicked on Create PO button");
    },
    async clickOnStandardPOButton() {
        I.click(I.getElement(iSpoObject.standardPOButton));
        await I.waitForVisible(I.getElement(iSpoObject.poNumberTextbox), prop.DEFAULT_MEDIUM_WAIT);
        I.saveScreenshot("CreateSpo.png");
        logger.info("Clicked on create standard po button.");
    },
    async fillPONumber(poNumber) {
        I.fillField(I.getElement(iSpoObject.poNumberTextbox), poNumber);
        logger.info("Filled po number :" + poNumber);
    },
    async fetchPONumber() {
        let poNumber = await I.grabAttributeFrom(I.getElement(iSpoObject.poNumberTextbox), "value");
        logger.info("Fetched po number :" + poNumber);
        return poNumber;
    },
    async fillPODescription(poDescription) {
        I.fillField(I.getElement(iSpoObject.poDescriptionTextbox), poDescription);
        logger.info("Filled po description :" + poDescription);
    },
    async clickOnPurchaseTypeDropdown() {
        I.seeElement(I.getElement(iSpoObject.purchaseTypeDropdown));
        I.click(I.getElement(iSpoObject.purchaseTypeDropdown));
    },
    async selectPurchaseType(purchaseType) {
        this.clickOnPurchaseTypeDropdown();
        I.seeElement("//a[contains(text(),'" + purchaseType + "')]");
        I.click("//a[contains(text(),'" + purchaseType + "')]");
        logger.info("Selected purchase type :" + purchaseType);
    },
    async clickOnBuyingUnitLink() {
        I.click(I.getElement(iSpoObject.BUYING_UNIT_LINK));
        logger.info("Clicked on Buying Unit link");
    },
    async fillCompany(company) {
        I.click(I.getElement(iSpoObject.COMPANY_TEXTBOX));
        I.clearField(I.getElement(iSpoObject.COMPANY_TEXTBOX));
        I.fillField(I.getElement(iSpoObject.COMPANY_TEXTBOX), company);
        this.selectOrganizationUnitOption(company);
        company = await I.grabAttributeFrom(I.getElement(iSpoObject.COMPANY_TEXTBOX), "value");
        logger.info(`Selected company --> ${company}`);
        return company;
    },
    async fillBusinessUnit(businessUnit) {
        I.click(I.getElement(iSpoObject.BUSINESS_UNIT_TEXTBOX));
        I.clearField(I.getElement(iSpoObject.BUSINESS_UNIT_TEXTBOX));
        I.fillField(I.getElement(iSpoObject.BUSINESS_UNIT_TEXTBOX), businessUnit);
        this.selectOrganizationUnitOption(businessUnit);
        businessUnit = await I.grabAttributeFrom(I.getElement(iSpoObject.BUSINESS_UNIT_TEXTBOX), "value");
        logger.info(`Selected business unit --> ${businessUnit}`);
        return businessUnit;
    },
    async fillLocation(location) {
        I.click(I.getElement(iSpoObject.LOCATION_TEXTBOX));
        I.clearField(I.getElement(iSpoObject.LOCATION_TEXTBOX));
        I.fillField(I.getElement(iSpoObject.LOCATION_TEXTBOX), location);
        this.selectOrganizationUnitOption(location);
        location = await I.grabAttributeFrom(I.getElement(iSpoObject.LOCATION_TEXTBOX), "value");
        logger.info(`Selected location --> ${location}`);
        return location;
    },
    async clickOnOuModalDoneButton() {
        I.click(I.getElement(iSpoObject.OU_MODAL_DONE_BUTTON));
        await I.waitForInvisible(I.getElement(iSpoObject.OU_MODAL_DONE_BUTTON));
        logger.info(`Clicked on OU modal Done button`);
    },
    async fetchBillToAddress() {
        let billToAddress = await I.grabTextFrom(I.getElement(iSpoObject.BILL_TO_ADDRESS_VALUE));
        logger.info(`Clicked on OU modal Done button`);
        return billToAddress;
    },
    async fillSupplierName(supplierName) {
        I.fillField(I.getElement(iSpoObject.supplierNameTextbox), supplierName);
    },
    async selectSupplierName(supplierName) {
        I.click("//p[@title='" + supplierName + "']");
        logger.info("Selected supplier name :" + supplierName);
    },
    async fillSupplierAddress(address) {
        I.fillField(I.getElement(iSpoObject.supplierAddressTextbox), address);
    },
    async selectSupplierAddress(address) {
        I.click("//p[contains(text(),'" + address + "')]");
        logger.info("Selected supplier address :" + address);
    },
    async clickOnPaymentTermDropdown() {
        I.click(I.getElement(iSpoObject.paymentTermDropdown));
    },
    async selectPaymentTerm(paymentTerm) {
        I.click("//div[contains(@title,'" + paymentTerm + "')]");
        logger.info("Selected payment term :" + paymentTerm);
    },
    async clickOnDeliveryTermDropdown() {
        I.click(I.getElement(iSpoObject.deliveryTermDropdown));
    },
    async selectDeliveryTerm(deliveryTerm) {
        I.click("//div[contains(@title,'" + deliveryTerm + "')]");
        logger.info("Selected delivery term :" + deliveryTerm);
    },
    async fillCurrency(currency) {
        I.fillField(I.getElement(iSpoObject.currencyTextbox), currency);
    },
    async selectCurrency(currency) {
        I.click("//span[contains(text(),'" + currency + "')]");
        logger.info("Selected currency :" + currency);
    },
    async fillBuyer(buyer) {
        I.fillField(I.getElement(iSpoObject.buyerTextbox), buyer);
        this.selectBuyer(buyer);
        buyer = await I.grabAttributeFrom(I.getElement(iSpoObject.buyerTextbox), "value");
        return buyer;
    },
    async selectBuyer(buyer) {
        I.seeElement("//span[contains(text(),'" + buyer + "')]");
        I.click("//span[contains(text(),'" + buyer + "')]");
        logger.info("Selected buyer :" + buyer);
    },
    async selectDeliverTo(deliverTo) {
        I.click(I.getElement(iSpoObject.DELIVER_TO_TEXTBOX));
        I.clearField(I.getElement(iSpoObject.DELIVER_TO_TEXTBOX));
        I.fillField(I.getElement(iSpoObject.DELIVER_TO_TEXTBOX), deliverTo);
        this.selectDeliverToOption(deliverTo);
        deliverTo = await I.grabAttributeFrom(I.getElement(iSpoObject.DELIVER_TO_TEXTBOX), "value");
        logger.info(`Selected deliverTo -->${deliverTo}`);
        return deliverTo;
    },
    async selectRequiredByDate() {
        logger.info("Selecting date");
        let day = new Date().getDate();
        let dayXpath = `//div[text()='${day}']/..`;
        I.click(I.getElement(iSpoObject.REQUIRED_BY));
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
    async  clickonTab(tabList, tabName) {
        I.scrollIntoView("//dew-section//div[contains(text(),'" + tabName + "')]");
        I.wait(prop.DEFAULT_WAIT);
        logger.info(`Scrolled to section --> ${tabName}`);
    },
    async clickOnCostAllocationTab() {
        I.seeElement(I.getElement(iSpoObject.COST_ALLOCATION_TAB));
        I.click(I.getElement(iSpoObject.COST_ALLOCATION_TAB));
        logger.info("Clicked on Cost Allocation Tab");
    },
    async clickOnAssignCostNOButton() {
        I.seeElement(I.getElement(iSpoObject.ASSIGN_COST_PROJECT_NO_RADIO_BUTTON));
        I.click(I.getElement(iSpoObject.ASSIGN_COST_PROJECT_NO_RADIO_BUTTON));
        logger.info("Clicked on Assign cost Project No Button");
    },
    async clickOnBookCostToSingle_MultipleCostCenter() {
        I.seeElement(I.getElement(iSpoObject.BOOK_COST_TO_SINGLE_MULTIPLE_COST_CENTER_RADIO_BUTTON));
        I.click(I.getElement(iSpoObject.BOOK_COST_TO_SINGLE_MULTIPLE_COST_CENTER_RADIO_BUTTON));
        logger.info("Clicked on Book Cost To Single/Multiple Cost center");
    },
    async enterCostCenter(costCenter) {
        I.seeElement(I.getElement(iSpoObject.COST_CENTER_INPUT_FIELD));
        I.fillField(I.getElement(iSpoObject.COST_CENTER_INPUT_FIELD), costCenter);
        const xpath = `//div[contains(text(),'${costCenter}')]`;
        I.waitForVisible(xpath, prop.DEFAULT_MEDIUM_WAIT);
        I.click(xpath);
        costCenter = await I.grabAttributeFrom(I.getElement(iSpoObject.COST_CENTER_INPUT_FIELD), "value");
        logger.info(`Enter Cost Center: ${costCenter}`);
        return costCenter;
    },
    async selectReceiptCreationAtHeaderLevel() {
        await I.executeScript(function() {
            document.getElementById("customControlValidation2").click();
        });
        logger.info(`Selected Receipt Creation at Header Level`);
    },
    async selectDefaultReceiptCreation() {
        await I.executeScript(function() {
            document.getElementById("customRadioInline1").click();
        });
        logger.info(`Selected Default Receipt Creation`);
    },
    async clickOnAddLineItemButton() {
        I.seeElement(I.getElement(iSpoObject.ADD_LINE_ITEM_BUTTON));
        I.click(I.getElement(iSpoObject.ADD_LINE_ITEM_BUTTON));
        logger.info("Clicked on Add Line Item Button");
    },
    async enterItemName(itemName) {
        I.seeElement(I.getElement(iSpoObject.ITEM_NAME_INPUT));
        I.fillField(I.getElement(iSpoObject.ITEM_NAME_INPUT), itemName);
        logger.info(`Entered item name: ${itemName}`);
    },
    async selectItemOption(itemName) {
        I.seeElement(I.getElement(iSpoObject.FIRST_ITEMNAME_OPTION));
        I.click(I.getElement(iSpoObject.FIRST_ITEMNAME_OPTION));
        logger.info(`Selected first item option: ${itemName}`);
    },
    async clickOnCostBookingLink(itemName) {
        let costBookingLink = `(//span[contains(text(),'${itemName}')]//ancestor::dew-row//following-sibling::dew-row//dew-flex-item[3])`;
        I.seeElement(costBookingLink);
        I.click(costBookingLink);
        logger.info("Clicked on Cost booking Link");
    },
    async fillGlAccount(glAccount) {
        I.seeElement(I.getElement(iSpoObject.GLACCOUNT));
        I.fillField(I.getElement(iSpoObject.GLACCOUNT), glAccount);
        let glAccountSuggXpath = `//div[contains(text(),'${glAccount}')]`;
        I.waitForVisible(glAccountSuggXpath, prop.DEFAULT_MEDIUM_WAIT);
        I.click(glAccountSuggXpath);
        glAccount = await I.grabAttributeFrom(I.getElement(iSpoObject.GLACCOUNT), "value");
        logger.info(`Selected GlAccount: ${glAccount}`);
        return glAccount;
    },
    async clickOnCostBookingSaveButton() {
        I.seeElement(I.getElement(iSpoObject.COSTBOOKING_SAVE_BUUTON));
        I.click(I.getElement(iSpoObject.COSTBOOKING_SAVE_BUUTON));
        logger.info("Clicked on Save Button");
    },
    async clickOnRemoveAllTaxesButton() {
        I.seeElement(I.getElement(iSpoObject.REMOVE_ALL_TAXES_BUTTON));
        I.click(I.getElement(iSpoObject.REMOVE_ALL_TAXES_BUTTON));
        logger.info("Clicked on Remove All Taxes Button");
    },
    async clickOnSubmitPOButton() {
        I.seeElement(I.getElement(iSpoObject.SUBMIT_PO_BUTTON));
        I.click(I.getElement(iSpoObject.SUBMIT_PO_BUTTON));
        logger.info("Clicked on Submit PO Button");
    },
    async clickOnConfirmButton() {
        I.seeElement(I.getElement(iSpoObject.CONFIRM_BUTTON));
        I.click(I.getElement(iSpoObject.CONFIRM_BUTTON));
        logger.info("Clicked on Confirm button");
    },
    async selectOrganizationUnitOption(option) {
        let optionXpath = `//div[contains(text(),'${option}')]`;
        I.seeElement(optionXpath);
        I.click(optionXpath);
        logger.info(`Selected option --> ${option}`);
    },
    async selectDeliverToOption(option) {
        let optionXpath = `//span[contains(text(),'${option}')]`;
        I.seeElement(optionXpath);
        I.click(optionXpath);
        logger.info(`Selected Deliver To --> ${option}`);
    },
    async selectTaxInclusive() {
        let checked = await I.executeScript(function() {
            return document.getElementById("inclusive1").checked;
        });
        if(!checked) {
            await I.executeScript(function() {
                document.getElementById("inclusive1").click();
            });
            logger.info("Selected Tax Inclusive");
        }
        else {
            logger.info("Tax Inclusive is already checked");
        }
    },
    async clickRemoveTaxesConfirmButton() {
        I.click(I.getElement(iSpoObject.REMOVE_TAXES_CONFIRM_BUTTON));
        logger.info(`Clicked on Remove Taxes Confirm button`);
    },
    async fillTermsAndConditions(termsAndConditions) {
        I.fillField(I.getElement(iSpoObject.TERMS_AND_CONDITIONS_TEXTBOX), termsAndConditions);
        logger.info(`Entered terms and conditions --> ${termsAndConditions}`);
    },
    async fillNotes(notes) {
        I.fillField(I.getElement(iSpoObject.NOTES_TEXTBOX), notes);
        logger.info(`Entered notes --> ${notes}`);
    },
    async fetchRequiredBy() {
        let requiredBy = await I.grabAttributeFrom(I.getElement(iSpoObject.REQUIRED_BY), "value");
        logger.info(`Selected Required By -->${requiredBy}`);
        return requiredBy;
    },
    async createSpoFlow(spo) {
        await poListingImpl.navigateToPoListing();

        await this.clickOnCreatePOButton();

        await this.clickOnStandardPOButton();

        spo = await this.fillBasicDetails(spo);

        spo = await this.fillBillingInformation(spo);

        spo = await this.fillSupplierDetails(spo);

        spo = await this.fillBuyerAndOtherInformation(spo);

        spo = await this.fillShippingDetails(spo);

        spo = await this.fillCostAllocation(spo);

        spo = await this.fillControlSettings(spo);

        spo = await this.fillLineItems(spo);

        spo = await this.fillTaxes(spo);

        spo = await this.fillAdditionalDetails(spo);

        await this.submitPo();

        return spo;
    },
    async fillBasicDetails(spo) {
        logger.info(`**************Filling Basic Details**************`);
        this.fillPONumber(spo.poNumber);
        this.fillPODescription(spo.poDescription);
        this.selectPurchaseType(spo.purchaseType);
        return spo;
    },
    async fillBillingInformation(spo) {
        logger.info(`**************Filling Billing Information**************`);
        this.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_BILLING_INFORMATION_SECTION"));
        this.clickOnBuyingUnitLink();
        await this.fillCompany(spo.company);
        await this.fillBusinessUnit(spo.businessUnit);
        await this.fillLocation(spo.location);
        await this.clickOnOuModalDoneButton();
        spo.setBillToAddress(this.fetchBillToAddress());
        return spo;
    },
    async fillSupplierDetails(spo) {
        logger.info(`**************Filling Supplier Details**************`);
        this.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_SUPPLIER_DETAILS_SECTION"));
        this.fillSupplierName(spo.supplierName);
        this.selectSupplierName(spo.supplierName);
        this.fillSupplierAddress(spo.supplierAddress);
        this.selectSupplierAddress(spo.supplierAddress)
        this.clickOnPaymentTermDropdown();
        this.selectPaymentTerm(spo.paymentTerm);
        this.clickOnDeliveryTermDropdown();
        this.selectDeliveryTerm(spo.deliveryTerm);
        this.fillCurrency(spo.currency);
        this.selectCurrency(spo.currency);
        return spo
    },
    async fillBuyerAndOtherInformation(spo) {
        logger.info(`**************Filling Buyer and Other Information**************`);
        this.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_BUYER_AND_OTHER_INFORMATION_SECTION"));
        let buyer = await this.fillBuyer(spo.buyer);
        spo.setBuyer(buyer);
        return spo
    },
    async fillShippingDetails(spo) {
        logger.info(`**************Filling Shipping Details**************`);
        this.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_SHIPPING_DETAILS_SECTION"));
        let deliverTo = await this.selectDeliverTo(spo.deliverTo);
        spo.setDeliverTo(deliverTo);
        // await this.selectRequiredByDate();
        let requiredBy = this.fetchRequiredBy();
        spo.setRequiredBy(requiredBy);
        return spo;
    },
    async fillCostAllocation(spo) {
        logger.info(`**************Filling Cost Allocation**************`);
        this.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_COST_ALLOCATION_SECTION"));
        this.clickOnAssignCostNOButton();
        this.clickOnBookCostToSingle_MultipleCostCenter();
        let costCenter = await this.enterCostCenter(spo.costCenter);
        spo.setCostCenter(costCenter);
        return spo;
    },
    async fillControlSettings(spo) {
        logger.info(`**************Filling Control Settings**************`);
        this.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_CONTROL_SETTINGS_SECTION"));
        if (spo.receiptRuleAtHeaderLevel) {
            await this.selectReceiptCreationAtHeaderLevel();
            if (spo.receiptCreationDefault) {
                await this.selectDefaultReceiptCreation();
            }
        }
        return spo;
    },
    async fillLineItems(spo) {
        logger.info(`**************Filling Line Items**************`);
        if(spo.taxInclusive) {
            await this.selectTaxInclusive();
            this.clickRemoveTaxesConfirmButton();
        }
        this.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_LINE_ITEMS_SECTION"));
        this.clickOnAddLineItemButton();
        this.enterItemName(spo.items[0].itemName);
        this.selectItemOption(spo.items[0].itemName);
        this.clickOnCostBookingLink(spo.items[0].itemName);

        let glAccount = await this.fillGlAccount(spo.glAccount);
        spo.setGlAccount(glAccount);
        this.clickOnCostBookingSaveButton();
        return spo;
    },
    async fillTaxes(spo) {
        logger.info(`**************Filling Taxes**************`);
        this.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_TAXES_SECTION_SECTION"));
        this.clickOnRemoveAllTaxesButton();
        return spo;
    },
    async fillAdditionalDetails(spo) {
        logger.info(`**************Filling Additional Details**************`);
        this.clickonTab(I.getElement(iSpoObject.TAB_NAME_LIST), lmtVar.getLabel("SPO_ADDITIONAL_DETAILS_SECTION"));
        this.fillTermsAndConditions(spo.termsAndConditions);
        this.fillNotes(spo.notes);
        return spo;
    },
    async submitPo() {
        logger.info(`**************Submitting SPO**************`);
        this.clickOnSubmitPOButton();
        this.clickOnConfirmButton();
        await I.waitForVisible(I.getElement(iSpoObject.spinner));
        await I.waitForInvisible(I.getElement(iSpoObject.spinner), prop.DEFAULT_HIGH_WAIT);
        logger.info("Waited for loader to go off after submitting spo");
    },
    async createAndReleaseSpoFlow(spo) {
        spo = await this.createSpoFlow(spo);
        await this.navigateToApprovalListing();
        //  click on spo tab
        await approvalImpl.approveDoc(spo.poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
        await poListingImpl.navigateToPoListing();
        await commonComponent.searchDocOnListing(spo.poNumber, lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"));
        let status = await poListingImpl.getPoStatus();
        let flag = status.includes(lmtVar.getLabel("RELEASED_STATUS"));
        if(!flag) {
            logger.info(`Failed to release spo because status is ${status} on po listing after approving`);
            throw new Error(`Failed to release spo because status is ${status} on po listing after approving`);
        }
        else {
            logger.info("Spo is released successfully");
        }
        return spo;
    },
    async clickOnSaveAsDraftButton() {
        await I.seeElement(I.getElement(iSpoObject.SPO_SAVE_AS_DRAFT_BUTTON));
        await I.click(I.getElement(iSpoObject.SPO_SAVE_AS_DRAFT_BUTTON));
        await I.seeElement(I.getElement(poListingObject.PO_NUMBER_LINK));
        logger.info("Clicked on Save as Draft button");
    },
    async getItemNameOnSpoView(index) {
        let itemNameXpath = `(//eproc-line-items-view//span[contains(@class,'text-body-link')])[${index}]`;
        await I.seeElement(itemNameXpath);
        let itemName = await I.grabTextFrom(itemNameXpath);
        logger.info(`Retrieved item name --> ${itemName}`);
        return itemName;
    }

}