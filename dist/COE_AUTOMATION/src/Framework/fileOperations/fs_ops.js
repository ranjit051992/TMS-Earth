"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const fs = require('fs');
const Startup_1 = require("../FrameworkUtilities/Startup/Startup");
class fileSystemOperation {
    static async mapTagsToFeature(listOfFiles) {
        console.log("Files under review  ", listOfFiles);
        for (const filepath of listOfFiles) {
            await fs.readFile(filepath, "utf-8", async (err, data) => {
                let data1 = data;
                let regexForScenario = new RegExp(/(Scenario: [A-Z a-z 0-9 \\d \" -]*)/gm);
                let scenarioList = data1.match(regexForScenario);
                if (scenarioList != null) {
                    for (let i = 0; i < scenarioList.length; i++) {
                        let scenarioNameFromFile = scenarioList[i].replace(/Scenario:\s*/gm, '');
                        console.log("Scenario Name from the file under review     === " + scenarioNameFromFile);
                        await fileSystemOperation.getFromJira(data1, scenarioNameFromFile).then(async function (result) {
                            data1 = result;
                            if (i == scenarioList.length - 1) {
                                fs.writeFile(filepath, data1, (err) => {
                                    console.log(data1);
                                    if (err)
                                        console.log(err);
                                    console.log("Successfully Written to File." + filepath);
                                });
                            }
                        });
                    }
                }
            });
        }
    }
    static async getFromJira(data, scenarioName) {
        return new Promise(async function (resolve, reject) {
            if (Startup_1.Startup.finalScenarioLabel_map.has(scenarioName)) {
                let fromFile = scenarioName.replace(/\\/gm, '\\\\');
                console.log(scenarioName, '       @TEST_' + Startup_1.Startup.finalScenarioLabel_map.get(scenarioName));
                var pattern = '(.*((@[a-z A-Z -:_ \d ]*))[\r \n \t .]*)(Scenario: ' + fromFile + ')';
                var regex = new RegExp(pattern, "m");
                let matches = data.search(regex);
                let tagToBeAdded = '@TEST_' + Startup_1.Startup.finalScenarioLabel_map.get(scenarioName) + ' ';
                if (data.match(tagToBeAdded)) {
                    console.log("Tag Already added");
                    resolve(data);
                }
                else {
                    data = [data.slice(0, matches), tagToBeAdded, data.slice(matches)].join('');
                    console.log("Tag is newly added to scenario");
                    resolve(data);
                }
            }
            else {
                console.log("Issue in Scenario:", scenarioName);
                resolve(data);
            }
        });
    }
}
exports.fileSystemOperation = fileSystemOperation;
