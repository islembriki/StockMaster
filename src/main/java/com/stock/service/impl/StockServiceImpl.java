package com.stock.service.impl;
import com.stock.model.Produit;
import com.stock.service.IStockService;
import java.util.ArrayList;
import java.util.List;
public class StockServiceImpl implements IStockService {
    @Override
    public boolean authentifier(String login, String password) {
        // La logique métier est ici
        return "admin".equals(login) && "123".equals(password);
    }
    @Override
    public List<Produit> getCatalogue() {
        // MOCK DATA: Since Belkis isn't here, we return a hardcoded list.
        // This keeps the architecture correct without needing a database.
        //-->hethi just sna3neha li test balkis baad chtbadlha bi donnes s7a7 ama khali heth chtben baad ili amlna mock
        //@belkis
        List<Produit> fakeDatabase = new ArrayList<>();
        fakeDatabase.add(new Produit(1, "Clavier Mécanique", 45.99));
        fakeDatabase.add(new Produit(2, "Souris Gamer RGB", 29.50));
        fakeDatabase.add(new Produit(3, "Ecran 27 pouces", 199.00));
        return fakeDatabase;

    }
}

