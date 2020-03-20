function parseJson() {
  var PRODUCT = process.env.PRODUCT;
  var fs = require('fs');
  var data = fs.readFileSync("./Resources/config.json", "utf8");
  var obj = JSON.parse(data);
  let testDataMap = new Map();

  Object.keys(obj).forEach(function (productName) {
    if (productName === PRODUCT) {
      console.log("adding config data for :  " + PRODUCT)
      let LMTMap = obj[productName];
      global.confi_prop = LMTMap;
      
    }
  })

  for(let i=0;i<Object.entries(global.confi_prop).length;i++)
  {
   testDataMap.set(Object.entries(global.confi_prop)[i][0],Object.entries(global.confi_prop)[i][1]);
  }
  global.configmap=testDataMap; 

}

module.exports = parseJson;




