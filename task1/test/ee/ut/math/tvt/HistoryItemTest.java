package ee.ut.math.tvt;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.HistoryItem;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;

public class HistoryItemTest {

	private SoldItem soldItem1;
	private SoldItem soldItem2;
	private SoldItem soldItem3;
	private List<SoldItem> soldItems;
	private HistoryItem historyItem1;
	private HistoryItem historyItem2;
	private HistoryItem historyItem3;
	private HistoryItem historyItem4;

	@Before
	public void setUp() {

		soldItem1 = new SoldItem(new StockItem(1L, "Walter", "Odav 6lu", 0.5),
				90);
		soldItem2 = new SoldItem(
				new StockItem(2L, "Saku Kuld", "Kehv 6lu", 1.5), 60);
		soldItem3 = new SoldItem(new StockItem(3L, "Corona Extra", "Hea 6lu",
				2.0), 20);
		soldItems = new ArrayList<>();

	}

	@Test
	public void testAddSoldItem() {
		historyItem1 = new HistoryItem(soldItems);
		soldItems.add(soldItem1);
		soldItems.add(soldItem2);
		soldItems.add(soldItem3);
		historyItem1.setSoldGoods(soldItems);

	}

	@Test
	public void testGetSumWithNoItems() {
		historyItem2 = new HistoryItem(soldItems);
		assertEquals(historyItem2.getSum(), 0.0, 1e-7);

	}

	@Test
	public void testGetSumWithOneItem() {
		soldItems.add(soldItem1);
		historyItem3 = new HistoryItem(soldItems);
		assertEquals(historyItem3.getSum(), 45.0, 1e-7);
	}

	@Test
	public void testGetSumWithMultipleItems() {
		soldItems.add(soldItem1);
		soldItems.add(soldItem2);
		soldItems.add(soldItem3);
		historyItem4 = new HistoryItem(soldItems);
		assertEquals(historyItem4.getSum(), 175.0, 1e-7);

	}
}

