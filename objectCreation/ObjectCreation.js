const {LoginBO, SqlConnection} = inject();
// const LoginBO = require("./bo/LoginBO");
// import {LoginBO} from "./bo/LoginBO";

class ObjectCreation {

    getDefaultObjectOfLogin() {
        let username = "";
        let password = "";
        let query = "SELECT USERNAME,PASSWORD FROM eProc_credentials WHERE SETUP_NAME='RM' AND TENANT_NAME='ZCS'";
        let credentialsMap = SqlConnection.sqlConnection(query);
        console.log("Query triggered");

        if(credentialsMap.size < 1) {
            console.log("No results returned by query");
        }
        else {
            console.log("Results returned by query");
        }
        
        var keysItr = credentialsMap.keys();
        for(var i = 0; i < credentialsMap.size; i++) {
            username = keysItr.next().value;
            console.log("username" + username);
        }

        var valueItr = credentialsMap.values();
        for(var i = 0; i < credentialsMap.size; i++) {
            password = valueItr.next().value;
            console.log("password" + password);
        }

        LoginBO.setUsername(username);
        LoginBO.setPassword(password);

        return LoginBO;
    }
}

module.exports = new ObjectCreation;