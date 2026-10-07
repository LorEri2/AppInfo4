<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<a href="Exo1Servlet?name=Loris&age=21">Exercice 1</a>
<a href="test-api">ApiKeyServlet</a>
<a href="visite">Compteur</a>
<a href="admin/stats">Admin</a>
<a href="ConnexionServlet?user=admin&pass=Secret123">Connexion Réussie</a>
<a href="ConnexionServlet?user=admin&pass=Secret12">Connexion Ratée</a>
<a href="LimiteurServlet">Limiteur</a>
<a href="QueryStringSender.html">InfosGet</a>
<a href="FormDataSender.html">InfosPost</a>
<a href="PokemonSelector.html">POKEMON</a>
<a href="ResponseSelector.html">Gestion des réponses</a>
<a href="StatusHandler.html">UserID</a>
<a href="CharacterServlet">Character</a>
<a href="playlist">Playlist</a>
</body>
</html>