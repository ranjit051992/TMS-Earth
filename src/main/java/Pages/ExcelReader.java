package Pages;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;

public class ExcelReader
{
    public static Map<String, String> getDefaultObjectOfReq() throws Exception {
        Map<String, String> map = new HashMap<String, String>();

        String filePath = "./resources/ReqBoDefaultData.xlsx";
        File excelFile = new File(filePath);
        FileInputStream fis = new FileInputStream(excelFile);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheetAt(0);

        for(int i = 0; i <= sheet.getLastRowNum(); i++) {
            String key = "";
            String value = "";
            XSSFRow row = sheet.getRow(i);
            XSSFCell cell0 = row.getCell(0);
            XSSFCell cell1 = row.getCell(1);
            if(cell0.getCellType().equals(CellType.NUMERIC)) {
                key = String.valueOf(cell0.getNumericCellValue());
            }
            else if(cell0.getCellType().equals(CellType.STRING)) {
                key = cell0.getStringCellValue();
            }
            else {
                throw new Exception("Cell type is " + row.getCell(0).getCellType().toString());
            }
            if(cell1.getCellType().equals(CellType.NUMERIC)) {
                value = String.valueOf(cell1.getNumericCellValue());
            }
            else if(cell1.getCellType().equals(CellType.STRING)) {
                value = cell1.getStringCellValue();
            }
            else {
                throw new Exception("Cell type is " + row.getCell(0).getCellType().toString());
            }
            map.put(key, value);
        }
        System.out.println("-->" + map.size());
        for(Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("key-->" + entry.getKey() + ", value-->" + entry.getValue());
        }
        return map;
    }
}
