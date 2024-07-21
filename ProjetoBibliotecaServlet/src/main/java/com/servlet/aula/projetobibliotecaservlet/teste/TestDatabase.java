package com.servlet.aula.projetobibliotecaservlet.teste;

import com.servlet.aula.projetobibliotecaservlet.models.Book;
import com.servlet.aula.projetobibliotecaservlet.models.Logger;
import com.servlet.aula.projetobibliotecaservlet.util.JPAUtil;
import jakarta.persistence.EntityManager;

public class TestDatabase {
    public static void main(String[] args) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();

        // Teste simples para persistir um objeto e verificar se a tabela é criada
        Logger logger = new Logger("FGHFGH","EDFGDFG@gmail.com","12344566");
        em.persist(logger);


        // Teste simples para persistir um objeto e verificar se a tabela é criada
        Book book = new Book("4564565676756", "Test GHFGH", "Test FGHFGF", 5);
        em.persist(book);

        em.getTransaction().commit();
        em.close();


    }
}

