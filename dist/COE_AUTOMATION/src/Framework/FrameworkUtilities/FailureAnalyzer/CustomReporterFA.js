"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
const fs_1 = __importDefault(require("fs"));
const xmldom_1 = require("xmldom");
const FailureAnalyzer_1 = require("./FailureAnalyzer");
const FailureHistory_1 = require("./FailureHistory");
class CustomReporterFA {
    static async modifyAllureXmlFiles() {
        try {
            await new Promise((resolve, reject) => {
                setTimeout(() => {
                    resolve(true);
                }, 30000);
            });
            if (fs_1.default.existsSync(FailureAnalyzer_1.FailureAnalyzer.jsonFilePath)) {
                this.jsonArray = JSON.parse(fs_1.default.readFileSync(FailureAnalyzer_1.FailureAnalyzer.jsonFilePath, "utf-8"));
                // if(this.jsonArray.length) {
                console.log("started modifying the allure report");
                this.pipelineIssueFlag = await this.isPipelineIssue();
                if (fs_1.default.existsSync(FailureHistory_1.FailureHistory.historyFilePath)) {
                    this.historyJsonObject = JSON.parse(fs_1.default.readFileSync(FailureHistory_1.FailureHistory.historyFilePath, "utf-8"));
                }
                await this.modifyXmlFile(this.outputPath);
                console.log("allure report modification completed");
                if (this.isFaJsonIssueTypeModified) {
                    fs_1.default.writeFileSync(FailureAnalyzer_1.FailureAnalyzer.jsonFilePath, JSON.stringify(this.jsonArray, null, "\t"));
                    console.log("Failure Analyzer json modification completed");
                }
                await this.createCategoriesJsonFile();
                // }
            }
        }
        catch (error) {
            console.log("skipping the modification of allure report");
        }
    }
    static async modifyXmlFile(file) {
        if (fs_1.default.statSync(file).isDirectory()) {
            let fileArray = fs_1.default.readdirSync(file);
            for (let filee of fileArray) {
                filee = file + "/" + filee;
                await this.modifyXmlFile(filee);
            }
        }
        else if (file.endsWith(".xml")) {
            let xmlFilePath = file;
            let fileData = fs_1.default.readFileSync(xmlFilePath, "utf8");
            let xml = new xmldom_1.DOMParser().parseFromString(fileData, "application/xml");
            let elementCollection = xml.getElementsByTagName(this.testcaseTagName);
            for (let i = 0; i < elementCollection.length; i++) {
                let failures = xml.getElementsByTagName(this.testcaseTagName)[i].getElementsByTagName("failure");
                if (failures.length) {
                    let name = xml.getElementsByTagName(this.testcaseTagName)[i].getElementsByTagName("name")[0].childNodes[0].textContent;
                    if (name.includes("@")) {
                        name = name.split("@")[0].trim();
                    }
                    // console.log("name---\n" + name);
                    let scenarioArray = this.jsonArray.filter(x => x[FailureAnalyzer_1.FailureAnalyzer.scenario] === name);
                    if (!scenarioArray.length) {
                        await FailureAnalyzer_1.FailureAnalyzer.addMissingScenarioInFAJson(name, xml, i);
                        await FailureHistory_1.FailureHistory.writeToFailureHistoryJson();
                        this.jsonArray = JSON.parse(fs_1.default.readFileSync(FailureAnalyzer_1.FailureAnalyzer.jsonFilePath, "utf-8"));
                        this.historyJsonObject = JSON.parse(fs_1.default.readFileSync(FailureHistory_1.FailureHistory.historyFilePath, "utf-8"));
                    }
                    for (let j = 0; j < this.jsonArray.length; j++) {
                        const obj = this.jsonArray[j];
                        if (obj[FailureAnalyzer_1.FailureAnalyzer.scenario] === name) {
                            let issue = obj[FailureAnalyzer_1.FailureAnalyzer.issue];
                            if (this.pipelineIssueFlag) {
                                issue = "Pipeline issue";
                            }
                            // else if(await this.isFlakyIssue(obj[FailureAnalyzer.scenario], issue)) {
                            //     issue = "Flaky script issue";
                            // }
                            else {
                                issue = await this.isFlakyIssue(obj[FailureAnalyzer_1.FailureAnalyzer.scenario], issue);
                            }
                            let textContent = xml.getElementsByTagName(this.testcaseTagName)[i].getElementsByTagName("failure")[0].getElementsByTagName("message")[0].textContent;
                            if (textContent) {
                                textContent += "\n- " + issue;
                                // console.log(textContent);
                            }
                            else {
                                textContent = "- " + issue;
                                // console.log(textContent);
                            }
                            xml.getElementsByTagName(this.testcaseTagName)[i].getElementsByTagName("failure")[0].getElementsByTagName("message")[0].textContent = textContent;
                            if (obj[FailureAnalyzer_1.FailureAnalyzer.issue] !== issue) {
                                this.isFaJsonIssueTypeModified = true;
                                this.jsonArray[j][FailureAnalyzer_1.FailureAnalyzer.issue] = issue;
                            }
                            if (obj[FailureAnalyzer_1.FailureAnalyzer.moduleName] === "NA" && obj[FailureAnalyzer_1.FailureAnalyzer.featureName] !== "NA") {
                                this.isFaJsonIssueTypeModified = true;
                                let featureName = obj[FailureAnalyzer_1.FailureAnalyzer.featureName];
                                let featureFilePath = await FailureAnalyzer_1.FailureAnalyzer.getFeatureFilePath(`./src/${process.env.PRODUCT}/features`, featureName);
                                if (featureFilePath)
                                    this.jsonArray[j][FailureAnalyzer_1.FailureAnalyzer.moduleName] = featureFilePath;
                                else
                                    this.jsonArray[j][FailureAnalyzer_1.FailureAnalyzer.moduleName] = featureName;
                            }
                            break;
                        }
                    }
                }
            }
            fileData = new xmldom_1.XMLSerializer().serializeToString(xml);
            fs_1.default.writeFileSync(xmlFilePath, fileData, "utf8");
        }
    }
    static async createCategoriesJsonFile() {
        try {
            console.log("started creating categories.json file");
            let obj = [
                {
                    "name": "Script issue",
                    "matchedStatuses": ["failed"],
                    "messageRegex": ".*Script issue.*"
                },
                {
                    "name": "Performance issue",
                    "matchedStatuses": ["failed"],
                    "messageRegex": ".*Performance issue.*"
                },
                {
                    "name": "Infra issue",
                    "matchedStatuses": ["failed"],
                    "messageRegex": ".*Infra issue.*"
                },
                {
                    "name": "Bug",
                    "matchedStatuses": ["failed"],
                    "messageRegex": ".*Bug.*"
                },
                {
                    "name": "Unhandled alert",
                    "matchedStatuses": ["failed"],
                    "messageRegex": ".*Unhandled alert.*"
                },
                {
                    "name": "Flaky script issue",
                    "matchedStatuses": ["failed"],
                    "messageRegex": ".*Flaky script issue.*"
                },
                {
                    "name": "Pipeline issue",
                    "matchedStatuses": ["failed"],
                    "messageRegex": ".*Pipeline issue.*"
                },
                {
                    "name": "Intermittent issue",
                    "matchedStatuses": ["failed"],
                    "messageRegex": ".*Intermittent issue.*"
                }
            ];
            fs_1.default.writeFileSync(this.outputPath + "/categories.json", JSON.stringify(obj, null, "\t"), "utf8");
            console.log("categories.json file creation completed.");
        }
        catch (error) {
            // console.log("skipping the creation of categories.json file");
            console.log(error);
        }
    }
    static async isFlakyIssue(scenarioName, issueType) {
        let isFlaky = false;
        if (issueType !== "Infra issue" && issueType !== "Performance issue") {
            if (issueType === "Unhandled alert") {
                // isFlaky = true;
                issueType = "Flaky script issue";
            }
            else if (Object.getOwnPropertyNames(this.historyJsonObject).length) {
                let historyArray = this.historyJsonObject[scenarioName]["history"];
                // if(historyArray.length >= this.intermittentFailureThreshold) {
                //     isFlaky = true;
                // }
                if (historyArray.length === 5) {
                    issueType = "Flaky script issue";
                }
                else if (historyArray.length > 0) {
                    issueType = "Intermittent issue";
                }
            }
        }
        // return isFlaky;
        return issueType;
    }
    static async isPipelineIssue() {
        let isPipelineIssue = false;
        if (Object.getOwnPropertyNames(this.jsonArray).length) {
            let infraIssueArray = this.jsonArray.filter(x => x[FailureAnalyzer_1.FailureAnalyzer.issue] === "Infra issue");
            if (infraIssueArray.length === this.jsonArray.length) {
                isPipelineIssue = true;
            }
        }
        return isPipelineIssue;
    }
}
exports.CustomReporterFA = CustomReporterFA;
CustomReporterFA.jsonArray = new Array();
CustomReporterFA.historyJsonObject = {};
CustomReporterFA.consecutiveFailureThreshold = 3;
CustomReporterFA.intermittentFailureThreshold = 2;
CustomReporterFA.pipelineIssueFlag = false;
CustomReporterFA.missingScenarioArray = new Array();
CustomReporterFA.testcaseTagName = "test-case";
CustomReporterFA.outputPath = "./output";
CustomReporterFA.isFaJsonIssueTypeModified = false;
