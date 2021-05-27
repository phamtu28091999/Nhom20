package com.example.quanLiMatHang.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "accounts")
public class Account {

	@Column(name = "id")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "username")
	@NotBlank(message = "Nhập tên đăng nhập")
	private String username;

	@Column(name = "password")
	@NotBlank(message = "Nhập mật khẩu")
	private String password;

	@Column(name = "auth")
	private int auth;

	public Account() {

	}

	public Account(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public Account(int id, String username, String password, int auth) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.auth = auth;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAuth() {
		return auth;
	}

	public void setAuth(int auth) {
		this.auth = auth;
	}

}
