package Service;

import com.servlet.aula.projetobibliotecaservlet.dao.LoggerDao;
import com.servlet.aula.projetobibliotecaservlet.models.Logger;

import java.util.List;


public class AuthenticationService {

    private LoggerDao loggerDao;

    public AuthenticationService(LoggerDao loggerDao) {
        this.loggerDao = loggerDao;
    }

    public Logger authenticate(String email, String password) {
        List<Logger> users = loggerDao.listarUsers();
        for (Logger logger : users) {
            if (logger.getEmail().equals(email) && logger.getPassword().equals(password)) {
                return logger;
            }
        }
        return null;
    }

    public registerUser(Logger newLogger) {
        List<Logger> users = loggerDao.listarUsers();
        for (Logger logger : users) {
            if (logger.getEmail().equals(newLogger.getEmail())) {
                return null;

            } else {

            }
            }
        }
    }


}

