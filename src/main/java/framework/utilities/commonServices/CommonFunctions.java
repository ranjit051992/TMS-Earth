package framework.utilities.commonServices;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

public class CommonFunctions
{
	public static Logger				logger		= Logger.getLogger(CommonFunctions.class);
	public static Map<String, String>	UiElements	= new HashMap<String, String>();

	public static void getUiElements() throws Exception
	{
		try
		{

			Connection con = null;
			String query = null;;
			Statement stmt = null;
			ResultSet rs = null;
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://192.168.5.221:3306/katalon_repo", "katalonteam", "team@123");
				query = "SELECT PAGE_NAME,ELEMENT_NAME,ELEMENT_VALUE FROM `eProc_UI_Elements`;";
				stmt = con.createStatement();
				rs = stmt.executeQuery(query);
				if (rs != null)
				{
					while (rs.next())
					{
						String elementKey = rs.getString("PAGE_NAME") + "/" + rs.getString("ELEMENT_NAME");
						String elementValue = rs.getString("ELEMENT_VALUE");
						UiElements.put(elementKey, elementValue);
					}
				}

			}
			catch (Exception e)
			{
				logger.error("Exception in getUiElements method", e);
			}
			finally
			{
				con.close();
			}

		}
		catch (Exception e)
		{
			throw e;
		}

	}

	public static void main(String[] args)
	{
		try
		{
			getUiElements();
			logger.info(UiElements.size());
			logger.info(UiElements.toString());
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
