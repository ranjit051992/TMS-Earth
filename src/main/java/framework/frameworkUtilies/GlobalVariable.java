package framework.frameworkUtilies;

import framework.startup.Startup;
import framework.utilities.helper_package.commonUtilities;

public class GlobalVariable
{

	public static final String	FILE_DOWNLOAD_PATH			= "";
	public static int			TIMEOUT						= 20;
	public static String		SETUP						= Startup.configMap.get("SETUP");
	public static String		TENANT						= Startup.configMap.get("TENANT");
	public static String		SUITE_TYPE					= Startup.configMap.get("SUITE_TYPE");
	public static int			DEFAULT_WAIT				= Integer.parseInt(Startup.configMap.get("DEFAULT_WAIT"));
	public static int			DEFAULT_LOW_WAIT			= Integer.parseInt(Startup.configMap.get("DEFAULT_LOW_WAIT"));
	public static int			DEFAULT_MEDIUM_WAIT			= Integer.parseInt(Startup.configMap.get("DEFAULT_MEDIUM_WAIT"));
	public static int			DEFAULT_HIGH_WAIT			= Integer.parseInt(Startup.configMap.get("DEFAULT_HIGH_WAIT"));
	public static int			CONDITIONAL_WAIT			= Integer.parseInt(Startup.configMap.get("CONDITIONAL_WAIT"));
	public static String		DB_URL						= Startup.configMap.get("DB_URL");
	public static String		DB_USER_NAME				= Startup.configMap.get("DB_USER_NAME");
	public static String		DB_PASSWORD					= Startup.configMap.get("DB_PASSWORD");
	public static String		SCREENSHOT_PATH				= Startup.configMap.get("SCREENSHOT_PATH");
	public static String		ROLE						= Startup.configMap.get("ROLE");
	public static String		RUN_ON						= Startup.configMap.get("RUN_ON");
	public static int			THREAD_COUNT				= Integer.parseInt(Startup.configMap.get("THREAD_COUNT"));
	public static String		HUB_URL						= Startup.configMap.get("HUB_URL");
	public static String		BROWSER						= Startup.configMap.get("BROWSER");
	public static boolean		TAKE_SCREEN_SHOT			= Startup.configMap.get("TAKE_SCREEN_SHOT").equalsIgnoreCase("true");
	public static boolean		isAnalyzeLog				= Startup.configMap.get("isAnalyzeLog").equalsIgnoreCase("true");
	public static boolean		LOGIN_WITH_PASSWORD_MANAGER	= Startup.configMap.get("LOGIN_WITH_PASSWORD_MANAGER").equalsIgnoreCase("true");
	public static boolean		isCOA						= Startup.configMap.get("isCOA").equalsIgnoreCase("true");
	public static boolean		GENERATE_REPORT				= Startup.configMap.get("GENERATE_REPORT").equalsIgnoreCase("true");
	public static String		EXECUTION_DATE_STAMP		= commonUtilities.currentdateTime("yyyy-MM-dd");
	public static String		USER_NAME					= Startup.configMap.get("USER_NAME");
	public static String		PASSWORD					= Startup.configMap.get("PASSWORD");
	public static String		ADMIN_USERNAME				= Startup.configMap.get("ADMIN_USERNAME");
	public static String		ADMIN_PASSWORD				= Startup.configMap.get("ADMIN_PASSWORD");
	public static String		CURRENT_STATUS_FILE			= Startup.configMap.get("CURRENT_STATUS_FILE");
	public static String		TESTCASES_LIST_FILE_PATH	= Startup.configMap.get("TESTCASES_LIST_FILE_PATH");
	public static String		AUTHOR						= Startup.configMap.get("AUTHOR");
	public static String		MODULE						= Startup.configMap.get("MODULE");

}
