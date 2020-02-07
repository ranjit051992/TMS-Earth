//to include module: use the require() function with the name of the module 
var XLSX = require('xlsx');

class ExcelReader
{
    readExcelData(filePath, sheetName)
    {
        var workbook = XLSX.readFile(filePath);
        var worksheet = workbook.Sheets[sheetName];
        return XLSX.utils.sheet_to_json(worksheet);
    }
}

module.exports = new ExcelReader();