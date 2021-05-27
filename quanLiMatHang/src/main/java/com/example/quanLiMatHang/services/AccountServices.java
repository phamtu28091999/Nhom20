package com.example.quanLiMatHang.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.quanLiMatHang.model.Account;
import com.example.quanLiMatHang.repository.AccountRepository;

@Service
public class AccountServices {
	
	@Autowired
	private AccountRepository accountRepository;
	public List<Account> getAllAcount() {
		return accountRepository.findAll();
	}
}
