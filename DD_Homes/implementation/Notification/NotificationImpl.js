/* eslint-disable linebreak-style */
"use strict";
const { I } = inject();

/**
 * Notifications related class
 */
class NotificationCheck {
  /**
   * To check Notifications count
   */
  async checkNotificationCount() {

    I.waitForVisible("//span[contains(@class,'icon-notification')]",30)
    const checkIfNotification  = await I.grabNumberOfVisibleElements("//span[contains(@class,'icon-notification')]/following-sibling::span[contains(@class,'count')]")
    if(checkIfNotification == 0){
      console.log("No Notification present")
    }else{
      const totalNumberOfNotification = await I.grabTextFrom("//span[contains(@class,'icon-notification')]/following-sibling::span[contains(@class,'count')]");
      I.see(totalNumberOfNotification);
    }

  }


  async selectNotificationHeader(headerName){
    I.click("//dew-default-tab-head[contains(text(),'"+headerName+"')]")
  }


  async checkNotificationForAlertAndReminder() {
    let alertAndReminderNotificationCount = await I.grabNumberOfVisibleElements("//dew-notification//div[contains(@class,'notify-content')]")
    if (alertAndReminderNotificationCount > 0) {
      I.seeElement("//dew-notification//div[contains(@class,'notify-content')]")
    }
  }


  async clickNotificationIcon(){

    I.waitForVisible("//span[contains(@class,'icon-notification')]",30)
    let checkIfNotificationIsClicked = await I.grabNumberOfVisibleElements("//dew-notification")
    console.log("notification:",checkIfNotificationIsClicked)
    if (checkIfNotificationIsClicked == 0)
      I.click("//span[contains(@class,'icon-notification')]");
  }


  async downLoadDocumentFromNotification(data) {

    this.selectNotificationHeader("APPROVAL")
    this.selectDataFromNotification(data);

    I.seeElement("//dew-view-attachments")
    I.scrollTo("//dew-view-attachments")

    I.click("//div[contains(@class,'text-body-link')]/span[text()[normalize-space()='Download']]")
  }

  async selectDataFromNotification(data){

    I.scrollTo("//span[text()[normalize-space()='" + data + "']]");
    I.see(data);

    I.click("//span[text()[normalize-space()='" + data + "']]");
    I.see(data);
  }



  /**
   * To act on notifications
   * @param {*} action
   * @param {*} data
   */
  async actionOnNotification(action, data) {

    switch (action) {
      case "Approve":
        within('.modal-content', () => {
          I.click(".//dew-modal-footer//button[@aria-label='Approve']");
        })
        within('//dew-approve-reject-pop-up', () => {
          I.seeElement(".//textarea[@aria-label='This is comment box']");
          I.fillField(".//textarea[@aria-label='This is comment box']", "Approving");
          I.click(".//dew-modal-footer//button[@aria-label='Approve']");
        })
        break;
      case "Reject":
        within('.modal-content', () => {
          I.click(".//dew-modal-footer//button[@aria-label='Reject']");
        })
        within('//dew-approve-reject-pop-up', () => {
          I.seeElement(".//textarea[@aria-label='This is comment box']");
          I.fillField(".//textarea[@aria-label='This is comment box']", "Rejecting");
          I.click(".//dew-modal-footer//button[@aria-label='Reject']");
        })
        break;
      case "Delegate":
        within('.modal-content', () => {
          I.click(".//dew-modal-footer//button[@aria-label='Delegate']");
        })
        within('.modal-content', () => {
          I.see("Delegate Approval To");
          I.fillField(".//textarea[@aria-label='This is input for reason for delegation']", "Delegating");
          I.click(".//dew-modal-footer//button[@aria-label='Delegate']");
        })
        break;
    }
  }
}

module.exports = new NotificationCheck();
module.exports.NotificationCheckcation = NotificationCheck; // for inheritance
