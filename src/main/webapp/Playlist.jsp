<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%-- Si vous utilisez Java EE 8 / Tomcat 9, utilisez : uri="http://java.sun.com/jsp/jstl/core" --%>

<!DOCTYPE html>
<html lang="fr">
<head>
  <meta charset="UTF-8">
  <title><c:out value="${playlist.name}" /></title>
</head>
<body>

<h1><c:out value="${playlist.name}" /></h1>
<p>Créée par : <strong><c:out value="${playlist.owner}" /></strong></p>

<c:choose>
  <c:when test="${empty playlist.songs}">
    <p>Cette playlist est vide</p>
  </c:when>
  <c:otherwise>
    <ol>
      <c:forEach var="song" items="${playlist.songs}">
        <li>
          <c:if test="${song.favorite}">★ </c:if>
          <a href="<c:out value='${song.url}' />" target="_blank" rel="noopener noreferrer">
            <c:out value="${song.title}" />
          </a>
          - <c:out value="${song.artist}" />
        </li>
      </c:forEach>
    </ol>
  </c:otherwise>
</c:choose>

</body>
</html>