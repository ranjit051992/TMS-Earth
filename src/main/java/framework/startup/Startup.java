package framework.startup;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;

import framework.frameworkUtilies.GlobalVariable;
import framework.frameworkUtilies.PropertiesConfigurator;
import framework.frameworkUtilies.testResult.ReportingService;
import framework.frameworkUtilies.testResult.TestReportingBO;
import framework.utilities.commonServices.CommonServices;
import framework.utilities.commonServices.JSONParsingClass;
import framework.utilities.screenshot.Screenshot;
import framework.utilities.userListing.User;
import framework.utilities.userListing.userListingUtility;
import framework.utilities.webElementWrapper.WebElementWrapper;

public class Startup
{

	public static Logger						logger					= Logger.getLogger(Startup.class);
	public static Map<String, TestReportingBO>	testMethodTestCaseMap	= new HashMap<String, TestReportingBO>();
	public static Map<String, TestReportingBO>	executionMethods		= new HashMap<String, TestReportingBO>();
	public static Map<String, String>			testDataMap				= new HashMap<String, String>();
	private static String						log4jConfPath			= "./Resources/log4j.properties";
	public static List<User>					usersList				= new ArrayList<User>();
	public static List<String>					remainingMethods		= new ArrayList<String>();
	public static Map<String, String>			configMap				= new HashMap<String, String>();

	public static void main(String[] args) throws Exception
	{

		Screenshot.removeDir("./output");

		PropertyConfigurator.configure(log4jConfPath);

		createconfigMap();

		userListingUtility.collectUserData();

		ReportingService.collectTestCaseData();

		ReportingService.testCaseMapping();

		JSONParsingClass.getJsonData(GlobalVariable.SETUP, GlobalVariable.TENANT);

		WebElementWrapper.UiElements = WebElementWrapper.getUIElements();

		framework.utilities.helper_package.GetData.getTestData();

		if (executionMethods.size() != 0)
		{

			CommonServices.screenShotFileOperations(GlobalVariable.SUITE_TYPE);



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
}
