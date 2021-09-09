
import { logger } from "../Logger/logger";
import { Startup } from "../Startup/Startup";
import { z } from "actionbot-wrapper/z";
//import { setStepData } from "../Share_data/client.js";
const fetch = require("node-fetch");
const { I } = inject();

export class TMSLmt {

    static async getElement(elementKey) {
                        const I = this;
                        const element = Startup.uiElements.get(elementKey) as string;
                        return element;
                      } 

        static async getData(key) {
            const I = this;
            const Value = Startup.testData.get(key) as string;
            return Value;

            //const I = this;
            //var value;
            // var index = 0;
            // if (key.includes("[") && key.includes("]")) {
            //   let startindex = key.indexOf("[");
            //   let endtindex = key.indexOf("]");
            //   index = key.substring(startindex + 1, endtindex);
            //   key = key.substring(0, startindex);
            // }
            // else {
            //   logger.info("warning : no index in key so it will return 0 index value");
            // }
      
            //let mapValue = Startup.testData.get(key) as string;
            // if (typeof mapValue == 'undefined') {
            //   logger.info("Error : Getting null from testData for given field : " + key);
            // }
            // else {
            //   let arrayVal = mapValue.split("||");
            //   if (index < arrayVal.length) {
            //     value = arrayVal[index];
            //   }
            //   else {
            //     logger.info("warning : index is greater then size returning 0 index value");
            //     value = arrayVal[0];
            //   }
            // }
            //return value;
          }

    static async getLabel(key: string) {
        // console.log((await client.getStepData("mstMap")).has(key))
        if ((Startup.mst_final).has(key)) {
            console.log("mst key taken" + (Startup.mst_final).get(key))
            let val=(Startup.mst_final).get(key);
            return val;
        } else {
            console.log("lmt key taken")
            let map = Startup.lmt.get(key) as Map<string, string>;
            return map.get(Startup.lang);
        }
        
        // return (await client.getStepData("mstMap")).get(key);
    }

    // async getLabel(key){
    //     return Startup.lmt.get(key).get((await client.getStepData("UserLang")).toString());
    //    }
    
    static getLabelFromKey(label: string) {
        if (Startup.allkeys.get(label)) {
            return this.getLabel(Startup.allkeys.get(label) as string);
        }
        else {
            logger.info("exception occured as key may not happened")
        }
    }

    static async getUserLangCode(): Promise<any> {
        return new Promise(async function (resolve, reject) {
            await I.getCookie().then(async function (SAAS_TOKEN: string) {
                console.log(SAAS_TOKEN)
                fetch("" + Startup.testData.get("getDetailsAPI") + "", {
                    method: 'GET',
                    headers: {
                        'cookie': 'SAAS_COMMON_BASE_TOKEN_ID=' + SAAS_TOKEN,
                        'Content-Type': 'application/json'
                    },
                })
                .then(async function (response: Response) {
                    console.log(
                        `Response: ${response.status} ${response.statusText}`
                    );
                    return response.json();
                })
                .then(async function (json: any) {
                    // await setStepData("UserLang", json.langCode);
                    // console.log(json.langCode)
                    resolve(json.langCode)
                })
                .catch((err: Error) => console.error(err));
            })
        })
    }


    static async get_USER_MST_keys() {
        // let langCode = await this.getUserLangCode();
        // console.log(langCode);
        let MST_USER;
        return await this.getUserLangCode().then(function(userLang: string) {
            console.log("User Language " + userLang)
            return new Promise(async function (resolve, reject) {
                fetch(Startup.testData.get("languageAPI") + userLang + '.json', {
                    method: 'GET'
                })
                .then(async function (response: Response) {
                    console.log(
                        `Response: ${response.status} ${response.statusText}`
                    );
                    return response.json();
                })
                .then(async function (json: any) {
                    MST_USER = json;
                    resolve(MST_USER);
                });
            })
        })
    }

    static async matchKeys() {
        let AutoToMstValue = new Map();
        return await this.get_USER_MST_keys().then(async function (MST_user: any) {
            Startup.automationLMT_Pair.forEach(async function (val: string, key: string) {
                if (val != undefined) {
                    AutoToMstValue.set(key, MST_user[val]);
                }
            })
            return AutoToMstValue;
        })
    }
}