"use strict";
const { I } = inject();

/**
 * Calendar works
 */
class DatePicker {
  /**
   * This function is used to select today's date
   * @param {string} locator
   */
  selectToday(locator) {
    I.click(locator);
    I.click(".currentDate", ".d-picker");
  }
  /**
   * This function is used to select provided date
   * @param {string} locator
   * @param {int} date
   */
  selectInNextMonth(locator, date = "15") {
    I.click(locator);
    I.click("show next month", ".d-picker");
    I.click(date, ".d-picker");
  }
  /**
   * To select date
   * @param {String} locator
   * @param {String} date In MM/DD/YYYY
   */
  selectDate(locator, date) {

    var dateObj = new Date(Date.parse(date));
    const month = dateObj.toLocaleString('default', { month: 'long' }); //months from 1-12
    var day = dateObj.getDate();
    var year = dateObj.getFullYear();
    
    I.click(locator);
    selectYear(year);
    selectMonth(month);
    selectDay(day)
    
    // I.click(day, "//span[contains(@class, 'd-picker-body')]");
    // I.click(day);
  }
}

module.exports = new DatePicker();
module.exports.DatePicker = DatePicker; // for inheritance


async function selectYear(year){

  I.click("(//div[contains(@class, 'd-picker-header')]//dew-btn)[2]");
  I.see("Select Year")
  I.click("//div[contains(@class, 'year-scroll')]//button/div[text()='"+year+"']")
  I.see(year);
}

async function selectMonth(month){

  I.click("(//div[contains(@class, 'd-picker-header')]//dew-btn)[1]");
  I.see("Select Month")
  I.click("//span[contains(@class,'month')]//button/div[text()='"+month +"']")
  I.see(month);
}


async function selectDay(day){

  I.seeElement(".d-picker-header")
  I.click("//span[contains(@class, 'd-picker-body')]//button/div[text()='"+day+"']")
}