package com.bitsassignment.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import com.bitsassignment.model.Author;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class AuthorRepositoryTest {

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    public void testSaveAndFind() {
        Author author = new Author();
        author.setName("Test Author");
        authorRepository.save(author);

        assertThat(authorRepository.findAll())
                .extracting(Author::getName)
                .contains("Test Author");
    }
} 