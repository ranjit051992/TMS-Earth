package framework.utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

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

	public static void writeInFile(String filePath, String Value) throws Exception {
		try {
			BufferedWriter BR = new BufferedWriter(new FileWriter(new File(filePath), true));
			BR.write(Value);
			BR.newLine();
			BR.close();
		}
		catch (Exception e) {

			throw e;
		}
	}
}
