package eProc.pages.addItem;

import com.thoughtworks.gauge.Step;
import com.thoughtworks.gauge.datastore.DataStoreFactory;
import eProc.bo.CatalogItemBO;
import eProc.bo.RequisitionBO;
import eProc.keywords.OnlineStoreFlow;
import eProc.pages.onlineStore.OnlineStoreImpl;
import eProc.productUtilities.dataCreation.ObjectCreation;
import framework.utilities.driverFactory.DriverSelector;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;

public class AddItem
{
    public static Logger logger	= Logger.getLogger(AddItem.class);

    @Step("Add Item to Cart on browser <driverKey> for RequisitionBO <requisitionBO> and testcase <testCaseName>")
    public static RequisitionBO addItemToCart(String driverKey, String requisitionBOKey, String testCaseName) throws Exception
    {
        WebDriver driver = null;
        RequisitionBO requisitionBO = null;
        try
        {
            driver = DriverSelector.getDriverFromDataStore(driverKey);
            requisitionBO = (RequisitionBO)DataStoreFactory.getSuiteDataStore().get(requisitionBOKey);
            requisitionBO = ObjectCreation.getDefaultObjectOfRequsition(requisitionBO.getNoOfItem(), requisitionBO.getItemType());
            List<CatalogItemBO> catalogItemList = requisitionBO.getCatalogItemList();
            List<CatalogItemBO> addedCatelogItems = new ArrayList<CatalogItemBO>();

            if (catalogItemList != null)
            {
                for (CatalogItemBO catalogItemBO : catalogItemList)
                {
                   OnlineStoreImpl.addCatalogItemToCart(driverKey,testCaseName,catalogItemBO.getItemName(),catalogItemBO.getQuantity());
                    addedCatelogItems.add(catalogItemBO);
                    logger.info("Catalog item is added to cart.");
                }
            }

        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
            DataStoreFactory.getSuiteDataStore().put(driverKey, driver);
        }

        return requisitionBO;
    }
}
