package com.demo.esercizio1SpringWeb.services;


import com.demo.esercizio1SpringWeb.entities.Blogpost;
import com.demo.esercizio1SpringWeb.exception.NotFoundException;
import com.demo.esercizio1SpringWeb.repository.BlogpostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BlogsService {

    @Autowired
    private BlogpostRepository blogpostRepository;

    public Page<Blogpost> getBlogs(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return blogpostRepository.findAll(pageable);
    }

    public Blogpost save(Blogpost blogpost) {
        blogpost.setCover("https://picsum.photos/200/300");
        return blogpostRepository.save(blogpost);
    }

    public List<Blogpost> getBlogs() {
        return blogpostRepository.findAll();
    }

    public Blogpost findById(int id) {
        return blogpostRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
    }

    public void findByIdAndDelete(int id) {
        blogpostRepository.deleteById(id);
    }

    public Blogpost findByIdAndUpdate(int id, Blogpost blogpost) {
        Blogpost found = blogpostRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
        found.setCategory(blogpost.getCategory());
        found.setTitle(blogpost.getTitle());
        found.setContent(blogpost.getContent());
        found.setReadingTime(blogpost.getReadingTime());
        return blogpostRepository.save(found);
    }}
