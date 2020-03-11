/* eslint-disable linebreak-style */
/* eslint-disable max-len */
"use strict";
const { I } = inject();

/**
 * Checkbox class
 */
class Checkbox {
  /**
   * To select all checkboxes
   * @param {String} checkboxCollectionHeader
   */
  selectAll(checkboxCollectionHeader) {
    I.click(".//div[label[contains(text(),'" + checkboxCollectionHeader + "')]]/following-sibling::div//label[contains(text(),'Select All')]");
  }
  /**
   * To Search and select a checkbox
   * @param {String} checkboxCollectionHeader
   * @param {String} checkboxToSelect
   */
  searchSelect(checkboxCollectionHeader, checkboxToSelect) {
    // Enter name of checkbox to select in the search field
    I.fillField(".//dew-checklist//input[@placeholder='Search']", checkboxToSelect);
    // Wait for 5 seconds to reduce the listed checkboxes list to checkbox(es) as per entered criteria
    I.wait(5);
    // TODO - verify listed checkboxes list reduces to checkbox(es) as per entered criteria
    I.click(".//dew-checklist-filter[div[label[contains(.,'" + checkboxCollectionHeader + "')]]]//dew-checkbox/label[contains(.,'" + checkboxToSelect + "')]");
    I.seeCheckboxIsChecked(checkboxToSelect);
  }
  /**
   * To select a particular checkbox directly without searching
   * @param {String} checkboxCollectionHeader
   * @param {String} checkboxToSelect
   */
  selectDirectly(checkboxCollectionHeader, checkboxToSelect) {
    // Select Direct Type
    I.click("//dew-checklist-filter[div[label[contains(.,'" + checkboxCollectionHeader + "')]]]//dew-checkbox/label[contains(.,'" + checkboxToSelect + "')]");
    I.seeCheckboxIsChecked(checkboxToSelect);
  }
  /**
   * Select Multilevel Checkbox
   * @param {*} param
   * @param  {...any} params
   */
  async selectMultilevelCheckbox(param, ...params) {
        let flag = 1;
    const toggleCountParam = await I.grabNumberOfVisibleElements("//span[contains(@class,'toggle-children-wrapper')][../../div//dew-checkbox/input[@type='checkbox']/../label[contains(text(),'" + param + "')]]");
    if (toggleCountParam > 0) {
      I.click("//div[contains(@class,'level-" + flag + "')]//span[contains(@class,'toggle-children-wrapper')][../../div//dew-checkbox//label[contains(text(),'" + param + "')]]");
      if (params.length > 0) {
        for (let i = 0; i < params.length; i++) {
          console.log(params.length);
          ++flag;
          const toggleCountParams = await I.grabNumberOfVisibleElements("//span[contains(@class,'toggle-children-wrapper')][../../div//dew-checkbox/input[@type='checkbox']/../label[contains(text(),'" + params[i] + "')]]");
          if (toggleCountParams > 0) {
            I.wait(5);
            I.click("//div[contains(@class,'level-" + flag + "')]//span[contains(@class,'toggle-children-wrapper')][../../div//dew-checkbox//label[contains(text(),'" + params[i] + "')]]");
          } else {
            I.wait(5);
            I.click("//div[contains(@class,'level-" + flag + "')]/tree-node-wrapper//dew-checkbox//label[contains(text(),'" + params[i] + "')]");
            I.seeCheckboxIsChecked(params[i]);
          }
        }
      }
    } else {
      I.click("//dew-checkbox/input[@type='checkbox']/../label[contains(text(),'" + param + "')]");
      I.seeCheckboxIsChecked(param);
    }
  }
}

module.exports = new Checkbox();
module.exports.checkbox = Checkbox; // for inheritance
