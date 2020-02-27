  function readProperties() {
    let PropertiesReader = require('properties-reader');
    let prop = PropertiesReader('./Resources/config.properties');
    return prop.getAllProperties();
}

  function parseJson() {
    var props = readProperties();
    var fs = require('fs');
    var data = fs.readFileSync("./Resources/config.json", "utf8");
    var obj = JSON.parse(data);

    Object.keys(obj).forEach(function (productName) {
        if (productName === props.PRODUCT) {
            console.log("adding config data for :  " + props.PRODUCT)
            LMTMap = obj[productName];
            global.confi_prop=LMTMap;
        }
    })
}

module.exports =parseJson();




