<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <title>Connexion | StockMaster Pro</title>
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;600&display=swap" rel="stylesheet">

    <style>
        * { margin: 0; padding: 0; box-sizing: border-box; font-family: 'Poppins', sans-serif; }
        body { background: #f0f2f5; height: 100vh; display: flex; align-items: center; justify-content: center; color: #2d3436; }
        .login-card { background: white; padding: 40px; border-radius: 20px; box-shadow: 0 10px 30px rgba(0,0,0,0.08); width: 100%; max-width: 400px; animation: fadeIn 0.8s ease-out; }
        @keyframes fadeIn { from { opacity: 0; transform: translateY(20px); } to { opacity: 1; transform: translateY(0); } }
        h2 { font-weight: 600; margin-bottom: 10px; color: #2d3436; text-align: center; }
        .subtitle { text-align: center; font-size: 14px; color: #636e72; margin-bottom: 30px; }

        /* Styles des messages */
        .message { padding: 12px; border-radius: 10px; font-size: 13px; margin-bottom: 20px; text-align: center; display: block; }
        .error { background: #fff5f5; color: #ff7675; border: 1px solid #ff7675; }
        .success { background: #f0fff4; color: #55efc4; border: 1px solid #55efc4; }

        .form-group { margin-bottom: 20px; }
        label { display: block; font-size: 13px; font-weight: 600; margin-bottom: 8px; color: #b2bec3; text-transform: uppercase; }
        input[type="text"], input[type="password"] { width: 100%; padding: 12px 15px; border: 1px solid #f1f2f6; border-radius: 10px; background: #f8f9fa; font-size: 14px; }
        input:focus { outline: none; border-color: #a29bfe; background: white; box-shadow: 0 0 0 4px rgba(162, 155, 254, 0.1); }
        input[type="submit"] { width: 100%; padding: 12px; background: #6c5ce7; color: white; border: none; border-radius: 10px; font-weight: 600; cursor: pointer; transition: 0.3s; margin-top: 10px; }
        input[type="submit"]:hover { background: #a29bfe; transform: translateY(-2px); }
        .footer-note { text-align: center; font-size: 11px; color: #b2bec3; margin-top: 30px; }
    </style>
</head>
<body>

<div class="login-card">
    <h2>Identification</h2>
    <p class="subtitle">Gestionnaire StockMaster Pro</p>

    <%-- Condition JSTL : Le message ne s'affiche QUE si le paramètre correspond --%>

    <c:if test="${param.error == 'unauthorized'}">
        <div class="message error">Veuillez vous connecter pour accéder au catalogue.</div>
    </c:if>

    <c:if test="${param.error == 'bad_credentials'}">
        <div class="message error">Login ou mot de passe incorrect.</div>
    </c:if>

    <c:if test="${param.loggedout == 'true'}">
        <div class="message success">Déconnexion réussie.</div>
    </c:if>

    <form action="connexion" method="post">
        <div class="form-group">
            <label>Utilisateur</label>
            <input type="text" name="login" placeholder="Ex: admin" required>
        </div>

        <div class="form-group">
            <label>Mot de passe</label>
            <input type="password" name="pass" placeholder="••••••••" required>
        </div>

        <input type="submit" value="Se connecter">
    </form>

    <div class="footer-note">Accès restreint aux administrateurs StockMaster.</div>
</div>

</body>
</html>