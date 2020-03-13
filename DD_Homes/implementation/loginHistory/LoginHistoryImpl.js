const { I } = inject();

module.exports = {

    async navigateToLoginHistory() {
      I.seeElement("//dew-dropdown[contains(@class,'profile')]");
      I.click("//dew-dropdown[contains(@class,'profile')]");
      I.click("//div[contains(@class,'dropdown-item') and text()[normalize-space()='Login History']]");
      I.seeElement("//dew-modal-header//span[text()='Login History']");
    },

    async verifyHistory() {
        I.see("Date");
        I.see("IP"); 
    }

}