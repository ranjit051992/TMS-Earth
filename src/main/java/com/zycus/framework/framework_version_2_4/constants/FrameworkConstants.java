package com.zycus.framework.framework_version_2_4.constants;

import com.zycus.automation.utilities.actionbot.ActionBot;
import com.zycus.framework.framework_version_2_4.framework.Helper;

public interface FrameworkConstants
{

	public static int			ENVIRONMENT_GRID	= 10;
	public static int			ENVIRONMENT_LOCAL	= 20;

	public static String		BROWSER_IE			= "Internet Explorer";
	public static String		BROWSER_FIREFOX		= "Firefox";
	public static String		BROWSER_CHROME		= "Chrome";
	public static String		BROWSER_EDGE		= "Edge";

	public static final String	output				= Helper.returnKeyValuePair("output.dir");
	public static final String	screenShot			= Helper.returnKeyValuePair("screenShot.dir");

	public static final String	testopiaScreenShot	= output + screenShot + "Testopia_ScreenShot/";
	public static final String	takeScreenShot		= Helper.returnKeyValuePair("Take_Screenshot");
	public static final String	tempScreenShot		= Helper.returnKeyValuePair("temp_ScreenShot");

	// Sanity Regression Mapping
	public static final String	description			= "description";
	public static final String	mappingID			= "mappingID";

	// Suite Type
	public String				SUITE_TYPE			= ActionBot.returnKeyValuePair("SUITE_TYPE");

}
