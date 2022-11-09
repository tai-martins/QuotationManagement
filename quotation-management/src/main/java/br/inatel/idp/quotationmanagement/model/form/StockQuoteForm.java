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

	@NotNull @NotEmpty @Length(min = 2)
	private String stockId;
	
	private Map<LocalDate, BigDecimal> quotesMap = new HashMap<>();

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public Map<LocalDate, BigDecimal> getQuotesMap() {
		return quotesMap;
	}

	public void setQuotesMap(Map<LocalDate, BigDecimal> quotesMap) {
		this.quotesMap = quotesMap;
	}

	public StockQuoteForm(@NotNull @NotEmpty @Length(min = 2) String stockId, Map<LocalDate, BigDecimal> quotesMap) {
		this.stockId = stockId;
		this.quotesMap = quotesMap;
	}
	
	public List<Quote> addQuotesList(Stock stock){
		List<Quote> quotes = new ArrayList<>();
		quotesMap.forEach((date, price) -> {
			Quote quote = new Quote(stock, date, price);
			quotes.add(quote);
			stock.setQuotes(quotes);
		});
		return stock.getQuotes();
	}
	
	public Stock convertTo() {
		return new Stock(stockId);
	}
	
}
