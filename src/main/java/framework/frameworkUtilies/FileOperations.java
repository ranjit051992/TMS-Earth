package framework.frameworkUtilies;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileOperations
{
	public static List<String> getTestCaseList() throws IOException
	{
		List<String> testcases = new ArrayList<String>();
		XSSFWorkbook workbook = null;
		XSSFSheet sheet = null;
		try
		{
			FileInputStream inputStream = new FileInputStream(GlobalVariable.TESTCASES_LIST_FILE_PATH);
			workbook = new XSSFWorkbook(inputStream);
			sheet = workbook.getSheetAt(0);
			int lastRowNo = sheet.getLastRowNum();
			if (lastRowNo > 0)
			{
				for (int i = 1; i <= lastRowNo; i++)
				{
					testcases.add(sheet.getRow(i).getCell(0).getStringCellValue());
				}
			}

		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			workbook.close();
		}

		return testcases;
	}
}
