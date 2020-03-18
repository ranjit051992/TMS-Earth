const { I } = inject();
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const iGuided = require("./GuidedProcurementObject");
const prop = global.confi_prop;
const lmtVar = require("../../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const commonKeywordImpl = require("../../../commonKeywords/CommonComponent");
const onlineStoreImpl = require("./../OnlineStore/OnlineStoreImpl");

module.exports = {
    async addGuidedItemForPo(guidedItem) {
        await this.clickOnAddItemServiceButtonPo();
        await this.fillShortDescriptionPo();  //pass parameter
        await this.selectProductCategoryPo(); //pass category
        if (guidedItem.itemType === lmtVar.getLabel("ITEM_TYPE_GOODS")) {
            await this.selectItemTypeGoods();
        }
        else {
            logger.info(`Incorrect Item type passed --> ${guidedItem.itemType}`);
            throw new Error(`Incorrect Item type passed --> ${guidedItem.itemType}`);
        }

        if (guidedItem.receiveBy === lmtVar.getLabel("RECEIVE_BY_QUANTITY")) {
            await this.selectReceiveByQuantity();
        }
        else if (lmtVar.getLabel("RECEIVE_BY_AMOUNT")) {
            await this.selectReceiveByAmount();
        }
        else {
            logger.info(`Incorrect Receive By passed --> ${guidedItem.receiveBy}`);
            throw new Error(`Incorrect Receive By passed --> ${guidedItem.receiveBy}`);
        }

        await this.fillMarketPricePo();   //pass market price

        await this.fillQuantityPo();  //pass quantity

        await this.fillUomPo();   //pass uom

        await this.clickOnOkayButtonPo();
    },
    async clickOnAddItemServiceButtonPo() {
        await I.waitForVisible(I.getElement(iGuided.ADD_ITEM_SERVICE_BUTTON));
        await I.click(I.getElement(iGuided.ADD_ITEM_SERVICE_BUTTON));
        logger.info("Clicked on Add Item/Service button");
    },
    async fillShortDescriptionPo(shortDescription) {
        await I.waitForVisible(I.getElement(iGuided.PO_GUIDED_ITEM_SHORT_DESCRIPTION_TEXTBOX));
        await I.click(I.getElement(iGuided.PO_GUIDED_ITEM_SHORT_DESCRIPTION_TEXTBOX));
        await I.clearField(I.getElement(iGuided.PO_GUIDED_ITEM_SHORT_DESCRIPTION_TEXTBOX));
        await I.fillField(I.getElement(iGuided.PO_GUIDED_ITEM_SHORT_DESCRIPTION_TEXTBOX), shortDescription);
        logger.info(`Filled Short Description --> ${shortDescription}`);
    },
    async selectProductCategoryPo(category) {
        let optionXpath = `//span[text()='${category}']`;
        category = await commonKeywordImpl.searchAndSelectFromDropdown(I.getElement(iGuided.PO_GUIDED_ITEM_PRODUCT_CATEGORY_TEXTBOX), category, optionXpath);
        logger.info(`Selected product category --> ${category}`);
        return category;
    },
    async selectItemTypeGoodsPo() {
        await commonKeywordImpl.waitForElementPresent(I.getElement(iGuided.PO_GUIDED_ITEM_GOODS_RADIO_BUTTON));
        await commonKeywordImpl.clickUsingJsByXpath(I.getElement(iGuided.PO_GUIDED_ITEM_GOODS_RADIO_BUTTON));
        logger.info("Selected item type goods");
    },
    async selectReceiveByQuantityPo() {
        await commonKeywordImpl.waitForElementPresent(I.getElement(iGuided.PO_GUIDED_ITEM_QUANTITY_RADIO_BUTTON));
        await commonKeywordImpl.clickUsingJsByXpath(I.getElement(iGuided.PO_GUIDED_ITEM_QUANTITY_RADIO_BUTTON));
        logger.info("Selected receive by quantity");
    },
    async selectReceiveByAmountPo() {
        await commonKeywordImpl.waitForElementPresent(I.getElement(iGuided.PO_GUIDED_ITEM_AMOUNT_RADIO_BUTTON));
        await commonKeywordImpl.clickUsingJsByXpath(I.getElement(iGuided.PO_GUIDED_ITEM_AMOUNT_RADIO_BUTTON));
        logger.info("Selected receive by amount");
    },
    async fillMarketPricePo(price) {
        await I.waitForVisible(I.getElement(iGuided.PO_GUIDED_ITEM_MARKET_PRICE_TEXTBOX));
        await I.click(I.getElement(iGuided.PO_GUIDED_ITEM_MARKET_PRICE_TEXTBOX));
        await I.clearField(I.getElement(iGuided.PO_GUIDED_ITEM_MARKET_PRICE_TEXTBOX));
        await I.fillField(I.getElement(iGuided.PO_GUIDED_ITEM_MARKET_PRICE_TEXTBOX), price);
        logger.info(`Filled Market Price --> ${price}`);
        return price;
    },
    async fillQuantityPo(quantity) {
        await I.waitForVisible(I.getElement(iGuided.PO_GUIDED_ITEM_MARKET_PRICE_TEXTBOX));
        await I.click(I.getElement(iGuided.PO_GUIDED_ITEM_MARKET_PRICE_TEXTBOX));
        await I.clearField(I.getElement(iGuided.PO_GUIDED_ITEM_MARKET_PRICE_TEXTBOX));
        await I.fillField(I.getElement(iGuided.PO_GUIDED_ITEM_MARKET_PRICE_TEXTBOX), price);
        logger.info(`Filled quantity --> ${quantity}`);
        return price;
    },
    async fillUomPo(uom) {
        let optionXpath = `//span[text()='${uom}']`;
        uom = await commonKeywordImpl.searchAndSelectFromDropdown(I.getElement(iGuided.PO_GUIDED_ITEM_UOM_TEXTBOX), uom, optionXpath);
        logger.info(`Selected Uom --> ${uom}`);
        return uom;
    },
    async clickOnOkayButtonPo(uom) {
        let optionXpath = `//span[text()='${uom}']`;
        uom = await commonKeywordImpl.searchAndSelectFromDropdown(I.getElement(iGuided.PO_GUIDED_ITEM_UOM_TEXTBOX), uom, optionXpath);
        logger.info(`Selected Uom --> ${uom}`);
        return uom;
    },



    async fillItemServiceName(itemName) {
        await I.waitForVisible(I.getElement(iGuided.ITEM_NAME_TEXTBOX));
        await I.waitForClickable(I.getElement(iGuided.ITEM_NAME_TEXTBOX));
        await I.clearField(I.getElement(iGuided.ITEM_NAME_TEXTBOX));
        await I.fillField(I.getElement(iGuided.ITEM_NAME_TEXTBOX), itemName);
    },

    async clickOnAddItemServiceButton() {
        await I.waitForVisible(I.getElement(iGuided.ADD_ITEM_SERVICE_BUTTON));
        await I.waitForClickable(I.getElement(iGuided.ADD_ITEM_SERVICE_BUTTON));
        await I.click(I.getElement(iGuided.ADD_ITEM_SERVICE_BUTTON));
    },

    async fillCategory(category) {
        await commonKeywordImpl.searchAndSelectFromDropdown(I.getElement(iGuided.CATEGORY_TEXTBOX), category, "//span[contains(text(),'" + category + "')]");
    },

    async clickOnGoodsRadioButton() {
        await I.waitForVisible(I.getElement(iGuided.ITEM_TYPE_GOODS_RADIO_BUTTON));
        await I.waitForClickable(I.getElement(iGuided.ITEM_TYPE_GOODS_RADIO_BUTTON));
        await I.click(I.getElement(iGuided.ITEM_TYPE_GOODS_RADIO_BUTTON));
    },

    async clickOnServiceRadioButton() {
        await I.waitForVisible(I.getElement(iGuided.ITEM_TYPE_SERVICE_RADIO_BUTTON));
        await I.waitForClickable(I.getElement(iGuided.ITEM_TYPE_SERVICE_RADIO_BUTTON));
        await I.click(I.getElement(iGuided.ITEM_TYPE_SERVICE_RADIO_BUTTON));
    },

    async clickOnQuantityRadioButton() {
        await I.waitForVisible(I.getElement(iGuided.RECEIVE_BY_QUANTITY_RADIO_BUTTON));
        await I.waitForClickable(I.getElement(iGuided.RECEIVE_BY_QUANTITY_RADIO_BUTTON));
        await I.click(I.getElement(iGuided.RECEIVE_BY_QUANTITY_RADIO_BUTTON));
    },

    async clickOnAmountRadioButton() {
        await I.waitForVisible(I.getElement(iGuided.RECEIVE_BY_AMOUNT_RADIO_BUTTON));
        await I.waitForClickable(I.getElement(iGuided.RECEIVE_BY_AMOUNT_RADIO_BUTTON));
        await I.click(I.getElement(iGuided.RECEIVE_BY_AMOUNT_RADIO_BUTTON));
    },

    async clickOnQuotedBySupplierRadioButton() {
        await I.waitForVisible(I.getElement(iGuided.QUOTED_BY_SUPPLIER_RADIO_BUTTON));
        await I.waitForClickable(I.getElement(iGuided.QUOTED_BY_SUPPLIER_RADIO_BUTTON));
        await I.click(I.getElement(iGuided.QUOTED_BY_SUPPLIER_RADIO_BUTTON));
    },

    async clickOnEstimatedPriceRadioButton() {
        await I.waitForVisible(I.getElement(iGuided.ESTIMATED_PRICE_RADIO_BUTTON));
        await I.waitForClickable(I.getElement(iGuided.ESTIMATED_PRICE_RADIO_BUTTON));
        await I.click(I.getElement(iGuided.ESTIMATED_PRICE_RADIO_BUTTON));
    },

    async clickOnNeedAQuoteRadioButton() {
        await I.waitForVisible(I.getElement(iGuided.NEED_A_QUOTE_RADIO_BUTTON));
        await I.waitForClickable(I.getElement(iGuided.NEED_A_QUOTE_RADIO_BUTTON));
        await I.click(I.getElement(iGuided.NEED_A_QUOTE_RADIO_BUTTON));
    },

    async fillQuantity(quantity) {
        await I.waitForVisible(I.getElement(iGuided.QUANTITY_TEXTBOX));
        await I.waitForClickable(I.getElement(iGuided.QUANTITY_TEXTBOX));
        await I.clearField(I.getElement(iGuided.QUANTITY_TEXTBOX));
        await I.fillField(I.getElement(iGuided.QUANTITY_TEXTBOX), quantity.toString());
    },

    async fillUom(uom) {
        await I.scrollIntoView(I.getElement(iGuided.UOM_TEXTBOX));
        await I.waitForVisible(I.getElement(iGuided.UOM_TEXTBOX));
        await I.clearField(I.getElement(iGuided.UOM_TEXTBOX));
        await commonKeywordImpl.searchAndSelectFromDropdown(I.getElement(iGuided.UOM_TEXTBOX), uom, "//span[contains(text(),'" + uom + "')]");
    },

    async fillPrice(price) {
        await I.waitForVisible(I.getElement(iGuided.PRICE_TEXTBOX));
        await I.waitForClickable(I.getElement(iGuided.PRICE_TEXTBOX));
        await I.clearField(I.getElement(iGuided.PRICE_TEXTBOX));
        await I.fillField(I.getElement(iGuided.PRICE_TEXTBOX), price.toString());
    },

    async fillCurrency(currency) {
        await commonKeywordImpl.searchAndSelectFromDropdown(I.getElement(iGuided.CURRENCY_TEXTBOX), currency, "//div[@class='round Suggestion']//span[contains(text(),'" + currency + "')]");
    },

    async clickOnZeroPriceItemCheckbox() {
        await I.waitForVisible(I.getElement(iGuided.ZERO_PRICE_ITEM_CHECKBOX));
        await I.click(I.getElement(iGuided.ZERO_PRICE_ITEM_CHECKBOX));
    },

    async clickOnBuyerReviewYesRadioButton() {
        await I.waitForVisible(I.getElement(iGuided.BUYER_REVIEW_REQUIRED_YES_RADIO_BUTTON));
        await I.waitForClickable(I.getElement(iGuided.BUYER_REVIEW_REQUIRED_YES_RADIO_BUTTON));
        await I.click(I.getElement(iGuided.BUYER_REVIEW_REQUIRED_YES_RADIO_BUTTON));
    },

    async clickOnBuyerReviewNoRadioButton() {
        await I.waitForVisible(I.getElement(iGuided.BUYER_REVIEW_REQUIRED_NO_RADIO_BUTTON));
        await I.waitForClickable(I.getElement(iGuided.BUYER_REVIEW_REQUIRED_NO_RADIO_BUTTON));
        await I.click(I.getElement(iGuided.BUYER_REVIEW_REQUIRED_NO_RADIO_BUTTON));
    },

    async clickOnDoneButton() {
        await I.waitForVisible(I.getElement(iGuided.DONE_BUTTON));
        await I.waitForClickable(I.getElement(iGuided.DONE_BUTTON));
        await I.click(I.getElement(iGuided.DONE_BUTTON));
    },

    async clickOnDescriptionLink() {
        await I.waitForVisible(I.getElement(iGuided.DESCRIPTION_LINK));
        await I.waitForClickable(I.getElement(iGuided.DESCRIPTION_LINK));
        await I.click(I.getElement(iGuided.DESCRIPTION_LINK));
    },

    async fillDescription(description) {
        await I.waitForVisible(I.getElement(iGuided.DESCRIPTION_TEXTBOX));
        await I.waitForClickable(I.getElement(iGuided.DESCRIPTION_TEXTBOX));
        await I.clearField(I.getElement(iGuided.DESCRIPTION_TEXTBOX));
        await I.fillField(I.getElement(iGuided.DESCRIPTION_TEXTBOX), description);
    },


    async fillSupplier(supplier) {
        await I.waitForVisible(I.getElement(iGuided.SUPPLIER_TEXTBOX));
        await I.waitForClickable(I.getElement(iGuided.SUPPLIER_TEXTBOX));
        await I.clearField(I.getElement(iGuided.SUPPLIER_TEXTBOX));
        await I.fillField(I.getElement(iGuided.SUPPLIER_TEXTBOX), supplier);
    },

    async selectExistingSupplier(supplier) {
        await I.waitForVisible("//div[contains(text(),'" + supplier + "')]");
        await I.waitForClickable("//div[contains(text(),'" + supplier + "')]");
        await I.click("//div[contains(text(),'" + supplier + "')]");
    },

    async checkIfSupplierSuggestionsPresent() {
        //await I.waitForVisible(I.getElement(iGuided.SUPPLIER_NAME_SUGGESTION));
        let isPresent = commonKeywordImpl.isElementVisible(I.getElement(iGuided.SUPPLIER_NAME_SUGGESTION))
        if (isPresent) {
            logger.info("Suppliers are present.");
        }
        else {
            logger.info("Suppliers are not present.");
        }

        return isPresent;
    },

    async selectSupplierCheckbox(supplier) {
        await I.waitForVisible("//label[contains(text(),'" + supplier + "')]//parent::div[contains(@class,'checkbox')]");
        await I.click("//label[contains(text(),'" + supplier + "')]//parent::div[contains(@class,'checkbox')]");
    },

    async clickOnAdditionalDetailsButton() {
        await I.scrollIntoView(I.getElement(iGuided.SUPPLIER_ADDITIONAL_DETAILS_BUTTON));
        await I.waitForVisible(I.getElement(iGuided.SUPPLIER_ADDITIONAL_DETAILS_BUTTON));
        await I.waitForClickable(I.getElement(iGuided.SUPPLIER_ADDITIONAL_DETAILS_BUTTON));
        await I.click(I.getElement(iGuided.SUPPLIER_ADDITIONAL_DETAILS_BUTTON));
    },

    async clickOnAddressTextbox() {
        await I.waitForVisible(I.getElement(iGuided.SUPPLIER_ADDRESS_TEXTBOX));
        await I.waitForClickable(I.getElement(iGuided.SUPPLIER_ADDRESS_TEXTBOX));
        await I.click(I.getElement(iGuided.SUPPLIER_ADDRESS_TEXTBOX));
        
    },

    async clickOnSupplierAddressSuggestion() {
        await I.waitForVisible(I.getElement(iGuided.SUPPLIER_ADDRESS_SUGGESTION));
        await I.waitForClickable(I.getElement(iGuided.SUPPLIER_ADDRESS_SUGGESTION));
        await I.click(I.getElement(iGuided.SUPPLIER_ADDRESS_SUGGESTION));
    },

    async getSupplierContactName() {
        await I.waitForVisible(I.getElement(iGuided.SUPPLIER_CONTACT_TEXTBOX));
        let contactName = await I.grabAttributeFrom(I.getElement(iGuided.SUPPLIER_CONTACT_TEXTBOX), 'value');
        logger.info("Supplier Contact : "+contactName.toString());
        return contactName.toString().trim();
    },

    async getSupplierEmail() {
        await I.waitForVisible(I.getElement(iGuided.SUPPLIER_EMAIL_TEXTBOX));
        let email = await I.grabAttributeFrom(I.getElement(iGuided.SUPPLIER_EMAIL_TEXTBOX), 'value');
        logger.info("Supplier Email : "+email.toString());
        return email.toString().trim();
    },

    async clickOnSupplierModalDoneButton() {
        await I.waitForVisible(I.getElement(iGuided.SUPPLIER_DONE_BUTTON));
        await I.waitForClickable(I.getElement(iGuided.SUPPLIER_DONE_BUTTON));
        await I.click(I.getElement(iGuided.SUPPLIER_DONE_BUTTON));
    },


    async clickOnSuggestNewSupplierButton() {
        await I.waitForVisible(I.getElement(iGuided.SUPPLIER_ADDITIONAL_DETAILS_BUTTON));
        await I.waitForClickable(I.getElement(iGuided.SUPPLIER_ADDITIONAL_DETAILS_BUTTON));
        await I.click(I.getElement(iGuided.SUPPLIER_ADDITIONAL_DETAILS_BUTTON));
    },

    async fillNewSupplierNameOnPopup(supplier) {
        await I.waitForVisible(I.getElement(iGuided.NEW_SUPPLIER_NAME_TEXTBOX));
        await I.waitForClickable(I.getElement(iGuided.NEW_SUPPLIER_NAME_TEXTBOX));
        await I.clearField(I.getElement(iGuided.NEW_SUPPLIER_NAME_TEXTBOX));
        await I.fillField(I.getElement(iGuided.NEW_SUPPLIER_NAME_TEXTBOX), supplier);
    },

    async fillNewSupplierAddressOnPopup(address) {
        await I.waitForVisible(I.getElement(iGuided.NEW_SUPPLIER_ADDRESS_TEXTBOX));
        await I.waitForClickable(I.getElement(iGuided.NEW_SUPPLIER_ADDRESS_TEXTBOX));
        await I.clearField(I.getElement(iGuided.NEW_SUPPLIER_ADDRESS_TEXTBOX));
        await I.fillField(I.getElement(iGuided.NEW_SUPPLIER_ADDRESS_TEXTBOX), address);
    },

    async fillNewSupplierContactOnPopup(contact) {
        await I.waitForVisible(I.getElement(iGuided.NEW_SUPPLIER_CONTACT_TEXTBOX));
        await I.waitForClickable(I.getElement(iGuided.NEW_SUPPLIER_CONTACT_TEXTBOX));
        await I.clearField(I.getElement(iGuided.NEW_SUPPLIER_CONTACT_TEXTBOX));
        await I.fillField(I.getElement(iGuided.NEW_SUPPLIER_CONTACT_TEXTBOX), contact);
    },

    async fillNewSupplierContactEmailOnPopup(email) {
        await I.waitForVisible(I.getElement(iGuided.NEW_SUPPLIER_EMAIL_TEXTBOX));
        await I.waitForClickable(I.getElement(iGuided.NEW_SUPPLIER_EMAIL_TEXTBOX));
        await I.clearField(I.getElement(iGuided.NEW_SUPPLIER_EMAIL_TEXTBOX));
        await I.fillField(I.getElement(iGuided.NEW_SUPPLIER_EMAIL_TEXTBOX), email);
    },

    async fillNewSupplierContactPhoneOnPopup(phone) {
        await I.waitForVisible(I.getElement(iGuided.NEW_SUPPLIER_CONTACT_PHONE_TEXTBOX));
        await I.waitForClickable(I.getElement(iGuided.NEW_SUPPLIER_CONTACT_PHONE_TEXTBOX));
        await I.clearField(I.getElement(iGuided.NEW_SUPPLIER_CONTACT_PHONE_TEXTBOX));
        await I.fillField(I.getElement(iGuided.NEW_SUPPLIER_CONTACT_PHONE_TEXTBOX), phone);
    },

    async fillNewSupplierOtherDetailsOnPopup(details) {
        await I.waitForVisible(I.getElement(iGuided.NEW_OTHER_DETAILS_TEXTBOX));
        await I.waitForClickable(I.getElement(iGuided.NEW_OTHER_DETAILS_TEXTBOX));
        await I.clearField(I.getElement(iGuided.NEW_OTHER_DETAILS_TEXTBOX));
        await I.fillField(I.getElement(iGuided.NEW_OTHER_DETAILS_TEXTBOX), details);
    },

    async clickOnAddToCartButton() {
        await I.waitForVisible(I.getElement(iGuided.ADD_TO_CART_BUTTON));
        await I.waitForClickable(I.getElement(iGuided.ADD_TO_CART_BUTTON));
        await I.click(I.getElement(iGuided.ADD_TO_CART_BUTTON));
    },

    async clickOnAddToBasketButton() {
        await I.waitForVisible("//span[contains(text(),'" + lmtVar.getLabel("ADD_TO_BASKET") + "'))]");
        await I.waitForClickable("//span[contains(text(),'" + lmtVar.getLabel("ADD_TO_BASKET") + "'))]");
        await I.click("//span[contains(text(),'" + lmtVar.getLabel("ADD_TO_BASKET") + "'))]");
    },

    async addItemToCart() {
        await this.clickOnAddToCartButton();
        await commonKeywordImpl.waitForLoadingSymbolNotDisplayed();
        await commonKeywordImpl.waitForElementVisible(I.getElement(iGuided.ITEM_NAME_TEXTBOX));
    },

    async CreateGuidedItem(guidedItem) {
        await onlineStoreImpl.clickOnCreateRequestButton();
        await commonKeywordImpl.waitForElementVisible(I.getElement(iGuided.ITEM_NAME_TEXTBOX));
        await this.fillItemServiceName(guidedItem.itemName);
        await this.clickOnAddItemServiceButton();
        await this.fillGuidedItemDetails(guidedItem);
        await this.selectSupplier(guidedItem);

        if (guidedItem.nextAction === lmtVar.getLabel("ADD_TO_CART")) {
            await this.clickOnAddToCartButton();
        }
        else if (guidedItem.nextAction === lmtVar.getLabel("ADD_TO_BASKET")) {
            await this.clickOnAddToBasketButton();
        }

        await I.wait(15);

        return guidedItem;

    },

    async fillGuidedItemDetails(guidedItem) {
        if (guidedItem.category !== "undefined") {
            await this.fillCategory(guidedItem.category);
            if(guidedItem.eform!== "undefined")
            {
                await this.selectCategoryEform(guidedItem.eform);
            }
         }

        if (guidedItem.type === lmtVar.getLabel("ITEM_TYPE_GOODS")) {
            await this.clickOnGoodsRadioButton();
        }

        if (guidedItem.type === lmtVar.getLabel("ITEM_TYPE_SERVICE")) {
            await this.clickOnServiceRadioButton();
        }

        if (guidedItem.receiveBillBy === lmtVar.getLabel("RECEIVE_BY_AMOUNT")) {
            await this.clickOnAmountRadioButton();
        }

        if (guidedItem.receiveBillBy === lmtVar.getLabel("RECEIVE_BY_QUANTITY")) {
            await this.clickOnQuantityRadioButton();
        }

        this.selectSourcingStatus(guidedItem.sourcingStatus);

        if (guidedItem.quantity > 0) {
            await this.fillQuantity(guidedItem.quantity.toString());
        }

        if (guidedItem.uom !== "undefined") {
            await this.fillUom(guidedItem.uom);
        }

        if (guidedItem.price > 0) {
            await this.fillPrice(guidedItem.price.toString());
        }

        if (guidedItem.currency !== "undefined") {
            await this.fillCurrency(guidedItem.currency);
        }

        if (guidedItem.zeroPriceItem) {
            await this.clickOnZeroPriceItemCheckbox();
        }

        if (guidedItem.buyerReviewRequired) {
            await this.clickOnBuyerReviewYesRadioButton();
        }

        if (!guidedItem.buyerReviewRequired) {
            await this.clickOnBuyerReviewNoRadioButton();
        }

        if (!guidedItem.description) {
            await this.clickOnDescriptionLink();
            await this.fillDescription(guidedItem.description);
        }

        await this.clickOnDoneButton();
        await this.clickOnEformDoneButton();
    },

    async selectSupplier(guidedItem) {
        if (guidedItem.buyerReviewRequired) {
            for (let i = 0; i < guidedItem.suppliers.length; i++) {
                await this.fillSupplier(guidedItem.suppliers[i]);
                let isPresent = await this.checkIfSupplierSuggestionsPresent();
                if (isPresent) {
                    await this.selectSupplierCheckbox(guidedItem.suppliers[i]);
                    await this.clickOnAdditionalDetailsButton();
                    await this.clickOnAddressTextbox();
                    await this.clickOnSupplierAddressSuggestion();
                    let address = await this.getSupplierAddress();
                    guidedItem.supplierAddress = address;
                    let contact = await this.getSupplierContactName();
                    guidedItem.supplierContact = contact;
                    let email = await this.getSupplierEmail();
                    guidedItem.supplierEmail= email;

                    if(typeof guidedItem.bpo !== 'undefined')
                    {
                        await this.fillBpo(guidedItem.bpo);
                    }
                    await this.clickOnSupplierModalDoneButton();
                }
                else {
                    await this.clickOnSuggestNewSupplierButton();
                    await this.fillNewSupplierAddressOnPopup(guidedItem.supplierAddress);
                    await this.fillNewSupplierContactOnPopup(guidedItem.supplierContact);
                    await this.fillNewSupplierContactEmailOnPopup(guidedItem.supplierEmail);
                    await this.fillNewSupplierContactPhoneOnPopup(guidedItem.supplierPhone);
                    await this.fillNewSupplierOtherDetailsOnPopup(guidedItem.supplierOtherDetails);
                    await this.clickOnSupplierModalDoneButton();

                }

            }
        }
        else {
            for (let i = 0; i < guidedItem.suppliers.length; i++) {
                await this.fillSupplier(guidedItem.suppliers[i]);
                let isPresent = await this.checkIfSupplierSuggestionsPresent()
                if (isPresent) {
                    await this.selectExistingSupplier(guidedItem.suppliers[i]);
                    //await this.clickOnAdditionalDetailsButton();
                    await this.clickOnAddressTextbox();
                    await this.clickOnSupplierAddressSuggestion();
                    let address = await this.getSupplierAddress();
                    guidedItem.supplierAddress = address;
                    let contact = await this.getSupplierContactName();
                    guidedItem.supplierContact = contact;
                    let email = await this.getSupplierEmail();
                    guidedItem.supplierEmail= email;
                    if(typeof guidedItem.bpo !== 'undefined')
                    {
                        await this.fillBpo(guidedItem.bpo);
                    }
                    await this.clickOnSupplierModalDoneButton();
                }
                else {
                    logger.error("Supplier is not present.");
                }
            }
        }

        return guidedItem;
    },

    async selectSourcingStatus(sourcingStatus)
    {
        logger.info(`Selecting sourcing status : ${sourcingStatus}`);
        if (sourcingStatus === lmtVar.getLabel("SOURCING_STATUS_NEED_QUOTE")) {
            await this.clickOnNeedAQuoteRadioButton();
        }

        if (sourcingStatus === lmtVar.getLabel("SOURCING_STATUS_ESTIMATED_PRICE")) {
            await this.clickOnEstimatedPriceRadioButton();
        }

        if (sourcingStatus === lmtVar.getLabel("SOURCING_STATUS_QUOTED_BY_SUPPLIER")) {
            await this.clickOnQuotedBySupplierRadioButton();
        }
    },

    async getSelectedSupplier()
    {
        let selectedSupplier = await I.grabTextFrom(I.getElement(iGuided.SELECTED_SUPPLIER_FIELD));
        logger.info("Selected supplier is : "+selectedSupplier);
        return selectedSupplier;
    },

    async getSupplierAddress() {
        await I.waitForVisible(I.getElement(iGuided.SUPPLIER_ADDRESS_TEXTBOX));
        let address = await I.grabAttributeFrom(I.getElement(iGuided.SUPPLIER_ADDRESS_TEXTBOX), 'value');
        address = address.toString().replace('\n',' ').trim();
        logger.info("Supplier Address : "+address);
        return address;
    },

    async selectCategoryEform(eformName)
    {
        await I.waitForVisible(I.getElement(iGuided.EFORM_DROPDOWN));
        // await I.waitForClickable(I.getElement(iGuided.EFORM_DROPDOWN));
        // await I.click(I.getElement(iGuided.EFORM_DROPDOWN));
        await commonKeywordImpl.selectValueFromDropDown(I.getElement(iGuided.EFORM_DROPDOWN),eformName);
    },
    async clickOnEformDoneButton() 
    {
        let isPresent = await commonKeywordImpl.isElementVisible(I.getElement(iGuided.EFORM_DONE));
        if(isPresent)
        {
            await I.waitForVisible(I.getElement(iGuided.EFORM_DONE));
            await I.waitForClickable(I.getElement(iGuided.EFORM_DONE));
            await I.click(I.getElement(iGuided.EFORM_DONE));
        }
    },

    async fillBpo(bpo) 
    {
        await commonKeywordImpl.searchAndSelectFromDropdown(I.getElement(iGuided.SUPPLIER_BPO_TEXTBOX), bpo, "//span[contains(text(),'" + bpo + "')]");
    },
}