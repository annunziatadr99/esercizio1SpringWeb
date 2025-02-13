package com.demo.esercizio1SpringWeb.controllers;


import com.demo.esercizio1SpringWeb.dto.AuthorDTO;
import com.demo.esercizio1SpringWeb.entities.Author;
import com.demo.esercizio1SpringWeb.services.AuthorMapper;
import com.demo.esercizio1SpringWeb.services.AuthorService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {
    @Autowired
    AuthorService authorsService;


    // Metodo per ottenere gli autori con paginazione
    @GetMapping("")
    public Page<Author> getAuthors(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size) {
        return authorsService.getAuthors(page, size);
    }

    // Metodo per ottenere un autore specifico
    @GetMapping("/{authorId}")
    public Author findById(@PathVariable int authorId) throws Exception {
        return authorsService.findById(authorId);
    }

    // Metodo per salvare un autore
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Author saveAuthor(@Valid @RequestBody Author body) throws Exception {
        return authorsService.save(body);
    }

    // Metodo per aggiornare un autore specifico
    @PutMapping("/{authorId}")
    public Author findAndUpdate(@PathVariable int authorId, @Valid @RequestBody Author body) throws Exception {
        return authorsService.findByIdAndUpdate(authorId, body);
    }

    // Metodo per eliminare un autore specifico
    @DeleteMapping("/{authorId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findAndDelete(@PathVariable int authorId) {
        authorsService.findByIdAndDelete(authorId);
    }
}

