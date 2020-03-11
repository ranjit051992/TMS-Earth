const ProductNavigator = require("../../../node_modules/dd-cc-zycus-automation/components/dewSideMenu");
const { I } = inject();
const DewNavBar = require("../../../node_modules/dd-cc-zycus-automation/components/dewNavBar");
const ApprovalPage = require("./MyApprovalImpl");

Given("I am logged in as: {string}, {string}", async function (userName, password) {
  I.login(userName, password)
});

Given("I am on home page", async function () {
  await I.seeElement(`//span[contains(@class,'welcome-message')]`)
});


When("I click on hamburger icon", async function () {
  DewNavBar.clickHamburger();
});

When("I click on {string} module", async function (moduleName) {
  ProductNavigator.navigate(moduleName);
});

When("I click on {string} page", async function (listingName) {
  ApprovalPage.selectHeaderTab(listingName);
});


Then("I should see details of the {string} page", async function (listingName) {
  ApprovalPage.verifyListingPage(listingName);
});

When("I navigate to all page", async function(){
  ApprovalPage.navigateToAllSubListing();
});