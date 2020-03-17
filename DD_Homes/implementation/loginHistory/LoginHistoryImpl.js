const { I } = inject();
const CommonKeyword = require("dd-cc-zycus-automation/components/commonKeyword")

module.exports = {

    async navigateToLoginHistory() {
      I.seeElement("//dew-dropdown[contains(@class,'profile')]");
      CommonKeyword.clickElement("//dew-dropdown[contains(@class,'profile')]");
      CommonKeyword.clickElement("//div[contains(@class,'dropdown-item') and text()[normalize-space()='Login History']]");
      I.seeElement("//dew-modal-header//span[text()='Login History']");
    },

    async verifyHistory() {
        I.see("Date");
        I.see("IP"); 
    }

    

}