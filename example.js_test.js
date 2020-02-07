Feature('example.js');


Scenario('test something @test', (I) => {
    
    I.amOnPage("https://login-rp.zycus.com/sso/login");
    I.see("Zycus");
    I.seeElement("//input[@id='emailAddressGhost']");
    I.click("//input[@id='emailAddressGhost']");
    I.seeElement("//input[@id='emailAddress']");
    I.click("//input[@id='emailAddress']");
    I.fillField("//input[@id='emailAddress']", "auto.zcs2@zycus.com");
    I.saveScreenshot("Enter userName.png");
    //pause();
    I.seeElement("//input[@class='input_text ghost-text']");
    I.click("//input[@name='pass_temp']");
    I.seeElement("//input[@id='password']");
    I.click("//input[@id='password']");
    I.fillField("//input[@id='password']", "eProc@123");
    I.saveScreenshot("Enter password.png");   
    I.seeElement("#signIn");
    I.click("#signIn");
    I.saveScreenshot("Clicked on login button.png");
    I.wait(5);
    I.see("What would you like");
    //I.saveScreenshot("Enter userName ", true);

    let accounts = new DataTable(['login','password'])
    accounts.add(['davert', '123456']); 
    accounts.add(['auto.zcs2@zycus.com', 'eProc@123']);

    Data(accounts.filter(account => account.login == 'admin')).Scenario("Test DataTable",(current)=>{
        console.log("User "+current.login);
        console.login("Password "+current.password);
    })

});



