package com.example.quanLiMatHang.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.quanLiMatHang.model.Book;




@Repository
public interface BookRepository extends JpaRepository<Book, Integer>{
	@Query(value = "SELECT id,img,name,price,number FROM book b WHERE CONCAT "
			+ "(b.id,' ',b.img,' ',b.name,' ',b.price,' ',b.number,'') LIKE %?1%", nativeQuery = true)
	public List<Book> search(String keyword);
	
	@Query(value = "select * from book where id =?",nativeQuery = true)
	public Book searchById(int id) ;
	
}
