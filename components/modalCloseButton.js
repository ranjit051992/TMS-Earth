"use strict";
const { I } = inject();

/**
 * Modal Close Button class
 */
class ModalCloseButton {
  /**
   * To click modal close button
   */
  click() {
    I.click("//button[@aria-label='close-modal']");
  }
}

module.exports = new ModalCloseButton();
module.exports.ModalCloseButton = ModalCloseButton; // for inheritance
