"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const fetch = require("node-fetch");
var request = require('request');
class Jiralogger {
    static async logJira(ScenarioName, FeatureName, errorStack, flag) {
        return new Promise(async function (resolve, reject) {
            if (flag) {
                const bodyData = `{
    "fields": {
       "project":
       {
          "key": "TSTNG"
       },
       "summary": "` + ScenarioName + ` SCENARIO has failed from FEATURE ` + FeatureName + `",
        "assignee": { "id": "5ca5be5f9a000c1180956a33" },
        "issuetype": {
            "name": "Bug"
        }
   }
} `;
                fetch('https://pdtzycus.atlassian.net/rest/api/2/issue', {
                    method: 'POST',
                    headers: {
                        'Authorization': `Basic SklSQS1ib3R1c2VyQHp5Y3VzLmNvbTpRbnhXTVRKd0pQc0Q4aGpNMFdoVjlENTM=`,
                        'Accept': 'application/json',
                        'Content-Type': 'application/json'
                    },
                    body: bodyData
                })
                    .then(async function (response) {
                    console.log(`Response: ${response.status} ${response.statusText}`);
                    return response.json();
                })
                    .then(async function (text) {
                    resolve(text);
                })
                    .catch(async function (err) {
                    reject(err);
                });
            }
            else {
                resolve(true);
            }
        });
    }
    static async updateIssueLink(testExecutionTicket) {
        if (process.env.storyNo) {
            return new Promise(async (resolve, reject) => {
                var options = {
                    'method': 'PUT',
                    'url': 'https://pdtzycus.atlassian.net/rest/api/2/issue/' + testExecutionTicket,
                    'headers': {
                        'Content-Type': 'application/json',
                        'Authorization': 'Basic SklSQS1ib3R1c2VyQHp5Y3VzLmNvbTpRbnhXTVRKd0pQc0Q4aGpNMFdoVjlENTM='
                    },
                    body: JSON.stringify({ "update": { "issuelinks": [{ "add": { "type": { "name": "Covers", "inward": "is covered by", "outward": "covers" }, "outwardIssue": { "key": process.env.storyNo } } }] } })
                };
                console.log(testExecutionTicket);
                request(options, function (error, response) {
                    if (error)
                        reject(new Error(error));
                    resolve(response);
                });
            });
        }
    }
    static async updateFilter(UserStoryKey) {
        var options = {
            'method': 'PUT',
            'url': 'https://pdtzycus.atlassian.net/rest/api/3/filter/50855',
            'headers': {
                'Accept': 'application/json',
                'Content-Type': 'application/json',
                'Authorization': 'Basic SklSQS1ib3R1c2VyQHp5Y3VzLmNvbTpRbnhXTVRKd0pQc0Q4aGpNMFdoVjlENTM='
            },
            body: JSON.stringify({ "jql": "issuetype = 'Xray Test' AND labels in (" + UserStoryKey + ")", "name": "updateLinkedIssue", "description": "Lists all the xray tests having labelas the userstory ID" })
        };
        request(options, function (error, response) {
            if (error)
                throw new Error(error);
            console.log(response.body);
        });
    }
    static async getModifiedFilterResult() {
        return new Promise(async (resolve, reject) => {
            var options = {
                'method': 'GET',
                'url': 'https://pdtzycus.atlassian.net/rest/api/3/search?jql=filter=50855',
                'headers': {
                    'Accept': 'application/json',
                    'Authorization': 'Basic SklSQS1ib3R1c2VyQHp5Y3VzLmNvbTpRbnhXTVRKd0pQc0Q4aGpNMFdoVjlENTM='
                }
            };
            request(options, async function (error, response) {
                if (error)
                    throw new Error(error);
                resolve((JSON.parse(response.body))["issues"]);
            });
        });
    }
    static async updateissue(storyNumber) {
        await Jiralogger.updateFilter(storyNumber);
        await Jiralogger.getModifiedFilterResult().then(async function (listOfIssue) {
            console.log("===================");
            for (let i = 0; i < listOfIssue.length; i++) {
                var options = {
                    'method': 'PUT',
                    'url': 'https://pdtzycus.atlassian.net/rest/api/2/issue/' + (listOfIssue[i])["key"],
                    'headers': {
                        'Accept': 'application/json',
                        'Content-Type': 'application/json',
                        'Authorization': 'Basic SklSQS1ib3R1c2VyQHp5Y3VzLmNvbTpRbnhXTVRKd0pQc0Q4aGpNMFdoVjlENTM=',
                    }, body: JSON.stringify({ "update": { "issuelinks": [{ "add": { "type": { "name": "Test", "inward": "is tested by", "outward": "Tests" }, "outwardIssue": { "key": storyNumber } } }] } })
                };
                request(options, function (error, response) {
                    if (error)
                        throw new Error(error);
                    console.log(response.body);
                });
            }
        });
    }
}
exports.Jiralogger = Jiralogger;
