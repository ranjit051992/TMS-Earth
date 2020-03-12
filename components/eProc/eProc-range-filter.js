/* eslint-disable linebreak-style */
/* eslint-disable max-len */
"use strict";
const { I, DewButton } = inject();

/**
 * EprocRangeFilter class
 */
class EprocRangeFilter {
  /**
   * To filter between a minimum and maximum range
   * @param {int} minValue - minimum range of item to search
   * @param {int} maxValue - maximum range of item to search
   */
  filter(minValue, maxValue) {
    within("eproc-range-filter", () => {
      // Enter minimum value
      I.clearField("//input[@name='min']");
      I.fillField("//input[@name='min']", minValue);
      // Enter maximum value
      I.clearField("//input[@name='max']");
      I.fillField("//input[@name='max']", maxValue);
      // Click 'Go' button
      DewButton.click("Go");
    });
  }
}

module.exports = new EprocRangeFilter();
module.exports.EprocRangeFilter = EprocRangeFilter; // for inheritance
