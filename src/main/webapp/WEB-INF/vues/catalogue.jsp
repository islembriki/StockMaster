<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Catalogue | StockMaster Pro</title>
    <!-- Modern Font -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">

    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
        }

        body {
            background: #f0f2f5;
            color: #2d3436;
            padding: 40px;
        }

        .container {
            max-width: 1000px;
            margin: 0 auto;
            animation: fadeIn 0.8s ease-out;
        }

        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(10px); }
            to { opacity: 1; transform: translateY(0); }
        }

        /* Top Header Info */
        .header-card {
            background: white;
            padding: 20px 30px;
            border-radius: 15px;
            display: flex;
            justify-content: space-between;
            align-items: center;
            margin-bottom: 30px;
            box-shadow: 0 4px 12px rgba(0,0,0,0.05);
        }

        .user-info {
            display: flex;
            align-items: center;
            gap: 10px;
        }

        .user-badge {
            background: #a29bfe;
            color: white;
            padding: 5px 15px;
            border-radius: 50px;
            font-weight: 600;
            font-size: 14px;
        }

        .visit-info {
            font-size: 13px;
            color: #636e72;
        }

        /* Table Styling */
        .table-container {
            background: white;
            border-radius: 20px;
            overflow: hidden;
            box-shadow: 0 10px 30px rgba(0,0,0,0.08);
        }

        h1 {
            padding: 30px 30px 10px 30px;
            font-size: 24px;
            color: #2d3436;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th {
            background-color: #f8f9fa;
            color: #b2bec3;
            text-transform: uppercase;
            font-size: 12px;
            letter-spacing: 1px;
            padding: 20px;
            text-align: left;
        }

        td {
            padding: 20px;
            border-bottom: 1px solid #f1f2f6;
            font-size: 15px;
        }

        tr:last-child td {
            border-bottom: none;
        }

        tr:hover {
            background-color: #fdfdff;
            transition: 0.3s;
        }

        .price-tag {
            color: #6c5ce7;
            font-weight: 600;
        }

        .id-badge {
            color: #b2bec3;
            font-weight: 300;
        }

        .logout-link {
            font-size: 14px;
            color: #ff7675;
            text-decoration: none;
            margin-top: 20px;
            display: inline-block;
        }
    </style>
</head>
<body>

<div class="container">

    <!-- Top Info Bar -->
    <div class="header-card">
        <div class="user-info">
            <span>👋 Bienvenue,</span>
            <span class="user-badge">${sessionScope.user}</span>
        </div>
        <div class="visit-info">
            🕒 Dernière visite : <b>${lastVisitTime}</b>
        </div>
    </div>

    <!-- Main Product Table -->
    <div class="table-container">
        <h1>Inventaire des Produits</h1>

        <table>
            <thead>
            <tr>
                <th>ID</th>
                <th>Nom du Produit</th>
                <th>Prix Unitaire</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listeProduits}" var="p">
                <tr>
                    <td class="id-badge">#${p.id}</td>
                    <td style="font-weight: 500;">${p.nom}</td>
                    <td class="price-tag">${p.prix} €</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <a href="logout" class="logout-link">Se déconnecter</a>

</div>

</body>
</html>