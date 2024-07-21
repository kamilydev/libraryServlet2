<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Central Biblioteca | Novo Livro</title>
    <link rel="stylesheet" href="styles/reset.css"/>
    <link rel="stylesheet" href="styles/style.css"/>
    <link rel="preconnect" href="https://fonts.googleapis.com"/>
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin/>
    <link
            href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap"
            rel="stylesheet"
    />
</head>
<body id="body">
<header id="header">
    <a href="home.jsp"
    ><img id="logo" src="images/logo.png" alt="Logo Biblioteca"/>
    </a>
    <h1 id="header-title">Central Biblioteca</h1>
    <a class="button" id="logout-button" href="index.jsp">Logout</a>
</header>
<section id="section">
    <a class="button" id="back-button" href="home.jsp">Voltar</a>
    <h1 id="section-title">Editar Livro</h1>
    <form id="form" action="">
        <label class="label" for="isbn">ISBN</label>
        <input class="input" id="isbn" type="text" name="isbn" required/>
        <label class="label" for="titulo">Título</label>
        <input class="input" id="titulo" type="text" name="titulo" required/>
        <label class="label" for="categoria">Categoria</label>
        <input class="input" id="categoria" type="text" name="categoria"/>
        <label class="label" for="quantidade">Quantidade</label>
        <input
                class="input"
                id="quantidade"
                type="number"
                name="quantidade"
                min="1"
                required
        />
        <button id="button-login" type="submit">Confirmar Edição</button>
    </form>
</section>
<footer id="footer">
    Danilo Lassabia | Kamily Santos - Projeto Servlet ©️
</footer>
</body>
</html>

