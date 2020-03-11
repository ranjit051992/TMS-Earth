const { I } = inject()

Given("I navigate to the login page", async function () {
        await I.amOnPage("https://login-partner.zycus.com/sso");
    I.resizeWindow("maximize");
    });
    
When("I submit username and password", async function () {
        I.click("#emailAddressGhost");
        I.fillField("input#emailAddress","GDQA-P2P@zycus.com");
        I.click("[name=\"pass_temp\"]");
        I.fillField("input#password","YoDeHaCoPoBiBaIoAiWiYeQe8&7");
        I.click("Login");
        I.wait(5)
        I.refreshPage()
        I.waitForElement("dew-navbar", 30);
    });
    
Then("I should be logged in", async function (link) {
       I.seeElement("dew-navbar")
    });
    //"GDQA-P2P@zycus.com", "nUnEwOgElI1%" "YoDeHaCoPoBiBaIoAiWiYeQe8&7"