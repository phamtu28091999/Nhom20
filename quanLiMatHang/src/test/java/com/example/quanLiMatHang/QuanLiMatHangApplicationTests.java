package com.example.quanLiMatHang;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.quanLiMatHang.controller.AccountController;

@SpringBootTest
class QuanLiMatHangApplicationTests {
	
	@Autowired
	private AccountController accController;
	@Test
	void contextLoads() {
		assertThat(accController).isNotNull();
	}

}
