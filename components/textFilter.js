/* eslint-disable linebreak-style */
/* eslint-disable max-len */
"use strict";
const { I } = inject();

/**
 * Text filter class
 */
class TextFilter {
  /**
   * To filter filterlabel by text in eProc
   * @param {String} filterLabel
   * @param {String} textValue
   */
  filterByText(filterLabel, textValue) {
    I.clearField(`.//div[label[text()='${filterLabel}']]/following-sibling::div//input|
    .//input[preceding-sibling::label[contains(text(),'${filterLabel}')]]|
    .//dew-text-filter[label[text()='${filterLabel}']]//input`);
    I.fillField(`.//div[label[text()='${filterLabel}']]/following-sibling::div//input|
    .//input[preceding-sibling::label[contains(text(),'${filterLabel}')]]|
    .//dew-text-filter[label[text()='${filterLabel}']]//input`, textValue);
    I.click(".//button[@aria-label='Apply']");
  }
  /**
   * To filter by text in eProc
   * @param {String} textValue
   */
  filterByTextEProc(textValue) {
    I.fillField("//dew-icon[@icon='search']/following-sibling::input", textValue);
    I.pressKey("Enter");
    I.wait(5);
  }
}
module.exports = new TextFilter();
module.exports.TextFilter = TextFilter; // for inheritance
