package com.zycus.automation.eproc.pageobjects.pages.settings.masterdatatenantlevelconfig;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.eproc.pageobjects.pages.settings.buyersdesksettings.IPageBuyersDeskSettingsImpl;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPageMasterDataTenantLevelConfigSettingsImpl implements IPageMasterDataTenantLevelConfigSettings
{

	static Logger logger = Logger.getLogger(IPageMasterDataTenantLevelConfigSettingsImpl.class);

	@Override
	public void removePurchaseType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.clear(driver, TEXTBOX_EPROC_ENTITY_PURCHASE_TYPE);

	}

	@Override
	public String addPurchaseType(WebDriver driver, String testCaseName, String purchaseType) throws ActionBotException
	{
		ActionBot.sendKeys(driver, TEXTBOX_EPROC_ENTITY_PURCHASE_TYPE, purchaseType);
		String str = ActionBot.getTextWithInElement(driver, TEXTBOX_EPROC_ENTITY_PURCHASE_TYPE);
		logger.info("Added Purchase Type : " + str);
		return str;
	}

	@Override
	public boolean clickOnSave(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SAVE_TENANT_LEVEL_CONFIG);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on save");
		if (ActionBot.isElementPresent(driver, IPageBuyersDeskSettingsImpl.BUYERS_DESK_SETTING_SUCCESS_MSG))
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	@Override
	public boolean clickOnEnforcePTBasedValidationOfGLAccountsYES(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ENFORCE_PURCHASE_TYPE_BASED_VALIDATION_OF_GL_ACCOUNTS_YES);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on enforce PT based gl account YES");
		return ActionBot.isElementSelected(driver, ENFORCE_PURCHASE_TYPE_BASED_VALIDATION_OF_GL_ACCOUNTS_YES);

	}

	@Override
	public boolean clickOnEnforcePTBasedValidationOfGLAccountsNO(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ENFORCE_PURCHASE_TYPE_BASED_VALIDATION_OF_GL_ACCOUNTS_NO);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on enforce PT based gl account NO");
		return ActionBot.isElementSelected(driver, ENFORCE_PURCHASE_TYPE_BASED_VALIDATION_OF_GL_ACCOUNTS_NO);
	}

	@Override
	public boolean isEnforcePTBasedValidationOfGLAccountsYESNOSettingPresent(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, ENFORCE_PURCHASE_TYPE_BASED_VALIDATION_OF_GL_ACCOUNTS_NO))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isAllowsplittingcosttomultiplecostcentersYes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.findElement(driver, ALLOW_SPLITTING_COST_TO_MULTIPLE_COST_CENTER_YES).isSelected())
		{
			return true;
		}
		return false;
	}

	@Override
	public String getPurchaseType(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String purchaseType = ActionBot.getAttributeOfElement(driver, TEXTBOX_EPROC_ENTITY_PURCHASE_TYPE, "value");
		logger.info("Purchase Type : " + purchaseType);
		return purchaseType;
	}

	@Override
	public boolean clickOnUsethePurchaseTypeFieldToclassifyPurchasesNo(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, USE_THE_PURCHASE_TYPE_FIELD_TO_CLASSIFY_PURCHASES_NO);
		return ActionBot.isElementSelected(driver, USE_THE_PURCHASE_TYPE_FIELD_TO_CLASSIFY_PURCHASES_NO);

	}

	@Override
	public boolean clickOnUsethePurchaseTypeFieldToclassifyPurchasesYes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, USE_THE_PURCHASE_TYPE_FIELD_TO_CLASSIFY_PURCHASES_YES);
		return ActionBot.isElementSelected(driver, USE_THE_PURCHASE_TYPE_FIELD_TO_CLASSIFY_PURCHASES_YES);

	}

	@Override
	public boolean isEnforcePTBasedValidationOfGLAccountYESEnabled(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.findElement(driver, ENFORCE_PURCHASE_TYPE_BASED_VALIDATION_OF_GL_ACCOUNTS_YES).isEnabled())
		{
			return true;
		}
		else
		{
			return false;
		}

	}

	@Override
	public boolean isManageStockAtWarehouseLevel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementSelected(driver, MANAGE_STOCK_AT_WAREHOUSE_LEVEL_YES))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean clickOnManageStockAtWarehouseLevel(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementEnabled(driver, MANAGE_STOCK_AT_WAREHOUSE_LEVEL_YES))
		{
			if (ActionBot.getAttributeOfElement(driver, MANAGE_STOCK_AT_WAREHOUSE_LEVEL_NO, "value").equalsIgnoreCase("true"))
			{
				ActionBot.click(driver, MANAGE_STOCK_AT_WAREHOUSE_LEVEL_YES);

				return true;
			}
		}
		return false;
	}

	@Override
	public boolean clickOnAllowEditingPurchaseTypeLineLevel_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementEnabled(driver, RADIOBUTTON_ALLOW_EDITING_OF_PURCHASE_TYPE_AT_LINE_LEVEL_YES))
		{
			ActionBot.click(driver, RADIOBUTTON_ALLOW_EDITING_OF_PURCHASE_TYPE_AT_LINE_LEVEL_YES);
			return ActionBot.isElementSelected(driver, RADIOBUTTON_ALLOW_EDITING_OF_PURCHASE_TYPE_AT_LINE_LEVEL_YES);
		}
		return false;
	}

	@Override
	public boolean clickOnAllowEditingPurchaseTypeLineLevel_No(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementEnabled(driver, RADIOBUTTON_ALLOW_EDITING_OF_PURCHASE_TYPE_AT_LINE_LEVEL_NO))
		{
			ActionBot.click(driver, RADIOBUTTON_ALLOW_EDITING_OF_PURCHASE_TYPE_AT_LINE_LEVEL_NO);
			return ActionBot.isElementSelected(driver, RADIOBUTTON_ALLOW_EDITING_OF_PURCHASE_TYPE_AT_LINE_LEVEL_NO);
		}
		return false;
	}

	@Override
	public boolean clickOnAllowCostCenterOwnerWithOverlappingLimit_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ALLOW_CC_OWNER_WITH_OVERLAPPING_LIMIT_YES);
		return ActionBot.isElementSelected(driver, ALLOW_CC_OWNER_WITH_OVERLAPPING_LIMIT_YES);
	}

	@Override
	public boolean clickOnAllowCostCenterOwnerWithOverlappingLimit_No(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ALLOW_CC_OWNER_WITH_OVERLAPPING_LIMIT_NO);
		return ActionBot.isElementSelected(driver, ALLOW_CC_OWNER_WITH_OVERLAPPING_LIMIT_NO);
	}

	@Override
	public boolean clickOnAllowProjectOwnerWithOverlappingLimit_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ALLOW_PROJECT_OWNER_WITH_OVERLAPPING_LIMIT_YES);
		return ActionBot.isElementSelected(driver, ALLOW_PROJECT_OWNER_WITH_OVERLAPPING_LIMIT_YES);
	}

	@Override
	public boolean clickOnAllowProjectOwnerWithOverlappingLimit_No(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ALLOW_PROJECT_OWNER_WITH_OVERLAPPING_LIMIT_NO);
		return ActionBot.isElementSelected(driver, ALLOW_PROJECT_OWNER_WITH_OVERLAPPING_LIMIT_NO);
	}

	@Override
	public boolean clickOnAllowGLAccountOwnerWithOverlappingLimit_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ALLOW_GLACCOUNT_OWNER_WITH_OVERLAPPING_LIMIT_YES);
		return ActionBot.isElementSelected(driver, ALLOW_GLACCOUNT_OWNER_WITH_OVERLAPPING_LIMIT_YES);
	}

	@Override
	public boolean clickOnAllowGLAccountOwnerWithOverlappingLimit_No(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ALLOW_GLACCOUNT_OWNER_WITH_OVERLAPPING_LIMIT_NO);
		return ActionBot.isElementSelected(driver, ALLOW_GLACCOUNT_OWNER_WITH_OVERLAPPING_LIMIT_NO);
	}

	@Override
	public boolean clickOnAllowMultipleCatagoryOwners_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIOBUTTON_ALLOW_MULTIPLE_CATAGORY_OWNERS_YES);
		return ActionBot.isElementSelected(driver, RADIOBUTTON_ALLOW_MULTIPLE_CATAGORY_OWNERS_YES);
	}

	@Override
	public boolean clickOnAllowMultipleCatagoryOwners_No(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIOBUTTON_ALLOW_MULTIPLE_CATAGORY_OWNERS_NO);
		return ActionBot.isElementSelected(driver, RADIOBUTTON_ALLOW_MULTIPLE_CATAGORY_OWNERS_NO);
	}

	@Override
	public boolean clickOnPreventSupplierNotEntendedToOrderingLocation_Yes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIOBUTTON_PREVENT_SUPPLIER_NOT_EXTENDED_TO_ORDERING_LOCATION_YES);
		return ActionBot.isElementSelected(driver, RADIOBUTTON_PREVENT_SUPPLIER_NOT_EXTENDED_TO_ORDERING_LOCATION_YES);
	}

	@Override
	public boolean clickOnPreventSupplierNotEntendedToOrderingLocation_No(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, RADIOBUTTON_PREVENT_SUPPLIER_NOT_EXTENDED_TO_ORDERING_LOCATION_NO);
		return ActionBot.isElementSelected(driver, RADIOBUTTON_PREVENT_SUPPLIER_NOT_EXTENDED_TO_ORDERING_LOCATION_NO);
	}
}
