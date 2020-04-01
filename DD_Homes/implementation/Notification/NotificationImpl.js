/* eslint-disable linebreak-style */
"use strict";
const { I } = inject();
const CommonKeyword = require("dd-cc-zycus-automation/components/commonKeyword")
const DewElement = require("dd-cc-zycus-automation/components/element")
const INotification = require("./NotificationObject")
/**
 * Notifications related class
 */
class NotificationCheck {
  /**
   * To check Notifications count
   */
  async checkNotificationCount() {

    I.waitForVisible(INotification.Bell_Icon, 30)
    I.wait("5")
    const checkIfNotification = await I.grabNumberOfVisibleElements(INotification.Notification_Count)
    if (checkIfNotification == 0) {
      I.saveScreenshot("No Notification present.png")
    } else {
      const totalNumberOfNotification = await I.grabTextFrom(INotification.Notification_Count);
      I.see(totalNumberOfNotification);
    }

  }


  async selectNotificationHeader(headerName) {
    CommonKeyword.clickElement("//dew-default-tab-head[contains(text(),'" + headerName + "')]")
  }


  async checkNotificationForAlertAndReminder() {
    let alertAndReminderNotificationCount = await I.grabNumberOfVisibleElements(INotification.NumberOfVisibleElements)
    if (alertAndReminderNotificationCount > 0) {
      I.seeElement(INotification.NumberOfVisibleElements)
    }
  }


  async clickNotificationIcon() {

    I.waitForVisible(INotification.Bell_Icon, 30)
    let checkIfNotificationIsClicked = await I.grabNumberOfVisibleElements(INotification.View_Notification)
    console.log("notification:", checkIfNotificationIsClicked)
    if (checkIfNotificationIsClicked == 0)
      CommonKeyword.clickElement(INotification.Bell_Icon);
  }


  async downLoadDocumentFromNotification(data) {

    this.selectNotificationHeader("APPROVAL")
    this.selectDataFromNotification(data);

    I.seeElement(INotification.View_Attachment)
    I.scrollIntoView(INotification.View_Attachment)

    CommonKeyword.clickElement(INotification.Download_Attachment)
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
        within(INotification.Action_PopUp, () => {
          I.seeElement(INotification.Comment_box);

          I.fillField(INotification.Comment_box, "Approving");
          CommonKeyword.clickElement(INotification.Approve_Action_Popup);
        })
        break;
      case "Reject":
        // within('.modal-content', () => {
        //   CommonKeyword.clickElement(".//dew-modal-footer//button[@aria-label='Reject']");
        // })
        within(INotification.Action_PopUp, () => {
          I.seeElement(INotification.Comment_box);
          I.fillField(INotification.Comment_box, "Rejecting");
          CommonKeyword.clickElement(INotification.Reject_Action_Popup);
        })
        break;
      case "Delegate":
        // within('.modal-content', () => {
        //   CommonKeyword.clickElement(".//dew-modal-footer//button[@aria-label='Delegate']");
        // })
        within(INotification.Delegate_PopUp, () => {
          I.see("Delegate Approval To");
          CommonKeyword.clickElement(INotification.Delegate_User)
          CommonKeyword.clickElement(INotification.First_Delegate_User);
          I.fillField(INotification.Delegate_Comment, "Delegating");
          CommonKeyword.clickElement(INotification.Delegate_Action_Popup);
        })
        break;
    }
  }
}

module.exports = new NotificationCheck();
module.exports.NotificationCheckcation = NotificationCheck; // for inheritance
