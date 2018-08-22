/**
 * 
 *//*
package com.zycus.automation.eproc.businessflow.isourceflow;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.zycus.DataBin.EventCreation;
import com.zycus.DataBin.LineItems;
import com.zycus.DataBin.Lots;
import com.zycus.DataBin.RfxEditor;
import com.zycus.DataBin.Section;
import com.zycus.DataBin.SupplierRepository;
import com.zycus.Page.BidOptimizationHomePage;
import com.zycus.Page.IsourceSupplier;
import com.zycus.Page.PrepareSupplierResponsePage;
import com.zycus.Page.SupplierSubmitResponsePage;
import com.zycus.Testcase.IsourceFlowHelper;
import com.zycus.automation.bo.GuidedItem;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

*//**
 * @author ankita.sawant
 *
 *//*
public class FlowIsource
{

	static Logger logger = Logger.getLogger(FlowIsource.class);

	public static void fillAndSendSupplierResponse(IsourceSupplier isourceSupplier, SupplierRepository supplierRepository, RfxEditor rfxEditor, EventCreation eventCreation)
		throws CloneNotSupportedException, ActionBotException
	{
		IsourceFlowHelper isourceFlowHelper = new IsourceFlowHelper();
		isourceFlowHelper.acceptTnCAndConfirmParticipation(supplierRepository, eventCreation, isourceSupplier);
		// ScreenShot.screenshot(driver, testCaseName, "After accepting terms
		// and conditions");
		isourceFlowHelper.prepareOrRecallResponses(isourceSupplier, eventCreation, rfxEditor);
		fillSaveAndSubmitResponses(rfxEditor, eventCreation, supplierRepository, isourceSupplier);
		isourceFlowHelper.logoutSupplier(isourceSupplier);
	}

	public static void fillSaveAndSubmitResponses(RfxEditor rfxEditor, EventCreation eventCreation, SupplierRepository supplierRepository, IsourceSupplier isourceSupplier)
		throws CloneNotSupportedException, ActionBotException
	{
		WebDriver driver = isourceSupplier.getDriver();
		PrepareSupplierResponsePage.getInstance(driver);

		// prepareSupplierResponsePage.saveAndSubmitResponses(rfxEditor,
		// eventCreation, supplierRepository);

		fillAndSaveResponse(driver, rfxEditor, eventCreation, supplierRepository);
		submitResponse(driver);

		SupplierSubmitResponsePage supplierSubmitResponsePage = SupplierSubmitResponsePage.getInstance(driver);
		supplierSubmitResponsePage.submitResponseClk();
	}

	private static void fillAndSaveResponse(WebDriver driver, RfxEditor rfxEditor, EventCreation eventCreation, SupplierRepository supplierRepository)
		throws CloneNotSupportedException, ActionBotException
	{
		List<Section> expectedSectionList = rfxEditor.getSectionList();
		List<Section> supplierSectionList = supplierRepository.getSectionList();
		for (Section section : expectedSectionList)
		{
			Section sectionClone = section.clone();
			openSectionBySectionName(driver, section);
			if (sectionClone.getLotID() != null)
			{
				fillLotResponses(driver, sectionClone.getLotList().get(0));
			}
			goBackToTop(driver);
			saveResponse(driver, eventCreation);
			supplierSectionList.add(sectionClone);
		}
		supplierRepository.setSectionList(supplierSectionList);
	}

	public static void fillLotResponses(WebDriver driver, Lots lots) throws ActionBotException
	{
		List<LineItems> lineItemsList = lots.getLineItemsList();
		for (LineItems lineItem : lineItemsList)
		{
			fillUnitCostValue(driver, lineItem);
		}
	}

	public static void fillUnitCostValue(WebDriver driver, LineItems lineItem) throws ActionBotException
	{
		WebElement element = ActionBot.findElement(driver, By.xpath("//td[contains(@title,'" + lineItem.getItemName() + "')]/following-sibling::td[@_title='unit Cost']/input"));

		ActionBot.scroll(driver, element);
		ActionBot.click(driver, By.xpath(".//*[@id='ItemTable0']//td[@_title='No Bid']/input"));
		ActionBot.sendKeys(driver, By.xpath("//td[contains(@title,'" + lineItem.getItemName() + "')]/following-sibling::td[@_title='unit Cost']/input"),
			lineItem.getUnitCostValue());
	}

	private static void openSectionBySectionName(WebDriver driver, Section section) throws ActionBotException
	{
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
		((JavascriptExecutor) driver).executeScript("scroll(250, 0)", new Object[0]);
		ActionBot.click(driver, By.xpath("//span[contains(@title,'" + section.getSectionName() + "')]"));
		ActionBot.waitForPageLoad(driver);
	}

	public static void goBackToTop(WebDriver driver) throws ActionBotException
	{
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
		ActionBot.click(driver, By.id("GO_UP"));
		ActionBot.waitForPageLoad(driver);
	}

	private static void saveResponse(WebDriver driver, EventCreation eventCreation) throws ActionBotException
	{
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
		ActionBot.click(driver, By.xpath("//div[@id='saveRFX']/input/parent::div[contains(@style,'display: block')]/input"));
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
		ActionBot.defaultHighSleep();
		ActionBot.defaultHighSleep();
		ActionBot.defaultHighSleep();
		ActionBot.defaultHighSleep();
		ActionBot.click(driver, By.id("popup_ok"));
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
	}

	private static void submitResponse(WebDriver driver) throws ActionBotException
	{
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
		ActionBot.click(driver, By.id("SubmitResponse"));
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
	}

	public static void awardScenario(WebDriver driver) throws ActionBotException
	{
		clickAwardScenarioButton(driver);
		fillAwardComment(driver);
		clickDoneButton(driver);
		ActionBot.waitForPageLoad(driver);
		ActionBot.defaultSleep();
	}

	private static void clickAwardScenarioButton(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, By.id("sticky_award"));
	}

	private static String fillAwardComment(WebDriver driver) throws ActionBotException
	{
		return ActionBot.sendKeys(driver, By.id("popupCommentInst"), "Auto Generated Comment for Award");
	}

	private static void clickDoneButton(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//span[contains(text(),'Done')]/parent::button"));
	}

	public static void sendResultsToEproc(WebDriver driver, RfxEditor rfxEditor) throws ActionBotException
	{
		BidOptimizationHomePage bidOptimizationHomePage = new BidOptimizationHomePage(driver);
		bidOptimizationHomePage.clickActionLink(rfxEditor.getAwardScenario());
		clickSendResultToEprocLink(driver);
		fillEprocRequestComment(driver);
		clickSendResultToEprocButton(driver);
		geteProcResultSucessMsg(driver);
		clickCancelButton(driver);
	}

	private static void clickSendResultToEprocLink(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, By.id("sendToEprocButtonId"));
	}

	private static String fillEprocRequestComment(WebDriver driver) throws ActionBotException
	{
		return ActionBot.sendKeys(driver, By.id("integrationComment"), "Auto Generated Comment for Eproc Request");
	}

	private static void clickSendResultToEprocButton(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//span[contains(text(),'Send result to eProc')]/parent::button"));
	}

	public static String geteProcResultSucessMsg(WebDriver driver) throws ActionBotException
	{
		String msg = null;
		msg = ActionBot.getTextWithInElement(driver, By.xpath(".//*[@id='popUpHtml4']/div[2]"));
		logger.info("Eproc Result Success Message : " + msg);
		return msg;
	}

	private static void clickCancelButton(WebDriver driver) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath("(.//span[contains(text(),'Cancel')]/parent::button)[2]"));
	}

	public static void clickOnEprocProductSwitchTab(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath("(.//*[@id='newHeaderLowerPart']//label[contains(@class,'newDownArrow')])[1]"));

		WebElement element = ActionBot.findElement(driver, MainPageHeaderLevelTab.EPROC_PRODUCT_SELECTION_TAB_ON_SWITCH_PRODUCT);

		((JavascriptExecutor) driver).executeScript("arguments[0].click()", element);
		ActionBot.waitForPageLoad(driver);
		ScreenShot.screenshot(driver, testCaseName, "After clicking on eProc product selection tab");
	}

	public static void clickOnViewDraftButton(WebDriver driver, String testCaseName) throws ActionBotException
	{
		ActionBot.click(driver, By.xpath(".//*[@id='midContentArea']//input[@value='View Draft']"));
		ScreenShot.screenshot(driver, testCaseName, "After clicking on View Draft");
	}

	*//**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To compare line items details <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param lots </font><b><br>
	 * @param guidedItem </font><b><br>
	 * @return </b> <br>
	 *//*
	public static boolean compareLineItemsDetailsWithGuidedItem(Lots lots, GuidedItem guidedItem)
	{
		boolean flag = true;

		return flag;
	}

}
*/