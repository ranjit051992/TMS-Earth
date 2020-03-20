const NotificationCheckcation  = require("./NotificationImpl");
const { I } = inject();

let dataPresent;
Given("I am on home page", async function () {
    await I.seeElement(`//span[contains(@class,'welcome-message')]`)
});


When("I am on home page", async function () {
    await I.seeElement(`//span[contains(@class,'welcome-message')]`)
});

When("I click on notification icon", async function () {
    await NotificationCheckcation.clickNotificationIcon();
});

Then("I see notification count", async function () {
    await NotificationCheckcation.checkNotificationCount();
});

Then("i see list of document failure", async function () {

});

Then("{string} status should be shown as approved in Notification", async function(data) {

});

Then("{string} status should be shown as Rejected in Notification", async function (data) {

});

Then("{string} status should be shown as Delegated in notification", async function (data) {

});

Then("document should be download on user system", async function () {
    await NotificationCheckcation.downLoadDocumentFromNotification();
});

Then("i see list of {string} notifications", async function (alertsandreminders) {
    await NotificationCheckcation.checkNotificationForAlertAndReminder();
});

Given("I am on home page", async function () {
    await I.seeElement(`//span[contains(@class,'welcome-message')]`)
});

When("click on document failure notification", async function () {
    await NotificationCheckcation.selectNotificationHeader("DOCUMENT FAILURES");
});

When("I click on {string};", async function (data) {
    await NotificationCheckcation.selectDataFromNotification();
});

When("i see details page for {string}", async function (data) {

});

When("I click on {string} button;", async function (actionToPerform) {
    if(this.dataPresent){
        await NotificationCheckcation.actionOnNotification(actionToPerform)
    }else{
        I.saveScreenshot("Data not present.png")
    }
   
});

When("I click on {string} button in notification", async function (actionToPerform) {
    this.dataPresent = await NotificationCheckcation.actionFromNotification(actionToPerform)
 });


When("i click on download button", async function () {
   await NotificationCheckcation.downLoadDocumentFromNotification();
});

When("click on {string} notification", async function (headerName) {
    await NotificationCheckcation.selectNotificationHeader(headerName);
});
