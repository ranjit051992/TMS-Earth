"use strict";
const { I } = inject();

/**
 * Calendar works
 */
class PageHeader {
  /**
   * This function is used to select today's date
   * @param {string} sectionName
   */
  navigateToSection(sectionName) {
    I.click(locator);
    I.click(".currentDate", ".d-picker");
  }
}

module.exports = new PageHeader();
module.exports.PageHeader = PageHeader; // for inheritance
