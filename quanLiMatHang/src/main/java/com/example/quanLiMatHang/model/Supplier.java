package com.example.quanLiMatHang.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "supplier")
public class Supplier {
	
	@Column(name="id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="name")
	@NotBlank(message = "Vui lòng nhập tên công ty")
	private String name;
	
	@Column(name="address")
	@NotBlank(message = "Vui lòng nhập địa chỉ")
	private String address;
	
	@Column(name="phone")
	@Size(min = 10,message = " số điện thoại ít nhất phải 10 chữa số")
	private String phone;

	public Supplier() {
	}

	public Supplier(int id, String name, String address, String phone) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public Supplier(String name, String address, String phone) {
		this.name = name;
		this.address = address;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhone() {
		return phone;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhone(String phone) {
	        this.phone = phone;
	    }
}
