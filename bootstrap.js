const databaseOperations = require("./Framework/FrameworkUtilities/DatabaseOperations/databaseOperations");
module.exports=async function print()
{
console.log("Inside Bootstrap");
console.log(process.env.USERNAME);
global.testData = await databaseOperations.getTestData();
global.uiElements = await databaseOperations.getUiElementXpath();
};