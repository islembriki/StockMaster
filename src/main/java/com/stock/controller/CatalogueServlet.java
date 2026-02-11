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
        //we ask the browser to give us the cookies he has stored for this website and we put it into a variable
        String lastVisitValue = "C'est votre première visite !";

        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("lastVisit")) {//there is a field in cookies called lastvisit(in the browser)
                    lastVisitValue = c.getValue();
                }
            }
        }
        // Send the value of the OLD cookie to the JSP
        //since we need to display the date to the client we need to forward the value to vue (no need for a model its one value unlike product
        request.setAttribute("lastVisitTime", lastVisitValue);//put into the scope too and we can tell the differnece by its key name (di than liste produits

        // --- PART 4: Cookie logic (Ecriture) --- -->how is the cookie updated
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH:mm:ss"));
        Cookie lastVisitCookie = new Cookie("lastVisit", now);//cookie is also a bean but we dont write its model code cuz we imported it
        lastVisitCookie.setMaxAge(24 * 60 * 60); // 24 hours
        response.addCookie(lastVisitCookie);
        //we are basically preparing for the future after getting the old cookies now we need to updatewith our own cookie bean and the age we want it to be and we send it as a response , it will be stored and next time we open the browser and retrive the old cookiees its our owen new(old now) cookie we made with the dates saved unless it surpassed 24 h
        // Forward to the protected JSP
        request.getRequestDispatcher("/WEB-INF/vues/catalogue.jsp").forward(request, response);
        //Explication : C'est le "Forward". On dit au serveur : "J'ai fini mon travail de Contrôleur, maintenant prends la valise request (avec les produits et la date de visite) et donne-la à la JSP pour qu'elle dessine le HTML".
        //Sécurité : Puisque la JSP est dans /WEB-INF/, cette ligne est le seul moyen de voir la page. L'utilisateur ne peut pas taper le chemin directement.
    }
}