const { I } = inject();
const lmt = require("./../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp")
const transitionScreenAction = require("./transitionScreenAction")
const dropdown = require("../../../Framework/CommonComponents/Dropdown/dropdown")
class transitionScreenFlow{

    enterClauseTitle(){
        I.fillField(global.uiElements.get(transitionScreenAction.clauseTitle), I.getRandomText(10));
    }

    enterClauseCategory(categoryKey){
        if(typeof categoryKey !== "undefined"){
        let categoryValue = lmt.getLabel(categoryKey);
         dropdown.searchAndSelectFromDropdown(global.uiElements.get(transitionScreenAction.clauseCategory), categoryValue);
         return categoryValue;
        }
        else{
            let categoryValue = dropdown.searchAndSelectFromDropdown(global.uiElements.get(transitionScreenAction.clauseCategory));
            return categoryValue;
        }

    }

}

module.exports = new transitionScreenFlow;