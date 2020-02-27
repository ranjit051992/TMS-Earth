// in this file you can append custom step methods to 'I' object
const{I} = inject();
var randomstring = require("randomstring");
module.exports = function() {
  return actor({

    // Define custom steps here, use 'this' to access default methods of I.
    // It is recommended to place a general 'login' function here.
    getRandomText(length){
      const I = this;
      return randomstring.generate(length);
    }
  });
}
