const { I } = inject();
import { Common } from "../../Common/Common";
import { UserExportObj } from "./UserExportObj";
import { z } from "actionbot-wrapper/z";
import { TMSLmt } from "../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp";

export class UserExportImpl
{
   static async selectProduct()
     {  
        var products = UserExportObj.ProductList;
        for (let i = 0; i < products.length; i++) 
        {
        await z.click(`//div[@class='cust-drop-inner']/div[@class='drop-row']/input[@value='${products[i]}']`);
        }        
     }

   static async ExportUserData()
   {
      await z.click(await TMSLmt.getElement(UserExportObj.ExportUserData));
      await z.click(await TMSLmt.getElement(UserExportObj.UserExpPopUpOK));
   }

   static async UserEmailExportUserData()
   {
      await z.click(await TMSLmt.getElement(UserExportObj.UserEmailExportUserData));
      await z.click(await TMSLmt.getElement(UserExportObj.UserEmailExportLink));
      await z.click(await TMSLmt.getElement(UserExportObj.UserExpPopUpOK));
   }

   static async BellIconClick()
   {
      await z.click(await TMSLmt.getElement(UserExportObj.BellIcon));
      await z.click(await TMSLmt.getElement(UserExportObj.BellIconExportTab));
   }

   
   static async BellIconAuditClick()
   {
      await z.click(await TMSLmt.getElement(UserExportObj.AuditBellIcon));
   }

   static async ExcelDwnloadBulkEditUsers()
   {
      await z.click(await TMSLmt.getElement(UserExportObj.AllUserBulkEditDownloadBtn));
      await z.click(await TMSLmt.getElement(UserExportObj.AllUserBulkEditConfirmationOK));
   }

   static async SelectStatus()
   {
      await z.click(await TMSLmt.getElement(UserExportObj.FilteredListSelectStatusOption));
      await z.click(await TMSLmt.getElement(UserExportObj.Inactive));
   }

   static async FillReportingMgr()
   {
      //  await I.fillField(UserExportObj.FilteredListReportingMgrTxtBox,UserExportObj.ReportingManagerValue);
      await z.fillField(await TMSLmt.getElement(UserExportObj.FilteredListReportingMgrTxtBox), await TMSLmt.getData("ReportingManagerValue"));
      //await z.click(await TMSLmt.getElement(UserExportObj.RepMgrFieldAfterSelection));
      //await z.click(await TMSLmt.getElement(UserExportObj.RepMgrFieldAfterSelection));
      await z.click(await TMSLmt.getData("ReportingManagerSelectionValue"));
      await z.click(await TMSLmt.getData("ReportingManagerSelectionValue"));
   }

   static async assignProduct()
   {
      await z.click(await TMSLmt.getElement(UserExportObj.ProductDDTxtBox));
      await z.waitForElement(UserExportObj.ProductsDDBox);
      var products = UserExportObj.ProductList;
        for (let i = 0; i < products.length; i++) 
         {
            await z.click(`//div[@class='cust-drop-inner']/div[@class='drop-row']/input[@value='${products[i]}']`);
         }
            //   I.wait(10);
            //  await I.click(UserExportObj.ProductDDTxtBox);
      await z.click(await TMSLmt.getElement(UserExportObj.ProductDDTxtBox));
   }

   static async DwnloadFilteredList()
   {
      await z.click(await TMSLmt.getElement(UserExportObj.FilteredListDwnloadBtn));
      await z.click(await TMSLmt.getElement(UserExportObj.AllUserBulkEditConfirmationOK));
   }

   static async attachFile()
   {
      await z.click(await TMSLmt.getElement(UserExportObj.UserUploadBrowse));
      await z.attachFile("//input[@value='Browse']", 'UploadUserTemplate.xlsx');
   }

   static async uploadFile()
   {
    await z.click(await TMSLmt.getElement(UserExportObj.UserUpload));
    await z.click(await TMSLmt.getElement(UserExportObj.exportConfirmation));
   }
}
  
// module.exports = new UserExportImpl();
// module.exports.UserExportImpl=UserExportImpl; // for inheritance