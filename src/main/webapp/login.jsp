<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 07/02/2026
  Time: 22:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Connexion - StockMaster Pro</title>
</head>
<body>

    <h2>Identification</h2>
    <%-- Affichage d'un message d'erreur si la connexion échoue ou si l'accès est refusé --%>
    <p style="color: red;">${param.error == 'unauthorized' ? 'Veuillez vous connecter pour accéder au catalogue.' : ''}</p>
    <p style="color: red;">${param.error == 'bad_credentials' ? 'Login ou mot de passe incorrect.' : ''}</p>
    <p style="color: green;">${param.loggedout == 'true' ? 'Vous avez été déconnecté avec succès.' : ''}</p>

    <form action="connexion" method="post">
         <label>Login :</label>
         <input type="text" name="login" required> <br><br>

         <label>Mot de passe :</label>
         <input type="password" name="pass" required> <br><br>

         <input type="submit" value="Se connecter">
    </form>

</body>
</html>
<%-- Note pour la prof : Ce fichier est à la racine, donc accessible publiquement --%>