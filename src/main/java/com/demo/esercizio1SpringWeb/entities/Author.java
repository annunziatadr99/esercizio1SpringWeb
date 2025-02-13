package com.demo.esercizio1SpringWeb.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Il campo risulta vuoto")
    @Size(min = 2, max = 30)
    private String name;

    @Column(nullable = false)
    @Size(min = 2, max = 30)
    private String surname;

    @Column(unique = true)
    @NotNull(message = "Il campo risulta vuoto")
    @Email
    private String email;

    @NotNull(message = "Il campo risulta vuoto")
    @Past
    private String dateOfBirth;


    private String avatar;
}
