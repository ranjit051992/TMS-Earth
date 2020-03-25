const { I } = inject()
const CommonKeyword = require("dd-cc-zycus-automation/components/commonKeyword")

const prop = global.confi_prop;

Given("I navigate to the login page", async function () {
    await I.amOnPage(global.testData.get("URL"));
    });
    
When("I submit {string} and {string}", async function (username,password) {
    CommonKeyword.clickElement("//input[@formcontrolname='emailAddress']");
    CommonKeyword.enterText("Email Address",global.users.get("USERNAME"));
    CommonKeyword.clickElement("//input[@formcontrolname='password']");
    CommonKeyword.enterText("Password", global.users.get("PASSWORD"));
    I.click("Login");
    I.waitForElement("dew-navbar", 30);
    });
    
Then("I should be logged in", async function (link) {
       I.seeElement("dew-navbar")
    });
    //"GDQA-P2P@zycus.com", "nUnEwOgElI1%" "YoDeHaCoPoBiBaIoAiWiYeQe8&7"