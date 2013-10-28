

package ee.ut.math.tvt.salessystem.ui.model;


import java.util.NoSuchElementException;

import org.apache.log4j.Logger;

import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.ui.SalesSystemUI;

/**
 * Purchase history details model.
 */
public class PurchaseInfoTableModel extends SalesSystemTableModel<SoldItem> {

	int totalQuantity;
	public static double totalSum = 0.0;

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(PurchaseInfoTableModel.class);

	public PurchaseInfoTableModel() {
		super(new String[] { "Id", "Name", "Price", "Quantity", "Sum"});
	}

	@Override
	protected Object getColumnValue(SoldItem item, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return item.getId();
		case 1:
			return item.getName();
		case 2:
			return item.getPrice();
		case 3:
			return item.getQuantity();
		case 4:
			return item.getSum();
		}
		throw new IllegalArgumentException("Column index out of range");
	}

	@Override
	public String toString() {
		final StringBuffer buffer = new StringBuffer();

		for (int i = 0; i < headers.length; i++)
			buffer.append(headers[i] + "\t");
		buffer.append("\n");

		for (final SoldItem item : rows) {
			buffer.append(item.getId() + "\t");
			buffer.append(item.getName() + "\t");
			buffer.append(item.getPrice() + "\t");
			buffer.append(item.getQuantity() + "\t");
			buffer.append(item.getSum() + "\t");
			buffer.append("\n");
		}

		return buffer.toString();
	}

	/**
	 * Add new StockItem to table.
	 */
	public void addItem(final SoldItem item) {
		/**
		 * XXX In case such stockItem already exists increase the quantity of the
		 * existing stock.
		 */

		boolean exists = false;

		if (rows.size() == 0){
			rows.add(item);

		} else {
			for (int i = 0; i < rows.size(); i++){
				if (rows.get(i).getStockItem().getId() == item.getStockItem().getId()){
					exists = true;
					totalQuantity = rows.get(i).getQuantity() + item.getQuantity();
					rows.get(i).setQuantity(totalQuantity);
				}

			}if (!exists) {
				rows.add(item);
			}
		}

		log.debug("Added " + item.getName() + " quantity of " + item.getQuantity());
		fireTableDataChanged();
		totalSum = 0.0;
		
		for (int i = 0; i < rows.size(); i++) {
			totalSum = totalSum + (rows.get(i).getSum());
		}

	}
}
