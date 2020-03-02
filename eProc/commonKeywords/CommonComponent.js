const {I} = inject();
const lmtVar = require("../../Framework/FrameworkUtilities/i18nUtil/readI18NProp");
const commonKeywordObject = require("./CommonComponentObject");
const logger = require("./../../Framework/FrameworkUtilities/Logger/logger");
const prop= global.confi_prop;
const poListingObject = require("../implementation/PO/PoListing/PoListingObject");

/**
 * Verifies if element is present in DOM of a page.
 * @param {string} xpath 
 * @param {number} timeout 
 * @returns {boolean} boolean
 * @author om.pawar
 */
async function getElementDomStatus(xpath, timeout) {
    this.count = 0;
    return new Promise(async (resolve, reject) => {
        let interval = setInterval(async () => {
            let element = await I.executeScript((xpath) => {
                return document.evaluate(xpath, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
            }, xpath);
            if(!element) {
                if(this.count < timeout) {
                    this.count++;
                }
                else {
                    clearInterval(interval);
                    resolve(false);
                }
            }
            else {
                clearInterval(interval);
                resolve(true);
            }
        }, 1000);
    });
}

/**
 * Verifies if element is present in the viewport.
 * @param {string} xpath 
 * @param {number} timeout 
 * @returns {boolean} boolean
 * @author om.pawar
 */
async function getElementViewportStatus(xpath, timeout) {
    let isPresent = await getElementDomStatus(xpath, timeout);
    if(isPresent) {
        return new Promise(async (resolve, reject) => {
            let interval = setInterval(async () => {
                let bounding = await I.executeScript((xpath) => {
                    return document.evaluate(xpath, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.getBoundingClientRect();
                }, xpath);

                let boundingRight = await I.executeScript(() => {
                    return window.innerWidth || document.documentElement.clientWidth;
                });

                let boundingBottom = await I.executeScript(() => {
                    return window.innerHeight || document.documentElement.clientHeight;
                });

                if (
                    bounding.top >= 0 &&
                    bounding.left >= 0 &&
                    bounding.right <= boundingRight &&
                    bounding.bottom <= boundingBottom
                ) {
                    clearInterval(interval);
                    resolve(true);
                } else {
                    if(this.count < timeout) {
                        this.count++;
                    }
                    else {
                        clearInterval(interval);
                        resolve(false);
                    }
                }
            }, 1000);
        });
    }
    else {
        throw new Error(`Element '${xpath}' is not present after ${timeout} sec`);
    }
}

module.exports={

    async searchAndSelectFromDropdown(dropdownElement, searchValue, selectOptionXpath){
        await I.waitForVisible(dropdownElement);        
        await I.click(dropdownElement);
        await I.clearField(dropdownElement);
        // if(typeof searchValue !== "undefined"){
        await I.fillField(dropdownElement, searchValue);
        // let optionXpath = `//div[contains(text(),'${selectOption}')]`
        await I.waitForVisible(selectOptionXpath);
        await I.click(selectOptionXpath);
        let value = await I.grabAttributeFrom(dropdownElement, "value");
        return value;
        // }
        // else{
        //     I.click(global.uiElements.get(commonCompObject.SearchAndSelectDropdown_Option));
        //     let selectedValue =  await I.grabAttributeFrom(global.uiElements.get(dropdownAction.SearchAndSelectDropdown_Option), "title");
        //     return selectedValue;
        // }

    },

    async selectValueFromDropDown(dropdownElement, selectOption)
    {
        I.waitForVisible(dropdownElement, prop.DEFAULT_MEDIUM_WAIT);
        I.click(dropdownElement);
        if(selectOption !== "undefined")
        {
            let xpath = `//*[contains(text(),'${selectOption}')]`;
            I.scrollIntoView(xpath);
            I.click(selectOption);
            logger.info(`Selected Value from Drop Down: ${selectOption}`);
        }
        else
        {
            logger.info("Select Option in null....");
        }
    },

    async scrollToSection(sectionName)
    {
        let sectionXapth = `//div[contains(text(),'${sectionName}')]`;
        I.scrollIntoView(sectionXapth);
        I.wait(prop.DEFAULT_MEDIUM_WAIT);
        logger.info("Scrolled to Section "+sectionName);
    },

    waitForLoadingSymbolNotDisplayed()
    {
        I.waitForInvisible(I.getElement(commonKeywordObject.LOADING_SPINNER), prop.DEFAULT_HIGH_WAIT);
        logger.info("Waited for Loading Symbol to go off");
    },

    async enterDocNumberOrDescription(docDetail) {
        await I.seeElement(I.getElement(poListingObject.SEARCH_TEXTBOX));
        await I.click(I.getElement(poListingObject.SEARCH_TEXTBOX));
        await I.clearField(I.getElement(poListingObject.SEARCH_TEXTBOX));
        await I.fillField(I.getElement(poListingObject.SEARCH_TEXTBOX), docDetail);
        logger.info(`Entered search text --> ${docDetail}`);
    },
    async selectDocOption(option) {
        let index;
        if(option === lmtVar.getLabel("SEARCH_BY_DOC_NUMBER")) {
            index = 1;
        }
        else if(option === lmtVar.getLabel("SEARCH_BY_DOC_NAME_OR_DESCRIPTION")) {
            index = 2;
        }
        else {
            throw new Error("Invalid search option!");
        }

        let optionXpath = `//dew-listing-search//div[contains(@class,'dropdown-menu')]//a[${index}]`;
        logger.info(`optionXpath --> ${optionXpath}`);

        await I.seeElement(optionXpath);
        await I.click(optionXpath);
        await I.wait(prop.DEFAULT_WAIT);
        await I.seeElement(I.getElement(poListingObject.PO_NUMBER_LINK));
        logger.info(`Selected doc option --> ${option}`);
    },
    /**
     * Searches for a doc on any listing page by doc number or doc name/description.
     * @param {String} docDetail doc number/name/description.
     * @param {String} searchBy search by number/name/description
     * (eg. lmtVar.getLabel("SEARCH_BY_DOC_NUMBER"), lmtVar.getLabel(")."SEARCH_BY_DOC_NAME_OR_DESCRIPTION)
     * @author om.pawar
     */
    async searchDocOnListing(docDetail, searchBy) {
        await this.enterDocNumberOrDescription(docDetail);
        await this.selectDocOption(searchBy);
        logger.info(`Searched for doc --> ${docDetail}`);
    },
    async clickOnActionMenuIcon() {
        await I.seeElement(I.getElement(poListingObject.ACTION_MENU_ICON));
        await I.click(I.getElement(poListingObject.ACTION_MENU_ICON));
        logger.info("Clicked on action menu icon");
    },
    async clickOnActionMenuOption(option) {
        let optionXpath = `//*[contains(@title,'${option}')]`;
        await I.seeElement(optionXpath);
        await I.click(optionXpath);
        logger.info(`Clicked on action menu option --> ${option}`);
    },
    async getDocNumber() {
        await I.seeElement(I.getElement(poListingObject.PO_NUMBER_LINK));
        let docNumber = await I.grabTextFrom(I.getElement(poListingObject.PO_NUMBER_LINK));
        logger.info(`Retrieved doc number --> ${docNumber}`);
        return docNumber;
    },
    async clickOnDocNumberLink() {
        await I.seeElement(I.getElement(poListingObject.PO_NUMBER_LINK));
        await I.click(I.getElement(poListingObject.PO_NUMBER_LINK));
        logger.info("Clicked on document number");
    },
    /**
     * Clicks an element using Javascript executor.
     * @param {String} xpath
     * @author om.pawar
     */
    async clickUsingJsByXpath(xpath) {
        await I.executeScript(function(xpath) {
            document.evaluate(xpath, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click();
        }, xpath);
    },
    /**
     * Verifies if element is enabled and returns a boolean value.
     * @param {String} xpath
     * @returns {boolean} boolean
     * @author om.pawar
     */
    async isEnabledByXpath(xpath) {
        return await I.executeScript(function(xpath) {
            return document.evaluate(xpath, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.disabled;
        }, xpath);
    },
    /**
     * Verifies if element is selected and returns a boolean value.
     * @param {String} xpath
     * @returns {boolean} boolean
     * @author om.pawar
     */
    async isSelectedByXpath(xpath) {
        return await I.executeScript(function(xpath) {
            return document.evaluate(xpath, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.checked;
        }, xpath);
    },
    /**
     * Verifies if element is present in the DOM of a page
     * and instantly returns a boolean value.
     * @param {string} xpath 
     * @param {number} timeout 
     * @returns {boolean} boolean
     * @author om.pawar
     */
    async isElementPresent(xpath) {
        return await getElementDomStatus(xpath, 1);
    },
    /**
     * Waits for the specified amount of time
     * for the element to load in the DOM of a page
     * and then returns a boolean value.
     * @param {string} xpath 
     * @param {number} timeout optional, default timeout is value mentioned against key "DEFAULT_HIGH_WAIT"
     * in config.json
     * @returns {boolean} boolean
     * @author om.pawar
     */
    async waitForElementPresent(xpath, ...timeout) {
        if(timeout.length === 0) {
            return await getElementDomStatus(xpath, prop.DEFAULT_HIGH_WAIT);
        }
        else {
            return await getElementDomStatus(xpath, timeout[0]);
        }
    },
    /**
     * Verifies if element is present in the DOM of a page
     * and visible and instantly returns a boolean value.
     * @param {string} xpath 
     * @param {number} timeout 
     * @returns {boolean} boolean
     * @author om.pawar
     */
    async isElementVisible(xpath) {
        return await getElementViewportStatus(xpath, 1);
    },
    /**
     * Waits for the specified amount of time
     * for the element to load in the DOM of a page and to be visible
     * and then returns a boolean value.
     * @param {string} xpath 
     * @param {number} timeout optional, default timeout is value mentioned against key "DEFAULT_HIGH_WAIT"
     * in config.json
     * @returns {boolean} boolean
     * @author om.pawar
     */
    async waitForElementVisible(xpath, ...timeout) {
        if(timeout.length === 0) {
            return await getElementViewportStatus(xpath, prop.DEFAULT_HIGH_WAIT);
        }
        else {
            return await getElementViewportStatus(xpath, timeout[0]);
        }
    },
};