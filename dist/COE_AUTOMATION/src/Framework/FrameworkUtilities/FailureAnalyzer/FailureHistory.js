"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const fs_1 = __importDefault(require("fs"));
const mysql_1 = require("mysql");
const mssql_connection_string_1 = __importDefault(require("mssql-connection-string"));
const FailureAnalyzer_1 = require("./FailureAnalyzer");
class FailureHistory {
    static async getHistoryRecordsFromDatabase() {
        const connectionString = "Data Source=tcp:192.168.5.221,3306;Initial Catalog=Gauge_schema;User Id=gauge.poc;Password=gauge@123;";
        console.log("connectionString  : " + connectionString);
        const connectionObj = mssql_connection_string_1.default(connectionString);
        let pipelineRange = await this.getHistoryRange();
        const query = `SELECT Execution_Date, Pipeline_Instance, Product, Setup, Tenant, Scenario, Error, Issue FROM ${FailureAnalyzer_1.FailureAnalyzer.tableName} WHERE Product = "${process.env.PRODUCT}" AND Pipeline_Instance IN (${pipelineRange})`;
        console.log(`ticketing query to be executed --> ${query}`);
        return new Promise((resolve, reject) => {
            console.log("Creating sql connection");
            const connection = mysql_1.createConnection(connectionObj);
            console.log("Checking sql connection");
            connection.connect((error) => {
                if (!!error) {
                    throw new Error("Error in database connection\n" + error);
                }
                else {
                    console.log("Connected");
                    console.log("Triggering sql query");
                    connection.query(query, function (error, rows, fields) {
                        if (!!error) {
                            throw new Error("Error in the query\n" + error);
                        }
                        else {
                            console.log("SUCCESS!");
                            let jsonArray = new Array();
                            for (let i = 0; i < rows.length; i++) {
                                let jsonObject = {};
                                for (let [key, value] of Object.entries(rows[i])) {
                                    jsonObject[key] = value;
                                }
                                jsonArray.push(jsonObject);
                            }
                            connection.destroy();
                            console.log(`History data size --> ${jsonArray.length}`);
                            resolve(jsonArray);
                        }
                    });
                }
            });
        });
    }
    static async writeToFailureHistoryJson() {
        // process.env.GO_PIPELINE_NAME = "AutoHealTest";
        // process.env.GO_PIPELINE_COUNTER = "61";
        if (!fs_1.default.existsSync(FailureAnalyzer_1.FailureAnalyzer.jsonFilePath)) {
            throw new Error(`${FailureAnalyzer_1.FailureAnalyzer.jsonFilePath} file not present`);
        }
        else {
            let faJsonArray = JSON.parse(fs_1.default.readFileSync(FailureAnalyzer_1.FailureAnalyzer.jsonFilePath, "utf-8"));
            if (faJsonArray.length) {
                let dbJsonArray = await this.getHistoryRecordsFromDatabase();
                console.log("started writting to failure history json");
                let historyJsonObject = {};
                for (const faJsonObj of faJsonArray) {
                    let obj = {};
                    obj[FailureAnalyzer_1.FailureAnalyzer.executionDate] = faJsonObj[FailureAnalyzer_1.FailureAnalyzer.executionDate];
                    obj[FailureAnalyzer_1.FailureAnalyzer.pipelineInstance] = faJsonObj[FailureAnalyzer_1.FailureAnalyzer.pipelineInstance];
                    obj[FailureAnalyzer_1.FailureAnalyzer.product] = faJsonObj[FailureAnalyzer_1.FailureAnalyzer.product];
                    obj[FailureAnalyzer_1.FailureAnalyzer.setup] = faJsonObj[FailureAnalyzer_1.FailureAnalyzer.setup];
                    obj[FailureAnalyzer_1.FailureAnalyzer.tenant] = faJsonObj[FailureAnalyzer_1.FailureAnalyzer.tenant];
                    obj[FailureAnalyzer_1.FailureAnalyzer.scenario] = faJsonObj[FailureAnalyzer_1.FailureAnalyzer.scenario];
                    obj[FailureAnalyzer_1.FailureAnalyzer.error] = faJsonObj[FailureAnalyzer_1.FailureAnalyzer.error];
                    obj[FailureAnalyzer_1.FailureAnalyzer.issue] = faJsonObj[FailureAnalyzer_1.FailureAnalyzer.issue];
                    let scenarioObj = {};
                    scenarioObj[faJsonObj[FailureAnalyzer_1.FailureAnalyzer.scenario]] = {
                        "current": obj,
                        "history": new Array()
                    };
                    historyJsonObject = Object.assign(historyJsonObject, scenarioObj);
                }
                let historyJsonObjectKeys = Object.getOwnPropertyNames(historyJsonObject);
                for (const dbJsonObj of dbJsonArray) {
                    if (historyJsonObjectKeys.includes(dbJsonObj[FailureAnalyzer_1.FailureAnalyzer.scenario])) {
                        let scenarioName = dbJsonObj[FailureAnalyzer_1.FailureAnalyzer.scenario];
                        delete dbJsonObj[scenarioName];
                        historyJsonObject[scenarioName]["history"].push(dbJsonObj);
                    }
                }
                fs_1.default.writeFileSync(this.historyFilePath, JSON.stringify(historyJsonObject, null, "\t"));
                console.log("done writting to failure history json");
            }
            else {
                console.log("no records found in FailureAnalyzer.json");
            }
        }
    }
    static async getHistoryRange() {
        let pipelineRange = "";
        let pipelineInstanceCounter = parseInt(process.env.GO_PIPELINE_COUNTER) - 1;
        for (let i = 0; i < this.noOfDaysOfHistory; i++) {
            pipelineRange += `"${process.env.GO_PIPELINE_NAME}_${pipelineInstanceCounter--}",`;
        }
        pipelineRange = pipelineRange.substring(0, pipelineRange.length - 1);
        return pipelineRange;
    }
    static async getSetupSpecificHistoryFromDb(product, executionDate, setup) {
        const connectionString = "Data Source=tcp:192.168.5.221,3306;Initial Catalog=Gauge_schema;User Id=gauge.poc;Password=gauge@123;";
        console.log("connectionString  : " + connectionString);
        const connectionObj = mssql_connection_string_1.default(connectionString);
        const query = `SELECT Execution_Date, Pipeline_Instance, Product, Setup, Tenant, Scenario, Error, Issue FROM ${FailureAnalyzer_1.FailureAnalyzer.tableName} WHERE Product = "${product}" AND Execution_Date = "${executionDate}" AND Setup = "${setup}"`;
        console.log(`setup specific query --> ${query}`);
        return new Promise((resolve, reject) => {
            console.log("Creating sql connection");
            const connection = mysql_1.createConnection(connectionObj);
            console.log("Checking sql connection");
            connection.connect((error) => {
                if (!!error) {
                    throw new Error("Error in database connection\n" + error);
                }
                else {
                    console.log("Connected");
                    console.log("Triggering sql query");
                    connection.query(query, function (error, rows, fields) {
                        if (!!error) {
                            throw new Error("Error in the query\n" + error);
                        }
                        else {
                            console.log("SUCCESS!");
                            let jsonArray = new Array();
                            for (let i = 0; i < rows.length; i++) {
                                let jsonObject = {};
                                for (let [key, value] of Object.entries(rows[i])) {
                                    jsonObject[key] = value;
                                }
                                jsonArray.push(jsonObject);
                            }
                            connection.destroy();
                            console.log(`Setup specific history data size --> ${jsonArray.length}`);
                            resolve(jsonArray);
                        }
                    });
                }
            });
        });
    }
    static async compareSetupSpecificHistory(product, executionDate, setup1, setup2) {
        let setup1HistoryArray = await this.getSetupSpecificHistoryFromDb(product, executionDate, setup1);
        let setup2HistoryArray = await this.getSetupSpecificHistoryFromDb(product, executionDate, setup2);
        fs_1.default.writeFileSync("./setup1.json", JSON.stringify(setup1HistoryArray, null, "\t"));
        fs_1.default.writeFileSync("./setup2.json", JSON.stringify(setup2HistoryArray, null, "\t"));
        let comparisonObject = {
            "common": {},
        };
    }
}
exports.FailureHistory = FailureHistory;
FailureHistory.categoriesJsonFilePath = "allure-report/data/categories.json";
FailureHistory.noOfDaysOfHistory = 5;
FailureHistory.historyJsonArray = new Array();
FailureHistory.historyFilePath = "./output/FailureHistory.json";
