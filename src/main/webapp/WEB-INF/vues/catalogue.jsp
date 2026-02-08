<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>StockMaster Pro - Catalogue</title>
    <style>
        body { font-family: Arial; margin: 40px; }
        table { width: 100%; border-collapse: collapse; margin-top: 20px; }
        th, td { border: 1px solid #ddd; padding: 12px; text-align: left; }
        th { background-color: #f2f2f2; }
        .user-info { color: blue; font-weight: bold; }
    </style>
</head>
<body>

<h1>Gestion de Stock</h1>

<!-- Part 2 requirement (Amani will handle the "user" session) -->
<p>Utilisateur connecté : <span class="user-info">${sessionScope.user}</span></p>

<!-- Part 4 display -->
<p>Votre précédente visite : <b>${lastVisitTime}</b></p>

<table>
    <thead>
    <tr>
        <th>ID</th>
        <th>Nom du Produit</th>
        <th>Prix Unitaire</th>
    </tr>
    </thead>
    <tbody>
    <!-- Part 1: JSTL loop -->
    <c:forEach items="${listeProduits}" var="p">
        <tr>
            <td>${p.id}</td>
            <td>${p.nom}</td>
            <td>${p.prix} €</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>