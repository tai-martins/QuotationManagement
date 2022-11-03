package br.inatel.idp.quotationmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.inatel.idp.quotationmanagement.model.entity.Quote;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, String>{
	
}
