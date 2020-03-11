/* eslint-disable linebreak-style */
"use strict";
const { I ,CommonKeyword} = inject();

/**
 * User Preference Column Setting class
 */
class UserPreferenceColumnSetting {
  /**
   * To set filter column
   * @param  {...string} columnToAdd
   */
 async setFilterColumn(...columnToAdd) {
    CommonKeyword.click("//dew-listing-userpref-cols//button[contains(@class,'filter')]")
    CommonKeyword.click("//dew-checkbox[//input[@id='selectAll']]");
    CommonKeyword.click("//dew-checkbox[//input[@id='selectAll']]");
    within("//dew-popover-body", async () => {
      columnToAdd.forEach(async (element) => {
        //I.executeScript("arguments[0].scrollIntoView({behavior: 'auto',block: 'center',inline: 'center'});", element);
        // const width = await I.grabElementBoundingRect("//dew-checkbox[input[@id='" + element + "']]", 'height');
        // I.executeScript("document.querySelector('div.mselect-body').scrollTop="+width+"");
        CommonKeyword.click("//dew-checkbox[input[@id='" + element + "']]");
        // I.executeScript("document.querySelector('div.mselect-body').scrollTop=0");
      });
    });
  }
}

module.exports = new UserPreferenceColumnSetting();
// for inheritance
module.exports.UserPreferenceColumnSetting = UserPreferenceColumnSetting;
