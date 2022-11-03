package br.inatel.idp.quotationmanagement.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import br.inatel.idp.quotationmanagement.model.entity.Stock;

public class StockQuoteDto {
	
	private String id;
	private String stockId;
	
	private Map<LocalDate, BigDecimal> quotes = new HashMap<>();

	public StockQuoteDto() {

	}
	
	public StockQuoteDto(Stock sq) {
		this.id = sq.getId();
		this.stockId = sq.getStockId();
		sq.getQuotes().stream().forEach(quote -> quotes.put(quote.getDate(), quote.getPrice()));
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

	public Map<LocalDate, BigDecimal> getQuotes() {
		return quotes;
	}
	
	public void setQuotes(Map<LocalDate, BigDecimal> quotes) {
		this.quotes = quotes;
	}
	
	public static List<StockQuoteDto> convertTo(List<Stock> stocks) {
		return stocks.stream().map(StockQuoteDto::new).collect(Collectors.toList());
	}


	
	
}