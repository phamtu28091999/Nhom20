package com.example.quanLiMatHang;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.quanLiMatHang.controller.OrderController;

@SpringBootTest
public class OrderControllerTest {
	@Autowired
	private OrderController controller;
	
	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}
}
