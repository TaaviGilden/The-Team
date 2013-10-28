

package ee.ut.math.tvt.salessystem.ui.tabs;

import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.ui.model.PurchaseInfoTableModel;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;
import ee.ut.math.tvt.salessystem.ui.panels.PurchaseItemPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.JTableHeader;

import org.apache.log4j.Logger;


public class StockTab {

	private static final Logger log = Logger.getLogger(StockTab.class);

	private JButton addItem;

	private SalesSystemModel model;

	public StockTab(SalesSystemModel model) {
		this.model = model;
	}

	// warehouse stock tab - consists of a menu and a table
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

		panel.add(drawStockMenuPane(), gc);

		gc.weighty = 1.0;
		gc.fill = GridBagConstraints.BOTH;
		panel.add(drawStockMainPane(), gc);
		return panel;
	}

	// warehouse menu
	private Component drawStockMenuPane() {
		JPanel panel = new JPanel();

		GridBagConstraints gc = new GridBagConstraints();
		GridBagLayout gb = new GridBagLayout();

		panel.setLayout(gb);

		gc.anchor = GridBagConstraints.NORTHWEST;
		gc.weightx = 0;

		addItem = new JButton("Add");
		addItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  
				//JOptionPane.showInputDialog("Add item:");
				addNewItem();
			}
		});
		gc.gridwidth = GridBagConstraints.RELATIVE;
		gc.weightx = 1.0;
		panel.add(addItem, gc);

		panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		return panel;
	}


	// table of the wareshouse stock
	private Component drawStockMainPane() {
		JPanel panel = new JPanel();

		JTable table = new JTable(model.getWarehouseTableModel());

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

		panel.setBorder(BorderFactory.createTitledBorder("Warehouse status"));
		return panel;
	}

	public void addNewItem(){
		final JFrame addNewItemFrame = new JFrame();
		addNewItemFrame.setTitle("Add new item to the warehouse");
		//addNewItemFrame.setResizable(false);
		//addNewItemFrame. setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension actualSize = addNewItemFrame.getContentPane().getSize();
		addNewItemFrame.setLocation((screen.width - actualSize.width) / 2,
				(screen.height - actualSize.height) / 2);
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(7, 2));


		panel.add(new JLabel("Id"));
		final JTextField id = new JTextField();
		panel.add(id);
		panel.add(new JLabel("Name"));
		final JTextField name = new JTextField();
		panel.add(name);
		panel.add(new JLabel("Description"));
		final JTextField description = new JTextField();
		panel.add(description);
		panel.add(new JLabel("Price"));
		final JTextField price = new JTextField();
		panel.add(price);

		panel.add(new JLabel("Quantity"));
		final JTextField quantity = new JTextField();
		panel.add(quantity);

		JButton submit = new JButton("Submit");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {String nametext = name.getText();
				String descriptiontext = description.getText();;
				long idtext = Long.parseLong(id.getText());
				double pricetext = Double.parseDouble(price.getText());
				int quantitytext = Integer.parseInt(quantity.getText());

				if (pricetext < 0) throw new ParseException("loll", 0);
				if (idtext < 0) throw new ParseException("asi", 0);
				if (quantitytext < 0) throw new ParseException("asfdsi", 0);
				StockItem descr = new StockItem(idtext, nametext, descriptiontext, pricetext, quantitytext);
				System.out.println(descr);
				model.getWarehouseTableModel().addItem(descr);
				PurchaseItemPanel.nameField.removeAllItems();
			    
			    for (StockItem item : model.getWarehouseTableModel().getTableRows()) {
			          
			     PurchaseItemPanel.nameField.addItem(item);
			    }

				log.debug("Added new item to the warehouse");

				addNewItemFrame.dispose();
				} catch (ParseException p){
					JOptionPane.showMessageDialog(null,
							"Incorrect data!", "Warning",
							JOptionPane.WARNING_MESSAGE);

				} catch (NumberFormatException o){
					JOptionPane.showMessageDialog(null,
							"Incorrect data!", "Warning",
							JOptionPane.WARNING_MESSAGE);

				}

			}
		});

		panel.add(submit);

		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				addNewItemFrame.dispose();

			}
		});

		panel.add(cancel);

		addNewItemFrame.add(panel);
		addNewItemFrame.pack();
		addNewItemFrame.setVisible(true);

	}

}

