<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Central Biblioteca | Home</title>
    <link rel="stylesheet" href="styles/reset.css"/>
    <link rel="stylesheet" href="styles/style.css"/>
    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin/>
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet"/>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="./js/deleteBooks.js"></script>
</head>
<body id="body">
<dialog id="modal">
    <h3 id="modal-title">Deseja realmente remover este livro?</h3>
    <button class="button" id="confirm-button" onclick="confirmDelete()">Confirmar</button>
    <button class="button" id="cancel-button" onclick="document.getElementById('modal').close()">Cancelar</button>
</dialog>
<header id="header">
    <a href="#">
        <img id="logo" src="images/logo.png" alt="Logo Biblioteca"/>
    </a>
    <h1 id="header-title">Central Biblioteca</h1>
    <a class="button" id="logout-button" href="index.jsp">Logout</a>
</header>
<section id="section">
    <h1 id="section-title">Lista de Livros</h1>
    <table id="table">
        <tr class="table-row">
            <th class="table-head">ISBN</th>
            <th class="table-head">Título</th>
            <th class="table-head">Categoria</th>
            <th class="table-head">Quantidade</th>
            <th>
                <a class="button" href="newBook.jsp">Novo Livro</a>
            </th>
        </tr>
        <c:forEach var="book" items="${books}">
            <tr class="table-row">
                <td class="table-data">${book.isbn}</td>
                <td class="table-data">${book.titulo}</td>
                <td class="table-data">${book.categoria}</td>
                <td class="table-data">${book.quantidade}</td>
                <td class="table-data">
                    <a class="button" href="editBook.jsp?isbn=${book.isbn}">Editar</a>
                    <a class="button" href="#" onclick="showModal('${book.isbn}')">Remover</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</section>
<footer id="footer">
    Danilo Lassabia | Kamily Santos - Projeto Servlet ©️
</footer>
</body>
</html>
