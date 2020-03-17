//const ProductNavigator = require("dd-cc-zycus-automation/components/dewSideMenu");
const { I } = inject();
const DewNavBar = require("dd-cc-zycus-automation/components/dewNavBar");
const Navigation = require("./ProductNavigationImpl");

Given("I am on home page", async function () {
  await I.seeElement(`//span[contains(@class,'welcome-message')]`)
  I.wait(7)
});


When("I click on hamburger icon", async function () {
  I.wait(10)
  DewNavBar.clickHamburger();
  console.log("done")
});

Then("I should be redirected to selected  product page", async function (listingName) {
  await Navigation.productNavigation()
});
