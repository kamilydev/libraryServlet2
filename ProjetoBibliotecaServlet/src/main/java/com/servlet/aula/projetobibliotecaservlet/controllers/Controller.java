package com.servlet.aula.projetobibliotecaservlet.controllers;

import com.servlet.aula.projetobibliotecaservlet.dao.BookDao;
import com.servlet.aula.projetobibliotecaservlet.dao.LoggerDao;
import com.servlet.aula.projetobibliotecaservlet.models.Book;
import com.servlet.aula.projetobibliotecaservlet.models.Logger;
import com.servlet.aula.projetobibliotecaservlet.util.JPAUtil;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.persistence.EntityManager;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/login", "/newuser", "/home", "/cadastrar", "/atualizar", "/excluir"})
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BookDao bookDao;
    private LoggerDao loggerDao;

    public Controller() {
        super();
        EntityManager em = JPAUtil.getEntityManager();
        this.bookDao = new BookDao(em);
        this.loggerDao = new LoggerDao(em);
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getMethod();
        String path = request.getServletPath();

        switch (method) {
            case "GET":
                doGet(request, response);
                break;
            case "POST":
                doPost(request, response);
                break;
            case "PUT":
                if (path.equals("/atualizar")) {
                    doPut(request, response);
                }
                break;
            case "DELETE":
                if (path.equals("/excluir")) {
                    doDelete(request, response);
                }
                break;
            default:
                response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
                break;
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();

        switch (path) {
            case "/home":
                System.out.println("teste 1");
                List<Book> livros = bookDao.listarLivros();
                request.setAttribute("listaLivros", livros);
                request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
            case "/cadastrar":
                System.out.println("teste 2");

                RequestDispatcher rd = request.getRequestDispatcher("biblioteca.jsp"); //
                rd.forward(request, response);
                break;
            case "/login":
                System.out.println("teste 3");

                request.getRequestDispatcher("login.jsp").forward(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getServletPath();

        switch (path) {
            case "/newuser":
                String nome = request.getParameter("nome");
                String email = request.getParameter("email");
                String password = request.getParameter("password");
                Logger logger = new Logger(nome, email, password);
                loggerDao.cadastrar(logger);
                response.sendRedirect("login.jsp");
                System.out.println("teste 4");

                break;
            case "/cadastrar":
                String isbn = request.getParameter("isbn");
                String titulo = request.getParameter("titulo");
                String categoria = request.getParameter("categoria");
                int quantidade = Integer.parseInt(request.getParameter("quantidade"));
                Book book = new Book(isbn, titulo, categoria, quantidade);
                bookDao.cadastrar(book.getIsbn());
                response.sendRedirect("home");
                System.out.println("teste 5");

                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
                System.out.println("teste 66666");

                break;
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isbn = request.getParameter("isbn");
        String titulo = request.getParameter("titulo");
        String categoria = request.getParameter("categoria");
        String quantidade = request.getParameter("quantidade");

        Book book = bookDao.listarLivros().stream()
                .filter(livro -> livro.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
        System.out.println("teste 6");

        if (book != null) {
            if (!isbn.isEmpty()) {
                book.setIsbn(isbn);
            }
            if (titulo != null && !titulo.isEmpty()) {
                book.setTitulo(titulo);
            }
            if (categoria != null && !categoria.isEmpty()) {
                book.setCategoria(categoria);
            }
            if (quantidade != null && !quantidade.isEmpty()) {
                book.setQuantidade(Integer.parseInt(quantidade));
            }
            bookDao.atualizar(isbn);
        }

        response.sendRedirect("home");
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String isbn = request.getParameter("isbn");
        bookDao.remover(isbn);
        response.sendRedirect("home");
        System.out.println("teste 7");

    }
}