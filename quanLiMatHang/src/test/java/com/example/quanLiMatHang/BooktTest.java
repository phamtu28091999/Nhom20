package com.example.quanLiMatHang;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.quanLiMatHang.model.Book;

@ExtendWith(MockitoExtension.class)
public class BooktTest {
	@Autowired
	private Book book ;
	@Test 
	void getId() {
		book.setId(1);
		assertEquals(1, book.getId());
	}
}
