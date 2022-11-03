package br.inatel.idp.quotationmanagement.model.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;

@Entity
public class Quote {
	
	@Id
	private String id;

	@ManyToOne
	private Stock stock;
	private LocalDate date;
	private BigDecimal price;
	
	public Quote() {

	}

	public Quote(Stock stock, LocalDate date, BigDecimal price) {
		this.stock = stock;
		this.date = date;
		this.price = price;
	}

	@PrePersist
	private void onPersist() {
		generateUUID();
	}

	private void generateUUID() {
		id = UUID.randomUUID().toString();
		
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Quote [id=" + id + ", date=" + date + ", price=" + price + "]";
	}
	
	
	
	
}
