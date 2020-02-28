
// function readLangFile(){
// let PropertiesReader = require('properties-reader');
// const prop=global.confi_prop;
// global.lang = await I.grabAttributeFrom('//html', 'lang');
// console.log(global.lang);
// let filePath = './Resources/LMT/'+ prop.product +'/'+ global.lang + '/messages.properties';
// let prop = PropertiesReader(filePath);
// global.langValues = prop.getAllProperties();
// return prop.getAllProperties();
// }
const logger = require("../Logger/logger");

class lmt {
    getLabel(key){
        return global.lmt.get(key).get(global.lang);
       }


       getLabelFromKey(label){
           if(global.allkeys.get(label)){
           return this.getLabel(global.allkeys.get(label))
           }
           else{
               logger.info("exception occured as key may not happened")
           }
       }
}


module.exports = new lmt;