package com.stock.service.impl;
import com.stock.dao.IProduitDAO;
import com.stock.dao.impl.ProduitDAOImpl; // On importe l'implémentation
import com.stock.model.Produit;
import com.stock.service.IStockService;
import java.util.List;

public class StockServiceImpl implements IStockService {

    // On crée le lien avec la DAO via son Interface
    private IProduitDAO dao = new ProduitDAOImpl();

    @Override
    public boolean authentifier(String login, String password) {
        return "admin".equals(login) && "123".equals(password);
    }

    @Override
    public List<Produit> getCatalogue() {
        // Le Service ne "fabrique" plus la liste.
        // Il demande à la DAO et renvoie le résultat.
        return dao.findAll();
    }
}
