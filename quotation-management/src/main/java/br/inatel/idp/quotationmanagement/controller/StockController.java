package br.inatel.idp.quotationmanagement.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.inatel.idp.quotationmanagement.model.dto.StockQuoteDto;
import br.inatel.idp.quotationmanagement.model.entity.Stock;
import br.inatel.idp.quotationmanagement.model.form.StockQuoteForm;
import br.inatel.idp.quotationmanagement.service.StockService;

/**
 * @author Tainara Martins.
 * @since October 2022
 */

@RestController
@RequestMapping("/stock")
public class StockController {

	@Autowired
	private StockService stockService;

	@GetMapping
	public List<StockQuoteDto> list() {
		List<Stock> stocks = stockService.findAllStockQuote();
		List<StockQuoteDto> sqDto = StockQuoteDto.convertTo(stocks);
		// stocks.stream().map(StockQuoteDto::new).collect(Collectors.toList());
		return sqDto;
	}

	@GetMapping("/{id}")
	public Optional<Stock> getByStockId(@PathVariable String id) {
		return stockService.findOneStockQuoteByStockId(id);
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<StockQuoteDto> createStockeQuote(@RequestBody @Valid StockQuoteForm form) {
		
		Optional<Stock> stocks = stockService.findOneStockQuoteByStockId(form.getStockId());
		
		if(stocks.isPresent()) {
			Stock stock = stocks.get();
			form.addQuotesList(stock);
			stockService.saveQuoteDb(stock.getQuotes());
			return new ResponseEntity<>(new StockQuoteDto(stock), HttpStatus.CREATED);
			
		}
		else {
			Stock stock = form.convertTo();
			stockService.saveStockDb(stock);
			form.addQuotesList(stock);
			stockService.saveQuoteDb(stock.getQuotes());
			return new ResponseEntity<>(new StockQuoteDto(stock), HttpStatus.CREATED);
		}		
	}

}
