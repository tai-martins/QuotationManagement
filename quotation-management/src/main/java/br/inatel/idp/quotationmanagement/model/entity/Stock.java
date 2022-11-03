package br.inatel.idp.quotationmanagement.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

@Entity
public class Stock {
	
	@Id
	private String id;
	
	private String stockId;
	
	@OneToMany(mappedBy = "stock")
	private List<Quote> quotes = new ArrayList<>();
	
	public Stock() {

	}

	public Stock(String id, String stockId) {
		this.id = id;
		this.stockId = stockId;
	}
	
	@PrePersist
	private void onPersist() {
		generateUUID();
	}

	private void generateUUID() {
		id = UUID.randomUUID().toString();
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public List<Quote> getQuotes() {
		return quotes;
	}

	public void setQuotes(List<Quote> quotes) {
		this.quotes = quotes;
	}
	
	public void addQuote(Quote q) {
		if (this.quotes==null) {
			 this.quotes = new ArrayList<>();
		}
		this.quotes.add( q );
	}

	@Override
	public String toString() {
		return "Stock [id=" + id + ", stockId=" + stockId + "]";
	}

}
