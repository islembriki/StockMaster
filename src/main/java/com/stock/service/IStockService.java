package com.stock.service;

import com.stock.model.Produit;
import java.util.List;

public interface IStockService {
    // Logic: Returns the catalog (Person 1 will call this)
    List<Produit> getCatalogue();
}
