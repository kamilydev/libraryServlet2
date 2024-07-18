package com.servlet.aula.projetobibliotecaservlet.dao;
import com.servlet.aula.projetobibliotecaservlet.models.Book;
import jakarta.persistence.EntityManager;

import java.util.List;

import static com.servlet.aula.projetobibliotecaservlet.util.InSessionUtil.getFactory;
import static com.servlet.aula.projetobibliotecaservlet.util.InSessionUtil.inSession;

public class BookDao {
    private EntityManager em;
    List<Book> livros;
    Book livro;
    public BookDao(EntityManager em) {
        this.em = em;
    }

    public BookDao() {

    }

    public void cadastrar(String isbn){
        inSession(getFactory(), entityManager -> {
            livro = entityManager.find(Book.class, isbn);
            this.em.persist(livro);
        });
    }



    public void atualizar(String isbn){
        inSession(getFactory(), entityManager -> {
            livro = entityManager.find(Book.class, isbn);
            this.em.merge(livro);
        });
    }

    public void remover(String isbn){
        inSession(getFactory(), entityManager -> {
            livro = entityManager.find(Book.class, isbn);
            this.em.remove(livro);
        });
    }

    public List<Book> listarLivros() {
        inSession(getFactory(), entityManager -> {
            livros = em.createQuery("select b from Book b", Book.class).getResultList();
        });
        return livros;
    }
}
