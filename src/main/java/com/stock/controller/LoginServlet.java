package com.stock.controller;

import com.stock.service.IStockService;
import com.stock.service.impl.StockServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet("/connexion")
public class LoginServlet extends HttpServlet {

    // On déclare l'interface du service (Abstraction)
    private IStockService service = new StockServiceImpl();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String pass = request.getParameter("pass");

        // RÈGLE D'OR RESPECTÉE : On demande au service de décider
        if (service.authentifier(login, pass)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", login);
            response.sendRedirect("catalogue");
        } else {
            response.sendRedirect("login.jsp?error=bad_credentials");
        }
    }
}