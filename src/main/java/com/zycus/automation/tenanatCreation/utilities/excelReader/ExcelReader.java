package com.zycus.automation.tenanatCreation.utilities.excelReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

import com.zycus.automation.tenanatCreation.bo.IntegrationEntity;
import com.zycus.automation.tenanatCreation.bo.Master;
import com.zycus.automation.tenanatCreation.bo.MasterStructure;
import com.zycus.automation.tenanatCreation.bo.Roles;
import com.zycus.automation.tenanatCreation.utilities.IConstants.IConstantData;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;

public class ExcelReader
{
	public static Map<String, Map<String, String>>	registryMap			= new HashMap<String, Map<String, String>>();
	public static Map<String, String>				keyValueMap			= new HashMap<String, String>();
	public static List<Master>						mastersList			= new ArrayList<>();
	public static List<MasterStructure>				masterStructureList	= new ArrayList<>();

	public static Map<String, Map<String, String>> readAllRegistryValues(WebDriver driver, String testCaseName)
	{
		//		keyValueMap=new HashMap<String,String>();
		try
		{

			String dataFile;
			dataFile = ConfigProperty.getConfig("registryFile");
			String fileName = ConfigProperty.getConfig("Input_Files_Location") + dataFile;
			FileInputStream fileInputStream = new FileInputStream(new File(fileName));
			HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
			HSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			Row row = rowIterator.next();
			String product = "";//row.getCell(0).getStringCellValue().trim();
			String prvsProduct = "";
			while (rowIterator.hasNext())
			{
				row = rowIterator.next();
				if (row != null)
				{
					product = row.getCell(0).getStringCellValue().trim();
					if ((product.equalsIgnoreCase(prvsProduct) && product != null && (!product.equals(""))) || prvsProduct.equals(""))
					{
						row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
						row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
						keyValueMap.put(row.getCell(1).getStringCellValue().trim(), row.getCell(2).getStringCellValue().trim());
						prvsProduct = product;
						if (rowIterator.hasNext() == false)
						{
							registryMap.put(product, keyValueMap);
						}
					}
					else
					{
						registryMap.put(prvsProduct, keyValueMap);
						keyValueMap = new HashMap<String, String>();
						if ((!product.equals("")) || product != null)
						{
							row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
							row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
							keyValueMap.put(row.getCell(1).getStringCellValue().trim(), row.getCell(2).getStringCellValue().trim());
							if (rowIterator.hasNext() == false)
							{
								registryMap.put(product, keyValueMap);
							}
						}
						prvsProduct = product;
					}
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("Exception while reading registry file !!!" + e.getMessage());
		}
		return registryMap;
	}

	public static List<Master> readMasterValues(WebDriver driver, String testCaseName)
	{

		System.out.println();
		//		keyValueMap=new HashMap<String,String>();
		try
		{

			String dataFile;
			dataFile = ConfigProperty.getConfig("masterDataFile");
			String fileName = ConfigProperty.getConfig("Input_Files_Location") + dataFile;
			System.out.println("File name for master values"+fileName);
			FileInputStream fileInputStream = new FileInputStream(new File(fileName));
			HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
			HSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			Row row = rowIterator.next();
			String tablename = "";//row.getCell(0).getStringCellValue().trim();
			String prvsTableName = "";
			String prvsDisplayName = "";
			while (rowIterator.hasNext())
			{
				MasterStructure masterStructure = new MasterStructure();
				Master master = new Master();
				row = rowIterator.next();
				if (row != null)
				{
					tablename = row.getCell(0).getStringCellValue().trim();
					row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
					row.getCell(3).setCellType(Cell.CELL_TYPE_STRING);
					row.getCell(4).setCellType(Cell.CELL_TYPE_STRING);
					row.getCell(5).setCellType(Cell.CELL_TYPE_STRING);
					row.getCell(6).setCellType(Cell.CELL_TYPE_STRING);
					if(row.getCell(7)!=null)
						row.getCell(7).setCellType(Cell.CELL_TYPE_STRING);
					if ((tablename.equalsIgnoreCase(prvsTableName) && tablename != null && (!tablename.equals(""))) || prvsTableName.equals(""))
					{

						masterStructure.setColumnName(row.getCell(2).getStringCellValue().trim());
						masterStructure.setDisplayField(row.getCell(3).getStringCellValue().trim());
						masterStructure.setFieldType(row.getCell(4).getStringCellValue().trim());
						masterStructure.setFieldLength(row.getCell(5).getStringCellValue().trim());
						masterStructure.setRequired(Boolean.parseBoolean(row.getCell(6).getStringCellValue().trim().toLowerCase()));
						if(row.getCell(7)!=null)
							masterStructure.setConstraint(row.getCell(7).getStringCellValue().trim());
						//keyValueMap.put(row.getCell(1).getStringCellValue().trim(), row.getCell(2).getStringCellValue().trim());
						masterStructureList.add(masterStructure);
						prvsTableName = tablename;
						prvsDisplayName = row.getCell(1).getStringCellValue().trim();
						if (rowIterator.hasNext() == false)
						{
							master.setTableName(tablename);
							master.setDisplayName(row.getCell(1).getStringCellValue().trim());
							master.setMasterStructure(masterStructureList);
							mastersList.add(master);
							//							registryMap.put(tablename, keyValueMap);
						}
					}
					else
					{
						master.setTableName(prvsTableName);
						master.setDisplayName(prvsDisplayName);
						master.setMasterStructure(masterStructureList);
						mastersList.add(master);
						masterStructureList = new ArrayList<>();
						//registryMap.put(prvsTableName, keyValueMap);
						//keyValueMap = new HashMap<String, String>();
						if ((!tablename.equals("")) || tablename != null)
						{
							masterStructure.setColumnName(row.getCell(2).getStringCellValue().trim());
							masterStructure.setDisplayField(row.getCell(3).getStringCellValue().trim());
							masterStructure.setFieldType(row.getCell(4).getStringCellValue().trim());
							masterStructure.setFieldLength(row.getCell(5).getStringCellValue().trim());
							masterStructure.setRequired(Boolean.parseBoolean(row.getCell(6).getStringCellValue().trim().toLowerCase()));
							masterStructure.setConstraint(row.getCell(7).getStringCellValue().trim());
							masterStructureList.add(masterStructure);
							//							keyValueMap.put(row.getCell(1).getStringCellValue().trim(), row.getCell(2).getStringCellValue().trim());
							if (rowIterator.hasNext() == false)
							{
								master.setTableName(tablename);
								master.setDisplayName(row.getCell(1).getStringCellValue().trim());
								master.setMasterStructure(masterStructureList);
								mastersList.add(master);
								//								registryMap.put(tablename, keyValueMap);
							}
						}
						prvsTableName = tablename;
					}
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("Exception while reading masterData file file !!!" + e.getMessage());
		}
		return mastersList;
	}

	public static List<Roles> getAllRoles(WebDriver driver, String testCaseName)
	{

		List<Roles> roles = new ArrayList<>();
		try
		{

			String dataFile;
			dataFile = ConfigProperty.getConfig("rolesForAdminUser");
			String fileName = ConfigProperty.getConfig("Input_Files_Location") + dataFile;
			FileInputStream fileInputStream = new FileInputStream(new File(fileName));
			HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
			HSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			Row row = rowIterator.next();
			while (rowIterator.hasNext())
			{
				row = rowIterator.next();
				if (row != null)
				{
					Roles currentRole = new Roles();
					row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
					currentRole.setRoleName(row.getCell(0).getStringCellValue().trim());
					if (row.getCell(1) != null)
					{
						row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
						currentRole.setAssignedProduct(row.getCell(1).getStringCellValue().trim());
					}

					if (row.getCell(2) != null)
					{
						row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
						currentRole.setRoleType(row.getCell(2).getStringCellValue().trim());
					}
					roles.add(currentRole);
				}
			}
		}
		catch (Exception e)
		{
			System.out.println("Exception while reading roles for admin user file !!!" + e.getMessage());
		}
		return roles;
	}

	public static List<IntegrationEntity> getintegrationEntities(WebDriver driver, String testCaseName, int noOfRows, String product)
	{

		List<IntegrationEntity> entities = new ArrayList<IntegrationEntity>();
		try
		{
			String sheetName = "";
			if (product.equalsIgnoreCase(IConstantData.sheetName_eproc))
			{
				sheetName = IConstantData.sheetName_eproc_entity;
			}
			if (product.equalsIgnoreCase(IConstantData.sheetName_ecatalog))
			{
				sheetName = IConstantData.sheetName_ecatalog_entity;
			}
			String dataFile;
			dataFile = ConfigProperty.getConfig("systemTenantConfigurationFile");
			String fileName = ConfigProperty.getConfig("Input_Files_Location") + dataFile;
			FileInputStream fileInputStream = new FileInputStream(new File(fileName));
			XSSFWorkbook  workbook = new XSSFWorkbook(fileInputStream);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			Iterator<Row> rowIterator = sheet.iterator();
			Row row = rowIterator.next();
			for (int i = 0; i < noOfRows; i++)
			{

				row = rowIterator.next();
				if (row != null)
				{

					IntegrationEntity entity = new IntegrationEntity();
					row.getCell(0).setCellType(Cell.CELL_TYPE_STRING);
					row.getCell(1).setCellType(Cell.CELL_TYPE_STRING);
					row.getCell(2).setCellType(Cell.CELL_TYPE_STRING);
					entity.setEntity(row.getCell(0).getStringCellValue().trim());
					entity.setToSystem(row.getCell(1).getStringCellValue().trim());
					entity.setToUrl(row.getCell(2).getStringCellValue().trim());
					entities.add(entity);

				}
			}
			return entities;

		}
		catch (Exception e)
		{
			System.out.println("Exception while reading integration Entities for system tenant configuration !!!" + e.getMessage());
		}
		return entities;
	}
}
