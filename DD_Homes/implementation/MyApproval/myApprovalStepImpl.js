const ProductNavigator = require("dd-cc-zycus-automation/components/dewSideMenu");
const { I } = inject();
const DewNavBar = require("dd-cc-zycus-automation/components/dewNavBar");
const ApprovalPage = require("./MyApprovalImpl");

Given("I am on home page", async function () {
  await I.seeElement(`//span[contains(@class,'welcome-message')]`)
});


When("I click on hamburger icon", async function () {
  DewNavBar.clickHamburger();
  console.log("done")
});


When("I click on {string} module", async function (moduleName) {
  await ProductNavigator.navigate(moduleName);
});

When("I click on {string} page", async function (listingName) {
  await ApprovalPage.selectHeaderTab(listingName);
});


Then("I should see details of the {string} page", async function (listingName) {
  await ApprovalPage.verifyListingPage(listingName);
});

When("I navigate to all page", async function(){
  await ApprovalPage.navigateToAllSubListing();
});