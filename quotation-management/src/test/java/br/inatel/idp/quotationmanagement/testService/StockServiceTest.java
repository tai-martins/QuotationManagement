package br.inatel.idp.quotationmanagement.testService;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.inatel.idp.quotationmanagement.model.entity.Stock;
import br.inatel.idp.quotationmanagement.service.StockService;

@SpringBootTest
public class StockServiceTest {

	@Autowired
	private StockService stockService;

	//@Test
//	public void givenValidStockId_ReturnAExistentStock() {
//		String validStockId = "test4";
//		Stock stock = stockService.findOneStockQuoteByStockId(validStockId);
//		assertEquals(validStockId, stock.getStockId());
//	}

}
