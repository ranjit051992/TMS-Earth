package framework.loggers;

import org.apache.log4j.MDC;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LogGenerator {

    /**
     * ;
     *
     * @author om.pawar;
     * @description: generateErrorLog generates a separate error log file with a
     *               custom message;
     * @param: Throwable;
     * @return: String;
     */
    public static String generateErrorLog(Throwable throwable) throws Exception
    {
        String message = "";
        String reportingMessage = "";
        String testCaseID = MDC.get("TestCaseName").toString();
        String fileName = "./output/log/testlog-Exception.xlsx";
        String sheetName = fileName.substring(fileName.lastIndexOf("/") + 1, fileName.lastIndexOf(".xlsx"));
        int rowNum;
        int cellCounter = 0;
        FileInputStream is = null;
        FileOutputStream fs = null;
        Workbook workbook = null;
        XSSFSheet sheet = null;
        XSSFRow row = null;

        File file = new File(fileName);
        if (!file.exists())
        {
            fs = new FileOutputStream(fileName);
            workbook = new XSSFWorkbook();
            sheet = (XSSFSheet) workbook.createSheet(sheetName);
//			 sheet.autoSizeColumn(1000000);
            rowNum = sheet.getLastRowNum();
            row = sheet.createRow(rowNum);

            XSSFFont cellFont = (XSSFFont) workbook.createFont();
            cellFont.setBold(true);
            XSSFCellStyle cellStyle = (XSSFCellStyle) workbook.createCellStyle();
            cellStyle.setFont(cellFont);

            XSSFCell cell = row.createCell(cellCounter++);
            cell.setCellStyle(cellStyle);
            cell.setCellValue("Test Case ID");

            cell = row.createCell(cellCounter++);
            cell.setCellStyle(cellStyle);
            cell.setCellValue("Exception Name");

            cell = row.createCell(cellCounter++);
            cell.setCellStyle(cellStyle);
            cell.setCellValue("Exception Message");

            cell = row.createCell(cellCounter++);
            cell.setCellStyle(cellStyle);
            cell.setCellValue("Class and Method Name");
//			 row.createCell(cellCounter++).setCellValue("Test Case ID");
//			 row.createCell(cellCounter++).setCellValue("Exception Name");
//			 row.createCell(cellCounter++).setCellValue("Exception Message");
//			 row.createCell(cellCounter++).setCellValue("Class and Method Name");

            rowNum++;
        }
        else
        {
            is = new FileInputStream(file);
            workbook = new XSSFWorkbook(is);
            sheet = (XSSFSheet) workbook.getSheet(sheetName);
            rowNum = sheet.getLastRowNum() + 1;
        }

        row = sheet.createRow(rowNum);

        getClassNames(new File("./src/main/java"));

        if (throwable.getClass().getCanonicalName().toLowerCase().contains("assertion"))
        {
            cellCounter = 0;
            row.createCell(cellCounter++).setCellValue(testCaseID);
            row.createCell(cellCounter++).setCellValue(throwable.getClass().getCanonicalName());
            row.createCell(cellCounter++).setCellValue(throwable.getLocalizedMessage());
            logger.error(throwable.getClass().getCanonicalName() + " :: " + throwable.getLocalizedMessage(), throwable);

            reportingMessage = throwable.getClass().getCanonicalName() + " \n " + throwable.getLocalizedMessage();
        }
        else
        {
            cellCounter = 0;

            StackTraceElement[] stackElement = throwable.getStackTrace();
            String exception = "";
            exception = throwable.getLocalizedMessage();
            if(exception != null) {
                if (exception.contains("\n"))
                {
                    exception = exception.substring(0, exception.indexOf("\n"));
                }
            }

            for (int i = 0; i < stackElement.length; i++)
            {
                if (stackElement[i] != null)
                {
                    Iterator<String> itr = classNameSet.iterator();
                    while (itr.hasNext())
                    {
                        if (stackElement[i].getClassName().contains(itr.next()))
                        {
                            if (message.isEmpty())
                            {
                                message += throwable.getClass().getCanonicalName() + " :: " + exception + " --> " + stackElement[i].getClassName() + " ==> " + stackElement[i].getMethodName() + "||";
                                row.createCell(cellCounter++).setCellValue(testCaseID);
                                row.createCell(cellCounter++).setCellValue(throwable.getClass().getCanonicalName());
                                row.createCell(cellCounter++).setCellValue(exception);
                            }
                            else
                            {
                                message += stackElement[i].getClassName() + " ==> " + stackElement[i].getMethodName() + "||";
                            }
//							 stackElement[i + 1] = null;
                            break;
                        }
                    }
                }
            }

            if (!message.isEmpty())
            {
                message = message.substring(0, message.lastIndexOf("||"));
                if (message.contains("-->"))
                {
                    row.createCell(cellCounter++).setCellValue(message.substring(message.indexOf("-->") + 4));
                }
            }
            else
            {
                cellCounter = 0;
                row.createCell(cellCounter++).setCellValue(testCaseID);
                row.createCell(cellCounter++).setCellValue(throwable.getClass().getCanonicalName());
                row.createCell(cellCounter++).setCellValue(exception);
                message = throwable.getClass().getCanonicalName() + " :: " + exception;
            }
            logger.error(message, throwable);
            reportingMessage = throwable.getClass().getCanonicalName() + " \n " + exception;
        }

        try
        {
            if(file.exists()) {
                fs = new FileOutputStream(file);
            }
            workbook.write(fs);
            fs.close();
            workbook.close();
        }
        catch (FileNotFoundException fe)
        {
            Runtime.getRuntime().exec("cmd /c taskkill /f /im excel.exe");
            Thread.sleep(5000);
            if(file.exists()) {
                fs = new FileOutputStream(file);
            }
            workbook.write(fs);
            fs.close();
            workbook.close();
        }
        logger.info("Hey nitin returning error message : " + reportingMessage);
        return reportingMessage;
    }

    /**
     * ;
     *
     * @author om.pawar;
     * @description: getClassNames retrieves all the file names from the File
     *               parameter passed to it;
     * @param: File;
     * @return: void;
     */
    public static void getClassNames(File file) throws Exception
    {
        File[] fileArray = file.listFiles();
        for (int i = 0; i < fileArray.length; i++)
        {
            if (fileArray[i].isDirectory())
            {
                getClassNames(fileArray[i]);
            }
            else if (fileArray[i].isFile())
            {
                if (fileArray[i].getName().contains(".java"))
                {
                    String fileName = fileArray[i].getName().replace(".java", "");
                    classNameSet.add(fileName);
                }
            }
        }
    }

    /**
     * ;
     *
     * @author om.pawar;
     * @description: generateErrorLog generates a separate error log file with a
     *               custom message;
     * @param: Throwable;
     * @return: void;
     */
    public static void analyzeLog(WebDriver driver) throws Exception
    {
        if (GlobalVariable.isAnalyzeLog)
        {
            List<String> urlList = new ArrayList<String>();
            LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
            for (LogEntry entry : logEntries)
            {
                /*
                 * ; String url = ""; String completeLog=entry.getMessage();
                 * completeLog = new Date(entry.getTimestamp()) + " " +
                 * entry.getLevel() + " " + entry.getMessage(); String urlTemp =
                 * completeLog.substring(completeLog.indexOf("https://"),
                 * completeLog.lastIndexOf("-")); urlList.add(urlTemp); String
                 * browserConsoleOutput = new Date(entry.getTimestamp()) + " " +
                 * entry.getLevel() + " " + entry.getMessage();
                 * logger.warn(entry.getMessage());
                 */
            }
            ((JavascriptExecutor) driver).executeScript("console.clear();");
        }
    }

}
