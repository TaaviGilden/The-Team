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

	private Long id;
	private String date;
	private String time;
	private static List<SoldItem> soldGoods;
	private String detailid;

	public HistoryItem(String date, String time,
			List<SoldItem> soldGoods) {
		super();
		this.date = date;
		this.time = time;
		this.detailid = "Detailid";
		this.soldGoods = soldGoods;
	}

	public JButton getDetails() {
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

	public Long getId() {
		return null;
	}
	
	public static List<SoldItem> getSoldGoods() {
		return soldGoods;
	}

	@Override
	public String toString() {
		return "HistoryItem [id=" + id + ", date=" + date + ", time=" + time
				+ ", soldGoods=" + soldGoods.toString() + ", detailid=" + detailid + "]";
	}

	public String getDetailid() {
		return detailid;
	}

}
