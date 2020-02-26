const databaseOperations = require("./Framework/FrameworkUtilities/DatabaseOperations/databaseOperations");
<<<<<<< HEAD
module.exports = async function bootstrapFunction() {
    global.testData = await databaseOperations.getTestData();
    global.uiElements = await databaseOperations.getUiElementXpath();
=======
module.exports=async function print()
{
console.log("Inside Bootstrap");
console.log(process.env.USERNAME);
global.testData = await databaseOperations.getTestData();
global.uiElements = await databaseOperations.getUiElementXpath();
>>>>>>> DD_UI_2502
};