const { I } = inject();

import { Common } from "../../Common/Common";
import { CreateUserObj } from "./CreateUserObj";
//import { assert } from "../../../../node_modules/";
import { logger } from "../../../Framework/FrameworkUtilities/Logger/logger";
//import { assert } from "assert";
const idnumber = Common.getRandomNumber1(7);
var Email;
import { z } from "actionbot-wrapper/z";
import { TMSLmt } from "../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp";
import { DataIntegrity } from 'dd-dataintegrity/src/DataIntegrity';
import { Wait } from "dd-cc-zycus-automation/dist/components/dewWait";
import {prop} from "../../../Framework/FrameworkUtilities/config";
//import { EmailTest } from "../../../Framework/FrameworkUtilities/EmailTest/emailTest";
//import { EmailTest_NewImpl } from "../../../Framework/FrameworkUtilities/EmailTest/emailTest_Enhanced_NewImplementation";
import { Startup } from "../../../Framework/FrameworkUtilities/Startup/Startup";
import { EmailTest_NewImpl_TMS } from "../../../Framework/FrameworkUtilities/EmailTest/emailTest_Enhanced_NewImplementation_TMS";

var DisplayName1 = Common.getRandomNumber(4) + "Display";
var Firstname1 = Common.getRandomNumber(4) + "First";
var Lastname1 = Common.getRandomNumber(4) + "Last";
var Initialame1 = getRandominitial(2) + "In";
const idnumber1 = Common.getRandomNumber1(7);
const PurchaseLimit1 = Common.getRandomNumber1(7);
const Reqapplimit1 = Common.getRandomNumber1(7);

export class CreateUserImpl {

  
  static async NavigateToUserAddPage() {
    await z.click(await TMSLmt.getElement(CreateUserObj.AddNewUser_btn));
    //await z.seeTitleEquals("Create New User - Step 1");
    await z.seeTitleEquals(await TMSLmt.getData("Create_User_step1"));

  }
  static async EnterBasicDetailsUser() {
    Email =  Common.getRandomNumber(8) + "@gmail.com";
    await z.fillField(await TMSLmt.getElement(CreateUserObj.Locator_displayName), await TMSLmt.getData("Value_displayName"));
    DataIntegrity.actualDatamap("User Display Name",await TMSLmt.getData("Value_displayName"));
    await z.fillField(await TMSLmt.getElement(CreateUserObj.Locator_lastName), await TMSLmt.getData("Value_lastName"));
    DataIntegrity.actualDatamap("User last Name",await TMSLmt.getData("Value_lastName"));
    await z.fillField(await TMSLmt.getElement(CreateUserObj.Locator_firstName), await TMSLmt.getData("Value_firstName"));
    DataIntegrity.actualDatamap("User first Name",await TMSLmt.getData("Value_firstName"));
    await z.fillField(await TMSLmt.getElement(CreateUserObj.Locator_emailaddress), Email);
    DataIntegrity.actualDatamap("User Email Address",Email);
    //await z.selectOption(await TMSLmt.getElement(CreateUserObj.Designation_Locator), await TMSLmt.getData("Designation_Value"));
    await z.selectOption(CreateUserObj.Designation_Locator, await TMSLmt.getData("Designation_Value"));
    DataIntegrity.actualDatamap("User Designation Name",await TMSLmt.getData("Designation_Value2"));
    //z.selectOption(CreateUserObj.Designation_Locator, CreateUserObj.Designation_Value);
    await z.fillField(CreateUserObj.Maneger_Email_Locator, await TMSLmt.getData("Maneger_Email_Value"));
    DataIntegrity.actualDatamap("User Manager Email Address",await TMSLmt.getData("Maneger_Email_Value"));
    //await z.fillField(CreateUserObj.Maneger_Email_Locator, CreateUserObj.Maneger_Email_Value);
    await z.fillField(await TMSLmt.getElement(CreateUserObj.UserInitials),await TMSLmt.getData("UserInitials_Value"));
    DataIntegrity.actualDatamap("User Initial Name",await TMSLmt.getData("UserInitials_Value"));
    //await z.selectOption(await TMSLmt.getElement(CreateUserObj.Salutation_Locator),await TMSLmt.getData("Salutation_Value"));
    await z.selectOption(CreateUserObj.Salutation_Locator,CreateUserObj.Salutation_Value);
    DataIntegrity.actualDatamap("User Salutaion",await TMSLmt.getData("Salutation_Value"));
    
    await this.adduniqueids("ERP ID", idnumber);
    DataIntegrity.actualDatamap("ERP ID",idnumber);
    await this.adduniqueids("User ID", idnumber);
    DataIntegrity.actualDatamap("User ID",idnumber);
    await this.adduniqueids("Employee ID", idnumber);
    DataIntegrity.actualDatamap("Employee ID",idnumber);
    await this.adduniqueids("Contact Number", idnumber);
    DataIntegrity.actualDatamap("Contact Number",idnumber);

    await this.selectAutocomplete(await TMSLmt.getElement(CreateUserObj.Org_level1_Locator), await TMSLmt.getData("Org_level1_Value"));
    DataIntegrity.actualDatamap("User Org level1 value",await TMSLmt.getData("Org_level1_Value"));
    await this.selectAutocomplete(await TMSLmt.getElement(CreateUserObj.Org_level2_Locator), await TMSLmt.getData("Org_level2_Value"));
    DataIntegrity.actualDatamap("User Org level2 value",await TMSLmt.getData("Org_level2_Value"));
    await this.selectAutocomplete(await TMSLmt.getElement(CreateUserObj.Org_costCenter_Locator), await TMSLmt.getData("Org_costCenter_Value"));
    DataIntegrity.actualDatamap("User Org costcenter value",await TMSLmt.getData("Org_costCenter_Value"));
    await this.selectAutocomplete(await TMSLmt.getElement(CreateUserObj.Org_Location_Locator), await TMSLmt.getData("Org_Location_Value"));
    DataIntegrity.actualDatamap("User Org Location value",await TMSLmt.getData("Org_Location_Value"));
    await this.selectAutocompletedept(await TMSLmt.getElement(CreateUserObj.Org_dept_Locator), await TMSLmt.getData("Org_dept_Value"));
    DataIntegrity.actualDatamap("User Org dept value",await TMSLmt.getData("Org_dept_Value"));

    await z.fillField(await TMSLmt.getElement(CreateUserObj.invoiceApprovalLimit), await TMSLmt.getData("Limit_Max_value"));
    DataIntegrity.actualDatamap("User Limit Max value",await TMSLmt.getData("Limit_Max_value"));
    await z.fillField(await TMSLmt.getElement(CreateUserObj.requisitionApprovalLimit), await TMSLmt.getData("Limit_Max_value"));
    DataIntegrity.actualDatamap("User Limit Min value",await TMSLmt.getData("Limit_Max_value"));
    //await z.selectOption(await TMSLmt.getElement(CreateUserObj.approvalCurrency), await TMSLmt.getData("approvalCurrency_value"));
    //z.selectOption(CreateUserObj.approvalCurrency, CreateUserObj.approvalCurrency_value);
    await z.selectOption(CreateUserObj.approvalCurrency, await TMSLmt.getData("approvalCurrency_value"));
    DataIntegrity.actualDatamap("User Approval Currency Value",await TMSLmt.getData("approvalCurrency_valueverify"));
  }

  static async EnterBasicDetailsUserwithminimumdata() {
    Email =  Common.getRandomNumber(8) + "@gmail.com";
    await z.fillField(await TMSLmt.getElement(CreateUserObj.Locator_displayName), await TMSLmt.getData("Value_displayName"));
    DataIntegrity.actualDatamap("User Display Name",await TMSLmt.getData("Value_displayName"));
    await z.fillField(await TMSLmt.getElement(CreateUserObj.Locator_lastName), await TMSLmt.getData("Value_lastName"));
    DataIntegrity.actualDatamap("User last Name",await TMSLmt.getData("Value_lastName"));
    await z.fillField(await TMSLmt.getElement(CreateUserObj.Locator_firstName), await TMSLmt.getData("Value_firstName"));
    DataIntegrity.actualDatamap("User first Name",await TMSLmt.getData("Value_firstName"));
    await z.fillField(await TMSLmt.getElement(CreateUserObj.Locator_emailaddress), Email);
    DataIntegrity.actualDatamap("User Email Address",Email);
    //await z.selectOption(await TMSLmt.getElement(CreateUserObj.Designation_Locator), await TMSLmt.getData("Designation_Value"));
    await z.selectOption(CreateUserObj.Designation_Locator, await TMSLmt.getData("Designation_Value"));
    DataIntegrity.actualDatamap("User Designation Name",await TMSLmt.getData("Designation_Value"));
    //z.selectOption(CreateUserObj.Designation_Locator, CreateUserObj.Designation_Value);
    await z.fillField(CreateUserObj.Maneger_Email_Locator, await TMSLmt.getData("Maneger_Email_Value"));
    DataIntegrity.actualDatamap("User Manager Email Address",await TMSLmt.getData("Maneger_Email_Value"));
    
    await this.selectAutocomplete(await TMSLmt.getElement(CreateUserObj.Org_level1_Locator), await TMSLmt.getData("Org_level1_Value"));
    DataIntegrity.actualDatamap("User Org level1 value",await TMSLmt.getData("Org_level1_Value"));
    await this.selectAutocomplete(await TMSLmt.getElement(CreateUserObj.Org_level2_Locator), await TMSLmt.getData("Org_level2_Value"));
    DataIntegrity.actualDatamap("User Org level2 value",await TMSLmt.getData("Org_level2_Value"));
    await this.selectAutocomplete(await TMSLmt.getElement(CreateUserObj.Org_costCenter_Locator), await TMSLmt.getData("Org_costCenter_Value"));
    DataIntegrity.actualDatamap("User Org costcenter value",await TMSLmt.getData("Org_costCenter_Value"));
    await this.selectAutocomplete(await TMSLmt.getElement(CreateUserObj.Org_Location_Locator), await TMSLmt.getData("Org_Location_Value"));
    DataIntegrity.actualDatamap("User Org Location value",await TMSLmt.getData("Org_Location_Value"));
    await this.selectAutocompletedept(await TMSLmt.getElement(CreateUserObj.Org_dept_Locator), await TMSLmt.getData("Org_dept_Value"));
    DataIntegrity.actualDatamap("User Org dept value",await TMSLmt.getData("Org_dept_Value"));

    await z.fillField(await TMSLmt.getElement(CreateUserObj.invoiceApprovalLimit), await TMSLmt.getData("Limit_Max_value"));
    DataIntegrity.actualDatamap("User Limit Max value",await TMSLmt.getData("Limit_Max_value"));
    await z.fillField(await TMSLmt.getElement(CreateUserObj.requisitionApprovalLimit), await TMSLmt.getData("Limit_Max_value"));
    DataIntegrity.actualDatamap("User Limit Min value",await TMSLmt.getData("Limit_Max_value"));
    //await z.selectOption(await TMSLmt.getElement(CreateUserObj.approvalCurrency), await TMSLmt.getData("approvalCurrency_value"));
    //z.selectOption(CreateUserObj.approvalCurrency, CreateUserObj.approvalCurrency_value);
    await z.selectOption(CreateUserObj.approvalCurrency, await TMSLmt.getData("approvalCurrency_value"));
    DataIntegrity.actualDatamap("User Approval Currency Value",await TMSLmt.getData("approvalCurrency_valueverify"));
  }


  static async adduniqueids(idtype, value) {
    await z.selectOption(await TMSLmt.getElement(CreateUserObj.uniqueKeyTypexpath), idtype);
    await z.click(await TMSLmt.getElement(CreateUserObj.uniqueKeyTypefieldxpath));
    await z.fillField(await TMSLmt.getElement(CreateUserObj.uniqueKeyTypefieldxpath), value);
    await z.click(await TMSLmt.getElement(CreateUserObj.addbuttonxpath));
  }
  static async selectProduct() {
    var cars = await TMSLmt.getData("ProductList");
    for (let i = 0; i < cars.length; i++) {
      await z.click(`//*[@id="${cars[i]}"]`);
    }
    await z.click(`//*[@id="btniRequest"]`);
  }

  static async UpdateUserBasicDetails2() {
    await z.click(await TMSLmt.getElement(CreateUserObj.ProductDetailsEditBtn));
    var cars = await TMSLmt.getData("ProductList1");
    for (let i = 0; i < cars.length; i++) {
      await z.click(`//*[@id="${cars[i]}"]`);
    }
    await z.click(`//*[@id="btnSPM"]`);
    await z.click(await TMSLmt.getElement(CreateUserObj.Ctn_MainBtn));

  }

  static async UpdateUserBasicDetails3() {
    await z.click(await TMSLmt.getElement(CreateUserObj.RoleDetailsEditBtn));
    await z.fillField(await TMSLmt.getElement(CreateUserObj.RoleSearchField),await TMSLmt.getData("Role_Name1"));
    DataIntegrity.actualDatamap("User Assigned Role1",await TMSLmt.getData("Role_Name1"));
    await z.click(await TMSLmt.getElement(CreateUserObj.RoleSearchBtn));
    await z.click(await TMSLmt.getElement(CreateUserObj.Role_checkbox));
    await z.click(await TMSLmt.getElement(CreateUserObj.Ctn_MainBtn));
  }

  static async selectRoles() {
    await z.fillField(await TMSLmt.getElement(CreateUserObj.RoleSearchField),await TMSLmt.getData("Role_Name"));
    DataIntegrity.actualDatamap("User Assigned Role",await TMSLmt.getData("Role_Name"));
    await z.click(await TMSLmt.getElement(CreateUserObj.RoleSearchBtn));
    await z.click(await TMSLmt.getElement(CreateUserObj.Role_checkbox));
    await z.click(await TMSLmt.getElement(CreateUserObj.Ctn_MainBtn));
    
  }
  static async selectscope() {
    await z.fillField(await TMSLmt.getElement(CreateUserObj.Locator_ScopeNameSearchField),await TMSLmt.getData("Value_ScopeNameSearchField"));
    DataIntegrity.actualDatamap("User Assigned Scope",await TMSLmt.getData("Value_ScopeNameSearchField"));
    await z.click(await TMSLmt.getElement(CreateUserObj.Locator_ScopeNameSearchbutton));
    await z.click(await TMSLmt.getElement(CreateUserObj.Locator_ScopeNameSelectcheckbox));
    await z.click(await TMSLmt.getElement(CreateUserObj.Ctn_MainBtn));
    
  }

  static async UpdateUserBasicDetails4() {
    await z.click(await TMSLmt.getElement(CreateUserObj.ScopeDetailsEditBtn));
    await z.fillField(await TMSLmt.getElement(CreateUserObj.Locator_ScopeNameSearchField),await TMSLmt.getData("Value_ScopeNameSearchField1"));
    DataIntegrity.actualDatamap("User Assigned Scope1",await TMSLmt.getData("Value_ScopeNameSearchField1"));
    await z.click(await TMSLmt.getElement(CreateUserObj.Locator_ScopeNameSearchbutton));
    await z.click(await TMSLmt.getElement(CreateUserObj.Locator_ScopeNameSelectcheckbox));
    await z.click(await TMSLmt.getElement(CreateUserObj.Ctn_MainBtn));
    
  }

  static async selectUserPreference() {
    await z.selectOption(await TMSLmt.getElement(CreateUserObj.Locator_numberFormat), await TMSLmt.getData("Value_numberFormat"));
    DataIntegrity.actualDatamap("User Number Format",await TMSLmt.getData("Value_numberFormat"));
    await z.selectOption(await TMSLmt.getElement(CreateUserObj.Locator_defaultDateFormat), await TMSLmt.getData("Value_defaultDateFormat"));
    DataIntegrity.actualDatamap("User Date Format",await TMSLmt.getData("Value_defaultDateFormat"));
    await z.selectOption(await TMSLmt.getElement(CreateUserObj.Locator_timeFormat), await TMSLmt.getData("Value_timeFormat"));
    DataIntegrity.actualDatamap("User Time Format",await TMSLmt.getData("Value_timeFormat"));
    await z.selectOption(await TMSLmt.getElement(CreateUserObj.Locator_defaultCurrency), await TMSLmt.getData("Value_defaultCurrency"));
    DataIntegrity.actualDatamap("User Currency Type",await TMSLmt.getData("Value_defaultCurrency1"));
    await z.selectOption(await TMSLmt.getElement(CreateUserObj.Locator_defaultLocale), await TMSLmt.getData("Value_defaultLocale"));
    DataIntegrity.actualDatamap("User Locale Type",await TMSLmt.getData("Value_defaultLocale1"));
    await z.selectOption(await TMSLmt.getElement(CreateUserObj.Locator_decimalPrecision), await TMSLmt.getData("Value_decimalPrecision"));
    DataIntegrity.actualDatamap("User Decimal Precision",await TMSLmt.getData("Value_decimalPrecision"));
    await z.fillField(await TMSLmt.getElement(CreateUserObj.Locator_ipsource), await TMSLmt.getData("Value_ipsource"));
    DataIntegrity.actualDatamap("User IPSource Value",await TMSLmt.getData("Value_ipsource"));
    await z.click(await TMSLmt.getElement(CreateUserObj.Ctn_MainBtn));
    
  }

  static async UpdateUserBasicDetails5() {
    await z.click(await TMSLmt.getElement(CreateUserObj.PreferenceDetailsEditBtn));
    await z.selectOption(await TMSLmt.getElement(CreateUserObj.Locator_numberFormat), await TMSLmt.getData("Value_numberFormat2"));
    DataIntegrity.actualDatamap("User Number Format1",await TMSLmt.getData("Value_numberFormat2"));
    await z.selectOption(await TMSLmt.getElement(CreateUserObj.Locator_defaultDateFormat), await TMSLmt.getData("Value_defaultDateFormat2"));
    DataIntegrity.actualDatamap("User Date Format1",await TMSLmt.getData("Value_defaultDateFormat2"));
    await z.selectOption(await TMSLmt.getElement(CreateUserObj.Locator_timeFormat), await TMSLmt.getData("Value_timeFormat2"));
    DataIntegrity.actualDatamap("User Time Format1",await TMSLmt.getData("Value_timeFormat2"));
    await z.selectOption(await TMSLmt.getElement(CreateUserObj.Locator_defaultCurrency), await TMSLmt.getData("Value_defaultCurrency2"));
    DataIntegrity.actualDatamap("User Currency Type1",await TMSLmt.getData("Value_defaultCurrency12"));
    await z.selectOption(await TMSLmt.getElement(CreateUserObj.Locator_defaultLocale), await TMSLmt.getData("Value_defaultLocale2"));
    DataIntegrity.actualDatamap("User Locale Type1",await TMSLmt.getData("Value_defaultLocale12"));
    await z.selectOption(await TMSLmt.getElement(CreateUserObj.Locator_decimalPrecision), await TMSLmt.getData("Value_decimalPrecision2"));
    DataIntegrity.actualDatamap("User Decimal Precision1",await TMSLmt.getData("Value_decimalPrecision2"));
    await z.fillField(await TMSLmt.getElement(CreateUserObj.Locator_ipsource), await TMSLmt.getData("Value_ipsource2"));
    DataIntegrity.actualDatamap("User IPSource Value1",await TMSLmt.getData("Value_ipsource2"));
    await z.click(await TMSLmt.getElement(CreateUserObj.Ctn_MainBtn));
    
  }

  static async defineUser() {
    //await z.see("TMS");
    //await z.see("ADMIN");
    await z.see(await TMSLmt.getData("User_productassigned"));
    await z.see(await TMSLmt.getData("User_Role_assigned"));
    await z.click(await TMSLmt.getElement(CreateUserObj.Ctn_MainBtn));
    
  }

  static async popupSuccessUser() {
    await z.see(await TMSLmt.getData("Success_pop_up"));
    await z.click("//button[@role='button']/span[text()='Ok']");
  }


  static async selectAutocomplete(id, value) {
    await z.click(`//input[@id='${id}']`);
    await z.fillField(`//input[@id='${id}']`, value);
    await z.click("//*[contains(text(),'" + value + "')][1]");
  }
  static async selectAutocompletedept(id, value) {
    await z.click(`//input[@id='${id}']`);
    await z.fillField(`//input[@id='${id}']`, value);
    await z.waitForVisible("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content']");
    await z.click("//a[contains(text(),'" + value + "')][1]");
  }
  static async searchbyemailaddress(Email) {
    await z.selectOption("//*[@id='searchColumn']", "Email ID");
    await z.fillField("//*[@id='eventSearchText']", Email);
    await z.click("//*[@name='SearchButton']");
  }

  static async Usersearcheble(){
    await this.searchbyemailaddress(Email);
    var SearchEmail = await z.grabTextFrom("//td[@class='filterGridTblTd user-email-left']");
    logger.info("printing.... " + SearchEmail);
    //await z.assertEqual(Email, SearchEmail);
  }
  static async UserCreateBasicDetailsDI1(){
    await z.click(await TMSLmt.getElement(CreateUserObj.EditUserBtn));
    await z.click(await TMSLmt.getElement(CreateUserObj.BasicDetailsEditBtn));

    //await z.fillField(await TMSLmt.getElement(CreateUserObj.Locator_displayName), await TMSLmt.getData("Value_displayName"));
    //DataIntegrity.actualDatamap("User Display Name",await TMSLmt.getData("Value_displayName"));
    var CreateUserDisplayName = await z.grabValueFrom(await TMSLmt.getElement(CreateUserObj.Locator_displayName));
    //logger.info(CreateUserDisplayName);
    var CreateUserDisplayName = CreateUserDisplayName.toString().replace(/ *\([^)]*\) */g,'');
    DataIntegrity.expectedDatamap("User Display Name Expected",CreateUserDisplayName);
    z.assertEqual(DataIntegrity.actualData().get("User Display Name"), DataIntegrity.expectedData().get("User Display Name Expected"));

    //DataIntegrity.actualDatamap("User last Name",await TMSLmt.getData("Value_lastName"));
    //await z.fillField(await TMSLmt.getElement(CreateUserObj.Locator_lastName), await TMSLmt.getData("Value_lastName"));
    var CreateUserLastName = await z.grabValueFrom(await TMSLmt.getElement(CreateUserObj.Locator_lastName));
    //logger.info(CreateUserLastName);
    var CreateUserLastName = CreateUserLastName.toString().replace(/ *\([^)]*\) */g,'');
    DataIntegrity.expectedDatamap("User last Name Expected",CreateUserLastName);
    z.assertEqual(DataIntegrity.actualData().get("User last Name"), DataIntegrity.expectedData().get("User last Name Expected"));

    //DataIntegrity.actualDatamap("User first Name",await TMSLmt.getData("Value_firstName"));
    //await z.fillField(await TMSLmt.getElement(CreateUserObj.Locator_firstName), await TMSLmt.getData("Value_firstName"));
    var CreateUserFirstName = await z.grabValueFrom(await TMSLmt.getElement(CreateUserObj.Locator_firstName));
    //logger.info(CreateUserFirstName);
    var CreateUserFirstName = CreateUserFirstName.toString().replace(/ *\([^)]*\) */g,'');
    DataIntegrity.expectedDatamap("User first Name Expected",CreateUserFirstName);
    z.assertEqual(DataIntegrity.actualData().get("User first Name"), DataIntegrity.expectedData().get("User first Name Expected"));

    //DataIntegrity.actualDatamap("User Email Address",'DmXfcOmt_auto@gmail.com');
    //await z.fillField(await TMSLmt.getElement(CreateUserObj.Locator_emailaddress), Email);
    var CreateUserEmailAddress = await z.grabValueFrom(await TMSLmt.getElement(CreateUserObj.Locator_emailaddress));
    //logger.info(CreateUserEmailAddress);
    var CreateUserEmailAddress = CreateUserEmailAddress.toString().replace(/ *\([^)]*\) */g,'');
    DataIntegrity.expectedDatamap("User Email Address Expected",CreateUserEmailAddress);
    z.assertEqual(DataIntegrity.actualData().get("User Email Address"), DataIntegrity.expectedData().get("User Email Address Expected"));

    
    //DataIntegrity.actualDatamap("User Designation Name",await TMSLmt.getData("Designation_Value"));
    //var CreateUserDesiEmailAddress = await z.grabValueFrom(await TMSLmt.getElement(CreateUserObj.Designation_Locator));
    var CreateUserDesiEmailAddress = await z.grabValueFrom('#designation');
    //logger.info(CreateUserEmailAddress);
    var CreateUserDesiEmailAddress = CreateUserDesiEmailAddress.toString().replace(/ *\([^)]*\) */g,'');
    DataIntegrity.expectedDatamap("User Designation Name Expected",CreateUserDesiEmailAddress);
    z.assertEqual(DataIntegrity.actualData().get("User Designation Name"), DataIntegrity.expectedData().get("User Designation Name Expected"));

    //DataIntegrity.actualDatamap("User Manager Email Address",await TMSLmt.getData("Maneger_Email_Value"));
    var CreateUserDesivalueEmailAddress = await z.grabValueFrom('#managerEmail');
    //logger.info(CreateUserEmailAddress);
    var CreateUserDesivalueEmailAddress = CreateUserDesivalueEmailAddress.toString().replace(/ *\([^)]*\) */g,'');
    DataIntegrity.expectedDatamap("User Manager Email Expected",CreateUserDesivalueEmailAddress);
    z.assertEqual(DataIntegrity.actualData().get("User Manager Email Address"), DataIntegrity.expectedData().get("User Manager Email Expected"));

    //DataIntegrity.actualDatamap("User Initial Name",await TMSLmt.getData("UserInitials_Value"));
    var CreateUserinitiakvalue = await z.grabValueFrom(await TMSLmt.getElement(CreateUserObj.UserInitials));
    //logger.info(CreateUserEmailAddress);
    var CreateUserinitiakvalue = CreateUserinitiakvalue.toString().replace(/ *\([^)]*\) */g,'');
    DataIntegrity.expectedDatamap("User Initial Name Expected",CreateUserinitiakvalue);
    z.assertEqual(DataIntegrity.actualData().get("User Initial Name"), DataIntegrity.expectedData().get("User Initial Name Expected"));

    //DataIntegrity.actualDatamap("User Salutaion","Mr");
    //var CreateUserSalvalue = await z.grabValueFrom('#managerEmail');
    //var CreateUserSalvalue = await z.grabValueFrom(await TMSLmt.getElement(CreateUserObj.Salutation_Locator));
    //logger.info(CreateUserEmailAddress);
    //var CreateUserSalvalue = CreateUserSalvalue.toString().replace(/ *\([^)]*\) */g,'');
    //DataIntegrity.expectedDatamap("User Salutaion Expected",CreateUserSalvalue);
    //z.assertEqual(DataIntegrity.actualData().get("User Salutaion"), DataIntegrity.expectedData().get("User Salutaion Expected"));

    //DataIntegrity.actualDatamap("User Org level1 value",await TMSLmt.getData("Org_level1_Value"));
    //var CreateUserOrgvalue1 = await z.grabValueFrom(await TMSLmt.getElement(CreateUserObj.Org_level1_Locator));
    var CreateUserOrgvalue1 = await z.grabValueFrom('#organizationLevel_1');
    //logger.info(CreateUserEmailAddress);
    var CreateUserOrgvalue1 = CreateUserOrgvalue1.toString().replace(/ *\([^)]*\) */g,'');
    DataIntegrity.expectedDatamap("User Org level1 value Expected",CreateUserOrgvalue1);
    z.assertEqual(DataIntegrity.actualData().get("User Org level1 value"), DataIntegrity.expectedData().get("User Org level1 value Expected"));

    //DataIntegrity.actualDatamap("User Org level2 value",await TMSLmt.getData("Org_level2_Value"));
    //var CreateUserOrgvalue2 = await z.grabValueFrom(await TMSLmt.getElement(CreateUserObj.Org_level2_Locator));
    var CreateUserOrgvalue2 = await z.grabValueFrom('#organizationLevel_2');
    //logger.info(CreateUserEmailAddress);
    var CreateUserOrgvalue2 = CreateUserOrgvalue2.toString().replace(/ *\([^)]*\) */g,'');
    DataIntegrity.expectedDatamap("User Org level2 value Expected",CreateUserOrgvalue2);
    z.assertEqual(DataIntegrity.actualData().get("User Org level2 value"), DataIntegrity.expectedData().get("User Org level2 value Expected"));

    //DataIntegrity.actualDatamap("User Org costcenter value",await TMSLmt.getData("Org_costCenter_Value"));
    //var CreateUserOrgCCvalue = await z.grabValueFrom(await TMSLmt.getElement(CreateUserObj.Org_costCenter_Locator));#costCenters
    var CreateUserOrgCCvalue = await z.grabValueFrom('#costCenters');
    //logger.info(CreateUserEmailAddress);
    var CreateUserOrgCCvalue = CreateUserOrgCCvalue.toString().replace(/ *\([^)]*\) */g,'');
    DataIntegrity.expectedDatamap("User Org costcenter value Expected",CreateUserOrgCCvalue);
    z.assertEqual(DataIntegrity.actualData().get("User Org costcenter value"), DataIntegrity.expectedData().get("User Org costcenter value Expected"));

    //DataIntegrity.actualDatamap("User Org Location value",await TMSLmt.getData("Org_Location_Value"));
    //var CreateUserOrgLocvalue = await z.grabValueFrom(await TMSLmt.getElement(CreateUserObj.Org_Location_Locator));#locations
    var CreateUserOrgLocvalue = await z.grabValueFrom('#locations');
    //logger.info(CreateUserEmailAddress);
    var CreateUserOrgLocvalue = CreateUserOrgLocvalue.toString().replace(/ *\([^)]*\) */g,'');
    DataIntegrity.expectedDatamap("User Org Location value Expected",CreateUserOrgLocvalue);
    z.assertEqual(DataIntegrity.actualData().get("User Org Location value"), DataIntegrity.expectedData().get("User Org Location value Expected"));

    //DataIntegrity.actualDatamap("User Org dept value",await TMSLmt.getData("Org_dept_Value"));
    //var CreateUserOrgDeptvalue = await z.grabValueFrom(await TMSLmt.getElement(CreateUserObj.Org_dept_Locator));#input_departmentid
    var CreateUserOrgDeptvalue = await z.grabValueFrom('#input_departmentid');
    //logger.info(CreateUserEmailAddress);
    var CreateUserOrgDeptvalue = CreateUserOrgDeptvalue.toString().replace(/ *\([^)]*\) */g,'');
    DataIntegrity.expectedDatamap("User Org dept value Expected",CreateUserOrgDeptvalue);
    z.assertEqual(DataIntegrity.actualData().get("User Org dept value"), DataIntegrity.expectedData().get("User Org dept value Expected"));

    //DataIntegrity.actualDatamap("User Limit Max value",await TMSLmt.getData("Limit_Max_value"));
    var CreateUserlimitmaxvalue = await z.grabValueFrom(await TMSLmt.getElement(CreateUserObj.invoiceApprovalLimit));
    //logger.info(CreateUserEmailAddress);
    var CreateUserlimitmaxvalue = CreateUserlimitmaxvalue.toString().replace(/ *\([^)]*\) */g,'');
    DataIntegrity.expectedDatamap("User Limit Max value Expected",CreateUserlimitmaxvalue);
    z.assertEqual(DataIntegrity.actualData().get("User Limit Max value"), DataIntegrity.expectedData().get("User Limit Max value Expected"));

    //DataIntegrity.actualDatamap("User Limit Min value",await TMSLmt.getData("Limit_Max_value"));
    var CreateUserlimitreqmaxvalue = await z.grabValueFrom(await TMSLmt.getElement(CreateUserObj.requisitionApprovalLimit));
    //logger.info(CreateUserEmailAddress);
    var CreateUserlimitreqmaxvalue = CreateUserlimitreqmaxvalue.toString().replace(/ *\([^)]*\) */g,'');
    DataIntegrity.expectedDatamap("User Limit Max value Expected",CreateUserlimitmaxvalue);
    z.assertEqual(DataIntegrity.actualData().get("User Limit Max value"), DataIntegrity.expectedData().get("User Limit Max value Expected"));

    //DataIntegrity.actualDatamap("User Approval Currency Value",await TMSLmt.getData("approvalCurrency_value1"));
    //var CreateUserappcurrvalue = await z.grabValueFrom(await TMSLmt.getElement(CreateUserObj.approvalCurrency));#approvalCurrency
    var CreateUserappcurrvalue = await z.grabValueFrom('#approvalCurrency');
    //logger.info(CreateUserEmailAddress);
    var CreateUserappcurrvalue = CreateUserappcurrvalue.toString().replace(/ *\([^)]*\) */g,'');
    DataIntegrity.expectedDatamap("User Approval Currency Value Expected",CreateUserappcurrvalue);
    z.assertEqual(DataIntegrity.actualData().get("User Approval Currency Value"), DataIntegrity.expectedData().get("User Approval Currency Value Expected"));

    //DataIntegrity.actualDatamap("ERP ID","6717234");
    var ERPIDValue = await z.grabValueFrom('#uniqueTypeValue_1');
    var ERPIDValue = ERPIDValue.toString().replace(/ *\([^)]*\) */g,'');
    DataIntegrity.expectedDatamap("ERP ID Expected",ERPIDValue);
    z.assertEqual(DataIntegrity.actualData().get("ERP ID"), DataIntegrity.expectedData().get("ERP ID Expected"));

    //DataIntegrity.actualDatamap("User ID","6717234");
    var UserIDValue = await z.grabValueFrom('#uniqueTypeValue_2');
    var UserIDValue = UserIDValue.toString().replace(/ *\([^)]*\) */g,'');
    DataIntegrity.expectedDatamap("User ID Expected",UserIDValue);
    z.assertEqual(DataIntegrity.actualData().get("User ID"), DataIntegrity.expectedData().get("User ID Expected"));

    //DataIntegrity.actualDatamap("Employee ID","6717234");
    var EmployeeIDValue = await z.grabValueFrom('#uniqueTypeValue_3');
    var EmployeeIDValue = EmployeeIDValue.toString().replace(/ *\([^)]*\) */g,'');
    DataIntegrity.expectedDatamap("Employee ID Expected",EmployeeIDValue);
    z.assertEqual(DataIntegrity.actualData().get("Employee ID"), DataIntegrity.expectedData().get("Employee ID Expected"));

    //DataIntegrity.actualDatamap("Contact Number","6717234");
    var ContactNoIDValue = await z.grabValueFrom('#uniqueTypeValue_4');
    var ContactNoIDValue = ContactNoIDValue.toString().replace(/ *\([^)]*\) */g,'');
    DataIntegrity.expectedDatamap("Contact Number Expected",ContactNoIDValue);
    z.assertEqual(DataIntegrity.actualData().get("Contact Number"), DataIntegrity.expectedData().get("Contact Number Expected"));

    await z.click(await TMSLmt.getElement(CreateUserObj.Ctn_MainBtn));
  }

  static async UserCreateBasicDetailsDI2(){
    await z.click(await TMSLmt.getElement(CreateUserObj.ProductDetailsEditBtn));

    let unassignedcount = await z.grabNumberOfVisibleElements("//*[@title='Unassign']");
    let Assignedcount = await z.grabNumberOfVisibleElements("//*[@title='Assign']");
    logger.info("Un......." + unassignedcount);
    logger.info("As......." + Assignedcount);

    var attrTMS = await z.grabAttributeFrom("//*[@id='btnDashboard']", "value");
    var flag = attrTMS.includes("Unassign");
    await z.assertEqual(flag, true);

    var attriSource = await z.grabAttributeFrom("//*[@id='btniSource']", "value");
    var flag1 = attriSource.includes("Unassign");
    await z.assertEqual(flag1, true);

    var attrMAS = await z.grabAttributeFrom("//*[@id='btnMAS']", "value");
    var flag2 = attrMAS.includes("Unassign");
    await z.assertEqual(flag2, true);

    var attrTMS = await z.grabAttributeFrom("//*[@id='btnTMS']", "value");
    var flag5 = attrTMS.includes("Unassign");
    await z.assertEqual(flag5, true);

    var attriRequest = await z.grabAttributeFrom("//*[@id='btniRequest']", "value");
    var flag6 = attriRequest.includes("Assign");
    await z.assertEqual(flag6, true);

    await z.click(await TMSLmt.getElement(CreateUserObj.Ctn_MainBtn));
  }

  static async UserCreateBasicDetailsDI3(){
    await z.see(await TMSLmt.getData("Role_Name"));
    DataIntegrity.expectedDatamap("User Assigned Role Expected","LOCAL ADMIN");
    z.assertEqual(DataIntegrity.actualData().get("User Assigned Role"), DataIntegrity.expectedData().get("User Assigned Role Expected"));

  }

  static async VerifyUpdateuserdetails3(){
    await z.see(await TMSLmt.getData("Role_Name1"));
    DataIntegrity.expectedDatamap("User Assigned Role Expected1","Company Dashboard Admin");
    z.assertEqual(DataIntegrity.actualData().get("User Assigned Role1"), DataIntegrity.expectedData().get("User Assigned Role Expected1"));
  }

  static async UserCreateBasicDetailsDI4(){

    await z.see(await TMSLmt.getData("Value_ScopeNameSearchField"));
    DataIntegrity.expectedDatamap("User Assigned Scope Expected",await TMSLmt.getData("Value_ScopeNameSearchField"));
    z.assertEqual(DataIntegrity.actualData().get("User Assigned Scope"), DataIntegrity.expectedData().get("User Assigned Scope Expected"));

  }

  static async VerifyUpdateuserdetails4(){

    await z.see(await TMSLmt.getData("Value_ScopeNameSearchField1"));
    DataIntegrity.expectedDatamap("User Assigned Scope Expected1",await TMSLmt.getData("Value_ScopeNameSearchField1"));
    z.assertEqual(DataIntegrity.actualData().get("User Assigned Scope1"), DataIntegrity.expectedData().get("User Assigned Scope Expected1"));

  }

  static async UserCreateBasicDetailsDI5(){

    await z.see(await TMSLmt.getData("Value_numberFormat"));
    //DataIntegrity.actualDatamap("User Number Format",await TMSLmt.getData("Value_numberFormat"));
    DataIntegrity.expectedDatamap("User Number Format Expected",await TMSLmt.getData("Value_numberFormat"));
    z.assertEqual(DataIntegrity.actualData().get("User Number Format"), DataIntegrity.expectedData().get("User Number Format Expected"));

    await z.see(await TMSLmt.getData("Value_defaultDateFormat"));
    //DataIntegrity.actualDatamap("User Date Format",await TMSLmt.getData("Value_defaultDateFormat"));
    DataIntegrity.expectedDatamap("User Date Format Expected",await TMSLmt.getData("Value_defaultDateFormat"));
    z.assertEqual(DataIntegrity.actualData().get("User Date Format"), DataIntegrity.expectedData().get("User Date Format Expected"));

    await z.see(await TMSLmt.getData("Value_timeFormat"));
    //DataIntegrity.actualDatamap("User Time Format",await TMSLmt.getData("Value_timeFormat"));
    DataIntegrity.expectedDatamap("User Time Format Expected",await TMSLmt.getData("Value_timeFormat"));
    z.assertEqual(DataIntegrity.actualData().get("User Time Format"), DataIntegrity.expectedData().get("User Time Format Expected"));

    await z.see(await TMSLmt.getData("Value_defaultCurrency1"));
    //DataIntegrity.actualDatamap("User Currency Type",await TMSLmt.getData("Value_defaultCurrency1"));
    DataIntegrity.expectedDatamap("User Currency Type Expected",await TMSLmt.getData("Value_defaultCurrency1"));
    z.assertEqual(DataIntegrity.actualData().get("User Currency Type"), DataIntegrity.expectedData().get("User Currency Type Expected"));

    await z.see(await TMSLmt.getData("Value_defaultLocale1"));
    //DataIntegrity.actualDatamap("User Locale Type",await TMSLmt.getData("Value_defaultLocale1"));
    DataIntegrity.expectedDatamap("User Locale Type Expected",await TMSLmt.getData("Value_defaultLocale1"));
    z.assertEqual(DataIntegrity.actualData().get("User Locale Type"), DataIntegrity.expectedData().get("User Locale Type Expected"));

    await z.see(await TMSLmt.getData("Value_decimalPrecision"));
    //DataIntegrity.actualDatamap("User Decimal Precision",await TMSLmt.getData("Value_decimalPrecision"));
    DataIntegrity.expectedDatamap("User Decimal Precision Expected",await TMSLmt.getData("Value_decimalPrecision"));
    z.assertEqual(DataIntegrity.actualData().get("User Decimal Precision"), DataIntegrity.expectedData().get("User Decimal Precision Expected"));

    await z.see(await TMSLmt.getData("Value_ipsource"))
    //DataIntegrity.actualDatamap("User IPSource Value",await TMSLmt.getData("Value_ipsource"));
    DataIntegrity.expectedDatamap("User IPSource Value Expected",await TMSLmt.getData("Value_ipsource"));
    z.assertEqual(DataIntegrity.actualData().get("User IPSource Value"), DataIntegrity.expectedData().get("User IPSource Value Expected"));

    await z.click(await TMSLmt.getElement(CreateUserObj.CancelBtn));

  }

  static async VerifyUpdateuserdetails5(){

    await z.see(await TMSLmt.getData("Value_numberFormat2"));
    DataIntegrity.expectedDatamap("User Number Format Expected1",await TMSLmt.getData("Value_numberFormat2"));
    z.assertEqual(DataIntegrity.actualData().get("User Number Format1"), DataIntegrity.expectedData().get("User Number Format Expected1"));

    await z.see(await TMSLmt.getData("Value_defaultDateFormat2"));
    DataIntegrity.expectedDatamap("User Date Format Expected1",await TMSLmt.getData("Value_defaultDateFormat2"));
    z.assertEqual(DataIntegrity.actualData().get("User Date Format1"), DataIntegrity.expectedData().get("User Date Format Expected1"));

    await z.see(await TMSLmt.getData("Value_timeFormat2"));
    //DataIntegrity.actualDatamap("User Time Format",await TMSLmt.getData("Value_timeFormat"));
    DataIntegrity.expectedDatamap("User Time Format Expected1",await TMSLmt.getData("Value_timeFormat2"));
    z.assertEqual(DataIntegrity.actualData().get("User Time Format1"), DataIntegrity.expectedData().get("User Time Format Expected1"));

    await z.see(await TMSLmt.getData("Value_defaultCurrency12"));
    //DataIntegrity.actualDatamap("User Currency Type",await TMSLmt.getData("Value_defaultCurrency1"));
    DataIntegrity.expectedDatamap("User Currency Type Expected1",await TMSLmt.getData("Value_defaultCurrency12"));
    z.assertEqual(DataIntegrity.actualData().get("User Currency Type1"), DataIntegrity.expectedData().get("User Currency Type Expected1"));

    await z.see(await TMSLmt.getData("Value_defaultLocale12"));
    //DataIntegrity.actualDatamap("User Locale Type",await TMSLmt.getData("Value_defaultLocale1"));
    DataIntegrity.expectedDatamap("User Locale Type Expected1",await TMSLmt.getData("Value_defaultLocale12"));
    z.assertEqual(DataIntegrity.actualData().get("User Locale Type1"), DataIntegrity.expectedData().get("User Locale Type Expected1"));

    await z.see(await TMSLmt.getData("Value_decimalPrecision2"));
    //DataIntegrity.actualDatamap("User Decimal Precision",await TMSLmt.getData("Value_decimalPrecision"));
    DataIntegrity.expectedDatamap("User Decimal Precision Expected1",await TMSLmt.getData("Value_decimalPrecision2"));
    z.assertEqual(DataIntegrity.actualData().get("User Decimal Precision1"), DataIntegrity.expectedData().get("User Decimal Precision Expected1"));

    await z.see(await TMSLmt.getData("Value_ipsource2"))
    //DataIntegrity.actualDatamap("User IPSource Value",await TMSLmt.getData("Value_ipsource"));
    DataIntegrity.expectedDatamap("User IPSource Value Expected1",await TMSLmt.getData("Value_ipsource2"));
    z.assertEqual(DataIntegrity.actualData().get("User IPSource Value1"), DataIntegrity.expectedData().get("User IPSource Value Expected1"));

    await z.click(await TMSLmt.getElement(CreateUserObj.CancelBtn));

  }


  static async markUserInactive(){
    await this.searchbyemailaddress(Email);
    await Wait.waitForDefaultTimeout(prop.DEFAULT_LOW_WAIT);
    var text = await z.grabTextFrom("//tr[@class='filterGridTblTd']/td[@class='filterGridTblTd user-lst-status']/label");
    await z.assertEqual("Active", text);
    await z.click(`//tr[@class='filterGridTblTd'][td[text()="${Email}"]]//input`);
    await z.click("//*[@id='deActivateSelectedUsersID']");
    //await z.see("If the current user is a reporting manager to other user then those reportees will not have any reporting manager assigned");
    await z.see(await TMSLmt.getData("Reporting_Manager_Popup"));
    await z.click("//button[@role='button']/span[text()='Ok']");
    //await z.see("1 user has been inactivated")
    await z.see(await TMSLmt.getData("User_inactive_message"));
    await z.click("//button[@role='button']/span[text()='Ok']");
  }

  static async deactivateuser(){
    let Email= await TMSLmt.getData("EmailActivateDeactivate");
    await this.searchbyemailaddress(Email);
    var text = await z.grabTextFrom("//tr[@class='filterGridTblTd']/td[@class='filterGridTblTd user-lst-status']/label");
    //await z.assertEqual("Active", text);
    await z.click(`//tr[@class='filterGridTblTd'][td[text()="${Email}"]]//input`);
    await z.click("//*[@id='deActivateSelectedUsersID']");
    await z.see("If the current user is a reporting manager to other user then those reportees will not have any reporting manager assigned");
    await z.click("//button[@role='button']/span[text()='Ok']");
    //await z.see("1 user has been inactivated")
    await z.see(await TMSLmt.getData("User_inactive_message"));
    await z.click("//button[@role='button']/span[text()='Ok']");
  }

  static async deactivateuserusermgmact(){
    let EmailofUser= await TMSLmt.getData("EmailDeactivateUserMgmAct");
    await this.searchbyemailaddress(EmailofUser);
    var text = await z.grabTextFrom("//tr[@class='filterGridTblTd']/td[@class='filterGridTblTd user-lst-status']/label");
    //await z.assertEqual("Active", text);
    await z.click(`//tr[@class='filterGridTblTd'][td[text()="${EmailofUser}"]]//input`);
    //await z.click("//*[@id='user-grid']/tbody/tr/td[27]/label");
    await z.click("//*[@id='deActivateSelectedUsersID']");
    await z.see("If the current user is a reporting manager to other user then those reportees will not have any reporting manager assigned");
    await z.click("//button[@role='button']/span[text()='Ok']");
    //await z.see("1 user has been inactivated")
    await z.see(await TMSLmt.getData("User_inactive_message"));
    await z.click("//button[@role='button']/span[text()='Ok']");
  }

  static async deactivateusercheck(){
    await Wait.waitForDefaultTimeout(prop.DEFAULT_LOW_WAIT);
    var text = await z.grabTextFrom("//tr[@class='filterGridTblTd']/td[@class='filterGridTblTd user-lst-status']/label");
    await z.assertEqual("Inactive", text);
  }
  static async activateuser(){
    let Email=await TMSLmt.getData("EmailActivateDeactivate");
    //let Email=await TMSLmt.getData("EmailActivateDeactivateDummy");
    await this.searchbyemailaddress(Email);
    var text = await z.grabTextFrom("//tr[@class='filterGridTblTd']/td[@class='filterGridTblTd user-lst-status']/label");
    //await z.assertEqual("Inactive", text);
    await z.click(`//tr[@class='filterGridTblTd'][td[text()="${Email}"]]//input`);
    await z.click("//*[@id='activateSelectedUsersID']");
    await z.click("//button[@role='button']/span[text()='Ok']");
  }
  static async Activateuserusermgmact(){
    let EmailForActivate=await TMSLmt.getData("EmailDeactivateUserMgmAct");
    //let Email=await TMSLmt.getData("EmailActivateDeactivateDummy");
    await this.searchbyemailaddress(EmailForActivate);
    var text = await z.grabTextFrom("//tr[@class='filterGridTblTd']/td[@class='filterGridTblTd user-lst-status']/label");
    //await z.assertEqual("Inactive", text);
    await z.click(`//tr[@class='filterGridTblTd'][td[text()="${EmailForActivate}"]]//input`);
    await z.click("//*[@id='activateSelectedUsersID']");
    //await z.click("//*[@id='user-grid']/tbody/tr/td[39]/label");
    await z.click("//button[@role='button']/span[text()='Ok']");
  }

  static async activateusercheck(){
    await Wait.waitForDefaultTimeout(prop.DEFAULT_LOW_WAIT);
    var text = await z.grabTextFrom("//tr[@class='filterGridTblTd']/td[@class='filterGridTblTd user-lst-status']/label");
    await z.assertEqual("Active", text);
  }
  static async activateusermailcheck(){
    await EmailTest_NewImpl_TMS.readEmail(prop.email_address1, prop.user_password1, ['SUBJECT'], ['Your Zycus Account has been Re-activated'], "Inbox/Ranjit", 0);
    //await EmailTest.readEmail('ranjit.more@zycus.com','rmz@112020', ['SUBJECT'], ['Your Zycus Account has been Re-activated'], "Inbox/Ranjit", 0);

    //console.log("EmailBody is "+ Startup.email_Test.get("emailBody") as String);
    //console.log("Links is "+ Startup.email_Test.get("links") as String);

    //await EmailTest_NewImpl_TMS.verifyDetails('BODY', 'ganapati');
    let value = await EmailTest_NewImpl_TMS.verifyDetails('BODY', 'Your account with Zycus has been successfully re-activated.');
    console.log("====== >>>  "+value);
    await z.assertEqual(value,true)
    //await EmailTest.verifyDetails('SUBJECT', 'Your Zycus Account has been Re-activated');
  }

  static async resetPassword(){
    let Email=await TMSLmt.getData("EmailActivateDeactivate");
    await this.searchbyemailaddress(Email);
    await z.click(`//tr[@class='filterGridTblTd'][td[text()="${Email}"]]//input`);
    await z.click("//*[@id='resetUserPasswordsID']");
    await z.click("//button[@role='button']/span[text()='Ok']");
  }

  static async UserMgmActresetPassword(){
    let Email=await TMSLmt.getData("EmailDeactivateUserMgmAct");
    await this.searchbyemailaddress(Email);
    await z.click(`//tr[@class='filterGridTblTd'][td[text()="${Email}"]]//input`);
    await z.click("//*[@id='resetUserPasswordsID']");
    await z.click("//button[@role='button']/span[text()='Ok']");
  }

  static async resetPasswordcheck(){
    //await z.see("The password has been reset");
    await Wait.waitForDefaultTimeout(prop.DEFAULT_HIGH_WAIT);
    // await Wait.waitForDefaultTimeout(prop.DEFAULT_HIGH_WAIT);
    // await Wait.waitForDefaultTimeout(prop.DEFAULT_HIGH_WAIT);
     await z.see(await TMSLmt.getData("Password_Reset_Message"));
     await z.click("//button[@role='button']/span[text()='Ok']");
  }
  static async emailEdit(){
    let SearchEmail=await TMSLmt.getData("EditEmailaddres");
    let Email1=await TMSLmt.getData("EditEmailaddres1");
    let Email2=await TMSLmt.getData("EditEmailaddres2");
    await this.searchbyemailaddress(SearchEmail);
    await z.click("//*[@title='Edit Email ID']");
    var oldEmail = await z.grabValueFrom("//input[@id='oldEmail']");
    if (oldEmail == Email1)
    { var newEmail = Email2 }
    else { var newEmail = Email1 }
    await z.fillField("//input[@id='email']", newEmail);
    await z.click("//input[@value='Submit']");
  }
  static async emailEditVerify(){
    //await z.see("User email edit request is submitted and will be processed once the user stops using Zycus system");
    await z.see(await TMSLmt.getData("Email_edit_request_message"));
    await z.click("//button[@role='button']/span[text()='Ok']");
  }

  static async NavigateCopyUser(){
    await this.searchbyemailaddress(await TMSLmt.getData("copyUser"));
    await z.click("//label[@title='Edit User Information']");
    await z.click(await TMSLmt.getElement(CreateUserObj.CopyUserBtn));
  }
  static async CopyUserFillDetails(){
    Email =  Common.getRandomNumber(8) + "@gmail.com";
    await z.fillField(await TMSLmt.getElement(CreateUserObj.FN_Txt), await TMSLmt.getData("Value_firstName"));
    await z.fillField(await TMSLmt.getElement(CreateUserObj.LN_Text), await TMSLmt.getData("Value_lastName"))
    await z.fillField(await TMSLmt.getElement(CreateUserObj.DisplayNameTxt), await TMSLmt.getData("Value_displayName"));
    await z.fillField(await TMSLmt.getElement(CreateUserObj.Email_Txt), Email);
    //Common.fillfields(CreateUserObj.ReportingMgr,)
    //Common.fillfields(CreateUserObj.UserInitials,"UAut");
    //Common.fillfields(CreateUserObj.ERPId,"598932");
    //Common.fillfields(CreateUserObj.UserId,"565");
    //Common.fillfields(CreateUserObj.EmpId,"74");
    //Common.fillfields(CreateUserObj.ContactNo,"84543543549");

  }

  static async CopyUserConfirm(){
    await z.see("User " + Email + " is successfully created");
    await z.click("//button[@role='button']/span[text()='Ok']");
    await this.searchbyemailaddress(Email);
  }



  static async EditUserPageSummary(Email) {
    await this.searchbyemailaddress(Email);
    await z.click(await TMSLmt.getElement(CreateUserObj.EditUserBtn));

  }
  static async UpdateUserBasicDetails1() {
    await Wait.waitForDefaultTimeout(prop.DEFAULT_LOW_WAIT);
    await z.click(await TMSLmt.getElement(CreateUserObj.EditUserBtn));
    await z.click(await TMSLmt.getElement(CreateUserObj.BasicDetailsEditBtn));
    await z.fillField(await TMSLmt.getElement(CreateUserObj.Locator_displayName),DisplayName1);
    DataIntegrity.actualDatamap("User Display Name1",DisplayName1);
    await z.fillField(await TMSLmt.getElement(CreateUserObj.Locator_lastName),Lastname1);
    DataIntegrity.actualDatamap("User last Name1",Lastname1);
    await z.fillField(await TMSLmt.getElement(CreateUserObj.Locator_firstName),Firstname1);
    DataIntegrity.actualDatamap("User first Name1",Firstname1);
    await z.selectOption(CreateUserObj.Designation_Locator, await TMSLmt.getData("Designation_Value1"));
    DataIntegrity.actualDatamap("User Designation Name1",await TMSLmt.getData("Designation_Value1Codename"));
    //DataIntegrity.actualDatamap("User Designation Name1",await TMSLmt.getData("Designation_Value1"));
    await z.fillField(CreateUserObj.Maneger_Email_Locator, await TMSLmt.getData("Maneger_Email_Value1"));
    DataIntegrity.actualDatamap("User Manager Email Address1",await TMSLmt.getData("Maneger_Email_Value1"));
    //await z.fillField(await TMSLmt.getElement(CreateUserObj.UserInitials),Initialame1);
    //DataIntegrity.actualDatamap("User Initial Name1",Initialame1);
    
    await z.click(await TMSLmt.getElement(CreateUserObj.UniqueERPIDEdit));
    await z.fillField(await TMSLmt.getElement(CreateUserObj.UniqueERPIDEditNumber), idnumber1);
    await z.click(await TMSLmt.getElement(CreateUserObj.UniqueERPIDEditSave));
    DataIntegrity.actualDatamap("ERP ID1",idnumber1);

    await z.click(await TMSLmt.getElement(CreateUserObj.UniqueUserIDEdit));
    await z.fillField(await TMSLmt.getElement(CreateUserObj.UniqueUserIDEditNumber), idnumber1);
    await z.click(await TMSLmt.getElement(CreateUserObj.UniqueUserIDEditSave));
    DataIntegrity.actualDatamap("User ID1",idnumber1);

    await z.click(await TMSLmt.getElement(CreateUserObj.UniqueEmployeeIDEdit));
    await z.fillField(await TMSLmt.getElement(CreateUserObj.UniqueEmployeeIDEditNumber), idnumber1);
    await z.click(await TMSLmt.getElement(CreateUserObj.UniqueEmployeeIDEditSave));
    DataIntegrity.actualDatamap("Employee ID1",idnumber1);
    
    await z.click(await TMSLmt.getElement(CreateUserObj.UniqueContactNoEdit));
    await z.fillField(await TMSLmt.getElement(CreateUserObj.UniqueContactNoEditNumber), idnumber1);
    await z.click(await TMSLmt.getElement(CreateUserObj.UniqueContactNoEditSave));
    DataIntegrity.actualDatamap("Contact Number1",idnumber1);

    await this.selectAutocomplete(await TMSLmt.getElement(CreateUserObj.Org_level1_Locator), await TMSLmt.getData("Org_level1_Value1"));
    DataIntegrity.actualDatamap("User Org level1 value1",await TMSLmt.getData("Org_level1_Value1"));
    await this.selectAutocomplete(await TMSLmt.getElement(CreateUserObj.Org_level2_Locator), await TMSLmt.getData("Org_level2_Value1"));
    DataIntegrity.actualDatamap("User Org level2 value1",await TMSLmt.getData("Org_level2_Value1"));
    await this.selectAutocomplete(await TMSLmt.getElement(CreateUserObj.Org_costCenter_Locator), await TMSLmt.getData("Org_costCenter_Value1"));
    DataIntegrity.actualDatamap("User Org costcenter value1",await TMSLmt.getData("Org_costCenter_Value1"));
    await this.selectAutocomplete(await TMSLmt.getElement(CreateUserObj.Org_Location_Locator), await TMSLmt.getData("Org_Location_Value1"));
    DataIntegrity.actualDatamap("User Org Location value1",await TMSLmt.getData("Org_Location_Value1"));
    await this.selectAutocompletedept(await TMSLmt.getElement(CreateUserObj.Org_dept_Locator), await TMSLmt.getData("Org_dept_Value1"));
    DataIntegrity.actualDatamap("User Org dept value1",await TMSLmt.getData("Org_dept_Value1"));

    await z.fillField(await TMSLmt.getElement(CreateUserObj.invoiceApprovalLimit),PurchaseLimit1);
    DataIntegrity.actualDatamap("User Limit Max value1",PurchaseLimit1);
    await z.fillField(await TMSLmt.getElement(CreateUserObj.requisitionApprovalLimit),Reqapplimit1);
    DataIntegrity.actualDatamap("User Limit Min value1",Reqapplimit1);
    //await z.selectOption(await TMSLmt.getElement(CreateUserObj.approvalCurrency), await TMSLmt.getData("approvalCurrency_value"));
    //z.selectOption(CreateUserObj.approvalCurrency, CreateUserObj.approvalCurrency_value);
    await z.selectOption(CreateUserObj.approvalCurrency, await TMSLmt.getData("approvalCurrency_value1"));
    DataIntegrity.actualDatamap("User Approval Currency Value1",await TMSLmt.getData("approvalCurrency_valueverify1"));

    await z.click(await TMSLmt.getElement(CreateUserObj.Ctn_MainBtn));
  }

  static async UpdateUserMgmactdetail() {
    await z.click(await TMSLmt.getElement(CreateUserObj.EditUserBtn));
    await z.click(await TMSLmt.getElement(CreateUserObj.BasicDetailsEditBtn));
    await z.fillField(await TMSLmt.getElement(CreateUserObj.Locator_displayName),DisplayName1);
    await z.fillField(await TMSLmt.getElement(CreateUserObj.Locator_lastName),Lastname1);
    await z.fillField(await TMSLmt.getElement(CreateUserObj.Locator_firstName),Firstname1);
    await z.click(await TMSLmt.getElement(CreateUserObj.Ctn_MainBtn));
  }

  static async updateUser() {
    await z.click(await TMSLmt.getElement(CreateUserObj.UpdateUserBtn));
    await Wait.waitForDefaultTimeout(prop.DEFAULT_HIGH_WAIT);
  }

 static async VerifyUpdateuserdetails1(){
  
  await z.click(await TMSLmt.getElement(CreateUserObj.EditUserBtn));
  await z.click(await TMSLmt.getElement(CreateUserObj.BasicDetailsEditBtn));

  var CreateUserDisplayName1 = await z.grabValueFrom(await TMSLmt.getElement(CreateUserObj.Locator_displayName));
  var CreateUserDisplayName1 = CreateUserDisplayName1.toString().replace(/ *\([^)]*\) */g,'');
  DataIntegrity.expectedDatamap("User Display Name Expected1",CreateUserDisplayName1);
  z.assertEqual(DataIntegrity.actualData().get("User Display Name1"), DataIntegrity.expectedData().get("User Display Name Expected1"));

  var CreateUserLastName1 = await z.grabValueFrom(await TMSLmt.getElement(CreateUserObj.Locator_lastName));
  var CreateUserLastName1 = CreateUserLastName1.toString().replace(/ *\([^)]*\) */g,'');
  DataIntegrity.expectedDatamap("User last Name Expected1",CreateUserLastName1);
  z.assertEqual(DataIntegrity.actualData().get("User last Name1"), DataIntegrity.expectedData().get("User last Name Expected1"));

  var CreateUserFirstName1 = await z.grabValueFrom(await TMSLmt.getElement(CreateUserObj.Locator_firstName));
  var CreateUserFirstName1 = CreateUserFirstName1.toString().replace(/ *\([^)]*\) */g,'');
  DataIntegrity.expectedDatamap("User first Name Expected1",CreateUserFirstName1);
  z.assertEqual(DataIntegrity.actualData().get("User first Name1"), DataIntegrity.expectedData().get("User first Name Expected1"));

  var CreateUserDesiEmailAddress1 = await z.grabValueFrom('#designation');
  var CreateUserDesiEmailAddress1 = CreateUserDesiEmailAddress1.toString().replace(/ *\([^)]*\) */g,'');
  DataIntegrity.expectedDatamap("User Designation Name Expected1",CreateUserDesiEmailAddress1);
  z.assertEqual(DataIntegrity.actualData().get("User Designation Name1"), DataIntegrity.expectedData().get("User Designation Name Expected1"));

  var CreateUserDesivalueEmailAddress1 = await z.grabValueFrom('#managerEmail');
  var CreateUserDesivalueEmailAddress1 = CreateUserDesivalueEmailAddress1.toString().replace(/ *\([^)]*\) */g,'');
  DataIntegrity.expectedDatamap("User Manager Email Expected1",CreateUserDesivalueEmailAddress1);
  z.assertEqual(DataIntegrity.actualData().get("User Manager Email Address1"), DataIntegrity.expectedData().get("User Manager Email Expected1"));

  //var CreateUserinitiakvalue1 = await z.grabValueFrom(await TMSLmt.getElement(CreateUserObj.UserInitials));
  //var CreateUserinitiakvalue1 = CreateUserinitiakvalue1.toString().replace(/ *\([^)]*\) */g,'');
  //DataIntegrity.expectedDatamap("User Initial Name Expected1",CreateUserinitiakvalue1);
  //z.assertEqual(DataIntegrity.actualData().get("User Initial Name1"), DataIntegrity.expectedData().get("User Initial Name Expected1"));


  var CreateUserOrgvalue11 = await z.grabValueFrom('#organizationLevel_1');
  var CreateUserOrgvalue11 = CreateUserOrgvalue11.toString().replace(/ *\([^)]*\) */g,'');
  DataIntegrity.expectedDatamap("User Org level1 value Expected1",CreateUserOrgvalue11);
  z.assertEqual(DataIntegrity.actualData().get("User Org level1 value1"), DataIntegrity.expectedData().get("User Org level1 value Expected1"));

  var CreateUserOrgvalue21 = await z.grabValueFrom('#organizationLevel_2');
  var CreateUserOrgvalue21 = CreateUserOrgvalue21.toString().replace(/ *\([^)]*\) */g,'');
  DataIntegrity.expectedDatamap("User Org level2 value Expected1",CreateUserOrgvalue21);
  z.assertEqual(DataIntegrity.actualData().get("User Org level2 value1"), DataIntegrity.expectedData().get("User Org level2 value Expected1"));

  var CreateUserOrgCCvalue1 = await z.grabValueFrom('#costCenters');
  var CreateUserOrgCCvalue1 = CreateUserOrgCCvalue1.toString().replace(/ *\([^)]*\) */g,'');
  DataIntegrity.expectedDatamap("User Org costcenter value Expected1",CreateUserOrgCCvalue1);
  z.assertEqual(DataIntegrity.actualData().get("User Org costcenter value1"), DataIntegrity.expectedData().get("User Org costcenter value Expected1"));

  var CreateUserOrgLocvalue1 = await z.grabValueFrom('#locations');
  var CreateUserOrgLocvalue1 = CreateUserOrgLocvalue1.toString().replace(/ *\([^)]*\) */g,'');
  DataIntegrity.expectedDatamap("User Org Location value Expected1",CreateUserOrgLocvalue1);
  z.assertEqual(DataIntegrity.actualData().get("User Org Location value1"), DataIntegrity.expectedData().get("User Org Location value Expected1"));

  var CreateUserOrgDeptvalue1 = await z.grabValueFrom('#input_departmentid');
  var CreateUserOrgDeptvalue1 = CreateUserOrgDeptvalue1.toString().replace(/ *\([^)]*\) */g,'');
  DataIntegrity.expectedDatamap("User Org dept value Expected1",CreateUserOrgDeptvalue1);
  z.assertEqual(DataIntegrity.actualData().get("User Org dept value1"), DataIntegrity.expectedData().get("User Org dept value Expected1"));

  var CreateUserlimitmaxvalue1 = await z.grabValueFrom(await TMSLmt.getElement(CreateUserObj.invoiceApprovalLimit));
  var CreateUserlimitmaxvalue1 = CreateUserlimitmaxvalue1.toString().replace(/ *\([^)]*\) */g,'');
  DataIntegrity.expectedDatamap("User Limit Max value Expected1",CreateUserlimitmaxvalue1);
  z.assertEqual(DataIntegrity.actualData().get("User Limit Max value1"), DataIntegrity.expectedData().get("User Limit Max value Expected1"));

  var CreateUserlimitreqmaxvalue1 = await z.grabValueFrom(await TMSLmt.getElement(CreateUserObj.requisitionApprovalLimit));
  var CreateUserlimitreqmaxvalue1 = CreateUserlimitreqmaxvalue1.toString().replace(/ *\([^)]*\) */g,'');
  DataIntegrity.expectedDatamap("User Limit Max value Expected1",CreateUserlimitmaxvalue1);
  z.assertEqual(DataIntegrity.actualData().get("User Limit Max value1"), DataIntegrity.expectedData().get("User Limit Max value Expected1"));

  var CreateUserappcurrvalue1 = await z.grabValueFrom('#approvalCurrency');
  var CreateUserappcurrvalue1 = CreateUserappcurrvalue1.toString().replace(/ *\([^)]*\) */g,'');
  DataIntegrity.expectedDatamap("User Approval Currency Value Expected1",CreateUserappcurrvalue1);
  z.assertEqual(DataIntegrity.actualData().get("User Approval Currency Value1"), DataIntegrity.expectedData().get("User Approval Currency Value Expected1"));

  var ERPIDValue1 = await z.grabValueFrom('#uniqueTypeValue_1');
  var ERPIDValue1 = ERPIDValue1.toString().replace(/ *\([^)]*\) */g,'');
  DataIntegrity.expectedDatamap("ERP ID Expected1",ERPIDValue1);
  z.assertEqual(DataIntegrity.actualData().get("ERP ID1"), DataIntegrity.expectedData().get("ERP ID Expected1"));

  var UserIDValue1 = await z.grabValueFrom('#uniqueTypeValue_2');
  var UserIDValue1 = UserIDValue1.toString().replace(/ *\([^)]*\) */g,'');
  DataIntegrity.expectedDatamap("User ID Expected1",UserIDValue1);
  z.assertEqual(DataIntegrity.actualData().get("User ID1"), DataIntegrity.expectedData().get("User ID Expected1"));

  var EmployeeIDValue1 = await z.grabValueFrom('#uniqueTypeValue_3');
  var EmployeeIDValue1 = EmployeeIDValue1.toString().replace(/ *\([^)]*\) */g,'');
  DataIntegrity.expectedDatamap("Employee ID Expected1",EmployeeIDValue1);
  z.assertEqual(DataIntegrity.actualData().get("Employee ID1"), DataIntegrity.expectedData().get("Employee ID Expected1"));

  var ContactNoIDValue1 = await z.grabValueFrom('#uniqueTypeValue_4');
  var ContactNoIDValue1 = ContactNoIDValue1.toString().replace(/ *\([^)]*\) */g,'');
  DataIntegrity.expectedDatamap("Contact Number Expected1",ContactNoIDValue1);
  z.assertEqual(DataIntegrity.actualData().get("Contact Number1"), DataIntegrity.expectedData().get("Contact Number Expected1"));

  await z.click(await TMSLmt.getElement(CreateUserObj.Ctn_MainBtn));

}

static async VerifyUpdateuserdetails2(){
  await z.click(await TMSLmt.getElement(CreateUserObj.ProductDetailsEditBtn));

  let unassignedcount = await z.grabNumberOfVisibleElements("//*[@title='Unassign']");
  let Assignedcount = await z.grabNumberOfVisibleElements("//*[@title='Assign']");
  logger.info("Un......." + unassignedcount);
  logger.info("As......." + Assignedcount);

  var attrTMS = await z.grabAttributeFrom("//*[@id='btnDashboard']", "value");
  var flag7 = attrTMS.includes("Unassign");
  await z.assertEqual(flag7, true);

  var attriSource = await z.grabAttributeFrom("//*[@id='btniSource']", "value");
  var flag8 = attriSource.includes("Unassign");
  await z.assertEqual(flag8, true);

  var attrMAS = await z.grabAttributeFrom("//*[@id='btnMAS']", "value");
  var flag9 = attrMAS.includes("Unassign");
  await z.assertEqual(flag9, true);

  var attrTMS = await z.grabAttributeFrom("//*[@id='btnTMS']", "value");
  var flag11 = attrTMS.includes("Unassign");
  await z.assertEqual(flag11, true);

  var attrSIM = await z.grabAttributeFrom("//*[@id='btnSIM']", "value");
  var flag12 = attrSIM.includes("Unassign");
  await z.assertEqual(flag12, true);

  var attrSPM = await z.grabAttributeFrom("//*[@id='btnSPM']", "value");
  var flag13 = attrSPM.includes("Assign");
  await z.assertEqual(flag13, true);

  var attriRequest = await z.grabAttributeFrom("//*[@id='btniRequest']", "value");
  var flag14 = attriRequest.includes("Assign");
  await z.assertEqual(flag14, true);

  await z.click(await TMSLmt.getElement(CreateUserObj.Ctn_MainBtn));

}
  static async DatacheckPage1(){
    var displayname= await z.grabValueFrom(await TMSLmt.getElement(CreateUserObj.Locator_displayName));
    var flag= displayname.includes(await TMSLmt.getData("Value_displayName"));
    logger.info ("printing ..."+flag);
    await z.assertEqual(flag,true);
  }
  static async MasterDatacheckPage1(){
    
    var Orglevl = await z.grabAttributeFrom("//input[@id='organizationLevel_1']", "selectedvaluecode");
    logger.info("Printing...."+Orglevl);
    //await z.assertEqual(Orglevl.toString(),"OU_1-041");
    await z.assertEqual(Orglevl.toString(),await TMSLmt.getData("Org_level_1"));

    var Orglev2= await z.grabAttributeFrom("//input[@id='organizationLevel_2']", "selectedvaluecode");
    logger.info("Printing...."+Orglev2);
    //await z.assertEqual(Orglev2.toString(),"OU_2-039");
    await z.assertEqual(Orglev2.toString(),await TMSLmt.getData("Org_level_2"));

  }
  static async CompanyAllProductSeen(){
  var cars = await TMSLmt.getData("ProductCompanyList");
    for (let i = 0; i < cars.length; i++) {
        await z.see(cars[i]);
    }
  }

  static async checkAssignedProduct(){
    let unassignedcount = await z.grabNumberOfVisibleElements("//*[@title='Unassign']");
    let Assignedcount = await z.grabNumberOfVisibleElements("//*[@title='Assign']");
    logger.info("Un......." + unassignedcount);
    logger.info("As......." + Assignedcount);

    var attrTMS = await z.grabAttributeFrom("//*[@id='btnTMS']", "value");
    var flag = attrTMS.includes("Unassign");
    await z.assertEqual(flag, true);

    var attriRequest = await z.grabAttributeFrom("//*[@id='btniRequest']", "value");
    var flag1 = attriRequest.includes("Assign");
    await z.assertEqual(flag1, true);
  }

  static async RoleList(){
    var cars = await TMSLmt.getData("RoleListProduct");
    for (let i = 0; i < cars.length; i++) {
        await z.fillField(await TMSLmt.getElement(CreateUserObj.RoleSearchField), cars[i]);
        await z.click(await TMSLmt.getElement(CreateUserObj.RoleSearchBtn));
        await z.clearField(await TMSLmt.getElement(CreateUserObj.RoleSearchField));
        await z.see(cars[i]);
    }
  }
  static async RoleAssignedcheck(){
    var cars = await TMSLmt.getData("RoleListAssigned");
    for (let i = 1; i <= cars.length; i++) {
      await z.fillField(await TMSLmt.getElement(CreateUserObj.RoleSearchField), cars[i - 1]);
      await z.click(await TMSLmt.getElement(CreateUserObj.RoleSearchBtn));
      await z.click(`//td[text()="${cars[i - 1]}"]/preceding-sibling::td/input`);
      var a = await z.grabTextFrom("//*[@id='basketCountId']");
      await z.assertEqual(a, i.toString());
    }
    await z.fillField(await TMSLmt.getElement(CreateUserObj.RoleSearchField), cars[1]);
    await z.click(await TMSLmt.getElement(CreateUserObj.RoleSearchBtn));
    await z.click(`//td[text()="${cars[1]}"]/preceding-sibling::td/input`);
    var a = await z.grabTextFrom("//*[@id='basketCountId']");
    await z.assertEqual(a, "2");
}
  static async MulitpleScopeAssignedError(){
    await z.fillField(await TMSLmt.getElement(CreateUserObj.Locator_ScopeNameSearchField), "Admin");
    await z.click(await TMSLmt.getElement(CreateUserObj.Locator_ScopeNameSearchbutton));
    await z.click("//tr[@class='sortrow']//th[1]//label/input");
    await z.click(await TMSLmt.getElement(CreateUserObj.Ctn_MainBtn));
    //await z.see("You cannot select multiple scopes for same Scope Type");
    await z.see(await TMSLmt.getData("Multiple_Scope_Error"));

  }

  static async ScopeAssignCheck(){
    var cars = await TMSLmt.getData("ScopeListAssigned");
    for (let i = 1; i <= cars.length; i++) {
    await z.fillField(await TMSLmt.getElement(CreateUserObj.Locator_ScopeNameSearchField), cars[i-1]);
    await z.click(await TMSLmt.getElement(CreateUserObj.Locator_ScopeNameSearchbutton));
    await z.click(await TMSLmt.getElement(CreateUserObj.Locator_ScopeNameSelectcheckbox));
    var a= await z.grabTextFrom("//*[@id='basketCountId']");
    await z.assertEqual(a,i.toString());
    }

  }

  static async searchbyfullname(FullName) {
    await z.selectOption("//*[@id='searchColumn']", "Name");
    await z.fillField("//*[@id='eventSearchText']", FullName);
    await z.click("//*[@name='SearchButton']");
  }

  static async Searchuserwithfullname(){
    let FullName= await TMSLmt.getData("Userwithfullname");
    await this.searchbyfullname(FullName);
    
  }

  static async Verifyuserwithfullname(){
    var SearchNameEmail = await z.grabTextFrom("//td[@class='filterGridTblTd user-email-left']");
    logger.info("printing.... " + SearchNameEmail);
    await z.assertEqual(await TMSLmt.getData("UserwithnameEmail"), SearchNameEmail);
    
  }

  static async Searchuserwithcasesensativename(){
    let CaseName= await TMSLmt.getData("Userwithcasesensativename");
    await this.searchbyfullname(CaseName);
    
  }

  static async Searchuserwithpartailname(){
    let PartailName= await TMSLmt.getData("UserwithPartialename");
    await this.searchbyfullname(PartailName);
    
  }


}
function getRandominitial(length:number) {
  var result           = '';
  var characters       = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz';
  var charactersLength = characters.length;
  for ( var i = 0; i < length; i++ ) {
     result += characters.charAt(Math.floor(Math.random() * charactersLength));
  }
  return result+"_auto";
}
