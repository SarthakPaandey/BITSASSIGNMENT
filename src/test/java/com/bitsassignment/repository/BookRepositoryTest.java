package com.bitsassignment.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.assertj.core.api.Assertions.assertThat;

import com.bitsassignment.model.Author;
import com.bitsassignment.model.Book;
import com.bitsassignment.dto.BookAuthorDTO;
import java.util.List;

@DataJpaTest
public class BookRepositoryTest {

    // Mock the CommandLineRunner to prevent sample data loading
    @MockBean
    private CommandLineRunner commandLineRunner;

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Test
    public void testFetchBookAuthorData() {
        Author author = new Author();
        author.setName("Test Author");
        authorRepository.save(author);

        Book book = new Book();
        book.setTitle("Test Book");
        book.setAuthor(author);
        bookRepository.save(book);

        List<BookAuthorDTO> results = bookRepository.fetchBookAuthorData();
        assertThat(results).hasSize(1);
        BookAuthorDTO dto = results.get(0);
        assertThat(dto.getBookTitle()).isEqualTo("Test Book");
        assertThat(dto.getAuthorName()).isEqualTo("Test Author");
    }
} 