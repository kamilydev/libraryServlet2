<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Central Biblioteca | Login</title>
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
    <a href="#"
    ><img id="logo" src="images/logo.png" alt="Logo Biblioteca" />
    </a>
    <h1 id="header-title">Central Biblioteca</h1>
</header>
<section id="section">
    <h1 id="section-title">Faça seu Login</h1>
    <form id="form" action="">
        <label class="label" for="email">E-mail</label>
        <input class="input" id="email" type="email" name="email" required />
        <label class="label" for="password">Senha</label>
        <input class="input" id="password" type="password" name="password" required />
        <button id="button-login" type="submit">Fazer Login</button>
        <a id="register-link" href="newUser.jsp">Novo Usuário</a>
    </form>
</section>
<footer id="footer">
    Danilo Lassabia | Kamily Santos - Projeto Servlet ©️
</footer>
</body>
</html>
