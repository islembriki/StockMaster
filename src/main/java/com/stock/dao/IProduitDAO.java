package com.stock.dao;
import com.stock.model.Produit;
import java.util.List;

public interface IProduitDAO {
    // Contract: Anyone using this must provide a list of Products
    List<Produit> findAll();
}
