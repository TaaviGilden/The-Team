package ee.ut.math.tvt;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.Before;
import org.junit.Test;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.StockTableModel;

public class StockTableModelTest {

	private StockItem stockItem1;
	private StockTableModel stockTableModel;

	@Before
	public void setUp() {
		stockItem1 = new StockItem(1l, "Product 1", "First product", 5.0, 10);
		stockTableModel = new StockTableModel();
	}

	@Test
	public void testValidateNameUniqueness() {
		stockTableModel.addItem(stockItem1);
		assertEquals(stockTableModel.getItemById(1l).getName(), "Product 1");
	}

	@Test
	public void testHasEnoughInStock() {
		stockTableModel.addItem(stockItem1);
		assertEquals(stockTableModel.getItemById(1l).getQuantity(), 10, 1e-7);
	}

	@Test
	public void testGetItemByIdWhenItemExists() {
		stockTableModel.addItem(stockItem1);
		assertEquals(stockTableModel.getItemById(1l).getId(), 1l, 1e-7);
	}

	// ??
	@Test(expected = NoSuchElementException.class)
	public void testGetItemByIdWhenThrowsException() {
		stockTableModel.addItem(stockItem1);
		assertEquals(stockTableModel.getItemById(1l).getId(), 1l, 1e-7);
	}

}
