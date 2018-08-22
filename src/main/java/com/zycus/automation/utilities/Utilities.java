package com.zycus.automation.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.constants.IConstants;

public class Utilities
{
	static Logger logger = Logger.getLogger(Utilities.class);

	static
	{
		PropertyConfigurator.configure(IConstants.LOG_4J_APPENDDER);
	}

	public static boolean driverStatus(WebDriver driver, String methodName)
	{
		boolean driverStat = false;
		try
		{
			driver.getTitle();

			if (driver != null)
			{
				driverStat = true;
			}
		}
		catch (SessionNotCreatedException e)
		{
			logger.error("WebDriver Session Not Avaliable To Proceed for ".toUpperCase() + methodName + " : " + e, e);
			driverStat = false;
		}
		catch (Exception a)
		{
			logger.error("WebDriver is Not Avaliable To Proceed for ".toUpperCase() + methodName + " : " + a, a);
			driverStat = false;
		}
		return driverStat;
	}

	public static String appendUnderScore(String string)
	{
		String str = null;
		try
		{
			if (string.contains(" "))
			{
				String[] str1 = StringUtils.split(string, " ");
				for (String str2 : str1)
				{
					if (str == null)
					{
						str = str2;
					}
					else if (str != null)
					{
						str = str.concat("_").concat(str2);
					}
				}
				if (str == null)
				{
					str = string;
				}
			}
			else
			{
				str = "" + string;
			}
		}
		catch (Exception e)
		{
			str = "" + string;
		}
		return str.toUpperCase();
	}

	public static String getSystemCurrentTime()
	{
		return "" + System.nanoTime();
	}

	public static String getDate()
	{
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date date = new Date();
		return simpleDateFormat.format(date);
	}

	public static String formatCurrency(String currency)
	{
		String currencyValue = "";
		if (currency.contains(","))
		{
			String[] formatedCurrency = StringUtils.split(currency, ",");
			currencyValue += formatedCurrency[0];

			for (String element : formatedCurrency)
			{
				currencyValue += element;
			}
		}
		else
		{
			currencyValue = currency;
		}
		return currencyValue;
	}

}
