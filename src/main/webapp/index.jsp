<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Bienvenue | StockMaster Pro</title>
    <!-- Google Fonts for a cute/modern look -->
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">

    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: 'Poppins', sans-serif;
        }

        body {
            background: linear-gradient(135deg, #f5f7fa 0%, #c3cfe2 100%);
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
            color: #333;
        }

        .welcome-card {
            background: white;
            padding: 50px;
            border-radius: 20px;
            box-shadow: 0 15px 35px rgba(0,0,0,0.1);
            text-align: center;
            max-width: 500px;
            animation: fadeIn 1.2s ease-out;
        }

        @keyframes fadeIn {
            from { opacity: 0; transform: translateY(20px); }
            to { opacity: 1; transform: translateY(0); }
        }

        .logo-icon {
            font-size: 60px;
            margin-bottom: 20px;
        }

        h1 {
            font-weight: 600;
            color: #2d3436;
            margin-bottom: 15px;
            font-size: 28px;
        }

        p {
            color: #636e72;
            line-height: 1.6;
            margin-bottom: 30px;
        }

        .btn-start {
            display: inline-block;
            background-color: #6c5ce7;
            color: white;
            padding: 15px 40px;
            border-radius: 50px;
            text-decoration: none;
            font-weight: 600;
            transition: all 0.3s ease;
            box-shadow: 0 4px 15px rgba(108, 92, 231, 0.3);
        }

        .btn-start:hover {
            background-color: #a29bfe;
            transform: translateY(-3px);
            box-shadow: 0 6px 20px rgba(108, 92, 231, 0.4);
        }

        footer {
            margin-top: 20px;
            font-size: 12px;
            color: #b2bec3;
        }
    </style>
</head>
<body>

<div class="welcome-card">
    <div class="logo-icon">📦</div>
    <h1>StockMaster Pro</h1>
    <p>Votre solution intelligente pour une gestion de stock simplifiée, sécurisée et efficace.</p>

    <a href="login.jsp" class="btn-start">Commencer l'aventure</a>

    <footer>&copy; 2026 StockMaster Pro Team - Islem & Amani & Belkis </footer>
</div>

</body>
</html>