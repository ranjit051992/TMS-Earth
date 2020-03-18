const { I } = inject();
const logger = require("../../../../Framework/FrameworkUtilities/Logger/logger");
const iOnlineStore = require("./OnlineStoreObject");
const prop = global.confi_prop;
const lmtVar = require("../../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const commonComponent = require("../../../commonKeywords/CommonComponent");

module.exports = {

    /** 
     * fill search item name in search field
     * 
     * @param itemName
     * 
    */
    async fillSearchItem(itemName) {

        await I.scrollIntoView(I.getElement(iOnlineStore.SEARCH_TEXTBOX));
        await I.waitForVisible(I.getElement(iOnlineStore.SEARCH_TEXTBOX));
        await I.waitForClickable(I.getElement(iOnlineStore.SEARCH_TEXTBOX));
        await I.clearField(I.getElement(iOnlineStore.SEARCH_TEXTBOX));
        await I.fillField(I.getElement(iOnlineStore.SEARCH_TEXTBOX), itemName);
        logger.info(`Entered item name : ${itemName}`);

    },

    /** 
     * clicks on search icon
     * 
     * @param 
     * @returns   
     * 
    */
    async clickOnSearchIcon() {
        await I.waitForVisible(I.getElement(iOnlineStore.SEARCH_TEXTBOX));
        await I.waitForClickable(I.getElement(iOnlineStore.SEARCH_TEXTBOX));
        await I.pressKey('Enter');
        logger.info(`clicked on Search icon`);

    },

    /** 
      * fill quantity in for specific item 
      * 
      * @param itemName, quantity
      * 
     */
    async fillItemQuantity(itemName, quantity) {
        await I.waitForVisible("//span[contains(text(),'" + itemName + "')]//ancestor::dew-card//input[@aria-label='Quantity']", prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable("//span[contains(text(),'" + itemName + "')]//ancestor::dew-card//input[@aria-label='Quantity']", prop.DEFAULT_MEDIUM_WAIT);
        await I.clearField("//span[contains(text(),'" + itemName + "')]//ancestor::dew-card//input[@aria-label='Quantity']");
        await I.fillField("//span[contains(text(),'" + itemName + "')]//ancestor::dew-card//input[@aria-label='Quantity']", quantity);
        logger.info(`Entered item quantity : ${quantity}`);
    },

    /** 
      * clicks on add to cart button present against specific item
      * 
      * @param itemName
      * @returns   
      * 
     */
    async clickOnAddToCartButton(itemName) {
        await I.waitForVisible("//span[contains(text(),'" + itemName + "')]//ancestor::dew-card//button[contains(@class,'btn primary')]", prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable("//span[contains(text(),'" + itemName + "')]//ancestor::dew-card//button[contains(@class,'btn primary')]", prop.DEFAULT_MEDIUM_WAIT);
        await I.click("//span[contains(text(),'" + itemName + "')]//ancestor::dew-card//button[contains(@class,'btn primary')]");
        logger.info(`clicked on add to cart button`);
    },

    /** 
      * clicks on cart icon
      * 
      * @param 
      * @returns   
      * 
     */
    async clickOnCartIcon() {
        await I.scrollIntoView(I.getElement(iOnlineStore.CART_ICON));
        await I.waitForVisible(I.getElement(iOnlineStore.CART_ICON), prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(I.getElement(iOnlineStore.CART_ICON), prop.DEFAULT_MEDIUM_WAIT);
        await I.click(I.getElement(iOnlineStore.CART_ICON));
        logger.info(`clicked on Cart icon`);
    },

    /** 
      * fill search item name in search field & hit search icon
      * 
      * @param itemName
      * @returns   
      * 
     */
    async searchItem(itemName) {
        await this.fillSearchItem(itemName);
        await this.clickOnSearchIcon();
        I.waitForVisible("//span[contains(text(),'" + itemName + "')]", prop.DEFAULT_MEDIUM_WAIT);
        I.seeElement("//span[contains(text(),'" + itemName + "')]");
        logger.info("Item is searched.");
    },

    /** 
      * search item, fill quantity & add it to cart
      * 
      * @param itemName , quantity
      * @returns   
      * 
     */
    async addItemToCart(itemName, quantity) {
        await this.searchItem(itemName);
        await this.fillItemQuantity(itemName, quantity);
        await this.clickOnAddToCartButton(itemName);
        await I.waitForVisible(I.getElement(iOnlineStore.ADD_TO_CART_SUCCESS_MSG), prop.DEFAULT_MEDIUM_WAIT);
        logger.info("Add to cart success msg is displayed. Item " + itemName + " is added to cart.");
        await I.scrollIntoView(I.getElement(iOnlineStore.ONLINE_STORE_LINK));
    },

    /** 
      * click on Online Store link present at the top
      * 
      * @param
      * @returns   
      * 
     */
    async clickOnOnlineStoreLink() {

        await I.scrollIntoView(I.getElement(iOnlineStore.ONLINE_STORE_LINK));
        await I.waitForVisible(I.getElement(iOnlineStore.ONLINE_STORE_LINK), prop.DEFAULT_MEDIUM_WAIT);
        await I.click(I.getElement(iOnlineStore.ONLINE_STORE_LINK));
    },

    /** 
      * Wait for loading spinner to go off & item search textbox to be visible
      * 
      * @param
      * @returns   
      * 
     */
    async waitForOnlineStoreToLoad() {
        await I.waitForInvisible(I.getElement(iOnlineStore.SPINNER), prop.DEFAULT_HIGH_WAIT);
        await I.waitForVisible(I.getElement(iOnlineStore.SEARCH_TEXTBOX), prop.DEFAULT_HIGH_WAIT);
        logger.info("Online Store page is loaded.");
    },

    /** 
     * Check whether search result display items as per searched item name
     * 
     * @param itemName
     * @returns   
     * 
    */
    async checkSearchItemReqults(itemName) {
        let searchResultXpath = `//eproc-product-list//span[contains(text(),'${itemName}')]`;
        let searchedItems = await I.grabNumberOfVisibleElements(searchResultXpath);
        let isGreater = false;
        if (searchedItems > 0) {
            isGreater = true;
        }

        return isGreater;
    },

    async checkItemsInFavorites() {
        let isPresent = false;
        let noOfElements = await I.grabNumberOfVisibleElements(I.getElement(iOnlineStore.NO_FAV_PRODUCT_DATA_MSG));
        if (noOfElements > 0) {
            isPresent = false
            await logger.info("No data present for favorite items.");
        }
        else {
            isPresent = true;
            await logger.info("Data is present for favorite items.");
        }

        return isPresent;
    },

    /** 
      * Checks whether items are present under favorites tab, if found any then clicks on view all button
      * 
      * @param 
      * @returns   
      * 
     */
    async clickOnFavoritesViewAllButton() {
        await I.waitForVisible(I.getElement(iOnlineStore.VIEW_ALL_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(I.getElement(iOnlineStore.VIEW_ALL_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        await I.click(I.getElement(iOnlineStore.VIEW_ALL_BUTTON));
        await I.waitForVisible(I.getElement(iOnlineStore.ITEM_CHECKBOX), prop.DEFAULT_MEDIUM_WAIT);
        await logger.info("Clicked on view all button present in favorites section.");
    },

    async selectAllFavoriteItems() {
        let noOfElements = await I.grabNumberOfVisibleElements(I.getElement(iOnlineStore.ITEM_CHECKBOX));
        for (let i = 1; i <= noOfElements; i++) {
            let xpath = await "(" + I.getElement(iOnlineStore.ITEM_CHECKBOX) + ")[" + i + "]";
            await I.click(xpath);
        }
    },
    async clickOnMenuIcon() {
        let noOfElements = await I.grabNumberOfVisibleElements(I.getElement(iOnlineStore.MULTISELECT_MENU_ICON));
        if (noOfElements > 0) {
            await I.scrollIntoView(I.getElement(iOnlineStore.MULTISELECT_MENU_ICON));
            await I.waitForVisible(I.getElement(iOnlineStore.MULTISELECT_MENU_ICON), prop.DEFAULT_MEDIUM_WAIT);
            await I.waitForClickable(I.getElement(iOnlineStore.MULTISELECT_MENU_ICON), prop.DEFAULT_MEDIUM_WAIT);
            await I.click(I.getElement(iOnlineStore.MULTISELECT_MENU_ICON));
        }
    },

    async SelectOnMenuOption(option) {
        let noOfElements = await I.grabNumberOfVisibleElements(I.getElement(iOnlineStore.MULTISELECT_MENU_OPTION));
        for (let i = 1; i <= noOfElements; i++) {
            let optionXpath = await "(" + I.getElement(iOnlineStore.MULTISELECT_MENU_OPTION) + ")[" + i + "]";
            let text = await I.grabTextFrom(optionXpath);
            console.log("Actual Option : " + text + " Expected " + option);

            if (text === option) {
                await I.waitForClickable(optionXpath);
                await I.click(optionXpath);
                break;
            }
        }
    },

    async clickOnFavoritesIcon(itemName) {
        // pause();
        let favoriteIconXpath = "//span[text()='" + itemName + "']" + I.getElement(iOnlineStore.FAVORITE_ICON);

        let totalIcons = await I.grabNumberOfVisibleElements(favoriteIconXpath);
        logger.info("total fav icon " + totalIcons);

        let totalMarked = 0;
        for (let i = 1; i <= totalIcons; i++) {
            let xpath = "(" + favoriteIconXpath + ")[" + i + "]";
            logger.info(" fav icon xpath " + xpath);

            let attr = await I.grabAttributeFrom(xpath, "class");

            logger.info("Attribute classname " + attr);
            //    if(attr.includes('fill'))
            //    {
            await I.waitForVisible(xpath, prop.DEFAULT_MEDIUM_WAIT);
            await I.waitForClickable(xpath, prop.DEFAULT_MEDIUM_WAIT);
            await I.click(xpath);
            logger.info("Clicked on fav icon");
            await totalMarked++;
            //}

        }

        await logger.info("Total items marked favorite are : " + totalMarked);
        return totalMarked;
    },

    async addItemsToFavorites(itemName) {
        let totalItemsMarked = await this.clickOnFavoritesIcon(itemName);
    },

    async verifyFavoriteItems(itemName, totalFav) {
        let noOfElements = await I.grabNumberOfVisibleElements("//span[text()='" + itemName + "']");
        let isEqual = false;
        if (noOfElements === totalFav) {
            isEqual = true;
            await logger.info("Favorites item validated successfully. Expected Favorites : " + totalFav + " Actual Favorites : " + noOfElements);
        }

        return isEqual;
    },

    async selectMultipleItems() {
        let itemCheckboxXpath = await I.getElement(iOnlineStore.ITEM_CHECKBOX);
        let noOfElements = await I.grabNumberOfVisibleElements(itemCheckboxXpath);
        let itemDetailsArray = new Array();
        let j = 1;
        for (let i = 1; i <= noOfElements; i++) {

            let itemXpath = await I.getElement(iOnlineStore.ITEM_NAME);
            let supplierNameXpath = await I.getElement(iOnlineStore.SUPPLIER_NAME);
            let uomXpath = await I.getElement(iOnlineStore.UOM);
            let unitPriceXpath = await I.getElement(iOnlineStore.UNIT_PRICE);
            let userCurrencyXpath = await I.getElement(iOnlineStore.USER_CURRENCY);
            let checkboxXpath = "(" + I.getElement(iOnlineStore.ITEM_CHECKBOX) + ")[" + i + "]";
            if (j < 4) {
                if (true) {
                    await I.waitForVisible("(" + itemXpath + ")[" + i + "]", prop.DEFAULT_MEDIUM_WAIT);
                    let item = await I.grabTextFrom("(" + itemXpath + ")[" + i + "]");

                    await I.waitForVisible("(" + supplierNameXpath + ")[" + i + "]", prop.DEFAULT_MEDIUM_WAIT);
                    let supplierName = await I.grabTextFrom("(" + supplierNameXpath + ")[" + i + "]");

                    await I.waitForVisible("(" + unitPriceXpath + ")[" + i + "]", prop.DEFAULT_MEDIUM_WAIT);
                    let unitPrice = await I.grabTextFrom("(" + unitPriceXpath + ")[" + i + "]");

                    // await I.waitForVisible("("+userCurrencyXpath+")["+i+"]",prop.DEFAULT_MEDIUM_WAIT);
                    let userCurrency = await I.grabTextFrom("(" + userCurrencyXpath + ")[" + i + "]");

                    await I.waitForVisible("(" + uomXpath + ")[" + i + "]", prop.DEFAULT_MEDIUM_WAIT);
                    let uom = await I.grabTextFrom("(" + uomXpath + ")[" + i + "]");

                    let finalPriceAfterDiscount;
                    if (userCurrency.length > 0) {
                        finalPriceAfterDiscount = unitPrice + " / " + uom + " " + userCurrency + " / " + uom;
                        unitPrice = unitPrice + " " + userCurrency;

                    }
                    else {
                        finalPriceAfterDiscount = unitPrice + " / " + uom;
                    }

                    await I.waitForClickable(checkboxXpath, prop.DEFAULT_MEDIUM_WAIT);
                    await I.click(checkboxXpath);

                    let details = new Array();

                    details.push(item.trim());
                    details.push(unitPrice.trim());
                    details.push(finalPriceAfterDiscount.trim());
                    details.push(supplierName.toUpperCase().trim());

                    itemDetailsArray.push(details);
                }

                j++;

            }
            else {
                break;
            }

        }

        return itemDetailsArray;
    },

    async clickOnCompareButton() {
        await I.waitForVisible(I.getElement(iOnlineStore.COMPARE_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(I.getElement(iOnlineStore.COMPARE_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        await I.click(I.getElement(iOnlineStore.COMPARE_BUTTON));
        await I.waitForVisible(I.getElement(iOnlineStore.COMPARE_GRID));
        logger.info("Clicked on Compare button.");

    },

    async checkIfCompareButtonPresent() {
        let noOfElements = await I.grabNumberOfVisibleElements(I.getElement(iOnlineStore.COMPARE_BUTTON));
        let isPresent = false;
        if (noOfElements > 0) {
            isPresent = true;
            logger.info("Compare button is present.");
        }
        else {
            logger.info("Compare button is not present.");
        }

        return isPresent;
    },

    async getItemName(index) {
        let xpath = "(" + I.getElement(iOnlineStore.COMPARE_ITEM_NAME) + ")[" + index + "]";
        let name = await I.grabTextFrom(xpath);
        return name.trim();
    },

    async getUnitPrice(index) {
        let xpath = "(" + I.getElement(iOnlineStore.COMPARE_UNIT_PRICE) + ")[" + index + "]";
        let price = await I.grabTextFrom(xpath);
        price = price.replace('\n', ' ').trim();
        return price;
    },

    async getFinalPriceAfterDiscount(index) {
        let xpath = "(" + I.getElement(iOnlineStore.FINAL_PRICE_AFTER_DISCOUNT) + ")[" + index + "]";
        let finalPrice = await I.grabTextFrom(xpath);
        finalPrice = finalPrice.replace('\n', ' ').trim();
        return finalPrice;
    },

    async getSupplier(index) {
        let xpath = "(" + I.getElement(iOnlineStore.SUPPLIER) + ")[" + index + "]";
        let supplier = await I.grabTextFrom(xpath);
        return supplier.trim();
    },

    async fetchComparedItemDetails() {
        // pause();
        let comparedItemsDetails = new Array();
        await I.waitForVisible(I.getElement(iOnlineStore.COMPARE_COLUMN), prop.DEFAULT_MEDIUM_WAIT);
        let noOfElements = await I.grabNumberOfVisibleElements(I.getElement(iOnlineStore.COMPARE_COLUMN));
        while (noOfElements > 0) {
            let itemDetails = new Array();

            let item = await this.getItemName(noOfElements);
            itemDetails.push(item);

            let unitPrice = await this.getUnitPrice(noOfElements);
            itemDetails.push(unitPrice);

            let finalPriceAfterDiscount = await this.getFinalPriceAfterDiscount(noOfElements);
            itemDetails.push(finalPriceAfterDiscount);

            let supplier = await this.getSupplier(noOfElements);
            itemDetails.push(supplier);

            comparedItemsDetails.push(itemDetails);

            noOfElements--;
        }

        return comparedItemsDetails;
    },

    async verifyComparedItems(expectedDetails, actualDetails) {
        let flagArray = new Array();
        let isEqual = true;
        for (let expectedDetail of expectedDetails) {
            let flag = 0;
            for (let actualDetail of actualDetails) {
                if (JSON.stringify(expectedDetail) === JSON.stringify(actualDetail)) {
                    flag = 1;
                    logger.info("Equal");
                }

            }

            if (flag === 1) {
                flagArray.push("true");

            }
            else {
                flagArray.push("false");

            }

        }

        logger.info("flagArray : " + flagArray);

        if (flagArray.includes("false")) {
            isEqual = false;
        }
        return isEqual;
    },

    /** 
     * Checks whether baskets are present under baskets tab, if found any then clicks on view all button
     * 
     * @param 
     * @returns   
     * 
    */
    async clickOnBasketViewAllButton() {
        await I.waitForVisible(I.getElement(iOnlineStore.BASKET_VIEW_ALL_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(I.getElement(iOnlineStore.BASKET_VIEW_ALL_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        await I.click(I.getElement(iOnlineStore.BASKET_VIEW_ALL_BUTTON));
        await I.waitForVisible(I.getElement(iOnlineStore.BASKET_NAME), prop.DEFAULT_MEDIUM_WAIT);
        logger.info("Clicked on view all button present in baskets section.");
    },

    /** 
      * Checks whether baskets are present under baskets tab, if found any then clicks on view all button
      * 
      * @param 
      * @returns   
      * 
     */
    async fetchBasketNames() {
        await I.waitForVisible(I.getElement(iOnlineStore.BASKET_NAME));
        let basketNames = await I.grabAttributeFrom(I.getElement(iOnlineStore.BASKET_NAME),'title');
        let baskets = new Array();
        for(let name of basketNames)
        {
            baskets.push(name.toString().toLowerCase())
        }
        logger.info("Total baskets present are : " + baskets);
        return baskets;
    },

    async getCurrentSortOrder() {
        await I.scrollIntoView(I.getElement(iOnlineStore.BASKET_SORT_ORDER_LABEL));
        await I.waitForVisible(I.getElement(iOnlineStore.BASKET_SORT_ORDER_LABEL));
        let currentOrder = await I.grabTextFrom(I.getElement(iOnlineStore.BASKET_SORT_ORDER_LABEL));
        logger.info("Current basket sort order is : " + currentOrder);
        return currentOrder;
    },

    async clickOnSortIcon() {
        await I.scrollIntoView(I.getElement(iOnlineStore.BASKET_SORT_ICON), prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForVisible(I.getElement(iOnlineStore.BASKET_SORT_ICON), prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(I.getElement(iOnlineStore.BASKET_SORT_ICON), prop.DEFAULT_MEDIUM_WAIT);
        await I.click(I.getElement(iOnlineStore.BASKET_SORT_ICON));
        await I.waitForVisible(I.getElement(iOnlineStore.BASKET_NAME), prop.DEFAULT_MEDIUM_WAIT);
        logger.info("Clicked on sort icon.");
    },

    /** 
      * Checks whether baskets are present under baskets tab, if found any then clicks on view all button
      * 
      * @param 
      * @returns   
      * 
     */
    async verifySortedBaskets(sortOder, sortedBaskets) {
        let isSorted = false;
        if (sortOder === lmtVar.getLabel("ASCENDING_SORT_ORDER")) {
            let expectedSort = sortedBaskets;
            expectedSort = await expectedSort.sort();
            logger.info("A-Z : expected sort : " + expectedSort + " Actual sort : " + sortedBaskets);
            if (JSON.stringify(expectedSort) === JSON.stringify(sortedBaskets)) {
                isSorted = true;
            }
        }
        else {
            let expectedSort = sortedBaskets;
            expectedSort = await expectedSort.sort();
            expectedSort = await expectedSort.reverse();
            logger.info("Z-A : expected sort : " + expectedSort + " Actual sort : " + sortedBaskets);

            if (JSON.stringify(expectedSort) === JSON.stringify(sortedBaskets)) {

                isSorted = true;
            }
        }
        logger.info("Baskets sorted in '" + sortOder + "' : " + isSorted);
        return isSorted;
    },

    async clickOnFavoritesTab() {
        await I.waitForVisible("//dew-default-tab-head[contains(text(),'" + lmtVar.getLabel("FAVORITES_AND_PREVIOUSLY_USED_TAB") + "')]", prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable("//dew-default-tab-head[contains(text(),'" + lmtVar.getLabel("FAVORITES_AND_PREVIOUSLY_USED_TAB") + "')]", prop.DEFAULT_MEDIUM_WAIT);
        await I.click("//dew-default-tab-head[contains(text(),'" + lmtVar.getLabel("FAVORITES_AND_PREVIOUSLY_USED_TAB") + "')]");
    },

    async clickOnBasketsTab() {
        await I.waitForVisible("//dew-default-tab-head[contains(text(),'" + lmtVar.getLabel("BASKET_TAB") + "')]", prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable("//dew-default-tab-head[contains(text(),'" + lmtVar.getLabel("BASKET_TAB") + "')]", prop.DEFAULT_MEDIUM_WAIT);
        await I.click("//dew-default-tab-head[contains(text(),'" + lmtVar.getLabel("BASKET_TAB") + "')]");
    },

    async clickOnCreateRequestButton() {
        await I.waitForVisible(I.getElement(iOnlineStore.CREATE_REQUEST_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        await I.waitForClickable(I.getElement(iOnlineStore.CREATE_REQUEST_BUTTON), prop.DEFAULT_MEDIUM_WAIT);
        await I.click(I.getElement(iOnlineStore.CREATE_REQUEST_BUTTON));
    },

    async clickOnBasketLoadMoreButton()
    {
        await I.waitForVisible(I.getElement(iOnlineStore.BASKET_LOAD_MORE_BUTTON));
        await I.waitForClickable(I.getElement(iOnlineStore.BASKET_LOAD_MORE_BUTTON));
        await I.click(I.getElement(iOnlineStore.BASKET_LOAD_MORE_BUTTON));
    },

    async loadAllBasketRecords()
    {
        let isPresent = await commonComponent.waitForElementPresent(I.getElement(iOnlineStore.BASKET_LOAD_MORE_BUTTON),prop.DEFAULT_LOW_WAIT);
        logger.info(`isPresent --> ${isPresent}`);
        await I.scrollIntoView(I.getElement(iOnlineStore.BASKET_LOAD_MORE_BUTTON));
        isPresent = await commonComponent.isElementVisible(I.getElement(iOnlineStore.BASKET_LOAD_MORE_BUTTON));
        while(isPresent)
        {
            logger.info(`inside while`);
            await I.scrollIntoView(I.getElement(iOnlineStore.BASKET_LOAD_MORE_BUTTON));
            await this.clickOnBasketLoadMoreButton();
            isPresent = await commonComponent.waitForElementPresent(I.getElement(iOnlineStore.BASKET_LOAD_MORE_BUTTON),prop.DEFAULT_LOW_WAIT);
            logger.info(`2nd isPresent --> ${isPresent}`);
            await I.scrollIntoView(I.getElement(iOnlineStore.BASKET_LOAD_MORE_BUTTON));
            isPresent = await commonComponent.isElementVisible(I.getElement(iOnlineStore.BASKET_LOAD_MORE_BUTTON));
            logger.info(`2nd isPresent --> ${isPresent}`);
            logger.info("Clicked on load");
            
        }

        logger.info("All the baskets are loaded.");
    },

    async navigateToOnlineStore() {
        // await commonComponent.navigateToPage(lmtVar.getLabel("APPLICATION_NAME"), lmtVar.getLabel("ONLINE_STORE_PAGE"));
        await I.amOnPage(prop.DDS_OnlineStore_Url);
        await I.waitForVisible(I.getElement(iOnlineStore.SEARCH_TEXTBOX));
    }
}