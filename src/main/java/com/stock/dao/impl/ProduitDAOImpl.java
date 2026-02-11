package com.stock.dao.impl;

import com.stock.dao.IProduitDAO;
import com.stock.model.Produit;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProduitDAOImpl implements IProduitDAO {
    // Connection details for XAMPP
    private String url = "jdbc:mysql://localhost:3306/stockmaster_db";
    private String user = "root";
    private String password = "";

    @Override
    //part5: database integration
    //find all products
    public List<Produit> findAll() {
        List<Produit> list = new ArrayList<>();
        try {
            // 1. Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. Connect to the DB
            Connection conn = DriverManager.getConnection(url, user, password);

            // 3. Prepare the SQL query
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM produits");

            // 4. Execute and loop through results
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Produit p = new Produit(
                        rs.getInt("id"),
                        rs.getString("nom"),
                        rs.getDouble("prix")
                );
                list.add(p);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //add a product
    @Override
    public void addProduit(Produit p) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "INSERT INTO produits (nom, prix) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getNom());
            ps.setDouble(2, p.getPrix());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    //delete a product
    @Override
    public void deleteProduit(int id) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "DELETE FROM produits WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }

    //chercher un produit specifique
    @Override
    public Produit getProduitById(int id) {
        Produit p = null;
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT * FROM produits WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                p = new Produit(rs.getInt("id"), rs.getString("nom"), rs.getDouble("prix"));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return p;
    }

    //updates a product
    @Override
    public void updateProduit(Produit p) {
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "UPDATE produits SET nom = ?, prix = ? WHERE id = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getNom());
            ps.setDouble(2, p.getPrix());
            ps.setInt(3, p.getId());
            ps.executeUpdate();
        } catch (SQLException e) { e.printStackTrace(); }
    }
}
