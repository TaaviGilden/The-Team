package ee.ut.math.tvt.salessystem.ui.model;

import java.util.List;

import org.apache.log4j.Logger;

import ee.ut.math.tvt.salessystem.domain.controller.SalesDomainController;
import ee.ut.math.tvt.salessystem.domain.controller.impl.SalesDomainControllerImpl;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;

/**
 * Main model. Holds all the other models.
 */
public class SalesSystemModel {
    
    private static final Logger log = Logger.getLogger(SalesSystemModel.class);

    // Warehouse model
    private StockTableModel warehouseTableModel;
    // History model
    public HistoryTableModel purchaseHistoryTableModel;
    // Current shopping cart model
    private PurchaseInfoTableModel currentPurchaseTableModel;
    // HistoryItem model
    private PurchaseInfoTableModel historyItemModel;

    private final SalesDomainController domainController;
    

    /**
     * Construct application model.
     * @param domainController Sales domain controller.
     */
    public SalesSystemModel(SalesDomainController domainController) {
        this.domainController = domainController;
        
        warehouseTableModel = new StockTableModel();
        purchaseHistoryTableModel = new HistoryTableModel();
        currentPurchaseTableModel = new PurchaseInfoTableModel();
        historyItemModel = new PurchaseInfoTableModel();
        // populate stock model with data from the warehouse
        warehouseTableModel.populateWithData(domainController.loadWarehouseState());
//        historyItemModel.populateWithData(domainController.loadHistory().get(index));
    }

    public StockTableModel getWarehouseTableModel() {
        return warehouseTableModel;
    }
    
    public HistoryTableModel getHistoryTableModel() {
    	return purchaseHistoryTableModel;
    }

    public PurchaseInfoTableModel getCurrentPurchaseTableModel() {
        return currentPurchaseTableModel;
    }
    public PurchaseInfoTableModel gethistoryItemModel(List<SoldItem> historyItems) {
    	historyItemModel.populateWithData(historyItems);
    	return historyItemModel;
    }
    
    
    
}
