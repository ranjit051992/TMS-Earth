"use strict";
const { I } = inject();

/**
 * Workflow class
 */
class DewWorkflow {
  /**
   * To get pending request approver email Id
   * @return {String} approverEmail
   */
  getPendingRequestApproverEmailID() {
    I.seeElement(`//dew-tab[@id='Workflow']//div[text()='Workflow']`);
    const approverEmail = I.grabTextFrom(`//span[contains(@class,'workflow-pending')]/../preceding-sibling::div[contains(text(),'.com')]`);
    return approverEmail;
  }
}

module.exports = new DewWorkflow();
module.exports.DewWorkflow = DewWorkflow;
