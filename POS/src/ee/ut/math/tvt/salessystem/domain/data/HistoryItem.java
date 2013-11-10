package ee.ut.math.tvt.salessystem.domain.data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import ee.ut.math.tvt.salessystem.ui.model.PurchaseInfoTableModel;

public class HistoryItem implements Cloneable, DisplayableItem, ActionListener  {

//	private Long id;
	private String date;
	private String time;
	private List<SoldItem> soldGoods;

	public HistoryItem(Long id, String date, String time,
			List<SoldItem> soldGoods) {
		super();
//		this.id = id;
		this.date = date;
		this.time = time;
		this.soldGoods = soldGoods;
	}

	public JButton Details() {
		JButton Details = new JButton("Details");
		Details.addActionListener(this);
		return Details;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		Houston, we need a window.
	}
	
	public static String getDate() {
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		Date date = new Date();
		String currentDate = dateFormat.format(date);	
		return currentDate;
	}

	public static String getTime() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		String time = timeFormat.format(cal.getTime());
		return time;
	}

	public JButton getDetails() {
		return Details();
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

}
