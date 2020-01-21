package eProc.pages.addItem;

import com.thoughtworks.gauge.Step;
import eProc.bo.CatalogItemBO;
import eProc.bo.RequisitionBO;
import eProc.keywords.OnlineStoreFlow;
import eProc.pages.onlineStore.OnlineStoreImpl;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class AddItem
{
    public static Logger logger	= Logger.getLogger(AddItem.class);

   // @Step(Add Item to Cart )
    public static RequisitionBO addItemToCart(WebDriver driver, RequisitionBO requisitionBO, String testCaseName) throws Exception
    {
        try
        {
            List<CatalogItemBO> catalogItemList = requisitionBO.getCatalogItemList();
            List<CatalogItemBO> addedCatelogItems = new ArrayList<CatalogItemBO>();

            if (catalogItemList != null)
            {
                for (CatalogItemBO catalogItemBO : catalogItemList)
                {
                   // OnlineStoreImpl.addCatalogItemToCart(driver,testCaseName,catalogItemBO.getItemName(),catalogItemBO.getQuantity());
                    addedCatelogItems.add(catalogItemBO);
                    logger.info("Catalog item is added to cart.");
                }
            }

        }
        catch (Exception e)
        {
            throw e;
        }

        return requisitionBO;
    }
}
