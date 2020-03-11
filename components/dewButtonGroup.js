/* eslint-disable linebreak-style */
/* eslint-disable max-len */
"use strict";
const { I } = inject();

/**
 * DewButtonGroup class
 */
class DewButtonGroup {
  /**
   * To change view (List, Grid) of listed items
   * @param {String} viewType
   */
  changeView(viewType) {
    const views = { "List": 1, "Grid": 2 };
    I.click("//dew-btn-group/button[" + views[viewType] + "]");
    // TODO - Verify if clicked view is active
  }
}

module.exports = new DewButtonGroup();
module.exports.DewButtonGroup = DewButtonGroup; // for inheritance
