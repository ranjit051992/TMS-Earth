package eProc.bo;

import java.util.ArrayList;
import java.util.List;

public class ItemsBO
{
    private List<CatalogItemBO> catalogItemList = new ArrayList<CatalogItemBO>();
   // private List<GuidedItemBO> guidedItemList = new ArrayList<GuidedItemBO>();
   // private List<VirtualItemBO> virtualItemList = new ArrayList<VirtualItemBO>();
   // private List<NonStockItemBO> nonstockItemList = new ArrayList<NonStockItemBO>();
   // private List<StockItemBO> stockItemList = new ArrayList<StockItemBO>();

    public List<CatalogItemBO> getCatalogItemList() {
        return catalogItemList;
    }
    public void setCatalogItemList(List<CatalogItemBO> catalogItemList) {
        this.catalogItemList = catalogItemList;
    }
    /*public List<GuidedItemBO> getGuidedItemList() {
        return guidedItemList;
    }
    public void setGuidedItemList(List<GuidedItemBO> guidedItemList) {
        this.guidedItemList = guidedItemList;
    }
    public List<VirtualItemBO> getVirtualItemList() {
        return virtualItemList;
    }
    public void setVirtualItemList(List<VirtualItemBO> virtualItemList) {
        this.virtualItemList = virtualItemList;
    }
    public List<NonStockItemBO> getNonstockItemList() {
        return nonstockItemList;
    }
    public void setNonstockItemList(List<NonStockItemBO> nonstockItemList) {
        this.nonstockItemList = nonstockItemList;
    }
    public List<StockItemBO> getStockItemList() {
        return stockItemList;
    }
    public void setStockItemList(List<StockItemBO> stockItemList) {
        this.stockItemList = stockItemList;
    }*/
}
