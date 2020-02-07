
Feature('tests.js');


Scenario('test Another scenario', async (I) => {

    I.amOnPage('https://login-rp.zycus.com/sso/login');
    // I.click('#emailAddressGhost');
    // I.fillField('#emailAddress','auto.zcs3@zycus.com');
    // I.click('//input[@name="pass_temp"]');
    // I.fillField('#password','eProc@123');
    // I.saveScreenshot("LoginPage.png")
    // I.click('#signIn');

    // I.amOnPage('https://dewdrops-rp.zycus.com/eproc/#/online-store');
    // I.waitForInvisible("//dew-spinner[@class='dew-spinner']",30);
    // I.waitForText("Create Request");
    // I.saveScreenshot("OnlineStore.png");
    // //pause();
    // await I.grabTextFrom("//li[@class='breadcrumb-item']");
    // I.click("//dew-icon[@icon='cart']");
    // I.saveScreenshot("FullOnlineStore.png",true);

    // I.assertEqual('foo', 'too');

   
});

Scenario('Scenario 2', async (I) => {

    console.log("Scenario 2 of test.js")

});