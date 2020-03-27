const { I } = inject();
const CommonKeyword = require("dd-cc-zycus-automation/components/commonKeyword")
const Element = require("dd-cc-zycus-automation/components/element")
const DewLoader = require("dd-cc-zycus-automation/components/dewLoader")
var newTimezone = null;
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
  },

  async getTimezone() {
    var timezone = await I.grabAttributeFrom("//dew-select[@formcontrolname='timezone']//dew-dropdown-trigger/p", "title")
    console.log(timezone)
    newTimezone = timezone.toString().split("-")[0]
    newTimezone= newTimezone.replace(" ","")
    console.log(newTimezone)

  },

  async verifyTimezoneInLoginHistory() {
    DewLoader.waitToProcess()
    I.seeElement("//table[@class='table']//tr//td[contains(text(),'"+newTimezone+"')]")
  }
}