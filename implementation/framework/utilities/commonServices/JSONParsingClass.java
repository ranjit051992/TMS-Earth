package framework.utilities.commonServices;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import eProc.productUtilities.constants.Constants;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class JSONParsingClass
{
	static Logger						logger	= Logger.getLogger(JSONParsingClass.class);
	public static Map<String, String>	umap	= new HashMap<String, String>();

	public static void getJsonData(String setupName, String tenantName)
	{
		JSONParser parser = new JSONParser();
		try
		{
			logger.info("Fetching configurations for " + setupName.toUpperCase() + " Setup and " + tenantName + " tenant");

			File file = new File("./Resources/RunConfigurations.json");
			String fs = FileUtils.readFileToString(file);
			JSONObject jsonObject = new JSONObject(fs);

			String setupConfig = jsonObject.getJSONObject("Setups").getJSONObject("SetupName").get(setupName.toUpperCase()).toString();

			ObjectMapper mapper = new ObjectMapper();

			JsonNode jsonNode = mapper.createObjectNode();

			jsonNode = mapper.readTree(setupConfig);

			logger.info("Changed Configurations: " + jsonNode);

			jsonParser(jsonNode, tenantName);

		}
		catch (Exception e)
		{
			logger.info(e);
		}
	}

	public static void jsonParser(JsonNode jsonNode, String tenantName)
	{
		Iterator<Map.Entry<String, JsonNode>> objectIterator = jsonNode.fields();
		while (objectIterator.hasNext())
		{

			Map.Entry<String, JsonNode> field = objectIterator.next();
			String fieldKey = field.getKey();

			JsonNode fieldValue = field.getValue();
			Constants.profileConfig.put(fieldKey, fieldValue.asText());

		}
	}

	public static void main(String[] args)
	{
		getJsonData("QCVM", "KATALON_AUTOX");
		String url = Constants.profileConfig.get("URL");
		logger.info("url   : " + url);
	}
}
