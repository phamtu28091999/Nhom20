package com.example.quanLiMatHang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.quanLiMatHang.model.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer>{

}
