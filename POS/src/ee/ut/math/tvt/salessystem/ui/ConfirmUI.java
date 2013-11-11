

package ee.ut.math.tvt.salessystem.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;



import org.apache.log4j.Logger;

import ee.ut.math.tvt.salessystem.domain.controller.SalesDomainController;
import ee.ut.math.tvt.salessystem.ui.model.PurchaseInfoTableModel;
import ee.ut.math.tvt.salessystem.ui.tabs.PurchaseTab;
import ee.ut.math.tvt.salessystem.ui.model.SalesSystemModel;


public class ConfirmUI extends JFrame {

	private static final Logger log = Logger.getLogger(PurchaseTab.class);
	private final SalesDomainController domainController;


	public double total;
	public double change;
	public double paymentAmount;
	public JTextField changeText;
	//	public List<SoldItem> a = model.getCurrentPurchaseTableModel().getTableRows();

	private static final long serialVersionUID = 1L;
	private SalesSystemModel model;

	public ConfirmUI(SalesDomainController controller,
			SalesSystemModel model) {

		this.domainController = controller;
		this.model = model;
		total = PurchaseInfoTableModel.totalSum;

		setTitle("");
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension actualSize = getContentPane().getSize();
		setLocation((screen.width - actualSize.width) / 2,
				(screen.height - actualSize.height) / 2);

		Container confirm = getContentPane();
		confirm.setLayout(new GridLayout(4, 2));

		JLabel sumLabel = new JLabel("Total Sum");
		confirm.add(sumLabel);

		JTextField sumText = new JTextField(new Double(total).toString());
		sumText.setEditable(false);
		confirm.add(sumText);

		JLabel paymentLabel = new JLabel("Payment Amount");
		confirm.add(paymentLabel);

		final JTextField paymentField = new JTextField();

		paymentField.getDocument().addDocumentListener(new DocumentListener() {

			@Override
			public void insertUpdate(DocumentEvent e) {
				try {
					paymentAmount = Double.parseDouble(paymentField.getText());

					change = paymentAmount -  total;

					changeText.setText(new Double(change).toString());
				} catch (NumberFormatException e1) {

				}

			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				try {
					paymentAmount = Double.parseDouble(paymentField.getText());

					change = paymentAmount -  total;

					changeText.setText(new Double(change).toString());
				} catch (NumberFormatException e1) {

				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				try {
					paymentAmount = Double.parseDouble(paymentField.getText());

					change = paymentAmount - total;

					changeText.setText(new Double(change).toString());
				} catch (NumberFormatException e1) {

				}
			}

		});
		confirm.add(paymentField);

		JLabel changeLabel = new JLabel("Change");
		confirm.add(changeLabel);

		changeText = new JTextField(new Double(change).toString());
		confirm.add(changeText);
		changeText.setEditable(false);

		JButton accept = new JButton("Accept");
		accept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(total<=paymentAmount&&paymentAmount>=0){
					acceptButtonClicked();
					dispose();
				}
				else{
					JOptionPane.showMessageDialog(null, "Check the Payment Amount field!", "Error", JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});
		confirm.add(accept);

		JButton cancel = new JButton("Cancel");
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		confirm.add(cancel);
		pack();

	}

	protected void acceptButtonClicked() {
		log.info("Sale saved");
		model.getPurchaseHistoryTableModel().addItem(domainController.gethItem());	
		model.getCurrentPurchaseTableModel().clear();
	}
}

