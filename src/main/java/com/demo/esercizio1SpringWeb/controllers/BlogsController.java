package com.demo.esercizio1SpringWeb.controllers;

import com.demo.esercizio1SpringWeb.dto.BlogpostDTO;
import com.demo.esercizio1SpringWeb.entities.Blogpost;
import com.demo.esercizio1SpringWeb.services.BlogpostMapper;
import com.demo.esercizio1SpringWeb.services.BlogsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/blogs")
public class BlogsController {
    @Autowired
    BlogsService blogsService;


    // Metodo per ottenere i blogpost con paginazione
    @GetMapping("")
    public Page<Blogpost> getBlogs(@RequestParam(defaultValue = "0") int page,
                                   @RequestParam(defaultValue = "10") int size) {
        return blogsService.getBlogs(page, size);
    }

    // Metodo per ottenere un blogpost specifico
    @GetMapping("/{blogId}")
    public Blogpost findById(@PathVariable int blogId) {
        return blogsService.findById(blogId);
    }

    // Metodo per salvare un blogpost
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED)
    public Blogpost saveBlog(@Valid @RequestBody Blogpost body) {
        return blogsService.save(body);
    }

    // Metodo per aggiornare un blogpost specifico
    @PutMapping("/{blogId}")
    public Blogpost findAndUpdate(@PathVariable int blogId, @Valid @RequestBody Blogpost body) {
        return blogsService.findByIdAndUpdate(blogId, body);
    }

    // Metodo per eliminare un blogpost specifico
    @DeleteMapping("/{blogId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void findAndDelete(@PathVariable int blogId) {
        blogsService.findByIdAndDelete(blogId);
    }
}

