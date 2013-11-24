package ee.ut.math.tvt;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;

public class StockItemTest {
	private StockItem stockItem1;

	@Before
	public void setUp() {
		stockItem1 = new StockItem(1L, "Tuborg", "Õlu", 2.0, 10);
	}

	@Test
	public void testClone() {
		assertEquals(stockItem1.clone().getClass(), stockItem1.getClass());
	}

	@Test
	public void testGetColumn() {
		assertEquals(stockItem1.getColumn(0), 1L);
		assertEquals(stockItem1.getColumn(1), "Tuborg");
		assertEquals(stockItem1.getColumn(2), 2.0);
		assertEquals(stockItem1.getColumn(3), 10);

	}
}

