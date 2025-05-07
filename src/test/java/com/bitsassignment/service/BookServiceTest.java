package com.bitsassignment.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.bitsassignment.dto.BookAuthorDTO;
import com.bitsassignment.model.Book;
import com.bitsassignment.repository.BookRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class BookServiceTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllBooks() {
        Book b1 = new Book(); b1.setTitle("B1");
        Book b2 = new Book(); b2.setTitle("B2");
        when(bookRepository.findAll()).thenReturn(Arrays.asList(b1, b2));

        List<Book> result = bookService.getAllBooks();
        assertThat(result).hasSize(2).contains(b1, b2);
        verify(bookRepository).findAll();
    }

    @Test
    void testSaveBook() {
        Book b = new Book(); b.setTitle("B");
        when(bookRepository.save(b)).thenReturn(b);

        Book saved = bookService.saveBook(b);
        assertThat(saved).isEqualTo(b);
        verify(bookRepository).save(b);
    }

    @Test
    void testGetBookByIdFound() {
        Book b = new Book(); b.setId(1L); b.setTitle("B");
        when(bookRepository.findById(1L)).thenReturn(Optional.of(b));

        Book result = bookService.getBookById(1L);
        assertThat(result).isEqualTo(b);
    }

    @Test
    void testGetBookByIdNotFound() {
        when(bookRepository.findById(2L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> bookService.getBookById(2L));
    }

    @Test
    void testGetBookAuthorData() {
        BookAuthorDTO dto = new BookAuthorDTO(1L, "Title", "Author");
        when(bookRepository.fetchBookAuthorData()).thenReturn(Arrays.asList(dto));

        List<BookAuthorDTO> result = bookService.getBookAuthorData();
        assertThat(result).hasSize(1).contains(dto);
        verify(bookRepository).fetchBookAuthorData();
    }
} 