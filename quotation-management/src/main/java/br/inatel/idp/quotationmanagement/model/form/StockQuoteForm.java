package br.inatel.idp.quotationmanagement.model.form;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.inatel.idp.quotationmanagement.model.entity.Quote;
import br.inatel.idp.quotationmanagement.model.entity.Stock;

/**
 * StockQuoteForm class
 * @author Tainara Martins.
 * @since November 2022
 */

public class StockQuoteForm {

	/** stockId variable */
	@NotNull @NotEmpty @Length(min = 2)
	private String stockId;
	
	/** The quotesMap */
	private Map<LocalDate, BigDecimal> quotesMap = new HashMap<>();

	/**
	 * Gets the stock id
	 * 
	 * @return the stockId
	 */
	public String getStockId() {
		return stockId;
	}

	/**
	 * Sets the stock id
	 * 
	 * @param stockId the new stock id
	 */
	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	/**
	 * Gets the quotes Map
	 * 
	 * @return the quotesMap
	 */
	public Map<LocalDate, BigDecimal> getQuotesMap() {
		return quotesMap;
	}

	/**
	 * Sets the quotes Map
	 * 
	 * @param quotesMap the new quotes Map
	 */
	public void setQuotesMap(Map<LocalDate, BigDecimal> quotesMap) {
		this.quotesMap = quotesMap;
	}

	/**
	 * Instantiates a new stock quote form
	 * 
	 * @param stockId
	 * @param quotesMap
	 */
	public StockQuoteForm(@NotNull @NotEmpty @Length(min = 2) String stockId, Map<LocalDate, BigDecimal> quotesMap) {
		this.stockId = stockId;
		this.quotesMap = quotesMap;
	}
	
	/**
	 * Add quotes to stock list 
	 * 
	 * @param stock
	 * @return the stock List
	 */
	public List<Quote> addQuotesList(Stock stock){
		List<Quote> quotes = new ArrayList<>();
		quotesMap.forEach((date, price) -> {
			Quote quote = new Quote(stock, date, price);
			quotes.add(quote);
			stock.setQuotes(quotes);
		});
		return stock.getQuotes();
	}
	
	/**
	 * convertTo method
	 * 
	 * @return a new Stock
	 */
	public Stock convertTo() {
		return new Stock(stockId);
	}
	
}
