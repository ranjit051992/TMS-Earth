const { I } = inject();
const CommonKeyword = require("dd-cc-zycus-automation/components/commonKeyword")
const Element = require("dd-cc-zycus-automation/components/element")
const DewLoader = require("dd-cc-zycus-automation/components/dewLoader")
const LoginHistoryObject = require("./LoginHistoryObject")
var newTimezone = null;
module.exports = {

  async navigateToLoginHistory() {
  
    CommonKeyword.clickElement(LoginHistoryObject.Profile);
    CommonKeyword.clickElement(LoginHistoryObject.LoginHistory);
    I.seeElement(LoginHistoryObject.VerifyLoginHistory);
  },

  async verifyHistory() {
    I.see(LoginHistoryObject.Date);
    I.see(LoginHistoryObject.IP);
  },

  async getTimezone() {

    I.scrollPageToBottom();
    var timezone = await I.grabAttributeFrom(LoginHistoryObject.TimeZoneAttribute, "title")
    console.log(timezone)
    newTimezone = timezone.toString().split("-")[0]
    newTimezone= newTimezone.replace(" ","")
    console.log(newTimezone)

  },

  async verifyTimezoneInLoginHistory() {
    DewLoader.waitToProcess()
    I.seeElement(Element.getDynamicLocator(LoginHistoryObject.VerifyTimeZone,"<<newTimezone>>",newTimezone))
  }
}