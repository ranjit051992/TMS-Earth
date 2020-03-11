/* eslint-disable max-len */
"use strict";
const { DewButton } = inject();

/**
 * Confirm Pppup class
 */
class Confirm {
  /**
   * To press button in confirm popup
   * @param {string} popupHeader
   * @param {string} btnName
   */
  acceptButton(popupHeader, btnName) {
    within(`"//dew-confirm/div[2]/div[p[contains(text(),'" +  ${popupHeader} + "')]]/div"`, () => {
      DewButton.click(btnName);
    });
  }
}

module.exports = new Confirm();
module.exports.Confirm = Confirm; // for inheritance
