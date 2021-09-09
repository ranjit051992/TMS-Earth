"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const codeceptjs_1 = require("codeceptjs");
const fs_1 = __importDefault(require("fs"));
// import { N } from "actionbot-wrapper-auto-heal/N";
const mysql_1 = require("mysql");
const mssql_connection_string_1 = __importDefault(require("mssql-connection-string"));
const moment = require("moment-timezone");
const CustomReporterFA_1 = require("./CustomReporterFA");
const Startup = require("../../../../../../dist/Framework/FrameworkUtilities/Startup/Startup").Startup;
class FailureAnalyzer extends codeceptjs_1.Helper {
    static async testBefore(test) {
        try {
            // if(GlobalVars.failureAnalyzer) {
            // console.log(`testBefore started----------------`);
            await this.initializeFailureMap();
            moment.tz.setDefault("Asia/Kolkata");
            this.executionDateVar = moment().format("YYYY-MM-DD");
            this.startTimeVar = moment().format("h:mm:ss A");
            this.failureMap.set(this.executionDate, this.executionDateVar);
            this.failureMap.set(this.startTime, this.startTimeVar);
            this.failureMap.set(this.product, process.env.PRODUCT);
            this.failureMap.set(this.setup, process.env.SETUP);
            this.failureMap.set(this.tenant, process.env.TENANT);
            this.failureMap.set(this.pipelineInstance, `${process.env.GO_PIPELINE_NAME}_${process.env.GO_PIPELINE_COUNTER}`);
            if (test.title.includes("@")) {
                this.failureMap.set(this.scenario, test.title.split("@")[0].trim());
            }
            else {
                this.failureMap.set(this.scenario, test.title);
            }
            await this.setFeatureAndModuleName(test);
            // console.log(`testBefore ended----------------`);
            // }
        }
        catch (error) {
            console.log("FA error in before hook");
        }
    }
    static async testFailed(test, error) {
        try {
            // if(GlobalVars.failureAnalyzer) {
            // console.log("testFailed started----------------");
            const helper = codeceptjs_1.container.helpers("WebDriver");
            moment.tz.setDefault("Asia/Kolkata");
            this.failureMap.set(this.endTime, moment().format("h:mm:ss A"));
            this.failureMap.set(this.testStatus, "failed");
            // this.failureMap.set(this.error, error.stack.substring(0, error.stack.indexOf("\n")));
            // this.failureMap.set(this.stacktrace, error.stack);
            if (error) {
                if (error.stack) {
                    if (error.stack.includes("\n"))
                        this.failureMap.set(this.error, error.stack.substring(0, error.stack.indexOf("\n")));
                    else
                        this.failureMap.set(this.error, error.stack);
                    this.failureMap.set(this.stacktrace, error.stack);
                }
                else if (error.actual || error.expected) {
                    this.failureMap.set(this.error, "AssertionError");
                    this.failureMap.set(this.stacktrace, "AssertionError");
                }
            }
            // this.failureMap.set(this.executionDate, this.executionDateVar);
            // this.failureMap.set(this.startTime, this.startTimeVar);
            // this.failureMap.set(this.scenario, test.title);
            if (test.tags)
                this.failureMap.set(this.tags, test.tags);
            // this.failureMap.set(this.product, process.env.PRODUCT as string);
            // this.failureMap.set(this.setup, process.env.SETUP as string);
            // this.failureMap.set(this.tenant, process.env.TENANT as string);
            if (Startup.users.has("USERNAME")) {
                let user = Startup.users.get("USERNAME");
                if (user)
                    this.failureMap.set(this.username, user);
            }
            let browser = helper.config.browser;
            this.failureMap.set(this.browser, browser);
            if (test.steps) {
                for (const step of test.steps) {
                    if (step.status && (step.status === "failed")) {
                        this.failureMap.set(this.stepArgs, step.args.toString());
                        this.failureMap.set(this.step, step.name);
                        break;
                    }
                }
            }
            if (this.failureMap.get(this.stepArgs) === "NA") {
                // if(N.stepArgs.length) {
                //     let arr = N.stepArgs.filter(x => (x));
                //     await this.addAutoHealDetails(arr);
                // }
                // else {
                await this.addAutoHealDetails(["NA"]);
                //     }
            }
            else {
                await this.addAutoHealDetails([this.failureMap.get(this.stepArgs)]);
            }
            // if(this.failureMap.get(this.step) === "NA") {
            // if(N.stepName) {
            //     this.failureMap.set(this.step, N.stepName);
            // }
            // else {
            // this.failureMap.set(this.step, "NA");
            // }
            // }
            // await this.setFeatureAndModuleName(test);
            // await this.setIssue();
            let url = "NA", title = "NA";
            this.failureMap.set(this.url, url);
            this.failureMap.set(this.pageTitle, title);
            // this.failureMap.set(this.pageSource, "NA");
            if (helper.browser) {
                url = await helper.browser.getUrl();
                title = await helper.browser.getTitle();
            }
            this.failureMap.set(this.url, url);
            this.failureMap.set(this.pageTitle, title);
            // console.log("testFailed ended----------------");
            // }
        }
        catch (error) {
            console.log("FA error in failed hook");
        }
    }
    static async testAfter(test) {
        try {
            // if(GlobalVars.failureAnalyzer) {
            // console.log("testAfter started----------------");
            if (this.failureMap.has(this.testStatus)) {
                if (test.duration) {
                    let duration = test.duration;
                    let seconds = Math.floor((duration / 1000) % 60);
                    let minutes = Math.floor((duration / (1000 * 60)) % 60);
                    let hours = Math.floor((duration / (1000 * 60 * 60)) % 24);
                    duration = `${minutes}m ${seconds}s`;
                    this.failureMap.set(this.duration, duration);
                }
                else {
                    this.failureMap.set(this.duration, "NA");
                }
                let error = this.failureMap.get(this.error);
                let stacktrace = this.failureMap.get(this.stacktrace);
                if (error.includes("Error: Failed to create session") || stacktrace.includes("Error: Failed to create session") ||
                    stacktrace.includes("connect ECONNREFUSED")) {
                    this.failureMap.set(this.issue, "Infra issue");
                }
                if (!this.failureMap.has(this.browserConsoleLogs)) {
                    this.failureMap.set(this.browserConsoleLogs, "NA");
                    this.failureMap.set(this.pageSource, "NA");
                }
                // for (const [key, value] of this.failureMap) {
                //     console.log(`${key} --> ${value}`);
                // }
                await this.writeToJson();
                this.failureMap = new Map();
                // N.stepArgs = new Array();
                // N.stepName = "";
            }
            // console.log("testAfter ended----------------");
            // }
        }
        catch (error) {
            console.log("FA error in after hook");
        }
    }
    static async getFeatureFilePath(directoryPath, featureName) {
        // let directoryPath = `./src/${process.env.PRODUCT}/features`;
        if (fs_1.default.statSync(directoryPath).isDirectory()) {
            let fileArray = fs_1.default.readdirSync(directoryPath);
            for (let i = 0; i < fileArray.length; i++) {
                fileArray[i] = `${directoryPath}/${fileArray[i]}`;
                let value = await this.getFeatureFilePath(fileArray[i], featureName);
                if (value) {
                    return value;
                }
            }
        }
        else if (fs_1.default.statSync(directoryPath).isFile()) {
            let fileText = fs_1.default.readFileSync(directoryPath, "utf-8");
            if (fileText) {
                if (fileText.trim().replace(" ", "").includes(`Feature:${featureName}`)) {
                    let path = directoryPath.split("/");
                    return path[path.length - 2];
                }
            }
        }
    }
    static async createJsonFile() {
        // if(GlobalVars.failureAnalyzer) {
        fs_1.default.writeFileSync(this.jsonFilePath, JSON.stringify(new Array()));
        console.log(`FailureAnalyzer json file created`);
        // }
    }
    static async deleteJson() {
        fs_1.default.unlinkSync(this.jsonFilePath);
        console.log(`FailureAnalyzer json file deleted`);
    }
    static async writeToJson() {
        console.log("started writting to json");
        let jsonObject = JSON.parse(fs_1.default.readFileSync(this.jsonFilePath, "utf-8"));
        let msg = "------------------------------------------------------------------\n";
        for (const [key, value] of this.failureMap) {
            msg += key + ":" + value + "\n";
        }
        msg += "------------------------------------------------------------------";
        // console.log(msg);
        let obj = {};
        obj[this.executionDate] = this.failureMap.get(this.executionDate);
        obj[this.pipelineInstance] = this.failureMap.get(this.pipelineInstance);
        obj[this.product] = this.failureMap.get(this.product);
        obj[this.setup] = this.failureMap.get(this.setup);
        obj[this.tenant] = this.failureMap.get(this.tenant);
        obj[this.moduleName] = this.failureMap.get(this.moduleName);
        obj[this.featureName] = this.failureMap.get(this.featureName);
        obj[this.username] = this.failureMap.get(this.username);
        obj[this.scenario] = this.failureMap.get(this.scenario);
        obj[this.tags] = this.failureMap.get(this.tags);
        obj[this.browser] = this.failureMap.get(this.browser);
        obj[this.step] = this.failureMap.get(this.step);
        obj[this.stepArgs] = this.failureMap.get(this.stepArgs);
        obj[this.url] = this.failureMap.get(this.url);
        obj[this.pageTitle] = this.failureMap.get(this.pageTitle);
        obj[this.error] = this.failureMap.get(this.error);
        obj[this.stacktrace] = this.failureMap.get(this.stacktrace);
        obj[this.startTime] = this.failureMap.get(this.startTime);
        obj[this.endTime] = this.failureMap.get(this.endTime);
        obj[this.duration] = this.failureMap.get(this.duration);
        obj[this.browserConsoleLogs] = this.failureMap.get(this.browserConsoleLogs);
        obj[this.pageSource] = this.failureMap.get(this.pageSource);
        obj[this.primaryLocator] = this.failureMap.get(this.primaryLocator);
        obj[this.retryCount] = this.failureMap.get(this.retryCount);
        obj[this.issue] = this.failureMap.get(this.issue);
        jsonObject.push(obj);
        fs_1.default.writeFileSync(this.jsonFilePath, JSON.stringify(jsonObject, null, "\t"));
        console.log("done writting to json");
    }
    static async writeToDb() {
        try {
            // if(GlobalVars.failureAnalyzer) {
            if (!fs_1.default.existsSync(this.jsonFilePath)) {
                console.log(`${this.jsonFilePath} file not present`);
            }
            else {
                console.log("Started writing the failures to db");
                let dbHost = "192.168.5.221";
                let dbUser = "gauge.poc";
                let dbPassword = "gauge@123";
                let dbDatabase = "Gauge_schema";
                let jsonArray = JSON.parse(fs_1.default.readFileSync(this.jsonFilePath, "utf-8"));
                if (jsonArray.length) {
                    const connectionString = "Data Source=tcp:" + dbHost + ",3306;Initial Catalog=" + dbDatabase + ";User Id=" + dbUser + ";Password=" + dbPassword + ";";
                    console.log("connectionString  : " + connectionString);
                    const connectionObj = mssql_connection_string_1.default(connectionString);
                    await new Promise((resolve, reject) => {
                        console.log("Creating sql connection");
                        let connection = mysql_1.createConnection(connectionObj);
                        console.log("Checking sql connection");
                        connection.connect(async function (error) {
                            if (!!error) {
                                connection.destroy();
                                console.log("Error in database connection:\n" + error);
                            }
                            else {
                                console.log("Connected");
                                console.log("Triggering sql query");
                                for (const jsonObject of jsonArray) {
                                    if (jsonObject[FailureAnalyzer.issue] !== "NA") {
                                        let query = `insert into ${FailureAnalyzer.tableName} (${FailureAnalyzer.executionDate}, ${FailureAnalyzer.pipelineInstance}, ${FailureAnalyzer.product}, ${FailureAnalyzer.setup}, ${FailureAnalyzer.tenant},
                                                ${FailureAnalyzer.moduleName}, ${FailureAnalyzer.featureName}, ${FailureAnalyzer.username}, ${FailureAnalyzer.scenario}, ${FailureAnalyzer.tags}, ${FailureAnalyzer.browser}, ${FailureAnalyzer.step}, ${FailureAnalyzer.stepArgs},
                                                ${FailureAnalyzer.url}, ${FailureAnalyzer.pageTitle}, ${FailureAnalyzer.error}, ${FailureAnalyzer.stacktrace}, ${FailureAnalyzer.startTime}, ${FailureAnalyzer.endTime}, ${FailureAnalyzer.duration},
                                                ${FailureAnalyzer.browserConsoleLogs}, ${FailureAnalyzer.pageSource}, ${FailureAnalyzer.primaryLocator}, ${FailureAnalyzer.retryCount}, ${FailureAnalyzer.issue}, Status) values(`;
                                        for (let [key, value] of Object.entries(jsonObject)) {
                                            // if(key !== FailureAnalyzer.pageSource) {
                                            if (value.includes('"'))
                                                value = value.replace(/"/g, "'");
                                            // if(key === FailureAnalyzer.error) {
                                            //     let errMsg = value.substring(0, value.indexOf("\n"))/* .replace(/"/g, "'") */;
                                            //     query += `"${errMsg}",`;
                                            // }
                                            // else {
                                            query += `"${value}",`;
                                            // }
                                            // }
                                        }
                                        query += "'Failed');";
                                        // console.log(query);
                                        await new Promise((resolve, reject) => {
                                            connection.query(query, function (error, rows, fields) {
                                                if (!!error) {
                                                    connection.destroy();
                                                    console.log("Error in the query:\n" + error);
                                                    resolve(true);
                                                }
                                                else {
                                                    console.log("SUCCESS!");
                                                    resolve(true);
                                                }
                                            });
                                        });
                                    }
                                }
                                connection.destroy();
                                console.log("Done writing the failures to db");
                                resolve(true);
                            }
                        });
                    });
                }
                await this.deleteJson();
            }
            // }
        }
        catch (error) {
            console.log(error);
        }
    }
    static async addAutoHealDetails(locators) {
        let primaryLocatorArr = new Array();
        let retryCountArr = new Array();
        let stepArgsArr = new Array();
        for (const locator of locators) {
            // if (N.uiElements.has(locator)) {
            //     if (!this.failureMap.has(this.stepArgs)) stepArgsArr.push(N.uiElements.get(locator)!.xpath);
            //     primaryLocatorArr.push(N.uiElements.get(locator)!.primaryLocator);
            //     if (N.uiElements.get(locator)!.retryCount) retryCountArr.push(N.uiElements.get(locator)!.retryCount.toString());
            //     else retryCountArr.push("0");
            // }
            // else {
            if (!this.failureMap.has(this.stepArgs))
                stepArgsArr.push(locator);
            primaryLocatorArr.push("NA");
            retryCountArr.push("0");
            // }
        }
        if (!this.failureMap.has(this.stepArgs))
            this.failureMap.set(this.stepArgs, stepArgsArr.toString());
        this.failureMap.set(this.primaryLocator, primaryLocatorArr.toString());
        this.failureMap.set(this.retryCount, retryCountArr.toString());
    }
    static async getBrowserConsoleLogs(scenarioName) {
        const helper = codeceptjs_1.container.helpers("WebDriver");
        const browser = helper.browser;
        try {
            this.failureMap.set("Browser_Console_Logs", "");
            // const browser = this.helpers['WebDriver'].browser;
            let logs = await browser.getLogs('browser');
            let msg = `--------------------------------------- browser console logs for ${scenarioName} ---------------------------------------\n`;
            msg += `Application url --> ${await helper['WebDriver'].grabCurrentUrl()}\n`;
            msg += JSON.stringify(logs);
            msg += `\n----------------------------------------------------------------------------------------------------`;
            console.log(msg);
            this.failureMap.set("Browser_Console_Logs", JSON.stringify(logs));
            return logs;
        }
        catch (error) {
            console.log("inside catch of browser console logs");
        }
    }
    static async setPageSource() {
        const helper = codeceptjs_1.container.helpers("WebDriver");
        try {
            let pageSource = await helper.grabSource();
            this.failureMap.set(this.pageSource, pageSource);
        }
        catch (error) {
            this.failureMap.set(this.pageSource, "NA");
        }
    }
    static async setFeatureAndModuleName(test) {
        let featureName = test.parent.title;
        if (featureName) {
            this.failureMap.set(this.featureName, featureName);
            for (const tag of test.tags) {
                if (featureName.includes(tag)) {
                    featureName = featureName.replace(tag, "").trim();
                }
            }
            let featureFilePath = await this.getFeatureFilePath(`./src/${process.env.PRODUCT}/features`, featureName);
            if (featureFilePath)
                this.failureMap.set(this.moduleName, featureFilePath);
            else
                this.failureMap.set(this.moduleName, "NA");
        }
        else {
            this.failureMap.set(this.featureName, "NA");
            this.failureMap.set(this.moduleName, "NA");
        }
    }
    static async setIssue() {
        try {
            let issue = "NA";
            this.failureMap.set(this.issue, issue);
            let scriptIssue = "Script issue";
            let performanceIssue = "Performance issue";
            let infraIssue = "Infra issue";
            let bug = "Bug";
            let unhandledAlert = "Unhandled alert";
            // if(this.failureMap.get(this.retryCount)!.includes(",")) {
            //     for (const element of this.failureMap.get(this.retryCount)!.split(",")) {
            //         if(!isNaN(parseInt(element))) {
            //             if(parseInt(element) > 3) {
            //                 this.failureMap.set(this.issue, "Bug");
            //             }
            //         }
            //     }
            // }
            // else {
            //     if(!isNaN(parseInt(this.failureMap.get(this.retryCount)!))) {
            //         if(parseInt(this.failureMap.get(this.retryCount)!) > 3) {
            //             this.failureMap.set(this.issue, "Bug");
            //         }
            //     }
            // }
            let error = this.failureMap.get(this.error);
            let stacktrace = this.failureMap.get(this.stacktrace);
            let step = this.failureMap.get(this.step);
            if (error.includes("Error: Failed to create session") || stacktrace.includes("Error: Failed to create session") ||
                error.includes("Session timed out or not found") || stacktrace.includes("Session timed out or not found") ||
                error.includes("ECONNRESET") || stacktrace.includes("ECONNRESET") ||
                stacktrace.includes("connect ECONNREFUSED")) {
                issue = infraIssue;
            }
            // else if(step.includes("waitForVisible") || step.includes("waitForElement") || step.includes("waitForClickable") ||
            // step.includes("waitForEnabled") || step.includes("waitForValue") || step.includes("waitForText") ||
            // step.includes("waitForInvisible") || step.includes("click") || step.includes("fillField") ||
            // step.includes("assert") || step.includes("see")) {
            else if (!step.includes("NA")) {
                try {
                    let helper = this.prototype.helpers['WebDriver'];
                    let countArray = new Array();
                    countArray.push(await helper.grabNumberOfVisibleElements("//div[@class='spinner-cube']"));
                    countArray.push(await helper.grabNumberOfVisibleElements("//dew-progress-overlay//div[@class='spinner-cube']"));
                    countArray.push(await helper.grabNumberOfVisibleElements("//div[@id='status_overlay_parseInProgress']//div[contains(@class,'statusmsg')]"));
                    countArray.push(await helper.grabNumberOfVisibleElements("//div[@id='notification-overlay']"));
                    countArray.push(await helper.grabNumberOfVisibleElements("//div[@class='spinner-backdrop']//div[@class='spinner']"));
                    countArray.push(await helper.grabNumberOfVisibleElements("//div[@id='status_overlay_parsing_count_overlay']"));
                    countArray.push(await helper.grabNumberOfVisibleElements("//img[@alt='No records found']"));
                    let count = countArray.filter(x => x > 0);
                    console.log("after executing all the loader checks");
                    if (count.length)
                        issue = performanceIssue;
                    else if (step.includes("assert") || step.includes("see"))
                        issue = bug;
                    else {
                        let count = await helper.grabNumberOfVisibleElements("//div[contains(@class,'alert-panel')]");
                        if (count)
                            issue = unhandledAlert;
                        else
                            issue = scriptIssue;
                    }
                }
                catch (error) {
                    console.log("Error while checking presence of loader.\n" + error);
                    issue = scriptIssue;
                }
            }
            else if (step.includes("NA")) {
                if (error.includes("EvalError:") || stacktrace.includes("EvalError:") ||
                    error.includes("RangeError:") || stacktrace.includes("RangeError:") ||
                    error.includes("ReferenceError:") || stacktrace.includes("ReferenceError:") ||
                    error.includes("SyntaxError:") || stacktrace.includes("SyntaxError:") ||
                    error.includes("TypeError:") || stacktrace.includes("TypeError:") ||
                    error.includes("URIError:") || stacktrace.includes("URIError:")) {
                    issue = scriptIssue;
                }
                else if (error.includes("AssertionError") || stacktrace.includes("AssertionError"))
                    issue = bug;
                else {
                    issue = bug;
                }
            }
            else {
                issue = scriptIssue;
            }
            this.failureMap.set(this.issue, issue);
        }
        catch (error) {
            console.log("setting issue as NA");
        }
    }
    static async grabBrowserConsoleLogs(helper, scenarioName) {
        // if(GlobalVars.failureAnalyzer) {
        try {
            this.failureMap.set("Browser_Console_Logs", "NA");
            const browser = helper.browser;
            if (browser) {
                let logs = await browser.getLogs('browser');
                let msg = `--------------------------------------- browser console logs for ${scenarioName} ---------------------------------------\n`;
                msg += `Application url --> ${helper.grabCurrentUrl()}\n`;
                msg += JSON.stringify(logs);
                msg += `\n----------------------------------------------------------------------------------------------------`;
                console.log(msg);
                // commenting browser console logs as not being used anywhere in failure analyzer
                // this.failureMap.set(this.browserConsoleLogs, JSON.stringify(logs));
                return logs;
            }
        }
        catch (error) {
            console.log(`setting browser console logs as NA\n${error}`);
            this.failureMap.set(this.browserConsoleLogs, "NA");
        }
        // }
    }
    static async grabPageSource(helper) {
        // if(GlobalVars.failureAnalyzer) {
        try {
            // commenting page source as not being used anywhere in failure analyzer
            // let pageSource = await helper.grabSource();
            // this.failureMap.set(this.pageSource, pageSource);
            // return pageSource;
        }
        catch (error) {
            console.log(`setting page source as NA\n${error}`);
            this.failureMap.set(this.pageSource, "NA");
        }
        // }
    }
    static async initializeFailureMap() {
        this.failureMap.set(this.executionDate, "NA");
        this.failureMap.set(this.product, "NA");
        this.failureMap.set(this.setup, "NA");
        this.failureMap.set(this.tenant, "NA");
        this.failureMap.set(this.moduleName, "NA");
        this.failureMap.set(this.featureName, "NA");
        this.failureMap.set(this.username, "NA");
        this.failureMap.set(this.scenario, "NA");
        this.failureMap.set(this.tags, "NA");
        this.failureMap.set(this.browser, "NA");
        this.failureMap.set(this.step, "NA");
        this.failureMap.set(this.stepArgs, "NA");
        this.failureMap.set(this.url, "NA");
        this.failureMap.set(this.pageTitle, "NA");
        this.failureMap.set(this.error, "NA");
        this.failureMap.set(this.stacktrace, "NA");
        this.failureMap.set(this.startTime, "NA");
        this.failureMap.set(this.endTime, "NA");
        this.failureMap.set(this.duration, "NA");
        this.failureMap.set(this.browserConsoleLogs, "NA");
        this.failureMap.set(this.pageSource, "NA");
        this.failureMap.set(this.primaryLocator, "NA");
        this.failureMap.set(this.retryCount, "NA");
        this.failureMap.set(this.issue, "NA");
    }
    static async setBrowserConsolePageSourceIssueType(test, error) {
        const helper = codeceptjs_1.container.helpers("WebDriver");
        await this.grabBrowserConsoleLogs(helper, test.title);
        await this.grabPageSource(helper);
        await this.setIssue();
    }
    static async addMissingScenarioInFAJson(scenarioName, xml, testcaseIndex) {
        await this.initializeFailureMap();
        let error = xml.getElementsByTagName(CustomReporterFA_1.CustomReporterFA.testcaseTagName)[testcaseIndex].getElementsByTagName("failure")[0].getElementsByTagName("message")[0].textContent;
        let stacktrace = xml.getElementsByTagName(CustomReporterFA_1.CustomReporterFA.testcaseTagName)[testcaseIndex].getElementsByTagName("failure")[0].getElementsByTagName("message")[0].textContent;
        let featureName = xml.getElementsByTagName(CustomReporterFA_1.CustomReporterFA.testcaseTagName)[testcaseIndex].parentNode.parentNode.childNodes[1].textContent;
        let issue = "";
        if (error.includes("Error: Failed to create session") || stacktrace.includes("Error: Failed to create session") ||
            error.includes("Session timed out or not found") || stacktrace.includes("Session timed out or not found") ||
            stacktrace.includes("connect ECONNREFUSED")) {
            issue = "Infra issue";
        }
        else {
            issue = "Script issue";
        }
        moment.tz.setDefault("Asia/Kolkata");
        this.failureMap.set(this.executionDate, moment().format("YYYY-MM-DD"));
        this.failureMap.set(this.pipelineInstance, `${process.env.GO_PIPELINE_NAME}_${process.env.GO_PIPELINE_COUNTER}`);
        this.failureMap.set(this.product, process.env.PRODUCT);
        this.failureMap.set(this.setup, process.env.SETUP);
        this.failureMap.set(this.tenant, process.env.TENANT);
        // obj[this.moduleName] = this.failureMap.get(this.moduleName)!;
        this.failureMap.set(this.featureName, featureName);
        // this.failureMap.set(this.username, username);
        this.failureMap.set(this.scenario, scenarioName);
        // obj[this.tags] = this.failureMap.get(this.tags)!;
        // this.failureMap.set(this.scenario, browser);
        // obj[this.step] = this.failureMap.get(this.step)!;
        // obj[this.stepArgs] = this.failureMap.get(this.stepArgs)!;
        // obj[this.url] = this.failureMap.get(this.url)!;
        // obj[this.pageTitle] = this.failureMap.get(this.pageTitle)!;
        this.failureMap.set(this.error, error);
        this.failureMap.set(this.stacktrace, stacktrace);
        // obj[this.startTime] = this.failureMap.get(this.startTime)!;
        // obj[this.endTime] = this.failureMap.get(this.endTime)!;
        // obj[this.duration] = this.failureMap.get(this.duration)!;
        // obj[this.browserConsoleLogs] = this.failureMap.get(this.browserConsoleLogs)!;
        // obj[this.pageSource] = this.failureMap.get(this.pageSource)!;
        // obj[this.primaryLocator] = this.failureMap.get(this.primaryLocator)!;
        // obj[this.retryCount] = this.failureMap.get(this.retryCount)!;
        this.failureMap.set(this.issue, issue);
        await this.writeToJson();
    }
}
exports.FailureAnalyzer = FailureAnalyzer;
FailureAnalyzer.failureMap = new Map();
FailureAnalyzer.executionDate = "Execution_Date";
FailureAnalyzer.product = "Product";
FailureAnalyzer.setup = "Setup";
FailureAnalyzer.tenant = "Tenant";
FailureAnalyzer.moduleName = "Module_Name";
FailureAnalyzer.featureName = "Feature_Name";
FailureAnalyzer.username = "Username";
FailureAnalyzer.scenario = "Scenario";
FailureAnalyzer.tags = "Tags";
FailureAnalyzer.browser = "Browser";
FailureAnalyzer.step = "Step";
FailureAnalyzer.stepArgs = "Step_Args";
FailureAnalyzer.url = "Url";
FailureAnalyzer.pageTitle = "Page_Title";
FailureAnalyzer.error = "Error";
FailureAnalyzer.stacktrace = "Error_Stacktrace";
FailureAnalyzer.startTime = "Start_Time";
FailureAnalyzer.endTime = "End_Time";
FailureAnalyzer.duration = "Duration";
FailureAnalyzer.browserConsoleLogs = "Browser_Console_Logs";
FailureAnalyzer.pageSource = "Page_Source";
FailureAnalyzer.primaryLocator = "Primay_Locator";
FailureAnalyzer.retryCount = "Retry_Count";
FailureAnalyzer.issue = "Issue";
FailureAnalyzer.testStatus = "testStatus";
FailureAnalyzer.pipelineInstance = "Pipeline_Instance";
FailureAnalyzer.executionDateVar = "";
FailureAnalyzer.startTimeVar = "";
FailureAnalyzer.jsonFilePath = "./FailureAnalyzer.json";
FailureAnalyzer.tableName = "FailureAnalyzer";
