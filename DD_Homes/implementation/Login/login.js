const { I } = inject();
const CommonKeyword = require("dd-cc-zycus-automation/components/commonKeyword")

Given ("user enter valid {string},{string} credentials", async function(username,password) {
    CommonKeyword.clickElement("//input[@formcontrolname='emailAddress']");
    CommonKeyword.enterText("Email Address", username);
    CommonKeyword.clickElement("//input[@formcontrolname='password']");
    CommonKeyword.enterText("Password", password);
    I.click("Login");
    I.wait(5)
    I.refreshPage()

});

Given ("user enter invalid {string},{string} credentials", async function(username,password) {
    CommonKeyword.clickElement("//input[@formcontrolname='emailAddress']");
    CommonKeyword.enterText("Email Address", username);
    CommonKeyword.clickElement("//input[@formcontrolname='password']");
    CommonKeyword.enterText("Password", password);
    I.click("Login");
    I.wait(5)

});



Then ("login must be successful", async function() {
       await I.seeElement("dew-navbar");
});



Then ("login must give validation error", async function() {
    await I.see("Invalid email address or password")
});
