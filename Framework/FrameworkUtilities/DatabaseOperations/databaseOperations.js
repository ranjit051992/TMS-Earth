const mysql = require("mysql");
const logger = require("../Logger/logger");
const parser = require("mssql-connection-string");
const faker = require("faker");

module.exports = {
    async getTestData() {
        const prop = global.confi_prop;

        const connectionString = "Data Source=tcp:"+prop.DBhost+",3306;Initial Catalog="+prop.DBdatabase+";User Id="+prop.DBuser+";Password="+prop.DBpassword+";";
        logger.info("connectionString  : " + connectionString);

        const connectionObj = parser(connectionString);

        const columnName = process.env.SETUP + "_" + process.env.TENANT;
        logger.info(columnName);
        
        const query = `SELECT FIELD_NAME, ${columnName} FROM ${prop.testdataTable}`;
        
        //const query = `SELECT FIELD_NAME, QCVM_SupplierPortalBuyer1 FROM ${prop.testdataTable}`;
        logger.info("getTestData query : "+query);

        return new Promise((resolve, reject) => {
            let testDataMap = new Map();

            logger.info("Creating sql connection");

            connection = mysql.createConnection(connectionObj);

            logger.info("Checking sql connection");
            connection.connect(function (error) {
                if (!!error) {
                    logger.info("Error1");
                }
                else {
                    logger.info("Connected");
                    logger.info("Triggering sql query");
                    connection.query(query, function (error, rows, fields) {
                        if (!!error) {
                            logger.info("Error in the query");
                        }
                        else {
                            logger.info("SUCCESS!");

                            for(let i = 0; i < rows.length; i++) {
                                let mapKey;
                                let mapValue;

                                for (let [key, value] of Object.entries(rows[i])) {
                                    if(key === "FIELD_NAME") {
                                        mapKey = value;
                                    }
                                    else if(key === columnName) {
                                        mapValue = value;
                                    }
                                }
                                testDataMap.set(mapKey, mapValue);
                            }
                            connection.destroy();
                            logger.info(`Data map size --> ${testDataMap.size}`);
                            resolve(testDataMap);
                        }
                    });
                }
            });
        });
    },

    async getUiElementXpath(uiElementKey) {
       const prop = global.confi_prop;
        let tablename = "uiElementTable"

        const connectionString = "Data Source=tcp:" + prop.DBhost + ",3306;Initial Catalog=" + prop.DBdatabase + ";User Id=" + prop.DBuser + ";Password=" + prop.DBpassword + ";";
        logger.info("connectionString  : " + connectionString);

        const connectionObj = parser(connectionString);
        if (process.env.SETUP) {
            tablename = process.env.SETUP + "_uiElementTable";
        }
        else {
            tablename = prop.SETUP + "_uiElementTable";
        }

        const query = `SELECT PAGE_NAME, ELEMENT_NAME, XPATH FROM ${global.configmap.get(tablename)}`;
        console.log("Query : " + query)

        return new Promise((resolve, reject) => {
            let elementMap = new Map();

            logger.info("Creating sql connection");
            connection = mysql.createConnection(connectionObj);

            logger.info("Checking sql connection");
            connection.connect(function (error) {
                if (!!error) {
                    logger.info("Error2");
                }
                else {
                    logger.info("Connected");
                    logger.info("Triggering sql query");
                    connection.query(query, function (error, rows, fields) {
                        if (!!error) {
                            logger.info("Error in the query");
                        }
                        else {
                            logger.info("SUCCESS!");

                            for(let i = 0; i < rows.length; i++) {
                                let mapKey;
                                let mapValue;

                                for (let [key, value] of Object.entries(rows[i])) {
                                    if(key === "PAGE_NAME") {
                                        mapKey = value;
                                    }
                                    else if(key === "ELEMENT_NAME") {
                                        mapKey = `${mapKey}/${value}`;
                                    }
                                    else if(key === "XPATH") {
                                        mapValue = value;
                                    }
                                    // if(key === "Page Name") {
                                    //     mapKey = value;
                                    // }
                                    // else if(key === "Element Name") {
                                    //     mapKey = `${mapKey}/${value}`;
                                    // }
                                    // else if(key === "Element Value") {
                                    //     mapValue = value;
                                    // }

                                }
                                elementMap.set(mapKey, mapValue);
                            }
                            connection.destroy();
                            logger.info(`UiElement map size --> ${elementMap.size}`);
                            resolve(elementMap);
                        }
                    });
                }
            });
        });
    },

    async getLMTDetails(){
        const prop = global.confi_prop;

        const connectionString = "Data Source=tcp:"+prop.DBhost+",3306;Initial Catalog="+prop.DBdatabase+";User Id="+prop.DBuser+";Password="+prop.DBpassword+";";
        logger.info("connectionString  : " + connectionString);

        const connectionObj = parser(connectionString);

        const query = "SELECT * FROM LMT";

        return new Promise((resolve, reject) => {
            let LMTMap = new Map();

            logger.info("Creating sql connection");
            connection = mysql.createConnection(connectionObj);

            logger.info("Checking sql connection");
            connection.connect(function (error) {
                if (!!error) {
                    logger.info("Error");
                }
                else {
                    logger.info("Connected");
                    logger.info("Triggering sql query");
                    connection.query(query, function (error, rows, fields) {
                        if (!!error) {
                            logger.info("Error in the query");
                        }
                        else {
                            logger.info("SUCCESS!");

                            for(let i = 0; i < rows.length; i++) {
                                let mapKey;
                                let LMTValueMap = new Map();
                                for (let [key, value] of Object.entries(rows[i])) {
                                    if(key === "Key"){
                                        mapKey = value;
                                    }else{
                                        LMTValueMap.set(key, value);
                                    }
                                }
                                LMTMap.set(mapKey, LMTValueMap);
                            }
                            connection.destroy();
                            logger.info(`LMT map size --> ${LMTMap.size}`);
                            resolve(LMTMap);
                        }
                    });
                }
            });
        });
    },

    async getLMTKeys(){
        const prop = global.confi_prop;

        const connectionString = "Data Source=tcp:"+prop.DBhost+",3306;Initial Catalog="+prop.DBdatabase+";User Id="+prop.DBuser+";Password="+prop.DBpassword+";";
        logger.info("connectionString  : " + connectionString)

        const connectionObj = parser(connectionString);

        const query = `SELECT * FROM LMT`;

        return new Promise((resolve, reject) => {
            let getLMTKeys = new Map();

            logger.info("Creating sql connection");
            connection = mysql.createConnection(connectionObj);

            logger.info("Checking sql connection");
            connection.connect(function (error) {
                if (!!error) {
                    logger.info("Error");
                }
                else {
                    logger.info("Connected");
                    logger.info("Triggering sql query");
                    connection.query(query, function (error, rows, fields) {
                        if (!!error) {
                            logger.info("Error in the query");
                        }
                        else {
                            logger.info("SUCCESS!");

                            for(let i = 0; i < rows.length; i++) {
                                let mapKey;
                                let LMTValueMap = new Map();
                                for (let [key, value] of Object.entries(rows[i])) {
                                    if(key === "en"){
                                        mapKey = value
                                    }else{
                                        if(key === "Key"){
                                            mapValue = value
                                        }
                                    }
                                }
                                getLMTKeys.set(mapKey, mapValue);
                            }
                            connection.destroy();
                            logger.info(`LMT map size --> ${getLMTKeys.size}`);
                            resolve(getLMTKeys);
                        }
                    });
                }
            });
        });
    },

    async getUser() {
        const prop = global.confi_prop;
        const connectionString = "Data Source=tcp:" + prop.DBhost + ",3306;Initial Catalog=" + prop.DBdatabase + ";User Id=" + prop.DBuser + ";Password=" + prop.DBpassword + ";";
        //logger.info("connectionString  : " + connectionString);
        const connectionObj = parser(connectionString);
        
        //logger.info(columnName);
        const query = `SELECT USERNAME,PASSWORD,DISPLAY_NAME FROM ${prop.UserTable} WHERE SETUP_NAME='${process.env.SETUP}' AND TENANT_NAME='${process.env.TENANT}' AND flag='true'`;
        console.log("getUser query : "+query);
        logger.info("getUser query : "+query);

        let timeout = 0;
        if(process.env.GRID) {
            timeout = faker.random.number({min:60000, max:300000});
        }
        logger.info(`waiting for timeout --> ${timeout}`);
        
        return new Promise((resolve, reject) => {
            setTimeout(() => {
                logger.info(`waited for timeout --> ${timeout}`);
                let testDataMap = new Map();
                //logger.info("Creating sql connection");
                connection = mysql.createConnection(connectionObj);
                //logger.info("Checking sql connection");
                connection.connect(function (error) {
                    if (!!error) {
                        //logger.info("Error1");
                    }
                    else {
                        //logger.info("Connected");
                        //logger.info("Triggering sql query");
                        connection.query(query, function (error, rows, fields) {
                            if (!!error) {
                                //logger.info("Error in the query");
                            }
                            else {
                                //logger.info("SUCCESS!");
                                for (let i = 0; i < rows.length; i++) {
                                    let mapKey;
                                    let mapValue;
                                    testDataMap.set("USERNAME", rows[i].USERNAME);
                                    testDataMap.set("PASSWORD", rows[i].PASSWORD);
                                    var displayName = rows[i].DISPLAY_NAME; 
                                }
                                connection.destroy();
                                //logger.info(`user map size --> ${testDataMap.size}`);
                                global.displayName = displayName;
                                resolve(testDataMap);
                            }
                        });
                    }
                });
            }, timeout);
        });
    },

    async updateUSER(userName,status) {
        const prop = global.confi_prop;
        //logger.info("userName  : " + userName);
        const connectionString = "Data Source=tcp:" + prop.DBhost + ",3306;Initial Catalog=" + prop.DBdatabase + ";User Id=" + prop.DBuser + ";Password=" + prop.DBpassword + ";";
        //logger.info("connectionString  : " + connectionString);
        const connectionObj = parser(connectionString);
        const query = `UPDATE eProc_credentials SET FLAG='${status}' WHERE USERNAME='${userName}'`;
        //logger.info(query);
        return new Promise((resolve, reject) => {
            let testDataMap = new Map();
            //logger.info("Creating sql connection");
            connection = mysql.createConnection(connectionObj);
            //logger.info("Checking sql connection");
            connection.connect(function (error) {
                if (!!error) {
                    //logger.info("Error1");
                }
                else {
                    //logger.info("Connected");
                    //logger.info("Triggering sql query");
                    connection.query(query, function (error, rows, fields) {
                        if (!!error) {
                            //logger.info("Error in the query");
                            connection.destroy();
                        }
                        else {
                            //logger.info("SUCCESS!");
                            connection.destroy();
                            resolve("RESOLVED");
                        }
                    });
                }
            });
        });
    },

    async getAndUpdateUser() {
        let testDataMap = await this.getUser();
        await this.updateUSER(testDataMap.get("USERNAME"), "false");
        return testDataMap;
    },
    async getAutomationKey() {
        const prop = global.confi_prop;

        const connectionString = "Data Source=tcp:"+prop.DBhost+",3306;Initial Catalog="+prop.DBdatabase+";User Id="+prop.DBuser+";Password="+prop.DBpassword+";";
        logger.info("connectionString  : " + connectionString)

        const connectionObj = parser(connectionString);

        const columnName = process.env.SETUP + "_" + process.env.TENANT;
        logger.info(columnName);
        
        const query = "SELECT `Key`, MST_key FROM LMT";
        logger.info(query);

        return new Promise((resolve, reject) => {
            let testDataMap = new Map();

            logger.info("Creating sql connection");

            connection = mysql.createConnection(connectionObj);

            logger.info("Checking sql connection");
            connection.connect(function (error) {
                if (!!error) {
                    logger.info("Error");
                }
                else {
                    logger.info("Connected");
                    logger.info("Triggering sql query");
                    connection.query(query, function (error, rows, fields) {
                        if (!!error) {
                            logger.info("Error in the query");
                        }
                        else {
                            logger.info("SUCCESS!");

                            for(let i = 0; i < rows.length; i++) {
                                let mapKey;
                                let mapValue;

                                for (let [key, value] of Object.entries(rows[i])) {
                                    if(key === "Key") {
                                        mapKey = value;
                                    }
                                    else {//if(key === "en") {
                                        mapValue = value;
                                    }
                                }
                                testDataMap.set(mapKey, mapValue);
                            }
                            connection.destroy();
                            logger.info(`Automation Keys size --> ${testDataMap.size}`);
                            resolve(testDataMap);
                        }
                    });
                }
            });
        });
    }
};