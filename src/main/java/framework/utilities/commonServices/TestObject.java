package framework.utilities.commonServices;

import org.apache.cxf.jaxrs.ext.search.ConditionType;

public class TestObject
{
	private String elementType = "";
	private String elementValue = "";
	private ConditionType condition = null;

	public void addProperty(String elementType, ConditionType conditionType, String elementValue)
	{
		this.elementType = elementType;
		this.elementValue = elementValue;
		this.condition = conditionType;
	}

	public String findPropertyValue(String elementType)
	{
		return this.elementValue;
	}

}
