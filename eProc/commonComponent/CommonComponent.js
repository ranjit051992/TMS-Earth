const {I} = inject();
const dropdownAction = require("./CommonComponentObject");
const logger = require("./../../Framework/FrameworkUtilities/Logger/logger");
const prop= global.confi_prop;
module.exports={

    async searchAndSelectFromDropdown(dropdownElement, selectOption){
                I.click(dropdownElement);
                if(typeof selectOption !== "undefined"){
                I.fillField(dropdownElement, selectOption);
                I.click(selectOption);
                }
                else{
                    I.click(global.uiElements.get(dropdownAction.SearchAndSelectDropdown_Option));
                    let selectedValue =  await I.grabAttributeFrom(global.uiElements.get(dropdownAction.SearchAndSelectDropdown_Option), "title");
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
};