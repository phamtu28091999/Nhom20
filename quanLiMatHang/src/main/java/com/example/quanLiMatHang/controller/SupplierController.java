package com.example.quanLiMatHang.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.quanLiMatHang.model.Supplier;
import com.example.quanLiMatHang.services.SupplierServices;

@Controller
public class SupplierController {
	
	@Autowired 
	private SupplierServices supplierServices;
	
	@RequestMapping(value = "/supplier/")
	public String listSupplieer(Model model,HttpServletRequest request) {
		List<Supplier> listSupplier = supplierServices.getAllSupplier();
		model.addAttribute("listSupplier", listSupplier);
		String action2 = (String) request.getAttribute("action2");
		request.setAttribute("action2",action2);
		if(action2==null) {
			request.setAttribute("action1","true");
		} else {
			request.setAttribute("action1",null);
		}
		return "listSupplier";
	}
	
	@RequestMapping(value = "/supplier/add")
	public String addSupplier(Model model) {
		model.addAttribute("supplier",new Supplier());
		return "addSupplier";
	}	
	 
	@RequestMapping(value = "/supplier/save" )
	public String saveBook(@Valid  Supplier supplier,BindingResult bindingResult,RedirectAttributes model) {
		if(bindingResult.hasErrors()) {
			return "addSupplier";
		} else {
			supplierServices.saveSupplier(supplier);
			model.addFlashAttribute("success", "Thêm thành công");
			return "redirect:/supplier/";
		}
	}
	
	@RequestMapping(value = "/supplier/delete" ,method = RequestMethod.GET)
	public String deleteSupplier(@RequestParam("id")int id,RedirectAttributes model) {
		supplierServices.deleteSuplier(id);
		model.addFlashAttribute("success", "Xóa thành công");
		return "redirect:/supplier/";
	}
	
	@RequestMapping(value = "/supplier/search")
	public String searchSupplier(@Param(value = "keyword") String keyword,Model model,HttpServletRequest request) {
		List<Supplier> listSupplier = supplierServices.searchSupplier(keyword);
		String action2 = (String) request.getAttribute("action2");
		request.setAttribute("action2",action2);
		if(action2==null) {
			request.setAttribute("action1","true");
		} else {
			request.setAttribute("action1",null);
		}
		
		if(keyword.equals("")) {
			model.addAttribute("success","Vui lòng nhập từ khóa");
			return "forward:/supplier/";
		}
		
		if(listSupplier == null) {
			model.addAttribute("search","Không tìm thấy");
		}
		model.addAttribute("listSupplier",listSupplier);
		return "searchSupplier";
	}	
	
}
