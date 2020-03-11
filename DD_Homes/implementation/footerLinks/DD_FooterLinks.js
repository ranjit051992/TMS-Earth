const { I } = inject()
const ProductNavigator = require("../../../node_modules/dd-cc-zycus-automation/components/dewSideMenu");
const FooterLinkImpl = require("./DD_FooterLinksImpl");
const CommonKeyword = require("../../../node_modules/dd-cc-zycus-automation/components/commonKeyword")


Given("I am on Landing Page", async function () {
ProductNavigator.navigate("Home");
I.seeElement(`//span[contains(@class,'welcome-message')]`);
});

When("I click on footer-link {string}", async function (footerLink)  {
	FooterLinkImpl.clickHomeCircleLink(footerLink);
});

Then("I should be redirected to selected {string} product", async function (footerLink) {
	FooterLinkImpl.verifyIfNavigatedToCircleLinkPage(footerLink);
});
