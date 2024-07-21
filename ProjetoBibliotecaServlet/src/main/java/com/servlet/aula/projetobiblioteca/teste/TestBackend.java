package com.servlet.aula.projetobiblioteca.teste;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestBackend {
    public static void main(String[] args) {
        try {
            // Testar registro de novo usuário
            String newUserJson = "nome=Teste&email=teste@example.com&password=123456";
            sendPostRequest("http://localhost:8080/newuser", newUserJson);

            // Testar login
            String loginJson = "email=teste@example.com&password=123456";
            sendPostRequest("http://localhost:8080/login", loginJson);

            // Testar cadastro de novo livro
            String newBookJson = "isbn=123456&titulo=Java Basics&categoria=Programming&quantidade=10";
            sendPostRequest("http://localhost:8080/cadastrar", newBookJson);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sendPostRequest(String urlString, String urlParameters) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");

        try (OutputStream os = connection.getOutputStream()) {
            os.write(urlParameters.getBytes());
            os.flush();
        }

        int responseCode = connection.getResponseCode();
        System.out.println("POST Response Code :: " + responseCode);
    }
}
