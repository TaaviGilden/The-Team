package ee.ut.math.tvt;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.HistoryItem;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.HistoryTableModel;

public class HistoryTableModelTest {
	private SoldItem soldItem1;
	private List<SoldItem> soldItems;
	private HistoryItem historyItem1;
	private HistoryTableModel historyTableModel;

	@Before
	public void setUp() {
		soldItem1 = new SoldItem(
				new StockItem(1L, "Product1", "Something", 2.5), 90);
		soldItems = new ArrayList<>();
		soldItems.add(soldItem1);
		historyItem1 = new HistoryItem(soldItems);
		historyTableModel = new HistoryTableModel();
		historyTableModel.addItem(historyItem1);
	}

	@Test
	public void testGetSum() {
		assertEquals(historyItem1.getSum(),
				historyTableModel.getColumnValue(historyItem1, 2));
	}

}
