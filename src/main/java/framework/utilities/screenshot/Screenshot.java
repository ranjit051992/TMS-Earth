package framework.utilities.screenshot;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import framework.frameworkUtilies.GlobalVariable;
import framework.utilities.helper_package.commonUtilities;

public class Screenshot
{
	public static Logger logger = Logger.getLogger(Screenshot.class);

	public static void captureScreenshot(WebDriver driver, String testcase, String screenshotName) throws Exception
	{
		try
		{
			String currentUrl = "";
			if (driver != null)
			{
				currentUrl = driver.getCurrentUrl();
			}
			if (GlobalVariable.TAKE_SCREEN_SHOT && driver != null && testcase != null)
			{
				String screenshotname = commonUtilities.currentdateTime("dd-MM-yyyy_HH-mm-ss-SS") + testcase + "_" + screenshotName;
				String filepath = GlobalVariable.SCREENSHOT_PATH;
				String fileName = filepath + testcase + "/" + screenshotname + ".png";
				File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
				printURLOnScreenShot(screenshotFile, currentUrl);
				FileUtils.copyFile(screenshotFile, new File(fileName));
			}
		}
		catch (Exception e)
		{
			throw e;
		}
	}

	public static boolean createDir(String dirName) throws Exception
	{
		boolean dirTest = false;
		try
		{
			File theDir = new File(dirName);
			dirTest = theDir.mkdirs();
		}
		catch (Exception e)
		{
			throw e;
		}
		return dirTest;
	}

	public static boolean removeDir(String dirName) throws Exception
	{
		boolean status = false;

		File tmpDir = new File(dirName);
		if (tmpDir.exists())
		{
			logger.info("\nRemoving   " + dirName);
			FileUtils.deleteDirectory(new File(dirName));
		}
		else
		{
			logger.info(dirName + " Not Exist");
		}

		return status;
	}

	/**
	 * ;
	 * 
	 * @author nitin.chourey;
	 * @description moveDirectory moves passed and failed testcase to different
	 *              folders ;
	 * @param Test
	 *            case object;
	 * @return boolean value;
	 */
	public static synchronized boolean moveDirectory(String TestCaseName)
	{
		boolean status = false, moveFile = false;
		try
		{

			if (GlobalVariable.TAKE_SCREEN_SHOT)
			{
				File[] files = new File(GlobalVariable.SCREENSHOT_PATH).listFiles();
				logger.info("moving screen shots directory....");
				for (File file : files)
				{

					if (file.isDirectory() && !file.getName().equals("Passed") && !file.getName().equals("Failed"))
					{
						if (TestCaseName.equals(file.getName()))
						{

							logger.info("moving : " + file.getName() + "  Directory");
							File[] subfiles = new File(GlobalVariable.SCREENSHOT_PATH + "/" + file.getName()).listFiles();
							for (File filee : subfiles)
							{

								if (filee.getName().contains("Exception") || filee.getName().contains("Assertion"))
								{
									status = false;
									break;
								}
								else
								{
									status = true;
								}
							}
							if (status)
							{
								moveFile = file.renameTo((new File(GlobalVariable.SCREENSHOT_PATH + "Passed" + "/" + file.getName())));
								logger.info("is " + file.getName() + " moved: " + moveFile);
							}
							else
							{
								moveFile = file.renameTo(new File(GlobalVariable.SCREENSHOT_PATH + "Failed" + "/" + file.getName()));
								logger.info("is " + file.getName() + " moved: " + moveFile);
							}
						}
					}
				}
			}
			logger.info("screen shots directory moved ");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		return status;
	}

	public static File printURLOnScreenShot(File file, String currentURL)
	{
		try
		{
			BufferedImage image = ImageIO.read(file);
			Graphics g = image.getGraphics();
			g.setColor(new Color(000));
			g.setFont(new Font("default", Font.BOLD, 12));
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
