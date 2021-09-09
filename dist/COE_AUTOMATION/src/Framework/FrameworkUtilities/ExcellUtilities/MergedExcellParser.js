"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var XLSX = require('xlsx');
class ParseMergedExcell {
    /*This class contains methods relate dto merged excell sheet */
    /**
     *
     * @param filePath path of the file which we want to process
     * @param sheetName sheetname of excell
     * @param rowNumber row number from excell from which we want cell values or data
     * @returns dataArray(array which contains all values from specified row)
     */
    static async readSpecificRow(filePath, sheetName, rowNumber) {
        let dataArray = new Array();
        var workbook = await XLSX.readFile(filePath);
        var worksheet = workbook.Sheets[sheetName];
        let array = Object.getOwnPropertyNames(worksheet);
        for (const iterator of array) {
            if (iterator.includes(rowNumber.valueOf())) {
                console.log(worksheet[iterator].v);
                dataArray.push(worksheet[iterator].v);
            }
        }
        return dataArray;
    }
    /**
     *
     * @param filePath path of the file which we want to process
     * @param sheetName sheetname of excell
     * @param columnName column identifier(A,B) from excell from which we want cell values or data
     *  @returns dataArray(array which contains all values from specified column)
     */
    static async readSpecificColumn(filePath, sheetName, columnName) {
        let dataArray = new Array();
        var workbook = await XLSX.readFile(filePath);
        var worksheet = workbook.Sheets[sheetName];
        let array = Object.getOwnPropertyNames(worksheet);
        for (const iterator of array) {
            if (iterator.includes(columnName)) {
                console.log(worksheet[iterator].v);
                dataArray.push(worksheet[iterator].v);
            }
        }
        return dataArray;
    }
}
exports.ParseMergedExcell = ParseMergedExcell;
