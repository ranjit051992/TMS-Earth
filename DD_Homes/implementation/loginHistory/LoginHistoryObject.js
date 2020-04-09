module.exports = {
  WelcomeMessage: "//span[contains(@class,'welcome-message')]",
  Profile: "//dew-dropdown[contains(@class,'profile')]",
  LoginHistory: "//div[contains(@class,'dropdown-item') and text()[normalize-space()='Login History']]",
  VerifyLoginHistory: "//dew-modal-header//span[text()='Login History']",
  Date: "Date",
  IP: "IP",
  TimeZoneAttribute: "//dew-select[@formcontrolname='timezone']//dew-dropdown-trigger/p",
  VerifyTimeZone:"//table[@class='table']//tr//td[contains(text(),'<<newTimezone>>')]"
}