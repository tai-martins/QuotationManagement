package br.inatel.idp.quotationmanagement.model.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

/**
 * Stock Class. 
 * 
 * @author Tainara Martins.
 * @since November 2022
 */

@Entity
public class Stock{
	
	/** creation of the id and stockId variables */
	@Id
	private String id;
	private String stockId;
	
	/** creation of the quotes List */
	@OneToMany(mappedBy = "stock")
	private List<Quote> quotes = new ArrayList<>();
	
	/** Empty constructor StockQuoteDto */
	public Stock() {

	}

	/**
	 * Constructor that receives the parameter stockId
	 * 
	 * @param stockId
	 */
	public Stock(String stockId) {
		this.stockId = stockId;
	}

	/**
	 * Constructor that receives all parameters
	 * 
	 * @param id
	 * @param stockId
	 */
	public Stock(String id, String stockId) {
		this.id = id;
		this.stockId = stockId;
	}
	
	/** call the method that generates id */
	@PrePersist
	private void onPersist() {
		generateUUID();
	}

	/** method that generates an id */
	private void generateUUID() {
		id = UUID.randomUUID().toString();
		
	}

	/**
	 * Gets the id
	 * 
	 * @return id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Sets the id
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the stockId
	 * 
	 * @return stockId
	 */
	public String getStockId() {
		return stockId;
	}

	/**
	 * Sets the stockId
	 * 
	 * @param stockId the new stockId
	 */
	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	/**
	 * Gets the quotes List
	 * 
	 * @return quotes
	 */
	public List<Quote> getQuotes() {
		return quotes;
	}

	/**
	 * Sets the quotes list
	 * 
	 * @param quotes
	 */
	public void setQuotes(List<Quote> quotes) {
		this.quotes = quotes;
	}
	
	/**
	 * method to add a quote to the list
	 * 
	 * @param q
	 */
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
