package com.zycus.framework.framework_version_2_4.startup;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import org.apache.commons.exec.util.StringUtils;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Rule;
import org.openqa.selenium.WebDriver;
import org.reflections.Reflections;
import org.reflections.scanners.ResourcesScanner;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import org.reflections.util.FilterBuilder;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlDefine;
import org.testng.xml.XmlDependencies;
import org.testng.xml.XmlGroups;
import org.testng.xml.XmlInclude;
import org.testng.xml.XmlRun;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;

import com.zycus.automation.constants.IConstants;
import com.zycus.automation.eproc.excelDatabaseReader.ExcelReader;
import com.zycus.automation.eproc.excelDatabaseReader.SettingMapReader;
import com.zycus.automation.eproc.reader.PropertyReader;
import com.zycus.automation.eproc.testdata.IConstantsData;
import com.zycus.automation.eproc.uielements.UIFactory;
import com.zycus.automation.integration.testopia.TestopiaIntegration;
import com.zycus.automation.utilities.reports.CreateEmailReport;
import com.zycus.automation.utilities.reports.CreateMailContentReport;
import com.zycus.automation.utilities.reports.SanityReport1;
import com.zycus.framework.framework_version_2_4.bo.BrowserEnvironment;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.bo.TestSuiteResult;
import com.zycus.framework.framework_version_2_4.constants.FrameworkConstants;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;
import com.zycus.framework.framework_version_2_4.framework.TestDataProvider;
import com.zycus.framework.framework_version_2_4.framework.TestNGReportXMLUtil;
import com.zycus.framework.framework_version_2_4.framework.config.SetupChecker;
import com.zycus.framework.framework_version_2_4.framework_exception.TestCaseException;
import com.zycus.framework.framework_version_2_4.listener.CustomTestListener;

/**
 * @author aryasindhu.sahu
 * 
 */
public class Startup
{

	static Logger								logger					= Logger.getLogger(Startup.class);

	public static Map<String, TestCase>			testMethodTestCaseMap	= new HashMap<String, TestCase>();
	private static String						fileName				= ConfigProperty.getConfig("Input_Files_Location") + ConfigProperty.getConfig("Test_Case_File");
	public static List<BrowserEnvironment>		browserEnvironments		= new ArrayList<BrowserEnvironment>();

	public static Map<WebDriver, TestCase>		driverTestCaseMap		= new HashMap<WebDriver, TestCase>();
	public static List<TestSuiteResult>			result					= null;
	public static LinkedList<String>			browserNames			= new LinkedList<String>();

	// TODO : New Code
	public static Map<String, List<TestCase>>	moduleTestCaseMap		= new HashMap<String, List<TestCase>>();
	public static List<String>					failedModuleNames		= new ArrayList<String>();

	public static int							totalCase				= 0;

	@SuppressWarnings("rawtypes")
	public static void main(String[] args)
	{
		String suiteName = "_TestSuite";
		String query = null;
		int threadCount = Integer.parseInt(ConfigProperty.getConfig("Thread_Count"));
		String testNGOutputDirectory = ConfigProperty.getConfig("testNG_Output_Directory");
		try
		{
			// Check Configurations : Proceed Testrun only if all Configurations
			// are OK
			checkConfiguration();

			// Prepare browser environments from Config
			prepareBrowserEnvironments();

			// Prepare the Map of testMethod -> TestCase
			prepareTestMethodTestCaseMap();

			// changes done by ankita
			// prepare testdata map for eproc
			ExcelReader.testDataMap = ExcelReader.getTestData();

			//Prepsre the Map for settings-> eproc setting Map
			SettingMapReader.settingMap = SettingMapReader.getSettingMap();

			// prepare testdata map for einvoice
			com.zycus.eInvoice.automation.scripts.excelDatabaseReader.ExcelReader.testDataMap = com.zycus.eInvoice.automation.scripts.excelDatabaseReader.ExcelReader.getTestData();

			// changes made by ankita
			// load all peroperties
			PropertyReader.loadProperties();

			// load all UI excels of eproc
			UIFactory.UI_MAP = UIFactory.loadMap(IConstants.UI_eProc);


			// load all UI excels of einvoice
			com.zycus.eInvoice.automation.scripts.uielements.UIFactory.UI_MAP = com.zycus.eInvoice.automation.scripts.uielements.UIFactory.loadMap(IConstants.UI_eInvoice);

			// load all UI excels of ZSN
			com.zycus.zsn.automation.uielements.UIFactory.UI_MAP = com.zycus.zsn.automation.uielements.UIFactory.loadMap(IConstants.UI_ZSN);

			// Get All Classes in the testCase Package directory
			List<ClassLoader> classLoadersList = new LinkedList<ClassLoader>();
			classLoadersList.add(ClasspathHelper.contextClassLoader());
			classLoadersList.add(ClasspathHelper.staticClassLoader());

			Reflections reflections = new Reflections(new ConfigurationBuilder().setScanners(new SubTypesScanner(false), new ResourcesScanner())
				.setUrls(ClasspathHelper.forClassLoader(classLoadersList.toArray(new ClassLoader[0])))
				.filterInputsBy(new FilterBuilder().include(FilterBuilder.prefix(ConfigProperty.getConfig("TestCase_Package")))));

			Set<Class<? extends TestDataProvider>> allClasses = reflections.getSubTypesOf(TestDataProvider.class);

			// Prepare include methods list for a classs
			Map<String, List<XmlInclude>> includeMethodsMap = new HashMap<String, List<XmlInclude>>();
			for (Class clazz : allClasses)
			{
				List<XmlInclude> includeMethods = new ArrayList<XmlInclude>();
				Method[] methods = clazz.getDeclaredMethods();
				Set<String> allMethods = testMethodTestCaseMap.keySet();
				for (Method method : methods)
				{
					for (String tempMethod : allMethods)
					{
						String actualMethodName = tempMethod.substring(0, tempMethod.indexOf("*"));
						// if method is found in the method->testcase map then
						// add this method to include list
						if (actualMethodName.equalsIgnoreCase(method.getName()))
						{
							includeMethods.add(new XmlInclude(method.getName()));
							break;
						}
					}
				}
				// Add the class -> include methods to map
				if (includeMethods.size() != 0)
				{
					includeMethodsMap.put(clazz.getName(), includeMethods);
				}
			}

			logger.info("testMethodTestCaseMap : " + testMethodTestCaseMap.toString());
			logger.info("includeMethodsMap : " + includeMethodsMap.toString());

			// TestNG code to start testCase Execution
			TestNG testNG = new TestNG();
			List<XmlSuite> suites = new ArrayList<XmlSuite>();

			for (BrowserEnvironment environment : browserEnvironments)
			{
				XmlSuite suite = new XmlSuite();
				suite.setName(environment.getBrowser() + "-" + environment.getVersion() + "-" + suiteName);
				suite.setParallel(XmlSuite.PARALLEL_METHODS);
				suite.setThreadCount(threadCount);

				for (String className : includeMethodsMap.keySet())
				{
					XmlTest test = new XmlTest(suite);
					List<XmlClass> xmlClasses = new ArrayList<XmlClass>();
					List<XmlInclude> methodNames = includeMethodsMap.get(className);
					XmlClass xmlClass = new XmlClass(Class.forName(className));
					xmlClass.setIncludedMethods(methodNames);
					xmlClasses.add(xmlClass);
					test.setName(xmlClass.getName().substring(1 + xmlClass.getName().lastIndexOf(".")));
					test.setXmlClasses(xmlClasses);
				}
				suites.add(suite);
			}

			testNG.setXmlSuites(suites);
			testNG.setOutputDirectory(testNGOutputDirectory);
			List<Class> listenerClasses = new ArrayList<Class>();
			listenerClasses.add(CustomTestListener.class);
			listenerClasses.add(org.uncommons.reportng.HTMLReporter.class);
			listenerClasses.add(org.uncommons.reportng.JUnitXMLReporter.class);
			testNG.setListenerClasses(listenerClasses);
			SimpleDateFormat dateFormat = new SimpleDateFormat("E dd.MM.yyyy 'at' hh:mm:ss a zzz");
			Date date = new Date();
			logger.info("************************ Start Time : " + dateFormat.format(date) + " ************************");

			// checking setups before running tests
			checkSetup();

			testNG.run();

			// Remove all duplicate methods from the XML file.
			TestNGReportXMLUtil.removeDuplicateMethods();

			// CREATE sanity report
			// SanityReport.createSanityReoprt();
			SanityReport1.createSanityReoprt();

			// update automation build health status report
			if (ConfigProperty.getConfig("updateAutomationBuildHealthStatusReport").equalsIgnoreCase("Yes")
				|| ConfigProperty.getConfig("updateAutomationBuildHealthStatusReport").equalsIgnoreCase("Y"))
			{
				ExcelReader.createAutomationBuildHealthStatusReport();
			}

			// create email-testing report
			CreateEmailReport.createEmailReoprt();

			// create mail content report
			CreateMailContentReport.createMailContentReoprt();

			// write summary of report in excel
			ExcelReader.writeSummaryReportResult();

			Date endDate = new Date();
			logger.info("************************ End Time : " + dateFormat.format(endDate) + " ************************");

			int hoursDiff = 0, minDiff = 0, secDiff = 0;

			if (endDate.getHours() - date.getHours() == 1)
			{
				hoursDiff = 0;
				minDiff = (60 - date.getMinutes()) + endDate.getMinutes();
			}
			else
			{
				hoursDiff = endDate.getHours() - date.getHours();
				minDiff = endDate.getMinutes() - date.getMinutes();
			}
			secDiff = endDate.getSeconds() - date.getSeconds();

			logger.info("************************ Total Time Taken : " + hoursDiff + ":" + minDiff + ":" + secDiff + " ************************");

			if (ConfigProperty.getConfig("RUN_TESTOPIA").equalsIgnoreCase("true") || ConfigProperty.getConfig("RUN_TESTOPIA").equalsIgnoreCase("yes"))
			{
				TestopiaIntegration.markedTestCaseExecution();
			}

			logger.info("Test Suite Result : " + result);
		}
		catch (IOException e)
		{
			logger.error("IO Operation failed while trying to access the excel file :", e);
		}
		catch (ClassNotFoundException e)
		{
			logger.error("Test Class not found :", e);
		}
		catch (TestCaseException e)
		{
			logger.error("Error occured while trying to create Test Suites.", e);
		}
		catch (Exception e)
		{
			logger.error("Error occured while trying to run Test cases.", e);
		}
	}

	/**
	 * Prepares a Map of TestMethod -> TestCase. When running a TestMethod its
	 * corresponding TestCase Object is fetched from this Map to get other
	 * information about the Test.
	 * 
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private static void prepareTestMethodTestCaseMap() throws IOException, FileNotFoundException
	{
		String testDataSeparator = ConfigProperty.getConfig("Test_Data_Separtor");
		TestCase testCase = new TestCase();
		List<String> allQueries = new LinkedList<String>();
		String suiteType = null;
		String query = null;
		boolean flag = false;

		// Added by Ankita
		String components = ConfigProperty.getConfig("Component");
		String author = ConfigProperty.getConfig("Author");
		List<String> componentList = new ArrayList<String>();
		ResultSet rs = null;
		if (components.contains(","))
		{
			StringTokenizer tokenizer = new StringTokenizer(components, ",");
			while (tokenizer.hasMoreElements())
			{
				componentList.add(tokenizer.nextToken());
			}
		}
		else
		{
			componentList.add(components);
		}

		//to check TestCase_Type
		if (ConfigProperty.getConfig("SUITE_TYPE").trim().equalsIgnoreCase("sanity"))
		{
			logger.info("RUNNING SANITY TESTCASES");
			suiteType = IConstants.SANITY;
		}
		else if (ConfigProperty.getConfig("SUITE_TYPE").trim().equalsIgnoreCase("regression"))
		{
			logger.info("RUNNING REGRESSION TESTCASEs");
			suiteType = IConstants.REGRESSION;
		}
		else
		{
			logger.info("SUITE_TYPE is wrong");
		}

		//for local execution of selected cases
		FileInputStream fileInputStream = new FileInputStream(new File(fileName));
		HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
		HSSFSheet sheet = workbook.getSheetAt(0);

		//to find all cases to be executed from local file
		totalCase = sheet.getLastRowNum();
		if (totalCase > 0)
		{
			Iterator<Row> rowIterator = sheet.iterator();
			rowIterator.next();

			while (rowIterator.hasNext())
			{
				Row row = rowIterator.next();
				query = "select * from TestCase_eProc where Product_Name='eProc' and TestCase_Type='" + suiteType + "' and TestCase_Name='" + row.getCell(0) + "'";
				allQueries.add(query);
			}
		}
		else
		{
			if (components.equalsIgnoreCase(IConstantsData.ALL) && author.equalsIgnoreCase(IConstantsData.ALL))
			{
				//fetch all cases from db
				query = "select * from TestCase_eProc where Product_Name='eProc' and TestCase_Type='" + suiteType + "'";
				allQueries.add(query);
			}
			else if (author.equalsIgnoreCase(IConstantsData.ALL))
			{
				//fetch component wise cases from db
				query = "select * from TestCase_eProc where Product_Name='eProc' and TestCase_Type='" + suiteType + "' and TestCase_Module='" + components + "'";
				allQueries.add(query);
			}
			else
			{
				//fetch component wise cases from db for selected author 
				query = "select * from TestCase_eProc where Product_Name='eProc' and TestCase_Type='" + suiteType + "' and TestCase_Module='" + components
					+ "' and TestCase_Author='" + author + "'";
				allQueries.add(query);
			}

		}

		//DB connection
		try
		{
			/*
			 * //Connection variables load values from DB
			 * String query = "select * from TestCase_eProc where Product_Name='eProc' and TestCase_Type='" + suiteType + "'";
			 */
			logger.info("Obtaining DB Connection for TestCases");

			//to load jdbc class
			Class.forName("com.mysql.jdbc.Driver");

			//to obtain db connection
			Connection con = DriverManager.getConnection(ConfigProperty.getConfig("DB_URL"), ConfigProperty.getConfig("DB_Username"), ConfigProperty.getConfig("DB_Password"));

			logger.info("Successfully connected to DB for TestCases");

			//to execute statement on db
			Statement stmt = con.createStatement();

			//storing result of executed query
			if (allQueries.size() > 0)
			{
				for (String s : allQueries)
				{
					rs = stmt.executeQuery(s);
					prepareMap(rs);
				}

			}

			//closing DB connection
			con.close();
		}
		catch (ClassNotFoundException e1)
		{
			logger.info("Exception received while registering jdbc driver. Exception: " + e1);
		}
		catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Check if the testMethodTestCaseMap does not contain anything, then show error message.
		if (testMethodTestCaseMap.size() == 0)
		{
			logger.error("NO TESTCASES MARKED \"Y\" TO BE RUN. STOPPING TEST EXECUTION.");
			System.exit(0);
		}
		// to get total number of cases to be excetued
		else
		{
			logger.info("Total No of Cases to be executed : " + testMethodTestCaseMap.size() + " for Component: " + components);
		}
	}

	/**
	 * Prepares the list of testcases/testmap
	 * @throws TestCaseException
	 */
	private static void prepareMap(ResultSet rs) throws SQLException
	{
		boolean flag = false;

		// Added by Ankita
		String components = ConfigProperty.getConfig("Component");
		List<String> componentList = new ArrayList<String>();
		if (components.contains(","))
		{
			StringTokenizer tokenizer = new StringTokenizer(components, ",");
			while (tokenizer.hasMoreElements())
			{
				componentList.add(tokenizer.nextToken());
			}
		}
		else
		{
			componentList.add(components);
		}

		while (rs.next())
		{
			String testMethodName = rs.getString(3);
			String testDescription = rs.getString(4);
			String moduleName = rs.getString(5);
			String executionStatus = rs.getString(6);
			String jiraId = rs.getString(8);
			String isTempTC = rs.getString(10);
			String isCOATC = rs.getString(11);

			if (executionStatus != null)
			{
				if ("Y".equalsIgnoreCase(executionStatus))
				{
					for (String component : componentList)
					{
						if (component.equalsIgnoreCase(moduleName))
						{
							flag = true;
							break;
						}
						else if (component.equalsIgnoreCase("All"))
						{
							flag = true;
							break;
						}
						else
						{
							flag = false;
						}
					}

					Map<String, String> testDataMap = new HashMap<String, String>();

					for (BrowserEnvironment environment : browserEnvironments)
					{
						TestCase testCase = new TestCase();
						testCase.setTestMethodName(testMethodName);
						testCase.setDescription(testDescription != null ? testDescription : "");
						testCase.setModuleName(moduleName != null ? moduleName : "");
						testCase.setTestData(testDataMap);
						testCase.setBrowser(environment.getBrowser());
						testCase.setVersion(environment.getVersion());
						testCase.setBrowserVersionID(getBrowserString(environment.getBrowser(), environment.getVersion()));
						testCase.setExecution(true);
						testCase.setIsCOATC(isCOATC == null ? "" : isCOATC);
						testCase.setIsTempTC(isTempTC == null ? "" : isTempTC);

						if (jiraId == null)
						{
							testCase.setJiraId("NO JIRA ID");
						}
						else
						{
							testCase.setJiraId(jiraId);
						}
						/*
						 * Add the method and TestCase to map
						 * Key : methodName*browser*version Value : testCase
						 */

						//to run non-COA cases via jenkins by ignoring temp cases
						if (flag && totalCase == 0 && testCase.getIsTempTC() == "" && testCase.getIsCOATC() == "")
						{
							testMethodTestCaseMap.put(testCase.getTestMethodName() + "*" + environment.getBrowser() + "*" + environment.getVersion(), testCase);
						}
						//to run only COA cases via Jenkins
						else if (flag && testCase.getIsCOATC().equalsIgnoreCase("Y") && ConfigProperty.getConfig("Component").equalsIgnoreCase(IConstantsData.COA))
						{
							testMethodTestCaseMap.put(testCase.getTestMethodName() + "*" + environment.getBrowser() + "*" + environment.getVersion(), testCase);
						}
						//to ignore temp cases from Jenkins
						else if (totalCase == 0 && testCase.getIsTempTC().equalsIgnoreCase("Y"))
						{

						}
						//to run cases locally
						else if (totalCase > 0)
						{
							testMethodTestCaseMap.put(testCase.getTestMethodName() + "*" + environment.getBrowser() + "*" + environment.getVersion(), testCase);
						}

						// TODO : New Code
						// check if moduleTestCaseMap contains the module name

						List<TestCase> testCasesofModule = moduleTestCaseMap.get(testCase.getModuleName());
						if (testCasesofModule == null)
						{
							testCasesofModule = new ArrayList<TestCase>();
						}
						testCasesofModule.add(testCase);
						moduleTestCaseMap.put(testCase.getModuleName(), testCasesofModule);
					} // end of for
				} // end of inner if
			} // end of outer if
		} // end of while
	}

	/**
	 * Prepares the list of BrowserEnvironments as per the configurations
	 * provided.
	 * 
	 * @throws TestCaseException
	 */
	private static void prepareBrowserEnvironments() throws TestCaseException
	{
		String browserVersion = ConfigProperty.getConfig("Browsers");
		StringTokenizer stringTokenizer = new StringTokenizer(browserVersion, ",");
		while (stringTokenizer.hasMoreElements())
		{
			String token = stringTokenizer.nextToken();
			String browser = token.substring(0, token.lastIndexOf("-")).trim();
			String version = token.substring(1 + token.lastIndexOf("-")).trim();

			BrowserEnvironment environment = new BrowserEnvironment();
			if ("IE".equalsIgnoreCase(browser))
			{
				environment.setBrowser(FrameworkConstants.BROWSER_IE);
			}
			else if ("FF".equalsIgnoreCase(browser))
			{
				environment.setBrowser(FrameworkConstants.BROWSER_FIREFOX);
			}
			else if ("CR".equalsIgnoreCase(browser))
			{
				environment.setBrowser(FrameworkConstants.BROWSER_CHROME);
			}
			else if ("Edge".equalsIgnoreCase(browser))
			{
				environment.setBrowser(FrameworkConstants.BROWSER_EDGE);
			}
			else
			{
				throw new TestCaseException("Browser :" + browser + " Currently not supported by Framework.");
			}
			environment.setVersion(version);
			environment
				.setEnvironmentType("Grid".equalsIgnoreCase(ConfigProperty.getConfig("Run_On")) ? FrameworkConstants.ENVIRONMENT_GRID : FrameworkConstants.ENVIRONMENT_LOCAL);
			browserNames.add(getBrowserString(environment.getBrowser(), version));

			browserEnvironments.add(environment);
		}
		String logBrowsers = "";
		for (BrowserEnvironment browserEnvironment : browserEnvironments)
		{
			logBrowsers += browserEnvironment.toString();
		}
		logger.info("Browser Environments :" + logBrowsers);
	}

	/**
	 * Checks if the HUB is available
	 * 
	 * @return boolean
	 */
	private static boolean isHubAlive()
	{
		boolean isAlive = false;
		Socket socket = null;
		String hubURL = ConfigProperty.getConfig("Hub_URL");
		StringTokenizer stringTokenizer = new StringTokenizer(hubURL, ":");
		List<String> tokens = new ArrayList<String>();
		while (stringTokenizer.hasMoreTokens())
		{
			tokens.add(stringTokenizer.nextToken());
		}
		String url = tokens.get(1).substring(2);
		String port = tokens.get(2).substring(0, tokens.get(2).indexOf("/"));
		logger.info("Checking HUB [" + hubURL + "] Availability");
		try
		{
			socket = new Socket(url, Integer.parseInt(port));
			isAlive = true;
		}
		catch (Exception e)
		{
			isAlive = false;
		}
		finally
		{
			if (socket != null)
			{
				try
				{
					socket.close();
				}
				catch (IOException e)
				{
				}
			}
		}
		logger.info(isAlive ? "HUB Available" : "HUB Not available");
		return isAlive;
	}

	/**
	 * This method checks if the minimum configuration is provided to run the
	 * TestSuite and is they are provided correctly.
	 */
	private static void checkConfiguration()
	{
		boolean configOk = true;
		StringBuffer errorMessage = new StringBuffer();

		// Check if Run_On is correct, correct entries : Grid | Local
		String runOn = ConfigProperty.getConfig("Run_On");
		if (!("Grid".equalsIgnoreCase(runOn) || "Local".equalsIgnoreCase(runOn)))
		{
			configOk = false;
			errorMessage.append("Run_On=" + runOn + " is Invalid. Valid Choices :" + "Grid | Local.\n");
		}

		// if Run_On = Grid
		// Check if HUB is alive
		// If Local, Check if IE Driver is accessible
		if ("Grid".equalsIgnoreCase(runOn))
		{
			if (!isHubAlive())
			{
				configOk = false;
				errorMessage.append("HUB not available.\n");
			}
		}
		else if ("Local".equalsIgnoreCase(runOn))
		{
			String fileBaseDirectory = ConfigProperty.getConfig("Input_Files_Location") + ConfigProperty.getConfig("IE_Driver_Location");
			File ieDriver32BitFile = new File(fileBaseDirectory + ConfigProperty.getConfig("IE_Driver_32_FileName"));
			File ieDriver64BitFile = new File(fileBaseDirectory + ConfigProperty.getConfig("IE_Driver_64_FileName"));
			if (!ieDriver32BitFile.exists() || !ieDriver64BitFile.exists())
			{
				configOk = false;
				errorMessage.append("IE Driver Files do not exist.\n");
				errorMessage.append("Configured Locations : " + fileBaseDirectory + ConfigProperty.getConfig("IE_Driver_32_FileName") + ", & " + fileBaseDirectory
					+ ConfigProperty.getConfig("IE_Driver_64_FileName") + "\n");
			}
		}

		// If configOk == false, Don't run TCs
		if (!configOk)
		{
			logger.error("CONFIGURATION ISSUES. POSSIBLE CAUSE : " + errorMessage.toString());
			System.exit(0);
		}
	}

	/**
	 * <b><br>
	 * <font color="blue">Method :</b> return the string of browser and version
	 * id <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param broswserName </font><b><br>
	 * @param version </font><b><br>
	 * @return </b> <br>
	 */
	public static String getBrowserString(String broswserName, String version)
	{
		String browserID = null;
		String versionID = null;
		if (broswserName.equalsIgnoreCase("Internet Explorer"))
		{
			browserID = "IE";
		}
		else if (broswserName.equalsIgnoreCase("Firefox"))
		{
			browserID = "FF";
		}
		else if (broswserName.equalsIgnoreCase("Chrome"))
		{
			browserID = "CH";
		}
		else if (broswserName.equalsIgnoreCase("edge"))
		{
			browserID = "edge";
		}
		if (version.contains("."))

		{
			String[] versions = StringUtils.split(version, ".");
			versionID = versions[0];
		}
		else
		{
			versionID = version;
		}
		return browserID.concat("_").concat(versionID);
	}

	/**
	 * <b>Author: amitkumar.dash </b> <b><br>
	 * <font color="blue">Method :</b> To check set up <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @throws InstantiationException </font><b><br>
	 * @throws IllegalAccessException </font><b><br>
	 * @throws ClassNotFoundException </b> <br>
	 */
	private static void checkSetup() throws InstantiationException, IllegalAccessException, ClassNotFoundException
	{
		// Code for setup check
		boolean preCheckSetup = Boolean.valueOf(ConfigProperty.getConfig("PRECHECK_SETUP"));
		if (preCheckSetup)
		{
			String setupsToCheck = ConfigProperty.getConfig("SETUPS_TO_CHECK");
			String setupImpl = ConfigProperty.getConfig("SETUP_CHECHK_IMPL");
			SetupChecker setupCheckImpl = (SetupChecker) Class.forName(setupImpl).newInstance();
			String[] setups = setupsToCheck.split(",");
			for (int index = 0; index < setups.length; index++)
			{
				setups[index] = setups[index].trim();
			}
			StringBuffer setupCheckError = setupCheckImpl.check(setups);
			if (setupCheckError.length() > 0)
			{
				logger.info("System Setup check failed :" + setupCheckError);
				System.exit(1);
			}
		}
	}

}
