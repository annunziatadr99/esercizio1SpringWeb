package com.demo.esercizio1SpringWeb.services;

import com.demo.esercizio1SpringWeb.dto.BlogpostDTO;
import com.demo.esercizio1SpringWeb.entities.Blogpost;
import org.springframework.stereotype.Component;


@Component
public class BlogpostMapper {
    // Metodo per convertire Blogpost in BlogpostDTO
    public BlogpostDTO toDTO(Blogpost blogpost) {
        BlogpostDTO dto = new BlogpostDTO();
        dto.setId(blogpost.getId());
        dto.setCategory(blogpost.getCategory());
        dto.setTitle(blogpost.getTitle());
        dto.setCover(blogpost.getCover());
        dto.setContent(blogpost.getContent());
        dto.setReadingTime(blogpost.getReadingTime());
        return dto;
    }

    // Metodo per convertire BlogpostDTO in Blogpost
    public Blogpost toEntity(BlogpostDTO dto) {
        Blogpost blogpost = new Blogpost();
        blogpost.setId(dto.getId());
        blogpost.setCategory(dto.getCategory());
        blogpost.setTitle(dto.getTitle());
        blogpost.setCover(dto.getCover());
        blogpost.setContent(dto.getContent());
        blogpost.setReadingTime(dto.getReadingTime());
        return blogpost;
    }
}