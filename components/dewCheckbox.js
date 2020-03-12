/* eslint-disable linebreak-style */
"use strict";
const { I } = inject();
/**
 * Dew Checkbox class
 */
class DewCheckbox {
  /**
   * To select all checkboxes in a checkbox collection
   */
  selectAll() {
    I.click(".//dew-checkbox/label[contains(text(),'Select All')]");
    I.seeCheckboxIsChecked("Select All");
  }
  /**
   * To select a particular checkbox
   * @param {String} checkboxName
   */
  selectCheckbox(checkboxName) {
    if ( checkboxName === "SELECT ALL" | checkboxName == "Select All" | checkboxName == "select all")
      this.selectAll();
    I.click(".//dew-checkbox[@title='" + checkboxName + "']/label");
    I.seeCheckboxIsChecked(checkboxName);
  }

  /**
   * To select a row with checkbox as first column
   */
  selectCheckboxInRow() {
    I.click(".//dew-checkbox/label");
    I.seeCheckboxIsChecked(checkboxName);
  }
}

module.exports = new DewCheckbox();
module.exports.DewCheckbox = DewCheckbox;
