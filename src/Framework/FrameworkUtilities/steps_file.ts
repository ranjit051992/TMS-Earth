// in this file you can append custom step methods to 'I' object
// const { I } = inject();
// var randomstring = require("randomstring");
// const logger = require("./Framework/FrameworkUtilities/Logger/logger");
// module.exports = function () {
//   return actor({

//     // Define custom steps here, use 'this' to access default methods of I.
//     // It is recommended to place a general 'login' function here.
//     getRandomText(length) {
//       const I = this;
//       return randomstring.generate(length);
//     },

//     getElement(elementKey) {
//       const I = this;
//       const element = global.uiElements.get(elementKey);
//       return element;
//     },

//     getData(key) {
//       logger.info("############### key passed " + key);
//       const I = this;
//       var value;
//       var index = 0;
//       if (key.includes("[") && key.includes("]")) {
//         let startindex = key.indexOf("[");
//         let endtindex = key.indexOf("]");
//         index = key.substring(startindex + 1, endtindex);
//         key = key.substring(0, startindex);
//       }
//       else {
//         logger.info("warning : no index in key so it will return 0 index value");
//       }
      
//       let mapValue = global.testData.get(key);
//       if (typeof mapValue == 'undefined') {
//         logger.info("Error : Getting null from testData for given field : " + key);
//       }
//       else {
//         let arrayVal = mapValue.split("||");
//         if (index < arrayVal.length) {
//           value = arrayVal[index];
//         }
//         else {
//           logger.info("warning : index is greater then size returning 0 index value");
//           value = arrayVal[0];
//         }
//       }
//       logger.info("############### value returning " + value);
//       return value;
//     }


//   });
// }
