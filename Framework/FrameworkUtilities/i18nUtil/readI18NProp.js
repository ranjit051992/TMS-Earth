const logger = require("../Logger/logger");
const fetch = require('node-fetch');
const {I} = inject();
const client = require("../../../Share_data/client");
const databaseOperations = require("../DatabaseOperations/databaseOperations");

class lmt {
    async getLabel(key){
        // console.log((await client.getStepData("mstMap")).has(key))
        if((global.mst_final).has(key)){
            console.log("mst key taken" + (global.mst_final).get(key))
            return (global.mst_final).get(key);
        }else{
            console.log("lmt key taken")
        return global.lmt.get(key).get(global.lang);
        }

        // return (await client.getStepData("mstMap")).get(key);
    }

    // async getLabel(key){
    //     return global.lmt.get(key).get((await client.getStepData("UserLang")).toString());
    //    }

    async getLabelFromKey(label){
        if(global.allkeys.get(label)){
        return this.getLabel(global.allkeys.get(label))
        }
        else{
            logger.info("exception occured as key may not happened")
        }
    }

    async getUserLangCode(){
        return new Promise(async function(resolve, reject){
            await I.getCookie().then(async function(SAAS_TOKEN){
            console.log(SAAS_TOKEN)
            fetch(""+global.testData.get("getDetailsAPI")+"", {
                method: 'GET',
                headers: {
                    'cookie':'SAAS_COMMON_BASE_TOKEN_ID='+ SAAS_TOKEN,
                    'Content-Type': 'application/json'
                },
                })
                .then(async function (response) {
                    console.log(
                    `Response: ${response.status} ${response.statusText}`
                    );
                    return response.json();
                })
                .then(async function(json) { 
                    await client.setStepData("UserLang",json.langCode);
                    // console.log(json.langCode)
                    resolve(json.langCode)
            })
                .catch(err => console.error(err));
    })
})
}

    async get_USER_MST_keys(){
        // let langCode = await this.getUserLangCode();
        // console.log(langCode);
        let MST_USER;
       return await this.getUserLangCode().then(async function(userLang){
            console.log("User Language " + userLang)
            return new Promise(async function(resolve, reject){
                fetch(global.testData.get("languageAPI")+userLang+'.json', {
                    method: 'GET'
                })
                .then(async function(response){
                console.log(
                    `Response: ${response.status} ${response.statusText}`
                    );
                    return response.json();
                })
                .then(async function(json){
                MST_USER = json;
                resolve(MST_USER);
                });
            })
        })
    }

    async matchKeys(){
        let AutoToMstValue = new Map();
        return await this.get_USER_MST_keys().then(async function(MST_user){
                    global.automationLMT_Pair.forEach(async function(val, key){
                        if(val != undefined){
                        AutoToMstValue.set(key, MST_user[val]);
                        }
                    })
                    return AutoToMstValue;
             })
            }
}

module.exports= new lmt;