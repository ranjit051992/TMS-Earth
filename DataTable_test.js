let validLogins = new DataTable(['login','password'])
validLogins.add(['auto.zcs1@zycus.com', 'eProc@123']); 
validLogins.add(['auto.zcs2@zycus.com', 'eProc@123']);



Feature('DataTable.js');

Data(validLogins).Scenario('Test Login', (I, current) => {

    console.log("User "+current.login);
    console.log("Password "+current.password);
    I.amOnPage("https://login-rp.zycus.com/sso/login");
    I.see("Zycus");
    I.seeElement("//input[@id='emailAddressGhost']");
    I.click("//input[@id='emailAddressGhost']");
    I.seeElement("//input[@id='emailAddress']");
    I.click("//input[@id='emailAddress']");
    I.fillField("//input[@id='emailAddress']", current.login);
    I.saveScreenshot("Enter userName.png");
    //pause();
    I.seeElement("//input[@class='input_text ghost-text']");
    I.click("//input[@name='pass_temp']");
    I.seeElement("//input[@id='password']");
    I.click("//input[@id='password']");
    I.fillField("//input[@id='password']", current.password);
    I.saveScreenshot("Enter password.png");   
    I.seeElement("#signIn");
    I.click("#signIn");
    I.saveScreenshot("Clicked on login button.png");
    I.wait(5);
    I.see("What would you like");
    //I.saveScreenshot("Enter userName ", true);
})




// Data(validLogins.filter(account => account.login == 'auto.zcs2@zycus.com').Scenario('TestL Login',(I, current)=>{
//     console.log("User "+current.login);
//     console.log("Password "+current.password);
//     I.amOnPage("https://login-rp.zycus.com/sso/login");
//     I.see("Zycus");
//     I.seeElement("//input[@id='emailAddressGhost']");
//     I.click("//input[@id='emailAddressGhost']");
//     I.seeElement("//input[@id='emailAddress']");
//     I.click("//input[@id='emailAddress']");
//     I.fillField("//input[@id='emailAddress']", current.login);
//     I.saveScreenshot("Enter userName.png");
//     //pause();
//     I.seeElement("//input[@class='input_text ghost-text']");
//     I.click("//input[@name='pass_temp']");
//     I.seeElement("//input[@id='password']");
//     I.click("//input[@id='password']");
//     I.fillField("//input[@id='password']", current.password);
//     I.saveScreenshot("Enter password.png");   
//     I.seeElement("#signIn");
//     I.click("#signIn");
//     I.saveScreenshot("Clicked on login button.png");
//     I.wait(5);
//     I.see("What would you like");
// }))

