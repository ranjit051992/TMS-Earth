const { I } = inject();
const LoginHistoryImpl = require("./LoginHistoryImpl");
const ManageProfile = require("../ManageProfile/ManageProfileImpl");


Given("I am on Home page", async function(){
    await I.seeElement(`//span[contains(@class,'welcome-message')]`)
});

When("I navigate to Login History", async function(){
    
   await LoginHistoryImpl.navigateToLoginHistory()
});

Then("I should be able to see user's login time and IP", async function(){
    await LoginHistoryImpl.verifyHistory()
});

Then("I navigate to manage profile", async function(){
    await ManageProfile.navigateToManageProfile()
});

Then("I fetch Timezone under User preferences", async function(){
    await LoginHistoryImpl.getTimezone()
});

Then("I should be able to see Timezone as per my preference", async function() {
    await LoginHistoryImpl.verifyTimezoneInLoginHistory()
});
