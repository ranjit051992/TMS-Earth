package com.zycus.automation.eproc.businessflow.coaflow;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.zycus.automation.bo.COAMayerBrownDataBO;
import com.zycus.automation.bo.Requisition;
import com.zycus.automation.eproc.businessflow.allrequestsapprovalflow.FlowAllRequestsApproval;
import com.zycus.automation.eproc.businessflow.myrequisitionsflow.FlowMyRequisitions;
import com.zycus.automation.eproc.businessflow.requisitionflow.FlowRequisition;
import com.zycus.automation.eproc.pageobjects.pages.buyersdesklisting.PageBuyersDeskListing;
import com.zycus.automation.eproc.pageobjects.pages.viewrequisition.PageRequisitionView;
import com.zycus.automation.eproc.pageobjects.tabs.checkoutTabItemSummary.TabCheckoutItemSummary;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.exception.FactoryMethodException;
import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.automation.utilities.screenshot.ScreenShot;

public class COAFlow
{
	public static List<Boolean> verifyCoaFormOnViewPage(WebDriver driver, String testCaseName, int split) throws ActionBotException, InterruptedException
	{
		ScreenShot.screenshot(driver, testCaseName, "COA Form on ReqView Page");
		List<Boolean> flagList = new ArrayList<Boolean>();

		List<COAMayerBrownDataBO> enteredDataList = FlowRequisition.mayerBrownDataList;
		boolean flag = false;
		Thread.sleep(2000);
		List<COAMayerBrownDataBO> coaDataList = PageRequisitionView.getCOAMayerBrownData(split, driver, testCaseName);
		if (enteredDataList != null && coaDataList == null)
		{
			flag = false;
		}
		else
		{
			for (int i = 0; i < coaDataList.size(); i++)
			{
				COAMayerBrownDataBO viewData = coaDataList.get(coaDataList.size() - 1 - i);

				COAMayerBrownDataBO enteredData = enteredDataList.get(i);

				if (enteredData.getAmount() != null && enteredData.getAmount() != "")
				{
					if (viewData.getAmount().equalsIgnoreCase(enteredData.getAmount()))
					{

						flagList.add(true);
					}
					else
					{

						flagList.add(false);
					}
				}
				else
				{
					if ((enteredData.getAmount() == null || enteredData.getAmount() == "") && (viewData.getAmount() == null || viewData.getAmount() == ""))
					{

						flagList.add(true);
					}
					else
					{

						flagList.add(false);
					}
				}
				if (enteredData.getBookCostTo() != null && enteredData.getBookCostTo() != "" && viewData.getBookCostTo() != null && viewData.getBookCostTo() != "")
				{
					if (viewData.getBookCostTo().equalsIgnoreCase(enteredData.getBookCostTo()))
					{

						flagList.add(true);
					}
					else
					{

						flagList.add(false);
					}
				}
				else
				{
					if ((enteredData.getBookCostTo() == null || enteredData.getBookCostTo() == "") && (viewData.getBookCostTo() == null || viewData.getBookCostTo() == ""))
					{

						flagList.add(true);
					}
					else
					{

						flagList.add(false);
					}
				}
				if (enteredData.getClient() != null && enteredData.getClient() != "" && viewData.getClient() != null && viewData.getClient() != "")
				{
					if (viewData.getClient().equalsIgnoreCase(enteredData.getClient()))
					{

						flagList.add(true);
					}
					else
					{

						flagList.add(false);
					}
				}
				else
				{
					if ((enteredData.getClient() == null || enteredData.getClient() == "") && (viewData.getClient() == null || viewData.getClient() == ""))
					{

						flagList.add(true);
					}

					else
					{

						flagList.add(false);
					}
				}
				/*
				 * if (enteredData.getCostDisburseMentCode() != null &&
				 * enteredData.getCostDisburseMentCode() != "" &&
				 * viewData.getCostDisburseMentCode() != null &&
				 * viewData.getCostDisburseMentCode() != "") { if
				 * (viewData.getCostDisburseMentCode().equalsIgnoreCase(
				 * enteredData.getCostDisburseMentCode())) { flagList.add(true);
				 * } else { flagList.add(false); } } else { if
				 * ((enteredData.getCostDisburseMentCode() == null ||
				 * enteredData.getCostDisburseMentCode() == "") &&
				 * (viewData.getCostDisburseMentCode() == null ||
				 * viewData.getCostDisburseMentCode() == "")) {
				 * flagList.add(true); } else { flagList.add(false); } }
				 */
				if (enteredData.getDepartment() != null && enteredData.getDepartment() != "" && viewData.getDepartment() != null && viewData.getDepartment() != "")
				{
					if (viewData.getDepartment().equalsIgnoreCase(enteredData.getDepartment()))
					{

						flagList.add(true);
					}

					else
					{

						flagList.add(false);
					}
				}
				else
				{
					if ((enteredData.getDepartment() == null || enteredData.getDepartment() == "") && (viewData.getDepartment() == null || viewData.getDepartment() == ""))
					{

						flagList.add(true);
					}
					else if (enteredData.getDepartment() == "" && viewData.getDepartment() == "")
					{

						flagList.add(true);
					}
					else
					{

						flagList.add(false);
					}
				}
				if (enteredData.getDescription() != null && enteredData.getDescription() != "" && viewData.getDescription() != null && viewData.getDescription() != "")
				{
					if (viewData.getDescription().equalsIgnoreCase(enteredData.getDescription()))
					{

						flagList.add(true);
					}
					else
					{

						flagList.add(false);
					}
				}
				else
				{
					if ((enteredData.getDescription() == null || enteredData.getDescription() == "") && (viewData.getDescription() == null || viewData.getDescription() == ""))
					{

						flagList.add(true);
					}

					else
					{

						flagList.add(false);
					}
				}
				if (enteredData.getEmpTimekeeper() != null && enteredData.getEmpTimekeeper() != "" && viewData.getEmpTimekeeper() != null && viewData.getEmpTimekeeper() != "")
				{
					if (viewData.getEmpTimekeeper().equalsIgnoreCase(enteredData.getEmpTimekeeper()))
					{

						flagList.add(true);
					}
					else
					{

						flagList.add(false);
					}
				}
				else
				{
					if ((enteredData.getEmpTimekeeper() == null || enteredData.getEmpTimekeeper() == "")
						&& (viewData.getEmpTimekeeper() == null || viewData.getEmpTimekeeper() == ""))
					{

						flagList.add(true);
					}

					else
					{

						flagList.add(false);
					}
				}
				if (enteredData.getGlAccount() != null && enteredData.getGlAccount() != "" && viewData.getGlAccount() != null && viewData.getGlAccount() != "")
				{
					if (viewData.getGlAccount().equalsIgnoreCase(enteredData.getGlAccount()))
					{

						flagList.add(true);
					}
					else
					{

						flagList.add(false);
					}
				}
				else
				{
					if ((enteredData.getGlAccount() == null || enteredData.getGlAccount() == "") && (viewData.getGlAccount() == null || viewData.getGlAccount() == ""))
					{

						flagList.add(true);
					}

					else
					{

						flagList.add(false);
					}
				}
				if (enteredData.getMatter() != null && enteredData.getMatter() != "" && viewData.getMatter() != null && viewData.getMatter() != "")
				{
					if (viewData.getMatter().equalsIgnoreCase(enteredData.getMatter()))
					{

						flagList.add(true);
					}
					else
					{

						flagList.add(false);
					}
				}
				else
				{
					if ((enteredData.getMatter() == null || enteredData.getMatter() == "") && (viewData.getMatter() == null || viewData.getMatter() == ""))
					{

						flagList.add(true);
					}

					else
					{

						flagList.add(false);
					}
				}
				if (enteredData.getPercentage() != null && enteredData.getPercentage() != "" && viewData.getPercentage() != null && viewData.getPercentage() != "")
				{
					if (viewData.getPercentage().equalsIgnoreCase(enteredData.getPercentage()))
					{

						flagList.add(true);
					}
					else
					{

						flagList.add(false);
					}
				}
				else
				{
					if ((enteredData.getPercentage() == null || enteredData.getPercentage() == "") && (viewData.getPercentage() == null || viewData.getPercentage() == ""))
					{

						flagList.add(true);
					}

					else
					{

						flagList.add(false);
					}
				}
				if (enteredData.getTransactionDate() != null && enteredData.getTransactionDate() != "" && viewData.getTransactionDate() != null
					&& viewData.getTransactionDate() != "")
				{
					if (viewData.getTransactionDate().equalsIgnoreCase(enteredData.getTransactionDate()))
					{

						flagList.add(true);
					}
					else
					{

						flagList.add(false);
					}
				}
				else
				{
					if ((enteredData.getTransactionDate() == null || enteredData.getTransactionDate() == "")
						&& (viewData.getTransactionDate() == null || viewData.getTransactionDate() == ""))
					{

						flagList.add(true);
					}

					else
					{

						flagList.add(false);
					}
				}
				/*
				 * if (enteredData.getFinalAmount() != null &&
				 * enteredData.getFinalAmount() != "" &&
				 * viewData.getFinalAmount() != null &&
				 * viewData.getFinalAmount() != "") { if
				 * (viewData.getFinalAmount().equalsIgnoreCase(enteredData.
				 * getFinalAmount())) { flagList.add(true); } else {
				 * flagList.add(false); } } else { if
				 * ((enteredData.getFinalAmount() == null ||
				 * enteredData.getFinalAmount() == "") &&
				 * (viewData.getFinalAmount() == null ||
				 * viewData.getFinalAmount() == "")) { flagList.add(true); }
				 * else { flagList.add(false); } }
				 */
			}

		}
		return flagList;

	}

	public static void fromApprovalToBuyersDeskFlow(WebDriver driver, String testCaseName, Requisition req) throws ActionBotException, FactoryMethodException, InterruptedException
	{

		MainPageHeaderLevelTab.clickOnApprovalAllRequestsTab(driver);
		FlowAllRequestsApproval.SearchAndClickRequisition(driver, testCaseName, req.getReqName());
		Thread.sleep(2000);
		/* ; */

		// MainPageHeaderLevelTab.clickOnApprovalAllRequestsTab(driver);
		WebElement checkBoxElement = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]/input"));
		checkBoxElement.click();
		WebElement aopproveLink = driver.findElement(By.xpath("//a[@id='dev_lnkApprove']/span[@class='ppI'][contains(text(),'Approve')]"));
		aopproveLink.click();
		WebElement commentElement = driver.findElement(By.xpath("//textarea[@id='approvalComments']"));
		commentElement.click();
		commentElement.sendKeys("Approved");
		WebElement approveButton = driver.findElement(By.xpath("//input[@id='approveCommentBtn']"));
		approveButton.click();
		Thread.sleep(5000);

		MainPageHeaderLevelTab.clickOnBuyersDeskSubTab(driver, testCaseName);
		WebElement reqNameSearchBoxOnBuyersDesk = driver.findElement(By.xpath("//input[@id='txtFltrReqName']"));
		reqNameSearchBoxOnBuyersDesk.click();
		reqNameSearchBoxOnBuyersDesk.clear();
		reqNameSearchBoxOnBuyersDesk.sendKeys(req.getReqName());
		Thread.sleep(2000);
		WebElement firstReqLink = driver.findElement(By.xpath("//a[@class='scLnk']"));
		firstReqLink.click();// click is not working
		Thread.sleep(4000);
		// FlowMyRequisitions.viewRequisition(driver, testCaseName);
		viewCoaFormOnBuyersDesk(driver, testCaseName, false);

	}

	public static boolean viewCoaFormOnBuyersDesk(WebDriver driver, String testCaseName, boolean freeTextItem)
		throws ActionBotException, FactoryMethodException, InterruptedException, ActionBotException
	{
		ScreenShot.screenshot(driver, testCaseName, "COA form on Buyersdesk view page");
		boolean flag = false;
		ActionBot.defaultMediumSleep();
		List<COAMayerBrownDataBO> enteredDataList = FlowRequisition.mayerBrownDataList;
		List<COAMayerBrownDataBO> mayerDataList = new ArrayList<COAMayerBrownDataBO>();
		// fromApprovalToBuyersDeskFlow(driver, testCaseName);

		By expandAllTextBox = By.xpath("//a[@href='#'][contains(text(),'Expand All')]");
		ActionBot.click(driver, expandAllTextBox);
		By checkBox = null;

		if (freeTextItem)
		{
			checkBox = By.xpath("(//input[@class='itemChk autoCheckItem applyMultipleChk'])[2]");
		}
		else
		{
			checkBox = By.xpath("(//input[@class='itemChk autoCheckItem applyMultipleChk'])[1]");
		}

		ActionBot.click(driver, checkBox);

		By editLink = By.xpath("(//a[contains(text(),'Edit')])[3]");
		ActionBot.click(driver, editLink);
		ScreenShot.screenshot(driver, "", "After clicking edit link");
		Thread.sleep(3000);
		List<WebElement> buyersDeskCoaRows = ActionBot.findElements(driver, By.xpath("//div/div[2]/ul/li[2]/div[3]/div[2]/div[3]/div[2]/div[2]/table/tbody/tr"));
		System.out.println(buyersDeskCoaRows.size());
		List<WebElement> coaDataOnBuyersDeskHeaderList = ActionBot.findElements(driver,
			By.xpath("//div/form/div/div[2]/ul/li[2]/div[3]/div[2]/div[3]/div[2]/div[1]/div/table/thead/tr/th"));
		int counter = 2;
		int counter1 = 1;
		int headerCounter = 1;
		for (int i = 1; i < buyersDeskCoaRows.size(); i++)
		{
			COAMayerBrownDataBO mayerData = new COAMayerBrownDataBO();
			for (WebElement element : coaDataOnBuyersDeskHeaderList)
			{
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", driver,
					By.xpath("//div/form/div/div[2]/ul/li[2]/div[3]/div[2]/div[3]/div[2]/div[1]/div/table/thead/tr/th[" + headerCounter + "]/div"));
				WebElement headerEle = ActionBot.findElement(driver,
					By.xpath("//div/form/div/div[2]/ul/li[2]/div[3]/div[2]/div[3]/div[2]/div[1]/div/table/thead/tr/th[" + headerCounter + "]/div"));

				String text = headerEle.getText();
				if (text != null && !(text.trim().equalsIgnoreCase("")) && !(text.trim().equals("	")))
				{
					WebElement dataEle = ActionBot.findElement(driver,
						By.xpath("//div/div[2]/ul/li[2]/div[3]/div[2]/div[3]/div[2]/div[2]/table/tbody/tr[" + counter + "]/td[" + counter1 + "]"));
					if (text.trim().contains("Book Cost to"))
					{
						mayerData.setBookCostTo(dataEle.getText());
					}
					else if (text.trim().equalsIgnoreCase("") || text.trim().equalsIgnoreCase(null) || text.trim().equalsIgnoreCase(" "))
					{

					}
					else if (text.trim().contains("Matter"))
					{
						mayerData.setMatter(dataEle.getText());
					}
					else if (text.trim().contains("Client"))
					{
						mayerData.setClient(dataEle.getText());
					}
					else if (text.trim().contains("GL Account"))
					{
						mayerData.setGlAccount(dataEle.getText());
					}
					else if (text.trim().contains("Employee/Timekeeper"))
					{
						mayerData.setEmpTimekeeper(dataEle.getText());
					}
					else if (text.trim().contains("Office"))
					{
						mayerData.setOffice(dataEle.getText());
					}
					else if (text.trim().contains("Cost / Disbursement Code"))
					{
						mayerData.setCostDisburseMentCode(dataEle.getText());
					}
					else if (text.trim().contains("Department"))
					{
						mayerData.setDepartment(dataEle.getText());
					}
					else if (text.trim().contains("Profit Center"))
					{
						mayerData.setProfitCenter(dataEle.getText());
					}
					else if (text.trim().contains("Transaction Date"))
					{
						mayerData.setTransactionDate(dataEle.getText());
					}
					else if (text.trim().contains("Description"))
					{
						mayerData.setDescription(dataEle.getText());
					}
					else if (text.trim().contains("Percentage"))
					{
						mayerData.setPercentage(dataEle.getText());
					}
					else if (text.trim().contains("Quantity"))
					{
						mayerData.setQuantity(dataEle.getText());
					}
					else if (text.trim().contains("Amount"))
					{
						mayerData.setAmount(dataEle.getText());
					}
					else if (text.trim().contains("Final Amount"))
					{
						mayerData.setFinalAmount(dataEle.getText());
					}

				}
				counter1++;
				headerCounter++;
			}
			mayerDataList.add(mayerData);
			counter++;
		}
		ScreenShot.screenshot(driver, "", "After filling COA form");
		List<Boolean> flagList = compareTwoObject(enteredDataList, mayerDataList);
		if (flagList.contains(false))
		{
			flag = false;
		}
		else
		{
			flag = true;
		}
		return flag;
	}

	public static void viewCoaDataFromApprovalPage(WebDriver driver) throws ActionBotException
	{
		List<WebElement> approvalGridHeaderEle = ActionBot.findElements(driver, By.xpath("//div/div[2]/ul/li[2]/div[2]/div[2]/div[3]/div[1]/div/table/thead/tr/th/div"));
		List<WebElement> approvalPageElements = ActionBot.findElements(driver, By.xpath("//div/div[2]/ul/li[2]/div[2]/div[2]/div[3]/div[2]/table/tbody/tr"));

		int counter = 2;
		int counter1 = 1;
		List<COAMayerBrownDataBO> mayerDataList = new ArrayList<COAMayerBrownDataBO>();
		for (int i = 0; i < approvalPageElements.size(); i++)
		{
			COAMayerBrownDataBO mayerData = new COAMayerBrownDataBO();
			for (int j = 0; j < approvalGridHeaderEle.size(); j++)
			{
				WebElement headerEle = ActionBot.findElement(driver, By.xpath("//div/div[2]/ul/li[2]/div[2]/div[2]/div[3]/div[1]/div/table/thead/tr/th[" + i + "]/div"));
				String text = headerEle.getText();
				WebElement dataEle = ActionBot.findElement(driver,
					By.xpath("//div/div[2]/ul/li[2]/div[2]/div[2]/div[3]/div[2]/table/tbody/tr[" + counter + "]/td[" + counter1 + "]"));
				if (text.trim().equalsIgnoreCase("Book Cost to"))
				{
					mayerData.setBookCostTo(dataEle.getText());
				}
				else if (text.trim().equalsIgnoreCase("Matter"))
				{
					mayerData.setMatter(dataEle.getText());
				}
				else if (text.trim().equalsIgnoreCase("Client"))
				{
					mayerData.setClient(dataEle.getText());
				}
				else if (text.trim().equalsIgnoreCase("GL Account"))
				{
					mayerData.setGlAccount(dataEle.getText());
				}
				else if (text.trim().equalsIgnoreCase("Employee/Timekeeper"))
				{
					mayerData.setEmpTimekeeper(dataEle.getText());
				}
				else if (text.trim().equalsIgnoreCase("Office"))
				{
					mayerData.setOffice(dataEle.getText());
				}
				else if (text.trim().equalsIgnoreCase("Cost / Disbursement Code"))
				{
					mayerData.setCostDisburseMentCode(dataEle.getText());
				}
				else if (text.trim().equalsIgnoreCase("Department"))
				{
					mayerData.setDepartment(dataEle.getText());
				}
				else if (text.trim().equalsIgnoreCase("Profit Center"))
				{
					mayerData.setProfitCenter(dataEle.getText());
				}
				else if (text.trim().equalsIgnoreCase("Transaction Date"))
				{
					mayerData.setTransactionDate(dataEle.getText());
				}
				else if (text.trim().equalsIgnoreCase("Description"))
				{
					mayerData.setDescription(dataEle.getText());
				}
				else if (text.trim().equalsIgnoreCase("Percentage"))
				{
					mayerData.setPercentage(dataEle.getText());
				}
				else if (text.trim().equalsIgnoreCase("Quantity"))
				{
					mayerData.setQuantity(dataEle.getText());
				}
				else if (text.trim().equalsIgnoreCase("Amount"))
				{
					mayerData.setAmount(dataEle.getText());
				}
				else if (text.trim().equalsIgnoreCase("Final Amount"))
				{
					mayerData.setFinalAmount(dataEle.getText());
				}
				counter1++;
			}
			counter++;
			mayerDataList.add(mayerData);
		}
	}

	public static List<COAMayerBrownDataBO> viewCoaDataFromPOPage(WebDriver driver) throws ActionBotException
	{
		By dataIconEle = By.xpath("(//a[@class='icon coaicon costingAccountingLnk'])[1]");
		ActionBot.click(driver, dataIconEle);
		List<COAMayerBrownDataBO> mayerDataList = new ArrayList<COAMayerBrownDataBO>();
		List<WebElement> headerListOnPO = ActionBot.findElements(driver, By.xpath("//div/div[2]/ul/li[2]/div[2]/div[2]/div[3]/div[1]/div/table/thead/tr/th/div"));

		List<WebElement> dataListOnPO = ActionBot.findElements(driver, By.xpath("//div/div[2]/ul/li[2]/div[2]/div[2]/div[3]/div[2]/table/tbody/tr"));
		int counter = 1;
		int counter1 = 1;
		for (int i = 1; i <= dataListOnPO.size(); i++)
		{
			COAMayerBrownDataBO mayerData = new COAMayerBrownDataBO();
			for (int j = 1; j <= headerListOnPO.size(); j++)
			{
				WebElement headerElement = ActionBot.findElement(driver, By.xpath("//div/div[2]/ul/li[2]/div[2]/div[2]/div[3]/div[1]/div/table/thead/tr/th[" + counter1 + "]/div"));
				String text = headerElement.getText();
				WebElement dataEle = ActionBot.findElement(driver,
					By.xpath("//div/div[2]/ul/li[2]/div[2]/div[2]/div[3]/div[2]/table/tbody/tr[" + counter + "]/td[" + counter1 + "]"));
				if (text.trim().equalsIgnoreCase("Book Cost to"))
				{
					mayerData.setBookCostTo(dataEle.getText());
				}
				else if (text.trim().equalsIgnoreCase("Matter"))
				{
					mayerData.setMatter(dataEle.getText());
				}
				else if (text.trim().equalsIgnoreCase("Client"))
				{
					mayerData.setClient(dataEle.getText());
				}
				else if (text.trim().equalsIgnoreCase("GL Account"))
				{
					mayerData.setGlAccount(dataEle.getText());
				}
				else if (text.trim().equalsIgnoreCase("Employee/Timekeeper"))
				{
					mayerData.setEmpTimekeeper(dataEle.getText());
				}
				else if (text.trim().equalsIgnoreCase("Office"))
				{
					mayerData.setOffice(dataEle.getText());
				}
				else if (text.trim().equalsIgnoreCase("Cost / Disbursement Code"))
				{
					mayerData.setCostDisburseMentCode(dataEle.getText());
				}
				else if (text.trim().equalsIgnoreCase("Department"))
				{
					mayerData.setDepartment(dataEle.getText());
				}
				else if (text.trim().equalsIgnoreCase("Profit Center"))
				{
					mayerData.setProfitCenter(dataEle.getText());
				}
				else if (text.trim().equalsIgnoreCase("Transaction Date"))
				{
					mayerData.setTransactionDate(dataEle.getText());
				}
				else if (text.trim().equalsIgnoreCase("Description"))
				{
					mayerData.setDescription(dataEle.getText());
				}
				else if (text.trim().equalsIgnoreCase("Percentage"))
				{
					mayerData.setPercentage(dataEle.getText());
				}
				else if (text.trim().equalsIgnoreCase("Quantity"))
				{
					mayerData.setQuantity(dataEle.getText());
				}
				else if (text.trim().equalsIgnoreCase("Amount"))
				{
					mayerData.setAmount(dataEle.getText());
				}
				else if (text.trim().equalsIgnoreCase("Final Amount"))
				{
					mayerData.setFinalAmount(dataEle.getText());
				}
				counter1++;
			}
			counter++;
			mayerDataList.add(mayerData);
		}
		return mayerDataList;
	}

	public static List<Boolean> compareTwoObject(List<COAMayerBrownDataBO> enteredDataList, List<COAMayerBrownDataBO> viewedDataList)
	{
		boolean flag = false;
		List<Boolean> flagList = new ArrayList<Boolean>();

		if (enteredDataList.size() != viewedDataList.size())
		{
			flag = false;
		}
		else
		{
			for (int i = 0; i < enteredDataList.size(); i++)
			{

				COAMayerBrownDataBO viewData = viewedDataList.get(i);

				COAMayerBrownDataBO enteredData = enteredDataList.get(i);

				if (enteredData.getAmount() != null && enteredData.getAmount() != "")
				{
					if (viewData.getAmount().equalsIgnoreCase(enteredData.getAmount()))
					{

						flagList.add(true);
					}
					else
					{

						flagList.add(false);
					}
				}
				else
				{
					if ((enteredData.getAmount() == null || enteredData.getAmount() == "") && (viewData.getAmount() == null || viewData.getAmount() == ""))
					{

						flagList.add(true);
					}
					else
					{

						flagList.add(false);
					}
				}
				if (enteredData.getBookCostTo() != null && enteredData.getBookCostTo() != "" && viewData.getBookCostTo() != null && viewData.getBookCostTo() != "")
				{
					if (viewData.getBookCostTo().equalsIgnoreCase(enteredData.getBookCostTo()))
					{

						flagList.add(true);
					}
					else
					{

						flagList.add(false);
					}
				}
				else
				{
					if ((enteredData.getBookCostTo() == null || enteredData.getBookCostTo() == "") && (viewData.getBookCostTo() == null || viewData.getBookCostTo() == ""))
					{

						flagList.add(true);
					}
					else
					{

						flagList.add(false);
					}
				}
				if (enteredData.getClient() != null && enteredData.getClient() != "" && viewData.getClient() != null && viewData.getClient() != "")
				{
					if (viewData.getClient().equalsIgnoreCase(enteredData.getClient()))
					{

						flagList.add(true);
					}
					else
					{

						flagList.add(false);
					}
				}
				else
				{
					if ((enteredData.getClient() == null || enteredData.getClient() == "") && (viewData.getClient() == null || viewData.getClient() == ""))
					{

						flagList.add(true);
					}

					else
					{

						flagList.add(false);
					}
				}
				if (enteredData.getCostDisburseMentCode() != null && enteredData.getCostDisburseMentCode() != "" && viewData.getCostDisburseMentCode() != null
					&& viewData.getCostDisburseMentCode() != "")
				{
					if (viewData.getCostDisburseMentCode().equalsIgnoreCase(enteredData.getCostDisburseMentCode()))
					{

						flagList.add(true);
					}
					else
					{

						flagList.add(false);
					}
				}
				else
				{
					if ((enteredData.getCostDisburseMentCode() == null || enteredData.getCostDisburseMentCode() == "")
						&& (viewData.getCostDisburseMentCode() == null || viewData.getCostDisburseMentCode() == ""))
					{

						flagList.add(true);
					}

					else
					{

						flagList.add(false);
					}
				}
				if (enteredData.getDepartment() != null && enteredData.getDepartment() != "" && viewData.getDepartment() != null && viewData.getDepartment() != "")
				{
					if (viewData.getDepartment().equalsIgnoreCase(enteredData.getDepartment()))
					{

						flagList.add(true);
					}

					else
					{

						flagList.add(false);
					}
				}
				else
				{
					if ((enteredData.getDepartment() == null || enteredData.getDepartment() == "") && (viewData.getDepartment() == null || viewData.getDepartment() == ""))
					{

						flagList.add(true);
					}
					else if (enteredData.getDepartment() == "" && viewData.getDepartment() == "")
					{

						flagList.add(true);
					}
					else
					{

						flagList.add(false);
					}
				}
				if (enteredData.getDescription() != null && enteredData.getDescription() != "" && viewData.getDescription() != null && viewData.getDescription() != "")
				{
					if (viewData.getDescription().equalsIgnoreCase(enteredData.getDescription()))
					{

						flagList.add(true);
					}
					else
					{

						flagList.add(false);
					}
				}
				else
				{
					if ((enteredData.getDescription() == null || enteredData.getDescription() == "") && (viewData.getDescription() == null || viewData.getDescription() == ""))
					{

						flagList.add(true);
					}

					else
					{

						flagList.add(false);
					}
				}
				if (enteredData.getEmpTimekeeper() != null && enteredData.getEmpTimekeeper() != "" && viewData.getEmpTimekeeper() != null && viewData.getEmpTimekeeper() != "")
				{
					if (viewData.getEmpTimekeeper().equalsIgnoreCase(enteredData.getEmpTimekeeper()))
					{

						flagList.add(true);
					}
					else
					{

						flagList.add(false);
					}
				}
				else
				{
					if ((enteredData.getEmpTimekeeper() == null || enteredData.getEmpTimekeeper() == "")
						&& (viewData.getEmpTimekeeper() == null || viewData.getEmpTimekeeper() == ""))
					{

						flagList.add(true);
					}

					else
					{

						flagList.add(false);
					}
				}
				if (enteredData.getGlAccount() != null && enteredData.getGlAccount() != "" && viewData.getGlAccount() != null && viewData.getGlAccount() != "")
				{
					if (viewData.getGlAccount().equalsIgnoreCase(enteredData.getGlAccount()))
					{

						flagList.add(true);
					}
					else
					{

						flagList.add(false);
					}
				}
				else
				{
					if ((enteredData.getGlAccount() == null || enteredData.getGlAccount() == "") && (viewData.getGlAccount() == null || viewData.getGlAccount() == ""))
					{

						flagList.add(true);
					}

					else
					{

						flagList.add(false);
					}
				}
				if (enteredData.getMatter() != null && enteredData.getMatter() != "" && viewData.getMatter() != null && viewData.getMatter() != "")
				{
					if (viewData.getMatter().equalsIgnoreCase(enteredData.getMatter()))
					{

						flagList.add(true);
					}
					else
					{

						flagList.add(false);
					}
				}
				else
				{
					if ((enteredData.getMatter() == null || enteredData.getMatter() == "") && (viewData.getMatter() == null || viewData.getMatter() == ""))
					{
						flagList.add(true);
					}

					else
					{

						flagList.add(false);
					}
				}
				if (enteredData.getPercentage() != null && enteredData.getPercentage() != "" && viewData.getPercentage() != null && viewData.getPercentage() != "")
				{
					if (viewData.getPercentage().equalsIgnoreCase(enteredData.getPercentage()))
					{

						flagList.add(true);
					}
					else
					{

						flagList.add(false);
					}
				}
				else
				{
					if ((enteredData.getPercentage() == null || enteredData.getPercentage() == "") && (viewData.getPercentage() == null || viewData.getPercentage() == ""))
					{

						flagList.add(true);
					}

					else
					{

						flagList.add(false);
					}
				}
				if (enteredData.getTransactionDate() != null && enteredData.getTransactionDate() != "" && viewData.getTransactionDate() != null
					&& viewData.getTransactionDate() != "")
				{
					if (viewData.getTransactionDate().equalsIgnoreCase(enteredData.getTransactionDate()))
					{

						flagList.add(true);
					}
					else
					{

						flagList.add(false);
					}
				}
				else
				{
					if ((enteredData.getTransactionDate() == null || enteredData.getTransactionDate() == "")
						&& (viewData.getTransactionDate() == null || viewData.getTransactionDate() == ""))
					{

						flagList.add(true);
					}

					else
					{

						flagList.add(false);
					}
				}
				if (enteredData.getFinalAmount() != null && enteredData.getFinalAmount() != "" && viewData.getFinalAmount() != null && viewData.getFinalAmount() != "")
				{
					if (viewData.getFinalAmount().equalsIgnoreCase(enteredData.getFinalAmount()))
					{

						flagList.add(true);
					}
					else
					{

						flagList.add(false);
					}
				}
				else
				{
					if ((enteredData.getFinalAmount() == null || enteredData.getFinalAmount() == "") && (viewData.getFinalAmount() == null || viewData.getFinalAmount() == ""))
					{

						flagList.add(true);
					}
					else
					{

						flagList.add(false);
					}
				}
			}

		}
		return flagList;
	}

	public static boolean compareTwoVersionFromAuditTrail(WebDriver driver, String testCaseName, int split, List<COAMayerBrownDataBO> versionOneList,
		List<COAMayerBrownDataBO> versionTwoList) throws ActionBotException, InterruptedException
	{
		boolean flag = false;
		try
		{

			Thread.sleep(2000);
			WebDriver auditTrailDriver = null;
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,1000)", "");

			WebElement element = ActionBot.findElement(driver, By.xpath("//a[@class='scLnk auditLink'][contains(text(),'v1')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
			Thread.sleep(2000);
			PageRequisitionView.clickOnAuditTrailFirstVersionOnReqView(driver, testCaseName);
			Thread.sleep(15000);
			String parentWindow = driver.getWindowHandle();

			auditTrailDriver = getWindowDriver(driver);
			List<COAMayerBrownDataBO> firstVersionDataList = getMayerBrownDataBOList(auditTrailDriver, testCaseName, split);
			List<Boolean> flagList1 = compareTwoObject(versionOneList, firstVersionDataList);
			auditTrailDriver.close();
			auditTrailDriver.switchTo().window(parentWindow);
			WebElement V2element = ActionBot.findElement(driver, By.xpath("//a[@class='scLnk auditLink'][contains(text(),'v2')]"));
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", V2element);
			PageRequisitionView.clickOnAuditTrailSecondVersionOnReqView(driver, testCaseName);
			Thread.sleep(15000);
			auditTrailDriver = getWindowDriver(driver);
			List<COAMayerBrownDataBO> secondVersionDataList = getMayerBrownDataBOList(auditTrailDriver, testCaseName, split);
			List<Boolean> flagList2 = compareTwoObject(versionTwoList, secondVersionDataList);

			if (flagList1.contains(false) || flagList2.contains(false))
			{
				flag = false;
			}
			else
			{
				flag = true;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return flag;
	}

	public static WebDriver getWindowDriver(WebDriver driver) throws InterruptedException
	{
		Thread.sleep(2000);
		Set<String> windowHandles = driver.getWindowHandles();
		WebDriver auditTrailDriver = null;
		for (String window : windowHandles)
		{
			WebDriver driver1 = driver.switchTo().window(window);
			if (driver1.findElements(By.xpath("//h1[contains(text(),'Requisition Details')]")).size() > 0)
			{
				auditTrailDriver = driver1;
				break;
			}
		}
		return auditTrailDriver;
	}

	public static List<COAMayerBrownDataBO> getMayerBrownDataBOList(WebDriver auditTrailDriver, String testCaseName, int split) throws ActionBotException
	{
		List<COAMayerBrownDataBO> firstVersionDataList = null;
		if (auditTrailDriver != null)
		{
			auditTrailDriver.manage().window().maximize();
			WebElement auditTrailViewSummary = auditTrailDriver.findElement(By.xpath("//a[@class='icon comments itemComments']"));
			auditTrailViewSummary.click();
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(auditTrailDriver, testCaseName);
			firstVersionDataList = PageRequisitionView.getCOAMayerBrownData(split, auditTrailDriver, testCaseName);
		}
		return firstVersionDataList;
	}

	public static void openItemSummaryPopUpOnBuyersDesk(WebDriver driver, boolean freetext, String testCaseName) throws ActionBotException
	{
		ActionBot.defaultSleep();

		By checkBox = null;
		if (freetext)
		{
			checkBox = By.xpath("(//input[@class='itemChk autoCheckItem applyMultipleChk'])[2]");
		}
		else
		{
			checkBox = By.xpath("(//input[@class='itemChk autoCheckItem applyMultipleChk'])[1]");
		}
		ActionBot.click(driver, checkBox);

		/*
		 * By itemCheckBox = By.xpath(
		 * "//input[@class='itemChk autoCheckItem applyMultipleChk']");
		 * ActionBot.click(driver, itemCheckBox);
		 */

		By editLink = By.xpath("//a[@class='icon edit splitItem' and @title='Edit']");
		ActionBot.click(driver, editLink);

		TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);
		ActionBot.defaultSleep();
	}

	public static void clickOnOkButtonOfCoaForm(WebDriver driver) throws ActionBotException
	{
		By okButton = By.xpath("//input[@id='saveRequisitionItemSummary']");
		ActionBot.click(driver, okButton);
	}

	public static boolean viewMultipleItemsOnReqViewPage(WebDriver driver, String testCaseName, List<COAMayerBrownDataBO> reqDataList, List<COAMayerBrownDataBO> itemDataList)
		throws ActionBotException, FactoryMethodException, InterruptedException, ActionBotException
	{
		List<Boolean> flagList = null;
		boolean flag = false;
		List<COAMayerBrownDataBO> mayerBrownDataList = new ArrayList<COAMayerBrownDataBO>();
		List<WebElement> viewAttachmentEleList = driver.findElements(By.xpath("//a[@class='icon uploadicon itemAttachments' and @title='View attachments']"));
		int loopCounter = 0;
		for (WebElement viewEle : viewAttachmentEleList)
		{
			// Click On View Attachment link
			viewEle.click();
			TabCheckoutItemSummary.clickItemSummaryCostBookingTab(driver, testCaseName);

			ActionBot.defaultSleep();
			List<WebElement> buyersDeskCoaRows = ActionBot.findElements(driver, By.xpath("//div/form/div[2]/div[2]/ul/li[2]/div[2]/div[2]/div[3]/div[2]/table/tbody/tr"));
			System.out.println(buyersDeskCoaRows.size());
			List<WebElement> coaDataOnBuyersDeskHeaderList = ActionBot.findElements(driver,
				By.xpath("//div/form/div[2]/div[2]/ul/li[2]/div[2]/div[2]/div[3]/div[1]/div/table/thead/tr/th/div"));
			int counter = 1;
			int counter1 = 1;
			int headerCounter = 1;
			for (int i = 0; i < buyersDeskCoaRows.size(); i++)
			{
				COAMayerBrownDataBO mayerData = new COAMayerBrownDataBO();
				for (WebElement element : coaDataOnBuyersDeskHeaderList)
				{

					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",
						ActionBot.findElement(driver, By.xpath("//div/form/div[2]/div[2]/ul/li[2]/div[2]/div[2]/div[3]/div[1]/div/table/thead/tr/th[" + headerCounter + "]/div")));
					WebElement headerEle = ActionBot.findElement(driver,
						By.xpath("//div/form/div[2]/div[2]/ul/li[2]/div[2]/div[2]/div[3]/div[1]/div/table/thead/tr/th[" + headerCounter + "]/div"));
					String text = headerEle.getText();
					if (text != null && !(text.trim().equalsIgnoreCase("")) && !(text.trim().equals("	")))
					{
						WebElement dataEle = ActionBot.findElement(driver,
							By.xpath("//div/form/div[2]/div[2]/ul/li[2]/div[2]/div[2]/div[3]/div[2]/table/tbody/tr[" + counter + "]/td[" + counter1 + "]"));
						if (text.trim().contains("Book Cost to"))
						{
							mayerData.setBookCostTo(dataEle.getText());
						}
						else if (text.trim().equalsIgnoreCase("") || text.trim().equalsIgnoreCase(null) || text.trim().equalsIgnoreCase(" "))
						{

						}
						else if (text.trim().contains("Matter"))
						{
							mayerData.setMatter(dataEle.getText());
						}
						else if (text.trim().contains("Client"))
						{
							mayerData.setClient(dataEle.getText());
						}
						else if (text.trim().contains("GL Account"))
						{
							mayerData.setGlAccount(dataEle.getText());
						}
						else if (text.trim().contains("Employee/Timekeeper"))
						{
							mayerData.setEmpTimekeeper(dataEle.getText());
						}
						else if (text.trim().contains("Office"))
						{
							mayerData.setOffice(dataEle.getText());
						}
						else if (text.trim().contains("Cost / Disbursement Code"))
						{
							mayerData.setCostDisburseMentCode(dataEle.getText());
						}
						else if (text.trim().contains("Department"))
						{
							mayerData.setDepartment(dataEle.getText());
						}
						else if (text.trim().contains("Profit Center"))
						{
							mayerData.setProfitCenter(dataEle.getText());
						}
						else if (text.trim().contains("Transaction Date"))
						{
							mayerData.setTransactionDate(dataEle.getText());
						}
						else if (text.trim().contains("Description"))
						{
							mayerData.setDescription(dataEle.getText());
						}
						else if (text.trim().contains("Percentage"))
						{
							mayerData.setPercentage(dataEle.getText());
						}
						else if (text.trim().contains("Quantity"))
						{
							mayerData.setQuantity(dataEle.getText());
						}
						else if (text.trim().contains("Amount"))
						{
							mayerData.setAmount(dataEle.getText());
						}
						else if (text.trim().contains("Final Amount"))
						{
							mayerData.setFinalAmount(dataEle.getText());
						}

					}
					counter1++;
					headerCounter++;
				}
				mayerBrownDataList.add(mayerData);
				counter++;
			}
			if (counter == 0)
			{
				flagList = compareTwoObject(reqDataList, mayerBrownDataList);
				if (flagList.contains(false))
				{
					flag = false;
				}
				else
				{
					flag = true;
				}
			}
			if (counter == 1)
			{
				flagList = compareTwoObject(itemDataList, mayerBrownDataList);
				if (flagList.contains(false))
				{
					flag = false;
				}
				else
				{
					flag = true;
				}
			}

		}
		return flag;
	}
}
