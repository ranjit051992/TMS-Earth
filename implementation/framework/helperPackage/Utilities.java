package framework.helperPackage;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class Utilities {
	public static Logger logger = Logger.getLogger(Utilities.class);

	public static boolean driverStatus(WebDriver driver, String testCaseName) throws Exception {
		boolean status = false;
		try {
			driver.getTitle();

			if (driver != null) {
				status = true;
			}
		} catch (Exception e) {
			logger.error("WebDriver is not avaliable to proceed for " + testCaseName);
			throw e;
		}

		return status;
	}

	public static String toUpperCase(String text) throws Exception {
		try {
			if (text != null) {
				text = text.toUpperCase();
			}
		} catch (Exception e) {
			throw e;
		}
		return text;
	}

}
