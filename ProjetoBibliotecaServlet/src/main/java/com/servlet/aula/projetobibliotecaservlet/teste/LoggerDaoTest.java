package com.servlet.aula.projetobibliotecaservlet.teste;

import com.servlet.aula.projetobibliotecaservlet.dao.LoggerDao;
import com.servlet.aula.projetobibliotecaservlet.models.Logger;
import com.servlet.aula.projetobibliotecaservlet.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import static org.junit.jupiter.api.Assertions.*;

public class LoggerDaoTest {

    private static EntityManager em;
    private LoggerDao loggerDao;

    @BeforeAll
    public static void setUpClass() {
        em = JPAUtil.getEntityManager();
    }

    @BeforeEach
    public void setUp() {
        EntityTransaction transaction = em.getTransaction();
        if (!transaction.isActive()) {
            transaction.begin();
        }
        loggerDao = new LoggerDao(em);
    }

    @AfterEach
    public void tearDown() {
        EntityTransaction transaction = em.getTransaction();
        if (transaction.isActive()) {
            transaction.commit();
        }
    }

    @AfterAll
    public static void tearDownClass() {
        if (em != null) {
            em.close();
        }
    }

    @Test
    public void testFindByEmail() {
        Logger logger = new Logger("Test User", "test@example.com", "password");
        loggerDao.cadastrar(logger);

        Logger foundLogger = loggerDao.findByEmail("test@example.com");
        assertNotNull(foundLogger);
        assertEquals("Test User", foundLogger.getNome());
    }
}
