package com.example.quanLiMatHang.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "order1")
public class Order {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@NotBlank(message = "Vui lòng nhập ngày ")
	@Column(name = "date")
	private String date;
	
	@Column(name = "price")
	private float price;
	
	@Column(name = "number")
	private int number;
	
	@Column(name = "total")
	private float total;

	@Column(name = "supplierid")
	private int idsupplier;
	
	@Column(name = "bookid")
	private int idbook;
	
	public Order() {
	}

	public Order(int id, int idsupplier, int idbook, String date, float price, int number, float total) {
		this.id = id;
		this.idsupplier = idsupplier;
		this.idbook = idbook;
		this.date = date;
		this.price = price;
		this.number = number;
		this.total = total;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdsupplier() {
		return idsupplier;
	}

	public void setIdsupplier(int idsupplier) {
		this.idsupplier = idsupplier;
	}

	public int getIdbook() {
		return idbook;
	}

	public void setIdbook(int idbook) {
		this.idbook = idbook;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	};

}
