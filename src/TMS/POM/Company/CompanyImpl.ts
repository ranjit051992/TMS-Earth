const { I } = inject();
import { Common } from "../../Common/Common";
import { CompanyObj } from "./CompanyObj";
import {prop} from "../../../Framework/FrameworkUtilities/config";
import { logger } from "../../../Framework/FrameworkUtilities/Logger/logger";
import { z } from "actionbot-wrapper/z";
import { TMSLmt } from "../../../Framework/FrameworkUtilities/i18nUtil/readI18NProp";
import { CommonKeyword } from "dd-cc-zycus-automation/dist/components/commonKeyword";
import { Wait } from "dd-cc-zycus-automation/dist/components/dewWait";

var CompanyName = "12nov20" + Common.getRandomNumber1(6);

var CityName = "mum" + Common.getRandomNumber1(6);


export class CompanyImpl {

    static async NavigateToCompanyCreatePage() {
        await z.click(await TMSLmt.getElement(CompanyObj.CREATE_NEW_COMPANY));
        await z.seeTitleEquals("Create New Company - Step 1");
    }
    static async fillBasicInfo() {

        await z.fillField(await TMSLmt.getElement(CompanyObj.COMPANY_NAME), CompanyName);
        await z.click(await TMSLmt.getElement(CompanyObj.IS_DELEGATED_COMPANY));
        await z.click(await TMSLmt.getElement(CompanyObj.IS_ZAUTH_COMPANY));
        await z.fillField(await TMSLmt.getElement(CompanyObj.COMPANY_ALIAS), CompanyName);
        let DomainURL = CompanyName + ".zycus.com";
        await z.fillField(await TMSLmt.getElement(CompanyObj.DOMAIN_URL), DomainURL);
        await z.click(await TMSLmt.getElement(CompanyObj.LOGIN_THROUGH_UNIQUE_ID));
        await z.click(await TMSLmt.getElement(CompanyObj.IS_CHILD_COMPANY));
      //  await z.fillField(await TMSLmt.getElement(CompanyObj.COMPANY_PARENT), await TMSLmt.getData("PARENT_COMPANY_NAME")); await this.selectAutocomplete
        await z.fillField(CompanyObj.COMPANY_PARENT_Locator, await TMSLmt.getData("PARENT_COMPANY_NAME"));
        await z.click(CompanyObj.COMPANY_PARENT_Selector);
        await z.click("//button[@role='button']/span[text()='Ok']");
        await z.fillField(await TMSLmt.getElement(CompanyObj.COMPANY_LOCATION), await TMSLmt.getData("COMPANY_LOCATION_DATA") + "_" + CompanyName);
        await z.fillField(await TMSLmt.getElement(CompanyObj.COMPANY_ADDRESS1), await TMSLmt.getData("COMPANY_ADDRESS1_DATA") + "_" + CompanyName);
        await z.fillField(await TMSLmt.getElement(CompanyObj.COMPANY_ADDRESS2), await TMSLmt.getData("COMPANY_ADDRESS2_DATA") + "_" + CompanyName);
        await z.fillField(await TMSLmt.getElement(CompanyObj.COMPANY_CITY), await TMSLmt.getData("COMPANY_CITY_DATA") + "_" + CompanyName);
        await z.fillField(await TMSLmt.getElement(CompanyObj.COMPANY_STATE), await TMSLmt.getData("COMPANY_STATE_DATA") + "_" + CompanyName);
        await z.fillField(await TMSLmt.getElement(CompanyObj.COMPANY_ZIPCODE), await TMSLmt.getData("COMPANY_ZIPCODE_DATA"));
        await z.selectOption(await TMSLmt.getElement(CompanyObj.COMPANY_COUNTRY), await TMSLmt.getData("COMPANY_COUNTRY_DATA"));
        await z.click(await TMSLmt.getElement(CompanyObj.COMPANY_CONTINUE_NEXT_STEP));
    }
    static async ProductComponentSelection() {
await z.seeTitleEquals("Create New Company - Step 2");
//await CommonKeyword.clickElement (".//*[@id='rainbowCheck']");
//await z.click(await TMSLmt.getElement(CompanyObj.COMPANY_ENABLE_RAINBOW));
//await z.acceptPopup();
//await z.click(await TMSLmt.getElement(CompanyObj.COMPANY_ENABLE_CRMS));
//await z.acceptPopup();
//await z.click(await TMSLmt.getElement(CompanyObj.COMPANY_ENABLE_ONEVIEW));
//await z.acceptPopup();
//await z.click(await TMSLmt.getElement(CompanyObj.COMPANY_ENABLE_COMMONWORKFLOW));
//await z.acceptPopup();
await z.fillField(await TMSLmt.getElement(CompanyObj.COMPANY_TMS_URL), await TMSLmt.getData("COMPANY_TMS_URL_DATA"));
await z.click(await TMSLmt.getElement(CompanyObj.COMPANY_TMS_ACTIVATE));
await z.fillField(await TMSLmt.getElement(CompanyObj.COMPANY_SIM_URL), await TMSLmt.getData("COMPANY_SIM_URL_DATA"));
await z.click(await TMSLmt.getElement(CompanyObj.COMPANY_SIM_ACTIVATE));
//await z.fillField(await TMSLmt.getElement(CompanyObj.COMPANY_FIELD_LIBRARY_URL), await TMSLmt.getData("COMPANY_FIELD_LIBRARY_URL_DATA"));
//await z.click(await TMSLmt.getElement(CompanyObj.COMPANY_FIELD_LIBRARY_ACTIVATE));
//await z.fillField(await TMSLmt.getElement(CompanyObj.COMPANY_EPROC_URL), await TMSLmt.getData("COMPANY_EPROC_URL_DATA"));
//await z.click(await TMSLmt.getElement(CompanyObj.COMPANY_EPROC_ACTIVATE));
//await z.fillField(await TMSLmt.getElement(CompanyObj.COMPANY_IREQUEST_URL), await TMSLmt.getData("COMPANY_IREQUEST_URL_DATA"));
//await z.click(await TMSLmt.getElement(CompanyObj.COMPANY_IREQUEST_ACTIVATE));
await z.fillField(await TMSLmt.getElement(CompanyObj.COMPANY_LMT_URL), await TMSLmt.getData("COMPANY_LMT_URL_DATA"));
await z.click(await TMSLmt.getElement(CompanyObj.COMPANY_LMT_ACTIVATE));
//await z.fillField(await TMSLmt.getElement(CompanyObj.COMPANY_SHT_URL), await TMSLmt.getData("COMPANY_SHT_URL_DATA"));
//await z.click(await TMSLmt.getElement(CompanyObj.COMPANY_SHT_ACTIVATE));
await z.click(await TMSLmt.getElement(CompanyObj.COMPANY_CONTINUE_NEXT_STEP));
    }
    static async UpdateProductComponentupdateSelection() {
        await z.seeTitleEquals("Company Summary");
        await z.click(`//span[text()="Component Selection & Product Allocation"]/following-sibling::label`);
        await Wait.waitForDefaultTimeout(prop.DEFAULT_LOW_WAIT);
        //await z.seeTitleEquals("Product Allocation");
        //await CommonKeyword.clickElement (".//*[@id='rainbowCheck']");
        //await z.click(await TMSLmt.getElement(CompanyObj.COMPANY_ENABLE_RAINBOW));
        //await z.acceptPopup();
        //await z.click(await TMSLmt.getElement(CompanyObj.COMPANY_ENABLE_CRMS));
        //await z.acceptPopup();
        //await z.click(await TMSLmt.getElement(CompanyObj.COMPANY_ENABLE_ONEVIEW));
        //await z.acceptPopup();
        //await z.click(await TMSLmt.getElement(CompanyObj.COMPANY_ENABLE_COMMONWORKFLOW));
        //await z.acceptPopup();
        await z.fillField(await TMSLmt.getElement(CompanyObj.COMPANY_TMS_URL), await TMSLmt.getData("COMPANY_TMS_URL_DATA1"));
        await z.fillField(await TMSLmt.getElement(CompanyObj.COMPANY_SIM_URL), await TMSLmt.getData("COMPANY_SIM_URL_DATA1"));
        await z.click(await TMSLmt.getElement(CompanyObj.COMPANY_CONTINUE_NEXT_STEP));
            }
    static async fillCompanyAdminDetails() {
        await z.seeTitleEquals("Create New Company - Step 3");
        await z.fillField(await TMSLmt.getElement(CompanyObj.COMPANY_ADMIN_FIRST_NAME), "CAFN_" + CompanyName);
        await z.fillField(await TMSLmt.getElement(CompanyObj.COMPANY_ADMIN_LAST_NAME), "CALN_" + CompanyName);
        await z.fillField(await TMSLmt.getElement(CompanyObj.COMPANY_ADMIN_DISPLAY_NAME), "CADN_" + CompanyName);
        await z.fillField(await TMSLmt.getElement(CompanyObj.COMPANY_ADMIN_EMAIL), "CA@" + CompanyName + ".com");
        await z.click(await TMSLmt.getElement(CompanyObj.COMPANY_CONTINUE_NEXT_STEP));

    }
    static async fillPerferences() {
        await z.seeTitleEquals("Create New Company - Step 4");
await z.fillField(await TMSLmt.getElement(CompanyObj.COMPANY_TIMEZONE), await TMSLmt.getData("COMPANY_TIMEZONE_DATA"));
await z.pressKey("ArrowDown");
await z.pressKey("Enter");
await z.selectOption(await TMSLmt.getElement(CompanyObj.COMPANY_NUMBER_FORMAT), await TMSLmt.getData("COMPANY_NUMBER_FORMAT_DATA"));
await z.selectOption(await TMSLmt.getElement(CompanyObj.COMPANY_DATE_FORMAT), await TMSLmt.getData("COMPANY_DATE_FORMAT_DATA"));
await z.selectOption(await TMSLmt.getElement(CompanyObj.COMPANY_TIME_FORMAT), await TMSLmt.getData("COMPANY_TIME_FORMAT_DATA"));
await z.selectOption(await TMSLmt.getElement(CompanyObj.COMPANY_CURRENCY), await TMSLmt.getData("COMPANY_CURRENCY_DATA"));
await z.selectOption(await TMSLmt.getElement(CompanyObj.COMPANY_LOCALE), await TMSLmt.getData("COMPANY_LOCALE_DATA"));
await z.selectOption(await TMSLmt.getElement(CompanyObj.COMPANY_DECIMAL_PRECISION), await TMSLmt.getData("COMPANY_DECIMAL_PRECISION_DATA"));
await z.click(await TMSLmt.getElement(CompanyObj.COMPANY_CONTINUE_NEXT_STEP));
    }
    static async defineCompany() {
        await z.see("CA@" + CompanyName + ".com");
        await z.see("TMS");
        await Wait.waitForDefaultTimeout(prop.DEFAULT_LOW_WAIT);
        //await z.forceClick(await TMSLmt.getElement(CompanyObj.COMPANY_DEFINE_COMPANY));
        await z.click("//*[@id='mainButton']");
    }
    static async VerifyCompanyCreationPopup() {
        await z.see("Success");
        //await z.see(Wait.waitForDefaultTimeout(prop.DEFAULT_LOW_WAIT)"Success");
        //await z.see(CompanyName);
        //await z.click("//button[@role='button']/span[text()='Ok']");
        await z.click("//button[@role='button']/span[text()='Ok']");
        //await z.click(await TMSLmt.getElement(CompanyObj.COMPANY_CREATEPOPUP_COMPANY));
    }
    static async searchCompany() {
        await z.fillField(await TMSLmt.getElement(CompanyObj.COMPANY_LISTING_SEARCH_BY_VALUE), CompanyName);
        await z.click(await TMSLmt.getElement(CompanyObj.COMPANY_LISTING_SEARCH_COMPANY_BUTTON));
        var Searchedcompany = await z.grabTextFrom(".//*[@class='filterGridTblTd fixed-left']");
        logger.info("print "+Searchedcompany);
        logger.info("print "+CompanyName);
        await z.assertEqual(Searchedcompany,CompanyName);
    }
    static async activateCompany() {
        await this.searchCompany1(await TMSLmt.getData("COMPANY_ACTIVE_DEACTIVE_DATA"));
        await z.click(".//*[@title='Inactive Company']")
        await z.click("//button[@role='button']/span[text()='Ok']");
    }
    static async searchCompany1(CompName) {
        await z.fillField(await TMSLmt.getElement(CompanyObj.COMPANY_LISTING_SEARCH_BY_VALUE), CompName);
        await z.click(await TMSLmt.getElement(CompanyObj.COMPANY_LISTING_SEARCH_COMPANY_BUTTON));
        let findcompany = await z.grabTextFrom(".//*[@class='filterGridTblTd fixed-left']");
        await z.assertEqual(CompName,findcompany);
    }
    static async verifyCompanyActive() {
        await this.searchCompany1(await TMSLmt.getData("COMPANY_ACTIVE_DEACTIVE_DATA"));
        await z.see("Active");
    }
    static async deactivateCompany() {
        await this.searchCompany1(await TMSLmt.getData("COMPANY_ACTIVE_DEACTIVE_DATA"));
        await z.click(".//*[@title='Active Company']")
        await z.click("//button[@role='button']/span[text()='Ok']");
    }
    static async verifyCompanyDeActive() {
        await this.searchCompany1(await TMSLmt.getData("COMPANY_ACTIVE_DEACTIVE_DATA"));
        await z.see("Inactive");
    }

    static async NavigatetoEditPage() {
        await this.searchCompany1(await TMSLmt.getData("COMPANY_EDIT_NAME"));
        await z.click(".//*[@title='Edit Company Information']");
    }
    static async updateCompanyBasicDetails() {
        await z.seeTitleEquals("Company Summary");
        await z.click(`//span[text()="Basic Information"]/following-sibling::label`);
        await z.seeTitleEquals("Edit Existing Company");
        await z.fillField(await TMSLmt.getElement(CompanyObj.COMPANY_CITY), CityName);
        await z.click(await TMSLmt.getElement(CompanyObj.COMPANY_CONTINUE_NEXT_STEP));
    }
    static async VerifyCompanyUpdatePopup() {
        await z.see("Success");
        await z.see(await TMSLmt.getData("COMPANY_EDIT_NAME"));
        await z.click("//button[@role='button']/span[text()='Ok']");
       //comment 
    }

    static async Companycreatedname() {
        await z.see(CompanyName);
        
    }
}
