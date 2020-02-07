const {I, LoginBO, SqlConnection, ObjectCreation} = inject();
// const LoginBO = require("./bo/LoginBO");

class LoginPage {

    emailAddressGhostTextbox = "$emailAddressGhost";
    emailAddressTextbox = "$emailAddress";
    passwordGhostTextbox = "//input[@name='pass_temp']";
    passwordTextbox = "$password";
    loginButton = "$signIn";

    loginToEproc() {
        let loginBO = ObjectCreation.getDefaultObjectOfLogin();
        I.amOnPage("https://eproc-rp.zycus.com/eproc/requisition/default/searchCatalog");
        I.seeElement(this.emailAddressGhostTextbox);
        I.click(this.emailAddressGhostTextbox);
        I.fillField(this.emailAddressTextbox, loginBO.getUsername());
        I.click(this.passwordGhostTextbox);
        I.fillField(this.passwordTextbox, loginBO.getPassword());
        I.click(this.loginButton);
        I.wait(5);
    }
}

module.exports = new LoginPage;