package com.stock.controller;

import com.stock.model.Produit;
import com.stock.service.IStockService;
import com.stock.service.impl.StockServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet("/catalogue")
public class CatalogueServlet extends HttpServlet {

    // Rule: Always call the Interface
    private IStockService stockService = new StockServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // --- PART 1: MVC logic ---
        List<Produit> produits = stockService.getCatalogue();
        request.setAttribute("listeProduits", produits);

        // --- PART 4: Cookie logic (Lecture) ---
        Cookie[] cookies = request.getCookies();
        String lastVisitValue = "C'est votre première visite !";

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("lastVisit")) {
                    lastVisitValue = c.getValue();
                }
            }
        }
        // Send the value of the OLD cookie to the JSP
        request.setAttribute("lastVisitTime", lastVisitValue);

        // --- PART 4: Cookie logic (Ecriture) ---
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH:mm:ss"));
        Cookie lastVisitCookie = new Cookie("lastVisit", now);
        lastVisitCookie.setMaxAge(24 * 60 * 60); // 24 hours
        response.addCookie(lastVisitCookie);

        // Forward to the protected JSP
        request.getRequestDispatcher("/WEB-INF/vues/catalogue.jsp").forward(request, response);
    }
}