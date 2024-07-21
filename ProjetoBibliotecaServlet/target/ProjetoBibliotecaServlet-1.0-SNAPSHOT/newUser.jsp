<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Central Biblioteca | Cadastro</title>
    <link rel="stylesheet" href="styles/reset.css" />
    <link rel="stylesheet" href="styles/style.css" />
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
            href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap"
            rel="stylesheet"
    />
</head>
<body id="body">
<header id="header">
    <a href="index.jsp"
    ><img id="logo" src="images/logo.png" alt="Logo Biblioteca" />
    </a>
    <h1 id="header-title">Central Biblioteca</h1>
</header>
<section id="section">
    <a class="button" id="back-button" href="index.jsp">Voltar</a>
    <h1 id="section-title">Faça seu Cadastro</h1>
    <form id="form" action="" onsubmit="return checkPasswords()">
        <label class="label" for="name">Nome</label>
        <input class="input" id="name" type="text" name="name" required />
        <label class="label" for="email">E-mail</label>
        <input class="input" id="email" type="email" name="email" required />
        <label class="label" for="password">Crie sua Senha</label>
        <input class="input" id="password" type="password" name="password" required />
        <label class="label" for="confirm-password">Confirme sua Senha</label>
        <input class="input" id="confirm-password" type="password" name="confirm-password" required />
        <button id="button-login" type="submit">Fazer Cadastro</button>
    </form>
</section>
<footer id="footer">
    Danilo Lassabia | Kamily Santos - Projeto Servlet ©️
</footer>
</body>
<script src="js/checkPasswords.js"></script>
</html>
