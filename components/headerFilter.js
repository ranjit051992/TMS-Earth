/* eslint-disable max-len */
"use strict";
const { I, TextFilter, DewCheckbox, DateFilter, RangeFilter } = inject();
/**
 * Header Filter class
 */
class HeaderFilter {
  /**
     * To apply Text filter for a column header
     * @param {String} columnName
     * @param {String} dataForFilter
     */
  async applyTextFilterOnColumn(columnName, dataForFilter) {
    I.click("//span[contains(@class,'text-subhead') and text()[normalize-space()='" + columnName + "']]/ancestor::dew-col[contains(@class,'align-items')]//dew-icon[contains(@class,'icon-filter')]");
    I.wait(6);
    within("dew-popover-body", () => {
      TextFilter.filterByText(columnName, dataForFilter);
    });

    // Verification
    const numOfElements = await I.seeElement("//div[b[text()[normalize-space()='" + columnName + ":']] and text()[normalize-space()='" + dataForFilter + "']] | //div[@class='tagText']/div[text()[normalize-space()='" + dataForFilter + "']]");
    if (numOfElements >= 1) {
      console.log("Filter Applied");
    } else {
      console.log("Filter Not Applied");
    }
  }

  /**
   * To apply checkbox filter over a header
   * @param {String} columnName
   * @param  {...String} data
   */
  async applyCheckboxFilter(columnName, ...data) {
    I.click("//span[contains(@class,'text-subhead') and text()[normalize-space()='" + columnName + "']]/ancestor::dew-col[contains(@class,'align-items')]//dew-icon[contains(@class,'icon-filter')]");
    within("//dew-popover-body", () => {
      data.forEach((element) => {
        DewCheckbox.selectCheckbox(element);
      });
    });
    I.click("//div[contains(@class,'filter-action')]//button[@aria-label='Apply']");

    // Verification
    data.forEach(async (dataCheck) => {
      //const numOfElements = await I.seeElement("//div[b[text()[normalize-space()='" + columnName + ":']] and text()[normalize-space()='" + dataCheck + "']]");
      const numOfElements = await I.seeElement("//div[b[text()[normalize-space()='" + columnName + ":']] and text()[normalize-space()='" + dataForFilter + "']] | //div[@class='tagText']/div[text()[normalize-space()='" + dataForFilter + "']]");
      if (numOfElements >= 1) {
        console.log("Filter Applied for " + dataCheck);
      } else {
        console.log("Filter Not Applied for " + dataCheck);
      }
    });
  }
  
  /**
   * To apply Date filter over a header
   * @param {*} columnName 
   * @param {*} filtertype 
   * @param {*} filtervalue 
   */

  async applyDateFilter(columnName, filtertype, ...filtervalue) {
    I.click("//span[contains(@class,'text-subhead') and text()[normalize-space()='" + columnName + "']]/ancestor::dew-col[contains(@class,'align-items')]//dew-icon[contains(@class,'icon-filter')]");
    within("dew-popover-body", () => {
      switch (filtertype){
        case "Create Date":
          DateFilter.selectCreateDate(filtervalue);
          break;

        case "Date Wihin":
          DateFilter.selectDateWithin(filtervalue);
          break;

        case "Date Period":
          DateFilter.selectDatePeriod(filtervalue[0],filtervalue[1]);
          break;

      }
      I.click(".//button[@aria-label='Apply']");
    });

    //verification
    /* const numOfElements = await I.seeElement("//div[b[text()[normalize-space()='" + columnName + ":']] and text()[normalize-space()='" + filtervalue[0] + "'] | //div[@class='tagText']/div[text()[normalize-space()='" + filtervalue + "']]");
      if (numOfElements >= 1) {
        console.log("Filter Applied for " + dataCheck);
      } else {
        console.log("Filter Not Applied for " + dataCheck);
      } */

  }

  /**
   * 
   * @param {*} filterlabel 
   * @param {*} fromRange 
   * @param {*} toRange 
   */

  async applyRangeFilter(filterlabel, fromRange, toRange){
    I.click("//span[contains(@class,'text-subhead') and text()[normalize-space()='" + filterlabel + "']]/ancestor::dew-col[contains(@class,'align-items')]//dew-icon[contains(@class,'icon-filter')]");
    within("dew-popover-body", () => {
      RangeFilter.selectNumericRangeFilter(filterlabel, fromRange, toRange);
    });
  }

}
module.exports = new HeaderFilter();
module.exports.HeaderFilter = HeaderFilter; // for inheritance

