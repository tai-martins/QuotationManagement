package br.inatel.idp.quotationmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.inatel.idp.quotationmanagement.adapter.StockManagerAdapter;
import br.inatel.idp.quotationmanagement.adapter.StockManagerDto;
import br.inatel.idp.quotationmanagement.model.entity.Quote;
import br.inatel.idp.quotationmanagement.model.entity.Stock;
import br.inatel.idp.quotationmanagement.repository.QuoteRepository;
import br.inatel.idp.quotationmanagement.repository.StockRepository;

/**
 * StockService Class.
 * 
 * @author Tainara Martins.
 * @since November 2022
 */
@Service
@Transactional
public class StockService {

	@Autowired
	StockRepository stockRepository;

	@Autowired
	QuoteRepository quoteRepository;
	
	@Autowired
	StockManagerAdapter stockManagerAdapter;
	
	/**
	 * method that saves a stock in the database
	 * 
	 * @param stock
	 * @return stock
	 */
	public Stock saveStockDb(Stock stock) {
		stock = stockRepository.save(stock);
		return stock;
	}

	/**
	 * method that saves a quote in the database
	 * 
	 * @param quotes
	 */
	public void saveQuoteDb(List<Quote> quotes) {
		quotes.forEach(quote -> quoteRepository.save(quote));
	} 

	/**
	 * Find one stock with quotes by stockId
	 * 
	 * @param stockId
	 * @return optionalStock
	 */
	public Optional<Stock> findOneStockQuoteByStockId(String stockId) {
		Optional<Stock> optionalStock = stockRepository.findByStockId(stockId);
		optionalStock.map(stock -> stock.getQuotes().size());
		return optionalStock;
	}

	/**
	 * Find all stocks with quotes
	 * 
	 * @return stocks
	 */
	public List<Stock> findAllStockQuote() {
		List<Stock> stocks = stockRepository.findAll();
		stocks.forEach(stock -> stock.getQuotes().size());
		return stocks;
	}

	/**
	 * check if there is an Stock
	 * 
	 * @param stock
	 * @return stocksAtManager
	 */
	public boolean existsAtStockManager(Stock stock) {
		List<StockManagerDto> stocksAtManager = stockManagerAdapter.listAllStocks();
		return stocksAtManager.stream().anyMatch(s -> s.getId().equals(stock.getStockId()));
	}

}
