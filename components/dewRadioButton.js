/* eslint-disable linebreak-style */
/* eslint-disable max-len */
"use strict";
const { I } = inject();

/**
 * Radio Button class
 */
class DewRadioButton {
  /**
   * Select Radio button
   * @param {String} radioCollectionLbl
   * @param {String} optionToSelect
   */
  selectRadioButton(radioCollectionLbl, optionToSelect) {
    // I.click("//p[contains(.,'" + radioCollectionLbl + "')]/following-sibling::dew-radio//input[@type='radio']/../*[text()='" + optionToSelect + "']");
    I.click(`.//div[p[contains(.,'${radioCollectionLbl}')]]//dew-radio//input[@type='radio']/../*[text()='${optionToSelect}']|
      .//dew-input-container[label/div[contains(.,'${radioCollectionLbl}')]]//dew-radio/div[label[contains(.,'${optionToSelect}')]]/input|
      .//dew-input-container[label/div[contains(.,'${radioCollectionLbl}')]]/div/label[contains(.,'${optionToSelect}')]`);
  }
  /**
   * Select Radio button
   * @param {String} optionToSelect
   */
  selectRadioButton(optionToSelect) {
    I.click(`.//label[contains(.,'${optionToSelect}')][preceding-sibling::input]`);
  }
}

module.exports = new DewRadioButton();
module.exports.DewRadioButton = DewRadioButton; // for inheritance
