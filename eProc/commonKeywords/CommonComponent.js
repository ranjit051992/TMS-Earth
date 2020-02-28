const {I} = inject();
const commonKeywordObject = require("./CommonComponentObject");
const logger = require("./../../Framework/FrameworkUtilities/Logger/logger");
const prop= global.confi_prop;
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
                    I.click(I.getElement(commonKeywordObject.SearchAndSelectDropdown_Option));
                    let selectedValue =  await I.grabAttributeFrom(I.getElement(commonKeywordObject.SearchAndSelectDropdown_Option), "title");
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
    async clickOnActionMenuIcon() {
        I.seeElement(global.uiElements.get(commonKeywordObject.ACTION_MENU_ICON));
        I.click(global.uiElements.get(commonKeywordObject.ACTION_MENU_ICON));
        logger.info("Clicked on action menu icon");
    },
    async clickOnActionMenuOption(option) {
        let optionXpath = `//*[contains(@title,'${option}')]`;
        I.seeElement(optionXpath);
        I.click(optionXpath);
        logger.info(`Clicked on action menu option --> ${option}`);
    },
};