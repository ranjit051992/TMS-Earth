"use strict";
const { I } = inject();

/**
 * DewButton class
 */
class DewButton {
  /**
   * To click button with given name
   * @param {string} buttonName
   */
  click(buttonName) {
    I.click("//dew-btn/button[div/span[text()='" + buttonName + "']]");
  }
}

module.exports = new DewButton();
module.exports.DewButton = DewButton; // for inheritance
