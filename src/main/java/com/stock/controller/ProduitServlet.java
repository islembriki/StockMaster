package com.stock.controller;

import com.stock.model.Produit;
import com.stock.service.IStockService;
import com.stock.service.impl.StockServiceImpl;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/product-action")
public class ProduitServlet extends HttpServlet {
    private IStockService service = new StockServiceImpl();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String action = request.getParameter("action");
        int id = Integer.parseInt(request.getParameter("id"));

        if ("delete".equals(action)) {
            service.deleteProduit(id);
        }
        response.sendRedirect("catalogue"); // Go back to the list
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nom = request.getParameter("nom");
        double prix = Double.parseDouble(request.getParameter("prix"));

        service.addProduit(new Produit(0, nom, prix));
        response.sendRedirect("catalogue");
    }
}