package com.example.quanLiMatHang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.quanLiMatHang.model.Account;
import com.example.quanLiMatHang.services.AccountServices;

@Controller
public class AccountController {
	@Autowired
	private AccountServices accountServices;

	@RequestMapping(value = "/login")
	public String loginForm() {
		return "login";
	}

	@RequestMapping(value = "/login/check")
	public String login(@RequestParam("username") String username, @RequestParam("password") String password,
			 Model model) {
		List<Account> listAccount = accountServices.getAllAcount();
		boolean check = false;
		Account acc = new Account(username, password);
		if(username.equals("")) {
			model.addAttribute("erUser", "Vui lòng nhập tên tài khoản");
			model.addAttribute("user", username);
			model.addAttribute("pass", password);
			return "login";
		}
		
		if(password.equals("")) {
			model.addAttribute("erPass", "Vui lòng nhập mật khẩu");
			model.addAttribute("user", username);
			model.addAttribute("pass", password);
			return "login";
		}
		
		for (int i = 0; i < listAccount.size(); i++) {
			if (acc.getUsername().equals(listAccount.get(i).getUsername())
					&& acc.getPassword().equals(listAccount.get(i).getPassword())) {
				check = true;
			}
		}
		
		if (check == false) {
			model.addAttribute("erAcc", "Tài khoản hoặc mật khẩu không đúng");
			model.addAttribute("user", username);
			model.addAttribute("pass", password);
			return "login";
		}
		model.addAttribute("user", username.toUpperCase());
		return "home";
	}
}
