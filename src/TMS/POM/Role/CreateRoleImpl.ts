const { I } = inject();
import { Common } from "../../Common/Common";
import { logger } from "../../../Framework/FrameworkUtilities/Logger/logger";
// import { CommonComponent } from "../../commonKeywords/CommonComponent";
import { z } from "actionbot-wrapper/z";
import { TMSLmt } from "../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp";
import { CreateRoleObj } from "./CreateRoleObj";
import { CommonKeyword } from "dd-cc-zycus-automation/dist/components/commonKeyword";
import { DataIntegrity } from "dd-dataintegrity/src/DataIntegrity";
import { Wait } from "dd-cc-zycus-automation/dist/components/dewWait";
import { prop } from "../../../Framework/FrameworkUtilities/config";


var existingRoleDesc ="";
var UpdateRoleDes = "";
let a = Common.getRandomNumber1(4);
let ZARoleName = "za" + a.toString();

var RoleName = getRandomforRole(5) + "_automation";
var RoleName1 = getRandomforRole(5) + "_autorole";
var UpdateRoleDes = "";

export class CreateRoleImpl{
    static async SearchRole(role)
        {
            await z.fillField(await TMSLmt.getElement(CreateRoleObj.SearchRole), role);
           //await z.fillField(await TMSLmt.getElement(CreateRoleObj.SearchRole), RoleName);
            await z.click(await TMSLmt.getElement(CreateRoleObj.GoBtn));
        //     await I.click(CreateRoleObj.GoBtn); 
        //     I.wait(2);
        }
        
        static async NavigateTo(xpath) 
        {
        //      I.click(xpath);
             await CommonKeyword.clickElement(xpath);
        }

        static async DeactivateRole() 
        {
                // I.click(CreateRoleObj.Deactivate);
                await CreateRoleImpl.SearchRole(RoleName1);
                await z.click(await TMSLmt.getElement(CreateRoleObj.Deactivate));
                // I.click(CreateRoleObj.Confirmation);
                await z.click(await TMSLmt.getElement(CreateRoleObj.Confirmation));
        }

        static async DeactivateNewRole() 
        {
                // I.click(CreateRoleObj.Deactivate);
                await CreateRoleImpl.SearchRole(RoleName);
                await z.click(await TMSLmt.getElement(CreateRoleObj.Deactivate));
                // I.click(CreateRoleObj.Confirmation);
                await z.click(await TMSLmt.getElement(CreateRoleObj.Confirmation));
        }

        static async ActivateRole() 
        {   
                // I.click(CreateRoleObj.Activate);
                await z.click(await TMSLmt.getElement(CreateRoleObj.Activate));
                // I.wait(2);
                // I.click(CreateRoleObj.Confirmation);
                await z.click(await TMSLmt.getElement(CreateRoleObj.Confirmation));
                // I.wait(2);      
        }

        static async EditRole()
        {
                // I.click(CreateRoleObj.EditRole);
                await z.click(await TMSLmt.getElement(CreateRoleObj.EditRole));
                // I.wait(5);
                // I.click(CreateRoleObj.EditRoleInfo);
                await z.click(await TMSLmt.getElement(CreateRoleObj.EditRoleInfo));
                // I.wait(5);
        }

        static async EditNewRole()
        {
                // I.click(CreateRoleObj.EditRole);
                await z.click(await TMSLmt.getElement(CreateRoleObj.EditRole));
                // I.wait(5);
                // I.click(CreateRoleObj.EditRoleInfo);
                await z.click(await TMSLmt.getElement(CreateRoleObj.EditRoleInfo));
                // I.wait(5);
        }

        static async activateRole() {
                await this.SearchRole(await TMSLmt.getData("StaticRole_ACTIVATE"));
                await this.ActivateRole();
                // I.wait(10);
                // I.refreshPage();
        }
        static async verifyRoleActivation() {
                //I.waitForClickable(CreateRoleObj.SearchRole);
                await this.SearchRole(await TMSLmt.getData("StaticRole_ACTIVATE"));
                // I.wait(5);
                 var ExpStatus= await z.grabTextFrom(CreateRoleObj.Deactivate);
                 await z.assertEqual("Active",ExpStatus);
                //reverting back to inactive state
                await this.DeactivateRole();
                // I.wait(10);
                // I.refreshPage();
        }
        static async makeChangestoRoleDesc() {
                this.SearchRole(await TMSLmt.getData("StaticRole_Edit"));
   
                var ER = '//td[text()="'+ TMSLmt.getData("StaticRole_Edit") +'"]/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/label[1]';
                //"//tr[@class='filterGridTblTd']/td[5]/label[1]"
                await z.click(ER);
                await z.click(await TMSLmt.getElement(CreateRoleObj.EditRoleInfo));


                existingRoleDesc = await z.grabTextFrom(CreateRoleObj.RoleDesc);
                console.log(existingRoleDesc);
    
                UpdateRoleDes = Common.getRandomNumber1(3)+"_UpdateThroughAutomation";
                z.fillField(await TMSLmt.getElement(CreateRoleObj.RoleDesc), UpdateRoleDes);
                await z.click(await TMSLmt.getElement(CreateRoleObj.UpdateSave));
                await z.click(await TMSLmt.getElement(CreateRoleObj.DoneBtn));

        }

        static async descUpdated() {
                await z.refreshPage();
                await this.SearchRole(await TMSLmt.getData("StaticRole_Edit"));
                // I.wait(3);
                await this.EditRole();
                var UpdatedRoleDesc = z.grabTextFrom(CreateRoleObj.RoleDesc).toString();
                console.log(UpdatedRoleDesc);
                //I.assertEqual(UpdateRoleDes,UpdatedRoleDesc);
        }

        static async ZAEditRole() {
                await this.SearchRole(await TMSLmt.getData("ZA_StaticRole_Edit"));
                var ZA_ER = '//td[text()="'+ TMSLmt.getData("ZA_StaticRole_Edit") +'"]/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/label[1]';
                // z.click(ZA_ER);
                await z.click(ZA_ER);
                // I.wait(5);
                await z.click(await TMSLmt.getElement(CreateRoleObj.EditRoleInfo));
                // I.click(CreateRoleObj.EditRoleInfo);
                // I.wait(5);     
        }
        static async MakeChangesForZARoleUpdate(){
                await this.ZAEditRole();
                UpdateRoleDes = getRandomforRole(3)+ "_UpdateThroughAutomation";
                z.fillField(await TMSLmt.getElement(CreateRoleObj.RoleDesc), UpdateRoleDes);
                await z.click(await TMSLmt.getElement(CreateRoleObj.ZA_UpdateSave));
                // z.wait(2);
                await z.click(await TMSLmt.getElement(CreateRoleObj.DoneBtn));
                // z.wait(3);
        }

        static async VerificationZARoleUpdation(){
                await this.verifyRoleUpdated();
                var UpdatedRoleDesc = await z.grabTextFrom(CreateRoleObj.RoleDesc);
                z.assertEqual(UpdateRoleDes,UpdatedRoleDesc);
        }

        static async verifyRoleUpdated() {
                await this.SearchRole(await TMSLmt.getData("ZA_StaticRole_Edit"));
                //z.wait(3);
                await this.EditRole();
        }

        static async ZAAssignRole(){
                await this.SearchRole(await TMSLmt.getData("ZA_StaticRole_Edit"));
                await z.click(await TMSLmt.getElement(CreateRoleObj.AssignRole));
                var User = z.grabTextFrom(CreateRoleObj.AddUser);
                console.log(User);
                await z.click(await TMSLmt.getElement(CreateRoleObj.AddUser));
                await z.click(await TMSLmt.getElement(CreateRoleObj.SaveBtn3));
        }

        static async activateZARole() {
                await this.SearchRole(await TMSLmt.getData("ZA_StaticRole"));
                await this.ActivateRole();
                // I.wait(10);
                z.refreshPage();
        }
        static async verifyZARoleActivation() {
                //I.waitForClickable(CreateRoleObj.SearchRole);
                await this.SearchRole(await TMSLmt.getData("ZA_StaticRole"));
                // I.wait(5);
                 var ExpStatus= await z.grabTextFrom(CreateRoleObj.Deactivate);
                 z.assertEqual("Active",ExpStatus);
                //reverting back to inactive state
                await this.DeactivateRole();
                // I.wait(10);
                z.refreshPage();
        }

        static async deactivateZARole() {
                await this.SearchRole(await TMSLmt.getData("ZA_StaticRole"));
                // I.wait(5);
                await z.click("//label[@title='Active Role']");
                // I.wait(2);await z.click(await TMSLmt.getElement(CreateRoleObj.DoneBtn));
                await z.click(await TMSLmt.getElement(CreateRoleObj.Confirmation));
                // I.wait(2);
                //this.DeactivateRole;
               // I.wait(5);
                z.refreshPage()
        }

        static async editedtherole() {
                await this.SearchRole(await TMSLmt.getData("ZA_StaticRole_Edit"));
                // I.wait(5);
                //await z.click("//label[@title='Active Role']");//*[@id="company-role-management-grid"]/tbody/tr/td[5]/label
                await z.click("//*[@id='company-role-management-grid']/tbody/tr/td[5]/label");
                // I.wait(2);await z.click(await TMSLmt.getElement(CreateRoleObj.DoneBtn));
                await z.click(await TMSLmt.getElement(CreateRoleObj.Confirmation));
                // I.wait(2);
                //this.DeactivateRole;
               // I.wait(5);
                z.refreshPage()
        }

        static async verifyZARoleDeactivation() {
                //I.waitForClickable(CreateRoleObj.SearchRole);
                // I.wait(5);
                await this.SearchRole(await TMSLmt.getData("ZA_StaticRole"));

                var ExpStatus= await z.grabTextFrom(CreateRoleObj.Activate);
                await z.assertEqual("Inactive",ExpStatus);
                //reverting back to active state
                await this.ActivateRole();
                // I.wait(10);
                await z.refreshPage();
        }

        static async searchCompany() {
                // Common.fillfields(CreateRoleObj.CompSearch,CreateRoleObj.CompToBeSearched--TMSLmt.getData(CompToBeSearched));
                await z.fillField(await TMSLmt.getElement(CreateRoleObj.CompSearch), await TMSLmt.getData("CompToBeSearched"));
                // I.wait(2);
                // I.click(CreateRoleObjGoBtn);
                await z.click(await TMSLmt.getElement(CreateRoleObj.GoBtn));
                // I.wait(5);
                // I.click(CreateRoleObj.UserListingIcon);
                await z.click(await TMSLmt.getElement(CreateRoleObj.UserListingIcon));
                // I.wait(5);
        }

        static async FillRoleDetails() {
                await z.fillField(await TMSLmt.getElement(CreateRoleObj.RoleTitleTxtBox),RoleName1);
                //let role_namefordata: string = "["+RoleName1+"]";
                DataIntegrity.actualDatamap("Create Role Name",RoleName1);
                await z.fillField(await TMSLmt.getElement(CreateRoleObj.RoleDesc),"automationScript");
                DataIntegrity.actualDatamap("Create Role Description","automationScript");
                // await z.selectOption("//select[@id='cmbAssignProduct']","TMS");
                await z.selectOption(await TMSLmt.getElement(CreateRoleObj.ProductSelection),await TMSLmt.getData("RoleForProduct"));
                DataIntegrity.actualDatamap("Create Role Product",await TMSLmt.getData("RoleForProduct"));
                DataIntegrity.actualDatamap("Role activity created by",await TMSLmt.getData("CA_EmailAddress"));
                await z.click(await TMSLmt.getElement(CreateRoleObj.SaveBtn));
        }

        static async FillRoleRoleActDetails() {
                await z.fillField(await TMSLmt.getElement(CreateRoleObj.RoleTitleTxtBox),RoleName);
                //let role_namefordata: string = "["+RoleName1+"]";
                DataIntegrity.actualDatamap("Create Role Name",RoleName);
                await z.fillField(await TMSLmt.getElement(CreateRoleObj.RoleDesc),"automationScript");
                DataIntegrity.actualDatamap("Create Role Description","automationScript");
                // await z.selectOption("//select[@id='cmbAssignProduct']","TMS");
                await z.selectOption(await TMSLmt.getElement(CreateRoleObj.ProductSelection),await TMSLmt.getData("RoleForProduct"));
                DataIntegrity.actualDatamap("Create Role Product",await TMSLmt.getData("RoleForProduct"));
                DataIntegrity.actualDatamap("Role activity created by",await TMSLmt.getData("CA_EmailAddress"));
                await z.click(await TMSLmt.getElement(CreateRoleObj.SaveBtn));
        }

        static async Rolecreatedname() {
        await z.see(RoleName1);
        }
        
        
        static async NewRoleAdded(){
                await Wait.waitForDefaultTimeout(prop.DEFAULT_LOW_WAIT);
                await Wait.waitForDefaultTimeout(prop.DEFAULT_HIGH_WAIT);
                z.refreshPage();
                await Wait.waitForDefaultTimeout(prop.DEFAULT_LOW_WAIT);
                await this.SearchRole(RoleName1);
                var a = '//td[text()="'+ RoleName1 +'"]';
                var RoleAdded = await z.grabTextFrom(a);
                console.log(RoleAdded);
                await this.EditNewRole();
                
                var RoleCreatedName = await z.grabValueFrom('#txtRoleTitle')
                //logger.info("=======>  "+RoleCreatedName.toString().replace(/ *\([^)]*\) */g,''));
                var RoleCreatedName = RoleCreatedName.toString().replace(/ *\([^)]*\) */g,'');
                DataIntegrity.expectedDatamap("Create Role Name Expected",RoleCreatedName);
                z.assertEqual(DataIntegrity.actualData().get("Create Role Name"), DataIntegrity.expectedData().get("Create Role Name Expected"));

                let CreatedRoleDesc = await z.grabTextFrom(await TMSLmt.getElement(CreateRoleObj.RoleDesc));
                logger.info(CreatedRoleDesc);
                DataIntegrity.expectedDatamap("Create Role Description Expected",CreatedRoleDesc);
                z.assertEqual(DataIntegrity.actualData().get("Create Role Description"), DataIntegrity.expectedData().get("Create Role Description Expected"));

                var RoleCreatedProduct = await z.grabValueFrom('#cmbAssignProduct');
                //logger.info(RoleCreatedProduct);
                var RoleCreatedProduct = RoleCreatedProduct.toString().replace(/ *\([^)]*\) */g,'');
                DataIntegrity.expectedDatamap("Create Role Product Expected",RoleCreatedProduct);
                z.assertEqual(DataIntegrity.actualData().get("Create Role Product"), DataIntegrity.expectedData().get("Create Role Product Expected"));
                // I.wait(5);

                var RoleActivityCreatedby = await z.grabValueFrom('#txtRoleCreatedBy');
                //logger.info("=======>  "+RoleCreatedName.toString().replace(/ *\([^)]*\) */g,''));
                var RoleActivityCreatedby = RoleActivityCreatedby.toString().replace(/ *\([^)]*\) */g,'');
                DataIntegrity.expectedDatamap("Role activity created by Expected",RoleActivityCreatedby);
                z.assertEqual(DataIntegrity.actualData().get("Role activity created by"), DataIntegrity.expectedData().get("Role activity created by Expected"));

                await z.click(await TMSLmt.getElement(CreateRoleObj.RolebasicBackBtn));

                //var RoleActivityCA = await z.grabValueFrom(await TMSLmt.getElement(CreateRoleObj.AcvtivityassignedtoroleCA));
                //var RoleActivityCA = await z.grabValueFrom("//td[text()='COMPANY ADMIN']");
                //logger.info("=======>  "+RoleActivityCA.toString().replace(/ *\([^)]*\) */g,''));
                //var RoleActivityCA = RoleActivityCA.toString().replace(/ *\([^)]*\) */g,'');
                //DataIntegrity.expectedDatamap("Assigned SubActivity Name Expected",RoleActivityCA);
                //z.assertEqual(DataIntegrity.actualData().get("Assigned SubActivity Name"), DataIntegrity.expectedData().get("Assigned SubActivity Name Expected"));

                //await z.see("COMPANY ADMIN");
                await z.see(await TMSLmt.getData("Company_admin_role"));

                await z.click(await TMSLmt.getElement(CreateRoleObj.RoleMainCancelBtn));

        }
        

        static async NewRolethroughrolemgmactAdded(){
                z.refreshPage();
                await this.SearchRole(RoleName);
                var a = '//td[text()="'+ RoleName +'"]';
                var RoleAdded = await z.grabTextFrom(a);
                console.log(RoleAdded);
                await this.EditNewRole();
                
                var RoleCreatedName = await z.grabValueFrom('#txtRoleTitle')
                //logger.info("=======>  "+RoleCreatedName.toString().replace(/ *\([^)]*\) */g,''));
                var RoleCreatedName = RoleCreatedName.toString().replace(/ *\([^)]*\) */g,'');
                DataIntegrity.expectedDatamap("Create Role Name Expected",RoleCreatedName);
                z.assertEqual(DataIntegrity.actualData().get("Create Role Name"), DataIntegrity.expectedData().get("Create Role Name Expected"));

                let CreatedRoleDesc = await z.grabTextFrom(await TMSLmt.getElement(CreateRoleObj.RoleDesc));
                logger.info(CreatedRoleDesc);
                DataIntegrity.expectedDatamap("Create Role Description Expected",CreatedRoleDesc);
                z.assertEqual(DataIntegrity.actualData().get("Create Role Description"), DataIntegrity.expectedData().get("Create Role Description Expected"));

                var RoleCreatedProduct = await z.grabValueFrom('#cmbAssignProduct');
                //logger.info(RoleCreatedProduct);
                var RoleCreatedProduct = RoleCreatedProduct.toString().replace(/ *\([^)]*\) */g,'');
                DataIntegrity.expectedDatamap("Create Role Product Expected",RoleCreatedProduct);
                z.assertEqual(DataIntegrity.actualData().get("Create Role Product"), DataIntegrity.expectedData().get("Create Role Product Expected"));
                // I.wait(5);

                var RoleActivityCreatedby = await z.grabValueFrom('#txtRoleCreatedBy');
                //logger.info("=======>  "+RoleCreatedName.toString().replace(/ *\([^)]*\) */g,''));
                var RoleActivityCreatedby = RoleActivityCreatedby.toString().replace(/ *\([^)]*\) */g,'');
                DataIntegrity.expectedDatamap("Role activity created by Expected",RoleActivityCreatedby);
                z.assertEqual(DataIntegrity.actualData().get("Role activity created by"), DataIntegrity.expectedData().get("Role activity created by Expected"));

                await z.click(await TMSLmt.getElement(CreateRoleObj.RolebasicBackBtn));

                //var RoleActivityCA = await z.grabValueFrom(await TMSLmt.getElement(CreateRoleObj.AcvtivityassignedtoroleCA));
                //var RoleActivityCA = await z.grabValueFrom("//td[text()='COMPANY ADMIN']");
                //logger.info("=======>  "+RoleActivityCA.toString().replace(/ *\([^)]*\) */g,''));
                //var RoleActivityCA = RoleActivityCA.toString().replace(/ *\([^)]*\) */g,'');
                //DataIntegrity.expectedDatamap("Assigned SubActivity Name Expected",RoleActivityCA);
                //z.assertEqual(DataIntegrity.actualData().get("Assigned SubActivity Name"), DataIntegrity.expectedData().get("Assigned SubActivity Name Expected"));

                //await z.see("COMPANY ADMIN");
                await z.see(await TMSLmt.getData("Company_admin_role"));

                await z.click(await TMSLmt.getElement(CreateRoleObj.RoleMainCancelBtn));

        }


        static async AssignCreatedRole(){
                await z.click(await TMSLmt.getElement(CreateRoleObj.AssignRole));
                await z.click(await TMSLmt.getElement(CreateRoleObj.AddUser));
                await z.click(await TMSLmt.getElement(CreateRoleObj.SaveBtn3));
        }

        static async AssignCreatedNewRole(){
                await z.click(await TMSLmt.getElement(CreateRoleObj.AssignRole));
                await z.click(await TMSLmt.getElement(CreateRoleObj.AddUser));
                await z.click(await TMSLmt.getElement(CreateRoleObj.SaveBtn3));
        }

        static async MakeChangesForRoleEdit(){
                await this.SearchRole(await TMSLmt.getData("StaticRole_Edit"));
                var ER = '//td[text()="'+ (await TMSLmt.getData("StaticRole_Edit")) +'"]/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/label[1]';
                await z.click(ER);
                await z.click(await TMSLmt.getElement(CreateRoleObj.EditRoleInfo));
            
                existingRoleDesc = await z.grabTextFrom(await TMSLmt.getElement(CreateRoleObj.RoleDesc));
                console.log(existingRoleDesc);
                UpdateRoleDes = getRandomforRole(3)+"_UpdateThroughAutomation";
                await z.fillField(await TMSLmt.getElement(CreateRoleObj.RoleDesc), UpdateRoleDes);
                DataIntegrity.actualDatamap("Update Role Description",UpdateRoleDes);
                await z.click(await TMSLmt.getElement(CreateRoleObj.UpdateSave));

                await z.click(await TMSLmt.getElement(CreateRoleObj.RoleActassignEditBtn));
                
                await z.click(await TMSLmt.getElement(CreateRoleObj.selectmainactcheck));
                await z.click(await TMSLmt.getElement(CreateRoleObj.selectCAsubactheck));
                await z.click(await TMSLmt.getElement(CreateRoleObj.selectLAsubactheck));
                DataIntegrity.actualDatamap("Assigned SubActivity Updated Name",await TMSLmt.getData("Local_admin_role"));
                await z.click(await TMSLmt.getElement(CreateRoleObj.SaveBtn2));


                await z.click(await TMSLmt.getElement(CreateRoleObj.DoneBtn));
        }

        static async MakeChangesForRoleupdateEdit(){
                await this.SearchRole(RoleName1);
                var ER = '//td[text()="'+ (RoleName1) +'"]/following-sibling::td/following-sibling::td/following-sibling::td/following-sibling::td/label[1]';
                await z.click(ER);
                await z.click(await TMSLmt.getElement(CreateRoleObj.EditRoleInfo));
            
                existingRoleDesc = await z.grabTextFrom(await TMSLmt.getElement(CreateRoleObj.RoleDesc));
                console.log(existingRoleDesc);
                UpdateRoleDes = getRandomforRole(3)+"_UpdateThroughAutomation";
                await z.fillField(await TMSLmt.getElement(CreateRoleObj.RoleDesc), UpdateRoleDes);
                DataIntegrity.actualDatamap("Update Role Description",UpdateRoleDes);
                await z.click(await TMSLmt.getElement(CreateRoleObj.UpdateSave));

                await z.click(await TMSLmt.getElement(CreateRoleObj.RoleActassignEditBtn));
                
                await z.click(await TMSLmt.getElement(CreateRoleObj.selectmainactcheck));
                await z.click(await TMSLmt.getElement(CreateRoleObj.selectCAsubactheck));
                await z.click(await TMSLmt.getElement(CreateRoleObj.selectReportssubactheck));
                DataIntegrity.actualDatamap("Assigned SubActivity Updated Name",await TMSLmt.getData("Report_role"));
                await z.click(await TMSLmt.getElement(CreateRoleObj.SaveBtn2));


                await z.click(await TMSLmt.getElement(CreateRoleObj.DoneBtn));
        }
        
        static async VerifyEditRoleDone(){
                z.refreshPage();
                //await this.SearchRole(await TMSLmt.getData("StaticRole_Edit"));
                await this.SearchRole(RoleName1);
                await this.EditRole();
                let UpdatedRoleDesc = await z.grabTextFrom(await TMSLmt.getElement(CreateRoleObj.RoleDesc));
                // console.log(UpdatedRoleDesc);
                logger.info(UpdatedRoleDesc);
                //await z.assertEqual(UpdateRoleDes,UpdatedRoleDesc);
                DataIntegrity.expectedDatamap("Update Role Description Expected",UpdatedRoleDesc);
                z.assertEqual(DataIntegrity.actualData().get("Update Role Description"), DataIntegrity.expectedData().get("Update Role Description Expected"));

                await z.click(await TMSLmt.getElement(CreateRoleObj.RolebasicBackBtn));

                //await z.see("LOCAL ADMIN");
                await z.see(await TMSLmt.getData("Report_role"));

                await z.click(await TMSLmt.getElement(CreateRoleObj.RoleMainCancelBtn));

        }

        static async CheckRoleinAudit(){
                await z.see(RoleName1);
        }
                
        static async CheckRoleinAuditInLink(){
                //await z.click("//span[text()='Role Updated through  UI']");
                //await z.see(await TMSLmt.getData("StaticRole_Edit"));
                await z.see(RoleName1);
                await z.see("Role Updated");
        }

        static async RoleShouldDeactivate(){
                await z.waitForClickable(await TMSLmt.getElement(CreateRoleObj.SearchRole));
                await this.SearchRole(await TMSLmt.getData("StaticRole"));
                var ExpStatus= await z.grabTextFrom(CreateRoleObj.Activate);
                //reverting back to active state
                await this.SearchRole(await TMSLmt.getData("StaticRole"));
                await this.ActivateRole();
                z.refreshPage();
        }

        static async ChangeRoleStatus(){
                await this.SearchRole(await TMSLmt.getData("StaticRole"));
                // I.wait(5);
                var a = await z.grabTextFrom("//*[@id='user-role-management-grid']/tbody/tr/td[4]/label");
                if (a == 'Active')
                {
                await z.click("//*[@id='user-role-management-grid']/tbody/tr/td[4]/label");
                // I.click();
                // I.wait(2);
                await z.click(await TMSLmt.getElement(CreateRoleObj.Confirmation));
                // I.click(CreateRoleObj.Confirmation);
                // I.wait(2);
                z.refreshPage();
                await this.SearchRole(await TMSLmt.getData("StaticRole"));                                                                                                                                                                                                                                                                                                                                                                              
                // I.wait(5);
                var b = await z.grabTextFrom("//*[@id='user-role-management-grid']/tbody/tr/td[4]/label");
                //await z.assertEqual(b, "Inactive")
                }
                else
                {
                await z.click("//*[@id='user-role-management-grid']/tbody/tr/td[4]/label");
                await z.click(await TMSLmt.getElement(CreateRoleObj.Confirmation));
                await z.refreshPage();
                await this.SearchRole(await TMSLmt.getData("StaticRole"));
                var b = await z.grabTextFrom("//*[@id='user-role-management-grid']/tbody/tr/td[4]/label");
                //await z.assertEqual(b, "Active")
                }
        }
                static async AssignStaticRole(){
                await this.SearchRole(await TMSLmt.getData("AssingedRoleUser"));
                await z.click(await TMSLmt.getElement(CreateRoleObj.AssignRole));            
                await z.click(await TMSLmt.getElement(CreateRoleObj.AddUser));
                await z.click(await TMSLmt.getElement(CreateRoleObj.SaveBtn3));
        }
}

// module.exports = new CreateRole();
// module.exports.CreateRole=CreateRole; // for inheritance 

function getRandomforRole(length:number) {
        var result           = '';
        var characters       = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
        var charactersLength = characters.length;
        for ( var i = 0; i < length; i++ ) {
           result += characters.charAt(Math.floor(Math.random() * charactersLength));
        }
        return result+"_auto";
     }