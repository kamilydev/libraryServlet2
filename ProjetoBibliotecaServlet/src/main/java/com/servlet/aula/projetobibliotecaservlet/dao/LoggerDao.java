package com.servlet.aula.projetobibliotecaservlet.dao;

import com.servlet.aula.projetobibliotecaservlet.models.Logger;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import static com.servlet.aula.projetobibliotecaservlet.util.InSessionUtil.inSession;

public class LoggerDao {
     Configuration cfg = new Configuration().configure("/hibernate.cfg.xml");
     SessionFactory factory = cfg.buildSessionFactory();

    private EntityManager em;
    List<Logger> loggers;
    Logger logger;

    public LoggerDao() {}

    public LoggerDao(EntityManager em) {
        this.em = em;
    }

    public void cadastrar(Logger logger) {
        inSession(factory, entityManager -> {
            entityManager.persist(logger);
        });
    }

    public void atualizar(String email) {
        inSession(factory, entityManager -> {
            logger = entityManager.find(Logger.class, email);
            if (logger != null) {
                entityManager.merge(logger);
            }
        });
    }

    public void remover(String email) {
        inSession(factory, entityManager -> {
            logger = entityManager.find(Logger.class, email);
            if (logger != null) {
                entityManager.remove(logger);
            }
        });
    }

    public List<Logger> listarUsers() {
        inSession(factory, entityManager -> {
            loggers = entityManager.createQuery("select u from Logger u", Logger.class).getResultList();
        });
        return loggers;
    }

    public Logger findByEmail(String email) {
        try {
            return em.createQuery("SELECT l FROM Logger l WHERE l.email = :email", Logger.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; // Nenhum resultado encontrado, usuário não existe
        }
    }
}
