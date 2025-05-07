package com.bitsassignment.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.bitsassignment.model.Author;
import com.bitsassignment.repository.AuthorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class AuthorServiceTest {

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorService authorService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllAuthors() {
        Author a1 = new Author(); a1.setName("A1");
        Author a2 = new Author(); a2.setName("A2");
        when(authorRepository.findAll()).thenReturn(Arrays.asList(a1, a2));

        List<Author> result = authorService.getAllAuthors();
        assertThat(result).hasSize(2).contains(a1, a2);
        verify(authorRepository).findAll();
    }

    @Test
    void testSaveAuthor() {
        Author a = new Author(); a.setName("A");
        when(authorRepository.save(a)).thenReturn(a);

        Author saved = authorService.saveAuthor(a);
        assertThat(saved).isEqualTo(a);
        verify(authorRepository).save(a);
    }

    @Test
    void testGetAuthorByIdFound() {
        Author a = new Author(); a.setId(1L); a.setName("A");
        when(authorRepository.findById(1L)).thenReturn(Optional.of(a));

        Author result = authorService.getAuthorById(1L);
        assertThat(result).isEqualTo(a);
    }

    @Test
    void testGetAuthorByIdNotFound() {
        when(authorRepository.findById(2L)).thenReturn(Optional.empty());
        assertThrows(RuntimeException.class, () -> authorService.getAuthorById(2L));
    }
} 