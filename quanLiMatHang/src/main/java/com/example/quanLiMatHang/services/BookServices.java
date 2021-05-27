package com.example.quanLiMatHang.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.quanLiMatHang.repository.BookRepository;
import com.example.quanLiMatHang.model.Book;

@Service
public class BookServices {
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getALLBook(){
		return bookRepository.findAll();
	}
	
	public void deleteBook(int id) {
		bookRepository.deleteById(id);
	}
	
	public void saveBook(Book book) {
		bookRepository.save(book);
	}
	
	public Optional<Book> findBookId(int id) {
		return bookRepository.findById(id);
	}
	
	public List<Book> searchBook(String keyword){
		return bookRepository.search(keyword);
	}
	
	public Book searchBookById(int id){
		return bookRepository.searchById(id);
	}
	
}
