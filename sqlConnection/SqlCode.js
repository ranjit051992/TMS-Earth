const express = require('express');
const mysql = require('mysql');

class SqlConnection {
    
    sqlConnection(sqlQuery) {
        var credentialsMap = new Map();

        var connection = mysql.createConnection({
            host: "192.168.5.221",
            user: "katalonteam",
            password: "team@123",
            database: "katalon_repo",
        });

        connection.connect(function(error) {
            if(!!error) {
                console.log("Error");
            }
            else {
                console.log("Connected");
            }
        });

        connection.query(sqlQuery, function(error, rows, fields) {
            if(!!error) {
                console.log("Error in the query");
            }
            else {
                console.log("SUCCESS!");
                credentialsMap.set(rows[0].USERNAME, rows[0].PASSWORD);
                // rows.forEach(function(value){
                //     credentialsMap.set(value.USERNAME, value.PASSWORD);
                //     console.log(value.USERNAME, value.PASSWORD);
                // });
            }
        });

        connection.destroy();

        return credentialsMap;
    }
}

module.exports = new SqlConnection;