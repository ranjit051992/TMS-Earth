/* eslint-disable linebreak-style */
"use strict";
const { I } = inject();
/**
 * Information Card class
 */
class InfoCard {
  /**
   * To check information card functionality
   * @param {*} locator
   */
  async checkinfoCardFunctionality(locator) {
    columnConfiguration(locator);
    const selectedColumn = await fetchColumName();
    this.searchAndSelectCheckBox(selectedColumn);
    this.verfiyColumnInInfoCard(locator, selectedColumn);
  }
  /**
   * To select column in Information card
   * @param {*} locator
   * @param {*} columnName
   */
  async selectColumnInInfoCard(locator, columnName) {
    columnConfiguration(locator);
    this.searchAndSelectCheckBox(columnName);
    this.verfiyColumnInInfoCard(locator, columnName);
  }
  /**
   * To search and select Checkbox
   * @param {*} selectedColumn
   */
  searchAndSelectCheckBox(selectedColumn) {
    selectedColumn.forEach((columnName) => {
      I.clearField("//input[contains(@aria-label,'header filter search')]");
      I.fillField("//input[contains(@aria-label,'header filter search')]", columnName);
      I.click("//dew-modal-body//div/dew-checkbox[label[text()[normalize-space()='" + columnName + "']]]");
      I.seeCheckboxIsChecked(columnName);
    });
    I.click("//dew-modal-footer//button[@aria-label='Apply' and not(@disabled)]");
  }
  /**
   * To verify column card
   * @param {*} locator
   * @param {*} verfiyColumn
   */
  verfiyColumnInInfoCard(locator, verfiyColumn) {
    I.moveCursorTo(locator);
    I.seeElement("//ngb-tooltip-window[contains(@class,'tooltip show')]");

    verfiyColumn.forEach((columnName) => {
      I.see(columnName);
    });
  }
}

module.exports = new InfoCard();
module.exports.InfoCard = InfoCard; // for inheritance
/**
 * To configure column
 * @param {*} locator
 */
function columnConfiguration(locator) {
  I.moveCursorTo(locator);
  I.seeElement("//ngb-tooltip-window[contains(@class,'tooltip show')]");

  I.wait(3);
  I.click("//i[contains(@class,'icon-settings')]");
  I.see("Column Configuration");

  I.click("//dew-checkbox[label[text()[normalize-space()='Select All']]]");
  I.click("//dew-checkbox[label[text()[normalize-space()='Select All']]]");
  I.see("Select at least");
}
/**
 * To fetch Column Name
 */
async function fetchColumName() {
  const availableColumnName = await I.grabTextFrom("//dew-modal-body//div/dew-checkbox/label");

  const selectedColumn = new Array();
  while (selectedColumn.length < 6) {
    const randomColumn = availableColumnName[Math.floor(Math.random() * availableColumnName.length)];
    if (selectedColumn.indexOf(randomColumn) === -1) {
      selectedColumn.push(randomColumn);
    }
  }
  return selectedColumn;
}
