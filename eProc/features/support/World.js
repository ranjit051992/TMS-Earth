const objectCreation = require("../../dataCreation/ObjectCreation")



var World = function World(callback) {

    this.spo = undefined;
    this.getSpoObject = function(noOfItem,itemType) {
        return objectCreation.getObjectOfStandardPO(noOfItem,itemType);
      };

      
      callback();

  };
  
  module.exports.World = World;