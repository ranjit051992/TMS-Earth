
Given("I am on Landing Page", () => {
	return true;
});

When("I click on QuickLink Dropdown", async function ()  {
	return true;
});

When("I click on {string}", async function (Customize) {
	console.log(Customize);
	return true;
});

When("I select {string} {string}, {string}, {string}", async function (QuickLinkMenus, Menu1, Menu2, Menu3) {
	console.log(Menu1, Menu2, Menu3);
	return true;
});

When("I click on {string}", async function (Apply) {
	return true;
});

Then("I should see selected {string} in the Quick Link Dropdown", async function(QuickLinkMenus) {
	return true;
});

Given("I am on Landing Page", () => {
	return true;
});

Then("I have configured {string} Menus", async function(QuickLinkMenus) {
	return true;
});

When("I click on {string} Dropdown", async function(QuickLink) {
	return true;
});

When("I click on any 1 {string} from {string}", async function(Menu, QuickLinkMenus)  {
	console.log(Menu);
	return true;
});

Then("I should be redirected to the {string}", async function(Menu) {
	console.log(Menu);
	return true;
});

Given("I have configured {string} Menus", async function() {
	return true;
});

When("I Navigate to {string}", async function(Product)  {
	console.log(Product);
	return true;
});

When("I click on {string} Dropdown", async function(QuickLink)  {
	return true;
});

Then("I should be see the same {string} as on Landing Page", async function(QuickLinkMenus) {
	return true;
});

Given("I have configured {string} in Quick Link", async function(AdminMenus) {
	return true;
});

When("I click on Quick link Dropdown", async function() {
	return true;
});

When("I click on {string} in Quick Link", async function(AdminMenu)  {
	return true;
});

Then("I should be redirected to selected {string} in different tab", async function(AdminMenu)  {
	return true;
});

