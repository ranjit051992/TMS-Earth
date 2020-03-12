"use strict";
const { locator: Locator } = codeceptjs;
const { I } = inject();

/**
 * Pick item inside <dew-dropdown> component
 */
class DewDropdown {
  /**
   * To select first element in the dropdown
   * @param {string} locator
   */
  selectFirst(locator) {
    clickElement(locator);
    I.click(".dropdown-item", ".cdk-overlay-container");
  }
  /**
   * To select element by title
   * @param {string} locator
   * @param {string} title
   */
  selectByTitle(locator, title) {
    clickElement(locator);
    I.click(`[title="${title}"]`, ".cdk-overlay-container");
  }
  /**
   * To select element by given text from a dropdown
   * @param {string} locator
   * @param {string} text
   */
  selectByText(locator, text) {
    clickElement(locator);
    I.click(locate(".cdk-overlay-container [title]").withText(text));
  }
}

module.exports = new DewDropdown();
/**
 * To click on element to display the dropdown values
 * @param {string} field
 */
function clickElement(field) {
  const locator = new Locator(field);
  if (locator.isCSS()) {
    // find element if this is strict locator
    I.click(locator);
  } else {
    I.click(
      locate()
        .after(locate("p").withText(field))
        .find("dew-dropdown-trigger"),
    );
  }
}
