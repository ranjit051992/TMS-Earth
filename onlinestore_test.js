
const{I,Login}=inject();


Feature('OnlineStore');

Scenario('test something', (I) => {
    I.amOnPage("http://login-rp.zycus.com/sso/login")
    Login.loginToEproc();
    I.assertEqual('BDD','BDD1');
    

});
