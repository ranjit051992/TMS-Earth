function parseJson(PRODUCT) {
  var fs = require('fs');
  var data = fs.readFileSync("./Resources/config.json", "utf8");
  var obj = JSON.parse(data);

  Object.keys(obj).forEach(function (productName) {
      if (productName === PRODUCT) {
          console.log("adding config data for :  " + PRODUCT)
          LMTMap = obj[productName];
          global.confi_prop=LMTMap;
      }
  })
}

module.exports =parseJson;




