package framework.frameworkUtilies.customLogger;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.FileAppender;
import org.apache.log4j.Layout;
import org.apache.log4j.Level;
import org.apache.log4j.MDC;
import org.apache.log4j.RollingFileAppender;
import org.apache.log4j.spi.ErrorCode;
import org.apache.log4j.spi.LoggingEvent;

public class CustomFileAppender extends FileAppender {

	private final static String DOT = ".";
	private final static String DASH = "-";
	private static final String ORIGINAL_FILE_NAME = "";

	public CustomFileAppender() {
	}

	public CustomFileAppender(Layout layout, String fileName, boolean append, boolean bufferedIO, int bufferSize)
			throws IOException {
		new FileAppender(layout, fileName, append, bufferedIO, 10);
		new RollingFileAppender(layout, fileName, append);
	}

	public CustomFileAppender(Layout layout, String fileName, boolean append) throws IOException {
		super(layout, fileName, append);
		new RollingFileAppender(layout, fileName, append);
	}

	public CustomFileAppender(Layout layout, String fileName) throws IOException {
		super(layout, fileName);
		new RollingFileAppender(layout, fileName);
	}

	@Override
	public void activateOptions() {
		MDC.put(ORIGINAL_FILE_NAME, fileName);
		super.activateOptions();
	}

	@Override
	public void append(LoggingEvent event) {
		try {
			if (event.getLevel().equals(Level.WARN)) {
				setFile(appendLevelToFileName((String) MDC.get(ORIGINAL_FILE_NAME), "BrowserConsole"), fileAppend,
						bufferedIO, bufferSize);
				super.append(event);
			} else {
				setFile(MDC.get(ORIGINAL_FILE_NAME).toString(), fileAppend, bufferedIO, bufferSize);
				super.append(event);
				if (event.getThrowableInformation() != null) {
					for (int i = 0; i < event.getThrowableInformation().getThrowableStrRep().length; i++) {
						if (event.getThrowableInformation().getThrowableStrRep()[i].toLowerCase().contains("exception")
								|| event.getThrowableInformation().getThrowableStrRep()[i].toLowerCase()
										.contains("assertion")) {
							setFile(appendLevelToFileName((String) MDC.get(ORIGINAL_FILE_NAME), "Exception"),
									fileAppend, bufferedIO, bufferSize);
							super.append(event);
							break;
						} else {
							setFile(appendLevelToFileName((String) MDC.get(ORIGINAL_FILE_NAME),
									event.getLevel().toString()), fileAppend, bufferedIO, bufferSize);
							super.append(event);
							break;
						}
					}
				}
			}
		} catch (IOException ie) {
			errorHandler.error("Error occured while setting file for the log level " + event.getLevel(), ie,
					ErrorCode.FILE_OPEN_FAILURE);
		}
	}

	private String appendLevelToFileName(String oldLogFileName, String level) {
		if (oldLogFileName != null) {
			final File logFile = new File(oldLogFileName);
			String newFileName = "";
			final String fn = logFile.getName();
			final int dotIndex = fn.indexOf(DOT);
			if (dotIndex != -1) {
				newFileName = fn.substring(0, dotIndex) + DASH + level + DOT + fn.substring(dotIndex + 1);
			} else {
				newFileName = fn + DASH + level;
			}
			return logFile.getParent() + File.separator + newFileName;
		}
		return null;
	}
}
