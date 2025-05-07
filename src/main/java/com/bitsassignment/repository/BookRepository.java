package com.bitsassignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;
import com.bitsassignment.model.Book;
import com.bitsassignment.dto.BookAuthorDTO;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    @Query("SELECT new com.bitsassignment.dto.BookAuthorDTO(b.id, b.title, a.name) FROM Book b JOIN b.author a")
    List<BookAuthorDTO> fetchBookAuthorData();
} 