package com.stock.service.impl;
import com.stock.dao.IProduitDAO;
import com.stock.dao.impl.ProduitDAOImpl;
import com.stock.model.Produit;
import com.stock.service.IStockService;
import java.util.List;

public class StockServiceImpl implements IStockService {

    // The Service Layer has an instance of the DAO Interface
    private IProduitDAO dao = new ProduitDAOImpl();

    @Override
    public boolean authentifier(String login, String password) {
        // La logique métier est ici
        return "admin".equals(login) && "123".equals(password);
    }

    //part5: the service calls the dao
    public List<Produit> getCatalogue() {
        return dao.findAll();
    }
    public void addProduit(Produit p) { dao.addProduit(p); }
    public void deleteProduit(int id) { dao.deleteProduit(id); }
}















//package com.stock.service.impl;
//import com.stock.model.Produit;
//import com.stock.service.IStockService;
//import java.util.ArrayList;
//import java.util.List;
//public class StockServiceImpl implements IStockService {
//    @Override
//    public boolean authentifier(String login, String password) {
//        // La logique métier est ici
//        return "admin".equals(login) && "123".equals(password);
//    }
//    @Override
//    public List<Produit> getCatalogue() {
//        // MOCK DATA
//        List<Produit> fakeDatabase = new ArrayList<>();
//        fakeDatabase.add(new Produit(1, "Clavier Mécanique", 45.99));
//        fakeDatabase.add(new Produit(2, "Souris Gamer RGB", 29.50));
//        fakeDatabase.add(new Produit(3, "Ecran 27 pouces", 199.00));
//        return fakeDatabase;
//
//    }
//}
//
