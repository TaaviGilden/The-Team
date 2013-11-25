package ee.ut.math.tvt;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.PurchaseInfoTableModel;

public class PurchaseInfoTableModelTest {
	private StockItem stockItem1;
	private SoldItem soldItem1;
	PurchaseInfoTableModel purchaseInfoTableModel;

	@Before
	public void setUp() {
		stockItem1 = new StockItem(1L, "Alexander", "6lu", 2.0, 5);
		soldItem1 = new SoldItem(stockItem1, 5);
		soldItem1.setId(1L);
		purchaseInfoTableModel = new PurchaseInfoTableModel();

	}

	@Test
	public void testAddItem() {

		purchaseInfoTableModel.addItem(soldItem1);

		assertEquals(soldItem1, purchaseInfoTableModel.getItemById(1));
	}

}
