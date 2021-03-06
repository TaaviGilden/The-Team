package ee.ut.math.tvt.salessystem.ui.model;

import java.util.NoSuchElementException;

import org.apache.log4j.Logger;

import ee.ut.math.tvt.salessystem.domain.data.HistoryItem;

public class HistoryTableModel extends SalesSystemTableModel<HistoryItem> {
	private static final long serialVersionUID = 1L;

	private static final Logger log = Logger.getLogger(StockTableModel.class);

	public HistoryTableModel() {
		super(new String[] {"Time", "Date", "Sum", "Details"});
	}

	@Override
	public Object getColumnValue(HistoryItem item, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return item.getTime();
		case 1:
			return item.getDate();
		case 2:
			return item.getSum();
		case 3:
			return "Click for details";
		}
		throw new IllegalArgumentException("Column index out of range");
	}

	/**
	 * Add new stock item to table. If there already is a stock item with
	 * same id, then existing item's quantity will be increased.
	 * @param stockItem
	 */
	public void addItem(final HistoryItem historyItem) {
		rows.add(historyItem);
		fireTableDataChanged();
		log.debug("Added one history item");
	}

}
