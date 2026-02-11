package com.stock.model;
import java.io.Serializable;

// A Java Bean must be Serializable, have a no-arg constructor, and public getters/setters
public class Produit implements Serializable {
    private int id;
    private String nom;
    private double prix;

    // 1. Empty Constructor
    public Produit() {}

    // 2. Full Constructor (Convenient for Person 1's Mock data)
    public Produit(int id, String nom, double prix) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }

    // 3. Getters and Setters (Mandatory for JSP/JSTL)
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }

    public double getPrix() { return prix; }
    public void setPrix(double prix) { this.prix = prix; }
}
