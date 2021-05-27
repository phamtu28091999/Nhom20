package com.example.quanLiMatHang;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.quanLiMatHang.controller.SupplierController;

@SpringBootTest
public class SupplierControllerTest {
	@Autowired
	private SupplierController controller;
	
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}
}
