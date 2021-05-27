package com.example.quanLiMatHang.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.quanLiMatHang.model.Book;
import com.example.quanLiMatHang.model.Order;
import com.example.quanLiMatHang.model.Supplier;
import com.example.quanLiMatHang.services.BookServices;
import com.example.quanLiMatHang.services.OrderServices;
import com.example.quanLiMatHang.services.SupplierServices;

@Controller
public class OrderController {
	@Autowired
	private OrderServices orderServices;

	@Autowired
	private BookServices bookServices;

	@Autowired
	private SupplierServices supplierServices;

	@RequestMapping(value = "/order/")
	public String listOrder(Model model) {
		List<Order> listOrder = orderServices.getAllOrder();
		model.addAttribute("listOrder", listOrder);
		return "listOrder";
	}

	@RequestMapping(value = "/order/addSupplier")
	public String addSupplier(Model model, HttpServletRequest request) {
		request.setAttribute("action2", "true");
		String sid = (String) request.getParameter("sid");
		request.setAttribute("sid", sid);
		return "forward:/supplier/";
	}

	@RequestMapping(value = "/order/addBook")
	public String addBook(Model model, HttpServletRequest request) {
		String sid = (String) request.getParameter("sid");
		request.setAttribute("sid", sid);
		request.setAttribute("action2", "true");
		return "forward:/book/";
	}

	@RequestMapping(value = "/order/viewOrder", method = RequestMethod.GET)
	public String viewOrder(@RequestParam("id") int id, Model model) {
		Order order = orderServices.searchById(id);
		Book book = bookServices.searchBookById(order.getIdbook());
		Supplier supplier = supplierServices.searchSupplierById(order.getIdsupplier());

		model.addAttribute("o", order);
		model.addAttribute("b", book);
		model.addAttribute("s", supplier);

		return "viewOrder";
	}

	@RequestMapping(value = "/order/loadOrder")
	public String loadOrder(Model model,HttpServletRequest request) {
		String sid = (String)request.getParameter("sid");
		String bid = (String)request.getParameter("bid");
		request.setAttribute("action2", "true");
		request.setAttribute("bid", bid);
		request.setAttribute("sid", sid);
		model.addAttribute("order",new Order());
		return "addOrder";
	}

	@RequestMapping(value = "/order/saveOrder",method = RequestMethod.POST)
	public String saveOrder(@Valid Order order ,BindingResult bindingResult,RedirectAttributes model,@RequestParam("bid") int bid,
			@RequestParam("sid")int sid) {
		
		if(bindingResult.hasErrors()) {
			return "addOrder";
		} else {
			order.setIdbook(bid);
			order.setIdsupplier(sid);
			order.setTotal(order.getNumber()*order.getPrice());
			orderServices.saveOrder(order);
			model.addFlashAttribute("success", "Cập nhật thành công");
			return "redirect:/order/";
		}
		
	}
}
