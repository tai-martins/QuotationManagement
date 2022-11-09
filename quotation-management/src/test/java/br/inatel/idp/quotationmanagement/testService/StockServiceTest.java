package br.inatel.idp.quotationmanagement.testService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.inatel.idp.quotationmanagement.model.entity.Stock;
import br.inatel.idp.quotationmanagement.service.StockService;

@SpringBootTest
public class StockServiceTest {

	@Autowired
	private StockService stockService;
	
	@Test
	public void ListOfStocksIsNotEmpty() {
		List<Stock> stocks = stockService.findAllStockQuote();
		assertNotNull(stocks);
	}
	
	@Test
	public void ReturnAllStockQuoteByStockId() {
		String stockId = "bbas3";
		Optional<Stock> opStock = stockService.findOneStockQuoteByStockId(stockId);
		assertNotNull(opStock);
		assertEquals(stockId, opStock.get().getStockId());
	}
	
	@Test
	public void ReturnStockQuoteByInvalidStockId() {
		String stockId = "INTB";
		Optional<Stock> opStock = stockService.findOneStockQuoteByStockId(stockId);
		assertTrue(opStock.isEmpty());
	}
	
	@Test
	public void SaveStockInDataBase() {
		Stock saveStock = new Stock("bbas4");
		stockService.saveStockDb(saveStock);
		Optional<Stock> stock = stockService.findOneStockQuoteByStockId(saveStock.getStockId());
		assertFalse(stock.get().getStockId().isEmpty());
	}
	
	@Test
	public void SaveQuoteInDataBase() {
		
	}

}
