package ee.ut.math.tvt.salessystem.domain.data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "HistoryItem")
public class HistoryItem implements Cloneable, DisplayableItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "date")
	private String date;
	@Column(name = "time")
	private String time;
	@Column(name = "totalSum")
	private double sum = 0;
	@OneToMany(mappedBy = "Id")
	private List<SoldItem> soldGoods;


	public HistoryItem(List<SoldItem> soldGoods) {
		super();
		this.date = Date();
		this.time = Time();
		this.soldGoods = soldGoods;
		for (SoldItem soldItem : soldGoods) {
			sum += soldItem.getSum();
		}

	}

	public String getDate() {
		return date;
	}

	public String getTime() {
		return time;
	}

	public String Date() {
		DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
		Date date = new Date();
		String currentDate = dateFormat.format(date);	
		return currentDate;
	}

	public String Time() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		String time = timeFormat.format(cal.getTime());
		return time;
	}

	public Long getId() {
		return null;
	}

	public List<SoldItem> getSoldGoods() {
		return soldGoods;
	}

	@Override
	public String toString() {
		return "HistoryItem [id=" + id + ", date=" + date + ", time=" + time
				+ ", soldGoods=" + soldGoods + "]";
	}

	public double getSum() {
		return sum;
	}

}
