package com.stock.service;

import com.stock.model.Produit;
import java.util.List;

public interface IStockService {

    /**
     * Authenticates a user based on login and password.
     * (Part 2: Logic used by LoginServlet)
     */
    boolean authentifier(String login, String password);

    /**
     * Retrieves the list of products for the catalog.
     * (Part 1: Mock data / Part 5: Real database data)
     */
    List<Produit> getCatalogue();

    //crud operations
    public void addProduit(Produit p);
    public void deleteProduit(int id);

}