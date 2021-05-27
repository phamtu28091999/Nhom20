package com.example.quanLiMatHang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.quanLiMatHang.model.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Integer>{

	@Query(value = "select * from order1 where id =?",nativeQuery = true)
	public Order searchById(int id) ;
	
}
