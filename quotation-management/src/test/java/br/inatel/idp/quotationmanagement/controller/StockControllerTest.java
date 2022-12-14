package br.inatel.idp.quotationmanagement.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import br.inatel.idp.quotationmanagement.model.form.StockQuoteForm;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class StockControllerTest {

	@Autowired
    private WebTestClient webTestClient;
	
	@Test
	public void Return200ListingAllStockQuotes() {
		webTestClient.get()
		.uri("/stock")
		.exchange()
		.expectHeader().contentType(MediaType.APPLICATION_JSON)
		.expectStatus().isOk();
	}
	
	@Test
	public void Return200ByAValidStockId() {
		webTestClient.get()
		.uri("/stock/petr4")
		.accept(MediaType.APPLICATION_JSON)
		.exchange()
		.expectStatus().isOk();
	}

	@Test
	public void Return404ByAnInvalidStockId() {
		webTestClient.get()
		.uri("/stock/error")
		.exchange()
		.expectStatus().isNotFound();
	}
	
	@Test
	public void Return200ByPostStockQuote() {
		StockQuoteForm stockForm = createStockForm();
		webTestClient.post()
		.uri("/stock")
		.body(BodyInserters.fromValue(stockForm))
		.exchange()
		.expectHeader().contentType(MediaType.APPLICATION_JSON)
		.expectStatus().isOk();
	}
	
	@Test
	public void Return400ByPostStockQuoteInvalidStockId() {
		StockQuoteForm stockForm = createStockForm();
		stockForm.setStockId("testInvalid");
		webTestClient.post()
		.uri("/stock")
		.body(BodyInserters.fromValue(stockForm))
		.exchange()
		.expectStatus().isBadRequest();
	}

	private StockQuoteForm createStockForm() {
		Map<LocalDate, BigDecimal> quotesMap = new HashMap<>();
		quotesMap.put(LocalDate.now(), null);
		StockQuoteForm stockForm = new StockQuoteForm("petr4", quotesMap);
		return stockForm;
	}
}
