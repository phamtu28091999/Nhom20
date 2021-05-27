package com.example.quanLiMatHang.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.quanLiMatHang.model.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer>{
	@Query(value = "SELECT id,name,address,phone FROM supplier s WHERE CONCAT "
			+ "(s.id,' ',s.name,' ',s.address,' ',s.phone,' ') LIKE %?1%", nativeQuery = true)
	public ArrayList<Supplier> search(String keyword);


	@Query(value = "select * from supplier where id =?",nativeQuery = true)
	public Supplier searchById(int id);
}
