"use strict";
const { I } = inject();

/**
 * Pagination Class
 */
class DewPagination {
  /**
   * To navigate to a page
   * @param {String} param
   */
  goToPage(page) {
    I.seeElement(`//input[@title='Go to page']`);
    I.fillField(`//input[@title='Go to page']`, page);
    I.pressKey("Enter");
   I.seeElement(`//div//button[contains(@class,'active')][text()='${page}']`)
    
  }
  /**
   * To show records per page
   * @param {String} param
   */

  async showRecordsPerPage(page) {
    I.click(`//dew-paginate//dew-dropdown-trigger[contains(@class,'dropdown')]`);
    I.waitForVisible(`//div[contains(@class,'dropdown-menu show')]`, 3);
    I.click(`//div[contains(@class,'dropdown-menu show')]//div[text()[normalize-space()='${page}']]`);
    I.waitToProcess();
    I.wait(2)
    I.scrollPageToBottom()
    let records= await I.GetListOfElements(`//dew-col[contains(@class,'overflow-hidden col-2')]//dew-col/div[@class='ng-star-inserted']`)
    console.log(records.length)
    if(records.length==page){
      console.log("Records are displayed properly as defined")
    }else{
      console.log("Records are not displayed as defined")
    }
  }

  /**
   * To navigate to next page
   */
  goToNextPage() {
    I.seeElement(`//button[@aria-label='naviagte to next page']`);
    I.click(`//button[@aria-label='naviagte to next page']`);
  }

  /**
   * To navigate to the last page
   */
  goToLastPage() {
    I.seeElement(`//button[@aria-label='naviagte to last page']`);
    I.click(`//button[@aria-label='naviagte to last page']`);
  }

  /**
   * To go to previous page
   */
  goToPreviousPage() {
    I.seeElement(`//button[@aria-label='navigate to previous page']`);
    I.click(`//button[@aria-label='navigate to previous page']`);
  }
  
  /**
   * To go to the first page
   */
  goToFirstPage() {
    I.seeElement(`//button[@aria-label='navigate to first page']`);
    I.click(`//button[@aria-label='navigate to first page']`);
  }
}

module.exports = new DewPagination();
module.exports.DewPagination = DewPagination;
