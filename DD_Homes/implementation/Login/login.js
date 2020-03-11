const { I } = inject();


Given ("user navigates to the login page", async function() {
    await I.amOnPage("https://login-partner.zycus.com/sso");
});

Given ("user enter valid {string},{string} credentials", async function(username,password) {
    I.click("#emailAddressGhost");
    I.fillField("input#emailAddress", username);
    I.click("[name=\"pass_temp\"]");
    I.fillField("input#password", password);
    I.click("Login");
    I.wait(5);
    I.refreshPage();

});

Given ("user enter invalid {string},{string} credentials", async function(username,password) {
          I.click("#emailAddressGhost");
        I.fillField("input#emailAddress", username);
       I.click("[name=\"pass_temp\"]");
        I.fillField("input#password", password);
        I.click("Login");

});



Then ("login must be successful", async function() {
       await I.seeElement("dew-navbar");
});



Then ("login must give validation error", async function() {
    await I.see("Invalid username or password")
});
