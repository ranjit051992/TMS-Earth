package com.zycus.automation.utilities.screenshot;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.Augmenter;

import com.zycus.automation.constants.IConstants;
import com.zycus.automation.exception.ScreenShotException;
import com.zycus.automation.utilities.Utilities;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;

public class ScreenShot extends Utilities
{

	final static private String	output			= ConfigProperty.getConfig("output.dir");
	final static private String	passTcDir		= ConfigProperty.getConfig("destOfPassedTC");
	final static private String	failTcDir		= ConfigProperty.getConfig("destOfFailedTC");
	final static private String	takeScreenShot	= ConfigProperty.getConfig("Take_Screenshot");
	final static private String	tempScreenShot	= ConfigProperty.getConfig("temp_ScreenShot");
	private static List<String>	skipScreenShots	= null;
	static Logger				logger			= Logger.getLogger(ScreenShot.class);
	static
	{
		PropertyConfigurator.configure(IConstants.LOG_4J_APPENDDER);
	}

	private static int	assertion	= 0;
	private static int	exception	= 1;

	private static void screenShot(WebDriver driver, String testCaseName, String screenShotName)
	{
		try
		{
			WebDriver tempDriver = driver;
			String tempdir = output + tempScreenShot.concat("/").concat(testCaseName).concat("/");
			long screenShotPrefix = System.currentTimeMillis();
			String screenShotSuffix = "_".concat(screenShotName);
			if (takeScreenShot.equalsIgnoreCase("false") || takeScreenShot.equalsIgnoreCase("no"))
			{
				logger.info("SCREENSHOT IS BEEN SKIPPED");
			}
			else if (takeScreenShot.equalsIgnoreCase("true") || takeScreenShot.equalsIgnoreCase("yes"))
			{
				if (driverStatus(driver, testCaseName))
				{
					String currentURL = driver.getCurrentUrl();
					if ((!(driver instanceof InternetExplorerDriver)) && (!(driver instanceof FirefoxDriver)))
					{
						tempDriver = new Augmenter().augment(tempDriver);
					}
					try
					{
						String name = screenShotPrefix + screenShotSuffix + ".png";
						File scrFile = ((TakesScreenshot) tempDriver).getScreenshotAs(OutputType.FILE);
						scrFile = printURLOnScreenShot(scrFile, currentURL);
						FileUtils.copyFile(scrFile, new File(tempdir + name));
					}
					catch (IOException e)
					{
						logger.error("UNABLE TO SAVE SCREENSHOT WITH NAME ==> " + screenShotName, e);
					}
					catch (Exception e)
					{
						logger.error("UNABLE TO SAVE SCREENSHOT WITH NAME ==>" + screenShotName, e);
					}
				}
			}
			else
			{
				logger.error("DRIVER IS NULL");
			}
		}
		catch (Exception e)
		{
			logger.error("[-- Harmless --] Error While Taking ScreenShot" + e);
		}
	}

	private static void screenShot(WebDriver driver, String testCaseName, String screenShotName, int type)
	{

		switch (type)
		{
			case 0: {
				screenShotName = screenShotName.concat("_ASSERTION_!!!!!!!");
				break;
			}
			case 1: {
				screenShotName = screenShotName.concat("_EXCEPTION_!!!!!!!");
				break;
			}
		}
		screenShot(driver, testCaseName, screenShotName);
	}

	private static void assertScreenShot(WebDriver driver, String testCaseName, String screenShotName)
	{
		screenShot(driver, testCaseName, screenShotName, assertion);
	}

	private static void exceptionScreenShot(WebDriver driver, String testCaseName, String screenShotName)
	{
		screenShot(driver, testCaseName, screenShotName, exception);
	}

	public static void moveTestCase(TestCase testCase, boolean testResults) throws IOException, ScreenShotException
	{
		try
		{
			logger.info("MOVING REPORT");
			File srcFileName, destOfPassedTC, destOfFailedTC;
			String methodName = testCase.getTestMethodName();
			srcFileName = new File(output + tempScreenShot.concat("/").concat(methodName));
			File folder = new File(srcFileName.toString());
			File[] listOfFiles = folder.listFiles();
			String file;
			boolean pass = true;
			for (File listOfFile : listOfFiles)
			{

				if (listOfFile.isFile())
				{
					file = listOfFile.getName();
					if (file.contains("ASSERTION") || file.contains("EXCEPTION"))
					{
						pass = false;
					}
				}
			}

			if ((pass == false) && (testResults == false))
			{
				destOfFailedTC = new File(output + failTcDir.concat("/") + testCase.getBrowser() + "-" + testCase.getVersion() + "/");
				if (srcFileName.isDirectory())
				{
					if (!destOfFailedTC.isDirectory())
					{
						boolean result = createDirectory(destOfFailedTC.toString());
						if (!result)
						{
							logger.info("FAILED TO CREATE DIRECTORY " + destOfFailedTC);
						}
					}

					if (!srcFileName.renameTo(new File(destOfFailedTC, srcFileName.getName())))
					{
						logger.error(methodName + " WAS FAILED MOVED TO FAILED SECTION");
					}

				}
				else
				{
					logger.error(methodName + " Does Not Exist");
				}
			}

			else if ((pass == true) && (testResults = true))
			{
				destOfPassedTC = new File(output + passTcDir.concat("/") + testCase.getBrowser() + "-" + testCase.getVersion() + "/");
				if (srcFileName.isDirectory())
				{
					if (!destOfPassedTC.isDirectory())
					{
						boolean result = createDirectory(destOfPassedTC.toString());
						if (!result)
						{
							logger.info("FAILED TO CREATE DIRECTORY " + destOfPassedTC);

						}
					}
					if (!srcFileName.renameTo(new File(destOfPassedTC, srcFileName.getName())))
					{
						logger.error(methodName + " WAS FAILED MOVED TO PASSED SECTION");
					}
				}
				else
				{
					logger.error(methodName + " DOES NOT EXIST");
				}
			}
		}
		catch (Exception e)
		{
			logger.error("FAILED TO MOVED TESTCASE TO DESIRED DIRECTORY" + e, e);
			throw new ScreenShotException();

		}
	}

	private static boolean createDirectory(String directory)
	{
		File theDir = new File(directory);
		boolean dirTest = theDir.mkdirs();
		return dirTest;
	}

	/**
	 * 
	 * <b>Author: puneet.sharma </b> <b><br>
	 * <font color="blue">Method :</b> Takes screenshot for normal execution of
	 * tc after checking the status of driver. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param by </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception </b> <br>
	 */
	public static void screenshot(WebDriver driver, String testCaseName, String str)
	{
		if (skipScreenShots != null)
		{
			if (!skipScreenShots.contains(testCaseName.trim()))
			{

				str = appendUnderScore(str);
				if (driverStatus(driver, testCaseName))
				{
					screenShot(driver, testCaseName, str);
				}
				else
				{
					logger.info("Driver is Found To Be Dead Hence Aborting ScreenShot".toString());
				}
			}
		}
		else
		{
			str = appendUnderScore(str);
			if (driverStatus(driver, testCaseName))
			{
				screenShot(driver, testCaseName, str);
			}
			else
			{
				logger.info("Driver is Found To Be Dead Hence Aborting ScreenShot".toString());
			}

		}
	}

	/**
	 * 
	 * <b>Author: puneet.sharma </b> <b><br>
	 * <font color="blue">Method :</b> Takes screenshot on assertion of tc after
	 * checking the status of driver. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param by </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception </b> <br>
	 */
	public static void assertScreenshot(WebDriver driver, String testCaseName, String str)
	{
		if (driverStatus(driver, testCaseName))
		{
			assertScreenShot(driver, testCaseName, str);
		}
		else
		{
			logger.info("Driver is Found To Be Dead Hence Aborting ScreenShot");
		}
	}

	/**
	 * 
	 * <b>Author: puneet.sharma </b> <b><br>
	 * <font color="blue">Method :</b> Takes screenshot on exception of tc after
	 * checking the status of driver. <br>
	 * </font><b><font color="green">Note :</b> </font><b><br>
	 * <font color="red">Assertion :</b> </font><b><br>
	 * @param driver </font><b><br>
	 * @param by </font><b><br>
	 * @return </font><b><br>
	 * @throws Exception </b> <br>
	 */
	public static void exceptionScreenshot(WebDriver driver, String testCaseName, String str)
	{
		if (driverStatus(driver, testCaseName))
		{
			exceptionScreenShot(driver, testCaseName, str);
		}
		else
		{
			logger.info("Driver is Found To Be Dead Hence Aborting ScreenShot");
		}
	}

	/**
	 * 
	 * <b>created On : </b>25-Jul-2014 : 7:09:12 pm<br>
	 * <font size="2" color="black"><b>author : </b> puneet.sharma<br>
	 * </font> <font size="2" color="black"><b>method Name : </b>
	 * deleteAlreadyCreatedDir<br>
	 * </font> <font size="2" color="red"><b>method Description : </b> </font>
	 * <br>
	 * <font size="2" color="black"><b>return Type : </b>void </font><br>
	 * @param param
	 */
	public static void deleteAlreadyCreatedDir(String param)
	{
		try
		{
			FileUtils.deleteDirectory(new File(param));
		}
		catch (IOException e)
		{
			logger.info("Error in deleting screenshot directory : " + param);
		}
	}

	public static void addMethodToSkipScreenshotList(String param)
	{
		if (skipScreenShots == null)
		{
			skipScreenShots = new ArrayList<String>();
		}
		skipScreenShots.add(param.trim());
	}

	public static File printURLOnScreenShot(File file, String currentURL)
	{
		try
		{
			BufferedImage image = ImageIO.read(file);
			Graphics g = image.getGraphics();
			g.setColor(new Color(000));
			g.setFont(new Font("default", Font.BOLD, 18));
			// g.setFont(g.getFont().deriveFont(15f));
			g.drawString(currentURL, 0, 600);
			g.dispose();

			ImageIO.write(image, "png", file);
		}
		catch (IOException e)
		{
			logger.error("Exception while printing url on screen shot : " + e, e);
		}
		return file;
	}
}