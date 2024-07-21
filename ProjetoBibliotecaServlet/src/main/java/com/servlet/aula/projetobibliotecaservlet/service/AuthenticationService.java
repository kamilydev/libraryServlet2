package com.servlet.aula.projetobibliotecaservlet.service;

import com.servlet.aula.projetobibliotecaservlet.dao.LoggerDao;
import com.servlet.aula.projetobibliotecaservlet.models.Logger;

import java.util.List;

public class AuthenticationService {

    private LoggerDao loggerDao;

    public AuthenticationService(LoggerDao loggerDao) {
        this.loggerDao = loggerDao;
    }

    public Logger authenticate(String email, String password) {
        Logger user = loggerDao.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public Logger registerUser(Logger newLogger) {
        Logger existingUser = loggerDao.findByEmail(newLogger.getEmail());
        if (existingUser != null) {
            return null; // Usuário já existe
        }
        loggerDao.cadastrar(newLogger);
        return newLogger;
    }




}
