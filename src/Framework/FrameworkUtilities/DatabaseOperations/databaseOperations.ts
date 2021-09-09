import parser from "mssql-connection-string";
import { logger } from "../Logger/logger";
import { prop } from "../config";
import { createConnection, Connection, MysqlError } from "mysql";
import { Startup } from "../Startup/Startup";
import { random } from "faker";
import * as fs from "fs";

export class DatabaseOperations {

    // static async getTestData(): Promise<Map<string, string>> {
    //     const connectionString = "Data Source=tcp:" + prop.DBhost + ",3306;Initial Catalog=" + prop.DBdatabase + ";User Id=" + prop.DBuser + ";Password=" + prop.DBpassword + ";";
    //     logger.info("connectionString  : " + connectionString);

    //     const connectionObj = parser(connectionString);

    //     const columnName = process.env.SETUP + "_" + process.env.TENANT;
    //     logger.info(columnName);

    //     const query = `SELECT FIELD_NAME, ${columnName} FROM ${prop.testdataTable}`;

    //     logger.info("getTestData query : " + query);

    //     return new Promise((resolve, reject) => {
    //         let testDataMap: Map<string, string> = new Map();

    //         logger.info("Creating sql connection");

    //         const connection = createConnection(connectionObj);

    //         logger.info("Checking sql connection");

    //         connection.connect((error) => {
    //             if (!!error) {
    //                 logger.info("Error1");
    //             }
    //             else {
    //                 logger.info("Connected");
    //                 logger.info("Triggering sql query");
    //                 connection.query(query, function (error, rows, fields) {
    //                     if (!!error) {
    //                         logger.info("Error in the query");
    //                     }
    //                     else {
    //                         logger.info("SUCCESS!");

    //                         for (let i = 0; i < rows.length; i++) {
    //                             let mapKey: string = "";
    //                             let mapValue: string = "";

    //                             for (let [key, value] of Object.entries(rows[i])) {
    //                                 if (key === "FIELD_NAME") {
    //                                     mapKey = value as string;
    //                                 }
    //                                 else if (key === columnName) {
    //                                     mapValue = value as string;
    //                                 }
    //                             }
    //                             testDataMap.set(mapKey, mapValue);
    //                         }
    //                         connection.destroy();
    //                         logger.info(`Data map size --> ${testDataMap.size}`);
    //                         resolve(testDataMap);
    //                     }
    //                 });
    //             }
    //         });
    //     });
    // }

    // static async getUiElementXpath(): Promise<Map<string, string>>{
    //     let tablename = "uiElementTable"

    //     const connectionString = "Data Source=tcp:" + prop.DBhost + ",3306;Initial Catalog=" + prop.DBdatabase + ";User Id=" + prop.DBuser + ";Password=" + prop.DBpassword + ";";
    //     logger.info("connectionString  : " + connectionString);

    //     const connectionObj = parser(connectionString);
    //     if (process.env.SETUP) {
    //         tablename = process.env.SETUP + "_uiElementTable";
    //     }
    //     else {
    //         tablename = prop.SETUP + "_uiElementTable";
    //     }

    //     const query = `SELECT PAGE_NAME, ELEMENT_NAME, XPATH FROM ${Startup.configmap.get(tablename)}`;
    //     logger.info("---=-==-=-=-=-=-=-=>" + query);
    //     return new Promise((resolve, reject) => {
    //         let elementMap: Map<string, string> = new Map();

    //         logger.info("Creating sql connection");
    //         let connection = createConnection(connectionObj);

    //         logger.info("Checking sql connection");
    //         connection.connect(function (error) {
    //             if (!!error) {
    //                 logger.info("Error2");
    //             }
    //             else {
    //                 logger.info("Connected");
    //                 logger.info("Triggering sql query");
    //                 connection.query(query, function (error, rows, fields) {
    //                     if (!!error) {
    //                         logger.info("Error in the query");
    //                     }
    //                     else {
    //                         logger.info("SUCCESS!");

    //                         for (let i = 0; i < rows.length; i++) {
    //                             let mapKey: string = "";
    //                             let mapValue: string = "";

    //                             for (let [key, value] of Object.entries(rows[i])) {
    //                                 if (key === "PAGE_NAME") {
    //                                     mapKey = value as string;
    //                                 }
    //                                 else if (key === "ELEMENT_NAME") {
    //                                     mapKey = `${mapKey}/${value}`;
    //                                 }
    //                                 else if (key === "XPATH") {
    //                                     mapValue = value as string;
    //                                 }
    //                             }
    //                             elementMap.set(mapKey, mapValue);
    //                         }
    //                         connection.destroy();
    //                         logger.info(`UiElement map size --> ${elementMap.size}`);
    //                         resolve(elementMap);
    //                     }
    //                 });
    //             }
    //         });
    //     });
    // }

    // static async getLMTDetails(): Promise<Map<string, Map<string, string>>> {
    //     // const prop = global.confi_prop;

    //     const connectionString = "Data Source=tcp:" + prop.DBhost + ",3306;Initial Catalog=" + prop.DBdatabase + ";User Id=" + prop.DBuser + ";Password=" + prop.DBpassword + ";";
    //     logger.info("connectionString  : " + connectionString);

    //     const connectionObj = parser(connectionString);

    //     const query = "SELECT * FROM LMT";

    //     return new Promise((resolve, reject) => {
    //         let LMTMap: Map<string, Map<string, string>> = new Map();

    //         logger.info("Creating sql connection");
    //         let connection = createConnection(connectionObj);

    //         logger.info("Checking sql connection");
    //         connection.connect(function (error) {
    //             if (!!error) {
    //                 logger.info("Error");
    //             }
    //             else {
    //                 logger.info("Connected");
    //                 logger.info("Triggering sql query");
    //                 connection.query(query, function (error, rows, fields) {
    //                     if (!!error) {
    //                         logger.info("Error in the query");
    //                     }
    //                     else {
    //                         logger.info("SUCCESS!");

    //                         for (let i = 0; i < rows.length; i++) {
    //                             let mapKey: string = "";
    //                             let LMTValueMap: Map<string, string> = new Map();
    //                             for (let [key, value] of Object.entries(rows[i])) {
    //                                 if (key === "Key") {
    //                                     mapKey = value as string;
    //                                 } else {
    //                                     LMTValueMap.set(key, value as string);
    //                                 }
    //                             }
    //                             LMTMap.set(mapKey, LMTValueMap);
    //                         }
    //                         connection.destroy();
    //                         logger.info(`LMT map size --> ${LMTMap.size}`);
    //                         resolve(LMTMap);
    //                     }
    //                 });
    //             }
    //         });
    //     });
    // }

    // static async getLMTKeys(): Promise<Map<string, string>> {
    //     // const prop = global.confi_prop;

    //     const connectionString = "Data Source=tcp:" + prop.DBhost + ",3306;Initial Catalog=" + prop.DBdatabase + ";User Id=" + prop.DBuser + ";Password=" + prop.DBpassword + ";";
    //     logger.info("connectionString  : " + connectionString)

    //     const connectionObj = parser(connectionString);

    //     const query = `SELECT * FROM LMT`;

    //     return new Promise((resolve, reject) => {
    //         let getLMTKeys: Map<string, string> = new Map();

    //         logger.info("Creating sql connection");
    //         let connection = createConnection(connectionObj);

    //         logger.info("Checking sql connection");
    //         connection.connect(function (error) {
    //             if (!!error) {
    //                 logger.info("Error");
    //             }
    //             else {
    //                 logger.info("Connected");
    //                 logger.info("Triggering sql query");
    //                 connection.query(query, function (error, rows, fields) {
    //                     if (!!error) {
    //                         logger.info("Error in the query");
    //                     }
    //                     else {
    //                         logger.info("SUCCESS!");

    //                         for (let i = 0; i < rows.length; i++) {
    //                             let mapKey: string = "";
    //                             let mapValue: string = "";
    //                             let LMTValueMap = new Map();
    //                             for (let [key, value] of Object.entries(rows[i])) {
    //                                 if (key === "en") {
    //                                     mapKey = value as string;
    //                                 } else {
    //                                     if (key === "Key") {
    //                                         mapValue = value as string;
    //                                     }
    //                                 }
    //                             }
    //                             getLMTKeys.set(mapKey, mapValue);
    //                         }
    //                         connection.destroy();
    //                         logger.info(`LMT map size --> ${getLMTKeys.size}`);
    //                         resolve(getLMTKeys);
    //                     }
    //                 });
    //             }
    //         });
    //     });
    // }

    // static async getUser(query:string): Promise<Map<string, string>> {
    //     const connectionString = "Data Source=tcp:" + prop.DBhost + ",3306;Initial Catalog=" + prop.DBdatabase + ";User Id=" + prop.DBuser + ";Password=" + prop.DBpassword + ";";
        
    //     const connectionObj = parser(connectionString);

    //     //logger.info(columnName);
    //    // const query = `SELECT USERNAME,PASSWORD,DISPLAY_NAME,SCOPE FROM ${prop.UserTable} WHERE SETUP_NAME='${process.env.SETUP}' AND TENANT_NAME='${process.env.TENANT}' AND flag='true' AND SCOPE = '${prop.USERSCOPE}'`;

    //     logger.info("getUser query : " + query);

    //     let timeout = 0;
    //      if (process.env.GRID) {
    //          timeout = random.number({ min: 60000, max: 300000 });
    //    } 
    //     logger.info(`waiting for timeout --> ${timeout}`);

    //     return new Promise((resolve, reject) => {
    //         setTimeout(() => {
    //             logger.info(`waited for timeout --> ${timeout}`);
    //             let testDataMap: Map<string, string> = new Map();
    //             //logger.info("Creating sql connection");
    //             let connection = createConnection(connectionObj);
    //             //logger.info("Checking sql connection");
    //             connection.connect(function (error) {
    //                 if (!!error) {
    //                     //logger.info("Error1");
    //                 }
    //                 else {
    //                     //logger.info("Connected");
    //                     //logger.info("Triggering sql query");
    //                     connection.query(query, function (error, rows, fields) {
    //                         let displayName: string = "";
    //                         let userScope: string = "";
    //                         if (!!error) {
    //                             //logger.info("Error in the query");
    //                         }
    //                         else {
    //                             //logger.info("SUCCESS!");
    //                             for (let i = 0; i < rows.length; i++) {
    //                                 displayName = rows[i].DISPLAY_NAME;
    //                                 userScope = rows[i].SCOPE;
    //                                 testDataMap.set("USERNAME", rows[i].USERNAME as string);
    //                                 testDataMap.set("PASSWORD", rows[i].PASSWORD as string);
    //                             }
    //                             connection.destroy();
    //                             logger.info(`user map size --> ${testDataMap.size}`);
    //                             logger.info(`user map size --> ${testDataMap.get("USERNAME")}`);
    //                             logger.info(`user map size --> ${testDataMap.get("PASSWORD")}`);
    //                             Startup.displayName = displayName;
    //                             resolve(testDataMap);
    //                         }
    //                     });
    //                 }
    //             });
    //         }, timeout);
    //     });
    // }

    // static async getUserScope(query:string): Promise<Map<string, string>> {
    //     const connectionString = "Data Source=tcp:" + prop.DBhost + ",3306;Initial Catalog=" + prop.DBdatabase + ";User Id=" + prop.DBuser + ";Password=" + prop.DBpassword + ";";
        
    //     const connectionObj = parser(connectionString);

    //     //logger.info(columnName);
    //    // const query = `SELECT USERNAME,PASSWORD,DISPLAY_NAME,SCOPE FROM ${prop.UserTable} WHERE SETUP_NAME='${process.env.SETUP}' AND TENANT_NAME='${process.env.TENANT}' AND flag='true' AND SCOPE = '${prop.USERSCOPE}'`;

    //     logger.info("getUser query : " + query);

    //     let timeout = 0;
    //    // if (process.env.GRID) {
    //      //   timeout = random.number({ min: 60000, max: 300000 });
    //    // }
    //     logger.info(`waiting for timeout --> ${timeout}`);

    //     return new Promise((resolve, reject) => {
    //         setTimeout(() => {
    //             logger.info(`waited for timeout --> ${timeout}`);
    //             let testDataMap: Map<string, string> = new Map();
    //             //logger.info("Creating sql connection");
    //             let connection = createConnection(connectionObj);
    //             //logger.info("Checking sql connection");
    //             connection.connect(function (error) {
    //                 if (!!error) {
    //                     //logger.info("Error1");
    //                 }
    //                 else {
    //                     //logger.info("Connected");
    //                     //logger.info("Triggering sql query");
    //                     connection.query(query, function (error, rows, fields) {
    //                         let displayName: string = "";
    //                         let userScope: string = "";
    //                         if (!!error) {
    //                             //logger.info("Error in the query");
    //                         }
    //                         else {
    //                             //logger.info("SUCCESS!");
    //                             for (let i = 0; i < rows.length; i++) {
    //                                 displayName = rows[i].DISPLAY_NAME;
    //                                 userScope = rows[i].SCOPE;
    //                                 testDataMap.set("USERNAME", rows[i].USERNAME as string);
    //                                 testDataMap.set("PASSWORD", rows[i].PASSWORD as string);
    //                             }
    //                             connection.destroy();
    //                             logger.info(`user map size --> ${testDataMap.size}`);
    //                             logger.info(`user map size --> ${testDataMap.get("USERNAME")}`);
    //                             logger.info(`user map size --> ${testDataMap.get("PASSWORD")}`);
    //                             Startup.displayName = displayName;
    //                             resolve(testDataMap);
    //                         }
    //                     });
    //                 }
    //             });
    //         }, timeout);
    //     });
    // }


    // static async updateUSER(userName: string, status: string) {
    //     // const prop = global.confi_prop;
    //     //logger.info("userName  : " + userName);
    //     const connectionString = "Data Source=tcp:" + prop.DBhost + ",3306;Initial Catalog=" + prop.DBdatabase + ";User Id=" + prop.DBuser + ";Password=" + prop.DBpassword + ";";
    //     //logger.info("connectionString  : " + connectionString);
    //     const connectionObj = parser(connectionString);
    //     const query = `UPDATE eProc_credentials SET FLAG='${status}' WHERE USERNAME='${userName}'`;
    //     //logger.info(query);
    //     return new Promise((resolve, reject) => {
    //         let testDataMap = new Map();
    //         //logger.info("Creating sql connection");
    //         let connection = createConnection(connectionObj);
    //         //logger.info("Checking sql connection");
    //         connection.connect(function (error) {
    //             if (!!error) {
    //                 //logger.info("Error1");
    //             }
    //             else {
    //                 //logger.info("Connected");
    //                 //logger.info("Triggering sql query");
    //                 connection.query(query, function (error, rows, fields) {
    //                     if (!!error) {
    //                         //logger.info("Error in the query");
    //                         connection.destroy();
    //                     }
    //                     else {
    //                         //logger.info("SUCCESS!");
    //                         connection.destroy();
    //                         resolve("RESOLVED");
    //                     }
    //                 });
    //             }
    //         });
    //     });
    // }

    static async getAndUpdateUser(query:string) {
        let testDataMap = await this.getUser(query);
        await this.updateUSER(testDataMap.get("USERNAME") as string, "false");
      
        return testDataMap;
    }

    static async createEnvFile() {
        let envVar = `Product='${process.env.PRODUCT}' \n Setup ='${process.env.SETUP}' \n Tenant='${process.env.TENANT}' \n Browser='${prop.browser}' \n Resolution='${prop.windowSize}'`;
        fs.writeFile("./output/environment.properties", envVar,
        function (err) {
            if (err) throw err;
            console.log("Saved!");
        });
    }

    // static async getAutomationKey() {
    //     const connectionString = "Data Source=tcp:" + prop.DBhost + ",3306;Initial Catalog=" + prop.DBdatabase + ";User Id=" + prop.DBuser + ";Password=" + prop.DBpassword + ";";
    //     logger.info("connectionString  : " + connectionString)
        
    //     const connectionObj = parser(connectionString);
        
    //     const columnName = process.env.SETUP + "_" + process.env.TENANT;
    //     logger.info(columnName);
        
    //     const query = "SELECT `Key`, MST_key FROM LMT";
    //     logger.info(query);
        
    //     return new Promise((resolve, reject) => {
    //         let testDataMap = new Map();
        
    //         logger.info("Creating sql connection");
        
    //         let connection = createConnection(connectionObj);
        
    //         logger.info("Checking sql connection");
    //         connection.connect(function (error) {
    //             if (!!error) {
    //                 logger.info("Error");
    //             }
    //             else {
    //                 logger.info("Connected");
    //                 logger.info("Triggering sql query");
    //                 connection.query(query, function (error, rows, fields) {
    //                     if (!!error) {
    //                         logger.info("Error in the query");
    //                     }
    //                     else {
    //                         logger.info("SUCCESS!");
        
    //                         for (let i = 0; i < rows.length; i++) {
    //                             let mapKey;
    //                             let mapValue;
        
    //                             for (let [key, value] of Object.entries(rows[i])) {
    //                                 if (key === "Key") {
    //                                     mapKey = value;
    //                                 }
    //                                 else {//if(key === "en") {
    //                                     mapValue = value;
    //                                 }
    //                             }
    //                             testDataMap.set(mapKey, mapValue);
    //                         }
    //                         connection.destroy();
    //                         logger.info(`Automation Keys size --> ${testDataMap.size}`);
    //                         resolve(testDataMap);
    //                     }
    //                 });
    //             }
    //         });
    //     });
    // }



    static addPoDetailsInZsn(poNumber: string, poType: string,supplier: string,date:string) 
    {
       
        logger.info("in add po details");
        const connectionString = "Data Source=tcp:192.168.5.221,3306;Initial Catalog=ZSN_Schema;User Id=zsnuser;Password=zsn@123;";

        logger.info("connectionString  : " + connectionString);
        const connectionObj = parser(connectionString);

        const query = `INSERT INTO Po_Details (SETUP_NAME,TENANT_NAME,PO_NUMBER,FLAG,PO_TYPE,SUPPLIER,CREATION_DATE) VALUES('${process.env.SETUP}','${process.env.TENANT}','${poNumber}','true','${poType}','${supplier}','${date}');`
        logger.info(query);
        return new Promise((resolve, reject) => {
            let testDataMap = new Map();
            let connection = createConnection(connectionObj);
            connection.connect(function (error) {
                if (!!error) {
                    logger.info("Error while connecting zsn db");
                }
                else {
                    logger.info("Connected to zsn");
                    //logger.info("Triggering sql query");
                    connection.query(query, function (error, rows, fields) {
                        if (!!error) {
                            logger.info("Error in the query");
                            connection.destroy();
                        }
                        else {
                            logger.info("SUCCESS!");
                            connection.destroy();
                            resolve("RESOLVED");
                        }
                    });
                }
            });
        });
    }

    static async getTestData(): Promise<Map<string, string>> {
        let testDataMap: Map<string, string> = new Map();

        let testDataFilePath = `./src/${process.env.PRODUCT}/DataRepository/${process.env.SETUP}_TestData_${process.env.PRODUCT}.json`;
        logger.info(`Test data json file path --> ${testDataFilePath}`);
        
        if(!fs.existsSync(testDataFilePath)) {
            logger.info(`Test data json file '${testDataFilePath}' not found`);
            throw new Error(`Test data json file '${testDataFilePath}' not found`);
        }
        else {
            let jsonObject = JSON.parse(fs.readFileSync(testDataFilePath, "utf-8"));
            jsonObject = jsonObject[`${process.env.SETUP}_${process.env.TENANT}` as string];

            for (const [key, value] of Object.entries(jsonObject)) {
                if(key !== "CREDENTIALS") {
                    testDataMap.set(key, value as string);
                }
            }
        }

        logger.info(`Data map size --> ${testDataMap.size}`);

        return testDataMap;
    }

    static async getUiElementXpath(): Promise<Map<string, string>> {
        let uiElementJsonFileName = `./src/${process.env.PRODUCT}/ObjectRepository/UI_Elements.json`;
        
        logger.info(`UI elements to be retrieved from file --> ${uiElementJsonFileName}`);

        let jsonObject = JSON.parse(fs.readFileSync(uiElementJsonFileName, "utf-8"));
        
        let elementMap: Map<string, string> = new Map();
     
        for (const [key, value] of Object.entries(jsonObject)) {
            let elementObject: object = value as object;

            let xpath = elementObject["XPATH"];
            
            elementMap.set(key, xpath);
        }

        console.log("-------------------elementMap size -----------" + elementMap.size);
        
        return elementMap;
    }

    static async getLMTDetails(): Promise<Map<string, Map<string, string>>> {
        let lmtJsonFilePath = `./src/${process.env.PRODUCT}/LmtRepository/Lmt.json`;
        let jsonObject = JSON.parse(fs.readFileSync(lmtJsonFilePath, "utf-8"));
        let LMTMap: Map<string, Map<string, string>> = new Map();
        for (const [key, value] of Object.entries(jsonObject)) {
                        
            let map: Map<string, string> = new Map();
            //map.set("Module", childObject["Module"]);
            // map.set("Key", childObject["Key"]);
            // map.set("MST_key", childObject["MST_key"]);
             map.set(key, value as string);
            LMTMap.set(key, map);
        }
        return LMTMap;
    }

    static async getLMTKeys(): Promise<Map<string, string>> {
        let lmtJsonFilePath = `./src/${process.env.PRODUCT}/LmtRepository/Lmt.json`;
        let jsonObject = JSON.parse(fs.readFileSync(lmtJsonFilePath, "utf-8"));
        let getLMTKeys: Map<string, string> = new Map();
        for (const [key, value] of Object.entries(jsonObject)) {
            let mapKey: string = "";
            let mapValue: string = "";
            if(key === "en") {
                mapKey = key;
            }
            else {
                mapValue = key;
            }
            getLMTKeys.set(mapKey, mapValue);
        }
        return getLMTKeys;
    }

    static async getAutomationKey() {
        let lmtJsonFilePath = `./src/${process.env.PRODUCT}/LmtRepository/Lmt.json`;
        let jsonObject = JSON.parse(fs.readFileSync(lmtJsonFilePath, "utf-8"));
        let testDataMap = new Map(); 
            
        for (let [key, value] of Object.entries(jsonObject))  
        {
            let mapKey;
            let mapValue;
            mapKey = key;
        
            mapValue = value;
           
            testDataMap.set(mapKey, mapValue);
        }       
        
        logger.info(`Automation Keys size --> ${testDataMap.size}`);
        return testDataMap;
        }
    
    static async getUser(query:string): Promise<Map<string, string>> {
        let timeout = 0;
        if (process.env.GRID) {
            // timeout = random.number({ min: 60000, max: 300000 });
        } 
        logger.info(`waiting for timeout --> ${timeout}`);

        let credsMap: Map<string, string> = new Map();
        
        return new Promise((resolve, reject) => {
            setTimeout(() => {
                logger.info(`waited for timeout --> ${timeout}`);
                
                let credentialsFilePath = `./src/${process.env.PRODUCT}/DataRepository/${process.env.SETUP}_TestData_${process.env.PRODUCT}.json`;
                logger.info(`Credentials json file path --> ${credentialsFilePath}`);
                
                if(!fs.existsSync(credentialsFilePath)) {
                    logger.info(`Credentials json file '${credentialsFilePath}' not found`);
                    throw new Error(`Credentials json file '${credentialsFilePath}' not found`);
                }
                else {
                    let displayName: string = "";
                    let userScope: string = "";
                    let jsonObject = JSON.parse(fs.readFileSync(credentialsFilePath, "utf-8"));
                    let credsArray: object[] = jsonObject[`${process.env.SETUP}_${process.env.TENANT}` as string]["CREDENTIALS"];

                    for (let i = 0; i < credsArray.length; i++) {
                        if(credsArray[i]["FLAG"] === "true") {
                            displayName = credsArray[i]["DISPLAY_NAME"];
                            credsMap.set("USERNAME", credsArray[i]["USERNAME"]);
                            credsMap.set("PASSWORD", credsArray[i]["PASSWORD"]);
                        }
                    }

                    logger.info(`user map size --> ${credsMap.size}`);
                    logger.info(`user map size --> ${credsMap.get("USERNAME")}`);
                    logger.info(`user map size --> ${credsMap.get("PASSWORD")}`);
                    Startup.displayName = displayName;

                    resolve(credsMap);
                }
            }, timeout);
        });
    }
           
    static async updateUSER(userName: string, status: string) {
        let credentialsFilePath = `./src/${process.env.PRODUCT}/DataRepository/${process.env.SETUP}_TestData_${process.env.PRODUCT}.json`;
        logger.info(`Credentials json file path --> ${credentialsFilePath}`);

        let jsonObject = JSON.parse(fs.readFileSync(credentialsFilePath, "utf-8"));
        let credsArray: object[] = jsonObject[`${process.env.SETUP}_${process.env.TENANT}` as string]["CREDENTIALS"];

        for (let i = 0; i < credsArray.length; i++) {
            if(credsArray[i]["USERNAME"] === userName) {
                jsonObject[`${process.env.SETUP}_${process.env.TENANT}` as string]["CREDENTIALS"][i]["FLAG"] = status;
                fs.writeFileSync(credentialsFilePath, JSON.stringify(jsonObject, null, "\t"));
                break;
            }
        }
    }

    static async getUserScope(query:string): Promise<Map<string, string>> {
        let timeout = 0;
        if (process.env.GRID) {
            timeout = random.number({ min: 60000, max: 300000 });
        } 
        logger.info(`waiting for timeout --> ${timeout}`);
        let credsMap: Map<string, string> = new Map();
        return new Promise((resolve, reject) => {
            setTimeout(() => {
                logger.info(`waited for timeout --> ${timeout}`);
                let credentialsFilePath = `./src/${process.env.PRODUCT}/DataRepository/${process.env.SETUP}_TestData_${process.env.PRODUCT}.json`;
                logger.info(`Credentials json file path --> ${credentialsFilePath}`);
                if(!fs.existsSync(credentialsFilePath)) {
                    logger.info(`Credentials json file '${credentialsFilePath}' not found`);
                    throw new Error(`Credentials json file '${credentialsFilePath}' not found`);
                }
                else {
                    let displayName: string = "";
                    let userScope: string = "";
                    let jsonObject = JSON.parse(fs.readFileSync(credentialsFilePath, "utf-8"));
                    let credsArray: object[] = jsonObject[process.env.TENANT as string]["CREDENTIALS"];
                    for (let i = 0; i < credsArray.length; i++) {
                        if(credsArray[i]["FLAG"] === "true" && credsArray[i]["SCOPE"] === "Global") {
                            displayName = credsArray[i]["DISPLAY_NAME"];
                            userScope = credsArray[i]["SCOPE"];
                            credsMap.set("USERNAME", credsArray[i]["USERNAME"]);
                            credsMap.set("PASSWORD", credsArray[i]["PASSWORD"]);
                        }
                    }
                    logger.info(`user map size --> ${credsMap.size}`);
                    logger.info(`user map size --> ${credsMap.get("USERNAME")}`);
                    logger.info(`user map size --> ${credsMap.get("PASSWORD")}`);
                    Startup.displayName = displayName;
                    resolve(credsMap);
                }
            }, timeout);
        });
    }

}