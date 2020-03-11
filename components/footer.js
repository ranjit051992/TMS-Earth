"use strict";
const { DewButton } = inject();

/**
 * Footer class
 */
class Footer {
  /**
   * To click button with given name
   * @param {String} btnName
   */
  clickButton(btnName) {
    within("footer", () => {
      DewButton.click(btnName);
    });
  }
}

module.exports = new Footer();
module.exports.Footer = Footer; // for inheritance
