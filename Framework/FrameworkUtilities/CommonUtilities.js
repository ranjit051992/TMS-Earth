const logger = require("../FrameworkUtilities/Logger/logger");

class CommonUtilities
{
    splitData(index,key)
    {
        let value;
        let mapValue = global.testData.get(key);
        if(typeof mapValue =='undefined')
        {
            logger.info("Getting null from testData for given field : "+key);

        }
        else
        {
            let arrayVal = mapValue.split("||");
            if(index<arrayVal.length)
            {
                value = arrayVal[index];
            }
            else
            {
                value = arrayVal[0];
            }
        }
       
        return value;
    }
}

module.exports = new CommonUtilities();