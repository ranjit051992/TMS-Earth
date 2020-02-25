const { I } = inject();
const logger = require("../Framework/FrameworkUtilities/Logger/logger");
const databaseOperations = require("../Framework/FrameworkUtilities/DatabaseOperations/databaseOperations");
const coe = require("../COE/COE");

module.exports = {
    EMAIL_ADDRESS_GHOST_TEXTBOX: "Login/EMAIL_ADDRESS_GHOST_TEXTBOX",
    EMAIL_ADDRESS_TEXTBOX: "Login/EMAIL_ADDRESS_TEXTBOX",
    PASSWORD_GHOST_TEXTBOX: "Login/PASSWORD_GHOST_TEXTBOX",
    PASSWORD_TEXTBOX: "Login/PASSWORD_TEXTBOX",
    LOGIN_BUTTON: "Login/LOGIN_BUTTON",
    MENU_ICON: "Home/MENU_ICON",
    CREATEBUTTON:"CLAUSESlISING/CREATEBUTTON",
    CLAUSETITLE:"CLAUSETITLE/ClauseTitle",
    clickDropdown:"Create_A_New_Clause/clickDropdown",
    DropDownText:"Create_A_New_Clause/DropDownText",
    AssociatedBaseType:"Create_A_New_Clause/AssociatedBaseType",
    DRISCRIPTION:"Create_A_New_Clause/Description",
    CREATEBUTTON_FOOTER:"Create_A_New_Clause/CREATEBUTTON_FOOTER",
    NAVIGATEVIATABLISTING:"ListingPage/NavigateViaTabListing",
    NAVIGATESUBMENUTABS:"ClauseBasicDetails/NavigateTOSubMenuTab",
    SearchOnGrid:"Listing/SearchOnGrid",
    searchByColumnName:"Listing/searchByColumnName",
    ClauseTitlePresentCheck:"Listing/ClauseTitlePresentCheck",
    BackArrow:"BasicDetailsClauses/BackArrow",
    AddDefault:"Listing/AddDefault",
    SaveAndGoTOAllClauses:"BasicDetailsClauses/SaveAndGoTOAllClauses",
    SearchBoxReviewer:"SearchBoxReviewer/SearchTextBox",
    SearchReviewerColumnNAme:"AddReviewer/SearchReviewerColumnNAme",
    SelectReviewerByValue:"AddReviewersClauses/SelectReviewerByValue",
    AddButtonClauses:"AddReviewersClauses/AddButton",
    crossIcon:"AddReviewersClauses/crossButton",
    
    navigateViaTabsListing(TabName)
        {
        I.seeElement(replaceValueInAString(global.uiElements.get(coe.NAVIGATEVIATABLISTING),TabName));
        I.click(replaceValueInAString(global.uiElements.get(coe.NAVIGATEVIATABLISTING),TabName));
        } ,
SelectFromDropDown(formControlName,ValueToSelect,TestDataDefaultValueKeyFromDB)
{
    I.click(replaceValueInAString(global.uiElements.get(coe.clickDropdown),formControlName));
    if(!ValueToSelect)
                     {
                                 I.scrollIntoView(replaceValueInAString(global.uiElements.get(coe.DropDownText),TestDataDefaultValueKeyFromDB));
                                 I.click(replaceValueInAString(global.uiElements.get(coe.DropDownText),TestDataDefaultValueKeyFromDB));
                                 return TestDataDefaultValueKeyFromDB;
                     }
                      else
                            {
                                 I.scrollIntoView(replaceValueInAString(global.uiElements.get(coe.DropDownText),ValueToSelect));
                                 I.click(replaceValueInAString(global.uiElements.get(coe.DropDownText),ValueToSelect));
                                return ValueToSelect;
                                }
},

SelectFromDropDownMultipleCheckBoxValues(formControlName,DropDownOptionsTobeSelected)
{
    if(DropDownOptionsTobeSelected)
    {
    var listofelements= DropDownOptionsTobeSelected.split(',');
    I.click(replaceValueInAString(global.uiElements.get(coe.clickDropdown),formControlName));
                for(var i=0;i<=listofelements.length-1;i++)
                         {
                             I.fillField(replaceValueInAString(global.uiElements.get(coe.clickDropdown),formControlName),listofelements[i]);
                             I.seeElement(replaceValueInAString(global.uiElements.get(coe.AssociatedBaseType),listofelements[i]));
                             I.click(replaceValueInAString(global.uiElements.get(coe.AssociatedBaseType),listofelements[i]));
                            
                         }
    }
    else
    {
        var listofElements=global.testData.get("AssociatedBseTypeDropDown_DefaultValue");
        if(listofElements.includes(','))
                {
                var listofelements=global.testData.get("AssociatedBseTypeDropDown_DefaultValue");
                I.click(replaceValueInAString(global.uiElements.get(coe.clickDropdown),formControlName));
                 for(var i=0;i<=listofelements.length-1;i++)
                                     {
                                          I.fillField(replaceValueInAString(global.uiElements.get(coe.clickDropdown),formControlName),listofelements[i]);
                                          I.seeElement(replaceValueInAString(global.uiElements.get(coe.AssociatedBaseType),listofelements[i]));
                                          I.click(replaceValueInAString(global.uiElements.get(coe.AssociatedBaseType),listofelements[i]));

                                     }
                 }
                    else 
                        {
                             var listofelements=global.testData.get("AssociatedBseTypeDropDown_DefaultValue");
                             I.fillField(replaceValueInAString(global.uiElements.get(coe.clickDropdown),formControlName),listofelements);
                             I.seeElement(replaceValueInAString(global.uiElements.get(coe.AssociatedBaseType),listofelements));
                             I.click(replaceValueInAString(global.uiElements.get(coe.AssociatedBaseType),listofelements));

        }

    }


},

        navigateToSunMenuTabs(SubTabText)
            {
                 I.seeElement(replaceValueInAString(global.uiElements.get(ActionClassforclause.NAVIGATESUBMENUTABS),SubTabText));
                 I.click(replaceValueInAString(global.uiElements.get(ActionClassforclause.NAVIGATESUBMENUTABS),SubTabText));
            },


searchOnGrid(dataTosearch,colunmName)
            {
                I.seeElement(global.uiElements.get(ActionClassforclause.SearchOnGrid));
                 I.click(global.uiElements.get(ActionClassforclause.SearchOnGrid));
                I.fillField(global.uiElements.get(ActionClassforclause.SearchOnGrid),dataTosearch);
                I.seeElement(replaceValueInAString(global.uiElements.get(ActionClassforclause.searchByColumnName),colunmName));
                I.click(replaceValueInAString(global.uiElements.get(ActionClassforclause.searchByColumnName),colunmName));
                I.seeElement(replaceValueInAString(global.uiElements.get(ActionClassforclause.ClauseTitlePresentCheck),dataTosearch));

            },
            randomString(xpath){
               return randomString(xpath);
            }

}
function replaceValueInAString(xpath,valueToReplacewith)
{
   return  xpath.replace("<<dataname>>",valueToReplacewith);
}
function randomString(length) {
    return Math.round((Math.pow(36, length + 1) - Math.random() * Math.pow(36, length))).toString(36).slice(1);
}