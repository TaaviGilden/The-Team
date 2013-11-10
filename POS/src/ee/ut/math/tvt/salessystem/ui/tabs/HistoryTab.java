package ee.ut.math.tvt.salessystem.ui.tabs;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.JTableHeader;

import ee.ut.math.tvt.salessystem.domain.controller.SalesDomainController;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;

/**
 * Encapsulates everything that has to do with the purchase tab (the tab
 * labelled "History" in the menu).
 */
public class HistoryTab {
	private final SalesDomainController domainController;
	// TODO - implement!
	private SalesSystemModel model;

	public HistoryTab(SalesDomainController controller, SalesSystemModel model) {
		this.model = model;
		this.domainController = controller;
	}

	public HistoryTab(SalesDomainController controller) {
		this.domainController = controller;
	} 

	public Component draw() {
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gc = new GridBagConstraints();
		panel.setLayout(gb);

		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.anchor = GridBagConstraints.NORTH;
		gc.gridwidth = GridBagConstraints.REMAINDER;
		gc.weightx = 1.0d;
		gc.weighty = 0d;

		gc.weighty = 1.0;
		gc.fill = GridBagConstraints.BOTH;
		panel.add(drawHistoryMainPane(), gc);
		return panel;
	}

	private Component drawHistoryMainPane() {
		JPanel panel = new JPanel();

		JTable table = new JTable(model.getHistoryTableModel());

		JTableHeader header = table.getTableHeader();
		header.setReorderingAllowed(false);

		JScrollPane scrollPane = new JScrollPane(table);

		GridBagConstraints gc = new GridBagConstraints();
		GridBagLayout gb = new GridBagLayout();
		gc.fill = GridBagConstraints.BOTH;
		gc.weightx = 1.0;
		gc.weighty = 1.0;

		panel.setLayout(gb);
		panel.add(scrollPane, gc);

		panel.setBorder(BorderFactory.createTitledBorder("History status"));

		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					JTable target = (JTable)e.getSource();
					int row = target.getSelectedRow();
					int column = target.getSelectedColumn();
					if (column == 2) {

						System.out.println(domainController.loadHistory().get(row).getSoldGoods());
						List<SoldItem> historyList = domainController.loadHistory().get(row).getSoldGoods();
						historyEntry(historyList);
					}
				}
			}
		});	
		return panel;
	}

	public void historyEntry(List<SoldItem> historyList) {
		JFrame historyEntry = new JFrame();
		historyEntry.setTitle("History entry");
		JPanel panel = new JPanel();
		
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension actualSize = historyEntry.getContentPane().getSize();
		historyEntry.setLocation((screen.width - actualSize.width) / 2,
				(screen.height - actualSize.height) / 2);
		
		
		
		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		GridBagLayout gb = new GridBagLayout();
		GridBagConstraints gc = new GridBagConstraints();
		panel.setLayout(gb);

		gc.fill = GridBagConstraints.HORIZONTAL;
		gc.anchor = GridBagConstraints.NORTH;
		gc.gridwidth = GridBagConstraints.REMAINDER;
		gc.weightx = 1.0d;
		gc.weighty = 0d;

		gc.weighty = 1.0;
		gc.fill = GridBagConstraints.BOTH;
		historyEntry.add(panel);
		panel.add(historyEntryContent(historyList), gc);
		historyEntry.pack();
		historyEntry.setVisible(true);
	}
	public Component historyEntryContent(List<SoldItem> historyList) {
		JPanel panel = new JPanel();
		JTable historyItemsTable = new JTable(model.gethistoryItemModel(historyList));

		JTableHeader header = historyItemsTable.getTableHeader();
		header.setReorderingAllowed(false);

		JScrollPane scrollPane = new JScrollPane(historyItemsTable);

		GridBagConstraints gc = new GridBagConstraints();
		GridBagLayout gb = new GridBagLayout();
		gc.fill = GridBagConstraints.BOTH;
		gc.weightx = 1.0;
		gc.weighty = 1.0;

		panel.setLayout(gb);
		panel.add(scrollPane, gc);

//		panel.setBorder(BorderFactory.createTitledBorder("History status"));

		return panel;
	}

}