package br.inatel.idp.quotationmanagement.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.inatel.idp.quotationmanagement.model.entity.Stock;

/**
 * StockQuoteDto Class. Convert stocks to stockQuotesDto
 * 
 * @author Tainara Martins.
 * @since November 2022
 */
public class StockQuoteDto {
	
	/** creation of the id and stockId variables */
	private String id;
	private String stockId;
	
	/** The quotes */
	private Map<LocalDate, BigDecimal> quotes = new HashMap<>();

	/** Empty constructor StockQuoteDto */
	public StockQuoteDto() {

	}
	
	/**
	 * Constructor that receives all parameters
	 * 
	 * @param sq
	 */
	public StockQuoteDto(Stock sq) {
		this.id = sq.getId();
		this.stockId = sq.getStockId();
		sq.getQuotes().stream().forEach(quote -> quotes.put(quote.getDate(), quote.getPrice()));
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
	 * Gets the Quotes
	 * 
	 * @return quotes
	 */
	public Map<LocalDate, BigDecimal> getQuotes() {
		return quotes;
	}
	
	/**
	 * Sets the Quotes 
	 * 
	 * @param quotes the new quotes
	 */
	public void setQuotes(Map<LocalDate, BigDecimal> quotes) {
		this.quotes = quotes;
	}
	
	/**
	 * method that converts a quote map into a quote list
	 * 
	 * @return a StockQuoteDto List 
	 */
	public static List<StockQuoteDto> convertTo(List<Stock> stocks) {
		return stocks.stream().map(StockQuoteDto::new).collect(Collectors.toList());
	}

	
}