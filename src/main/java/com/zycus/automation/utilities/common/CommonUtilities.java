package com.zycus.automation.utilities.common;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.exec.util.StringUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.bo.CatelogItem;
import com.zycus.automation.bo.CostCenterSplitInfo;
import com.zycus.automation.bo.CustomDate;
import com.zycus.automation.bo.Requisition;
import com.zycus.automation.eproc.pageobjects.tabs.mainpageheaderleveltabs.MainPageHeaderLevelTab;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.exception.ActionBotException;
import com.zycus.automation.services.CommonServices;
import com.zycus.framework.framework_version_2_4.framework.Helper;

public class CommonUtilities
{
	static Logger logger = Logger.getLogger(CommonUtilities.class);

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> To get non-zero random number <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param size
	 *        </font><b><br>
	 * @return integer</b> <br>
	 */
	public static Integer getNonZeroRandomNumbers(int size)
	{
		Integer number = 0;
		while (number == 0 || number == 1)
		{
			number = Integer.parseInt(Helper.getRandomNumber(size));
		}
		return number;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> To get non-zero random number <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param size
	 *        </font><b><br>
	 * @return integer</b> <br>
	 */
	public static float getNonZeroRandomNumber(int size)
	{
		float number = 0;
		while (number == 0 || number == 1)
		{
			number = Float.parseFloat(Helper.getRandomNumber(size));
		}
		return number;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> To get non-zero random number <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param size
	 *        </font><b><br>
	 * @param listSize
	 *        </font><b><br>
	 * @return list of integer </b> <br>
	 */
	public static List<Integer> getNonZeroRandomNumbers(int size, int listSize)
	{
		List<Integer> intList = new ArrayList<Integer>();
		for (int i = 0; i < listSize; i++)
		{
			int number = 0;
			while (number == 0)
			{
				number = Integer.parseInt(Helper.getRandomNumber(size));
			}
			intList.add(number);
		}

		return intList;
	}

	public static String getReqName() throws Exception
	{
		String reqName = CommonServices.getTestData("reqName", 0) + "_" + System.currentTimeMillis();
		return reqName;

	}

	public static CustomDate getRequiredBy()
	{
		CustomDate customDate = new CustomDate();
		Calendar today = Calendar.getInstance();
		customDate.setDay(today.get(Calendar.DATE));
		customDate.setMonth(today.get(Calendar.MONTH));
		customDate.setYear(today.get(Calendar.YEAR));
		customDate.setDate(today.get(Calendar.DATE) + "/" + (today.get(Calendar.MONTH) + 1) + "/" + today.get(Calendar.YEAR));
		logger.info("The date is " + customDate);
		return customDate;
	}

	public static CustomDate getPreviousDayDate()
	{
		CustomDate customDate = new CustomDate();
		Calendar today = Calendar.getInstance();

		long timeInMillis = today.getTimeInMillis();

		Calendar previousDay = Calendar.getInstance();
		previousDay.setTimeInMillis(timeInMillis - 86400000);

		customDate.setMonth(previousDay.get(Calendar.MONTH));
		customDate.setDay(previousDay.get(Calendar.DAY_OF_MONTH));
		customDate.setYear(previousDay.get(Calendar.YEAR));
		customDate.setDate(previousDay.get(Calendar.DATE) + "/" + (previousDay.get(Calendar.MONTH) + 1) + "/" + previousDay.get(Calendar.YEAR));
		return customDate;
	}

	public static CustomDate getFutureDayDate()
	{
		CustomDate customDate = new CustomDate();
		Calendar today = Calendar.getInstance();

		long timeInMillis = today.getTimeInMillis();

		Calendar previousDay = Calendar.getInstance();
		previousDay.setTimeInMillis(timeInMillis + 86400000);

		customDate.setMonth(previousDay.get(Calendar.MONTH));
		customDate.setDay(previousDay.get(Calendar.DAY_OF_MONTH));
		customDate.setYear(previousDay.get(Calendar.YEAR));
		customDate.setDate(previousDay.get(Calendar.DATE) + "/" + (previousDay.get(Calendar.MONTH) + 1) + "/" + previousDay.get(Calendar.YEAR));
		return customDate;
	}

	public static String getCostCenter() throws Exception
	{
		String costCenterAndBudget = CommonServices.getTestData("Cost Center");
		costCenterAndBudget.split(",");
		return costCenterAndBudget;

	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get short desc of guided item <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param testCase </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception </b> <br>
	 */
	public static String getShortDescriptionOfGuidedItem() throws Exception
	{
		return CommonServices.getTestData(IConstantsData.SHORT_DESC_FOR_GUIDED_ITEM) + System.currentTimeMillis() + getNonZeroRandomNumbers(3);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get display name of user <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param testCaseName </font><b><br>
	 * @return </b> <br>
	 * 
	 * @throws ActionBotException
	 */
	public static String getUserDisplayName(WebDriver driver, String testCaseName) throws ActionBotException
	{
		String displayName;
		String[] str;
		// to get original display name
		displayName = MainPageHeaderLevelTab.getUserDisplayName(driver, testCaseName);
		str = displayName.split(" ");
		displayName = str[1].trim();
		logger.info("Display name of user : " + displayName);
		return displayName;
	}

	public static String getBasketName() throws Exception
	{
		String basketName = CommonServices.getTestData(IConstantsData.BASKET_NAME) + "_" + System.currentTimeMillis();
		return basketName;

	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get decimal value of given price <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param price </font><b><br>
	 * @return </b> <br>
	 */
	public static String getDecimalPrice(String price)
	{
		String[] temp, str;
		String totalPrice = " ";
		if (price.contains(","))
		{
			temp = StringUtils.split(price, ",");
			for (String ele : temp)
			{
				totalPrice = totalPrice + ele;
			}
		}
		else
		{
			totalPrice = price;
		}

		if (totalPrice.contains("."))
		{
			str = StringUtils.split(totalPrice, ".");
			totalPrice = str[0].trim();
		}

		return totalPrice.trim();
	}

	public static CustomDate getTodaysDate()
	{
		CustomDate customDate = new CustomDate();
		Calendar today = Calendar.getInstance();
		customDate.setDay(today.get(Calendar.DATE));
		customDate.setMonth(today.get(Calendar.MONTH));
		customDate.setYear(today.get(Calendar.YEAR));
		customDate.setDate(today.get(Calendar.DATE) + "/" + (today.get(Calendar.MONTH) + 1) + "/" + today.get(Calendar.YEAR));

		return customDate;
	}

	public static CustomDate getDayAfterTodaysDate()
	{
		CustomDate customDate = new CustomDate();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		cal.add(Calendar.MONTH, 1);
		customDate.setDay(cal.get(Calendar.DATE));
		customDate.setMonth(cal.get(Calendar.MONTH));
		customDate.setYear(cal.get(Calendar.YEAR));
		customDate.setDate(cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH)) + "/" + cal.get(Calendar.YEAR));

		return customDate;
	}

	public static String getRandomInvoiceNo()
	{
		return getNonZeroRandomNumbers(2) + "_" + System.currentTimeMillis();
	}

	public static String getCatalogName() throws Exception
	{
		return getNonZeroRandomNumbers(2) + "_" + CommonServices.getTestData(IConstantsData.CATALOG_NAME) + "_" + System.currentTimeMillis();
	}

	public static String getCEformName() throws Exception
	{
		return getNonZeroRandomNumbers(2) + "_Test_CEform_" + System.currentTimeMillis();
	}

	public static String getSectionName() throws Exception
	{
		String sectionName = getNonZeroRandomNumbers(2) + "_Test_Section_" + System.currentTimeMillis();
		return sectionName;
	}

	public static String getFieldName() throws Exception
	{
		String fieldName = "Test_Field_" + System.currentTimeMillis();
		return fieldName;
	}

	public static String getPEformName() throws Exception
	{
		String pEformName = getNonZeroRandomNumbers(2) + "_Test_PEform_" + System.currentTimeMillis();
		return pEformName;
	}

	public static LinkedHashMap<String, String> setRequisitionDataInMap(Requisition requisition, LinkedHashMap<String, String> map)
	{
		if (requisition.getReqNo() != null)
		{
			map.put("Requisition No ", requisition.getReqNo());
		}
		if (requisition.getReqName() != null)
		{
			map.put("Requisition Name ", requisition.getReqName());
		}
		if (requisition.getItems() != null)
		{
			if (requisition.getItems().getCatelogItems() != null)
			{
				map.put("Header", "Catalog Items");
				for (CatelogItem catelogItem : requisition.getItems().getCatelogItems())
				{
					map.put("Item Name ", catelogItem.getItemName());
					map.put("Quantity ", Integer.toString(catelogItem.getQuantity()));
				}
			}
		}

		return map;

	}

	public static String getDecimalPriceAlongWithCurrency(String price)
	{
		String total[] = StringUtils.split(price, " ");
		String total_amount = total[1].trim();
		String[] temp, str;
		if (total_amount.contains(","))
		{
			temp = StringUtils.split(total_amount, ",");
			total_amount = "";
			for (String ele : temp)
			{
				total_amount = total_amount + ele;
			}
		}

		total_amount = Float.toString(Math.round(Float.parseFloat(total_amount)));
		if (total_amount.contains("."))
		{
			str = StringUtils.split(total_amount, ".");
			total_amount = str[0].trim();
		}

		return total_amount.trim();
	}

	public static CostCenterSplitInfo getProperCC_Budget_Project(CostCenterSplitInfo costCenterSplitInfo)
	{
		String[] temp = null;
		if (costCenterSplitInfo.getCostCenter() != null)
		{
			if (costCenterSplitInfo.getCostCenter().contains(":"))
			{
				temp = StringUtils.split(costCenterSplitInfo.getCostCenter(), ":");
				costCenterSplitInfo.setCostCenter(temp[0].trim());
			}
		}

		if (costCenterSplitInfo.getBudget() != null)
		{
			if (costCenterSplitInfo.getBudget().contains(":"))
			{
				temp = StringUtils.split(costCenterSplitInfo.getBudget(), ":");
				costCenterSplitInfo.setBudget(temp[0].trim());
			}
		}

		if (costCenterSplitInfo.getProject() != null)
		{
			if (costCenterSplitInfo.getProject().contains(":"))
			{
				temp = StringUtils.split(costCenterSplitInfo.getProject(), ":");
				costCenterSplitInfo.setProject(temp[1].trim());
			}
		}

		return costCenterSplitInfo;
	}

	public static String getBudgetName()
	{
		return "Budget_" + System.currentTimeMillis();
	}

	public static CostCenterSplitInfo getCostCenterInfoFromTestData() throws Exception
	{
		CostCenterSplitInfo centerSplitInfo = new CostCenterSplitInfo();

		String cc_budget_project = CommonServices.getTestData(IConstantsData.CC_PROJECT_BUDGET);

		String[] temp = StringUtils.split(cc_budget_project, ",");
		centerSplitInfo.setCostCenter(temp[0].trim());
		centerSplitInfo.setBudget(temp[1].trim());
		centerSplitInfo.setProject(temp[2].trim());

		return centerSplitInfo;

	}

	public static CostCenterSplitInfo getOtherCostCenterInfoFromTestData() throws Exception
	{
		CostCenterSplitInfo centerSplitInfo = new CostCenterSplitInfo();

		String cc_budget_project = CommonServices.getTestData(IConstantsData.other_CC_other_project_other_budget);

		String[] temp = StringUtils.split(cc_budget_project, ",");
		centerSplitInfo.setCostCenter(temp[0].trim());
		centerSplitInfo.setBudget(temp[1].trim());
		centerSplitInfo.setProject(temp[2].trim());

		return centerSplitInfo;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> To get non-zero random number <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param size
	 *        </font><b><br>
	 * @return integer</b> <br>
	 */
	public static Integer getRandomNumbersBetweenRange(int size, int minRange, int maxRange)
	{
		int number = ThreadLocalRandom.current().nextInt(minRange, maxRange);
		return number;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> To get non-zero random number <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param size
	 *        </font><b><br>
	 * @return integer</b> <br>
	 */
	public static Integer getRandomNumbersBetweenRange(int size, Double minRange, Double maxRange)
	{
		int number = Integer.parseInt(Helper.getRandomNumber(size));
		while ((number <= minRange) || (number >= maxRange))
		{
			number = Integer.parseInt(Helper.getRandomNumber(size));
		}
		return number;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b> To get non-zero random number <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * 
	 * @param size
	 *        </font><b><br>
	 * @return integer</b> <br>
	 */
	public static Integer getRandomNumbersBetweenRange(int size, float minRange, float maxRange)
	{
		int number = Integer.parseInt(Helper.getRandomNumber(size));
		while ((number <= minRange) || (number >= maxRange))
		{
			number = Integer.parseInt(Helper.getRandomNumber(size));
		}
		return number;
	}

	public static String getReportName()
	{
		return "Report" + System.currentTimeMillis();
	}

	public static String getFolderName()
	{
		return "Folder" + System.currentTimeMillis();
	}

	public static float calculatePercentageOf(float value, int percentage)
	{
		float percentageValue = 0;
		percentageValue = (value * percentage) / 100;
		return percentageValue;
	}

	public static String getRoundedDecimalPriceAlongWithCurrency(String price)
	{
		String total[] = StringUtils.split(price, " ");
		String total_amount = total[1].trim();
		String[] temp, str;
		if (total_amount.contains(","))
		{
			temp = StringUtils.split(total_amount, ",");
			total_amount = "";
			for (String ele : temp)
			{
				total_amount = total_amount + ele;
			}
		}

		// total_amount =
		// Float.toString(Math.round(Float.parseFloat(total_amount)));
		if (total_amount.contains("."))
		{
			str = StringUtils.split(total_amount, ".");
			total_amount = str[0].trim();
		}

		return total_amount.trim();
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get decimal value of given price <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param price </font><b><br>
	 * @return </b> <br>
	 */
	public static String getRoundedDecimalPrice(String price)
	{
		String[] temp, str;
		String totalPrice = " ";
		if (price.contains(","))
		{
			temp = StringUtils.split(price, ",");
			for (String ele : temp)
			{
				totalPrice = totalPrice + ele;
			}
		}
		else
		{
			totalPrice = price;
		}
		totalPrice = Float.toString(Math.round(Float.parseFloat(totalPrice)));
		if (totalPrice.contains("."))
		{
			str = StringUtils.split(totalPrice, ".");
			totalPrice = str[0].trim();
		}

		return totalPrice.trim();
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To calculate price based on quantity and
	 * unit price <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param unitPrice </font><b><br>
	 * @param quantity </font><b><br>
	 * @return </b> <br>
	 */
	public static double calculatePrice(double unitPrice, int quantity)
	{
		double totalPrice = 0;
		totalPrice = unitPrice * quantity;
		return totalPrice;
	}

	public static void downloadFile() throws Exception
	{
		Thread.sleep(3000);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get proper GL Account <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param glAccount </font><b><br>
	 * @return </b> <br>
	 */
	public static String getProperGLAccount(String glAccount)
	{
		String[] temp = null;
		String properGLAccount = null;
		if(glAccount!=null){
			if (glAccount.contains(":"))
			{
				temp = StringUtils.split(glAccount, ":");
				properGLAccount = temp[1].trim();
			}
		}
		return properGLAccount;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Get list of cc names from testdata <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception </b> <br>
	 */
	public static List<String> getListOFCCNamesForBU() throws Exception
	{
		List<String> listOfCCNames = new ArrayList<>();
		String ccNames = CommonServices.getTestData(IConstantsData.List_Of_Cost_Center_For_BU);
		String[] temp = StringUtils.split(ccNames, ",");
		for (String str : temp)
		{
			listOfCCNames.add(str);
		}
		return listOfCCNames;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get proper Cost Center <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param glAccount </font><b><br>
	 * @return </b> <br>
	 */
	public static String getProperCostCenter(String cc)
	{
		String[] temp = StringUtils.split(cc, ":");
		return temp[0].trim();
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>Get list of cc names from testdata <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception </b> <br>
	 */
	public static List<String> getListOFProjectNamesForBU() throws Exception
	{
		List<String> listOfCCNames = new ArrayList<>();
		String ccNames = CommonServices.getTestData(IConstantsData.List_Of_Projects_For_BU);
		String[] temp = StringUtils.split(ccNames, ",");
		for (String str : temp)
		{
			listOfCCNames.add(str);
		}
		return listOfCCNames;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get proper Cost Center <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param glAccount </font><b><br>
	 * @return </b> <br>
	 */
	public static String getProperProject(String project)
	{
		if (project.contains(":"))
		{
			String[] temp = StringUtils.split(project, ":");
			return temp[1].trim();
		}
		else
		{
			return null;
		}
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get date after no of days of todays
	 * date. No of days to be provided by user <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param noOfDays </font><b><br>
	 * @return </b> <br>
	 */
	public static CustomDate getDateAfterNoOfDaysOfTodays(int noOfDays)
	{
		CustomDate customDate = new CustomDate();
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, noOfDays);
		customDate.setDay(cal.get(Calendar.DATE));
		customDate.setMonth(cal.get(Calendar.MONTH));
		customDate.setYear(cal.get(Calendar.YEAR));
		customDate.setDate(cal.get(Calendar.DATE) + "/" + (cal.get(Calendar.MONTH) + 1) + "/" + cal.get(Calendar.YEAR));

		return customDate;
	}

	/**
	 * <b>Author: ankita.sawant </b> <b><br>
	 * <font color="blue">Method :</b>To get date in proper format for email
	 * testing <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param date </font><b><br>
	 * @return </b> <br>
	 */
	public static String getProperDateForEmailTesting(String date)
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");

		Date date2 = null;
		try
		{
			date2 = dateFormat2.parse(date);
			return (dateFormat.format(date2)).toString().toUpperCase();
		}
		catch (ParseException e)
		{
			return date;
		}
	}

	/**
	 * <b>Author: kunal.ashar </b> <b><br>
	 * <font color="blue">Method :</b> To get size of a number <br>
	 */
	public static Integer getSizeOfNumber(int number)
	{
		int size = (int) (Math.log10(number) + 1);
		return size;
	}

	public static boolean areAllStringsUnique(List<String> list)
	{
		Set<String> set = new HashSet<>();
		for (String item : list)
		{
			set.add(item);
		}
		return (list.size() == set.size());
	}

	public static String getRandomStringWithSize(int size)
	{
		char[] charSequence = new char[size];

		for (int i = 0; i < size; i++)

		{

			int randomInt = 97 + (int) (Math.random() * ((122 - 97) + 1));

			charSequence[i] = (char) randomInt;

		}

		String randomStr = new String(charSequence);
		return randomStr;

	}

	public static String getRandomStringWithSpecialCharacters()
	{
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789~`!@#$%^&*()-_=+[{]}\\|;:\'\",<.>/?";
		String randomStr = RandomStringUtils.random(15, characters);
		return randomStr;

	}
}
