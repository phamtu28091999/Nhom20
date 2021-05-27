package com.example.quanLiMatHang;

import static org.hamcrest.CoreMatchers.startsWith;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.awt.PageAttributes.MediaType;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.example.quanLiMatHang.controller.BookController;
import com.example.quanLiMatHang.model.Book;
import com.example.quanLiMatHang.repository.BookRepository;
import com.example.quanLiMatHang.services.BookServices;

@WebMvcTest( BookController.class)
public class BookControllerTest {
	@Autowired
	private MockMvc mvc;

	@MockBean
	private BookServices services;
	
	@MockBean
	private BookRepository repostitory;
	
	@Test
	public void listBookTest() throws Exception {
		List<Book> listBook = IntStream.range(0, 10)
                .mapToObj(i -> new Book(i,"anh"+i+".png","i",i,i))
                .collect(Collectors.toList());
		given(services.getALLBook()).willReturn(listBook);
		
//		mvc.perform(get("").contentType(MediaType.APPLICATION_JSON)) 
//        .andExpect(status().isOk()) 
//        .andExpect(jsonPath("$", hasSize(10))) 
//        .andExpect(jsonPath("$[0].id", is(0))) 
//        .andExpect(jsonPath("$[0].title", is("title-0"))) 
//        .andExpect(jsonPath("$[0].detail", is("detail-0")));
	}
	
	

	@Test
	public void  deleteBook() throws Exception{
		
	}
}
