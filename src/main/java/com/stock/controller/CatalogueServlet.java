package com.stock.controller;
import com.stock.model.Produit;
import com.stock.service.IStockService;
import com.stock.service.impl.StockServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
//l'annotation qui indique au serveur tomcat que si qq tape /catalogue dans le context path
//c cette classe qui doit repondre
@WebServlet("/catalogue")
public class CatalogueServlet extends HttpServlet {
    //httpservlet gives it its superpower to understand the browser's requests(geet post etc)
    // Rule: Always call the Interface
    private IStockService stockService = new StockServiceImpl();
    //this is the golden rule to not directly acces the DAO layer we need to go throught the service layer first
    //the servlet doesn't know how the service works it justs knows that it has the methods that will help it do its work
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //this method will be executed the moment we load the page(its a get type request)
        //->request : its the bag that is delivered to the client with the cookies and parameters

        // --- PART 1: MVC logic ---
        List<Produit> produits = stockService.getCatalogue();//the bean is made; well technically its made in the service(dao but since we used mock) and then forwarded to service which then forwaded it to servlet
        request.setAttribute("listeProduits", produits);//then the bean is put into the scope
        //each scope needs to have keys (this will be later on forwarded to the JSP)
        // --- PART 4: Cookie logic (Lecture) ---
        Cookie[] cookies = request.getCookies();
        String lastVisitValue = "C'est votre première visite !";
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("lastVisit")) {
                    lastVisitValue = c.getValue();
                }
            }
        }
        request.setAttribute("lastVisitTime", lastVisitValue);
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH:mm:ss"));
        Cookie lastVisitCookie = new Cookie("lastVisit", now);
        lastVisitCookie.setMaxAge(24 * 60 * 60); // 24 hours
        response.addCookie(lastVisitCookie);


        request.getRequestDispatcher("/WEB-INF/vues/catalogue.jsp").forward(request, response);
        //Explication : C'est le "Forward". On dit au serveur : "J'ai fini mon travail de Contrôleur, maintenant prends la valise request (avec les produits et la date de visite) et donne-la à la JSP pour qu'elle dessine le HTML".
        //Sécurité : Puisque la JSP est dans /WEB-INF/, cette ligne est le seul moyen de voir la page. L'utilisateur ne peut pas taper le chemin directement.
    }
}