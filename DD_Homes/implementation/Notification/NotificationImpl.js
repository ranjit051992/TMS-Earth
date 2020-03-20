/* eslint-disable linebreak-style */
"use strict";
const { I } = inject();
const CommonKeyword = require("dd-cc-zycus-automation/components/commonKeyword")
const DewElement = require("dd-cc-zycus-automation/components/element")
/**
 * Notifications related class
 */
class NotificationCheck {
  /**
   * To check Notifications count
   */
  async checkNotificationCount() {

    I.waitForVisible("//span[contains(@class,'icon-notification')]", 30)
    I.wait("5")
    const checkIfNotification = await I.grabNumberOfVisibleElements("//span[contains(@class,'icon-notification')]/following-sibling::span[contains(@class,'count')]")
    if (checkIfNotification == 0) {
      I.saveScreenshot("No Notification present.png")
    } else {
      const totalNumberOfNotification = await I.grabTextFrom("//span[contains(@class,'icon-notification')]/following-sibling::span[contains(@class,'count')]");
      I.see(totalNumberOfNotification);
    }

  }


  async selectNotificationHeader(headerName) {
    CommonKeyword.clickElement("//dew-default-tab-head[contains(text(),'" + headerName + "')]")
  }


  async checkNotificationForAlertAndReminder() {
    let alertAndReminderNotificationCount = await I.grabNumberOfVisibleElements("//dew-notification//div[contains(@class,'notify-content')]")
    if (alertAndReminderNotificationCount > 0) {
      I.seeElement("//dew-notification//div[contains(@class,'notify-content')]")
    }
  }


  async clickNotificationIcon() {

    I.waitForVisible("//span[contains(@class,'icon-notification')]", 30)
    let checkIfNotificationIsClicked = await I.grabNumberOfVisibleElements("//dew-notification")
    console.log("notification:", checkIfNotificationIsClicked)
    if (checkIfNotificationIsClicked == 0)
      CommonKeyword.clickElement("//span[contains(@class,'icon-notification')]");
  }


  async downLoadDocumentFromNotification(data) {

    this.selectNotificationHeader("APPROVAL")
    this.selectDataFromNotification(data);

    I.seeElement("//dew-view-attachments")
    I.scrollIntoView("//dew-view-attachments")

    CommonKeyword.clickElement("//div[contains(@class,'text-body-link')]/span[text()[normalize-space()='Download']]")
  }

  async selectDataFromNotification(data) {

    I.scrollIntoView("//span[text()[normalize-space()='" + data + "']]");
    I.see(data);

    CommonKeyword.clickElement("//span[text()[normalize-space()='" + data + "']]");
    I.see(data);
  }

  async actionFromNotification(action) {

    try {
      if (await DewElement.checkIfElementPresent("//button[@aria-label='" + action + "']")) {
        CommonKeyword.clickElement("//button[@aria-label='" + action + "']");
        I.see(action);
        return true;
      } else
        return false;

    } catch (err) {
      I.saveScreenshot("No Notification Present for " + action + ".png")
      return false;
    }



  }

  /**
   * To act on notifications
   * @param {*} action
   * @param {*} data
   */
  async actionOnNotification(action, data) {

    switch (action) {
      case "Approve":
        // within('.modal-content', () => {
        //   CommonKeyword.clickElement(".//dew-modal-footer//button[@aria-label='Approve']");
        // })
        within('//dew-approve-reject-pop-up//div[@class="modal-content"]', () => {
          I.seeElement(".//textarea[@aria-label='This is comment box']");

          I.fillField(".//textarea[@aria-label='This is comment box']", "Approving");
          CommonKeyword.clickElement(".//dew-modal-footer//button[@aria-label='Approve']");
        })
        break;
      case "Reject":
        // within('.modal-content', () => {
        //   CommonKeyword.clickElement(".//dew-modal-footer//button[@aria-label='Reject']");
        // })
        within('//dew-approve-reject-pop-up//div[@class="modal-content"]', () => {
          I.seeElement(".//textarea[@aria-label='This is comment box']");
          I.fillField(".//textarea[@aria-label='This is comment box']", "Rejecting");
          CommonKeyword.clickElement(".//dew-modal-footer//button[@aria-label='Reject']");
        })
        break;
      case "Delegate":
        // within('.modal-content', () => {
        //   CommonKeyword.clickElement(".//dew-modal-footer//button[@aria-label='Delegate']");
        // })
        within('//dew-delegate-popup//div[@class="modal-content"]', () => {
          I.see("Delegate Approval To");
          CommonKeyword.clickElement("//input[@title='autocomplete-user']")
          CommonKeyword.clickElement("(//div[@dew-autocomplete-body]//div[@activeclass='ac-item-focused'])[1]");
          I.fillField(".//textarea[@aria-label='This is input for reason for delegation']", "Delegating");
          CommonKeyword.clickElement(".//dew-modal-footer//button[@aria-label='Delegate']");
        })
        break;
    }
  }
}

module.exports = new NotificationCheck();
module.exports.NotificationCheckcation = NotificationCheck; // for inheritance
