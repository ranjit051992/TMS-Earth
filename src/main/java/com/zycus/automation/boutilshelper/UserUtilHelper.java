package com.zycus.automation.boutilshelper;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import com.zycus.automation.bo.User;
import com.zycus.framework.framework_version_2_4.framework.ConfigProperty;

public class UserUtilHelper
{
	static Logger				logger				= Logger.getLogger(UserUtilHelper.class);
	final static int			CELL_USERNAME		= 0;
	final static int			CELL_PASSWORD		= 1;
	final static int			CELL_ROLE			= 2;
	final static int			CELL_DISPLAY_NAME	= 3;
	final static int			CELL_TENANT			= 4;

	/*
	 * private final static String fileName = "input/" +
	 * PropertyReader.configProperty.getProperty("credentials");
	 */
	private final static String	fileName			= "input/" + ConfigProperty.getConfig("credentials");
	private static List<User>	users				= initializeUserList();

	public enum Enum_UserList {
		USERNAME, PASSWORD, DISPLAY_NAME, ROLE, TENANT;
	}

	private static List<User> initializeUserList()
	{

		return (users == null) ? createUserList() : users;
	}

	public static List<User> getAvailableUser()
	{
		Collections.sort(users);
		return users;
	}

	public static User getAvailableUserFromList()
	{
		Collections.sort(users);
		logger.info("Availble Users list : " + users);
		User user = users.get(0);

		if (user.getUsername() != null && user.getPassword() != null && !user.getUsername().equalsIgnoreCase("null") && user.getPassword().equalsIgnoreCase("null"))
		{
			removeUserFromList(user);
			return user;
		}
		else
		{
			removeUserFromList(user);
			User newUser = new User();
			if (users.size() > 0)
			{
				newUser = users.get(0);
			}
			else
			{
				createUserList();
				newUser = users.get(0);

			}
			removeUserFromList(newUser);
			return newUser;
		}
	}

	private static List<User> createUserList()
	{
		users = new ArrayList<User>();
		try
		{
			FileInputStream fileInputStream = new FileInputStream(fileName);
			HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
			HSSFSheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			Row row = rowIterator.next();
			while (rowIterator.hasNext())
			{
				row = rowIterator.next();
				User user = new User();
				Cell username = row.getCell(CELL_USERNAME);
				Cell password = row.getCell(CELL_PASSWORD);
				Cell role = row.getCell(CELL_ROLE);
				Cell displayName = row.getCell(CELL_DISPLAY_NAME);
				Cell tenant = row.getCell(CELL_TENANT);
				user.setUsername((username != null) ? getCellValue(username, username.getCellType()).trim() : null);
				user.setPassword((password != null) ? getCellValue(password, password.getCellType()).trim() : null);
				user.setRole((role != null) ? getCellValue(role, role.getCellType()).trim() : null);
				user.setDisplayName((displayName != null) ? getCellValue(displayName, displayName.getCellType()).trim() : null);
				user.setTenant((tenant != null) ? getCellValue(tenant, tenant.getCellType()).trim() : null);
				if (!user.getUsername().equalsIgnoreCase("null") && !user.getPassword().equalsIgnoreCase("null") && user.getUsername() != null && user.getPassword() != null)
				{
					if (!user.getRole().equalsIgnoreCase("null") && user.getRole() != null)
					{
						users.add(user);
					}
				}
			}
		}
		catch (FileNotFoundException e)
		{

			e.printStackTrace();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return users;
	}

	public static void removeUserFromList(User user)
	{
		logger.info("RESERVING USER :  " + user);
		if (users != null)
		{
			if (users.contains(user))
			{
				users.remove(user);
			}
		}
		logger.info("Availble Users list : " + users);
	}

	public static void addUserToList(User user)
	{
		logger.info("RELEASING USER :  " + user);
		if (!users.contains(user) && user.getUsername() != null && user.getPassword() != null && !user.getUsername().equalsIgnoreCase("null")
			&& !user.getPassword().equalsIgnoreCase("null"))
		{
			users.add(user);
		}
		else
		{
			logger.info("encountered null user");
		}
		logger.info("Availble Users list : " + users);
	}

	public static User getUserWithSpecificAttribute(Enum_UserList enumType, String attribute)
	{
		logger.info("Availble Users list : " + users);
		for (User user : users)
		{
			switch (enumType)
			{
				case DISPLAY_NAME: {
					if (user.getDisplayName().equalsIgnoreCase(attribute))
					{
						return user;
					}
					break;
				}
				case PASSWORD: {
					if (user.getPassword().equalsIgnoreCase(attribute))
					{
						return user;
					}
					break;
				}

				case ROLE: {
					if (user.getRole().equalsIgnoreCase(attribute))
					{
						return user;
					}
					break;
				}
				case TENANT: {
					if (user.getTenant().equalsIgnoreCase(attribute))
					{
						return user;
					}
					break;
				}
				case USERNAME: {
					if (user.getUsername().equalsIgnoreCase(attribute))
					{
						return user;
					}
					break;
				}
				default: {
					if (user.getUsername().equalsIgnoreCase(attribute))
					{
						return user;
					}
					break;
				}
			}
		}
		return null;
	}

	public static boolean isUserAvaliable(User user)
	{
		logger.info("List of available users :" + users);
		if (users != null)
		{
			return (users.contains(user)) ? true : false;
		}
		else
			return false;

	}

	private static String getCellValue(Cell cell, int cellType)
	{
		switch (cellType)
		{
			case Cell.CELL_TYPE_BOOLEAN: {
				return "" + cell.getBooleanCellValue();
			}
			case Cell.CELL_TYPE_BLANK: {
				return "" + null;
			}
			case Cell.CELL_TYPE_NUMERIC: {
				return "" + cell.getNumericCellValue();
			}
			case Cell.CELL_TYPE_STRING: {
				return cell.getStringCellValue();
			}
			case Cell.CELL_TYPE_ERROR: {
				return "" + cell.getErrorCellValue();
			}
			default: {
				return cell.getStringCellValue();
			}
		}
	}

}
