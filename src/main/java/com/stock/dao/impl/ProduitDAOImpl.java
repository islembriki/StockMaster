package com.stock.dao.impl;

import com.stock.dao.IProduitDAO;
import com.stock.model.Produit;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAOImpl implements IProduitDAO {
    //this is the fake mock data not the real database !
    @Override
    public List<Produit> findAll() {
        // On simule ici ce que ferait la BDD
        List<Produit> mockList = new ArrayList<>();

        // C'est ici que les Beans sont instanciés (ils "naissent" dans la DAO)
        mockList.add(new Produit(1, "Clavier Mécanique RGB", 45.99));
        mockList.add(new Produit(2, "Souris Gamer", 29.50));
        mockList.add(new Produit(3, "Ecran Professional 27\"", 199.00));

        System.out.println("DAO: Simulation de récupération des données terminée.");
        return mockList;
    }
}

//Pour l'instant, c'est une DAO de simulation (Mocking), mais l'architecture est déjà en place. Le Service communique avec la DAO par son interface, respectant ainsi le découplage total.