const ProductNavigator = require("dd-cc-zycus-automation/components/dewSideMenu");
const { I } = inject();
const DewNavBar = require("dd-cc-zycus-automation/components/dewNavBar");
const ApprovalPage = require("../MyApproval/MyApprovalImpl");


Given ("I am on home page", async function() {
  await I.seeElement(`//span[contains(@class,'welcome-message')]`)
});


When("I click on hamburger icon",async function(){
    DewNavBar.clickHamburger();
});



When("I click on {string} module",async function(moduleName){
    ProductNavigator.navigate(moduleName);
});


When("I see all the listing page",async function(){
  ApprovalPage.verifyListingPage();
});


When("I click on {string} page",async function(listingName){
    ApprovalPage.selectHeaderTab(listingName);
});


Then ("I should see details of the listing page", async function() {
    ApprovalPage.verifyPageSubListing(listingName);
});