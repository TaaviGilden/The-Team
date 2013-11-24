package ee.ut.math.tvt.salessystem.domain.controller.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import ee.ut.math.tvt.salessystem.domain.controller.SalesDomainController;
import ee.ut.math.tvt.salessystem.domain.data.HistoryItem;
import ee.ut.math.tvt.salessystem.domain.data.SoldItem;
import ee.ut.math.tvt.salessystem.domain.data.StockItem;
import ee.ut.math.tvt.salessystem.domain.exception.VerificationFailedException;
import ee.ut.math.tvt.salessystem.util.HibernateUtil;

/**
 * Implementation of the sales domain controller.
 */
public class SalesDomainControllerImpl implements SalesDomainController {
	
	private Session session = HibernateUtil.currentSession();
	List<HistoryItem> purchaseHistory = new ArrayList<HistoryItem>();

	public HistoryItem hItem;
	
	public void submitCurrentPurchase(List<SoldItem> goods) throws VerificationFailedException {
		// Let's assume we have checked and found out that the buyer is underaged and
		// cannot buy chupa-chups
		//throw new VerificationFailedException("Underaged!");
		// XXX - Save purchase
		hItem = new HistoryItem(goods);
		purchaseHistory.add(hItem);
		session.save(hItem);
		}
	
	public List<HistoryItem> loadHistory() {
		session.createQuery("from SoldItem").list();
		return (List<HistoryItem>)(session.createQuery("from StockItem").list());
	}
	
	public HistoryItem gethItem() {
		return hItem;
	}

	public void cancelCurrentPurchase() throws VerificationFailedException {				
		// XXX - Cancel current purchase
	}
	

	public void startNewPurchase() throws VerificationFailedException {
		// XXX - Start new purchase
	}

	public List<StockItem> loadWarehouseState() {
		// XXX mock implementation
		return (List<StockItem>)(session.createQuery("from StockItem").list());
	}
	
	public void endSession() {
	    HibernateUtil.closeSession();
	}
}
