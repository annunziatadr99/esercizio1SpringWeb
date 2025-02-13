package com.demo.esercizio1SpringWeb.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table
public class Blogpost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Il campo risulta vuoto")
    @Size(min = 2, max = 30)private String category;

    @NotNull(message = "Il campo risulta vuoto")
    @Size(min = 5, max = 100)
    private String title;


    private String cover;

    @NotNull(message = "Il campo risulta vuoto")
    @Size(min = 10)
    private String content;

    private double readingTime;
}
