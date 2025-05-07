package com.bitsassignment.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.dao.DataIntegrityViolationException;

import com.bitsassignment.model.Author;
import com.bitsassignment.service.AuthorService;

@Controller
@RequestMapping("/authors")
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/ping")
    @ResponseBody
    public String ping() {
        return "AuthorController is reachable!";
    }

    @GetMapping
    public String listAuthors(Model model) {
        model.addAttribute("authors", authorService.getAllAuthors());
        return "authors/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("author", new Author());
        return "authors/form";
    }

    @PostMapping
    public String createAuthor(@ModelAttribute Author author, Model model) {
        try {
            authorService.saveAuthor(author);
            return "redirect:/authors";
        } catch (DataIntegrityViolationException e) {
            model.addAttribute("errorMessage", e.getRootCause().getMessage());
            return "authors/form";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Author existing = authorService.getAuthorById(id);
        model.addAttribute("author", existing);
        return "authors/edit";
    }

    @PostMapping("/update/{id}")
    public String updateAuthor(@PathVariable Long id, @ModelAttribute Author author) {
        author.setId(id);
        authorService.saveAuthor(author);
        return "redirect:/authors";
    }
} 