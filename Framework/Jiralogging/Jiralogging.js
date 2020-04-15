// This code sample uses the 'node-fetch' library:
// https://www.npmjs.com/package/node-fetch
const fetch = require('node-fetch');
const assigneeMap = {
  "iSource": "rushabh.shah",
  "iContract":"liji.vadassery",
  "iAnalyze":"archana.maheshwari",
  "iSave":"liji.vadassery",
  "iManage":"liji.vadassery",
  "iPerform":"",
  "eProc":"mahesh.chikane",
  "CRMS" : "archana.maheshwari",
  "SIM" : "srinivasa.jyothi",
  "iRequest" : "",
  "eInvoice" : "ram.samal"
  }
// const {I} = inject();
// let desc = `element not interactable\n(Session info: chrome=74.0.3729.108)\n(Driver info: chromedriver=2.43.600210\n(68dcf5eebde37173d4027fa8635e332711d2874a),platform=Windows NT 10.0.15063 x86_64)\nScenario Steps:\n I.click(\"//label[contains(text(),'Test Event')]\") at CreateEventFlow.checkTestEvent\n  at Object.onceWrapper (events.js:421:28)`
async function logJira(ScenarioName, FeatureName , errorStack){
    // if(true){
const bodyData = `{
    "fields": {
       "project":
       {
          "key": "DDS"
       },
       "summary": "`+ScenarioName+` SCENARIO has failed from FEATURE `+FeatureName+`",
       "components":[{"name": "`+process.env.PRODUCT_COMPONENT+`"}],
       "assignee": {"name": "`+process.env.ASSIGNEE || assigneeMap[process.env.PRODUCT]+`"},
       "description": "`+((errorStack.replace(/\\/g,"\\\\")).replace(/\"/g, "\\\"")).replace(/\n/g,"")+`",
       "issuetype": {
          "name": "Bug"
       },
       "customfield_10128": { "value": "`+process.env.PRODUCT+`" },
       "customfield_15709": { "value": "`+process.env.PRIORITY+`" },
       "customfield_15606": { "value": "`+process.env.SEVERITY+`" },
       "customfield_16203": { "value": "Yes" }
   }
} `;

fetch('https://pdtzycus.atlassian.net/rest/api/2/issue', {
  method: 'POST',
  headers: {
    // 'Authorization': `Basic cnVzaGFiaC5zaGFoQHp5Y3VzLmNvbTowYlVhMGNJN3oxR3h2SlR5V0ZqTEM1NDA`,
    'Authorization': `Basic SklSQS1ib3R1c2VyQHp5Y3VzLmNvbTpRbnhXTVRKd0pQc0Q4aGpNMFdoVjlENTM=`,
    'Accept': 'application/json',
    'Content-Type': 'application/json'
  },
  body: bodyData
})
  .then(response => {
    console.log(
      `Response: ${response.status} ${response.statusText}`
    );
    return response.text();
  })
  .then(text => console.log(text))
  .catch(err => console.error(err));

}
module.exports = {logJira};