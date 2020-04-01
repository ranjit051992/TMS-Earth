module.exports = {
  Bell_Icon:"//span[contains(@class,'icon-notification')]",
  Notification_Count:"//span[contains(@class,'icon-notification')]/following-sibling::span[contains(@class,'count')]",
  NumberOfVisibleElements:"//dew-notification//div[contains(@class,'notify-content')]",
  View_Notification:"//dew-notification",
  View_Attachment:"//dew-view-attachments",
  Download_Attachment:"//div[contains(@class,'text-body-link')]/span[text()[normalize-space()='Download']]",
  Action_PopUp:'//dew-approve-reject-pop-up//div[@class="modal-content"]',
  Comment_box:".//textarea[@aria-label='This is comment box']",
  Approve_Action_Popup:"(.//dew-modal-footer//button[@aria-label='Approve'])[2]",
  Reject_Action_Popup:".//dew-modal-footer//button[@aria-label='Reject']",
  Delegate_PopUp:'//dew-delegate-popup//div[@class="modal-content"]',
  Delegate_User:"//input[@title='autocomplete-user']",
  First_Delegate_User:"(//div[@dew-autocomplete-body]//div[@activeclass='ac-item-focused'])[1]",
  Delegate_Comment:".//textarea[@aria-label='This is input for reason for delegation']",
  Delegate_Action_Popup:".//dew-modal-footer//button[@aria-label='Delegate']"
}
