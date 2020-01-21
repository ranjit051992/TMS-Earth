package framework.startup;

import com.thoughtworks.gauge.datastore.DataStoreFactory;
import framework.utilities.GetData;
import framework.utilities.GlobalVariable;
import framework.utilities.PropertiesConfigurator;
import framework.reporting.ReportingService;
import framework.reporting.TestReportingBO;
import framework.utilities.commonServices.CommonServices;
import framework.utilities.commonServices.JSONParsingClass;
import framework.utilities.screenshot.Screenshot;
import eProc.productUtilities.userListing.UserBO;
import eProc.productUtilities.userListing.UserListing;
//import framework.utilities.webElementWrapper.WebElementWrapper;
import framework.utilities.webElementWrapper.WebElementWrapper;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import java.text.SimpleDateFormat;
import java.util.*;

public class Startup
{

	public static Logger						logger					= Logger.getLogger(Startup.class);
	public static Map<String, TestReportingBO>	testMethodTestCaseMap	= new HashMap<String, TestReportingBO>();
	public static Map<String, TestReportingBO>	executionMethods		= new HashMap<String, TestReportingBO>();
	public static Map<String, String>			testDataMap				= new HashMap<String, String>();
	private static String						log4jConfPath			= "./Resources/log4j.properties";
	public static List<UserBO>					usersList				= new ArrayList<UserBO>();
	public static List<String>					remainingMethods		= new ArrayList<String>();
	public static Map<String, String>			configMap				= new HashMap<String, String>();

	public static void main(String[] args) throws Exception
	{

		Screenshot.removeDir("./output");

		PropertyConfigurator.configure(log4jConfPath);

		createconfigMap();

		UserListing.collectUserData();

		ReportingService.collectTestCaseData();


		ReportingService.testCaseMapping();

		JSONParsingClass.getJsonData(GlobalVariable.SETUP, GlobalVariable.TENANT);

		WebElementWrapper.UiElements = WebElementWrapper.getUIElements();

		GetData.getTestData();

		if (executionMethods.size() != 0)
		{

			Screenshot.screenShotFileOperations(GlobalVariable.SUITE_TYPE);



			SimpleDateFormat dateFormat = new SimpleDateFormat("E dd.MM.yyyy 'at' hh:mm:ss a zzz");
			Date date = new Date();
			logger.info("************************ Start Time : " + dateFormat.format(date) + " ************************");


			ReportingService.reportGenration();
		}
		else
		{
			logger.info("ERROR : No Testcase marked for execution. Please check TestCases.xlsx or config.properties");
		}
	}

	public static void createconfigMap() throws Exception
	{
		PropertiesConfigurator.loadProperties();
		PropertiesConfigurator.loadSystemEnvVariable();
	}

	public static void startup() throws Exception
	{
		try {
			Screenshot.removeDir("./output");

			PropertyConfigurator.configure(log4jConfPath);

			createconfigMap();

			UserListing.collectUserData();

			ReportingService.collectTestCaseData();

			ReportingService.testCaseMapping();

			JSONParsingClass.getJsonData(GlobalVariable.SETUP, GlobalVariable.TENANT);

			WebElementWrapper.UiElements = WebElementWrapper.getUIElements();

			GetData.getTestData();

			if (executionMethods.size() != 0)
			{

				Screenshot.screenShotFileOperations(GlobalVariable.SUITE_TYPE);



				SimpleDateFormat dateFormat = new SimpleDateFormat("E dd.MM.yyyy 'at' hh:mm:ss a zzz");
				Date date = new Date();
				logger.info("************************ Start Time : " + dateFormat.format(date) + " ************************");


				ReportingService.reportGenration();
			}
			else
			{
				logger.info("ERROR : No Testcase marked for execution. Please check TestCases.xlsx or config.properties");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
}
