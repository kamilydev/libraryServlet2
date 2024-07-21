package com.servlet.aula.projetobibliotecaservlet.dao;

import com.servlet.aula.projetobibliotecaservlet.models.Book;
import jakarta.persistence.EntityManager;
import lombok.Getter;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

import static com.servlet.aula.projetobibliotecaservlet.util.InSessionUtil.inSession;

public class BookDao {
     Configuration cfg = new Configuration().configure("/hibernate.cfg.xml");
     SessionFactory factory = cfg.buildSessionFactory();
    private EntityManager em;

    public BookDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Book book){
        inSession(factory, entityManager -> {
            entityManager.persist(book);
        });
    }

    public void atualizar(Book book){
        inSession(factory, entityManager -> {
            entityManager.merge(book);
        });
    }

    public void remover(String isbn){
        inSession(factory, entityManager -> {
            Book book = entityManager.find(Book.class, isbn);
            if (book != null) {
                entityManager.remove(book);
            }
        });
    }

    public List<Book> listarLivros() {
        return inSession(factory, entityManager -> {
            return entityManager.createQuery("select b from Book b", Book.class).getResultList();
        });
    }
}
