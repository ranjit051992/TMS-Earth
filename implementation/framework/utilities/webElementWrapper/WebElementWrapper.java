package framework.utilities.webElementWrapper;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class WebElementWrapper
{

    public static Logger logger			= Logger.getLogger(WebElementWrapper.class);
    public static Map<String, By>		UiElements		= new HashMap<String, By>();
    public static Map<String, String> UiElementsXpath	= new HashMap<String, String>();

    public static void main(String[] args) throws Exception
    {
        UiElements = getUIElements();
        logger.info("Map size " + UiElements.size());
        logger.info("Map value " + UiElements.toString());
    }

    /**
     * @author priyanka.ingale
     * @description getUIElements return a Map with UI_ElementName as Key and
     *              UI_ElementValue as By object value
     * @return Map
     */
    public static Map<String, By> getUIElements() throws Exception
    {
        Map<String, By> uiElementmap = new LinkedHashMap<String, By>();
        try
        {

            Connection con = null;
            String query = null;
            ;
            Statement stmt = null;
            ResultSet rs = null;
            By findBy = null;

            try
            {
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://192.168.5.221:3306/katalon_repo", "katalonteam", "team@123");
                query = "SELECT PAGE_NAME,ELEMENT_NAME,ELEMENT_VALUE, ELEMENT_TYPE FROM `eProc_UI_Elements`;";
                stmt = con.createStatement();
                rs = stmt.executeQuery(query);
                if (rs != null)
                {
                    while (rs.next())
                    {
                        String elementKey = rs.getString("PAGE_NAME") + "/" + rs.getString("ELEMENT_NAME");
                        String elementValue = rs.getString("ELEMENT_VALUE");
                        String elemetType = rs.getString("ELEMENT_TYPE");

                        findBy = elementValue(elemetType, elementValue);
                        uiElementmap.put(elementKey, findBy);

                        UiElementsXpath.put(elementKey, elementValue);
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
        return uiElementmap;

    }

    /**
     * @author priyanka.ingale
     * @description elementValue return a By which locates locatorValue via
     *              locatorType
     * @param locatorType,
     *            locatorValue
     * @return By object
     */
    public static By elementValue(String locatorType, String locatorValue) throws Exception
    {
        try
        {
            By findBy = null;
            if (locatorType.equalsIgnoreCase("XPATH"))
            {
                findBy = By.xpath(locatorValue);
            }

            else if (locatorType.equalsIgnoreCase("ID"))
            {
                findBy = By.id(locatorValue);
            }

            else if (locatorType.equalsIgnoreCase("NAME"))
            {
                findBy = By.name(locatorValue);
            }

            else if (locatorType.equalsIgnoreCase("CLASS"))
            {
                findBy = By.className(locatorValue);
            }

            else if (locatorType.equalsIgnoreCase("TAGNAME"))
            {
                findBy = By.tagName(locatorValue);
            }

            else if (locatorType.equalsIgnoreCase("CSSSeclector"))
            {
                findBy = By.cssSelector(locatorValue);
            }

            return findBy;
        }

        catch (Exception e)
        {
            throw e;
        }

    }

    /**
     * @author priyanka.ingale
     * @description getElement return a By object of elementName
     * @param elementName
     * @return By object
     */

    public static By getElement(String elementName)
    {
        return UiElements.get(elementName);

    }

    public static String getXpath(String elementPath)
    {
        return UiElementsXpath.get(elementPath);

    }

}
