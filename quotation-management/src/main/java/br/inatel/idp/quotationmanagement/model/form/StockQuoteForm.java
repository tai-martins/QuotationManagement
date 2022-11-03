package br.inatel.idp.quotationmanagement.model.form;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

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
	
	
}
