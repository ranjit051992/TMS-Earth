import { z } from "actionbot-wrapper/z";
import { logger } from "../../Framework/FrameworkUtilities/Logger/logger";
import { TMSLmt } from "../../Framework/FrameworkUtilities/i18nUtil/readI18NProp";
import { CreateReportObj } from "../../../src/TMS/POM/Reports/CreateReportObj";

const { I } = inject();
export class  Common {

     static getRandomNumber(length) {
        var result           = '';
        var characters       = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
        var charactersLength = characters.length;
        for ( var i = 0; i < length; i++ ) {
           result +=  characters.charAt(Math.floor(Math.random() * charactersLength));
        }
        logger.info(result)
        return result+"_auto";
     }
     static getRandomNumber1(length) {
      var result           = '';
      var characters       = '0123456789';
      var charactersLength = characters.length;
      for ( var i = 0; i < length; i++ ) {
         result += characters.charAt(Math.floor(Math.random() * charactersLength));
      }
      return result;
   }
      static async selectInNextMonth(locator, date) {
        await z.waitForVisible(locator);
        await z.waitForClickable(locator);
        await z.click(locator);
        await z.click("show next month", ".d-picker");
        await z.click(`//*[text()='${date}']`);
    }


//     static async selectPreviousMonthDate(locator: string, date: string) {
//       await z.click(locator);
//       await z.click(await TMSLmt.getElement(OnlineStoreObject.SHOW_PREVIOUS_MONTH), await TMSLmt.getElement(OnlineStoreObject.DATE_PICKER_CONTEXT));
//       await z.click(date, await TMSLmt.getElement(OnlineStoreObject.DATE_PICKER_CONTEXT));
//   }
   }