package br.inatel.idp.quotationmanagement.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.inatel.idp.quotationmanagement.model.entity.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, String>{

	Optional<Stock> findByStockId(String id);
	
}
