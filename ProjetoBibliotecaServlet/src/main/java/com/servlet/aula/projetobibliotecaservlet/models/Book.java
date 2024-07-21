package com.servlet.aula.projetobibliotecaservlet.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Book")
public class Book {
    @Id
    private String isbn;
    private String titulo;
    private String categoria;
    private int quantidade;


    public Book(String isbn, String titulo, String categoria, int quantidade) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.categoria = categoria;
        this.quantidade = quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(isbn);
    }
}



