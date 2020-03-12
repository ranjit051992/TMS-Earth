/* eslint-disable linebreak-style */
"use strict";
const { I } = inject();

/**
 * Login History related class
 */
class LoginHistory {
  /**
   * check history
   */
  checkHistory() {
    navigateToLoginHistory();
    I.see("Date");
    I.see("IP");
  }
}

module.exports = new LoginHistory();
module.exports.LoginHistory = LoginHistory; // for inheritance
/**
 * Navigate to Login History
 */
function navigateToLoginHistory() {
  I.seeElement("//dew-dropdown[contains(@class,'profile')]");
  I.click("//dew-dropdown[contains(@class,'profile')]");
  I.click("//div[contains(@class,'dropdown-item') and text()[normalize-space()='Login History']]");
  I.seeElement("//dew-modal-header//span[text()='Login History']");
}
