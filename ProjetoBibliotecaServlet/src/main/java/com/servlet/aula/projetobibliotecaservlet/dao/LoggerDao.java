package com.servlet.aula.projetobibliotecaservlet.dao;
import com.servlet.aula.projetobibliotecaservlet.models.Book;
import com.servlet.aula.projetobibliotecaservlet.models.Logger;
import jakarta.persistence.EntityManager;


import java.util.List;

import static com.servlet.aula.projetobibliotecaservlet.util.InSessionUtil.getFactory;
import static com.servlet.aula.projetobibliotecaservlet.util.InSessionUtil.inSession;

public class LoggerDao {

    private EntityManager em;
    List<Logger> loggers;
    Logger logger;
    public LoggerDao() {

    }

    public LoggerDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Logger logger){
        inSession(getFactory(), entityManager -> {
            this.em.persist(logger);
        });
    }

    public void atualizar(String email){
        inSession(getFactory(), entityManager -> {
            logger = entityManager.find(Logger.class, email);
            this.em.merge(logger);
        });
    }

    public void remover(String email){
        inSession(getFactory(), entityManager -> {
            logger = entityManager.find(Logger.class, email);
            this.em.remove(logger);
        });
    }

    public List<Logger> listarUsers() {
        inSession(getFactory(), entityManager -> {
            loggers = em.createQuery("select u from Logger u", Logger.class).getResultList();
        });
        return loggers;
    }
}
