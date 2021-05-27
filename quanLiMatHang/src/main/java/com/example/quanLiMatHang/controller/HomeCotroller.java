package com.example.quanLiMatHang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeCotroller {
	@RequestMapping(value = "/home")
	public String home() {
		return "home";
	}
}
