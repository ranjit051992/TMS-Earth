const { I } = inject();
const CommonKeyword = require("dd-cc-zycus-automation/components/commonKeyword")
const LoginObject = require("./LoginObject")

Given ("user enter valid {string},{string} credentials", async function(username,password) {
    await CommonKeyword.clickElement(LoginObject.EmailAddress);
    CommonKeyword.enterText("Email Address",global.users.get("USERNAME"));
    await CommonKeyword.clickElement(LoginObject.Password);
    CommonKeyword.enterText("Password", global.users.get("PASSWORD"));
    I.click("Login");
    I.wait(5)
    I.refreshPage()

});

Given ("user enter invalid {string},{string} credentials", async function(username,password) {
    await CommonKeyword.clickElement(LoginObject.EmailAddress);
    CommonKeyword.enterText("Email Address", global.users.get("USERNAME"));
    await CommonKeyword.clickElement(LoginObject.Password);
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
