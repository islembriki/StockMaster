package com.stock.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/connexion")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. Récupérer les données envoyées par le formulaire
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");

        // 2. Vérification "en dur" (comme demandé dans le TP)
        if ("admin".equals(login) && "123".equals(pass)) {
            // 3. Succès : On crée une session et on stocke le nom de l'utilisateur
            HttpSession session = request.getSession();
            session.setAttribute("user", "admin");

            // 4. Redirection vers le catalogue
            response.sendRedirect("catalogue");
        } else {
            // 5. Échec : Retour au login avec un message d'erreur
            response.sendRedirect("login.jsp?error=bad_credentials");
        }
    }
}
