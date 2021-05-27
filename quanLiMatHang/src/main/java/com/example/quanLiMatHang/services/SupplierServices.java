package com.example.quanLiMatHang.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.quanLiMatHang.model.Supplier;
import com.example.quanLiMatHang.repository.SupplierRepository;

@Service
public class SupplierServices {
	@Autowired
	private SupplierRepository repository;
	
	public List<Supplier> getAllSupplier(){
		return repository.findAll();
	}
	
	public void saveSupplier(Supplier supplier) {
		repository.save(supplier);
	}
	
	public void deleteSuplier(int id) {
		repository.deleteById(id);
	}
	
	public List<Supplier> searchSupplier(String keyword){
		return repository.search(keyword);
	}
	
	public Supplier searchSupplierById(int id){
		return repository.searchById(id);
	}
	
}
