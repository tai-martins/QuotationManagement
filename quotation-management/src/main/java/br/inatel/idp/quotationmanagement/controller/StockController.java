package br.inatel.idp.quotationmanagement.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.inatel.idp.quotationmanagement.service.StockService;

/**
 * @author Tainara Martins.
 * @since October 2022
 */

@RestController
@RequestMapping("/stock")
public class StockController {
	
	private StockService service;

}
