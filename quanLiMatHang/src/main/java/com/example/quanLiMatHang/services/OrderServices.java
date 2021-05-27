package com.example.quanLiMatHang.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quanLiMatHang.model.Order;
import com.example.quanLiMatHang.repository.OrderRepository;

@Service
public class OrderServices {
	
	@Autowired
	OrderRepository orderRepository;
	
	public List<Order> getAllOrder(){
		return orderRepository.findAll();
	}
	
	public Order  searchById(int id) {
		return orderRepository.searchById(id);
	}
	
	public void saveOrder(Order order) {
		orderRepository.save(order);
	}
}
