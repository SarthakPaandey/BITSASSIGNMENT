package com.bitsassignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.dao.DataIntegrityViolationException;

import com.bitsassignment.model.Book;
import com.bitsassignment.service.BookService;
import com.bitsassignment.service.AuthorService;

@Controller
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;
    private final AuthorService authorService;

    public BookController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "books/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("book", new Book());
        model.addAttribute("authors", authorService.getAllAuthors());
        return "books/form";
    }

    @PostMapping
    public String createBook(@ModelAttribute Book book, Model model) {
        try {
            bookService.saveBook(book);
            return "redirect:/books";
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("errorMessage", e.getRootCause().getMessage());
            model.addAttribute("authors", authorService.getAllAuthors());
            return "books/form";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Book existing = bookService.getBookById(id);
        model.addAttribute("book", existing);
        model.addAttribute("authors", authorService.getAllAuthors());
        return "books/edit";
    }

    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable Long id, @ModelAttribute Book book) {
        book.setId(id);
        bookService.saveBook(book);
        return "redirect:/books";
    }

    @GetMapping("/join")
    public String showJoinData(Model model) {
        model.addAttribute("bookAuthors", bookService.getBookAuthorData());
        return "books/join";
    }
} 