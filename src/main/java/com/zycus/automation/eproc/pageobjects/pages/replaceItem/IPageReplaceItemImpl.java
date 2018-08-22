package com.zycus.automation.eproc.pageobjects.pages.replaceItem;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPageReplaceItemImpl implements IPageReplaceItem
{

	@Override
	public void clickOnRadioItem(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		ActionBot.click(driver, RADIO_BUTTON_ITEM_LIST);
		ScreenShot.screenshot(driver, testCaseName, "After selecting radio button of item");

	}

	@Override
	public void clickOnReplaceItemButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_REPLACE_ITEM);
		ActionBot.defaultMediumSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on replace button");

	}

	@Override
	public String fillChangeComment(WebDriver driver, String testCaseName, String changeComment) throws ActionBotException
	{
		ActionBot.clear(driver, TEXTBOX_CHANGE_COMMENTS);
		ActionBot.sendKeys(driver, TEXTBOX_CHANGE_COMMENTS, changeComment);
		return ActionBot.getTextWithInElement(driver, TEXTBOX_CHANGE_COMMENTS);
	}

	@Override
	public void clickOnConfirm(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "clicking on confirm button");
		ActionBot.click(driver, BUTTON_CONFIRM_REPLACE_BUYER_ITEM);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testCaseName, "After clicking on confirm button");

	}

	@Override
	public String getReplaceItemPageHeaderText(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		String pageHeader = ActionBot.findElement(driver, TEXT_PAGE_HEADER).getText();
		return pageHeader;
	}

	@Override
	public boolean verifyReplaceButtonDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "replace button displayed");
		if (ActionBot.isElementDisplayed(driver, BUTTON_REPLACE_ITEM))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean verifyCancelAndGoBackButtonDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "cancel and go back button displayed");
		if (ActionBot.isElementDisplayed(driver, BUTTON_CANCEL_AND_GO_BACK))
		{
			return true;
		}
		return false;
	}

	@Override
	public void clickCancelAndGoBackButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		ActionBot.click(driver, BUTTON_CANCEL_AND_GO_BACK);
		ActionBot.defaultMediumSleep();
	}

	@Override
	public String enterproductDescription(WebDriver driver, String testCaseName, String productDescription) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, TEXT_DESCRIPTION);
		ele.sendKeys(productDescription);
		ele.sendKeys(Keys.ENTER);
		ActionBot.defaultLowSleep();
		return productDescription;
	}

	@Override
	public boolean isSearchResultDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "replace item search result");
		List<WebElement> ele = ActionBot.findElements(driver, By.xpath(".//*[@id='tblSearchItemList']//tbody//tr"));
		int size = ele.size();
		if (size > 0)
		{
			return true;
		}
		return false;
	}

	@Override
	public void clearProductDescription(WebDriver driver, String testCaseName) throws ActionBotException
	{
		WebElement ele = ActionBot.findElement(driver, TEXT_DESCRIPTION);
		ele.clear();
		ele.sendKeys(Keys.ENTER);
		ActionBot.defaultLowSleep();
	}

	@Override
	public boolean isItemImageDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "item image");
		if (ActionBot.isElementDisplayed(driver, ITEM_IMAGE))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isItemNameDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ScreenShot.screenshot(driver, testCaseName, "item name");
		if (ActionBot.isElementDisplayed(driver, ITEM_NAME_REPLACE_ITEM))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isItemDescriptionDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ScreenShot.screenshot(driver, testCaseName, "item description");
		if (ActionBot.isElementDisplayed(driver, ITEM_DESCRIPTION))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isSupplierNameDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ScreenShot.screenshot(driver, testCaseName, "item supplier name");
		if (ActionBot.isElementDisplayed(driver, ITEM_SUPPLIER_NAME))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isItemLeadTimeDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ScreenShot.screenshot(driver, testCaseName, "item lead time");
		if (ActionBot.isElementDisplayed(driver, ITEM_LEAD_TIME))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isIconIsGreenDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ScreenShot.screenshot(driver, testCaseName, "item is green");
		if (ActionBot.isElementDisplayed(driver, ICON_IS_GREEN))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isIconIsPreferredDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ScreenShot.screenshot(driver, testCaseName, "item is preferred");
		if (ActionBot.isElementDisplayed(driver, ICON_IS_PREFERRED))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isItemPriceDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{

		ScreenShot.screenshot(driver, testCaseName, "item price");
		WebElement ele = ActionBot.findElement(driver, ITEM_PRICE_REPLACE_ITEM_PAGE);
		if (ele.isDisplayed())
		{
			return true;
		}
		return false;
	}

	@Override
	public void clickItemName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, ITEM_NAME_REPLACE_ITEM);
		ActionBot.defaultLowSleep();
		ScreenShot.screenshot(driver, testCaseName, "item details popup");
	}

	@Override
	public boolean isItemDetailsPopupDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		if (ActionBot.isElementDisplayed(driver, POPUP_ITEM_DETAILS))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isItemNameInItemDetailsPopupDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, ITEM_NAME_POPUP_ITEM_DETAILS))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isItemPartIdInItemDetailsPopupDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, ITEM_PART_ID_POPUP_ITEM_DETAILS))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isItemPriceInItemDetailsPopupDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, ITEM_PRICE_POPUP_ITEM_DETAILS))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isIconIsGreenInItemDetailsPopupDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, ICON_IS_GREEN_POPUP_ITEM_DETAILS))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isIconIsPreferredInItemDetailsPopupDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, ICON_IS_PREFERRED_POPUP_ITEM_DETAILS))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isTabDetailsInItemDetailsPopupDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TAB_DETAILS_POPUP_ITEM_DETAILS))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isTabSpecificationInItemDetailsPopupDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TAB_SPECIFICATION_POPUP_ITEM_DETAILS))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean isTabAttachmentInItemDetailsPopupDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, TAB_ATTACHMENT_POPUP_ITEM_DETAILS))
		{
			return true;
		}
		return false;
	}

	@Override
	public void clickCloseOnItemPopUp(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_CLOSE_ITEM_POPUP_REPLACE_ITEM);
		ActionBot.defaultSleep();
	}

	@Override
	public boolean verifyFieldsOnDetailsTabItemPopup(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, LABEL_DESCRIPTION_TAB_DETAILS_POPUP_REPLACE_ITEM))
		{
			if (ActionBot.isElementDisplayed(driver, LABEL_MANUFACTURER_TAB_DETAILS_POPUP_REPLACE_ITEM))
			{
				if (ActionBot.isElementDisplayed(driver, LABEL_CATEGORY_TAB_DETAILS_POPUP_REPLACE_ITEM))
				{
					if (ActionBot.isElementDisplayed(driver, LABEL_SPSC_TAB_DETAILS_POPUP_REPLACE_ITEM))
					{
						if (ActionBot.isElementDisplayed(driver, LABEL_SUPPLIER_TAB_DETAILS_POPUP_REPLACE_ITEM))
						{
							if (ActionBot.isElementDisplayed(driver, LABEL_DELIVERY_TAB_DETAILS_POPUP_REPLACE_ITEM))
							{
								if (ActionBot.isElementDisplayed(driver, LABEL_CONTRACT_TAB_DETAILS_POPUP_REPLACE_ITEM))
								{
									return true;
								}
							}
						}
					}
				}
			}
		}
		return false;
	}

	@Override
	public void clickDetailsTabOnItemPopup(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TAB_DETAILS_POPUP_ITEM_DETAILS);
		ScreenShot.screenshot(driver, testCaseName, "Details Tab");
	}

	@Override
	public void clickSpecificationTabOnItemPopup(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TAB_SPECIFICATION_POPUP_ITEM_DETAILS);
		ScreenShot.screenshot(driver, testCaseName, "Specification Tab");
	}

	@Override
	public void clickAttachmentsTabOnItemPopup(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, TAB_ATTACHMENT_POPUP_ITEM_DETAILS);
		ScreenShot.screenshot(driver, testCaseName, "Attachments Tab");
	}

	@Override
	public boolean verifyFieldsOnSpecificationTabItemPopup(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, LABEL_SPECIFICATION_NAME_TAB_SPECIFICATION_POPUP_REPLACE_ITEM))
		{
			if (ActionBot.isElementDisplayed(driver, LABEL_SPECIFICATION_KEY_TAB_SPECIFICATION_POPUP_REPLACE_ITEM))
			{
				if (ActionBot.isElementDisplayed(driver, LABEL_SPECIFICATION_VALUE_TAB_SPECIFICATION_POPUP_REPLACE_ITEM))
				{
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public boolean verifyFieldsOnAttachmentsTabItemPopup(WebDriver driver, String testCaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, LINK_TAB_ATTACHMENT_POPUP_REPLACE_ITEM))
		{
			return true;
		}
		return false;
	}

	@Override
	public void clickOnRadioItemGrid(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		WebElement ele = ActionBot.findElement(driver, RADIO_BUTTON_ITEM_GRID);
		ele.click();
		ScreenShot.screenshot(driver, testCaseName, "After selecting radio button of item on Grid View");
	}

	@Override
	public void clickButtonAlertOk(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultLowSleep();
		if (ActionBot.isElementDisplayed(driver, BUTTON_ALERT_OK_REPLACE_ITEM))
		{
			ActionBot.click(driver, BUTTON_ALERT_OK_REPLACE_ITEM);
		}

	}

	@Override
	public void fillReplaceItemQuantity(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String quantity = ActionBot.findElement(driver, LABEL_GET_ITEM_QUANTITY).getText();
		ActionBot.clear(driver, TEXT_REPLACE_ITEM_QUANTITY);
		ActionBot.sendKeys(driver, TEXT_REPLACE_ITEM_QUANTITY, quantity);
		ActionBot.defaultLowSleep();
	}

	@Override
	public boolean verifyButtonConfirmDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		if (ActionBot.isElementDisplayed(driver, BUTTON_CONFIRM_REPLACE_BUYER_ITEM))
		{
			return true;
		}
		return false;
	}

	@Override
	public boolean verifyLinkCancelDisplayed(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();
		if (ActionBot.isElementDisplayed(driver, LINK_CANCEL_REPLACE_BUYER_ITEM))
		{
			return true;
		}
		return false;
	}

	@Override
	public void clickCloseOnItemPopUpByXpath(WebDriver driver, String testCaseName, String xpath) throws ActionBotException
	{
		List<WebElement> ele = ActionBot.findElements(driver, By.xpath(xpath));
		boolean breakFlag = false;
		int size = ele.size();
		for (WebElement a : ele)
		{
			for (int i = 1; i <= size; i++)
			{
				String newXpath = xpath + "[" + i + "]";
				if (ActionBot.isElementDisplayed(driver, By.xpath(newXpath)))
				{
					ActionBot.click(driver, By.xpath(newXpath));
					breakFlag = true;
					break;
				}
			}
			if (breakFlag == true)
				break;
		}
		// ActionBot.click(driver, By.xpath(xpath));
		ActionBot.defaultSleep();
	}

	@Override
	public void clickReplaceFreeTextItemButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "replace button");
		ActionBot.click(driver, BUTTON_REPLACE_ITEMS_POPUP);
		ActionBot.defaultMediumSleep();
	}

}
