function parseJson() {
  var PRODUCT =process.env.PRODUCT;
  var fs = require('fs');
  var data = fs.readFileSync("./Resources/config.json", "utf8");
  var obj = JSON.parse(data);

  Object.keys(obj).forEach(function (productName) {
    console.log(productName, ' ----',PRODUCT );
      if (productName === 'DD_Homes') {
          console.log("adding config data for :  " + PRODUCT)
          LMTMap = obj[productName];
          global.confi_prop=LMTMap;
      }
  })
}

module.exports =parseJson;




