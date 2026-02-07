package com.stock.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/catalogue") // Ce filtre surveille uniquement l'URL /catalogue
public class AuthentificationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        // On transforme les objets request/response en version "HTTP" pour accéder aux sessions
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        HttpSession session = req.getSession(false); // false = ne pas créer de session si elle n'existe pas

        // Vérification : est-ce que l'attribut "user" existe en session ?
        if (session != null && session.getAttribute("user") != null) {
            // OUI : Tout est bon, on laisse passer la requête vers la Servlet
            chain.doFilter(request, response);
        } else {
            // NON : Accès interdit, redirection vers login.jsp
            res.sendRedirect(req.getContextPath() + "/login.jsp?error=unauthorized");
        }
    }
}
