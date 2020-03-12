"use strict";
const { I, DatePicker } = inject();

/**
 * Calendar works
 */
class DateFilter {
  /**
   * select Create Date
   * @param {*} date
   */
  selectCreateDate(date) {
    DatePicker.selectDate(".//label[contains(text(),'Create Date')]/following-sibling::dew-datepicker//input[contains(@class,'date-picker')]", date);
  }
  /**
   * select Date Period
   * @param {*} fromDate
   * @param {*} toDate
   */
  selectDatePeriod(fromDate, toDate) {
    DatePicker.selectDate("(.//label[contains(text(),'Date Period')]/following-sibling::dew-datepicker//input[contains(@class,'date-picker')])[1]", fromDate);
    DatePicker.selectDate("(.//label[contains(text(),'Date Period')]/following-sibling::dew-datepicker//input[contains(@class,'date-picker')])[2]", toDate);
  }
  /**
   * select Date Within
   * @param {*} option
   */
  selectDateWithin(option) {
    I.click(".//div[@class='time-range']/button[text()='" + option + "']");
  }
}

module.exports = new DateFilter();
module.exports.DateFilter = DateFilter; // for inheritance
