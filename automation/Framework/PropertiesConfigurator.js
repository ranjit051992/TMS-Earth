function readProperties()
{
 
let PropertiesReader = require('properties-reader');
let prop = PropertiesReader('./Resources/config.properties');
console.log( prop.getAllProperties())
//return prop.getAllProperties();
}
module.exports=readProperties();