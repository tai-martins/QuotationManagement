package br.inatel.idp.quotationmanagement.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.inatel.idp.quotationmanagement.model.dto.StockQuoteDto;
import br.inatel.idp.quotationmanagement.model.entity.Stock;
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
		List<StockQuoteDto> sqDto = stocks.stream().map(StockQuoteDto::new).collect(Collectors.toList());
		return sqDto;
	}
	
	@GetMapping("/{id}")
	public Optional<Stock> getByStockId(@PathVariable String id) {
		return stockService.findOneStockQuoteByStockId(id);
	}
	
	
  
}
