//to include module: use the require() function with the name of the module 
//var XLSX = require('xlsx')
var excel = require("./readExcel/ReadExcel")
describe("Read Excel data", function(){
    var testData = excel.readExcelData("./TestData.xlsx", "Sheet1");
    console.log(testData);
    console.log("Reading and Printing Excel Data");
    testData.forEach(function(data) {
        
        console.log("UserNames are "+data.userName+ " "+"Passwords are "+data.password);
        
    });

    
})


