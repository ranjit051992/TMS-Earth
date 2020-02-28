const {I} = inject();
const commonKeywordObject = require("./CommonComponentObject");
const logger = require("./../../Framework/FrameworkUtilities/Logger/logger");
const prop= global.confi_prop;
const iConstants = require("../constants/iConstants");
const poListingObject = require("../implementation/PO/PoListing/PoListingObject");

module.exports={

    async searchAndSelectFromDropdown(dropdownElement, selectOption){
                I.click(dropdownElement);
                if(typeof selectOption !== "undefined"){
                I.fillField(dropdownElement, selectOption);
                I.click(selectOption);
                let value = await I.grabAttributeFrom(global.uiElements.get(dropdownElement), "value");
                return value;
                }
                else{
                    I.click(global.uiElements.get(commonKeywordObject.SearchAndSelectDropdown_Option));
                    let selectedValue =  await I.grabAttributeFrom(global.uiElements.get(commonKeywordObject.SearchAndSelectDropdown_Option), "title");
                    return selectedValue;
                }
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
    async enterDocNumberOrDescription(docDetail) {
        await I.seeElement(global.uiElements.get(poListingObject.SEARCH_TEXTBOX));
        await I.click(global.uiElements.get(poListingObject.SEARCH_TEXTBOX));
        await I.clearField(global.uiElements.get(poListingObject.SEARCH_TEXTBOX));
        await I.fillField(global.uiElements.get(poListingObject.SEARCH_TEXTBOX), docDetail);
        logger.info(`Entered search text --> ${docDetail}`);
    },
    async selectDocOption(option) {
        let index;
        if(option === iConstants.SEARCH_BY_DOC_NUMBER) {
            index = 1;
        }
        else if(option === iConstants.SEARCH_BY_DOC_NAME_OR_DESCRIPTION) {
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
        await I.seeElement(global.uiElements.get(poListingObject.PO_NUMBER_LINK));
        logger.info(`Selected doc option --> ${option}`);
    },
    /**
     * this function will search for a doc on any listing page by doc number or doc name/description
     * @param {String} docDetail doc number/name/description.
     * 
     * @param {String} searchBy search by number/name/description (eg. iConstants.SEARCH_BY_DOC_NUMBER, iConstants.SEARCH_BY_DOC_NAME_OR_DESCRIPTION)
     * 
     */
    async searchDocOnListing(docDetail, searchBy) {
        await this.enterDocNumberOrDescription(docDetail);
        await this.selectDocOption(searchBy);
        logger.info(`Searched for doc --> ${docDetail}`);
    },
    async clickOnActionMenuIcon() {
        pause();
        await I.seeElement(global.uiElements.get(poListingObject.ACTION_MENU_ICON));
        await I.click(global.uiElements.get(poListingObject.ACTION_MENU_ICON));
        logger.info("Clicked on action menu icon");
    },
    async clickOnActionMenuOption(option) {
        let optionXpath = `//*[contains(@title,'${option}')]`;
        await I.seeElement(optionXpath);
        await I.click(optionXpath);
        logger.info(`Clicked on action menu option --> ${option}`);
    },
    async getDocNumber(docName) {
        await this.searchDocOnListing(docName, iConstants.SEARCH_BY_DOC_NAME_OR_DESCRIPTION);
        let docNumber = await I.grabTextFrom(global.uiElements.get(poListingObject.PO_NUMBER_LINK));
        logger.info(`Retrieved doc number --> ${docNumber}`);
        return docNumber;
    },
    async viewDocByDocNumber(docNumber) {
        await this.searchDocOnListing(docNumber, iConstants.SEARCH_BY_DOC_NUMBER);
        await I.click(global.uiElements.get(poListingObject.PO_NUMBER_LINK));
        logger.info(`Clicked on document --> ${docNumber}`);
    },
};