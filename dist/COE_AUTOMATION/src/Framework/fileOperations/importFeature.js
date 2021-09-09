"use strict";
var __importDefault = (this && this.__importDefault) || function (mod) {
    return (mod && mod.__esModule) ? mod : { "default": mod };
};
Object.defineProperty(exports, "__esModule", { value: true });
var FormData = require('form-data');
const fs_1 = __importDefault(require("fs"));
const path = require('path');
const axios = require('axios');
const fs_ops_1 = require("./fs_ops");
const xray_ImportFeature_Request_1 = require("../Xray_Api/xray_ImportFeature_Request");
const Startup_1 = require("../FrameworkUtilities/Startup/Startup");
const productProp = require("../../../../../dist/Framework/FrameworkUtilities/config").prop;
let filesList = new Array();
/*compressed folder*/
class fileSystemOperationImport {
    static async importFeature(projectKey, productName, filePath, sprintName, sprintBoardId, releaseTrain) {
        await xray_ImportFeature_Request_1.xray_ImportCucumberApiRequest.generateAuthToken().then(async function (authToken) {
            const fileList = getListOfFile(filePath);
            console.log("List of feature files:", fileList);
            for (const files of fileList) {
                await updateSpecialCharaterInScenario(files);
                let featureFileContent = fs_1.default.readFileSync(files, "utf-8");
                // let storyNo = "";
                var data = new FormData();
                data.append('file', fs_1.default.createReadStream(files));
                let finalToken = 'Bearer ' + authToken.replace(/(\")/gm, "");
                var options = {
                    method: 'post',
                    timeout: 1000 * 60,
                    url: 'https://xray.cloud.xpand-it.com/api/v1/import/feature?projectKey=' + projectKey,
                    headers: {
                        'Content-Type': 'multipart/form-data',
                        'Authorization': finalToken,
                        ...data.getHeaders()
                    },
                    data: data
                };
                console.log("Doing POST request for:", files);
                await axios(options).then(async function (response) {
                    if (response.status != 202) {
                        if (response.data.errors.length > 0) {
                            console.log("Error in File:", response.data.errors);
                        }
                        let jiraID = response.data;
                        for (const sample of jiraID["updatedOrCreatedTests"]) {
                            console.log("Test case id under update -->", sample["key"]);
                            var options = {
                                'method': 'GET',
                                'url': 'https://pdtzycus.atlassian.net/rest/api/3/issue/' + sample["key"],
                                'headers': {
                                    'Authorization': 'Basic SklSQS1ib3R1c2VyQHp5Y3VzLmNvbTpRbnhXTVRKd0pQc0Q4aGpNMFdoVjlENTM='
                                }
                            };
                            await axios(options).then(async function (response) {
                                let userStoryKey = "";
                                let linkedIssues = response.data["fields"]["issuelinks"];
                                for (const link of linkedIssues) {
                                    if (link["type"]["name"] == "Test") {
                                        userStoryKey = userStoryKey + link["outwardIssue"]["key"];
                                        // if(sprintName && featureFileContent.includes(`@REQ_${link["outwardIssue"]["key"]}`)) {
                                        //     storyNo = link["outwardIssue"]["key"];
                                        //     console.log("Sprint to be fetched for story --> " + storyNo);
                                        // }
                                    }
                                }
                                console.log("User story key for above issue --> ", userStoryKey);
                                if (userStoryKey != undefined) {
                                    let jsonRequestBody = {
                                        "update": {},
                                        "fields": {
                                            "customfield_10128": {
                                                "value": productName
                                            },
                                            "customfield_19004": userStoryKey
                                        }
                                    };
                                    if (sprintName) {
                                        let sprintId = await getSprintId(sprintName, sprintBoardId);
                                        console.log(`Sprint id fetched --> ${sprintId}`);
                                        jsonRequestBody["fields"]["customfield_10007"] = sprintId;
                                    }
                                    if (releaseTrain) {
                                        let releaseTrainFieldValue = {
                                            "value": releaseTrain
                                        };
                                        jsonRequestBody["fields"]["customfield_25064"] = releaseTrainFieldValue;
                                    }
                                    let options = {
                                        'method': 'PUT',
                                        'url': 'https://pdtzycus.atlassian.net/rest/api/3/issue/' + sample["key"],
                                        'headers': {
                                            'Accept': 'application/json',
                                            'Content-Type': 'application/json',
                                            'Authorization': 'Basic SklSQS1ib3R1c2VyQHp5Y3VzLmNvbTpRbnhXTVRKd0pQc0Q4aGpNMFdoVjlENTM=',
                                        },
                                        data: JSON.stringify(jsonRequestBody)
                                    };
                                    await axios(options).then(async function (response1) {
                                        var scenarioName = response.data["fields"]["summary"];
                                        console.log("Updated the product and user story key for xray test id ", sample["key"], "against scenario :", scenarioName);
                                        Startup_1.Startup.finalScenarioLabel_map.set(scenarioName, sample["key"]);
                                    }).catch((error) => {
                                        console.log("Error while updating test case id fields\n" + error.response.data);
                                        throw new Error(error);
                                    });
                                }
                            }).catch((error) => {
                                console.log("Error while fetching test case id details\n" + error.response.data);
                                throw new Error(error);
                            });
                        }
                    }
                    else {
                        throw new Error("Issue In " + files + ":" + response.data.error);
                    }
                }).catch((error) => {
                    console.log("Error while hitting xray feature upload api\n" + error.response.data);
                    throw new Error(error);
                });
                console.log("************End Of Feature File:" + files + "************");
            }
            await fs_ops_1.fileSystemOperation.mapTagsToFeature(fileList);
        });
    }
}
exports.fileSystemOperationImport = fileSystemOperationImport;
async function updateSpecialCharaterInScenario(filepath) {
    await fs_1.default.readFile(filepath, "utf-8", async (err, data) => {
        let data1 = data.split(' ').join(' ');
        let regexForScenario = new RegExp(/(Scenario: [A-Z a-z \\d \" -]*)/gm);
        let scenarioList = data1.match(regexForScenario);
        if (scenarioList != null) {
            for (let i = 0; i < scenarioList.length; i++) {
                await replaceSpecialCharacters(data1, scenarioList[i]).then(async function (result) {
                    data1 = result;
                    if (i == scenarioList.length - 1) {
                        await fs_1.default.writeFile(filepath, data1, (err) => {
                            if (err)
                                console.log(err);
                            console.log("Successfully Written to File after making changes to the special characters in a file:" + filepath);
                        });
                    }
                });
            }
        }
    });
}
async function replaceSpecialCharacters(data, orgScenario) {
    if (orgScenario.match(/"/gm) != null && orgScenario.match(/\\"/gm) == null) {
        let updatedScenario = orgScenario.replace(/"/gm, '\\"');
        return data.replace(orgScenario, updatedScenario);
    }
    else {
        return data;
    }
}
function getListOfFile(directorypath) {
    fs_1.default.readdirSync(directorypath).forEach((fileName) => {
        const Absolute = path.join(directorypath, fileName);
        if (fs_1.default.statSync(Absolute).isDirectory())
            getListOfFile(Absolute);
        else
            filesList.push(Absolute);
    });
    return filesList;
}
async function getSprintId(sprintName, boardId) {
    let options = {
        'method': 'GET',
        'url': `https://pdtzycus.atlassian.net/rest/agile/1.0/board/${boardId}/sprint`,
        'headers': {
            'Authorization': 'Basic SklSQS1ib3R1c2VyQHp5Y3VzLmNvbTpRbnhXTVRKd0pQc0Q4aGpNMFdoVjlENTM='
        }
    };
    return await axios(options).then(async function (response) {
        let sprintArray = response.data["values"];
        let arr = sprintArray.filter(value => value["name"] === sprintName);
        if (!arr.length) {
            throw new Error(`Sprint "${sprintName}" not found under dashboard "${boardId}"`);
        }
        return arr[0]["id"];
    }).catch((error) => {
        console.log("Error while fetching sprint id\n" + error);
        throw new Error(error);
    });
}
console.log(`Sprint --> ${productProp.sprintName}`);
console.log(`Sprint board id --> ${productProp.sprintBoardId}`);
console.log(`Release train --> ${productProp.releaseTrain}`);
if (productProp.sprintName && !productProp.sprintBoardId) {
    throw new Error("Sprint board id parameter is undefined.\nPlease add 'sprintBoardId' key and value in config.ts file of parent repo");
}
fileSystemOperationImport.importFeature(productProp.productKey, productProp.productName, productProp.xrayFeatureFilePath, productProp.sprintName, productProp.sprintBoardId, productProp.releaseTrain);
