package com.servlet.aula.projetobibliotecaservlet.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.function.Consumer;

public class InSessionUtil {
    static Configuration cfg = new Configuration().configure("/hibernate.cfg.xml");
    static SessionFactory factory = cfg.buildSessionFactory();
    public static void inSession(EntityManagerFactory factory, Consumer<EntityManager> work) {
        var entityManager = factory.createEntityManager();
        var transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            work.accept(entityManager);
            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) transaction.rollback();
            throw e;
        } finally {
            entityManager.close();
        }
    }
    public static SessionFactory getFactory() {
        return factory;
    }
}
