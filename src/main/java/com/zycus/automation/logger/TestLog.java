
package com.zycus.automation.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class TestLog
{

	private static final Logger logger = Logger.getLogger(TestLog.class);

	public static void main(String args[])
	{
		PropertyConfigurator.configure("log4j.properties");
		logger.debug("This is a debug message");
		logger.info("This is a information message");
		logger.warn("This is a warning message");
		logger.error("This is an error message");
		logger.fatal("This is a fatal message");
		logger.debug("This is another debug message");
		logger.info("This is another information message");
		logger.warn("This is another warning message");
		logger.error("This is another error message");
		logger.fatal("This is another fatal message");
	}
}
