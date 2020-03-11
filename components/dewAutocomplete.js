/* eslint-disable max-len */
"use strict";
const { I } = inject();

/**
* Pick values in <dew-autocomplete>
*/
class DewAutocomplete {
  /**
   * This function is used to select first element in the autocomplete
   * @param {string} locator
   */
  selectFirst(locator) {
    activate(locator);
    I.click(locate("label"), "[dew-autocomplete-body]");
    deactivate();
  }
  /**
   * This function is used to select multiple values in a autocomplete
   * @param {string} locator
   * @param {Array} values
   */
  selectMultipleByText(locator, values) {
    activate(locator);
    for (const value of values) {
      I.click(locate("label").withText(value), "[dew-autocomplete-body]");
    }
    deactivate();
  }
  /**
   * This function is used to select element by text provided
   * @param {string} locator
   * @param {string} value
   */
  selectByText(locator, value) {
    this.selectMultipleByText(locator, [value]);
  }
}

module.exports = new DewAutocomplete();
/**
 * This function is used to click in autocomplete field to display suggested values
 * @param {*} field
 */
function activate(field) {
  I.fillField(field, " ");
  I.waitForVisible("[dew-autocomplete-body]", 10);
}
/**
 * This function is used to disappear the suggested values of autocomplete
 */
function deactivate() {
  I.click("//body");
}
