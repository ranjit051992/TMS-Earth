/* eslint-disable max-len */
"use strict";
const { I } = inject();

/**
 * Text field class
 */
class TextField {
  /**
   * To enter text in text field
   * @param {String} fieldLbl
   * @param {String} txt
   */
  enterText(fieldLbl, txt) {
    I.fillField(`.//p[contains(.,'${fieldLbl}')]/following-sibling::p/input|
        .//*[label[div[contains(.,'${fieldLbl}')]]]//input`,
    txt);
  }
}

/**
 * Text field With placeholder class
 */
class TextFieldWithPlaceholder extends TextField {
  /**
     * To enter text in text field
     * @param {String} placeholder
     * @param {String} txt
     */
  @Override
  enterText(placeholder, txt) {
    I.fillField(".//input[@placeholder='" + placeholder + "']", txt);
  }
}

module.exports = new TextField();
module.exports.TextField = TextField; // for inheritance
module.exports = new TextFieldWithPlaceholder();
// for inheritance
module.exports.TextFieldWithPlaceholder = TextFieldWithPlaceholder;
