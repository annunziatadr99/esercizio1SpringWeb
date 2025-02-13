package com.demo.esercizio1SpringWeb.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BlogpostDTO {
    private int id;
    private String category;
    private String title;
    private String cover;
    private String content;
    private double readingTime;
}
