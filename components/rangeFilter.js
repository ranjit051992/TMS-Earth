/* eslint-disable linebreak-style */
"use strict";
const { I } = inject();

/**
 * Range Filter class
 */
class RangeFilter {
  /**
   * To select numeric range in eInvoice
   * @param {*} filterlabel
   * @param {*} fromRange
   * @param {*} toRange
   */
  selectNumericRangeFilter(filterlabel, fromRange, toRange) {
    I.clearField(".//label[text()='" + filterlabel + "']/following-sibling::input[@numeric and contains(@aria-label,'From')] | .//input[@numeric and contains(@aria-label,'From')]");
    I.fillField(".//label[text()='" + filterlabel + "']/following-sibling::input[@numeric and contains(@aria-label,'From')] | .//input[@numeric and contains(@aria-label,'From')]", fromRange);
    I.clearField(".//label[text()='" + filterlabel + "']/following-sibling::input[@numeric and contains(@aria-label,'To')] | .//input[@numeric and contains(@aria-label,'To')]");
    I.fillField(".//label[text()='" + filterlabel + "']/following-sibling::input[@numeric and contains(@aria-label,'To')] | .//input[@numeric and contains(@aria-label,'To')]", toRange);
    I.seeInField(".//label[text()='" + filterlabel + "']/following-sibling::input[@numeric and contains(@aria-label,'From')] | .//input[@numeric and contains(@aria-label,'From')]", fromRange);
    I.seeInField(".//label[text()='" + filterlabel + "']/following-sibling::input[@numeric and contains(@aria-label,'To')] | .//input[@numeric and contains(@aria-label,'To')]", toRange);
    I.click(".//button[@aria-label='Apply']");
  }
  /**
   * To select numeric range in eProc
   * @param {*} filterlabel
   * @param {*} fromRange
   * @param {*} toRange
   */
  /* selectNumericRangeEProc(filterlabel, fromRange, toRange) {
    I.clearField("//input[@numeric and contains(@aria-label,'From')]");
    I.fillField("//input[@numeric and contains(@aria-label,'From')]", fromRange);
    I.clearField("//input[@numeric and contains(@aria-label,'To')]");
    I.fillField("//input[@numeric and contains(@aria-label,'To')]", toRange);
    I.seeInField("//input[@numeric and contains(@aria-label,'From')]", fromRange);
    I.seeInField("//input[@numeric and contains(@aria-label,'To')]", toRange);
    I.click("//button[@aria-label='Apply']");
  } */
}

module.exports = new RangeFilter();
module.exports.RangeFilter = RangeFilter; // for inheritance
