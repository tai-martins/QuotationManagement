package br.inatel.idp.quotationmanagement.adapter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@Service
public class StockManagerAdapter {

	@Value("${URL_MANAGER}")
	private String URL_MANAGER;
	
	@Value("${server.host}")
	private String host;
	
	@Value("${url.port}")
	private String port;
	
	@Cacheable(value = "stocksAtManagerList")
	public List<StockManagerDto> listAllStocks() {
		List<StockManagerDto> sMDto = new ArrayList<>();
		Flux<StockManagerDto> fluxDto = WebClient.create(URL_MANAGER)
				//builder().baseUrl("http://"+ URL_MANAGER).build()
				.get()
				.uri("/stock")
				.retrieve()
				.bodyToFlux(StockManagerDto.class);
		
		fluxDto.subscribe(f -> sMDto.add(f));
	    fluxDto.blockLast();
		
	    return sMDto;
	} 
	
}
