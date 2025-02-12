package com.demo.esercizio1SpringWeb.services;

import com.demo.esercizio1SpringWeb.entities.Author;
import com.demo.esercizio1SpringWeb.exception.NotFoundException;
import com.demo.esercizio1SpringWeb.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    public Page<Author> getAuthors(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return authorRepository.findAll(pageable);
    }

    public Author save(Author author) {
        author.setAvatar("https://ui-avatars.com/api/?name=" + author.getName() + "+" + author.getSurname());
        return authorRepository.save(author);
    }

    public List<Author> getAuthors() {
        return authorRepository.findAll();
    }

    public Author findById(int id) {
        return authorRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(int id) {
        authorRepository.deleteById(id);
    }

    public Author findByIdAndUpdate(int id, Author author) {
        Author found = authorRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        found.setName(author.getName());
        found.setSurname(author.getSurname());
        return authorRepository.save(found);
    }
}