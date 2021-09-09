
const fetch = require("node-fetch");

var request = require('request');
export class Jiralogger {

  static async logJira(ScenarioName: string, FeatureName: string, errorStack: string, flag: boolean) {
    return new Promise(async function (resolve, reject) {
      if (flag) {
        const bodyData = `{
    "fields": {
       "project":
       {
          "key": "TMS"
       },
       "summary": "`+ ScenarioName + ` SCENARIO has failed from FEATURE ` + FeatureName + `",
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
          .then(async function (response: any) {
            console.log(
              `Response: ${response.status} ${response.statusText}`
            );
            return response.json();
          })
          .then(async function (text: any) {
            resolve(text)
          })
          .catch(async function (err: any) {
            reject(err)
          });
      }
      else {
        resolve()
      }
    });
  }

  static async updateIssueLink(testExecutionTicket: any) {
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
        console.log(testExecutionTicket)
        request(options, function (error: any, response: any) {
          if (error) reject(new Error(error));
          resolve(response)
        });
      })
    }
  }


  static async updateFilter(UserStoryKey: string) {
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
    request(options, function (error: any, response: any) {
      if (error) throw new Error(error);
      console.log(response.body);
    });

  }

  static async getModifiedFilterResult() {
    return new Promise(async (resolve: any, reject: any) => {
      var options = {
        'method': 'GET',
        'url': 'https://pdtzycus.atlassian.net/rest/api/3/search?jql=filter=50855',
        'headers': {
          'Accept': 'application/json',
          'Authorization': 'Basic SklSQS1ib3R1c2VyQHp5Y3VzLmNvbTpRbnhXTVRKd0pQc0Q4aGpNMFdoVjlENTM='
        }
      };
      request(options, async function (error: any, response: any) {
        if (error) throw new Error(error);
        resolve((JSON.parse(response.body))["issues"])
      });
    })
  }

  static async updateissue(storyNumber: string) {
    await Jiralogger.updateFilter(storyNumber);
    await Jiralogger.getModifiedFilterResult().then(async function (listOfIssue: any) {
      console.log("===================")
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
        request(options, function (error: any, response: any) {
          if (error) throw new Error(error);
          console.log(response.body);
        });
      }
    })
  }
}

