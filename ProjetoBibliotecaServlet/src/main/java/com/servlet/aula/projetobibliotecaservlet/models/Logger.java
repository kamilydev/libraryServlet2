package com.servlet.aula.projetobibliotecaservlet.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Logger")
public class Logger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String password;

    public Logger(String nome, String email, String password) {
        this.nome = nome;
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // Verifica se é o mesmo objeto
        if (o == null || getClass() != o.getClass()) return false; // Verifica se é do mesmo tipo
        Logger logger = (Logger) o; // Faz o cast para Logger
        return Objects.equals(email, logger.email) && Objects.equals(password, logger.password); // Compara os campos relevantes
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, password); // Garante que hashCode é consistente com equals
    }
}
