package com.bitsassignment.service;

import org.springframework.stereotype.Service;
import java.util.List;
import com.bitsassignment.model.Book;
import com.bitsassignment.dto.BookAuthorDTO;
import com.bitsassignment.repository.BookRepository;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public Book getBookById(Long id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public List<BookAuthorDTO> getBookAuthorData() {
        return bookRepository.fetchBookAuthorData();
    }
} 