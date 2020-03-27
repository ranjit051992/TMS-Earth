const { I } = inject()
const ProductNavigator = require("dd-cc-zycus-automation/components/dewSideMenu")
const DewImpersonation = require("./DewImpersonation")
const ApprovalPage = require("../../implementation/MyApproval/MyApprovalImpl")
const ImpersonationImpl = require ("./impersonationImpl")

Given("I am on Home page",  async function() {
    await ProductNavigator.navigate("Home");
I.seeElement(`//span[contains(@class,'welcome-message')]`);
});

Given("I navigate to iSupplier MyApproval Page", async function(){
    await ProductNavigator.navigate("iSupplier","Approvals")
})

When("I select allow company admin to impersonate me",  async function() {
    await DewImpersonation.authorizeImpersonation("Allow Company admin to impersonate me");
console.log("Impersonation done");
});

Then("I should be able to see success popup alert",  async function() {
    await ImpersonationImpl.verifySuccessAlert();
});

Given("I Select Allow impersonate from user profile",  async function() {
    await DewImpersonation.navigateToAllowImpersonation();
});

When("I enter impersonation end date {string}",  async function (date) {
console.log("");
});

When("I click on revoke and create option",  async function () {
    await ImpersonationImpl.createAndRevoke(); 
});

Then("I see request status change to revoke state", async function () {
    await ImpersonationImpl.verifyRevoke(); 
});

Then("I should see request status change to revoke state", async function(){
    await ImpersonationImpl.createAndRevoke();
    await ImpersonationImpl.verifyRevoke();

})

Then("I create new impersonation for admin", async function(){
    await DewImpersonation.createImpersonation("Allow Company admin to impersonate me");
    await ImpersonationImpl.verifySuccessAlert();
})

Then("I create new impersonation for support user", async function(){
    await DewImpersonation.createImpersonation("Allow Product Support Personnel to impersonate me");
    await ImpersonationImpl.verifySuccessAlert();
})

Given("I select view impersonate request page", async function () {
    await ApprovalPage.selectHeaderTab("View Impersonation Requests");
});

Given("I have active impersonate request from company admin", async function () {
    await DewImpersonation.authorizeImpersonation("Allow Company admin to impersonate me");
    await ImpersonationImpl.verifySuccessAlert();
});

Then("I navigate back to create impersonate page", async function () {
    //ApprovalPage.selectHeaderTab("Authorize Impersonation");
    I.waitForVisible('//a[dew-default-tab-head[text()[normalize-space()="Authorize Impersonation"]] and contains(@class,"active")]',120); 
    I.seeElement('//a[dew-default-tab-head[text()[normalize-space()="Authorize Impersonation"]] and contains(@class,"active")]'); 

});

When("I click on revoke option", async function () {
    await ImpersonationImpl.clickRevoke();
  });

When("I select allow Support user to impersonate me", async function () {
    await DewImpersonation.authorizeImpersonation("Allow Product Support Personnel to impersonate me");
  });

Given("I have active impersonate request from support user", async function () {
   await  DewImpersonation.authorizeImpersonation("Allow Product Support Personnel to impersonate me");
   await ImpersonationImpl.verifySuccessAlert();
  });
