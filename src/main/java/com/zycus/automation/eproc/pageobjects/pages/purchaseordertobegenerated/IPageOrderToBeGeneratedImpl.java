package com.zycus.automation.eproc.pageobjects.pages.purchaseordertobegenerated;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class IPageOrderToBeGeneratedImpl implements IPurchaseOrderToBeGenerated
{

	static Logger logger = Logger.getLogger(IPageOrderToBeGeneratedImpl.class);

	@Override
	public String getPurchaseOrderToBeGeneratedSuggestedPOs(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		ScreenShot.screenshot(driver, testCaseName, "Purchase Order To Be Generated Suggested POs");
		String PurchaseOrderToBeGeneratedSuggestedPOs = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='wrapper']//tr[" + index + "]/td[@class='itmNo poNumCell']"));
		logger.info("Purchase Order To Be Generated SuggestedPOs: " + PurchaseOrderToBeGeneratedSuggestedPOs);
		return PurchaseOrderToBeGeneratedSuggestedPOs;
	}

	@Override
	public String getPurchaseOrderToBeGeneratedSupplier(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		ScreenShot.screenshot(driver, testCaseName, "Purchase Order To Be GeneratedSupplier");
		String PurchaseOrderToBeGeneratedSupplier = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='wrapper']//tr[" + index + "]/td[@class='iDesc']"));
		logger.info("Purchase Order To Be Generated SuggestedPOs: " + PurchaseOrderToBeGeneratedSupplier);
		return PurchaseOrderToBeGeneratedSupplier;
	}

	@Override
	public String getPurchaseOrderToBeGeneratedBu(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		ScreenShot.screenshot(driver, testCaseName, "Purchase Order To BeGeneratedBu");
		String PurchaseOrderToBeGeneratedBu = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='wrapper']//tr[" + index + "]/td[@class='BUCell']"));
		logger.info("Purchase Order To Be GeneratedBu " + PurchaseOrderToBeGeneratedBu);
		return PurchaseOrderToBeGeneratedBu;
	}

	@Override
	public String getPurchaseOrderToBeGeneratedDeliverydate(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		ScreenShot.screenshot(driver, testCaseName, "Purchase Order To BeGenerated Deliverydate");
		String PurchaseOrderToBeGeneratedDeliverydate = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='wrapper']//tr[" + index + "]/td[7]"));
		logger.info("PurchaseOrder To Be Generated Deliverydate" + PurchaseOrderToBeGeneratedDeliverydate);
		return PurchaseOrderToBeGeneratedDeliverydate;
	}

	@Override
	public String getPurchaseOrderToBeGeneratedPoTotal(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		ScreenShot.screenshot(driver, testCaseName, "Purchase Order To Be Generated PoTotal");
		String PurchaseOrderToBeGeneratedPoTotal = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='suggestedPoGrossTotalAmount_" + index + "']"));
		logger.info("PurchaseOrder To Be Generated PoTotal " + PurchaseOrderToBeGeneratedPoTotal);
		return PurchaseOrderToBeGeneratedPoTotal;
	}

	@Override
	public String getPurchaseOrderToBeGeneratedExchangeRate(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		ScreenShot.screenshot(driver, testCaseName, "Purchase Order To Be Generated ExchangeRate");
		String PurchaseOrderToBeGeneratedExchangeRate = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='wrapper']//tr[" + index + "]/td[@class='iQty eleBlck']"));
		logger.info("PurchaseOrder To Be Generated ExchangeRate " + PurchaseOrderToBeGeneratedExchangeRate);
		return PurchaseOrderToBeGeneratedExchangeRate;
	}

	@Override
	public String getPurchaseOrderToBeGeneratedReqNo(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		ScreenShot.screenshot(driver, testCaseName, "Purchase Order To Be Generated ReqNo");
		String PurchaseOrderToBeGeneratedReqNo = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='wrapper']//tr[" + index + "]//td[@class='reqno']/a"));
		logger.info("PurchaseOrder To Be GeneratedReqNo" + PurchaseOrderToBeGeneratedReqNo);
		return PurchaseOrderToBeGeneratedReqNo;
	}

	@Override
	public String getPurchaseOrderToBeGeneratedItemName(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		ScreenShot.screenshot(driver, testCaseName, "Purchase Order To Be Generated ReqNo");
		String PurchaseOrderToBeGeneratedItemName = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='wrapper']//tr[" + index + "]//td[@class='itemName']"));
		logger.info("Purchase Order To Be Generated ItemName" + PurchaseOrderToBeGeneratedItemName);
		return PurchaseOrderToBeGeneratedItemName;
	}

	@Override
	public String getPurchaseOrderToBeGeneratedDeliverTo(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		ScreenShot.screenshot(driver, testCaseName, "Purchase Order To Be Generated DeliverTo");
		String PurchaseOrderToBeGeneratedDeliverTo = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='wrapper']//tr[" + index + "]//td[@class='delTo']"));
		logger.info("Purchase Order To Be Generated DeliverTo" + PurchaseOrderToBeGeneratedDeliverTo);
		return PurchaseOrderToBeGeneratedDeliverTo;
	}

	@Override
	public String getPurchaseOrderToBeGeneratedUnitPrice(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		ScreenShot.screenshot(driver, testCaseName, "Purchase Order To Be Generated UnitPrice");
		String PurchaseOrderToBeGeneratedUnitPrice = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='wrapper']//tr[" + index + "]//td[5]"));
		logger.info("Purchase Order To Be Generated UnitPrice" + PurchaseOrderToBeGeneratedUnitPrice);
		return PurchaseOrderToBeGeneratedUnitPrice;
	}

	@Override
	public String getPurchaseOrderToBeGeneratedQty(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		ScreenShot.screenshot(driver, testCaseName, "Purchase Order To Be Generated Qty");
		String PurchaseOrderToBeGeneratedQty = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='wrapper']//tr[" + index + "]//td[@class='itmQty']"));
		logger.info("Purchase Order To Be Generated Qty" + PurchaseOrderToBeGeneratedQty);
		return PurchaseOrderToBeGeneratedQty;
	}

	@Override
	public String getPurchaseOrderTotalPrices(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{

		ScreenShot.screenshot(driver, testCaseName, "Purchase Order Total Prices");
		String PurchaseOrderTotalPrices = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='wrapper']//tr[" + index + "]//td[7]"));
		logger.info("Purchase Order Total Prices" + PurchaseOrderTotalPrices);
		return PurchaseOrderTotalPrices;
	}

	@Override
	public void clickOnPreviewPoLink(WebDriver driver, String testcaseName, int index) throws ActionBotException
	{

		ActionBot.click(driver, By.xpath(".//*[@id='preview_" + index + "']"));

		ScreenShot.screenshot(driver, testcaseName, "Purchase Order");

	}

	@Override
	public void clickOnReqNoLink(WebDriver driver, String testcaseName, int index) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='wrapper']//tr[" + index + "]//td[@class='reqno']/a"));
		ScreenShot.screenshot(driver, testcaseName, "Purchase Order");

	}

	@Override
	public void clickOnSubmitPoForProcessing(WebDriver driver, String testcaseName) throws ActionBotException
	{
		if (ActionBot.isElementDisplayed(driver, BUTTON_SUBMIT_PO_FOR_PROCESSING))
		{
			ActionBot.click(driver, BUTTON_SUBMIT_PO_FOR_PROCESSING);
			ActionBot.defaultMediumSleep();
			ActionBot.waitTillPopUpIsPresent(driver, PROGRESSING_DIV_CONVERT_PO_BUYERS_DESK);
			ScreenShot.screenshot(driver, testcaseName, "Converted Purchase Order");
			ActionBot.defaultSleep();
		}

		//for SAWater
		else
		{
			if (ActionBot.isElementDisplayed(driver, BUTTON_SUBMIT_PO_FOR_PROCESSING_SAWATER))
			{
				ActionBot.click(driver, BUTTON_SUBMIT_PO_FOR_PROCESSING_SAWATER);
				ActionBot.defaultMediumSleep();
				ActionBot.waitTillPopUpIsPresent(driver, PROGRESSING_DIV_CONVERT_PO_BUYERS_DESK);
				ScreenShot.screenshot(driver, testcaseName, "Converted Purchase Order");
			}
		}

	}

	@Override
	public void clickOnSavePosAsDraft(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='createDraftPO']"));
		ActionBot.defaultMediumSleep();
		ActionBot.waitTillPopUpIsPresent(driver, PROGRESSING_DIV_CONVERT_PO_BUYERS_DESK);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testcaseName, "Purchase Order");
	}

	@Override
	public void clickOnCancelLink(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='cancelPO']"));
		ScreenShot.screenshot(driver, testcaseName, "Purchase Order");

	}

	@Override
	public String getPurchaseOrderToBeGeneratedAction(WebDriver driver, String testCaseName, int index) throws ActionBotException
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void ClikOnPurchaseOrderToBeGeneratedCheckBox(WebDriver driver, String testcaseName, int index) throws ActionBotException
	{
		ActionBot.defaultSleep();
		ActionBot.click(driver, By.xpath(".//*[@id='chk_suggested_po_" + index + "']"));
		ActionBot.defaultSleep();
	}

	@Override
	public List<String> getListOfItems(WebDriver driver, String testCaseName) throws ActionBotException
	{
		List<WebElement> itemNames = ActionBot.findElements(driver, ITEM_NAME_ON_SUGGESTED_PO_PAGE);
		List<String> listOfItemNames = new ArrayList<String>();
		for (WebElement element : itemNames)
		{
			listOfItemNames.add(element.getText().trim());
		}
		return listOfItemNames;
	}

	@Override
	public List<WebElement> getListOfAllSuggestedPOCheckboxes(WebDriver driver, String testCaseName) throws ActionBotException
	{
		return ActionBot.findElements(driver, CHECKBOX_SUBMIT_PO_FOR_PROCESSING);
	}

	@Override
	public void clickOnNotes(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_NOTES_ON_SUGGEESTED_PO);
		ScreenShot.screenshot(driver, testcaseName, "After clicking on notes");

	}

	@Override
	public String enterNotes(WebDriver driver, String testcaseName, String notes) throws ActionBotException
	{
		ActionBot.findElement(driver, TEXTBOX_NOTES_ON_SUGGESTED_PO);
		ActionBot.clear(driver, TEXTBOX_NOTES_ON_SUGGESTED_PO);
		ActionBot.sendKeys(driver, TEXTBOX_NOTES_ON_SUGGESTED_PO, notes);
		String str = ActionBot.getTextWithInElement(driver, TEXTBOX_NOTES_ON_SUGGESTED_PO);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testcaseName, "After entering description in notes");
		return str;
	}

	@Override
	public void clickOnSaveNotes(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SAVE_NOTES_ON_SUGGESTED_PO);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testcaseName, "After clicking on save notes");

	}

	@Override
	public void clickOnAddAttachments(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, LINK_ADD_ATTACHMENTS_ON_SUGGESTED_PO);
		ScreenShot.screenshot(driver, testcaseName, "After clicking on add attachments");

	}

	@Override
	public boolean isPOInfoAtPreviewPOPresent(WebDriver driver, String testcaseName) throws ActionBotException
	{
		if (ActionBot.isElementPresent(driver, LABEL_PO_INFO_AT_PREVIEW_PO_FROM_PO_TO_BE_GENERATED))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public boolean isPONOFormatConfigPresentCorrectly(WebDriver driver, String testcaseName) throws ActionBotException
	{
		String po = ActionBot.getTextWithInElement(driver, LABEL_PO_NO_FORMAT_CONFIG_ON_PO_TO_BE_GENERATED_PAGE);
		if (po.equals("The purchase order number will be automatically generated based on the configuration"))
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	@Override
	public void clickOnCollapseAndExpandIcon(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, ICON_COLLAPSE_AND_EXPAND);
		ActionBot.defaultSleep();
		ScreenShot.screenshot(driver, testcaseName, "After clicking on Expand and Collapse icon");

	}

	@Override
	public boolean isSubmitPOForProcessingPresent(WebDriver driver, String testcaseName) throws ActionBotException
	{
		return ActionBot.isElementPresent(driver, BUTTON_SUBMIT_PO_FOR_PROCESSING);
	}

	@Override
	public void clickOnSavePoAndContinue(WebDriver driver, String testcaseName) throws ActionBotException
	{
		ActionBot.click(driver, BUTTON_SAVE_PO_AND_CONTINUE);

		ScreenShot.screenshot(driver, testcaseName, "Converted Purchase Order");
	}

	@Override
	public String clickOnRecomendationMemoProvided(WebDriver driver, String testcaseName, String recommendationMemoProvided) throws ActionBotException
	{
		if (recommendationMemoProvided.equalsIgnoreCase(IConstants.YES))
		{
			ActionBot.click(driver, RADIO_YES_RECOMMDATION_PROVIDED_FURTHER_DETAILS);

			if (ActionBot.findElement(driver, RADIO_YES_RECOMMDATION_PROVIDED_FURTHER_DETAILS).isSelected())
			{
				return recommendationMemoProvided;
			}
			else
			{
				ScreenShot.screenshot(driver, testcaseName, "Converted Purchase Order");

				return null;
			}
		}
		else if (recommendationMemoProvided.equalsIgnoreCase(IConstants.NO))
		{

			ActionBot.click(driver, RADIO_NO_RECOMMDATION_PROVIDED_FURTHER_DETAILS);

			if (ActionBot.findElement(driver, RADIO_NO_RECOMMDATION_PROVIDED_FURTHER_DETAILS).isSelected())
			{
				return recommendationMemoProvided;
			}
			else
			{
				ScreenShot.screenshot(driver, testcaseName, "Converted Purchase Order");

				return null;
			}
		}
		else if (recommendationMemoProvided.equalsIgnoreCase(IConstantsData.NA_RECOMMDATION_PROVIDED_FURTHER_DETAILS))
		{

			ActionBot.click(driver, RADIO_NA_RECOMMDATION_PROVIDED_FURTHER_DETAILS);
			if (ActionBot.findElement(driver, RADIO_NA_RECOMMDATION_PROVIDED_FURTHER_DETAILS).isSelected())
			{
				return recommendationMemoProvided;
			}
			else
			{
				ScreenShot.screenshot(driver, testcaseName, "Converted Purchase Order");

				return null;
			}

		}
		return null;

	}

	@Override
	public String clickOnquote(WebDriver driver, String testcaseName, String quote) throws ActionBotException
	{
		if (quote.equalsIgnoreCase(IConstantsData.OBTAINED_BY_AO_QUOTE_FURTHER_DETAILS))
		{
			ActionBot.click(driver, RADIO_OBTAINED_BY_AO_QUOTE_FURTHER_DETAILS);

			if (ActionBot.findElement(driver, RADIO_OBTAINED_BY_AO_QUOTE_FURTHER_DETAILS).isSelected())
			{
				return quote;
			}
			else
			{
				ScreenShot.screenshot(driver, testcaseName, "Converted Purchase Order");

				return null;
			}
		}
		else if (quote.equalsIgnoreCase(IConstantsData.OBTAINED_BUT_TC_QUOTE_FURTHER_DETAILS))
		{

			ActionBot.click(driver, RADIO_OBTAINED_BUT_TC_QUOTE_FURTHER_DETAILS);

			if (ActionBot.findElement(driver, RADIO_OBTAINED_BUT_TC_QUOTE_FURTHER_DETAILS).isSelected())
			{
				return quote;
			}
			else
			{
				ScreenShot.screenshot(driver, testcaseName, "Converted Purchase Order");

				return null;
			}
		}
		else if (quote.equalsIgnoreCase(IConstantsData.NA_QUOTE_FURTHER_DETAILS))
		{

			ActionBot.click(driver, RADIO_NA_QUOTE_FURTHER_DETAILS);

			if (ActionBot.findElement(driver, RADIO_NA_QUOTE_FURTHER_DETAILS).isSelected())
			{
				return quote;
			}
			else
			{
				ScreenShot.screenshot(driver, testcaseName, "Converted Purchase Order");

				return null;
			}
		}
		return null;
	}

	@Override
	public String clickOncmsRegistered(WebDriver driver, String testcaseName, String cmsRegistered) throws ActionBotException
	{
		if (cmsRegistered.equalsIgnoreCase(IConstants.YES))
		{
			ActionBot.click(driver, RADIO_YES_CMS_REGISTERED_FURTHER_DETAILS);

			if (ActionBot.findElement(driver, RADIO_YES_CMS_REGISTERED_FURTHER_DETAILS).isSelected())
			{
				return cmsRegistered;
			}
			else
			{
				ScreenShot.screenshot(driver, testcaseName, "Converted Purchase Order");

				return null;
			}
		}
		else if (cmsRegistered.equalsIgnoreCase(IConstants.NO))
		{

			ActionBot.click(driver, RADIO_NO_CMS_REGISTERED_FURTHER_DETAILS);
			if (ActionBot.findElement(driver, RADIO_NO_CMS_REGISTERED_FURTHER_DETAILS).isSelected())
			{
				return cmsRegistered;
			}
			else
			{
				ScreenShot.screenshot(driver, testcaseName, "Converted Purchase Order");

				return null;
			}

		}
		else if (cmsRegistered.equalsIgnoreCase(IConstantsData.NA_NOT_ON_SITE_CMS_REGISTERED_FURTHER_DETAILS))
		{

			ActionBot.click(driver, RADIO_NA_NOT_ON_SITE_CMS_REGISTERED_FURTHER_DETAILS);
			if (ActionBot.findElement(driver, RADIO_NA_NOT_ON_SITE_CMS_REGISTERED_FURTHER_DETAILS).isSelected())
			{
				return cmsRegistered;
			}
			else
			{
				ScreenShot.screenshot(driver, testcaseName, "Converted Purchase Order");

				return null;
			}

		}

		else if (cmsRegistered.equalsIgnoreCase(IConstantsData.NA_SUPPLIER_EXEMPT_CMS_REGISTERED_FURTHER_DETAILS))
		{

			ActionBot.click(driver, RADIO_NA_SUPPLIER_EXEMPT_CMS_REGISTERED_FURTHER_DETAILS);
			if (ActionBot.findElement(driver, RADIO_NA_SUPPLIER_EXEMPT_CMS_REGISTERED_FURTHER_DETAILS).isSelected())
			{
				return cmsRegistered;
			}
			else
			{
				ScreenShot.screenshot(driver, testcaseName, "Converted Purchase Order");

				return null;
			}

		}
		return null;
	}

	@Override
	public String clickOnpoMedium(WebDriver driver, String testcaseName, String poMedium) throws ActionBotException
	{

		if (poMedium.equalsIgnoreCase(IConstantsData.EMAIL_PO_MEDIUM_FURTHER_DETAILS))
		{
			ActionBot.click(driver, RADIO_EMAIL_PO_MEDIUM_FURTHER_DETAILS);

			if (ActionBot.findElement(driver, RADIO_EMAIL_PO_MEDIUM_FURTHER_DETAILS).isSelected())
			{
				return poMedium;
			}
			else
			{
				ScreenShot.screenshot(driver, testcaseName, "Converted Purchase Order");

				return null;
			}
		}
		else if (poMedium.equalsIgnoreCase(IConstantsData.PRINT_PO_MEDIUM_FURTHER_DETAILS))
		{

			ActionBot.click(driver, RADIO_PRINT_PO_MEDIUM_FURTHER_DETAILS);

			if (ActionBot.findElement(driver, RADIO_PRINT_PO_MEDIUM_FURTHER_DETAILS).isSelected())
			{
				return poMedium;
			}
			else
			{
				ScreenShot.screenshot(driver, testcaseName, "Converted Purchase Order");

				return null;
			}
		}
		else if (poMedium.equalsIgnoreCase(IConstantsData.FAX_PO_MEDIUM_FURTHER_DETAILS))
		{

			ActionBot.click(driver, RADIO_FAX_PO_MEDIUM_FURTHER_DETAILS);
			if (ActionBot.findElement(driver, RADIO_FAX_PO_MEDIUM_FURTHER_DETAILS).isSelected())
			{
				return poMedium;
			}
			else
			{
				ScreenShot.screenshot(driver, testcaseName, "Converted Purchase Order");

				return null;
			}

		}
		return null;

	}

	@Override
	public String clickOnpanelApply(WebDriver driver, String testcaseName, String panelApply) throws ActionBotException
	{
		if (panelApply.equalsIgnoreCase(IConstants.YES))
		{
			ActionBot.click(driver, RADIO_YES_PANEL_APPLY_FURTHER_DETAILS);
			if (ActionBot.findElement(driver, RADIO_YES_PANEL_APPLY_FURTHER_DETAILS).isSelected())
			{
				return panelApply;
			}
			else
			{
				ScreenShot.screenshot(driver, testcaseName, "Converted Purchase Order");
				return null;
			}

		}
		else if (panelApply.equalsIgnoreCase(IConstants.NO))
		{

			ActionBot.click(driver, RADIO_NO_PANEL_APPLY_FURTHER_DETAILS);
			if (ActionBot.findElement(driver, RADIO_NO_PANEL_APPLY_FURTHER_DETAILS).isSelected())
			{
				return panelApply;
			}
			else
			{
				ScreenShot.screenshot(driver, testcaseName, "Converted Purchase Order");

				return null;
			}

		}
		return null;
	}

	@Override
	public String setIsPOValue(WebDriver driver, String testcaseName, String isPOValue) throws ActionBotException
	{
		ActionBot.defaultSleep();
		Select select = new Select(ActionBot.findElement(driver, DROPDOWN_IS_PO_VALUE_PO_COMPLETED));
		if (isPOValue.equalsIgnoreCase(IConstants.YES))
		{
			select.selectByVisibleText(IConstants.YES);

		}
		else if (isPOValue.equalsIgnoreCase(IConstants.NO))
		{

			select.selectByVisibleText(IConstants.NO);

		}
		ActionBot.defaultSleep();

		return select.getFirstSelectedOption().getText().trim();
	}

	@Override
	public String clickOnPurchaseProcurement(WebDriver driver, String testcaseName, String proccurementInvolvement) throws ActionBotException
	{

		if (proccurementInvolvement.equalsIgnoreCase(IConstants.YES))
		{
			ActionBot.click(driver, RADIO_YES_PURCHASE_WITHOUT_PROCCUREMENT_FURTHER_DETAILS);
			if (ActionBot.findElement(driver, RADIO_YES_PURCHASE_WITHOUT_PROCCUREMENT_FURTHER_DETAILS).isSelected())
			{
				return proccurementInvolvement;
			}
			else
			{
				ScreenShot.screenshot(driver, testcaseName, "Converted Purchase Order");

				return null;
			}

		}
		else if (proccurementInvolvement.equalsIgnoreCase(IConstants.NO))
		{

			ActionBot.click(driver, RADIO_NO_PURCHASE_WITHOUT_PROCCUREMENT_FURTHER_DETAILS);

			if (ActionBot.findElement(driver, RADIO_NO_PURCHASE_WITHOUT_PROCCUREMENT_FURTHER_DETAILS).isSelected())
			{
				return proccurementInvolvement;
			}
			else
			{
				ScreenShot.screenshot(driver, testcaseName, "Converted Purchase Order");

				return null;
			}

		}
		return null;
	}

}
