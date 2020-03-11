/* eslint-disable linebreak-style */
/* eslint-disable max-len */
"use strict";
const { I, DewCheckbox } = inject();

/**
 * EProcValueFilter class
 */
class EProcValueFilter {
  /**
   * To select all EProcValueFilteres
   * @param {String} filterHeader name of the checkbox collection header
   */
  selectAll(filterHeader) {
    within("//div[div/div[contains(text(),'" + filterHeader + "')]]/following-sibling::div/eproc-value-filter", () => {
      DewCheckbox.selectAll();
    });
  }
  /**
   * To Search and select a EProcValueFilter
   * @param {String} filterHeader name of the checkbox collection header
   * @param {String} filterToSelect name of the filter to select
   */
  searchSelect(filterHeader, filterToSelect) {
    within("//div[div/div[contains(text(),'" + filterHeader + "')]]/following-sibling::div/eproc-value-filter", () => {
      // Enter name of EProcValueFilter to select in the search field
      I.fillField("//input[@aria-label='Search And Select']", filterToSelect);
      // Wait for 5 seconds to reduce the listed EProcValueFilteres list to EProcValueFilter(es) as per entered criteria
      I.wait(5);
      // TODO - verify listed EProcValueFilteres list reduces to EProcValueFilter(es) as per entered criteria
      DewCheckbox.selectCheckbox(filterToSelect);
    });
  }
  /**
   * To select a particular EProcValueFilter directly without searching
   * @param {String} filterHeader name of the checkbox collection header
   * @param {String} filterToSelect name of the filter to select
   */
  directSelect(filterHeader, filterToSelect) {
    within("//div[div/div[contains(text(),'" + filterHeader + "')]]/following-sibling::div/eproc-value-filter", () => {
      DewCheckbox.selectCheckbox(filterToSelect);
    });
  }
}

module.exports = new EProcValueFilter();
module.exports.EProcValueFilter = EProcValueFilter; // for inheritance

