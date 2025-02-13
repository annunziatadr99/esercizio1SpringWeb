package com.demo.esercizio1SpringWeb.services;

import com.demo.esercizio1SpringWeb.dto.AuthorDTO;
import com.demo.esercizio1SpringWeb.entities.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {
    // Metodo per convertire Author in AuthorDTO
    public AuthorDTO toDTO(Author author) {
        AuthorDTO dto = new AuthorDTO();
        dto.setId(author.getId());
        dto.setName(author.getName());
        dto.setSurname(author.getSurname());
        dto.setEmail(author.getEmail());
        dto.setDateOfBirth(author.getDateOfBirth());
        dto.setAvatar(author.getAvatar());
        return dto;
    }

    // Metodo per convertire AuthorDTO in Author
    public Author toEntity(AuthorDTO dto) {
        Author author = new Author();
        author.setId(dto.getId());
        author.setName(dto.getName());
        author.setSurname(dto.getSurname());
        author.setEmail(dto.getEmail());
        author.setDateOfBirth(dto.getDateOfBirth());
        author.setAvatar(dto.getAvatar());
        return author;
    }
}
