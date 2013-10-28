package ee.ut.math.tvt.salessystem.domain.data;

import java.util.Date;
import java.util.List;

public class HistoryItem {

	private String date;
	private String time;
	private List<SoldItem> soldGoods;
	
	public HistoryItem(String date, String time2, List<SoldItem> soldGoods) {
		super();
		this.date = date;
		this.time = time2;
		this.soldGoods = soldGoods;
	}
	
	
}
