const {I} = inject();
const dropdownAction = require("./dropdownActions")


class dropdown{

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
    }

}
module.exports = new dropdown;