<%--
  Created by IntelliJ IDEA.
  User: Utilisateur
  Date: 05-10-26
  Time: 10:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
  <title>Champion de LOL</title>
</head>
<body>
<p>Nom: <c:out value="${character.name}"/></p>
<p>Role: <c:out value="${character.role}"/></p>

<p>Compétences: </p>
<ul>
  <c:forEach var="skill" items="${character.skills}">
    <li>
      <c:out value="${skill}"/>
    </li>
  </c:forEach>
</ul>
</body>
</html>