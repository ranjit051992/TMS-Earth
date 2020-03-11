/* eslint-disable linebreak-style */
"use strict";
const { I } = inject();

/**
 * Filter Class
 */
class Filter {
/**
 * Apply filter function
 * @param {*} columnName
 */
  applyFilter(columnName) {
    I.click("//dew-filter-pipe-line//button[contains(@class,'filter')]");
    I.click("//div[@class='modal-content']//div[contains(@class,'search-box')]/input");
    I.fillField("//div[@class='modal-content']//div[contains(@class,'search-box')]/input", columnName);
  }
}

module.exports = new Filter();
module.exports.Filter = Filter; // for inheritance
