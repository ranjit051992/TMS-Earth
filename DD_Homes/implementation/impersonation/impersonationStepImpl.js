const { I } = inject()
const ProductNavigator = require("../../../node_modules/dd-cc-zycus-automation/components/dewSideMenu")
const DewImpersonation = require("./DewImpersonation")
const ApprovalPage = require("../../../node_modules/dd-cc-zycus-automation/components/approvalPage")
const ImpersonationImpl = require ("./impersonationImpl")

Given("I am on Home page",  async function() {
ProductNavigator.navigate("Home");
I.seeElement(`//span[contains(@class,'welcome-message')]`);
});

When("I select allow company admin to impersonate me",  async function() {
 DewImpersonation.authorizeImpersonation("Allow Company admin to impersonate me");
console.log("Impersonation done");
});

Then("I should be able to see success popup alert",  async function() {
     ImpersonationImpl.verifySuccessAlert();
});

Given("I Select Allow impersonate from user profile",  async function() {
 DewImpersonation.navigateToAllowImpersonation();
});

When("I enter impersonation end date {string}",  async function (date) {
console.log("");
});

When("I click on revoke and create option",  async function () {
    ImpersonationImpl.createAndRevoke(); 
});

Then("I see request status change to revoke state", async function () {
    ImpersonationImpl.verifyRevoke(); 
});

Given("I select view impersonate request page", async function () {
     ApprovalPage.selectHeaderTab("View Impersonation Requests");
});

Given("I have active impersonate request from company admin", async function () {
    await DewImpersonation.authorizeImpersonation("Allow Company admin to impersonate me");
    await ImpersonationImpl.verifySuccessAlert();
});

Then("I navigate back to create impersonate page", async function () {
    I.waitForVisible('//a[dew-default-tab-head[text()[normalize-space()="Authorize Impersonation"]] and contains(@class,"active")]',120); 
    I.seeElement('//a[dew-default-tab-head[text()[normalize-space()="Authorize Impersonation"]] and contains(@class,"active")]'); 
});

When("I click on revoke option", async function () {
    ImpersonationImpl.clickRevoke();
  });

When("I select allow Support user to impersonate me", async function () {
    DewImpersonation.authorizeImpersonation("Allow Product Support Personnel to impersonate me");
  });

Given("I have active impersonate request from support user", async function () {
    DewImpersonation.authorizeImpersonation("Allow Product Support Personnel to impersonate me");
    ImpersonationImpl.verifySuccessAlert();
  });
