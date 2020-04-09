const { I } = inject()
const ProductNavigator = require("dd-cc-zycus-automation/components/dewSideMenu");
const FooterLinkImpl = require("./DD_FooterLinksImpl");
const FooterObject = require("./DD_FooterObject")
const CommonKeyword = require("dd-cc-zycus-automation/components/commonKeyword")


Given("I am on Landing Page", async function () {
ProductNavigator.navigate("Home");
I.seeElement(FooterObject.WelcomeMessage);
});

When("I click on footer-link {string}", async function (footerLink)  {
	await FooterLinkImpl.clickHomeCircleLink(footerLink);
});

Then("I should be redirected to selected {string} product", async function (footerLink) {
	await FooterLinkImpl.verifyIfNavigatedToCircleLinkPage(footerLink);
});
