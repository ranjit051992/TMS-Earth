let fs = require('fs');
let myArgs = process.argv.slice(2);
//let writeStream = fs.createWriteStream("ruleViolate.xls");
let async = require('async');
var Excel = require('exceljs');
var options = {
    filename: './lintRules.xlsx',
    useStyles: true,
    useSharedStrings: true
};

var workbook = new Excel.stream.xlsx.WorkbookWriter(options);
var worksheet2 = workbook.addWorksheet('Data');
var worksheet = workbook.addWorksheet('Detail');
worksheet.columns = [
    { header: 'File', key: 'File', width: 100 },
    { header: 'Rule', key: 'Rule', width: 32 },
    { header: 'Description.', key: 'Message', width: 120 },
    { header: 'Line.', key: 'Line', width: 10 }
];
worksheet2.columns = [
    { header: 'Rule', key: 'Rule', width: 80 },
    { header: 'Description', key: 'Message', width: 90 },
    { header: 'Number Of Times Violated', key: 'NumberOfTimesViolated', width: 30 },
    { header: 'Threshold', key: 'Threshold', width: 10 },
    { header: 'Weightage', key: 'Weightage', width: 25 },
    { header: 'Achieved Score', key: 'AchievedLintScore', width: 20 }
];
//worksheet.addRow({File: 1, Rule: 'John Doe', Message: new Date(1970,1,1),Line:22});

//var weightageperRule = JSON.parse((fs.readFileSync("rules.json")))
var weightageperRuleSheet = JSON.parse((fs.readFileSync("rules.json")))
weightageperRule = weightageperRuleSheet[process.env.PRODUCT]

function gherkinlintrules(callback) {

    fs.readFile(process.argv[2], 'utf-8', function (err, res) {
        // var rulesMap = new Map();
        let errArray = []
        let fileArray = []
        let rulesArr = []
        if (res) {
            const object = JSON.parse(res.toString("utf-8"))

            // writeStream.write(header);

            for (i in object) {

                if (object[i].errors.length > 0) {

                    for (m in object[i].errors) {
                        // console.log(object[i].errors[m])
                        // console.log(object[i].filePath)
                        rulesArr.push(object[i].errors[m].rule)
                        fileArray.push(object[i].filePath)
                        errArray.push(object[i].errors[m])
                        //writeStream.write(object[i].filePath + "\t" + object[i].errors[m].rule + "\t" + object[i].errors[m].message + "\t" + object[i].errors[m].line + "\n");
                        // writeStream.write(" 29" + "\t" + "bob" + "\n");
                        worksheet.addRow({ File: object[i].filePath, Rule: object[i].errors[m].rule, Message: object[i].errors[m].message, Line: object[i].errors[m].line });
                    }


                }
            }

            // worksheet.commit();
            callback(null, rulesArr)
        }

        else {
            console.log(err)
            callback(err, null)
        }
        // callback(null,rulesArr)

    })
}

function eslintrules(rulesArr, callback) {


    fs.readFile(process.argv[3], 'utf-8', function (err, res) {
        if (res) {
            const object = JSON.parse(res.toString("utf-8"))

            for (i in object) {
                if (object[i].messages.length > 0) {
                    for (rules in object[i].messages) {
                        rulesArr.push(object[i].messages[rules].ruleId)
                        //writeStream.write(object[i].filePath + "\t" + object[i].messages[rules].ruleId + "\t" + object[i].messages[rules].message + "\t" + object[i].messages[rules].line + "\n");
                        worksheet.addRow({ File: object[i].filePath, Rule: object[i].messages[rules].ruleId, Message: object[i].messages[rules].message, Line: object[i].messages[rules].line });

                    }
                }

            }
            worksheet.commit();

            //console.log(arg)
            callback(null, rulesArr)
        }

        else {
            console.log(err)
            //callback(err,null)
        }
        // callback(null,rulesArr)

    })



}



function countOfRules(array_elements, callback) {
    // console.log(array_elements)
    var JSONObjofFiringRules = {};
    let FiringRules = []
    array_elements.sort();
    //console.log(array_elements)
    var current = null;
    var cnt = 0;
    global.globalString = "This can be accessed anywhere!";
    for (var i = 0; i <= array_elements.length; i++) {
        if (array_elements[i] != current) {
            if (cnt > 0) {
                console.log(current + ' comes --> ' + cnt + ' times');
                FiringRules.push(current)
                JSONObjofFiringRules[current] = cnt

            }
            current = array_elements[i];
            cnt = 1;
        } else {
            cnt++;
        }
    }
    // console.log(JSONObjofFiringRules);
    callback(null, FiringRules, JSONObjofFiringRules)
    /*  if (cnt > 0) {
          console.log(current + ' comes --> ' + cnt + ' times');
      } */
}
function wightageSum(FiringRules, JSONObjofFiringRules, callback) {
    // let wightageArray = []
    // writeStream.write(header2);
    let weightageSum = 0;
    AchievedLintScore = 0
    let weightageRules = []
    //let FiringRules=[]
    for (rules in weightageperRule) {
        weightageRules.push(rules)
        for (firedRule in JSONObjofFiringRules) {
            if (rules == firedRule) {
                if (JSONObjofFiringRules[firedRule] >= weightageperRule[rules].threshold) {
                    worksheet2.addRow({ Rule: firedRule, Message: weightageperRule[rules].message, NumberOfTimesViolated: JSONObjofFiringRules[firedRule], Threshold: weightageperRule[rules].threshold, Weightage: weightageperRule[rules].weightage, AchievedLintScore: AchievedLintScore })
                    weightageSum = weightageSum + AchievedLintScore

                }
                else {
                    worksheet2.addRow({ Rule: firedRule, Message: weightageperRule[rules].message, NumberOfTimesViolated: JSONObjofFiringRules[firedRule], Threshold: weightageperRule[rules].threshold, Weightage: weightageperRule[rules].weightage, AchievedLintScore: weightageperRule[rules].weightage })
                    weightageSum = weightageSum + weightageperRule[rules].weightage
                }
            }
        }

    }

    var diff = weightageRules.filter(x => !FiringRules.includes(x));


    for (notfired in diff) {


        //console.log(weightageperRule[diff[notfired]].message,"<<<<<")
        worksheet2.addRow({ Rule: diff[notfired], Message: weightageperRule[diff[notfired]].message, NumberOfTimesViolated: 0, Threshold: weightageperRule[diff[notfired]].threshold, Weightage: weightageperRule[diff[notfired]].weightage, AchievedLintScore: weightageperRule[diff[notfired]].weightage })
        weightageSum = weightageSum + weightageperRule[diff[notfired]].weightage
    }
    worksheet2.addRow({ Rule: "", Message: "", NumberOfTimesViolated: "", Threshold: "", Weightage: "Total Score Achieved", AchievedLintScore: weightageSum }, 'FF0000FF')

    worksheet2.commit()
    workbook.commit().then(function () {
    });
    //writeStream.close();
    /* var sumWeightage = wightageArray.reduce(function (a, b) {
        return a + b;
     }, 0); */

    console.log("{\"total lint score\":"+weightageSum+"}");

}


async.waterfall([gherkinlintrules,
    eslintrules,
    countOfRules,
    wightageSum
], function (err, res) {

})
/*async.waterfall([gherkinlintrules,
   eslintrules,
   countOfRules,
   wightageSum], function (err, res) {

   })*/