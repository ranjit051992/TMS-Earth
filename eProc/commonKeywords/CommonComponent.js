const {I} = inject();

const commonCompObject = require("./CommonComponentObject");
const logger = require("./../../Framework/FrameworkUtilities/Logger/logger");
const prop= global.confi_prop;
module.exports={

    async searchAndSelectFromDropdown(dropdownElement,searchValue, selectOptionXpath){
                I.click(dropdownElement);

               // if(typeof searchValue !== "undefined"){
                I.fillField(dropdownElement, searchValue);
               // let optionXpath = `//div[contains(text(),'${selectOption}')]`
                I.click(selectOptionXpath);
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
                I.waitForInvisible(global.uiElements.get(commonCompObject.LOADING_SPINNER), prop.CONDITIONAL_WAIT);
                logger.info("Waited for Loading Symbol to go off");
            },
};