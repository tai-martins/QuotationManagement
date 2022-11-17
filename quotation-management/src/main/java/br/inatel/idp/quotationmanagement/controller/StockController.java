package br.inatel.idp.quotationmanagement.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
 * Controller Class. Implementation of endpoints
 * 
 * @author Tainara Martins.
 * @since November 2022
 */

@RestController
@RequestMapping("/stock")
public class StockController {

	@Autowired
	private StockService stockService;

	/**
	 * Get method
	 * 
	 * @return All stocks and their quotes 
	 */
	@GetMapping
	@Cacheable(value = "stocksList")
	public List<StockQuoteDto> list() {
		List<Stock> stocks = stockService.findAllStockQuote();
		List<StockQuoteDto> sqDto = StockQuoteDto.convertTo(stocks);
		return sqDto;
	}

	/**
	 * Get method
	 * 
	 * @return one stock by your stockId
	 */
	@GetMapping("/{stockId}")
	@Cacheable(value = "oneStock")
	public ResponseEntity<?> getByStockId(@PathVariable String stockId) {
		Optional<Stock> stocks = stockService.findOneStockQuoteByStockId(stockId);
		if (stocks.isPresent()) {
			Stock stock = stocks.get();
			StockQuoteDto sqDto = new StockQuoteDto(stock);
			return new ResponseEntity<>(sqDto, HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	/**
	 * Post method
	 * 
	 * @return ResponseEntity and Body
	 */
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	@CacheEvict(value = { "stocksList", "oneStock" }, allEntries = true)
	public ResponseEntity<?> createStockQuote(@RequestBody @Valid StockQuoteForm form) {

		Optional<Stock> opStock = stockService.findOneStockQuoteByStockId(form.getStockId());
		Stock stock = form.convertTo();

		if (opStock.isPresent()) {
			stock = opStock.get();
			form.addQuotesList(stock);
			stockService.saveQuoteDb(stock.getQuotes());
			return new ResponseEntity<>(new StockQuoteDto(stock), HttpStatus.OK);
		}
		else if(stockService.existsAtStockManager(stock)){
			stock = stockService.saveStockDb(stock);
			form.addQuotesList(stock);
			stockService.saveQuoteDb(stock.getQuotes());
			return new ResponseEntity<>(new StockQuoteDto(stock), HttpStatus.CREATED);
		}
		else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}


	}

	/** Delete method to clear cache */
	@DeleteMapping("/stockcache")
	public void deletar() {
		System.out.println("cache erased");
	}

}
