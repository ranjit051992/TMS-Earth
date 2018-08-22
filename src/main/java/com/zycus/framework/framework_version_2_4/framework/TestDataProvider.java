package com.zycus.framework.framework_version_2_4.framework;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import atu.testrecorder.ATUTestRecorder;

import com.zycus.automation.eproc.excelDatabaseReader.ExcelReader;
import com.zycus.framework.framework_version_2_4.bo.TestCase;
import com.zycus.framework.framework_version_2_4.startup.Startup;

/**
 * This class provides all data needed for a test case in an Object (
 * <b>com.zycus.testautomation.framework.bo.TestCase</b>)
 * 
 * @author aryasindhu.sahu
 *
 */

public class TestDataProvider
{
	static Logger			logger			= Logger.getLogger(TestDataProvider.class);

	ATUTestRecorder			recorder;
	private static String	outputFilename	= "output/videos/";

	@DataProvider(name = "dataProvider", parallel = true)
	public Object[][] testDataProvider(Method method, ITestContext context)
	{
		String methodName = method.getName();
		String suiteName = context.getCurrentXmlTest().getSuite().getName();
		String browser = suiteName.substring(0, suiteName.indexOf("-"));
		String version = suiteName.substring(1 + suiteName.indexOf("-"), suiteName.lastIndexOf("-"));
		TestCase testCase = Startup.testMethodTestCaseMap.get(methodName + "*" + browser + "*" + version);
		Object[][] retValue = { { testCase } };
		return retValue;
	}

	// TODO : New Code
	@BeforeMethod
	public void checkTestCase(Object[] args)
	{
		TestCase testcase = (TestCase) args[0];
		testcase.getTestMethodName();
		if (Startup.failedModuleNames.indexOf(testcase.getModuleName()) != -1)
		{
			ExcelReader.writeResult("SKIPPED", testcase, null, null, null, null);
			throw new SkipException("module [" + testcase.getModuleName() + "] already failed");
		}

		/*
		 * //To start video recording. try { boolean file = new
		 * File("output/videos/").mkdir(); if (file) { logger.info(
		 * "Directory created..."); } recorder = new
		 * ATUTestRecorder("output/videos/", testMethodName, false);
		 * recorder.start(); } catch (ATUTestRecorderException e) {
		 * logger.error("Exception occurred while recording video : " + e, e); }
		 */
	}

	@AfterMethod
	public void stopVideo(Object[] args)
	{
		// To stop video recording.
		/*
		 * try { TestCase testcase = (TestCase) args[0];
		 * testcase.getTestMethodName();
		 * 
		 * recorder.stop();
		 * 
		 * Long st = System.currentTimeMillis();
		 * 
		 * // create a media reader IMediaReader mediaReader =
		 * ToolFactory.makeReader(inputFilename + "testMethodName.MOV");
		 * 
		 * // create a media writer IMediaWriter mediaWriter =
		 * ToolFactory.makeWriter(outputFilename + "testMethodName.mp4",
		 * mediaReader);
		 * 
		 * // add a writer to the reader, to create the output file
		 * mediaReader.addListener(mediaWriter);
		 * 
		 * // create a media viewer with stats enabled IMediaViewer mediaViewer
		 * = ToolFactory.makeViewer(true);
		 * 
		 * // add a viewer to the reader, to see the decoded media
		 * mediaReader.addListener(mediaViewer);
		 * 
		 * // read and decode packets from the source file and // and dispatch
		 * decoded audio and video to the writer while (mediaReader.readPacket()
		 * == null) { ; }
		 * 
		 * Long end = System.currentTimeMillis(); logger.info(
		 * "Time Taken In Milli Seconds: " + (end - st));
		 * 
		 * } catch (ATUTestRecorderException e) { logger.error(
		 * "Exception occurred while recording video : " + e, e); }
		 */
	}

	/*
	 * public static void convertVideo(String inputFileName, String
	 * outputFileName) { Long st = System.currentTimeMillis();
	 * 
	 * // create a media reader IMediaReader mediaReader =
	 * ToolFactory.makeReader(inputFileName + ".MOV");
	 * 
	 * // create a media writer IMediaWriter mediaWriter =
	 * ToolFactory.makeWriter(outputFilename + ".mp4", mediaReader);
	 * 
	 * // add a writer to the reader, to create the output file
	 * mediaReader.addListener(mediaWriter);
	 * 
	 * // create a media viewer with stats enabled IMediaViewer mediaViewer =
	 * ToolFactory.makeViewer(true);
	 * 
	 * // add a viewer to the reader, to see the decoded media
	 * mediaReader.addListener(mediaViewer);
	 * 
	 * // read and decode packets from the source file and // and dispatch
	 * decoded audio and video to the writer while (mediaReader.readPacket() ==
	 * null) { ; }
	 * 
	 * Long end = System.currentTimeMillis(); logger.info(
	 * "Time Taken In Milli Seconds: " + (end - st)); }
	 */

}
