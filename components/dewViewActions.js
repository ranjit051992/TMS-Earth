/* eslint-disable linebreak-style */
/* eslint-disable max-len */
"use strict";
const { I } = inject();

/**
 * Radio Button class
 */
class DewViewActions {
  /**
   * Navigate to View
   * @param {*} view
   */
  navigateToView(view) {
    I.wait(5);
    I.waitToProcess();
    I.click("//div[contains(@class,'dropdown current-view')]");
    // I.scrollTo("//a[contains(@class,'dropdown')]//span[@class='view-name'][@title='"+view+"']");
    I.click("//span[@class='view-name'][@title='" + view + "']");
    if (I.seeElement("//p[contains(@title,'" + view + "')]")) {
      console.log(view + " selected successfully");
    }
  }
  /**
   * Take Action
   * @param {*} view
   * @param {*} action
   * @return {*}
   */
  takeAction(view, action) {
    let temp = view;
    this.navigate_to_view(view);
    I.click("//dew-listing-views//button[@class='btn filter is-fab']");
    I.waitForVisible("//div[contains(@class,'dropdown-content')]");

    switch (action) {
    case "Duplicate View":
      I.click("//div[text()='Duplicate View']");
      if (I.seeElement("//div[contains(@class,'modal-header')]//*[contains(text(),'Save Duplicate View')]")) {
        I.clearField("//input[@placeholder='Duplicate View']");
        const copiedView = view + "_copy";
        I.fillField("//input[@placeholder='Duplicate View']", copiedView);
        I.click("//div[h5[contains(text(),'Save Duplicate View')]]/following-sibling::div//span[text()='Save']");
        I.waitToProcess();
        if (I.seeElement("//p[contains(@title,'" + copiedView + "')]")) {
          console.log("View is copied successfully");
          temp = copiedView;
        }
      }
      break;

    case "Rename View":
      I.click("//div[text()='Rename View']");
      if (I.seeElement("//div[contains(@class,'modal-header')]//*[contains(text(),'Rename View')]")) {
        I.clearField("//input[@placeholder='New View']");
        const newView = "view" + generateRandomNumber();
        I.fillField("//input[@placeholder='New View']", newView);
        I.click("//div[h5[contains(text(),'Rename View')]]/following-sibling::div//span[text()='Save']");
        I.waitToProcess();
        if (I.seeElement("//p[contains(@title,'" + newView + "')]")) {
          console.log("View is renamed successfully");
          temp = newView;
        }
      }
      break;

    case "Delete View":
      I.click("//div[text()='Delete View']");
      if (I.seeElement("//div[contains(@class,'confirm-panel')]")) {
        I.click("//button[@aria-label='Delete']");
        I.waitToProcess();
        if (I.dontSeeElement(view)) {
          console.log("View is deleted successfully");
        }
      }
      break;

    case "Set as Default":

      I.click("//div[text()='Set as Default']");
      I.waitToProcess();
      I.wait(5);
      I.click("//div[contains(@class,'dropdown current-view')]");
      // I.scrollTo("//a[contains(@class,'dropdown')]//span[@class='view-name'][@title='"+view+"']");
      if (I.seeElement("//a[span[@title='" + view + "']]//dew-icon[@icon='pin-selected']")) {
        console.log("View is set to Default");
      }
      I.click("//div[contains(@class,'dropdown current-view')]");
      break;
    }
    return temp;
  }
}

module.exports = new DewViewActions();
module.exports.DewViewActions = DewViewActions;
/**
 * Generates Random number
 * @return {int}
 */
function generateRandomNumber() {
  return Math.floor(Math.random() * 9000000);
}
