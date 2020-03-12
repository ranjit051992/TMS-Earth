/* eslint-disable comma-dangle */
/* eslint-disable multiline-comment-style */
/* eslint-disable indent */
/* eslint-disable arrow-parens */
/* eslint-disable semi */
/* eslint-disable new-cap */
/* eslint-disable max-len */
/* eslint-disable quotes */
"use strict";
const { I } = inject();

/**
 * DewButton class
 */
class DriverManager {
  /**
   * To open new ZSN Browser.
   * @param {string} testName
   */
  async openZSNBrowser(testName) {
    session(testName, () => {
        I.amOnPage("https://zsn.zycus.com/guest");
        I.fillField("#login-email", "pegdummysupplier101@zycus.com");
        I.fillField("#login-password", "Pass@123");
        I.click("Login")
        I.wait("/home", 10)
        // const localecheck = I.grabNumberOfVisibleElements("check_user_language")
        // if(localecheck){
        //     I.seeElement("#check_user_language");
        //     I.click("//button[contains(@class,'yesButton')]")
        //     I.waitForInvisible("#notification-overlay",30)
        // }
    })
  }

   /**
   * Logout from ZSN Browser.
   * @param {string} testName
   */
  async logoutZSN(testName) {
    session(testName, () => {
      I.moveCursorTo("#headerDisplayName")
       I.click("#logout");
       I.see("Login");
    })
  }
}

module.exports = new DriverManager();
module.exports.DriverManager = DriverManager; // for inheritance
