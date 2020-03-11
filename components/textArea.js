/* eslint-disable max-len */
"use strict";
const { I } = inject();

/**
 * Text Area class
 */
class TextArea {
  /**
   * To enter text in Text Area
   * @param {String} fieldLbl
   * @param {String} txt
   */
  enterText(fieldLbl, txt) {
    I.fillField(`//*[label[div[contains(.,'" + ${fieldLbl} + "')]]]/following-sibling::*//textarea"`, txt);
  }
}

/**
 * Text Area With placeholder class
 */
class TextAreaWithPlaceholder extends TextArea {
  /**
     * To enter text in Text Area
     * @param {String} placeholder
     * @param {String} txt
     */
  @Override
  enterText(placeholder, txt) {
    I.fillField("//textarea[@placeholder='" + placeholder + "']", txt);
  }
}

module.exports = new TextArea();
module.exports.TextArea = TextArea; // for inheritance
module.exports = new TextAreaWithPlaceholder();
// for inheritance
module.exports.TextAreaWithPlaceholder = TextAreaWithPlaceholder;
