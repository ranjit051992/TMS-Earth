package com.zycus.automation.utilities.utilitieshelpers;

import java.util.List;
import java.util.Stack;
import java.util.Vector;

import org.apache.log4j.Logger;

import com.zycus.automation.eproc.testdata.IConstantsData;

/**
 * @author omkar.jagdale
 * @link reference : https://github.com/grahamking/darkcoding-credit-card/blob/master/RandomCreditCardNumberGenerator.java
 */
public class RandomCreditCardNumberGenerator
{
	static Logger					logger					= Logger.getLogger(RandomCreditCardNumberGenerator.class);

	public static final String[]	VISA_PREFIX_LIST		= new String[] { "4539", "4556", "4916", "4532", "4929", "40240071", "4485", "4716", "4" };

	public static final String[]	MASTERCARD_PREFIX_LIST	= new String[] { "51", "52", "53", "54", "55", "2221", "2222", "2223", "2224", "2225", "2226", "2227", "2228", "2229",
			"223", "224", "225", "226", "227", "228", "229", "23", "24", "25", "26", "270", "271", "2720" };

	public static final String[]	AMEX_PREFIX_LIST		= new String[] { "34", "37" };

	public static final String[]	DISCOVER_PREFIX_LIST	= new String[] { "6011" };

	public static final String[]	DINERS_PREFIX_LIST		= new String[] { "300", "301", "302", "303", "36", "38" };

	public static final String[]	ENROUTE_PREFIX_LIST		= new String[] { "2014", "2149" };

	public static final String[]	JCB_PREFIX_LIST			= new String[] { "35" };

	public static final String[]	VOYAGER_PREFIX_LIST		= new String[] { "8699" };

	public static String[] getCreditCardNumber(int howMany, String pCardType)
	{

		String[] creditcardnumbers = null;
		creditcardnumbers = generateCardNumbersByType(howMany, pCardType);
		for (int i = 0; i < creditcardnumbers.length; i++)
		{
			logger.info(creditcardnumbers[i] + ":" + (isValidCreditCardNumber(creditcardnumbers[i]) ? "valid" : "invalid"));
		}
		return creditcardnumbers;
	}

	public static String[] generateCardNumbersByType(int howMany, String pCardType)
	{
		try{
		logger.info("generating " + howMany + "credit card no for " + pCardType);
		if (pCardType.equalsIgnoreCase(IConstantsData.PCARD_TYPE_MASTER_CARD))
			return credit_card_number(MASTERCARD_PREFIX_LIST, 16, howMany);
		if (pCardType.equalsIgnoreCase(IConstantsData.PCARD_TYPE_VISA))
			return credit_card_number(VISA_PREFIX_LIST, 16, howMany);
		if (pCardType.equalsIgnoreCase(IConstantsData.PCARD_TYPE_AMEX))
			return credit_card_number(AMEX_PREFIX_LIST, 16, howMany);
		}
		catch(Exception e){
			System.out.println(e);
			e.printStackTrace();
		}
		return null;
	}

	public static String[] credit_card_number(String[] prefixList, int length, int howMany)
	{

		Stack<String> result = new Stack<String>();
		for (int i = 0; i < howMany; i++)
		{
			int randomArrayIndex = (int) Math.floor(Math.random() * prefixList.length);
			logger.info("Random prefix index chosed: "+randomArrayIndex);
			String ccnumber = prefixList[randomArrayIndex];
			logger.info("Random CreditCard prefix chosed: "+ccnumber);
			result.push(completed_number(ccnumber, length));
		}

		return result.toArray(new String[result.size()]);
	}

	public static boolean isValidCreditCardNumber(String creditCardNumber)
	{
		boolean isValid = false;

		try
		{
			String reversedNumber = new StringBuffer(creditCardNumber).reverse().toString();
			int mod10Count = 0;
			for (int i = 0; i < reversedNumber.length(); i++)
			{
				int augend = Integer.parseInt(String.valueOf(reversedNumber.charAt(i)));
				if (((i + 1) % 2) == 0)
				{
					String productString = String.valueOf(augend * 2);
					augend = 0;
					for (int j = 0; j < productString.length(); j++)
					{
						augend += Integer.parseInt(String.valueOf(productString.charAt(j)));
					}
				}

				mod10Count += augend;
			}

			if ((mod10Count % 10) == 0)
			{
				isValid = true;
			}
		}
		catch (NumberFormatException e)
		{
		}

		return isValid;
	}

	static String strrev(String str)
	{
		if (str == null)
			return "";
		String revstr = "";
		for (int i = str.length() - 1; i >= 0; i--)
		{
			revstr += str.charAt(i);
		}

		return revstr;
	}

	/*
	 * 'prefix' is the start of the CC number as a string, any number of digits.
	 * 'length' is the length of the CC number to generate. Typically 13 or 16
	 */
	static String completed_number(String prefix, int length)
	{

		String ccnumber = prefix;

		// generate digits

		while (ccnumber.length() < (length - 1))
		{
			ccnumber += new Double(Math.floor(Math.random() * 10)).intValue();
		}

		logger.info("Credit card no generated after genrating digits: "+ccnumber);
		// reverse number and convert to int

		String reversedCCnumberString = strrev(ccnumber);
		
		logger.info("Reversed Credit card String: "+reversedCCnumberString);

		List<Integer> reversedCCnumberList = new Vector<Integer>();
		for (int i = 0; i < reversedCCnumberString.length(); i++)
		{
			reversedCCnumberList.add(new Integer(String.valueOf(reversedCCnumberString.charAt(i))));
		}

		logger.info("Reversed CC number List : "+reversedCCnumberList);
		// calculate sum

		int sum = 0;
		int pos = 0;

		Integer[] reversedCCnumber = reversedCCnumberList.toArray(new Integer[reversedCCnumberList.size()]);
		while (pos < length - 1)
		{

			int odd = reversedCCnumber[pos] * 2;
			if (odd > 9)
			{
				odd -= 9;
			}

			sum += odd;

			if (pos != (length - 2))
			{
				sum += reversedCCnumber[pos + 1];
			}
			pos += 2;
		}

		logger.info("Sum: "+sum);
		// calculate check digit

		int checkdigit = new Double(((Math.floor(sum / 10) + 1) * 10 - sum) % 10).intValue();
		logger.info("Check digit : "+checkdigit);
		
		ccnumber += checkdigit;
		logger.info("Final Credit card no genrated: "+ccnumber);

		return ccnumber;

	}

}
