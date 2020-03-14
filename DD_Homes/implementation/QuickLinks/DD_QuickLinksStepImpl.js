
const DewQuickLinks = require("./DD_QuickLinkImpl")
const DewNavBar = require("dd-cc-zycus-automation/components/dewNavBar");
const { I } = inject();


/**
 * To verify whether on Home Page load, frequently accessed list is displayed and user is able to navigate to the product
 */
Given("I am on home page", async function() {
    await I.seeElement(`//span[contains(@class,'welcome-message')]`)
});


When("I click on QuickLink Dropdown", async function() {
    await DewQuickLinks.navigateQuickLink();
});

When("I click {string} in Quicklink dropdown", async function(Customize){
	await DewQuickLinks.clickQuickLinkDropdownOption(Customize)
});

When("I select product {string} and modules {string},{string}, {string}, {string}", async function(Product,QuickLinkMenus, QuickLinkMenus1, QuickLinkMenus2, QuickLinkMenus3) {
    await DewQuickLinks.customizeQuickLinks(Product, QuickLinkMenus, QuickLinkMenus1, QuickLinkMenus2, QuickLinkMenus3)
});


Then("I should see selected product {string} and modules {string},{string},{string},{string} in the Quick Link Dropdown",async function(Product, QuickLinkMenus, QuickLinkMenus1, QuickLinkMenus2, QuickLinkMenus3) {
    await DewQuickLinks.verifyQuickLinksInDropdown(Product, QuickLinkMenus, QuickLinkMenus1, QuickLinkMenus2, QuickLinkMenus3)
});

Then("Then I should see selected product {string} and modules {string},{string}, {string}, {string} in the Quick Link Dropdown", async function(QuickLinkMenus, QuickLinkMenus1, QuickLinkMenus2, QuickLinkMenus3) {
  
});

Then("I have configured {string} Menus", async function(QuickLinkMenus) {
    return true;
});

When("I click on {string} Dropdown", async function(QuickLink) {
    return true;
});

When("I click on any 1 {string} from Quick Link Menus", async function(Menu) {
    DewQuickLinks.clickQuickLink(Menu);
});

Then("I should be redirected to the {string}", async function(menu) {

    DewQuickLinks.verifyQuickLinkPage(menu)
});

Given("I have configured {string} Menus", async function() {
    return true;
});

When("I click on {string} Dropdown", async function(QuickLink) {
    return true;
});

Then("I should be see the same {string} as on Landing Page", async function(QuickLinkMenus) {
    await DewQuickLinks.verifyQuickLinksInDropdown(QuickLinkMenus)
});

Given("I have configured {string} in Quick Link", async function(AdminMenus) {
    return true;
});

When("I Navigate to {string} {string}", async function(product, module) {
    await ProductNavigator.navigate(product, module);
});

When("I click on hamburger icon", async function() {
    DewNavBar.clickHamburger();
});

When("I click on Quick link Dropdown", async function() {
    return true;
});

When("I click on {string} in Quick Link", async function(AdminMenu) {
    DewQuickLinks.clickQuickLink(AdminMenu)
});

Then("I should be redirected to selected {string} in different tab", async function(AdminMenu) {
    DewQuickLinks.verifyAdminLinksInDifferentTabs(AdminMenu);
});




