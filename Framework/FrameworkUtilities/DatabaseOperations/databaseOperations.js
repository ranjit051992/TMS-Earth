const mysql = require('mysql');
const logger = require("../Logger/logger");
const parser = require('mssql-connection-string');

module.exports = {
    async getTestData() {
        const prop = global.confi_prop;

        const connectionString = "Data Source=tcp:"+prop.DBhost+",3306;Initial Catalog="+prop.DBdatabase+";User Id="+prop.DBuser+";Password="+prop.DBpassword+";";
        logger.info("connectionString  : " + connectionString)

        const connectionObj = parser(connectionString);

        const columnName = prop.SETUP + "_" + prop.TENANT
        logger.info(columnName);
        
        const query = `SELECT FIELD_NAME, ${columnName} FROM TestData_eproc`;
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

        const connectionString = "Data Source=tcp:"+prop.DBhost+",3306;Initial Catalog="+prop.DBdatabase+";User Id="+prop.DBuser+";Password="+prop.DBpassword+";";
        logger.info("connectionString  : " + connectionString)

        const connectionObj = parser(connectionString);

        const query = `SELECT PAGE_NAME, ELEMENT_NAME, XPATH FROM eProc_UI_Elements`;

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
                                    if(key === "PAGE_NAME") {
                                        mapKey = value;
                                    }
                                    else if(key === "ELEMENT_NAME") {
                                        mapKey = `${mapKey}/${value}`;
                                    }
                                    else if(key === "XPATH") {
                                        mapValue = value;
                                    }

                                }
                                testDataMap.set(mapKey, mapValue);
                            }
                            connection.destroy();
                            logger.info(`UiElement map size --> ${testDataMap.size}`);
                            resolve(testDataMap);
                        }
                    });
                }
            });
        });
    }
}