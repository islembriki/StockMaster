package com.stock.dao;
import com.stock.model.Produit;
import java.util.List;

public interface IProduitDAO {
    // Contract: Anyone using this must provide a list of Products
    List<Produit> findAll();

    //we're gonna add crud operations
    void addProduit(Produit p);
    void deleteProduit(int id);
    Produit getProduitById(int id); // Useful for editing
    void updateProduit(Produit p);
}
