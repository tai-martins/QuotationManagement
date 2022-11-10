package br.inatel.idp.quotationmanagement.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

/**
 * Quote Class. 
 * 
 * @author Tainara Martins.
 * @since November 2022
 */

@Entity
public class Quote {
	
	/**creation of the id, stock, date and price variables */
	@Id
	private String id;
	@ManyToOne
	private Stock stock;
	private LocalDate date;
	private BigDecimal price;
	
	/** Empty constructor StockQuoteDto */
	public Quote() {

	}

	/**
	 * Constructor that receives all parameters
	 * 
	 * @param stock
	 * @param date
	 * @param price
	 */
	public Quote(Stock stock, LocalDate date, BigDecimal price) {
		this.stock = stock;
		this.date = date;
		this.price = price;
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
	 * 
	 * @param id the new id
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * Gets the stock
	 * 
	 * @return stock
	 */
	public Stock getStock() {
		return stock;
	}

	/**
	 * Sets the stock
	 * 
	 * @param stock the new stock
	 */
	public void setStock(Stock stock) {
		this.stock = stock;
	}

	/**
	 * Gets the date
	 * 
	 * @return date the new date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * Sets the date
	 * 
	 * @param date the new date
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * Gets the Price 
	 * 
	 * @return price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * Sets the price 
	 * 
	 * @param price the new price
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Quote [id=" + id + ", date=" + date + ", price=" + price + "]";
	}
	
	
	
	
}
