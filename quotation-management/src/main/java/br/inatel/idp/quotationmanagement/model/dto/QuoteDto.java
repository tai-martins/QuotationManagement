package br.inatel.idp.quotationmanagement.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.inatel.idp.quotationmanagement.model.entity.Quote;

/**
 * QuoteDto Class. Data transfer for Stock and your Quotes
 * 
 * @author Tainara Martins.
 * @since November 2022
 */
public class QuoteDto {
	
	/** creation of the id, stock, stockId, date and price variables */
	private String id;
	private String stock;
	private String stockId;
	private LocalDate date;
	private BigDecimal price;
	
	/**
	 * Constructor that receives all parameters
	 * 
	 * @param quote
	 */
	public QuoteDto(Quote quote) {
		this.id = quote.getId();
		this.stock = quote.getStock().getId();
		this.stockId = quote.getStock().getStockId();
		this.date = quote.getDate();
		this.price = quote.getPrice();
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
	public String getStock() {
		return stock;
	}

	/**
	 * Sets the Stock
	 * 
	 * @param stock the new stock
	 */
	public void setStock(String stock) {
		this.stock = stock;
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
	 * Gets the Date
	 * 
	 * @return date 
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * Sets the Date
	 * @param date the new date
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * Gets the price 
	 * 
	 * @return price
	 */
	public BigDecimal getPrice() {
		return price;
	}

	/**
	 * Sets the price
	 * @param price the new price
	 */
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	/**
	 * convertTo method that converts quote map to quote list
	 * 
	 * @return a quotes List 
	 */
	public static List<QuoteDto> convert(List<Quote> quotes) {
		return quotes.stream().map(QuoteDto::new).collect(Collectors.toList());
	}
	
	
}
