package com.example.quanLiMatHang.controller;

import java.util.List;
import java.util.Optional;

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

import com.example.quanLiMatHang.model.Book;
import com.example.quanLiMatHang.services.BookServices;

@Controller
public class BookController {
	
	@Autowired
	private BookServices bookServices;
	
	@RequestMapping(value = "/book/")
	public String listBook(Model model,HttpServletRequest request) {
		List<Book> listBook = bookServices.getALLBook();
		
		String action2 = (String) request.getAttribute("action2");
		request.setAttribute("action2",action2);
		if(action2==null) {
			request.setAttribute("action1","true");
		} else {
			request.setAttribute("action1",null);
		}
		
		model.addAttribute("listBook", listBook);
		return "listBook";
	}
	
	@RequestMapping(value = "/book/delete" ,method = RequestMethod.GET)
	public String deleteBook(@RequestParam("id")int id,RedirectAttributes model) {
		bookServices.deleteBook(id);
		model.addFlashAttribute("success", "Xóa thành công");
		return "redirect:/book/";
	}
	
	@RequestMapping(value = "/book/add")
	public String addBook(Model model) {
		model.addAttribute("book",new Book());
		return "addBook";
	}	
	 
	@RequestMapping(value = "/book/save"  ,method = RequestMethod.POST)
	public String saveBook(@Valid Book book,BindingResult bindingResult,RedirectAttributes model) {
		if(bindingResult.hasErrors()) {
			return "addBook";
		} else {
			bookServices.saveBook(book);
			model.addFlashAttribute("success", "Thêm thành công");
			return "redirect:/book/";
		}
	}
	
	@RequestMapping(value = "/book/edit")
	public String editBook(@RequestParam("id") int id,Model model) {
		Optional<Book> bookEdit = bookServices.findBookId(id);
		bookEdit.ifPresent(book -> model.addAttribute("book", book));
		return "editBook";
	}
	
	@RequestMapping(value = "/book/saveUpdate" ,method = RequestMethod.POST)
	public String updateBook(@Valid Book book,BindingResult bindingResult,RedirectAttributes model) {
		if(bindingResult.hasErrors()) {
			return "addBook";
		} else {
			bookServices.saveBook(book);
			model.addFlashAttribute("success", "Cập nhật thành công");
			return "redirect:/book/";
		}
	}
	
	@RequestMapping(value = "/book/search")
	public String searchBook(@Param("keyword")String keyword,Model model,HttpServletRequest request) {
		
		String action2 = (String) request.getAttribute("action2");
		request.setAttribute("action2",action2);
		if(action2==null) {
			request.setAttribute("action1","true");
		} else {
			request.setAttribute("action1",null);
		}
		
		if(keyword.equals("")) {
			model.addAttribute("success","Vui lòng nhập từ khóa");
			return "forward:/book/";
		}
		
		List<Book> listBook = bookServices.searchBook(keyword);
		if(listBook == null) {
			model.addAttribute("success","Không tìm thấy");
			return "searchBook";
		}
		model.addAttribute("listBook", listBook);
		return "searchBook";
	}
}
