package ee.ut.math.tvt;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;

public class SoldItemTest {
	private StockItem stockItem1;
	private SoldItem soldItem1;
	private SoldItem soldItem2;

	@Before
	public void setUp() {

		stockItem1 = new StockItem(1L, "Saku Tume", "6lu", 2.0);
	}

	@Test
	public void testGetSum() {
		soldItem1 = new SoldItem(stockItem1, 8);
		assertEquals(soldItem1.getSum(), (2.0 * 8), 1e-7);
	}

	@Test
	public void testGetSumWithZeroQuantity() {
		soldItem2 = new SoldItem(stockItem1, 0);
		assertEquals(soldItem2.getSum(), 0, 1e-7);

	}

}

