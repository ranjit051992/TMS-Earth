
// function readLangFile(){
// let PropertiesReader = require('properties-reader');
// const prop=require('./Framework/PropertiesConfigurator');
// global.lang = await I.grabAttributeFrom('//html', 'lang');
// console.log(global.lang);
// let filePath = './Resources/LMT/'+ prop.product +'/'+ global.lang + '/messages.properties';
// let prop = PropertiesReader(filePath);
// global.langValues = prop.getAllProperties();
// return prop.getAllProperties();
// }
class lmt {
    getLabel(key){
        return global.lmt.get(key).get(global.lang);
       }    
}


module.exports = new lmt;