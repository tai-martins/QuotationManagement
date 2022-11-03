package br.inatel.idp.quotationmanagement.model.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import br.inatel.idp.quotationmanagement.model.entity.Quote;

public class QuoteDto {
	
	private String id;
	private String stock;
	private String stockId;
	private LocalDate date;
	private BigDecimal price;
	
	public QuoteDto(Quote quote) {
		this.id = quote.getId();
		this.stock = quote.getStock().getId();
		this.stockId = quote.getStock().getStockId();
		this.date = quote.getDate();
		this.price = quote.getPrice();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getStockId() {
		return stockId;
	}

	public void setStockId(String stockId) {
		this.stockId = stockId;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	public static List<QuoteDto> convert(List<Quote> quotes) {
		return quotes.stream().map(QuoteDto::new).collect(Collectors.toList());
	}
	
	
}
