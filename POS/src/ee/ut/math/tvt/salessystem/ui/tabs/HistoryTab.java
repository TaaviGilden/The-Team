package ee.ut.math.tvt.salessystem.ui.tabs;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;

/**
 * Encapsulates everything that has to do with the purchase tab (the tab
 * labelled "History" in the menu).
 */
public class HistoryTab {

	// TODO - implement!
	private SalesSystemModel model;

	public HistoryTab(SalesSystemModel model) {
		this.model = model;
	}

	public HistoryTab() {
	} 

	public Component draw() {	
		JPanel panel = new JPanel();
		
	    JTable table = new JTable(model.getHistoryTableModel());
	    JTableHeader header = table.getTableHeader();
		header.setReorderingAllowed(false);
		JScrollPane scrollPane = new JScrollPane(table);
	    
	    panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	    GridBagLayout gb = new GridBagLayout();
	    GridBagConstraints gc = new GridBagConstraints();
	    panel.setLayout(gb);
	    panel.add(table);
	    panel.add(scrollPane);
	    gc.weighty = 1.0;
	    gc.fill = GridBagConstraints.BOTH;
	    return panel;
	}
}