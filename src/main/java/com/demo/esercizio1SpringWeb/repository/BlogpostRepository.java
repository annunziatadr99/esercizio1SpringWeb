package com.demo.esercizio1SpringWeb.repository;

import com.demo.esercizio1SpringWeb.entities.Blogpost;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogpostRepository extends JpaRepository<Blogpost, Integer> {
    Page<Blogpost> findAll(Pageable pageable);
}