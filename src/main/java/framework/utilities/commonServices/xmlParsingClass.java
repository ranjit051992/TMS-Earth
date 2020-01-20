
package framework.utilities.commonServices;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import product.keywords.logout.Logout;

public class xmlParsingClass
{
	public static Logger logger = Logger.getLogger(xmlParsingClass.class);

	public static String getValue(String tag, Element element)
	{
		NodeList nodes = element.getElementsByTagName(tag).item(0).getChildNodes();
		Node node = (Node) nodes.item(0);
		return node.getNodeValue();
	}

	public static List<String> fetchingTestcasesList(String suiteName) throws Exception
	{

		List<String> testCase = new ArrayList<String>();
		File stocks = new File(suiteName);
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(stocks);
		doc.getDocumentElement().normalize();

		logger.info(doc.getDocumentElement().getNodeName());
		NodeList nodes = doc.getElementsByTagName("testCaseLink");

		for (int i = 0; i < nodes.getLength(); i++)
		{
			Node node = nodes.item(i);
			if (node.getNodeType() == Node.ELEMENT_NODE)
			{
				Element element = (Element) node;
				String testcaseId = getValue("testCaseId", element);
				String[] path = testcaseId.split("/");
				String Jiraid = path[path.length - 1];
				if ((getValue("isRun", element)).equals("true"))
				{
					testCase.add(Jiraid);
				}
				else
				{
					logger.info("WARNING : Flag is set False for " + Jiraid + " it will not execute in Suitew execution.");
				}
			}
		}
		return testCase;
	}
}
