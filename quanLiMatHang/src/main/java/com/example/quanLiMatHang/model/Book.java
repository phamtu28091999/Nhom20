package com.example.quanLiMatHang.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "book")
public class Book {
	@Column(name="id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="img")
	@NotBlank(message = "Vui lòng nhập đường đãn hình ảnh")
	private String img;
	
	@Column(name="name")
	@NotBlank(message = "Vui lòng nhập tên")
	private String name;
	
	@Column(name="price")
	@PositiveOrZero(message = "Giá bán không được âm")
	
	private float price;
	
	@PositiveOrZero(message = "Tồn kho không được âm")
	@Column(name="number")
	private int number;

	public Book() {
	}

	public Book(String img, String name, float price, int number) {
		this.img = img;
		this.name = name;
		this.price = price;
		this.number = number;
	}

	public Book(int id, String img, String name, float price, int number) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.img = img;
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public float getPrice() {
		return price;
	}

	public String getImg() {
		return img;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public void setImg(String img) {
		this.img = img;
	}

	@Override
	public String toString() {
		return "" + id + " " + img + " " + name + " " + price + " " + number;
	}
}
