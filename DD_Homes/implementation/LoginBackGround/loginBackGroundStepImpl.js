const { I } = inject()



Given("I navigate to the login page", async function () {
    await I.amOnPage("https://dewdrops-staging.zycus.com/home/#/auth");
    });
    
When("I submit {string} and {string}", async function (username,password) {
    I.click("//input[@formcontrolname='emailAddress']");
    I.fillField("//input[@formcontrolname='emailAddress']", "support.sanity@zycus.com");
    I.click("//input[@formcontrolname='password']");
    I.fillField("//input[@formcontrolname='password']", "NuIuRuDaLaAaPoLiPeViQeWoXa2$3");
    I.click("Login");
    I.wait(5)
    I.refreshPage()
    I.waitForElement("dew-navbar", 30);
    });
    
Then("I should be logged in", async function (link) {
       I.seeElement("dew-navbar")
    });
    //"GDQA-P2P@zycus.com", "nUnEwOgElI1%" "YoDeHaCoPoBiBaIoAiWiYeQe8&7"