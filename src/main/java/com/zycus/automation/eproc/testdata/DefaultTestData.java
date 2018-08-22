package com.zycus.automation.eproc.testdata;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zycus.automation.constants.IConstants;

public class DefaultTestData
{

	static Logger logger = Logger.getLogger(DefaultTestData.class);

	static
	{
		PropertyConfigurator.configure(IConstants.LOG_4J_APPENDDER);
	}

	protected enum DefaultData {
		CATALOG_ITEM("catlogItem");

		String enumValue;

		private DefaultData(String args)
		{
			this.enumValue = args;
		}

		public String getDefaultData()
		{
			return this.enumValue;
		}
	}

	protected static Map<String, Object> readDefaultDataFor(DefaultData args)
	{
		try
		{
			JSONParser jsonParser = new JSONParser();
			Object object = jsonParser.parse(new FileReader(IConstants.DEFAULT_TEST_DATA + "defaultData.json"));
			JSONObject jsonObject = (JSONObject) object;
			Object dataObject = jsonObject.get(args.getDefaultData());
			return new Gson().fromJson(dataObject.toString(), new TypeToken<HashMap<String, Object>>() {
			}.getType());
		}
		catch (FileNotFoundException e)
		{
			logger.error("ERROR IN METHOD readDefaultDataFor " + e.toString(), e);
		}
		catch (IOException e)
		{
			logger.error("ERROR IN METHOD readDefaultDataFor " + e.toString(), e);
		}
		catch (ParseException e)
		{
			logger.error("ERROR IN METHOD readDefaultDataFor " + e.toString(), e);
		}
		catch (Exception e)
		{
			logger.error("ERROR IN METHOD readDefaultDataFor " + e.toString(), e);
		}
		return null;
	}

	/**************************************************************************************************************************************************/
	/**************************************************************************************************************************************************/
	/**************************************************************************************************************************************************/
	/**************************************************************************************************************************************************/
	/**************************************************************************************************************************************************/
	/**************************************************************************************************************************************************/
	/**************************************************************
	 * JUNIT TESTCASE FOR METHODS
	 **********************************************************/

	@Test
	public void testReadDefaultData()
	{

		Map<String, Object> testMap = readDefaultDataFor(DefaultData.CATALOG_ITEM);
		logger.info(testMap);

	}
}
