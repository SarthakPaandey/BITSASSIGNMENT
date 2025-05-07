package com.bitsassignment;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.bitsassignment.model.Author;
import com.bitsassignment.model.Book;
import com.bitsassignment.repository.AuthorRepository;
import com.bitsassignment.repository.BookRepository;

@SpringBootApplication
public class BitsassignmentApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(BitsassignmentApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(BitsassignmentApplication.class);
    }

    @Bean
    public CommandLineRunner dataLoader(AuthorRepository authorRepo, BookRepository bookRepo) {
        return args -> {
            // Create sample authors
            for (int i = 1; i <= 10; i++) {
                Author author = new Author();
                author.setName("Author " + i);
                authorRepo.save(author);
            }
            // Create sample books
            for (int i = 1; i <= 10; i++) {
                Book book = new Book();
                book.setTitle("Book " + i);
                // Assign an author
                long authorId = (i % 10) + 1;
                Author author = authorRepo.findById(authorId).orElse(null);
                book.setAuthor(author);
                bookRepo.save(book);
            }
        };
    }
} 