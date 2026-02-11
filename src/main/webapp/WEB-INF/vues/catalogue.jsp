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

        /* Delete Button Styles */
        .delete-btn {
            background: #ff7675;
            color: white;
            border: none;
            padding: 8px 16px;
            border-radius: 8px;
            cursor: pointer;
            font-size: 13px;
            font-weight: 500;
            transition: all 0.3s;
        }

        .delete-btn:hover {
            background: #d63031;
            transform: scale(1.05);
        }

        /* Add Product Form Styles */
        .add-product-form {
            background: white;
            padding: 30px;
            border-radius: 20px;
            margin-bottom: 30px;
            box-shadow: 0 10px 30px rgba(0,0,0,0.08);
        }

        .add-product-form h2 {
            font-size: 20px;
            margin-bottom: 20px;
            color: #2d3436;
        }

        .form-row {
            display: flex;
            gap: 15px;
            align-items: flex-end;
        }

        .form-group {
            flex: 1;
        }

        .form-group label {
            display: block;
            margin-bottom: 8px;
            font-size: 13px;
            color: #636e72;
            font-weight: 500;
        }

        .form-group input {
            width: 100%;
            padding: 12px 15px;
            border: 2px solid #e9ecef;
            border-radius: 10px;
            font-size: 14px;
            transition: all 0.3s;
        }

        .form-group input:focus {
            outline: none;
            border-color: #6c5ce7;
            box-shadow: 0 0 0 3px rgba(108, 92, 231, 0.1);
        }

        .submit-btn {
            background: #6c5ce7;
            color: white;
            border: none;
            padding: 12px 30px;
            border-radius: 10px;
            cursor: pointer;
            font-size: 14px;
            font-weight: 600;
            transition: all 0.3s;
        }

        .submit-btn:hover {
            background: #5f3dc4;
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(108, 92, 231, 0.3);
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

    <!-- Add Product Form -->
    <div class="add-product-form">
        <h2>➕ Ajouter un Nouveau Produit</h2>
        <form action="product-action" method="post">
            <div class="form-row">
                <div class="form-group">
                    <label for="nom">Nom du Produit</label>
                    <input type="text" id="nom" name="nom" placeholder="Ex: Laptop HP" required>
                </div>
                <div class="form-group">
                    <label for="prix">Prix (TND)</label>
                    <input type="number" id="prix" name="prix" step="0.01" placeholder="Ex: 1500.00" required>
                </div>
                <button type="submit" class="submit-btn">Ajouter</button>
            </div>
        </form>
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
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listeProduits}" var="p">
                <tr>
                    <td class="id-badge">#${p.id}</td>
                    <td style="font-weight: 500;">${p.nom}</td>
                    <td class="price-tag">${p.prix} TND</td>
                    <td>
                        <form action="product-action" method="get" style="display: inline;">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="id" value="${p.id}">
                            <button type="submit" class="delete-btn" onclick="return confirm('Êtes-vous sûr de vouloir supprimer ce produit ?')">Supprimer</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

    <a href="logout" class="logout-link">Se déconnecter</a>

</div>

</body>
</html>