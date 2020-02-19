const mysql = require('mysql');
const logger = require("../Logger/logger");

module.exports = {
    async getTestData() {

        const columnName = "RM_ZCS";
        const query = `SELECT FIELD_NAME, ${columnName} FROM TestData_eproc`;

        return new Promise((resolve, reject) => {
            let testDataMap = new Map();

            logger.info("Creating sql connection");
            connection = mysql.createConnection({
                host: "192.168.5.221",
                user: "gauge.poc",
                password: "gauge@123",
                database: "Gauge_schema",
            });

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
                                let counter = 0;
                                logger.info("Inside rows for loop");

                                for (let [key, value] of Object.entries(rows[i])) {
                                    if(key === "FIELD_NAME") {
                                        mapKey = value;
                                    }
                                    else if(key === columnName) {
                                        mapValue = value;
                                    }


                                    // if(counter === 0) {
                                    //     mapKey = value;
                                    // }
                                    // else {
                                    //     mapValue = value;
                                    // }
                                    // counter++;
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

        const query = `SELECT PAGE_NAME, ELEMENT_NAME, XPATH FROM eProc_UI_Elements`;

        return new Promise((resolve, reject) => {
            let testDataMap = new Map();

            logger.info("Creating sql connection");
            connection = mysql.createConnection({
                host: "192.168.5.221",
                user: "gauge.poc",
                password: "gauge@123",
                database: "Gauge_schema",
            });

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
                                
                                // if(mapKey === uiElementKey) {
                                //     connection.destroy();
                                //     logger.info(`Ui element found ${mapValue}`);
                                //     resolve(mapValue);
                                //     break;
                                // }
                                // else {
                                //     if(i === (rows.length - 1)) {
                                //         connection.destroy();
                                //         logger.info(`Ui element key ${uiElementKey} not present in table`);
                                //         reject(`Ui element key ${uiElementKey} not present in table`);
                                //     }
                                // }
                                
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
    }
}